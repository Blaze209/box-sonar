package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import com.box.android.domain.models.DomainError;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1", f = "CollectionsListReducer.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
public final class CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super CollectionsListReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    final /* synthetic */ DomainError $unwrappedError$inlined;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1(Flow flow, Continuation continuation, DomainError domainError) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$unwrappedError$inlined = domainError;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1 collectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1 = new CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1(this.$this_transform, continuation, this.$unwrappedError$inlined);
        collectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1.L$0 = obj;
        return collectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CollectionsListReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<CollectionsListReducer.Action> $$this$flow;
        final /* synthetic */ DomainError $unwrappedError$inlined;

        /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1$1", f = "CollectionsListReducer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {39, 44}, m = "emit", n = {"value", "$completion", "$this$invokeSuspend_u24lambda_u241_u240_u240", "collectionModels", "$i$a$-transform-CollectionsListReducer$reduceLoadCollections$effect$1$2$1$1", FirebaseAnalytics.Param.INDEX, "value", "$completion", "$this$invokeSuspend_u24lambda_u241_u240_u240", "collectionModels", "$i$a$-transform-CollectionsListReducer$reduceLoadCollections$effect$1$2$1$1", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
        public static final class C01541 extends ContinuationImpl {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            public C01541(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, DomainError domainError) {
            this.$unwrappedError$inlined = domainError;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00cc, code lost:
        
            if (r5.emit(r11, r0) == r1) goto L23;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1$invokeSuspend$lambda$1$0$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.$this_transform.collect(new AnonymousClass1(flowCollector, this.$unwrappedError$inlined), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
