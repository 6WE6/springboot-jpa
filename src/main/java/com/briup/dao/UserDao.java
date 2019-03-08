package com.briup.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Gender;
import com.briup.bean.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findByName(String name);
	List<User> findByAge(int age);
	List<User> findByNameOrAge(String name, int age);
	
	
	List<User> findByNameLike(String name);
	User findByNameIgnoreCase(String name);
	List<User> findByAgeOrderByNameDesc(int age);
	
	List<User> findByGender(Gender gender,Sort sort);
	
	Page<User> findByGender(Gender gender,Pageable pageable);
	
	User findFirstByOrderByAgeAsc();
	User findFirstByOrderByAgeDesc();
	
	User findTopByOrderByAgeAsc();
	User findTopByOrderByAgeDesc();
	
	
	List<User> findFirst2ByGender(Gender gender);
	
	Page<User> findFirst25ByGender(Gender gender, Pageable pageable);
	List<User> findTop25ByGender(Gender gender, Pageable pageable);

	List<User> findFirst25ByGender(Gender gender, Sort sort);

	
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.id = ?2")
	int updateNameByUserId(String  name, Long id);
		
	@Transactional(timeout = 10)
	@Modifying
	@Query("delete from User u where u.id = ?1")
	void deleteByUserId(Long id);
	  
	@Query("select u from User u where u.name = ?1")
	User findByUserName(String name);
	
	@Query(value="select * from t_user where name = ?1",nativeQuery=true)
	User findByUserNameByNative(String name);
	
}
