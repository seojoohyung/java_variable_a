package kr.or.ddit.comm.handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;

public class FileDownloadHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		long fileId = req.getParameter("fileId") != null ? Long.parseLong(req.getParameter("fileId")) : -1;
		int fileSn = req.getParameter("fileSn") != null ? Integer.parseInt(req.getParameter("fileSn")) : 1;
		
		//파일 정보 조회
		IAtchFileDao dao = AtchFileDaoImpl.getInstance();
		
		AtchFileVO fileVO = new AtchFileVO();
		fileVO.setAtchFileId(fileId);
		fileVO.setFileSn(fileSn);
		
		fileVO = dao.getAtchFileDetail(fileVO);
		
		//파일 다운로드 처리를 위한 응답헤더 정보 설정하기
		resp.setContentType("application/octet-stream");
		System.out.println("URL 인코딩된 파일명 => " + URLEncoder.encode(fileVO.getOrignlFileNm(), "UTF-8"));
		//URLs cannot contain spaces. URL encoding normally replaces a space with a plus (+) sign or with %20.
		//+문자 공백으로 바꿔주기
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileVO.getOrignlFileNm(), "UTF-8").replaceAll("\\+", "%20") + "\"");
		
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileVO.getFileStreCours()));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int c = -1;
		while ((c = bis.read()) != -1) {
			bos.write(c);
		}
		
		bis.close();
		bos.close();
		
		return null;
	}

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
}
