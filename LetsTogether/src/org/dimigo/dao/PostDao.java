package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.PostVO;

public class PostDao {
	private Connection con = null;
	
	public PostDao(Connection con) {
		this.con = con;
	}
	
	public PostVO searchPost(PostVO U) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.posting where id=? or posting=? or title=? or pk=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			pstmt.setString(2, U.getPosting());
			pstmt.setString(3, U.getTitle());
			pstmt.setString(4, String.valueOf(U.getPk()));
			rs = pstmt.executeQuery();
			
			PostVO result = null;
			
			if(rs.next()) {
				result =  new PostVO();
				result.setId(rs.getString(1));
				result.setPosting(rs.getString(2));
				result.setTitle(rs.getString(3));
				result.setDate(rs.getString(4));
				result.setPk(Integer.parseInt(rs.getString(5)));
			}

			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public PostVO searchPostByPk(String pk) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.posting where pk=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pk);
			rs = pstmt.executeQuery();
			
			PostVO result = null;
			
			if(rs.next()) {
				result =  new PostVO();
				result.setId(rs.getString(1));
				result.setPosting(rs.getString(2));
				result.setTitle(rs.getString(3));
				result.setDate(rs.getString(4));
				result.setPk(Integer.parseInt(rs.getString(5)));
			}

			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
		
	public List<PostVO> searchPostList() throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, posting, title, date, pk from letstogether.posting";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			PostVO result = null;
			List<PostVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new PostVO();
				result.setId(rs.getString(1));
				result.setPosting(rs.getString(2));
				result.setTitle(rs.getString(3));
				result.setDate(rs.getString(4));
				result.setPk(Integer.parseInt(rs.getString(5)));
				list.add(result);
			}

			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 목록 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void insertPost(PostVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "insert into letstogether.posting values(?, ?, ?, ?, 0)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			pstmt.setString(2, U.getPosting());
			pstmt.setString(3, U.getTitle());
			pstmt.setString(4, U.getDate());
			
			cnt = pstmt.executeUpdate();
			if(cnt == 0) throw new Exception("게시물 등록에 실패하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 작성 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void updatePost(PostVO U) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "update letstogether.posting set posting = ?, Title = ? where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getPosting());
			pstmt.setString(2, U.getTitle());
			pstmt.setString(3, U.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 내용 변경 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
}
