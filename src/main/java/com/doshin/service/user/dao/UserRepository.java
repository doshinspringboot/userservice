package com.doshin.service.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.doshin.service.user.dao.model.UserDO;

public interface UserRepository extends CrudRepository<UserDO, Integer>{

}
