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
public class StudentChaServlet extends HttpServlet {

	private StudentDao dao = new StudentDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����id
		String id2str=request.getSession().getAttribute("testSession").toString();
		String idstr = request.getParameter("id");
		String namestr = request.getParameter("name");
		namestr=new String(namestr.getBytes("ISO-8859-1"),"utf-8");
		String urlstr = request.getParameter("url");
		String alexastr = request.getParameter("num");
		String countrystr = request.getParameter("country");
		System.out.println("id2=="+idstr);
		int id2 = Integer.parseInt(id2str);
		int id = Integer.parseInt(idstr);
		int alexa = Integer.parseInt(alexastr);
		System.out.println(idstr+namestr+urlstr+alexastr+countrystr);
		
		//����dao��������
		dao.chsert(id, id2,namestr, urlstr, alexa, countrystr);
		List<Student> list = dao.queryAll();
		request.setAttribute("students", list);
		//��ת���б�ҳ��
		request.getRequestDispatcher("stulist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
