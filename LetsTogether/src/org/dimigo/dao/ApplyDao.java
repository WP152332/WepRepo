package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.ApplyVO;

public class ApplyDao {
	private Connection con = null;
	
	public ApplyDao(Connection con) {
		this.con = con;
	}
	
	public ApplyVO searchApply(ApplyVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.apply where getapplyid=? and doapplyid=? and pk = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getGetapplyid());
			pstmt.setString(2, U.getDoapplyid());
			pstmt.setString(3, String.valueOf(U.getPk()));
			rs = pstmt.executeQuery();
			
			ApplyVO result = null;
			
			if(rs.next()) {
				result =  new ApplyVO();
				result.setGetapplyid(rs.getString(1));
				result.setDoapplyid(rs.getString(2));
				result.setPk(Integer.parseInt(rs.getString(3)));
			}

			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("신청 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public List<ApplyVO> searchApplyList() throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.apply";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ApplyVO result = null;
			List<ApplyVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new ApplyVO();
				result.setGetapplyid(rs.getString(1));
				result.setDoapplyid(rs.getString(2));
				result.setPk(Integer.parseInt(rs.getString(3)));
				list.add(result);
			}

			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("신청 목록 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}

	public List<ApplyVO> searchApplyListBy(String w, String j) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.apply where ?=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, w);
			pstmt.setString(2, j);
			rs = pstmt.executeQuery();
			
			
			ApplyVO result = null;
			List<ApplyVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new ApplyVO();
				result.setGetapplyid(rs.getString(1));
				result.setDoapplyid(rs.getString(2));
				result.setPk(Integer.parseInt(rs.getString(3)));
				list.add(result);
			}

			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("신청 목록 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void insertApply(ApplyVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "insert into letstogether.apply values(?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getGetapplyid());
			pstmt.setString(2, U.getDoapplyid());
			pstmt.setString(3, String.valueOf(U.getPk()));
			
			cnt = pstmt.executeUpdate();
			if(cnt == 0) throw new Exception("신청에 실패하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("신청 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void deleteApply(ApplyVO U) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "delete from letstogether.apply where getapplyid=? and doapplyid=? and pk=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getGetapplyid());
			pstmt.setString(2, U.getDoapplyid());
			pstmt.setString(3, String.valueOf(U.getPk()));
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("신청 취소 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
}
