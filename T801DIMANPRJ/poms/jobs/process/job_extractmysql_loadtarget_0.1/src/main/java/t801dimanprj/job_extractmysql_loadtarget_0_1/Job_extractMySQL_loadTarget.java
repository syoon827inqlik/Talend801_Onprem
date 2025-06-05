
package t801dimanprj.job_extractmysql_loadtarget_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: Job_extractMySQL_loadTarget Purpose: <br>
 * Description:  <br>
 * @author YOON, SEAN
 * @version 8.0.1.20240920_1319-patch
 * @status 
 */
public class Job_extractMySQL_loadTarget implements TalendJob {
	static {System.setProperty("TalendJob.log", "Job_extractMySQL_loadTarget.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Job_extractMySQL_loadTarget.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";

	public static String taskExecutionId = null;

	public static String jobExecutionId = java.util.UUID.randomUUID().toString();;
	

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
		

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(Host != null){
				
					this.setProperty("Host", Host.toString());
				
			}
			
			if(Port != null){
				
					this.setProperty("Port", Port.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String Host;
public String getHost(){
	return this.Host;
}
public String Port;
public String getPort(){
	return this.Port;
}
	}
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
	    return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

	private final String jobVersion = "0.1";
	private final String jobName = "Job_extractMySQL_loadTarget";
	private final String projectName = "T801DIMANPRJ";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");
	
	private void s(final String component) {
		try {
			org.talend.metrics.DataReadTracker.setCurrentComponent(jobName, component);
		} catch (Exception | NoClassDefFoundError e) {
			// ignore
		}
	}
	
	
	private void mdc(final String subJobName, final String subJobPidPrefix) {
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", subJobName);
		org.slf4j.MDC.put("_subJobPid", subJobPidPrefix + subJobPidCounter.getAndIncrement());
	}
	
	
	private void sh(final String componentId) {
		ok_Hash.put(componentId, false);
		start_Hash.put(componentId, System.currentTimeMillis());
	}

	{
	s("none");
	}

	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_C0bm0A99EfC2vO2gbn31CQ", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Job_extractMySQL_loadTarget.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Job_extractMySQL_loadTarget.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}


	









public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
    static byte[] commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public short order_id;

				public short getOrder_id () {
					return this.order_id;
				}

				public Boolean order_idIsNullable(){
				    return false;
				}
				public Boolean order_idIsKey(){
				    return true;
				}
				public Integer order_idLength(){
				    return 5;
				}
				public Integer order_idPrecision(){
				    return 0;
				}
				public String order_idDefault(){
				
					return null;
				
				}
				public String order_idComment(){
				
				    return "";
				
				}
				public String order_idPattern(){
				
					return "";
				
				}
				public String order_idOriginalDbColumnName(){
				
					return "order_id";
				
				}

				
			    public String customer_id;

				public String getCustomer_id () {
					return this.customer_id;
				}

				public Boolean customer_idIsNullable(){
				    return true;
				}
				public Boolean customer_idIsKey(){
				    return false;
				}
				public Integer customer_idLength(){
				    return 100;
				}
				public Integer customer_idPrecision(){
				    return 0;
				}
				public String customer_idDefault(){
				
					return null;
				
				}
				public String customer_idComment(){
				
				    return "";
				
				}
				public String customer_idPattern(){
				
					return "";
				
				}
				public String customer_idOriginalDbColumnName(){
				
					return "customer_id";
				
				}

				
			    public String company_name;

				public String getCompany_name () {
					return this.company_name;
				}

				public Boolean company_nameIsNullable(){
				    return false;
				}
				public Boolean company_nameIsKey(){
				    return false;
				}
				public Integer company_nameLength(){
				    return 40;
				}
				public Integer company_namePrecision(){
				    return 0;
				}
				public String company_nameDefault(){
				
					return null;
				
				}
				public String company_nameComment(){
				
				    return "";
				
				}
				public String company_namePattern(){
				
					return "";
				
				}
				public String company_nameOriginalDbColumnName(){
				
					return "company_name";
				
				}

				
			    public String contact_name;

				public String getContact_name () {
					return this.contact_name;
				}

				public Boolean contact_nameIsNullable(){
				    return true;
				}
				public Boolean contact_nameIsKey(){
				    return false;
				}
				public Integer contact_nameLength(){
				    return 30;
				}
				public Integer contact_namePrecision(){
				    return 0;
				}
				public String contact_nameDefault(){
				
					return null;
				
				}
				public String contact_nameComment(){
				
				    return "";
				
				}
				public String contact_namePattern(){
				
					return "";
				
				}
				public String contact_nameOriginalDbColumnName(){
				
					return "contact_name";
				
				}

				
			    public Short employee_id;

				public Short getEmployee_id () {
					return this.employee_id;
				}

				public Boolean employee_idIsNullable(){
				    return true;
				}
				public Boolean employee_idIsKey(){
				    return false;
				}
				public Integer employee_idLength(){
				    return 5;
				}
				public Integer employee_idPrecision(){
				    return 0;
				}
				public String employee_idDefault(){
				
					return null;
				
				}
				public String employee_idComment(){
				
				    return "";
				
				}
				public String employee_idPattern(){
				
					return "";
				
				}
				public String employee_idOriginalDbColumnName(){
				
					return "employee_id";
				
				}

				
			    public java.util.Date order_date;

				public java.util.Date getOrder_date () {
					return this.order_date;
				}

				public Boolean order_dateIsNullable(){
				    return true;
				}
				public Boolean order_dateIsKey(){
				    return false;
				}
				public Integer order_dateLength(){
				    return 10;
				}
				public Integer order_datePrecision(){
				    return 0;
				}
				public String order_dateDefault(){
				
					return null;
				
				}
				public String order_dateComment(){
				
				    return "";
				
				}
				public String order_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String order_dateOriginalDbColumnName(){
				
					return "order_date";
				
				}

				
			    public java.util.Date required_date;

				public java.util.Date getRequired_date () {
					return this.required_date;
				}

				public Boolean required_dateIsNullable(){
				    return true;
				}
				public Boolean required_dateIsKey(){
				    return false;
				}
				public Integer required_dateLength(){
				    return 10;
				}
				public Integer required_datePrecision(){
				    return 0;
				}
				public String required_dateDefault(){
				
					return null;
				
				}
				public String required_dateComment(){
				
				    return "";
				
				}
				public String required_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String required_dateOriginalDbColumnName(){
				
					return "required_date";
				
				}

				
			    public java.util.Date shipped_date;

				public java.util.Date getShipped_date () {
					return this.shipped_date;
				}

				public Boolean shipped_dateIsNullable(){
				    return true;
				}
				public Boolean shipped_dateIsKey(){
				    return false;
				}
				public Integer shipped_dateLength(){
				    return 10;
				}
				public Integer shipped_datePrecision(){
				    return 0;
				}
				public String shipped_dateDefault(){
				
					return null;
				
				}
				public String shipped_dateComment(){
				
				    return "";
				
				}
				public String shipped_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String shipped_dateOriginalDbColumnName(){
				
					return "shipped_date";
				
				}

				
			    public Short ship_via;

				public Short getShip_via () {
					return this.ship_via;
				}

				public Boolean ship_viaIsNullable(){
				    return true;
				}
				public Boolean ship_viaIsKey(){
				    return false;
				}
				public Integer ship_viaLength(){
				    return 5;
				}
				public Integer ship_viaPrecision(){
				    return 0;
				}
				public String ship_viaDefault(){
				
					return null;
				
				}
				public String ship_viaComment(){
				
				    return "";
				
				}
				public String ship_viaPattern(){
				
					return "";
				
				}
				public String ship_viaOriginalDbColumnName(){
				
					return "ship_via";
				
				}

				
			    public Double freight;

				public Double getFreight () {
					return this.freight;
				}

				public Boolean freightIsNullable(){
				    return true;
				}
				public Boolean freightIsKey(){
				    return false;
				}
				public Integer freightLength(){
				    return 22;
				}
				public Integer freightPrecision(){
				    return 0;
				}
				public String freightDefault(){
				
					return null;
				
				}
				public String freightComment(){
				
				    return "";
				
				}
				public String freightPattern(){
				
					return "";
				
				}
				public String freightOriginalDbColumnName(){
				
					return "freight";
				
				}

				
			    public String ship_name;

				public String getShip_name () {
					return this.ship_name;
				}

				public Boolean ship_nameIsNullable(){
				    return true;
				}
				public Boolean ship_nameIsKey(){
				    return false;
				}
				public Integer ship_nameLength(){
				    return 40;
				}
				public Integer ship_namePrecision(){
				    return 0;
				}
				public String ship_nameDefault(){
				
					return null;
				
				}
				public String ship_nameComment(){
				
				    return "";
				
				}
				public String ship_namePattern(){
				
					return "";
				
				}
				public String ship_nameOriginalDbColumnName(){
				
					return "ship_name";
				
				}

				
			    public String ship_address;

				public String getShip_address () {
					return this.ship_address;
				}

				public Boolean ship_addressIsNullable(){
				    return true;
				}
				public Boolean ship_addressIsKey(){
				    return false;
				}
				public Integer ship_addressLength(){
				    return 60;
				}
				public Integer ship_addressPrecision(){
				    return 0;
				}
				public String ship_addressDefault(){
				
					return null;
				
				}
				public String ship_addressComment(){
				
				    return "";
				
				}
				public String ship_addressPattern(){
				
					return "";
				
				}
				public String ship_addressOriginalDbColumnName(){
				
					return "ship_address";
				
				}

				
			    public String ship_city;

				public String getShip_city () {
					return this.ship_city;
				}

				public Boolean ship_cityIsNullable(){
				    return true;
				}
				public Boolean ship_cityIsKey(){
				    return false;
				}
				public Integer ship_cityLength(){
				    return 15;
				}
				public Integer ship_cityPrecision(){
				    return 0;
				}
				public String ship_cityDefault(){
				
					return null;
				
				}
				public String ship_cityComment(){
				
				    return "";
				
				}
				public String ship_cityPattern(){
				
					return "";
				
				}
				public String ship_cityOriginalDbColumnName(){
				
					return "ship_city";
				
				}

				
			    public String ship_region;

				public String getShip_region () {
					return this.ship_region;
				}

				public Boolean ship_regionIsNullable(){
				    return true;
				}
				public Boolean ship_regionIsKey(){
				    return false;
				}
				public Integer ship_regionLength(){
				    return 15;
				}
				public Integer ship_regionPrecision(){
				    return 0;
				}
				public String ship_regionDefault(){
				
					return null;
				
				}
				public String ship_regionComment(){
				
				    return "";
				
				}
				public String ship_regionPattern(){
				
					return "";
				
				}
				public String ship_regionOriginalDbColumnName(){
				
					return "ship_region";
				
				}

				
			    public String ship_postal_code;

				public String getShip_postal_code () {
					return this.ship_postal_code;
				}

				public Boolean ship_postal_codeIsNullable(){
				    return true;
				}
				public Boolean ship_postal_codeIsKey(){
				    return false;
				}
				public Integer ship_postal_codeLength(){
				    return 10;
				}
				public Integer ship_postal_codePrecision(){
				    return 0;
				}
				public String ship_postal_codeDefault(){
				
					return null;
				
				}
				public String ship_postal_codeComment(){
				
				    return "";
				
				}
				public String ship_postal_codePattern(){
				
					return "";
				
				}
				public String ship_postal_codeOriginalDbColumnName(){
				
					return "ship_postal_code";
				
				}

				
			    public String ship_country;

				public String getShip_country () {
					return this.ship_country;
				}

				public Boolean ship_countryIsNullable(){
				    return true;
				}
				public Boolean ship_countryIsKey(){
				    return false;
				}
				public Integer ship_countryLength(){
				    return 15;
				}
				public Integer ship_countryPrecision(){
				    return 0;
				}
				public String ship_countryDefault(){
				
					return null;
				
				}
				public String ship_countryComment(){
				
				    return "";
				
				}
				public String ship_countryPattern(){
				
					return "";
				
				}
				public String ship_countryOriginalDbColumnName(){
				
					return "ship_country";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.order_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final out1Struct other = (out1Struct) obj;
		
						if (this.order_id != other.order_id)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.order_id = this.order_id;
	            other.customer_id = this.customer_id;
	            other.company_name = this.company_name;
	            other.contact_name = this.contact_name;
	            other.employee_id = this.employee_id;
	            other.order_date = this.order_date;
	            other.required_date = this.required_date;
	            other.shipped_date = this.shipped_date;
	            other.ship_via = this.ship_via;
	            other.freight = this.freight;
	            other.ship_name = this.ship_name;
	            other.ship_address = this.ship_address;
	            other.ship_city = this.ship_city;
	            other.ship_region = this.ship_region;
	            other.ship_postal_code = this.ship_postal_code;
	            other.ship_country = this.ship_country;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.order_id = this.order_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
					this.company_name = readString(dis);
					
					this.contact_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
					this.company_name = readString(dis);
					
					this.contact_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// String
				
						writeString(this.company_name,dos);
					
					// String
				
						writeString(this.contact_name,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// String
				
						writeString(this.company_name,dos);
					
					// String
				
						writeString(this.contact_name,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",customer_id="+customer_id);
		sb.append(",company_name="+company_name);
		sb.append(",contact_name="+contact_name);
		sb.append(",employee_id="+String.valueOf(employee_id));
		sb.append(",order_date="+String.valueOf(order_date));
		sb.append(",required_date="+String.valueOf(required_date));
		sb.append(",shipped_date="+String.valueOf(shipped_date));
		sb.append(",ship_via="+String.valueOf(ship_via));
		sb.append(",freight="+String.valueOf(freight));
		sb.append(",ship_name="+ship_name);
		sb.append(",ship_address="+ship_address);
		sb.append(",ship_city="+ship_city);
		sb.append(",ship_region="+ship_region);
		sb.append(",ship_postal_code="+ship_postal_code);
		sb.append(",ship_country="+ship_country);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(order_id);
        			
        			sb.append("|");
        		
        				if(customer_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(customer_id);
            			}
            		
        			sb.append("|");
        		
        				if(company_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(company_name);
            			}
            		
        			sb.append("|");
        		
        				if(contact_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(contact_name);
            			}
            		
        			sb.append("|");
        		
        				if(employee_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(employee_id);
            			}
            		
        			sb.append("|");
        		
        				if(order_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(order_date);
            			}
            		
        			sb.append("|");
        		
        				if(required_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(required_date);
            			}
            		
        			sb.append("|");
        		
        				if(shipped_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(shipped_date);
            			}
            		
        			sb.append("|");
        		
        				if(ship_via == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_via);
            			}
            		
        			sb.append("|");
        		
        				if(freight == null){
        					sb.append("<null>");
        				}else{
            				sb.append(freight);
            			}
            		
        			sb.append("|");
        		
        				if(ship_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_name);
            			}
            		
        			sb.append("|");
        		
        				if(ship_address == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_address);
            			}
            		
        			sb.append("|");
        		
        				if(ship_city == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_city);
            			}
            		
        			sb.append("|");
        		
        				if(ship_region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_region);
            			}
            		
