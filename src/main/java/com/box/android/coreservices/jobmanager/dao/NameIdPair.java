package com.box.android.coreservices.jobmanager.dao;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class NameIdPair implements Serializable {
    private static final long serialVersionUID = 1;
    private final String mId;
    private final String mName;

    public NameIdPair(String str, String str2) {
        this.mName = str;
        this.mId = str2;
    }

    public String getName() {
        return this.mName;
    }

    public String getId() {
        return this.mId;
    }
}
