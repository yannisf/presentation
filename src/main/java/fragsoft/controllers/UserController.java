package fragsoft.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fragsoft.annotations.ManagedBean;
import fragsoft.domain.Group;
import fragsoft.domain.User;

/**
 * Domain User/Group controller.
 */
@ManagedBean
public class UserController {

	public static final AtomicInteger USER_ID_SEQUENCE = new AtomicInteger(0);
	public static final AtomicInteger GROUP_ID_SEQUENCE = new AtomicInteger(0);

	public static final String USER_ID_PREFIX = "U";
	public static final String GROUP_ID_PREFIX = "G";

	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);

	private static final Integer ID_PADDING_SIZE = 3;
	private static final Character ID_PADDING_CHAR = '0';

	private User user;
	private Group group;
	private List<User> users;
	private List<Group> groups;

	private boolean userformRender;
	private boolean groupformRender;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<User>();
		}

		return users;
	}

	public List<Group> getGroups() {
		if (groups == null) {
			groups = new ArrayList<Group>();
		}

		return groups;
	}

	public boolean isUserformRender() {
		return userformRender;
	}

	public boolean isGroupformRender() {
		return groupformRender;
	}

	public String initializeUser() {
		cancelGroup();
		user = new User();
		userformRender = true;
		return null;
	}

	public String cancelUser() {
		user = null;
		userformRender = false;
		return null;
	}

	public String addUser() {
		String id = StringUtils.leftPad(String.valueOf(USER_ID_SEQUENCE
				.incrementAndGet()), ID_PADDING_SIZE, ID_PADDING_CHAR);
		String uid = USER_ID_PREFIX + id;
		user.setId(uid);
		LOG.debug("User ID generated: {}", uid);
		getUsers().add(getUser());
		userformRender = false;
		user = null;
		return null;
	}

	public String initializeGroup() {
		cancelUser();
		group = new Group();
		groupformRender = true;
		return null;
	}

	public String cancelGroup() {
		group = null;
		groupformRender = false;
		return null;
	}

	public String addGroup() {
		String id = StringUtils.leftPad(String.valueOf(GROUP_ID_SEQUENCE
				.incrementAndGet()), ID_PADDING_SIZE, ID_PADDING_CHAR);
		String gid = GROUP_ID_PREFIX + id;
		group.setId(gid);
		LOG.debug("Group ID generated: {}", gid);
		getGroups().add(getGroup());
		groupformRender = false;
		group = null;
		return null;
	}

}
