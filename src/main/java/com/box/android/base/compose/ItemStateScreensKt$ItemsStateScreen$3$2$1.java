package com.box.android.base.compose;

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
final class ItemStateScreensKt$ItemsStateScreen$3$2$1 implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ boolean $shouldCenterContent;
    final /* synthetic */ ConstrainedLayoutReference $stateImage;

    ItemStateScreensKt$ItemsStateScreen$3$2$1(boolean z, ConstrainedLayoutReference constrainedLayoutReference) {
        this.$shouldCenterContent = z;
        this.$stateImage = constrainedLayoutReference;
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
            constrainAs.centerTo(constrainAs.getParent());
        } else {
            HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getTop(), this.$stateImage.getBottom(), 0.0f, 0.0f, 6, (Object) null);
            ConstrainScope.centerHorizontallyTo$default(constrainAs, constrainAs.getParent(), 0.0f, 2, null);
        }
    }
}
