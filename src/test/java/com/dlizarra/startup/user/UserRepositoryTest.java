package com.dlizarra.startup.user;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.dlizarra.startup.support.AbstractWebIntegrationTest;
import com.dlizarra.startuphub.user.User;
import com.dlizarra.startuphub.user.UserRepository;

@Sql({ "classpath:/sql/reset-db.sql", "classpath:/sql/user.sql" })
public class UserRepositoryTest extends AbstractWebIntegrationTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void getProjectUserPositions_TwoEntitiesInDb_ShouldReturnTwoResults() {
		final User user = userRepository.findOne(1).get();
		Assert.assertEquals(2, user.getProjectUserPositions().size());
	}

}
