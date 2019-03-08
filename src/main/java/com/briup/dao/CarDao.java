package com.briup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.Car;

public interface CarDao extends JpaRepository<Car, Long>{
	
	@Query("select u.id as id,u.name as userName,c.name as carName,c.price as carPrice,c.color as carColor from Car c left outer join c.user u")
//	@Query(value="select u.id as id,u.name as userName,c.name as carName,c.price as carPrice,c.color as carColor from t_user u left outer join t_car c on u.id=c.user_id",nativeQuery=true)
	List<UserCarResultSet> findByCar();
	
	@Query("select c from Car c left outer join c.user u")
	List<Car> findByCar_test();
	
}
