package com.pspdfkit.internal;

import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.configuration.AnnotationAggregationStrategyConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder;
import com.pspdfkit.annotations.configuration.AnnotationFontConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationNoteIconConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationPrecisionConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationPreviewConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.AnnotationScaleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationTextResizingConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.configuration.annotations.AnnotationAggregationStrategy;
import com.pspdfkit.ui.fonts.Font;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g1<T extends AnnotationConfiguration.Builder<T>> implements AnnotationConfiguration.Builder<T>, AnnotationAlphaConfiguration.Builder<T>, AnnotationThicknessConfiguration.Builder<T>, AnnotationPreviewConfiguration.Builder<T>, AnnotationAggregationStrategyConfiguration.Builder<T>, AnnotationTextSizeConfiguration.Builder<T>, AnnotationLineEndsConfiguration.Builder<T>, AnnotationFontConfiguration.Builder<T>, AnnotationOverlayTextConfiguration.Builder<T>, AnnotationNoteIconConfiguration.Builder<T>, AnnotationTextResizingConfiguration.Builder<T>, AnnotationScaleConfiguration.Builder<T>, AnnotationPrecisionConfiguration.Builder<T> {
    public final j1 a = new j1();
    public EnumSet<AnnotationProperty> b;

    public g1(AnnotationProperty... annotationPropertyArr) {
        if (annotationPropertyArr.length == 0) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(AnnotationProperty.class);
            enumSetNoneOf.getClass();
            setSupportedProperties(enumSetNoneOf);
        } else {
            EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) ArraysKt.toList(annotationPropertyArr));
            enumSetCopyOf.getClass();
            setSupportedProperties(enumSetCopyOf);
        }
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final Object disableProperty(AnnotationProperty annotationProperty) {
        annotationProperty.getClass();
        EnumSet<AnnotationProperty> enumSet = this.b;
        EnumSet<AnnotationProperty> enumSet2 = null;
        if (enumSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supportedProperties");
            enumSet = null;
        }
        if (enumSet.remove(annotationProperty)) {
            j1 j1Var = this.a;
            i1<EnumSet<AnnotationProperty>> i1Var = i1.a;
            EnumSet<AnnotationProperty> enumSet3 = this.b;
            if (enumSet3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("supportedProperties");
            } else {
                enumSet2 = enumSet3;
            }
            j1Var.getClass();
            HashMap<i1<?>, Object> map = j1Var.a;
            enumSet2.getClass();
            map.put(i1Var, enumSet2);
        }
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationAggregationStrategyConfiguration.Builder
    public final Object setAnnotationAggregationStrategy(AnnotationAggregationStrategy annotationAggregationStrategy) {
        annotationAggregationStrategy.getClass();
        j1 j1Var = this.a;
        i1<AnnotationAggregationStrategy> i1Var = i1.u;
        j1Var.getClass();
        j1Var.a.put(i1Var, annotationAggregationStrategy);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationFontConfiguration.Builder
    public final Object setAvailableFonts(List list) {
        list.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("availableFonts may not contain null item");
            }
        }
        j1 j1Var = this.a;
        i1<List<Font>> i1Var = i1.A;
        ArrayList arrayList = new ArrayList(list);
        j1Var.getClass();
        j1Var.a.put(i1Var, arrayList);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationNoteIconConfiguration.Builder
    public final Object setAvailableIconNames(List list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<String>> i1Var = i1.F;
        j1Var.getClass();
        j1Var.a.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration.Builder
    public final Object setAvailableLineEnds(List list) {
        list.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("availableLineEnds may not contain null item");
            }
        }
        j1 j1Var = this.a;
        i1<List<LineEndType>> i1Var = i1.y;
        j1Var.getClass();
        j1Var.a.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration.Builder
    public final Object setDefaultAlpha(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.q;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationFontConfiguration.Builder
    public final Object setDefaultFont(Font font) {
        font.getClass();
        j1 j1Var = this.a;
        i1<Font> i1Var = i1.z;
        j1Var.getClass();
        j1Var.a.put(i1Var, font);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationNoteIconConfiguration.Builder
    public final Object setDefaultIconName(String str) {
        str.getClass();
        j1 j1Var = this.a;
        i1<String> i1Var = i1.E;
        j1Var.getClass();
        j1Var.a.put(i1Var, str);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration.Builder
    public final Object setDefaultLineEnds(Pair pair) {
        pair.getClass();
        j1 j1Var = this.a;
        i1<Pair<LineEndType, LineEndType>> i1Var = i1.x;
        j1Var.getClass();
        j1Var.a.put(i1Var, pair);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration.Builder
    public final Object setDefaultOverlayText(String str) {
        str.getClass();
        j1 j1Var = this.a;
        i1<String> i1Var = i1.D;
        j1Var.getClass();
        j1Var.a.put(i1Var, str);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationPrecisionConfiguration.Builder
    public final Object setDefaultPrecision(MeasurementPrecision measurementPrecision) {
        measurementPrecision.getClass();
        j1 j1Var = this.a;
        i1<MeasurementPrecision> i1Var = i1.L;
        j1Var.getClass();
        j1Var.a.put(i1Var, measurementPrecision);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration.Builder
    public final Object setDefaultRepeatOverlayTextSetting(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.C;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationScaleConfiguration.Builder
    public final Object setDefaultScale(Scale scale) {
        scale.getClass();
        j1 j1Var = this.a;
        i1<Scale> i1Var = i1.K;
        j1Var.getClass();
        j1Var.a.put(i1Var, scale);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration.Builder
    public final Object setDefaultTextSize(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.n;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration.Builder
    public final Object setDefaultThickness(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.k;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final Object setForceDefaults(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.b;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationTextResizingConfiguration.Builder
    public final Object setHorizontalResizingEnabled(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.J;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration.Builder
    public final Object setMaxAlpha(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.s;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration.Builder
    public final Object setMaxTextSize(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.p;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration.Builder
    public final Object setMaxThickness(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.m;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration.Builder
    public final Object setMinAlpha(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.r;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration.Builder
    public final Object setMinTextSize(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.o;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration.Builder
    public final Object setMinThickness(float f) {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.l;
        Float fValueOf = Float.valueOf(f);
        j1Var.getClass();
        j1Var.a.put(i1Var, fValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationPreviewConfiguration.Builder
    public final Object setPreviewEnabled(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.t;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationTextResizingConfiguration.Builder
    public final Object setVerticalResizingEnabled(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.I;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final Object setZIndexEditingEnabled(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.c;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final g1 setSupportedProperties(EnumSet enumSet) {
        enumSet.getClass();
        EnumSet<AnnotationProperty> enumSetCopyOf = EnumSet.copyOf(enumSet);
        enumSetCopyOf.getClass();
        this.b = enumSetCopyOf;
        j1 j1Var = this.a;
        i1<EnumSet<AnnotationProperty>> i1Var = i1.a;
        j1Var.getClass();
        j1Var.a.put(i1Var, enumSetCopyOf);
        return this;
    }
}
