package com.dlizarra.startuphub.user;

import java.util.List;

public interface UserService {

	List<UserDto> findAll();

	UserDto getUser(Integer id);

}
