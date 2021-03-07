/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdob.csv.file;


import pdob.csv.model.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdob.csv.model.Person;

/**
 *
 * @author Paweł Dobrowolski
 */
public class PersonCSV {

    public PersonCSV() {
    }


    public void writeCSV(ArrayList<Person> personarray, String filename, String separator) {
       
        try (FileWriter csvWriter = new FileWriter(filename)) {
            csvWriter.append("ID");
            csvWriter.append(separator);
            csvWriter.append("FirstName");
            csvWriter.append(separator);
            csvWriter.append("LastName");
            csvWriter.append(separator);
            csvWriter.append("E-Mail");
            csvWriter.append("\n");
            for (Person person: personarray) {
                csvWriter.append(String.valueOf(person.getID()));
                csvWriter.append(separator);
                csvWriter.append(person.getFirstName());
                csvWriter.append(separator);
                csvWriter.append(person.getLastName());
                csvWriter.append(separator);
                csvWriter.append(person.getEMail());              
                csvWriter.append("\n");
            }   
            csvWriter.flush();
            
            System.out.println("File  " + filename + " have been saved");
            
        } catch (IOException ex) {
            Logger.getLogger(PersonCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<Person> readCSV(String filename, String separator) {
        
        ArrayList<Person> personarray = new ArrayList<>();
        
        try (BufferedReader csvReader = new BufferedReader(new FileReader(filename))) {
            String row;
            int iterator = 0;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(separator);
                if (iterator != 0){
                    Person person = new Person(   
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3]
                    );
                    personarray.add(person);    
                }
                
                iterator++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personarray;
    }
}

