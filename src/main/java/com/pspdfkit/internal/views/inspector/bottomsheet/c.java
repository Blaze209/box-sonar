package com.pspdfkit.internal.views.inspector.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements AccessibilityViewCommand {
    public final /* synthetic */ int a;
    public final /* synthetic */ BottomSheetBehavior b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.b = bottomSheetBehavior;
        this.a = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        this.b.c(this.a);
        return true;
    }
}
