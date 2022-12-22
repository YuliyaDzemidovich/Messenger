package example.ydzemidovich.messenger;

import example.ydzemidovich.messenger.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MessengerApplicationTests {

	@Autowired
	private HelloWorldController helloWorldController;

	/**
	 * Sanity test that Spring Boot can load its context
	 */
	@Test
	void contextLoads() {
		// assert the controller bean was autowired by Spring successfully
		assertNotNull(helloWorldController);
	}

}
