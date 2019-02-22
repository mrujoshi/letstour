package com.letstour.test.TestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letstour.TestUtil;
import com.letstour.controller.DestinationController;
import com.letstour.model.Destination;
import com.letstour.service.DestinationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(DestinationController.class)
@AutoConfigureMockMvc

public class DestinationControllerTest {

    @MockBean
    DestinationService destinationServiceMock;
    
    @Autowired
    private MockMvc mockMvc;
    
    private List<Destination> getDestinationList() {
		Destination first = new DestinationBuilder()
                .id(1)
                .name("Pune")
                .build();
    	Destination second = new DestinationBuilder()
                .id(2)
                .name("Hydrabad")
                .build();
    	List<Destination> destList = Arrays.asList(first, second);
		return destList;
	}
    
    @Test public void testSattus() throws Exception {
    	this.mockMvc.perform(get("/destination")).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    //this test passes when all destinations are returned successfully.
    public void getDestinationTest() throws Exception {
    	List<Destination> destList = getDestinationList();
        when(destinationServiceMock.findAllDestination()).thenReturn(destList);
 
        mockMvc.perform(get("/destination"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Pune")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Hyderabad")));
 
        verify(destinationServiceMock, times(1)).findAllDestination();
        verifyNoMoreInteractions(destinationServiceMock);
    }
    
    @Test 
    public void getDestinationByIdTest() throws Exception{
    	List<Destination> destList = getDestinationList();
        when(destinationServiceMock.findDestination(1)).thenReturn(destList.get(0));
 
        mockMvc.perform(get("/destination/{id}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Pune")));
                
        verify(destinationServiceMock, times(1)).findDestination(1);
        verifyNoMoreInteractions(destinationServiceMock);
    }
    
    @Test
    public void findByIdWhenDestinationIsNotFound() throws Exception {
    	List<Destination> destList = getDestinationList();
        when(destinationServiceMock.findDestination(3)).thenReturn(null);
        mockMvc.perform(get("/destination/{id}", 3))
                .andExpect(status().isNotFound());
    }
    
    //test put
    @Test
    public void updateDestinationTest() throws Exception{
    	
    	
    }
    
    //test post
    
    @Test
    public void postDestinationTest() throws Exception{
    	Destination destination = new Destination();
    	destination.setId(1);
    	destination.setName("Pune");
    	
   	 when(destinationServiceMock.addDestination(destination)).thenReturn(destination);
    	mockMvc.perform(post("/destination/") .contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(destination)))
    	.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("Pune")));
        
    	verify(destinationServiceMock, times(1)).deleteDestination(1);
    	verifyNoMoreInteractions(destinationServiceMock);
    }
    
    //test delete
    @Test
    public void deleteDestinationTest() throws Exception{
    	List<Destination> destList = this.getDestinationList();
        when(destinationServiceMock.deleteDestination(1)).thenReturn(destList.get(0));
    	mockMvc.perform(delete("/destination/{id}", 1))
    	.andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(TestUtil.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("Pune")));
        
    	verify(destinationServiceMock, times(1)).deleteDestination(1);
    	verifyNoMoreInteractions(destinationServiceMock);
    }
}
