package us.kbase.toc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import us.kbase.common.service.JsonClientException;
import us.kbase.toc.exceptions.TypedObjectConversionException;
import us.kbase.toc.ws.WorkspaceManager;
import us.kbase.workspace.ObjectData;
import us.kbase.workspace.ObjectIdentity;

public class SimpleTypedObjectConverter {

	private WorkspaceManager ws; 
	
	public SimpleTypedObjectConverter(WorkspaceManager wsManager) {
		ws = wsManager;
	}
	
	
	public Object convert(ObjectIdentity data, ObjectIdentity converter) throws TypedObjectConversionException  {
		
		List<ObjectIdentity> oids = new ArrayList<ObjectIdentity>(2);
		oids.add(data);
		oids.add(converter);
		try {
			List<ObjectData> objData = ws.getObjects(oids);
			
			System.out.println(objData.get(0).getInfo());
			System.out.println(objData.get(1).getInfo());
			//JoltConverterHandler.convert(objData.get(0).getData()., converter)
			
		} catch (JsonClientException e) {
			throw new TypedObjectConversionException("Cannot get data or converter from the workspace.\n"+e.getMessage(), e);
		} catch (IOException e) {
			throw new TypedObjectConversionException("Cannot get data or converter from the workspace.\n"+e.getMessage(), e);
		}
		return null;
		
	}
	
	
}
