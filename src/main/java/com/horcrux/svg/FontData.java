package com.horcrux.svg;

import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes14.dex */
class FontData {
    static final double DEFAULT_FONT_SIZE = 12.0d;
    private static final double DEFAULT_KERNING = 0.0d;
    private static final double DEFAULT_LETTER_SPACING = 0.0d;
    private static final double DEFAULT_WORD_SPACING = 0.0d;
    static final FontData Defaults = new FontData();
    private static final String FONT_DATA = "fontData";
    private static final String FONT_FEATURE_SETTINGS = "fontFeatureSettings";
    private static final String FONT_VARIANT_LIGATURES = "fontVariantLigatures";
    private static final String FONT_VARIATION_SETTINGS = "fontVariationSettings";
    private static final String KERNING = "kerning";
    private static final String LETTER_SPACING = "letterSpacing";
    private static final String TEXT_ANCHOR = "textAnchor";
    private static final String TEXT_DECORATION = "textDecoration";
    private static final String WORD_SPACING = "wordSpacing";
    int absoluteFontWeight;
    final ReadableMap fontData;
    final String fontFamily;
    final String fontFeatureSettings;
    final double fontSize;
    final TextProperties.FontStyle fontStyle;
    final TextProperties.FontVariantLigatures fontVariantLigatures;
    final String fontVariationSettings;
    TextProperties.FontWeight fontWeight;
    final double kerning;
    final double letterSpacing;
    final boolean manualKerning;
    final TextProperties.TextAnchor textAnchor;
    private final TextProperties.TextDecoration textDecoration;
    final double wordSpacing;

    static class AbsoluteFontWeight {
        private static final TextProperties.FontWeight[] WEIGHTS = {TextProperties.FontWeight.w100, TextProperties.FontWeight.w100, TextProperties.FontWeight.w200, TextProperties.FontWeight.w300, TextProperties.FontWeight.Normal, TextProperties.FontWeight.w500, TextProperties.FontWeight.w600, TextProperties.FontWeight.Bold, TextProperties.FontWeight.w800, TextProperties.FontWeight.w900, TextProperties.FontWeight.w900};
        private static final int[] absoluteFontWeights = {400, 700, 100, 200, 300, 400, 500, 600, 700, HubAssetRemoteDataSource.HUB_BANNER_SCALED_SIZE, 900};
        static final int normal = 400;

        private static int bolder(int i) {
            if (i < 350) {
                return 400;
            }
            if (i < 550) {
                return 700;
            }
            if (i < 900) {
                return 900;
            }
            return i;
        }

        private static int lighter(int i) {
            if (i < 100) {
                return i;
            }
            if (i < 550) {
                return 100;
            }
            return i < 750 ? 400 : 700;
        }

        AbsoluteFontWeight() {
        }

        static TextProperties.FontWeight nearestFontWeight(int i) {
            return WEIGHTS[Math.round(i / 100.0f)];
        }

        static int from(TextProperties.FontWeight fontWeight, FontData fontData) {
            if (fontWeight == TextProperties.FontWeight.Bolder) {
                return bolder(fontData.absoluteFontWeight);
            }
            if (fontWeight == TextProperties.FontWeight.Lighter) {
                return lighter(fontData.absoluteFontWeight);
            }
            return absoluteFontWeights[fontWeight.ordinal()];
        }
    }

