package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AtomicFile;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.editor.PdfDocumentEditor;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.WritableDataProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.jni.NativeEditingChange;
import com.pspdfkit.internal.jni.NativeEditingOperation;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeNewPageConfiguration;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.undo.EditingChange;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class gd implements PdfDocumentEditor {
    public static final /* synthetic */ boolean e = true;
    public HashSet a;
    public final lm b;
    public NativeDocumentEditor c;
    public Integer d = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NativeEditingOperation.values().length];
            a = iArr;
            try {
                iArr[NativeEditingOperation.REMOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NativeEditingOperation.INSERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NativeEditingOperation.INSERTREFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NativeEditingOperation.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NativeEditingOperation.ROTATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public gd(lm lmVar) {
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow editing of PDF documents.");
        }
        this.b = lmVar;
    }

    public final Completable a(final HashSet hashSet, final String str, final DocumentSaveOptions documentSaveOptions) {
        uw.a(hashSet, "pageIndexes", null);
        uw.a(hashSet, "pageIndexes may not be empty.");
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(documentSaveOptions, hashSet, str);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> addPage(final int i, final NewPage newPage) {
        if (i < 0 || i > a(true).getPageCount()) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + a(true).getPageCount() + "]");
        }
        uw.a(newPage, "newPageConfiguration", null);
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(i, newPage);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> addPages(final int i, final List<NewPage> list) {
        if (i < 0 || i > a(true).getPageCount()) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + a(true).getPageCount() + "]");
        }
        uw.a(list, "newPageConfigurations", null);
        uw.a(list, "newPageConfigurations may not be empty.");
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(i, list);
            }
        });
    }

    public final Completable b(final String str, final OutputStream outputStream) {
        uw.a(str, "cachedDocumentPath", null);
        uw.a(outputStream, "destinationUri", null);
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda12
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(str, outputStream);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final void beginTransaction() {
        a(true).beginUpdates();
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final boolean canRedo() {
        return a(true).canRedo();
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final boolean canUndo() {
        return a(true).canUndo();
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final List<EditingChange> commitTransaction() {
        ArrayList<NativeEditingChange> arrayListCommitUpdates = a(true).commitUpdates();
        a(arrayListCommitUpdates);
        return mr.a(arrayListCommitUpdates);
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final List<EditingChange> discardTransaction() {
        return mr.a(a(true).discardUpdates());
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> duplicatePages(final Set<Integer> set) {
        uw.a(set, "pageIndexes", null);
        uw.a(set, "pageIndexes may not be empty.");
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(set);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Completable exportPages(Context context, final OutputStream outputStream, Set<Integer> set, DocumentSaveOptions documentSaveOptions) {
        uw.a(context, "context", null);
        uw.a(outputStream, "outputStream", null);
        uw.a(set, "pageIndexes", null);
        uw.a(set, "pageIndexes may not be empty.");
        return a(context, set, documentSaveOptions).flatMapCompletable(new Function() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(outputStream, (String) obj);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final PdfDocument getDocument() {
        return this.b;
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final int getPageCount() {
        return a(true).getPageCount();
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Size getRotatedPageSize(int i) {
        if (i < 0 || i > a(true).getPageCount() - 1) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + (a(true).getPageCount() - 1) + "]");
        }
        return a(true).getRotatedPageSize(i);
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> importDocument(final Context context, DocumentSource documentSource, final int i) {
        if (i < 0 || i > a(true).getPageCount()) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + a(true).getPageCount() + "]");
        }
        uw.a(documentSource, "documentSource", null);
        uw.a(context, "context", null);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        try {
            final PdfDocument pdfDocumentA = a(context, documentSource);
            return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.a(i, pdfDocumentA, arrayList2, arrayList, context);
                }
            });
        } catch (IOException e2) {
            PdfLog.e("Nutri.DocumentEditorImp", e2, "Can't extract document to import.", new Object[0]);
            return Single.just(arrayList);
        }
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final boolean isTransactionActive() {
        return a(true).isInsideUpdateGroup();
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> movePages(final Set<Integer> set, final int i) {
        uw.a(set, "fromPositions", null);
        uw.a(set, "fromPositions may not be empty.");
        if (i < 0 || i > a(true).getPageCount()) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + a(true).getPageCount() + "]");
        }
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(set, i);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final List<EditingChange> redo() {
        ArrayList<NativeEditingChange> arrayListRedo = a(true).redo();
        a(arrayListRedo);
        return mr.a(arrayListRedo);
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> removePages(final Set<Integer> set) {
        uw.a(set, "pageIndexes", null);
        uw.a(set, "pageIndexes may not be empty.");
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.b(set);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Completable renderPageToBitmap(final int i, final Bitmap bitmap, final PageRenderConfiguration pageRenderConfiguration) {
        if (i < 0 || i > a(true).getPageCount() - 1) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + (a(true).getPageCount() - 1) + "]");
        }
        uw.a(bitmap, "buffer", null);
        uw.a(pageRenderConfiguration, "configuration", null);
        if (pageRenderConfiguration.reuseBitmap != null) {
            PdfLog.w("Nutri.DocumentEditorImp", "configuration reuseBitmap is not supported and will be ignored.", new Object[0]);
        }
        if (pageRenderConfiguration.renderRegion) {
            PdfLog.w("Nutri.DocumentEditorImp", "configuration renderRegion is not supported and will be ignored.", new Object[0]);
        }
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda15
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(i, bitmap, pageRenderConfiguration);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Single<List<EditingChange>> rotatePages(final Set<Integer> set, final int i) {
        uw.a(set, "pageIndexes", null);
        uw.a(set, "pageIndexes may not be empty.");
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.b(set, i);
                }
            });
        }
        throw new IllegalArgumentException(String.format("Illegal page rotation: %d. Page rotation may be one the following: %d, %d, %d, %d", Integer.valueOf(i), 0, 90, 180, 270));
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Completable saveDocument(final Context context, DocumentSaveOptions documentSaveOptions) {
        uw.a(context, "context", null);
        if (this.b.A.get(0).isFileSource()) {
            return b(context, documentSaveOptions).map(new Function() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda5
                @Override // io.reactivex.rxjava3.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.a(context, (String) obj);
                }
            }).ignoreElement();
        }
        if ((this.b.A.get(0).getDataProvider() instanceof WritableDataProvider) && ((WritableDataProvider) this.b.A.get(0).getDataProvider()).canWrite()) {
            return b(context, documentSaveOptions).map(new Function() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda6
                @Override // io.reactivex.rxjava3.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.a((String) obj);
                }
            }).ignoreElement();
        }
        throw new IllegalStateException("Saving document in place can be applied only when the source is a file Uri or a data provider that supports saving.");
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final void setPageLabel(int i, String str) {
        if (i < 0 || i > a(true).getPageCount() - 1) {
            throw new IllegalArgumentException("Invalid page destination index " + i + " - valid page destination indexes are [0, " + (a(true).getPageCount() - 1) + "]");
        }
        a(true).setPageLabel(i, str);
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final List<EditingChange> undo() {
        ArrayList<NativeEditingChange> arrayListUndo = a(true).undo();
        a(arrayListUndo);
        return mr.a(arrayListUndo);
    }

    public final List b(Set set) throws Exception {
        ArrayList<NativeEditingChange> arrayListRemovePages = a(true).removePages(new HashSet<>(set));
        a(arrayListRemovePages);
        return mr.a(arrayListRemovePages);
    }

    public final List a(int i, NewPage newPage) throws Exception {
        ArrayList<NativeEditingChange> arrayListAddPage = a(true).addPage(i, newPage.getNativeNewPageConfiguration());
        a(arrayListAddPage);
        return mr.a(arrayListAddPage);
    }

    public final List b(Set set, int i) throws Exception {
        return mr.a(a(true).rotatePagesBy(new HashSet<>(set), i));
    }

    public final List a(int i, List list) throws Exception {
        NativeDocumentEditor nativeDocumentEditorA = a(true);
        list.getClass();
        ArrayList<NativeNewPageConfiguration> arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((NewPage) it.next()).getNativeNewPageConfiguration());
        }
        ArrayList<NativeEditingChange> arrayListAddPages = nativeDocumentEditorA.addPages(i, arrayList);
        a(arrayListAddPages);
        return mr.a(arrayListAddPages);
    }

    public final Single<String> b(final Context context, final DocumentSaveOptions documentSaveOptions) {
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(context, documentSaveOptions);
            }
        });
    }

    @Override // com.pspdfkit.document.editor.PdfDocumentEditor
    public final Completable saveDocument(Context context, final OutputStream outputStream, DocumentSaveOptions documentSaveOptions) {
        uw.a(context, "context", null);
        uw.a(outputStream, "destinationUri", null);
        return b(context, documentSaveOptions).flatMapCompletable(new Function() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.b(outputStream, (String) obj);
            }
        });
    }

    public final List a(Set set) throws Exception {
        ArrayList<NativeEditingChange> arrayListDuplicatePages = a(true).duplicatePages(new HashSet<>(set));
        a(arrayListDuplicatePages);
        return mr.a(arrayListDuplicatePages);
    }

    public final List a(Set set, int i) throws Exception {
        ArrayList<NativeEditingChange> arrayListMovePages = a(true).movePages(new HashSet<>(set), i);
        a(arrayListMovePages);
        return mr.a(arrayListMovePages);
    }

    public final synchronized NativeDocumentEditor a(boolean z) {
        if (this.c == null && z) {
            this.c = NativeDocumentEditor.EditDocument(this.b.y);
        }
        return this.c;
    }

    public final /* synthetic */ List a(int i, PdfDocument pdfDocument, ArrayList arrayList, List list, Context context) throws Exception {
        for (int i2 = 0; i2 < pdfDocument.getPageCount(); i2++) {
            arrayList.add(NewPage.fromPage(pdfDocument, i2).build());
        }
        list.addAll(addPages(i, arrayList).blockingGet());
        Uri fileUri = pdfDocument.getDocumentSource().getFileUri();
        if (fileUri != null) {
            File file = new File(wg.a(context, fileUri));
            if (file.exists()) {
                file.delete();
            }
        }
        return list;
    }

    public static PdfDocument a(Context context, DocumentSource documentSource) throws IOException {
        File fileA = wg.a(context, documentSource.getUid() + "_temp");
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
        if (absolutePath != null) {
            File file = new File(absolutePath);
            if (documentSource.isFileSource()) {
                wg.a(context, false, Arrays.asList(documentSource.getFileUri()));
                InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(context.getContentResolver(), documentSource.getFileUri());
                if (inputStreamOpenInputStream != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            wg.a(inputStreamOpenInputStream, fileOutputStream);
                            fileOutputStream.close();
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        inputStreamOpenInputStream.close();
                        throw th3;
                    }
                } else {
                    throw new IllegalStateException("Failed to open document source with Uri: " + documentSource.getFileUri());
                }
            } else {
                DataProvider dataProvider = documentSource.getDataProvider();
                if (!e && dataProvider == null) {
                    throw new AssertionError();
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        wg.a(dataProvider, fileOutputStream2);
                        fileOutputStream2.close();
                        dataProvider.release();
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                        throw th4;
                    }
                } catch (Throwable th6) {
                    dataProvider.release();
                    throw th6;
                }
            }
            return PdfDocumentLoader.openDocument(context, Uri.fromFile(file));
        }
        throw new IllegalStateException("Failed to create temporary destination path.");
    }

    public final void a(int i, Bitmap bitmap, PageRenderConfiguration pageRenderConfiguration) throws Throwable {
        ou ouVar = this.b.c;
        android.util.Size size = new android.util.Size(bitmap.getWidth(), bitmap.getHeight());
        NativeDocumentEditor nativeDocumentEditorA = a(true);
        List list = Collections.EMPTY_LIST;
        a(true).render(i, bitmap, r10.a(km.a(ouVar, i, null, size, pageRenderConfiguration, 10, nativeDocumentEditorA, null, list, list, null)));
    }

    public final DocumentSource a(Context context, String str) throws Exception {
        FileOutputStream fileOutputStreamStartWrite;
        Uri fileUri = this.b.A.get(0).getFileUri();
        boolean z = e;
        if (!z && fileUri == null) {
            throw new AssertionError("Document source URI must not be null.");
        }
        wg.a(context, true, Arrays.asList(fileUri));
        String strA = wg.a(context, fileUri);
        if (!z && strA == null) {
            throw new AssertionError();
        }
        AtomicFile atomicFile = new AtomicFile(new File(strA));
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                b(str, fileOutputStreamStartWrite).blockingAwait();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
                return new DocumentSource(fileUri);
            } catch (Exception e2) {
                e = e2;
                if (fileOutputStreamStartWrite != null) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStreamStartWrite = null;
        }
    }

    public final DocumentSource a(String str) throws Throwable {
        WritableDataProvider writableDataProvider = (WritableDataProvider) this.b.A.get(0).getDataProvider();
        writableDataProvider.startWrite(WritableDataProvider.WriteMode.REWRITE_FILE);
        try {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    byte[] bArr = new byte[65535];
                    while (fileInputStream.read(bArr) >= 0) {
                        writableDataProvider.write(bArr);
                    }
                    fileInputStream.close();
                } catch (IOException e2) {
                    PdfLog.e("Nutri.DocumentEditorImp", e2, "Error while writing.", new Object[0]);
                }
            } catch (FileNotFoundException e3) {
                PdfLog.e("Nutri.DocumentEditorImp", e3, "Error while opening cached file.", new Object[0]);
            }
            return new DocumentSource(writableDataProvider);
        } finally {
            writableDataProvider.finishWrite();
        }
    }

    public final String a(Context context, DocumentSaveOptions documentSaveOptions) throws Exception {
        this.b.saveIfModified();
        File fileA = wg.a(context, "pdf");
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
        if (absolutePath != null) {
            if (documentSaveOptions == null) {
                documentSaveOptions = this.b.a(true);
            }
            documentSaveOptions.setIncremental(false);
            if (a(true).writeToFilePath(absolutePath, mr.a(documentSaveOptions, this.b, true))) {
                PdfLog.d("Nutri.DocumentEditorImp", "Saved edited file to ".concat(absolutePath), new Object[0]);
                ut utVar = q10.b;
                if (utVar == null) {
                    utVar = new ut(NativePageCache.create(15728640));
                    q10.b = utVar;
                }
                lm lmVar = this.b;
                utVar.a(lmVar.B, lmVar.s).blockingAwait();
                return absolutePath;
            }
            throw new IOException("Failed to save file to new destination.");
        }
        throw new IOException("Failed to create temporary file.");
    }

    public final Single<String> a(final Context context, final Set<Integer> set, final DocumentSaveOptions documentSaveOptions) {
        uw.a(set, "pageIndexes may not be empty.");
        final HashSet hashSet = new HashSet(set);
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gd$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(context, documentSaveOptions, set, hashSet);
            }
        });
    }

    public final String a(Context context, DocumentSaveOptions documentSaveOptions, Set set, HashSet hashSet) throws Exception {
        this.b.saveIfModified();
        File fileA = wg.a(context, "pdf");
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
        if (absolutePath != null) {
            if (documentSaveOptions == null) {
                documentSaveOptions = this.b.a(true);
            }
            documentSaveOptions.setIncremental(false);
            HashSet hashSet2 = this.a;
            if (hashSet2 == null) {
                this.a = new HashSet(set.size());
            } else {
                hashSet2.clear();
            }
            this.a.addAll(set);
            a(hashSet, absolutePath, documentSaveOptions).blockingAwait();
            PdfLog.d("Nutri.DocumentEditorImp", "Exported file to ".concat(absolutePath), new Object[0]);
            ut utVar = q10.b;
            if (utVar == null) {
                utVar = new ut(NativePageCache.create(15728640));
                q10.b = utVar;
            }
            lm lmVar = this.b;
            utVar.a(lmVar.B, lmVar.s).blockingAwait();
            return absolutePath;
        }
        throw new IOException("Failed to create temporary file.");
    }

    public final /* synthetic */ void a(String str, OutputStream outputStream) throws Throwable {
        PdfLog.d("Nutri.DocumentEditorImp", "Source document is an URI, copy " + str + " -> " + outputStream, new Object[0]);
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                wg.a(fileInputStream, outputStream);
                fileInputStream.close();
                outputStream.close();
                PdfLog.d("Nutri.DocumentEditorImp", "Export OK.", new Object[0]);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            outputStream.close();
            throw th3;
        }
    }

    public final void a(DocumentSaveOptions documentSaveOptions, Set set, String str) throws Throwable {
        if (a(true).exportPagesToFilePath(new HashSet<>(set), str, mr.a(documentSaveOptions, this.b, true))) {
            return;
        }
        throw new IOException("Failed to export file to new destination: " + str + ".");
    }

    public final void a(ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        Integer numValueOf = null;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NativeEditingChange nativeEditingChange = (NativeEditingChange) obj;
            if (this.d == null) {
                return;
            }
            int affectedPageIndex = nativeEditingChange.getAffectedPageIndex();
            if (numValueOf != null && nativeEditingChange.getOperation() != NativeEditingOperation.MOVE) {
                this.d = numValueOf;
                numValueOf = null;
            }
            int i2 = a.a[nativeEditingChange.getOperation().ordinal()];
            if (i2 == 1) {
                int iIntValue = this.d.intValue();
                Integer num = this.d;
                if (affectedPageIndex < iIntValue) {
                    this.d = Integer.valueOf(num.intValue() - 1);
                } else if (affectedPageIndex == num.intValue()) {
                    this.d = null;
                }
            } else if (i2 != 2 && i2 != 3) {
                if (i2 == 4 && affectedPageIndex == this.d.intValue()) {
                    numValueOf = Integer.valueOf(nativeEditingChange.getPageIndexDestination());
                }
            } else if (affectedPageIndex <= this.d.intValue()) {
                this.d = Integer.valueOf(this.d.intValue() + 1);
            }
        }
        if (numValueOf != null) {
            this.d = numValueOf;
        }
    }
}
