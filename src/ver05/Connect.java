package ver05;

public interface Connect {
	
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	void connect(String user, String pass);
	
	void makeAccount();
	void depositMoney();
	void withdrawMoney();
	void showAccInfo();
	void close();
}
