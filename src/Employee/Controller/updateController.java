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


@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String vehical=request.getParameter("vehical");
		String license=request.getParameter("license");
		String city=request.getParameter("city");
		String aadhar=request.getParameter("aadhar");
		
		Driver_bo db=new Driver_bo();
		
		db.setId(id);
		db.setName(name);
		db.setPhone(phone);
		db.setVehical(vehical);
		db.setLicense(license);
		db.setCity(city);
		db.setAadhar(aadhar);
		
		int status=Emp_dao.UpdateDriver(db);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllDriverController");
			rd.forward(request, response);
		}
	}
}
