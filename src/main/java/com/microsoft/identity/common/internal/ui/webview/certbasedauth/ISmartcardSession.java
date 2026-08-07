package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import java.security.PrivateKey;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface ISmartcardSession {
    List<ICertDetails> getCertDetailsList() throws Exception;

    PrivateKey getKeyForAuth(ICertDetails iCertDetails, char[] cArr) throws Exception;

    int getPinAttemptsRemaining() throws Exception;

    boolean verifyPin(char[] cArr) throws Exception;
}
