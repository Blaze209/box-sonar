package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationConfiguration {

    /* JADX INFO: renamed from: com.pspdfkit.annotations.configuration.AnnotationConfiguration$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$annotations$AnnotationType;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            $SwitchMap$com$pspdfkit$annotations$AnnotationType = iArr;
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.STRIKEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.SQUIGGLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.FREETEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.INK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.SQUARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.CIRCLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.POLYGON.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.LINE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.POLYLINE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.NOTE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.STAMP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.FILE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.REDACT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.SOUND.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public interface Builder<T> {
        AnnotationConfiguration build();

        T disableProperty(AnnotationProperty annotationProperty);

        T setForceDefaults(boolean z);

        T setSupportedProperties(EnumSet<AnnotationProperty> enumSet);

        T setZIndexEditingEnabled(boolean z);
    }

    static Builder<? extends Builder> builder(Context context, AnnotationTool annotationTool) {
        return annotationTool == AnnotationTool.ERASER ? EraserToolConfiguration.builder() : builder(context, annotationTool.toAnnotationType());
    }

    boolean getForceDefaults();

    EnumSet<AnnotationProperty> getSupportedProperties();

    boolean isZIndexEditingEnabled();

    static Builder<? extends Builder> builder(Context context, AnnotationType annotationType) {
        switch (AnonymousClass1.$SwitchMap$com$pspdfkit$annotations$AnnotationType[annotationType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return MarkupAnnotationConfiguration.builder(context, annotationType);
            case 5:
                return FreeTextAnnotationConfiguration.builder(context);
            case 6:
                return InkAnnotationConfiguration.builder(context);
            case 7:
            case 8:
            case 9:
                return ShapeAnnotationConfiguration.builder(context, annotationType);
            case 10:
            case 11:
                return LineAnnotationConfiguration.builder(context, annotationType);
            case 12:
                return NoteAnnotationConfiguration.builder(context);
            case 13:
                return StampAnnotationConfiguration.builder(context);
            case 14:
                return FileAnnotationConfiguration.builder();
            case 15:
                return RedactionAnnotationConfiguration.builder(context);
            case 16:
                return SoundAnnotationConfiguration.builder();
            default:
                throw new IllegalArgumentException("Annotation configuration builder is not implemented for annotation type: " + annotationType);
        }
    }
}
