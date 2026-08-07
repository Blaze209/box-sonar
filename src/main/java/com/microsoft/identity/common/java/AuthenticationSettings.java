package com.microsoft.identity.common.java;

import com.microsoft.identity.common.java.challengehandlers.IDeviceCertificateLoader;

/* JADX INFO: loaded from: classes14.dex */
public enum AuthenticationSettings {
    INSTANCE;

    private IDeviceCertificateLoader mCertificateLoader;

    public IDeviceCertificateLoader getCertificateLoader() {
        return this.mCertificateLoader;
    }

    public void setCertificateLoader(IDeviceCertificateLoader iDeviceCertificateLoader) {
        this.mCertificateLoader = iDeviceCertificateLoader;
    }
}
