package com.pspdfkit.ui.toolbar;

import com.pspdfkit.R;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PEN_ITEM' uses external variables
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
final class AnnotationCreationToolMenuItem {
    private static final /* synthetic */ AnnotationCreationToolMenuItem[] $VALUES;
    public static final AnnotationCreationToolMenuItem ANNOTATION_MULTI_SELECTION_ITEM;
    public static final AnnotationCreationToolMenuItem ARROW_ITEM;
    public static final AnnotationCreationToolMenuItem CAMERA_ITEM;
    public static final AnnotationCreationToolMenuItem CIRCLE_ITEM;
    public static final AnnotationCreationToolMenuItem CLOUDY_CIRCLE_ITEM;
    public static final AnnotationCreationToolMenuItem CLOUDY_ITEM;
    public static final AnnotationCreationToolMenuItem CLOUDY_POLYGON_ITEM;
    public static final AnnotationCreationToolMenuItem CLOUDY_SQUARE_ITEM;
    public static final AnnotationCreationToolMenuItem DASHED_CIRCLE_ITEM;
    public static final AnnotationCreationToolMenuItem DASHED_POLYGON_ITEM;
    public static final AnnotationCreationToolMenuItem DASHED_SQUARE_ITEM;
    public static final AnnotationCreationToolMenuItem ERASER_ITEM;
    public static final AnnotationCreationToolMenuItem HIGHLIGHTER;
    public static final AnnotationCreationToolMenuItem IMAGE_ITEM;
    public static final AnnotationCreationToolMenuItem INSTANT_COMMENT_MARKER_ITEM;
    public static final AnnotationCreationToolMenuItem INSTANT_HIGHLIGHT_COMMENT_ITEM;
    public static final AnnotationCreationToolMenuItem LINE_ITEM;
    public static final AnnotationCreationToolMenuItem MAGIC_INK_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_AREA_ELLIPSE_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_AREA_POLYGON_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_AREA_RECT_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_DISTANCE_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_PERIMETER_ITEM;
    public static final AnnotationCreationToolMenuItem MEASUREMENT_SCALE_CALIBRATION_ITEM;
    public static final AnnotationCreationToolMenuItem PEN_ITEM;
    public static final AnnotationCreationToolMenuItem POLYGON_ITEM;
    public static final AnnotationCreationToolMenuItem POLYLINE_ITEM;
    public static final AnnotationCreationToolMenuItem REDACTION_ITEM;
    public static final AnnotationCreationToolMenuItem SOUND_ITEM;
    public static final AnnotationCreationToolMenuItem SQUARE_ITEM;
    public static final AnnotationCreationToolMenuItem STAMP_ITEM;
    final AnnotationTool annotationTool;
    final AnnotationToolVariant annotationToolVariant;
    final int drawableId;
    final int id;
    final boolean isStyleIndicatorEnabled;
    final int stringId;
    final int styleableId;
    public static final AnnotationCreationToolMenuItem HIGHLIGHT_ITEM = new AnnotationCreationToolMenuItem("HIGHLIGHT_ITEM", 0, AnnotationTool.HIGHLIGHT, R.id.pspdf__annotation_toolbar_item_highlight, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__highlightIcon, R.drawable.pspdf__ic_highlight, R.string.pspdf__edit_menu_highlight);
    public static final AnnotationCreationToolMenuItem SQUIGGLY_ITEM = new AnnotationCreationToolMenuItem("SQUIGGLY_ITEM", 1, AnnotationTool.SQUIGGLY, R.id.pspdf__annotation_toolbar_item_squiggly, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__squigglyIcon, R.drawable.pspdf__ic_squiggly, R.string.pspdf__edit_menu_squiggly);
    public static final AnnotationCreationToolMenuItem STRIKEOUT_ITEM = new AnnotationCreationToolMenuItem("STRIKEOUT_ITEM", 2, AnnotationTool.STRIKEOUT, R.id.pspdf__annotation_toolbar_item_strikeout, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__strikeoutIcon, R.drawable.pspdf__ic_strikeout, R.string.pspdf__edit_menu_strikeout);
    public static final AnnotationCreationToolMenuItem UNDERLINE_ITEM = new AnnotationCreationToolMenuItem("UNDERLINE_ITEM", 3, AnnotationTool.UNDERLINE, R.id.pspdf__annotation_toolbar_item_underline, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__underlineIcon, R.drawable.pspdf__ic_underline, R.string.pspdf__edit_menu_underline);
    public static final AnnotationCreationToolMenuItem NOTE_ITEM = new AnnotationCreationToolMenuItem("NOTE_ITEM", 4, AnnotationTool.NOTE, R.id.pspdf__annotation_toolbar_item_note, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__noteIcon, R.drawable.pspdf__ic_note, R.string.pspdf__edit_menu_note);
    public static final AnnotationCreationToolMenuItem FREETEXT_ITEM = new AnnotationCreationToolMenuItem("FREETEXT_ITEM", 5, AnnotationTool.FREETEXT, R.id.pspdf__annotation_toolbar_item_freetext, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__freeTextIcon, R.drawable.pspdf__ic_freetext, R.string.pspdf__edit_menu_freetext);
    public static final AnnotationCreationToolMenuItem FREETEXT_CALLOUT_ITEM = new AnnotationCreationToolMenuItem("FREETEXT_CALLOUT_ITEM", 6, AnnotationTool.FREETEXT_CALLOUT, R.id.pspdf__annotation_toolbar_item_freetext_callout, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__freeTextCalloutIcon, R.drawable.pspdf__ic_freetext_callout, R.string.pspdf__edit_menu_callout, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.CALLOUT), false);
    public static final AnnotationCreationToolMenuItem SIGNATURE_ITEM = new AnnotationCreationToolMenuItem("SIGNATURE_ITEM", 7, AnnotationTool.SIGNATURE, R.id.pspdf__annotation_toolbar_item_signature, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__signatureIcon, R.drawable.pspdf__ic_signature, R.string.pspdf__signature);

    private static /* synthetic */ AnnotationCreationToolMenuItem[] $values() {
        return new AnnotationCreationToolMenuItem[]{HIGHLIGHT_ITEM, SQUIGGLY_ITEM, STRIKEOUT_ITEM, UNDERLINE_ITEM, NOTE_ITEM, FREETEXT_ITEM, FREETEXT_CALLOUT_ITEM, SIGNATURE_ITEM, PEN_ITEM, HIGHLIGHTER, MAGIC_INK_ITEM, LINE_ITEM, ARROW_ITEM, SQUARE_ITEM, DASHED_SQUARE_ITEM, CLOUDY_SQUARE_ITEM, CIRCLE_ITEM, DASHED_CIRCLE_ITEM, CLOUDY_CIRCLE_ITEM, POLYGON_ITEM, DASHED_POLYGON_ITEM, CLOUDY_POLYGON_ITEM, CLOUDY_ITEM, POLYLINE_ITEM, IMAGE_ITEM, CAMERA_ITEM, STAMP_ITEM, ERASER_ITEM, REDACTION_ITEM, SOUND_ITEM, INSTANT_COMMENT_MARKER_ITEM, INSTANT_HIGHLIGHT_COMMENT_ITEM, MEASUREMENT_DISTANCE_ITEM, MEASUREMENT_PERIMETER_ITEM, MEASUREMENT_AREA_POLYGON_ITEM, MEASUREMENT_AREA_ELLIPSE_ITEM, MEASUREMENT_AREA_RECT_ITEM, MEASUREMENT_SCALE_CALIBRATION_ITEM, ANNOTATION_MULTI_SELECTION_ITEM};
    }

    static {
        AnnotationTool annotationTool = AnnotationTool.INK;
        PEN_ITEM = new AnnotationCreationToolMenuItem("PEN_ITEM", 8, annotationTool, R.id.pspdf__annotation_toolbar_item_ink_pen, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__inkPenIcon, R.drawable.pspdf__ic_stylus, R.string.pspdf__edit_menu_ink_pen, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.PEN), true);
        HIGHLIGHTER = new AnnotationCreationToolMenuItem("HIGHLIGHTER", 9, annotationTool, R.id.pspdf__annotation_toolbar_item_ink_highlighter, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__inkHighlighterIcon, R.drawable.pspdf__ic_ink_highlighter, R.string.pspdf__edit_menu_ink_highlighter, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.HIGHLIGHTER), true);
        MAGIC_INK_ITEM = new AnnotationCreationToolMenuItem("MAGIC_INK_ITEM", 10, AnnotationTool.MAGIC_INK, R.id.pspdf__annotation_toolbar_item_magic_ink, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__magicInkIcon, R.drawable.pspdf__ic_magic_ink, R.string.pspdf__edit_menu_magic_ink, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.MAGIC), false);
        AnnotationTool annotationTool2 = AnnotationTool.LINE;
        LINE_ITEM = new AnnotationCreationToolMenuItem("LINE_ITEM", 11, annotationTool2, R.id.pspdf__annotation_toolbar_item_line, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__lineIcon, R.drawable.pspdf__ic_line, R.string.pspdf__annotation_type_line);
        ARROW_ITEM = new AnnotationCreationToolMenuItem("ARROW_ITEM", 12, annotationTool2, R.id.pspdf__annotation_toolbar_item_line_arrow, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__lineArrowIcon, R.drawable.pspdf__ic_line_arrow, R.string.pspdf__edit_menu_line_arrow, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.ARROW), false);
        AnnotationTool annotationTool3 = AnnotationTool.SQUARE;
        SQUARE_ITEM = new AnnotationCreationToolMenuItem("SQUARE_ITEM", 13, annotationTool3, R.id.pspdf__annotation_toolbar_item_square, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__squareIcon, R.drawable.pspdf__ic_square, R.string.pspdf__annotation_type_square);
        int i = R.id.pspdf__annotation_toolbar_item_dashed_square;
        int i2 = R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__dashedSquareIcon;
        int i3 = R.drawable.pspdf__ic_dashed_square;
        int i4 = R.string.pspdf__annotation_type_dashed_rectangle;
        AnnotationToolVariant.Preset preset = AnnotationToolVariant.Preset.DASHED;
        DASHED_SQUARE_ITEM = new AnnotationCreationToolMenuItem("DASHED_SQUARE_ITEM", 14, annotationTool3, i, i2, i3, i4, AnnotationToolVariant.fromPreset(preset), false);
        int i5 = R.id.pspdf__annotation_toolbar_item_cloudy_square;
        int i6 = R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__cloudySquareIcon;
        int i7 = R.drawable.pspdf__ic_cloudy_square;
        int i8 = R.string.pspdf__annotation_type_cloudy_rectangle;
        AnnotationToolVariant.Preset preset2 = AnnotationToolVariant.Preset.CLOUDY;
        CLOUDY_SQUARE_ITEM = new AnnotationCreationToolMenuItem("CLOUDY_SQUARE_ITEM", 15, annotationTool3, i5, i6, i7, i8, AnnotationToolVariant.fromPreset(preset2), false);
        AnnotationTool annotationTool4 = AnnotationTool.CIRCLE;
        CIRCLE_ITEM = new AnnotationCreationToolMenuItem("CIRCLE_ITEM", 16, annotationTool4, R.id.pspdf__annotation_toolbar_item_circle, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__circleIcon, R.drawable.pspdf__ic_circle, R.string.pspdf__annotation_type_circle);
        DASHED_CIRCLE_ITEM = new AnnotationCreationToolMenuItem("DASHED_CIRCLE_ITEM", 17, annotationTool4, R.id.pspdf__annotation_toolbar_item_dashed_circle, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__dashedCircleIcon, R.drawable.pspdf__ic_dashed_circle, R.string.pspdf__annotation_type_dashed_ellipse, AnnotationToolVariant.fromPreset(preset), false);
        CLOUDY_CIRCLE_ITEM = new AnnotationCreationToolMenuItem("CLOUDY_CIRCLE_ITEM", 18, annotationTool4, R.id.pspdf__annotation_toolbar_item_cloudy_circle, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__cloudyCircleIcon, R.drawable.pspdf__ic_cloudy_circle, R.string.pspdf__annotation_type_cloudy_ellipse, AnnotationToolVariant.fromPreset(preset2), false);
        AnnotationTool annotationTool5 = AnnotationTool.POLYGON;
        POLYGON_ITEM = new AnnotationCreationToolMenuItem("POLYGON_ITEM", 19, annotationTool5, R.id.pspdf__annotation_toolbar_item_polygon, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__polygonIcon, R.drawable.pspdf__ic_polygon, R.string.pspdf__annotation_type_polygon);
        DASHED_POLYGON_ITEM = new AnnotationCreationToolMenuItem("DASHED_POLYGON_ITEM", 20, annotationTool5, R.id.pspdf__annotation_toolbar_item_dashed_polygon, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__dashedPolygonIcon, R.drawable.pspdf__ic_dashed_polygon, R.string.pspdf__annotation_type_dashed_polygon, AnnotationToolVariant.fromPreset(preset), false);
        CLOUDY_POLYGON_ITEM = new AnnotationCreationToolMenuItem("CLOUDY_POLYGON_ITEM", 21, annotationTool5, R.id.pspdf__annotation_toolbar_item_cloudy_polygon, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__cloudyPolygonIcon, R.drawable.pspdf__ic_cloudy_polygon, R.string.pspdf__annotation_type_cloudy_polygon, AnnotationToolVariant.fromPreset(preset2), false);
        CLOUDY_ITEM = new AnnotationCreationToolMenuItem("CLOUDY_ITEM", 22, annotationTool5, R.id.pspdf__annotation_toolbar_item_cloudy, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__cloudyPolygonIcon, R.drawable.pspdf__ic_cloudy_polygon, R.string.pspdf__annotation_type_cloudy, AnnotationToolVariant.fromPreset(preset2), false);
        POLYLINE_ITEM = new AnnotationCreationToolMenuItem("POLYLINE_ITEM", 23, AnnotationTool.POLYLINE, R.id.pspdf__annotation_toolbar_item_polyline, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__polylineIcon, R.drawable.pspdf__ic_polyline, R.string.pspdf__annotation_type_polyline);
        IMAGE_ITEM = new AnnotationCreationToolMenuItem("IMAGE_ITEM", 24, AnnotationTool.IMAGE, R.id.pspdf__annotation_toolbar_item_image, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__imageIcon, R.drawable.pspdf__ic_image, R.string.pspdf__gallery_item_img_desc);
        CAMERA_ITEM = new AnnotationCreationToolMenuItem("CAMERA_ITEM", 25, AnnotationTool.CAMERA, R.id.pspdf__annotation_toolbar_item_camera, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__cameraIcon, R.drawable.pspdf__ic_camera, R.string.pspdf__annotation_type_camera);
        STAMP_ITEM = new AnnotationCreationToolMenuItem("STAMP_ITEM", 26, AnnotationTool.STAMP, R.id.pspdf__annotation_toolbar_item_stamp, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__stampIcon, R.drawable.pspdf__ic_stamp, R.string.pspdf__annotation_type_stamp);
        ERASER_ITEM = new AnnotationCreationToolMenuItem("ERASER_ITEM", 27, AnnotationTool.ERASER, R.id.pspdf__annotation_toolbar_item_eraser, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__eraserIcon, R.drawable.pspdf__ic_eraser, R.string.pspdf__annotation_type_eraser);
        REDACTION_ITEM = new AnnotationCreationToolMenuItem("REDACTION_ITEM", 28, AnnotationTool.REDACTION, R.id.pspdf__annotation_toolbar_item_redaction, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__redactionIcon, R.drawable.pspdf__ic_redaction, R.string.pspdf__annotation_type_redaction);
        SOUND_ITEM = new AnnotationCreationToolMenuItem("SOUND_ITEM", 29, AnnotationTool.SOUND, R.id.pspdf__annotation_toolbar_item_sound, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__soundIcon, R.drawable.pspdf__ic_sound, R.string.pspdf__annotation_type_sound);
        INSTANT_COMMENT_MARKER_ITEM = new AnnotationCreationToolMenuItem("INSTANT_COMMENT_MARKER_ITEM", 30, AnnotationTool.INSTANT_COMMENT_MARKER, R.id.pspdf__annotation_toolbar_item_instant_comment_marker, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__instantCommentIcon, R.drawable.pspdf__ic_instant_comment, R.string.pspdf__annotation_type_instantComments);
        INSTANT_HIGHLIGHT_COMMENT_ITEM = new AnnotationCreationToolMenuItem("INSTANT_HIGHLIGHT_COMMENT_ITEM", 31, AnnotationTool.INSTANT_HIGHLIGHT_COMMENT, R.id.pspdf__annotation_toolbar_item_instant_highlight_comment, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__instantCommentIcon, R.drawable.pspdf__ic_instant_comment, R.string.pspdf__annotation_type_instantComments);
        MEASUREMENT_DISTANCE_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_DISTANCE_ITEM", 32, AnnotationTool.MEASUREMENT_DISTANCE, R.id.pspdf__annotation_toolbar_item_measurement_distance, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementDistanceIcon, R.drawable.pspdf__ic_measurement_distance, R.string.pspdf__annotation_type_measure_distance);
        MEASUREMENT_PERIMETER_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_PERIMETER_ITEM", 33, AnnotationTool.MEASUREMENT_PERIMETER, R.id.pspdf__annotation_toolbar_item_measurement_perimeter, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementPerimeterIcon, R.drawable.pspdf__ic_measurement_perimeter, R.string.pspdf__annotation_type_measure_perimeter);
        MEASUREMENT_AREA_POLYGON_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_AREA_POLYGON_ITEM", 34, AnnotationTool.MEASUREMENT_AREA_POLYGON, R.id.pspdf__annotation_toolbar_item_measurement_area_polygon, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementAreaPolygonIcon, R.drawable.pspdf__ic_measurement_area_polygon, R.string.pspdf__annotation_type_measure_polygonal_area);
        MEASUREMENT_AREA_ELLIPSE_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_AREA_ELLIPSE_ITEM", 35, AnnotationTool.MEASUREMENT_AREA_ELLIPSE, R.id.pspdf__annotation_toolbar_item_measurement_area_ellipse, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementAreaEllipseIcon, R.drawable.pspdf__ic_measurement_area_ellipse, R.string.pspdf__annotation_type_measure_elliptical_area);
        MEASUREMENT_AREA_RECT_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_AREA_RECT_ITEM", 36, AnnotationTool.MEASUREMENT_AREA_RECT, R.id.pspdf__annotation_toolbar_item_measurement_area_rect, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementAreaRectIcon, R.drawable.pspdf__ic_measurement_area_rectangle, R.string.pspdf__annotation_type_measure_rectangular_area);
        MEASUREMENT_SCALE_CALIBRATION_ITEM = new AnnotationCreationToolMenuItem("MEASUREMENT_SCALE_CALIBRATION_ITEM", 37, AnnotationTool.MEASUREMENT_SCALE_CALIBRATION, R.id.pspdf__annotation_toolbar_item_measurement_scale_calibration, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__measurementScaleCalibrationIcon, R.drawable.pspdf__ic_calibrate, R.string.pspdf__picker_calibrate);
        ANNOTATION_MULTI_SELECTION_ITEM = new AnnotationCreationToolMenuItem("ANNOTATION_MULTI_SELECTION_ITEM", 38, AnnotationTool.ANNOTATION_MULTI_SELECTION, R.id.pspdf__annotation_toolbar_item_multi_selection, R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__annotationMultiSelectionIcon, R.drawable.pspdf__ic_annotation_selection, R.string.pspdf__selection_tool);
        $VALUES = $values();
    }

    private AnnotationCreationToolMenuItem(String str, int i, AnnotationTool annotationTool, int i2, int i3, int i4, int i5) {
        this(str, i, annotationTool, i2, i3, i4, i5, AnnotationToolVariant.defaultVariant(), false);
    }

    public static AnnotationCreationToolMenuItem valueOf(String str) {
        return (AnnotationCreationToolMenuItem) Enum.valueOf(AnnotationCreationToolMenuItem.class, str);
    }

    public static AnnotationCreationToolMenuItem[] values() {
        return (AnnotationCreationToolMenuItem[]) $VALUES.clone();
    }

    private AnnotationCreationToolMenuItem(String str, int i, AnnotationTool annotationTool, int i2, int i3, int i4, int i5, AnnotationToolVariant annotationToolVariant, boolean z) {
        super(str, i);
        this.annotationTool = annotationTool;
        this.id = i2;
        this.styleableId = i3;
        this.drawableId = i4;
        this.stringId = i5;
        this.annotationToolVariant = annotationToolVariant;
        this.isStyleIndicatorEnabled = z;
    }
}
