package us.kbase.toc.test;


//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

//import us.kbase.auth.AuthToken;





import com.bazaarvoice.jolt.Chainr;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class BasicJoltTest {
	
	
	@BeforeClass
	public static void setUpClass() throws Exception {
	}
	
	@Test
	public void runJolt() throws Exception {
		
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
		System.out.println("Spec " + specJSON); 
		
		Chainr chainr = Chainr.fromSpec( specJSON );
		Object transformedOutput = chainr.transform( inputJSON );
		
		System.out.println( mapper.writeValueAsString( inputJSON ) );
		System.out.println( mapper.writeValueAsString( transformedOutput ) );
	}
	
}
