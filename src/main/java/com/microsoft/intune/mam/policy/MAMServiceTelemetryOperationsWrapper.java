package com.microsoft.intune.mam.policy;

import android.content.Context;
import com.microsoft.intune.mam.client.app.AppUtils;
import com.microsoft.intune.mam.client.telemetry.NetworkUtils;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.events.ServiceRequestEvent;
import com.microsoft.intune.mam.http.KnownClouds;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceTelemetryOperationsWrapper implements MAMServiceLookupThread.Operations {
    private final MAMServiceLookupThread.Operations mBaseOperations;
    private final Context mContext;
    private final String mOperationSessionGuid;
    private final TelemetryLogger mTelemetryLogger;

    public MAMServiceTelemetryOperationsWrapper(Context context, MAMServiceLookupThread.Operations operations, TelemetryLogger telemetryLogger, String str) {
        this.mContext = context;
        this.mBaseOperations = operations;
        this.mTelemetryLogger = telemetryLogger;
        this.mOperationSessionGuid = str;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void acquireToken(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        ServiceRequestEvent serviceRequestEventCreateServiceRequestEvent = createServiceRequestEvent("GetMAMServiceToken", "ADAL", null, mAMServiceSupportData);
        serviceRequestEventCreateServiceRequestEvent.startTimer();
        boolean z = true;
        try {
            this.mBaseOperations.acquireToken(mAMServiceSupportData);
        } finally {
            serviceRequestEventCreateServiceRequestEvent.stopTimer();
            serviceRequestEventCreateServiceRequestEvent.setAuthType(ServiceRequestEvent.AuthType.APIV2);
            if (mAMServiceSupportData != null && mAMServiceSupportData.mIdentity != null && mAMServiceSupportData.mIdentity.authority() != null) {
                serviceRequestEventCreateServiceRequestEvent.setTargetUri(mAMServiceSupportData.mIdentity.authority());
            }
            logServiceRequestEvent(serviceRequestEventCreateServiceRequestEvent, mAMServiceSupportData.mMamServiceToken != null);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void getLookupServiceUrl(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        ServiceRequestEvent serviceRequestEventCreateServiceRequestEvent = createServiceRequestEvent("GetLookupServiceUrl", "FWLink", KnownClouds.fromAuthority(mAMServiceSupportData.mIdentity.authority()).getMAMServiceFWLink(), mAMServiceSupportData);
        serviceRequestEventCreateServiceRequestEvent.startTimer();
        boolean z = true;
        try {
            this.mBaseOperations.getLookupServiceUrl(mAMServiceSupportData);
        } finally {
            serviceRequestEventCreateServiceRequestEvent.stopTimer();
            logServiceRequestEvent(serviceRequestEventCreateServiceRequestEvent, mAMServiceSupportData.mLookupServiceUrl != null);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void queryLookupService(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        ServiceRequestEvent serviceRequestEventCreateServiceRequestEvent = createServiceRequestEvent("GetMAMServiceUrl", "LookupService", mAMServiceSupportData.getMAMServiceUrl(), mAMServiceSupportData);
        serviceRequestEventCreateServiceRequestEvent.startTimer();
        boolean z = true;
        try {
            this.mBaseOperations.queryLookupService(mAMServiceSupportData);
        } finally {
            serviceRequestEventCreateServiceRequestEvent.stopTimer();
            logServiceRequestEvent(serviceRequestEventCreateServiceRequestEvent, mAMServiceSupportData.getMAMServiceUrl() != null);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void getIsTargeted(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        ServiceRequestEvent serviceRequestEventCreateServiceRequestEvent = createServiceRequestEvent("GetIsTargeted", "MAMService", mAMServiceSupportData.getMAMServiceUrl(), mAMServiceSupportData);
        serviceRequestEventCreateServiceRequestEvent.startTimer();
        boolean z = true;
        try {
            this.mBaseOperations.getIsTargeted(mAMServiceSupportData);
        } finally {
            serviceRequestEventCreateServiceRequestEvent.stopTimer();
            logServiceRequestEvent(serviceRequestEventCreateServiceRequestEvent, mAMServiceSupportData.mIsTargeted != null);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public HttpURLConnection getLastConnection() {
        return this.mBaseOperations.getLastConnection();
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public String getLastRequestId() {
        return this.mBaseOperations.getLastRequestId();
    }

    private ServiceRequestEvent createServiceRequestEvent(String str, String str2, String str3, MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        Context context = this.mContext;
        ServiceRequestEvent serviceRequestEvent = new ServiceRequestEvent(AppUtils.getPackageInfo(context, context.getPackageName()), str, str2, this.mOperationSessionGuid);
        serviceRequestEvent.setAADTenantID(mAMServiceSupportData.mIdentity.tenantId());
        if (str3 != null) {
            serviceRequestEvent.setDNSLookupTimeMS(NetworkUtils.measureDNSLookupTime(str3));
        }
        return serviceRequestEvent;
    }

    private void logServiceRequestEvent(ServiceRequestEvent serviceRequestEvent, boolean z) {
        serviceRequestEvent.setConnectionData(this.mContext, this.mBaseOperations.getLastConnection(), this.mBaseOperations.getLastRequestId());
        serviceRequestEvent.setSucceeded(z);
        this.mTelemetryLogger.logServiceRequest(serviceRequestEvent);
    }
}
