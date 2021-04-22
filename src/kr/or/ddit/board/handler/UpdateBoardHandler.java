package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

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

public class UpdateBoardHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/board/updateForm.jsp";

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

		if (req.getMethod().equals("GET")) {	//Get방식인 경우 redirect를 하지 않음
			
			String boardNum = req.getParameter("boardNum");
			
			//1-1. 게시판 정보 조회
			IBoardService service = BoardServiceImpl.getInstance();
			BoardVO bv = service.getBoard(Integer.parseInt(boardNum));
			
			if (bv.getAtchFileId() > 0) {	//첨부파일 존재하면
				//첨부파일 정보 조회
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(bv.getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			//2. 모델 정보 등록
			req.setAttribute("boardVO", bv);
			
			return VIEW_PAGE;
		}else {	//Post방식인 경우
			
			//FileItem 추출
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			//기존의 첨부파일 아이디 정보 가져오기
			atchFileVO.setAtchFileId(req.getParameter("atchFile") == null ?
					-1 : Long.parseLong(req.getParameter("atchFile")));
			
			if (item != null && item.getName().equals("")) {
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				atchFileVO = fileService.saveAtchFile(item);	//첨부파일 저장
			}
			
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
