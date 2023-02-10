package src;

import java.sql.*;


public class Query_SQL {
    public static void main(String[] args) throws SQLException {

        // Connecting to Your Database is the first step:
        //right click on your user and click on copy jdbc connection string
        //jdbc:mysql://localhost:3306/?user=root
        String dbURL="jdbc:mysql://localhost:3306/employeeportal?useUnicode=true&characerEncoding=UTP-8&useSSL=false";
        String uname="root";
        String pass="root";
        Statement mystmt = null;
        Connection myconn = null;
        try{
            myconn= DriverManager.getConnection(dbURL,uname,pass);
        }
        catch(Exception E){
            System.out.println("Connection impossible due to ");
            E.printStackTrace();
            myconn.close();
            System.exit(0);
        }
        try{
            //Query Execution
            mystmt=myconn.createStatement();
            ResultSet result_ =mystmt.executeQuery("select * from employeeinfo where id='MAR35'");
            while(result_.next()) {
                System.out.println("----------------------------------------");
                System.out.println("ID= " + result_.getString(1));
                System.out.println("Name= " + result_.getString(2));
                System.out.println("Dept= " + result_.getString("dept"));
                System.out.println("Age= " + result_.getInt("age"));
                System.out.println("----------------------------------------");
            }
                //Executing Prepared Statement
                //Prevents SQL Injection
                /*System.out.println("Prepared Statement Result");
                PreparedStatement prepstmt = myconn.prepareStatement("select * from employeeinfo where age > ? and dept= ?");
                prepstmt.setInt(1,30);
                prepstmt.setString(2,"HR");
                ResultSet result_p =prepstmt.executeQuery();
                while(result_p.next()){
                    System.out.println("----------------------------------------");
                    System.out.println("ID= "+result_p.getString(1));
                    System.out.println("Name= "+result_p.getString(2));
                    System.out.println("Dept= "+result_p.getString("dept"));
                    System.out.println("Age= "+result_p.getInt("age"));
                    System.out.println("----------------------------------------");

            }*/

            System.out.println("Stored Procedures");
            CallableStatement call_stmt=myconn.prepareCall("{call inc_age_by (?,?)}");
            call_stmt.setInt(1,1);
            call_stmt.setString(2,"KAT45");
            call_stmt.execute();


        }
        catch(Exception E){
            E.printStackTrace();
        }
        finally {
            if(mystmt != null){
                mystmt.close();
            }
            if(myconn!=null){
                myconn.close();
            }
        }
    }
}