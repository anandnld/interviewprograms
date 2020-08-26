package com.prog;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class APDetails {

    private String apMac;
    private String prevDeviceIp;
    private String currentdeviceIp;
    
    public APDetails() {
        // TODO Auto-generated constructor stub
    }
    public APDetails(String apMac, String prevDeviceIp, String currentdeviceIp) {
        super();
        this.apMac = apMac;
        this.prevDeviceIp = prevDeviceIp;
        this.currentdeviceIp = currentdeviceIp;
    }
    
    public String getApMac() {
        return apMac;
    }
    public void setApMac(String apMac) {
        this.apMac = apMac;
    }
    public String getPrevDeviceIp() {
        return prevDeviceIp;
    }
    public void setPrevDeviceIp(String prevDeviceIp) {
        this.prevDeviceIp = prevDeviceIp;
    }
    public String getCurrentdeviceIp() {
        return currentdeviceIp;
    }
    public void setCurrentdeviceIp(String currentdeviceIp) {
        this.currentdeviceIp = currentdeviceIp;
    }
    
    @Override
    public String toString() {
    	return "VALUES ::: "+this.apMac + ": "+this.currentdeviceIp +" : "+this.prevDeviceIp;
    }
}

public class CollectionEmptyCheck {

    HashMap<String, Set<APDetails>> invCleanupCache = new HashMap<>();

	public static void main(String[] args) {
		Set<APDetails> cleanupApMacs = new HashSet <APDetails>();
		CollectionEmptyCheck obj = new CollectionEmptyCheck();
		cleanupApMacs = obj.getCleanupCache();
		if (isEmpty(cleanupApMacs)) {
			System.out.println("Empty set ");
			
			APDetails apObj = new APDetails("MAC","IP1","IP2");
			cleanupApMacs.add(apObj);
			System.out.println(apObj.toString());
			
			
		}else{
			System.out.println("set has values");
		}
	}
	
	public static boolean isEmpty(Collection coll) {
		return coll == null || coll.isEmpty();
	}
	
	 public Set<APDetails> getCleanupCache() {
	        if (invCleanupCache.get("KEY") != null) {
	            return invCleanupCache.get("KEY");
	        }
	        return Collections.emptySet();
	        //return new HashSet <APDetails>();
	    }
}
