package com.box.android.localrepo;

import android.content.Context;
import android.util.Log;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.BoxAuthMap;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes12.dex */
public class LocalAuthStorage extends BoxAuthentication.AuthStorage {
    IMoCoBoxGlobalSettings mMoCoBoxGlobalSettings;
    Integer mSizeOfRefreshToken = 0;

    public LocalAuthStorage(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        this.mMoCoBoxGlobalSettings = iMoCoBoxGlobalSettings;
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthStorage
    protected void storeAuthInfoMap(Map<String, BoxAuthentication.BoxAuthenticationInfo> map, Context context) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = map.get(it.next());
            BoxUser user = boxAuthenticationInfo.getUser();
            if (user != null) {
                try {
                    this.mMoCoBoxGlobalSettings.addCurrentUserData(boxAuthenticationInfo).get();
                    if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
                        try {
                            CommonBoxUtil.writeToFile(CommonBoxUtil.getCrashReportFile(), "storeAuthInfo " + user.toJson() + "->" + boxAuthenticationInfo.toJson() + "\n", true, true);
                        } catch (Exception unused) {
                        }
                    }
                    int iValueOf = 0;
                    if (boxAuthenticationInfo.refreshToken() != null) {
                        iValueOf = Integer.valueOf(boxAuthenticationInfo.refreshToken().length());
                    }
                    BoxAmplitudeAnalytics.createEventBuilder().setRefreshTokenSize(iValueOf).setRefreshTokenLoadedSize(this.mSizeOfRefreshToken).setAuthInfoStorageStackTrace(getCurrentStackTrace()).logEvent(BoxAnalyticsParams.EVENT_AUTH_INFO_STOAGE_UPDATED);
                } catch (InterruptedException e) {
                    Log.e(LocalAuthStorage.class.getName(), "InterruptedException ", e);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e2) {
                    Log.e(LocalAuthStorage.class.getName(), "ExecutionException ", e2);
                }
            }
        }
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthStorage
    protected void clearAuthInfoMap(Context context) {
        try {
            BoxAuthMap payload = ((BoxLocalUsersDataMessage) this.mMoCoBoxGlobalSettings.getAllUsersData().get()).getPayload();
            if (payload != null) {
                Iterator<BoxAuthentication.BoxAuthenticationInfo> it = payload.iterator();
                while (it.hasNext()) {
                    this.mMoCoBoxGlobalSettings.removeUserData(it.next().getUser().getUserId()).get();
                }
            }
            this.mMoCoBoxGlobalSettings.setLastRememberedUserName(null);
            BoxAmplitudeAnalytics.createEventBuilder().setAuthInfoStorageStackTrace(getCurrentStackTrace()).logEvent(BoxAnalyticsParams.EVENT_AUTH_INFO_STOAGE_CLEARED);
        } catch (InterruptedException e) {
            BoxLogUtils.logException(e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        }
    }

    public void updateUser(BoxUser boxUser, BoxSession boxSession) {
        BoxAuthentication.BoxAuthenticationInfo authInfo = boxSession.getAuthInfo();
        if (authInfo == null || boxUser == null || authInfo.getUser() == null || !boxUser.getUserId().equals(authInfo.getUser().getUserId())) {
            return;
        }
        try {
            authInfo.setUser(boxUser);
            this.mMoCoBoxGlobalSettings.addCurrentUserData(authInfo).get();
        } catch (InterruptedException e) {
            Log.e(LocalAuthStorage.class.getName(), "InterruptedException ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            Log.e(LocalAuthStorage.class.getName(), "ExecutionException ", e2);
        }
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthStorage
    public void storeLastAuthenticatedUserId(String str, Context context) {
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            try {
                CommonBoxUtil.writeToFile(CommonBoxUtil.getCrashReportFile(), "storeLastAuthenticatedUser " + str + "\n", true, true);
            } catch (Exception unused) {
            }
        }
        this.mMoCoBoxGlobalSettings.setLastRememberedUserName(str);
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthStorage
    protected String getLastAuthentictedUserId(Context context) {
        return this.mMoCoBoxGlobalSettings.getLastRememberedUserName();
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthStorage
    protected ConcurrentHashMap<String, BoxAuthentication.BoxAuthenticationInfo> loadAuthInfoMap(Context context) {
        ConcurrentHashMap<String, BoxAuthentication.BoxAuthenticationInfo> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            BoxAuthMap payload = ((BoxLocalUsersDataMessage) this.mMoCoBoxGlobalSettings.getAllUsersData().get()).getPayload();
            if (payload != null) {
                for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo : payload) {
                    if (boxAuthenticationInfo.getUser() != null) {
                        concurrentHashMap.put(boxAuthenticationInfo.getUser().getUserId(), boxAuthenticationInfo);
                        if (!SdkUtils.isBlank(boxAuthenticationInfo.refreshToken())) {
                            String strRefreshToken = boxAuthenticationInfo.refreshToken();
                            String decryptedToken = this.mMoCoBoxGlobalSettings.getDecryptedToken(strRefreshToken);
                            boxAuthenticationInfo.setRefreshToken(decryptedToken);
                            if (boxAuthenticationInfo.refreshToken() != null) {
                                this.mSizeOfRefreshToken = Integer.valueOf(boxAuthenticationInfo.refreshToken().length());
                            }
                            if (decryptedToken != null && (decryptedToken.length() == strRefreshToken.length() || decryptedToken.length() != 64)) {
                                BoxLogUtils.d("refreshToken problem", "decryptedToken length " + decryptedToken.length() + " encrypted " + strRefreshToken.length());
                            }
                        }
                        if (!SdkUtils.isBlank(boxAuthenticationInfo.accessToken())) {
                            boxAuthenticationInfo.setAccessToken(this.mMoCoBoxGlobalSettings.getDecryptedToken(boxAuthenticationInfo.accessToken()));
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            BoxLogUtils.logException(e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        }
        return concurrentHashMap;
    }

    private String getCurrentStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Integer numValueOf = 13;
        if (stackTrace.length < numValueOf.intValue()) {
            numValueOf = Integer.valueOf(stackTrace.length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i < numValueOf.intValue(); i++) {
            sb.append(stackTrace[i].getMethodName() + ":" + stackTrace[i].getLineNumber() + "|");
        }
        return sb.toString();
    }
}
