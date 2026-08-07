package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface IMultipleAccountPublicClientApplication extends IPublicClientApplication {

    public interface GetAccountCallback extends TaskCompletedCallbackWithError<IAccount, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(IAccount iAccount);
    }

    public interface RemoveAccountCallback {
        void onError(MsalException msalException);

        void onRemoved();
    }

    @Deprecated
    void acquireToken(Activity activity, String[] strArr, String str, AuthenticationCallback authenticationCallback);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireToken(AcquireTokenParameters acquireTokenParameters);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters acquireTokenSilentParameters) throws MsalException, InterruptedException;

    @Deprecated
    IAuthenticationResult acquireTokenSilent(String[] strArr, IAccount iAccount, String str) throws MsalException, InterruptedException;

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireTokenSilentAsync(AcquireTokenSilentParameters acquireTokenSilentParameters);

    @Deprecated
    void acquireTokenSilentAsync(String[] strArr, IAccount iAccount, String str, SilentAuthenticationCallback silentAuthenticationCallback);

    IAccount getAccount(String str) throws MsalException, InterruptedException;

    void getAccount(String str, GetAccountCallback getAccountCallback);

    List<IAccount> getAccounts() throws MsalException, InterruptedException;

    void getAccounts(IPublicClientApplication.LoadAccountsCallback loadAccountsCallback);

    void removeAccount(IAccount iAccount, RemoveAccountCallback removeAccountCallback);

    boolean removeAccount(IAccount iAccount) throws MsalException, InterruptedException;
}
