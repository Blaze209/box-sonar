package com.microsoft.intune.mam.policy;

import android.content.Context;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMServiceLookupThreadFactory {
    private MAMServiceAuthenticationCallbackExtended mAuthCallback;
    private MAMServiceLookupThread.Callback mCallback;
    private final Context mContext;
    private MAMIdentity mIdentity;
    private MAMServiceQueryParameters mMAMServiceQueryParameters;
    private String mOperationSessionGuid;
    private final String mPackageName;
    private MAMServiceLookupCache mServiceLookupCache;
    private SSLSocketFactory mSocketFactory;
    private TelemetryLogger mTelemetryLogger;

    public MAMServiceLookupThreadFactory(Context context, String str) {
        this.mContext = context;
        this.mPackageName = str;
    }

    public MAMServiceLookupThread build() {
        validateParams();
        return new MAMServiceLookupThread(this.mIdentity, this.mPackageName, this.mServiceLookupCache, this.mCallback, constructOperations());
    }

    public MAMServiceLookupThreadFactory setIdentity(MAMIdentity mAMIdentity) {
        this.mIdentity = mAMIdentity;
        return this;
    }

    public MAMServiceLookupThreadFactory setLookupCache(MAMServiceLookupCache mAMServiceLookupCache) {
        this.mServiceLookupCache = mAMServiceLookupCache;
        return this;
    }

    public MAMServiceLookupThreadFactory setCallback(MAMServiceLookupThread.Callback callback) {
        this.mCallback = callback;
        return this;
    }

    public MAMServiceLookupThreadFactory setTelemetryInfo(TelemetryLogger telemetryLogger, String str) {
        this.mTelemetryLogger = telemetryLogger;
        this.mOperationSessionGuid = str;
        return this;
    }

    public MAMServiceLookupThreadFactory setMAMServiceQueryParameters(MAMServiceQueryParameters mAMServiceQueryParameters) {
        this.mMAMServiceQueryParameters = mAMServiceQueryParameters;
        return this;
    }

    public MAMServiceLookupThreadFactory setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSocketFactory = sSLSocketFactory;
        return this;
    }

    public MAMServiceLookupThreadFactory setAuthenticationCallback(MAMServiceAuthenticationCallbackExtended mAMServiceAuthenticationCallbackExtended) {
        this.mAuthCallback = mAMServiceAuthenticationCallbackExtended;
        return this;
    }

    private MAMServiceLookupThread.Operations constructOperations() {
        return new MAMServiceTelemetryOperationsWrapper(this.mContext, new MAMServiceLookupOperationsImpl(this.mContext, this.mSocketFactory, this.mAuthCallback, this.mMAMServiceQueryParameters), this.mTelemetryLogger, this.mOperationSessionGuid);
    }

    private void validateParams() {
        if (this.mContext == null || this.mPackageName == null) {
            throw new IllegalArgumentException();
        }
        if (this.mIdentity == null) {
            throw new IllegalArgumentException();
        }
        if (this.mServiceLookupCache == null || this.mCallback == null) {
            throw new IllegalArgumentException();
        }
        if (this.mTelemetryLogger == null || this.mOperationSessionGuid == null) {
            throw new IllegalArgumentException();
        }
    }
}
