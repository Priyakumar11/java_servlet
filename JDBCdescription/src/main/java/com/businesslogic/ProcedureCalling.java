package com.businesslogic;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProcedureCalling")
public class ProcedureCalling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProcedureCalling() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid=Integer.parseInt(request.getParameter("txtpid"));
		try {
			
			//String str="select * from Product";
			//Call Connection Method
				Connection con=DatabaseConnection.getMyConnection();
			//Write sql command
				CallableStatement stmt=con.prepareCall("{call getRecord(?,?,?,?,?)}");
			    
			    
			    stmt.setInt(1,pid);
			    stmt.registerOutParameter(2, Types.VARCHAR);
			    stmt.registerOutParameter(3, Types.INTEGER);
			    stmt.registerOutParameter(4, Types.DECIMAL);
			    stmt.registerOutParameter(5, Types.DECIMAL);
			   stmt.execute();
			  //  Statement  ps=con.createStatement();
			 //  ResultSet ans =ps.executeQuery(str);
			    PrintWriter out=response.getWriter();
			    out.println("<table border=2>");
				out.println("<tr><th>Pid</th><th>PName</th><th>Qty</th><th>Price</th><th>Total</th></tr>");
				out.println("<tr>");
				out.print("<td>"+pid+"</td>");
				out.print("<td>"+stmt.getString(2)+"</td>");
				out.print("<td>"+stmt.getInt(3)+"</td>");
				out.print("<td>"+stmt.getInt(4)+"</td>");
				out.print("<td>"+stmt.getInt(5)+"</td>");
				out.println("</tr>");
			
			out.println("</table>");
					
					
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	
	}


/*delimiter $$
delimiter $$
create  procedure getRecord(in p_pid int,out p_name  varchar(20), out p_qty int, out p_price decimal(5,2), out p_total decimal(5,2))
begin
     select pname,qty,price,total into p_name,p_qty,p_price,p_total from Product where pid=p_pid;
end$$
delimiter ;
call getRecord(2,@p_name,@p_qty,@p_price,@p_total);
select @p_name,@p_qty,@p_price,@p_total;

*/
