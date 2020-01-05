package eg.edu.alexu.csd.oop;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.SQLException;

import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {

	public static void main(String[] args) throws SQLException {
		/*Driver driver = new Driver();
		Properties info = new Properties();
        File dbDir = new File("sample" + System.getProperty("file.separator") + ((int)(Math.random() * 100000)));
        info.put("path", dbDir.getAbsoluteFile());
        Connection connection = driver.connect("jdbc:xmldb://localhost", info);
        Statement statement = connection.createStatement();
        statement.reload();
        statement.execute("create database islam");
        statement.execute("create table h(name varchar , phone int)");
        statement.executeUpdate("insert into h (name,phone)values('i',1)");
        statement.executeUpdate("insert into h (name,phone)values('d',2)");
        statement.executeUpdate("insert into h (name,phone)values('s',3)");
        statement.executeUpdate("insert into h (name,phone)values('f',4)");
        statement.executeUpdate("insert into h (name,phone)values('it',5)");
        ResultSet r =  statement.executeQuery("select * from h");
        r.absolute(3);
        ResultSetMetaData rs = r.getMetaData();
        System.out.println(rs.getColumnLabel(0));
        System.out.println(rs.getColumnName(0));
        System.out.println(rs.getColumnType(0));
        System.out.println(rs.getTableName(0));
        System.out.println(rs.getColumnCount());
        */
        
        
        
		
		
		
		
		
		
		System.out.println("********************** Welcome To JDBS ***********************");
		System.out.print("Creating Driver....");
		try {
			Thread.sleep(2000);
			System.out.println(".. Driver Created");
			Thread.sleep(500);
			System.out.print("Creating Connection....");
			Thread.sleep(2000);
			System.out.println(".. Connection Created");
			Thread.sleep(500);
			System.out.print("Creating Statement....");
			Thread.sleep(2000);
			System.out.println(".. Statement Created ");
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Logger Log=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		Driver d = new Driver();
		Properties info = new Properties();
		File dbDir = new File("D:\\DBMS\\databases");
		info.put("path", dbDir.getAbsoluteFile());
		Connection c = d.connect("jdbc:xmldb://localhost", info);
		Statement s=c.createStatement();
		s.reload();
		System.out.println("Enter Your Query TO execute it  or write (end) to exit :");
		while (true) {
		
		Scanner sc = new Scanner(System.in);
		String sql = new String();
		java.sql.ResultSet r = new ResultSet();
		sql = sc.nextLine();
		if(sql.equalsIgnoreCase("end")) {
			System.out.println("Ending Program...");
			try {
				Thread.sleep(500);
				System.out.print("Closing Statement..");
				Thread.sleep(1000);
				System.out.println(".. Statement Closed");
				Thread.sleep(500);
				System.out.print("Closing Connection....");
				Thread.sleep(1000);
				System.out.println(".. Connection closed");
				Thread.sleep(500);
				System.out.println("..JDBC is Closed");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("********************* see you soon *************************");
			break;
		}
		
		
		try {
			
			if(sql.toLowerCase().contains("create") || sql.toLowerCase().contains("drop")) {
				long start = System.currentTimeMillis();
				if(s.execute(sql)) {
					//s.addBatch(sql);
					System.out.println("Execution time in ms = "+(System.currentTimeMillis()-start));
					Log.log(Level.INFO, "Structure Query Is Done");
				}
			}
			else if(sql.toLowerCase().contains("insert") || sql.toLowerCase().contains("update")|| sql.toLowerCase().contains("delete"))  {
				long start = System.currentTimeMillis();
				if(s.executeUpdate(sql) != -1) {
					//s.addBatch(sql);
					System.out.println("Execution time in ms = "+(System.currentTimeMillis()-start));
					Log.log(Level.INFO, "Update Query Is Done");
				}
			}
			else if(sql.toLowerCase().contains("select") ) {
				long start = System.currentTimeMillis();
				if(s.executeQuery(sql) != null) {
					//s.addBatch(sql);
					System.out.println("Execution time in ms = "+(System.currentTimeMillis()-start));
					Log.log(Level.INFO, "Select Query Is Done");
				}
				}
			else {
				System.err.println("Invalid Input");
				Log.log(Level.WARNING,"wrong input");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wrong SQL");
			Log.log(Level.WARNING,"wrong input");
			if(e.getMessage()!=null) {
			
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Enter Your Query TO execute it  or write (end) to exit :");
		}
		
			
	}

}
