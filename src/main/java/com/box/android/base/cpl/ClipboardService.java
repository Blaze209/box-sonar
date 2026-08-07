package com.box.android.base.cpl;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import com.box.android.common.utilities.SdkVersionProvider;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IClipboardService.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/cpl/ClipboardService;", "Lcom/box/android/base/cpl/IClipboardService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardManager$delegate", "Lkotlin/Lazy;", "copyTextToClipboard", "", "textToCopy", "", "label", "getTextFromClipboard", "getHtmlTextFromClipboard", "hasPasteData", "", "shouldShowCopyNotification", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClipboardService implements IClipboardService {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: clipboardManager$delegate, reason: from kotlin metadata */
    private final Lazy clipboardManager;
    private final Context context;

    @Inject
    public ClipboardService(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.clipboardManager = LazyKt.lazy(new Function0() { // from class: com.box.android.base.cpl.ClipboardService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClipboardService.clipboardManager_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipboardManager clipboardManager_delegate$lambda$0(ClipboardService clipboardService) {
        Object systemService = clipboardService.context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }

    private final ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.clipboardManager.getValue();
    }

    @Override // com.box.android.base.cpl.IClipboardService
    public void copyTextToClipboard(String textToCopy, String label) {
        Intrinsics.checkNotNullParameter(textToCopy, "textToCopy");
        MAMClipboard.setPrimaryClip(getClipboardManager(), ClipData.newPlainText(label, textToCopy));
    }

    @Override // com.box.android.base.cpl.IClipboardService
    public String getTextFromClipboard() {
        CharSequence charSequenceCoerceToText;
        ClipData primaryClip = MAMClipboard.getPrimaryClip(getClipboardManager());
        ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
        if (itemAt == null || (charSequenceCoerceToText = itemAt.coerceToText(this.context)) == null) {
            return null;
        }
        return charSequenceCoerceToText.toString();
    }

    @Override // com.box.android.base.cpl.IClipboardService
    public String getHtmlTextFromClipboard() {
        ClipData primaryClip = MAMClipboard.getPrimaryClip(getClipboardManager());
        ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
        if (itemAt != null) {
            return itemAt.coerceToHtmlText(this.context);
        }
        return null;
    }

    @Override // com.box.android.base.cpl.IClipboardService
    public boolean hasPasteData() {
        ClipDescription primaryClipDescription;
        if (!MAMClipboard.hasPrimaryClip(getClipboardManager()) || (primaryClipDescription = MAMClipboard.getPrimaryClipDescription(getClipboardManager())) == null) {
            return false;
        }
        return primaryClipDescription.hasMimeType("text/plain") || primaryClipDescription.hasMimeType("text/html");
    }

    @Override // com.box.android.base.cpl.IClipboardService
    public boolean shouldShowCopyNotification() {
        return SdkVersionProvider.INSTANCE.getSdkVersion() < 33;
    }
}
