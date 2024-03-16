package spring.constant;

public class SystemConstant {
	
	public static final int ACTIVE_STATUS = 1;
	public static final int INACTIVE_STATUS = 0;
	
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = (12 * 1000) + (1 * 60000) + (1000 * 3600000);//12s + 1m + 1h
	//public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 30000;
	public static final String SIGNING_KEY = "thuan";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String AUTHORITIES_KEY = "scopes";
}
