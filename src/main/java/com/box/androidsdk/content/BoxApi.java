package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApi {
    protected String mBaseUploadUri;
    protected String mBaseUri;
    protected BoxSession mSession;

    public BoxApi(BoxSession boxSession) {
        this.mBaseUri = BoxConstants.BASE_URI;
        this.mBaseUploadUri = BoxConstants.BASE_UPLOAD_URI;
        this.mSession = boxSession;
        if (boxSession == null || !boxSession.isAppFedrampHighCompliant()) {
            return;
        }
        this.mBaseUri = BoxConstants.BASE_URI_FEDRAMP_COMPLIANT;
        this.mBaseUploadUri = BoxConstants.BASE_UPLOAD_URI_FEDRAMP_COMPLIANT;
    }

    protected String getBaseUri() {
        BoxSession boxSession = this.mSession;
        if (boxSession != null && boxSession.getAuthInfo() != null && this.mSession.getAuthInfo().getBaseDomain() != null) {
            return String.format(BoxConstants.BASE_URI_TEMPLATE, this.mSession.getAuthInfo().getBaseDomain());
        }
        return this.mBaseUri;
    }

    protected String getBaseUploadUri() {
        BoxSession boxSession = this.mSession;
        if (boxSession != null && boxSession.getAuthInfo() != null && this.mSession.getAuthInfo().getBaseDomain() != null) {
            return String.format(BoxConstants.BASE_UPLOAD_URI_TEMPLATE, this.mSession.getAuthInfo().getBaseDomain());
        }
        return this.mBaseUploadUri;
    }
}
