package edu.wright.cs.sp16.ceg3120;

public class Querybuilder {

	private DatabaseConnector connector;
	
	public Querybuilder(DatabaseConnector connector) {
		this.setConnector(connector);
	}

	public DatabaseConnector getConnector() {
		return connector;
	}

	public void setConnector(DatabaseConnector connector) {
		this.connector = connector;
	}
}
