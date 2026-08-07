package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSharedItemMessage extends BoxItemMessage {
    private static final String EXTRA_SHARED_LINK_URL = "shared_link_url";

    public void setSharedLinkUrl(String str) {
        putExtra(EXTRA_SHARED_LINK_URL, str);
    }

    public String getSharedLinkUrl() {
        return getStringExtra(EXTRA_SHARED_LINK_URL);
    }
}
