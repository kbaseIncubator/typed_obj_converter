package us.kbase.toc.test;


//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import us.kbase.common.service.UObject;
import us.kbase.kbasetypedobjconverter.Operation;
import us.kbase.kbasetypedobjconverter.SimpleConverter;
import us.kbase.toc.JoltConverterHandler;

import com.bazaarvoice.jolt.Chainr;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BasicJoltTest {
	
	
	@BeforeClass
	public static void setUpClass() throws Exception {
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void runJolt() throws Exception {
		
		// create example input data
		JsonFactory factory = new JsonFactory(); 
		ObjectMapper mapper = new ObjectMapper(factory); 
		String input = "{" +
		"    \"rating\": {"+
		"        \"primary\": {"+
		"            \"value\": 3"+
		"        },"+
		"        \"quality\": {"+
		"            \"value\": 3"+
		"        }"+
		"    }"+
		"}";
		TypeReference<HashMap<String,Object>> typeRefMap 
			= new TypeReference<HashMap<String,Object>>() {};
		HashMap<String,Object> inputJSON = mapper.readValue(input, typeRefMap); 
		//System.out.println("Got " + inputJSON); 
		
		// create example spec
		String spec = "" +
				"["+
				"    {"+
				"        \"operation\": \"shift\","+
				"        \"spec\": {"+
				"            \"rating\": {"+
				"                \"primary\": {"+
				"                    \"value\": \"Rating\""+
				"                },"+
				"                \"*\": {"+
				"                    \"value\":\"SecondaryRatings.&1.Value\","+
				"                    \"$\": \"SecondaryRatings.&.Id\""+
				"                }"+
				"            }"+
				"        }"+
				"    },"+
				"    {"+
				"        \"operation\": \"default\","+
				"        \"spec\": {"+
				"            \"Range\" : 5,"+
				"            \"SecondaryRatings\" : {"+
				"                \"*\" : {"+
				"                    \"Range\" : 5"+
				"                }"+
				"            }"+
				"        }"+
				"    }"+
				"]";
		TypeReference<List<Object>> typeRefList 
			= new TypeReference<List<Object>>() {};
		List<Object> specJSON = mapper.readValue(spec, typeRefList);
		//System.out.println("Spec " + specJSON); 
		
		// set the expected output
		String expectedOutput = "{\"Rating\":3,\"SecondaryRatings\":{\"quality\":{\"Id\":\"quality\",\"Value\":3,\"Range\":5}},\"Range\":5}";
		
		
		// TEST 1 run the JOLT library
		Chainr chainr = Chainr.fromSpec( specJSON );
		Object transformedOutput = chainr.transform( inputJSON );
		assertTrue("  - JOLT can run correctly ",0==mapper.writeValueAsString(transformedOutput).compareTo(expectedOutput));
		//System.out.println( mapper.writeValueAsString( inputJSON ) );
		//System.out.println( mapper.writeValueAsString( transformedOutput ) );
		
		
		// TEST 2 encode the object as a SimpleConverter and call the JOLT handler
		List<Operation> ops = new ArrayList<Operation>(2);
		ops.add(new Operation().withOperation("shift").withSpec(new UObject(((Map<String,Object>)specJSON.get(0)).get("spec"))));
		ops.add(new Operation().withOperation("default").withSpec(new UObject(((Map<String,Object>)specJSON.get(1)).get("spec"))));
		SimpleConverter converter = new SimpleConverter().withOperations(ops );
		Object result = JoltConverterHandler.convert(inputJSON, converter);
		assertTrue("  - JOLT handler can run correctly ",0==mapper.writeValueAsString(result).compareTo(expectedOutput));
		//System.out.println( mapper.writeValueAsString( result ) );
	}
	
}
