package us.kbase.toc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.exception.JoltException;
import com.fasterxml.jackson.core.type.TypeReference;

import us.kbase.kbasetypedobjconverter.Operation;
import us.kbase.kbasetypedobjconverter.SimpleConverter;
import us.kbase.toc.exceptions.TypedObjectConversionException;

public class JoltConverterHandler {

	//private static final TypeReference<List<Object>> typeReferenceList;
	private static final TypeReference<Map<String,Object>> typeReferenceMap;
	
	static {
		//typeReferenceList = new TypeReference<List<Object>>() {};
		typeReferenceMap  = new TypeReference<Map<String,Object>>() {};
	}
	
	
	public static Object convert(Object inputObject, SimpleConverter converter) 
		throws TypedObjectConversionException
	{
		// extract out the Jolt specs from the converter... this is ugly, i know, but
		// this is how Jolt operates: on generic java objects
		List<Operation> ops = converter.getOperations();
		List<Object> joltTransformChainSpec = new ArrayList<Object>(ops.size());
		for(Operation o: ops) {
			Map<String,Object> transform = new HashMap<String,Object>(2);
			transform.put( "operation", o.getOperation() );
			transform.put( "spec",      o.getSpec().asClassInstance(typeReferenceMap) );
			joltTransformChainSpec.add(transform);
			System.out.println("adding operation: " + o.getOperation());
			System.out.println("adding spec: " + o.getSpec().asClassInstance(typeReferenceMap));
		}
		Chainr chainr = null;
		Object transformedOutput = null;
		try {
			chainr = Chainr.fromSpec( joltTransformChainSpec );
		} catch (JoltException e) {
			throw new TypedObjectConversionException("Invalid JOLT transformation spec: "+e.getMessage(),e);
		}
		try {
			transformedOutput = chainr.transform( inputObject );
		} catch (JoltException e) {
			throw new TypedObjectConversionException("Type Conversion Error: "+e.getMessage(),e);
		}
		return transformedOutput;
	}
	
	
}
