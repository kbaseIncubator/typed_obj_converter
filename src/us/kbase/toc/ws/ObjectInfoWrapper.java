package us.kbase.toc.ws;

import java.util.Map;

import us.kbase.common.service.Tuple11;

public class ObjectInfoWrapper {

	/**
	wrapper for this tuple:
	
	typedef tuple<
		obj_id objid,
		obj_name name,
		type_string type,
		timestamp save_date,
		int version,
		username saved_by,
		ws_id wsid,
		ws_name workspace,
		string chsum,
		int size,
		usermeta meta>
	object_info;
	*/
	
	private long objid;
	private String name;
	
	private long wsid;
	private String workspace;
	
	private long version;
	
	private String type;
	
	private String save_date;
	private String saved_by;
	
	private String chsum;
	private long size;
	
	private Map<String,String> meta;
	
	
	public ObjectInfoWrapper(Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String,String>> object_info) {
		    objid = object_info.getE1();
		     name = object_info.getE2();
		     type = object_info.getE3();
		save_date = object_info.getE4();
		  version = object_info.getE5();
		 saved_by = object_info.getE6();
		     wsid = object_info.getE7();
		workspace = object_info.getE8();
		    chsum = object_info.getE9();
		     size = object_info.getE10();
		     meta = object_info.getE11();
	}

	public String getAbsRef() {
		return wsid + "/" + objid +"/"+version;
	}
	
	@Override
	public String toString() {
		return "ObjectInfoWrapper [objid=" + objid + ", name=" + name
				+ ", wsid=" + wsid + ", workspace=" + workspace + ", version="
				+ version + ", type=" + type + ", save_date=" + save_date
				+ ", saved_by=" + saved_by + ", chsum=" + chsum + ", size="
				+ size + "]";
	}
	public String toStringNice() {
		return toStringNice("");
	}
	public String toStringNice(String prefix) {
		String out = 
				prefix + "    objid : " + objid + "\n" +
				prefix + "     name : " + name + "\n" +
				prefix + "     wsid : " + wsid + "\n" +
				prefix + "workspace : " + workspace + "\n" +
				prefix + "  version : " + version + "\n" +
				prefix + "     type : "  + type + "\n" +
				prefix + "save_date : " + save_date + "\n" +
				prefix + " saved_by : " + saved_by + "\n" +
				prefix + "    chsum : " + chsum + "\n" +
				prefix + "     size : " + size + "\n";
		return out;
	}


	public long getObjid() {
		return objid;
	}

	public String getName() {
		return name;
	}

	public long getWsid() {
		return wsid;
	}

	public String getWorkspace() {
		return workspace;
	}

	public long getVersion() {
		return version;
	}

	public String getType() {
		return type;
	}

	public String getSave_date() {
		return save_date;
	}

	public String getSaved_by() {
		return saved_by;
	}

	public String getChsum() {
		return chsum;
	}

	public long getSize() {
		return size;
	}

	public Map<String, String> getMeta() {
		return meta;
	}
	
	
}
