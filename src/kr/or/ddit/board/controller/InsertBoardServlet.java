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

public class InsertBoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/insertForm.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터 정보 가져오는 부분
		String boardTitle = req.getParameter("boardTitle");
		String boardContent = req.getParameter("boardContent");
		String boardWriter = req.getParameter("boardWriter");
		
		//서비스 객체 생성하는 부분
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		//게시글 등록하는 부분
		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardContent(boardContent);
		bv.setBoardWriter(boardWriter);
		
		int cnt = boardService.insertBoard(bv);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "Y";
		} else {
			msg = "N";
		}
		
		//목록 조회 화면으로 이동하는 부분
		String redirectUrl = req.getContextPath() + "/board/list.do?msg=" + msg;
		
		resp.sendRedirect(redirectUrl);
	}
}
