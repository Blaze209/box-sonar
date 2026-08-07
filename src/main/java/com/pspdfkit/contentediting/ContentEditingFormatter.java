package com.pspdfkit.contentediting;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.FaceMismatch;
import com.pspdfkit.contentediting.models.StyleInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\bH&R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/contentediting/ContentEditingFormatter;", "", "setFaceName", "", "faceName", "", "setFontSize", "size", "", "setFontColor", "color", "", "setBold", "bold", "", "setItalic", "italic", "applyFormat", "styleInfo", "Lcom/pspdfkit/contentediting/models/StyleInfo;", "availableFontSizes", "", "getAvailableFontSizes", "()Ljava/util/List;", "isIncreaseFontSizeEnabled", "currentStyleInfo", "isDecreaseFontSizeEnabled", "increaseFontSize", "decreaseFontSize", "setTextAlignment", "alignment", "Lcom/pspdfkit/contentediting/models/Alignment;", "setLineSpacing", "lineSpacing", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ContentEditingFormatter {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void decreaseFontSize(ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
            styleInfo.getClass();
            ContentEditingFormatter.super.decreaseFontSize(styleInfo);
        }

        @Deprecated
        public static void increaseFontSize(ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
            styleInfo.getClass();
            ContentEditingFormatter.super.increaseFontSize(styleInfo);
        }

        @Deprecated
        public static boolean isDecreaseFontSizeEnabled(ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
            return ContentEditingFormatter.super.isDecreaseFontSizeEnabled(styleInfo);
        }

        @Deprecated
        public static boolean isIncreaseFontSizeEnabled(ContentEditingFormatter contentEditingFormatter, StyleInfo styleInfo) {
            return ContentEditingFormatter.super.isIncreaseFontSizeEnabled(styleInfo);
        }

        @Deprecated
        public static void setBold(ContentEditingFormatter contentEditingFormatter, boolean z) {
            ContentEditingFormatter.super.setBold(z);
        }

        @Deprecated
        public static void setFaceName(ContentEditingFormatter contentEditingFormatter, String str) {
            str.getClass();
            ContentEditingFormatter.super.setFaceName(str);
        }

        @Deprecated
        public static void setFontColor(ContentEditingFormatter contentEditingFormatter, int i) {
            ContentEditingFormatter.super.setFontColor(i);
        }

        @Deprecated
        public static void setFontSize(ContentEditingFormatter contentEditingFormatter, float f) {
            ContentEditingFormatter.super.setFontSize(f);
        }

        @Deprecated
        public static void setItalic(ContentEditingFormatter contentEditingFormatter, boolean z) {
            ContentEditingFormatter.super.setItalic(z);
        }
    }

    void applyFormat(StyleInfo styleInfo);

    default void decreaseFontSize(StyleInfo currentStyleInfo) {
        currentStyleInfo.getClass();
        Float size = currentStyleInfo.getSize();
        if (size != null) {
            float fFloatValue = size.floatValue();
            float f = 1;
            int iFloor = (int) (Float.valueOf(fFloatValue % f).equals(Float.valueOf(0.0f)) ? fFloatValue - f : (float) Math.floor(fFloatValue));
            Integer num = (Integer) CollectionsKt.firstOrNull((List) getAvailableFontSizes());
            if (num == null || num.intValue() > iFloor) {
                return;
            }
            applyFormat(new StyleInfo((String) null, (FaceMismatch) null, (Boolean) null, (Boolean) null, Float.valueOf(iFloor), (Integer) null, (Float) null, (Float) null, 239, (DefaultConstructorMarker) null));
        }
    }

    List<Integer> getAvailableFontSizes();

    default void increaseFontSize(StyleInfo currentStyleInfo) {
        currentStyleInfo.getClass();
        Float size = currentStyleInfo.getSize();
        if (size != null) {
            float fFloatValue = size.floatValue();
            float f = 1;
            int iCeil = (int) (Float.valueOf(fFloatValue % f).equals(Float.valueOf(0.0f)) ? fFloatValue + f : (float) Math.ceil(fFloatValue));
            Integer num = (Integer) CollectionsKt.lastOrNull((List) getAvailableFontSizes());
            if (num == null || num.intValue() < iCeil) {
                return;
            }
            applyFormat(new StyleInfo((String) null, (FaceMismatch) null, (Boolean) null, (Boolean) null, Float.valueOf(iCeil), (Integer) null, (Float) null, (Float) null, 239, (DefaultConstructorMarker) null));
        }
    }

    default boolean isDecreaseFontSizeEnabled(StyleInfo currentStyleInfo) {
        Float size;
        Boolean boolValueOf;
        if (currentStyleInfo != null && (size = currentStyleInfo.getSize()) != null) {
            float fFloatValue = size.floatValue();
            Integer num = (Integer) CollectionsKt.firstOrNull((List) getAvailableFontSizes());
            if (num != null) {
                boolValueOf = Boolean.valueOf(fFloatValue > ((float) num.intValue()));
            } else {
                boolValueOf = null;
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return false;
    }

    default boolean isIncreaseFontSizeEnabled(StyleInfo currentStyleInfo) {
        Float size;
        Boolean boolValueOf;
        if (currentStyleInfo != null && (size = currentStyleInfo.getSize()) != null) {
            float fFloatValue = size.floatValue();
            Integer num = (Integer) CollectionsKt.lastOrNull((List) getAvailableFontSizes());
            if (num != null) {
                boolValueOf = Boolean.valueOf(fFloatValue < ((float) num.intValue()));
            } else {
                boolValueOf = null;
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return false;
    }

    default void setBold(boolean bold) {
        applyFormat(new StyleInfo((String) null, (FaceMismatch) null, Boolean.valueOf(bold), (Boolean) null, (Float) null, (Integer) null, (Float) null, (Float) null, 251, (DefaultConstructorMarker) null));
    }

    default void setFaceName(String faceName) {
        faceName.getClass();
        applyFormat(new StyleInfo(faceName, (FaceMismatch) null, (Boolean) null, (Boolean) null, (Float) null, (Integer) null, (Float) null, (Float) null, 254, (DefaultConstructorMarker) null));
    }

    default void setFontColor(int color) {
        applyFormat(new StyleInfo((String) null, (FaceMismatch) null, (Boolean) null, (Boolean) null, (Float) null, Integer.valueOf(color), (Float) null, (Float) null, 223, (DefaultConstructorMarker) null));
    }

    default void setFontSize(float size) {
        applyFormat(new StyleInfo((String) null, (FaceMismatch) null, (Boolean) null, (Boolean) null, Float.valueOf(size), (Integer) null, (Float) null, (Float) null, 239, (DefaultConstructorMarker) null));
    }

    default void setItalic(boolean italic) {
        applyFormat(new StyleInfo((String) null, (FaceMismatch) null, (Boolean) null, Boolean.valueOf(italic), (Float) null, (Integer) null, (Float) null, (Float) null, 247, (DefaultConstructorMarker) null));
    }

    void setLineSpacing(float lineSpacing);

    void setTextAlignment(Alignment alignment);
}
