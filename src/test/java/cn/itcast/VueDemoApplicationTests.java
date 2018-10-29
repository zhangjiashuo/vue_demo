package cn.itcast;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VueDemoApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	public void findAll() {
		List<User> users = userService.findAll();
		System.out.println(users);
	}


	@Test
	public void findOne() {
		User id = userService.findById(1);
		System.out.println(id);
	}

	@Test
	public void update() {
		User user = userService.findById(1);
		System.out.println("更改前的用户信息:"+user);

		user.setAge(20);
		userService.update(user);
		System.out.println("更改后的用户信息:"+user);
	}
}
