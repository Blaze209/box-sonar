package com.box.android.jobsui;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobListingScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class JobListingScreenKt$JobItem$3$1$2$1 implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstrainedLayoutReference $jobIcon;

    JobListingScreenKt$JobItem$3$1$2$1(ConstrainedLayoutReference constrainedLayoutReference) {
        this.$jobIcon = constrainedLayoutReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable start = constrainAs.getStart();
        ConstraintLayoutBaseScope.VerticalAnchor end = this.$jobIcon.getEnd();
        float f = 8;
        VerticalAnchorable.m10159linkToVpY3zN4$default(start, end, Dp.m9687constructorimpl(f), 0.0f, 4, null);
        HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getTop(), constrainAs.getParent().getTop(), Dp.m9687constructorimpl(f), 0.0f, 4, (Object) null);
        HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getBottom(), constrainAs.getParent().getBottom(), Dp.m9687constructorimpl(f), 0.0f, 4, (Object) null);
    }
}
