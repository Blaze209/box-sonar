package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
final class ConstraintLayoutKt$ConstraintLayout$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ ConstraintSet $constraintSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$3$1(Channel<ConstraintSet> channel, ConstraintSet constraintSet) {
        super(0);
        this.$channel = channel;
        this.$constraintSet = constraintSet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$channel.mo11206trySendJP2dKIU(this.$constraintSet);
    }
}
