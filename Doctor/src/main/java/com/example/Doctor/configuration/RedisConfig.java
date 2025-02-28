package com.example.Doctor.configuration;

import com.example.Doctor.model.DoctorResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //craete the connectionfactory
    //redis template

    private RedisConnectionFactory getConnectionFactory() {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost", Integer.parseInt("6379"));
        //configuration.setPassword(RedisPassword.of(authKey));
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().build();
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    RedisTemplate<String, DoctorResponse> identityRedisTemplate() {
        final RedisTemplate<String, DoctorResponse> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getConnectionFactory());
        setSerializer(redisTemplate);
        return redisTemplate;
    }

    private <K,V> void setSerializer(RedisTemplate<K,V> redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
    }
}
