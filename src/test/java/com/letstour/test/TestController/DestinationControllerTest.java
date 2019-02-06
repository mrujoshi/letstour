package com.letstour.test.TestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.letstour.TestUtil;
import com.letstour.model.Destination;
import com.letstour.service.DestinationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DestinationControllerTest {
	
	@LocalServerPort
    private int port;

    @Mock
    DestinationService destinationServiceMock;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    //this test passes when all destinations are returned successfully.
    public void getDestinationTest() throws Exception {
    	Destination first = new DestinationBuilder()
                .id(1)
                .name("Pune")
                .build();
    	Destination second = new DestinationBuilder()
                .id(2)
                .name("Hydrabad")
                .build();
    	List<Destination> destList = Arrays.asList(first, second);
        when(destinationServiceMock.findAllDestination()).thenReturn(destList);
 
        mockMvc.perform(get("/destination"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Pune")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Hydrabad")));
 
        verify(destinationServiceMock, times(1)).findAllDestination();
        verifyNoMoreInteractions(destinationServiceMock);
    }
	
}
