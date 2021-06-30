package com.example.KCbootcampapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
class KcBootcampApplicationTests{
	@Test
	void test01_contextLoads(){

	}


}
