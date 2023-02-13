package Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.Dao.Emp_dao;
import Employee.bo.Transport_bo;


@WebServlet("/EditTransport")
public class EditTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditTransport() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 
		 
		 String number=request.getParameter("vehical_no");
		 
		 
		 Transport_bo tb=Emp_dao.getvehicalno(number);
		 
		 pw.print("<form  action='updatetransportController' method='get'> ");
		    
			pw.print("<table>");
			
			pw.print("<tr><td>transport_type : :</td><td>");  
	        pw.print("<select name='Transport_type' value='style='width:150px'>");  
	        pw.print("<option>Truck</option>");  
	        pw.print("<option>Bus</option>");  
	        pw.print("<option>Delivery_Van</option>");  
	        pw.print("<option>Lorry</option>");
	        pw.print("<option>Trailer</option>"); 
	        pw.print("<option>Tractor</option>");
	        pw.print("<option>Other</option>"); 
	        pw.print("</select>");  
		   	pw.print("<tr><td>vehical_No. : </td> <td><input type='text' name=vehical value='"+tb.getNumber()+"'/></td></tr>");
		   	pw.print("<tr><td>Departure :</td> <td><input type='text' name=Departure value='"+tb.getDep()+"'/></td></tr>");
		   	pw.print("<tr><td>Destination : </td> <td><input name=Destination type='text' value='"+tb.getDes()+"'/></td></tr>");
			
		    pw.print("<tr><td><input type='submit' value='Edit & Save '/></td></tr>"); 
		    
		   	pw.print("</table>");
			
			pw.print("</form>");
	}

}
