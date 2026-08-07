package com.microsoft.identity.common.internal.broker;

import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.PropertyBagUtil;
import com.microsoft.identity.common.internal.result.BrokerResultAdapterFactory;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.app.MAMActivity;

/* JADX INFO: loaded from: classes14.dex */
public final class BrokerActivity extends MAMActivity {
    public static final String BROKER_INTENT = "broker_intent";
    static final int BROKER_INTENT_REQUEST_CODE = 1001;
    static final String BROKER_INTENT_STARTED = "broker_intent_started";
    private static final String TAG = "BrokerActivity";
    private Intent mBrokerInteractiveRequestIntent;
    private Boolean mBrokerIntentStarted = false;
    private Boolean mBrokerResultReceived = false;

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.mBrokerInteractiveRequestIntent = (Intent) extras.getParcelable(BROKER_INTENT);
                return;
            } else {
                Logger.warn(str, "Extras is null.");
                return;
            }
        }
        this.mBrokerInteractiveRequestIntent = (Intent) bundle.getParcelable(BROKER_INTENT);
        this.mBrokerIntentStarted = Boolean.valueOf(bundle.getBoolean(BROKER_INTENT_STARTED));
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (this.mBrokerIntentStarted.booleanValue()) {
            return;
        }
        this.mBrokerIntentStarted = true;
        startActivityForResult(this.mBrokerInteractiveRequestIntent, 1001);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        if (!this.mBrokerResultReceived.booleanValue()) {
            returnsExceptionOnActivityUnexpectedlyKilled();
        }
        super.onMAMDestroy();
    }

    private void returnsExceptionOnActivityUnexpectedlyKilled() {
        PropertyBag propertyBagFromBundle = PropertyBagUtil.fromBundle(BrokerResultAdapterFactory.getBrokerResultAdapter(SdkType.MSAL).bundleFromBaseException(new ClientException(ErrorStrings.BROKER_REQUEST_CANCELLED, "The activity is killed unexpectedly."), null));
        propertyBagFromBundle.put(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, 1003);
        propertyBagFromBundle.put(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, 2001);
        LocalBroadcaster.INSTANCE.broadcast(AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT, propertyBagFromBundle);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        bundle.putParcelable(BROKER_INTENT, this.mBrokerInteractiveRequestIntent);
        bundle.putBoolean(BROKER_INTENT_STARTED, this.mBrokerIntentStarted.booleanValue());
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        String str = TAG + ":onActivityResult";
        Logger.info(str, "Result received from Broker Request code: " + i + " Result code: " + i2);
        this.mBrokerResultReceived = true;
        if (i2 == 2004 || i2 == 2001 || i2 == 2002) {
            Logger.verbose(str, "Completing interactive request ");
            PropertyBag propertyBagFromBundle = PropertyBagUtil.fromBundle(intent.getExtras());
            propertyBagFromBundle.put(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, 1003);
            propertyBagFromBundle.put(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, Integer.valueOf(i2));
            LocalBroadcaster.INSTANCE.broadcast(AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT, propertyBagFromBundle);
        } else {
            returnsExceptionOnActivityUnexpectedlyKilled();
        }
        finish();
    }
}
