package expo.modules.ui;

import android.graphics.Color;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012$\b\u0002\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` ¢\u0006\u0004\b!\u0010\"J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010K\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010M\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010N\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010<J%\u0010O\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` HÆ\u0003JÚ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192$\b\u0002\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` HÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\u00172\b\u0010S\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010T\u001a\u00020\u0019HÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b4\u0010*R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b5\u0010*R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010=\u001a\u0004\b>\u0010<R-\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` ¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006V"}, d2 = {"Lexpo/modules/ui/TextProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "text", "", "color", "Landroid/graphics/Color;", "typography", "Lexpo/modules/ui/TypographyStyle;", "fontSize", "", "fontWeight", "Lexpo/modules/ui/TextFontWeight;", "fontStyle", "Lexpo/modules/ui/TextFontStyle;", "textAlign", "Lexpo/modules/ui/TextAlignType;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Lexpo/modules/ui/TextDecorationType;", ViewProps.LETTER_SPACING, ViewProps.LINE_HEIGHT, ViewProps.OVERFLOW, "Lexpo/modules/ui/TextOverflowType;", "softWrap", "", "maxLines", "", "minLines", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/TypographyStyle;Ljava/lang/Float;Lexpo/modules/ui/TextFontWeight;Lexpo/modules/ui/TextFontStyle;Lexpo/modules/ui/TextAlignType;Lexpo/modules/ui/TextDecorationType;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/TextOverflowType;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getColor", "()Landroid/graphics/Color;", "getTypography", "()Lexpo/modules/ui/TypographyStyle;", "getFontSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFontWeight", "()Lexpo/modules/ui/TextFontWeight;", "getFontStyle", "()Lexpo/modules/ui/TextFontStyle;", "getTextAlign", "()Lexpo/modules/ui/TextAlignType;", "getTextDecoration", "()Lexpo/modules/ui/TextDecorationType;", "getLetterSpacing", "getLineHeight", "getOverflow", "()Lexpo/modules/ui/TextOverflowType;", "getSoftWrap", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinLines", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/TypographyStyle;Ljava/lang/Float;Lexpo/modules/ui/TextFontWeight;Lexpo/modules/ui/TextFontStyle;Lexpo/modules/ui/TextAlignType;Lexpo/modules/ui/TextDecorationType;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/TextOverflowType;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lexpo/modules/ui/TextProps;", "equals", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TextProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final Float fontSize;
    private final TextFontStyle fontStyle;
    private final TextFontWeight fontWeight;
    private final Float letterSpacing;
    private final Float lineHeight;
    private final Integer maxLines;
    private final Integer minLines;
    private final List<Map<String, Object>> modifiers;
    private final TextOverflowType overflow;
    private final Boolean softWrap;
    private final String text;
    private final TextAlignType textAlign;
    private final TextDecorationType textDecoration;
    private final TypographyStyle typography;

    public TextProps() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final TextOverflowType getOverflow() {
        return this.overflow;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getSoftWrap() {
        return this.softWrap;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getMinLines() {
        return this.minLines;
    }

    public final List<Map<String, Object>> component15() {
        return this.modifiers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TypographyStyle getTypography() {
        return this.typography;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TextFontStyle getFontStyle() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TextAlignType getTextAlign() {
        return this.textAlign;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final TextDecorationType getTextDecoration() {
        return this.textDecoration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final TextProps copy(String text, Color color, TypographyStyle typography, Float fontSize, TextFontWeight fontWeight, TextFontStyle fontStyle, TextAlignType textAlign, TextDecorationType textDecoration, Float letterSpacing, Float lineHeight, TextOverflowType overflow, Boolean softWrap, Integer maxLines, Integer minLines, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new TextProps(text, color, typography, fontSize, fontWeight, fontStyle, textAlign, textDecoration, letterSpacing, lineHeight, overflow, softWrap, maxLines, minLines, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextProps)) {
            return false;
        }
        TextProps textProps = (TextProps) other;
        return Intrinsics.areEqual(this.text, textProps.text) && Intrinsics.areEqual(this.color, textProps.color) && this.typography == textProps.typography && Intrinsics.areEqual((Object) this.fontSize, (Object) textProps.fontSize) && this.fontWeight == textProps.fontWeight && this.fontStyle == textProps.fontStyle && this.textAlign == textProps.textAlign && this.textDecoration == textProps.textDecoration && Intrinsics.areEqual((Object) this.letterSpacing, (Object) textProps.letterSpacing) && Intrinsics.areEqual((Object) this.lineHeight, (Object) textProps.lineHeight) && this.overflow == textProps.overflow && Intrinsics.areEqual(this.softWrap, textProps.softWrap) && Intrinsics.areEqual(this.maxLines, textProps.maxLines) && Intrinsics.areEqual(this.minLines, textProps.minLines) && Intrinsics.areEqual(this.modifiers, textProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        TypographyStyle typographyStyle = this.typography;
        int iHashCode3 = (iHashCode2 + (typographyStyle == null ? 0 : typographyStyle.hashCode())) * 31;
        Float f = this.fontSize;
        int iHashCode4 = (iHashCode3 + (f == null ? 0 : f.hashCode())) * 31;
        TextFontWeight textFontWeight = this.fontWeight;
        int iHashCode5 = (iHashCode4 + (textFontWeight == null ? 0 : textFontWeight.hashCode())) * 31;
        TextFontStyle textFontStyle = this.fontStyle;
        int iHashCode6 = (iHashCode5 + (textFontStyle == null ? 0 : textFontStyle.hashCode())) * 31;
        TextAlignType textAlignType = this.textAlign;
        int iHashCode7 = (iHashCode6 + (textAlignType == null ? 0 : textAlignType.hashCode())) * 31;
        TextDecorationType textDecorationType = this.textDecoration;
        int iHashCode8 = (iHashCode7 + (textDecorationType == null ? 0 : textDecorationType.hashCode())) * 31;
        Float f2 = this.letterSpacing;
        int iHashCode9 = (iHashCode8 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.lineHeight;
        int iHashCode10 = (iHashCode9 + (f3 == null ? 0 : f3.hashCode())) * 31;
        TextOverflowType textOverflowType = this.overflow;
        int iHashCode11 = (iHashCode10 + (textOverflowType == null ? 0 : textOverflowType.hashCode())) * 31;
        Boolean bool = this.softWrap;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.maxLines;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.minLines;
        return ((iHashCode13 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "TextProps(text=" + this.text + ", color=" + this.color + ", typography=" + this.typography + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", textAlign=" + this.textAlign + ", textDecoration=" + this.textDecoration + ", letterSpacing=" + this.letterSpacing + ", lineHeight=" + this.lineHeight + ", overflow=" + this.overflow + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextProps(String text, Color color, TypographyStyle typographyStyle, Float f, TextFontWeight textFontWeight, TextFontStyle textFontStyle, TextAlignType textAlignType, TextDecorationType textDecorationType, Float f2, Float f3, TextOverflowType textOverflowType, Boolean bool, Integer num, Integer num2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.text = text;
        this.color = color;
        this.typography = typographyStyle;
        this.fontSize = f;
        this.fontWeight = textFontWeight;
        this.fontStyle = textFontStyle;
        this.textAlign = textAlignType;
        this.textDecoration = textDecorationType;
        this.letterSpacing = f2;
        this.lineHeight = f3;
        this.overflow = textOverflowType;
        this.softWrap = bool;
        this.maxLines = num;
        this.minLines = num2;
        this.modifiers = modifiers;
    }

    public /* synthetic */ TextProps(String str, Color color, TypographyStyle typographyStyle, Float f, TextFontWeight textFontWeight, TextFontStyle textFontStyle, TextAlignType textAlignType, TextDecorationType textDecorationType, Float f2, Float f3, TextOverflowType textOverflowType, Boolean bool, Integer num, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : typographyStyle, (i & 8) != 0 ? null : f, (i & 16) != 0 ? null : textFontWeight, (i & 32) != 0 ? null : textFontStyle, (i & 64) != 0 ? null : textAlignType, (i & 128) != 0 ? null : textDecorationType, (i & 256) != 0 ? null : f2, (i & 512) != 0 ? null : f3, (i & 1024) != 0 ? null : textOverflowType, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : num, (i & 8192) == 0 ? num2 : null, (i & 16384) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final Color getColor() {
        return this.color;
    }

    public final TypographyStyle getTypography() {
        return this.typography;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final TextFontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final TextAlignType getTextAlign() {
        return this.textAlign;
    }

    public final TextDecorationType getTextDecoration() {
        return this.textDecoration;
    }

    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final TextOverflowType getOverflow() {
        return this.overflow;
    }

    public final Boolean getSoftWrap() {
        return this.softWrap;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final Integer getMinLines() {
        return this.minLines;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
