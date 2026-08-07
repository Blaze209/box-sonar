package com.box.android.capture.widget;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CaptureModeSwitcher.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1", f = "CaptureModeSwitcher.kt", i = {}, l = {Token.CONST}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function1<Integer, Unit> $onIndexChange;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1(LazyListState lazyListState, Function1<? super Integer, Unit> function1, Continuation<? super CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$onIndexChange = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1(this.$listState, this.$onIndexChange, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$listState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(lazyListState.isScrollInProgress());
                }
            });
            final LazyListState lazyListState2 = this.$listState;
            final Function1<Integer, Unit> function1 = this.$onIndexChange;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.box.android.capture.widget.CaptureModeSwitcherKt$ChangeCenteredItemIndexEffect$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    T t;
                    if (!z) {
                        LazyListLayoutInfo layoutInfo = lazyListState2.getLayoutInfo();
                        int viewportStartOffset = layoutInfo.getViewportStartOffset() + (((int) (layoutInfo.mo1336getViewportSizeYbymL2g() >> 32)) / 2);
                        Iterator<T> it = layoutInfo.getVisibleItemsInfo().iterator();
                        if (it.hasNext()) {
                            T next = it.next();
                            if (it.hasNext()) {
                                LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) next;
                                int iAbs = Math.abs((lazyListItemInfo.getOffset() + (lazyListItemInfo.getSize() / 2)) - viewportStartOffset);
                                do {
                                    T next2 = it.next();
                                    LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) next2;
                                    int iAbs2 = Math.abs((lazyListItemInfo2.getOffset() + (lazyListItemInfo2.getSize() / 2)) - viewportStartOffset);
                                    if (iAbs > iAbs2) {
                                        next = next2;
                                        iAbs = iAbs2;
                                    }
                                } while (it.hasNext());
                            }
                            t = next;
                        } else {
                            t = null;
                        }
                        LazyListItemInfo lazyListItemInfo3 = (LazyListItemInfo) t;
                        if (lazyListItemInfo3 != null) {
                            function1.invoke(Boxing.boxInt(lazyListItemInfo3.getIndex()));
                        }
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
