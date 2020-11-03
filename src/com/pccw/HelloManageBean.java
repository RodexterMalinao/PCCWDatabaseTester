package com.pccw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="helloManageBean")
public class HelloManageBean {
	private String value = "hello world";

	public String getValue() {
		Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;
 
        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");
 
            // METHOD #1
            String dbURL2 = "jdbc:oracle:thin:@10.87.122.65:1526:imssit";
            String username = "ops$bom";
            String password = "bom";
            conn2 = DriverManager.getConnection(dbURL2, username, password);
            if (conn2 != null) {
                System.out.println("Connected with connection #2");
                return "Connected with connection jdbc:oracle:thin:@10.87.122.65:1526:imssit";
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Connection failed to jdbc:oracle:thin:@10.87.122.65:1526:imssit";
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
                if (conn2 != null && !conn2.isClosed()) {
                    conn2.close();
                }
                if (conn3 != null && !conn3.isClosed()) {
                    conn3.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		
		
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
