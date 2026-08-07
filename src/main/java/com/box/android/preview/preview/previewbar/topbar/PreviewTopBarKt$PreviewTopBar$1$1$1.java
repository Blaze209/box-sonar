package com.box.android.preview.preview.previewbar.topbar;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PreviewTopBarKt$PreviewTopBar$1$1$1 implements Function1<ConstrainScope, Unit> {
    public static final PreviewTopBarKt$PreviewTopBar$1$1$1 INSTANCE = new PreviewTopBarKt$PreviewTopBar$1$1$1();

    PreviewTopBarKt$PreviewTopBar$1$1$1() {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable.m10159linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), 0.0f, 0.0f, 6, null);
    }
}
