package com.box.android.preview.previewtype.document.search.ui;

import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.search.TextSearch;
import com.pspdfkit.ui.PdfUiFragment;
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

/* JADX INFO: compiled from: DocumentHighlightOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1", f = "DocumentHighlightOverlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<TextSearchManager> $getTextSearchManager;
    final /* synthetic */ PdfConfiguration $pdfConfiguration;
    final /* synthetic */ ImmutableWrapper<PdfUiFragment> $pdfFragmentWrapper;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1(ImmutableWrapper<PdfUiFragment> immutableWrapper, Function0<TextSearchManager> function0, PdfConfiguration pdfConfiguration, Continuation<? super DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1> continuation) {
        super(2, continuation);
        this.$pdfFragmentWrapper = immutableWrapper;
        this.$getTextSearchManager = function0;
        this.$pdfConfiguration = pdfConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1(this.$pdfFragmentWrapper, this.$getTextSearchManager, this.$pdfConfiguration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PdfDocument document;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PdfUiFragment value = this.$pdfFragmentWrapper.getValue();
        if (value != null && (document = value.getDocument()) != null) {
            this.$getTextSearchManager.invoke().setTextSearch(new TextSearch(document, this.$pdfConfiguration));
        }
        return Unit.INSTANCE;
    }
}
