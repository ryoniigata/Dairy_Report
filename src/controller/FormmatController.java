package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormmatController
 */
@WebServlet("/Formmat")
public class FormmatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormmatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formmat.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> array = new ArrayList<String>();
		String file = (String)request.getParameter("file");
		File f = new File(file);

		try(BufferedReader br = new BufferedReader(new FileReader(f));) {

        String line;
        int count = 0;
        while ((line = br.readLine()) != null && count < 100 ) {
        	array.add(line);
        	count++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

		request.setAttribute("formmat", array);
		//フォーマット確認へ画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formmatConfirmation.jsp");
		dispatcher.forward(request, response);

	}

}
