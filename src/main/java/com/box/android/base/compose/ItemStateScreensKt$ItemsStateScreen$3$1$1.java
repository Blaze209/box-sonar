package com.box.android.base.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemStateScreens.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class ItemStateScreensKt$ItemsStateScreen$3$1$1 implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ boolean $shouldCenterContent;
    final /* synthetic */ ConstrainedLayoutReference $stateTextColumn;

    ItemStateScreensKt$ItemsStateScreen$3$1$1(boolean z, ConstrainedLayoutReference constrainedLayoutReference) {
        this.$shouldCenterContent = z;
        this.$stateTextColumn = constrainedLayoutReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        if (this.$shouldCenterContent) {
            HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getBottom(), this.$stateTextColumn.getTop(), Dp.m9687constructorimpl(24), 0.0f, 4, (Object) null);
        } else {
            HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getTop(), constrainAs.getParent().getTop(), Dp.m9687constructorimpl(16), 0.0f, 4, (Object) null);
        }
        ConstrainScope.centerHorizontallyTo$default(constrainAs, constrainAs.getParent(), 0.0f, 2, null);
    }
}
