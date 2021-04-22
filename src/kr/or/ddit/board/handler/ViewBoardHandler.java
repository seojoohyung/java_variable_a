package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;

public class ViewBoardHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/board/select.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String boardNum = req.getParameter("boardNum");
		
		//게시판 정보 조회
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		BoardVO bv = boardService.getBoard(Integer.parseInt(boardNum));
		
		if (bv.getAtchFileId() > 0) {	//첨부파일 존재하면
			//첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(bv.getAtchFileId());
			
			IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
			
			List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
			
			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("boardVO", bv);
		
		return VIEW_PAGE;
	}
}
