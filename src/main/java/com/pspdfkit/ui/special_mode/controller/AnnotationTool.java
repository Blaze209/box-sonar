package com.pspdfkit.ui.special_mode.controller;

import com.pspdfkit.annotations.AnnotationType;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTool {
    private static final /* synthetic */ AnnotationTool[] $VALUES;
    public static final AnnotationTool ANNOTATION_MULTI_SELECTION;
    public static final AnnotationTool CAMERA;
    public static final AnnotationTool CIRCLE;
    public static final AnnotationTool ERASER;
    public static final AnnotationTool FREETEXT;
    public static final AnnotationTool FREETEXT_CALLOUT;
    public static final AnnotationTool HIGHLIGHT;
    public static final AnnotationTool IMAGE;
    public static final AnnotationTool INK;
    public static final AnnotationTool INSTANT_COMMENT_MARKER;
    public static final AnnotationTool INSTANT_HIGHLIGHT_COMMENT;
    public static final AnnotationTool LINE;
    public static final AnnotationTool MAGIC_INK;
    public static final AnnotationTool MEASUREMENT_AREA_ELLIPSE;
    public static final AnnotationTool MEASUREMENT_AREA_POLYGON;
    public static final AnnotationTool MEASUREMENT_AREA_RECT;
    public static final AnnotationTool MEASUREMENT_DISTANCE;
    public static final AnnotationTool MEASUREMENT_PERIMETER;
    public static final AnnotationTool MEASUREMENT_SCALE_CALIBRATION;
    public static final AnnotationTool NONE;
    public static final AnnotationTool NOTE;
    public static final AnnotationTool POLYGON;
    public static final AnnotationTool POLYLINE;
    public static final AnnotationTool REDACTION;
    public static final AnnotationTool SIGNATURE;
    public static final AnnotationTool SOUND;
    public static final AnnotationTool SQUARE;
    public static final AnnotationTool SQUIGGLY;
    public static final AnnotationTool STAMP;
    public static final AnnotationTool STRIKEOUT;
    public static final AnnotationTool UNDERLINE;
    private final AnnotationType annotationType;

    private static /* synthetic */ AnnotationTool[] $values() {
        return new AnnotationTool[]{NONE, HIGHLIGHT, STRIKEOUT, UNDERLINE, SQUIGGLY, FREETEXT, FREETEXT_CALLOUT, INK, MAGIC_INK, SIGNATURE, NOTE, LINE, SQUARE, CIRCLE, POLYGON, POLYLINE, MEASUREMENT_DISTANCE, MEASUREMENT_PERIMETER, MEASUREMENT_AREA_POLYGON, MEASUREMENT_AREA_ELLIPSE, MEASUREMENT_AREA_RECT, MEASUREMENT_SCALE_CALIBRATION, STAMP, IMAGE, CAMERA, SOUND, ERASER, REDACTION, INSTANT_COMMENT_MARKER, INSTANT_HIGHLIGHT_COMMENT, ANNOTATION_MULTI_SELECTION};
    }

    static {
        AnnotationType annotationType = AnnotationType.NONE;
        NONE = new AnnotationTool("NONE", 0, annotationType);
        AnnotationType annotationType2 = AnnotationType.HIGHLIGHT;
        HIGHLIGHT = new AnnotationTool("HIGHLIGHT", 1, annotationType2);
        STRIKEOUT = new AnnotationTool("STRIKEOUT", 2, AnnotationType.STRIKEOUT);
        UNDERLINE = new AnnotationTool("UNDERLINE", 3, AnnotationType.UNDERLINE);
        SQUIGGLY = new AnnotationTool("SQUIGGLY", 4, AnnotationType.SQUIGGLY);
        AnnotationType annotationType3 = AnnotationType.FREETEXT;
        FREETEXT = new AnnotationTool("FREETEXT", 5, annotationType3);
        FREETEXT_CALLOUT = new AnnotationTool("FREETEXT_CALLOUT", 6, annotationType3);
        AnnotationType annotationType4 = AnnotationType.INK;
        INK = new AnnotationTool("INK", 7, annotationType4);
        MAGIC_INK = new AnnotationTool("MAGIC_INK", 8, annotationType4);
        SIGNATURE = new AnnotationTool("SIGNATURE", 9, annotationType4);
        AnnotationType annotationType5 = AnnotationType.NOTE;
        NOTE = new AnnotationTool("NOTE", 10, annotationType5);
        AnnotationType annotationType6 = AnnotationType.LINE;
        LINE = new AnnotationTool("LINE", 11, annotationType6);
        AnnotationType annotationType7 = AnnotationType.SQUARE;
        SQUARE = new AnnotationTool("SQUARE", 12, annotationType7);
        AnnotationType annotationType8 = AnnotationType.CIRCLE;
        CIRCLE = new AnnotationTool("CIRCLE", 13, annotationType8);
        AnnotationType annotationType9 = AnnotationType.POLYGON;
        POLYGON = new AnnotationTool("POLYGON", 14, annotationType9);
        AnnotationType annotationType10 = AnnotationType.POLYLINE;
        POLYLINE = new AnnotationTool("POLYLINE", 15, annotationType10);
        MEASUREMENT_DISTANCE = new AnnotationTool("MEASUREMENT_DISTANCE", 16, annotationType6);
        MEASUREMENT_PERIMETER = new AnnotationTool("MEASUREMENT_PERIMETER", 17, annotationType10);
        MEASUREMENT_AREA_POLYGON = new AnnotationTool("MEASUREMENT_AREA_POLYGON", 18, annotationType9);
        MEASUREMENT_AREA_ELLIPSE = new AnnotationTool("MEASUREMENT_AREA_ELLIPSE", 19, annotationType8);
        MEASUREMENT_AREA_RECT = new AnnotationTool("MEASUREMENT_AREA_RECT", 20, annotationType7);
        MEASUREMENT_SCALE_CALIBRATION = new AnnotationTool("MEASUREMENT_SCALE_CALIBRATION", 21, annotationType6);
        AnnotationType annotationType11 = AnnotationType.STAMP;
        STAMP = new AnnotationTool("STAMP", 22, annotationType11);
        IMAGE = new AnnotationTool("IMAGE", 23, annotationType11);
        CAMERA = new AnnotationTool("CAMERA", 24, annotationType11);
        SOUND = new AnnotationTool("SOUND", 25, AnnotationType.SOUND);
        ERASER = new AnnotationTool("ERASER", 26, annotationType);
        REDACTION = new AnnotationTool("REDACTION", 27, AnnotationType.REDACT);
        INSTANT_COMMENT_MARKER = new AnnotationTool("INSTANT_COMMENT_MARKER", 28, annotationType5);
        INSTANT_HIGHLIGHT_COMMENT = new AnnotationTool("INSTANT_HIGHLIGHT_COMMENT", 29, annotationType2);
        ANNOTATION_MULTI_SELECTION = new AnnotationTool("ANNOTATION_MULTI_SELECTION", 30, annotationType);
        $VALUES = $values();
    }

    private AnnotationTool(String str, int i, AnnotationType annotationType) {
        super(str, i);
        this.annotationType = annotationType;
    }

    public static AnnotationTool fromAnnotationType(AnnotationType annotationType) {
        if (annotationType == null) {
            return NONE;
        }
        for (AnnotationTool annotationTool : values()) {
            if (annotationTool.toAnnotationType() == annotationType) {
                return annotationTool;
            }
        }
        return NONE;
    }

    public static AnnotationTool valueOf(String str) {
        return (AnnotationTool) Enum.valueOf(AnnotationTool.class, str);
    }

    public static AnnotationTool[] values() {
        return (AnnotationTool[]) $VALUES.clone();
    }

    public AnnotationType toAnnotationType() {
        return this.annotationType;
    }
}
