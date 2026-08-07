package com.pspdfkit.internal;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class og extends FrameLayout implements uh<FormElement> {
    public final xy a;
    public final rj b;
    public FormElement c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og(Context context, PdfConfiguration pdfConfiguration, PdfDocument pdfDocument, int i, mh mhVar) {
        super(context);
        context.getClass();
        pdfConfiguration.getClass();
        xy xyVar = new xy(context, pdfConfiguration, pdfDocument);
        this.a = xyVar;
        rj rjVar = new rj(context, i, mhVar);
        this.b = rjVar;
        addView(xyVar);
        addView(rjVar);
    }

    @Override // com.pspdfkit.internal.uh
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.uh
    public final Object a(Continuation<? super Boolean> continuation) {
        setHighlightEnabled(false);
        return Boxing.boxBoolean(true);
    }

    @Override // com.pspdfkit.internal.uh
    public final void d() {
        this.a.getClass();
        this.b.d();
        setHighlightEnabled(false);
    }

    @Override // com.pspdfkit.internal.uh
    public final void g() {
        xy xyVar = this.a;
        xyVar.o = true;
        xyVar.o();
        this.b.getClass();
    }

    @Override // com.pspdfkit.internal.uh
    public FormElement getFormElement() {
        FormElement formElement = this.c;
        if (formElement == null) {
            return null;
        }
        if (formElement != null) {
            return formElement;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boundFormElement");
        return null;
    }

    @Override // com.pspdfkit.internal.uh
    public final void l() {
        this.a.getClass();
        this.b.l();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.getClass();
        formEditingController.getClass();
        rj rjVar = this.b;
        rjVar.getClass();
        xh xhVar = rjVar.c;
        xhVar.getClass();
        xhVar.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.getClass();
        formEditingController.getClass();
        rj rjVar = this.b;
        rjVar.getClass();
        xh xhVar = rjVar.c;
        xhVar.getClass();
        xhVar.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.getClass();
        formEditingController.getClass();
        rj rjVar = this.b;
        rjVar.getClass();
        xh xhVar = rjVar.c;
        xhVar.getClass();
        xhVar.b = null;
    }

    public void setFormElement(FormElement formElement) {
        if (formElement == null) {
            throw new IllegalArgumentException("FormElement cannot be null");
        }
        FormElement formElement2 = this.c;
        if (formElement2 != null) {
            if (formElement2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boundFormElement");
                formElement2 = null;
            }
            if (Intrinsics.areEqual(formElement, formElement2)) {
                return;
            }
        }
        this.c = formElement;
        this.a.setFormElement(formElement);
        this.b.setFormElement(formElement);
        setLayoutParams(new OverlayLayoutParams(formElement.getAnnotation().getBoundingBox(), OverlayLayoutParams.SizingMode.LAYOUT));
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setHighlightEnabled(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }
}
