package kr.or.ddit.board.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class InsertBoardHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/board/insertForm.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		if (req.getMethod().equals("GET")) {	//Get방식인 경우
			return false;
		}else {	//Post방식인 경우
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		if (req.getMethod().equals("GET")) {	//Get방식인 경우 isRedirect를 하지 않음
			return VIEW_PAGE;
		}else {	//Post방식인 경우 isRedirect를 함
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			atchFileVO = fileService.saveAtchFile(item);
			
			//1. 요청 파라미터 정보 가져오기
			String memId = req.getParameter("memId");
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			String boardWriter = req.getParameter("boardWriter");
			
			//2. 서비스 객체 생성하기
			IBoardService boardService = BoardServiceImpl.getInstance();
			
			//3. 게시판 정보 등록하기
			BoardVO bv = new BoardVO();
			bv.setMemId(memId);
			bv.setBoardTitle(boardTitle);
			bv.setBoardContent(boardContent);
			bv.setBoardWriter(boardWriter);
			bv.setAtchFileId(atchFileVO.getAtchFileId());
			
			int cnt = boardService.insertBoard(bv);
			
			String msg = "";
			
			if (cnt > 0) {
				msg = "성공";						
			}else {
				msg = "실패";
			}
			
			//4. 목록 조회 화면으로 이동
			String redirectUrl = req.getContextPath() + "board/list.do?msg=" + URLEncoder.encode(msg, "UTF-8");

			return redirectUrl;
		}
	}
}
