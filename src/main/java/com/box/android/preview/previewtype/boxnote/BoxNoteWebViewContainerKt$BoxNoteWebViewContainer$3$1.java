package com.box.android.preview.previewtype.boxnote;

import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxNoteWebViewContainer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1", f = "BoxNoteWebViewContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxNotePreviewReducer.State $state;
    final /* synthetic */ MutableState<WebView> $webView$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1(MutableState<WebView> mutableState, BoxNotePreviewReducer.State state, Continuation<? super BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1> continuation) {
        super(2, continuation);
        this.$webView$delegate = mutableState;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1(this.$webView$delegate, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WebView webViewBoxNoteWebViewContainer$lambda$1 = BoxNoteWebViewContainerKt.BoxNoteWebViewContainer$lambda$1(this.$webView$delegate);
            if (webViewBoxNoteWebViewContainer$lambda$1 != null) {
                BoxNoteWebViewContainerKt.toggleConnectionBanner(webViewBoxNoteWebViewContainer$lambda$1, !this.$state.getIsConnected());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
