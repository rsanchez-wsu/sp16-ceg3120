//Associate this file with the overall package
package edu.wright.cs.sp16.ceg3120;
//Import necessary connection libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;

public class dbConnect{
	public static void main(String[] args){
		//Create needed variables
		String db_address = "";
		String db_username = "";
		String db_password = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//Prompt user for input
		try {
			System.out.println("Welcome to the database connector!");
			System.out.print("Please enter the address of the database you wish to connect to: ");
			db_address = input.readLine();
			System.out.print("\nPlease enter the username you wish to use: ");
			db_username = input.readLine();
			System.out.print("\nPlease enter the password for your username: ");
			db_password = input.readLine();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


