package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout-T3LJ6Qw$1, reason: invalid class name */
/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "invoke", "(Landroidx/constraintlayout/compose/MotionLayoutScope;Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/MotionLayoutKt$MotionLayout$contentDelegate$1"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1 extends Lambda implements Function3<MotionLayoutScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$changed$inlined;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ Function2 $content$inlined;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ InvalidationStrategy $invalidationStrategy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1(MutableState mutableState, InvalidationStrategy invalidationStrategy, Ref ref, Function2 function2, int i) {
        super(3);
        this.$contentTracker = mutableState;
        this.$invalidationStrategy = invalidationStrategy;
        this.$compositionSource = ref;
        this.$content$inlined = function2;
        this.$$changed$inlined = i;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer, Integer num) {
        invoke(motionLayoutScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C162@7011L9:MotionLayout.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(284503157, i, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:152)");
        }
        this.$contentTracker.setValue(Unit.INSTANCE);
        if (this.$invalidationStrategy.getOnObservedStateChange() == null && this.$compositionSource.getValue() == CompositionSource.Unknown) {
            this.$compositionSource.setValue(CompositionSource.Content);
        }
        composer.startReplaceGroup(-2076156842);
        ComposerKt.sourceInformation(composer, "C794@33173L9:ConstraintLayout.kt#fysre8");
        this.$content$inlined.invoke(composer, Integer.valueOf((this.$$changed$inlined >> 15) & 14));
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
