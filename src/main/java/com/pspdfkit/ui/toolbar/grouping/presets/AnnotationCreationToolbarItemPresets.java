package com.pspdfkit.ui.toolbar.grouping.presets;

import com.pspdfkit.R;
import com.pspdfkit.internal.n;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u000eR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u000eR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u000eR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u000eR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u000e¨\u0006!"}, d2 = {"Lcom/pspdfkit/ui/toolbar/grouping/presets/AnnotationCreationToolbarItemPresets;", "", "<init>", "()V", "", "capacity", "Ljava/util/EnumSet;", "Lcom/pspdfkit/internal/n;", "features", "", "Lcom/pspdfkit/ui/toolbar/grouping/presets/MenuItem;", "getPreset", "(ILjava/util/EnumSet;)Ljava/util/List;", "createMeasurementFourItemsGrouping", "()Ljava/util/List;", "createMeasurementFiveItemsGrouping", "createMeasurementSixItemsGrouping", "createMeasurementSevenItemsGrouping", "createMeasurementEightItemsGrouping", "createMeasurementNineItemsGrouping", "FOUR_ITEMS_GROUPING", "Ljava/util/List;", "getFOUR_ITEMS_GROUPING", "FIVE_ITEMS_GROUPING", "getFIVE_ITEMS_GROUPING", "SIX_ITEMS_GROUPING", "getSIX_ITEMS_GROUPING", "SEVEN_ITEMS_GROUPING", "getSEVEN_ITEMS_GROUPING", "EIGHT_ITEMS_GROUPING", "getEIGHT_ITEMS_GROUPING", "ALL_ITEMS_GROUPING", "getALL_ITEMS_GROUPING", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationCreationToolbarItemPresets {
    public static final int $stable;
    private static final List<MenuItem> ALL_ITEMS_GROUPING;
    private static final List<MenuItem> EIGHT_ITEMS_GROUPING;
    private static final List<MenuItem> FIVE_ITEMS_GROUPING;
    private static final List<MenuItem> FOUR_ITEMS_GROUPING;
    public static final AnnotationCreationToolbarItemPresets INSTANCE = new AnnotationCreationToolbarItemPresets();
    private static final List<MenuItem> SEVEN_ITEMS_GROUPING;
    private static final List<MenuItem> SIX_ITEMS_GROUPING;

    static {
        ArrayList arrayList = new ArrayList(4);
        FOUR_ITEMS_GROUPING = arrayList;
        ArrayList arrayList2 = new ArrayList(5);
        FIVE_ITEMS_GROUPING = arrayList2;
        ArrayList arrayList3 = new ArrayList(6);
        SIX_ITEMS_GROUPING = arrayList3;
        ArrayList arrayList4 = new ArrayList(7);
        SEVEN_ITEMS_GROUPING = arrayList4;
        ArrayList arrayList5 = new ArrayList(8);
        EIGHT_ITEMS_GROUPING = arrayList5;
        ArrayList arrayList6 = new ArrayList(32);
        ALL_ITEMS_GROUPING = arrayList6;
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP_EXTRA);
        MenuItem menuItem = AnnotationCreationToolbarItemGroups.DRAWING_GROUP;
        arrayList.add(menuItem);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        MenuItem menuItem2 = AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP;
        arrayList.add(menuItem2);
        MenuItem menuItem3 = AnnotationCreationToolbarItemGroups.MARKUP_GROUP;
        arrayList2.add(menuItem3);
        arrayList2.add(AnnotationCreationToolbarItemGroups.WRITING_AND_MULTIMEDIA_GROUP);
        arrayList2.add(menuItem);
        arrayList2.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList2.add(menuItem2);
        arrayList3.add(menuItem3);
        MenuItem menuItem4 = AnnotationCreationToolbarItemGroups.WRITING_GROUP;
        arrayList3.add(menuItem4);
        arrayList3.add(menuItem);
        MenuItem menuItem5 = AnnotationCreationToolbarItemGroups.MULTIMEDIA_GROUP;
        arrayList3.add(menuItem5);
        arrayList3.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList3.add(menuItem2);
        arrayList4.add(menuItem3);
        arrayList4.add(menuItem4);
        MenuItem menuItem6 = AnnotationCreationToolbarItemGroups.DRAWING_GROUP_NO_ERASER;
        arrayList4.add(menuItem6);
        arrayList4.add(menuItem5);
        arrayList4.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList4.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList4.add(menuItem2);
        arrayList5.add(menuItem3);
        arrayList5.add(menuItem4);
        arrayList5.add(menuItem6);
        arrayList5.add(menuItem5);
        arrayList5.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList5.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList5.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_undo));
        arrayList5.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_redo));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_highlight));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_squiggly));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_strikeout));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_underline));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_redaction));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_note));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_instant_comment_marker));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_freetext));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_freetext_callout));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_signature));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_ink_pen));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_ink_highlighter));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_magic_ink));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_line));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_line_arrow));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_square));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_circle));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_polygon));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_cloudy));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_polyline));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_image));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_stamp));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_camera));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_sound));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_multi_selection));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_undo));
        arrayList6.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_redo));
        $stable = 8;
    }

    private AnnotationCreationToolbarItemPresets() {
    }

    private final List<MenuItem> createMeasurementEightItemsGrouping() {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.WRITING_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP_NO_ERASER);
        arrayList.add(AnnotationCreationToolbarItemGroups.MEASUREMENTS_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.MULTIMEDIA_GROUP);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP);
        return arrayList;
    }

    private final List<MenuItem> createMeasurementFiveItemsGrouping() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP_EXTRA);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.MEASUREMENTS_GROUP);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP);
        return arrayList;
    }

    private final List<MenuItem> createMeasurementFourItemsGrouping() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP_EXTRA);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP_PLUS_MEASUREMENTS);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP);
        return arrayList;
    }

    private final List<MenuItem> createMeasurementNineItemsGrouping() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.WRITING_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP_NO_ERASER);
        arrayList.add(AnnotationCreationToolbarItemGroups.MEASUREMENTS_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.MULTIMEDIA_GROUP);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_undo));
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_redo));
        return arrayList;
    }

    private final List<MenuItem> createMeasurementSevenItemsGrouping() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.WRITING_AND_MULTIMEDIA_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP_NO_ERASER);
        arrayList.add(AnnotationCreationToolbarItemGroups.MEASUREMENTS_GROUP);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_eraser));
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP);
        return arrayList;
    }

    private final List<MenuItem> createMeasurementSixItemsGrouping() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(AnnotationCreationToolbarItemGroups.MARKUP_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.WRITING_AND_MULTIMEDIA_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.DRAWING_GROUP);
        arrayList.add(AnnotationCreationToolbarItemGroups.MEASUREMENTS_GROUP);
        arrayList.add(new MenuItem(R.id.pspdf__annotation_toolbar_item_picker));
        arrayList.add(AnnotationCreationToolbarItemGroups.UNDO_REDO_GROUP);
        return arrayList;
    }

    @JvmStatic
    public static final List<MenuItem> getPreset(int capacity, EnumSet<n> features) {
        features.getClass();
        if (features.contains(n.MEASUREMENT_TOOLS)) {
            switch (capacity) {
                case 4:
                    return INSTANCE.createMeasurementFourItemsGrouping();
                case 5:
                    return INSTANCE.createMeasurementFiveItemsGrouping();
                case 6:
                    return INSTANCE.createMeasurementSixItemsGrouping();
                case 7:
                    return INSTANCE.createMeasurementSevenItemsGrouping();
                case 8:
                    return INSTANCE.createMeasurementEightItemsGrouping();
                default:
                    return INSTANCE.createMeasurementNineItemsGrouping();
            }
        }
        if (capacity == 4) {
            return FOUR_ITEMS_GROUPING;
        }
        if (capacity == 5) {
            return FIVE_ITEMS_GROUPING;
        }
        if (capacity != 6) {
            return capacity != 7 ? EIGHT_ITEMS_GROUPING : SEVEN_ITEMS_GROUPING;
        }
        return SIX_ITEMS_GROUPING;
    }

    public final List<MenuItem> getALL_ITEMS_GROUPING() {
        return ALL_ITEMS_GROUPING;
    }

    public final List<MenuItem> getEIGHT_ITEMS_GROUPING() {
        return EIGHT_ITEMS_GROUPING;
    }

    public final List<MenuItem> getFIVE_ITEMS_GROUPING() {
        return FIVE_ITEMS_GROUPING;
    }

    public final List<MenuItem> getFOUR_ITEMS_GROUPING() {
        return FOUR_ITEMS_GROUPING;
    }

    public final List<MenuItem> getSEVEN_ITEMS_GROUPING() {
        return SEVEN_ITEMS_GROUPING;
    }

    public final List<MenuItem> getSIX_ITEMS_GROUPING() {
        return SIX_ITEMS_GROUPING;
    }
}
