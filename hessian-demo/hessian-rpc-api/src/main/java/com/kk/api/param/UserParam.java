package com.kk.api.param;

import java.io.Serializable;

public class UserParam implements Serializable {
    private static final long serialVersionUID = 1l;
    
    private int id;
    private String realname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
