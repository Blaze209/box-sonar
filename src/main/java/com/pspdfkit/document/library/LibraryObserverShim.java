package com.pspdfkit.document.library;

import com.pspdfkit.internal.jni.NativeDocumentLibrary;
import com.pspdfkit.internal.jni.NativeDocumentLibraryIndexingObserver;
import com.pspdfkit.internal.jni.NativeObservingEvents;
import java.util.Collection;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/document/library/LibraryObserverShim;", "Lcom/pspdfkit/internal/jni/NativeDocumentLibraryIndexingObserver;", "indexingListener", "Lcom/pspdfkit/document/library/LibraryIndexingListener;", "<init>", "(Lcom/pspdfkit/document/library/LibraryIndexingListener;)V", "willStartIndexingDocument", "", "documentLibrary", "Lcom/pspdfkit/internal/jni/NativeDocumentLibrary;", "uid", "", "didFinishIndexingDocument", "success", "", "didIndexPage", "pageIndex", "", "text", "getSubscribedEvents", "Ljava/util/EnumSet;", "Lcom/pspdfkit/internal/jni/NativeObservingEvents;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LibraryObserverShim extends NativeDocumentLibraryIndexingObserver {
    public static final int $stable = 8;
    private final LibraryIndexingListener indexingListener;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<NativeObservingEvents> entries$0 = EnumEntriesKt.enumEntries(NativeObservingEvents.values());
    }

    public LibraryObserverShim(LibraryIndexingListener libraryIndexingListener) {
        libraryIndexingListener.getClass();
        this.indexingListener = libraryIndexingListener;
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryIndexingObserver
    public void didFinishIndexingDocument(NativeDocumentLibrary documentLibrary, String uid, boolean success) {
        documentLibrary.getClass();
        uid.getClass();
        this.indexingListener.onFinishIndexingDocument(uid, success);
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryIndexingObserver
    public void didIndexPage(NativeDocumentLibrary documentLibrary, String uid, int pageIndex, String text) {
        documentLibrary.getClass();
        uid.getClass();
        text.getClass();
        this.indexingListener.onPageIndexed(uid, pageIndex, text);
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryIndexingObserver
    public EnumSet<NativeObservingEvents> getSubscribedEvents() {
        if (this.indexingListener.enableOnPageIndexedEvents()) {
            EnumSet<NativeObservingEvents> enumSetCopyOf = EnumSet.copyOf((Collection) EntriesMappings.entries$0);
            enumSetCopyOf.getClass();
            return enumSetCopyOf;
        }
        EnumSet<NativeObservingEvents> enumSetOf = EnumSet.of(NativeObservingEvents.START_INDEXING, NativeObservingEvents.FINISH_INDEXING);
        enumSetOf.getClass();
        return enumSetOf;
    }

    @Override // com.pspdfkit.internal.jni.NativeDocumentLibraryIndexingObserver
    public void willStartIndexingDocument(NativeDocumentLibrary documentLibrary, String uid) {
        documentLibrary.getClass();
        uid.getClass();
        this.indexingListener.onStartIndexingDocument(uid);
    }
}
