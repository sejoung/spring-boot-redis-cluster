package com.github.sejoung.test;

import com.github.sejoung.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    public static Logger log = LoggerFactory.getLogger(TestController.class);

    private final StringRedisTemplate redisTemplate;

    private final RandomUtil randomUtil;

    private final String KEY = "TEST:";


    public TestController(StringRedisTemplate redisTemplate, RandomUtil randomUtil) {
        this.redisTemplate = redisTemplate;
        this.randomUtil = randomUtil;
    }

    @GetMapping("insert")
    public void insert() {

        redisTemplate.opsForValue().set(KEY + "1", "1");
        redisTemplate.opsForValue().set(KEY + "2", "2");
        redisTemplate.opsForValue().set(KEY + "3", "3");
        redisTemplate.opsForValue().set(KEY + "4", "4");
        redisTemplate.opsForValue().set(KEY + "5", "5");
        redisTemplate.opsForValue().set(KEY + "6", "6");

    }

    @GetMapping("select")
    public void select() {
        log.debug(redisTemplate.opsForValue().get(KEY + randomUtil.randomRange()));
    }

}
