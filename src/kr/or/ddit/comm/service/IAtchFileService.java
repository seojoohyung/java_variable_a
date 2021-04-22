package kr.or.ddit.comm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.vo.AtchFileVO;

/**
 * 첨부파일 저장을 위한 공통 서비스용 인터페이스
 */
public interface IAtchFileService {

	/**
	 * 첨부파일 저장하기 위한 메서드
	 * @param item 저장할 FileItem객체
	 * @return AtchFileVO 저장한 첨부파일 정보
	 * @throws Exception
	 */
	public AtchFileVO saveAtchFile (FileItem item) throws Exception;
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param fileItemMap 저장할 FileItem 객체
	 * @return AtchFileVO 저장한 첨부파일 정보
	 * @throws Exception
	 */
	public AtchFileVO saAtchFileList (Map<String, Object> fileItemMap) throws Exception;
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param fileVO
	 * @return
	 * @throws SQLException
	 */
	public List<AtchFileVO> getAtchFileList(AtchFileVO fileVO) throws SQLException;
	
	/**
	 * 첨부파일 세부정보 조회하기
	 * @param fileVO 객체
	 * @return AtchFileVO 객체
	 * @throws SQLException
	 */
	public AtchFileVO getAtchFileDetail(AtchFileVO fileVO) throws SQLException;
}
