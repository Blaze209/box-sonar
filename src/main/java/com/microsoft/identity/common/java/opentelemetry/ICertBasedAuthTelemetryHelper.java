package com.microsoft.identity.common.java.opentelemetry;

/* JADX INFO: loaded from: classes14.dex */
public interface ICertBasedAuthTelemetryHelper {
    void setCertBasedAuthChallengeHandler(String str);

    void setExistingPivProviderPresent(boolean z);

    void setPublicKeyAlgoType(String str);

    void setResultFailure(Exception exc);

    void setResultFailure(String str);

    void setResultSuccess();

    void setUserChoice(CertBasedAuthChoice certBasedAuthChoice);
}
