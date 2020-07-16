package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImpl();
	@Override
	public Map<String, Object> insertMember(Map<String, Object> member) {
		int result = memberDAO.insertMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버등록 완료~");
		if(result!=1) {
			rMap.put("msg", "멤버등록 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateMember(Map<String, Object> member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(int mNum) {
		int result = memberDAO.deleteMember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버삭제 완료~");
		if(result!=1) {
			rMap.put("msg", "멤버삭제 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectMember(int mNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
//		Map<String,Object> rMap = memberService.deleteMember(21);
//		System.out.println(rMap);
		Map<String,Object> member = new HashMap<>();
		member.put("m_name", "차차");
		member.put("m_id", "chacha");
		member.put("m_pwd", "1234");
		Map<String,Object> rMap = memberService.insertMember(member);
		System.out.println(rMap);
	}
}






