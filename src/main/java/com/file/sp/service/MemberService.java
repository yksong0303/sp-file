package com.file.sp.service;

import org.springframework.stereotype.Service;

import com.file.sp.vo.MemberVO;

@Service
public interface MemberService {
	public int insertMember(MemberVO upload);
}
