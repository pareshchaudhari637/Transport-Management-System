package Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.Dao.Emp_dao;
import Employee.bo.Driver_bo;

/**
 * Servlet implementation class DriverController
 */
@WebServlet("/DriverController")
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DriverController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String vehical=request.getParameter("vehical");
		String license=request.getParameter("license");
		String city=request.getParameter("city");
		String aadhar=request.getParameter("aadhar");
		
		Driver_bo db=new Driver_bo(name, phone, vehical, license, city, aadhar);
		
		int status= Emp_dao.adddriver(db);
		
		if(status>0){
			RequestDispatcher rd=request.getRequestDispatcher("AllDriverController");
			rd.forward(request, response);
			
		}
		else {
			pw.print("Something is Wrong!!");
			RequestDispatcher rd=request.getRequestDispatcher("adddriver.html");
			rd.include(request, response);
		}	
	}
}
