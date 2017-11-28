package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.UserVO;

public class UserService extends AbstractService {
	
	public UserVO login(UserVO U) throws Exception{
		Connection con = null;
		try { 
			con = getConnection();
			
			UserDao dao = new UserDao(con);
			UserVO result = dao.searchUser(U);
			if(result == null) {
				throw new Exception("ID 혹은 Password가 옳지 않습니다.");
			}
			
			return result;
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<UserVO> searchUserList() throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			UserDao dao = new UserDao(con);
			return dao.searchUserList();
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}

	public void signup(UserVO user) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			UserDao dao = new UserDao(con);
			
			UserVO result = dao.searchUserById(user);
			if(result != null)
			{
				throw new Exception("이미 사용자가 존재합니다.");
			}
			dao.insertUser(user);
			
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void signout(UserVO user) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			UserDao dao = new UserDao(con);
			
			dao.deleteUser(user);
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void change(UserVO user) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			UserDao dao = new UserDao(con);
			dao.updateUser(user);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
}
