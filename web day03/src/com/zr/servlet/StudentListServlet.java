package com.zr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.dao.StudentDao;
import com.zr.entity.Student;

/**
 * 查看全部学生
 * @author Administrator
 *
 */
public class StudentListServlet extends HttpServlet {

	private StudentDao dao = new StudentDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//构造学生集合
//		List<Student> list = new ArrayList<Student>();
//		list.add(new Student(1, "stu001", "张三", "男", 20));
//		list.add(new Student(2, "stu002", "李四", "女", 21));
//		list.add(new Student(3, "stu003", "王五", "男", 19));
//		list.add(new Student(4, "stu004", "凤飞飞", "女", 22));
//		list.add(new Student(5, "stu005", "渣渣辉", "男", 25));
		//将数据放入request中，传递到页面
		List<Student> list = dao.queryAll();
		request.setAttribute("students", list);
		request.getRequestDispatcher("stulist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}




