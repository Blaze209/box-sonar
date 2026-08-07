package com.box.android.sync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.coreservices.services.IntentServices;

/* JADX INFO: loaded from: classes13.dex */
public class Authenticator extends AbstractAccountAuthenticator {
    private IntentServices mIntentServices;

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
        return null;
    }

    public Authenticator(Context context, IntentServices intentServices) {
        super(context);
        this.mIntentServices = intentServices;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
        Intent intentMainPhoneActivityIntent = this.mIntentServices.mainPhoneActivityIntent(BoxBaseApplication.getInstance());
        BoxPresentationUtils.displayToast("Already added sync account", BoxBaseApplication.getInstance().getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intentMainPhoneActivityIntent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }
}
