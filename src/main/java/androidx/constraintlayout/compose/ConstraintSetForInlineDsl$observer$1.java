package androidx.constraintlayout.compose;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ConstraintSetForInlineDsl$observer$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConstraintSetForInlineDsl$observer$1(ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(1);
        this.this$0 = constraintSetForInlineDsl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Function0<Unit> function0) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Handler handler = this.this$0.handler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
                this.this$0.handler = handler;
            }
            handler.post(new Runnable() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$observer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
            return;
        }
        function0.invoke();
    }
}
