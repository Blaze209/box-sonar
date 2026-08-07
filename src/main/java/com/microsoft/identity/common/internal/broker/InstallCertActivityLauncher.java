package com.microsoft.identity.common.internal.broker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.microsoft.identity.common.PropertyBagUtil;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;

/* JADX INFO: loaded from: classes14.dex */
public final class InstallCertActivityLauncher extends AppCompatActivity {
    private static final String CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE = "Certificate installation failed with an empty response";
    private static final String INSTALL_CERT_BROADCAST_ALIAS = "install_cert_broadcast_alias";
    private static final String INSTALL_CERT_INTENT = "install_cert_intent";
    private static final String INSTALL_CERT_INTENT_STARTED = "broker_intent_started";
    private static final String TAG = "InstallCertActivityLauncher";
    private Intent mInstallCertificateIntent;
    private Boolean mInstallCertificateIntentStarted = false;
    private Boolean mInstallCertificateResultReceived = false;
    final ActivityResultLauncher<Intent> installCertActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.microsoft.identity.common.internal.broker.InstallCertActivityLauncher$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.m13843x16038ed7((ActivityResult) obj);
        }
    });

    /* JADX INFO: renamed from: lambda$new$0$com-microsoft-identity-common-internal-broker-InstallCertActivityLauncher, reason: not valid java name */
    /* synthetic */ void m13843x16038ed7(ActivityResult activityResult) {
        PropertyBag propertyBag;
        String str = TAG + "#installCertActivityResultLauncher";
        Logger.info(str, "Result received from Broker, Result code: " + activityResult.getResultCode());
        Intent data = activityResult.getData();
        if (data == null || data.getExtras() == null) {
            Logger.error(str, CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE, null);
            propertyBag = new PropertyBag();
        } else {
            propertyBag = PropertyBagUtil.fromBundle(data.getExtras());
        }
        this.mInstallCertificateResultReceived = true;
        LocalBroadcaster.INSTANCE.broadcast(INSTALL_CERT_BROADCAST_ALIAS, propertyBag);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.mInstallCertificateIntent = (Intent) extras.getParcelable(INSTALL_CERT_INTENT);
                return;
            } else {
                Logger.warn(str, "Extras is null.");
                return;
            }
        }
        this.mInstallCertificateIntent = (Intent) bundle.getParcelable(INSTALL_CERT_INTENT);
        this.mInstallCertificateIntentStarted = Boolean.valueOf(bundle.getBoolean(INSTALL_CERT_INTENT_STARTED));
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (this.mInstallCertificateIntentStarted.booleanValue()) {
            return;
        }
        this.mInstallCertificateIntentStarted = true;
        this.installCertActivityResultLauncher.launch(this.mInstallCertificateIntent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        if (!this.mInstallCertificateResultReceived.booleanValue()) {
            Logger.error(TAG, "The activity is killed unexpectedly.", null);
            LocalBroadcaster.INSTANCE.broadcast(INSTALL_CERT_BROADCAST_ALIAS, new PropertyBag());
        }
        super.onMAMDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        bundle.putParcelable(INSTALL_CERT_INTENT, this.mInstallCertificateIntent);
        bundle.putBoolean(INSTALL_CERT_INTENT_STARTED, this.mInstallCertificateIntentStarted.booleanValue());
    }

    public static void installCertificate(Activity activity, Intent intent, IInstallCertCallback iInstallCertCallback, String str, String str2) {
        Intent intent2 = new Intent(activity, (Class<?>) InstallCertActivityLauncher.class);
        intent2.putExtra(INSTALL_CERT_INTENT, intent);
        registerCallbackAndParseResult(iInstallCertCallback, str, str2);
        activity.startActivity(intent2);
    }

    private static void registerCallbackAndParseResult(final IInstallCertCallback iInstallCertCallback, final String str, final String str2) {
        LocalBroadcaster.INSTANCE.registerCallback(INSTALL_CERT_BROADCAST_ALIAS, new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.broker.InstallCertActivityLauncher$$ExternalSyntheticLambda0
            @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
            public final void onReceive(PropertyBag propertyBag) {
                InstallCertActivityLauncher.lambda$registerCallbackAndParseResult$1(str, str2, iInstallCertCallback, propertyBag);
            }
        });
    }

    static /* synthetic */ void lambda$registerCallbackAndParseResult$1(String str, String str2, IInstallCertCallback iInstallCertCallback, PropertyBag propertyBag) {
        String str3 = (String) propertyBag.get(str);
        String str4 = (String) propertyBag.get(str2);
        if (StringUtil.isNullOrEmpty(str4) && !StringUtil.isNullOrEmpty(str3)) {
            iInstallCertCallback.onSuccess(Boolean.parseBoolean(str3));
        } else {
            if (StringUtil.isNullOrEmpty(str4)) {
                str4 = CERT_INSTALLATION_FAILED_WITH_EMPTY_RESPONSE;
            }
            iInstallCertCallback.onError(new ClientException(ClientException.INSTALL_CERT_ERROR, str4));
        }
        LocalBroadcaster.INSTANCE.unregisterCallback(INSTALL_CERT_BROADCAST_ALIAS);
    }
}
