package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.ApplyDao;
import org.dimigo.dao.PostDao;
import org.dimigo.vo.PostVO;
import org.dimigo.vo.UserVO;

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
			
			PostDao pdao = new PostDao(con);
			ApplyDao adao = new ApplyDao(con);
			
			pdao.updatePost(Post);
			adao.searchApplyAndUpPost(Post);
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deletePosting(PostVO Post) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao pdao = new PostDao(con);
			ApplyDao adao = new ApplyDao(con);
			
			adao.deleteApplyForPost(Post.getPk());
			pdao.deletePosting(Post);
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}

	public List<PostVO> searchPostByApply(UserVO U) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			
			return dao.searchPostByDoapplyid(U);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<PostVO> searchPostByAdmission(UserVO U) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			PostDao dao = new PostDao(con);
			
			return dao.searchPostByGetapplyid(U);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
}
