package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.View;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.DocumentDescriptor;
import com.pspdfkit.ui.PdfFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class bw implements DocumentCoordinator {
    public final cw a;
    public final ArrayList<DocumentDescriptor> b = new ArrayList<>();
    public DocumentDescriptor c = null;
    public final go<DocumentCoordinator.OnDocumentsChangedListener> d = new go<>();
    public final go<DocumentCoordinator.OnDocumentVisibleListener> e = new go<>();
    public final go<DocumentCoordinator.OnDocumentCoordinatorEmptyListener> f = new go<>();

    public bw(cw cwVar) {
        this.a = cwVar;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean addDocument(DocumentDescriptor documentDescriptor) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("addDocument() may only be called from the UI thread.");
        }
        if (this.b.contains(documentDescriptor)) {
            return false;
        }
        this.b.add(documentDescriptor);
        Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onDocumentAdded(documentDescriptor);
        }
        return true;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean addDocumentAfterVisibleDocument(DocumentDescriptor documentDescriptor) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("addDocumentAfterVisibleDocument() may only be called from the UI thread.");
        }
        DocumentDescriptor documentDescriptor2 = this.c;
        if (documentDescriptor2 == null) {
            return false;
        }
        addDocument(documentDescriptor, this.b.indexOf(documentDescriptor2) + 1);
        return true;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void addOnDocumentCoordinatorEmptyListener(DocumentCoordinator.OnDocumentCoordinatorEmptyListener onDocumentCoordinatorEmptyListener) {
        this.f.a(onDocumentCoordinatorEmptyListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void addOnDocumentVisibleListener(DocumentCoordinator.OnDocumentVisibleListener onDocumentVisibleListener) {
        this.e.a(onDocumentVisibleListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void addOnDocumentsChangedListener(DocumentCoordinator.OnDocumentsChangedListener onDocumentsChangedListener) {
        this.d.a(onDocumentsChangedListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final List<DocumentDescriptor> getDocuments() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final DocumentDescriptor getVisibleDocument() {
        return this.c;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean removeAllDocuments() {
        List listUnmodifiableList = Collections.unmodifiableList(this.b);
        boolean zRemoveDocument = false;
        for (int size = listUnmodifiableList.size() - 1; size >= 0; size--) {
            zRemoveDocument |= removeDocument((DocumentDescriptor) listUnmodifiableList.get(size));
        }
        return zRemoveDocument;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean removeAllDocumentsExceptVisible() {
        List listUnmodifiableList = Collections.unmodifiableList(this.b);
        DocumentDescriptor documentDescriptor = this.c;
        boolean zRemoveDocument = false;
        for (int size = listUnmodifiableList.size() - 1; size >= 0; size--) {
            DocumentDescriptor documentDescriptor2 = (DocumentDescriptor) listUnmodifiableList.get(size);
            if (documentDescriptor2 != documentDescriptor) {
                zRemoveDocument |= removeDocument(documentDescriptor2);
            }
        }
        return zRemoveDocument;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean removeDocument(DocumentDescriptor documentDescriptor) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("removeDocument() may only be called from the UI thread.");
        }
        int iIndexOf = this.b.indexOf(documentDescriptor);
        if (iIndexOf < 0) {
            return false;
        }
        this.b.remove(iIndexOf);
        Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onDocumentRemoved(documentDescriptor);
        }
        if (documentDescriptor == this.c) {
            if (this.b.size() > 0) {
                setVisibleDocument(this.b.get(iIndexOf != 0 ? iIndexOf - 1 : 0));
            } else {
                a(null);
            }
        }
        return true;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void removeOnDocumentCoordinatorEmptyListener(DocumentCoordinator.OnDocumentCoordinatorEmptyListener onDocumentCoordinatorEmptyListener) {
        this.f.b(onDocumentCoordinatorEmptyListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void removeOnDocumentVisibleListener(DocumentCoordinator.OnDocumentVisibleListener onDocumentVisibleListener) {
        this.e.b(onDocumentVisibleListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final void removeOnDocumentsChangedListener(DocumentCoordinator.OnDocumentsChangedListener onDocumentsChangedListener) {
        this.d.b(onDocumentsChangedListener);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean setDocument(DocumentDescriptor documentDescriptor) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocument() may only be called from the UI thread.");
        }
        DocumentDescriptor documentDescriptor2 = this.c;
        if (documentDescriptor2 == null) {
            if (!addDocument(documentDescriptor)) {
                return false;
            }
            setVisibleDocument(documentDescriptor);
            return true;
        }
        if (documentDescriptor2 == documentDescriptor) {
            return false;
        }
        ArrayList<DocumentDescriptor> arrayList = this.b;
        arrayList.set(arrayList.indexOf(documentDescriptor2), documentDescriptor);
        DocumentDescriptor documentDescriptor3 = this.c;
        this.c = null;
        setVisibleDocument(documentDescriptor);
        Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onDocumentReplaced(documentDescriptor3, documentDescriptor);
        }
        return true;
    }

    public final boolean a(DocumentDescriptor documentDescriptor) {
        Bitmap bitmapCopy;
        PdfFragment fragment;
        PdfFragment fragment2;
        View view;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setVisibleDocument() may only be called from the UI thread.");
        }
        if (this.c == documentDescriptor || !(documentDescriptor == null || this.b.contains(documentDescriptor))) {
            return false;
        }
        DocumentDescriptor documentDescriptor2 = this.c;
        if (documentDescriptor2 != null) {
            documentDescriptor2.setState(this.a.getActivityState(true, false));
        }
        this.c = documentDescriptor;
        PdfFragment pdfFragmentNewImageInstance = null;
        if (documentDescriptor == null || documentDescriptor.getDocument() == null || (fragment2 = this.a.getFragment()) == null || (view = fragment2.getView()) == null) {
            bitmapCopy = null;
        } else {
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            bitmapCopy = drawingCache != null ? drawingCache.copy(Bitmap.Config.ARGB_8888, false) : null;
            view.destroyDrawingCache();
        }
        DocumentDescriptor documentDescriptor3 = this.c;
        PdfActivityConfiguration configuration = this.a.getConfiguration();
        if (documentDescriptor3 != null) {
            if (documentDescriptor3.getDocument() != null) {
                pdfFragmentNewImageInstance = PdfFragment.newInstance(documentDescriptor3.getDocument(), configuration.getConfiguration());
            } else {
                pdfFragmentNewImageInstance = documentDescriptor3.isImageDocument() ? PdfFragment.newImageInstance(documentDescriptor3.getDocumentSources().get(0), configuration.getConfiguration()) : PdfFragment.newInstanceFromDocumentSources(documentDescriptor3.getDocumentSources(), configuration.getConfiguration());
            }
        }
        this.a.setFragment(pdfFragmentNewImageInstance);
        DocumentDescriptor documentDescriptor4 = this.c;
        if (documentDescriptor4 != null && documentDescriptor4.getState() != null) {
            this.a.setActivityState(this.c.getState());
            if (bitmapCopy != null && (fragment = this.a.getFragment()) != null) {
                fragment.setPageLoadingDrawable(new BitmapDrawable(this.a.getHostingActivity().getResources(), bitmapCopy));
            }
        }
        DocumentDescriptor documentDescriptor5 = this.c;
        if (documentDescriptor5 != null) {
            Iterator<DocumentCoordinator.OnDocumentVisibleListener> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onDocumentVisible(documentDescriptor5);
            }
        } else {
            Iterator<DocumentCoordinator.OnDocumentCoordinatorEmptyListener> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().onDocumentCoordinatorEmpty();
            }
        }
        return true;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean moveDocument(DocumentDescriptor documentDescriptor, int i) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("moveDocument() may only be called from the UI thread.");
        }
        uw.a(documentDescriptor, "documentToMove", null);
        a(i, false);
        int iIndexOf = this.b.indexOf(documentDescriptor);
        if (iIndexOf < 0 || iIndexOf == i) {
            return false;
        }
        this.b.remove(iIndexOf);
        this.b.add(i, documentDescriptor);
        Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onDocumentMoved(documentDescriptor, i);
        }
        return true;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean setVisibleDocument(DocumentDescriptor documentDescriptor) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setVisibleDocument() may only be called from the UI thread.");
        }
        uw.a(documentDescriptor, "visibleDocument", null);
        return a(documentDescriptor);
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator
    public final boolean addDocument(DocumentDescriptor documentDescriptor, int i) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            if (this.b.contains(documentDescriptor)) {
                return false;
            }
            a(i, true);
            this.b.add(i, documentDescriptor);
            Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onDocumentAdded(documentDescriptor);
            }
            return true;
        }
        throw new IllegalStateException("addDocument() may only be called from the UI thread.");
    }

    public final void a(int i, boolean z) {
        if (i >= 0) {
            int size = this.b.size();
            if (z) {
                if (i <= size) {
                    return;
                }
            } else if (i < size) {
                return;
            }
        }
        throw new IndexOutOfBoundsException("Target index " + i + " is out of bounds: [0;" + this.b.size() + (z ? "]" : ")"));
    }
}
