package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public interface IPublicClientApplication {

    public interface ApplicationCreatedListener {
        void onCreated(IPublicClientApplication iPublicClientApplication);

        void onError(MsalException msalException);
    }

    public interface DeviceCodeFlowCallback {
        void onError(MsalException msalException);

        void onTokenReceived(IAuthenticationResult iAuthenticationResult);

        void onUserCodeReceived(String str, String str2, String str3, Date date);
    }

    public interface IMultipleAccountApplicationCreatedListener {
        void onCreated(IMultipleAccountPublicClientApplication iMultipleAccountPublicClientApplication);

        void onError(MsalException msalException);
    }

    public interface ISingleAccountApplicationCreatedListener {
        void onCreated(ISingleAccountPublicClientApplication iSingleAccountPublicClientApplication);

        void onError(MsalException msalException);
    }

    public interface LoadAccountsCallback extends TaskCompletedCallbackWithError<List<IAccount>, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(List<IAccount> list);
    }

    public interface SignedHttpRequestRequestCallback extends TaskCompletedCallbackWithError<String, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(String str);
    }

    @Deprecated
    void acquireToken(Activity activity, String[] strArr, AuthenticationCallback authenticationCallback);

    void acquireToken(AcquireTokenParameters acquireTokenParameters);

    IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters acquireTokenSilentParameters) throws MsalException, InterruptedException;

    void acquireTokenSilentAsync(AcquireTokenSilentParameters acquireTokenSilentParameters);

    void acquireTokenWithDeviceCode(List<String> list, DeviceCodeFlowCallback deviceCodeFlowCallback);

    void acquireTokenWithDeviceCode(List<String> list, DeviceCodeFlowCallback deviceCodeFlowCallback, ClaimsRequest claimsRequest, UUID uuid);

    @Deprecated
    void acquireTokenWithDeviceCode(String[] strArr, DeviceCodeFlowCallback deviceCodeFlowCallback);

    String generateSignedHttpRequest(IAccount iAccount, PoPAuthenticationScheme poPAuthenticationScheme) throws MsalException;

    void generateSignedHttpRequest(IAccount iAccount, PoPAuthenticationScheme poPAuthenticationScheme, SignedHttpRequestRequestCallback signedHttpRequestRequestCallback);

    PublicClientApplicationConfiguration getConfiguration();

    PreferredAuthMethod getPreferredAuthConfiguration() throws BaseException;

    boolean isSharedDevice();
}
