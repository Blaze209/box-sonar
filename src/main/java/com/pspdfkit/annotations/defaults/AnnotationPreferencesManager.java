package com.pspdfkit.annotations.defaults;

import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationPreferencesManager {
    float getAlpha(AnnotationTool annotationTool);

    float getAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    String getAnnotationCreator();

    BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool);

    BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    int getColor(AnnotationTool annotationTool);

    int getColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    int getFillColor(AnnotationTool annotationTool);

    int getFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    Font getFont(AnnotationTool annotationTool);

    Font getFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool);

    Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    String getNoteAnnotationIcon(AnnotationTool annotationTool);

    String getNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    int getOutlineColor(AnnotationTool annotationTool);

    int getOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    String getOverlayText(AnnotationTool annotationTool);

    String getOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    boolean getRepeatOverlayText(AnnotationTool annotationTool);

    boolean getRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    float getTextSize(AnnotationTool annotationTool);

    float getTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    float getThickness(AnnotationTool annotationTool);

    float getThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    boolean isAnnotationCreatorSet();

    boolean isMeasurementSnappingEnabled();

    void setAlpha(AnnotationTool annotationTool, float f);

    void setAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f);

    void setBorderStylePreset(AnnotationTool annotationTool, BorderStylePreset borderStylePreset);

    void setBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, BorderStylePreset borderStylePreset);

    void setColor(AnnotationTool annotationTool, int i);

    void setColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i);

    void setFillColor(AnnotationTool annotationTool, int i);

    void setFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i);

    void setFont(AnnotationTool annotationTool, Font font);

    void setFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Font font);

    void setLineEnds(AnnotationTool annotationTool, LineEndType lineEndType, LineEndType lineEndType2);

    void setLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, LineEndType lineEndType, LineEndType lineEndType2);

    void setMeasurementSnappingEnabled(boolean z);

    void setNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str);

    void setNoteAnnotationIcon(AnnotationTool annotationTool, String str);

    void setOutlineColor(AnnotationTool annotationTool, int i);

    void setOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i);

    void setOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str);

    void setOverlayText(AnnotationTool annotationTool, String str);

    void setRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, boolean z);

    void setRepeatOverlayText(AnnotationTool annotationTool, boolean z);

    void setTextSize(AnnotationTool annotationTool, float f);

    void setTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f);

    void setThickness(AnnotationTool annotationTool, float f);

    void setThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f);
}
