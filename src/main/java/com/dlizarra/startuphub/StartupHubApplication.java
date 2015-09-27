package com.dlizarra.startuphub;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;

public class StartupHubApplication extends SpringApplication {
	
	public StartupHubApplication (Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {		
		super.configureProfiles(environment, args);
		
		boolean standaloneActive = environment.acceptsProfiles(StartupHubProfiles.STANDALONE);
		boolean stagingActive = environment.acceptsProfiles(StartupHubProfiles.STAGING);
		boolean productionActive = environment.acceptsProfiles(StartupHubProfiles.PRODUCTION);		
        
        if (stagingActive && productionActive) {
            throw new IllegalStateException("Cannot active staging and production profiles at the same time");
        } else if (productionActive || stagingActive) {
        	System.out.println("Activating " + (productionActive ? 
        			StartupHubProfiles.PRODUCTION : StartupHubProfiles.STAGING)  + " profile");
        } else if (standaloneActive) {
            System.out.println("The default 'standalone' profile is active because no other profiles have been specified or "
            		+ "you specified the default profile explicitly. If you specified "
            		+ "another active profile in application.yml file it it will be activated instead of default.");
        } else {
            throw new IllegalStateException("Unknown profiles specified. Please specify one of default, staging or production.");
        }
	}

	

}
