package com.pspdfkit.forms;

import android.graphics.Bitmap;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.internal.c1;
import com.pspdfkit.internal.k4;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class PushButtonFormElement extends ButtonFormElement {
    public PushButtonFormElement(PushButtonFormField pushButtonFormField, WidgetAnnotation widgetAnnotation) {
        super(pushButtonFormField, widgetAnnotation);
    }

    public Action getAction() {
        return getAnnotation().getAction();
    }

    public Bitmap getBitmap() {
        k4 annotationResource = getAnnotation().getInternal().getAnnotationResource();
        if (!(annotationResource instanceof c1)) {
            return null;
        }
        c1 c1Var = (c1) annotationResource;
        Bitmap bitmap = c1Var.f;
        if (bitmap != null) {
            return bitmap;
        }
        String str = c1Var.e;
        if (str == null) {
            return null;
        }
        return c1Var.c.getInternal().getNativeImageResource(str);
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.PUSHBUTTON;
    }

    public void setAction(Action action) {
        getAnnotation().setAction(action);
    }

    public void setBitmap(Bitmap bitmap) {
        uw.a(bitmap, "bitmap", null);
        getAnnotation().getInternal().setAnnotationResource(new c1(getAnnotation(), bitmap, true));
    }

    public PushButtonFormElement(PushButtonFormField pushButtonFormField, WidgetAnnotation widgetAnnotation, Bitmap bitmap) {
        super(pushButtonFormField, widgetAnnotation);
        setBitmap(bitmap);
    }

    @Override // com.pspdfkit.forms.FormElement
    public PushButtonFormField getFormField() {
        return (PushButtonFormField) super.getFormField();
    }
}
