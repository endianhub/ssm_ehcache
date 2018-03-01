package com.xh.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xh.model.StudentModel;
import com.xh.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentTest {

	@Resource
	private StudentService service;

	@Test
	public void findAll() {
		for (int i = 0; i < 200; i++) {
			long start = System.currentTimeMillis();
			List<StudentModel> list = service.findAll();
			long end = System.currentTimeMillis();
			long time = (end - start);
			System.out.println();
			System.out.println();
			System.out.println(i + "===================" + time + "=======================" + list.size());
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void add() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			StudentModel model = new StudentModel("student_" + i, 12, 1, 20.0);
			int result = service.add(model);
			System.out.println(result);
		}
		long end = System.currentTimeMillis();
		long time = (end - start);
		System.out.println("======数据处理总时间：" + time + "=======================");
	}

	@Test
	public void addBatch() {
		long start = System.currentTimeMillis();
		List<StudentModel> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(new StudentModel("student_" + i, 12, 1, 20.0));
		}
		long s = System.currentTimeMillis();
		int result = service.addBatch(list);
		long e = System.currentTimeMillis();
		long t = (e - s);

		long end = System.currentTimeMillis();
		long time = (end - start);
		System.out.println("======数据存储时间：" + t + "=============数据处理总时间：" + time + "=======================" + result);
	}

	@Test
	public void findCount() {
		int count = service.findCount();
		System.out.println("数据总记录数：" + count);
	}
}
