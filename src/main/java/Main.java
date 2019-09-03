import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {
            /*
        Connection object for Database connection using DriverManager
        Driver manager will make connection using the database driver in classpath and connection string defined
        This is called Connection String : jdbc:oracle:thin @18.206.135.47:1521:xe
        For this example , we have put oracle jdbc driver in class path and provided connection string and credentials

        Connection string in detail
        * jdbc -- protocol
        * oracle -- sub-protocol to define database vendor,
                if it was mysql database it would be jdbc:mysql....
        * thin  -- oracle driver name , thin driver (depends on database itself , mysql does not require this)
        * host  -- this is the address of the database server :  @18.207.135.47  your IP!
        * port  -- this is the port database use : 1521
        * xe    -- database service name
        * */
        String connection_str = "jdbc:oracle:thin:@18.206.235.47:1521:xe"; // replace ip with your ip
        String db_user     = "hr";
        String db_password = "hr";
        // creating Connection object
        // just like creating Webdriver object , according to what kind of driver connection string provided
        //  it will create corresponding Connection object
        Connection conn = DriverManager.getConnection(connection_str,db_user,db_password);

        // once we have connection object , now we can create statement object. and it has ability to execute query
        Statement stmt = conn.createStatement();
        // optionally you may do as below , if you want to just move top tp bottom direction
        //Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // use Statement Object to run query and store the result in ResultSet object
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");
        // initially the cursor is at right before first row, next() method will move it to first row
        rs.next();
        // printing out the Region_Name column value at first row
        System.out.println(rs.getObject("Region_Name"));


    }


}
