package com.pspdfkit.document.search;

import android.app.Activity;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProviderBlocking;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.ca;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.i00;
import com.pspdfkit.internal.j;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeCompareOptionsFlags;
import com.pspdfkit.internal.jni.NativeDocumentSearcher;
import com.pspdfkit.internal.jni.NativeDocumentSearcherQuery;
import com.pspdfkit.internal.jni.NativeDocumentSearcherQueryResultHandler;
import com.pspdfkit.internal.jni.NativeDocumentSearcherResult;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.TextBlockHelpersKt;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes3.dex */
public final class TextSearch {
    private static final String LOG_TAG = "Nutri.SearchView.TextSearch";
    private final PdfConfiguration configuration;
    private final SearchOptions defaultSearchOptions;
    private final lm document;
    private NativeDocumentSearcher documentSearcher = null;
    private UUID currentSearchId = null;

    public TextSearch(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration) {
        uw.a(pdfDocument, "document", null);
        uw.a(pdfConfiguration, "configuration", null);
        this.document = (lm) pdfDocument;
        this.defaultSearchOptions = new SearchOptions.Builder().build();
        this.configuration = pdfConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelSearch(UUID uuid) {
        synchronized (this) {
            if (Objects.equals(uuid, this.currentSearchId)) {
                cancelSearch();
            }
        }
    }

    private NativeDocumentSearcher getNewDocumentSearcher(UUID uuid) {
        NativeDocumentSearcher nativeDocumentSearcherCreate;
        synchronized (this) {
            cancelSearch();
            nativeDocumentSearcherCreate = NativeDocumentSearcher.create();
            this.documentSearcher = nativeDocumentSearcherCreate;
            this.currentSearchId = uuid;
        }
        return nativeDocumentSearcherCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$performSearchAsync$0(String str, SearchOptions searchOptions, final FlowableEmitter flowableEmitter) throws Throwable {
        ArrayList arrayList;
        ArrayList arrayList2;
        PdfLog.d(LOG_TAG, "Starting native search for: %s", str);
        EnumSet<CompareOptions> enumSet = searchOptions.compareOptionsFlags;
        enumSet.getClass();
        EnumSet enumSetNoneOf = EnumSet.noneOf(NativeCompareOptionsFlags.class);
        Iterator<CompareOptions> it = enumSet.iterator();
        it.getClass();
        while (it.hasNext()) {
            CompareOptions next = it.next();
            int i = next == null ? -1 : mr.b.k[next.ordinal()];
            if (i == 1) {
                enumSetNoneOf.add(NativeCompareOptionsFlags.CASE_INSENSITIVE);
            } else if (i == 2) {
                enumSetNoneOf.add(NativeCompareOptionsFlags.DIACRITIC_INSENSITIVE);
            } else if (i == 3) {
                enumSetNoneOf.add(NativeCompareOptionsFlags.SMART_SEARCH);
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException("Null flag passed.");
                }
                enumSetNoneOf.add(NativeCompareOptionsFlags.REGULAR_EXPRESSION);
            }
        }
        enumSetNoneOf.getClass();
        final boolean z = searchOptions.snippetLength > 0;
        boolean z2 = searchOptions.searchAnnotations;
        boolean zB = ar.b().b(this.configuration);
        int i2 = searchOptions.maxSearchResults;
        boolean z3 = !searchOptions.searchOnlyInPriorityPages;
        List<Range> list = searchOptions.priorityPages;
        if (list != null) {
            if (list instanceof ArrayList) {
                arrayList2 = (ArrayList) list;
            } else {
                arrayList = new ArrayList(list);
            }
            NativeDocumentSearcherQuery nativeDocumentSearcherQuery = new NativeDocumentSearcherQuery(str, enumSetNoneOf, z, z2, zB, i2, z3, false, arrayList, new Range(20, searchOptions.snippetLength));
            final UUID uuidRandomUUID = UUID.randomUUID();
            getNewDocumentSearcher(uuidRandomUUID).searchDocument(this.document.y, nativeDocumentSearcherQuery, new NativeDocumentSearcherQueryResultHandler() { // from class: com.pspdfkit.document.search.TextSearch.1
                @Override // com.pspdfkit.internal.jni.NativeDocumentSearcherQueryResultHandler
                public void pageResultHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery2, String str2, long j, ArrayList<NativeDocumentSearcherResult> arrayList3) {
                    TextBlock textBlockCreateTextBlock;
                    if (arrayList3.isEmpty()) {
                        return;
                    }
                    if (flowableEmitter.isCancelled()) {
                        TextSearch.this.cancelSearch(uuidRandomUUID);
                        return;
                    }
                    int size = arrayList3.size();
                    int i3 = 0;
                    while (i3 < size) {
                        NativeDocumentSearcherResult nativeDocumentSearcherResult = arrayList3.get(i3);
                        i3++;
                        NativeDocumentSearcherResult nativeDocumentSearcherResult2 = nativeDocumentSearcherResult;
                        int pageIndex = (int) nativeDocumentSearcherResult2.getPageIndex();
                        Annotation annotationBlocking = null;
                        SearchResult.TextSnippet textSnippet = z ? new SearchResult.TextSnippet(nativeDocumentSearcherResult2.getPreviewText(), nativeDocumentSearcherResult2.getRangeInPreviewText()) : null;
                        Range rangeInText = nativeDocumentSearcherResult2.getRangeInText();
                        boolean isAnnotation = nativeDocumentSearcherResult2.getIsAnnotation();
                        TextSearch textSearch = TextSearch.this;
                        if (!isAnnotation) {
                            textBlockCreateTextBlock = TextBlockHelpersKt.createTextBlock(textSearch.document, pageIndex, rangeInText);
                        } else if (!ca.a(textSearch.configuration).contains(AnnotationType.NOTE)) {
                            NativeAnnotation annotation = nativeDocumentSearcherResult2.getAnnotation();
                            if (annotation != null && annotation.getAbsolutePageIndex() != null && annotation.getAnnotationId() != null) {
                                annotationBlocking = AnnotationProviderBlocking.getAnnotationBlocking(TextSearch.this.document.getAnnotationProvider(), annotation.getAbsolutePageIndex().intValue(), (int) annotation.getAnnotationId().longValue());
                            }
                            TextSearch textSearch2 = TextSearch.this;
                            textBlockCreateTextBlock = annotationBlocking != null ? TextBlockHelpersKt.createTextBlock(annotationBlocking, textSearch2.document, rangeInText) : TextBlockHelpersKt.createTextBlock(textSearch2.document, pageIndex, rangeInText);
                        }
                        flowableEmitter.onNext(new SearchResult(pageIndex, textBlockCreateTextBlock, textSnippet, annotationBlocking, TextSearch.this.document));
                    }
                }

                @Override // com.pspdfkit.internal.jni.NativeDocumentSearcherQueryResultHandler
                public void searchCompleteHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery2, String str2) {
                    flowableEmitter.onComplete();
                }
            });
        }
        arrayList2 = null;
        arrayList = arrayList2;
        NativeDocumentSearcherQuery nativeDocumentSearcherQuery2 = new NativeDocumentSearcherQuery(str, enumSetNoneOf, z, z2, zB, i2, z3, false, arrayList, new Range(20, searchOptions.snippetLength));
        final UUID uuidRandomUUID2 = UUID.randomUUID();
        getNewDocumentSearcher(uuidRandomUUID2).searchDocument(this.document.y, nativeDocumentSearcherQuery2, new NativeDocumentSearcherQueryResultHandler() { // from class: com.pspdfkit.document.search.TextSearch.1
            @Override // com.pspdfkit.internal.jni.NativeDocumentSearcherQueryResultHandler
            public void pageResultHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery3, String str2, long j, ArrayList<NativeDocumentSearcherResult> arrayList3) {
                TextBlock textBlockCreateTextBlock;
                if (arrayList3.isEmpty()) {
                    return;
                }
                if (flowableEmitter.isCancelled()) {
                    TextSearch.this.cancelSearch(uuidRandomUUID2);
                    return;
                }
                int size = arrayList3.size();
                int i3 = 0;
                while (i3 < size) {
                    NativeDocumentSearcherResult nativeDocumentSearcherResult = arrayList3.get(i3);
                    i3++;
                    NativeDocumentSearcherResult nativeDocumentSearcherResult2 = nativeDocumentSearcherResult;
                    int pageIndex = (int) nativeDocumentSearcherResult2.getPageIndex();
                    Annotation annotationBlocking = null;
                    SearchResult.TextSnippet textSnippet = z ? new SearchResult.TextSnippet(nativeDocumentSearcherResult2.getPreviewText(), nativeDocumentSearcherResult2.getRangeInPreviewText()) : null;
                    Range rangeInText = nativeDocumentSearcherResult2.getRangeInText();
                    boolean isAnnotation = nativeDocumentSearcherResult2.getIsAnnotation();
                    TextSearch textSearch = TextSearch.this;
                    if (!isAnnotation) {
                        textBlockCreateTextBlock = TextBlockHelpersKt.createTextBlock(textSearch.document, pageIndex, rangeInText);
                    } else if (!ca.a(textSearch.configuration).contains(AnnotationType.NOTE)) {
                        NativeAnnotation annotation = nativeDocumentSearcherResult2.getAnnotation();
                        if (annotation != null && annotation.getAbsolutePageIndex() != null && annotation.getAnnotationId() != null) {
                            annotationBlocking = AnnotationProviderBlocking.getAnnotationBlocking(TextSearch.this.document.getAnnotationProvider(), annotation.getAbsolutePageIndex().intValue(), (int) annotation.getAnnotationId().longValue());
                        }
                        TextSearch textSearch2 = TextSearch.this;
                        textBlockCreateTextBlock = annotationBlocking != null ? TextBlockHelpersKt.createTextBlock(annotationBlocking, textSearch2.document, rangeInText) : TextBlockHelpersKt.createTextBlock(textSearch2.document, pageIndex, rangeInText);
                    }
                    flowableEmitter.onNext(new SearchResult(pageIndex, textBlockCreateTextBlock, textSnippet, annotationBlocking, TextSearch.this.document));
                }
            }

            @Override // com.pspdfkit.internal.jni.NativeDocumentSearcherQueryResultHandler
            public void searchCompleteHandler(NativeDocumentSearcherQuery nativeDocumentSearcherQuery3, String str2) {
                flowableEmitter.onComplete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSearchAsync$1() throws Throwable {
        cancelSearch(this.currentSearchId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Publisher lambda$performSearchAsync$2(final String str, final SearchOptions searchOptions) throws Throwable {
        g60 g60VarC;
        if (str.trim().isEmpty()) {
            return Flowable.empty();
        }
        if (str.equals("pspdf:info") || str.equals("nutrient:info")) {
            WeakReference<Activity> weakReference = j.a;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new i00(activity, null), 3, null);
                return Flowable.empty();
            }
        }
        Flowable flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.document.search.TextSearch$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws Throwable {
                this.f$0.lambda$performSearchAsync$0(str, searchOptions, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        Flowable flowableDoOnCancel = flowableCreate.subscribeOn(((m0) g60VarC).a()).doOnCancel(new Action() { // from class: com.pspdfkit.document.search.TextSearch$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$performSearchAsync$1();
            }
        });
        int i = searchOptions.maxSearchResults;
        return i == Integer.MAX_VALUE ? flowableDoOnCancel : flowableDoOnCancel.take(i);
    }

    public List<SearchResult> performSearch(String str) {
        return performSearch(str, this.defaultSearchOptions);
    }

    public Flowable<SearchResult> performSearchAsync(final String str, final SearchOptions searchOptions) {
        uw.a(str, "searchString", null);
        uw.a(searchOptions, "searchOptions", null);
        return Flowable.defer(new Supplier() { // from class: com.pspdfkit.document.search.TextSearch$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$performSearchAsync$2(str, searchOptions);
            }
        });
    }

    public List<SearchResult> performSearch(String str, SearchOptions searchOptions) {
        return performSearchAsync(str, searchOptions).toList().blockingGet();
    }

    public Flowable<SearchResult> performSearchAsync(String str) {
        return performSearchAsync(str, this.defaultSearchOptions);
    }

    private void cancelSearch() {
        synchronized (this) {
            NativeDocumentSearcher nativeDocumentSearcher = this.documentSearcher;
            if (nativeDocumentSearcher != null) {
                nativeDocumentSearcher.cancelSearches();
                this.currentSearchId = null;
                this.documentSearcher = null;
            }
        }
    }
}
