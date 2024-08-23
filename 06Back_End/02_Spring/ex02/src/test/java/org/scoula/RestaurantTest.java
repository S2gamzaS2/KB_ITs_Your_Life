package org.scoula;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //Spring Test다
@ContextConfiguration(classes = {RootConfig.class}) //설정파일
@Log4j //로그 출력을 위함, log 멤버 변수 자동 생성
class RestaurantTest {
    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef() {
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("--------------------");
        log.info(restaurant.getChef());
    }
}