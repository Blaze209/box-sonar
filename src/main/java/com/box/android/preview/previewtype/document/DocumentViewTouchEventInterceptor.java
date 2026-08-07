package com.box.android.preview.previewtype.document;

import android.view.MotionEvent;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentViewTouchEventInterceptor.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentViewTouchEventInterceptor;", "", "<init>", "()V", "onInterceptTouchEvent", "", "motionEvent", "Landroid/view/MotionEvent;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentViewTouchEventInterceptor {
    public static final int $stable = 0;
    public static final DocumentViewTouchEventInterceptor INSTANCE = new DocumentViewTouchEventInterceptor();

    private DocumentViewTouchEventInterceptor() {
    }

    public final void onInterceptTouchEvent(MotionEvent motionEvent, Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            store.send(DocumentPreviewReducer.Action.GestureStarted.INSTANCE);
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            store.send(DocumentPreviewReducer.Action.GestureEnded.INSTANCE);
        }
    }
}
