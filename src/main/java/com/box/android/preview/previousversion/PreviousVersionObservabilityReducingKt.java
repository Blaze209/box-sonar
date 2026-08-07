package com.box.android.preview.previousversion;

import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionObservabilityReducing.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"reduceObservability", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer;", "state", Analytics.Data.ACTION, "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionObservabilityReducingKt {
    public static final ReducerResult<PreviousVersionReducer.State, PreviousVersionReducer.Action> reduceObservability(PreviousVersionReducer previousVersionReducer, PreviousVersionReducer.State state, PreviousVersionReducer.Action action) {
        Intrinsics.checkNotNullParameter(previousVersionReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, previousVersionReducer, null)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionObservabilityReducingKt$reduceObservability$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviousVersionObservabilityReducing.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previousversion.PreviousVersionObservabilityReducingKt$reduceObservability$1", f = "PreviousVersionObservabilityReducing.kt", i = {}, l = {17, 21, 25, 30, 36, 42}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviousVersionReducer.Action $action;
        final /* synthetic */ PreviousVersionReducer $this_reduceObservability;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PreviousVersionReducer.Action action, PreviousVersionReducer previousVersionReducer, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reduceObservability = previousVersionReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.$this_reduceObservability, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
        
            if (r8.$this_reduceObservability.getEnvironment().getObservability().previewLoadingStarted(r8.$this_reduceObservability.getObservabilityId(), r8) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
        
            if (r8.$this_reduceObservability.getEnvironment().getObservability().updatePreviewerType(r8.$this_reduceObservability.getObservabilityId(), ((com.box.android.preview.previousversion.PreviousVersionReducer.Action.Ready) r8.$action).getPreviewData().getPreviewerType(), r8) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability.sendPreviewError$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), ((com.box.android.preview.previousversion.PreviousVersionReducer.Action.Error) r8.$action).getDomainError(), null, r8, 4, null) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c3, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00f1, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x011f, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0121, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previousversion.PreviousVersionObservabilityReducingKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
