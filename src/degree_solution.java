import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class degree_solution
{
	public static void main(String args[])
	{
		int count = 0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
			Statement stmt = con.createStatement();
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
			Statement stmt1 = con.createStatement();
			
			Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
			Statement stmt2 = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT family_details.family_member_id FROM family_details ");
		//	ResultSet rs = stmt.executeQuery("SELECT family_details.family_member_id FROM family_details WHERE family_details.form_number = 1");
			rs.next();
			
			do
			{
				ResultSet rs1 = stmt1.executeQuery("SELECT COUNT(member_degree.degree_id) FROM member_degree WHERE member_degree.family_member_id = '" + rs.getInt(1) + "'");
				
				rs1.next();
				
				do
				{
					if(rs1.getInt(1)==0)
					{
						stmt2.executeUpdate("INSERT INTO member_degree (family_member_id, degree_id) VALUES ('" + rs.getInt(1) + "','189')");
						
						System.out.println("family member " + rs.getInt(1) + " has two degree");
						count++;
					}
				}
				while(rs1.next());
			}
			while(rs.next());
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("count : " + count);	
	}
}
