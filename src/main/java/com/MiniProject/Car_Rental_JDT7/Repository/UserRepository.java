package com.MiniProject.Car_Rental_JDT7.Repository;

import org.springframework.data.repository.CrudRepository;

import com.MiniProject.Car_Rental_JDT7.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsernameAndPassword(String username_customer, String password_customer);
}
