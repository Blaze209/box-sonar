package com.box.android.preview.previewtype.boxnote;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import com.box.android.cpl.Store;
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

/* JADX INFO: compiled from: BoxNotePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1", f = "BoxNotePreviewScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BoxNoteEditModeReducer.ViewEffect $effect;
    final /* synthetic */ Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> $store;
    final /* synthetic */ WebView $webView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1(BoxNoteEditModeReducer.ViewEffect viewEffect, WebView webView, Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, Context context, Continuation<? super BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1> continuation) {
        super(2, continuation);
        this.$effect = viewEffect;
        this.$webView = webView;
        this.$store = store;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1(this.$effect, this.$webView, this.$store, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BoxNoteEditModeReducer.ViewEffect viewEffect = this.$effect;
        if (viewEffect == null) {
            return Unit.INSTANCE;
        }
        List<BoxNoteRequest> requests = viewEffect.getRequests();
        WebView webView = this.$webView;
        for (BoxNoteRequest boxNoteRequest : requests) {
            if (webView != null) {
                webView.loadUrl(BoxNotePreviewScreenKt.callNotesFunction(boxNoteRequest));
            }
        }
        if (this.$effect.getHideKeyboard()) {
            WebView webView2 = this.$webView;
            if (webView2 != null) {
                Object systemService = this.$context.getSystemService("input_method");
                InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                if (inputMethodManager != null) {
                    Boxing.boxBoolean(inputMethodManager.hideSoftInputFromWindow(webView2.getWindowToken(), 0));
                }
            }
            this.$store.send(BoxNotePreviewReducer.Action.StopEditing.INSTANCE);
        }
        this.$store.send(new BoxNotePreviewReducer.Action.EditModeAction(BoxNoteEditModeReducer.Action.EffectProcessed.INSTANCE));
        return Unit.INSTANCE;
    }
}
