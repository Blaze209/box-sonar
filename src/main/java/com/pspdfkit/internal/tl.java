package com.pspdfkit.internal;

import com.pspdfkit.jetpack.compose.interactors.AnnotationListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentListener;
import com.pspdfkit.jetpack.compose.interactors.FormListener;
import com.pspdfkit.jetpack.compose.interactors.InstantDocumentListener;
import com.pspdfkit.jetpack.compose.interactors.InstantDocumentManager;
import com.pspdfkit.jetpack.compose.interactors.UiListener;

/* JADX INFO: loaded from: classes3.dex */
public final class tl extends wd implements InstantDocumentManager {
    public final InstantDocumentListener e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tl(DocumentListener documentListener, AnnotationListener annotationListener, UiListener uiListener, FormListener formListener, InstantDocumentListener instantDocumentListener) {
        super(documentListener, annotationListener, uiListener, formListener);
        documentListener.getClass();
        annotationListener.getClass();
        uiListener.getClass();
        formListener.getClass();
        instantDocumentListener.getClass();
        this.e = instantDocumentListener;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.InstantDocumentManager
    public final InstantDocumentListener getInstantListener() {
        return this.e;
    }
}
