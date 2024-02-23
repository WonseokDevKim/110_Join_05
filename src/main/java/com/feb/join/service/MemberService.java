package com.feb.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.join.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	/**
	 * ID 중복 검사
	 * @param memberId 컨트롤러에서 받은 사용자가 입력한 ID
	 * @return ID와 일치하는 row 갯수
	 */
	public int confirmId(String memberId) {
		return memberDao.confirmId(memberId);
	}

}
