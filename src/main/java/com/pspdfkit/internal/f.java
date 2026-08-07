package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pspdfkit.R;
import com.pspdfkit.ui.actionmenu.ActionMenuItem;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f extends BottomSheetDialogFragment {
    public static final /* synthetic */ int e = 0;
    public h a;
    public List<ActionMenuItem> b;
    public String c;
    public a d;

    public interface a {
        void onClickOnMenuItem(f fVar, ActionMenuItem actionMenuItem);

        void onDismiss(f fVar);

        boolean onLongClickOnMenuItem(f fVar, ActionMenuItem actionMenuItem);

        void onShow(f fVar);
    }

    public final void a(Dialog dialog, int i, DialogInterface dialogInterface) {
        int i2 = getResources().getDisplayMetrics().widthPixels;
        Window window = dialog.getWindow();
        int i3 = -1;
        if (i2 < i) {
            i = -1;
        }
        String str = Build.DEVICE;
        if (str != null && str.matches(".+_cheets")) {
            i3 = -2;
        }
        window.setLayout(i, i3);
        dialog.getWindow().setGravity(1);
        a aVar = this.d;
        if (aVar != null) {
            aVar.onShow(this);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        setStyle(2, R.style.PSPDFKit_BottomSheetDialog);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getWindow().addFlags(67108864);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.d;
        if (aVar != null) {
            aVar.onDismiss(this);
        }
        this.a = null;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void setupDialog(final Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, h.k, h.l, h.m);
        final int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ActionMenu_pspdf__maxWidth, a80.a(getContext(), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
        typedArrayObtainStyledAttributes.recycle();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.pspdfkit.internal.f$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.a(dialog, dimensionPixelSize, dialogInterface);
            }
        });
        h hVar = new h(this);
        this.a = hVar;
        String str = this.c;
        if (str != null) {
            hVar.f.setVisibility(0);
            hVar.f.setTitle(str);
        }
        List<ActionMenuItem> list = this.b;
        if (list != null) {
            this.a.a(list);
        }
        dialog.setContentView(this.a);
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) this.a.getParent());
        if (bottomSheetBehaviorFrom != null) {
            h hVar2 = this.a;
            bottomSheetBehaviorFrom.setPeekHeight((int) ((((double) a80.a(getContext(), 120)) * 2.5d) + ((double) (hVar2.f.getVisibility() == 0 ? hVar2.f.getTitleHeight() : 0))));
        }
        this.a.requestLayout();
    }
}
