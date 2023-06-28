package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pratice","root","abc123");
		Scanner s=new Scanner(System.in);
		
		boolean loop =true;
		
		while(loop){
			
			
			System.out.println("1. Add Student");
			System.out.println("2.Show Student");
System.out.println("3.Serch Student");
System.out.println("4.Search name of Student");
System.out.println("5.delete Student");
System.out.println("6.update Student");
System.out.println("7.Student under roll 200");
System.out.println("8.Last Student added(history)");
	System.out.println("Enter the choce");
	int choice=Integer.parseInt(s.nextLine());
	
	switch (choice)
	
	{
	
	case 1:

		System.out.println("enter the roll  ");
		int roll=Integer.parseInt(s.nextLine());
		System.out.println("enter the name");
		String name=s.nextLine();
		System.out.println("Enter the address");
		String address=s.nextLine();
		PreparedStatement stmt=con.prepareStatement("insert into pratice.pra values(?,?,?)");
		stmt.setInt(1, roll);
stmt.setString(2, name);
stmt.setString(3, address);
int a=stmt.executeUpdate();
if(a>0){
	System.out.println("data imserted");
}
else{
	System.out.println("data not inserted");
}

		break;

	case 2:
		ResultSet rs=null;
     stmt=con.prepareStatement("SELECT*From pratice.pra");
	rs=stmt.executeQuery();
	while(rs.next()){
		
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
		
		
		
		break;
	case 3:
	System.out.println("Enter the roll");
	roll=Integer.parseInt(s.nextLine());
	
     stmt=con.prepareStatement("SELECT*From pratice.pra where roll=?");
     stmt.setInt(1,roll);
	rs=stmt.executeQuery();
	while(rs.next()){
		
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
		
		
		
		break;
		
	case 4:
		System.out.println("Enter the name");
		name =s.nextLine();
		
	     stmt=con.prepareStatement("SELECT*From pratice.pra where name LIKE '"+name+"%'");
	 //    stmt.setInt(1,roll);
		rs=stmt.executeQuery();
		while(rs.next()){
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
			
			
			
			break;
			
	case 5:
		System.out.println("Enter the roll");
		roll=Integer.parseInt(s.nextLine());
		
	     stmt=con.prepareStatement("delete From pratice.pra where roll=?");
	     stmt.setInt(1,roll);
		a=stmt.executeUpdate();
		if(a>0){
			System.out.println("data deleted");
			
			
		}
		else{
			System.out.println("not deleted");
		}
			
			
			break;
			
	case 6:
		System.out.println("enter the roll to update  ");
		 roll=Integer.parseInt(s.nextLine());
		System.out.println("enter the name");
		 name=s.nextLine();
		System.out.println("Enter the address");
		 address=s.nextLine();
		stmt=con.prepareStatement("Update pratice.pra set name=?,address=? where roll=?");
		stmt.setString(1, name);
		stmt.setString(2, address);
stmt.setInt(3, roll);
 a=stmt.executeUpdate();
if(a>0){
	System.out.println("data updated");
}
else{
	System.out.println("data not updated");
}

		break;
		
	case 7:
		 rs=null;
     stmt=con.prepareStatement("SELECT*From pratice.pra where roll <=200");
	rs=stmt.executeQuery();
	while(rs.next()){
		
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
		break;
		
	case 8:
		 rs=null;
	     stmt=con.prepareStatement("SELECT*From pratice.pra ORDER BY roll DESC");
		rs=stmt.executeQuery();
		while(rs.next()){
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
			
			
		
		
		break;
		
	
	}
	
	
		}
	}

}
