package com.file.sp.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.file.sp.dao.MemberDAO;
import com.file.sp.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionFactory ssf;
	@Override
	public int insertMember(MemberVO member) {
		try(SqlSession ss = ssf.openSession()){
			return ss.insert("Member.insertMember",member);
		}
		
	}

}
