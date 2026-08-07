package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
final class ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl $constraintSet;
    final /* synthetic */ MutableState<Boolean> $remeasureRequesterState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1(MutableState<Boolean> mutableState, ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(0);
        this.$remeasureRequesterState = mutableState;
        this.$constraintSet = constraintSetForInlineDsl;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MutableState<Boolean> mutableState = this.$remeasureRequesterState;
        mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
        this.$constraintSet.setKnownDirty(true);
    }
}
