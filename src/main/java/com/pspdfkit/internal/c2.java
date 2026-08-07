package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.BundleExtensions;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/c2;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class c2 extends DialogFragment {
    public lm a;
    public wu b;
    public x1.a c;
    public PdfFragment d;
    public at e;
    public PdfConfiguration f;
    public AnnotationConfigurationRegistry g;
    public AnnotationPreferencesManager h;

    public void a(Annotation annotation) {
        annotation.getClass();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (uc.a(activity, 540)) {
                setStyle(1, R.style.PSPDFKit_Dialog_Light);
            } else {
                setStyle(2, R.style.PSPDFKit_Dialog_Light_Panel_FullScreen);
            }
        }
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getClass();
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.pspdfkit.internal.c2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return c2.a(this.f$0, dialogInterface, i, keyEvent);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        x1 x1Var;
        z1.a aVar;
        lm document;
        dialogInterface.getClass();
        super.onDismiss(dialogInterface);
        x1.a aVar2 = this.c;
        if (aVar2 == null || (aVar = (x1Var = x1.this).c) == null || (document = z1.this.a.getDocument()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(z1.this.b), Dispatchers.getIO(), null, new y1(x1Var, document, z1.this, null), 2, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("annotation", this.b);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        FragmentActivity activity;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (activity = getActivity()) == null || !uc.a(activity, 540)) {
            return;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        boolean z = displayMetrics.heightPixels > displayMetrics.widthPixels;
        double d = z ? 0.85d : 0.5d;
        double d2 = z ? 0.7d : 0.85d;
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout((int) (((double) displayMetrics.widthPixels) * d), (int) (((double) displayMetrics.heightPixels) * d2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        lm lmVar;
        view.getClass();
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            wu wuVar = (wu) BundleExtensions.getSupportParcelable(bundle, "annotation", wu.class);
            this.b = wuVar;
            if (wuVar == null || (lmVar = this.a) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b2(wuVar, lmVar, this, null), 3, null);
        }
    }

    public static final boolean a(c2 c2Var, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        c2Var.dismiss();
        return true;
    }

    public final void a() {
        Context context = getContext();
        Dialog dialog = getDialog();
        if (context == null || dialog == null || dialog.getCurrentFocus() == null) {
            return;
        }
        Object systemService = context.getSystemService("input_method");
        systemService.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = dialog.getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
    }
}
