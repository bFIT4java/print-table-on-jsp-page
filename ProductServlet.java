package com.ust;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw = response.getWriter();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		//creates an object of the product class
		ProductList pl = new ProductList();
		
		//calls the product class to call the database and loads the product vectors
		pl.setVector();
		Vector<Integer> productId = pl.productId;
		Vector<String> productName = pl.productName;
		Vector<Double> productPrice = pl.productPrice;
		
		//creates and forwards the information to the jsp page
		request.setAttribute("productId", productId);
		request.setAttribute("productName", productName);
		request.setAttribute("productPrice", productPrice);
        request.getRequestDispatcher("ProductView.jsp").forward(request, response);

		
		/* do not worry about the code below
		//prints the table from the loaded vectors
		pw.println("<table border = \"1\" color=\"FF0000\" >");
		pw.println("<tr><td>"+"Product ID\t"+"</td><td>"+"\tProduct Name\t"+"</td><td>"+"\tProduct Price"+"</td></tr>");
		//loops through each vector and prints out the information for each one in rows and columns
		for(int i = 0;i<productId.size();i++){
			pw.println("<tr><td>"+productId.elementAt(i)+"</td><td>"+productName.elementAt(i)+"</td><td>"+fmt.format(productPrice.elementAt(i))+"</td></tr>");
		}
		pw.println("</table>");*/
	}

}
