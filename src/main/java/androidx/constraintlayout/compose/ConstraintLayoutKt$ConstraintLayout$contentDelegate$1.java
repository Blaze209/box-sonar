package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class ConstraintLayoutKt$ConstraintLayout$contentDelegate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ Ref<CompositionSource> $compositionSource;
    final /* synthetic */ Function3<ConstraintLayoutScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MutableState<Unit> $contentTracker;
    final /* synthetic */ MutableState<ConstraintSet> $end;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ MutableState<ConstraintSet> $start;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConstraintLayoutKt$ConstraintLayout$contentDelegate$1(MutableState<Unit> mutableState, Ref<CompositionSource> ref, ConstraintLayoutScope constraintLayoutScope, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Channel<ConstraintSet> channel, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$content = function3;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
            }
            this.$contentTracker.setValue(Unit.INSTANCE);
            if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
                this.$compositionSource.setValue(CompositionSource.Content);
            }
            this.$scope.reset();
            this.$content.invoke(this.$scope, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$scope) | composer.changedInstance(this.$channel);
            final ConstraintLayoutScope constraintLayoutScope = this.$scope;
            final MutableState<ConstraintSet> mutableState = this.$start;
            final MutableState<ConstraintSet> mutableState2 = this.$end;
            final Channel<ConstraintSet> channel = this.$channel;
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$contentDelegate$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope.getContainerObject().mo10168clone());
                        if (mutableState.getValue() == null || mutableState2.getValue() == null) {
                            mutableState.setValue(rawConstraintSet);
                            mutableState2.setValue(mutableState.getValue());
                        } else {
                            channel.mo11206trySendJP2dKIU(rawConstraintSet);
                        }
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
