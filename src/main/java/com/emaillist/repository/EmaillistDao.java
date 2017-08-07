package com.emaillist.repository;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistDao {
	
	@Autowired
	private SqlSession sqlSession;//sql session에 연결이 됨
	
		
	
	public int insert(EmaillistVo vo) {
		
		
		return sqlSession.insert("emaillist.insert",vo);
	}

	public List<EmaillistVo> getList() {
		
		List<EmaillistVo> list=sqlSession.selectList("emaillist.getList");
		return list;
		
	}
	public EmaillistVo getByteNo(int no) {
		return sqlSession.selectOne("emaillist.getByteNo",no);
		
	}
	public List<EmaillistVo> getByMap(Map<String, Object> map) {
		return sqlSession.selectList("emaillist.getByMap",map);
			
	}

}
