package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 게시판 정보 처리 서비스
 */
public interface IBoardService {

	/**
	 * 게시글 등록하는 메서드
	 * @param bv DB에 insert할 자료가 저장된 BoardVO 객체
	 * @return DB작업 성공시 1이상 값 반환, 실패시 0 반환
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 주어진 게시글 번호가 존재하는지 여부 찾는 메서드
	 * @param boardNum 게시글 번호
	 * @return 해당 게시글 번호 존재시 true, 존재하지 않을시 false
	 */
	public boolean checkBoard(int boardNum);

	/**
	 * 전체 게시판 정보 조회하는 메서드
	 * @return 게시판 정보를 갖고 있는 List 객체
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 단일 게시글 조회하는 메서드
	 * @param boardNum 게시글 번호
	 * @return 게시글 번호와 일치하는 게시글 내용
	 */
	public BoardVO getBoard(int boardNum);
	
	/**
	 * 단일 게시판 정보 수정하는 메서드
	 * @param bv 게시판 정보 객체
	 * @return 작업 성공시 1, 작업 실패시 0
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시글 삭제하는 메서드
	 * @param boardNum 삭제할 게시글 번호
	 * @return 작업성공시 1, 작업 실패시 0
	 */
	public int deleteBoard(int boardNum);
	
	/**
	 * BoardVO 객체에 담긴 자료 사용하여 게시글 검색하는 메서드
	 * @param bv 검색할 자료가 들어있는 BoardVO 객체
	 * @return 검색된 결과를 담은 List
	 */
	public List<BoardVO> getSearchBoard(BoardVO bv);
}
