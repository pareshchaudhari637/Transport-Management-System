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
import Employee.bo.Transport_bo;


@WebServlet("/updatetransportController")
public class updatetransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updatetransportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String transport=request.getParameter("Transport_type");
		String vehical=request.getParameter("vehical");
		String Departure=request.getParameter("Departure");
		String Destination=request.getParameter("Destination");
		
		Transport_bo tb=new Transport_bo();
		
		tb.setTransport_type(transport);
		tb.setNumber(vehical);
		tb.setDep(Departure);
		tb.setDes(Destination);		
		
		int status=Emp_dao.UpdateTransport(tb);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllTransportController");
			rd.forward(request, response);
		}	
	}
}
