package com.xh.dao;

import java.util.List;

import com.xh.model.StudentModel;

public interface IStudentDao {
	
	public List<StudentModel> findAll();
	
	public int add(StudentModel model);
	
	public int addBatch(List<StudentModel> params);
	
	public int remove(Integer paramId);
	
	public int update(StudentModel model);
	
	public StudentModel findById(Integer paramId);

	public int findCount();
}
