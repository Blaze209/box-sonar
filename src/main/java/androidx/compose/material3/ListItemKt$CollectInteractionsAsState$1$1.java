package androidx.compose.material3;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ListItemKt$CollectInteractionsAsState$1$1", f = "ListItem.kt", i = {}, l = {1264}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ListItemKt$CollectInteractionsAsState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $draggedState;
    final /* synthetic */ MutableState<Boolean> $focusedState;
    final /* synthetic */ MutableState<Boolean> $hoveredState;
    final /* synthetic */ MutableState<Boolean> $pressedState;
    final /* synthetic */ InteractionSource $this_CollectInteractionsAsState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListItemKt$CollectInteractionsAsState$1$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, InteractionSource interactionSource, Continuation<? super ListItemKt$CollectInteractionsAsState$1$1> continuation) {
        super(2, continuation);
        this.$pressedState = mutableState;
        this.$focusedState = mutableState2;
        this.$hoveredState = mutableState3;
        this.$draggedState = mutableState4;
        this.$this_CollectInteractionsAsState = interactionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListItemKt$CollectInteractionsAsState$1$1(this.$pressedState, this.$focusedState, this.$hoveredState, this.$draggedState, this.$this_CollectInteractionsAsState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ListItemKt$CollectInteractionsAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ArrayList arrayList = this.$pressedState != null ? new ArrayList() : null;
            final ArrayList arrayList2 = this.$focusedState != null ? new ArrayList() : null;
            final ArrayList arrayList3 = this.$hoveredState != null ? new ArrayList() : null;
            final ArrayList arrayList4 = this.$draggedState != null ? new ArrayList() : null;
            Flow<Interaction> interactions = this.$this_CollectInteractionsAsState.getInteractions();
            final MutableState<Boolean> mutableState = this.$pressedState;
            final MutableState<Boolean> mutableState2 = this.$focusedState;
            final MutableState<Boolean> mutableState3 = this.$hoveredState;
            final MutableState<Boolean> mutableState4 = this.$draggedState;
            this.label = 1;
            if (interactions.collect(new FlowCollector() { // from class: androidx.compose.material3.ListItemKt$CollectInteractionsAsState$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                    List<DragInteraction.Start> list;
                    List<DragInteraction.Start> list2;
                    List<HoverInteraction.Enter> list3;
                    List<FocusInteraction.Focus> list4;
                    List<PressInteraction.Press> list5;
                    if (interaction instanceof PressInteraction.Press) {
                        List<PressInteraction.Press> list6 = arrayList;
                        if (list6 != null) {
                            Boxing.boxBoolean(list6.add(interaction));
                        }
                    } else if (interaction instanceof PressInteraction.Release) {
                        List<PressInteraction.Press> list7 = arrayList;
                        if (list7 != null) {
                            Boxing.boxBoolean(list7.remove(((PressInteraction.Release) interaction).getPress()));
                        }
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        List<PressInteraction.Press> list8 = arrayList;
                        if (list8 != null) {
                            Boxing.boxBoolean(list8.remove(((PressInteraction.Cancel) interaction).getPress()));
                        }
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        List<FocusInteraction.Focus> list9 = arrayList2;
                        if (list9 != null) {
                            Boxing.boxBoolean(list9.add(interaction));
                        }
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        List<FocusInteraction.Focus> list10 = arrayList2;
                        if (list10 != null) {
                            Boxing.boxBoolean(list10.remove(((FocusInteraction.Unfocus) interaction).getFocus()));
                        }
                    } else if (interaction instanceof HoverInteraction.Enter) {
                        List<HoverInteraction.Enter> list11 = arrayList3;
                        if (list11 != null) {
                            Boxing.boxBoolean(list11.add(interaction));
                        }
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        List<HoverInteraction.Enter> list12 = arrayList3;
                        if (list12 != null) {
                            Boxing.boxBoolean(list12.remove(((HoverInteraction.Exit) interaction).getEnter()));
                        }
                    } else if (interaction instanceof DragInteraction.Start) {
                        List<DragInteraction.Start> list13 = arrayList4;
                        if (list13 != null) {
                            Boxing.boxBoolean(list13.add(interaction));
                        }
                    } else if (interaction instanceof DragInteraction.Stop) {
                        List<DragInteraction.Start> list14 = arrayList4;
                        if (list14 != null) {
                            Boxing.boxBoolean(list14.remove(((DragInteraction.Stop) interaction).getStart()));
                        }
                    } else if ((interaction instanceof DragInteraction.Cancel) && (list = arrayList4) != null) {
                        Boxing.boxBoolean(list.remove(((DragInteraction.Cancel) interaction).getStart()));
                    }
                    MutableState<Boolean> mutableState5 = mutableState;
                    if (mutableState5 != null && (list5 = arrayList) != null) {
                        mutableState5.setValue(Boxing.boxBoolean(!list5.isEmpty()));
                    }
                    MutableState<Boolean> mutableState6 = mutableState2;
                    if (mutableState6 != null && (list4 = arrayList2) != null) {
                        mutableState6.setValue(Boxing.boxBoolean(!list4.isEmpty()));
                    }
                    MutableState<Boolean> mutableState7 = mutableState3;
                    if (mutableState7 != null && (list3 = arrayList3) != null) {
                        mutableState7.setValue(Boxing.boxBoolean(!list3.isEmpty()));
                    }
                    MutableState<Boolean> mutableState8 = mutableState4;
                    if (mutableState8 != null && (list2 = arrayList4) != null) {
                        mutableState8.setValue(Boxing.boxBoolean(!list2.isEmpty()));
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
