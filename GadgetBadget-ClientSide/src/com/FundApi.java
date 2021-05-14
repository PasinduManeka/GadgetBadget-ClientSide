package com;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FundApi
 */
@WebServlet("/FundApi")
public class FundApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Fund itemObj = new Fund();
		
		String output = itemObj.inserFund(request.getParameter("code"), request.getParameter("name"), request.getParameter("price"), request.getParameter("description"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fund itObjUpdate = new Fund();
		Map paras = getParasMap(request);
		
		String output = itObjUpdate.updateItem(paras.get("hidIDItemIDSave").toString(), paras.get("code").toString(), paras.get("name").toString(), paras.get("amount").toString(), paras.get("description").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fund itObjDelete  = new Fund();
		Map paras = getParasMap(request);
		
		System.out.println(paras.get("id").toString());
		
		String output = itObjDelete.deleteItem(paras.get("id").toString());
		response.getWriter().write(output);
		
		
		
		
	}
	
	private static Map getParasMap(HttpServletRequest request) {
		Map<String,String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			
			for(String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
			
		}catch(Exception e) {
			
		}
		return map;
	}

}
