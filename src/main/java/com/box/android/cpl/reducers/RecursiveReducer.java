package com.box.android.cpl.reducers;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducableKt;
import com.box.android.cpl.ReducerResult;
import com.facebook.react.devsupport.StackTraceHelper;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RecursiveReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003Bs\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010JD\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00012\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013H\u0082\u0010¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/cpl/reducers/RecursiveReducer;", "State", "Action", "Lcom/box/android/cpl/Reducable;", "reducer", "toChildState", "Lkotlin/Function1;", "toChildAction", "toParentState", "Lkotlin/Function2;", "toParentAction", "(Lcom/box/android/cpl/Reducable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "reduceRecursively", StackTraceHelper.STACK_KEY, "", "Lkotlin/Pair;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;)Lcom/box/android/cpl/ReducerResult;", "reduceStack", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecursiveReducer<State, Action> implements Reducable<State, Action> {
    private final Reducable<State, Action> reducer;
    private final Function1<Action, Action> toChildAction;
    private final Function1<State, State> toChildState;
    private final Function1<Action, Action> toParentAction;
    private final Function2<State, State, State> toParentState;

    /* JADX WARN: Multi-variable type inference failed */
    public RecursiveReducer(Reducable<State, Action> reducer, Function1<? super State, ? extends State> toChildState, Function1<? super Action, ? extends Action> toChildAction, Function2<? super State, ? super State, ? extends State> toParentState, Function1<? super Action, ? extends Action> toParentAction) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        Intrinsics.checkNotNullParameter(toChildState, "toChildState");
        Intrinsics.checkNotNullParameter(toChildAction, "toChildAction");
        Intrinsics.checkNotNullParameter(toParentState, "toParentState");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        this.reducer = reducer;
        this.toChildState = toChildState;
        this.toChildAction = toChildAction;
        this.toParentState = toParentState;
        this.toParentAction = toParentAction;
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        return reduceRecursively(state, action, CollectionsKt.mutableListOf(TuplesKt.to(state, action)));
    }

    private final ReducerResult<State, Action> reduceRecursively(State state, Action action, List<Pair<State, Action>> stack) {
        while (true) {
            action = this.toChildAction.invoke(action);
            if (action == null) {
                return reduceStack(stack);
            }
            state = this.toChildState.invoke(state);
            if (state == null) {
                return reduceStack(stack);
            }
            stack.add(TuplesKt.to(state, action));
        }
    }

    private final ReducerResult<State, Action> reduceStack(List<Pair<State, Action>> stack) {
        Pair pair = (Pair) CollectionsKt.removeLast(stack);
        ReducerResult<State, Action> reducerResultReduce = this.reducer.reduce((State) pair.getFirst(), (Action) pair.getSecond());
        if (!stack.isEmpty()) {
            ListIterator<Pair<State, Action>> listIterator = stack.listIterator(stack.size());
            while (listIterator.hasPrevious()) {
                Pair<State, Action> pairPrevious = listIterator.previous();
                State stateComponent1 = pairPrevious.component1();
                Action actionComponent2 = pairPrevious.component2();
                State stateComponent2 = reducerResultReduce.component1();
                Effect<Action> effectComponent2 = reducerResultReduce.component2();
                State stateInvoke = this.toParentState.invoke(stateComponent1, stateComponent2);
                final Effect<Action> effect = effectComponent2;
                final Function1<Action, Action> function1 = this.toParentAction;
                reducerResultReduce = ReducableKt.chainWith(new ReducerResult(stateInvoke, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.cpl.reducers.RecursiveReducer$reduceStack$lambda$1$$inlined$map$1

                    /* JADX INFO: renamed from: com.box.android.cpl.reducers.RecursiveReducer$reduceStack$lambda$1$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ Function1 callee$inlined;

                        /* JADX INFO: renamed from: com.box.android.cpl.reducers.RecursiveReducer$reduceStack$lambda$1$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.cpl.reducers.RecursiveReducer$reduceStack$lambda$1$$inlined$map$1$2", f = "RecursiveReducer.kt", i = {}, l = {BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "emit", n = {}, s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, Function1 function1) {
                            this.$this_unsafeFlow = flowCollector;
                            this.callee$inlined = function1;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Object objInvoke = this.callee$inlined.invoke(obj);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(objInvoke, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = effect.collect(new AnonymousClass2(flowCollector, function1), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                })), this.reducer, actionComponent2);
            }
        }
        return reducerResultReduce;
    }
}
