package com.box.android.cpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;

/* JADX INFO: compiled from: Effect.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0019B%\b\u0016\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096@¢\u0006\u0002\u0010\u0014J+\u0010\u0015\u001a\u00020\u00112\u001e\u0010\u0016\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0017\"\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u0018R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/cpl/Effect;", "Action", "Lkotlinx/coroutines/flow/Flow;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "(Ljava/lang/Object;)V", "flow", "(Lkotlinx/coroutines/flow/Flow;)V", "cancellable", "id", "cancelInFlight", "", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "merge", "effects", "", "([Lcom/box/android/cpl/Effect;)V", "Companion", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Effect<Action> implements Flow<Action> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Flow<? extends Action> flow;

    public Effect(Flow<? extends Action> flow) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        this.flow = flow;
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Effect$1, reason: invalid class name */
    /* JADX INFO: compiled from: Effect.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Action", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Effect$1", f = "Effect.kt", i = {}, l = {16, 16}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Action>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Action>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L46
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super Action>, java.lang.Object> r6 = r5.$block
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r5)
                if (r6 != r0) goto L37
                goto L45
            L37:
                r3 = r5
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r4 = 0
                r5.L$0 = r4
                r5.label = r2
                java.lang.Object r5 = r1.emit(r6, r3)
                if (r5 != r0) goto L46
            L45:
                return r0
            L46:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.cpl.Effect.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Effect$2, reason: invalid class name */
    /* JADX INFO: compiled from: Effect.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Action", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Effect$2", f = "Effect.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$value = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (((FlowCollector) this.L$0).emit(this.$value, this) == coroutine_suspended) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Effect(Function1<? super Continuation<? super Action>, ? extends Object> block) {
        this(FlowKt.flow(new AnonymousClass1(block, null)));
        Intrinsics.checkNotNullParameter(block, "block");
    }

    public Effect(Action action) {
        this(FlowKt.flow(new AnonymousClass2(action, null)));
    }

    /* JADX INFO: compiled from: Effect.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0001J5\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000f\"\u0002H\u0005¢\u0006\u0002\u0010\u0010J7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u001e\u0010\u0011\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000f\"\b\u0012\u0004\u0012\u0002H\u00050\u0004¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/box/android/cpl/Effect$Companion;", "", "()V", "cancel", "Lcom/box/android/cpl/Effect;", "Action", "id", "fireAndForget", "work", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lcom/box/android/cpl/Effect;", "merge", "actions", "", "([Ljava/lang/Object;)Lcom/box/android/cpl/Effect;", "effects", "([Lcom/box/android/cpl/Effect;)Lcom/box/android/cpl/Effect;", "none", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <Action> Effect<Action> none() {
            return new Effect<>(FlowKt.emptyFlow());
        }

        public final <Action> Effect<Action> merge(Effect<Action>... effects) {
            Intrinsics.checkNotNullParameter(effects, "effects");
            return EffectKt.toEffect(FlowKt.merge(ArraysKt.asList(effects)));
        }

        public final <Action> Effect<Action> merge(Action... actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            List listAsList = ArraysKt.asList(actions);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAsList, 10));
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                arrayList.add(new Effect(it.next()));
            }
            return EffectKt.toEffect(FlowKt.merge(arrayList));
        }

        public final <Action> Effect<Action> fireAndForget(Function1<? super Continuation<? super Unit>, ? extends Object> work) {
            Intrinsics.checkNotNullParameter(work, "work");
            return new Effect<>(FlowKt.flow(new Effect$Companion$fireAndForget$1(work, null)));
        }

        public final <Action> Effect<Action> cancel(Object id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Effect<>(FlowKt.flow(new Effect$Companion$cancel$1(id, null)));
        }
    }

    public final void merge(Effect<Action>... effects) {
        Intrinsics.checkNotNullParameter(effects, "effects");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(this.flow);
        ArrayList arrayList = new ArrayList(effects.length);
        for (Effect<Action> effect : effects) {
            arrayList.add(effect.flow);
        }
        spreadBuilder.addSpread(arrayList.toArray(new Flow[0]));
        this.flow = FlowKt__MergeKt.flattenMerge$default(FlowKt.flowOf(spreadBuilder.toArray(new Flow[spreadBuilder.size()])), 0, 1, null);
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
        Object objCollect = this.flow.collect(flowCollector, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public static /* synthetic */ Effect cancellable$default(Effect effect, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        return effect.cancellable(obj, z);
    }

    public final Effect<Action> cancellable(Object id, boolean cancelInFlight) {
        Intrinsics.checkNotNullParameter(id, "id");
        Flow flow = FlowKt.flow(new Effect$cancellable$cancellableFlow$1(this, id, null));
        if (cancelInFlight) {
            return EffectKt.toEffect(FlowKt.onStart(flow, new C10531(id, null)));
        }
        return EffectKt.toEffect(flow);
    }

    /* JADX INFO: renamed from: com.box.android.cpl.Effect$cancellable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Effect.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Action", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.Effect$cancellable$1", f = "Effect.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class C10531 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10531(Object obj, Continuation<? super C10531> continuation) {
            super(2, continuation);
            this.$id = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10531 c10531 = new C10531(this.$id, continuation);
            c10531.L$0 = obj;
            return c10531;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C10531) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.emitAll((FlowCollector) this.L$0, Effect.INSTANCE.cancel(this.$id), this) == coroutine_suspended) {
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
}
