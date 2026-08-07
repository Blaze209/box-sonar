package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.EraserToolConfiguration;
import com.pspdfkit.annotations.configuration.FreeTextAnnotationConfiguration;
import com.pspdfkit.annotations.configuration.InkAnnotationConfiguration;
import com.pspdfkit.annotations.configuration.LineAnnotationConfiguration;
import com.pspdfkit.annotations.configuration.MeasurementAreaAnnotationConfiguration;
import com.pspdfkit.annotations.configuration.MeasurementDistanceAnnotationConfiguration;
import com.pspdfkit.annotations.configuration.MeasurementPerimeterAnnotationConfiguration;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 implements AnnotationConfigurationRegistry {
    public static final AnnotationType[] d = {AnnotationType.INK, AnnotationType.LINE, AnnotationType.POLYLINE, AnnotationType.SQUARE, AnnotationType.CIRCLE, AnnotationType.POLYGON, AnnotationType.FREETEXT, AnnotationType.NOTE, AnnotationType.UNDERLINE, AnnotationType.SQUIGGLY, AnnotationType.STRIKEOUT, AnnotationType.HIGHLIGHT, AnnotationType.STAMP, AnnotationType.FILE, AnnotationType.REDACT, AnnotationType.SOUND};
    public final Context a;
    public final HashMap<AnnotationType, AnnotationConfiguration> b;
    public final HashMap<Pair<AnnotationTool, AnnotationToolVariant>, AnnotationConfiguration> c;

    public static final class a extends on {
        public final /* synthetic */ AnnotationType a;

        public a(AnnotationType annotationType) {
            this.a = annotationType;
        }

        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            AnnotationConfiguration annotationConfigurationBuild = AnnotationConfiguration.builder(context, this.a).build();
            annotationConfigurationBuild.getClass();
            return annotationConfigurationBuild;
        }
    }

    public static final class b extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            EraserToolConfiguration eraserToolConfigurationBuild = EraserToolConfiguration.builder().build();
            eraserToolConfigurationBuild.getClass();
            return eraserToolConfigurationBuild;
        }
    }

    public static final class c extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            FreeTextAnnotationConfiguration.Builder builder = FreeTextAnnotationConfiguration.builder(context);
            AnnotationTool annotationTool = AnnotationTool.FREETEXT;
            float f = ww.a;
            annotationTool.getClass();
            AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            annotationToolVariantDefaultVariant.getClass();
            FreeTextAnnotationConfiguration freeTextAnnotationConfigurationBuild = builder.setDefaultColor(ww.a(context, annotationTool, annotationToolVariantDefaultVariant)).setDefaultLineEnds(new androidx.core.util.Pair<>(LineEndType.OPEN_ARROW, LineEndType.NONE)).setDefaultThickness(2.0f).setDefaultBorderStylePreset(BorderStylePreset.SOLID).build();
            freeTextAnnotationConfigurationBuild.getClass();
            return freeTextAnnotationConfigurationBuild;
        }
    }

    public static final class d extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            InkAnnotationConfiguration.Builder defaultAlpha = InkAnnotationConfiguration.builder(context).setDefaultAlpha(0.35f);
            AnnotationTool annotationTool = AnnotationTool.INK;
            AnnotationToolVariant annotationToolVariantFromPreset = AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.HIGHLIGHTER);
            annotationToolVariantFromPreset.getClass();
            InkAnnotationConfiguration inkAnnotationConfigurationBuild = defaultAlpha.setDefaultColor(ww.a(context, annotationTool, annotationToolVariantFromPreset)).setDefaultThickness(30.0f).build();
            inkAnnotationConfigurationBuild.getClass();
            return inkAnnotationConfigurationBuild;
        }
    }

    public static final class e extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            LineAnnotationConfiguration lineAnnotationConfigurationBuild = LineAnnotationConfiguration.builder(context, AnnotationTool.LINE).setDefaultLineEnds(new androidx.core.util.Pair<>(LineEndType.NONE, LineEndType.CLOSED_ARROW)).build();
            lineAnnotationConfigurationBuild.getClass();
            return lineAnnotationConfigurationBuild;
        }
    }

    public static final class f extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            MeasurementDistanceAnnotationConfiguration.Builder builder = MeasurementDistanceAnnotationConfiguration.builder(context);
            LineEndType lineEndType = LineEndType.BUTT;
            MeasurementDistanceAnnotationConfiguration measurementDistanceAnnotationConfigurationBuild = builder.setDefaultLineEnds(new androidx.core.util.Pair<>(lineEndType, lineEndType)).setDefaultThickness(2.0f).setDefaultColor(ww.c).build();
            measurementDistanceAnnotationConfigurationBuild.getClass();
            return measurementDistanceAnnotationConfigurationBuild;
        }
    }

    public static final class g extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            MeasurementDistanceAnnotationConfiguration.Builder builder = MeasurementDistanceAnnotationConfiguration.builder(context);
            LineEndType lineEndType = LineEndType.BUTT;
            MeasurementDistanceAnnotationConfiguration measurementDistanceAnnotationConfigurationBuild = builder.setDefaultLineEnds(new androidx.core.util.Pair<>(lineEndType, lineEndType)).setDefaultThickness(2.0f).setDefaultColor(ww.c).build();
            measurementDistanceAnnotationConfigurationBuild.getClass();
            return measurementDistanceAnnotationConfigurationBuild;
        }
    }

    public static final class h extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            MeasurementPerimeterAnnotationConfiguration measurementPerimeterAnnotationConfigurationBuild = MeasurementPerimeterAnnotationConfiguration.builder(context).setDefaultLineEnds(new androidx.core.util.Pair<>(LineEndType.BUTT, LineEndType.OPEN_ARROW)).setDefaultThickness(2.0f).setDefaultColor(ww.c).build();
            measurementPerimeterAnnotationConfigurationBuild.getClass();
            return measurementPerimeterAnnotationConfigurationBuild;
        }
    }

    public static final class i extends on {
        @Override // com.pspdfkit.internal.on
        public final AnnotationConfiguration a(Context context) {
            context.getClass();
            MeasurementAreaAnnotationConfiguration measurementAreaAnnotationConfigurationBuild = MeasurementAreaAnnotationConfiguration.builder(context).setDefaultThickness(2.0f).setDefaultColor(ww.c).build();
            measurementAreaAnnotationConfigurationBuild.getClass();
            return measurementAreaAnnotationConfigurationBuild;
        }
    }

    public k1(Context context) {
        context.getClass();
        this.a = context;
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        for (AnnotationType annotationType : d) {
            this.b.put(annotationType, new a(annotationType));
        }
        this.c.put(TuplesKt.to(AnnotationTool.ERASER, AnnotationToolVariant.defaultVariant()), new b());
        this.c.put(TuplesKt.to(AnnotationTool.FREETEXT_CALLOUT, AnnotationToolVariant.defaultVariant()), new c());
        this.c.put(TuplesKt.to(AnnotationTool.INK, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.HIGHLIGHTER)), new d());
        this.c.put(TuplesKt.to(AnnotationTool.LINE, AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.ARROW)), new e());
        this.c.put(TuplesKt.to(AnnotationTool.MEASUREMENT_DISTANCE, AnnotationToolVariant.defaultVariant()), new f());
        this.c.put(TuplesKt.to(AnnotationTool.MEASUREMENT_SCALE_CALIBRATION, AnnotationToolVariant.defaultVariant()), new g());
        this.c.put(TuplesKt.to(AnnotationTool.MEASUREMENT_PERIMETER, AnnotationToolVariant.defaultVariant()), new h());
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.k1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return k1.a(this.f$0, (AnnotationTool) obj);
            }
        };
        function1.invoke(AnnotationTool.MEASUREMENT_AREA_POLYGON);
        function1.invoke(AnnotationTool.MEASUREMENT_AREA_ELLIPSE);
        function1.invoke(AnnotationTool.MEASUREMENT_AREA_RECT);
    }

    public static final Unit a(k1 k1Var, AnnotationTool annotationTool) {
        annotationTool.getClass();
        k1Var.c.put(TuplesKt.to(annotationTool, AnnotationToolVariant.defaultVariant()), new i());
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final AnnotationConfiguration get(AnnotationType annotationType) {
        annotationType.getClass();
        AnnotationConfiguration annotationConfiguration = this.b.get(annotationType);
        if (!(annotationConfiguration instanceof on)) {
            return annotationConfiguration;
        }
        AnnotationConfiguration annotationConfigurationA = ((on) annotationConfiguration).a(this.a);
        this.b.put(annotationType, annotationConfigurationA);
        return annotationConfigurationA;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final boolean isAnnotationPropertySupported(AnnotationType annotationType, AnnotationProperty annotationProperty) {
        annotationType.getClass();
        annotationProperty.getClass();
        AnnotationConfiguration annotationConfiguration = get(annotationType, (Class<AnnotationConfiguration>) AnnotationConfiguration.class);
        return annotationConfiguration != null && annotationConfiguration.getSupportedProperties().contains(annotationProperty);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final boolean isZIndexEditingSupported(AnnotationType annotationType) {
        annotationType.getClass();
        AnnotationConfiguration annotationConfiguration = get(annotationType, (Class<AnnotationConfiguration>) AnnotationConfiguration.class);
        return annotationConfiguration != null && annotationConfiguration.isZIndexEditingEnabled();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final void put(AnnotationType annotationType, AnnotationConfiguration annotationConfiguration) {
        annotationType.getClass();
        HashMap<AnnotationType, AnnotationConfiguration> map = this.b;
        if (annotationConfiguration != null) {
            map.put(annotationType, annotationConfiguration);
        } else {
            map.remove(annotationType);
        }
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final boolean isAnnotationPropertySupported(AnnotationTool annotationTool, AnnotationProperty annotationProperty) {
        annotationTool.getClass();
        annotationProperty.getClass();
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        return isAnnotationPropertySupported(annotationTool, annotationToolVariantDefaultVariant, annotationProperty);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final boolean isAnnotationPropertySupported(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, AnnotationProperty annotationProperty) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        annotationProperty.getClass();
        AnnotationConfiguration annotationConfiguration = get(annotationTool, annotationToolVariant, AnnotationConfiguration.class);
        return annotationConfiguration != null && annotationConfiguration.getSupportedProperties().contains(annotationProperty);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final AnnotationConfiguration get(AnnotationTool annotationTool) {
        annotationTool.getClass();
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        return get(annotationTool, annotationToolVariantDefaultVariant);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final void put(AnnotationTool annotationTool, AnnotationConfiguration annotationConfiguration) {
        annotationTool.getClass();
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        put(annotationTool, annotationToolVariantDefaultVariant, annotationConfiguration);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final AnnotationConfiguration get(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        Pair<AnnotationTool, AnnotationToolVariant> pair = TuplesKt.to(annotationTool, annotationToolVariant);
        if (this.c.containsKey(pair)) {
            AnnotationConfiguration annotationConfiguration = this.c.get(pair);
            if (!(annotationConfiguration instanceof on)) {
                return annotationConfiguration;
            }
            AnnotationConfiguration annotationConfigurationA = ((on) annotationConfiguration).a(this.a);
            this.c.put(pair, annotationConfigurationA);
            return annotationConfigurationA;
        }
        if (!Intrinsics.areEqual(annotationToolVariant, AnnotationToolVariant.defaultVariant())) {
            AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            annotationToolVariantDefaultVariant.getClass();
            return get(annotationTool, annotationToolVariantDefaultVariant);
        }
        AnnotationType annotationType = annotationTool.toAnnotationType();
        annotationType.getClass();
        return get(annotationType);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final void put(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, AnnotationConfiguration annotationConfiguration) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        HashMap<Pair<AnnotationTool, AnnotationToolVariant>, AnnotationConfiguration> map = this.c;
        if (annotationConfiguration != null) {
            map.put(TuplesKt.to(annotationTool, annotationToolVariant), annotationConfiguration);
        } else {
            map.remove(TuplesKt.to(annotationTool, annotationToolVariant));
        }
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final <T extends AnnotationConfiguration> T get(AnnotationType annotationType, Class<T> cls) {
        annotationType.getClass();
        cls.getClass();
        T t = (T) get(annotationType);
        if (!cls.isInstance(t)) {
            return null;
        }
        t.getClass();
        return t;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final <T extends AnnotationConfiguration> T get(AnnotationTool annotationTool, Class<T> cls) {
        annotationTool.getClass();
        cls.getClass();
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        return (T) get(annotationTool, annotationToolVariantDefaultVariant, cls);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry
    public final <T extends AnnotationConfiguration> T get(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Class<T> cls) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        cls.getClass();
        T t = (T) get(annotationTool, annotationToolVariant);
        if (!cls.isInstance(t)) {
            return null;
        }
        t.getClass();
        return t;
    }
}
