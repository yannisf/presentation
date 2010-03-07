package fragsoft.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserManager.class);
	
	private String name;
	
	public String getName() {
		LOG.info("getName");
		return name;
	}

	public void setName(String name) {
		LOG.info("setName");
		this.name = name;
	}
	
	public String register() {
		LOG.info("register");
		return "greet";
	}

	public String home() {
		LOG.info("home");
		return "home";
	}
	
}
