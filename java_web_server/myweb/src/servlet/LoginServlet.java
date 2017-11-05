package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.utils.JSonUtil;


public final class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		ServletContext   application   =   getServletContext(); 
		PrintWriter out = response.getWriter();
		
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.user_getByUserIDAndPassword(userID, password);
		if(user == null) 
			out.print("0"); // �û������ڷ��� �ַ� 0
		else{
			List<User> list = new ArrayList<User>();
			list.add(user);
			String s = new JSonUtil().listToJson2(list, "users");
			out.print(s); // �û����� �����û�����json�ַ��� ���ﴦ���jsonstr ����ǰ̨jquery����
		}
     
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		ServletContext   application   =   getServletContext(); 
		PrintWriter out = response.getWriter();
		
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.user_getByUserIDAndPassword(userID, password);
		if(user == null) 
			out.print("0"); // �û������ڷ��� �ַ� 0
		else{
			List<User> list = new ArrayList<User>();
			list.add(user);
			String s = new JSonUtil().listToJson2(list, "users");
			out.print(s); // �û����� �����û�����json�ַ��� ���ﴦ���jsonstr ����ǰ̨jquery����
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
