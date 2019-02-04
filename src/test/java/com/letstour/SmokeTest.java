package com.letstour;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.letstour.controller.DestinationController;
import com.letstour.controller.IternaryController;
import com.letstour.controller.TourController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired DestinationController destinationController;
	@Autowired TourController tourController;
	@Autowired IternaryController iternaryController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(destinationController).isNotNull();
		assertThat(tourController).isNotNull();
		assertThat(iternaryController).isNotNull();
	}
	
}
