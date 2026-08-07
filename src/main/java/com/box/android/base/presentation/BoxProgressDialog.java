package com.box.android.base.presentation;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import androidx.navigation.compose.DialogNavigator;
import com.box.android.base.R;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxProgressDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ%\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/base/presentation/BoxProgressDialog;", "", "<init>", "()V", DialogNavigator.NAME, "Landroid/app/Dialog;", "show", "", "context", "Landroid/content/Context;", "titleRes", "", "messageRes", "(Landroid/content/Context;Ljava/lang/Integer;I)V", BoxAnalyticsParams.ACTION_DISMISS, "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxProgressDialog {
    public static final int $stable = 8;
    private Dialog dialog;

    public final void show(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        show(context, null, R.string.boxsdk_Please_wait);
    }

    public final void show(Context context, Integer titleRes, int messageRes) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        if (titleRes != null) {
            string = context.getResources().getString(titleRes.intValue());
        } else {
            string = null;
        }
        ProgressDialog progressDialogShow = ProgressDialog.show(context, string, context.getResources().getText(messageRes));
        this.dialog = progressDialogShow;
        if (progressDialogShow != null) {
            progressDialogShow.show();
        }
    }

    public final void dismiss() {
        Dialog dialog;
        Dialog dialog2 = this.dialog;
        if (dialog2 == null || !dialog2.isShowing() || (dialog = this.dialog) == null) {
            return;
        }
        dialog.dismiss();
    }
}
