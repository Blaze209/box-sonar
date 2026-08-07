package com.box.android.preview.previewtype.document.search.ui;

import com.box.android.base.compose.ImmutableWrapper;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentHighlightOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1", f = "DocumentHighlightOverlay.kt", i = {0, 0, 0}, l = {91}, m = "invokeSuspend", n = {"it", "pdfFragment", "$i$a$-let-DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
final class DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SearchResultHighlighter $citationHighlighter;
    final /* synthetic */ SearchResult $citationText;
    final /* synthetic */ PdfConfiguration $pdfConfiguration;
    final /* synthetic */ ImmutableWrapper<PdfUiFragment> $pdfFragmentWrapper;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1(SearchResult searchResult, SearchResultHighlighter searchResultHighlighter, ImmutableWrapper<PdfUiFragment> immutableWrapper, PdfConfiguration pdfConfiguration, Continuation<? super DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1> continuation) {
        super(2, continuation);
        this.$citationText = searchResult;
        this.$citationHighlighter = searchResultHighlighter;
        this.$pdfFragmentWrapper = immutableWrapper;
        this.$pdfConfiguration = pdfConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1(this.$citationText, this.$citationHighlighter, this.$pdfFragmentWrapper, this.$pdfConfiguration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PdfFragment pdfFragment;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SearchResult searchResult = this.$citationText;
            if (searchResult != null) {
                SearchResultHighlighter searchResultHighlighter = this.$citationHighlighter;
                ImmutableWrapper<PdfUiFragment> immutableWrapper = this.$pdfFragmentWrapper;
                PdfConfiguration pdfConfiguration = this.$pdfConfiguration;
                searchResultHighlighter.setSearchResults(CollectionsKt.listOf(searchResult));
                PdfUiFragment value = immutableWrapper.getValue();
                if (value == null || (pdfFragment = value.getPdfFragment()) == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(searchResult);
                this.L$1 = SpillingKt.nullOutSpilledVariable(pdfFragment);
                this.I$0 = 0;
                this.label = 1;
                if (DocumentHighlightOverlayKt.navigateToResult(pdfFragment, searchResult, pdfConfiguration, searchResultHighlighter, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.$citationHighlighter.clearSearchResults();
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
