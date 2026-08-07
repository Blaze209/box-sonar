package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class xy extends vy implements uh<FormElement> {
    public FormElement w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy(Context context, PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        super(context, pdfConfiguration, pdfDocument);
        context.getClass();
        pdfConfiguration.getClass();
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.uh
    public final Object a(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.pspdfkit.internal.uh
    public final void d() {
    }

    @Override // com.pspdfkit.internal.uh
    public final void g() {
        this.o = true;
        o();
    }

    @Override // com.pspdfkit.internal.uh
    public FormElement getFormElement() {
        return this.w;
    }

    @Override // com.pspdfkit.internal.uh
    public final void l() {
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public final void n() {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
    }

    public void setFormElement(FormElement formElement) {
        if (Intrinsics.areEqual(formElement, this.w)) {
            return;
        }
        this.w = formElement;
        if (formElement != null) {
            WidgetAnnotation annotation = formElement.getAnnotation();
            annotation.getClass();
            setAnnotation(annotation);
        }
    }

    @Override // com.pspdfkit.internal.vy
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        setBackgroundColor(-1);
    }
}
