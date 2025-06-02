package com.dfg.java_template.framework.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // Key 用 String 序列化
        template.setKeySerializer(new StringRedisSerializer());
        // Value 用 JSON 序列化（需引入 Jackson）
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
