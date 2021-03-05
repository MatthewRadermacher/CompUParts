package com.matthewradermacher.compuparts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.matthewradermacher.compuparts.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Override
	public List<User> findAll();
}
