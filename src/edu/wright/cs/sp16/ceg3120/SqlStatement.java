package edu.wright.cs.sp16.ceg3120;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * This class will be designed to handle SQL queries passed to it and to provide a result set gained 
 * from the query.
 */

import java.sql.Statement;
import java.util.Scanner;
/*
 * This class will take SQL statements and produce appropriate result sets or throw an
 * exception
 */
public class SqlStatement {
	
	Connection conn;
	Statement stat = null;
	String query;
	
	//constructor built to take a SQL input
	public SqlStatement(Connection conn, String enteredQuery)
	{
		this.conn = conn;
		this.query = enteredQuery;
	}
	
	/*
	 * This class will determine if an statement is executable.
	 */
	public void executeStat()
	{
		String success = "Statement executed.";
		String failed = "Statement failed to execute";
		
		try
		{
			stat = conn.createStatement();
			ResultSet rs = conn.;
			return rs;
		};
		
	}
	
	
}
