package com.pspdfkit.annotations;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.media3.common.PlaybackException;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.bm;
import com.pspdfkit.internal.fx;
import com.pspdfkit.internal.i10;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.j30;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeImageResourceInformation;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.jr;
import com.pspdfkit.internal.k4;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.p;
import com.pspdfkit.internal.p10;
import com.pspdfkit.internal.q70;
import com.pspdfkit.internal.qp;
import com.pspdfkit.internal.tg;
import com.pspdfkit.internal.xp;
import com.pspdfkit.internal.zs;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000é\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0017H\u0016¢\u0006\u0004\b0\u0010\u0019J\u000f\u00101\u001a\u00020&H\u0016¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0017H\u0016¢\u0006\u0004\b7\u0010\u0019J\u001b\u0010:\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020$H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0017H\u0016¢\u0006\u0004\bL\u0010MJ)\u0010Q\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u0017H\u0016¢\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u0005H\u0016¢\u0006\u0004\bS\u0010TJ\u001d\u0010X\u001a\u00020\u00022\f\u0010W\u001a\b\u0012\u0004\u0012\u00020V0UH\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0002H\u0016¢\u0006\u0004\bZ\u0010\u0004J#\u0010^\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u001a2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0017H\u0016¢\u0006\u0004\b`\u0010\u0019J\u000f\u0010a\u001a\u00020\u0002H\u0016¢\u0006\u0004\ba\u0010\u0004J\u0017\u0010d\u001a\u00020\u00022\u0006\u0010c\u001a\u00020bH\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u00022\u0006\u0010=\u001a\u00020fH\u0016¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\u0017H\u0016¢\u0006\u0004\bi\u0010\u0019J\u0019\u0010l\u001a\u0004\u0018\u00010k2\u0006\u0010j\u001a\u00020\u0005H\u0016¢\u0006\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u0019R\u0016\u0010x\u001a\u0004\u0018\u00010u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0016\u0010{\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R/\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010O\u001a\u0005\u0018\u00010\u0080\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u0089\u0001\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0005\b\u0088\u0001\u0010\u001dR\u0016\u0010!\u001a\u00020 8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010'\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u00102R\u0018\u0010\u0090\u0001\u001a\u00030\u008d\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0015\u00103\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0007R+\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010O\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010\u0007\"\u0005\b\u0093\u0001\u00105R\u0017\u0010\u0096\u0001\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0087\u0001R,\u0010F\u001a\u0004\u0018\u00010E2\b\u0010O\u001a\u0004\u0018\u00010E8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R6\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030\u009f\u00010U2\r\u0010O\u001a\t\u0012\u0005\u0012\u00030\u009f\u00010U8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010YR-\u0010¨\u0001\u001a\u0004\u0018\u00010p2\b\u0010O\u001a\u0004\u0018\u00010p8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R+\u0010®\u0001\u001a\u00030©\u00012\u0007\u0010O\u001a\u00030©\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R'\u0010±\u0001\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¯\u0001\u0010\u0019\"\u0005\b°\u0001\u0010MR\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u0019\u0010¶\u0001\u001a\u0004\u0018\u00010b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010¹\u0001\u001a\u0004\u0018\u00010f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010½\u0001\u001a\u0005\u0018\u00010º\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001¨\u0006¾\u0001"}, d2 = {"com/pspdfkit/annotations/Annotation$internalAPI$1", "Lcom/pspdfkit/internal/bm;", "", "loadObjectNumberFromNativeAnnotation", "()V", "", "generateNewUuid", "()Ljava/lang/String;", "updateBoundingBox", "Lcom/pspdfkit/internal/zs;", "propertyChangeListener", "addOnAnnotationPropertyChangeListener", "(Lcom/pspdfkit/internal/zs;)V", "removeOnAnnotationPropertyChangeListener", "Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "onAnnotationUpdatedListener", "addOnAnnotationUpdatedListener", "(Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;)V", "removeOnAnnotationUpdatedListener", "notifyAnnotationCreated", "notifyAnnotationUpdated", "notifyAnnotationRemoved", "markPreferredForPlatformRendering", "", "hasBeenSyncedFromNativeAnnotation", "()Z", "", "pageIndex", "setPageIndex", "(I)V", "objectNumber", "setObjectNumber", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;", Constants.SENSITIVITY_VARIANT, "setVariant", "(Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;)V", "Lcom/pspdfkit/internal/lm;", "internalPdfDocument", "Lcom/pspdfkit/internal/jni/NativeAnnotation;", "nativeAnnotation", "onBeforeAttachToDocument", "(Lcom/pspdfkit/internal/lm;Lcom/pspdfkit/internal/jni/NativeAnnotation;)V", "Lcom/pspdfkit/internal/jr;", "nativeAnnotationHolder", "onAttachToDocument", "(Lcom/pspdfkit/internal/lm;Lcom/pspdfkit/internal/jr;)V", "onDetachedFromDocument", "syncPropertiesWithNative", "syncToBackend", "requireNativeAnnotation", "()Lcom/pspdfkit/internal/jni/NativeAnnotation;", "uuid", "setUuid", "(Ljava/lang/String;)V", "prepareForCopy", "needsFlippedContentSize", "Landroid/graphics/RectF;", "reuse", "getContentSize", "(Landroid/graphics/RectF;)Landroid/graphics/RectF;", "", "scale", "adjustBoundsForRotation", "(F)V", "document", "ensureAnnotationCanBeAttachedToDocument", "(Lcom/pspdfkit/internal/lm;)V", "Lcom/pspdfkit/annotations/actions/AnnotationTriggerEvent;", "triggerEvent", "Lcom/pspdfkit/annotations/actions/Action;", Analytics.Data.ACTION, "setAdditionalAction", "(Lcom/pspdfkit/annotations/actions/AnnotationTriggerEvent;Lcom/pspdfkit/annotations/actions/Action;)V", "getAdditionalAction", "(Lcom/pspdfkit/annotations/actions/AnnotationTriggerEvent;)Lcom/pspdfkit/annotations/actions/Action;", "isSignature", "setIsSignature", "(Z)V", "key", "value", "includeInJson", "setAdditionalData", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getAdditionalData", "(Ljava/lang/String;)Ljava/lang/String;", "", "Landroid/graphics/PointF;", "points", "setPointsWithoutCoreSync", "(Ljava/util/List;)V", "clearTextShouldFit", "detachedAnnotationLookupKey", "Lcom/pspdfkit/internal/jni/NativeAnnotationManager;", "nativeAnnotationManager", "setDetachedAnnotationLookupKey", "(Ljava/lang/Integer;Lcom/pspdfkit/internal/jni/NativeAnnotationManager;)V", "isInstantCommentThreadRoot", "markAsInstantCommentRoot", "Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "precision", "setMeasurementPrecision", "(Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;)V", "Lcom/pspdfkit/annotations/measurements/Scale;", "setMeasurementScale", "(Lcom/pspdfkit/annotations/measurements/Scale;)V", "updateMeasurementContentsString", "imageResourceId", "Landroid/graphics/Bitmap;", "getNativeImageResource", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "ADDITIONAL_DATA_KEY_TEXT_SHOULD_FIT", "Ljava/lang/String;", "Lcom/pspdfkit/internal/j30;", "_soundAnnotationState", "Lcom/pspdfkit/internal/j30;", "getPrefersPlatformRendering", "prefersPlatformRendering", "Lcom/pspdfkit/annotations/Annotation;", "getCopy", "()Lcom/pspdfkit/annotations/Annotation;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "getInternalDocument", "()Lcom/pspdfkit/internal/lm;", "internalDocument", "Lcom/pspdfkit/internal/j3;", "getProperties", "()Lcom/pspdfkit/internal/j3;", "properties", "Lcom/pspdfkit/internal/k4;", "getAnnotationResource", "()Lcom/pspdfkit/internal/k4;", "setAnnotationResource", "(Lcom/pspdfkit/internal/k4;)V", "annotationResource", "getRotation", "()I", "setRotation", "rotation", "getVariant", "()Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;", "getNativeAnnotation", "Lcom/pspdfkit/internal/jni/NativeResourceManager;", "getNativeResourceManager", "()Lcom/pspdfkit/internal/jni/NativeResourceManager;", "nativeResourceManager", "getUuid", "getInReplyToUuid", "setInReplyToUuid", "inReplyToUuid", "getPageRotation", "pageRotation", "getAction", "()Lcom/pspdfkit/annotations/actions/Action;", "setAction", "(Lcom/pspdfkit/annotations/actions/Action;)V", "Lcom/pspdfkit/internal/p;", "getAdditionalActions", "()Lcom/pspdfkit/internal/p;", "additionalActions", "Lcom/pspdfkit/internal/fx;", "getQuadrilaterals", "()Ljava/util/List;", "setQuadrilaterals", "quadrilaterals", "getSoundAnnotationState", "()Lcom/pspdfkit/internal/j30;", "setSoundAnnotationState", "(Lcom/pspdfkit/internal/j30;)V", "soundAnnotationState", "Lcom/pspdfkit/utils/EdgeInsets;", "getEdgeInsets", "()Lcom/pspdfkit/utils/EdgeInsets;", "setEdgeInsets", "(Lcom/pspdfkit/utils/EdgeInsets;)V", "edgeInsets", "getTextShouldFit", "setTextShouldFit", "textShouldFit", "getDetachedAnnotationLookupKey", "()Ljava/lang/Integer;", "getMeasurementPrecision", "()Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "measurementPrecision", "getMeasurementScale", "()Lcom/pspdfkit/annotations/measurements/Scale;", "measurementScale", "Lcom/pspdfkit/internal/xp;", "getMeasurementProperties", "()Lcom/pspdfkit/internal/xp;", "measurementProperties", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Annotation$internalAPI$1 implements bm {
    private final String ADDITIONAL_DATA_KEY_TEXT_SHOULD_FIT = "web/freetext/isFitting";
    private j30 _soundAnnotationState;
    final /* synthetic */ Annotation this$0;

    public Annotation$internalAPI$1(Annotation annotation) {
        this.this$0 = annotation;
    }

    private final String generateNewUuid() {
        q70.a();
        String string = UUID.randomUUID().toString();
        string.getClass();
        return string;
    }

    private final void loadObjectNumberFromNativeAnnotation() {
        Long annotationId = requireNativeAnnotation().getAnnotationId();
        if (annotationId == null) {
            throw new IllegalStateException("The bound native annotation was not attached to a document.");
        }
        int iLongValue = (int) annotationId.longValue();
        if (this.this$0.getObjectNumber() != iLongValue) {
            setObjectNumber(iLongValue);
        }
    }

    private final void updateBoundingBox() {
        Annotation annotation = this.this$0;
        annotation.getClass();
        float fMin = Float.MAX_VALUE;
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (PointF pointF : ((BaseLineAnnotation) annotation).getPointsList()) {
            fMin = Math.min(pointF.x, fMin);
            fMax = Math.max(pointF.x, fMax);
            fMin2 = Math.min(pointF.y, fMin2);
            fMax2 = Math.max(pointF.y, fMax2);
        }
        RectF rectF = new RectF(fMin, fMin2, fMax, fMax2);
        rectF.sort();
        float f = -(i10.a(this.this$0) / 2);
        rectF.inset(f, f);
        float f2 = rectF.left;
        float f3 = rectF.right;
        if (f2 > f3) {
            rectF.left = f3;
            rectF.right = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 > f5) {
            rectF.bottom = f5;
            rectF.top = f4;
        }
        this.this$0.setBoundingBox(rectF);
    }

    @Override // com.pspdfkit.internal.bm
    public void addOnAnnotationPropertyChangeListener(zs propertyChangeListener) {
        propertyChangeListener.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.getClass();
        propertyChangeListener.getClass();
        j3Var.g.a(propertyChangeListener);
    }

    @Override // com.pspdfkit.internal.bm
    public void addOnAnnotationUpdatedListener(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener) {
        onAnnotationUpdatedListener.getClass();
        this.this$0.onAnnotationUpdatedListeners.a(onAnnotationUpdatedListener);
    }

    @Override // com.pspdfkit.internal.bm
    public void adjustBoundsForRotation(float scale) {
        RectF contentSize = getContentSize(null);
        if (contentSize == null) {
            return;
        }
        if (needsFlippedContentSize()) {
            contentSize = new RectF(0.0f, 0.0f, -contentSize.height(), contentSize.width());
        }
        contentSize.sort();
        RectF boundingBox = this.this$0.getBoundingBox();
        boundingBox.sort();
        double radians = Math.toRadians(getRotation());
        float f = 2;
        float fAbs = (((float) (Math.abs(Math.sin(radians) * ((double) contentSize.height())) + Math.abs(Math.cos(radians) * ((double) contentSize.width())))) * scale) / f;
        float fAbs2 = (((float) (Math.abs(Math.cos(radians) * ((double) contentSize.height())) + Math.abs(Math.sin(radians) * ((double) contentSize.width())))) * scale) / f;
        this.this$0.setBoundingBox(new RectF(boundingBox.centerX() - fAbs, boundingBox.centerY() + fAbs2, boundingBox.centerX() + fAbs, boundingBox.centerY() - fAbs2));
    }

    @Override // com.pspdfkit.internal.bm
    public void clearTextShouldFit() {
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation == null) {
            throw new IllegalStateException("Can't clear shouldFit flag on an annotation that is not attached to a document.");
        }
        nativeAnnotation.setAdditionalDataBoolean(this.ADDITIONAL_DATA_KEY_TEXT_SHOULD_FIT, null, false);
    }

    @Override // com.pspdfkit.internal.bm
    public void ensureAnnotationCanBeAttachedToDocument(lm document) {
        document.getClass();
        if (this.this$0.isAttached()) {
            throw new IllegalStateException("Can't add an annotation that is already attached to a document.");
        }
        this.this$0.checkIfInReplyToAnnotationIsAttachedToDocument(document);
    }

    @Override // com.pspdfkit.internal.bm
    public Action getAction() {
        return this.this$0.propertyManager.b();
    }

    @Override // com.pspdfkit.internal.bm
    public Action getAdditionalAction(AnnotationTriggerEvent triggerEvent) {
        triggerEvent.getClass();
        p additionalActions = getAdditionalActions();
        if (additionalActions == null) {
            return null;
        }
        triggerEvent.getClass();
        return additionalActions.a.get(triggerEvent);
    }

    @Override // com.pspdfkit.internal.bm
    public p getAdditionalActions() {
        return this.this$0.propertyManager.c();
    }

    @Override // com.pspdfkit.internal.bm
    public String getAdditionalData(String key) {
        key.getClass();
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation != null) {
            return nativeAnnotation.getAdditionalDataString(key);
        }
        throw new IllegalStateException("Can't get additional data on an annotation that is not attached to a document.");
    }

    @Override // com.pspdfkit.internal.bm
    public k4 getAnnotationResource() {
        k4 k4Var;
        j3 j3Var = this.this$0.propertyManager;
        synchronized (j3Var) {
            k4Var = j3Var.j;
        }
        return k4Var;
    }

    @Override // com.pspdfkit.internal.bm
    public RectF getContentSize(RectF reuse) {
        RectF rectFF = this.this$0.propertyManager.f(22);
        if (rectFF == null) {
            return null;
        }
        if (reuse == null) {
            reuse = new RectF();
        }
        reuse.set(rectFF);
        return reuse;
    }

    @Override // com.pspdfkit.internal.bm
    public Annotation getCopy() {
        return this.this$0.getCopy();
    }

    @Override // com.pspdfkit.internal.bm
    public Integer getDetachedAnnotationLookupKey() {
        return this.this$0.detachedAnnotationLookupKey;
    }

    @Override // com.pspdfkit.internal.bm
    public EdgeInsets getEdgeInsets() {
        return this.this$0.propertyManager.a(new EdgeInsets());
    }

    @Override // com.pspdfkit.internal.bm
    public String getInReplyToUuid() {
        return this.this$0.propertyManager.g(21);
    }

    @Override // com.pspdfkit.internal.bm
    public lm getInternalDocument() {
        return this.this$0.getInternalDocument();
    }

    @Override // com.pspdfkit.internal.bm
    public MeasurementPrecision getMeasurementPrecision() {
        if (this.this$0.isMeasurement()) {
            return this.this$0.propertyManager.f();
        }
        return null;
    }

    @Override // com.pspdfkit.internal.bm
    public xp getMeasurementProperties() {
        MeasurementPrecision measurementPrecision;
        Scale measurementScale;
        MeasurementMode measurementMode;
        if (!this.this$0.isMeasurement() || (measurementPrecision = getMeasurementPrecision()) == null || (measurementScale = getMeasurementScale()) == null) {
            return null;
        }
        AnnotationType type = this.this$0.getType();
        type.getClass();
        int i = qp.a.b[type.ordinal()];
        if (i == 1) {
            measurementMode = MeasurementMode.DISTANCE;
        } else if (i != 2) {
            measurementMode = (i == 3 || i == 4 || i == 5) ? MeasurementMode.AREA : null;
        } else {
            measurementMode = MeasurementMode.PERIMETER;
        }
        if (measurementMode == null) {
            return null;
        }
        lm internalDocument = this.this$0.getInternalDocument();
        return new xp(measurementScale, measurementPrecision, measurementMode, internalDocument != null ? internalDocument.getSecondaryMeasurementUnit() : null);
    }

    @Override // com.pspdfkit.internal.bm
    public Scale getMeasurementScale() {
        return this.this$0.propertyManager.h();
    }

    @Override // com.pspdfkit.internal.bm
    public NativeAnnotation getNativeAnnotation() {
        jr jrVar = this.this$0.nativeAnnotationHolder;
        if (jrVar != null) {
            return jrVar.getNativeAnnotation();
        }
        return null;
    }

    @Override // com.pspdfkit.internal.bm
    public Bitmap getNativeImageResource(String imageResourceId) {
        NativeAnnotation nativeAnnotation;
        NativeImageResourceInformation imageInformation;
        imageResourceId.getClass();
        if (!this.this$0.isAttached() || (nativeAnnotation = getNativeAnnotation()) == null || (imageInformation = getNativeResourceManager().getImageInformation(nativeAnnotation, imageResourceId)) == null) {
            return null;
        }
        Size originalSize = imageInformation.getOriginalSize();
        if (originalSize == null) {
            originalSize = new Size(Math.abs(imageInformation.getRect().width()), Math.abs(imageInformation.getRect().height()));
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) Math.ceil(originalSize.width), (int) Math.ceil(originalSize.height), Bitmap.Config.ARGB_8888);
        NativeResult imageResource = getNativeResourceManager().getImageResource(nativeAnnotation, imageResourceId, bitmapCreateBitmap);
        imageResource.getClass();
        if (imageResource.getHasError()) {
            PdfLog.e("Nutri.Annotation", "Couldn't retrieve annotation bitmap: %s", imageResource.getErrorString());
            return null;
        }
        bitmapCreateBitmap.setHasAlpha(imageInformation.getHasAlpha());
        if (!Objects.equals(Build.DEVICE, "robolectric")) {
            try {
                bitmapCreateBitmap.setPremultiplied(false);
                return bitmapCreateBitmap;
            } catch (RuntimeException e) {
                PdfLog.w("Nutri.Annotation", "Couldn't mark extracted annotation bitmap as non-premultiplied: %s", e.getMessage());
            }
        }
        return bitmapCreateBitmap;
    }

    @Override // com.pspdfkit.internal.bm
    public NativeResourceManager getNativeResourceManager() {
        if (!this.this$0.isAttached()) {
            throw new IllegalStateException("Can't access NativeResourceManager when annotation is not attached!");
        }
        lm internalDocument = this.this$0.getInternalDocument();
        internalDocument.getClass();
        return internalDocument.getAnnotationProvider().a.q;
    }

    @Override // com.pspdfkit.internal.bm
    public int getPageRotation() {
        lm internalDocument = this.this$0.getInternalDocument();
        if (internalDocument != null) {
            return internalDocument.getPageRotation(this.this$0.getPageIndex());
        }
        return 0;
    }

    @Override // com.pspdfkit.internal.bm
    public boolean getPrefersPlatformRendering() {
        return this.this$0.prefersPlatformRendering;
    }

    @Override // com.pspdfkit.internal.bm
    public j3 getProperties() {
        return this.this$0.propertyManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.internal.bm
    public List<fx> getQuadrilaterals() {
        List listE = this.this$0.propertyManager.e(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        boolean z = listE instanceof List;
        List list = listE;
        if (!z) {
            list = null;
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.pspdfkit.internal.bm
    public int getRotation() {
        return 360 - this.this$0.propertyManager.a(18, 0);
    }

    @Override // com.pspdfkit.internal.bm
    /* JADX INFO: renamed from: getSoundAnnotationState, reason: from getter */
    public j30 get_soundAnnotationState() {
        return this._soundAnnotationState;
    }

    @Override // com.pspdfkit.internal.bm
    public boolean getTextShouldFit() {
        Boolean additionalDataBoolean;
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation == null || (additionalDataBoolean = nativeAnnotation.getAdditionalDataBoolean(this.ADDITIONAL_DATA_KEY_TEXT_SHOULD_FIT)) == null) {
            return false;
        }
        return additionalDataBoolean.booleanValue();
    }

    @Override // com.pspdfkit.internal.bm
    public String getUuid() {
        String strG;
        Annotation annotation = this.this$0;
        synchronized (annotation.propertyManager) {
            strG = annotation.propertyManager.g(20);
            if (strG == null) {
                strG = generateNewUuid();
                setUuid(strG);
            }
        }
        return strG;
    }

    @Override // com.pspdfkit.internal.bm
    public AnnotationToolVariant getVariant() {
        String strG = this.this$0.propertyManager.g(26);
        if (strG != null) {
            AnnotationToolVariant annotationToolVariantFromName = AnnotationToolVariant.fromName(strG);
            annotationToolVariantFromName.getClass();
            return annotationToolVariantFromName;
        }
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        return annotationToolVariantDefaultVariant;
    }

    @Override // com.pspdfkit.internal.bm
    public boolean hasBeenSyncedFromNativeAnnotation() {
        return this.this$0.propertyManager.c;
    }

    @Override // com.pspdfkit.internal.bm
    public boolean isInstantCommentThreadRoot() {
        return this.this$0.propertyManager.a(12001);
    }

    @Override // com.pspdfkit.internal.bm
    public void markAsInstantCommentRoot() {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(12001, Boolean.TRUE, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void markPreferredForPlatformRendering() {
        this.this$0.markPreferredForPlatformRendering();
    }

    @Override // com.pspdfkit.internal.bm
    public boolean needsFlippedContentSize() {
        int pageRotation = getPageRotation();
        return pageRotation == 90 || pageRotation == 270;
    }

    @Override // com.pspdfkit.internal.bm
    public void notifyAnnotationCreated() {
        Iterator it = this.this$0.onAnnotationUpdatedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((AnnotationProvider.OnAnnotationUpdatedListener) it.next()).onAnnotationCreated(this.this$0);
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void notifyAnnotationRemoved() {
        Iterator it = this.this$0.onAnnotationUpdatedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((AnnotationProvider.OnAnnotationUpdatedListener) it.next()).onAnnotationRemoved(this.this$0);
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void notifyAnnotationUpdated() {
        Iterator it = this.this$0.onAnnotationUpdatedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((AnnotationProvider.OnAnnotationUpdatedListener) it.next()).onAnnotationUpdated(this.this$0);
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void onAttachToDocument(lm internalPdfDocument, jr nativeAnnotationHolder) {
        RectF rectFF;
        internalPdfDocument.getClass();
        nativeAnnotationHolder.getClass();
        Annotation annotation = this.this$0;
        synchronized (annotation) {
            annotation.internalDocument = internalPdfDocument;
            annotation.nativeAnnotationHolder = nativeAnnotationHolder;
            j3 j3Var = annotation.propertyManager;
            NativeAnnotation nativeAnnotationRequireNativeAnnotation = requireNativeAnnotation();
            o3 annotationProvider = internalPdfDocument.getAnnotationProvider();
            j3Var.getClass();
            nativeAnnotationRequireNativeAnnotation.getClass();
            annotationProvider.getClass();
            j3Var.b = nativeAnnotationRequireNativeAnnotation;
            j3Var.a = annotationProvider;
            j3Var.d = annotationProvider.d;
            j3Var.c = false;
            loadObjectNumberFromNativeAnnotation();
            if (annotation.adjustContentSizeOnAttachToDocument && needsFlippedContentSize() && (rectFF = annotation.propertyManager.f(22)) != null) {
                j3 j3Var2 = annotation.propertyManager;
                j3Var2.f.a(22, new RectF(0.0f, rectFF.width(), rectFF.height(), 0.0f), true);
                j3Var2.l();
            }
            annotation.adjustContentSizeOnAttachToDocument = false;
            if (annotation._appearanceStreamGenerator != null) {
                internalPdfDocument.getAnnotationProvider().g.a(annotation);
            }
            annotation.propertyManager.i();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void onBeforeAttachToDocument(lm internalPdfDocument, NativeAnnotation nativeAnnotation) {
        internalPdfDocument.getClass();
        nativeAnnotation.getClass();
        this.this$0.internalDocument = internalPdfDocument;
        j3 j3Var = this.this$0.propertyManager;
        o3 annotationProvider = internalPdfDocument.getAnnotationProvider();
        j3Var.getClass();
        annotationProvider.getClass();
        j3Var.b = nativeAnnotation;
        j3Var.a = annotationProvider;
        j3Var.d = annotationProvider.d;
        j3Var.c = false;
        this.this$0.onBeforeAttachToDocument(nativeAnnotation);
    }

    @Override // com.pspdfkit.internal.bm
    public void onDetachedFromDocument() {
        this.this$0.internalDocument = null;
        j3 j3Var = this.this$0.propertyManager;
        synchronized (j3Var) {
            Job job = j3Var.h;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            j3Var.h = null;
            j3Var.f.a(0, Integer.MIN_VALUE, true);
            j3Var.l();
            j3Var.h(17);
            j3Var.a = null;
            j3Var.b = null;
            j3Var.d = null;
            j3Var.i = false;
            k4 k4Var = j3Var.j;
            if (k4Var != null) {
                k4Var.c();
            }
        }
        jr jrVar = this.this$0.nativeAnnotationHolder;
        if (jrVar != null) {
            jrVar.release();
        }
        this.this$0.nativeAnnotationHolder = null;
    }

    @Override // com.pspdfkit.internal.bm
    public void prepareForCopy() {
        setPageIndex(0);
        setObjectNumber(Integer.MIN_VALUE);
        String strGenerateNewUuid = generateNewUuid();
        setUuid(strGenerateNewUuid);
        this.this$0.setName(strGenerateNewUuid);
        this.this$0.propertyManager.h(21);
        this.this$0.propertyManager.h(17);
    }

    @Override // com.pspdfkit.internal.bm
    public void removeOnAnnotationPropertyChangeListener(zs propertyChangeListener) {
        propertyChangeListener.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.getClass();
        propertyChangeListener.getClass();
        j3Var.g.b(propertyChangeListener);
    }

    @Override // com.pspdfkit.internal.bm
    public void removeOnAnnotationUpdatedListener(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener) {
        onAnnotationUpdatedListener.getClass();
        this.this$0.onAnnotationUpdatedListeners.b(onAnnotationUpdatedListener);
    }

    @Override // com.pspdfkit.internal.bm
    public NativeAnnotation requireNativeAnnotation() {
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation != null) {
            return nativeAnnotation;
        }
        throw new IllegalStateException("Native annotation is null.");
    }

    @Override // com.pspdfkit.internal.bm
    public void setAction(Action action) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(3000, action, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setAdditionalAction(AnnotationTriggerEvent triggerEvent, Action action) {
        p pVar;
        triggerEvent.getClass();
        p additionalActions = getAdditionalActions();
        if (additionalActions == null && action == null) {
            return;
        }
        if (additionalActions != null) {
            Map mapUnmodifiableMap = Collections.unmodifiableMap(additionalActions.a);
            mapUnmodifiableMap.getClass();
            pVar = new p((Map<AnnotationTriggerEvent, ? extends Action>) mapUnmodifiableMap);
        } else {
            pVar = new p((Object) null);
        }
        HashMap<AnnotationTriggerEvent, Action> map = pVar.a;
        if (action == null) {
            map.remove(triggerEvent);
        } else {
            map.put(triggerEvent, action);
        }
        boolean zIsEmpty = pVar.a.isEmpty();
        Annotation annotation = this.this$0;
        if (zIsEmpty) {
            j3 j3Var = annotation.propertyManager;
            j3Var.f.a(3001, null, true);
            j3Var.l();
        } else {
            j3 j3Var2 = annotation.propertyManager;
            j3Var2.f.a(3001, pVar, true);
            j3Var2.l();
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void setAdditionalData(String key, String value, boolean includeInJson) {
        key.getClass();
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation == null) {
            throw new IllegalStateException("Can't set additional data on an annotation that is not attached to a document.");
        }
        nativeAnnotation.setAdditionalDataString(key, value, includeInJson);
    }

    @Override // com.pspdfkit.internal.bm
    public void setAnnotationResource(k4 k4Var) {
        this.this$0.propertyManager.a(k4Var);
    }

    @Override // com.pspdfkit.internal.bm
    public void setDetachedAnnotationLookupKey(Integer detachedAnnotationLookupKey, NativeAnnotationManager nativeAnnotationManager) {
        this.this$0.detachedAnnotationLookupKey = detachedAnnotationLookupKey;
        this.this$0.detachedAnnotationManager = new WeakReference(nativeAnnotationManager);
    }

    @Override // com.pspdfkit.internal.bm
    public void setEdgeInsets(EdgeInsets edgeInsets) {
        edgeInsets.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(1007, edgeInsets, true);
        j3Var.l();
    }

    public void setInReplyToUuid(String str) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(21, str, true);
        synchronized (j3Var) {
            j3Var.a(true);
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void setIsSignature(boolean isSignature) {
        if (isSignature) {
            ar.b().getClass();
            if (!tg.b()) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow creating signature annotations.");
            }
        }
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(2000, Boolean.valueOf(isSignature), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setMeasurementPrecision(MeasurementPrecision precision) {
        precision.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(11001, precision, true);
        j3Var.l();
        this.this$0.updateMeasurementContentsString();
    }

    @Override // com.pspdfkit.internal.bm
    public void setMeasurementScale(Scale scale) {
        scale.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(11002, scale, true);
        j3Var.l();
        this.this$0.updateMeasurementContentsString();
    }

    public void setObjectNumber(int objectNumber) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(0, Integer.valueOf(objectNumber), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setPageIndex(int pageIndex) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(1, Integer.valueOf(pageIndex), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setPointsWithoutCoreSync(List<? extends PointF> points) {
        points.getClass();
        AnnotationType type = this.this$0.getType();
        if (p10.a(type)) {
            AnnotationType annotationType = AnnotationType.LINE;
            Annotation annotation = this.this$0;
            if (type == annotationType) {
                j3 j3Var = annotation.propertyManager;
                j3Var.f.a(100, LineAnnotation.linesFromPairOfPoints(points.get(0), points.get(1)), true);
                j3Var.l();
            } else {
                j3 j3Var2 = annotation.propertyManager;
                j3Var2.f.a(103, points, true);
                j3Var2.l();
            }
            this.this$0.updateMeasurementContentsString();
            if (this.this$0.isMeasurement()) {
                return;
            }
            updateBoundingBox();
        }
    }

    @Override // com.pspdfkit.internal.bm
    public void setQuadrilaterals(List<fx> list) {
        list.getClass();
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, new ArrayList(list), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setRotation(int i) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(18, Integer.valueOf(360 - (i % 360)), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setSoundAnnotationState(j30 j30Var) {
        this._soundAnnotationState = j30Var;
    }

    @Override // com.pspdfkit.internal.bm
    public void setTextShouldFit(boolean z) {
        NativeAnnotation nativeAnnotation = getNativeAnnotation();
        if (nativeAnnotation == null) {
            throw new IllegalStateException("Can't set shouldFit flag on an annotation that is not attached to a document.");
        }
        if (this.this$0.getType() != AnnotationType.FREETEXT) {
            throw new IllegalStateException("shouldFit flag can be set only on free-text annotations.");
        }
        nativeAnnotation.setAdditionalDataBoolean(this.ADDITIONAL_DATA_KEY_TEXT_SHOULD_FIT, Boolean.valueOf(z), false);
    }

    public void setUuid(String uuid) {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.f.a(20, uuid, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void setVariant(AnnotationToolVariant variant) {
        Annotation annotation = this.this$0;
        if (variant == null) {
            annotation.propertyManager.h(26);
            return;
        }
        j3 j3Var = annotation.propertyManager;
        j3Var.f.a(26, variant.getName(), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.internal.bm
    public void syncPropertiesWithNative() {
        j3 j3Var = this.this$0.propertyManager;
        j3Var.g();
        j3Var.j();
    }

    @Override // com.pspdfkit.internal.bm
    public boolean syncToBackend() {
        boolean zA;
        j3 j3Var = this.this$0.propertyManager;
        synchronized (j3Var) {
            zA = j3Var.a(true);
        }
        return zA;
    }

    @Override // com.pspdfkit.internal.bm
    public boolean updateMeasurementContentsString() {
        return this.this$0.updateMeasurementContentsString();
    }
}
