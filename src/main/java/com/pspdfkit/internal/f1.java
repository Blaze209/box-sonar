package com.pspdfkit.internal;

import androidx.core.util.Pair;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.configuration.annotations.AnnotationAggregationStrategy;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f1 {
    public final j1 a;

    public f1(j1 j1Var) {
        j1Var.getClass();
        this.a = j1Var;
    }

    public final boolean customColorPickerEnabled() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.j;
        Object obj = Boolean.TRUE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final AnnotationAggregationStrategy getAnnotationAggregationStrategy() {
        j1 j1Var = this.a;
        i1<AnnotationAggregationStrategy> i1Var = i1.u;
        Object obj = AnnotationAggregationStrategy.AUTOMATIC;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (AnnotationAggregationStrategy) obj;
    }

    public final int getAudioRecordingTimeLimit() {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.G;
        Object objValueOf = Integer.valueOf(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_IN_MILISECONDS);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).intValue();
    }

    public final List<Integer> getAvailableColors() {
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.e;
        Object obj = ww.d;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (List) obj;
    }

    public final List<Integer> getAvailableFillColors() {
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.g;
        float f = ww.a;
        Object obj = ww.f;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (List) obj;
    }

    public final List<Font> getAvailableFonts() {
        j1 j1Var = this.a;
        i1<List<Font>> i1Var = i1.A;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        List<Font> list = (List) obj;
        return list == null ? ar.c().getAvailableFonts() : list;
    }

    public final List<String> getAvailableIconNames() {
        j1 j1Var = this.a;
        i1<List<String>> i1Var = i1.F;
        float f = ww.a;
        Object obj = ww.k;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (List) obj;
    }

    public final List<LineEndType> getAvailableLineEnds() {
        j1 j1Var = this.a;
        i1<List<LineEndType>> i1Var = i1.y;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        List<LineEndType> list = (List) obj;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(LineEndType.NONE);
        arrayList.add(LineEndType.SQUARE);
        arrayList.add(LineEndType.CIRCLE);
        arrayList.add(LineEndType.DIAMOND);
        arrayList.add(LineEndType.OPEN_ARROW);
        arrayList.add(LineEndType.CLOSED_ARROW);
        arrayList.add(LineEndType.BUTT);
        arrayList.add(LineEndType.REVERSE_OPEN_ARROW);
        arrayList.add(LineEndType.REVERSE_CLOSED_ARROW);
        arrayList.add(LineEndType.SLASH);
        return arrayList;
    }

    public final List<Integer> getAvailableOutlineColors() {
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.i;
        Object obj = ww.d;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (List) obj;
    }

    public final List<BorderStylePreset> getBorderStylePresets() {
        j1 j1Var = this.a;
        i1<List<BorderStylePreset>> i1Var = i1.w;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        List<BorderStylePreset> list = (List) obj;
        if (list != null) {
            return list;
        }
        List<BorderStylePreset> list2 = Collections.EMPTY_LIST;
        list2.getClass();
        return list2;
    }

    public final float getDefaultAlpha() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.q;
        Object objValueOf = Float.valueOf(1.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final BorderStylePreset getDefaultBorderStylePreset() {
        j1 j1Var = this.a;
        i1<BorderStylePreset> i1Var = i1.v;
        Object obj = BorderStylePreset.NONE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return (BorderStylePreset) obj;
    }

    public final int getDefaultColor() {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.d;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        return ((Number) (obj != null ? obj : 0)).intValue();
    }

    public final int getDefaultFillColor() {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.f;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        return ((Number) (obj != null ? obj : 0)).intValue();
    }

    public final Font getDefaultFont() {
        j1 j1Var = this.a;
        i1<Font> i1Var = i1.z;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        Font font = (Font) obj;
        return font == null ? ar.c().b() : font;
    }

    public final String getDefaultIconName() {
        j1 j1Var = this.a;
        i1<String> i1Var = i1.E;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = NoteAnnotation.NOTE;
        }
        return (String) obj;
    }

    public final Pair<LineEndType, LineEndType> getDefaultLineEnds() {
        j1 j1Var = this.a;
        i1<Pair<LineEndType, LineEndType>> i1Var = i1.x;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        Pair<LineEndType, LineEndType> pair = (Pair) obj;
        if (pair != null) {
            return pair;
        }
        LineEndType lineEndType = LineEndType.NONE;
        return new Pair<>(lineEndType, lineEndType);
    }

    public final int getDefaultOutlineColor() {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.h;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        return ((Number) (obj != null ? obj : 0)).intValue();
    }

    public final String getDefaultOverlayText() {
        j1 j1Var = this.a;
        i1<String> i1Var = i1.D;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = "";
        }
        return (String) obj;
    }

    public final MeasurementPrecision getDefaultPrecision() {
        j1 j1Var = this.a;
        i1<MeasurementPrecision> i1Var = i1.L;
        Object precision = MeasurementValueConfiguration.INSTANCE.defaultConfiguration().getPrecision();
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            precision = obj;
        }
        return (MeasurementPrecision) precision;
    }

    public final boolean getDefaultRepeatOverlayTextSetting() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.C;
        Object obj = Boolean.FALSE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final Scale getDefaultScale() {
        j1 j1Var = this.a;
        i1<Scale> i1Var = i1.K;
        Object scale = MeasurementValueConfiguration.INSTANCE.defaultConfiguration().getScale();
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            scale = obj;
        }
        return (Scale) scale;
    }

    public final float getDefaultTextSize() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.n;
        Object objValueOf = Float.valueOf(18.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getDefaultThickness() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.k;
        Object objValueOf = Float.valueOf(5.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final boolean getForceDefaults() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.b;
        Object obj = Boolean.FALSE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final float getMaxAlpha() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.s;
        Object objValueOf = Float.valueOf(1.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getMaxTextSize() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.p;
        float f = ww.a;
        Object objValueOf = Float.valueOf(ww.b);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getMaxThickness() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.m;
        Object objValueOf = Float.valueOf(40.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getMinAlpha() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.r;
        Object objValueOf = Float.valueOf(0.0f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getMinTextSize() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.o;
        float f = ww.a;
        Object objValueOf = Float.valueOf(ww.a);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final float getMinThickness() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.l;
        Object objValueOf = Float.valueOf(0.5f);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final int getRecordingSampleRate() {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.H;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        return ((Number) (obj != null ? obj : 22050)).intValue();
    }

    public final List<StampPickerItem> getStampsForPicker() {
        j1 j1Var = this.a;
        i1<List<StampPickerItem>> i1Var = i1.B;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        List<StampPickerItem> list = (List) obj;
        if (list != null) {
            return list;
        }
        List<StampPickerItem> list2 = Collections.EMPTY_LIST;
        list2.getClass();
        return list2;
    }

    public final EnumSet<AnnotationProperty> getSupportedProperties() {
        j1 j1Var = this.a;
        i1<EnumSet<AnnotationProperty>> i1Var = i1.a;
        Object objNoneOf = EnumSet.noneOf(AnnotationProperty.class);
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj != null) {
            objNoneOf = obj;
        }
        return (EnumSet) objNoneOf;
    }

    public final boolean isHorizontalResizingEnabled() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.J;
        Object obj = Boolean.TRUE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean isPreviewEnabled() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.t;
        Object obj = Boolean.TRUE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean isVerticalResizingEnabled() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.I;
        Object obj = Boolean.TRUE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean isZIndexEditingEnabled() {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.c;
        Object obj = Boolean.TRUE;
        j1Var.getClass();
        Object obj2 = j1Var.a.get(i1Var);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }
}
