package com.dlizarra.startuphub;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.position.PositionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class, DatabaseConfig.class })
@WebAppConfiguration
@ActiveProfiles("default")
@IntegrationTest
// @Category
public class DemoApplicationTests {

	@Autowired
	private PositionRepository positionRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPositionRepository() {
		final Position p = positionRepository.findOne(1);
		Assert.assertEquals("Creator", p.getName());
	}

}
