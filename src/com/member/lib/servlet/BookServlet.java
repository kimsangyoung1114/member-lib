package com.member.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.BookService;
import com.member.lib.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs = new BookServiceImpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/book/list".equals(uri)) {
			request.setAttribute("bookList", bs.selectBookList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-list");
			rd.forward(request, response);
			return;
		}
		if("/book/view".equals(uri)) {
			int bNum = Integer.parseInt(request.getParameter("b_num"));
			request.setAttribute("book", bs.selectBook(bNum));
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-view");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		if("/book/update".equals(uri)) {
			String bTitle = request.getParameter("b_title");
			String bAuthor = request.getParameter("b_author");
			String bDesc = request.getParameter("b_desc");
			int bNum = Integer.parseInt(request.getParameter("b_num"));
			Map<String,Object> book = new HashMap<>();
			book.put("b_title", bTitle);
			book.put("b_author", bAuthor);
			book.put("b_desc", bDesc);
			book.put("b_num", bNum);
			doProcess(response,bs.updateBook(book).toString());
			return;
		}else if("/book/delete".equals(uri)) {
			int bNum = Integer.parseInt(request.getParameter("b_num"));
			doProcess(response,bs.deleteBook(bNum).toString());
			return;
		}
	}

	private void doProcess(HttpServletResponse response,String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
	}

}
