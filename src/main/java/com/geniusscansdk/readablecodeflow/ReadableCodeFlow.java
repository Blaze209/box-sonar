package com.geniusscansdk.readablecodeflow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.IntentCompat;
import androidx.room.FtsOptions;
import com.geniusscansdk.core.LicenseKeyStorage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableCodeFlow.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlow;", "", "<init>", "()V", "REQUEST_CODE", "", "createContract", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlowResult;", "scanWithConfiguration", "", "activity", "Landroid/app/Activity;", "configuration", "getResultFromActivityResult", "intent", "Landroid/content/Intent;", "ReadableCodeFlowContract", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeFlow {
    public static final ReadableCodeFlow INSTANCE = new ReadableCodeFlow();
    public static final int REQUEST_CODE = 43;

    private ReadableCodeFlow() {
    }

    public final ActivityResultContract<ReadableCodeConfiguration, ReadableCodeFlowResult> createContract() {
        return new ReadableCodeFlowContract();
    }

    @JvmStatic
    public static final void scanWithConfiguration(Activity activity, ReadableCodeConfiguration configuration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        activity.startActivityForResult(new ReadableCodeFlowContract().createIntent((Context) activity, configuration), 43);
    }

    @JvmStatic
    public static final ReadableCodeFlowResult getResultFromActivityResult(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return (ReadableCodeFlowResult) IntentCompat.getParcelableExtra(intent, ReadableCodeScanActivity.RESULT_KEY, ReadableCodeFlowResult.class);
    }

    /* JADX INFO: compiled from: ReadableCodeFlow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlow$ReadableCodeFlowContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlowResult;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ReadableCodeFlowContract extends ActivityResultContract<ReadableCodeConfiguration, ReadableCodeFlowResult> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, ReadableCodeConfiguration input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            SharedPreferences sharedPreferences = context.getSharedPreferences(LicenseKeyStorage.PREFERENCES_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(LicenseKeyStorage.INTEGRATION_MODE_KEY, FtsOptions.TOKENIZER_SIMPLE);
            editorEdit.apply();
            Intent intent = new Intent(context, (Class<?>) ReadableCodeScanActivity.class);
            intent.putExtra(ReadableCodeScanActivity.CONFIGURATION_KEY, input);
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ReadableCodeFlowResult parseResult(int resultCode, Intent intent) {
            if (resultCode == -1 && intent != null) {
                Object parcelableExtra = IntentCompat.getParcelableExtra(intent, ReadableCodeScanActivity.RESULT_KEY, ReadableCodeFlowResult.class);
                Intrinsics.checkNotNull(parcelableExtra);
                return (ReadableCodeFlowResult) parcelableExtra;
            }
            return ReadableCodeFlowResult.Canceled.INSTANCE;
        }
    }
}
