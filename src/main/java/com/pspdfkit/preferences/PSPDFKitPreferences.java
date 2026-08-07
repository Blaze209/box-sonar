package com.pspdfkit.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vw;
import com.pspdfkit.internal.y40;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PSPDFKitPreferences {
    public static final String PREFERENCES_NAME = "PSPDFKit";
    private static final String PREF_ANNOTATION_CREATOR_NAME = "pref_annotation_creator_name";
    private static final String PREF_COMPARISON_FIRST_LAUNCH = "comparison_first_launch";
    private static final String PREF_LAST_ANNOTATION_TOOLS = "last_annotation_tools";
    private static final String PREF_LAST_ANNOTATION_TOOL_VARIANTS = "last_annotation_tool_variants";
    private static final String PREF_LAST_TOOLBAR_POSITION = "last_toolbar_position";
    private static final String PREF_MEASUREMENT_SNAPPING_ENABLED = "measurement_snapping_enabled";
    private static final String PREF_RECENTLY_USED_COLORS = "recently_used_colors";
    private static final String PREF_SMART_GUIDES_ENABLED = "smart_guides_enabled";
    private static final String PREF_SNAP_TO_SELF_ENABLED = "self_snapping_enabled";
    private static final String PREF_USE_STYLUS_FOR_ANNOTATING = "use_stylus_for_annotating";
    private static PSPDFKitPreferences instance;
    private final vw preferences;
    private y40 stylusSettingChangeListener;

    private PSPDFKitPreferences(vw vwVar) {
        this.preferences = vwVar;
    }

    public static synchronized PSPDFKitPreferences get(Context context) {
        if (instance == null) {
            instance = new PSPDFKitPreferences(new vw(context.getApplicationContext(), "PSPDFKit"));
        }
        return instance;
    }

    public void clearPreferences() {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        Map<String, ?> all = this.preferences.a.getAll();
        all.getClass();
        Iterator<String> it = all.keySet().iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    public String getAnnotationCreator(String str) {
        return this.preferences.a(PREF_ANNOTATION_CREATOR_NAME, str);
    }

    public List<Pair<AnnotationTool, AnnotationToolVariant>> getLastAnnotationTools() {
        String strA = this.preferences.a(PREF_LAST_ANNOTATION_TOOLS, (String) null);
        String strA2 = this.preferences.a(PREF_LAST_ANNOTATION_TOOL_VARIANTS, (String) null);
        ArrayList arrayList = new ArrayList();
        if (strA != null) {
            String[] strArrSplit = strA.substring(1, strA.length() - 1).split(", ");
            String[] strArrSplit2 = new String[strArrSplit.length];
            if (strA2 != null && strA2.length() > 2) {
                strArrSplit2 = strA2.substring(1, strA2.length() - 1).split(", ");
            }
            int i = 0;
            while (i < strArrSplit.length) {
                int i2 = Integer.parseInt(strArrSplit[i]);
                String str = strArrSplit2.length > i ? strArrSplit2[i] : null;
                if (i2 < AnnotationTool.values().length) {
                    arrayList.add(new Pair(AnnotationTool.values()[i2], (str == null || str.equals("_")) ? AnnotationToolVariant.defaultVariant() : AnnotationToolVariant.fromName(str)));
                }
                i++;
            }
        }
        return arrayList;
    }

    public ToolbarCoordinatorLayout.LayoutParams.Position getLastToolbarPosition(ContextualToolbar contextualToolbar, ToolbarCoordinatorLayout.LayoutParams.Position position) {
        int iA = this.preferences.a("last_toolbar_position_" + contextualToolbar.getId(), position.ordinal());
        return (iA < 0 || iA >= ToolbarCoordinatorLayout.LayoutParams.Position.values().length) ? position : ToolbarCoordinatorLayout.LayoutParams.Position.values()[iA];
    }

    public List<Integer> getRecentlyUsedColors() {
        String strA = this.preferences.a(PREF_RECENTLY_USED_COLORS, (String) null);
        ArrayList arrayList = new ArrayList();
        if (strA != null && strA.length() >= 2) {
            for (String str : strA.substring(1, strA.length() - 1).split(", ")) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public boolean isAnnotationCreatorSet() {
        return getAnnotationCreator(null) != null;
    }

    public Boolean isComparisonFirstLaunch() {
        return Boolean.valueOf(this.preferences.a(PREF_COMPARISON_FIRST_LAUNCH, true));
    }

    public Boolean isMeasurementSnappingEnabled() {
        return Boolean.valueOf(this.preferences.a(PREF_MEASUREMENT_SNAPPING_ENABLED, true));
    }

    public Boolean isSmartGuidesEnabled() {
        return Boolean.valueOf(this.preferences.a(PREF_SMART_GUIDES_ENABLED, true));
    }

    public Boolean isSnapToSelfEnabled() {
        return Boolean.valueOf(this.preferences.a(PREF_SNAP_TO_SELF_ENABLED, true));
    }

    public void resetAnnotationCreator() {
        setAnnotationCreator(null);
    }

    public void setAnnotationCreator(String str) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putString(PREF_ANNOTATION_CREATOR_NAME, str).commit();
    }

    public void setIsComparisonFirstLaunch(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean(PREF_COMPARISON_FIRST_LAUNCH, z).apply();
    }

    public void setLastAnnotationTool(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        uw.a(annotationTool, "tool", null);
        List<Pair<AnnotationTool, AnnotationToolVariant>> lastAnnotationTools = getLastAnnotationTools();
        lastAnnotationTools.remove(new Pair(annotationTool, annotationToolVariant));
        lastAnnotationTools.add(0, new Pair<>(annotationTool, annotationToolVariant));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(lastAnnotationTools.size());
        for (Pair<AnnotationTool, AnnotationToolVariant> pair : lastAnnotationTools) {
            arrayList2.add(Integer.valueOf(((AnnotationTool) pair.first).ordinal()));
            String name = ((AnnotationToolVariant) pair.second).getName();
            if (name == null) {
                name = "_";
            }
            arrayList.add(name);
        }
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putString(PREF_LAST_ANNOTATION_TOOLS, Arrays.toString(arrayList2.toArray())).apply();
        SharedPreferences.Editor editorEdit2 = this.preferences.a.edit();
        editorEdit2.getClass();
        editorEdit2.putString(PREF_LAST_ANNOTATION_TOOL_VARIANTS, Arrays.toString(arrayList.toArray())).apply();
    }

    public void setLastToolbarPosition(ContextualToolbar contextualToolbar, ToolbarCoordinatorLayout.LayoutParams.Position position) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putInt("last_toolbar_position_" + contextualToolbar.getId(), position.ordinal()).apply();
    }

    public void setMeasurementSnappingEnabled(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean(PREF_MEASUREMENT_SNAPPING_ENABLED, z).apply();
    }

    public void setRecentlyUsedColors(List<Integer> list) {
        uw.a(list, "recentlyUsedColors", null);
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putString(PREF_RECENTLY_USED_COLORS, Arrays.toString(list.toArray())).apply();
    }

    public void setSmartGuidesEnabled(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean(PREF_SMART_GUIDES_ENABLED, z).apply();
    }

    public void setSnapToSelfEnabled(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean(PREF_SNAP_TO_SELF_ENABLED, z).apply();
    }

    public void setStylusSettingChangeListener(y40 y40Var) {
        this.stylusSettingChangeListener = y40Var;
    }

    public void setUseStylusForAnnotating(boolean z) {
        SharedPreferences.Editor editorEdit = this.preferences.a.edit();
        editorEdit.getClass();
        editorEdit.putBoolean(PREF_USE_STYLUS_FOR_ANNOTATING, z).apply();
        y40 y40Var = this.stylusSettingChangeListener;
        if (y40Var != null) {
            y40Var.onStylusSettingChange(z);
        }
    }

    public Boolean useStylusForAnnotating() {
        return Boolean.valueOf(this.preferences.a(PREF_USE_STYLUS_FOR_ANNOTATING, false));
    }

    public void setLastAnnotationTool(AnnotationTool annotationTool) {
        setLastAnnotationTool(annotationTool, AnnotationToolVariant.defaultVariant());
    }
}
