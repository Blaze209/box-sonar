package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;

/* JADX INFO: loaded from: classes14.dex */
public class MsalIntuneAppProtectionPolicyRequiredException extends MsalServiceException {
    private String mAccountUpn;
    private String mAccountUserId;
    private String mAuthorityUrl;
    private String mTenantId;

    public MsalIntuneAppProtectionPolicyRequiredException(IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException) {
        super(intuneAppProtectionPolicyRequiredException.getErrorCode(), intuneAppProtectionPolicyRequiredException.getMessage(), intuneAppProtectionPolicyRequiredException);
        this.mAccountUpn = intuneAppProtectionPolicyRequiredException.getAccountUpn();
        this.mAccountUserId = intuneAppProtectionPolicyRequiredException.getAccountUserId();
        this.mAuthorityUrl = intuneAppProtectionPolicyRequiredException.getAuthorityUrl();
        this.mTenantId = intuneAppProtectionPolicyRequiredException.getTenantId();
    }

    public String getAccountUpn() {
        return this.mAccountUpn;
    }

    public String getAccountUserId() {
        return this.mAccountUserId;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public String getAuthorityUrl() {
        return this.mAuthorityUrl;
    }
}
