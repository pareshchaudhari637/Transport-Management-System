package Employee.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Employee.bo.Driver_bo;
import Employee.bo.Emp_bo;
import Employee.bo.Transport_bo;


public class Emp_dao {
	
public static Connection getconnection() {
		
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_mangement","root", "Paresh@123");
		}catch(Exception ex) {
		    System.out.println(ex);
		}
		return con;
}

public static int signup(Emp_bo em){
	
	int status=0;
	
	try {
	Connection con=Emp_dao.getconnection();
	String sql="insert into signup(name,email,phone,password) values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, em.getName());
	ps.setString(2, em.getEmail());
	ps.setString(3, em.getPhone());
	ps.setString(4, em.getPass());
	
	status=ps.executeUpdate();
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return status;
}



public static boolean userlogin(String email, String password) {
	
	boolean status=false;
	
	try {
		Connection con=Emp_dao.getconnection();
		String sql="select * from signup where email=? And password=?";
		PreparedStatement ps=con.prepareStatement(sql);	
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}

public static int adddriver(Driver_bo db){
	
	int status=0;
	
	try {
	Connection con=Emp_dao.getconnection();
	String sql="insert into adddriver(name,phone_no,vehical_no,license_no,city,aadhar_no) values(?,?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, db.getName());
	ps.setString(2, db.getPhone());
	ps.setString(3, db.getVehical());
	ps.setString(4, db.getLicense());
	ps.setString(5, db.getCity());
	ps.setString(6, db.getLicense());
	
	status=ps.executeUpdate();
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return status;
}

public static  List getalldriver(){
	
	List<Driver_bo> list=new ArrayList<Driver_bo>();
	try {
		Connection con=Emp_dao.getconnection();
		PreparedStatement ps=con.prepareStatement("select * from adddriver");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Driver_bo db=new Driver_bo();
			db.setId((rs.getInt(1)));
			db.setName(rs.getString(2));
			db.setPhone(rs.getString(3));
			db.setVehical((rs.getString(4)));
			db.setLicense((rs.getString(5)));
			db.setCity((rs.getString(6)));
			db.setAadhar((rs.getString(7)));
			
			list.add(db);
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return list;
}
public static int addtransport(Transport_bo tb){
	
	int status=0;
	
	try {
	Connection con=Emp_dao.getconnection();
	String sql="insert into addtransport(transport_type,vehical_no,Departure,Destination) values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, tb.getTransport_type());
	ps.setString(2, tb.getNumber());
	ps.setString(3, tb.getDep());
	ps.setString(4, tb.getDes());

	
	status=ps.executeUpdate();
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return status;
}
public static  List getalltransport(){
	
	List<Transport_bo> list=new ArrayList<Transport_bo>();
	try {
		Connection con=Emp_dao.getconnection();
		PreparedStatement ps=con.prepareStatement("select * from addtransport");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Transport_bo tb=new Transport_bo();
			tb.setTransport_type(rs.getString(1));
			tb.setNumber((rs.getString(2)));
			tb.setDep((rs.getString(3)));
			tb.setDes((rs.getString(4)));
			
			
			list.add(tb);
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return list;
}





public static Driver_bo getEmployeeById(int id) {
	Driver_bo db=new Driver_bo();
	try {
		Connection con=Emp_dao.getconnection(); 
		String sql="select * from adddriver where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			db.setId(rs.getInt(1));
			db.setName(rs.getString(2));
			db.setPhone((rs.getString(3)));
			db.setVehical((rs.getString(4)));
			db.setLicense((rs.getString(5)));
			db.setCity((rs.getString(6)));
			db.setAadhar((rs.getString(7)));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return db;
}


public static Transport_bo getvehicalno(String number) {
	Transport_bo tb=new Transport_bo();
	try {
		Connection con=Emp_dao.getconnection(); 
		String sql="select * from addtransport where vehical_no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, number);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			tb.setTransport_type(rs.getString(1));
			tb.setNumber(rs.getString(2));
			tb.setDep(rs.getString(3));
			tb.setDes(rs.getString(4));
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return tb;
}



public static int UpdateDriver(Driver_bo db) {
	int status=0;
	
	try {
		Connection con=Emp_dao.getconnection(); 
		String sql="update adddriver set name=?, phone_no=?, vehical_no=?, license_no=?, city=?, aadhar_no=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, db.getName());
		ps.setString(2, db.getPhone());
		ps.setString(3, db.getVehical());
		ps.setString(4, db.getLicense());
		ps.setString(5, db.getCity());
		ps.setString(6, db.getAadhar());
		ps.setInt(7, db.getId());
		
		status=ps.executeUpdate();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}


public static int UpdateTransport(Transport_bo tb) {
	int status=0;
	
	try {
		Connection con=Emp_dao.getconnection(); 
		String sql="update addtransport set transport_type=?, vehical_no=?, Departure=?, Destination=? where vehical_no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, tb.getTransport_type());
		ps.setString(2, tb.getNumber());
		ps.setString(3, tb.getDep());
		ps.setString(4, tb.getDes());								
		ps.setString(5, tb.getNumber());
		
		
		status=ps.executeUpdate();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}




public static int deletedriver(int id){  
    int status=0;  
    try{  
    	Connection con=Emp_dao.getconnection(); 
        PreparedStatement ps=con.prepareStatement("delete from adddriver where id=?");  
        ps.setInt(1,id);  
        status=ps.executeUpdate();     
       
    }catch(Exception e){
    	System.out.println(e);
      }  
    return status;  
}


public static int deletetransport(String number){  
    int status=0;  
    try{  
    	Connection con=Emp_dao.getconnection(); 
        PreparedStatement ps=con.prepareStatement("delete from addtransport where vehical_no=?");  
        ps.setString(1, number);  
        status=ps.executeUpdate();     
       
    }catch(Exception e){
    	System.out.println(e);
      }  
    return status;  
}


}
