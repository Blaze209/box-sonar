package com.box.android.cpl.reducers;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducableKt;
import com.box.android.cpl.ReducerResult;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ForEachInListReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005B£\u0001\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n0\t\u0012 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00028\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0003\u0018\u00010\r0\f\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00028\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0003\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/cpl/reducers/ForEachInListReducer;", "ParentState", "ParentAction", "ChildState", "ChildAction", "Lcom/box/android/cpl/Reducable;", "parent", "child", "listProperty", "Lkotlin/reflect/KProperty1;", "", "toEmbeddedItemAction", "Lkotlin/Function1;", "Lcom/box/android/cpl/EmbeddedItem;", "", "toParentState", "Lkotlin/Function3;", "toParentAction", "Lkotlin/Function2;", "(Lcom/box/android/cpl/Reducable;Lcom/box/android/cpl/Reducable;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "reduceForEach", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ForEachInListReducer<ParentState, ParentAction, ChildState, ChildAction> implements Reducable<ParentState, ParentAction> {
    private final Reducable<ChildState, ChildAction> child;
    private final KProperty1<ParentState, List<ChildState>> listProperty;
    private final Reducable<ParentState, ParentAction> parent;
    private final Function1<ParentAction, EmbeddedItem<Integer, ChildAction>> toEmbeddedItemAction;
    private final Function2<Integer, ChildAction, ParentAction> toParentAction;
    private final Function3<ParentState, ChildState, Integer, ParentState> toParentState;

    /* JADX WARN: Multi-variable type inference failed */
    public ForEachInListReducer(Reducable<ParentState, ParentAction> parent, Reducable<ChildState, ChildAction> child, KProperty1<ParentState, ? extends List<? extends ChildState>> listProperty, Function1<? super ParentAction, ? extends EmbeddedItem<Integer, ChildAction>> toEmbeddedItemAction, Function3<? super ParentState, ? super ChildState, ? super Integer, ? extends ParentState> toParentState, Function2<? super Integer, ? super ChildAction, ? extends ParentAction> toParentAction) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(listProperty, "listProperty");
        Intrinsics.checkNotNullParameter(toEmbeddedItemAction, "toEmbeddedItemAction");
        Intrinsics.checkNotNullParameter(toParentState, "toParentState");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        this.parent = parent;
        this.child = child;
        this.listProperty = listProperty;
        this.toEmbeddedItemAction = toEmbeddedItemAction;
        this.toParentState = toParentState;
        this.toParentAction = toParentAction;
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<ParentState, ParentAction> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<ParentState, ParentAction> reduce(ParentState state, ParentAction action) {
        return ReducableKt.chainWith(reduceForEach(state, action), this.parent, action);
    }

    private final ReducerResult<ParentState, ParentAction> reduceForEach(ParentState state, ParentAction action) {
        EmbeddedItem<Integer, ChildAction> embeddedItemInvoke = this.toEmbeddedItemAction.invoke(action);
        if (embeddedItemInvoke == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        final int iIntValue = embeddedItemInvoke.getId().intValue();
        ChildAction hubAction = embeddedItemInvoke.getAction();
        Object orNull = CollectionsKt.getOrNull(this.listProperty.get(state), iIntValue);
        if (orNull == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        ReducerResult<ChildState, ChildAction> reducerResultReduce = this.child.reduce((ChildState) orNull, hubAction);
        ParentState parentstateInvoke = this.toParentState.invoke(state, reducerResultReduce.getState(), Integer.valueOf(iIntValue));
        final Effect<ChildAction> effect = reducerResultReduce.getEffect();
        return new ReducerResult<>(parentstateInvoke, EffectKt.toEffect(new Flow<ParentAction>() { // from class: com.box.android.cpl.reducers.ForEachInListReducer$reduceForEach$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.cpl.reducers.ForEachInListReducer$reduceForEach$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $index$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ ForEachInListReducer this$0;

                /* JADX INFO: renamed from: com.box.android.cpl.reducers.ForEachInListReducer$reduceForEach$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.cpl.reducers.ForEachInListReducer$reduceForEach$$inlined$map$1$2", f = "ForEachInListReducer.kt", i = {}, l = {BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "emit", n = {}, s = {})
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

                public AnonymousClass2(FlowCollector flowCollector, ForEachInListReducer forEachInListReducer, int i) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = forEachInListReducer;
                    this.$index$inlined = i;
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
                        Object objInvoke = this.this$0.toParentAction.invoke(Boxing.boxInt(this.$index$inlined), obj);
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
                Object objCollect = effect.collect(new AnonymousClass2(flowCollector, this, iIntValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }));
    }
}
