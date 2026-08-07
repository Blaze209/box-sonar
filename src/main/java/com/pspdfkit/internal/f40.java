package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.window.core.layout.WindowSizeClass;
import com.pspdfkit.R;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/f40;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class f40 extends AppCompatDialogFragment {
    public static final /* synthetic */ int d = 0;
    public l40 a;
    public w30 b;
    public h40 c;

    public f40() {
        CollectionsKt.emptyList();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        this.a = (l40) new ViewModelProvider(fragmentActivityRequireActivity, l40.e).get(l40.class);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new e40(this, null), 3, null);
        setStyle(2, R.style.PSPDFKit_Dialog_Light_Panel_Dim);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getClass();
        dialogOnCreateDialog.setCancelable(true);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        int[] iArr = h40.i;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.getTheme().obtainStyledAttributes(null, h40.i, h40.j, h40.k);
        typedArrayObtainStyledAttributes.getClass();
        int i = R.styleable.pspdf__StampPicker_pspdf__maxHeight;
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i, (int) un.a(contextRequireContext2, 1, 560));
        int i2 = R.styleable.pspdf__StampPicker_pspdf__maxWidth;
        Context contextRequireContext3 = requireContext();
        contextRequireContext3.getClass();
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(i2, (int) un.a(contextRequireContext3, 1, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
        typedArrayObtainStyledAttributes.recycle();
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i4 = getResources().getDisplayMetrics().heightPixels;
        boolean z = i3 < dimensionPixelSize2;
        boolean z2 = i4 < dimensionPixelSize;
        Window window = dialog.getWindow();
        if (window != null) {
            if (z) {
                dimensionPixelSize2 = -1;
            }
            if (z || z2) {
                dimensionPixelSize = -1;
            }
            window.setLayout(dimensionPixelSize2, dimensionPixelSize);
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setGravity(17);
        }
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.addFlags(67108864);
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setBackgroundDrawableResource(android.R.color.transparent);
        }
        h40 h40Var = this.c;
        if (h40Var != null) {
            h40Var.setFullscreen(z);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void setupDialog(Dialog dialog, int i) {
        dialog.getClass();
        super.setupDialog(dialog, i);
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        l40 l40Var = this.a;
        if (l40Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
            l40Var = null;
        }
        h40 h40Var = new h40(contextRequireContext, l40Var.b.getValue().d, new a());
        this.c = h40Var;
        dialog.setContentView(h40Var);
    }

    public static final class a {
        public a() {
        }

        public final void a(StampPickerItem stampPickerItem, boolean z) {
            x30 value;
            List<StampPickerItem> list;
            PointF pointF;
            int i;
            l40 l40Var = f40.this.a;
            if (l40Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                l40Var = null;
            }
            MutableStateFlow<x30> mutableStateFlow = l40Var.a;
            do {
                value = mutableStateFlow.getValue();
                x30 x30Var = value;
                list = x30Var.a;
                pointF = x30Var.b;
                i = x30Var.c;
                list.getClass();
            } while (!mutableStateFlow.compareAndSet(value, new x30(list, pointF, i, z)));
            w30 w30Var = f40.this.b;
            if (w30Var != null) {
                w30Var.a(stampPickerItem, z);
            }
        }

        public final void a() {
            f40 f40Var = f40.this;
            h40 h40Var = f40Var.c;
            if (h40Var != null) {
                ComposeView composeView = h40Var.e;
                ComposeView composeView2 = null;
                if (composeView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("visibleView");
                    composeView = null;
                }
                ComposeView composeView3 = h40Var.c;
                if (composeView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                    composeView3 = null;
                }
                if (composeView == composeView3) {
                    ComposeView composeView4 = h40Var.e;
                    if (composeView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("visibleView");
                        composeView4 = null;
                    }
                    ComposeView composeView5 = h40Var.d;
                    if (composeView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                        composeView5 = null;
                    }
                    if (composeView4 == composeView5) {
                        return;
                    }
                    ComposeView composeView6 = h40Var.d;
                    if (composeView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                        composeView6 = null;
                    }
                    h40Var.e = composeView6;
                    ComposeView composeView7 = h40Var.d;
                    if (composeView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                        composeView7 = null;
                    }
                    composeView7.bringToFront();
                    ComposeView composeView8 = h40Var.c;
                    if (composeView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                        composeView8 = null;
                    }
                    h40.a aVar = h40.a.LEFT_TO_RIGHT;
                    h40Var.b(composeView8, aVar);
                    ComposeView composeView9 = h40Var.d;
                    if (composeView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                    } else {
                        composeView2 = composeView9;
                    }
                    h40Var.a(composeView2, aVar);
                    return;
                }
                f40Var.dismiss();
            }
        }
    }
}
