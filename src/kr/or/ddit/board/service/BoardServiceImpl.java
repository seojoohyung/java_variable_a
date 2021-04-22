package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao boardDao;
	private SqlMapClient smc;
	
	private static IBoardService service;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO mv) {

		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean checkBoard(int boardNum) {

		boolean chk = false;
		
		try {
			chk = boardDao.checkBoard(smc, boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		List<BoardVO> memList = new ArrayList<>();
		
		try {
			memList = boardDao.getAllBoardList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public BoardVO getBoard(int boardNum) {

		BoardVO boardVO = null;
		
		try {
			boardVO = boardDao.getBoard(smc, boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardVO;
	}

	@Override
	public int updateBoard(BoardVO mv) {

		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNum) {

		int cnt = 0;
		
		try {
			cnt = boardDao.deleteboard(smc, boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO mv) {

		List<BoardVO> memList = new ArrayList<>();
		
		try {
			memList = boardDao.getSearchBoard(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}
}
