/**
 * 
 */
package org.spring.springboot.kafka.storm.bolt;

import com.alibaba.fastjson.JSON;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.kafka.constant.Constants;
import org.spring.springboot.kafka.pojo.User;
import org.spring.springboot.kafka.service.UserService;
import org.spring.springboot.kafka.util.GetSpringBean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Title: InsertBolt
 * @Description: 
 * 写入数据的bolt
 * @Version:1.0.0  
 * @author mongoding
 * @date 2018年4月19日
 */
public class InsertBolt extends BaseRichBolt{

		/**
		 * 
		 */
		private static final long serialVersionUID = 6542256546124282695L;

		
		private static final Logger logger = LoggerFactory.getLogger(InsertBolt.class);

		
		private UserService userService;
		
		
		@SuppressWarnings("rawtypes")
		@Override
		public void prepare(Map map, TopologyContext arg1, OutputCollector collector) {
			userService=GetSpringBean.getBean(UserService.class);
		}
	  
		   
		@Override
		public void execute(Tuple tuple) {
			String msg=tuple.getStringByField(Constants.FIELD);
			try{
				List<User> listUser =JSON.parseArray(msg,User.class);
				//移除age小于10的数据
				if(listUser!=null&&listUser.size()>0){
					Iterator<User> iterator = listUser.iterator();
					 while (iterator.hasNext()) {
						 User user = iterator.next();
						 if (user.getAge()<10) {
							 logger.warn("Bolt移除的数据:{}",user);
							 iterator.remove();
						 }
					 }
					if(listUser!=null&&listUser.size()>0){
						userService.insertBatch(listUser);
					}
				}
			}catch(Exception e){
				logger.error("Bolt的数据处理失败!数据:{}",msg,e);
			}
		}

		
		/**
	     * cleanup是IBolt接口中定义,用于释放bolt占用的资源。
	     * Storm在终止一个bolt之前会调用这个方法。
		 */
		@Override
		public void cleanup() {
		}

		@Override
		public void declareOutputFields(OutputFieldsDeclarer arg0) {
				
		}
		
	
}
