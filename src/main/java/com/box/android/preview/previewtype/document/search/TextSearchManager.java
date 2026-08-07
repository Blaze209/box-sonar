package com.box.android.preview.previewtype.document.search;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.search.SearchOptions;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.document.search.TextSearch;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextSearchManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "", "searchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "searchOptionsProvider", "Lcom/box/android/preview/previewtype/document/search/SearchOptionsProvider;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/box/android/preview/previewtype/document/search/SearchOptionsProvider;)V", "textSearch", "Lcom/pspdfkit/document/search/TextSearch;", "setTextSearch", "", "search", "", "Lcom/pspdfkit/document/search/SearchResult;", "searchQuery", "", "currentPageIndex", "", "pagesCount", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "priorityPages", "Lcom/pspdfkit/datastructures/Range;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextSearchManager {
    public static final int $stable = 8;
    private final CoroutineDispatcher searchDispatcher;
    private final SearchOptionsProvider searchOptionsProvider;
    private TextSearch textSearch;

    @Inject
    public TextSearchManager(CoroutineDispatcher searchDispatcher, SearchOptionsProvider searchOptionsProvider) {
        Intrinsics.checkNotNullParameter(searchDispatcher, "searchDispatcher");
        Intrinsics.checkNotNullParameter(searchOptionsProvider, "searchOptionsProvider");
        this.searchDispatcher = searchDispatcher;
        this.searchOptionsProvider = searchOptionsProvider;
    }

    public final void setTextSearch(TextSearch textSearch) {
        Intrinsics.checkNotNullParameter(textSearch, "textSearch");
        this.textSearch = textSearch;
    }

    public final Object search(String str, int i, int i2, Continuation<? super List<SearchResult>> continuation) {
        return search(str, CollectionsKt.listOf(new Range(i, i2 - i)), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.document.search.TextSearchManager$search$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextSearchManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/document/search/SearchResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.document.search.TextSearchManager$search$3", f = "TextSearchManager.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SearchResult>>, Object> {
        final /* synthetic */ List<Range> $priorityPages;
        final /* synthetic */ String $searchQuery;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(List<? extends Range> list, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$priorityPages = list;
            this.$searchQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = TextSearchManager.this.new AnonymousClass3(this.$priorityPages, this.$searchQuery, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SearchResult>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SearchResult>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SearchResult>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<SearchResult> listEmptyList;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            TextSearchManager textSearchManager = TextSearchManager.this;
            List<Range> list = this.$priorityPages;
            String str = this.$searchQuery;
            this.L$0 = coroutineScope;
            this.L$1 = textSearchManager;
            this.L$2 = list;
            this.L$3 = str;
            this.label = 1;
            AnonymousClass3 anonymousClass3 = this;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass3));
            SafeContinuation safeContinuation2 = safeContinuation;
            try {
                SearchOptions searchOptions = textSearchManager.searchOptionsProvider.getSearchOptions(list);
                TextSearch textSearch = textSearchManager.textSearch;
                if (textSearch == null || (listEmptyList = textSearch.performSearch(str, searchOptions)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } catch (Exception e) {
                String simpleName = coroutineScope.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                BoxLogUtils.e(simpleName, "Exception while searching in document, " + e);
                listEmptyList = CollectionsKt.emptyList();
            }
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m14780constructorimpl(listEmptyList));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass3);
            }
            return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object search$default(TextSearchManager textSearchManager, String str, List list, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return textSearchManager.search(str, list, continuation);
    }

    public final Object search(String str, List<? extends Range> list, Continuation<? super List<SearchResult>> continuation) {
        return BuildersKt.withContext(this.searchDispatcher, new AnonymousClass3(list, str, null), continuation);
    }
}
