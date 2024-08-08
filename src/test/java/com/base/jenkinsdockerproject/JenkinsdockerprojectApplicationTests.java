package com.base.jenkinsdockerproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class JenkinsdockerprojectApplicationTests {

	 @MockBean
	    private ApplicationContext applicationContext;

	    @Test
	    void contextLoads() {
	    }

	    @Test
	    void testMainMethod() {
	        JenkinsdockerprojectApplication.main(new String[]{});
	    }
}
