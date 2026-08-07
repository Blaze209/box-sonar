package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.StampAnnotationConfiguration;
import com.pspdfkit.annotations.stamps.PredefinedStampType;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.Size;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class w30 extends p7 {
    public final l40 f;
    public final AnnotationConfigurationRegistry g;
    public PointF h;
    public f40 i;

    public w30(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        this.g = q0Var.f.getAnnotationConfiguration();
        Context context = q0Var.a;
        context.getClass();
        this.f = (l40) new ViewModelProvider((ComponentActivity) context, l40.e).get(l40.class);
    }

    @Override // com.pspdfkit.internal.p7
    public final void a(float f, float f2) {
        au auVarL;
        if (this.a.s == AnnotationTool.STAMP && (auVarL = l()) != null) {
            PointF pointF = new PointF(f, f2);
            this.h = pointF;
            l4.a(auVarL.a((Matrix) null), pointF);
            StampAnnotationConfiguration stampAnnotationConfiguration = (StampAnnotationConfiguration) this.g.get(AnnotationType.STAMP, StampAnnotationConfiguration.class);
            List<StampPickerItem> stampsForPicker = stampAnnotationConfiguration == null ? Collections.EMPTY_LIST : stampAnnotationConfiguration.getStampsForPicker();
            if (stampsForPicker.size() == 1) {
                a(stampsForPicker.get(0), false);
                return;
            }
            l40 l40Var = this.f;
            x30 x30Var = new x30(stampsForPicker, this.h, k(), false);
            l40Var.getClass();
            MutableStateFlow<x30> mutableStateFlow = l40Var.a;
            while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), x30Var)) {
            }
            FragmentManager parentFragmentManager = this.a.f.getParentFragmentManager();
            int i = f40.d;
            parentFragmentManager.getClass();
            f40 f40Var = (f40) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.stamps.StampPickerDialog.FRAGMENT_TAG");
            if (f40Var == null) {
                f40Var = new f40();
                f40Var.setArguments(new Bundle());
            }
            f40Var.b = this;
            if (!f40Var.isAdded()) {
                f40Var.show(parentFragmentManager, "com.pspdfkit.ui.dialog.stamps.StampPickerDialog.FRAGMENT_TAG");
            }
            this.i = f40Var;
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 12;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.STAMP;
    }

    @Override // com.pspdfkit.internal.p7
    public final void m() {
        f40 f40Var = this.i;
        if (f40Var != null) {
            f40Var.dismiss();
        }
    }

    public final void a(StampPickerItem stampPickerItem, boolean z) {
        ComposeView composeView = null;
        if (z) {
            Context context = this.a.a;
            context.getClass();
            StampPickerItem stampPickerItemBuild = StampPickerItem.fromPredefinedType(context, PredefinedStampType.CUSTOM).withTitle("").withSubtitle(stampPickerItem.getSubtitle()).withSize(stampPickerItem.getDefaultPdfWidth(), stampPickerItem.getDefaultPdfHeight()).withTextColor(-15459505).build();
            f40 f40Var = this.i;
            if (f40Var != null) {
                l40 l40Var = f40Var.a;
                if (l40Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                    l40Var = null;
                }
                MutableStateFlow<StampPickerItem> mutableStateFlow = l40Var.c;
                while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), stampPickerItemBuild)) {
                }
                h40 h40Var = this.i.c;
                if (h40Var != null) {
                    ComposeView composeView2 = h40Var.e;
                    if (composeView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("visibleView");
                        composeView2 = null;
                    }
                    ComposeView composeView3 = h40Var.c;
                    if (composeView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                        composeView3 = null;
                    }
                    if (composeView2 != composeView3) {
                        ComposeView composeView4 = h40Var.c;
                        if (composeView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                            composeView4 = null;
                        }
                        h40Var.e = composeView4;
                        ComposeView composeView5 = h40Var.c;
                        if (composeView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                            composeView5 = null;
                        }
                        composeView5.bringToFront();
                        ComposeView composeView6 = h40Var.d;
                        if (composeView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                            composeView6 = null;
                        }
                        h40.a aVar = h40.a.RIGHT_TO_LEFT;
                        h40Var.b(composeView6, aVar);
                        ComposeView composeView7 = h40Var.c;
                        if (composeView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                        } else {
                            composeView = composeView7;
                        }
                        h40Var.a(composeView, aVar);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            }
            return;
        }
        PointF pointF = this.h;
        if (pointF != null) {
            Size pageSize = j().getPageSize(k());
            float fMax = Math.max(32.0f, Math.min(stampPickerItem.getDefaultPdfWidth(), pageSize.width));
            float fMax2 = Math.max(32.0f, Math.min(stampPickerItem.getDefaultPdfHeight(), pageSize.height));
            float f = pointF.x;
            float f2 = pointF.y;
            float f3 = fMax / 2.0f;
            float f4 = fMax2 / 2.0f;
            RectF rectF = new RectF(f - f3, f2 + f4, f + f3, f2 - f4);
            ff.a(rectF, new RectF(0.0f, pageSize.height, pageSize.width, 0.0f));
            StampAnnotation stampAnnotationCreateStampAnnotation = stampPickerItem.createStampAnnotation(k());
            stampAnnotationCreateStampAnnotation.setBoundingBox(rectF);
            stampAnnotationCreateStampAnnotation.setRotation(0, new Size(rectF.width(), rectF.height()));
            q0 q0Var = this.a;
            q0Var.getClass();
            ww.a(q0Var.g, stampAnnotationCreateStampAnnotation);
            stampAnnotationCreateStampAnnotation.getInternal().setVariant(q0Var.t);
            this.a.f.addAnnotationToPage(stampAnnotationCreateStampAnnotation, true, null);
            f40 f40Var2 = this.i;
            if (f40Var2 != null) {
                f40Var2.dismiss();
            }
        }
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        this.a.a(this);
        FragmentManager parentFragmentManager = this.a.f.getParentFragmentManager();
        int i = f40.d;
        parentFragmentManager.getClass();
        f40 f40Var = (f40) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.stamps.StampPickerDialog.FRAGMENT_TAG");
        if (f40Var != null) {
            l40 l40Var = f40Var.a;
            l40 l40Var2 = null;
            if (l40Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                l40Var = null;
            }
            if (l40Var.b.getValue().c == k()) {
                FragmentManager parentFragmentManager2 = this.a.f.getParentFragmentManager();
                parentFragmentManager2.getClass();
                f40 f40Var2 = (f40) parentFragmentManager2.findFragmentByTag("com.pspdfkit.ui.dialog.stamps.StampPickerDialog.FRAGMENT_TAG");
                if (f40Var2 != null) {
                    f40Var2.b = this;
                }
                this.i = f40Var2;
                if (f40Var2 != null) {
                    l40 l40Var3 = f40Var2.a;
                    if (l40Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                    } else {
                        l40Var2 = l40Var3;
                    }
                    this.h = l40Var2.b.getValue().b;
                }
            }
        }
    }
}
