package com.box.android.preview.preview;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.item.ItemPreviewReducer;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.PreviewScreenKt$PreviewScreenContent$2$1", f = "PreviewScreen.kt", i = {}, l = {JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreviewScreenKt$PreviewScreenContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    final /* synthetic */ Store<PreviewReducer.State, PreviewReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewScreenKt$PreviewScreenContent$2$1(PagerState pagerState, SnackbarHostState snackbarHostState, Store<PreviewReducer.State, PreviewReducer.Action> store, State<PreviewReducer.State> state, Continuation<? super PreviewScreenKt$PreviewScreenContent$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$snackbarHostState = snackbarHostState;
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewScreenKt$PreviewScreenContent$2$1(this.$pagerState, this.$snackbarHostState, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreviewScreenKt$PreviewScreenContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PagerState pagerState = this.$pagerState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.preview.preview.PreviewScreenKt$PreviewScreenContent$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Integer.valueOf(pagerState.getSettledPage());
                }
            });
            final SnackbarHostState snackbarHostState = this.$snackbarHostState;
            final Store<PreviewReducer.State, PreviewReducer.Action> store = this.$store;
            final State<PreviewReducer.State> state = this.$state$delegate;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.box.android.preview.preview.PreviewScreenKt$PreviewScreenContent$2$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(int i2, Continuation<? super Unit> continuation) {
                    FileModel fileModel = ((ItemPreviewReducer.State) PreviewScreenKt.PreviewScreenContent$lambda$0(state).getPreviewItems().get(i2)).getFileModel();
                    SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
                    if (currentSnackbarData != null) {
                        currentSnackbarData.dismiss();
                    }
                    store.send(new PreviewReducer.Action.SetSelectedItem(fileModel, PreviewNavigationMethod.SWIPE));
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
