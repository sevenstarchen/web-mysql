package com.zr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.dao.StudentDao;
import com.zr.entity.Student;
import java.io.*;
public class StudentSerServlet extends HttpServlet {

	private StudentDao dao = new StudentDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数id
		request.setCharacterEncoding("utf-8");
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		System.out.println(idstr);
		
		//调用dao方法插入
		List<Student> list = dao.search(id);
		request.setAttribute("students", list);
		//跳转回列表页面
		request.getRequestDispatcher("inner.jsp").forward(request, response);
	/*	List<Student> list = dao.queryAll();
		request.setAttribute("students", list);
		request.getRequestDispatcher("stulist.jsp").forward(request, response);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
