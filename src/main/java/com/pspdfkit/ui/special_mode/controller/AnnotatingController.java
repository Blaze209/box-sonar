package com.pspdfkit.ui.special_mode.controller;

import androidx.core.util.Pair;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotatingController extends FragmentSpecialModeController {
    void addOnAnnotatingModeChangeListener(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener);

    void addOnSettingsChangeListener(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener);

    void bindAnnotationInspectorController(AnnotationInspectorController annotationInspectorController);

    void changeAnnotationCreationMode(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    default void clearSelection() {
    }

    default void deleteCurrentlySelectedAnnotations() {
    }

    void displayScalePicker();

    default void enterAudioPlaybackMode() {
    }

    default void enterAudioRecordingMode() {
    }

    AnnotationTool getActiveAnnotationTool();

    AnnotationToolVariant getActiveAnnotationToolVariant();

    float getAlpha();

    AnnotationPreferencesManager getAnnotationPreferences();

    BorderStylePreset getBorderStylePreset();

    int getColor();

    PdfConfiguration getConfiguration();

    default Annotation getCurrentSingleSelectedAnnotation() {
        List<Annotation> currentlySelectedAnnotations = getCurrentlySelectedAnnotations();
        if (currentlySelectedAnnotations.size() == 1) {
            return currentlySelectedAnnotations.get(0);
        }
        return null;
    }

    default List<Annotation> getCurrentlySelectedAnnotations() {
        return Collections.EMPTY_LIST;
    }

    int getFillColor();

    Font getFont();

    Pair<LineEndType, LineEndType> getLineEnds();

    MeasurementValueConfiguration getMeasurementValueConfiguration();

    int getOutlineColor();

    String getOverlayText();

    boolean getRepeatOverlayText();

    float getTextSize();

    float getThickness();

    default boolean hasCurrentlySelectedAnnotations() {
        return !getCurrentlySelectedAnnotations().isEmpty();
    }

    default boolean isCopyEnabled(List<Annotation> list) {
        return false;
    }

    default boolean isCutEnabled() {
        return isCopyEnabled() && isDeleteEnabled();
    }

    default boolean isDeleteEnabled(List<Annotation> list) {
        return false;
    }

    default void recordAnnotationZIndexEdit(Annotation annotation, int i, int i2) {
    }

    void removeOnAnnotatingModeChangeListener(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener);

    void removeOnSettingsChangeListener(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener);

    default void selectAnnotations(List<Annotation> list) {
    }

    void setAlpha(float f);

    void setBorderStylePreset(BorderStylePreset borderStylePreset);

    void setColor(int i);

    void setFillColor(int i);

    void setFont(Font font);

    void setLineEnds(LineEndType lineEndType, LineEndType lineEndType2);

    void setMeasurementValueConfiguration(MeasurementValueConfiguration measurementValueConfiguration);

    void setOutlineColor(int i);

    void setOverlayText(String str);

    void setRepeatOverlayText(boolean z);

    void setTextSize(float f);

    void setThickness(float f);

    boolean shouldDisplayPicker();

    default boolean shouldDisplayPlayAudioButton() {
        return false;
    }

    default boolean shouldDisplayRecordAudioButton() {
        return false;
    }

    void showAnnotationEditor(Annotation annotation);

    default void showEditedAnnotationPositionOnThePage(int i) {
    }

    default void startRecording() {
    }

    default void stopRecording() {
    }

    void toggleAnnotationInspector();

    void unbindAnnotationInspectorController();

    default boolean isCopyEnabled() {
        return isCopyEnabled(getCurrentlySelectedAnnotations());
    }

    default boolean isCutEnabled(List<Annotation> list) {
        return isCopyEnabled(list) && isDeleteEnabled(list);
    }

    default boolean isDeleteEnabled() {
        return isDeleteEnabled(getCurrentlySelectedAnnotations());
    }
}
