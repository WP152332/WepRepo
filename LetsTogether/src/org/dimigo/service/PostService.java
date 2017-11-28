package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.PostDao;
import org.dimigo.vo.PostVO;

public class PostService extends AbstractService {
	
	public List<PostVO> searchPostList() throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			return dao.searchPostList();
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public PostVO searchPostByPk(String pk) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			return dao.searchPostByPk(pk);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}

	
	public void posting(PostVO Post) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			dao.insertPost(Post);			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void change(PostVO Post) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			dao.updatePost(Post);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
}
