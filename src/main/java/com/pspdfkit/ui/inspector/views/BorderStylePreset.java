package com.pspdfkit.ui.inspector.views;

import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class BorderStylePreset {
    public static final BorderStylePreset CLOUDY;
    public static final BorderStylePreset DASHED_1_1;
    public static final BorderStylePreset DASHED_1_3;
    public static final BorderStylePreset DASHED_3_3;
    public static final BorderStylePreset DASHED_6_6;
    public static final BorderStylePreset NONE = new BorderStylePreset(BorderStyle.NONE);
    public static final BorderStylePreset SOLID;
    private final BorderEffect borderEffect;
    private final float borderEffectIntensity;
    private final BorderStyle borderStyle;
    private final List<Integer> dashArray;

    static {
        BorderStyle borderStyle = BorderStyle.SOLID;
        SOLID = new BorderStylePreset(borderStyle);
        CLOUDY = new BorderStylePreset(borderStyle, BorderEffect.CLOUDY, null);
        BorderStyle borderStyle2 = BorderStyle.DASHED;
        DASHED_1_1 = new BorderStylePreset(borderStyle2, Arrays.asList(1, 1));
        DASHED_1_3 = new BorderStylePreset(borderStyle2, Arrays.asList(1, 3));
        DASHED_3_3 = new BorderStylePreset(borderStyle2, Arrays.asList(3, 3));
        DASHED_6_6 = new BorderStylePreset(borderStyle2, Arrays.asList(6, 6));
    }

    public BorderStylePreset(BorderStyle borderStyle) {
        this(borderStyle, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStylePreset)) {
            return false;
        }
        BorderStylePreset borderStylePreset = (BorderStylePreset) obj;
        return Float.compare(borderStylePreset.borderEffectIntensity, this.borderEffectIntensity) == 0 && this.borderStyle == borderStylePreset.borderStyle && this.borderEffect == borderStylePreset.borderEffect && Objects.equals(this.dashArray, borderStylePreset.dashArray);
    }

    public BorderEffect getBorderEffect() {
        return this.borderEffect;
    }

    public float getBorderEffectIntensity() {
        return this.borderEffectIntensity;
    }

    public BorderStyle getBorderStyle() {
        return this.borderStyle;
    }

    public List<Integer> getDashArray() {
        List<Integer> list = this.dashArray;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    public boolean hasBorder() {
        return (this.borderStyle == BorderStyle.NONE && this.borderEffect == BorderEffect.NO_EFFECT) ? false : true;
    }

    public int hashCode() {
        return Objects.hash(this.borderStyle, this.borderEffect, Float.valueOf(this.borderEffectIntensity), this.dashArray);
    }

    public BorderStylePreset(BorderStyle borderStyle, List<Integer> list) {
        this(borderStyle, BorderEffect.NO_EFFECT, list);
    }

    public BorderStylePreset(BorderStyle borderStyle, BorderEffect borderEffect, List<Integer> list) {
        this(borderStyle, borderEffect, borderEffect == BorderEffect.CLOUDY ? 2.0f : 0.0f, list);
    }

    public BorderStylePreset(BorderStyle borderStyle, BorderEffect borderEffect, float f, List<Integer> list) {
        if (borderStyle == BorderStyle.DASHED && (list == null || list.isEmpty())) {
            throw new IllegalArgumentException("You need to specify non-empty dash array when using DASHED border style.");
        }
        uw.a(borderStyle, "borderStyle", null);
        uw.a(borderEffect, "borderEffect", null);
        this.borderStyle = borderStyle;
        this.borderEffect = borderEffect;
        this.borderEffectIntensity = f;
        this.dashArray = list != null ? new ArrayList(list) : null;
    }
}