        			sb.append("|");
        		
        				if(ship_postal_code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_postal_code);
            			}
            		
        			sb.append("|");
        		
        				if(ship_country == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_country);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.order_id, other.order_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
    static byte[] commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];

	
			    public short order_id;

				public short getOrder_id () {
					return this.order_id;
				}

				public Boolean order_idIsNullable(){
				    return false;
				}
				public Boolean order_idIsKey(){
				    return true;
				}
				public Integer order_idLength(){
				    return 5;
				}
				public Integer order_idPrecision(){
				    return 0;
				}
				public String order_idDefault(){
				
					return null;
				
				}
				public String order_idComment(){
				
				    return "";
				
				}
				public String order_idPattern(){
				
					return "";
				
				}
				public String order_idOriginalDbColumnName(){
				
					return "order_id";
				
				}

				
			    public String customer_id;

				public String getCustomer_id () {
					return this.customer_id;
				}

				public Boolean customer_idIsNullable(){
				    return true;
				}
				public Boolean customer_idIsKey(){
				    return false;
				}
				public Integer customer_idLength(){
				    return 100;
				}
				public Integer customer_idPrecision(){
				    return 0;
				}
				public String customer_idDefault(){
				
					return null;
				
				}
				public String customer_idComment(){
				
				    return "";
				
				}
				public String customer_idPattern(){
				
					return "";
				
				}
				public String customer_idOriginalDbColumnName(){
				
					return "customer_id";
				
				}

				
			    public Short employee_id;

				public Short getEmployee_id () {
					return this.employee_id;
				}

				public Boolean employee_idIsNullable(){
				    return true;
				}
				public Boolean employee_idIsKey(){
				    return false;
				}
				public Integer employee_idLength(){
				    return 5;
				}
				public Integer employee_idPrecision(){
				    return 0;
				}
				public String employee_idDefault(){
				
					return null;
				
				}
				public String employee_idComment(){
				
				    return "";
				
				}
				public String employee_idPattern(){
				
					return "";
				
				}
				public String employee_idOriginalDbColumnName(){
				
					return "employee_id";
				
				}

				
			    public java.util.Date order_date;

				public java.util.Date getOrder_date () {
					return this.order_date;
				}

				public Boolean order_dateIsNullable(){
				    return true;
				}
				public Boolean order_dateIsKey(){
				    return false;
				}
				public Integer order_dateLength(){
				    return 10;
				}
				public Integer order_datePrecision(){
				    return 0;
				}
				public String order_dateDefault(){
				
					return null;
				
				}
				public String order_dateComment(){
				
				    return "";
				
				}
				public String order_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String order_dateOriginalDbColumnName(){
				
					return "order_date";
				
				}

				
			    public java.util.Date required_date;

				public java.util.Date getRequired_date () {
					return this.required_date;
				}

				public Boolean required_dateIsNullable(){
				    return true;
				}
				public Boolean required_dateIsKey(){
				    return false;
				}
				public Integer required_dateLength(){
				    return 10;
				}
				public Integer required_datePrecision(){
				    return 0;
				}
				public String required_dateDefault(){
				
					return null;
				
				}
				public String required_dateComment(){
				
				    return "";
				
				}
				public String required_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String required_dateOriginalDbColumnName(){
				
					return "required_date";
				
				}

				
			    public java.util.Date shipped_date;

				public java.util.Date getShipped_date () {
					return this.shipped_date;
				}

				public Boolean shipped_dateIsNullable(){
				    return true;
				}
				public Boolean shipped_dateIsKey(){
				    return false;
				}
				public Integer shipped_dateLength(){
				    return 10;
				}
				public Integer shipped_datePrecision(){
				    return 0;
				}
				public String shipped_dateDefault(){
				
					return null;
				
				}
				public String shipped_dateComment(){
				
				    return "";
				
				}
				public String shipped_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String shipped_dateOriginalDbColumnName(){
				
					return "shipped_date";
				
				}

				
			    public Short ship_via;

				public Short getShip_via () {
					return this.ship_via;
				}

				public Boolean ship_viaIsNullable(){
				    return true;
				}
				public Boolean ship_viaIsKey(){
				    return false;
				}
				public Integer ship_viaLength(){
				    return 5;
				}
				public Integer ship_viaPrecision(){
				    return 0;
				}
				public String ship_viaDefault(){
				
					return null;
				
				}
				public String ship_viaComment(){
				
				    return "";
				
				}
				public String ship_viaPattern(){
				
					return "";
				
				}
				public String ship_viaOriginalDbColumnName(){
				
					return "ship_via";
				
				}

				
			    public Double freight;

				public Double getFreight () {
					return this.freight;
				}

				public Boolean freightIsNullable(){
				    return true;
				}
				public Boolean freightIsKey(){
				    return false;
				}
				public Integer freightLength(){
				    return 22;
				}
				public Integer freightPrecision(){
				    return 0;
				}
				public String freightDefault(){
				
					return null;
				
				}
				public String freightComment(){
				
				    return "";
				
				}
				public String freightPattern(){
				
					return "";
				
				}
				public String freightOriginalDbColumnName(){
				
					return "freight";
				
				}

				
			    public String ship_name;

				public String getShip_name () {
					return this.ship_name;
				}

				public Boolean ship_nameIsNullable(){
				    return true;
				}
				public Boolean ship_nameIsKey(){
				    return false;
				}
				public Integer ship_nameLength(){
				    return 40;
				}
				public Integer ship_namePrecision(){
				    return 0;
				}
				public String ship_nameDefault(){
				
					return null;
				
				}
				public String ship_nameComment(){
				
				    return "";
				
				}
				public String ship_namePattern(){
				
					return "";
				
				}
				public String ship_nameOriginalDbColumnName(){
				
					return "ship_name";
				
				}

				
			    public String ship_address;

				public String getShip_address () {
					return this.ship_address;
				}

				public Boolean ship_addressIsNullable(){
				    return true;
				}
				public Boolean ship_addressIsKey(){
				    return false;
				}
				public Integer ship_addressLength(){
				    return 60;
				}
				public Integer ship_addressPrecision(){
				    return 0;
				}
				public String ship_addressDefault(){
				
					return null;
				
				}
				public String ship_addressComment(){
				
				    return "";
				
				}
				public String ship_addressPattern(){
				
					return "";
				
				}
				public String ship_addressOriginalDbColumnName(){
				
					return "ship_address";
				
				}

				
			    public String ship_city;

				public String getShip_city () {
					return this.ship_city;
				}

				public Boolean ship_cityIsNullable(){
				    return true;
				}
				public Boolean ship_cityIsKey(){
				    return false;
				}
				public Integer ship_cityLength(){
				    return 15;
				}
				public Integer ship_cityPrecision(){
				    return 0;
				}
				public String ship_cityDefault(){
				
					return null;
				
				}
				public String ship_cityComment(){
				
				    return "";
				
				}
				public String ship_cityPattern(){
				
					return "";
				
				}
				public String ship_cityOriginalDbColumnName(){
				
					return "ship_city";
				
				}

				
			    public String ship_region;

				public String getShip_region () {
					return this.ship_region;
				}

				public Boolean ship_regionIsNullable(){
				    return true;
				}
				public Boolean ship_regionIsKey(){
				    return false;
				}
				public Integer ship_regionLength(){
				    return 15;
				}
				public Integer ship_regionPrecision(){
				    return 0;
				}
				public String ship_regionDefault(){
				
					return null;
				
				}
				public String ship_regionComment(){
				
				    return "";
				
				}
				public String ship_regionPattern(){
				
					return "";
				
				}
				public String ship_regionOriginalDbColumnName(){
				
					return "ship_region";
				
				}

				
			    public String ship_postal_code;

				public String getShip_postal_code () {
					return this.ship_postal_code;
				}

				public Boolean ship_postal_codeIsNullable(){
				    return true;
				}
				public Boolean ship_postal_codeIsKey(){
				    return false;
				}
				public Integer ship_postal_codeLength(){
				    return 10;
				}
				public Integer ship_postal_codePrecision(){
				    return 0;
				}
				public String ship_postal_codeDefault(){
				
					return null;
				
				}
				public String ship_postal_codeComment(){
				
				    return "";
				
				}
				public String ship_postal_codePattern(){
				
					return "";
				
				}
				public String ship_postal_codeOriginalDbColumnName(){
				
					return "ship_postal_code";
				
				}

				
			    public String ship_country;

				public String getShip_country () {
					return this.ship_country;
				}

				public Boolean ship_countryIsNullable(){
				    return true;
				}
				public Boolean ship_countryIsKey(){
				    return false;
				}
				public Integer ship_countryLength(){
				    return 15;
				}
				public Integer ship_countryPrecision(){
				    return 0;
				}
				public String ship_countryDefault(){
				
					return null;
				
				}
				public String ship_countryComment(){
				
				    return "";
				
				}
				public String ship_countryPattern(){
				
					return "";
				
				}
				public String ship_countryOriginalDbColumnName(){
				
					return "ship_country";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",customer_id="+customer_id);
		sb.append(",employee_id="+String.valueOf(employee_id));
		sb.append(",order_date="+String.valueOf(order_date));
		sb.append(",required_date="+String.valueOf(required_date));
		sb.append(",shipped_date="+String.valueOf(shipped_date));
		sb.append(",ship_via="+String.valueOf(ship_via));
		sb.append(",freight="+String.valueOf(freight));
		sb.append(",ship_name="+ship_name);
		sb.append(",ship_address="+ship_address);
		sb.append(",ship_city="+ship_city);
		sb.append(",ship_region="+ship_region);
		sb.append(",ship_postal_code="+ship_postal_code);
		sb.append(",ship_country="+ship_country);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(order_id);
        			
        			sb.append("|");
        		
        				if(customer_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(customer_id);
            			}
            		
        			sb.append("|");
        		
        				if(employee_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(employee_id);
            			}
            		
        			sb.append("|");
        		
        				if(order_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(order_date);
            			}
            		
        			sb.append("|");
        		
        				if(required_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(required_date);
            			}
            		
        			sb.append("|");
        		
        				if(shipped_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(shipped_date);
            			}
            		
        			sb.append("|");
        		
        				if(ship_via == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_via);
            			}
            		
        			sb.append("|");
        		
        				if(freight == null){
        					sb.append("<null>");
        				}else{
            				sb.append(freight);
            			}
            		
        			sb.append("|");
        		
        				if(ship_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_name);
            			}
            		
        			sb.append("|");
        		
        				if(ship_address == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_address);
            			}
            		
        			sb.append("|");
        		
        				if(ship_city == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_city);
            			}
            		
        			sb.append("|");
        		
        				if(ship_region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_region);
            			}
            		
        			sb.append("|");
        		
        				if(ship_postal_code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_postal_code);
            			}
            		
        			sb.append("|");
        		
        				if(ship_country == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_country);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
    static byte[] commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public short order_id;

				public short getOrder_id () {
					return this.order_id;
				}

				public Boolean order_idIsNullable(){
				    return false;
				}
				public Boolean order_idIsKey(){
				    return true;
				}
				public Integer order_idLength(){
				    return 5;
				}
				public Integer order_idPrecision(){
				    return 0;
				}
				public String order_idDefault(){
				
					return null;
				
				}
				public String order_idComment(){
				
				    return "";
				
				}
				public String order_idPattern(){
				
					return "";
				
				}
				public String order_idOriginalDbColumnName(){
				
					return "order_id";
				
				}

				
			    public String customer_id;

				public String getCustomer_id () {
					return this.customer_id;
				}

				public Boolean customer_idIsNullable(){
				    return true;
				}
				public Boolean customer_idIsKey(){
				    return false;
				}
				public Integer customer_idLength(){
				    return 100;
				}
				public Integer customer_idPrecision(){
				    return 0;
				}
				public String customer_idDefault(){
				
					return null;
				
				}
				public String customer_idComment(){
				
				    return "";
				
				}
				public String customer_idPattern(){
				
					return "";
				
				}
				public String customer_idOriginalDbColumnName(){
				
					return "customer_id";
				
				}

				
			    public Short employee_id;

				public Short getEmployee_id () {
					return this.employee_id;
				}

				public Boolean employee_idIsNullable(){
				    return true;
				}
				public Boolean employee_idIsKey(){
				    return false;
				}
				public Integer employee_idLength(){
				    return 5;
				}
				public Integer employee_idPrecision(){
				    return 0;
				}
				public String employee_idDefault(){
				
					return null;
				
				}
				public String employee_idComment(){
				
				    return "";
				
				}
				public String employee_idPattern(){
				
					return "";
				
				}
				public String employee_idOriginalDbColumnName(){
				
					return "employee_id";
				
				}

				
			    public java.util.Date order_date;

				public java.util.Date getOrder_date () {
					return this.order_date;
				}

				public Boolean order_dateIsNullable(){
				    return true;
				}
				public Boolean order_dateIsKey(){
				    return false;
				}
				public Integer order_dateLength(){
				    return 10;
				}
				public Integer order_datePrecision(){
				    return 0;
				}
				public String order_dateDefault(){
				
					return null;
				
				}
				public String order_dateComment(){
				
				    return "";
				
				}
				public String order_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String order_dateOriginalDbColumnName(){
				
					return "order_date";
				
				}

				
			    public java.util.Date required_date;

				public java.util.Date getRequired_date () {
					return this.required_date;
				}

				public Boolean required_dateIsNullable(){
				    return true;
				}
				public Boolean required_dateIsKey(){
				    return false;
				}
				public Integer required_dateLength(){
				    return 10;
				}
				public Integer required_datePrecision(){
				    return 0;
				}
				public String required_dateDefault(){
				
					return null;
				
				}
				public String required_dateComment(){
				
				    return "";
				
				}
				public String required_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String required_dateOriginalDbColumnName(){
				
					return "required_date";
				
				}

				
			    public java.util.Date shipped_date;

				public java.util.Date getShipped_date () {
					return this.shipped_date;
				}

				public Boolean shipped_dateIsNullable(){
				    return true;
				}
				public Boolean shipped_dateIsKey(){
				    return false;
				}
				public Integer shipped_dateLength(){
				    return 10;
				}
				public Integer shipped_datePrecision(){
				    return 0;
				}
				public String shipped_dateDefault(){
				
					return null;
				
				}
				public String shipped_dateComment(){
				
				    return "";
				
				}
				public String shipped_datePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String shipped_dateOriginalDbColumnName(){
				
					return "shipped_date";
				
				}

				
			    public Short ship_via;

				public Short getShip_via () {
					return this.ship_via;
				}

				public Boolean ship_viaIsNullable(){
				    return true;
				}
				public Boolean ship_viaIsKey(){
				    return false;
				}
				public Integer ship_viaLength(){
				    return 5;
				}
				public Integer ship_viaPrecision(){
				    return 0;
				}
				public String ship_viaDefault(){
				
					return null;
				
				}
				public String ship_viaComment(){
				
				    return "";
				
				}
				public String ship_viaPattern(){
				
					return "";
				
				}
				public String ship_viaOriginalDbColumnName(){
				
					return "ship_via";
				
				}

				
			    public Double freight;

				public Double getFreight () {
					return this.freight;
				}

				public Boolean freightIsNullable(){
				    return true;
				}
				public Boolean freightIsKey(){
				    return false;
				}
				public Integer freightLength(){
				    return 22;
				}
				public Integer freightPrecision(){
				    return 0;
				}
				public String freightDefault(){
				
					return null;
				
				}
				public String freightComment(){
				
				    return "";
				
				}
				public String freightPattern(){
				
					return "";
				
				}
				public String freightOriginalDbColumnName(){
				
					return "freight";
				
				}

				
			    public String ship_name;

				public String getShip_name () {
					return this.ship_name;
				}

				public Boolean ship_nameIsNullable(){
				    return true;
				}
				public Boolean ship_nameIsKey(){
				    return false;
				}
				public Integer ship_nameLength(){
				    return 40;
				}
				public Integer ship_namePrecision(){
				    return 0;
				}
				public String ship_nameDefault(){
				
					return null;
				
				}
				public String ship_nameComment(){
				
				    return "";
				
				}
				public String ship_namePattern(){
				
					return "";
				
				}
				public String ship_nameOriginalDbColumnName(){
				
					return "ship_name";
				
				}

				
			    public String ship_address;

				public String getShip_address () {
					return this.ship_address;
				}

				public Boolean ship_addressIsNullable(){
				    return true;
				}
				public Boolean ship_addressIsKey(){
				    return false;
				}
				public Integer ship_addressLength(){
				    return 60;
				}
				public Integer ship_addressPrecision(){
				    return 0;
				}
				public String ship_addressDefault(){
				
					return null;
				
				}
				public String ship_addressComment(){
				
				    return "";
				
				}
				public String ship_addressPattern(){
				
					return "";
				
				}
				public String ship_addressOriginalDbColumnName(){
				
					return "ship_address";
				
				}

				
			    public String ship_city;

				public String getShip_city () {
					return this.ship_city;
				}

				public Boolean ship_cityIsNullable(){
				    return true;
				}
				public Boolean ship_cityIsKey(){
				    return false;
				}
				public Integer ship_cityLength(){
				    return 15;
				}
				public Integer ship_cityPrecision(){
				    return 0;
				}
				public String ship_cityDefault(){
				
					return null;
				
				}
				public String ship_cityComment(){
				
				    return "";
				
				}
				public String ship_cityPattern(){
				
					return "";
				
				}
				public String ship_cityOriginalDbColumnName(){
				
					return "ship_city";
				
				}

				
			    public String ship_region;

				public String getShip_region () {
					return this.ship_region;
				}

				public Boolean ship_regionIsNullable(){
				    return true;
				}
				public Boolean ship_regionIsKey(){
				    return false;
				}
				public Integer ship_regionLength(){
				    return 15;
				}
				public Integer ship_regionPrecision(){
				    return 0;
				}
				public String ship_regionDefault(){
				
					return null;
				
				}
				public String ship_regionComment(){
				
				    return "";
				
				}
				public String ship_regionPattern(){
				
					return "";
				
				}
				public String ship_regionOriginalDbColumnName(){
				
					return "ship_region";
				
				}

				
			    public String ship_postal_code;

				public String getShip_postal_code () {
					return this.ship_postal_code;
				}

				public Boolean ship_postal_codeIsNullable(){
				    return true;
				}
				public Boolean ship_postal_codeIsKey(){
				    return false;
				}
				public Integer ship_postal_codeLength(){
				    return 10;
				}
				public Integer ship_postal_codePrecision(){
				    return 0;
				}
				public String ship_postal_codeDefault(){
				
					return null;
				
				}
				public String ship_postal_codeComment(){
				
				    return "";
				
				}
				public String ship_postal_codePattern(){
				
					return "";
				
				}
				public String ship_postal_codeOriginalDbColumnName(){
				
					return "ship_postal_code";
				
				}

				
			    public String ship_country;

				public String getShip_country () {
					return this.ship_country;
				}

				public Boolean ship_countryIsNullable(){
				    return true;
				}
				public Boolean ship_countryIsKey(){
				    return false;
				}
				public Integer ship_countryLength(){
				    return 15;
				}
				public Integer ship_countryPrecision(){
				    return 0;
				}
				public String ship_countryDefault(){
				
					return null;
				
				}
				public String ship_countryComment(){
				
				    return "";
				
				}
				public String ship_countryPattern(){
				
					return "";
				
				}
				public String ship_countryOriginalDbColumnName(){
				
					return "ship_country";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.order_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.order_id != other.order_id)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.order_id = this.order_id;
	            other.customer_id = this.customer_id;
	            other.employee_id = this.employee_id;
	            other.order_date = this.order_date;
	            other.required_date = this.required_date;
	            other.shipped_date = this.shipped_date;
	            other.ship_via = this.ship_via;
	            other.freight = this.freight;
	            other.ship_name = this.ship_name;
	            other.ship_address = this.ship_address;
	            other.ship_city = this.ship_city;
	            other.ship_region = this.ship_region;
	            other.ship_postal_code = this.ship_postal_code;
	            other.ship_country = this.ship_country;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.order_id = this.order_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readShort();
					
					this.customer_id = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readShort();
           				}
					
					this.order_date = readDate(dis);
					
					this.required_date = readDate(dis);
					
					this.shipped_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.ship_via = null;
           				} else {
           			    	this.ship_via = dis.readShort();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.freight = null;
           				} else {
           			    	this.freight = dis.readDouble();
           				}
					
					this.ship_name = readString(dis);
					
					this.ship_address = readString(dis);
					
					this.ship_city = readString(dis);
					
					this.ship_region = readString(dis);
					
					this.ship_postal_code = readString(dis);
					
					this.ship_country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// short
				
		            	dos.writeShort(this.order_id);
					
					// String
				
						writeString(this.customer_id,dos);
					
					// Short
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.employee_id);
		            	}
					
					// java.util.Date
				
						writeDate(this.order_date,dos);
					
					// java.util.Date
				
						writeDate(this.required_date,dos);
					
					// java.util.Date
				
						writeDate(this.shipped_date,dos);
					
					// Short
				
						if(this.ship_via == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.ship_via);
		            	}
					
					// Double
				
						if(this.freight == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.freight);
		            	}
					
					// String
				
						writeString(this.ship_name,dos);
					
					// String
				
						writeString(this.ship_address,dos);
					
					// String
				
						writeString(this.ship_city,dos);
					
					// String
				
						writeString(this.ship_region,dos);
					
					// String
				
						writeString(this.ship_postal_code,dos);
					
					// String
				
						writeString(this.ship_country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",customer_id="+customer_id);
		sb.append(",employee_id="+String.valueOf(employee_id));
		sb.append(",order_date="+String.valueOf(order_date));
		sb.append(",required_date="+String.valueOf(required_date));
		sb.append(",shipped_date="+String.valueOf(shipped_date));
		sb.append(",ship_via="+String.valueOf(ship_via));
		sb.append(",freight="+String.valueOf(freight));
		sb.append(",ship_name="+ship_name);
		sb.append(",ship_address="+ship_address);
		sb.append(",ship_city="+ship_city);
		sb.append(",ship_region="+ship_region);
		sb.append(",ship_postal_code="+ship_postal_code);
		sb.append(",ship_country="+ship_country);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(order_id);
        			
        			sb.append("|");
        		
        				if(customer_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(customer_id);
            			}
            		
        			sb.append("|");
        		
        				if(employee_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(employee_id);
            			}
            		
        			sb.append("|");
        		
        				if(order_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(order_date);
            			}
            		
        			sb.append("|");
        		
        				if(required_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(required_date);
            			}
            		
        			sb.append("|");
        		
        				if(shipped_date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(shipped_date);
            			}
            		
        			sb.append("|");
        		
        				if(ship_via == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_via);
            			}
            		
        			sb.append("|");
        		
        				if(freight == null){
        					sb.append("<null>");
        				}else{
            				sb.append(freight);
            			}
            		
        			sb.append("|");
        		
        				if(ship_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_name);
            			}
            		
        			sb.append("|");
        		
        				if(ship_address == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_address);
            			}
            		
        			sb.append("|");
        		
        				if(ship_city == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_city);
            			}
            		
        			sb.append("|");
        		
        				if(ship_region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_region);
            			}
            		
        			sb.append("|");
        		
        				if(ship_postal_code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_postal_code);
            			}
            		
        			sb.append("|");
        		
        				if(ship_country == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ship_country);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.order_id, other.order_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tDBInput_1", "qACBrV_");

	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_2Process(globalMap);

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();





	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		sh("tLogRow_1");
		
	
	s(currentComponent="tLogRow_1");
	
			
			
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"out1");
			
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[16];

        public void addRow(String[] row) {

            for (int i = 0; i < 16; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 15 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 15 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%14$-");
        			        sbformat.append(colLengths[13]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%15$-");
        			        sbformat.append(colLengths[14]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%16$-");
        			        sbformat.append(colLengths[15]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[14] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[15] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"order_id","customer_id","company_name","contact_name","employee_id","order_date","required_date","shipped_date","ship_via","freight","ship_name","ship_address","ship_city","ship_region","ship_postal_code","ship_country",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



		

/**
 * [tLogRow_1 begin ] stop
 */




	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		sh("tMap_1");
		
	
	s(currentComponent="tMap_1");
	
			
			
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_1 = 0;
		
		int count_row2_tMap_1 = 0;
		
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	
		tHash_Lookup_row2.initGet();
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;
				
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



		

/**
 * [tMap_1 begin ] stop
 */




	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		sh("tDBInput_1");
		
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "context.Host");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "context.Port");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"northwind\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "\"root\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:OGwUUIMco8h2ZNoEbGCxY2S+1gxR91UzI9bLT+rHq2K8sIdijA==").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"orders\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT    `orders`.`order_id`,    `orders`.`customer_id`,    `orders`.`employee_id`,    `orders`.`order_date`,    `orders`.`required_date`,    `orders`.`shipped_date`,    `orders`.`ship_via`,    `orders`.`freight`,    `orders`.`ship_name`,    `orders`.`ship_address`,    `orders`.`ship_city`,    `orders`.`ship_region`,    `orders`.`ship_postal_code`,    `orders`.`ship_country`  FROM `orders`\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("order_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("customer_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("employee_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("order_date")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("required_date")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("shipped_date")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_via")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("freight")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_address")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_city")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_region")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_postal_code")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ship_country")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "\"orders\"", "tMysqlInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:ZnYFb+dB8ZUx26jb/9LGOPh1jZKWaSV3AFBNlj7ZhM38a4lETg==");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + context.Host + ":" + context.Port + "/" + "northwind" + "?" + properties_tDBInput_1;
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  `orders`.`order_id`, \n  `orders`.`customer_id`, \n  `orders`.`employee_id`, \n  `orders`.`order_date`, \n  `orde"
+"rs`.`required_date`, \n  `orders`.`shipped_date`, \n  `orders`.`ship_via`, \n  `orders`.`freight`, \n  `orders`.`ship_name`,"
+" \n  `orders`.`ship_address`, \n  `orders`.`ship_city`, \n  `orders`.`ship_region`, \n  `orders`.`ship_postal_code`, \n  `ord"
+"ers`.`ship_country`\n FROM `orders`";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

		    globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);

		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.order_id = 0;
							} else {
		                          
            row1.order_id = rs_tDBInput_1.getShort(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.customer_id = null;
							} else {
	                         		
        	row1.customer_id = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.employee_id = null;
							} else {
		                          
            row1.employee_id = rs_tDBInput_1.getShort(3);
            if(rs_tDBInput_1.wasNull()){
                    row1.employee_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.order_date = null;
							} else {
										
				if(rs_tDBInput_1.getString(4) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(4);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row1.order_date = rs_tDBInput_1.getTimestamp(4);
					} else {
						row1.order_date = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row1.order_date =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.required_date = null;
							} else {
										
				if(rs_tDBInput_1.getString(5) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(5);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row1.required_date = rs_tDBInput_1.getTimestamp(5);
					} else {
						row1.required_date = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row1.required_date =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.shipped_date = null;
							} else {
										
				if(rs_tDBInput_1.getString(6) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(6);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row1.shipped_date = rs_tDBInput_1.getTimestamp(6);
					} else {
						row1.shipped_date = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row1.shipped_date =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.ship_via = null;
							} else {
		                          
            row1.ship_via = rs_tDBInput_1.getShort(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.ship_via = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.freight = null;
							} else {
	                         		
            row1.freight = rs_tDBInput_1.getDouble(8);
            if(rs_tDBInput_1.wasNull()){
                    row1.freight = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.ship_name = null;
							} else {
	                         		
        	row1.ship_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.ship_address = null;
							} else {
	                         		
        	row1.ship_address = routines.system.JDBCUtil.getString(rs_tDBInput_1, 10, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.ship_city = null;
							} else {
	                         		
        	row1.ship_city = routines.system.JDBCUtil.getString(rs_tDBInput_1, 11, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.ship_region = null;
							} else {
	                         		
        	row1.ship_region = routines.system.JDBCUtil.getString(rs_tDBInput_1, 12, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.ship_postal_code = null;
							} else {
	                         		
        	row1.ship_postal_code = routines.system.JDBCUtil.getString(rs_tDBInput_1, 13, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.ship_country = null;
							} else {
	                         		
        	row1.ship_country = routines.system.JDBCUtil.getString(rs_tDBInput_1, 14, false);
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



		

/**
 * [tDBInput_1 begin ] stop
 */

	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		

 


	tos_count_tDBInput_1++;

		

/**
 * [tDBInput_1 main ] stop
 */

	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		

 



		

/**
 * [tDBInput_1 process_data_begin ] stop
 */


	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tDBInput_1","\"orders\"","tMysqlInput","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
						row2Struct row2 = null;
					
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								

								
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLooprow2 = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLooprow2 = true;
			           		  	} // G 21
                    		  	
                    		

							
                    		  	 
							

								while ((tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) || forceLooprow2) { // G_TM_M_043

								
									 // CALL close loop of lookup 'row2'
									
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								
								if(!forceLooprow2) { // G 46
								
							
								 
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLooprow2 = false;
									 	
							
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
count_out1_tMap_1++;

out1_tmp.order_id = row1.order_id ;
out1_tmp.customer_id = row1.customer_id ;
out1_tmp.company_name = row2.company_name ;
out1_tmp.contact_name = row2.contact_name ;
out1_tmp.employee_id = row1.employee_id ;
out1_tmp.order_date = row1.order_date ;
out1_tmp.required_date = row1.required_date ;
out1_tmp.shipped_date = row1.shipped_date ;
out1_tmp.ship_via = row1.ship_via ;
out1_tmp.freight = row1.freight ;
out1_tmp.ship_name = row1.ship_name ;
out1_tmp.ship_address = row1.ship_address ;
out1_tmp.ship_city = row1.ship_city ;
out1_tmp.ship_region = row1.ship_region ;
out1_tmp.ship_postal_code = row1.ship_postal_code ;
out1_tmp.ship_country = row1.ship_country ;
out1 = out1_tmp;
log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1 + " of the output table 'out1'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

		

/**
 * [tMap_1 main ] stop
 */

	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	

 



		

/**
 * [tMap_1 process_data_begin ] stop
 */

// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"out1","tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("out1 - " + (out1==null? "": out1.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[16];
              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(out1.order_id)			
					          ;	
										
    			   				
	    		if(out1.customer_id != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(out1.customer_id)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.company_name != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(out1.company_name)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.contact_name != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(out1.contact_name)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.employee_id != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(out1.employee_id)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.order_date != null) { //              
                 row_tLogRow_1[5]=    						
								FormatterUtils.format_Date(out1.order_date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(out1.required_date != null) { //              
                 row_tLogRow_1[6]=    						
								FormatterUtils.format_Date(out1.required_date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(out1.shipped_date != null) { //              
                 row_tLogRow_1[7]=    						
								FormatterUtils.format_Date(out1.shipped_date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_via != null) { //              
                 row_tLogRow_1[8]=    						    
				                String.valueOf(out1.ship_via)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.freight != null) { //              
                 row_tLogRow_1[9]=    						
								FormatterUtils.formatUnwithE(out1.freight)
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_name != null) { //              
                 row_tLogRow_1[10]=    						    
				                String.valueOf(out1.ship_name)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_address != null) { //              
                 row_tLogRow_1[11]=    						    
				                String.valueOf(out1.ship_address)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_city != null) { //              
                 row_tLogRow_1[12]=    						    
				                String.valueOf(out1.ship_city)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_region != null) { //              
                 row_tLogRow_1[13]=    						    
				                String.valueOf(out1.ship_region)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_postal_code != null) { //              
                 row_tLogRow_1[14]=    						    
				                String.valueOf(out1.ship_postal_code)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.ship_country != null) { //              
                 row_tLogRow_1[15]=    						    
				                String.valueOf(out1.ship_country)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

		

/**
 * [tLogRow_1 main ] stop
 */

	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 process_data_begin ] stop
 */

	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 process_data_end ] stop
 */


} // End of branch "out1"



			s(currentComponent="tMap_1");
			
	
		} // tMap_1:close loop of lookup 'row2' // G_TM_M_043
	
	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	

 



		

/**
 * [tMap_1 process_data_end ] stop
 */




	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		

 



		

/**
 * [tDBInput_1 process_data_end ] stop
 */

	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




		

/**
 * [tDBInput_1 end ] stop
 */


	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tDBInput_1","\"orders\"","tMysqlInput","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




		

/**
 * [tMap_1 end ] stop
 */


	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"out1",2,0,
			 			"tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




		

/**
 * [tLogRow_1 end ] stop
 */







				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"orders\"";
		

 



		

/**
 * [tDBInput_1 finally ] stop
 */


	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	

 



		

/**
 * [tMap_1 finally ] stop
 */


	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 finally ] stop
 */







				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];
    static byte[] commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[0];

	
			    public String customer_id;

				public String getCustomer_id () {
					return this.customer_id;
				}

				public Boolean customer_idIsNullable(){
				    return false;
				}
				public Boolean customer_idIsKey(){
				    return true;
				}
				public Integer customer_idLength(){
				    return 100;
				}
				public Integer customer_idPrecision(){
				    return 0;
				}
				public String customer_idDefault(){
				
					return null;
				
				}
				public String customer_idComment(){
				
				    return "";
				
				}
				public String customer_idPattern(){
				
					return "";
				
				}
				public String customer_idOriginalDbColumnName(){
				
					return "customer_id";
				
				}

				
			    public String company_name;

				public String getCompany_name () {
					return this.company_name;
				}

				public Boolean company_nameIsNullable(){
				    return false;
				}
				public Boolean company_nameIsKey(){
				    return false;
				}
				public Integer company_nameLength(){
				    return 40;
				}
				public Integer company_namePrecision(){
				    return 0;
				}
				public String company_nameDefault(){
				
					return null;
				
				}
				public String company_nameComment(){
				
				    return "";
				
				}
				public String company_namePattern(){
				
					return "";
				
				}
				public String company_nameOriginalDbColumnName(){
				
					return "company_name";
				
				}

				
			    public String contact_name;

				public String getContact_name () {
					return this.contact_name;
				}

				public Boolean contact_nameIsNullable(){
				    return true;
				}
				public Boolean contact_nameIsKey(){
				    return false;
				}
				public Integer contact_nameLength(){
				    return 30;
				}
				public Integer contact_namePrecision(){
				    return 0;
				}
				public String contact_nameDefault(){
				
					return null;
				
				}
				public String contact_nameComment(){
				
				    return "";
				
				}
				public String contact_namePattern(){
				
					return "";
				
				}
				public String contact_nameOriginalDbColumnName(){
				
					return "contact_name";
				
				}

				
			    public String contact_title;

				public String getContact_title () {
					return this.contact_title;
				}

				public Boolean contact_titleIsNullable(){
				    return true;
				}
				public Boolean contact_titleIsKey(){
				    return false;
				}
				public Integer contact_titleLength(){
				    return 30;
				}
				public Integer contact_titlePrecision(){
				    return 0;
				}
				public String contact_titleDefault(){
				
					return null;
				
				}
				public String contact_titleComment(){
				
				    return "";
				
				}
				public String contact_titlePattern(){
				
					return "";
				
				}
				public String contact_titleOriginalDbColumnName(){
				
					return "contact_title";
				
				}

				
			    public String address;

				public String getAddress () {
					return this.address;
				}

				public Boolean addressIsNullable(){
				    return true;
				}
				public Boolean addressIsKey(){
				    return false;
				}
				public Integer addressLength(){
				    return 60;
				}
				public Integer addressPrecision(){
				    return 0;
				}
				public String addressDefault(){
				
					return null;
				
				}
				public String addressComment(){
				
				    return "";
				
				}
				public String addressPattern(){
				
					return "";
				
				}
				public String addressOriginalDbColumnName(){
				
					return "address";
				
				}

				
			    public String city;

				public String getCity () {
					return this.city;
				}

				public Boolean cityIsNullable(){
				    return true;
				}
				public Boolean cityIsKey(){
				    return false;
				}
				public Integer cityLength(){
				    return 15;
				}
				public Integer cityPrecision(){
				    return 0;
				}
				public String cityDefault(){
				
					return null;
				
				}
				public String cityComment(){
				
				    return "";
				
				}
				public String cityPattern(){
				
					return "";
				
				}
				public String cityOriginalDbColumnName(){
				
					return "city";
				
				}

				
			    public String region;

				public String getRegion () {
					return this.region;
				}

				public Boolean regionIsNullable(){
				    return true;
				}
				public Boolean regionIsKey(){
				    return false;
				}
				public Integer regionLength(){
				    return 15;
				}
				public Integer regionPrecision(){
				    return 0;
				}
				public String regionDefault(){
				
					return null;
				
				}
				public String regionComment(){
				
				    return "";
				
				}
				public String regionPattern(){
				
					return "";
				
				}
				public String regionOriginalDbColumnName(){
				
					return "region";
				
				}

				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}

				public Boolean postal_codeIsNullable(){
				    return true;
				}
				public Boolean postal_codeIsKey(){
				    return false;
				}
				public Integer postal_codeLength(){
				    return 10;
				}
				public Integer postal_codePrecision(){
				    return 0;
				}
				public String postal_codeDefault(){
				
					return null;
				
				}
				public String postal_codeComment(){
				
				    return "";
				
				}
				public String postal_codePattern(){
				
					return "";
				
				}
				public String postal_codeOriginalDbColumnName(){
				
					return "postal_code";
				
				}

				
			    public String country;

				public String getCountry () {
					return this.country;
				}

				public Boolean countryIsNullable(){
				    return true;
				}
				public Boolean countryIsKey(){
				    return false;
				}
				public Integer countryLength(){
				    return 15;
				}
				public Integer countryPrecision(){
				    return 0;
				}
				public String countryDefault(){
				
					return null;
				
				}
				public String countryComment(){
				
				    return "";
				
				}
				public String countryPattern(){
				
					return "";
				
				}
				public String countryOriginalDbColumnName(){
				
					return "country";
				
				}

				
			    public String phone;

				public String getPhone () {
					return this.phone;
				}

				public Boolean phoneIsNullable(){
				    return true;
				}
				public Boolean phoneIsKey(){
				    return false;
				}
				public Integer phoneLength(){
				    return 24;
				}
				public Integer phonePrecision(){
				    return 0;
				}
				public String phoneDefault(){
				
					return null;
				
				}
				public String phoneComment(){
				
				    return "";
				
				}
				public String phonePattern(){
				
					return "";
				
				}
				public String phoneOriginalDbColumnName(){
				
					return "phone";
				
				}

				
			    public String fax;

				public String getFax () {
					return this.fax;
				}

				public Boolean faxIsNullable(){
				    return true;
				}
				public Boolean faxIsKey(){
				    return false;
				}
				public Integer faxLength(){
				    return 24;
				}
				public Integer faxPrecision(){
				    return 0;
				}
				public String faxDefault(){
				
					return null;
				
				}
				public String faxComment(){
				
				    return "";
				
				}
				public String faxPattern(){
				
					return "";
				
				}
				public String faxOriginalDbColumnName(){
				
					return "fax";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length) {
				if(length < 1024 && commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget.length == 0) {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[1024];
				} else {
   					commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length);
			strReturn = new String(commonByteArray_T801DIMANPRJ_Job_extractMySQL_loadTarget, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
					this.customer_id = readString(dis);
					
					this.company_name = readString(dis);
					
					this.contact_name = readString(dis);
					
					this.contact_title = readString(dis);
					
					this.address = readString(dis);
					
					this.city = readString(dis);
					
					this.region = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.country = readString(dis);
					
					this.phone = readString(dis);
					
					this.fax = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_T801DIMANPRJ_Job_extractMySQL_loadTarget) {

        	try {

        		int length = 0;
		
					this.customer_id = readString(dis);
					
					this.company_name = readString(dis);
					
					this.contact_name = readString(dis);
					
					this.contact_title = readString(dis);
					
					this.address = readString(dis);
					
					this.city = readString(dis);
					
					this.region = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.country = readString(dis);
					
					this.phone = readString(dis);
					
					this.fax = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.customer_id,dos);
					
					// String
				
						writeString(this.company_name,dos);
					
					// String
				
						writeString(this.contact_name,dos);
					
					// String
				
						writeString(this.contact_title,dos);
					
					// String
				
						writeString(this.address,dos);
					
					// String
				
						writeString(this.city,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.phone,dos);
					
					// String
				
						writeString(this.fax,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.customer_id,dos);
					
					// String
				
						writeString(this.company_name,dos);
					
					// String
				
						writeString(this.contact_name,dos);
					
					// String
				
						writeString(this.contact_title,dos);
					
					// String
				
						writeString(this.address,dos);
					
					// String
				
						writeString(this.city,dos);
					
					// String
				
						writeString(this.region,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.phone,dos);
					
					// String
				
						writeString(this.fax,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("customer_id="+customer_id);
		sb.append(",company_name="+company_name);
		sb.append(",contact_name="+contact_name);
		sb.append(",contact_title="+contact_title);
		sb.append(",address="+address);
		sb.append(",city="+city);
		sb.append(",region="+region);
		sb.append(",postal_code="+postal_code);
		sb.append(",country="+country);
		sb.append(",phone="+phone);
		sb.append(",fax="+fax);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(customer_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(customer_id);
            			}
            		
        			sb.append("|");
        		
        				if(company_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(company_name);
            			}
            		
        			sb.append("|");
        		
        				if(contact_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(contact_name);
            			}
            		
        			sb.append("|");
        		
        				if(contact_title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(contact_title);
            			}
            		
        			sb.append("|");
        		
        				if(address == null){
        					sb.append("<null>");
        				}else{
            				sb.append(address);
            			}
            		
        			sb.append("|");
        		
        				if(city == null){
        					sb.append("<null>");
        				}else{
            				sb.append(city);
            			}
            		
        			sb.append("|");
        		
        				if(region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(region);
            			}
            		
        			sb.append("|");
        		
        				if(postal_code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(postal_code);
            			}
            		
        			sb.append("|");
        		
        				if(country == null){
        					sb.append("<null>");
        				}else{
            				sb.append(country);
            			}
            		
        			sb.append("|");
        		
        				if(phone == null){
        					sb.append("<null>");
        				}else{
            				sb.append(phone);
            			}
            		
        			sb.append("|");
        		
        				if(fax == null){
        					sb.append("<null>");
        				}else{
            				sb.append(fax);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tDBInput_2", "9H4Who_");

	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		sh("tAdvancedHash_row2");
		
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tAdvancedHash_row2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



		

/**
 * [tAdvancedHash_row2 begin ] stop
 */




	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		sh("tDBInput_2");
		
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("HOST" + " = " + "context.Host");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PORT" + " = " + "context.Port");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("DBNAME" + " = " + "\"northwind\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USER" + " = " + "\"root\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:WpDJp1qv3oSlf0Fg0dJ8LQ/JFAH/GePZkqpEPTAkn4wWo+IBVw==").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"customers\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT    `customers`.`customer_id`,    `customers`.`company_name`,    `customers`.`contact_name`,    `customers`.`contact_title`,    `customers`.`address`,    `customers`.`city`,    `customers`.`region`,    `customers`.`postal_code`,    `customers`.`country`,    `customers`.`phone`,    `customers`.`fax`  FROM `customers`\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("customer_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("company_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("contact_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("contact_title")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("address")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("city")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("region")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("postal_code")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("country")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("phone")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("fax")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "\"customers\"", "tMysqlInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
		    calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "root";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:GQhLYbzxRBVvb+G8Wbp9Fd2jj2UV/hc4Ov7Qoedo/n10SowY5g==");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
        String properties_tDBInput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
            properties_tDBInput_2 = "";
        }
        String url_tDBInput_2 = "jdbc:mysql://" + context.Host + ":" + context.Port + "/" + "northwind" + "?" + properties_tDBInput_2;
				
	    		log.debug("tDBInput_2 - Driver ClassName: "+driverClass_tDBInput_2+".");
			
	    		log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '" + dbUser_tDBInput_2 + "'.");
			
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
	    		log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  `customers`.`customer_id`, \n  `customers`.`company_name`, \n  `customers`.`contact_name`, \n  `customers`.`cont"
+"act_title`, \n  `customers`.`address`, \n  `customers`.`city`, \n  `customers`.`region`, \n  `customers`.`postal_code`, \n  `"
+"customers`.`country`, \n  `customers`.`phone`, \n  `customers`.`fax`\n FROM `customers`";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

		    globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);

		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.customer_id = null;
							} else {
	                         		
        	row2.customer_id = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.company_name = null;
							} else {
	                         		
        	row2.company_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.contact_name = null;
							} else {
	                         		
        	row2.contact_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.contact_title = null;
							} else {
	                         		
        	row2.contact_title = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.address = null;
							} else {
	                         		
        	row2.address = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.city = null;
							} else {
	                         		
        	row2.city = routines.system.JDBCUtil.getString(rs_tDBInput_2, 6, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.region = null;
							} else {
	                         		
        	row2.region = routines.system.JDBCUtil.getString(rs_tDBInput_2, 7, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.postal_code = null;
							} else {
	                         		
        	row2.postal_code = routines.system.JDBCUtil.getString(rs_tDBInput_2, 8, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row2.country = null;
							} else {
	                         		
        	row2.country = routines.system.JDBCUtil.getString(rs_tDBInput_2, 9, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row2.phone = null;
							} else {
	                         		
        	row2.phone = routines.system.JDBCUtil.getString(rs_tDBInput_2, 10, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row2.fax = null;
							} else {
	                         		
        	row2.fax = routines.system.JDBCUtil.getString(rs_tDBInput_2, 11, false);
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					

 



		

/**
 * [tDBInput_2 begin ] stop
 */

	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		

 


	tos_count_tDBInput_2++;

		

/**
 * [tDBInput_2 main ] stop
 */

	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		

 



		

/**
 * [tDBInput_2 process_data_begin ] stop
 */


	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tDBInput_2","\"customers\"","tMysqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.customer_id = row2.customer_id;
				
				row2_HashRow.company_name = row2.company_name;
				
				row2_HashRow.contact_name = row2.contact_name;
				
				row2_HashRow.contact_title = row2.contact_title;
				
				row2_HashRow.address = row2.address;
				
				row2_HashRow.city = row2.city;
				
				row2_HashRow.region = row2.region;
				
				row2_HashRow.postal_code = row2.postal_code;
				
				row2_HashRow.country = row2.country;
				
				row2_HashRow.phone = row2.phone;
				
				row2_HashRow.fax = row2.fax;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

		

/**
 * [tAdvancedHash_row2 main ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	

 



		

/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	

 



		

/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */




	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		

 



		

/**
 * [tDBInput_2 process_data_end ] stop
 */

	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
	    		log.debug("tDBInput_2 - Closing the connection to the database.");
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_2 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




		

/**
 * [tDBInput_2 end ] stop
 */


	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	

tHash_Lookup_row2.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tDBInput_2","\"customers\"","tMysqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




		

/**
 * [tAdvancedHash_row2 end ] stop
 */




				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	s(currentComponent="tDBInput_2");
	
			
			
	
			cLabel="\"customers\"";
		

 



		

/**
 * [tDBInput_2 finally ] stop
 */


	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	s(currentComponent="tAdvancedHash_row2");
	
			
			
	

 



		

/**
 * [tAdvancedHash_row2 finally ] stop
 */




				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;


	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		sh("talendJobLog");
		
	
	s(currentComponent="talendJobLog");
	
			
			
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



		

/**
 * [talendJobLog begin ] stop
 */

	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 


	tos_count_talendJobLog++;

		

/**
 * [talendJobLog main ] stop
 */

	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_begin ] stop
 */

	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_end ] stop
 */

	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




		

/**
 * [talendJobLog end ] stop
 */

				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog finally ] stop
 */

				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;
    
    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final Job_extractMySQL_loadTarget Job_extractMySQL_loadTargetClass = new Job_extractMySQL_loadTarget();

        int exitCode = Job_extractMySQL_loadTargetClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Job_extractMySQL_loadTarget' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20240920_1319-patch"));
		
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }

        final boolean enableCBP = false;
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (!inOSGi) {
        if(org.talend.metrics.CBPClient.getInstanceForCurrentVM() == null) {
            try {
                org.talend.metrics.CBPClient.startListenIfNotStarted(enableCBP, true);
            } catch (java.lang.Exception e) {
                errorCode = 1;
                status = "failure";
                e.printStackTrace();
                return 1;
            }
        }
        }
        
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'Job_extractMySQL_loadTarget' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_C0bm0A99EfC2vO2gbn31CQ");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-04-02T07:53:15.394681900Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }

                if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
                    taskExecutionId = (String)jobProperties.get("taskExecutionId");
                }

                // extract ids from parent route
                if(null == taskExecutionId || taskExecutionId.isEmpty()){
                    for(String arg : args) {
                        if(arg.startsWith("--context_param")
                                && (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))){

                            String keyValue = arg.replace("--context_param", "");
                            String[] parts = keyValue.split("=");
                            String[] cleanParts = java.util.Arrays.stream(parts)
                                    .filter(s -> !s.isEmpty())
                                    .toArray(String[]::new);
                            if (cleanParts.length == 2) {
                                String key = cleanParts[0];
                                String value = cleanParts[1];
                                if ("taskExecutionId".equals(key.trim()) && null != value) {
                                    taskExecutionId = value.trim();
                                }else if ("jobExecutionId".equals(key.trim()) && null != value) {
                                    jobExecutionId = value.trim();
                                }
                            }
                        }
                    }
                }
            }

            // first load default key-value pairs from application.properties
            if(isStandaloneMS) {
                context.putAll(this.getDefaultProperties());
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Job_extractMySQL_loadTarget.class.getClassLoader().getResourceAsStream("t801dimanprj/job_extractmysql_loadtarget_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Job_extractMySQL_loadTarget.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                    if(isStandaloneMS) {
                        // override context key-value pairs if provided using --context=contextName
                        defaultProps.load(inContext);
                        context.putAll(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }
            // override key-value pairs if provided via --config.location=file1.file2 OR --config.additional-location=file1,file2
            if(isStandaloneMS) {
                context.putAll(this.getAdditionalProperties());
            }
            
            // override key-value pairs if provide via command line like --key1=value1,--key2=value2
            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("Host", "id_String");
                        if(context.getStringValue("Host") == null) {
                            context.Host = null;
                        } else {
                            context.Host=(String) context.getProperty("Host");
                        }
                        context.setContextType("Port", "id_String");
                        if(context.getStringValue("Port") == null) {
                            context.Port = null;
                        } else {
                            context.Port=(String) context.getProperty("Port");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("Host")) {
                context.Host = (String) parentContextMap.get("Host");
            }if (parentContextMap.containsKey("Port")) {
                context.Port = (String) parentContextMap.get("Port");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'Job_extractMySQL_loadTarget' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job_extractMySQL_loadTarget");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    if (!inOSGi) {
    if(org.talend.metrics.CBPClient.getInstanceForCurrentVM() != null) {
        s("none");
        org.talend.metrics.CBPClient.getInstanceForCurrentVM().sendData();
    }
    }

    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'Job_extractMySQL_loadTarget' - Finished - status: " + status + " returnCode: " + returnCode );

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {



    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--context_file")) {
        	String keyValue = arg.substring(15);
        	String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
        	java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
            try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int index = -1;
                    if ( (index = line.indexOf('=')) > -1) {
							if (line.startsWith("--context_param")) {
								if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
									context_param.put(line.substring(16, index), routines.system.PasswordEncryptUtil.decryptPassword(
											line.substring(index + 1)));
								} else {
									context_param.put(line.substring(16, index), line.substring(index + 1));
								}
							}else {//--context_type
								context_param.setContextType(line.substring(15, index), line.substring(index + 1));
							}
                    }
                }
            } catch (java.io.IOException e) {
            	System.err.println("Could not load the context file: " + filePath);
                e.printStackTrace();
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     209183 characters generated by Talend Real-time Big Data Platform 
 *     on the 2025년 4월 2일 오후 4시 53분 15초 KST
 ************************************************************************************************/