package com.pspdfkit.document.library;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface QueryResultListener {
    void onSearchCompleted(String str, Map<String, Set<Integer>> map);

    void onSearchPreviewsGenerated(String str, Map<String, Set<QueryPreviewResult>> map);
}
