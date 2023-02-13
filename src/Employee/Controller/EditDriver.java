package Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.Dao.Emp_dao;
import Employee.bo.Driver_bo;


@WebServlet("/EditDriver")
public class EditDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditDriver() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
          
	      int eid= Integer.parseInt(id);
	    
	      Driver_bo db= Emp_dao.getEmployeeById(eid);
	    
		 
		pw.print("<form  action='updateController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+db.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name=name value='"+db.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone No.: </td> <td><input type='text' name=phone value='"+db.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Vehical No.:</td> <td><input type='text' name=vehical value='"+db.getVehical()+"'/></td></tr>");
	   	pw.print("<tr><td>License No. : </td> <td><input name=license type='text' value='"+db.getLicense()+"'/></td></tr>");
	   	pw.print("<tr><td>City: </td> <td><input type='text' name=city value='"+db.getCity()+"'/></td></tr>");
	   	pw.print("<tr><td>Aadhar NO.: </td> <td><input type='text' name=aadhar value='"+db.getAadhar()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Edit & Save '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
