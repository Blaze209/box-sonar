package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Color;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.ui.inspector.views.BorderStylePickerInspectorView;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorView;
import com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView;
import com.pspdfkit.ui.inspector.views.ScaleSelectPickerInspectorView;
import com.pspdfkit.ui.inspector.views.SliderPickerInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m2 {
    public final FragmentSpecialModeController a;

    public m2(AnnotatingController annotatingController) {
        annotatingController.getClass();
        this.a = annotatingController;
    }

    public final ColorPickerInspectorView a(AnnotationColorConfiguration annotationColorConfiguration, int i, boolean z, ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        String strA;
        if (annotationColorConfiguration == null || !a(annotationColorConfiguration.getAvailableColors())) {
            return null;
        }
        List<Integer> availableColors = annotationColorConfiguration.getAvailableColors();
        availableColors.getClass();
        a(i, availableColors);
        if (z) {
            strA = no.a(l2.a(this), R.string.pspdf__edit_menu_text_color, null);
            strA.getClass();
        } else {
            strA = no.a(l2.a(this), R.string.pspdf__edit_menu_color, null);
            strA.getClass();
        }
        String str = strA;
        Context contextA = l2.a(this);
        List<Integer> availableColors2 = annotationColorConfiguration.getAvailableColors();
        boolean zCustomColorPickerEnabled = annotationColorConfiguration.customColorPickerEnabled();
        List<Integer> availableColors3 = annotationColorConfiguration.getAvailableColors();
        availableColors3.getClass();
        ColorPickerInspectorView colorPickerInspectorView = new ColorPickerInspectorView(contextA, str, availableColors2, i, a(zCustomColorPickerEnabled, availableColors3, i), colorPickerListener);
        colorPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_foreground_color_picker);
        return colorPickerInspectorView;
    }

    public abstract FragmentSpecialModeController a();

    public final ColorPickerInspectorView b(AnnotationFillColorConfiguration annotationFillColorConfiguration, int i, ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        if (annotationFillColorConfiguration == null || !a(annotationFillColorConfiguration.getAvailableFillColors())) {
            return null;
        }
        List<Integer> availableFillColors = annotationFillColorConfiguration.getAvailableFillColors();
        availableFillColors.getClass();
        a(i, availableFillColors);
        Context contextA = l2.a(this);
        String strA = no.a(l2.a(this), R.string.pspdf__picker_line_ends_fill_color, null);
        List<Integer> availableFillColors2 = annotationFillColorConfiguration.getAvailableFillColors();
        boolean zCustomColorPickerEnabled = annotationFillColorConfiguration.customColorPickerEnabled();
        List<Integer> availableFillColors3 = annotationFillColorConfiguration.getAvailableFillColors();
        availableFillColors3.getClass();
        ColorPickerInspectorView colorPickerInspectorView = new ColorPickerInspectorView(contextA, strA, availableFillColors2, i, a(zCustomColorPickerEnabled, availableFillColors3, i), colorPickerListener);
        colorPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_line_end_fill_color_picker);
        return colorPickerInspectorView;
    }

    public final ColorPickerInspectorView a(AnnotationFillColorConfiguration annotationFillColorConfiguration, int i, ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        if (annotationFillColorConfiguration == null || !a(annotationFillColorConfiguration.getAvailableFillColors())) {
            return null;
        }
        List<Integer> availableFillColors = annotationFillColorConfiguration.getAvailableFillColors();
        availableFillColors.getClass();
        a(i, availableFillColors);
        Context contextA = l2.a(this);
        String strA = no.a(l2.a(this), R.string.pspdf__edit_menu_fill_color, null);
        List<Integer> availableFillColors2 = annotationFillColorConfiguration.getAvailableFillColors();
        boolean zCustomColorPickerEnabled = annotationFillColorConfiguration.customColorPickerEnabled();
        List<Integer> availableFillColors3 = annotationFillColorConfiguration.getAvailableFillColors();
        availableFillColors3.getClass();
        ColorPickerInspectorView colorPickerInspectorView = new ColorPickerInspectorView(contextA, strA, availableFillColors2, i, a(zCustomColorPickerEnabled, availableFillColors3, i), colorPickerListener);
        colorPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_fill_color_picker);
        return colorPickerInspectorView;
    }

    public final ColorPickerInspectorView a(AnnotationOutlineColorConfiguration annotationOutlineColorConfiguration, int i, ColorPickerInspectorView.ColorPickerListener colorPickerListener) {
        if (annotationOutlineColorConfiguration == null || !a(annotationOutlineColorConfiguration.getAvailableOutlineColors())) {
            return null;
        }
        List<Integer> availableOutlineColors = annotationOutlineColorConfiguration.getAvailableOutlineColors();
        availableOutlineColors.getClass();
        a(i, availableOutlineColors);
        Context contextA = l2.a(this);
        String strA = no.a(l2.a(this), R.string.pspdf__edit_menu_outline_color, null);
        List<Integer> availableOutlineColors2 = annotationOutlineColorConfiguration.getAvailableOutlineColors();
        boolean zCustomColorPickerEnabled = annotationOutlineColorConfiguration.customColorPickerEnabled();
        List<Integer> availableOutlineColors3 = annotationOutlineColorConfiguration.getAvailableOutlineColors();
        availableOutlineColors3.getClass();
        ColorPickerInspectorView colorPickerInspectorView = new ColorPickerInspectorView(contextA, strA, availableOutlineColors2, i, a(zCustomColorPickerEnabled, availableOutlineColors3, i), colorPickerListener);
        colorPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_outline_color_picker);
        return colorPickerInspectorView;
    }

    public static void a(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (Color.alpha(iIntValue) != 255 && iIntValue != 0) {
                throw new IllegalArgumentException("Annotation inspector does not support transparent colors other than android.graphics.Color.TRANSPARENT");
            }
        }
        if (Color.alpha(i) == 255 || i == 0) {
            return;
        }
        throw new IllegalArgumentException("Annotation inspector does not support transparent colors other than android.graphics.Color.TRANSPARENT");
    }

    public final SliderPickerInspectorView a(AnnotationThicknessConfiguration annotationThicknessConfiguration, float f, SliderPickerInspectorView.SliderPickerListener sliderPickerListener) {
        if (annotationThicknessConfiguration == null || annotationThicknessConfiguration.getMinThickness() >= annotationThicknessConfiguration.getMaxThickness()) {
            return null;
        }
        SliderPickerInspectorView sliderPickerInspectorView = new SliderPickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__picker_thickness, null), no.a(l2.a(this), R.string.pspdf__unit_pt, null), (int) annotationThicknessConfiguration.getMinThickness(), (int) annotationThicknessConfiguration.getMaxThickness(), (int) f, sliderPickerListener);
        sliderPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_thickness_picker);
        return sliderPickerInspectorView;
    }

    public final SliderPickerInspectorView a(AnnotationTextSizeConfiguration annotationTextSizeConfiguration, float f, SliderPickerInspectorView.SliderPickerListener sliderPickerListener) {
        if (annotationTextSizeConfiguration == null || annotationTextSizeConfiguration.getMinTextSize() >= annotationTextSizeConfiguration.getMaxTextSize()) {
            return null;
        }
        SliderPickerInspectorView sliderPickerInspectorView = new SliderPickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__size, null), no.a(l2.a(this), R.string.pspdf__unit_pt, null), (int) annotationTextSizeConfiguration.getMinTextSize(), (int) annotationTextSizeConfiguration.getMaxTextSize(), (int) f, sliderPickerListener);
        sliderPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_text_size_picker);
        return sliderPickerInspectorView;
    }

    public final BorderStylePickerInspectorView a(AnnotationBorderStyleConfiguration annotationBorderStyleConfiguration, BorderStylePreset borderStylePreset, BorderStylePickerInspectorView.BorderStylePickerListener borderStylePickerListener) {
        Object next;
        borderStylePreset.getClass();
        if (annotationBorderStyleConfiguration == null || annotationBorderStyleConfiguration.getBorderStylePresets().isEmpty()) {
            return null;
        }
        List<BorderStylePreset> borderStylePresets = annotationBorderStyleConfiguration.getBorderStylePresets();
        borderStylePresets.getClass();
        Iterator<T> it = borderStylePresets.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual((BorderStylePreset) next, borderStylePreset));
        BorderStylePreset borderStylePreset2 = (BorderStylePreset) next;
        if (borderStylePreset2 == null) {
            borderStylePreset2 = borderStylePresets.get(0);
        }
        BorderStylePickerInspectorView borderStylePickerInspectorView = new BorderStylePickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__picker_line_style, null), borderStylePresets, borderStylePreset2, borderStylePickerListener);
        borderStylePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_border_style_picker);
        return borderStylePickerInspectorView;
    }

    public final ColorPickerInspectorView.ColorPickerDetailView a(boolean z, List<Integer> list, int i) {
        if (z) {
            return new CustomColorPickerInspectorDetailView(l2.a(this), list, i);
        }
        return new ColorPickerInspectorDetailView(l2.a(this), list, i, false);
    }

    public final SliderPickerInspectorView a(AnnotationAlphaConfiguration annotationAlphaConfiguration, float f, SliderPickerInspectorView.SliderPickerListener sliderPickerListener) {
        if (annotationAlphaConfiguration == null || annotationAlphaConfiguration.getMinAlpha() > annotationAlphaConfiguration.getMaxAlpha()) {
            return null;
        }
        float f2 = 100;
        SliderPickerInspectorView sliderPickerInspectorView = new SliderPickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__picker_opacity, null), "%1$s %%", (int) (annotationAlphaConfiguration.getMinAlpha() * f2), (int) (annotationAlphaConfiguration.getMaxAlpha() * f2), (int) (f * f2), sliderPickerListener);
        sliderPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_alpha_picker);
        return sliderPickerInspectorView;
    }

    public final PrecisionPickerInspectorView a(MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo, PrecisionPickerInspectorView.PrecisionPickerListener precisionPickerListener) {
        AnnotationType annotationType;
        Annotation annotation;
        measurementPrecision.getClass();
        unitTo.getClass();
        AnnotationTool activeAnnotationTool = a().getFragment().getActiveAnnotationTool();
        if (activeAnnotationTool == null || (type = activeAnnotationTool.toAnnotationType()) == null) {
            List<Annotation> selectedAnnotations = a().getFragment().getSelectedAnnotations();
            selectedAnnotations.getClass();
            if (selectedAnnotations.isEmpty()) {
                selectedAnnotations = null;
            }
            if (selectedAnnotations == null || (annotation = (Annotation) CollectionsKt.first((List) selectedAnnotations)) == null) {
                annotationType = null;
            } else {
                AnnotationType type = annotation.getType();
                annotationType = type;
            }
        } else {
            annotationType = type;
        }
        PrecisionPickerInspectorView precisionPickerInspectorView = new PrecisionPickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__picker_precision, null), measurementPrecision, unitTo, annotationType, precisionPickerListener);
        precisionPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_precision_picker);
        return precisionPickerInspectorView;
    }

    public final ScaleSelectPickerInspectorView a(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        return new ScaleSelectPickerInspectorView(l2.a(this), no.a(l2.a(this), R.string.pspdf__picker_scale, null), measurementValueConfiguration, this, a().getFragment().getMeasurementValueConfigurationEditor(), measurementValueConfigurationPickerListener);
    }

    public static boolean a(List list) {
        return !(list == null || list.isEmpty());
    }
}
