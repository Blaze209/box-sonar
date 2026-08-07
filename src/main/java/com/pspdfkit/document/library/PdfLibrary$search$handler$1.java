package com.pspdfkit.document.library;

import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.jni.NativeDocumentLibraryPreviewResult;
import com.pspdfkit.internal.jni.NativeDocumentLibraryQuery;
import com.pspdfkit.internal.jni.NativeDocumentLibraryQueryResultHandler;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.q10;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052B\u0010\u0006\u001a>\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\u0007j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b`\fH\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016¨\u0006\u0011"}, d2 = {"com/pspdfkit/document/library/PdfLibrary$search$handler$1", "Lcom/pspdfkit/internal/jni/NativeDocumentLibraryQueryResultHandler;", "successHandler", "", "query", "Lcom/pspdfkit/internal/jni/NativeDocumentLibraryQuery;", "nativeResults", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "previewHandler", "Ljava/util/ArrayList;", "Lcom/pspdfkit/internal/jni/NativeDocumentLibraryPreviewResult;", "Lkotlin/collections/ArrayList;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PdfLibrary$search$handler$1 extends NativeDocumentLibraryQueryResultHandler {
    final /* synthetic */ QueryResultListener $resultListener;

    public PdfLibrary$search$handler$1(QueryResultListener queryResultListener) {
        this.$resultListener = queryResultListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandler$lambda$1(QueryResultListener queryResultListener, String str, Map map) throws Exception {
        try {
            queryResultListener.onSearchPreviewsGenerated(str, map);
        } catch (Exception e) {
            PdfLog.e("Nutri.PdfLibrary", e, "Exception in onSearchPreviewsGenerated callback!", new Object[0]);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void successHandler$lambda$0(QueryResultListener queryResultListener, String str, Map map) throws Exception {
        try {
            queryResultListener.onSearchCompleted(str, map);
        } catch (Exception e) {
            PdfLog.e("Nutri.PdfLibrary", e, "Exception in onSearchCompleted callback!", new Object[0]);
            throw e;
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryQueryResultHandler
    public void previewHandler(NativeDocumentLibraryQuery query, ArrayList<NativeDocumentLibraryPreviewResult> nativeResults) {
        g60 g60VarC;
        query.getClass();
        nativeResults.getClass();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<NativeDocumentLibraryPreviewResult> it = nativeResults.iterator();
        it.getClass();
        while (it.hasNext()) {
            NativeDocumentLibraryPreviewResult next = it.next();
            next.getClass();
            NativeDocumentLibraryPreviewResult nativeDocumentLibraryPreviewResult = next;
            if (!linkedHashMap.containsKey(nativeDocumentLibraryPreviewResult.getUid())) {
                linkedHashMap.put(nativeDocumentLibraryPreviewResult.getUid(), new LinkedHashSet());
            }
            QueryPreviewResult queryPreviewResult = new QueryPreviewResult(nativeDocumentLibraryPreviewResult.getUid(), (int) nativeDocumentLibraryPreviewResult.getPageIndex(), nativeDocumentLibraryPreviewResult.getRange(), nativeDocumentLibraryPreviewResult.getPreviewText(), nativeDocumentLibraryPreviewResult.getRangeInPreviewText());
            Set set = (Set) linkedHashMap.get(nativeDocumentLibraryPreviewResult.getUid());
            if (set != null) {
                set.add(queryPreviewResult);
            }
        }
        final String searchString = query.getSearchString();
        searchString.getClass();
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        Scheduler.Worker workerCreateWorker = ((m0) g60VarC).a().createWorker();
        final QueryResultListener queryResultListener = this.$resultListener;
        workerCreateWorker.schedule(new Runnable() { // from class: com.pspdfkit.document.library.PdfLibrary$search$handler$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                PdfLibrary$search$handler$1.previewHandler$lambda$1(queryResultListener, searchString, linkedHashMap);
            }
        });
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryQueryResultHandler
    public void successHandler(NativeDocumentLibraryQuery query, HashMap<String, HashSet<Long>> nativeResults) {
        g60 g60VarC;
        query.getClass();
        nativeResults.getClass();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, HashSet<Long>> entry : nativeResults.entrySet()) {
            String key = entry.getKey();
            HashSet<Long> value = entry.getValue();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<Long> it = value.iterator();
            it.getClass();
            while (it.hasNext()) {
                Long next = it.next();
                next.getClass();
                linkedHashSet.add(Integer.valueOf((int) next.longValue()));
            }
            linkedHashMap.put(key, linkedHashSet);
        }
        final String searchString = query.getSearchString();
        searchString.getClass();
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        Scheduler.Worker workerCreateWorker = ((m0) g60VarC).a().createWorker();
        final QueryResultListener queryResultListener = this.$resultListener;
        workerCreateWorker.schedule(new Runnable() { // from class: com.pspdfkit.document.library.PdfLibrary$search$handler$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                PdfLibrary$search$handler$1.successHandler$lambda$0(queryResultListener, searchString, linkedHashMap);
            }
        });
    }
}
