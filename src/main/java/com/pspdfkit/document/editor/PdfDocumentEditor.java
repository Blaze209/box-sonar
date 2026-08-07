package com.pspdfkit.document.editor;

import android.content.Context;
import android.graphics.Bitmap;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.undo.EditingChange;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfDocumentEditor {
    Single<List<EditingChange>> addPage(int i, NewPage newPage);

    Single<List<EditingChange>> addPages(int i, List<NewPage> list);

    void beginTransaction();

    boolean canRedo();

    boolean canUndo();

    List<EditingChange> commitTransaction();

    List<EditingChange> discardTransaction();

    Single<List<EditingChange>> duplicatePages(Set<Integer> set);

    Completable exportPages(Context context, OutputStream outputStream, Set<Integer> set, DocumentSaveOptions documentSaveOptions);

    PdfDocument getDocument();

    int getPageCount();

    Size getRotatedPageSize(int i);

    Single<List<EditingChange>> importDocument(Context context, DocumentSource documentSource, int i);

    boolean isTransactionActive();

    Single<List<EditingChange>> movePages(Set<Integer> set, int i);

    List<EditingChange> redo();

    Single<List<EditingChange>> removePages(Set<Integer> set);

    Completable renderPageToBitmap(int i, Bitmap bitmap, PageRenderConfiguration pageRenderConfiguration);

    Single<List<EditingChange>> rotatePages(Set<Integer> set, int i);

    Completable saveDocument(Context context, DocumentSaveOptions documentSaveOptions);

    Completable saveDocument(Context context, OutputStream outputStream, DocumentSaveOptions documentSaveOptions);

    void setPageLabel(int i, String str);

    List<EditingChange> undo();
}
