package com.box.android.common.extensions;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import androidx.activity.ComponentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"requireActivity", "Landroidx/activity/ComponentActivity;", "Landroid/content/Context;", "showAlertDialog", "", "config", "Lcom/box/android/common/extensions/DialogConfig;", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContextExtensionsKt {
    public static final ComponentActivity requireActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof ComponentActivity) {
            return (ComponentActivity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            throw new IllegalArgumentException("No activity found for context");
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        return requireActivity(baseContext);
    }

    public static final void showAlertDialog(Context context, final DialogConfig config) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        materialAlertDialogBuilder.setTitle(config.getTitleRes()).setMessage((CharSequence) config.getMessage()).setPositiveButton(config.getPositiveButtonRes(), new DialogInterface.OnClickListener() { // from class: com.box.android.common.extensions.ContextExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContextExtensionsKt.showAlertDialog$lambda$0(config, dialogInterface, i);
            }
        }).setNegativeButton(config.getNegativeButtonRes(), new DialogInterface.OnClickListener() { // from class: com.box.android.common.extensions.ContextExtensionsKt$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContextExtensionsKt.showAlertDialog$lambda$1(config, dialogInterface, i);
            }
        });
        Integer neutralButtonRes = config.getNeutralButtonRes();
        if (neutralButtonRes != null) {
            materialAlertDialogBuilder.setNeutralButton(neutralButtonRes.intValue(), new DialogInterface.OnClickListener() { // from class: com.box.android.common.extensions.ContextExtensionsKt$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContextExtensionsKt.showAlertDialog$lambda$2$0(config, dialogInterface, i);
                }
            });
        }
        materialAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.common.extensions.ContextExtensionsKt$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ContextExtensionsKt.showAlertDialog$lambda$3(config, dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$0(DialogConfig dialogConfig, DialogInterface dialogInterface, int i) {
        dialogConfig.getOnPositiveClick().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$1(DialogConfig dialogConfig, DialogInterface dialogInterface, int i) {
        dialogConfig.getOnNegativeClick().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$2$0(DialogConfig dialogConfig, DialogInterface dialogInterface, int i) {
        Function0<Unit> onNeutralClick = dialogConfig.getOnNeutralClick();
        if (onNeutralClick != null) {
            onNeutralClick.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$3(DialogConfig dialogConfig, DialogInterface dialogInterface) {
        Function0<Unit> onDismiss = dialogConfig.getOnDismiss();
        if (onDismiss != null) {
            onDismiss.invoke();
        }
    }
}
