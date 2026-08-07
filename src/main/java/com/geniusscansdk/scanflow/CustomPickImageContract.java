package com.geniusscansdk.scanflow;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomPickImageContract.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/geniusscansdk/scanflow/CustomPickImageContract;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "supportedMimeTypes", "", "", "<init>", "(Ljava/util/List;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "Landroidx/activity/result/PickVisualMediaRequest;", "isSystemPickerAvailable", "", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPickImageContract extends ActivityResultContracts.PickVisualMedia {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> supportedMimeTypes;

    public CustomPickImageContract(List<String> supportedMimeTypes) {
        Intrinsics.checkNotNullParameter(supportedMimeTypes, "supportedMimeTypes");
        this.supportedMimeTypes = supportedMimeTypes;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia, androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, PickVisualMediaRequest input) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        super.createIntent(context, input);
        if (isSystemPickerAvailable()) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
        } else {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        }
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) this.supportedMimeTypes.toArray(new String[0]));
        return intent;
    }

    private final boolean isSystemPickerAvailable() {
        return Build.VERSION.SDK_INT >= 33 || SdkExtensions.getExtensionVersion(30) >= 2;
    }

    /* JADX INFO: compiled from: CustomPickImageContract.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/scanflow/CustomPickImageContract$Companion;", "", "<init>", "()V", "createRequest", "Landroidx/activity/result/PickVisualMediaRequest;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PickVisualMediaRequest createRequest() {
            return PickVisualMediaRequestKt.PickVisualMediaRequest$default(new ActivityResultContracts.PickVisualMedia.SingleMimeType("*/*"), 0, false, null, 14, null);
        }
    }
}
