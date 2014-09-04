package us.kbase.toc.ws;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonClientException;
import us.kbase.common.service.Tuple11;
import us.kbase.common.service.UnauthorizedException;
import us.kbase.workspace.GetObjectInfoNewParams;
import us.kbase.workspace.ObjectIdentity;
import us.kbase.workspace.ObjectData;
import us.kbase.workspace.WorkspaceClient;

public class WorkspaceManager {

	private WorkspaceClient ws;
	
	public WorkspaceManager(URL url, AuthToken token)
			throws UnauthorizedException, IOException {
		ws = new WorkspaceClient(url,token);
	}
	
	public List<ObjectInfoWrapper> getObjInfo(List<ObjectIdentity> objIds, AuthToken authPart)
			throws IOException, JsonClientException {
		GetObjectInfoNewParams goip = new GetObjectInfoNewParams()
											.withObjects(objIds)
											.withIncludeMetadata(0L)
											.withIgnoreErrors(0L);
		List<Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String, String>>> infoList
			= ws.getObjectInfoNew(goip);
		List<ObjectInfoWrapper> infoWrapperList = new ArrayList<ObjectInfoWrapper>(infoList.size());
		for(Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String, String>> info : infoList) {
			infoWrapperList.add(new ObjectInfoWrapper(info));
		}
		return infoWrapperList;
	}
	
	
	public List<ObjectData> getData() {
		return null;
	}
	
	
	
}
