package com.box.android.base.compose;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxTheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007¨\u0006:"}, d2 = {"Lcom/box/android/base/compose/BoxTypography;", "", "<init>", "()V", "BoxNormal8", "Landroidx/compose/ui/text/TextStyle;", "getBoxNormal8", "()Landroidx/compose/ui/text/TextStyle;", "BoxNormal12", "getBoxNormal12", "BoxNormal13", "getBoxNormal13", "BoxNormal14", "getBoxNormal14", "BoxNormal16", "getBoxNormal16", "BoxNormal22", "getBoxNormal22", "BoxNormal24", "getBoxNormal24", "BoxMedium12", "getBoxMedium12", "BoxMedium14", "getBoxMedium14", "BoxMedium15", "getBoxMedium15", "BoxMedium16", "getBoxMedium16", "BoxMedium17", "getBoxMedium17", "BoxMedium18", "getBoxMedium18", "BoxMedium20", "getBoxMedium20", "BoxMedium22", "getBoxMedium22", "BoxSemiBold10", "getBoxSemiBold10", "BoxSemiBold12", "getBoxSemiBold12", "BoxSemiBold14", "getBoxSemiBold14", "BoxSemiBold16", "getBoxSemiBold16", "BoxSemiBold22", "getBoxSemiBold22", "BoxBold10", "getBoxBold10", "BoxBold12", "getBoxBold12", "BoxBold14", "getBoxBold14", "BoxBold15", "getBoxBold15", "BoxBold16", "getBoxBold16", "BoxBold24", "getBoxBold24", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxTypography {
    public static final int $stable = 0;
    public static final BoxTypography INSTANCE = new BoxTypography();
    private static final TextStyle BoxNormal8 = new TextStyle(0, TextUnitKt.getSp(8), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal12 = new TextStyle(0, TextUnitKt.getSp(12), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal13 = new TextStyle(0, TextUnitKt.getSp(13), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal14 = new TextStyle(0, TextUnitKt.getSp(14), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal16 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal22 = new TextStyle(0, TextUnitKt.getSp(22), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxNormal24 = new TextStyle(0, TextUnitKt.getSp(24), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium12 = new TextStyle(0, TextUnitKt.getSp(12), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium14 = new TextStyle(0, TextUnitKt.getSp(14), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium15 = new TextStyle(0, TextUnitKt.getSp(15), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium16 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium17 = new TextStyle(0, TextUnitKt.getSp(17), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium18 = new TextStyle(0, TextUnitKt.getSp(18), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium20 = new TextStyle(0, TextUnitKt.getSp(20), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxMedium22 = new TextStyle(0, TextUnitKt.getSp(22), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxSemiBold10 = new TextStyle(0, TextUnitKt.getSp(10), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxSemiBold12 = new TextStyle(0, TextUnitKt.getSp(12), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxSemiBold14 = new TextStyle(0, TextUnitKt.getSp(14), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxSemiBold16 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxSemiBold22 = new TextStyle(0, TextUnitKt.getSp(22), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold10 = new TextStyle(0, TextUnitKt.getSp(10), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold12 = new TextStyle(0, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold14 = new TextStyle(0, TextUnitKt.getSp(14), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold15 = new TextStyle(0, TextUnitKt.getSp(15), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold16 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);
    private static final TextStyle BoxBold24 = new TextStyle(0, TextUnitKt.getSp(24), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getSansSerif(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (DefaultConstructorMarker) null);

    private BoxTypography() {
    }

    public final TextStyle getBoxNormal8() {
        return BoxNormal8;
    }

    public final TextStyle getBoxNormal12() {
        return BoxNormal12;
    }

    public final TextStyle getBoxNormal13() {
        return BoxNormal13;
    }

    public final TextStyle getBoxNormal14() {
        return BoxNormal14;
    }

    public final TextStyle getBoxNormal16() {
        return BoxNormal16;
    }

    public final TextStyle getBoxNormal22() {
        return BoxNormal22;
    }

    public final TextStyle getBoxNormal24() {
        return BoxNormal24;
    }

    public final TextStyle getBoxMedium12() {
        return BoxMedium12;
    }

    public final TextStyle getBoxMedium14() {
        return BoxMedium14;
    }

    public final TextStyle getBoxMedium15() {
        return BoxMedium15;
    }

    public final TextStyle getBoxMedium16() {
        return BoxMedium16;
    }

    public final TextStyle getBoxMedium17() {
        return BoxMedium17;
    }

    public final TextStyle getBoxMedium18() {
        return BoxMedium18;
    }

    public final TextStyle getBoxMedium20() {
        return BoxMedium20;
    }

    public final TextStyle getBoxMedium22() {
        return BoxMedium22;
    }

    public final TextStyle getBoxSemiBold10() {
        return BoxSemiBold10;
    }

    public final TextStyle getBoxSemiBold12() {
        return BoxSemiBold12;
    }

    public final TextStyle getBoxSemiBold14() {
        return BoxSemiBold14;
    }

    public final TextStyle getBoxSemiBold16() {
        return BoxSemiBold16;
    }

    public final TextStyle getBoxSemiBold22() {
        return BoxSemiBold22;
    }

    public final TextStyle getBoxBold10() {
        return BoxBold10;
    }

    public final TextStyle getBoxBold12() {
        return BoxBold12;
    }

    public final TextStyle getBoxBold14() {
        return BoxBold14;
    }

    public final TextStyle getBoxBold15() {
        return BoxBold15;
    }

    public final TextStyle getBoxBold16() {
        return BoxBold16;
    }

    public final TextStyle getBoxBold24() {
        return BoxBold24;
    }
}
