package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Pair;
import androidx.lifecycle.LifecycleOwnerKt;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.AnnotationZIndexMove;
import com.pspdfkit.annotations.BaseLineAnnotation;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationFontConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.internal.jni.NativeMeasurementCalibration;
import com.pspdfkit.internal.jni.NativeMeasurementScale;
import com.pspdfkit.internal.jni.NativeUnitFrom;
import com.pspdfkit.internal.jni.NativeUnitTo;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.BorderStylePickerInspectorView;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorView;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import com.pspdfkit.ui.inspector.views.LineEndTypePickerInspectorView;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.inspector.views.MeasurementValueInspectorView;
import com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView;
import com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView;
import com.pspdfkit.ui.inspector.views.ScaleNameInspectorView;
import com.pspdfkit.ui.inspector.views.ScaleSelectPickerInspectorView;
import com.pspdfkit.ui.inspector.views.SliderPickerInspectorView;
import com.pspdfkit.ui.inspector.views.TextInputInspectorView;
import com.pspdfkit.ui.inspector.views.TogglePickerInspectorView;
import com.pspdfkit.ui.inspector.views.ZIndexInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import com.pspdfkit.utils.Size;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 extends m2 {
    public final AnnotatingController b;
    public Job c;
    public a d;
    public MeasurementValueConfiguration e;
    public ZIndexInspectorView f;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.u1$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.u1$a[]) from 0x0042: INVOKE (r0v1 com.pspdfkit.internal.u1$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        NONE,
        ANNOTATION_THICKNESS,
        ANNOTATION_TEXT_SIZE,
        ANNOTATION_TEXT_FONT,
        ANNOTATION_ALPHA,
        ANNOTATION_OVERLAY_TEXT;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ EnumEntries<AnnotationProperty> a = EnumEntriesKt.enumEntries(AnnotationProperty.values());
    }

    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Scale.UnitTo.values().length];
            try {
                iArr[Scale.UnitTo.MI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.UnitTo.YD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Scale.UnitTo.FT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Scale.UnitTo.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Scale.UnitTo.M.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Scale.UnitTo.KM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Scale.UnitTo.CM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Scale.UnitTo.MM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.inspector.AnnotationEditingInspectorFactory$checkZIndexReorderingButtonsEnabled$numberOfAnnotations$1$1", f = "AnnotationEditingInspectorFactory.kt", i = {}, l = {538}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public int a;
        public final /* synthetic */ AnnotationProvider b;
        public final /* synthetic */ Annotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AnnotationProvider annotationProvider, Annotation annotation, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = annotationProvider;
            this.c = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.b;
            int pageIndex = this.c.getPageIndex();
            this.a = 1;
            Object annotations = annotationProvider.getAnnotations(pageIndex, this);
            return annotations == coroutine_suspended ? coroutine_suspended : annotations;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.inspector.AnnotationEditingInspectorFactory$checkZIndexReorderingButtonsEnabled$zIndex$1$1", f = "AnnotationEditingInspectorFactory.kt", i = {}, l = {543}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        public int a;
        public final /* synthetic */ AnnotationProvider b;
        public final /* synthetic */ Annotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AnnotationProvider annotationProvider, Annotation annotation, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = annotationProvider;
            this.c = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return new e(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.b;
            Annotation annotation = this.c;
            this.a = 1;
            Object zIndex = annotationProvider.getZIndex(annotation, this);
            return zIndex == coroutine_suspended ? coroutine_suspended : zIndex;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(AnnotatingController annotatingController) {
        super(annotatingController);
        annotatingController.getClass();
        this.b = annotatingController;
        this.d = a.NONE;
        this.e = MeasurementValueConfiguration.INSTANCE.defaultConfiguration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setAlpha((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i / 100.0f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit b(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFillColor((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit c(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setColor((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit d(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFillColor((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit e(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setOutlineColor((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit f(u1 u1Var, Pair pair, int i) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setTextSize((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, i);
        return Unit.INSTANCE;
    }

    public final void g(List<? extends Annotation> list, int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        final float f = i == 0 ? 0.5f : i;
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(f, this, (Annotation) obj));
            }
        }, "thickness", String.valueOf(i), a.ANNOTATION_THICKNESS, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.a(this.f$0, pair, f);
            }
        }, 64);
    }

    public static final void c(u1 u1Var, List list, Pair pair, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        u1Var.c((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(u1 u1Var, Pair pair, Ref.ObjectRef objectRef, LineEndType lineEndType) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setLineEnds((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, (LineEndType) objectRef.element, lineEndType);
        return Unit.INSTANCE;
    }

    public static final void c(u1 u1Var, List list, Pair pair, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        sliderPickerInspectorView.getClass();
        u1Var.f((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void d(u1 u1Var, List list, Pair pair, PropertyInspectorView propertyInspectorView, int i) {
        u1Var.e((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void e(u1 u1Var, List list, Pair pair, PropertyInspectorView propertyInspectorView, int i) {
        u1Var.b((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x045b  */
    /* JADX WARN: Code duplicated, block: B:141:0x04de  */
    /* JADX WARN: Code duplicated, block: B:164:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:49:0x0100  */
    /* JADX WARN: Code duplicated, block: B:65:0x0178  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f0  */
    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList b(final List list) {
        TextInputInspectorView textInputInspectorView;
        TogglePickerInspectorView togglePickerInspectorView;
        int color;
        ColorPickerInspectorView colorPickerInspectorViewA;
        ColorPickerInspectorView colorPickerInspectorViewA2;
        ColorPickerInspectorView colorPickerInspectorViewA3;
        SliderPickerInspectorView sliderPickerInspectorViewA;
        SliderPickerInspectorView sliderPickerInspectorViewA2;
        BorderStylePickerInspectorView borderStylePickerInspectorViewA;
        SliderPickerInspectorView sliderPickerInspectorView;
        SliderPickerInspectorView sliderPickerInspectorViewA3;
        int color2;
        Object obj;
        ColorPickerInspectorDetailView colorPickerInspectorDetailView;
        LineEndTypePickerInspectorView lineEndTypePickerInspectorView;
        ColorPickerInspectorView colorPickerInspectorViewB;
        LineEndTypePickerInspectorView lineEndTypePickerInspectorView2;
        Font defaultFont;
        FontPickerInspectorView fontPickerInspectorView;
        list.getClass();
        final ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(u1.a(arrayList, (PropertyInspectorView) obj2));
                }
            };
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(ww.c((Annotation) it.next()));
            }
            final Pair pair = (Pair) CollectionsKt.singleOrNull(hashSet);
            if (pair != null) {
                AnnotationTool annotationTool = (AnnotationTool) pair.first;
                Annotation annotation = (Annotation) CollectionsKt.first(list);
                if (annotationTool == AnnotationTool.MEASUREMENT_SCALE_CALIBRATION) {
                    if (list.size() == 1) {
                        a((Annotation) CollectionsKt.first(list), arrayList);
                    }
                } else {
                    annotationTool.getClass();
                    int i = p10.a.b[annotationTool.ordinal()];
                    if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                        function1.invoke(new rk(n1.a(this.b)));
                        a((Annotation) CollectionsKt.first(list), annotationTool, arrayList);
                    }
                    boolean z = annotation instanceof FreeTextAnnotation;
                    if (z) {
                        float f = ww.a;
                        if (ww.a.a[annotation.getType().ordinal()] == 5) {
                            String fontName = ((FreeTextAnnotation) annotation).getFontName();
                            defaultFont = ar.c().getFontByName(fontName);
                            if (defaultFont == null && fontName != null && fontName.length() != 0) {
                                defaultFont = new Font(fontName, null, null, 6, null);
                            }
                        } else {
                            defaultFont = null;
                        }
                        FontPickerInspectorView.FontPickerListener fontPickerListener = new FontPickerInspectorView.FontPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda5
                            @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorView.FontPickerListener
                            public final void onFontSelected(Font font) {
                                u1.a(this.f$0, list, pair, font);
                            }
                        };
                        if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.FONT)) {
                            AnnotationConfigurationRegistry annotationConfiguration = this.b.getFragment().getAnnotationConfiguration();
                            annotationConfiguration.getClass();
                            AnnotationFontConfiguration annotationFontConfiguration = (AnnotationFontConfiguration) annotationConfiguration.get(annotationTool, AnnotationFontConfiguration.class);
                            if (annotationFontConfiguration == null || annotationFontConfiguration.getAvailableFonts().isEmpty()) {
                                fontPickerInspectorView = null;
                            } else {
                                if (defaultFont == null) {
                                    defaultFont = annotationFontConfiguration.getDefaultFont();
                                    defaultFont.getClass();
                                }
                                Context contextRequireContext = a().getFragment().requireContext();
                                contextRequireContext.getClass();
                                fontPickerInspectorView = new FontPickerInspectorView(contextRequireContext, annotationFontConfiguration.getAvailableFonts(), defaultFont, fontPickerListener);
                                fontPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_font_picker);
                            }
                        } else {
                            fontPickerInspectorView = null;
                        }
                        function1.invoke(fontPickerInspectorView);
                    }
                    float f2 = ww.a;
                    annotation.getClass();
                    AnnotationType type = annotation.getType();
                    int[] iArr = ww.a.a;
                    String overlayText = iArr[type.ordinal()] == 21 ? ((RedactionAnnotation) annotation).getOverlayText() : null;
                    TextInputInspectorView.TextInputListener textInputListener = new TextInputInspectorView.TextInputListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda6
                        @Override // com.pspdfkit.ui.inspector.views.TextInputInspectorView.TextInputListener
                        public final void onValuePicked(TextInputInspectorView textInputInspectorView2, String str) {
                            u1.a(this.f$0, list, textInputInspectorView2, str);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.OVERLAY_TEXT)) {
                        AnnotationConfigurationRegistry annotationConfiguration2 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration2.getClass();
                        AnnotationOverlayTextConfiguration annotationOverlayTextConfiguration = (AnnotationOverlayTextConfiguration) annotationConfiguration2.get(annotationTool, AnnotationOverlayTextConfiguration.class);
                        if (overlayText == null) {
                            overlayText = "";
                        }
                        if (annotationOverlayTextConfiguration == null) {
                            textInputInspectorView = null;
                        } else {
                            Context contextRequireContext2 = a().getFragment().requireContext();
                            contextRequireContext2.getClass();
                            Context contextRequireContext3 = a().getFragment().requireContext();
                            contextRequireContext3.getClass();
                            textInputInspectorView = new TextInputInspectorView(contextRequireContext2, no.a(contextRequireContext3, R.string.pspdf__edit_menu_overlay_text, null), overlayText, textInputListener);
                            textInputInspectorView.setId(R.id.pspdf__annotation_inspector_view_overlay_text_picker);
                        }
                    } else {
                        textInputInspectorView = null;
                    }
                    function1.invoke(textInputInspectorView);
                    boolean zShouldRepeatOverlayText = iArr[annotation.getType().ordinal()] == 21 ? ((RedactionAnnotation) annotation).shouldRepeatOverlayText() : false;
                    TogglePickerInspectorView.TogglePickerListener togglePickerListener = new TogglePickerInspectorView.TogglePickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda7
                        @Override // com.pspdfkit.ui.inspector.views.TogglePickerInspectorView.TogglePickerListener
                        public final void onSelectionChanged(TogglePickerInspectorView togglePickerInspectorView2, boolean z2) {
                            u1.a(this.f$0, list, togglePickerInspectorView2, z2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.REPEAT_OVERLAY_TEXT)) {
                        AnnotationConfigurationRegistry annotationConfiguration3 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration3.getClass();
                        if (((AnnotationOverlayTextConfiguration) annotationConfiguration3.get(annotationTool, AnnotationOverlayTextConfiguration.class)) == null) {
                            togglePickerInspectorView = null;
                        } else {
                            Context contextRequireContext4 = a().getFragment().requireContext();
                            contextRequireContext4.getClass();
                            Context contextRequireContext5 = a().getFragment().requireContext();
                            contextRequireContext5.getClass();
                            togglePickerInspectorView = new TogglePickerInspectorView(contextRequireContext4, no.a(contextRequireContext5, R.string.pspdf__edit_menu_repeat_overlay_text, null), "", "", zShouldRepeatOverlayText, togglePickerListener);
                            togglePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_repeat_overlay_text_picker);
                        }
                    } else {
                        togglePickerInspectorView = null;
                    }
                    function1.invoke(togglePickerInspectorView);
                    AnnotationType type2 = annotation.getType();
                    AnnotationType annotationType = AnnotationType.STAMP;
                    if (type2 == annotationType) {
                        color = a40.a((StampAnnotation) annotation);
                    } else {
                        color = annotation.getColor();
                    }
                    ColorPickerInspectorView.ColorPickerListener colorPickerListener = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda8
                        @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                        public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i2) {
                            u1.c(this.f$0, list, pair, propertyInspectorView, i2);
                        }
                    };
                    AnnotationConfigurationRegistry annotationConfigurationRegistryA = o1.a(this.b);
                    AnnotationProperty annotationProperty = AnnotationProperty.COLOR;
                    if (annotationConfigurationRegistryA.isAnnotationPropertySupported(annotationTool, annotationProperty)) {
                        AnnotationConfigurationRegistry annotationConfiguration4 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration4.getClass();
                        colorPickerInspectorViewA = a((AnnotationColorConfiguration) annotationConfiguration4.get(annotationTool, AnnotationColorConfiguration.class), color, o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.TEXT_SIZE), colorPickerListener);
                    } else {
                        colorPickerInspectorViewA = null;
                    }
                    boolean zBooleanValue = ((Boolean) function1.invoke(colorPickerInspectorViewA)).booleanValue();
                    int outlineColor = iArr[annotation.getType().ordinal()] == 21 ? ((RedactionAnnotation) annotation).getOutlineColor() : 0;
                    ColorPickerInspectorView.ColorPickerListener colorPickerListener2 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda9
                        @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                        public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i2) {
                            u1.d(this.f$0, list, pair, propertyInspectorView, i2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.OUTLINE_COLOR)) {
                        AnnotationConfigurationRegistry annotationConfiguration5 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration5.getClass();
                        colorPickerInspectorViewA2 = a((AnnotationOutlineColorConfiguration) annotationConfiguration5.get(annotationTool, AnnotationOutlineColorConfiguration.class), outlineColor, colorPickerListener2);
                    } else {
                        colorPickerInspectorViewA2 = null;
                    }
                    function1.invoke(colorPickerInspectorViewA2);
                    F f3 = pair.first;
                    f3.getClass();
                    AnnotationTool annotationTool2 = (AnnotationTool) f3;
                    int fillColor = annotation.getFillColor();
                    ColorPickerInspectorView.ColorPickerListener colorPickerListener3 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda10
                        @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                        public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i2) {
                            u1.e(this.f$0, list, pair, propertyInspectorView, i2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool2, AnnotationProperty.FILL_COLOR)) {
                        AnnotationConfigurationRegistry annotationConfiguration6 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration6.getClass();
                        colorPickerInspectorViewA3 = a((AnnotationFillColorConfiguration) annotationConfiguration6.get(annotationTool2, AnnotationFillColorConfiguration.class), fillColor, colorPickerListener3);
                    } else {
                        colorPickerInspectorViewA3 = null;
                    }
                    function1.invoke(colorPickerInspectorViewA3);
                    F f4 = pair.first;
                    f4.getClass();
                    AnnotationTool annotationTool3 = (AnnotationTool) f4;
                    float fB = (int) ww.b(annotation);
                    SliderPickerInspectorView.SliderPickerListener sliderPickerListener = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda12
                        @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                        public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView2, int i2) {
                            u1.b(this.f$0, list, pair, sliderPickerInspectorView2, i2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool3, AnnotationProperty.THICKNESS)) {
                        AnnotationConfigurationRegistry annotationConfiguration7 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration7.getClass();
                        sliderPickerInspectorViewA = a((AnnotationThicknessConfiguration) annotationConfiguration7.get(annotationTool3, AnnotationThicknessConfiguration.class), fB, sliderPickerListener);
                    } else {
                        sliderPickerInspectorViewA = null;
                    }
                    function1.invoke(sliderPickerInspectorViewA);
                    F f5 = pair.first;
                    f5.getClass();
                    AnnotationTool annotationTool4 = (AnnotationTool) f5;
                    float textSize = annotation.getType() == AnnotationType.FREETEXT ? (int) ((FreeTextAnnotation) annotation).getTextSize() : -1;
                    SliderPickerInspectorView.SliderPickerListener sliderPickerListener2 = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda13
                        @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                        public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView2, int i2) {
                            u1.c(this.f$0, list, pair, sliderPickerInspectorView2, i2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool4, AnnotationProperty.TEXT_SIZE)) {
                        AnnotationConfigurationRegistry annotationConfiguration8 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration8.getClass();
                        sliderPickerInspectorViewA2 = a((AnnotationTextSizeConfiguration) annotationConfiguration8.get(annotationTool4, AnnotationTextSizeConfiguration.class), textSize, sliderPickerListener2);
                    } else {
                        sliderPickerInspectorViewA2 = null;
                    }
                    function1.invoke(sliderPickerInspectorViewA2);
                    F f6 = pair.first;
                    f6.getClass();
                    AnnotationTool annotationTool5 = (AnnotationTool) f6;
                    BorderStylePreset borderStylePreset = new BorderStylePreset(annotation.getBorderStyle(), annotation.getBorderEffect(), annotation.getBorderDashArray());
                    BorderStylePickerInspectorView.BorderStylePickerListener borderStylePickerListener = new BorderStylePickerInspectorView.BorderStylePickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda14
                        @Override // com.pspdfkit.ui.inspector.views.BorderStylePickerInspectorView.BorderStylePickerListener
                        public final void onBorderStylePicked(BorderStylePickerInspectorView borderStylePickerInspectorView, BorderStylePreset borderStylePreset2) {
                            u1.a(this.f$0, list, pair, borderStylePickerInspectorView, borderStylePreset2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool5, AnnotationProperty.BORDER_STYLE)) {
                        AnnotationConfigurationRegistry annotationConfiguration9 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration9.getClass();
                        borderStylePickerInspectorViewA = a((AnnotationBorderStyleConfiguration) annotationConfiguration9.get(annotationTool5, AnnotationBorderStyleConfiguration.class), borderStylePreset, borderStylePickerListener);
                    } else {
                        borderStylePickerInspectorViewA = null;
                    }
                    function1.invoke(borderStylePickerInspectorViewA);
                    Pair<LineEndType, LineEndType> pairD = ww.d(annotation);
                    if (pairD != null) {
                        if (!z) {
                            F f7 = pair.first;
                            f7.getClass();
                            AnnotationTool annotationTool6 = (AnnotationTool) f7;
                            LineEndType lineEndType = pairD.first;
                            lineEndType.getClass();
                            LineEndType lineEndType2 = lineEndType;
                            String strA = no.a(n1.a(this.b), R.string.pspdf__picker_line_start, null);
                            strA.getClass();
                            LineEndTypePickerInspectorView.LineEndTypePickerListener lineEndTypePickerListener = new LineEndTypePickerInspectorView.LineEndTypePickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda45
                                @Override // com.pspdfkit.ui.inspector.views.LineEndTypePickerInspectorView.LineEndTypePickerListener
                                public final void onLineEndTypePicked(LineEndTypePickerInspectorView lineEndTypePickerInspectorView3, LineEndType lineEndType3) {
                                    u1.a(this.f$0, list, pair, lineEndTypePickerInspectorView3, lineEndType3);
                                }
                            };
                            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool6, AnnotationProperty.LINE_ENDS)) {
                                AnnotationConfigurationRegistry annotationConfiguration10 = this.b.getFragment().getAnnotationConfiguration();
                                annotationConfiguration10.getClass();
                                AnnotationLineEndsConfiguration annotationLineEndsConfiguration = (AnnotationLineEndsConfiguration) annotationConfiguration10.get(annotationTool6, AnnotationLineEndsConfiguration.class);
                                if (annotationLineEndsConfiguration == null || annotationLineEndsConfiguration.getAvailableLineEnds().isEmpty()) {
                                    lineEndTypePickerInspectorView2 = null;
                                } else {
                                    Context contextRequireContext6 = a().getFragment().requireContext();
                                    contextRequireContext6.getClass();
                                    lineEndTypePickerInspectorView2 = new LineEndTypePickerInspectorView(contextRequireContext6, strA, annotationLineEndsConfiguration.getAvailableLineEnds(), lineEndType2, true, lineEndTypePickerListener);
                                    lineEndTypePickerInspectorView2.setId(R.id.pspdf__annotation_inspector_view_line_start_picker);
                                }
                            } else {
                                lineEndTypePickerInspectorView2 = null;
                            }
                            function1.invoke(lineEndTypePickerInspectorView2);
                        }
                        F f8 = pair.first;
                        f8.getClass();
                        AnnotationTool annotationTool7 = (AnnotationTool) f8;
                        LineEndType lineEndType3 = z ? pairD.first : pairD.second;
                        lineEndType3.getClass();
                        sliderPickerInspectorView = null;
                        String strA2 = no.a(n1.a(this.b), R.string.pspdf__picker_line_end, null);
                        strA2.getClass();
                        LineEndTypePickerInspectorView.LineEndTypePickerListener lineEndTypePickerListener2 = new LineEndTypePickerInspectorView.LineEndTypePickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda1
                            @Override // com.pspdfkit.ui.inspector.views.LineEndTypePickerInspectorView.LineEndTypePickerListener
                            public final void onLineEndTypePicked(LineEndTypePickerInspectorView lineEndTypePickerInspectorView3, LineEndType lineEndType4) {
                                u1.b(this.f$0, list, pair, lineEndTypePickerInspectorView3, lineEndType4);
                            }
                        };
                        if (o1.a(this.b).isAnnotationPropertySupported(annotationTool7, AnnotationProperty.LINE_ENDS)) {
                            AnnotationConfigurationRegistry annotationConfiguration11 = this.b.getFragment().getAnnotationConfiguration();
                            annotationConfiguration11.getClass();
                            AnnotationLineEndsConfiguration annotationLineEndsConfiguration2 = (AnnotationLineEndsConfiguration) annotationConfiguration11.get(annotationTool7, AnnotationLineEndsConfiguration.class);
                            if (annotationLineEndsConfiguration2 == null || annotationLineEndsConfiguration2.getAvailableLineEnds().isEmpty()) {
                                lineEndTypePickerInspectorView = null;
                            } else {
                                Context contextRequireContext7 = a().getFragment().requireContext();
                                contextRequireContext7.getClass();
                                lineEndTypePickerInspectorView = new LineEndTypePickerInspectorView(contextRequireContext7, strA2, annotationLineEndsConfiguration2.getAvailableLineEnds(), lineEndType3, false, lineEndTypePickerListener2);
                                lineEndTypePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_line_end_picker);
                            }
                        } else {
                            lineEndTypePickerInspectorView = null;
                        }
                        function1.invoke(lineEndTypePickerInspectorView);
                        F f9 = pair.first;
                        f9.getClass();
                        AnnotationTool annotationTool8 = (AnnotationTool) f9;
                        int fillColor2 = annotation.getFillColor();
                        ColorPickerInspectorView.ColorPickerListener colorPickerListener4 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda2
                            @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                            public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i2) {
                                u1.a(this.f$0, list, pair, propertyInspectorView, i2);
                            }
                        };
                        if (o1.a(this.b).isAnnotationPropertySupported(annotationTool8, AnnotationProperty.LINE_ENDS_FILL_COLOR)) {
                            AnnotationConfigurationRegistry annotationConfiguration12 = this.b.getFragment().getAnnotationConfiguration();
                            annotationConfiguration12.getClass();
                            colorPickerInspectorViewB = b((AnnotationFillColorConfiguration) annotationConfiguration12.get(annotationTool8, AnnotationFillColorConfiguration.class), fillColor2, colorPickerListener4);
                        } else {
                            colorPickerInspectorViewB = null;
                        }
                        function1.invoke(colorPickerInspectorViewB);
                    } else {
                        sliderPickerInspectorView = null;
                    }
                    if (zBooleanValue && arrayList.size() == 1) {
                        F f10 = pair.first;
                        f10.getClass();
                        AnnotationTool annotationTool9 = (AnnotationTool) f10;
                        if (annotation.getType() == annotationType) {
                            color2 = a40.a((StampAnnotation) annotation);
                        } else {
                            color2 = annotation.getColor();
                        }
                        ColorPickerInspectorView.ColorPickerListener colorPickerListener5 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda3
                            @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                            public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i2) {
                                u1.b(this.f$0, list, pair, propertyInspectorView, i2);
                            }
                        };
                        AnnotationConfigurationRegistry annotationConfiguration13 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration13.getClass();
                        if (annotationConfiguration13.isAnnotationPropertySupported(annotationTool9, annotationProperty)) {
                            AnnotationConfigurationRegistry annotationConfiguration14 = this.b.getFragment().getAnnotationConfiguration();
                            annotationConfiguration14.getClass();
                            AnnotationColorConfiguration annotationColorConfiguration = (AnnotationColorConfiguration) annotationConfiguration14.get(annotationTool9, AnnotationColorConfiguration.class);
                            if (annotationColorConfiguration == null || !m2.a(annotationColorConfiguration.getAvailableColors())) {
                                obj = sliderPickerInspectorView;
                            } else {
                                List<Integer> availableColors = annotationColorConfiguration.getAvailableColors();
                                availableColors.getClass();
                                m2.a(color2, availableColors);
                                Context contextRequireContext8 = a().getFragment().requireContext();
                                contextRequireContext8.getClass();
                                colorPickerInspectorDetailView = new ColorPickerInspectorDetailView(contextRequireContext8, annotationColorConfiguration.getAvailableColors(), color2, false);
                                colorPickerInspectorDetailView.setOnColorPickedListener(colorPickerListener5);
                                colorPickerInspectorDetailView.setId(R.id.pspdf__annotation_inspector_view_foreground_color_picker);
                            }
                        } else {
                            obj = sliderPickerInspectorView;
                        }
                        if (obj != null) {
                            obj = colorPickerInspectorDetailView;
                            arrayList.clear();
                            arrayList.add(obj);
                        }
                    }
                    obj = colorPickerInspectorDetailView;
                    F f11 = pair.first;
                    f11.getClass();
                    AnnotationTool annotationTool10 = (AnnotationTool) f11;
                    float alpha = annotation.getAlpha();
                    SliderPickerInspectorView.SliderPickerListener sliderPickerListener3 = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda4
                        @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                        public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView2, int i2) {
                            u1.a(this.f$0, list, pair, sliderPickerInspectorView2, i2);
                        }
                    };
                    if (o1.a(this.b).isAnnotationPropertySupported(annotationTool10, AnnotationProperty.ANNOTATION_ALPHA)) {
                        AnnotationConfigurationRegistry annotationConfiguration15 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration15.getClass();
                        sliderPickerInspectorViewA3 = a((AnnotationAlphaConfiguration) annotationConfiguration15.get(annotationTool10, AnnotationAlphaConfiguration.class), alpha, sliderPickerListener3);
                    } else {
                        sliderPickerInspectorViewA3 = sliderPickerInspectorView;
                    }
                    function1.invoke(sliderPickerInspectorViewA3);
                    F f12 = pair.first;
                    f12.getClass();
                    a(list, (AnnotationTool) f12, arrayList);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public final void f(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(i, this, (Annotation) obj));
            }
        }, "text_Size", String.valueOf(i), a.ANNOTATION_TEXT_SIZE, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.f(this.f$0, pair, i);
            }
        }, 64);
    }

    public static final boolean d(int i, Annotation annotation) {
        annotation.getClass();
        float f = ww.a;
        annotation.getClass();
        if (ww.a.a[annotation.getType().ordinal()] != 21) {
            return true;
        }
        ((RedactionAnnotation) annotation).setOutlineColor(i);
        return true;
    }

    public final void c(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.b(i, (Annotation) obj));
            }
        };
        Charset charset = u40.a;
        a(this, list, function1, "foreground_color", Integer.toHexString(i), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.c(this.f$0, pair, i);
            }
        }, 80);
    }

    public final void e(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.d(i, (Annotation) obj));
            }
        };
        Charset charset = u40.a;
        a(this, list, function1, "outline_color", Integer.toHexString(i), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.e(this.f$0, pair, i);
            }
        }, 80);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(u1 u1Var, Pair pair, Font font) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFont((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, font);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(u1 u1Var, Pair pair, LineEndType lineEndType, Ref.ObjectRef objectRef) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setLineEnds((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, lineEndType, (LineEndType) objectRef.element);
        return Unit.INSTANCE;
    }

    public static final boolean c(BorderStylePreset borderStylePreset, Annotation annotation) {
        annotation.getClass();
        annotation.setBorderEffectIntensity(borderStylePreset.getBorderEffectIntensity());
        BorderEffect borderEffect = borderStylePreset.getBorderEffect();
        borderEffect.getClass();
        annotation.setBorderEffect(borderEffect);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(u1 u1Var, Pair pair, float f) {
        AnnotationPreferencesManager annotationPreferences = u1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setThickness((AnnotationTool) pair.first, (AnnotationToolVariant) pair.second, f);
        return Unit.INSTANCE;
    }

    public static final boolean c(int i, Annotation annotation) {
        annotation.getClass();
        annotation.setFillColor(i);
        return true;
    }

    public static final void a(u1 u1Var, Annotation annotation, ZIndexInspectorView zIndexInspectorView, AnnotationZIndexMove annotationZIndexMove) {
        zIndexInspectorView.getClass();
        annotationZIndexMove.getClass();
        PdfDocument document = u1Var.b.getFragment().getDocument();
        if (document == null) {
            return;
        }
        AnnotationProvider annotationProvider = document.getAnnotationProvider();
        annotationProvider.getClass();
        v1 v1Var = new v1(annotationProvider, annotation, annotationZIndexMove, u1Var, null);
        PageRenderConfiguration pageRenderConfiguration = lm.Q;
        ((lm) document).a(EmptyCoroutineContext.INSTANCE, v1Var);
    }

    @Override // com.pspdfkit.internal.m2
    public final FragmentSpecialModeController a() {
        return this.b;
    }

    public static final boolean a(List list, PropertyInspectorView propertyInspectorView) {
        if (propertyInspectorView != null) {
            return list.add(propertyInspectorView);
        }
        return false;
    }

    public static final void a(u1 u1Var, List list, Pair pair, Font font) {
        font.getClass();
        u1Var.a((List<? extends Annotation>) list, font, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void a(u1 u1Var, List list, TextInputInspectorView textInputInspectorView, String str) {
        textInputInspectorView.getClass();
        str.getClass();
        u1Var.a((List<? extends Annotation>) list, str);
    }

    public static final void a(u1 u1Var, List list, TogglePickerInspectorView togglePickerInspectorView, boolean z) {
        togglePickerInspectorView.getClass();
        u1Var.a((List<? extends Annotation>) list, z);
    }

    public static final void a(u1 u1Var, List list, Pair pair, BorderStylePickerInspectorView borderStylePickerInspectorView, BorderStylePreset borderStylePreset) {
        borderStylePickerInspectorView.getClass();
        borderStylePreset.getClass();
        u1Var.a((List<? extends Annotation>) list, borderStylePreset, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void a(u1 u1Var, List list, Pair pair, LineEndTypePickerInspectorView lineEndTypePickerInspectorView, LineEndType lineEndType) {
        lineEndTypePickerInspectorView.getClass();
        lineEndType.getClass();
        u1Var.b((List<? extends Annotation>) list, lineEndType, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void a(u1 u1Var, List list, Pair pair, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        u1Var.d((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void a(u1 u1Var, List list, Pair pair, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        sliderPickerInspectorView.getClass();
        u1Var.a((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public final void a(List list, AnnotationTool annotationTool, ArrayList arrayList) {
        ZIndexInspectorView zIndexInspectorView = null;
        this.f = null;
        if (list.size() != 1) {
            return;
        }
        final Annotation annotation = (Annotation) CollectionsKt.first(list);
        if (annotation.isAttached()) {
            ZIndexInspectorView.ZIndexChangeListener zIndexChangeListener = new ZIndexInspectorView.ZIndexChangeListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda39
                @Override // com.pspdfkit.ui.inspector.views.ZIndexInspectorView.ZIndexChangeListener
                public final void onMoveExecuted(ZIndexInspectorView zIndexInspectorView2, AnnotationZIndexMove annotationZIndexMove) {
                    u1.a(this.f$0, annotation, zIndexInspectorView2, annotationZIndexMove);
                }
            };
            if (o1.a(this.b).isZIndexEditingSupported(annotationTool.toAnnotationType())) {
                AnnotationConfigurationRegistry annotationConfiguration = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration.getClass();
                AnnotationConfiguration annotationConfiguration2 = annotationConfiguration.get(annotationTool, (Class<AnnotationConfiguration>) AnnotationConfiguration.class);
                if (annotationConfiguration2 != null && annotationConfiguration2.isZIndexEditingEnabled()) {
                    ZIndexInspectorView zIndexInspectorView2 = new ZIndexInspectorView(n1.a(this.b), no.a(n1.a(this.b), R.string.pspdf__z_index_order, null), zIndexChangeListener);
                    zIndexInspectorView2.setId(R.id.pspdf__annotation_inspector_view_z_index_picker);
                    zIndexInspectorView = zIndexInspectorView2;
                }
            }
            if (zIndexInspectorView != null) {
                this.f = zIndexInspectorView;
                a(annotation);
                arrayList.add(zIndexInspectorView);
            }
        }
    }

    public final void a(final Annotation annotation, ArrayList arrayList) {
        AnnotationTool annotationTool = AnnotationTool.MEASUREMENT_SCALE_CALIBRATION;
        boolean z = annotation instanceof LineAnnotation;
        ScaleCalibrationPickerInspectorView scaleCalibrationPickerInspectorView = null;
        LineAnnotation lineAnnotation = z ? (LineAnnotation) annotation : null;
        if (lineAnnotation == null || !lineAnnotation.isCalibration()) {
            return;
        }
        MeasurementValueConfiguration.Companion companion = MeasurementValueConfiguration.INSTANCE;
        this.e = companion.defaultConfiguration();
        ScaleNameInspectorView.NameChangeListener nameChangeListener = new ScaleNameInspectorView.NameChangeListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda22
            @Override // com.pspdfkit.ui.inspector.views.ScaleNameInspectorView.NameChangeListener
            public final void onNameChanged(String str) {
                u1.a(this.f$0, str);
            }
        };
        Context contextRequireContext = a().getFragment().requireContext();
        contextRequireContext.getClass();
        arrayList.add(new ScaleNameInspectorView(contextRequireContext, "", nameChangeListener));
        final ScaleSelectPickerInspectorView scaleSelectPickerInspectorView = new ScaleSelectPickerInspectorView(n1.a(this.b), no.a(n1.a(this.b), R.string.pspdf__picker_scale, null), this.e, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda33
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
                u1.a(this.f$0, annotation, measurementValueConfiguration);
            }
        });
        final PrecisionPickerInspectorView precisionPickerInspectorViewA = !o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.MEASUREMENT_PRECISION) ? null : a(this.e.getPrecision(), this.e.getScale().unitTo, new PrecisionPickerInspectorView.PrecisionPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda40
            @Override // com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView.PrecisionPickerListener
            public final void onPrecisionPicked(MeasurementPrecision measurementPrecision) {
                u1.a(this.f$0, annotation, measurementPrecision);
            }
        });
        Scale.UnitTo unitTo = this.e.getScale().unitTo;
        ScaleCalibrationPickerInspectorView.CalibrationPickerListener calibrationPickerListener = new ScaleCalibrationPickerInspectorView.CalibrationPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda41
            @Override // com.pspdfkit.ui.inspector.views.ScaleCalibrationPickerInspectorView.CalibrationPickerListener
            public final void onScaleCalibrationPicked(Float f, Scale.UnitTo unitTo2) {
                u1.a(scaleSelectPickerInspectorView, precisionPickerInspectorViewA, annotation, this, f, unitTo2);
            }
        };
        annotation.getClass();
        LineAnnotation lineAnnotation2 = z ? (LineAnnotation) annotation : null;
        if (lineAnnotation2 != null) {
            Context contextA = n1.a(this.b);
            String strA = no.a(n1.a(this.b), R.string.pspdf__picker_calibrate, null);
            if (unitTo == null) {
                unitTo = companion.defaultConfiguration().getScale().unitTo;
            }
            ScaleCalibrationPickerInspectorView scaleCalibrationPickerInspectorView2 = new ScaleCalibrationPickerInspectorView(lineAnnotation2, contextA, strA, unitTo, true, calibrationPickerListener);
            scaleCalibrationPickerInspectorView2.setId(R.id.pspdf__annotation_inspector_view_scale_calibration_picker);
            scaleCalibrationPickerInspectorView = scaleCalibrationPickerInspectorView2;
        }
        if (scaleCalibrationPickerInspectorView != null) {
            arrayList.add(scaleCalibrationPickerInspectorView);
        }
        arrayList.add(scaleSelectPickerInspectorView);
        if (precisionPickerInspectorViewA != null) {
            arrayList.add(precisionPickerInspectorViewA);
        }
    }

    public static final void a(u1 u1Var, String str) {
        u1Var.e = new MeasurementValueConfiguration(str, u1Var.e.getScale(), u1Var.e.getPrecision());
    }

    public static final void a(u1 u1Var, Annotation annotation, MeasurementValueConfiguration measurementValueConfiguration) {
        u1Var.b();
        u1Var.b.startRecording();
        annotation.getInternal().setMeasurementScale(u1Var.e.getScale());
        u1Var.b.stopRecording();
    }

    public static final void a(u1 u1Var, Annotation annotation, MeasurementPrecision measurementPrecision) {
        measurementPrecision.getClass();
        u1Var.e = new MeasurementValueConfiguration(u1Var.e.getName(), u1Var.e.getScale(), measurementPrecision);
        annotation.getInternal().setMeasurementPrecision(measurementPrecision);
    }

    public static final void a(PropertyInspectorView propertyInspectorView, PropertyInspectorView propertyInspectorView2, Annotation annotation, u1 u1Var, Float f, Scale.UnitTo unitTo) {
        Scale.UnitFrom unitFrom;
        unitTo.getClass();
        if (f != null && (propertyInspectorView instanceof ScaleSelectPickerInspectorView) && (propertyInspectorView2 instanceof PrecisionPickerInspectorView)) {
            switch (c.a[unitTo.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    unitFrom = Scale.UnitFrom.IN;
                    break;
                case 5:
                case 6:
                case 7:
                    unitFrom = Scale.UnitFrom.CM;
                    break;
                case 8:
                    unitFrom = Scale.UnitFrom.MM;
                    break;
                default:
                    unitFrom = Scale.UnitFrom.PT;
                    break;
            }
            Scale.UnitFrom unitFrom2 = unitFrom;
            ScaleSelectPickerInspectorView scaleSelectPickerInspectorView = (ScaleSelectPickerInspectorView) propertyInspectorView;
            Scale scale = scaleSelectPickerInspectorView.getCurrentConfigurationValue().getScale();
            unitFrom2.getClass();
            scale.getClass();
            LineAnnotation lineAnnotation = (LineAnnotation) annotation;
            NativeMeasurementScale measurementScaleFromCalibration = NativeMeasurementCalculator.getMeasurementScaleFromCalibration(lineAnnotation.getPoints().first, lineAnnotation.getPoints().second, new NativeMeasurementCalibration(f.floatValue(), mr.a(unitTo)), mr.a(new Scale(scale.getValueFrom(), unitFrom2, scale.getValueTo(), scale.unitTo, scale.fromDescription, scale.toDescription)));
            if (measurementScaleFromCalibration == null) {
                return;
            }
            float from = (float) measurementScaleFromCalibration.getFrom();
            NativeUnitFrom unitFrom3 = measurementScaleFromCalibration.getUnitFrom();
            unitFrom3.getClass();
            Scale.UnitFrom unitFromA = mr.a(unitFrom3);
            float to = (float) measurementScaleFromCalibration.getTo();
            NativeUnitTo unitTo2 = measurementScaleFromCalibration.getUnitTo();
            unitTo2.getClass();
            Scale scale2 = new Scale(from, unitFromA, to, mr.a(unitTo2), measurementScaleFromCalibration.getFromDescription(), measurementScaleFromCalibration.getToDescription());
            MeasurementValueConfiguration measurementValueConfiguration = new MeasurementValueConfiguration(u1Var.e.getName(), scale2, u1Var.e.getPrecision());
            u1Var.e = measurementValueConfiguration;
            scaleSelectPickerInspectorView.setConfiguration(measurementValueConfiguration, true);
            ((PrecisionPickerInspectorView) propertyInspectorView2).onUnitChanged(scale2.unitTo);
        }
    }

    public final void d(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.c(i, (Annotation) obj));
            }
        };
        Charset charset = u40.a;
        a(this, list, function1, "line_ends_fill_color", Integer.toHexString(i), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.d(this.f$0, pair, i);
            }
        }, 80);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    public final void a(final Annotation annotation, AnnotationTool annotationTool, ArrayList arrayList) {
        MeasurementValueConfiguration measurementValueConfiguration;
        String strA;
        List<MeasurementValueConfiguration> configurations;
        Object next;
        xp measurementProperties = annotation.getInternal().getMeasurementProperties();
        if (measurementProperties == null) {
            return;
        }
        MeasurementValueConfigurationEditor measurementValueConfigurationEditor = this.b.getFragment().getMeasurementValueConfigurationEditor();
        if (measurementValueConfigurationEditor != null && (configurations = measurementValueConfigurationEditor.getConfigurations()) != null) {
            Iterator<T> it = configurations.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((MeasurementValueConfiguration) next).equals(measurementProperties));
            measurementValueConfiguration = (MeasurementValueConfiguration) next;
            if (measurementValueConfiguration == null) {
                measurementValueConfiguration = new MeasurementValueConfiguration(null, measurementProperties.a, measurementProperties.b);
            }
        } else {
            measurementValueConfiguration = new MeasurementValueConfiguration(null, measurementProperties.a, measurementProperties.b);
        }
        String contents = annotation.getContents();
        if (contents != null && contents.length() != 0) {
            AnnotationTool annotationTool2 = AnnotationTool.MEASUREMENT_SCALE_CALIBRATION;
            AnnotatingController annotatingController = this.b;
            if (annotationTool == annotationTool2) {
                strA = n1.a(annotatingController).getString(R.string.pspdf__picker_calibrate);
            } else {
                strA = no.a(n1.a(annotatingController), ww.a(annotationTool), null);
            }
            strA.getClass();
            MeasurementValueInspectorView measurementValueInspectorView = new MeasurementValueInspectorView(n1.a(this.b), strA, contents, annotation);
            measurementValueInspectorView.setId(R.id.pspdf__annotation_inspector_view_measurement_value);
            arrayList.add(measurementValueInspectorView);
        }
        ScaleSelectPickerInspectorView scaleSelectPickerInspectorViewA = o1.a(this.b).isAnnotationPropertySupported(annotationTool, AnnotationProperty.SCALE) ? a(measurementValueConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda31
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                u1.b(this.f$0, annotation, measurementValueConfiguration2);
            }
        }) : null;
        if (scaleSelectPickerInspectorViewA != null) {
            arrayList.add(scaleSelectPickerInspectorViewA);
        }
        arrayList.add(new qk(n1.a(this.b)));
    }

    public final void a(Annotation annotation) {
        boolean z;
        AnnotationProvider annotationProvider;
        AnnotationProvider annotationProvider2;
        if (this.f != null && annotation.isAttached()) {
            PdfDocument document = this.b.getFragment().getDocument();
            boolean z2 = true;
            Integer numValueOf = null;
            List listEmptyList = (document == null || (annotationProvider2 = document.getAnnotationProvider()) == null) ? null : (List) BuildersKt__BuildersKt.runBlocking$default(null, new d(annotationProvider2, annotation, null), 1, null);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            int size = listEmptyList.size();
            PdfDocument document2 = this.b.getFragment().getDocument();
            if (document2 != null && (annotationProvider = document2.getAnnotationProvider()) != null) {
                numValueOf = Integer.valueOf(((Number) BuildersKt__BuildersKt.runBlocking$default(null, new e(annotationProvider, annotation, null), 1, null)).intValue());
            }
            boolean z3 = false;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                z = true;
                z2 = false;
            } else {
                z = numValueOf == null || numValueOf.intValue() != size + (-1);
            }
            if (size < 2) {
                z = false;
            } else {
                z3 = z2;
            }
            ZIndexInspectorView zIndexInspectorView = this.f;
            if (zIndexInspectorView != null) {
                zIndexInspectorView.enableAllMovements();
                if (!z3) {
                    zIndexInspectorView.disableBackwardMovements();
                }
                if (z) {
                    return;
                }
                zIndexInspectorView.disableForwardMovements();
            }
        }
    }

    public static void a(u1 u1Var, List list, Function1 function1, String str, String str2, a aVar, Function0 function0, int i) {
        int i2;
        a aVar2 = (i & 16) != 0 ? a.NONE : aVar;
        Function0 function2 = (i & 32) != 0 ? null : function0;
        boolean z = (i & 64) != 0;
        u1Var.getClass();
        if (list.isEmpty()) {
            return;
        }
        a aVar3 = a.NONE;
        boolean z2 = aVar2 != aVar3;
        if (z2) {
            a aVar4 = u1Var.d;
            if (aVar4 == aVar3) {
                u1Var.b.startRecording();
                u1Var.d = aVar2;
            } else if (aVar4 != aVar2) {
                u1Var.b.stopRecording();
                u1Var.b.startRecording();
                u1Var.d = aVar2;
            }
            Job job = u1Var.c;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            PdfFragment fragment = u1Var.b.getFragment();
            fragment.getClass();
            u1Var.c = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), null, null, new w1(u1Var, null), 3, null);
        } else {
            u1Var.b();
            u1Var.b.startRecording();
        }
        if (list.isEmpty()) {
            i2 = 0;
        } else {
            Iterator it = list.iterator();
            i2 = 0;
            while (it.hasNext()) {
                Annotation annotation = (Annotation) it.next();
                if (((Boolean) function1.invoke(annotation)).booleanValue()) {
                    i0 i0VarA = ar.a();
                    Bundle bundleA = z50.a(i0VarA);
                    bundleA.putString(Analytics.Data.ANNOTATION_TYPE, annotation.getType().name());
                    bundleA.putInt(Analytics.Data.PAGE_INDEX, annotation.getPageIndex());
                    bundleA.putString(Analytics.Data.ACTION, str);
                    bundleA.putString("value", str2 == null ? "" : str2);
                    i0VarA.a(Analytics.Event.CHANGE_PROPERTY_IN_INSPECTOR, bundleA);
                    i2++;
                    if (i2 < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        if ((i2 > 0) && function2 != null) {
            function2.invoke();
        }
        if (z2 || !z) {
            return;
        }
        u1Var.b.stopRecording();
    }

    public final void a(List<? extends Annotation> list, final Font font, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(font, this, (Annotation) obj));
            }
        }, "fontName", font.getName(), a.ANNOTATION_TEXT_FONT, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.a(this.f$0, pair, font);
            }
        }, 64);
    }

    public static final boolean a(Font font, u1 u1Var, Annotation annotation) {
        annotation.getClass();
        float f = ww.a;
        PdfDocument document = u1Var.b.getFragment().getDocument();
        Size pageSize = document != null ? document.getPageSize(annotation.getPageIndex()) : null;
        AnnotationConfigurationRegistry annotationConfiguration = u1Var.b.getFragment().getAnnotationConfiguration();
        annotation.getClass();
        font.getClass();
        if (ww.a.a[annotation.getType().ordinal()] != 5) {
            return false;
        }
        FreeTextAnnotation freeTextAnnotation = (FreeTextAnnotation) annotation;
        freeTextAnnotation.setFontName(font.getName());
        if (pageSize == null || annotationConfiguration == null) {
            return true;
        }
        ji.a(freeTextAnnotation, annotationConfiguration, pageSize, null, null);
        return true;
    }

    public final void a(List<? extends Annotation> list, final String str) {
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(str, (Annotation) obj));
            }
        }, "overlay_text", str, a.ANNOTATION_OVERLAY_TEXT, null, 96);
    }

    public static final boolean a(String str, Annotation annotation) {
        annotation.getClass();
        float f = ww.a;
        annotation.getClass();
        if (ww.a.a[annotation.getType().ordinal()] != 21) {
            return false;
        }
        ((RedactionAnnotation) annotation).setOverlayText(str);
        return true;
    }

    public static final void b(u1 u1Var, List list, Pair pair, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        sliderPickerInspectorView.getClass();
        u1Var.g(list, i, pair);
    }

    public static final void b(u1 u1Var, List list, Pair pair, LineEndTypePickerInspectorView lineEndTypePickerInspectorView, LineEndType lineEndType) {
        lineEndTypePickerInspectorView.getClass();
        lineEndType.getClass();
        u1Var.a((List<? extends Annotation>) list, lineEndType, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void b(u1 u1Var, List list, Pair pair, PropertyInspectorView propertyInspectorView, int i) {
        u1Var.c((List<? extends Annotation>) list, i, (Pair<AnnotationTool, AnnotationToolVariant>) pair);
    }

    public static final void b(u1 u1Var, Annotation annotation, MeasurementValueConfiguration measurementValueConfiguration) {
        if (measurementValueConfiguration != null) {
            u1Var.b();
            u1Var.b.startRecording();
            annotation.getInternal().setMeasurementScale(measurementValueConfiguration.getScale());
            annotation.getInternal().setMeasurementPrecision(measurementValueConfiguration.getPrecision());
            u1Var.b.stopRecording();
        }
    }

    public final void b() {
        Job job = this.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.c = null;
        a aVar = this.d;
        a aVar2 = a.NONE;
        if (aVar != aVar2) {
            this.b.stopRecording();
            this.d = aVar2;
        }
    }

    public static final boolean b(int i, Annotation annotation) {
        annotation.getClass();
        annotation.setColor(i);
        return true;
    }

    public final void b(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(i, (Annotation) obj));
            }
        };
        Charset charset = u40.a;
        a(this, list, function1, "fill_color", Integer.toHexString(i), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.b(this.f$0, pair, i);
            }
        }, 80);
    }

    public static final boolean b(BorderStylePreset borderStylePreset, Annotation annotation) {
        annotation.getClass();
        annotation.setBorderDashArray(borderStylePreset.getDashArray());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.pspdfkit.annotations.LineEndType] */
    public final void b(List<? extends Annotation> list, final LineEndType lineEndType, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = LineEndType.NONE;
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.b(lineEndType, objectRef, (Annotation) obj));
            }
        };
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(this, list, function1, "line_ends", String.format("%s,%s", Arrays.copyOf(new Object[]{lineEndType.name(), ((LineEndType) objectRef.element).name()}, 2)), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.a(this.f$0, pair, lineEndType, objectRef);
            }
        }, 80);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [S, T, java.lang.Object] */
    public static final boolean b(LineEndType lineEndType, Ref.ObjectRef objectRef, Annotation annotation) {
        annotation.getClass();
        Pair<LineEndType, LineEndType> pairD = ww.d(annotation);
        if (pairD == null) {
            return false;
        }
        LineEndType lineEndType2 = pairD.second;
        lineEndType2.getClass();
        if (!ww.a(annotation, lineEndType, lineEndType2)) {
            return false;
        }
        ?? r2 = pairD.second;
        r2.getClass();
        objectRef.element = r2;
        return true;
    }

    public final void a(List<? extends Annotation> list, final boolean z) {
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(z, (Annotation) obj));
            }
        }, "repeat_overlay_text", String.valueOf(z), null, null, 112);
    }

    public static final boolean a(boolean z, Annotation annotation) {
        annotation.getClass();
        float f = ww.a;
        annotation.getClass();
        if (ww.a.a[annotation.getType().ordinal()] != 21) {
            return false;
        }
        ((RedactionAnnotation) annotation).setRepeatOverlayText(z);
        return true;
    }

    public static final boolean a(int i, Annotation annotation) {
        annotation.getClass();
        annotation.setFillColor(i);
        return true;
    }

    public static final boolean a(float f, u1 u1Var, Annotation annotation) {
        annotation.getClass();
        float f2 = ww.a;
        PdfDocument document = u1Var.b.getFragment().getDocument();
        Size pageSize = document != null ? document.getPageSize(annotation.getPageIndex()) : null;
        AnnotationConfigurationRegistry annotationConfiguration = u1Var.b.getFragment().getAnnotationConfiguration();
        annotation.getClass();
        int i = ww.a.a[annotation.getType().ordinal()];
        if (i != 5) {
            if (i == 7) {
                ((InkAnnotation) annotation).setLineWidth(f);
                return true;
            }
            if (i != 17 && i != 9) {
                if (i != 10 && i != 19 && i != 20) {
                    return false;
                }
                ((BaseLineAnnotation) annotation).setLineWidth(f);
                return true;
            }
        }
        annotation.setBorderWidth(f);
        if ((annotation instanceof FreeTextAnnotation) && pageSize != null && annotationConfiguration != null) {
            ji.a((FreeTextAnnotation) annotation, annotationConfiguration, pageSize, null, null);
        }
        return true;
    }

    public static final boolean a(int i, u1 u1Var, Annotation annotation) {
        annotation.getClass();
        float f = ww.a;
        PdfDocument document = u1Var.b.getFragment().getDocument();
        Size pageSize = document != null ? document.getPageSize(annotation.getPageIndex()) : null;
        AnnotationConfigurationRegistry annotationConfiguration = u1Var.b.getFragment().getAnnotationConfiguration();
        annotation.getClass();
        if (annotation.getType() != AnnotationType.FREETEXT) {
            return false;
        }
        FreeTextAnnotation freeTextAnnotation = (FreeTextAnnotation) annotation;
        freeTextAnnotation.setTextSize(i);
        if (pageSize == null || annotationConfiguration == null) {
            return true;
        }
        ji.a(freeTextAnnotation, annotationConfiguration, pageSize, null, null);
        return true;
    }

    public static final boolean a(BorderStylePreset borderStylePreset, Annotation annotation) {
        annotation.getClass();
        BorderStyle borderStyle = borderStylePreset.getBorderStyle();
        borderStyle.getClass();
        annotation.setBorderStyle(borderStyle);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.pspdfkit.annotations.LineEndType] */
    public final void a(List<? extends Annotation> list, final LineEndType lineEndType, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = LineEndType.NONE;
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(lineEndType, objectRef, (Annotation) obj));
            }
        };
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(this, list, function1, "line_ends", String.format("%s,%s", Arrays.copyOf(new Object[]{((LineEndType) objectRef.element).name(), lineEndType.name()}, 2)), null, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.a(this.f$0, pair, objectRef, lineEndType);
            }
        }, 80);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [F, T, java.lang.Object] */
    public static final boolean a(LineEndType lineEndType, Ref.ObjectRef objectRef, Annotation annotation) {
        annotation.getClass();
        Pair<LineEndType, LineEndType> pairD = ww.d(annotation);
        if (pairD == null) {
            return false;
        }
        LineEndType lineEndType2 = pairD.first;
        lineEndType2.getClass();
        if (!ww.a(annotation, lineEndType2, lineEndType)) {
            return false;
        }
        ?? r2 = pairD.first;
        r2.getClass();
        objectRef.element = r2;
        return true;
    }

    public final void a(List<? extends Annotation> list, final int i, final Pair<AnnotationTool, AnnotationToolVariant> pair) {
        final float f = i / 100.0f;
        a(this, list, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u1.a(f, (Annotation) obj));
            }
        }, "alpha", String.valueOf(f), a.ANNOTATION_ALPHA, new Function0() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return u1.a(this.f$0, pair, i);
            }
        }, 64);
    }

    public static final boolean a(float f, Annotation annotation) {
        boolean z;
        annotation.getClass();
        if (annotation.getFillAlpha() == f) {
            z = false;
        } else {
            annotation.setFillAlpha(f);
            z = true;
        }
        if (annotation.getAlpha() == f) {
            return z;
        }
        annotation.setAlpha(f);
        return true;
    }

    public final void a(List<? extends Annotation> list, final BorderStylePreset borderStylePreset, Pair<AnnotationTool, AnnotationToolVariant> pair) {
        String strJoinToString$default;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Annotation) obj).getBorderStyle() != borderStylePreset.getBorderStyle()) {
                arrayList.add(obj);
            }
        }
        a(this, arrayList, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(u1.a(borderStylePreset, (Annotation) obj2));
            }
        }, "border_style", borderStylePreset.getBorderStyle().name(), null, null, 48);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            Annotation annotation = (Annotation) obj2;
            if ((annotation.getBorderDashArray() != null && !Intrinsics.areEqual(annotation.getBorderDashArray(), borderStylePreset.getDashArray())) || borderStylePreset.getDashArray() != null) {
                arrayList2.add(obj2);
            }
        }
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(u1.b(borderStylePreset, (Annotation) obj3));
            }
        };
        List<Integer> dashArray = borderStylePreset.getDashArray();
        if (dashArray == null || (strJoinToString$default = CollectionsKt.joinToString$default(dashArray, ",", null, null, 0, null, null, 62, null)) == null) {
            strJoinToString$default = AbstractJsonLexerKt.NULL;
        }
        a(this, arrayList2, function1, "border_dash_array", strJoinToString$default, null, null, 48);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            Annotation annotation2 = (Annotation) obj3;
            if (annotation2.getBorderEffect() != borderStylePreset.getBorderEffect() || annotation2.getBorderEffectIntensity() != borderStylePreset.getBorderEffectIntensity()) {
                arrayList3.add(obj3);
            }
        }
        a(this, arrayList3, new Function1() { // from class: com.pspdfkit.internal.u1$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj4) {
                return Boolean.valueOf(u1.c(borderStylePreset, (Annotation) obj4));
            }
        }, "border_effect", borderStylePreset.getBorderEffect().name(), null, null, 48);
        this.b.stopRecording();
        List<Integer> dashArray2 = borderStylePreset.getDashArray();
        if (borderStylePreset.getBorderStyle() == BorderStyle.DASHED && dashArray2 != null && !dashArray2.isEmpty()) {
            AnnotationPreferencesManager annotationPreferences = this.b.getFragment().getAnnotationPreferences();
            annotationPreferences.getClass();
            annotationPreferences.setBorderStylePreset(pair.first, pair.second, new BorderStylePreset(borderStylePreset.getBorderStyle(), dashArray2));
        } else {
            AnnotationPreferencesManager annotationPreferences2 = this.b.getFragment().getAnnotationPreferences();
            annotationPreferences2.getClass();
            annotationPreferences2.setBorderStylePreset(pair.first, pair.second, new BorderStylePreset(borderStylePreset.getBorderStyle()));
        }
    }
}
