package com.pspdfkit.jetpack.compose.interactors;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.pspdfkit.internal.tl;
import com.pspdfkit.internal.wd;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a?\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"getDefaultDocumentManager", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;", "documentListener", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "annotationListener", "Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "uiListener", "Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "formListener", "Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;Lcom/pspdfkit/jetpack/compose/interactors/UiListener;Lcom/pspdfkit/jetpack/compose/interactors/FormListener;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;", "getDefaultInstantDocumentManager", "Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentManager;", "instantListener", "Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentListener;", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;Lcom/pspdfkit/jetpack/compose/interactors/UiListener;Lcom/pspdfkit/jetpack/compose/interactors/FormListener;Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentListener;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentManager;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DocumentManagerKt {
    public static final DocumentManager getDefaultDocumentManager(DocumentListener documentListener, AnnotationListener annotationListener, UiListener uiListener, FormListener formListener, Composer composer, int i, int i2) {
        UiListener uiListener2;
        AnnotationListener annotationListener2;
        FormListener formListenerFormListeners;
        DocumentListener documentListenerDocumentListeners = (i2 & 1) != 0 ? DefaultListeners.INSTANCE.documentListeners(null, null, null, null, null, null, null, null, null, null, null, composer, 0, 48, 2047) : documentListener;
        AnnotationListener annotationListenerAnnotationListeners = (i2 & 2) != 0 ? DefaultListeners.INSTANCE.annotationListeners(null, null, null, null, composer, 24576, 15) : annotationListener;
        UiListener uiListenerUiListeners = (i2 & 4) != 0 ? DefaultListeners.INSTANCE.uiListeners(null, null, composer, 384, 3) : uiListener;
        if ((i2 & 8) != 0) {
            uiListener2 = uiListenerUiListeners;
            annotationListener2 = annotationListenerAnnotationListeners;
            formListenerFormListeners = DefaultListeners.INSTANCE.formListeners(null, null, null, null, null, null, null, null, null, null, null, null, composer, 0, 384, 4095);
        } else {
            uiListener2 = uiListenerUiListeners;
            annotationListener2 = annotationListenerAnnotationListeners;
            formListenerFormListeners = formListener;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1499330165, i, -1, "com.pspdfkit.jetpack.compose.interactors.getDefaultDocumentManager (DocumentManager.kt:37)");
        }
        wd wdVar = new wd(documentListenerDocumentListeners, annotationListener2, uiListener2, formListenerFormListeners);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return wdVar;
    }

    public static final InstantDocumentManager getDefaultInstantDocumentManager(DocumentListener documentListener, AnnotationListener annotationListener, UiListener uiListener, FormListener formListener, InstantDocumentListener instantDocumentListener, Composer composer, int i, int i2) {
        DocumentListener documentListenerDocumentListeners = (i2 & 1) != 0 ? DefaultListeners.INSTANCE.documentListeners(null, null, null, null, null, null, null, null, null, null, null, composer, 0, 48, 2047) : documentListener;
        AnnotationListener annotationListenerAnnotationListeners = (i2 & 2) != 0 ? DefaultListeners.INSTANCE.annotationListeners(null, null, null, null, composer, 24576, 15) : annotationListener;
        UiListener uiListenerUiListeners = (i2 & 4) != 0 ? DefaultListeners.INSTANCE.uiListeners(null, null, composer, 384, 3) : uiListener;
        FormListener formListenerFormListeners = (i2 & 8) != 0 ? DefaultListeners.INSTANCE.formListeners(null, null, null, null, null, null, null, null, null, null, null, null, composer, 0, 384, 4095) : formListener;
        InstantDocumentListener instantDocumentListenerInstantListeners = (i2 & 16) != 0 ? DefaultListeners.INSTANCE.instantListeners(null, null, null, null, null, null, null, composer, 12582912, 127) : instantDocumentListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-362814405, i, -1, "com.pspdfkit.jetpack.compose.interactors.getDefaultInstantDocumentManager (DocumentManager.kt:56)");
        }
        tl tlVar = new tl(documentListenerDocumentListeners, annotationListenerAnnotationListeners, uiListenerUiListeners, formListenerFormListeners, instantDocumentListenerInstantListeners);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return tlVar;
    }
}
