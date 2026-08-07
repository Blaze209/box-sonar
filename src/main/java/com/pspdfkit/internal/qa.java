package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.ColorPickerInspectorView;
import com.pspdfkit.ui.inspector.views.ContentEditingFontNamesPickerView;
import com.pspdfkit.ui.inspector.views.ContentEditingFontSizesPickerView;
import com.pspdfkit.ui.inspector.views.ContentEditingLineSpacingPickerView;
import com.pspdfkit.ui.inspector.views.CustomColorPickerInspectorDetailView;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class qa {
    public final ContentEditingController a;
    public final Context b;
    public final ContentEditingFillColorConfiguration c;
    public final e50 d;

    public qa(ContentEditingController contentEditingController) {
        contentEditingController.getClass();
        this.a = contentEditingController;
        Context contextRequireContext = contentEditingController.getFragment().requireContext();
        contextRequireContext.getClass();
        this.b = contextRequireContext;
        ContentEditingFillColorConfiguration contentEditingConfiguration = contentEditingController.getFragment().getContentEditingConfiguration();
        contentEditingConfiguration.getClass();
        this.c = contentEditingConfiguration;
        e50 e50VarC = ar.c();
        e50VarC.getClass();
        this.d = e50VarC;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    /* JADX WARN: Code duplicated, block: B:32:0x0093  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae A[PHI: r7
      0x00ae: PHI (r7v5 com.pspdfkit.ui.fonts.Font) = (r7v2 com.pspdfkit.ui.fonts.Font), (r7v3 com.pspdfkit.ui.fonts.Font), (r7v4 com.pspdfkit.ui.fonts.Font) binds: [B:38:0x00ac, B:41:0x00bd, B:44:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x0129  */
    public final ContentEditingFontNamesPickerView a(List list, final ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
        Object obj;
        Font font;
        List listPlus;
        Object font2;
        Font font3;
        FontPickerInspectorView.FontPickerListener fontPickerListener = new FontPickerInspectorView.FontPickerListener() { // from class: com.pspdfkit.internal.qa$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorView.FontPickerListener
            public final void onFontSelected(Font font4) {
                qa.a(contentEditingFormatter, font4);
            }
        };
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            Map<String, Integer> map = e50.e;
            if (!e50.a.a(((pg) obj2).a)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= size) {
                break;
            }
            Object obj3 = arrayList.get(i2);
            i2++;
            pg pgVar = (pg) obj3;
            Iterator<T> it = pgVar.b.iterator();
            do {
                if (!it.hasNext()) {
                    font2 = null;
                    break;
                }
                qg qgVar = (qg) it.next();
                e50 e50Var = this.d;
                String str = qgVar.d;
                e50Var.getClass();
                if (str == null) {
                    font3 = null;
                } else {
                    if (str.length() == 0) {
                        str = null;
                    }
                    if (str == null) {
                        font3 = null;
                    } else {
                        font3 = (Font) BuildersKt__BuildersKt.runBlocking$default(null, new f50(e50Var, str, null), 1, null);
                    }
                }
                if (font3 == null) {
                    font2 = null;
                } else {
                    if (font3.getDefaultTypeface() == null) {
                        font3 = null;
                    }
                    if (font3 != null) {
                        String str2 = pgVar.a;
                        Typeface defaultTypeface = font3.getDefaultTypeface();
                        if (defaultTypeface == null) {
                            defaultTypeface = Typeface.DEFAULT;
                        }
                        font2 = new Font(str2, defaultTypeface);
                    } else {
                        font2 = null;
                    }
                }
            } while (font2 == null);
            if (font2 == null) {
                String str3 = pgVar.a;
                str3.getClass();
                Font font4 = dm.b.b;
                font4.getClass();
                if (!StringsKt.equals(str3, font4.getName(), true)) {
                    font4 = dm.a.b;
                    font4.getClass();
                    if (!StringsKt.equals(str3, font4.getName(), true)) {
                        font4 = dm.c.b;
                        font4.getClass();
                        obj = StringsKt.equals(str3, font4.getName(), true) ? font4 : null;
                    }
                }
                font2 = obj != null ? obj : new Font(pgVar.a, Typeface.DEFAULT);
            }
            arrayList2.add(font2);
        }
        if (styleInfo != null && !styleInfo.isFontResolved()) {
            font = new Font(styleInfo.getFontNameForDisplay(this.b), null, null, 6, null);
            listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(font), (Iterable) arrayList2);
        } else if (styleInfo != null) {
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj4 = arrayList2.get(i);
                i++;
                if (Intrinsics.areEqual(((Font) obj4).getName(), styleInfo.getFontNameForDisplay(this.b))) {
                    obj = obj4;
                    break;
                }
            }
            font = (Font) obj;
            listPlus = arrayList2;
            if (font == null) {
                font = (Font) CollectionsKt.first((List) arrayList2);
                listPlus = arrayList2;
            }
        } else {
            font = (Font) CollectionsKt.first((List) arrayList2);
            listPlus = arrayList2;
        }
        return new ContentEditingFontNamesPickerView(this.b, listPlus, font, fontPickerListener);
    }

    public final ContentEditingFontSizesPickerView b(final ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
        Integer num;
        String formattedPointSize;
        Object next;
        List<Integer> availableFontSizes = contentEditingFormatter.getAvailableFontSizes();
        String formattedPointSize2 = null;
        if (styleInfo == null || (formattedPointSize = styleInfo.getFormattedPointSize()) == null) {
            num = null;
        } else {
            Iterator<T> it = availableFontSizes.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!String.valueOf(((Number) next).intValue()).equals(formattedPointSize));
            num = (Integer) next;
        }
        if (num == null && styleInfo != null) {
            formattedPointSize2 = styleInfo.getFormattedPointSize();
        }
        return new ContentEditingFontSizesPickerView(this.b, availableFontSizes, num, formattedPointSize2, new FontPickerInspectorView.FontSizePickerListener() { // from class: com.pspdfkit.internal.qa$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorView.FontSizePickerListener
            public final void onFontSelected(Integer num2) {
                qa.a(contentEditingFormatter, num2);
            }
        });
    }

    public static final void a(ContentEditingFormatter contentEditingFormatter, Font font) {
        font.getClass();
        contentEditingFormatter.setFaceName(font.getName());
    }

    public static final void a(ContentEditingFormatter contentEditingFormatter, Integer num) {
        num.getClass();
        contentEditingFormatter.setFontSize(num.intValue());
    }

    public final ContentEditingLineSpacingPickerView a(final ContentEditingFormatter contentEditingFormatter, Float f) {
        Float f2;
        Object next;
        List listListOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(1.0f), Float.valueOf(1.15f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
        if (f != null) {
            float fFloatValue = f.floatValue();
            Iterator it = listListOf.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!ip.a(((Number) next).floatValue(), fFloatValue));
            f2 = (Float) next;
        } else {
            f2 = null;
        }
        return new ContentEditingLineSpacingPickerView(this.b, listListOf, f2, f2 != null ? null : f, new ContentEditingLineSpacingPickerView.LineSpacingPickerListener() { // from class: com.pspdfkit.internal.qa$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.ui.inspector.views.ContentEditingLineSpacingPickerView.LineSpacingPickerListener
            public final void onLineSpacingSelected(float f3) {
                qa.a(contentEditingFormatter, f3);
            }
        });
    }

    public static final void a(ContentEditingFormatter contentEditingFormatter, float f) {
        contentEditingFormatter.setLineSpacing(f);
    }

    public final View a(final ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
        ColorPickerInspectorView.ColorPickerDetailView colorPickerInspectorDetailView;
        Integer colorInt;
        boolean zCustomColorPickerEnabled = this.c.customColorPickerEnabled();
        List<Integer> availableFillColors = this.c.getAvailableFillColors();
        availableFillColors.getClass();
        int defaultFillColor = (styleInfo == null || (colorInt = styleInfo.getColorInt()) == null) ? this.c.getDefaultFillColor() : colorInt.intValue();
        if (zCustomColorPickerEnabled) {
            colorPickerInspectorDetailView = new CustomColorPickerInspectorDetailView(this.b, availableFillColors, defaultFillColor);
        } else {
            colorPickerInspectorDetailView = new ColorPickerInspectorDetailView(this.b, availableFillColors, defaultFillColor, false);
        }
        colorPickerInspectorDetailView.setOnColorPickedListener(new ColorPickerInspectorView.ColorPickerListener() { // from class: com.pspdfkit.internal.qa$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.ui.inspector.views.ColorPickerInspectorView.ColorPickerListener
            public final void onColorPicked(PropertyInspectorView propertyInspectorView, int i) {
                qa.a(contentEditingFormatter, propertyInspectorView, i);
            }
        });
        View view = colorPickerInspectorDetailView.getView();
        view.getClass();
        return view;
    }

    public static final void a(ContentEditingFormatter contentEditingFormatter, PropertyInspectorView propertyInspectorView, int i) {
        propertyInspectorView.getClass();
        contentEditingFormatter.setFontColor(i);
    }
}
