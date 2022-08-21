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

import com.assessment.simplilearn.dao.courseDAO;
import com.assessment.simplilearn.dao.studentDAO;
import com.assessment.simplilearn.entity.course;
import com.assessment.simplilearn.entity.student;

/**
 * Servlet implementation class CourseServletController
 */
@WebServlet("/CourseServlet")
public class CourseServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private courseDAO cDao;

    @Override
    public void init() {
        cDao = new courseDAO();
    }  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServletController() {
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
                case "/newcourse":
                    showNewForm(request, response);
                    break;
                case "//insertcourse":
                    insertCourse(request, response);
                    break;
                case "//deletecourse":
                    deleteCourse(request, response);
                    break;
                case "//editcourse":
                    showEditForm(request, response);
                    break;
                case "//updatecourse":
                    updateCourse(request, response);
                    break;
                default:
                    listCourse(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
    }
	private void listCourse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		       List<course> listCourse = cDao.getAllCourse();
    	        request.setAttribute("listCourse", listCourse);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int courseid = Integer.parseInt(request.getParameter("courseid"));
		        student existingCourse = cDao.getCourse(courseid);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
		        request.setAttribute("c", existingCourse);
		        dispatcher.forward(request, response);

		    }

		    private void insertCourse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String coursename = request.getParameter("coursename");
		        course newCourse = new course(coursename);
		        cDao.saveCourse(newCourse);
		        response.sendRedirect("clist");
		    }

		    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int courseid = Integer.parseInt(request.getParameter("courseid"));
		        String coursename = request.getParameter("coursename");
		       
		        course c = new course(courseid,coursename);
		        cDao.updateCourse(c);
		        response.sendRedirect("clist");
		    }

		    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int courseid = Integer.parseInt(request.getParameter("courseid"));
		        cDao.deleteCourse(courseid);
		        response.sendRedirect("clist");
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
