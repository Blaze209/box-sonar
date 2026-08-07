package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.exception.MsalException;

/* JADX INFO: loaded from: classes14.dex */
public interface ISingleAccountPublicClientApplication extends IPublicClientApplication {

    public interface CurrentAccountCallback {
        void onAccountChanged(IAccount iAccount, IAccount iAccount2);

        void onAccountLoaded(IAccount iAccount);

        void onError(MsalException msalException);
    }

    public interface SignOutCallback {
        void onError(MsalException msalException);

        void onSignOut();
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters acquireTokenSilentParameters) throws MsalException, InterruptedException;

    @Deprecated
    IAuthenticationResult acquireTokenSilent(String[] strArr, String str) throws MsalException, InterruptedException;

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireTokenSilentAsync(AcquireTokenSilentParameters acquireTokenSilentParameters);

    @Deprecated
    void acquireTokenSilentAsync(String[] strArr, String str, SilentAuthenticationCallback silentAuthenticationCallback);

    ICurrentAccountResult getCurrentAccount() throws MsalException, InterruptedException;

    void getCurrentAccountAsync(CurrentAccountCallback currentAccountCallback);

    @Deprecated
    void signIn(Activity activity, String str, String[] strArr, AuthenticationCallback authenticationCallback);

    @Deprecated
    void signIn(Activity activity, String str, String[] strArr, Prompt prompt, AuthenticationCallback authenticationCallback);

    void signIn(SignInParameters signInParameters);

    @Deprecated
    void signInAgain(Activity activity, String[] strArr, Prompt prompt, AuthenticationCallback authenticationCallback);

    void signInAgain(SignInParameters signInParameters);

    void signOut(SignOutCallback signOutCallback);

    boolean signOut() throws MsalException, InterruptedException;
}
