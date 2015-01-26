package com.blog.spring.jms;



import javax.jms.Queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
//		"classpath*:Spring/Spring_*.xml"
//		"classpath*:META-INF/context.xml",
//		"file:src/main/webapp/META-INF/context.xml",
//		"file:src/main/webapp/WEB-INF/config/spring-config.xml"
		"classpath*:/spring_*.xml"
		})
public class JMSTest {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void test(){
		private Queue testQueue_i;
		jmsTemplate_i.convertAndSend(testQueue_i, message_p);
	}
}
