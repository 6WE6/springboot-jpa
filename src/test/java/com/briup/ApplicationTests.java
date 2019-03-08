package com.briup;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.briup.bean.Car;
import com.briup.bean.Gender;
import com.briup.bean.User;
import com.briup.dao.CarDao;
import com.briup.dao.UserCarResultSet;
import com.briup.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test_curd() throws Exception {
//		User user = new User("woodcool",20,Gender.MAN);
//		userDao.save(user);
//		
//		User user1 = new User("woodcool1",21,Gender.MAN);
//		userDao.save(user1);
//		
//		User user2 = new User("woodcool2",22,Gender.MAN);
//		userDao.save(user2);
//		
//		System.out.println("-----------------------");
//		List<User> list = userDao.findAll();
//		list.stream().forEach(System.out::println);
		
		System.out.println("-----------------------");
		User findOne = userDao.findOne(2000L);
		System.out.println("更新前: "+findOne);
		
		findOne.setName("briup");
		userDao.save(findOne);
		System.out.println("更新后: "+findOne);
//		
//		System.out.println("-----------------------");
//		userDao.deleteAllInBatch();
	}
	
	@Test
	public void test_findByAge() throws Exception {
		List<User> list = userDao.findByAge(20);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test_findByName() throws Exception {
		User user = userDao.findByName("briup");
		System.out.println(user);
	}
	
	@Test
	public void test_findByNameOrAge() throws Exception {
		List<User> list = userDao.findByNameOrAge("briup", 20);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test_findByNameLike() throws Exception {
		List<User> list = userDao.findByNameLike("w%");
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test_findByNameIgnoreCase() throws Exception {
		User user = userDao.findByNameIgnoreCase("WOODCOOL");
		System.out.println(user);
	}
	
	@Test
	public void test_findByAgeOrderByNameDesc() throws Exception {
		List<User> list = userDao.findByAgeOrderByNameDesc(20);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test_sort() throws Exception {
		List<User> list = userDao.findAll(new Sort(Direction.DESC,"age"));
		list.stream().forEach(System.out::println);
	}
	

	@Test
	public void test_sort2() throws Exception {
		Sort sort = new Sort(Direction.ASC,"age");
		List<User> list = userDao.findByGender(Gender.MAN, sort);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test_pageable() throws Exception {
		int page = 0;//当前页数--从0开始计算
		int size = 2;//每页指定多少个元素
		Pageable pageable = new PageRequest(page,size);
		Page<User> pageObj = userDao.findAll(pageable);
		System.out.println("总共几页?\t\t"+pageObj.getTotalPages());
		System.out.println("总共多少元素?\t\t"+pageObj.getTotalElements());
		System.out.println("当前的页码?\t\t"+pageObj.getNumber());
		System.out.println("每页指定多少元素?\t\t"+pageObj.getSize());
		System.out.println("当前页实际多少元素?\t\t"+pageObj.getNumberOfElements());
		System.out.println("当前页是否有内容?\t\t"+pageObj.hasContent());
		System.out.println("当前页内容为?\t\t"+pageObj.getContent());
		System.out.println("分页查询的排序规则为\t\t"+pageObj.getSort());
		System.out.println("是否为第一页?\t\t"+pageObj.isFirst());
		System.out.println("是否为最后一页?\t\t"+pageObj.isLast());
		System.out.println("是否有上一页?\t\t"+pageObj.hasPrevious());
		System.out.println("是否有下一页?\t\t"+pageObj.hasNext());
		System.out.println("返回上一页Pageable对象为\t\t"+pageObj.previousPageable());
		System.out.println("返回下一页Pageable对象为\t\t"+pageObj.nextPageable());
		
		
		
	}
	
	
	@Test
	public void test_pageable2() throws Exception {
		int page = 0;//当前页数--从0开始计算
		int size = 2;//每页指定多少个元素
		Pageable pageable = new PageRequest(page,size);
		Page<User> pageObj = userDao.findByGender(Gender.MAN, pageable);
		System.out.println("总共几页?\t\t"+pageObj.getTotalPages());
		System.out.println("总共多少元素\t\t"+pageObj.getTotalElements());
		System.out.println("当前的页码\t\t"+pageObj.getNumber());
		System.out.println("每页指定多少元素\t\t"+pageObj.getSize());
		
	}
	
	
	@Test
	public void test_findTopByOrderByAgeDesc() throws Exception {
		User user = userDao.findTopByOrderByAgeDesc();
		System.out.println(user);
	}
	
	@Test
	public void test_findFirst2ByGender() throws Exception {
		List<User> list = userDao.findFirst2ByGender(Gender.MAN);
		list.stream().forEach(System.out::println);
	}
	
	
	@Test
	public void test_updateNameByUserId() throws Exception {
		userDao.updateNameByUserId("briup_test", 2001L);
	}
	
	@Test
	public void test_deleteByUserId() throws Exception {
		userDao.deleteByUserId(2001l);
	}
	
	@Test
	public void test_findByUserName() throws Exception {
		User user = userDao.findByUserName("briup_test");
		System.out.println(user);
	}
	
	@Test
	public void test_findByUserNameByNative() throws Exception {
		User user = userDao.findByUserNameByNative("briup_test");
		System.out.println(user);
	}
	
	@Autowired
	private CarDao carDao;
	@Test
	public void test_query1() throws Exception {
		//hibernate级联查询
		Car car = carDao.findOne(1L);
		System.out.println(car);
	}
	
	@Test
	public void test_query2() throws Exception {
		//自定义接口UserCarResultSet
		List<UserCarResultSet> list = carDao.findByCar();
		System.out.println(list);
	}
	
	@Test
	public void test_query3() throws Exception {
		List<Car> list = carDao.findByCar_test();
		System.out.println(list);
	}
	
	
}
