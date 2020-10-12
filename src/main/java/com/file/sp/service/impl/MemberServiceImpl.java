package com.file.sp.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.sp.dao.MemberDAO;
import com.file.sp.service.MemberService;
import com.file.sp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private String savePath = "C:/java_study/workspace/sp-file/src/main/webapp/resources/";
	@Autowired 
	private MemberDAO memberDAO;
	@Override
	public int insertMember(MemberVO member) {
		MultipartFile mf = member.getFile1();
		File f = null;
		if(mf!=null) {
			String extName = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
			String fileName = savePath + System.nanoTime()+extName;
			try {
				f = new File(fileName);
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		int result = memberDAO.insertMember(member);
		if(result!=1 && f!=null) {
			f.delete();
		}
		return result;
	}

}
