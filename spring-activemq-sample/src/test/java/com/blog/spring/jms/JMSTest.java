package com.blog.spring.jms;



import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
//		"classpath*:Spring/Spring_*.xml"
//		"classpath*:META-INF/context.xml",
//		"file:src/main/webapp/META-INF/context.xml",
//		"file:src/main/webapp/WEB-INF/config/spring-config.xml"
		"classpath*:/spring-*.xml"
		})
public class JMSTest {
	@Autowired
//	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue testQueueTwo;
	

	private Log log = LogFactory.getLog(this.getClass());
	
	@Test
	@Repeat(100)
	public void testSendJMS(){
		log.info("testSendJMS");
		jmsTemplate.convertAndSend(testQueueTwo, "Hahahah" + new Date() );
	}
	
	@Test
	@Repeat(100)
	public void testRecieveJMS() throws JMSException{
		jmsTemplate.setDefaultDestination(testQueueTwo);
		jmsTemplate.setReceiveTimeout(500);
		Message msg = jmsTemplate.receive();
		if (msg instanceof TextMessage){
			TextMessage tm = (TextMessage) msg;
			System.out.println(tm.getText() );
		}else{
			System.out.println();
		}
		
	}
}
