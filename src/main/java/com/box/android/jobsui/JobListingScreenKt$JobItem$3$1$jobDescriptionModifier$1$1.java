package com.box.android.jobsui;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobListingScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1 implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstrainedLayoutReference $jobName;
    final /* synthetic */ ConstrainedLayoutReference $secondaryAction;

    JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1(ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2) {
        this.$jobName = constrainedLayoutReference;
        this.$secondaryAction = constrainedLayoutReference2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable.m10159linkToVpY3zN4$default(constrainAs.getStart(), this.$jobName.getStart(), 0.0f, 0.0f, 6, null);
        float f = 8;
        HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getTop(), this.$jobName.getBottom(), Dp.m9687constructorimpl(f), 0.0f, 4, (Object) null);
        HorizontalAnchorable.m10065linkToVpY3zN4$default(constrainAs.getBottom(), constrainAs.getParent().getBottom(), Dp.m9687constructorimpl(f), 0.0f, 4, (Object) null);
        VerticalAnchorable.m10159linkToVpY3zN4$default(constrainAs.getEnd(), this.$secondaryAction.getStart(), Dp.m9687constructorimpl(f), 0.0f, 4, null);
        constrainAs.setWidth(Dimension.INSTANCE.getFillToConstraints());
    }
}
