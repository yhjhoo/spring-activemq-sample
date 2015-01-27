# spring-activemq-sample

This example is using apache activeMQ as the message queue, in order to use this example, Please setup activeMQ first:

http://activemq.apache.org


After setup activeMQ, you have to change brokerURL inside spring-config.xml

brokerURL   tcp://192.168.0.106:61616



Maven Junit Test
To run send JMS from maven command line: 
$mvn -Dtest=JMSTest#testSendJMS test


To run receive JMS from maven command line: 
$mvn -Dtest=JMSTest#testRecieveJMS test
