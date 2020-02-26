package com.playtime.service.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playtime.domain.MemberDTO;
import com.playtime.persistence.MemberDAO;

@Service 
public class MemberServiceImpl implements MemberService {
		
		@Autowired
		private SqlSession sqlSession;
		
		private MemberDAO mDao;
		
		@Autowired
		public void newMemberDAO() {
			mDao = sqlSession.getMapper(MemberDAO.class);			
		}
		@Override
		public int idOverlap(String id) {
		return mDao.idOverlap(id);
		}
		@Override
		public int memInsert(MemberDTO mDto) {
			return mDao.memInsert(mDto);
		}

}
