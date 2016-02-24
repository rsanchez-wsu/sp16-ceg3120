package edu.wright.cs.sp16.ceg3120;

/**
 * This class will be designed to handle SQL queries passed to it and to provide a result set gained 
 * from the query.
 */

import java.sql.Statement;
import java.util.Scanner;

public class SqlStatement {
	
	//default constructor
	public SqlStatement()
	{
		Statement stat = null;
		String query = null;
	}
	//constructor built to take a SQL input
	public SqlStatement(String enteredQuery)
	{
		Statement stat = null;
		String query = enteredQuery;
	}
	
	
}
