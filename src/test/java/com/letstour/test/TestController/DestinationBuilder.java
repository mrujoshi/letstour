package com.letstour.test.TestController;
import org.springframework.test.util.ReflectionTestUtils;

import com.letstour.model.Destination;
public class DestinationBuilder {

	    private Destination model;

	    public DestinationBuilder() {
	        model = new Destination();
	    }

	    public DestinationBuilder id(int i) {
	        ReflectionTestUtils.setField(model, "destinationId", i);
	        return this;
	    }

	    public DestinationBuilder name(String name) {
	    	ReflectionTestUtils.setField(model, "name", name);
	        return this;
	    }

	    public Destination build() {
	        return model;
	    }
	
}
