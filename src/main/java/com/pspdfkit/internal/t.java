package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ai.AiAssistantDialogTextHighLighter$highlight$1", f = "AiAssistantDialogTextHighLighter.kt", i = {0, 0, 0, 0, 0}, l = {68}, m = "invokeSuspend", n = {"searchResultHighlighter", "document", "size", "invertedRects", "textBlock"}, nl = {71}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
public final class t extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public SearchResultHighlighter a;
    public PdfDocument b;
    public Object c;
    public Object d;
    public TextBlock e;
    public int f;
    public final /* synthetic */ u g;
    public final /* synthetic */ PdfFragment h;
    public final /* synthetic */ int i;
    public final /* synthetic */ List<RectF> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public t(u uVar, PdfFragment pdfFragment, int i, List<? extends RectF> list, Continuation<? super t> continuation) {
        super(2, continuation);
        this.g = uVar;
        this.h = pdfFragment;
        this.i = i;
        this.j = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new t(this.g, this.h, this.i, this.j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((t) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PdfDocument document;
        SearchResultHighlighter searchResultHighlighter;
        TextBlock textBlock;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SearchResultHighlighter searchResultHighlighter2 = this.g.c;
            if (searchResultHighlighter2 == null) {
                throw new NullPointerException("SearchResultHighlighter is missing");
            }
            document = this.h.getDocument();
            if (document == null) {
                throw new NullPointerException("Document is missing");
            }
            u uVar = this.g;
            uVar.a.removeCallbacks(uVar.e);
            this.h.addDrawableProvider(searchResultHighlighter2);
            searchResultHighlighter2.clearSearchResults();
            int pageIndex = this.h.getPageIndex();
            int i2 = this.i;
            if (pageIndex != i2) {
                this.h.setPageIndex(i2);
            }
            Size pageSize = document.getPageSize(this.i);
            pageSize.getClass();
            List<RectF> list = this.j;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (RectF rectF : list) {
                float f = rectF.left;
                float f2 = pageSize.height;
                arrayList.add(new RectF(f, f2 - rectF.bottom, rectF.right, f2 - rectF.top));
            }
            TextBlock textBlockCreate = TextBlock.create(this.i, this.g.d, arrayList, "");
            this.a = searchResultHighlighter2;
            this.b = document;
            this.c = SpillingKt.nullOutSpilledVariable(pageSize);
            this.d = SpillingKt.nullOutSpilledVariable(arrayList);
            this.e = textBlockCreate;
            this.f = 1;
            if (DelayKt.delay(300L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            searchResultHighlighter = searchResultHighlighter2;
            textBlock = textBlockCreate;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TextBlock textBlock2 = this.e;
            document = this.b;
            searchResultHighlighter = this.a;
            ResultKt.throwOnFailure(obj);
            textBlock = textBlock2;
        }
        searchResultHighlighter.setSearchResults(CollectionsKt.listOf(new SearchResult(this.i, textBlock, null, null, document)));
        u uVar2 = this.g;
        uVar2.a.postDelayed(uVar2.e, 1500L);
        return Unit.INSTANCE;
    }
}
