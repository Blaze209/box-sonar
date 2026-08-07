package com.pspdfkit.annotations;

import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.internal.c1;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.p;
import com.pspdfkit.internal.uw;
import io.reactivex.rxjava3.core.Maybe;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WidgetAnnotation extends LinkAnnotation {
    public static final float FONT_SIZE_AUTO = 0.0f;

    public WidgetAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z);
        if (str != null) {
            j3 j3Var2 = this.propertyManager;
            c1 c1Var = new c1(this);
            c1Var.e = str;
            j3Var2.a(c1Var);
        }
    }

    public Action getAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent) {
        uw.a(annotationTriggerEvent, "triggerEvent", null);
        return getInternal().getAdditionalAction(annotationTriggerEvent);
    }

    public Map<AnnotationTriggerEvent, Action> getAdditionalActions() {
        p additionalActions = getInternal().getAdditionalActions();
        if (additionalActions == null) {
            return null;
        }
        Map<AnnotationTriggerEvent, Action> mapUnmodifiableMap = Collections.unmodifiableMap(additionalActions.a);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public int getBorderColor() {
        return this.propertyManager.a(13, 0);
    }

    public float getFontSize() {
        return this.propertyManager.a(1002, 0.0f);
    }

    public FormElement getFormElement() {
        if (getInternalDocument() == null) {
            return null;
        }
        return getInternalDocument().g.getFormElementForAnnotation(this);
    }

    public Maybe<FormElement> getFormElementAsync() {
        return getInternalDocument() != null ? getInternalDocument().g.getFormElementForAnnotationAsync(this) : Maybe.empty();
    }

    @Override // com.pspdfkit.annotations.LinkAnnotation, com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.WIDGET;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public VerticalTextAlignment getVerticalTextAlignment() {
        return VerticalTextAlignment.values()[this.propertyManager.b(1006)];
    }

    public void setAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent, Action action) {
        uw.a(annotationTriggerEvent, "triggerEvent", null);
        uw.a(action, Analytics.Data.ACTION, null);
        getInternal().setAdditionalAction(annotationTriggerEvent, action);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setBorderColor(int i) {
        j3 j3Var = this.propertyManager;
        if (i != 0) {
            i = ColorUtils.setAlphaComponent(i, 255);
        }
        j3Var.f.a(13, Integer.valueOf(i), true);
        j3Var.l();
    }

    public void setFontSize(float f) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1002, Float.valueOf(f), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
        uw.a(verticalTextAlignment, "verticalAlignment", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1006, Byte.valueOf((byte) verticalTextAlignment.ordinal()), true);
        j3Var.l();
    }

    public WidgetAnnotation(int i, RectF rectF) {
        super(i);
        uw.a(rectF, "boundingBox", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
    }
}
