package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationFontConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationPreviewConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.BorderStylePickerInspectorView;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorView;
import com.pspdfkit.ui.inspector.views.EraserPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import com.pspdfkit.ui.inspector.views.FreeTextAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.InkAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.LineEndTypePickerInspectorView;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.inspector.views.RedactionAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.ShapeAnnotationPreviewInspectorView;
import com.pspdfkit.ui.inspector.views.SliderPickerInspectorView;
import com.pspdfkit.ui.inspector.views.TextInputInspectorView;
import com.pspdfkit.ui.inspector.views.TogglePickerInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends m2 {
    public final AnnotatingController b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<AnnotationProperty> a = EnumEntriesKt.enumEntries(AnnotationProperty.values());
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationTool.values().length];
            try {
                iArr[AnnotationTool.FREETEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationTool.INK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationTool.MAGIC_INK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationTool.LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationTool.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationTool.CIRCLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationTool.POLYGON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationTool.POLYLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationTool.REDACTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationTool.ERASER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationTool.FREETEXT_CALLOUT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_DISTANCE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_PERIMETER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(AnnotatingController annotatingController) {
        super(annotatingController);
        annotatingController.getClass();
        this.b = annotatingController;
    }

    public static final void b(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.b.getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setColor(annotationTool, annotationToolVariant, i);
        p1Var.b.setColor(i);
    }

    public static final void c(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.b.getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setColor(annotationTool, annotationToolVariant, i);
        p1Var.b.setColor(i);
    }

    public static final void d(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setOutlineColor(annotationTool, annotationToolVariant, i);
        p1Var.b.setOutlineColor(i);
    }

    public static final void e(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFillColor(annotationTool, annotationToolVariant, i);
        p1Var.b.setFillColor(i);
    }

    public final LineEndTypePickerInspectorView a(final AnnotationTool annotationTool, final AnnotationToolVariant annotationToolVariant, LineEndType lineEndType, final boolean z, final boolean z2) {
        if (!o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.LINE_ENDS)) {
            return null;
        }
        AnnotationConfigurationRegistry annotationConfiguration = this.b.getFragment().getAnnotationConfiguration();
        annotationConfiguration.getClass();
        AnnotationLineEndsConfiguration annotationLineEndsConfiguration = (AnnotationLineEndsConfiguration) annotationConfiguration.get(annotationTool, annotationToolVariant, AnnotationLineEndsConfiguration.class);
        String strA = no.a(n1.a(this.b), z ? R.string.pspdf__picker_line_start : R.string.pspdf__picker_line_end, null);
        strA.getClass();
        LineEndTypePickerInspectorView.LineEndTypePickerListener lineEndTypePickerListener = new LineEndTypePickerInspectorView.LineEndTypePickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.ui.inspector.views.LineEndTypePickerInspectorView.LineEndTypePickerListener
            public final void onLineEndTypePicked(LineEndTypePickerInspectorView lineEndTypePickerInspectorView, LineEndType lineEndType2) {
                p1.a(z, z2, this, annotationTool, annotationToolVariant, lineEndTypePickerInspectorView, lineEndType2);
            }
        };
        lineEndType.getClass();
        if (annotationLineEndsConfiguration == null || annotationLineEndsConfiguration.getAvailableLineEnds().isEmpty()) {
            return null;
        }
        Context contextRequireContext = a().getFragment().requireContext();
        contextRequireContext.getClass();
        LineEndTypePickerInspectorView lineEndTypePickerInspectorView = new LineEndTypePickerInspectorView(contextRequireContext, strA, annotationLineEndsConfiguration.getAvailableLineEnds(), lineEndType, z, lineEndTypePickerListener);
        lineEndTypePickerInspectorView.setId(z ? R.id.pspdf__annotation_inspector_view_line_start_picker : R.id.pspdf__annotation_inspector_view_line_end_picker);
        return lineEndTypePickerInspectorView;
    }

    public static final void b(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        sliderPickerInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        float f = i;
        annotationPreferences.setTextSize(annotationTool, annotationToolVariant, f);
        p1Var.b.setTextSize(f);
    }

    public static final void c(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        float f = i / 100.0f;
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setAlpha(annotationTool, annotationToolVariant, f);
        p1Var.b.setAlpha(f);
    }

    @Override // com.pspdfkit.internal.m2
    public final FragmentSpecialModeController a() {
        return this.b;
    }

    public static final void a(boolean z, boolean z2, p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, LineEndTypePickerInspectorView lineEndTypePickerInspectorView, LineEndType lineEndType) {
        lineEndTypePickerInspectorView.getClass();
        lineEndType.getClass();
        if ((z && !z2) || (!z && z2)) {
            AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
            annotationPreferences.getClass();
            annotationPreferences.setLineEnds(annotationTool, annotationToolVariant, lineEndType, p1Var.b.getLineEnds().first);
            AnnotatingController annotatingController = p1Var.b;
            annotatingController.setLineEnds(lineEndType, annotatingController.getLineEnds().first);
            return;
        }
        AnnotationPreferencesManager annotationPreferences2 = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences2.getClass();
        annotationPreferences2.setLineEnds(annotationTool, annotationToolVariant, p1Var.b.getLineEnds().first, lineEndType);
        AnnotatingController annotatingController2 = p1Var.b;
        annotatingController2.setLineEnds(annotatingController2.getLineEnds().first, lineEndType);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, SliderPickerInspectorView sliderPickerInspectorView, int i) {
        sliderPickerInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        float f = i;
        annotationPreferences.setThickness(annotationTool, annotationToolVariant, f);
        p1Var.b.setThickness(f);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, BorderStylePickerInspectorView borderStylePickerInspectorView, BorderStylePreset borderStylePreset) {
        borderStylePickerInspectorView.getClass();
        borderStylePreset.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setBorderStylePreset(annotationTool, annotationToolVariant, borderStylePreset);
        p1Var.b.setBorderStylePreset(borderStylePreset);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFillColor(annotationTool, annotationToolVariant, i);
        p1Var.b.setFillColor(i);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Font font) {
        font.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setFont(annotationTool, annotationToolVariant, font);
        p1Var.b.setFont(font);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, TextInputInspectorView textInputInspectorView, String str) {
        textInputInspectorView.getClass();
        str.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setOverlayText(annotationTool, annotationToolVariant, str);
        p1Var.b.setOverlayText(str);
    }

    public static final void a(p1 p1Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, TogglePickerInspectorView togglePickerInspectorView, boolean z) {
        togglePickerInspectorView.getClass();
        AnnotationPreferencesManager annotationPreferences = p1Var.a().getFragment().getAnnotationPreferences();
        annotationPreferences.getClass();
        annotationPreferences.setRepeatOverlayText(annotationTool, annotationToolVariant, z);
        p1Var.b.setRepeatOverlayText(z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x0425  */
    /* JADX WARN: Code duplicated, block: B:102:0x0427  */
    /* JADX WARN: Code duplicated, block: B:116:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:47:0x015a  */
    /* JADX WARN: Code duplicated, block: B:54:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x0214  */
    /* JADX WARN: Code duplicated, block: B:99:0x03d9  */
    public final List<PropertyInspectorView> a(final AnnotationTool annotationTool, final AnnotationToolVariant annotationToolVariant) {
        FontPickerInspectorView fontPickerInspectorView;
        TextInputInspectorView textInputInspectorView;
        TogglePickerInspectorView togglePickerInspectorView;
        ColorPickerInspectorView colorPickerInspectorViewA;
        boolean z;
        ColorPickerInspectorView colorPickerInspectorViewA2;
        ColorPickerInspectorView colorPickerInspectorViewA3;
        SliderPickerInspectorView sliderPickerInspectorViewA;
        SliderPickerInspectorView sliderPickerInspectorViewA2;
        BorderStylePickerInspectorView borderStylePickerInspectorViewA;
        final AnnotationToolVariant annotationToolVariant2;
        final AnnotationTool annotationTool2;
        int fillColor;
        ColorPickerInspectorView.ColorPickerListener colorPickerListener;
        ColorPickerInspectorView colorPickerInspectorViewB;
        ColorPickerInspectorDetailView colorPickerInspectorDetailView;
        annotationTool.getClass();
        annotationToolVariant.getClass();
        if (annotationTool != AnnotationTool.SIGNATURE && annotationTool != AnnotationTool.NOTE) {
            final ArrayList arrayList = new ArrayList();
            int[] iArr = p10.a.b;
            int i = iArr[annotationTool.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                arrayList.add(new rk(n1.a(this.b)));
            }
            AnnotationConfigurationRegistry annotationConfiguration = this.b.getFragment().getAnnotationConfiguration();
            annotationConfiguration.getClass();
            AnnotationPreviewConfiguration annotationPreviewConfiguration = (AnnotationPreviewConfiguration) annotationConfiguration.get(annotationTool, annotationToolVariant, AnnotationPreviewConfiguration.class);
            AnnotationType annotationType = annotationTool.toAnnotationType();
            annotationType.getClass();
            if (annotationPreviewConfiguration != null && annotationPreviewConfiguration.isPreviewEnabled()) {
                switch (b.a[annotationTool.ordinal()]) {
                    case 1:
                        arrayList.add(new FreeTextAnnotationPreviewInspectorView(n1.a(this.b), this.b));
                        break;
                    case 2:
                    case 3:
                        arrayList.add(new InkAnnotationPreviewInspectorView(n1.a(this.b), this.b));
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        arrayList.add(new ShapeAnnotationPreviewInspectorView(n1.a(this.b), annotationType, this.b));
                        break;
                    case 9:
                        arrayList.add(new RedactionAnnotationPreviewInspectorView(n1.a(this.b), this.b));
                        break;
                    case 10:
                        AnnotationConfigurationRegistry annotationConfiguration2 = this.b.getFragment().getAnnotationConfiguration();
                        annotationConfiguration2.getClass();
                        AnnotationThicknessConfiguration annotationThicknessConfiguration = (AnnotationThicknessConfiguration) annotationConfiguration2.get(annotationTool, annotationToolVariant, AnnotationThicknessConfiguration.class);
                        if (annotationThicknessConfiguration != null) {
                            arrayList.add(new EraserPreviewInspectorView(n1.a(this.b), this.b, annotationThicknessConfiguration));
                        }
                        break;
                }
            }
            Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return p1.a(arrayList, (PropertyInspectorView) obj);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.SCALE)) {
                function1.invoke(a(e60.a, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda10
                    @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
                    public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
                        p1.a(this.f$0, measurementValueConfiguration);
                    }
                }));
            }
            int i2 = iArr[annotationTool.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                arrayList.add(new qk(n1.a(this.b)));
            }
            Font font = this.b.getFont();
            font.getClass();
            FontPickerInspectorView.FontPickerListener fontPickerListener = new FontPickerInspectorView.FontPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda11
                @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorView.FontPickerListener
                public final void onFontSelected(Font font2) {
                    p1.a(this.f$0, annotationTool, annotationToolVariant, font2);
                }
            };
            SliderPickerInspectorView sliderPickerInspectorViewA3 = null;
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.FONT)) {
                AnnotationConfigurationRegistry annotationConfiguration3 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration3.getClass();
                AnnotationFontConfiguration annotationFontConfiguration = (AnnotationFontConfiguration) annotationConfiguration3.get(annotationTool, annotationToolVariant, AnnotationFontConfiguration.class);
                if (annotationFontConfiguration == null || annotationFontConfiguration.getAvailableFonts().isEmpty()) {
                    fontPickerInspectorView = null;
                } else {
                    Context contextRequireContext = a().getFragment().requireContext();
                    contextRequireContext.getClass();
                    fontPickerInspectorView = new FontPickerInspectorView(contextRequireContext, annotationFontConfiguration.getAvailableFonts(), font, fontPickerListener);
                    fontPickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_font_picker);
                }
            } else {
                fontPickerInspectorView = null;
            }
            function1.invoke(fontPickerInspectorView);
            String overlayText = this.b.getOverlayText();
            overlayText.getClass();
            TextInputInspectorView.TextInputListener textInputListener = new TextInputInspectorView.TextInputListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda12
                @Override // com.pspdfkit.ui.inspector.views.TextInputInspectorView.TextInputListener
                public final void onValuePicked(TextInputInspectorView textInputInspectorView2, String str) {
                    p1.a(this.f$0, annotationTool, annotationToolVariant, textInputInspectorView2, str);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.OVERLAY_TEXT)) {
                AnnotationConfigurationRegistry annotationConfiguration4 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration4.getClass();
                if (((AnnotationOverlayTextConfiguration) annotationConfiguration4.get(annotationTool, annotationToolVariant, AnnotationOverlayTextConfiguration.class)) == null) {
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
            boolean repeatOverlayText = this.b.getRepeatOverlayText();
            TogglePickerInspectorView.TogglePickerListener togglePickerListener = new TogglePickerInspectorView.TogglePickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda13
                @Override // com.pspdfkit.ui.inspector.views.TogglePickerInspectorView.TogglePickerListener
                public final void onSelectionChanged(TogglePickerInspectorView togglePickerInspectorView2, boolean z2) {
                    p1.a(this.f$0, annotationTool, annotationToolVariant, togglePickerInspectorView2, z2);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.REPEAT_OVERLAY_TEXT)) {
                AnnotationConfigurationRegistry annotationConfiguration5 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration5.getClass();
                if (((AnnotationOverlayTextConfiguration) annotationConfiguration5.get(annotationTool, annotationToolVariant, AnnotationOverlayTextConfiguration.class)) == null) {
                    togglePickerInspectorView = null;
                } else {
                    Context contextRequireContext4 = a().getFragment().requireContext();
                    contextRequireContext4.getClass();
                    Context contextRequireContext5 = a().getFragment().requireContext();
                    contextRequireContext5.getClass();
                    togglePickerInspectorView = new TogglePickerInspectorView(contextRequireContext4, no.a(contextRequireContext5, R.string.pspdf__edit_menu_repeat_overlay_text, null), "", "", repeatOverlayText, togglePickerListener);
                    togglePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_repeat_overlay_text_picker);
                }
            } else {
                togglePickerInspectorView = null;
            }
            function1.invoke(togglePickerInspectorView);
            int color = this.b.getColor();
            ColorPickerInspectorView.ColorPickerListener colorPickerListener2 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda14
                @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i3) {
                    p1.c(this.f$0, annotationTool, annotationToolVariant, propertyInspectorView, i3);
                }
            };
            AnnotationConfigurationRegistry annotationConfigurationRegistryA = o1.a(this.b);
            AnnotationProperty annotationProperty = AnnotationProperty.COLOR;
            if (annotationConfigurationRegistryA.isAnnotationPropertySupported(annotationTool, annotationToolVariant, annotationProperty)) {
                AnnotationConfigurationRegistry annotationConfiguration6 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration6.getClass();
                colorPickerInspectorViewA = a((AnnotationColorConfiguration) annotationConfiguration6.get(annotationTool, annotationToolVariant, AnnotationColorConfiguration.class), color, o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.TEXT_SIZE), colorPickerListener2);
            } else {
                colorPickerInspectorViewA = null;
            }
            if (colorPickerInspectorViewA != null) {
                arrayList.add(colorPickerInspectorViewA);
                z = true;
            } else {
                z = false;
            }
            int outlineColor = this.b.getOutlineColor();
            ColorPickerInspectorView.ColorPickerListener colorPickerListener3 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda1
                @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i3) {
                    p1.d(this.f$0, annotationTool, annotationToolVariant, propertyInspectorView, i3);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.OUTLINE_COLOR)) {
                AnnotationConfigurationRegistry annotationConfiguration7 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration7.getClass();
                colorPickerInspectorViewA2 = a((AnnotationOutlineColorConfiguration) annotationConfiguration7.get(annotationTool, annotationToolVariant, AnnotationOutlineColorConfiguration.class), outlineColor, colorPickerListener3);
            } else {
                colorPickerInspectorViewA2 = null;
            }
            function1.invoke(colorPickerInspectorViewA2);
            int fillColor2 = this.b.getFillColor();
            ColorPickerInspectorView.ColorPickerListener colorPickerListener4 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda2
                @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i3) {
                    p1.e(this.f$0, annotationTool, annotationToolVariant, propertyInspectorView, i3);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.FILL_COLOR)) {
                AnnotationConfigurationRegistry annotationConfiguration8 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration8.getClass();
                colorPickerInspectorViewA3 = a((AnnotationFillColorConfiguration) annotationConfiguration8.get(annotationTool, annotationToolVariant, AnnotationFillColorConfiguration.class), fillColor2, colorPickerListener4);
            } else {
                colorPickerInspectorViewA3 = null;
            }
            function1.invoke(colorPickerInspectorViewA3);
            float thickness = this.b.getThickness();
            SliderPickerInspectorView.SliderPickerListener sliderPickerListener = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda3
                @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView, int i3) {
                    p1.a(this.f$0, annotationTool, annotationToolVariant, sliderPickerInspectorView, i3);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.THICKNESS)) {
                AnnotationConfigurationRegistry annotationConfiguration9 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration9.getClass();
                sliderPickerInspectorViewA = a((AnnotationThicknessConfiguration) annotationConfiguration9.get(annotationTool, annotationToolVariant, AnnotationThicknessConfiguration.class), thickness, sliderPickerListener);
            } else {
                sliderPickerInspectorViewA = null;
            }
            function1.invoke(sliderPickerInspectorViewA);
            float textSize = this.b.getTextSize();
            SliderPickerInspectorView.SliderPickerListener sliderPickerListener2 = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda4
                @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView, int i3) {
                    p1.b(this.f$0, annotationTool, annotationToolVariant, sliderPickerInspectorView, i3);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.TEXT_SIZE)) {
                AnnotationConfigurationRegistry annotationConfiguration10 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration10.getClass();
                sliderPickerInspectorViewA2 = a((AnnotationTextSizeConfiguration) annotationConfiguration10.get(annotationTool, annotationToolVariant, AnnotationTextSizeConfiguration.class), textSize, sliderPickerListener2);
            } else {
                sliderPickerInspectorViewA2 = null;
            }
            function1.invoke(sliderPickerInspectorViewA2);
            BorderStylePreset borderStylePreset = this.b.getBorderStylePreset();
            borderStylePreset.getClass();
            BorderStylePickerInspectorView.BorderStylePickerListener borderStylePickerListener = new BorderStylePickerInspectorView.BorderStylePickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda6
                @Override // com.pspdfkit.ui.inspector.views.BorderStylePickerInspectorView.BorderStylePickerListener
                public final void onBorderStylePicked(BorderStylePickerInspectorView borderStylePickerInspectorView, BorderStylePreset borderStylePreset2) {
                    p1.a(this.f$0, annotationTool, annotationToolVariant, borderStylePickerInspectorView, borderStylePreset2);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool, annotationToolVariant, AnnotationProperty.BORDER_STYLE)) {
                AnnotationConfigurationRegistry annotationConfiguration11 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration11.getClass();
                borderStylePickerInspectorViewA = a((AnnotationBorderStyleConfiguration) annotationConfiguration11.get(annotationTool, annotationToolVariant, AnnotationBorderStyleConfiguration.class), borderStylePreset, borderStylePickerListener);
            } else {
                borderStylePickerInspectorViewA = null;
            }
            function1.invoke(borderStylePickerInspectorViewA);
            int i3 = b.a[annotationTool.ordinal()];
            if (i3 != 4 && i3 != 8) {
                switch (i3) {
                    case 11:
                        LineEndType lineEndType = this.b.getLineEnds().first;
                        lineEndType.getClass();
                        function1.invoke(a(annotationTool, annotationToolVariant, lineEndType, false, true));
                        annotationTool2 = annotationTool;
                        annotationToolVariant2 = annotationToolVariant;
                        break;
                    case 12:
                    case 13:
                        LineEndType lineEndType2 = this.b.getLineEnds().first;
                        lineEndType2.getClass();
                        annotationToolVariant2 = annotationToolVariant;
                        function1.invoke(a(annotationTool, annotationToolVariant2, lineEndType2, true, false));
                        LineEndType lineEndType3 = this.b.getLineEnds().second;
                        lineEndType3.getClass();
                        LineEndType lineEndType4 = lineEndType3;
                        annotationTool2 = annotationTool;
                        function1.invoke(a(annotationTool2, annotationToolVariant2, lineEndType4, false, false));
                        fillColor = this.b.getFillColor();
                        colorPickerListener = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda7
                            @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                            public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i4) {
                                p1.a(this.f$0, annotationTool2, annotationToolVariant2, propertyInspectorView, i4);
                            }
                        };
                        if (o1.a(this.b).isAnnotationPropertySupported(annotationTool2, annotationToolVariant2, AnnotationProperty.LINE_ENDS_FILL_COLOR)) {
                            AnnotationConfigurationRegistry annotationConfiguration12 = this.b.getFragment().getAnnotationConfiguration();
                            annotationConfiguration12.getClass();
                            colorPickerInspectorViewB = b((AnnotationFillColorConfiguration) annotationConfiguration12.get(annotationTool2, annotationToolVariant2, AnnotationFillColorConfiguration.class), fillColor, colorPickerListener);
                        } else {
                            colorPickerInspectorViewB = null;
                        }
                        function1.invoke(colorPickerInspectorViewB);
                        break;
                    default:
                        annotationTool2 = annotationTool;
                        annotationToolVariant2 = annotationToolVariant;
                        break;
                }
            } else {
                LineEndType lineEndType5 = this.b.getLineEnds().first;
                lineEndType5.getClass();
                annotationToolVariant2 = annotationToolVariant;
                function1.invoke(a(annotationTool, annotationToolVariant2, lineEndType5, true, false));
                LineEndType lineEndType6 = this.b.getLineEnds().second;
                lineEndType6.getClass();
                LineEndType lineEndType7 = lineEndType6;
                annotationTool2 = annotationTool;
                function1.invoke(a(annotationTool2, annotationToolVariant2, lineEndType7, false, false));
                fillColor = this.b.getFillColor();
                colorPickerListener = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda7
                    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                    public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i4) {
                        p1.a(this.f$0, annotationTool2, annotationToolVariant2, propertyInspectorView, i4);
                    }
                };
                if (o1.a(this.b).isAnnotationPropertySupported(annotationTool2, annotationToolVariant2, AnnotationProperty.LINE_ENDS_FILL_COLOR)) {
                    colorPickerInspectorViewB = null;
                } else {
                    AnnotationConfigurationRegistry annotationConfiguration13 = this.b.getFragment().getAnnotationConfiguration();
                    annotationConfiguration13.getClass();
                    colorPickerInspectorViewB = b((AnnotationFillColorConfiguration) annotationConfiguration13.get(annotationTool2, annotationToolVariant2, AnnotationFillColorConfiguration.class), fillColor, colorPickerListener);
                }
                function1.invoke(colorPickerInspectorViewB);
            }
            if (z && arrayList.size() == 1) {
                int color2 = this.b.getColor();
                ColorPickerInspectorView.ColorPickerListener colorPickerListener5 = new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda8
                    @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
                    public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i4) {
                        p1.b(this.f$0, annotationTool2, annotationToolVariant2, propertyInspectorView, i4);
                    }
                };
                AnnotationConfigurationRegistry annotationConfiguration14 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration14.getClass();
                if (annotationConfiguration14.isAnnotationPropertySupported(annotationTool2, annotationToolVariant2, annotationProperty)) {
                    AnnotationConfigurationRegistry annotationConfiguration15 = this.b.getFragment().getAnnotationConfiguration();
                    annotationConfiguration15.getClass();
                    AnnotationColorConfiguration annotationColorConfiguration = (AnnotationColorConfiguration) annotationConfiguration15.get(annotationTool2, annotationToolVariant2, AnnotationColorConfiguration.class);
                    if (annotationColorConfiguration == null || !m2.a(annotationColorConfiguration.getAvailableColors())) {
                        colorPickerInspectorDetailView = null;
                    } else {
                        List<Integer> availableColors = annotationColorConfiguration.getAvailableColors();
                        availableColors.getClass();
                        m2.a(color2, availableColors);
                        Context contextRequireContext6 = a().getFragment().requireContext();
                        contextRequireContext6.getClass();
                        colorPickerInspectorDetailView = new ColorPickerInspectorDetailView(contextRequireContext6, annotationColorConfiguration.getAvailableColors(), color2, false);
                        colorPickerInspectorDetailView.setOnColorPickedListener(colorPickerListener5);
                        colorPickerInspectorDetailView.setId(R.id.pspdf__annotation_inspector_view_foreground_color_picker);
                    }
                } else {
                    colorPickerInspectorDetailView = null;
                }
                if (colorPickerInspectorDetailView != null) {
                    arrayList.clear();
                    arrayList.add(colorPickerInspectorDetailView);
                }
            }
            float alpha = this.b.getAlpha();
            SliderPickerInspectorView.SliderPickerListener sliderPickerListener3 = new SliderPickerInspectorView.SliderPickerListener() { // from class: com.pspdfkit.internal.p1$$ExternalSyntheticLambda9
                @Override // com.pspdfkit.ui.inspector.views.SliderPickerInspectorView.SliderPickerListener
                public final void onValuePicked(SliderPickerInspectorView sliderPickerInspectorView, int i4) {
                    p1.c(this.f$0, annotationTool2, annotationToolVariant2, sliderPickerInspectorView, i4);
                }
            };
            if (o1.a(this.b).isAnnotationPropertySupported(annotationTool2, annotationToolVariant2, AnnotationProperty.ANNOTATION_ALPHA)) {
                AnnotationConfigurationRegistry annotationConfiguration16 = this.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration16.getClass();
                sliderPickerInspectorViewA3 = a((AnnotationAlphaConfiguration) annotationConfiguration16.get(annotationTool2, annotationToolVariant2, AnnotationAlphaConfiguration.class), alpha, sliderPickerListener3);
            }
            function1.invoke(sliderPickerInspectorViewA3);
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public static final Unit a(List list, PropertyInspectorView propertyInspectorView) {
        if (propertyInspectorView != null) {
            list.add(propertyInspectorView);
        }
        return Unit.INSTANCE;
    }

    public static final void a(p1 p1Var, MeasurementValueConfiguration measurementValueConfiguration) {
        if (measurementValueConfiguration == null) {
            measurementValueConfiguration = MeasurementValueConfiguration.INSTANCE.defaultConfiguration();
        }
        p1Var.b.setMeasurementValueConfiguration(measurementValueConfiguration);
    }
}
