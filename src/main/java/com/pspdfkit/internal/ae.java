package com.pspdfkit.internal;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.ui.dialog.DocumentPrintDialog;

/* JADX INFO: loaded from: classes3.dex */
public final class ae implements DocumentPrintDialog.PrintDialogListener {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ be b;

    public ae(be beVar, FragmentActivity fragmentActivity) {
        this.b = beVar;
        this.a = fragmentActivity;
    }

    @Override // com.pspdfkit.ui.dialog.DocumentPrintDialog.PrintDialogListener
    public final void onAccept(PrintOptions printOptions) {
        this.b.c = false;
        DocumentPrintManager.get().print(this.a, this.b.a, printOptions);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ANNOTATION_PROCESSING_MODE, printOptions.getAnnotationProcessingMode().name());
        i0VarA.a(Analytics.Event.PRINT, bundle);
    }

    @Override // com.pspdfkit.ui.dialog.DocumentPrintDialog.PrintDialogListener
    public final void onDismiss() {
        this.b.c = false;
    }
}
