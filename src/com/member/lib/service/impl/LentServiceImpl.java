package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {

	private LentDAO lentDAO = new LentDAOImpl();
	@Override
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.insertLent(lent);
		rMap.put("msg", (result==1)?"대여입력 성공":"대여입력 실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public int updateLent(Map<String, Object> lent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLent(int lNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		return lentDAO.selectLentList(lent);
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectNoLentBookList() {
		return lentDAO.selectNoLentBookList();
	}

}
