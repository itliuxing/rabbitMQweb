package edu.topicOpt;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel ;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import edu.common.CommonFactory;
import edu.common.Constants;

/**
 * @Class 	ProducerConfirm.java
 * @Author 	作者姓名:Liuxing
 * @Version	1.0
 * @Date	创建时间：2018年5月29日 下午20:59:36
 * @Copyright Copyright by Liuxing
 * @Direction 类说明		生产者--发送消息至RabbitMQ，vhost 下面的 EXCHANGE交换器下面的QUEUE
 */
public class TopicProducerConfirm {


    public static void main(String[] args) throws IOException, TimeoutException,
            InterruptedException {

    	//我再封装了一层，没办法 导出都要用，但是工厂其实只需要创建一份就好了
    	ConnectionFactory factory = CommonFactory.getConnectionFactory() ;

        Connection connection = factory.newConnection();	//创建连接
        
        Channel channel = connection.createChannel();		//连接创建信道

        //交换器 四种交换器，direct、fanout、topic、handles			//绑定哪个交换器
        //channel.exchangeDeclare( Constants.EXCHANGE_NAME , BuiltinExchangeType.DIRECT );
        
        //channel.queueDeclare( Constants.QUEUE_NAME, false, false, false, null);	//创建队列（就是所谓的路由键）

        for(int i=0;i<10;i++){
            String message = " email send info: memnoy "+(i+1) + " dollars.";
            //发布消息至RabbitMQ-->交换器的路由键上面去
            channel.basicPublish( Constants.TOPIC_EXCHANGE_NAME ,Constants.TopicRoutingKey , null ,message.getBytes() );
            System.out.println("Sent 数据至队列： "+message);

        }

        channel.close();
        connection.close();

    }

}
