package com.xyz.vehicle.monitoring.config;

import ai.grakn.redismock.RedisServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
//@Configuration
//@ConditionalOnProperty(prefix = "app.redis", name = "embedded", havingValue = "true")
public class RedisTestConfiguration {


    @Value("${app.redis.host:localhost}")
    private String host;

    private RedisServer redisServer;


    @PostConstruct
    public void afterPropertiesSet() {
        try {
            final int port = getDynamicPort();
            redisServer = RedisServer.newRedisServer(port);
            redisServer.start();
            log.info("Starting local embedded redis server successfully, port is " + port);
        } catch (IOException ex) {
            throw new FatalBeanException("Failed to start local embedded redis server ", ex);
        }
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(redisServer.getBindPort());
        redisStandaloneConfiguration.setDatabase(0);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<Long, Object> redisTemplate() {
        RedisTemplate<Long, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }


    @PreDestroy
    public void destroy() {
        if (redisServer != null) {
            redisServer.stop();
            redisServer = null;
        }
    }


    private static int getDynamicPort() {
        ServerSocket socket = null;
        int port;
        try {
            socket = new ServerSocket(0);
            port = socket.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                log.error("{}", e);
            }
        }
        return port;
    }


}
