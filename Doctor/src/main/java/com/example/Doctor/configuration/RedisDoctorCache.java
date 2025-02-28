package com.example.Doctor.configuration;

import com.example.Doctor.model.DoctorResponse;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisDoctorCache {

    private HashOperations<String,String, DoctorResponse> hashOperations;

    RedisTemplate<String,DoctorResponse> redisTemplate ;
    public RedisDoctorCache(RedisTemplate<String,DoctorResponse> redisTemplate){

        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void put(String key,DoctorResponse value) {
        hashOperations.put("doctor",key,value);
        redisTemplate.expire("doctor", 1, TimeUnit.MINUTES);
    }

    public DoctorResponse get(String key) {
        return hashOperations.get("doctor",key);
    }

    public boolean checkData(String key){

       DoctorResponse response1 =  hashOperations.get("doctor",key);

       if(response1 !=null)
           return true;
       else return false;
    }

}
