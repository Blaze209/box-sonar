package com.pspdfkit.ui.annotations;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J#\u0010\u000b\u001a\u00020\n2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0002\b\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/annotations/OnAnnotationSelectedListener;", "", "onPrepareAnnotationSelection", "", "controller", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationSelectionController;", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "annotationCreated", "onAnnotationSelected", "", "onAnnotationSelectionFinished", "annotations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "annotationsCreated", "onAnnotationDeselected", "reselected", "onAnnotationWritingModeChanged", "active", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OnAnnotationSelectedListener {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAnnotationDeselected(OnAnnotationSelectedListener onAnnotationSelectedListener, Annotation annotation, boolean z) {
            annotation.getClass();
            OnAnnotationSelectedListener.super.onAnnotationDeselected(annotation, z);
        }

        @Deprecated
        public static void onAnnotationSelected(OnAnnotationSelectedListener onAnnotationSelectedListener, Annotation annotation, boolean z) {
            annotation.getClass();
            OnAnnotationSelectedListener.super.onAnnotationSelected(annotation, z);
        }

        @Deprecated
        public static void onAnnotationSelectionFinished(OnAnnotationSelectedListener onAnnotationSelectedListener, List<Annotation> list, boolean z) {
            list.getClass();
            OnAnnotationSelectedListener.super.onAnnotationSelectionFinished(list, z);
        }

        @Deprecated
        public static void onAnnotationWritingModeChanged(OnAnnotationSelectedListener onAnnotationSelectedListener, boolean z) {
            OnAnnotationSelectedListener.super.onAnnotationWritingModeChanged(z);
        }

        @Deprecated
        public static boolean onPrepareAnnotationSelection(OnAnnotationSelectedListener onAnnotationSelectedListener, AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
            annotationSelectionController.getClass();
            annotation.getClass();
            return OnAnnotationSelectedListener.super.onPrepareAnnotationSelection(annotationSelectionController, annotation, z);
        }
    }

    default void onAnnotationDeselected(Annotation annotation, boolean reselected) {
        annotation.getClass();
    }

    default void onAnnotationSelected(Annotation annotation, boolean annotationCreated) {
        annotation.getClass();
    }

    default void onAnnotationSelectionFinished(List<Annotation> annotations, boolean annotationsCreated) {
        annotations.getClass();
    }

    default void onAnnotationWritingModeChanged(boolean active) {
    }

    default boolean onPrepareAnnotationSelection(AnnotationSelectionController controller, Annotation annotation, boolean annotationCreated) {
        controller.getClass();
        annotation.getClass();
        return true;
    }
}
