package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {

		int cnt = 0;
		
		Object obj = smc.insert("board.insertBoard", bv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public boolean checkBoard(SqlMapClient smc, int boardNum) throws SQLException {

		boolean chk = false;
		
		int cnt = (int) smc.queryForObject("board.checkBoard", boardNum);
		
		if(cnt > 0) {
			chk = true;
		}
		
		return chk;
	}

	@Override
	public List<BoardVO> getAllBoardList(SqlMapClient smc) throws SQLException {

		List<BoardVO> memList = smc.queryForList("board.getBoardAll");
		
		return memList;
	}

	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {

		int cnt = 0;
		
		cnt = smc.update("board.updateBoard", bv);
		
		return cnt;
	}

	@Override
	public int deleteboard(SqlMapClient smc, int boardNum) throws SQLException {

		int cnt = 0;
		
		cnt = smc.delete("board.deleteBoard", boardNum);
		
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(SqlMapClient smc, BoardVO bv) throws SQLException {

		List<BoardVO> boardList = smc.queryForList("board.getSearchBoard",bv);
		
		return boardList;
	}

	@Override
	public BoardVO getBoard(SqlMapClient smc, int boardNum) throws SQLException {

		BoardVO boardVO = (BoardVO) smc.queryForObject("board.getBoard", boardNum);
		
		return boardVO;
	}
}
