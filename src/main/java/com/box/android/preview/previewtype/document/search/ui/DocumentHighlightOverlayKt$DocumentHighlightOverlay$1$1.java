package com.box.android.preview.previewtype.document.search.ui;

import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchUtilsKt;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import java.util.List;
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
@DebugMetadata(c = "com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1", f = "DocumentHighlightOverlay.kt", i = {0, 0, 0, 0}, l = {72}, m = "invokeSuspend", n = {"results", "it", "pdfFragment", "$i$a$-let-DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
final class DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PdfConfiguration $pdfConfiguration;
    final /* synthetic */ ImmutableWrapper<PdfUiFragment> $pdfFragmentWrapper;
    final /* synthetic */ SearchResultHighlighter $searchResultHighlighter;
    final /* synthetic */ DocumentSearchReducer.SearchState.Results $searchResultsState;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1(DocumentSearchReducer.SearchState.Results results, SearchResultHighlighter searchResultHighlighter, ImmutableWrapper<PdfUiFragment> immutableWrapper, PdfConfiguration pdfConfiguration, Continuation<? super DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1> continuation) {
        super(2, continuation);
        this.$searchResultsState = results;
        this.$searchResultHighlighter = searchResultHighlighter;
        this.$pdfFragmentWrapper = immutableWrapper;
        this.$pdfConfiguration = pdfConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1(this.$searchResultsState, this.$searchResultHighlighter, this.$pdfFragmentWrapper, this.$pdfConfiguration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<SearchResult> listEmptyList;
        PdfFragment pdfFragment;
        ImmutableWrapper<List<SearchResult>> results;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DocumentSearchReducer.SearchState.Results results2 = this.$searchResultsState;
            if (results2 == null || (results = results2.getResults()) == null || (listEmptyList = results.getValue()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            this.$searchResultHighlighter.setSearchResults(listEmptyList);
            DocumentSearchReducer.SearchState.Results results3 = this.$searchResultsState;
            if (results3 != null) {
                ImmutableWrapper<PdfUiFragment> immutableWrapper = this.$pdfFragmentWrapper;
                PdfConfiguration pdfConfiguration = this.$pdfConfiguration;
                SearchResultHighlighter searchResultHighlighter = this.$searchResultHighlighter;
                PdfUiFragment value = immutableWrapper.getValue();
                if (value == null || (pdfFragment = value.getPdfFragment()) == null) {
                    return Unit.INSTANCE;
                }
                SearchResult byIndex = DocumentSearchUtilsKt.getByIndex(results3, results3.getSelectedResultIndex());
                this.L$0 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                this.L$1 = SpillingKt.nullOutSpilledVariable(results3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(pdfFragment);
                this.I$0 = 0;
                this.label = 1;
                if (DocumentHighlightOverlayKt.navigateToResult(pdfFragment, byIndex, pdfConfiguration, searchResultHighlighter, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
