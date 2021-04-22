package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	/**
	 * BoardVO 객체에 담긴 자료를 DB에 insert하는 메서드
	 * @param smc SqlMapClient
	 * @param bv DB에 insert할 자료가 저장된  BoardVO 객체
	 * @return DB작업 성공시 1이상의 값 반환, 실패시 0 반환
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	
	/**
	 * 게시글 번호가 존재하는지 여부 알아내는 메서드
	 * @param smc SqlMapClient
	 * @param boardNum 게시글 번호
	 * @return 해당 게시글 번호가 존재시 true, 존재하지 않을시 false
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public boolean checkBoard(SqlMapClient smc, int boardNum) throws SQLException;
	
	/**
	 * DB의 board테이블의 전체 레코드를 가져와 List에 담아 반환하는 메서드
	 * @param smc SqlMapClient
	 * @return 게시판 정보를 담고있는 List 객체
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public List<BoardVO> getAllBoardList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 단일 게시판 정보를 사용하여 DB update하는 메서드
	 * @param smc SqlMapClient
	 * @param bv 게시판 정보 객체
	 * @return 작업 성공시 1, 실패시 0
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	
	/**
	 * 게시글 번호를 매개로 하여 게시판 정보 삭제하는 메서드
	 * @param smc SqlMapClient
	 * @param boardNum 삭제할 게시글 번호
	 * @return 작업 성공시 1, 실패시 0
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public int deleteboard(SqlMapClient smc, int boardNum) throws SQLException;
	
	/**
	 * BoardVO 객체에 담긴 자료를 사용하여 회원 검색하는 메서드
	 * @param smc SqlMapClient
	 * @param bv 검색할 자료가 담긴 BoardVO 객체
	 * @return 검색된 결과를 담은 List
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public List<BoardVO> getSearchBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	
	/**
	 * 단일 게시글 조회하는 메서드
	 * @param smc SqlMapClient
	 * @param boardNum 조회할 게시글 번호
	 * @return 작업 성공시 1, 실패시 0
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public BoardVO getBoard(SqlMapClient smc, int boardNum) throws SQLException;
}
