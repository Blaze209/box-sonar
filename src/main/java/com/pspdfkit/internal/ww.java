package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.media3.extractor.ts.TsExtractor;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseLineAnnotation;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.TextMarkupAnnotation;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.controller.ContentEditingStylingBarItem;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ww {
    public static final float a;
    public static final float b;
    public static final int c;
    public static final List<Integer> d;
    public static final List<AnnotationType> e;
    public static final List<Integer> f;
    public static final List<Integer> g;
    public static final List<Integer> h;
    public static final List<Integer> i;
    public static final List<Integer> j;
    public static final List<String> k;
    public static final Map<String, Integer> l;
    public static final int m;
    public static final int n;
    public static final Map<String, Integer> o;
    public static final int p;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.SQUIGGLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.LINK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationType.STAMP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationType.CARET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationType.RICHMEDIA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationType.SCREEN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationType.WIDGET.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AnnotationType.FILE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[AnnotationType.REDACT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[AnnotationType.POPUP.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[AnnotationType.WATERMARK.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[AnnotationType.TRAPNET.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[AnnotationType.TYPE3D.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            a = iArr;
            int[] iArr2 = new int[AnnotationTool.values().length];
            try {
                iArr2[AnnotationTool.ERASER.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[AnnotationTool.INSTANT_COMMENT_MARKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[AnnotationTool.INSTANT_HIGHLIGHT_COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_DISTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_PERIMETER.ordinal()] = 5;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_ELLIPSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_POLYGON.ordinal()] = 7;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_RECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_SCALE_CALIBRATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[AnnotationTool.FREETEXT.ordinal()] = 10;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[AnnotationTool.UNDERLINE.ordinal()] = 11;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr2[AnnotationTool.SQUIGGLY.ordinal()] = 12;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr2[AnnotationTool.STRIKEOUT.ordinal()] = 13;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr2[AnnotationTool.HIGHLIGHT.ordinal()] = 14;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr2[AnnotationTool.INK.ordinal()] = 15;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr2[AnnotationTool.MAGIC_INK.ordinal()] = 16;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr2[AnnotationTool.LINE.ordinal()] = 17;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr2[AnnotationTool.SQUARE.ordinal()] = 18;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr2[AnnotationTool.CIRCLE.ordinal()] = 19;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr2[AnnotationTool.POLYGON.ordinal()] = 20;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr2[AnnotationTool.POLYLINE.ordinal()] = 21;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr2[AnnotationTool.REDACTION.ordinal()] = 22;
            } catch (NoSuchFieldError unused47) {
            }
            b = iArr2;
            int[] iArr3 = new int[ContentEditingStylingBarItem.values().length];
            try {
                iArr3[ContentEditingStylingBarItem.FONT_COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr3[ContentEditingStylingBarItem.FONT_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr3[ContentEditingStylingBarItem.FONT_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr3[ContentEditingStylingBarItem.LINE_SPACING.ordinal()] = 4;
            } catch (NoSuchFieldError unused51) {
            }
            c = iArr3;
        }
    }

    static {
        float[] fArr = o50.a;
        a = ArraysKt.first(fArr);
        b = ArraysKt.last(fArr);
        c = Color.rgb(192, 39, 76);
        List<Integer> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.rgb(255, 255, 255)), Integer.valueOf(Color.rgb(TsExtractor.TS_PACKET_SIZE, 198, 203)), Integer.valueOf(Color.rgb(130, Token.SETELEM_OP, Token.DOTQUERY)), Integer.valueOf(Color.rgb(85, 93, 97)), Integer.valueOf(Color.rgb(0, 0, 0)), Integer.valueOf(Color.rgb(109, 80, 52)), Integer.valueOf(Color.rgb(192, 39, 76)), Integer.valueOf(Color.rgb(223, 71, 79)), Integer.valueOf(Color.rgb(245, Token.METHOD, 42)), Integer.valueOf(Color.rgb(254, 232, 49)), Integer.valueOf(Color.rgb(Token.ARRAYCOMP, 214, 0)), Integer.valueOf(Color.rgb(63, 179, 60)), Integer.valueOf(Color.rgb(8, 204, 180)), Integer.valueOf(Color.rgb(34, Token.DOTQUERY, 251)), Integer.valueOf(Color.rgb(75, 100, 227)), Integer.valueOf(Color.rgb(Token.SET_REF_OP, 91, 255)), Integer.valueOf(Color.rgb(226, 67, 252)), Integer.valueOf(Color.rgb(253, 99, Token.COLONCOLON))}));
        listUnmodifiableList.getClass();
        d = listUnmodifiableList;
        List<AnnotationType> listUnmodifiableList2 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new AnnotationType[]{AnnotationType.HIGHLIGHT, AnnotationType.STRIKEOUT, AnnotationType.UNDERLINE, AnnotationType.SQUIGGLY, AnnotationType.REDACT, AnnotationType.INK, AnnotationType.SQUARE, AnnotationType.CIRCLE, AnnotationType.LINE, AnnotationType.POLYGON, AnnotationType.POLYLINE}));
        listUnmodifiableList2.getClass();
        e = listUnmodifiableList2;
        List<Integer> listUnmodifiableList3 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new Integer[]{0, Integer.valueOf(Color.rgb(255, 255, 255)), Integer.valueOf(Color.rgb(TsExtractor.TS_PACKET_SIZE, 198, 203)), Integer.valueOf(Color.rgb(130, Token.SETELEM_OP, Token.DOTQUERY)), Integer.valueOf(Color.rgb(85, 93, 97)), Integer.valueOf(Color.rgb(0, 0, 0)), Integer.valueOf(Color.rgb(192, 39, 76)), Integer.valueOf(Color.rgb(223, 71, 79)), Integer.valueOf(Color.rgb(245, Token.METHOD, 42)), Integer.valueOf(Color.rgb(254, 232, 49)), Integer.valueOf(Color.rgb(Token.ARRAYCOMP, 214, 0)), Integer.valueOf(Color.rgb(63, 179, 60)), Integer.valueOf(Color.rgb(8, 204, 180)), Integer.valueOf(Color.rgb(34, Token.DOTQUERY, 251)), Integer.valueOf(Color.rgb(75, 100, 227)), Integer.valueOf(Color.rgb(Token.SET_REF_OP, 91, 255)), Integer.valueOf(Color.rgb(226, 67, 252)), Integer.valueOf(Color.rgb(253, 99, Token.COLONCOLON))}));
        listUnmodifiableList3.getClass();
        f = listUnmodifiableList3;
        g = listUnmodifiableList3;
        List<Integer> listUnmodifiableList4 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.rgb(255, 238, 88)), Integer.valueOf(Color.rgb(255, Token.LAST_TOKEN, 38)), Integer.valueOf(Color.rgb(239, 83, 80)), Integer.valueOf(Color.rgb(236, 64, 122)), Integer.valueOf(Color.rgb(66, Token.ARROW, 245)), Integer.valueOf(Color.rgb(102, 187, 106))}));
        listUnmodifiableList4.getClass();
        h = listUnmodifiableList4;
        List<Integer> listUnmodifiableList5 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.rgb(244, 67, 54)), Integer.valueOf(Color.rgb(139, 195, 74)), Integer.valueOf(Color.rgb(33, 150, 243)), Integer.valueOf(Color.rgb(252, 237, 140)), Integer.valueOf(Color.rgb(233, 30, 99)), Integer.valueOf(Color.rgb(250, 250, 250)), Integer.valueOf(Color.rgb(224, 224, 224)), Integer.valueOf(Color.rgb(Token.ARRAYCOMP, Token.ARRAYCOMP, Token.ARRAYCOMP)), Integer.valueOf(Color.rgb(66, 66, 66)), Integer.valueOf(Color.rgb(33, 33, 33))}));
        listUnmodifiableList5.getClass();
        i = listUnmodifiableList5;
        List<Integer> listUnmodifiableList6 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new Integer[]{-8781810, -13281254, -15459505, -13491091, -3563453, Integer.valueOf(Color.rgb(244, 67, 54)), Integer.valueOf(Color.rgb(139, 195, 74)), Integer.valueOf(Color.rgb(33, 150, 243)), Integer.valueOf(Color.rgb(252, 237, 140)), Integer.valueOf(Color.rgb(233, 30, 99)), -11010038, Integer.valueOf(Color.rgb(224, 224, 224)), Integer.valueOf(Color.rgb(Token.ARRAYCOMP, Token.ARRAYCOMP, Token.ARRAYCOMP)), Integer.valueOf(Color.rgb(66, 66, 66)), Integer.valueOf(Color.rgb(0, 0, 0))}));
        listUnmodifiableList6.getClass();
        j = listUnmodifiableList6;
        List<String> listUnmodifiableList7 = Collections.unmodifiableList(CollectionsKt.listOf((Object[]) new String[]{NoteAnnotation.COMMENT, NoteAnnotation.RIGHT_POINTER, NoteAnnotation.RIGHT_ARROW, NoteAnnotation.CHECK, NoteAnnotation.CIRCLE, NoteAnnotation.CROSS, NoteAnnotation.INSERT, NoteAnnotation.NEW_PARAGRAPH, NoteAnnotation.NOTE, NoteAnnotation.PARAGRAPH, NoteAnnotation.HELP, NoteAnnotation.STAR}));
        listUnmodifiableList7.getClass();
        k = listUnmodifiableList7;
        n70.a[] aVarArr = {new n70.a(NoteAnnotation.COMMENT, Integer.valueOf(R.drawable.pspdf__note_icon_comment)), new n70.a(NoteAnnotation.RIGHT_POINTER, Integer.valueOf(R.drawable.pspdf__note_icon_right_pointer)), new n70.a(NoteAnnotation.RIGHT_ARROW, Integer.valueOf(R.drawable.pspdf__note_icon_right_arrow)), new n70.a(NoteAnnotation.CHECK, Integer.valueOf(R.drawable.pspdf__note_icon_check)), new n70.a(NoteAnnotation.CIRCLE, Integer.valueOf(R.drawable.pspdf__note_icon_circle)), new n70.a(NoteAnnotation.CROSS, Integer.valueOf(R.drawable.pspdf__note_icon_cross)), new n70.a(NoteAnnotation.INSERT, Integer.valueOf(R.drawable.pspdf__note_icon_insert)), new n70.a(NoteAnnotation.NEW_PARAGRAPH, Integer.valueOf(R.drawable.pspdf__note_icon_new_paragraph)), new n70.a(NoteAnnotation.NOTE, Integer.valueOf(R.drawable.pspdf__note_icon_note)), new n70.a(NoteAnnotation.PARAGRAPH, Integer.valueOf(R.drawable.pspdf__note_icon_paragraph)), new n70.a(NoteAnnotation.HELP, Integer.valueOf(R.drawable.pspdf__note_icon_help)), new n70.a(NoteAnnotation.STAR, Integer.valueOf(R.drawable.pspdf__note_icon_star)), new n70.a(NoteAnnotation.KEY, Integer.valueOf(R.drawable.pspdf__note_icon_key))};
        HashMap map = new HashMap(13);
        for (int i2 = 0; i2 < 13; i2++) {
            n70.a aVar = aVarArr[i2];
            map.put(aVar.a, aVar.b);
        }
        Map<String, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        mapUnmodifiableMap.getClass();
        l = mapUnmodifiableMap;
        m = R.drawable.pspdf__note_icon_note;
        n = R.drawable.pspdf__note_icon_instant_comment;
        n70.a[] aVarArr2 = {new n70.a(FileAnnotation.GRAPH, Integer.valueOf(R.drawable.pspdf__file_icon_graph)), new n70.a(FileAnnotation.PAPERCLIP, Integer.valueOf(R.drawable.pspdf__file_icon_paperclip)), new n70.a(FileAnnotation.PUSH_PIN, Integer.valueOf(R.drawable.pspdf__file_icon_push_pin)), new n70.a(FileAnnotation.TAG, Integer.valueOf(R.drawable.pspdf__file_icon_tag))};
        HashMap map2 = new HashMap(4);
        for (int i3 = 0; i3 < 4; i3++) {
            n70.a aVar2 = aVarArr2[i3];
            map2.put(aVar2.a, aVar2.b);
        }
        Map<String, Integer> mapUnmodifiableMap2 = Collections.unmodifiableMap(map2);
        mapUnmodifiableMap2.getClass();
        o = mapUnmodifiableMap2;
        p = R.drawable.pspdf__file_icon_paperclip;
    }

    @JvmStatic
    public static final int a(Annotation annotation) {
        annotation.getClass();
        if (annotation instanceof NoteAnnotation) {
            if (annotation.getInternal().isInstantCommentThreadRoot()) {
                return n;
            }
            String iconName = ((NoteAnnotation) annotation).getIconName();
            iconName.getClass();
            Integer num = l.get(iconName);
            return num != null ? num.intValue() : m;
        }
        if (!(annotation instanceof FileAnnotation)) {
            if (annotation instanceof SoundAnnotation) {
                return R.drawable.pspdf__ic_sound;
            }
            throw new IllegalArgumentException("Only note and file annotations are supported.");
        }
        String iconName2 = ((FileAnnotation) annotation).getIconName();
        iconName2.getClass();
        Integer num2 = o.get(iconName2);
        return num2 != null ? num2.intValue() : p;
    }

    public static float b(Annotation annotation) {
        annotation.getClass();
        int i2 = a.a[annotation.getType().ordinal()];
        if (i2 != 5) {
            if (i2 == 7) {
                return ((InkAnnotation) annotation).getLineWidth();
            }
            if (i2 != 17 && i2 != 9) {
                if (i2 == 10 || i2 == 19 || i2 == 20) {
                    return ((BaseLineAnnotation) annotation).getLineWidth();
                }
                return -1.0f;
            }
        }
        return annotation.getBorderWidth();
    }

    @JvmStatic
    public static final Pair<AnnotationTool, AnnotationToolVariant> c(Annotation annotation) {
        annotation.getClass();
        AnnotationTool annotationTool = AnnotationTool.NONE;
        int i2 = a.a[annotation.getType().ordinal()];
        if (i2 != 5) {
            if (i2 == 17) {
                annotationTool = annotation.isMeasurement() ? AnnotationTool.MEASUREMENT_AREA_RECT : AnnotationTool.SQUARE;
            } else if (i2 == 9) {
                annotationTool = annotation.isMeasurement() ? AnnotationTool.MEASUREMENT_AREA_ELLIPSE : AnnotationTool.CIRCLE;
            } else if (i2 != 10) {
                if (i2 == 19) {
                    annotationTool = annotation.isMeasurement() ? AnnotationTool.MEASUREMENT_AREA_POLYGON : AnnotationTool.POLYGON;
                } else if (i2 != 20) {
                    for (AnnotationTool annotationTool2 : AnnotationTool.values()) {
                        if (annotation.getType() == annotationTool2.toAnnotationType()) {
                            annotationTool = annotationTool2;
                            break;
                        }
                    }
                } else {
                    annotationTool = annotation.isMeasurement() ? AnnotationTool.MEASUREMENT_PERIMETER : AnnotationTool.POLYLINE;
                }
            } else if (annotation.isMeasurement()) {
                LineAnnotation lineAnnotation = annotation instanceof LineAnnotation ? (LineAnnotation) annotation : null;
                annotationTool = (lineAnnotation == null || !lineAnnotation.isCalibration()) ? AnnotationTool.MEASUREMENT_DISTANCE : AnnotationTool.MEASUREMENT_SCALE_CALIBRATION;
            } else {
                annotationTool = AnnotationTool.LINE;
            }
        } else if (annotation instanceof FreeTextAnnotation) {
            List<PointF> callOutPoints = ((FreeTextAnnotation) annotation).getCallOutPoints();
            callOutPoints.getClass();
            annotationTool = !callOutPoints.isEmpty() ? AnnotationTool.FREETEXT_CALLOUT : AnnotationTool.FREETEXT;
        }
        return new Pair<>(annotationTool, annotation.getInternal().getVariant());
    }

    @JvmStatic
    public static final Pair<LineEndType, LineEndType> d(Annotation annotation) {
        annotation.getClass();
        int i2 = a.a[annotation.getType().ordinal()];
        if (i2 != 5) {
            if (i2 == 10) {
                return ((LineAnnotation) annotation).getLineEnds();
            }
            if (i2 != 20) {
                return null;
            }
            return ((PolylineAnnotation) annotation).getLineEnds();
        }
        FreeTextAnnotation freeTextAnnotation = (FreeTextAnnotation) annotation;
        if (freeTextAnnotation.getIntent() != FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            return null;
        }
        LineEndType lineEnd = freeTextAnnotation.getLineEnd();
        lineEnd.getClass();
        return new Pair<>(lineEnd, LineEndType.NONE);
    }

    @JvmStatic
    public static final List<PointF> e(Annotation annotation) {
        annotation.getClass();
        int i2 = a.a[annotation.getType().ordinal()];
        if (i2 == 5) {
            List<PointF> callOutPoints = ((FreeTextAnnotation) annotation).getCallOutPoints();
            callOutPoints.getClass();
            return callOutPoints;
        }
        if (i2 == 10) {
            Pair<PointF, PointF> points = ((LineAnnotation) annotation).getPoints();
            points.getClass();
            return CollectionsKt.listOf((Object[]) new PointF[]{points.first, points.second});
        }
        if (i2 == 19) {
            List<PointF> points2 = ((PolygonAnnotation) annotation).getPoints();
            points2.getClass();
            return points2;
        }
        if (i2 != 20) {
            return CollectionsKt.emptyList();
        }
        List<PointF> points3 = ((PolylineAnnotation) annotation).getPoints();
        points3.getClass();
        return points3;
    }

    @JvmStatic
    public static final boolean f(Annotation annotation) {
        return (annotation == null || !h(annotation) || annotation.hasFlag(AnnotationFlags.READONLY)) ? false : true;
    }

    @JvmStatic
    public static final boolean g(Annotation annotation) {
        String contents;
        annotation.getClass();
        if (annotation.getType() != AnnotationType.FREETEXT && annotation.getType() != AnnotationType.NOTE) {
            if (annotation.getInternal().isInstantCommentThreadRoot()) {
                return true;
            }
            if ((f(annotation) || ((contents = annotation.getContents()) != null && contents.length() != 0)) && !StringsKt.equals("AutoCAD SHX Text", annotation.getCreator(), true)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean h(Annotation annotation) {
        EnumSet<AnnotationFlags> flags;
        if (annotation == null || (flags = annotation.getFlags()) == null || flags.contains(AnnotationFlags.HIDDEN) || flags.contains(AnnotationFlags.NOVIEW)) {
            return false;
        }
        return (annotation.isReply() && annotation.getType() == AnnotationType.NOTE) ? false : true;
    }

    @JvmStatic
    public static final int a(AnnotationTool annotationTool) {
        annotationTool.getClass();
        switch (a.b[annotationTool.ordinal()]) {
            case 1:
                return R.string.pspdf__annotation_type_eraser;
            case 2:
            case 3:
                return R.string.pspdf__annotation_type_instantComments;
            case 4:
                return R.string.pspdf__annotation_type_measure_distance;
            case 5:
                return R.string.pspdf__annotation_type_measure_perimeter;
            case 6:
                return R.string.pspdf__annotation_type_measure_elliptical_area;
            case 7:
                return R.string.pspdf__annotation_type_measure_polygonal_area;
            case 8:
                return R.string.pspdf__annotation_type_measure_rectangular_area;
            case 9:
                return R.string.pspdf__calibrate_scale;
            default:
                AnnotationType annotationType = annotationTool.toAnnotationType();
                annotationType.getClass();
                annotationType.getClass();
                switch (a.a[annotationType.ordinal()]) {
                    case 2:
                        return R.string.pspdf__edit_menu_highlight;
                    case 3:
                        return R.string.pspdf__edit_menu_strikeout;
                    case 4:
                        return R.string.pspdf__edit_menu_underline;
                    case 5:
                        return R.string.pspdf__edit_menu_freetext;
                    case 6:
                        return R.string.pspdf__edit_menu_squiggly;
                    case 7:
                        return R.string.pspdf__edit_menu_ink;
                    case 8:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 18:
                    default:
                        return R.string.pspdf__annotations;
                    case 9:
                        return R.string.pspdf__annotation_type_circle;
                    case 10:
                        return R.string.pspdf__annotation_type_line;
                    case 11:
                        return R.string.pspdf__annotation_type_stamp;
                    case 17:
                        return R.string.pspdf__annotation_type_square;
                    case 19:
                        return R.string.pspdf__annotation_type_polygon;
                    case 20:
                        return R.string.pspdf__annotation_type_polyline;
                    case 21:
                        return R.string.pspdf__annotation_type_redaction;
                }
        }
    }

    @JvmStatic
    public static final int a(Context context, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        context.getClass();
        annotationTool.getClass();
        annotationToolVariant.getClass();
        int i2 = a.b[annotationTool.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2 && i2 != 3) {
            switch (i2) {
                case 10:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_freetext);
                case 11:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_underline);
                case 12:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_squiggle);
                case 13:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_strikeout);
                case 14:
                    break;
                case 15:
                    if (Intrinsics.areEqual(annotationToolVariant, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.HIGHLIGHTER))) {
                        return ContextCompat.getColor(context, R.color.pspdf__color_default_highlight);
                    }
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_ink);
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_ink);
                case 22:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_redaction);
                default:
                    return ContextCompat.getColor(context, R.color.pspdf__color_default_highlight);
            }
        }
        return ContextCompat.getColor(context, R.color.pspdf__color_default_highlight);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:113:0x0218 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0144  */
    @JvmStatic
    public static final String a(Context context, Annotation annotation, boolean z) {
        String strA;
        String str;
        boolean z2;
        context.getClass();
        annotation.getClass();
        AnnotationType type = annotation.getType();
        if (annotation.getInternal().isInstantCommentThreadRoot()) {
            strA = no.a(context, R.string.pspdf__annotation_type_instantComments, null);
            strA.getClass();
        } else {
            switch (a.a[type.ordinal()]) {
                case 1:
                    strA = no.a(context, R.string.pspdf__annotation_type_note, null);
                    strA.getClass();
                    break;
                case 2:
                    strA = no.a(context, R.string.pspdf__annotation_type_highlight, null);
                    strA.getClass();
                    break;
                case 3:
                    strA = no.a(context, R.string.pspdf__annotation_type_strikeout, null);
                    strA.getClass();
                    break;
                case 4:
                    strA = no.a(context, R.string.pspdf__annotation_type_underline, null);
                    strA.getClass();
                    break;
                case 5:
                    strA = no.a(context, R.string.pspdf__annotation_type_freetext, null);
                    strA.getClass();
                    break;
                case 6:
                    strA = no.a(context, R.string.pspdf__annotation_type_squiggly, null);
                    strA.getClass();
                    break;
                case 7:
                    strA = no.a(context, R.string.pspdf__annotation_type_ink, null);
                    strA.getClass();
                    break;
                case 8:
                    strA = no.a(context, R.string.pspdf__annotation_type_link, null);
                    strA.getClass();
                    break;
                case 9:
                    strA = no.a(context, R.string.pspdf__annotation_type_circle, null);
                    strA.getClass();
                    break;
                case 10:
                    strA = no.a(context, R.string.pspdf__annotation_type_line, null);
                    strA.getClass();
                    break;
                case 11:
                    strA = no.a(context, R.string.pspdf__annotation_type_stamp, null);
                    strA.getClass();
                    break;
                case 12:
                case 15:
                case 22:
                case 23:
                case 24:
                case 25:
                default:
                    strA = "";
                    break;
                case 13:
                    strA = no.a(context, R.string.pspdf__annotation_type_rich_media, null);
                    strA.getClass();
                    break;
                case 14:
                    strA = no.a(context, R.string.pspdf__annotation_type_screen, null);
                    strA.getClass();
                    break;
                case 16:
                    strA = no.a(context, R.string.pspdf__annotation_type_file, null);
                    strA.getClass();
                    break;
                case 17:
                    strA = no.a(context, R.string.pspdf__annotation_type_square, null);
                    strA.getClass();
                    break;
                case 18:
                    strA = no.a(context, R.string.pspdf__annotation_type_sound, null);
                    strA.getClass();
                    break;
                case 19:
                    strA = no.a(context, R.string.pspdf__annotation_type_polygon, null);
                    strA.getClass();
                    break;
                case 20:
                    strA = no.a(context, R.string.pspdf__annotation_type_polyline, null);
                    strA.getClass();
                    break;
                case 21:
                    strA = no.a(context, R.string.pspdf__annotation_type_redaction, null);
                    strA.getClass();
                    break;
            }
        }
        switch (a.a[type.ordinal()]) {
            case 1:
            case 5:
            case 9:
            case 10:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                String contents = annotation.getContents();
                if (contents == null || contents.length() == 0) {
                    return strA;
                }
                return contents;
            case 2:
            case 3:
            case 4:
            case 6:
                if (z) {
                    String contents2 = annotation.getContents();
                    if (!annotation.getInternal().isInstantCommentThreadRoot() && contents2 != null && contents2.length() != 0) {
                        return contents2;
                    }
                    if (annotation instanceof TextMarkupAnnotation) {
                        String highlightedText = ((TextMarkupAnnotation) annotation).getHighlightedText();
                        highlightedText.getClass();
                        if (highlightedText.length() > 0) {
                            return highlightedText;
                        }
                    }
                } else {
                    String contents3 = annotation.getContents();
                    if (!annotation.getInternal().isInstantCommentThreadRoot() && contents3 != null && contents3.length() != 0) {
                        return contents3;
                    }
                }
                return strA;
            case 7:
                StringBuilder sb = new StringBuilder();
                String contents4 = annotation.getContents();
                if (contents4 != null && contents4.length() != 0) {
                    return sb.append(contents4).toString();
                }
                sb.append(strA);
                if (annotation instanceof InkAnnotation) {
                    int size = ((InkAnnotation) annotation).getLines().size();
                    sb.append(", ").append(no.a(context, R.plurals.pspdf__lines_number, size, Integer.valueOf(size)));
                }
                return sb.toString();
            case 8:
                String name = annotation.getName();
                if (name != null) {
                    str = name.length() != 0 ? name : null;
                    if (str != null) {
                        return str;
                    }
                }
                return strA;
            case 11:
                StringBuilder sb2 = new StringBuilder();
                if (annotation instanceof StampAnnotation) {
                    StampAnnotation stampAnnotation = (StampAnnotation) annotation;
                    String title = stampAnnotation.getTitle();
                    String title2 = stampAnnotation.getTitle();
                    if (title2 == null || title2.length() == 0) {
                        z2 = false;
                    } else {
                        sb2.append(title);
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                String contents5 = annotation.getContents();
                if (contents5 != null && contents5.length() != 0) {
                    if (z2) {
                        sb2.append(": ");
                    }
                    sb2.append(contents5);
                }
                String string = sb2.toString();
                if (string.length() == 0) {
                    return strA;
                }
                return string;
            case 12:
            case 15:
            case 22:
            case 23:
            case 24:
            case 25:
                String name2 = annotation.getName();
                if (name2 != null) {
                    str = name2.length() != 0 ? name2 : null;
                    if (str != null) {
                        return str;
                    }
                }
                return "";
            case 13:
            case 14:
                return strA;
            default:
                String name3 = annotation.getName();
                if (name3 != null) {
                    str = name3.length() != 0 ? name3 : null;
                    if (str != null) {
                        return str;
                    }
                }
                return "";
        }
    }

    @JvmStatic
    public static final String a(Context context, PdfDocument pdfDocument) {
        context.getClass();
        pdfDocument.getClass();
        lm lmVar = (lm) pdfDocument;
        DocumentSource documentSource = lmVar.r;
        if (documentSource == null) {
            String title = lmVar.getTitle();
            if (title != null && title.length() != 0) {
                return title;
            }
            String strA = no.a(context, R.string.pspdf__activity_title_unnamed_document, null);
            strA.getClass();
            return strA;
        }
        String strA2 = documentSource != null ? ue.a(documentSource) : null;
        if (strA2 != null) {
            return strA2;
        }
        String strA3 = no.a(context, R.string.pspdf__unnamed_image_document, null);
        strA3.getClass();
        return strA3;
    }

    @JvmStatic
    public static final boolean a(Annotation annotation, LineEndType lineEndType, LineEndType lineEndType2) {
        annotation.getClass();
        lineEndType.getClass();
        lineEndType2.getClass();
        int i2 = a.a[annotation.getType().ordinal()];
        if (i2 == 5) {
            FreeTextAnnotation freeTextAnnotation = (FreeTextAnnotation) annotation;
            if (freeTextAnnotation.getIntent() != FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
                return false;
            }
            freeTextAnnotation.setLineEnd(lineEndType2);
            return true;
        }
        if (i2 == 10) {
            ((LineAnnotation) annotation).setLineEnds(lineEndType, lineEndType2);
            return true;
        }
        if (i2 != 20) {
            return false;
        }
        ((PolylineAnnotation) annotation).setLineEnds(lineEndType, lineEndType2);
        return true;
    }

    @JvmStatic
    public static final boolean a(FormElement formElement) {
        return (formElement == null || formElement.isReadOnly() || formElement.getAnnotation().getHasLockedContents()) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final int a(String str) {
        str.getClass();
        switch (str.hashCode()) {
            case -2099925287:
                if (str.equals(NoteAnnotation.INSERT)) {
                    return R.string.pspdf__note_icon_insert_text;
                }
                return 0;
            case -1876924466:
                if (str.equals(NoteAnnotation.NEW_PARAGRAPH)) {
                    return R.string.pspdf__note_icon_new_paragraph;
                }
                return 0;
            case -1679915457:
                if (str.equals(NoteAnnotation.COMMENT)) {
                    return R.string.pspdf__note_icon_comment;
                }
                return 0;
            case -341710514:
                if (str.equals(NoteAnnotation.PARAGRAPH)) {
                    return R.string.pspdf__note_icon_paragraph;
                }
                return 0;
            case 75327:
                if (str.equals(NoteAnnotation.KEY)) {
                    return R.string.pspdf__note_icon_key;
                }
                return 0;
            case 2245473:
                if (str.equals(NoteAnnotation.HELP)) {
                    return R.string.pspdf__note_icon_help;
                }
                return 0;
            case 2434066:
                if (str.equals(NoteAnnotation.NOTE)) {
                    return R.string.pspdf__note_icon_text_note;
                }
                return 0;
            case 2587250:
                if (str.equals(NoteAnnotation.STAR)) {
                    return R.string.pspdf__note_icon_star;
                }
                return 0;
            case 65074408:
                if (str.equals(NoteAnnotation.CHECK)) {
                    return R.string.pspdf__note_icon_checkmark;
                }
                return 0;
            case 65382432:
                if (str.equals(NoteAnnotation.CROSS)) {
                    return R.string.pspdf__note_icon_cross;
                }
                return 0;
            case 578064237:
                if (str.equals(NoteAnnotation.RIGHT_ARROW)) {
                    return R.string.pspdf__note_icon_right_arrow;
                }
                return 0;
            case 1802375329:
                if (str.equals(NoteAnnotation.RIGHT_POINTER)) {
                    return R.string.pspdf__note_icon_right_pointer;
                }
                return 0;
            case 2018617584:
                if (str.equals(NoteAnnotation.CIRCLE)) {
                    return R.string.pspdf__note_icon_circle;
                }
                return 0;
            default:
                return 0;
        }
    }

    @JvmStatic
    public static final void a(AnnotationPreferencesManager annotationPreferencesManager, Annotation annotation) {
        String annotationCreator;
        annotationPreferencesManager.getClass();
        annotation.getClass();
        if (annotation.getCreator() != null || (annotationCreator = annotationPreferencesManager.getAnnotationCreator()) == null) {
            return;
        }
        annotation.setCreator(annotationCreator);
    }
}
