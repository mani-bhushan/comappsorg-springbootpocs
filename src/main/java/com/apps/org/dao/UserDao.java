package com.apps.org.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	public DAOUser findByUsername(String username);
}