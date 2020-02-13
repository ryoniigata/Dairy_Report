package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberInfoBeans;
import dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Top")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		LoginDao ld = new LoginDao();

		boolean result = ld.loginJudge(id, pw);

		if (result) {
			//ログインユーザのインスタンス生成
			MemberInfoBeans mib = new MemberInfoBeans();
			mib.setId(id);
			mib.setPw(pw);

			//トップページへ画面遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topView.jsp");
			dispatcher.forward(request, response);

		} else {
			//トップページへ画面遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}

	}

}
