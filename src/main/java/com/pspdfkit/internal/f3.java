package com.pspdfkit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationAlphaConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationFontConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationLineEndsConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationNoteIconConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOverlayTextConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationTextSizeConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f3 implements AnnotationPreferencesManager {
    public final Context a;
    public final vw b;
    public final PSPDFKitPreferences c;
    public final k1 d;

    public f3(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = new vw(applicationContext, "PSPDFKit");
        this.d = new k1(applicationContext);
        this.c = PSPDFKitPreferences.get(applicationContext);
    }

    public static String a(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        return annotationToolVariant.getName() == null ? annotationTool.name() : annotationTool.name() + "_" + annotationToolVariant.getName();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getAlpha(AnnotationTool annotationTool) {
        return getAlpha(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getAnnotationCreator() {
        return this.c.getAnnotationCreator(null);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool) {
        return getBorderStylePreset(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getColor(AnnotationTool annotationTool) {
        return getColor(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getFillColor(AnnotationTool annotationTool) {
        return getFillColor(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Font getFont(AnnotationTool annotationTool) {
        return getFont(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool) {
        return getLineEnds(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getNoteAnnotationIcon(AnnotationTool annotationTool) {
        return getNoteAnnotationIcon(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getOutlineColor(AnnotationTool annotationTool) {
        return getOutlineColor(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getOverlayText(AnnotationTool annotationTool) {
        return getOverlayText(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean getRepeatOverlayText(AnnotationTool annotationTool) {
        return getRepeatOverlayText(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getTextSize(AnnotationTool annotationTool) {
        return getTextSize(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getThickness(AnnotationTool annotationTool) {
        return getThickness(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean isAnnotationCreatorSet() {
        return this.c.getAnnotationCreator(null) != null;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean isMeasurementSnappingEnabled() {
        return this.c.isMeasurementSnappingEnabled().booleanValue();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setAlpha(AnnotationTool annotationTool, float f) {
        setAlpha(annotationTool, AnnotationToolVariant.defaultVariant(), f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setBorderStylePreset(AnnotationTool annotationTool, BorderStylePreset borderStylePreset) {
        setBorderStylePreset(annotationTool, AnnotationToolVariant.defaultVariant(), borderStylePreset);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setColor(AnnotationTool annotationTool, int i) {
        setColor(annotationTool, AnnotationToolVariant.defaultVariant(), i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFillColor(AnnotationTool annotationTool, int i) {
        setFillColor(annotationTool, AnnotationToolVariant.defaultVariant(), i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFont(AnnotationTool annotationTool, Font font) {
        setFont(annotationTool, AnnotationToolVariant.defaultVariant(), font);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setLineEnds(AnnotationTool annotationTool, LineEndType lineEndType, LineEndType lineEndType2) {
        setLineEnds(annotationTool, AnnotationToolVariant.defaultVariant(), lineEndType, lineEndType2);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setMeasurementSnappingEnabled(boolean z) {
        if (this.c.isMeasurementSnappingEnabled().booleanValue() != z) {
            this.c.setMeasurementSnappingEnabled(z);
        }
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setNoteAnnotationIcon(AnnotationTool annotationTool, String str) {
        setNoteAnnotationIcon(annotationTool, AnnotationToolVariant.defaultVariant(), str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOutlineColor(AnnotationTool annotationTool, int i) {
        setOutlineColor(annotationTool, AnnotationToolVariant.defaultVariant(), i);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOverlayText(AnnotationTool annotationTool, String str) {
        setOverlayText(annotationTool, AnnotationToolVariant.defaultVariant(), str);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setRepeatOverlayText(AnnotationTool annotationTool, boolean z) {
        setRepeatOverlayText(annotationTool, AnnotationToolVariant.defaultVariant(), z);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setTextSize(AnnotationTool annotationTool, float f) {
        setTextSize(annotationTool, AnnotationToolVariant.defaultVariant(), f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setThickness(AnnotationTool annotationTool, float f) {
        setThickness(annotationTool, AnnotationToolVariant.defaultVariant(), f);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationAlphaConfiguration annotationAlphaConfiguration = (AnnotationAlphaConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationAlphaConfiguration.class);
        if (annotationAlphaConfiguration == null || !annotationAlphaConfiguration.getForceDefaults()) {
            return this.b.a("annotation_preferences_alpha_" + a(annotationTool, annotationToolVariant), annotationAlphaConfiguration != null ? annotationAlphaConfiguration.getDefaultAlpha() : 1.0f);
        }
        return annotationAlphaConfiguration.getDefaultAlpha();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final BorderStylePreset getBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationBorderStyleConfiguration annotationBorderStyleConfiguration = (AnnotationBorderStyleConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationBorderStyleConfiguration.class);
        if (annotationBorderStyleConfiguration != null && annotationBorderStyleConfiguration.getForceDefaults()) {
            return annotationBorderStyleConfiguration.getDefaultBorderStylePreset();
        }
        ArrayList arrayList = null;
        String strA = this.b.a("annotation_preferences_border_style_" + a(annotationTool, annotationToolVariant), (String) null);
        String strA2 = this.b.a("annotation_preferences_border_effect_" + a(annotationTool, annotationToolVariant), (String) null);
        float fA = this.b.a("annotation_preferences_border_effect_intensity_" + a(annotationTool, annotationToolVariant), 0.0f);
        if (strA == null || strA2 == null) {
            return annotationBorderStyleConfiguration != null ? annotationBorderStyleConfiguration.getDefaultBorderStylePreset() : new BorderStylePreset(BorderStyle.SOLID);
        }
        BorderStyle borderStyleValueOf = BorderStyle.valueOf(strA);
        BorderEffect borderEffectValueOf = BorderEffect.valueOf(strA2);
        String str = "annotation_preferences_dash_array_" + a(annotationTool, annotationToolVariant);
        vw vwVar = this.b;
        vwVar.getClass();
        if (vwVar.a.contains(str)) {
            String[] strArrSplit = TextUtils.split(this.b.a(str, ""), AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
            arrayList = new ArrayList();
            for (String str2 : strArrSplit) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                    PdfLog.i("Nutri.AnnotPrefMngImpl", "Parsing string %s to Integer failed and the exception was ignored.", str2);
                }
            }
        }
        return new BorderStylePreset(borderStyleValueOf, borderEffectValueOf, fA, arrayList);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationColorConfiguration annotationColorConfiguration = (AnnotationColorConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationColorConfiguration.class);
        if (annotationColorConfiguration == null || !annotationColorConfiguration.getForceDefaults()) {
            return this.b.a("annotation_preferences_color_" + a(annotationTool, annotationToolVariant), annotationColorConfiguration != null ? annotationColorConfiguration.getDefaultColor() : ww.a(this.a, annotationTool, annotationToolVariant));
        }
        return annotationColorConfiguration.getDefaultColor();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        int defaultFillColor;
        AnnotationFillColorConfiguration annotationFillColorConfiguration = (AnnotationFillColorConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationFillColorConfiguration.class);
        if (annotationFillColorConfiguration != null && annotationFillColorConfiguration.getForceDefaults()) {
            return annotationFillColorConfiguration.getDefaultFillColor();
        }
        vw vwVar = this.b;
        String str = "annotation_preferences_fill_color_" + a(annotationTool, annotationToolVariant);
        if (annotationFillColorConfiguration != null) {
            defaultFillColor = annotationFillColorConfiguration.getDefaultFillColor();
        } else {
            float f = ww.a;
            defaultFillColor = ww.a.b[annotationTool.ordinal()] == 22 ? -16777216 : 0;
        }
        return vwVar.a(str, defaultFillColor);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Font getFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        Font fontByName;
        AnnotationFontConfiguration annotationFontConfiguration = (AnnotationFontConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationFontConfiguration.class);
        if (annotationFontConfiguration != null && annotationFontConfiguration.getForceDefaults()) {
            return annotationFontConfiguration.getDefaultFont();
        }
        String strA = this.b.a("annotation_preferences_font_" + a(annotationTool, annotationToolVariant), (String) null);
        e50 e50VarC = ar.c();
        return (strA == null || (fontByName = e50VarC.getFontByName(strA)) == null) ? e50VarC.b() : fontByName;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final Pair<LineEndType, LineEndType> getLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        LineEndType lineEndTypeValueOf;
        AnnotationLineEndsConfiguration annotationLineEndsConfiguration = (AnnotationLineEndsConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationLineEndsConfiguration.class);
        if (annotationLineEndsConfiguration != null && annotationLineEndsConfiguration.getForceDefaults()) {
            return annotationLineEndsConfiguration.getDefaultLineEnds();
        }
        LineEndType lineEndTypeValueOf2 = LineEndType.NONE;
        String strA = this.b.a("annotation_preferences_line_start_" + a(annotationTool, annotationToolVariant), (String) null);
        if (strA != null) {
            lineEndTypeValueOf = LineEndType.valueOf(strA);
        } else {
            lineEndTypeValueOf = annotationLineEndsConfiguration != null ? annotationLineEndsConfiguration.getDefaultLineEnds().first : lineEndTypeValueOf2;
        }
        String strA2 = this.b.a("annotation_preferences_line_end_" + a(annotationTool, annotationToolVariant), (String) null);
        if (strA2 != null) {
            lineEndTypeValueOf2 = LineEndType.valueOf(strA2);
        } else if (annotationLineEndsConfiguration != null) {
            lineEndTypeValueOf2 = annotationLineEndsConfiguration.getDefaultLineEnds().second;
        }
        return new Pair<>(lineEndTypeValueOf, lineEndTypeValueOf2);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationNoteIconConfiguration annotationNoteIconConfiguration = (AnnotationNoteIconConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationNoteIconConfiguration.class);
        if (annotationNoteIconConfiguration != null && annotationNoteIconConfiguration.getForceDefaults()) {
            return annotationNoteIconConfiguration.getDefaultIconName();
        }
        String strA = this.b.a("annotation_preferences_note_icon_" + a(annotationTool, annotationToolVariant), annotationNoteIconConfiguration != null ? annotationNoteIconConfiguration.getDefaultIconName() : NoteAnnotation.NOTE);
        return strA != null ? strA : NoteAnnotation.NOTE;
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final int getOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        int defaultOutlineColor;
        AnnotationOutlineColorConfiguration annotationOutlineColorConfiguration = (AnnotationOutlineColorConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationOutlineColorConfiguration.class);
        if (annotationOutlineColorConfiguration != null && annotationOutlineColorConfiguration.getForceDefaults()) {
            return annotationOutlineColorConfiguration.getDefaultOutlineColor();
        }
        vw vwVar = this.b;
        String str = "annotation_preferences_outline_color_" + a(annotationTool, annotationToolVariant);
        if (annotationOutlineColorConfiguration != null) {
            defaultOutlineColor = annotationOutlineColorConfiguration.getDefaultOutlineColor();
        } else {
            float f = ww.a;
            defaultOutlineColor = ww.a.b[annotationTool.ordinal()] == 22 ? -16777216 : 0;
        }
        return vwVar.a(str, defaultOutlineColor);
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final String getOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationOverlayTextConfiguration annotationOverlayTextConfiguration = (AnnotationOverlayTextConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationOverlayTextConfiguration.class);
        if (annotationOverlayTextConfiguration != null && annotationOverlayTextConfiguration.getForceDefaults()) {
            return annotationOverlayTextConfiguration.getDefaultOverlayText();
        }
        String strA = this.b.a("annotation_preferences_overlay_text_" + a(annotationTool, annotationToolVariant), (String) null);
        if (strA != null) {
            return strA;
        }
        return annotationOverlayTextConfiguration != null ? annotationOverlayTextConfiguration.getDefaultOverlayText() : "";
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final boolean getRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationOverlayTextConfiguration annotationOverlayTextConfiguration = (AnnotationOverlayTextConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationOverlayTextConfiguration.class);
        if (annotationOverlayTextConfiguration == null || !annotationOverlayTextConfiguration.getForceDefaults()) {
            return this.b.a("annotation_preferences_repeat_overlay_text_" + a(annotationTool, annotationToolVariant), annotationOverlayTextConfiguration != null ? annotationOverlayTextConfiguration.getDefaultRepeatOverlayTextSetting() : false);
        }
        return annotationOverlayTextConfiguration.getDefaultRepeatOverlayTextSetting();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationTextSizeConfiguration annotationTextSizeConfiguration = (AnnotationTextSizeConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationTextSizeConfiguration.class);
        if (annotationTextSizeConfiguration == null || !annotationTextSizeConfiguration.getForceDefaults()) {
            return this.b.a("annotation_preferences_text_size_" + a(annotationTool, annotationToolVariant), annotationTextSizeConfiguration != null ? annotationTextSizeConfiguration.getDefaultTextSize() : 18.0f);
        }
        return annotationTextSizeConfiguration.getDefaultTextSize();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final float getThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        AnnotationThicknessConfiguration annotationThicknessConfiguration = (AnnotationThicknessConfiguration) this.d.get(annotationTool, annotationToolVariant, AnnotationThicknessConfiguration.class);
        if (annotationThicknessConfiguration == null || !annotationThicknessConfiguration.getForceDefaults()) {
            return this.b.a("annotation_preferences_thickness_" + a(annotationTool, annotationToolVariant), annotationThicknessConfiguration != null ? annotationThicknessConfiguration.getDefaultThickness() : 5.0f);
        }
        return annotationThicknessConfiguration.getDefaultThickness();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setAlpha(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putFloat("annotation_preferences_alpha_" + a(annotationTool, annotationToolVariant), f).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setBorderStylePreset(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, BorderStylePreset borderStylePreset) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putString("annotation_preferences_border_style_" + a(annotationTool, annotationToolVariant), borderStylePreset.getBorderStyle().name());
        editorEdit.putString("annotation_preferences_border_effect_" + a(annotationTool, annotationToolVariant), borderStylePreset.getBorderEffect().name());
        editorEdit.putFloat("annotation_preferences_border_effect_intensity_" + a(annotationTool, annotationToolVariant), borderStylePreset.getBorderEffectIntensity());
        String str = "annotation_preferences_dash_array_" + a(annotationTool, annotationToolVariant);
        List<Integer> dashArray = borderStylePreset.getDashArray();
        if (dashArray != null) {
            editorEdit.putString(str, TextUtils.join(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER, dashArray.toArray(new Integer[0])));
        } else {
            editorEdit.remove(str);
        }
        editorEdit.apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putInt("annotation_preferences_color_" + a(annotationTool, annotationToolVariant), i).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFillColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putInt("annotation_preferences_fill_color_" + a(annotationTool, annotationToolVariant), i).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setFont(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Font font) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putString("annotation_preferences_font_" + a(annotationTool, annotationToolVariant), font.getName()).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setLineEnds(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, LineEndType lineEndType, LineEndType lineEndType2) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putString("annotation_preferences_line_start_" + a(annotationTool, annotationToolVariant), lineEndType.name()).apply();
        SharedPreferences.Editor editorEdit2 = this.b.a.edit();
        editorEdit2.getClass();
        editorEdit2.putString("annotation_preferences_line_end_" + a(annotationTool, annotationToolVariant), lineEndType2.name()).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setNoteAnnotationIcon(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putString("annotation_preferences_note_icon_" + a(annotationTool, annotationToolVariant), str).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOutlineColor(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, int i) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putInt("annotation_preferences_outline_color_" + a(annotationTool, annotationToolVariant), i).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, String str) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putString("annotation_preferences_overlay_text_" + annotationTool.name(), str).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setRepeatOverlayText(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, boolean z) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean("annotation_preferences_repeat_overlay_text_" + a(annotationTool, annotationToolVariant), z).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setTextSize(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putFloat("annotation_preferences_text_size_" + a(annotationTool, annotationToolVariant), f).apply();
    }

    @Override // com.pspdfkit.annotations.defaults.AnnotationPreferencesManager
    public final void setThickness(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, float f) {
        SharedPreferences.Editor editorEdit = this.b.a.edit();
        editorEdit.getClass();
        editorEdit.putFloat("annotation_preferences_thickness_" + a(annotationTool, annotationToolVariant), f).apply();
    }
}
