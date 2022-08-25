package com.api.UserApi.Repository;

import com.api.UserApi.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
}
