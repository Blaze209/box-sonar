package com.pspdfkit.ui;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentCoordinator {

    public interface OnDocumentCoordinatorEmptyListener {
        void onDocumentCoordinatorEmpty();
    }

    public interface OnDocumentVisibleListener {
        void onDocumentVisible(DocumentDescriptor documentDescriptor);
    }

    public interface OnDocumentsChangedListener {
        void onDocumentAdded(DocumentDescriptor documentDescriptor);

        void onDocumentMoved(DocumentDescriptor documentDescriptor, int i);

        void onDocumentRemoved(DocumentDescriptor documentDescriptor);

        void onDocumentReplaced(DocumentDescriptor documentDescriptor, DocumentDescriptor documentDescriptor2);

        void onDocumentUpdated(DocumentDescriptor documentDescriptor);
    }

    boolean addDocument(DocumentDescriptor documentDescriptor);

    boolean addDocument(DocumentDescriptor documentDescriptor, int i);

    boolean addDocumentAfterVisibleDocument(DocumentDescriptor documentDescriptor);

    void addOnDocumentCoordinatorEmptyListener(OnDocumentCoordinatorEmptyListener onDocumentCoordinatorEmptyListener);

    void addOnDocumentVisibleListener(OnDocumentVisibleListener onDocumentVisibleListener);

    void addOnDocumentsChangedListener(OnDocumentsChangedListener onDocumentsChangedListener);

    List<DocumentDescriptor> getDocuments();

    DocumentDescriptor getVisibleDocument();

    boolean moveDocument(DocumentDescriptor documentDescriptor, int i);

    boolean removeAllDocuments();

    boolean removeAllDocumentsExceptVisible();

    boolean removeDocument(DocumentDescriptor documentDescriptor);

    void removeOnDocumentCoordinatorEmptyListener(OnDocumentCoordinatorEmptyListener onDocumentCoordinatorEmptyListener);

    void removeOnDocumentVisibleListener(OnDocumentVisibleListener onDocumentVisibleListener);

    void removeOnDocumentsChangedListener(OnDocumentsChangedListener onDocumentsChangedListener);

    boolean setDocument(DocumentDescriptor documentDescriptor);

    boolean setVisibleDocument(DocumentDescriptor documentDescriptor);
}
