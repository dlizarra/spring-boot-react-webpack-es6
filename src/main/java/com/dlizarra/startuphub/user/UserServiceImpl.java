package com.dlizarra.startuphub.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlizarra.startuphub.support.OrikaBeanMapper;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrikaBeanMapper mapper;

	@Override
	public List<UserDto> findAll() {
		final List<User> allUsers = userRepository.findAll();
		final List<UserDto> allUserDtos = new ArrayList<UserDto>();
		allUsers.forEach(x -> allUserDtos.add(mapper.map(x, UserDto.class)));

		return allUserDtos;
	}

	@Override
	public UserDto getUser(final Integer id) {
		return mapper.map(find(id), UserDto.class);
	}

	private User find(final Integer id) {
		final Optional<User> userOpt = userRepository.findOne(id);
		return userOpt.orElseThrow(() -> new UserNotFoundException(id));
	}

}
