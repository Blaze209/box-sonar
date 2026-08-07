package com.pspdfkit.jetpack.compose.interactors;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;", "", "documentListener", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "getDocumentListener", "()Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "annotationListener", "Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "getAnnotationListener", "()Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "uiListener", "Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "getUiListener", "()Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "formListener", "Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "getFormListener", "()Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DocumentManager {
    AnnotationListener getAnnotationListener();

    DocumentListener getDocumentListener();

    FormListener getFormListener();

    UiListener getUiListener();
}
