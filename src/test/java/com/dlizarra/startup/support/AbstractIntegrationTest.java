package com.dlizarra.startup.support;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.startuphub.AppConfig;
import com.dlizarra.startuphub.DatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class, DatabaseConfig.class })
@Transactional
@IntegrationTest
public abstract class AbstractIntegrationTest {

}
