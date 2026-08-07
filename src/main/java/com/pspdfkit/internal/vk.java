package com.pspdfkit.internal;

import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class vk implements AnnotationPreferencesManager {
    public final AnnotationPreferencesManager a;
    public final InstantDocumentDescriptor b;

    public vk(AnnotationPreferencesManager annotationPreferencesManager, InstantDocumentDescriptor instantDocumentDescriptor) {
        annotationPreferencesManager.getClass();
        this.a = annotationPreferencesManager;
        this.b = instantDocumentDescriptor;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getAlpha(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getAlpha(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getAnnotationCreator() {
        String creatorName;
        InstantDocumentDescriptor instantDocumentDescriptor = this.b;
        return (instantDocumentDescriptor == null || (creatorName = instantDocumentDescriptor.getCreatorName()) == null) ? this.a.getAnnotationCreator() : creatorName;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool) {
        annotationTool.getClass();
        BorderStylePreset borderStylePreset = this.a.getBorderStylePreset(annotationTool);
        borderStylePreset.getClass();
        return borderStylePreset;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getColor(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getColor(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getFillColor(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getFillColor(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Font getFont(AnnotationTool annotationTool) {
        annotationTool.getClass();
        Font font = this.a.getFont(annotationTool);
        font.getClass();
        return font;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool) {
        annotationTool.getClass();
        Pair<LineEndType, LineEndType> lineEnds = this.a.getLineEnds(annotationTool);
        lineEnds.getClass();
        return lineEnds;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getNoteAnnotationIcon(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getNoteAnnotationIcon(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getOutlineColor(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getOutlineColor(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getOverlayText(AnnotationTool annotationTool) {
        annotationTool.getClass();
        String overlayText = this.a.getOverlayText(annotationTool);
        overlayText.getClass();
        return overlayText;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean getRepeatOverlayText(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getRepeatOverlayText(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getTextSize(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getTextSize(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getThickness(AnnotationTool annotationTool) {
        annotationTool.getClass();
        return this.a.getThickness(annotationTool);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean isAnnotationCreatorSet() {
        return this.a.isAnnotationCreatorSet();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean isMeasurementSnappingEnabled() {
        return this.a.isMeasurementSnappingEnabled();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setAlpha(AnnotationTool annotationTool, float f) {
        annotationTool.getClass();
        this.a.setAlpha(annotationTool, f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setBorderStylePreset(AnnotationTool annotationTool, BorderStylePreset borderStylePreset) {
        annotationTool.getClass();
        borderStylePreset.getClass();
        this.a.setBorderStylePreset(annotationTool, borderStylePreset);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setColor(AnnotationTool annotationTool, int i) {
        annotationTool.getClass();
        this.a.setColor(annotationTool, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFillColor(AnnotationTool annotationTool, int i) {
        annotationTool.getClass();
        this.a.setFillColor(annotationTool, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFont(AnnotationTool annotationTool, Font font) {
        annotationTool.getClass();
        font.getClass();
        this.a.setFont(annotationTool, font);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setLineEnds(AnnotationTool annotationTool, LineEndType lineEndType, LineEndType lineEndType2) {
        annotationTool.getClass();
        lineEndType.getClass();
        lineEndType2.getClass();
        this.a.setLineEnds(annotationTool, lineEndType, lineEndType2);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setMeasurementSnappingEnabled(boolean z) {
        this.a.setMeasurementSnappingEnabled(z);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        str.getClass();
        this.a.setNoteAnnotationIcon(annotationTool, annotationToolVariant, str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOutlineColor(AnnotationTool annotationTool, int i) {
        annotationTool.getClass();
        this.a.setOutlineColor(annotationTool, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        str.getClass();
        this.a.setOverlayText(annotationTool, annotationToolVariant, str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, boolean z) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setRepeatOverlayText(annotationTool, annotationToolVariant, z);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setTextSize(AnnotationTool annotationTool, float f) {
        annotationTool.getClass();
        this.a.setTextSize(annotationTool, f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setThickness(AnnotationTool annotationTool, float f) {
        annotationTool.getClass();
        this.a.setThickness(annotationTool, f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getAlpha(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        BorderStylePreset borderStylePreset = this.a.getBorderStylePreset(annotationTool, annotationToolVariant);
        borderStylePreset.getClass();
        return borderStylePreset;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getColor(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getFillColor(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Font getFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        Font font = this.a.getFont(annotationTool, annotationToolVariant);
        font.getClass();
        return font;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        Pair<LineEndType, LineEndType> lineEnds = this.a.getLineEnds(annotationTool, annotationToolVariant);
        lineEnds.getClass();
        return lineEnds;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getNoteAnnotationIcon(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getOutlineColor(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        String overlayText = this.a.getOverlayText(annotationTool, annotationToolVariant);
        overlayText.getClass();
        return overlayText;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean getRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getRepeatOverlayText(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getTextSize(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        return this.a.getThickness(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setAlpha(annotationTool, annotationToolVariant, f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, BorderStylePreset borderStylePreset) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        borderStylePreset.getClass();
        this.a.setBorderStylePreset(annotationTool, annotationToolVariant, borderStylePreset);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setColor(annotationTool, annotationToolVariant, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setFillColor(annotationTool, annotationToolVariant, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Font font) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        font.getClass();
        this.a.setFont(annotationTool, annotationToolVariant, font);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, LineEndType lineEndType, LineEndType lineEndType2) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        lineEndType.getClass();
        lineEndType2.getClass();
        this.a.setLineEnds(annotationTool, annotationToolVariant, lineEndType, lineEndType2);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setNoteAnnotationIcon(AnnotationTool annotationTool, String str) {
        annotationTool.getClass();
        str.getClass();
        this.a.setNoteAnnotationIcon(annotationTool, str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setOutlineColor(annotationTool, annotationToolVariant, i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOverlayText(AnnotationTool annotationTool, String str) {
        annotationTool.getClass();
        str.getClass();
        this.a.setOverlayText(annotationTool, str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setRepeatOverlayText(AnnotationTool annotationTool, boolean z) {
        annotationTool.getClass();
        this.a.setRepeatOverlayText(annotationTool, z);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setTextSize(annotationTool, annotationToolVariant, f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.a.setThickness(annotationTool, annotationToolVariant, f);
    }
}
