package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class SelectBoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//서비스 객체 생성하는 부분
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		//해당 게시글 조회하는 부분
		String boardNum = req.getParameter("boardNum");
		
		BoardVO boardVO = boardService.getBoard(Integer.parseInt(boardNum));
		
		req.setAttribute("boardPost", boardVO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/postForm.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}
}
