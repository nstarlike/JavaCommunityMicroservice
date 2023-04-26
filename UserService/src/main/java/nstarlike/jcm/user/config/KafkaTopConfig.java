package nstarlike.jcm.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaTopConfig {
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	@Bean
	public NewTopic newTopic() {
		return TopicBuilder.name(topicName).build();
	}
}
