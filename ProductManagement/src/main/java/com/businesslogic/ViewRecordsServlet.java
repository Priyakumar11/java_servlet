package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businesslogic.DBconnection;


@WebServlet("/ViewRecordsServlet")
public class ViewRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewRecordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Call Connection Method
				Connection con=DBconnection.getMyConnection();
			//Write sql command
				String str="select * from Product";
				
				//to execute query create object of Statement
				Statement  ps=con.createStatement();
				//get ResultSet
				ResultSet ans =ps.executeQuery(str);
				//next method checks for nextrecord
				PrintWriter out=response.getWriter();
				out.println("<table border=2>");
				out.println("<tr><th>Pid</th><th>PName</th><th>Qty</th><th>Price</th><th>Total</th></tr>");
				//To read values from ResultSet
				while(ans.next()) {
					out.println("<tr>");
					out.print("<td>"+ans.getInt("pid")+"</td>");
					out.print("<td>"+ans.getString("pname")+"</td>");
					out.print("<td>"+ans.getInt("qty")+"</td>");
					out.print("<td>"+ans.getInt("price")+"</td>");
					out.print("<td>"+ans.getInt("total")+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
