package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

public class DeleteBoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String redirectUrl = req.getContextPath() + "/board/select.do?boardNo=" + req.getParameter("boardNo");

		resp.sendRedirect(redirectUrl);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IBoardService boardService = BoardServiceImpl.getInstance();
		
		String boardNum = req.getParameter("boardNum");
		
		int cnt = boardService.deleteBoard(Integer.parseInt(boardNum));
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "DY";
		} else {
			msg = "DN";
		}
		
		String redirectUrl = req.getContextPath() + "/board/list.do?msg=" + msg;
		
		resp.sendRedirect(redirectUrl);
	}
}
