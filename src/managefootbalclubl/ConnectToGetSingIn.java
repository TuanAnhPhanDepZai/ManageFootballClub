
package managefootbalclubl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectToGetSingIn {
    private final String classname = "com.mysql.jdbc.Driver" ;
    private final String url = "jdbc:mysql://localhost:3306/dangnhap" ; 
    private  String user = "root" ;
    private  String pass = "phantuananh123"; 
    private Connection connection ;
    private  String table = "dangnhap" ;
    public  void connnect(){
        try {
                Class.forName(classname);
            
            try {
                connection = DriverManager.getConnection(url, user, pass) ;
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectToGetSingIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectToGetSingIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isConnectToSingIn(){
    	boolean Issucess = false ;
    	if (connection != null) {
    		Issucess = true ;
    	} else {
    		Issucess = false ;
    	}
    	return Issucess ;
    }
    
    public ResultSet getData(){
    	ResultSet resultset = null  ;
    	String sqlcommand = "select * from " + table  ;
    	try {
			Statement st  = (Statement) connection.createStatement();
			resultset = (ResultSet) st.executeQuery(sqlcommand) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultset ;
    }
    
    public void ShowData(ResultSet resultset){
    	// su dung phuong thuc get String 
    	try {
    		System.out.println(" Show data base ");
			while ( resultset.next() ){
			   System.out.printf(" %-30s    %-20s   ", resultset.getString(1) , resultset.getString(2)) ;
			   System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ResultSet getDataId(String name){
    	ResultSet resultSet = null ;
    	String sqlcommand = "select * from " + table +" where username =  ? " ;
    	try {
			java.sql.PreparedStatement ps = connection.prepareStatement(sqlcommand);
			ps.setString(1,name);
			resultSet = ps.executeQuery() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultSet ;
    }
    public static void main(String[] args) {
      ConnectToGetSingIn c = new ConnectToGetSingIn()  ;
      c.connnect();
      c.ShowData(c.getDataId("sdfsdfds"));
    }
}
