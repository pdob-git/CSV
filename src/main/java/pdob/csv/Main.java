/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdob.csv;


import java.util.ArrayList;
import java.util.Arrays;
import pdob.csv.file.PersonCSV;
import pdob.csv.model.Person;

/**
 *
 * @author Paweł Dobrowolski
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filename = "testcsv.csv";
        
        System.out.println("---------------------------------------------------");
        System.out.println("Demo of writing and reading to CSV file");
        System.out.println("---------------------------------------------------");
        
        Person person1 = new Person( 1, "Joanna", "Zakościelna", "j.zakoscielna@gmail.com");
        Person person2 = new Person( 2, "Paweł", "Pawłowski", "p.pawloski@poczta.onet.pl");
        Person person3 = new Person( 3, "Marek", "Markowski", "m.markowski@o2.pl");
        
        ArrayList<Person> personarray = new ArrayList<>(Arrays.asList(person1, person2, person3));
        
        System.out.println("Data to Save");
        //Show Person Array
        showPersonArray(personarray);
        System.out.println("Saving CSV file....");
        PersonCSV CSV = new PersonCSV();
        //Here is save operation
        CSV.writeCSV(personarray, filename);
        
        System.out.println("Reading CSV file....");
        
        //Here is read operation
        ArrayList<Person> readCSV = CSV.readCSV(filename);
        System.out.println("Data Read from CSV file");
        
        //Show Person Array
        showPersonArray(readCSV);
    }    

    private static void showPersonArray(ArrayList<Person> personarray) {
        for (Person person:personarray){
            System.out.println(person);
        }
    }
}
