package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.EdgeInsets;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface bm {
    void addOnAnnotationPropertyChangeListener(zs zsVar);

    void addOnAnnotationUpdatedListener(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener);

    void adjustBoundsForRotation(float f);

    void clearTextShouldFit();

    void ensureAnnotationCanBeAttachedToDocument(lm lmVar);

    Action getAction();

    Action getAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent);

    p getAdditionalActions();

    String getAdditionalData(String str);

    k4 getAnnotationResource();

    RectF getContentSize(RectF rectF);

    Annotation getCopy();

    Integer getDetachedAnnotationLookupKey();

    EdgeInsets getEdgeInsets();

    String getInReplyToUuid();

    lm getInternalDocument();

    MeasurementPrecision getMeasurementPrecision();

    xp getMeasurementProperties();

    Scale getMeasurementScale();

    NativeAnnotation getNativeAnnotation();

    Bitmap getNativeImageResource(String str);

    NativeResourceManager getNativeResourceManager();

    int getPageRotation();

    boolean getPrefersPlatformRendering();

    j3 getProperties();

    List<fx> getQuadrilaterals();

    int getRotation();

    j30 getSoundAnnotationState();

    boolean getTextShouldFit();

    String getUuid();

    AnnotationToolVariant getVariant();

    boolean hasBeenSyncedFromNativeAnnotation();

    boolean isInstantCommentThreadRoot();

    void markAsInstantCommentRoot();

    void markPreferredForPlatformRendering();

    boolean needsFlippedContentSize();

    void notifyAnnotationCreated();

    void notifyAnnotationRemoved();

    void notifyAnnotationUpdated();

    void onAttachToDocument(lm lmVar, jr jrVar);

    void onBeforeAttachToDocument(lm lmVar, NativeAnnotation nativeAnnotation);

    void onDetachedFromDocument();

    void prepareForCopy();

    void removeOnAnnotationPropertyChangeListener(zs zsVar);

    void removeOnAnnotationUpdatedListener(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener);

    NativeAnnotation requireNativeAnnotation();

    void setAction(Action action);

    void setAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent, Action action);

    void setAdditionalData(String str, String str2, boolean z);

    void setAnnotationResource(k4 k4Var);

    void setDetachedAnnotationLookupKey(Integer num, NativeAnnotationManager nativeAnnotationManager);

    void setEdgeInsets(EdgeInsets edgeInsets);

    void setIsSignature(boolean z);

    void setMeasurementPrecision(MeasurementPrecision measurementPrecision);

    void setMeasurementScale(Scale scale);

    void setPageIndex(int i);

    void setPointsWithoutCoreSync(List<PointF> list);

    void setQuadrilaterals(List<fx> list);

    void setRotation(int i);

    void setSoundAnnotationState(j30 j30Var);

    void setTextShouldFit(boolean z);

    void setVariant(AnnotationToolVariant annotationToolVariant);

    void syncPropertiesWithNative();

    boolean syncToBackend();

    boolean updateMeasurementContentsString();
}
