package com.pspdfkit.document.library;

import com.pspdfkit.document.DocumentSource;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/document/library/LibraryDataSource;", "", "libraryWillBeginIndexing", "", "libraryDidFinishIndexingDocument", "uid", "", "success", "", "libraryDidRemoveDocument", "uidsOfDocumentsToBeIndexedByLibrary", "", "uidsOfDocumentsToBeRemovedFromLibrary", "documentSourceForLibrary", "Lcom/pspdfkit/document/DocumentSource;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface LibraryDataSource {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void libraryDidFinishIndexingDocument(LibraryDataSource libraryDataSource, String str, boolean z) {
            str.getClass();
            LibraryDataSource.super.libraryDidFinishIndexingDocument(str, z);
        }

        @Deprecated
        public static void libraryDidRemoveDocument(LibraryDataSource libraryDataSource, String str) {
            str.getClass();
            LibraryDataSource.super.libraryDidRemoveDocument(str);
        }

        @Deprecated
        public static void libraryWillBeginIndexing(LibraryDataSource libraryDataSource) {
            LibraryDataSource.super.libraryWillBeginIndexing();
        }
    }

    DocumentSource documentSourceForLibrary(String uid);

    default void libraryDidFinishIndexingDocument(String uid, boolean success) {
        uid.getClass();
    }

    default void libraryDidRemoveDocument(String uid) {
        uid.getClass();
    }

    default void libraryWillBeginIndexing() {
    }

    List<String> uidsOfDocumentsToBeIndexedByLibrary();

    List<String> uidsOfDocumentsToBeRemovedFromLibrary();
}
