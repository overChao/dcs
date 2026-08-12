package com.crodi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 17:19
 * @Description: TODO
 **/

@Slf4j
@Component
@RequiredArgsConstructor
public class WcsRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("WcsRunner run");

    }
}
