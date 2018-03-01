package com.xh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xh.dao.IStudentDao;
import com.xh.model.StudentModel;

@Service
public class StudentService {

	@Resource
	private IStudentDao studentDao;

	public List<StudentModel> findAll() {

		return studentDao.findAll();
	}

	public StudentModel findById(Integer paramId) {

		return studentDao.findById(paramId);
	}

	public int add(StudentModel param) {

		return studentDao.add(param);
	}
	
	public int addBatch(List<StudentModel> params) {
		
		return studentDao.addBatch(params);
	}

	public int remove(Integer paramId) {

		return studentDao.remove(paramId);
	}

	public int update(StudentModel param) {

		return studentDao.update(param);
	}

	public int findCount() {

		return studentDao.findCount();
	}
}
