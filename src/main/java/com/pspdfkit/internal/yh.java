package com.pspdfkit.internal;

import android.os.Looper;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class yh implements vh {
    public final go<FormManager.OnFormElementSelectedListener> a = new go<>();
    public final go<FormManager.OnFormElementDeselectedListener> b = new go<>();
    public final go<FormManager.OnFormElementUpdatedListener> c = new go<>();
    public final go<FormManager.OnFormElementEditingModeChangeListener> d = new go<>();
    public final go<FormManager.OnFormElementClickedListener> e = new go<>();
    public final go<FormManager.OnFormElementViewUpdatedListener> f = new go<>();
    public final go<FormManager.OnTextFormElementSuggestionRequestListener> g = new go<>();

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementClickedListener(FormManager.OnFormElementClickedListener onFormElementClickedListener) {
        this.e.addFirst(onFormElementClickedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementDeselectedListener(FormManager.OnFormElementDeselectedListener onFormElementDeselectedListener) {
        this.b.a(onFormElementDeselectedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementEditingModeChangeListener(FormManager.OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener) {
        this.d.a(onFormElementEditingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementSelectedListener(FormManager.OnFormElementSelectedListener onFormElementSelectedListener) {
        this.a.a(onFormElementSelectedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementUpdatedListener(FormManager.OnFormElementUpdatedListener onFormElementUpdatedListener) {
        this.c.a(onFormElementUpdatedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnFormElementViewUpdatedListener(FormManager.OnFormElementViewUpdatedListener onFormElementViewUpdatedListener) {
        this.f.a(onFormElementViewUpdatedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void addOnTextFormElementSuggestionRequestListener(FormManager.OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener) {
        this.g.a(onTextFormElementSuggestionRequestListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementClickedListener(FormManager.OnFormElementClickedListener onFormElementClickedListener) {
        this.e.b(onFormElementClickedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementDeselectedListener(FormManager.OnFormElementDeselectedListener onFormElementDeselectedListener) {
        this.b.b(onFormElementDeselectedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementEditingModeChangeListener(FormManager.OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener) {
        this.d.b(onFormElementEditingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementSelectedListener(FormManager.OnFormElementSelectedListener onFormElementSelectedListener) {
        this.a.b(onFormElementSelectedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementUpdatedListener(FormManager.OnFormElementUpdatedListener onFormElementUpdatedListener) {
        this.c.b(onFormElementUpdatedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnFormElementViewUpdatedListener(FormManager.OnFormElementViewUpdatedListener onFormElementViewUpdatedListener) {
        this.f.b(onFormElementViewUpdatedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public final void removeOnTextFormElementSuggestionRequestListener(FormManager.OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener) {
        this.g.b(onTextFormElementSuggestionRequestListener);
    }

    public static void a() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Form listeners touched on non ui thread.");
        }
    }
}
