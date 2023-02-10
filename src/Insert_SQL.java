import java.sql.*;
public class Insert_SQL {
    public static void main(String[] args) throws SQLException {

        // Connecting to Your Database is the first step:
        //right click on your user and click on copy jdbc connection string
        //jdbc:mysql://localhost:3306/?user=root
        String dbURL="jdbc:mysql://localhost:3306/employeeportal?useUnicode=true&characerEncoding=UTP-8&useSSL=false";
        String uname="root";
        String pass="root";
        int rowsAffected = 0;
        Statement mystmt = null;
        Connection myconn = null;
        try{
            myconn=DriverManager.getConnection(dbURL,uname,pass);
        }
        catch(Exception E){
            System.out.println("Connection impossible due to ");
            E.printStackTrace();
            myconn.close();
            System.exit(0);
        }

        try{
            //For Insertion
            mystmt=myconn.createStatement();
            //rowsAffected=mystmt.executeUpdate("insert into employeeinfo"+"(name,id,dept,age)"+"values"+"('Jermy','JER38','Sales',38)");
            //System.out.println(rowsAffected);

            //For Updation

            //rowsAffected=mystmt.executeUpdate("update employeeinfo"+" set age=27 "+"where"+" name='Clara'");
            //System.out.println(rowsAffected);

            //For Deletion
            //rowsAffected=mystmt.executeUpdate("delete from employeeinfo "+"where name='Jermy'");
            //System.out.println(rowsAffected);

            //String SQL1 = "insert into employeeinfo"+"(name,id,dept,age)"+"values"+"('Geeta','GET21','SDE',21)";
            // Add above SQL statement in the batch.
            //mystmt.addBatch(SQL1);

            // Create one more SQL statement
            //String SQL2 = "insert into employeeinfo"+"(name,id,dept,age)"+"values"+"('Hita','HIA38','Sales',44)";
            // Add above SQL statement in the batch.
            //mystmt.addBatch(SQL2);

            // Create an int[] to hold returned values
            //int[] count =  mystmt.executeBatch();

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