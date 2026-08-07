package com.box.android.preview.previewtype.document.search;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentSearchReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;", "", "textSearchManager", "Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "<init>", "(Lcom/box/android/preview/previewtype/document/search/TextSearchManager;)V", "getTextSearchManager", "()Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentSearchEnvironment {
    public static final int $stable = 8;
    private final TextSearchManager textSearchManager;

    @Inject
    public DocumentSearchEnvironment(TextSearchManager textSearchManager) {
        Intrinsics.checkNotNullParameter(textSearchManager, "textSearchManager");
        this.textSearchManager = textSearchManager;
    }

    public final TextSearchManager getTextSearchManager() {
        return this.textSearchManager;
    }
}