    private FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = TextProperties.FontStyle.normal;
        this.fontWeight = TextProperties.FontWeight.Normal;
        this.absoluteFontWeight = 400;
        this.fontFeatureSettings = "";
        this.fontVariationSettings = "";
        this.fontVariantLigatures = TextProperties.FontVariantLigatures.normal;
        this.textAnchor = TextProperties.TextAnchor.start;
        this.textDecoration = TextProperties.TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = DEFAULT_FONT_SIZE;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    private double toAbsolute(ReadableMap readableMap, String str, double d, double d2, double d3) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str) * d;
        }
        return PropHelper.fromRelative(readableMap.getString(str), d3, d, d2);
    }

    private void setInheritedWeight(FontData fontData) {
        this.absoluteFontWeight = fontData.absoluteFontWeight;
        this.fontWeight = fontData.fontWeight;
    }

    private void handleNumericWeight(FontData fontData, double d) {
        long jRound = Math.round(d);
        if (jRound >= 1 && jRound <= 1000) {
            int i = (int) jRound;
            this.absoluteFontWeight = i;
            this.fontWeight = AbsoluteFontWeight.nearestFontWeight(i);
            return;
        }
        setInheritedWeight(fontData);
    }

    FontData(ReadableMap readableMap, FontData fontData, double d) {
        FontData fontData2;
        ReadableMap readableMap2;
        String string;
        String string2;
        TextProperties.FontVariantLigatures fontVariantLigaturesValueOf;
        TextProperties.TextAnchor textAnchorValueOf;
        TextProperties.TextDecoration textDecoration;
        double d2;
        double absolute;
        double absolute2;
        double absolute3;
        double d3 = fontData.fontSize;
        if (readableMap.hasKey("fontSize")) {
            fontData2 = this;
            readableMap2 = readableMap;
            fontData2.fontSize = fontData2.toAbsolute(readableMap2, "fontSize", 1.0d, d3, d3);
        } else {
            fontData2 = this;
            readableMap2 = readableMap;
            fontData2.fontSize = d3;
        }
        if (readableMap2.hasKey("fontWeight")) {
            if (readableMap2.getType("fontWeight") == ReadableType.Number) {
                fontData2.handleNumericWeight(fontData, readableMap2.getDouble("fontWeight"));
            } else {
                String string3 = readableMap2.getString("fontWeight");
                if (TextProperties.FontWeight.hasEnum(string3)) {
                    int iFrom = AbsoluteFontWeight.from(TextProperties.FontWeight.get(string3), fontData);
                    fontData2.absoluteFontWeight = iFrom;
                    fontData2.fontWeight = AbsoluteFontWeight.nearestFontWeight(iFrom);
                } else if (string3 != null) {
                    fontData2.handleNumericWeight(fontData, Double.parseDouble(string3));
                } else {
                    fontData2.setInheritedWeight(fontData);
                }
            }
        } else {
            fontData2.setInheritedWeight(fontData);
        }
        fontData2.fontData = readableMap2.hasKey(FONT_DATA) ? readableMap2.getMap(FONT_DATA) : fontData.fontData;
        fontData2.fontFamily = readableMap2.hasKey("fontFamily") ? readableMap2.getString("fontFamily") : fontData.fontFamily;
        fontData2.fontStyle = readableMap2.hasKey("fontStyle") ? TextProperties.FontStyle.valueOf(readableMap2.getString("fontStyle")) : fontData.fontStyle;
        if (readableMap2.hasKey(FONT_FEATURE_SETTINGS)) {
            string = readableMap2.getString(FONT_FEATURE_SETTINGS);
        } else {
            string = fontData.fontFeatureSettings;
        }
        fontData2.fontFeatureSettings = string;
        if (readableMap2.hasKey(FONT_VARIATION_SETTINGS)) {
            string2 = readableMap2.getString(FONT_VARIATION_SETTINGS);
        } else {
            string2 = fontData.fontVariationSettings;
        }
        fontData2.fontVariationSettings = string2;
        if (readableMap2.hasKey(FONT_VARIANT_LIGATURES)) {
            fontVariantLigaturesValueOf = TextProperties.FontVariantLigatures.valueOf(readableMap2.getString(FONT_VARIANT_LIGATURES));
        } else {
            fontVariantLigaturesValueOf = fontData.fontVariantLigatures;
        }
        fontData2.fontVariantLigatures = fontVariantLigaturesValueOf;
        if (readableMap2.hasKey(TEXT_ANCHOR)) {
            textAnchorValueOf = TextProperties.TextAnchor.valueOf(readableMap2.getString(TEXT_ANCHOR));
        } else {
            textAnchorValueOf = fontData.textAnchor;
        }
        fontData2.textAnchor = textAnchorValueOf;
        if (readableMap2.hasKey("textDecoration")) {
            textDecoration = TextProperties.TextDecoration.getEnum(readableMap2.getString("textDecoration"));
        } else {
            textDecoration = fontData.textDecoration;
        }
        fontData2.textDecoration = textDecoration;
        boolean zHasKey = readableMap2.hasKey(KERNING);
        fontData2.manualKerning = zHasKey || fontData.manualKerning;
        if (zHasKey) {
            d2 = d;
            absolute = fontData2.toAbsolute(readableMap2, KERNING, d2, fontData2.fontSize, 0.0d);
        } else {
            d2 = d;
            absolute = fontData.kerning;
        }
        fontData2.kerning = absolute;
        if (readableMap2.hasKey(WORD_SPACING)) {
            absolute2 = fontData2.toAbsolute(readableMap2, WORD_SPACING, d2, fontData2.fontSize, 0.0d);
        } else {
            absolute2 = fontData.wordSpacing;
        }
        fontData2.wordSpacing = absolute2;
        if (readableMap2.hasKey("letterSpacing")) {
            absolute3 = fontData2.toAbsolute(readableMap2, "letterSpacing", d2, fontData2.fontSize, 0.0d);
        } else {
            absolute3 = fontData.letterSpacing;
        }
        fontData2.letterSpacing = absolute3;
    }
}
