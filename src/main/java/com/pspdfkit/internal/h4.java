package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.configuration.rendering.AnnotationRenderConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationRenderer;
import com.pspdfkit.internal.jni.NativeAnnotationRenderingConfig;
import com.pspdfkit.internal.jni.NativeFormRenderingConfig;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 {
    public static Single<Bitmap> a(lm lmVar, final Annotation annotation, final Bitmap bitmap, final AnnotationRenderConfiguration annotationRenderConfiguration) {
        return Single.just(bitmap).map(new Function() { // from class: com.pspdfkit.internal.h4$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return h4.a(annotation, bitmap, annotationRenderConfiguration, (Bitmap) obj);
            }
        }).subscribeOn(lmVar.b(5));
    }

    public static Bitmap a(Annotation annotation, Bitmap bitmap, AnnotationRenderConfiguration annotationRenderConfiguration, Bitmap bitmap2) throws Throwable {
        ew ewVar;
        bitmap2.setHasAlpha(true);
        bitmap2.eraseColor(0);
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation != null) {
            synchronized (ar.class) {
                if (ar.d == null) {
                    ar.d = new ew();
                }
                ewVar = ar.d;
            }
            String strA = fw.a(annotation.getType());
            ewVar.getClass();
            uw.a(strA, "name", null);
            NativeAnnotationRenderer.drawAnnotation(nativeAnnotation, bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), new NativeAnnotationRenderingConfig(new NativeFormRenderingConfig(annotationRenderConfiguration.formHighlightColor, annotationRenderConfiguration.formRequiredFieldBorderColor, annotationRenderConfiguration.signHereOverlayBackgroundColor, annotationRenderConfiguration.formItemHighlightColor, annotationRenderConfiguration.showSignHereOverlay), true, annotationRenderConfiguration.toGrayscale, annotationRenderConfiguration.invertColors, false, true, false, annotationRenderConfiguration.drawRedactAsRedacted));
            if (annotationRenderConfiguration.invertColors) {
                ColorMatrix colorMatrix = (ColorMatrix) um.a.getValue();
                Paint paint = new Paint();
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                new Canvas(bitmap2).drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            }
            return bitmap2;
        }
        throw new IllegalStateException("Can't render annotations that aren't attached to a document page!");
    }

    public static Single a(final AppearanceStreamGenerator appearanceStreamGenerator, final StampAnnotation stampAnnotation, Bitmap bitmap, final AnnotationRenderConfiguration annotationRenderConfiguration) {
        return Single.just(bitmap).map(new Function() { // from class: com.pspdfkit.internal.h4$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return h4.a(appearanceStreamGenerator, stampAnnotation, annotationRenderConfiguration, (Bitmap) obj);
            }
        });
    }

    public static Bitmap a(AppearanceStreamGenerator appearanceStreamGenerator, Annotation annotation, AnnotationRenderConfiguration annotationRenderConfiguration, Bitmap bitmap) throws Throwable {
        bitmap.setHasAlpha(true);
        bitmap.eraseColor(0);
        if (!appearanceStreamGenerator.shouldUseGeneratorForAnnotation(annotation)) {
            return bitmap;
        }
        DataProvider dataProviderForAnnotation = appearanceStreamGenerator.getDataProviderForAnnotation(annotation, EnumSet.noneOf(AppearanceStreamGenerator.AppearanceStreamGenerationOptions.class));
        if (dataProviderForAnnotation != null) {
            NativeAnnotationRenderer.drawRawAPStream(new DataProviderShim(dataProviderForAnnotation), 0, annotation.getBoundingBox(), bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), new NativeAnnotationRenderingConfig(new NativeFormRenderingConfig(annotationRenderConfiguration.formHighlightColor, annotationRenderConfiguration.formRequiredFieldBorderColor, annotationRenderConfiguration.signHereOverlayBackgroundColor, annotationRenderConfiguration.formItemHighlightColor, annotationRenderConfiguration.showSignHereOverlay), true, annotationRenderConfiguration.toGrayscale, annotationRenderConfiguration.invertColors, false, true, false, annotationRenderConfiguration.drawRedactAsRedacted));
            return bitmap;
        }
        throw new IllegalStateException("Can't generate data provider for AP stream");
    }
}
