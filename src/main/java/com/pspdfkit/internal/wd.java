package com.pspdfkit.internal;

import com.pspdfkit.jetpack.compose.interactors.AnnotationListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentManager;
import com.pspdfkit.jetpack.compose.interactors.FormListener;
import com.pspdfkit.jetpack.compose.interactors.UiListener;

/* JADX INFO: loaded from: classes3.dex */
public class wd implements DocumentManager {
    public final DocumentListener a;
    public final AnnotationListener b;
    public final UiListener c;
    public final FormListener d;

    public wd(DocumentListener documentListener, AnnotationListener annotationListener, UiListener uiListener, FormListener formListener) {
        documentListener.getClass();
        annotationListener.getClass();
        uiListener.getClass();
        formListener.getClass();
        this.a = documentListener;
        this.b = annotationListener;
        this.c = uiListener;
        this.d = formListener;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentManager
    public final AnnotationListener getAnnotationListener() {
        return this.b;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentManager
    public final DocumentListener getDocumentListener() {
        return this.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentManager
    public final FormListener getFormListener() {
        return this.d;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentManager
    public final UiListener getUiListener() {
        return this.c;
    }
}
