package edu.common;

/**
* @Class 	Constants.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年5月29日 下午20:31:56
* @Copyright Copyright by 刘兴
* @Direction 类说明
*/
public class Constants {
	

	public final static String IP = "192.168.248.129" ;					//RabbitMQ ID
	public final static String USERNAME = "liuxing" ;					//账户名称
	public final static String PASSWORD = "liuxing" ;					//账户密码
	public final static Integer PORT = 5672  ;							//端口
    public final static String VHOST = "/liuxing" ;						//虚拟地址（要绑定账户）
    
    
    public final static String DIRECT_EXCHANGE_NAME = "direct_1";		//直连交换器
    public final static String TOPIC_EXCHANGE_NAME = "topic_1";			//匹配交换器
    public final static String DIRECT_QUEUE_NAME = "error";				//直连队列名称
    public final static String TOPIC_QUEUE_NAME_A = "topic_a";			//匹配队列名称A
    public final static String TOPIC_QUEUE_NAME_B = "topic_b";			//匹配队列名称B
    
    public static String DirectRoutingKey = "DirectRoutingKey1" ;		//路由键--直连

    public static String TopicRoutingKey = "com.email.info" ;			//路由键--匹配
    
}
