package com.infovass.catering.DM;

public class AppVersionResult {

    public String id ;
    public String user_id ;
    public String version ;
    public String android_version ;

    public AppVersionResult(String id, String user_id, String version,String android_version) {
        this.id = id;
        this.user_id = user_id;
        this.version = version;
        this.android_version = android_version;
    }

    public String getAndroid_version() {
        return android_version;
    }

    public void setAndroid_version(String android_version) {
        this.android_version = android_version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
