package com.dbing.bean;

import java.util.ArrayList;
import java.util.List;

public class TPermission {
    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;

    private List childPermission = new ArrayList();

    public List getChildPermission() {
        return childPermission;
    }

    public void setChildPermission(List childPermission) {
        this.childPermission = childPermission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        return "TPermission{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", childPermission=" + childPermission +
                '}';
    }
}