package com.assessment.simplilearn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assessment.simplilearn.dao.studentDAO;
import com.assessment.simplilearn.entity.student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private studentDAO sDao;

    @Override
    public void init() {
        sDao = new studentDAO();
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
    }
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		       List<student> listStudent = sDao.getAllStudent();
		       request.setAttribute("listStudent", listStudent);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		       
		        dispatcher.forward(request, response);
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        student existingStudent = sDao.getStudent(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		        request.setAttribute("s", existingStudent);
		        dispatcher.forward(request, response);

		    }

		    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String fname = request.getParameter("fname");
		        String sname = request.getParameter("sname");
		        String address = request.getParameter("address");
		        int age=Integer.parseInt(request.getParameter("age"));
		        student newStudent = new student(fname, sname, address,age);
		        sDao.saveStudent(newStudent);
		        response.sendRedirect("list");
		    }

		    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String fname = request.getParameter("fname");
		        String sname = request.getParameter("sname");
		        String address = request.getParameter("address");
		        int age=Integer.parseInt(request.getParameter("age"));
		        student s = new student(id,fname, sname, address,age);
		        sDao.updateStudent(s);
		        response.sendRedirect("list");
		    }
		    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        sDao.deleteStudent(id);
		        response.sendRedirect("list");
		    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
