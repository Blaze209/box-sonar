package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.http.KnownClouds;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceLookupThread extends Thread {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMServiceLookupThread.class);
    public static final String MAMSERVICE_URL_KEY = "mam.api.application";
    private final MAMServiceLookupCache mCache;
    private final Callback mCallback;
    private boolean mCheckForPolicy;
    private final Operations mOperations;
    private final MAMServiceSupportData mSupportData;

    public interface Callback {
        void onFailure(MAMEnrollmentManager.Result result, MAMWEError mAMWEError);

        void onSuccess(Map<String, String> map, String str);
    }

    public interface Operations {
        void acquireToken(MAMServiceSupportData mAMServiceSupportData);

        void getIsTargeted(MAMServiceSupportData mAMServiceSupportData);

        HttpURLConnection getLastConnection();

        String getLastRequestId();

        void getLookupServiceUrl(MAMServiceSupportData mAMServiceSupportData);

        void queryLookupService(MAMServiceSupportData mAMServiceSupportData);
    }

    public static class MAMServiceSupportData {
        public final MAMIdentity mIdentity;
        public Boolean mIsTargeted;
        public String mLookupServiceUrl;
        public String mMamServiceToken;
        public Map<String, String> mMamServiceUrls;
        public final String mPackageName;
        public MAMWEError mError = MAMWEError.NONE_KNOWN;
        public long mUnlicensedRetryIntervalMs = MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS;

        public String getMAMServiceUrl() {
            Map<String, String> map = this.mMamServiceUrls;
            if (map == null) {
                return null;
            }
            return map.get(MAMServiceLookupThread.MAMSERVICE_URL_KEY);
        }

        public MAMServiceSupportData(MAMIdentity mAMIdentity, String str) {
            this.mIdentity = mAMIdentity;
            this.mPackageName = str;
        }
    }

    MAMServiceLookupThread(MAMIdentity mAMIdentity, String str, MAMServiceLookupCache mAMServiceLookupCache, Callback callback, Operations operations) {
        super("MAMServiceLookupThread");
        this.mSupportData = new MAMServiceSupportData(mAMIdentity, str);
        this.mCache = mAMServiceLookupCache;
        this.mCallback = callback;
        this.mOperations = operations;
        this.mCheckForPolicy = false;
    }

    public void skipTokenAcquisition(String str) {
        this.mSupportData.mMamServiceToken = str;
    }

    public void setCheckForPolicy(boolean z) {
        this.mCheckForPolicy = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (!KnownClouds.isSupported(this.mSupportData.mIdentity.authority())) {
            this.mCallback.onFailure(MAMEnrollmentManager.Result.NOT_LICENSED, MAMWEError.NONE_KNOWN);
            return;
        }
        if (!acquireTokenIfNecessary()) {
            this.mCallback.onFailure(MAMEnrollmentManager.Result.AUTHORIZATION_NEEDED, this.mSupportData.mError);
            return;
        }
        if (!lookupServiceUrlIfNecessary()) {
            this.mCallback.onFailure(MAMEnrollmentManager.Result.NOT_LICENSED, this.mSupportData.mError);
        } else if (!checkForPolicyIfNecessary()) {
            this.mCallback.onFailure(MAMEnrollmentManager.Result.NOT_LICENSED, this.mSupportData.mError);
        } else {
            this.mCallback.onSuccess(this.mSupportData.mMamServiceUrls, this.mSupportData.mMamServiceToken);
        }
    }

    private boolean acquireTokenIfNecessary() {
        if (this.mSupportData.mMamServiceToken == null) {
            this.mOperations.acquireToken(this.mSupportData);
        }
        return this.mSupportData.mMamServiceToken != null;
    }

    private boolean lookupServiceUrlIfNecessary() {
        if (this.mSupportData.getMAMServiceUrl() != null) {
            return true;
        }
        MAMServiceSupportData mAMServiceSupportData = this.mSupportData;
        mAMServiceSupportData.mMamServiceUrls = this.mCache.getMAMServiceUrls(mAMServiceSupportData.mIdentity);
        if (this.mSupportData.getMAMServiceUrl() != null) {
            LOGGER.info("MAM Service URL retrieved from cache: " + this.mSupportData.getMAMServiceUrl(), new Object[0]);
        } else {
            lookupServiceUrlIfAllowed();
        }
        return this.mSupportData.getMAMServiceUrl() != null;
    }

    private void lookupServiceUrlIfAllowed() {
        if (!this.mCache.okToReQuery(this.mSupportData.mIdentity)) {
            LOGGER.warning("Skipping lookup service query since insufficient time has passed since the last attempt.", new Object[0]);
            return;
        }
        this.mOperations.getLookupServiceUrl(this.mSupportData);
        if (this.mSupportData.mLookupServiceUrl == null) {
            return;
        }
        this.mOperations.queryLookupService(this.mSupportData);
        if (this.mSupportData.mError != MAMWEError.NETWORK_ERROR) {
            this.mCache.setMAMServiceUrls(this.mSupportData.mIdentity, this.mSupportData.mMamServiceUrls, this.mSupportData.mUnlicensedRetryIntervalMs);
        } else {
            LOGGER.info("Not updating MAMServiceURL time after network error", new Object[0]);
        }
        if (this.mSupportData.getMAMServiceUrl() == null) {
            LOGGER.warning("failed to get a MAM Service URL", new Object[0]);
        } else {
            LOGGER.info("MAM Service URL: " + this.mSupportData.getMAMServiceUrl(), new Object[0]);
        }
    }

    private boolean checkForPolicyIfNecessary() {
        if (!this.mCheckForPolicy) {
            return true;
        }
        this.mOperations.getIsTargeted(this.mSupportData);
        return this.mSupportData.mIsTargeted != null && this.mSupportData.mIsTargeted.booleanValue();
    }
}
