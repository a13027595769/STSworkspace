package cn.wolfcode.springboot._06import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate redisTemplate() {
		return new RedisTemplate();
	}

}
