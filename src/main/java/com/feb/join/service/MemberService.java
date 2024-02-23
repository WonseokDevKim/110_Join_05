package com.feb.join.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.join.dao.MemberDao;
import com.feb.join.util.Sha512Encoder;

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
	
	/**
	 * 회원 가입
	 * 비밀 번호 암호화
	 * @param params 사용자가 입력한 회원가입정보
	 * @return int 가입 성공 시 1
	 */
	public int signUp(HashMap<String, String> params) {
		// 사용자가 입력한 비밀번호(평문) 암호화해서 Dao로 전송
		String passwd = params.get("passwd");
		String encodeTxt = Sha512Encoder.getInstance().getSecurePassword(passwd);
		params.put("passwd", encodeTxt);
		
		return memberDao.signUp(params);
	}
}
