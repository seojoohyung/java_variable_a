package src.Kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.Kr.or.ddit.member.vo.MemberVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는  DAO인터페이스
 * 
*/
public interface iMemberDao {
	
	/** 
	 * MemberVO 객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param conn 커넥션 객체
	 * @param mv DB에 insert 할 자료가 저장된 MemberVO 객체
	 * @return DB 작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환한다.
	 * @throws SQLException JDBC 관련 예외객체 발생 
	 * 	*/
	public int insertMember(Connection conn , MemberVO mv) throws SQLException;
	
	/**
	 * 주어진 회원 ID가 존재하는지 여부를 알아내는 메서드
	 * @param conn 커넥션 객체
	 * @param memId 회워id
	 * @return 해당 회원 id가 존재 하면 true , 존재하지 않으면 false
	 * @throws SQLException JDNC 관련 예외 객체 발생 
	*/
	public boolean checkMember(Connection conn, String memId) throws SQLException;

	/**
	 * DB 의 mymember테이블의 전체 레코드를 가져와서 list에 담아 반환하는 메서드
	 * @param conn 커넥션 객체
	 * @return 회원정보를 담고있는 List 객체
	 * @throws SQLException JDNC 관련 예외 객체 발생
	*/
	public List<MemberVO> getAllMemberList(Connection conn) throws SQLException;

	/**
	 * 하나의 회원정보를 이용하여 db를 update하느 메서드
	 * @param conn 커넥션 객체
	 * @param mv 회원 정보 객체 
	 * @return 작업성공:1 작업실패: 0
	 * @throws SQLException JDNC 관련 예외 객체 발생
	*/
	public int updateMember(Connection conn, MemberVO mv) throws SQLException;

	/**
	 * 회원 id를 매개 변수로 받아서 그 회원정보를 삭제하는 메서드
	 * @param conn 커넥션 객체
	 * @param memId 삭제할 회원id
	 * @return 작업성공:1 작업실패: 0
	 * @throws SQLException JDNC 관련 예외 객체 발생
	*/
	public int deleteMember(Connection conn, String memId) throws SQLException;
	
	/**
	 * MemberVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param mv 검색할 자료가 들어있는 MemberVO 객체
	 * @return 검색된 결과를 담은 List
	 */
	
	
	List<MemberVO> getSearchMember(Connection conn, MemberVO mv) throws SQLException;
}
