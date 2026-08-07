package com.pspdfkit.annotations;

import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import androidx.core.internal.view.SupportMenu;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RedactionAnnotation extends BaseRectsAnnotation {
    public RedactionAnnotation(int i, List<RectF> list) {
        super(i);
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            throw new InvalidNutrientLicenseException("Creating RedactionAnnotations requires Redaction License.");
        }
        setRects(list);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public int getFillColor() {
        return this.propertyManager.a(11, -16777216);
    }

    public int getOutlineColor() {
        return this.propertyManager.a(8001, SupportMenu.CATEGORY_MASK);
    }

    public String getOverlayText() {
        return this.propertyManager.g(8002);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public final AnnotationType getType() {
        return AnnotationType.REDACT;
    }

    public void setOutlineColor(int i) {
        j3 j3Var = this.propertyManager;
        if (i != 0) {
            i = ColorUtils.setAlphaComponent(i, 255);
        }
        j3Var.f.a(8001, Integer.valueOf(i), true);
        j3Var.l();
    }

    public void setOverlayText(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(8002, str, true);
        j3Var.l();
    }

    public void setRepeatOverlayText(boolean z) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(8003, Boolean.valueOf(z), true);
        j3Var.l();
    }

    public boolean shouldRepeatOverlayText() {
        return this.propertyManager.a(8003);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    public RedactionAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            throw new InvalidNutrientLicenseException("Creating RedactionAnnotations requires Redaction License.");
        }
    }
}
