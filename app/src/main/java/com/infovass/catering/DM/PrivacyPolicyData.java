package com.infovass.catering.DM;

public class PrivacyPolicyData {

    public String id ;
    public String page_name ;
    public String title ;
    public String content;
    public String content_arabic ;
    public String created_at ;
    public String updated_at ;

    public PrivacyPolicyData(String id, String page_name, String title, String content, String content_arabic, String created_at, String updated_at) {
        this.id = id;
        this.page_name = page_name;
        this.title = title;
        this.content = content;
        this.content_arabic = content_arabic;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_arabic() {
        return content_arabic;
    }

    public void setContent_arabic(String content_arabic) {
        this.content_arabic = content_arabic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
