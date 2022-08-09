package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businesslogic.DBconnection;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("txtpid"));
		String pname=request.getParameter("txtpname");
		int qty=Integer.parseInt(request.getParameter("txtqty"));
		int price=Integer.parseInt(request.getParameter("txtprice"));
		//int total=Integer.parseInt(request.getParameter("txttotal"));
		int total=Integer.parseInt(request.getParameter("txttotal"));
		PrintWriter out=response.getWriter();
		/*out.println(rollno);
		out.println(name);
		out.println(marks);*/
		
		try {
			//Call Connection Method
				Connection con= DBconnection.getMyConnection();
			//Write sql command
				String str="Insert into Product (pid,pname,qty,price,total) values(?,?,?,?,?)";
				//string str= "update student set marks=? where rollno=?"
				//String str="delete from student where rollno=?"
				//to execute query create object of preparedSatement
				PreparedStatement  ps=con.prepareStatement(str);
				ps.setInt(1, pid );
				ps.setString(2, pname);
				ps.setInt(3, qty);
				ps.setInt(4, price);
				ps.setInt(5, (qty*price));
				int ans =ps.executeUpdate();
				
				if(ans>0)
					out.println("Record inserted");
				else
					out.println("Record not inserted");
				con.close();
			
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
