package com.geniusscansdk.scanflow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.content.IntentCompat;
import androidx.room.FtsOptions;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseKeyStorage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanFlow.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanFlow;", "", "<init>", "()V", ScanFlow.SCAN_CONFIGURATION_KEY, "", ScanFlow.SCAN_RESULT_KEY, ScanFlow.ERROR_KEY, "SCAN_REQUEST", "", "scanWithConfiguration", "", "activity", "Landroid/app/Activity;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "createScanFlowIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getScanResultFromActivityResult", "Lcom/geniusscansdk/scanflow/ScanResult;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "setLicenseKey", "licenseKey", "autoRefresh", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanFlow {
    public static final String ERROR_KEY = "ERROR_KEY";
    public static final ScanFlow INSTANCE = new ScanFlow();
    public static final String SCAN_CONFIGURATION_KEY = "SCAN_CONFIGURATION_KEY";
    public static final int SCAN_REQUEST = 42;
    public static final String SCAN_RESULT_KEY = "SCAN_RESULT_KEY";

    private ScanFlow() {
    }

    @JvmStatic
    public static final void scanWithConfiguration(Activity activity, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        activity.startActivityForResult(createScanFlowIntent(activity, scanConfiguration), 42);
    }

    @JvmStatic
    public static final Intent createScanFlowIntent(Context context, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        SharedPreferences sharedPreferences = context.getSharedPreferences(LicenseKeyStorage.PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LicenseKeyStorage.INTEGRATION_MODE_KEY, FtsOptions.TOKENIZER_SIMPLE);
        editorEdit.apply();
        Intent intent = new Intent(context, (Class<?>) ScanActivity.class);
        intent.putExtra(SCAN_CONFIGURATION_KEY, scanConfiguration);
        return intent;
    }

    @JvmStatic
    public static final ScanResult getScanResultFromActivityResult(Intent result) throws Exception {
        Intrinsics.checkNotNullParameter(result, "result");
        Exception exc = (Exception) IntentCompat.getSerializableExtra(result, ERROR_KEY, Exception.class);
        if (exc != null) {
            throw exc;
        }
        Serializable serializableExtra = IntentCompat.getSerializableExtra(result, SCAN_RESULT_KEY, ScanResult.class);
        Intrinsics.checkNotNull(serializableExtra);
        return (ScanResult) serializableExtra;
    }

    @JvmStatic
    public static final void setLicenseKey(Context context, String licenseKey, boolean autoRefresh) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        GeniusScanSDK.setLicenseKey(context, licenseKey, autoRefresh);
    }
}
