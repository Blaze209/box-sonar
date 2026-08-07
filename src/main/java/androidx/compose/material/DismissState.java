package androidx.compose.material;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/DismissState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/DismissValue;", "initialValue", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;)V", "dismissDirection", "Landroidx/compose/material/DismissDirection;", "getDismissDirection", "()Landroidx/compose/material/DismissDirection;", "isDismissed", "direction", "reset", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAnalyticsParams.ACTION_DISMISS, "(Landroidx/compose/material/DismissDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(DismissValue dismissValue) {
        return true;
    }

    public DismissState(DismissValue dismissValue, Function1<? super DismissValue, Boolean> function1) {
        super(dismissValue, null, function1, 2, null);
    }

    public /* synthetic */ DismissState(DismissValue dismissValue, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dismissValue, (i & 2) != 0 ? new Function1() { // from class: androidx.compose.material.DismissState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DismissState._init_$lambda$0((DismissValue) obj));
            }
        } : function1);
    }

    public final DismissDirection getDismissDirection() {
        if (getOffset().getValue().floatValue() == 0.0f) {
            return null;
        }
        return getOffset().getValue().floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final boolean isDismissed(DismissDirection direction) {
        return getCurrentValue() == (direction == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart);
    }

    public final Object reset(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, DismissValue.Default, null, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object dismiss(DismissDirection dismissDirection, Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart, null, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/DismissState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DismissState;", "Landroidx/compose/material/DismissValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<DismissState, DismissValue> Saver(final Function1<? super DismissValue, Boolean> confirmStateChange) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.DismissState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DismissState.Companion.Saver$lambda$0((SaverScope) obj, (DismissState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material.DismissState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DismissState.Companion.Saver$lambda$1(confirmStateChange, (DismissValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DismissValue Saver$lambda$0(SaverScope saverScope, DismissState dismissState) {
            return dismissState.getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DismissState Saver$lambda$1(Function1 function1, DismissValue dismissValue) {
            return new DismissState(dismissValue, function1);
        }
    }
}
