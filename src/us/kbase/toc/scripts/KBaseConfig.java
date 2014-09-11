package us.kbase.toc.scripts;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

public class KBaseConfig {

	private static final String KBASE_CLIENT_CONFIG = "KB_CLIENT_CONFIG";
	
	public static String getClientConfigPath() {
		String path = System.getenv(KBASE_CLIENT_CONFIG);
		if (path != null) { return path; }
		return System.getProperty( "user.home" )+"/.kbase_config";
	}
	
	private HierarchicalINIConfiguration kbConfig;
	
	public KBaseConfig() throws ConfigurationException {
		kbConfig = new HierarchicalINIConfiguration(getClientConfigPath());
	}
	
	public boolean isLoggedIn() {
		if(kbConfig.getString("authentication.token")!=null) return true;
		return false;
	}
	
	public String getToken() {
		return kbConfig.getString("authentication.token");
	}
	
	public String getUserId() {
		return kbConfig.getString("authentication.user_id");
	}
	
	public String getValue(String key) {
		return kbConfig.getString(key);
	}
	
}
