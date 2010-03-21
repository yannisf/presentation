package fragsoft.controllers.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fragsoft.controllers.UserController;

public class UserControllerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserControllerTest.class);

	private final UserController controller = new UserController();
	
	@BeforeClass
	public void initialize() {
		LOG.info("Initializing Controller");
		Assert.assertFalse(controller.isUserformRender());
		Assert.assertFalse(controller.isGroupformRender());
		Assert.assertNull(controller.getUser());
		Assert.assertNull(controller.getGroup());
	}
	
	@Test
	public void testUserInitialize() {
		LOG.info("Initializing User");
		controller.initializeUser();
		Assert.assertTrue(controller.isUserformRender());
		Assert.assertFalse(controller.isGroupformRender());
		Assert.assertNotNull(controller.getUser());
	}
	
	@Test(dependsOnMethods={"testUserInitialize"})
	public void testAddUser() {
		LOG.info("Adding User");
		controller.getUser().setUsername("test user");
		controller.addUser();
		Assert.assertFalse(controller.getUsers().isEmpty());
		Assert.assertNull(controller.getUser());
		Assert.assertFalse(controller.isUserformRender());
		Assert.assertFalse(controller.isGroupformRender());
	}

	@Test
	public void testGroupInitialize() {
		LOG.info("Initializing Group");
		controller.initializeGroup();
		Assert.assertTrue(controller.isGroupformRender());
		Assert.assertFalse(controller.isUserformRender());
		Assert.assertNotNull(controller.getGroup());
	}
	
	@Test(dependsOnMethods={"testGroupInitialize"})
	public void testAddGroup() {
		LOG.info("Adding Group");
		controller.getGroup().setName("test group");
		controller.addGroup();
		Assert.assertFalse(controller.getGroups().isEmpty());
		Assert.assertNull(controller.getGroup());
		Assert.assertFalse(controller.isUserformRender());
		Assert.assertFalse(controller.isGroupformRender());
	}
	
}
