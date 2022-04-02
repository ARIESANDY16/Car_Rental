package com.MiniProject.Car_Rental_JDT7.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.MiniProject.Car_Rental_JDT7.Model.User;
import com.MiniProject.Car_Rental_JDT7.Repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveMyUser(User user){
		userRepository.save(user);

		}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user:userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	public void deleteMyUser(int id_customer) {
		userRepository.deleteById(id_customer);
	}
	public User editUser(int id_customer) {
		return userRepository.findById(id_customer).orElse(null);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
