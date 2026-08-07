package com.box.androidsdk.content.models;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public class BoxSharedLinkSession extends BoxSession {
    String mPassword;
    String mSharedLink;

    public BoxSharedLinkSession(BoxSession boxSession) {
        super(boxSession);
        if (boxSession instanceof BoxSharedLinkSession) {
            BoxSharedLinkSession boxSharedLinkSession = (BoxSharedLinkSession) boxSession;
            setSharedLink(boxSharedLinkSession.getSharedLink());
            setPassword(boxSharedLinkSession.getPassword());
        }
    }

    public BoxSharedLinkSession(Context context, boolean z) {
        super(context, z);
    }

    public BoxSharedLinkSession(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, str, str2, str3, str4, z);
    }

    public String getSharedLink() {
        return this.mSharedLink;
    }

    public BoxSharedLinkSession setSharedLink(String str) {
        this.mSharedLink = str;
        return this;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public BoxSharedLinkSession setPassword(String str) {
        this.mPassword = str;
        return this;
    }
}
