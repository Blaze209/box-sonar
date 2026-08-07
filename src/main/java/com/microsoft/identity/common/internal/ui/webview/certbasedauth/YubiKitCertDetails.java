package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import com.yubico.yubikit.piv.Slot;
import java.security.cert.X509Certificate;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes14.dex */
public class YubiKitCertDetails implements ICertDetails {
    private final X509Certificate mCert;
    private final Slot mSlot;

    public YubiKitCertDetails(X509Certificate x509Certificate, Slot slot) {
        this.mCert = x509Certificate;
        this.mSlot = slot;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.ICertDetails
    public X509Certificate getCertificate() {
        return this.mCert;
    }

    @Nonnull
    public Slot getSlot() {
        return this.mSlot;
    }
}
