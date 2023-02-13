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
import Employee.bo.Transport_bo;


@WebServlet("/TransportController")
public class TransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TransportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String trans=request.getParameter("Transport_type");
		String num=request.getParameter("number");
		String dep=request.getParameter("dep");
		String des=request.getParameter("des");
		
		Transport_bo tb=new Transport_bo(trans, num, dep, des);
		
		int status= Emp_dao.addtransport(tb);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllTransportController");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("addtransport.html");
			rd.include(request, response);
		}	
	}
}
