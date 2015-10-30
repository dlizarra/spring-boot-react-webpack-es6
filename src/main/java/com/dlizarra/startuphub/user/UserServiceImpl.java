package com.dlizarra.startuphub.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrikaBeanMapper mapper;

	@Transactional(readOnly = true)
	@Override
	public List<UserDto> findAll() {
		final List<User> allUsers = userRepository.findAll();
		final List<UserDto> allUserDtos = new ArrayList<UserDto>();
		allUsers.forEach(x -> allUserDtos.add(mapper.map(x, UserDto.class)));

		return allUserDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDto getUser(final Integer id) {
		return mapper.map(find(id), UserDto.class);
	}

	private User find(final Integer id) {
		final Optional<User> userOpt = userRepository.findOne(id);
		return userOpt.orElseThrow(() -> new UserNotFoundException(id));
	}

}
