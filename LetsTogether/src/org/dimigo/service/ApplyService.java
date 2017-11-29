package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.ApplyDao;
import org.dimigo.vo.ApplyVO;

public class ApplyService extends AbstractService {
	
	public ApplyVO searchApply(ApplyVO U) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			return dao.searchApply(U);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void searchApplyAndUpdate(ApplyVO U) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			dao.searchApplyAndUpdate(U);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<ApplyVO> searchApplyList() throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			return dao.searchApplyList();
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<ApplyVO> searchApplyListBy(String w, String j) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			return dao.searchApplyListBy(w, j);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<ApplyVO> searchApplyListByDoapplyid(String j) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			return dao.searchApplyListByDoapplyid(j);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<ApplyVO> searchApplyListByGetapplyid(String j) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			return dao.searchApplyListByGetapplyid(j);
			
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void doapply(ApplyVO user) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			ApplyDao dao = new ApplyDao(con);
			if(dao.searchApply(user) != null) {
				throw new Exception("이미 신청하였습니다.");
			}
			dao.insertApply(user);
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deleteApply(ApplyVO user) throws Exception {
		Connection con = null;
		try { 
			con = getConnection();
			
			ApplyDao dao = new ApplyDao(con);
			if(dao.searchApply(user) == null) {
				throw new Exception("아직 신청하지 않았습니다.");
			}
			dao.deleteApply(user);
		} finally {
			if(con != null) {
				con.close();
			}
		}
	}

}
