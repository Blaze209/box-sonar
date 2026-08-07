package com.pspdfkit.jetpack.compose.interactors;

import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÓ\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u000724\b\u0002\u0010\u0013\u001a.\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001a2\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\"\b\u0002\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0007¢\u0006\u0002\u0010 J\u0091\u0001\u0010!\u001a\u00020\"2\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d2\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\"\b\u0002\u0010&\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180'\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u001c\b\u0002\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0007¢\u0006\u0002\u0010)JÈ\u0003\u0010*\u001a\u00020+2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000f0\u00072#\b\u0002\u0010.\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000f0\u00072#\b\u0002\u00102\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000f0\u000728\b\u0002\u00103\u001a2\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0013\u0012\u001104¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u000f0\r2#\b\u0002\u00106\u001a\u001d\u0012\u0013\u0012\u001107¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000f0\u00072#\b\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u001107¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000f0\u00072#\b\u0002\u0010:\u001a\u001d\u0012\u0013\u0012\u001107¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000f0\u00072#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000f0\u000728\b\u0002\u0010<\u001a2\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000f0\r2#\b\u0002\u0010>\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000f0\u00072\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000f0\u00072\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010AJ=\u0010B\u001a\u00020C2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010GJÍ\u0001\u0010H\u001a\u00020I2\u001c\b\u0002\u0010J\u001a\u0016\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u001c\b\u0002\u0010M\u001a\u0016\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u001c\b\u0002\u0010O\u001a\u0016\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u001c\b\u0002\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0016\b\u0002\u0010S\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010T¨\u0006U"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DefaultListeners;", "", "<init>", "()V", "documentListeners", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "onDocumentLoaded", "Lkotlin/Function1;", "Lcom/pspdfkit/document/PdfDocument;", "", "onDocumentLoadFailed", "", "onDocumentSave", "Lkotlin/Function2;", "Lcom/pspdfkit/document/DocumentSaveOptions;", "", "onDocumentSaved", "onDocumentSaveFailed", "onDocumentSaveCancelled", "onPageClick", "Lkotlin/Function5;", "", "Landroid/view/MotionEvent;", "Landroid/graphics/PointF;", "Lcom/pspdfkit/annotations/Annotation;", "onDocumentClick", "Lkotlin/Function0;", "onPageChanged", "onDocumentZoomed", "Lkotlin/Function3;", "", "onPageUpdated", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "annotationListeners", "Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "onPrepareAnnotationSelection", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationSelectionController;", "onAnnotationSelected", "onAnnotationSelectionFinished", "", "onAnnotationDeselected", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "formListeners", "Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "onFormElementClickedListener", "Lcom/pspdfkit/forms/FormElement;", "onFormElementViewUpdatedListener", "Lkotlin/ParameterName;", "name", "formElement", "onFormElementValidationSuccess", "onFormElementValidationFailed", "", "validationError", "onEnterFormElementEditingMode", "Lcom/pspdfkit/ui/special_mode/controller/FormEditingController;", "formEditingController", "onChangeFormElementEditingMode", "onExitFormElementEditingMode", "onFormElementUpdatedListener", "onFormElementDeselectedListener", "reselected", "onFormElementSelectedListener", "onIsFormElementClickableListener", "onPrepareFormElementSelection", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "uiListeners", "Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "onImmersiveModeEnabled", "onDocumentScroll", "Lcom/pspdfkit/listeners/scrolling/ScrollState;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "instantListeners", "Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentListener;", "onAuthenticationFailed", "Lcom/pspdfkit/instant/document/InstantPdfDocument;", "Lcom/pspdfkit/instant/exceptions/InstantException;", "onAuthenticationFinished", "onSyncStarted", "onSyncError", "onSyncFinished", "onDocumentStateChanged", "Lcom/pspdfkit/instant/document/InstantDocumentState;", "onDocumentCorrupted", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentListener;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultListeners {
    public static final int $stable = 0;
    public static final DefaultListeners INSTANCE = new DefaultListeners();

    private DefaultListeners() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean annotationListeners$lambda$0$0(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        annotationSelectionController.getClass();
        annotation.getClass();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit annotationListeners$lambda$1$0(Annotation annotation, boolean z) {
        annotation.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit annotationListeners$lambda$2$0(List list, boolean z) {
        list.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit annotationListeners$lambda$3$0(Annotation annotation, boolean z) {
        annotation.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$0$0(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$1$0(Throwable th) {
        th.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$10$0(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean documentListeners$lambda$2$0(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        pdfDocument.getClass();
        documentSaveOptions.getClass();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$3$0(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$4$0(PdfDocument pdfDocument, Throwable th) {
        pdfDocument.getClass();
        th.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$5$0(PdfDocument pdfDocument) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean documentListeners$lambda$6$0(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        pdfDocument.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean documentListeners$lambda$7$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$8$0(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit documentListeners$lambda$9$0(PdfDocument pdfDocument, int i, float f) {
        pdfDocument.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$0$0(FormElement formElement) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$1$0(FormElement formElement) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$10$0(FormElement formElement) {
        formElement.getClass();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$11$0(FormElement formElement) {
        formElement.getClass();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$2$0(FormElement formElement) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$3$0(FormElement formElement, String str) {
        formElement.getClass();
        str.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$4$0(FormEditingController formEditingController) {
        formEditingController.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$5$0(FormEditingController formEditingController) {
        formEditingController.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$6$0(FormEditingController formEditingController) {
        formEditingController.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$7$0(FormElement formElement) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$8$0(FormElement formElement, boolean z) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean formListeners$lambda$9$0(FormElement formElement) {
        formElement.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uiListeners$lambda$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uiListeners$lambda$1$0(ScrollState scrollState) {
        scrollState.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uiListeners$lambda$2$0$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    public final AnnotationListener annotationListeners(Function3<? super AnnotationSelectionController, ? super Annotation, ? super Boolean, Boolean> function3, Function2<? super Annotation, ? super Boolean, Unit> function2, Function2<? super List<? extends Annotation>, ? super Boolean, Unit> function4, Function2<? super Annotation, ? super Boolean, Unit> function5, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return Boolean.valueOf(DefaultListeners.annotationListeners$lambda$0$0((AnnotationSelectionController) obj, (Annotation) obj2, ((Boolean) obj3).booleanValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function3 = (Function3) objRememberedValue;
        }
        if ((i2 & 2) != 0) {
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.annotationListeners$lambda$1$0((Annotation) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            function2 = (Function2) objRememberedValue2;
        }
        if ((i2 & 4) != 0) {
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.annotationListeners$lambda$2$0((List) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            function4 = (Function2) objRememberedValue3;
        }
        if ((i2 & 8) != 0) {
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.annotationListeners$lambda$3$0((Annotation) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            function5 = (Function2) objRememberedValue4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1203916564, i, -1, "com.pspdfkit.jetpack.compose.interactors.DefaultListeners.annotationListeners (DefaultListeners.kt:85)");
        }
        AnnotationListener annotationListener = new AnnotationListener(function3, function2, function4, function5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return annotationListener;
    }

    public final DocumentListener documentListeners(Function1<? super PdfDocument, Unit> function1, Function1<? super Throwable, Unit> function2, Function2<? super PdfDocument, ? super DocumentSaveOptions, Boolean> function3, Function1<? super PdfDocument, Unit> function4, Function2<? super PdfDocument, ? super Throwable, Unit> function5, Function1<? super PdfDocument, Unit> function6, Function5<? super PdfDocument, ? super Integer, ? super MotionEvent, ? super PointF, ? super Annotation, Boolean> function7, Function0<Boolean> function0, Function2<? super PdfDocument, ? super Integer, Unit> function8, Function3<? super PdfDocument, ? super Integer, ? super Float, Unit> function9, Function2<? super PdfDocument, ? super Integer, Unit> function10, Composer composer, int i, int i2, int i3) {
        Function1<? super PdfDocument, Unit> function11;
        Function1<? super Throwable, Unit> function12;
        Function2<? super PdfDocument, ? super DocumentSaveOptions, Boolean> function13;
        Function1<? super PdfDocument, Unit> function14;
        Function2<? super PdfDocument, ? super Throwable, Unit> function15;
        Function1<? super PdfDocument, Unit> function16;
        Function5<? super PdfDocument, ? super Integer, ? super MotionEvent, ? super PointF, ? super Annotation, Boolean> function17;
        Function0<Boolean> function18;
        Function2<? super PdfDocument, ? super Integer, Unit> function19;
        Function3<? super PdfDocument, ? super Integer, ? super Float, Unit> function20;
        Function2<? super PdfDocument, ? super Integer, Unit> function21;
        if ((i3 & 1) != 0) {
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.documentListeners$lambda$0$0((PdfDocument) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function11 = (Function1) objRememberedValue;
        } else {
            function11 = function1;
        }
        if ((i3 & 2) != 0) {
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.documentListeners$lambda$1$0((Throwable) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            function12 = (Function1) objRememberedValue2;
        } else {
            function12 = function2;
        }
        if ((i3 & 4) != 0) {
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(DefaultListeners.documentListeners$lambda$2$0((PdfDocument) obj, (DocumentSaveOptions) obj2));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            function13 = (Function2) objRememberedValue3;
        } else {
            function13 = function3;
        }
        if ((i3 & 8) != 0) {
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.documentListeners$lambda$3$0((PdfDocument) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            function14 = (Function1) objRememberedValue4;
        } else {
            function14 = function4;
        }
        if ((i3 & 16) != 0) {
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.documentListeners$lambda$4$0((PdfDocument) obj, (Throwable) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            function15 = (Function2) objRememberedValue5;
        } else {
            function15 = function5;
        }
        if ((i3 & 32) != 0) {
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.documentListeners$lambda$5$0((PdfDocument) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            function16 = (Function1) objRememberedValue6;
        } else {
            function16 = function6;
        }
        if ((i3 & 64) != 0) {
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function5() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function5
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                        return Boolean.valueOf(DefaultListeners.documentListeners$lambda$6$0((PdfDocument) obj, ((Integer) obj2).intValue(), (MotionEvent) obj3, (PointF) obj4, (Annotation) obj5));
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            function17 = (Function5) objRememberedValue7;
        } else {
            function17 = function7;
        }
        if ((i3 & 128) != 0) {
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultListeners.documentListeners$lambda$7$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            function18 = (Function0) objRememberedValue8;
        } else {
            function18 = function0;
        }
        if ((i3 & 256) != 0) {
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.documentListeners$lambda$8$0((PdfDocument) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            function19 = (Function2) objRememberedValue9;
        } else {
            function19 = function8;
        }
        if ((i3 & 512) != 0) {
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function3() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DefaultListeners.documentListeners$lambda$9$0((PdfDocument) obj, ((Integer) obj2).intValue(), ((Float) obj3).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            function20 = (Function3) objRememberedValue10;
        } else {
            function20 = function9;
        }
        if ((i3 & 1024) != 0) {
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultListeners.documentListeners$lambda$10$0((PdfDocument) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            function21 = (Function2) objRememberedValue11;
        } else {
            function21 = function10;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1871332965, i, i2, "com.pspdfkit.jetpack.compose.interactors.DefaultListeners.documentListeners (DefaultListeners.kt:56)");
        }
        DocumentListener documentListener = new DocumentListener(function11, function12, function13, function14, function15, function16, function17, function18, function19, function20, function21);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return documentListener;
    }

    public final FormListener formListeners(Function1<? super FormElement, Boolean> function1, Function1<? super FormElement, Boolean> function2, Function1<? super FormElement, Boolean> function3, Function2<? super FormElement, ? super String, Boolean> function4, Function1<? super FormEditingController, Boolean> function5, Function1<? super FormEditingController, Boolean> function6, Function1<? super FormEditingController, Boolean> function7, Function1<? super FormElement, Boolean> function8, Function2<? super FormElement, ? super Boolean, Boolean> function9, Function1<? super FormElement, Boolean> function10, Function1<? super FormElement, Boolean> function11, Function1<? super FormElement, Boolean> function12, Composer composer, int i, int i2, int i3) {
        Function1<? super FormElement, Boolean> function13;
        Function1<? super FormElement, Boolean> function14;
        Function1<? super FormElement, Boolean> function15;
        Function2<? super FormElement, ? super String, Boolean> function16;
        Function1<? super FormEditingController, Boolean> function17;
        Function1<? super FormEditingController, Boolean> function18;
        Function1<? super FormEditingController, Boolean> function19;
        Function1<? super FormElement, Boolean> function20;
        Function2<? super FormElement, ? super Boolean, Boolean> function21;
        Function1<? super FormElement, Boolean> function22;
        Function1<? super FormElement, Boolean> function23;
        Function1<? super FormElement, Boolean> function24;
        if ((i3 & 1) != 0) {
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$0$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function13 = (Function1) objRememberedValue;
        } else {
            function13 = function1;
        }
        if ((i3 & 2) != 0) {
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$1$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            function14 = (Function1) objRememberedValue2;
        } else {
            function14 = function2;
        }
        if ((i3 & 4) != 0) {
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$2$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            function15 = (Function1) objRememberedValue3;
        } else {
            function15 = function3;
        }
        if ((i3 & 8) != 0) {
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$3$0((FormElement) obj, (String) obj2));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            function16 = (Function2) objRememberedValue4;
        } else {
            function16 = function4;
        }
        if ((i3 & 16) != 0) {
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$4$0((FormEditingController) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            function17 = (Function1) objRememberedValue5;
        } else {
            function17 = function5;
        }
        if ((i3 & 32) != 0) {
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$5$0((FormEditingController) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            function18 = (Function1) objRememberedValue6;
        } else {
            function18 = function6;
        }
        if ((i3 & 64) != 0) {
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$6$0((FormEditingController) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            function19 = (Function1) objRememberedValue7;
        } else {
            function19 = function7;
        }
        if ((i3 & 128) != 0) {
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$7$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            function20 = (Function1) objRememberedValue8;
        } else {
            function20 = function8;
        }
        if ((i3 & 256) != 0) {
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function2() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$8$0((FormElement) obj, ((Boolean) obj2).booleanValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            function21 = (Function2) objRememberedValue9;
        } else {
            function21 = function9;
        }
        if ((i3 & 512) != 0) {
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$9$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            function22 = (Function1) objRememberedValue10;
        } else {
            function22 = function10;
        }
        if ((i3 & 1024) != 0) {
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$10$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            function23 = (Function1) objRememberedValue11;
        } else {
            function23 = function11;
        }
        if ((i3 & 2048) != 0) {
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DefaultListeners.formListeners$lambda$11$0((FormElement) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            function24 = (Function1) objRememberedValue12;
        } else {
            function24 = function12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(3176591, i, i2, "com.pspdfkit.jetpack.compose.interactors.DefaultListeners.formListeners (DefaultListeners.kt:123)");
        }
        FormListener formListener = new FormListener(function13, function14, function15, function16, function17, function18, function19, function20, function21, function22, function23, function24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return formListener;
    }

    public final InstantDocumentListener instantListeners(Function2<? super InstantPdfDocument, ? super InstantException, Unit> function2, Function2<? super InstantPdfDocument, ? super String, Unit> function3, Function1<? super InstantPdfDocument, Unit> function1, Function2<? super InstantPdfDocument, ? super InstantException, Unit> function4, Function1<? super InstantPdfDocument, Unit> function5, Function2<? super InstantPdfDocument, ? super com.pspdfkit.instant.document.InstantDocumentState, Unit> function6, Function1<? super InstantPdfDocument, Unit> function7, Composer composer, int i, int i2) {
        Function2<? super InstantPdfDocument, ? super InstantException, Unit> function8 = (i2 & 1) != 0 ? null : function2;
        Function2<? super InstantPdfDocument, ? super String, Unit> function9 = (i2 & 2) != 0 ? null : function3;
        Function1<? super InstantPdfDocument, Unit> function10 = (i2 & 4) != 0 ? null : function1;
        Function2<? super InstantPdfDocument, ? super InstantException, Unit> function11 = (i2 & 8) != 0 ? null : function4;
        Function1<? super InstantPdfDocument, Unit> function12 = (i2 & 16) != 0 ? null : function5;
        Function2<? super InstantPdfDocument, ? super com.pspdfkit.instant.document.InstantDocumentState, Unit> function13 = (i2 & 32) != 0 ? null : function6;
        Function1<? super InstantPdfDocument, Unit> function14 = (i2 & 64) == 0 ? function7 : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1762411509, i, -1, "com.pspdfkit.jetpack.compose.interactors.DefaultListeners.instantListeners (DefaultListeners.kt:175)");
        }
        InstantDocumentListener instantDocumentListener = new InstantDocumentListener(function8, function9, function10, function11, function12, function13, function14, null, 128, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return instantDocumentListener;
    }

    public final UiListener uiListeners(final Function1<? super Boolean, Unit> function1, Function1<? super ScrollState, Unit> function2, Composer composer, int i, int i2) {
        Function1 function3;
        if ((i2 & 1) != 0) {
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.uiListeners$lambda$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
        }
        if ((i2 & 2) != 0) {
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.uiListeners$lambda$1$0((ScrollState) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            function2 = (Function1) objRememberedValue2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-734437397, i, -1, "com.pspdfkit.jetpack.compose.interactors.DefaultListeners.uiListeners (DefaultListeners.kt:146)");
        }
        if (function1 == null) {
            composer.startReplaceGroup(-1060673484);
            composer.endReplaceGroup();
            function3 = null;
        } else {
            composer.startReplaceGroup(-1060673483);
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DefaultListeners$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultListeners.uiListeners$lambda$2$0$0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            function3 = (Function1) objRememberedValue3;
            composer.endReplaceGroup();
        }
        UiListener uiListener = new UiListener(function3, function2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return uiListener;
    }
}
