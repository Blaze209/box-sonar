package com.box.android.preview.preview.previewbar.topbar;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.Dimension;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PreviewTopBarKt$PreviewTopBar$1$3$1 implements Function1<ConstrainScope, Unit> {
    public static final PreviewTopBarKt$PreviewTopBar$1$3$1 INSTANCE = new PreviewTopBarKt$PreviewTopBar$1$3$1();

    PreviewTopBarKt$PreviewTopBar$1$3$1() {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        ConstrainScope.m9965linkTo8ZKsbrE$default(constrainAs, constrainAs.getParent().getStart(), constrainAs.getParent().getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 60, (Object) null);
        constrainAs.setWidth(Dimension.INSTANCE.getFillToConstraints());
    }
}
