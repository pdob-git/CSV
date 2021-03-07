/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdob.csv.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Paweł Dobrowolski
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person implements Serializable {
	
//    public static final long serialVersionUID = 2L;
    
        
    private int ID; // ("Liczba pożądkowa");
    
    //FirstName field
    private String FirstName; // ("Imię:");
    
    //LastName field
    
    private String LastName; // ("Nazwisko:");

    //EMail field
    private String EMail; // ("EMail:");
    
}




