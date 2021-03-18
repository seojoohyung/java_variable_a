package src.Kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.Kr.or.ddit.member.vo.MemberVO;
import src.Kr.or.ddit.util.JDBCUtil2;



public class MemberDaoImpl implements iMemberDao{

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertMember(Connection conn, MemberVO mv) throws SQLException {
		int cnt = 0 ;
		try {
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr)"
					+"values (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mv.getMemId());
		pstmt.setString(2, mv.getMemName());
		pstmt.setString(3, mv.getMemTel());
		pstmt.setString(4, mv.getMemAddr());
		
		cnt = pstmt.executeUpdate();
		}finally {
			JDBCUtil2.disConnect(null, null, pstmt, null);
		}
		
		
		return cnt;
	}

	@Override
	public boolean checkMember(Connection conn, String memId) throws SQLException {
		
		boolean chk = false;
		try {

			String sql ="select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();
			
			int cnt = 0;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true;
			}
		}finally {
			JDBCUtil2.disConnect(null, null, pstmt, rs);
		}
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList(Connection conn) throws SQLException {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from mymember");
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");	
			
				mv.setMemId(memId);
				mv.setMemName(memName);
				mv.setMemTel(memTel);
				mv.setMemAddr(memAddr);
				
				memList.add(mv);
			}	
		}finally {
		JDBCUtil2.disConnect(null, stmt, null, rs);
	}
		
		return memList;
	}

	@Override
	public int updateMember(Connection conn, MemberVO mv) throws SQLException {
		int cnt = 0;	
		try {
			String sql = "update mymember" 
			          + " set mem_name = ?" 
					  + "    ,mem_tel = ?" 
			          + "    ,mem_addr= ?" 
					  + "where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());
			
			cnt = pstmt.executeUpdate();	
		}finally {
			JDBCUtil2.disConnect(null, stmt, null, rs);
		}
		return cnt;
	}

	@Override
	public int deleteMember(Connection conn, String memId) throws SQLException {
		int cnt = 0;
		try {
		
			String sql = "delete from mymember where mem_id=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
		}finally {
			JDBCUtil2.disConnect(null, null, pstmt, null);
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(Connection conn, MemberVO mv) throws SQLException {
		List<MemberVO> memList = new ArrayList<>();

		try {
			String sql = "select * from mymember where 1=1";
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				sql += " and mem_id = ?";
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				sql += " and mem_name = ?";
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ?";
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				sql += " and mem_addr like '%' || ? || '%' ";
			}

			pstmt = conn.prepareStatement(sql);

			int index = 1;

			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				pstmt.setString(index++, mv.getMemId());
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv2);
			}

		} finally {
			JDBCUtil2.disConnect(null, null, pstmt, rs);
		}
		return memList;
	}
}
		
	


