package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.ApplyVO;
import org.dimigo.vo.PostVO;
import org.dimigo.vo.UserVO;

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
				result.setResult(rs.getInt(4));
				result.setTitle(rs.getString(5));
				result.setPost(rs.getString(6));
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
	
	public void searchApplyAndUpPost(PostVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "update letstogether.apply set title = ?, post = ? where pk = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getTitle());
			pstmt.setString(2, U.getPosting());
			pstmt.setString(3, String.valueOf(U.getPk()));
			cnt = pstmt.executeUpdate();
			
			if(cnt == 0) throw new Exception("글 업데이트 에 실패하였습니다.");

		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("글 업데이트 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void searchApplyAndUpdate(ApplyVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "update letstogether.apply set result = ? where getapplyid=? and doapplyid=? and pk = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(U.getResult()));
			pstmt.setString(2, U.getGetapplyid());
			pstmt.setString(3, U.getDoapplyid());
			pstmt.setString(4, String.valueOf(U.getPk()));

			cnt = pstmt.executeUpdate();
			
			if(cnt == 0) throw new Exception("승인에 실패하였습니다.");

		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("승인 시 오류 발생");
		} finally {
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
				result.setResult(rs.getInt(4));
				result.setTitle(rs.getString(5));
				result.setPost(rs.getString(6));	
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
				result.setResult(rs.getInt(4));
				result.setTitle(rs.getString(5));
				result.setPost(rs.getString(6));
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

	public List<ApplyVO> searchApplyListByDoapplyid(String j) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.apply where doapplyid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, j);
			rs = pstmt.executeQuery();
			
			
			ApplyVO result = null;
			List<ApplyVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new ApplyVO();
				result.setGetapplyid(rs.getString(1));
				result.setDoapplyid(rs.getString(2));
				result.setPk(Integer.parseInt(rs.getString(3)));
				result.setResult(rs.getInt(4));
				result.setTitle(rs.getString(5));
				result.setPost(rs.getString(6));
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

	public List<ApplyVO> searchApplyListByGetapplyid(String j) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.apply where getapplyid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, j);
			rs = pstmt.executeQuery();
			
			
			ApplyVO result = null;
			List<ApplyVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new ApplyVO();
				result.setGetapplyid(rs.getString(1));
				result.setDoapplyid(rs.getString(2));
				result.setPk(Integer.parseInt(rs.getString(3)));
				result.setResult(rs.getInt(4));
				result.setTitle(rs.getString(5));
				result.setPost(rs.getString(6));
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
		
		String sql = "insert into letstogether.apply values(?, ?, ?, 0, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getGetapplyid());
			pstmt.setString(2, U.getDoapplyid());
			pstmt.setString(3, String.valueOf(U.getPk()));
			pstmt.setString(4, U.getTitle());
			pstmt.setString(5, U.getPost());
			
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
	
	public void deleteApplyForPost(int pk) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "delete from letstogether.apply where pk=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pk);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("글 삭제로 인한 취소 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void deleteApplyForSignout(UserVO U) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "delete from letstogether.apply where getapplyid=? or doapplyid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			pstmt.setString(2, U.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("회원가입으로 인한 취소 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
}
