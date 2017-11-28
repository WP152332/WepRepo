package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.UserVO;

public class UserDao {
	private Connection con = null;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public UserVO searchUser(UserVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.user where id=? and pwd=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			pstmt.setString(2, U.getPwd());
			rs = pstmt.executeQuery();
			
			UserVO result = null;
			
			if(rs.next()) {
				result =  new UserVO();
				result.setId(rs.getString(1));
				result.setPwd(rs.getString(2));
				result.setName(rs.getString(3));
				result.setIntro(rs.getString(4));
				result.setEtc(rs.getString(5));
			}

			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public UserVO searchUserById(UserVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from letstogether.user where id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			rs = pstmt.executeQuery();
			
			UserVO result = null;
			
			if(rs.next()) {
				result =  new UserVO();
				result.setId(rs.getString(1));
				result.setPwd(rs.getString(2));
				result.setName(rs.getString(3));
				result.setIntro(rs.getString(4));
				result.setEtc(rs.getString(5));
			}

			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}

	public List<UserVO> searchUserList() throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, name from letstogether.user";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			UserVO result = null;
			List<UserVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result =  new UserVO();
				result.setId(rs.getString(1));
				result.setPwd(rs.getString(2));
				result.setName(rs.getString(3));
				list.add(result);
			}

			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 목록 조회 시 오류 발생");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void insertUser(UserVO U) throws Exception {
		
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "insert into letstogether.user values(?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			pstmt.setString(2, U.getPwd());
			pstmt.setString(3, U.getName());
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			
			cnt = pstmt.executeUpdate();
			if(cnt == 0) throw new Exception("사용자 등록에 실패하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("회원가입 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void updateUser(UserVO U) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "update letstogether.user set pwd = ?, name = ?, intro = ?, etc = ? where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getPwd());
			pstmt.setString(2, U.getName());
			pstmt.setString(3, U.getIntro());
			pstmt.setString(4, U.getEtc());
			pstmt.setString(5, U.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 정보 변경 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void deleteUser(UserVO U) throws Exception {
		PreparedStatement pstmt = null;
		@SuppressWarnings("unused")
		int cnt = 0;
		
		String sql = "delete from letstogether.user where id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, U.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("회원탈퇴 시 오류 발생");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
}
