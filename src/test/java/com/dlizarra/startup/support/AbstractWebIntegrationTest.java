package com.dlizarra.startup.support;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.AppConfig;
import com.dlizarra.startuphub.DatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class, DatabaseConfig.class })
@Transactional
@WebIntegrationTest
public abstract class AbstractWebIntegrationTest {

}
