package com.box.android.boxai.markdown;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkdownStyle.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0007/012345BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00066"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle;", "", "textStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;", "linkStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;", "blockQuoteStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;", "bulletListStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;", "headingStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;", "thematicBreakStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;", "tableStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;", "<init>", "(Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;)V", "getTextStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;", "getLinkStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;", "getBlockQuoteStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;", "getBulletListStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;", "getHeadingStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;", "getThematicBreakStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;", "getTableStyle", "()Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "TextStyle", "LinkStyle", "BlockQuoteStyle", "BulletListStyle", "HeadingStyle", "ThematicBreakStyle", "TableStyle", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MarkdownStyle {
    public static final int $stable = 0;
    private final BlockQuoteStyle blockQuoteStyle;
    private final BulletListStyle bulletListStyle;
    private final HeadingStyle headingStyle;
    private final LinkStyle linkStyle;
    private final TableStyle tableStyle;
    private final TextStyle textStyle;
    private final ThematicBreakStyle thematicBreakStyle;

    public MarkdownStyle() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MarkdownStyle copy$default(MarkdownStyle markdownStyle, TextStyle textStyle, LinkStyle linkStyle, BlockQuoteStyle blockQuoteStyle, BulletListStyle bulletListStyle, HeadingStyle headingStyle, ThematicBreakStyle thematicBreakStyle, TableStyle tableStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle = markdownStyle.textStyle;
        }
        if ((i & 2) != 0) {
            linkStyle = markdownStyle.linkStyle;
        }
        if ((i & 4) != 0) {
            blockQuoteStyle = markdownStyle.blockQuoteStyle;
        }
        if ((i & 8) != 0) {
            bulletListStyle = markdownStyle.bulletListStyle;
        }
        if ((i & 16) != 0) {
            headingStyle = markdownStyle.headingStyle;
        }
        if ((i & 32) != 0) {
            thematicBreakStyle = markdownStyle.thematicBreakStyle;
        }
        if ((i & 64) != 0) {
            tableStyle = markdownStyle.tableStyle;
        }
        ThematicBreakStyle thematicBreakStyle2 = thematicBreakStyle;
        TableStyle tableStyle2 = tableStyle;
        HeadingStyle headingStyle2 = headingStyle;
        BlockQuoteStyle blockQuoteStyle2 = blockQuoteStyle;
        return markdownStyle.copy(textStyle, linkStyle, blockQuoteStyle2, bulletListStyle, headingStyle2, thematicBreakStyle2, tableStyle2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LinkStyle getLinkStyle() {
        return this.linkStyle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BlockQuoteStyle getBlockQuoteStyle() {
        return this.blockQuoteStyle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BulletListStyle getBulletListStyle() {
        return this.bulletListStyle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final HeadingStyle getHeadingStyle() {
        return this.headingStyle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ThematicBreakStyle getThematicBreakStyle() {
        return this.thematicBreakStyle;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TableStyle getTableStyle() {
        return this.tableStyle;
    }

    public final MarkdownStyle copy(TextStyle textStyle, LinkStyle linkStyle, BlockQuoteStyle blockQuoteStyle, BulletListStyle bulletListStyle, HeadingStyle headingStyle, ThematicBreakStyle thematicBreakStyle, TableStyle tableStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(linkStyle, "linkStyle");
        Intrinsics.checkNotNullParameter(blockQuoteStyle, "blockQuoteStyle");
        Intrinsics.checkNotNullParameter(bulletListStyle, "bulletListStyle");
        Intrinsics.checkNotNullParameter(headingStyle, "headingStyle");
        Intrinsics.checkNotNullParameter(thematicBreakStyle, "thematicBreakStyle");
        Intrinsics.checkNotNullParameter(tableStyle, "tableStyle");
        return new MarkdownStyle(textStyle, linkStyle, blockQuoteStyle, bulletListStyle, headingStyle, thematicBreakStyle, tableStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkdownStyle)) {
            return false;
        }
        MarkdownStyle markdownStyle = (MarkdownStyle) other;
        return Intrinsics.areEqual(this.textStyle, markdownStyle.textStyle) && Intrinsics.areEqual(this.linkStyle, markdownStyle.linkStyle) && Intrinsics.areEqual(this.blockQuoteStyle, markdownStyle.blockQuoteStyle) && Intrinsics.areEqual(this.bulletListStyle, markdownStyle.bulletListStyle) && Intrinsics.areEqual(this.headingStyle, markdownStyle.headingStyle) && Intrinsics.areEqual(this.thematicBreakStyle, markdownStyle.thematicBreakStyle) && Intrinsics.areEqual(this.tableStyle, markdownStyle.tableStyle);
    }

    public int hashCode() {
        return (((((((((((this.textStyle.hashCode() * 31) + this.linkStyle.hashCode()) * 31) + this.blockQuoteStyle.hashCode()) * 31) + this.bulletListStyle.hashCode()) * 31) + this.headingStyle.hashCode()) * 31) + this.thematicBreakStyle.hashCode()) * 31) + this.tableStyle.hashCode();
    }

    public String toString() {
        return "MarkdownStyle(textStyle=" + this.textStyle + ", linkStyle=" + this.linkStyle + ", blockQuoteStyle=" + this.blockQuoteStyle + ", bulletListStyle=" + this.bulletListStyle + ", headingStyle=" + this.headingStyle + ", thematicBreakStyle=" + this.thematicBreakStyle + ", tableStyle=" + this.tableStyle + ")";
    }

    public MarkdownStyle(TextStyle textStyle, LinkStyle linkStyle, BlockQuoteStyle blockQuoteStyle, BulletListStyle bulletListStyle, HeadingStyle headingStyle, ThematicBreakStyle thematicBreakStyle, TableStyle tableStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(linkStyle, "linkStyle");
        Intrinsics.checkNotNullParameter(blockQuoteStyle, "blockQuoteStyle");
        Intrinsics.checkNotNullParameter(bulletListStyle, "bulletListStyle");
        Intrinsics.checkNotNullParameter(headingStyle, "headingStyle");
        Intrinsics.checkNotNullParameter(thematicBreakStyle, "thematicBreakStyle");
        Intrinsics.checkNotNullParameter(tableStyle, "tableStyle");
        this.textStyle = textStyle;
        this.linkStyle = linkStyle;
        this.blockQuoteStyle = blockQuoteStyle;
        this.bulletListStyle = bulletListStyle;
        this.headingStyle = headingStyle;
        this.thematicBreakStyle = thematicBreakStyle;
        this.tableStyle = tableStyle;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MarkdownStyle(TextStyle textStyle, LinkStyle linkStyle, BlockQuoteStyle blockQuoteStyle, BulletListStyle bulletListStyle, HeadingStyle headingStyle, ThematicBreakStyle thematicBreakStyle, TableStyle tableStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        int i2 = 1;
        float f = 0.0f;
        this((i & 1) != 0 ? new TextStyle(0L, 0L, 0L, null, 0.0f, 31, null) : textStyle, (i & 2) != 0 ? new LinkStyle(0L, i2, defaultConstructorMarker2) : linkStyle, (i & 4) != 0 ? new BlockQuoteStyle(0.0f, 0L, 3, null) : blockQuoteStyle, (i & 8) != 0 ? new BulletListStyle(f, f, 3, defaultConstructorMarker2) : bulletListStyle, (i & 16) != 0 ? new HeadingStyle(f, i2, defaultConstructorMarker2) : headingStyle, (i & 32) != 0 ? new ThematicBreakStyle(0.0f, 0L, 3, null) : thematicBreakStyle, (i & 64) != 0 ? new TableStyle(0.0f, 0.0f, 0L, 0L, 0L, 0L, 63, null) : tableStyle);
    }

    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    public final LinkStyle getLinkStyle() {
        return this.linkStyle;
    }

    public final BlockQuoteStyle getBlockQuoteStyle() {
        return this.blockQuoteStyle;
    }

    public final BulletListStyle getBulletListStyle() {
        return this.bulletListStyle;
    }

    public final HeadingStyle getHeadingStyle() {
        return this.headingStyle;
    }

    public final ThematicBreakStyle getThematicBreakStyle() {
        return this.thematicBreakStyle;
    }

    public final TableStyle getTableStyle() {
        return this.tableStyle;
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015JD\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", ViewProps.LINE_HEIGHT, "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "textBlockBottomPadding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(JJJLandroidx/compose/ui/text/font/FontWeight;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "getFontSize-XSAIIZE", "getLineHeight-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getTextBlockBottomPadding-D9Ej5fM", "()F", "F", "component1", "component1-0d7_KjU", "component2", "component2-XSAIIZE", "component3", "component3-XSAIIZE", "component4", "component5", "component5-D9Ej5fM", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-ZfmxtC4", "(JJJLandroidx/compose/ui/text/font/FontWeight;F)Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextStyle {
        public static final int $stable = 0;
        private final long fontSize;
        private final FontWeight fontWeight;
        private final long lineHeight;
        private final float textBlockBottomPadding;
        private final long textColor;

        public /* synthetic */ TextStyle(long j, long j2, long j3, FontWeight fontWeight, float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, j3, fontWeight, f);
        }

        /* JADX INFO: renamed from: copy-ZfmxtC4$default, reason: not valid java name */
        public static /* synthetic */ TextStyle m11995copyZfmxtC4$default(TextStyle textStyle, long j, long j2, long j3, FontWeight fontWeight, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                j = textStyle.textColor;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = textStyle.fontSize;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = textStyle.lineHeight;
            }
            return textStyle.m12000copyZfmxtC4(j4, j5, j3, (i & 8) != 0 ? textStyle.fontWeight : fontWeight, (i & 16) != 0 ? textStyle.textBlockBottomPadding : f);
        }

        /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
        public final long getTextColor() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: component2-XSAIIZE, reason: not valid java name and from getter */
        public final long getFontSize() {
            return this.fontSize;
        }

        /* JADX INFO: renamed from: component3-XSAIIZE, reason: not valid java name and from getter */
        public final long getLineHeight() {
            return this.lineHeight;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        /* JADX INFO: renamed from: component5-D9Ej5fM, reason: not valid java name and from getter */
        public final float getTextBlockBottomPadding() {
            return this.textBlockBottomPadding;
        }

        /* JADX INFO: renamed from: copy-ZfmxtC4, reason: not valid java name */
        public final TextStyle m12000copyZfmxtC4(long textColor, long fontSize, long lineHeight, FontWeight fontWeight, float textBlockBottomPadding) {
            return new TextStyle(textColor, fontSize, lineHeight, fontWeight, textBlockBottomPadding, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextStyle)) {
                return false;
            }
            TextStyle textStyle = (TextStyle) other;
            return Color.m6815equalsimpl0(this.textColor, textStyle.textColor) && TextUnit.m9878equalsimpl0(this.fontSize, textStyle.fontSize) && TextUnit.m9878equalsimpl0(this.lineHeight, textStyle.lineHeight) && Intrinsics.areEqual(this.fontWeight, textStyle.fontWeight) && Dp.m9692equalsimpl0(this.textBlockBottomPadding, textStyle.textBlockBottomPadding);
        }

        public int hashCode() {
            int iM6821hashCodeimpl = ((((Color.m6821hashCodeimpl(this.textColor) * 31) + TextUnit.m9882hashCodeimpl(this.fontSize)) * 31) + TextUnit.m9882hashCodeimpl(this.lineHeight)) * 31;
            FontWeight fontWeight = this.fontWeight;
            return ((iM6821hashCodeimpl + (fontWeight == null ? 0 : fontWeight.hashCode())) * 31) + Dp.m9693hashCodeimpl(this.textBlockBottomPadding);
        }

        public String toString() {
            return "TextStyle(textColor=" + Color.m6822toStringimpl(this.textColor) + ", fontSize=" + TextUnit.m9888toStringimpl(this.fontSize) + ", lineHeight=" + TextUnit.m9888toStringimpl(this.lineHeight) + ", fontWeight=" + this.fontWeight + ", textBlockBottomPadding=" + Dp.m9698toStringimpl(this.textBlockBottomPadding) + ")";
        }

        private TextStyle(long j, long j2, long j3, FontWeight fontWeight, float f) {
            this.textColor = j;
            this.fontSize = j2;
            this.lineHeight = j3;
            this.fontWeight = fontWeight;
            this.textBlockBottomPadding = f;
        }

        public /* synthetic */ TextStyle(long j, long j2, long j3, FontWeight fontWeight, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE() : j2, (i & 4) != 0 ? TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE() : j3, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, null);
        }

        /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
        public final long m12004getTextColor0d7_KjU() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
        public final long m12001getFontSizeXSAIIZE() {
            return this.fontSize;
        }

        /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
        public final long m12002getLineHeightXSAIIZE() {
            return this.lineHeight;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        /* JADX INFO: renamed from: getTextBlockBottomPadding-D9Ej5fM, reason: not valid java name */
        public final float m12003getTextBlockBottomPaddingD9Ej5fM() {
            return this.textBlockBottomPadding;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "component1", "component1-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-8_81llA", "(J)Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LinkStyle {
        public static final int $stable = 0;
        private final long textColor;

        public /* synthetic */ LinkStyle(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* JADX INFO: renamed from: copy-8_81llA$default, reason: not valid java name */
        public static /* synthetic */ LinkStyle m11977copy8_81llA$default(LinkStyle linkStyle, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = linkStyle.textColor;
            }
            return linkStyle.m11979copy8_81llA(j);
        }

        /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
        public final long getTextColor() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: copy-8_81llA, reason: not valid java name */
        public final LinkStyle m11979copy8_81llA(long textColor) {
            return new LinkStyle(textColor, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LinkStyle) && Color.m6815equalsimpl0(this.textColor, ((LinkStyle) other).textColor);
        }

        public int hashCode() {
            return Color.m6821hashCodeimpl(this.textColor);
        }

        public String toString() {
            return "LinkStyle(textColor=" + Color.m6822toStringimpl(this.textColor) + ")";
        }

        private LinkStyle(long j) {
            this.textColor = j;
        }

        public /* synthetic */ LinkStyle(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, null);
        }

        /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
        public final long m11980getTextColor0d7_KjU() {
            return this.textColor;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;", "", "stripeWidth", "Landroidx/compose/ui/unit/Dp;", "stripeColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(FJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStripeWidth-D9Ej5fM", "()F", "F", "getStripeColor-0d7_KjU", "()J", "J", "component1", "component1-D9Ej5fM", "component2", "component2-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-cXLIe8U", "(FJ)Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BlockQuoteStyle {
        public static final int $stable = 0;
        private final long stripeColor;
        private final float stripeWidth;

        public /* synthetic */ BlockQuoteStyle(float f, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, j);
        }

        /* JADX INFO: renamed from: copy-cXLIe8U$default, reason: not valid java name */
        public static /* synthetic */ BlockQuoteStyle m11961copycXLIe8U$default(BlockQuoteStyle blockQuoteStyle, float f, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                f = blockQuoteStyle.stripeWidth;
            }
            if ((i & 2) != 0) {
                j = blockQuoteStyle.stripeColor;
            }
            return blockQuoteStyle.m11964copycXLIe8U(f, j);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getStripeWidth() {
            return this.stripeWidth;
        }

        /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
        public final long getStripeColor() {
            return this.stripeColor;
        }

        /* JADX INFO: renamed from: copy-cXLIe8U, reason: not valid java name */
        public final BlockQuoteStyle m11964copycXLIe8U(float stripeWidth, long stripeColor) {
            return new BlockQuoteStyle(stripeWidth, stripeColor, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockQuoteStyle)) {
                return false;
            }
            BlockQuoteStyle blockQuoteStyle = (BlockQuoteStyle) other;
            return Dp.m9692equalsimpl0(this.stripeWidth, blockQuoteStyle.stripeWidth) && Color.m6815equalsimpl0(this.stripeColor, blockQuoteStyle.stripeColor);
        }

        public int hashCode() {
            return (Dp.m9693hashCodeimpl(this.stripeWidth) * 31) + Color.m6821hashCodeimpl(this.stripeColor);
        }

        public String toString() {
            return "BlockQuoteStyle(stripeWidth=" + Dp.m9698toStringimpl(this.stripeWidth) + ", stripeColor=" + Color.m6822toStringimpl(this.stripeColor) + ")";
        }

        private BlockQuoteStyle(float f, long j) {
            this.stripeWidth = f;
            this.stripeColor = j;
        }

        public /* synthetic */ BlockQuoteStyle(float f, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, null);
        }

        /* JADX INFO: renamed from: getStripeColor-0d7_KjU, reason: not valid java name */
        public final long m11965getStripeColor0d7_KjU() {
            return this.stripeColor;
        }

        /* JADX INFO: renamed from: getStripeWidth-D9Ej5fM, reason: not valid java name */
        public final float m11966getStripeWidthD9Ej5fM() {
            return this.stripeWidth;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;", "", "bulletStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "bulletWidth", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBulletStrokeWidth-D9Ej5fM", "()F", "F", "getBulletWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-YgX7TsA", "(FF)Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BulletListStyle {
        public static final int $stable = 0;
        private final float bulletStrokeWidth;
        private final float bulletWidth;

        public /* synthetic */ BulletListStyle(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2);
        }

        /* JADX INFO: renamed from: copy-YgX7TsA$default, reason: not valid java name */
        public static /* synthetic */ BulletListStyle m11967copyYgX7TsA$default(BulletListStyle bulletListStyle, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = bulletListStyle.bulletStrokeWidth;
            }
            if ((i & 2) != 0) {
                f2 = bulletListStyle.bulletWidth;
            }
            return bulletListStyle.m11970copyYgX7TsA(f, f2);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getBulletStrokeWidth() {
            return this.bulletStrokeWidth;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
        public final float getBulletWidth() {
            return this.bulletWidth;
        }

        /* JADX INFO: renamed from: copy-YgX7TsA, reason: not valid java name */
        public final BulletListStyle m11970copyYgX7TsA(float bulletStrokeWidth, float bulletWidth) {
            return new BulletListStyle(bulletStrokeWidth, bulletWidth, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BulletListStyle)) {
                return false;
            }
            BulletListStyle bulletListStyle = (BulletListStyle) other;
            return Dp.m9692equalsimpl0(this.bulletStrokeWidth, bulletListStyle.bulletStrokeWidth) && Dp.m9692equalsimpl0(this.bulletWidth, bulletListStyle.bulletWidth);
        }

        public int hashCode() {
            return (Dp.m9693hashCodeimpl(this.bulletStrokeWidth) * 31) + Dp.m9693hashCodeimpl(this.bulletWidth);
        }

        public String toString() {
            return "BulletListStyle(bulletStrokeWidth=" + Dp.m9698toStringimpl(this.bulletStrokeWidth) + ", bulletWidth=" + Dp.m9698toStringimpl(this.bulletWidth) + ")";
        }

        private BulletListStyle(float f, float f2) {
            this.bulletStrokeWidth = f;
            this.bulletWidth = f2;
        }

        public /* synthetic */ BulletListStyle(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f2, null);
        }

        /* JADX INFO: renamed from: getBulletStrokeWidth-D9Ej5fM, reason: not valid java name */
        public final float m11971getBulletStrokeWidthD9Ej5fM() {
            return this.bulletStrokeWidth;
        }

        /* JADX INFO: renamed from: getBulletWidth-D9Ej5fM, reason: not valid java name */
        public final float m11972getBulletWidthD9Ej5fM() {
            return this.bulletWidth;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;", "", ViewProps.LINE_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-0680j_4", "(F)Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HeadingStyle {
        public static final int $stable = 0;
        private final float lineHeight;

        public /* synthetic */ HeadingStyle(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        /* JADX INFO: renamed from: copy-0680j_4$default, reason: not valid java name */
        public static /* synthetic */ HeadingStyle m11973copy0680j_4$default(HeadingStyle headingStyle, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = headingStyle.lineHeight;
            }
            return headingStyle.m11975copy0680j_4(f);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getLineHeight() {
            return this.lineHeight;
        }

        /* JADX INFO: renamed from: copy-0680j_4, reason: not valid java name */
        public final HeadingStyle m11975copy0680j_4(float lineHeight) {
            return new HeadingStyle(lineHeight, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HeadingStyle) && Dp.m9692equalsimpl0(this.lineHeight, ((HeadingStyle) other).lineHeight);
        }

        public int hashCode() {
            return Dp.m9693hashCodeimpl(this.lineHeight);
        }

        public String toString() {
            return "HeadingStyle(lineHeight=" + Dp.m9698toStringimpl(this.lineHeight) + ")";
        }

        private HeadingStyle(float f) {
            this.lineHeight = f;
        }

        public /* synthetic */ HeadingStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, null);
        }

        /* JADX INFO: renamed from: getLineHeight-D9Ej5fM, reason: not valid java name */
        public final float m11976getLineHeightD9Ej5fM() {
            return this.lineHeight;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;", "", ViewProps.LINE_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "lineColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(FJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight-D9Ej5fM", "()F", "F", "getLineColor-0d7_KjU", "()J", "J", "component1", "component1-D9Ej5fM", "component2", "component2-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-cXLIe8U", "(FJ)Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ThematicBreakStyle {
        public static final int $stable = 0;
        private final long lineColor;
        private final float lineHeight;

        public /* synthetic */ ThematicBreakStyle(float f, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, j);
        }

        /* JADX INFO: renamed from: copy-cXLIe8U$default, reason: not valid java name */
        public static /* synthetic */ ThematicBreakStyle m12005copycXLIe8U$default(ThematicBreakStyle thematicBreakStyle, float f, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                f = thematicBreakStyle.lineHeight;
            }
            if ((i & 2) != 0) {
                j = thematicBreakStyle.lineColor;
            }
            return thematicBreakStyle.m12008copycXLIe8U(f, j);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getLineHeight() {
            return this.lineHeight;
        }

        /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
        public final long getLineColor() {
            return this.lineColor;
        }

        /* JADX INFO: renamed from: copy-cXLIe8U, reason: not valid java name */
        public final ThematicBreakStyle m12008copycXLIe8U(float lineHeight, long lineColor) {
            return new ThematicBreakStyle(lineHeight, lineColor, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThematicBreakStyle)) {
                return false;
            }
            ThematicBreakStyle thematicBreakStyle = (ThematicBreakStyle) other;
            return Dp.m9692equalsimpl0(this.lineHeight, thematicBreakStyle.lineHeight) && Color.m6815equalsimpl0(this.lineColor, thematicBreakStyle.lineColor);
        }

        public int hashCode() {
            return (Dp.m9693hashCodeimpl(this.lineHeight) * 31) + Color.m6821hashCodeimpl(this.lineColor);
        }

        public String toString() {
            return "ThematicBreakStyle(lineHeight=" + Dp.m9698toStringimpl(this.lineHeight) + ", lineColor=" + Color.m6822toStringimpl(this.lineColor) + ")";
        }

        private ThematicBreakStyle(float f, long j) {
            this.lineHeight = f;
            this.lineColor = j;
        }

        public /* synthetic */ ThematicBreakStyle(float f, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, null);
        }

        /* JADX INFO: renamed from: getLineColor-0d7_KjU, reason: not valid java name */
        public final long m12009getLineColor0d7_KjU() {
            return this.lineColor;
        }

        /* JADX INFO: renamed from: getLineHeight-D9Ej5fM, reason: not valid java name */
        public final float m12010getLineHeightD9Ej5fM() {
            return this.lineHeight;
        }
    }

    /* JADX INFO: compiled from: MarkdownStyle.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0011J\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\u0011JL\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006,"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;", "", "cellPadding", "Landroidx/compose/ui/unit/Dp;", ViewProps.BORDER_WIDTH, ViewProps.BORDER_COLOR, "Landroidx/compose/ui/graphics/Color;", "headerRowBackgroundColor", "evenRowBackgroundColor", "oddRowBackgroundColor", "<init>", "(FFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCellPadding-D9Ej5fM", "()F", "F", "getBorderWidth-D9Ej5fM", "getBorderColor-0d7_KjU", "()J", "J", "getHeaderRowBackgroundColor-0d7_KjU", "getEvenRowBackgroundColor-0d7_KjU", "getOddRowBackgroundColor-0d7_KjU", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-VAaRpFU", "(FFJJJJ)Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TableStyle {
        public static final int $stable = 0;
        private final long borderColor;
        private final float borderWidth;
        private final float cellPadding;
        private final long evenRowBackgroundColor;
        private final long headerRowBackgroundColor;
        private final long oddRowBackgroundColor;

        public /* synthetic */ TableStyle(float f, float f2, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, j, j2, j3, j4);
        }

        /* JADX INFO: renamed from: copy-VAaRpFU$default, reason: not valid java name */
        public static /* synthetic */ TableStyle m11981copyVAaRpFU$default(TableStyle tableStyle, float f, float f2, long j, long j2, long j3, long j4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tableStyle.cellPadding;
            }
            if ((i & 2) != 0) {
                f2 = tableStyle.borderWidth;
            }
            if ((i & 4) != 0) {
                j = tableStyle.borderColor;
            }
            if ((i & 8) != 0) {
                j2 = tableStyle.headerRowBackgroundColor;
            }
            if ((i & 16) != 0) {
                j3 = tableStyle.evenRowBackgroundColor;
            }
            if ((i & 32) != 0) {
                j4 = tableStyle.oddRowBackgroundColor;
            }
            long j5 = j4;
            long j6 = j3;
            long j7 = j2;
            return tableStyle.m11988copyVAaRpFU(f, f2, j, j7, j6, j5);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getCellPadding() {
            return this.cellPadding;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
        public final float getBorderWidth() {
            return this.borderWidth;
        }

        /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
        public final long getBorderColor() {
            return this.borderColor;
        }

        /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
        public final long getHeaderRowBackgroundColor() {
            return this.headerRowBackgroundColor;
        }

        /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
        public final long getEvenRowBackgroundColor() {
            return this.evenRowBackgroundColor;
        }

        /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
        public final long getOddRowBackgroundColor() {
            return this.oddRowBackgroundColor;
        }

        /* JADX INFO: renamed from: copy-VAaRpFU, reason: not valid java name */
        public final TableStyle m11988copyVAaRpFU(float cellPadding, float borderWidth, long borderColor, long headerRowBackgroundColor, long evenRowBackgroundColor, long oddRowBackgroundColor) {
            return new TableStyle(cellPadding, borderWidth, borderColor, headerRowBackgroundColor, evenRowBackgroundColor, oddRowBackgroundColor, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TableStyle)) {
                return false;
            }
            TableStyle tableStyle = (TableStyle) other;
            return Dp.m9692equalsimpl0(this.cellPadding, tableStyle.cellPadding) && Dp.m9692equalsimpl0(this.borderWidth, tableStyle.borderWidth) && Color.m6815equalsimpl0(this.borderColor, tableStyle.borderColor) && Color.m6815equalsimpl0(this.headerRowBackgroundColor, tableStyle.headerRowBackgroundColor) && Color.m6815equalsimpl0(this.evenRowBackgroundColor, tableStyle.evenRowBackgroundColor) && Color.m6815equalsimpl0(this.oddRowBackgroundColor, tableStyle.oddRowBackgroundColor);
        }

        public int hashCode() {
            return (((((((((Dp.m9693hashCodeimpl(this.cellPadding) * 31) + Dp.m9693hashCodeimpl(this.borderWidth)) * 31) + Color.m6821hashCodeimpl(this.borderColor)) * 31) + Color.m6821hashCodeimpl(this.headerRowBackgroundColor)) * 31) + Color.m6821hashCodeimpl(this.evenRowBackgroundColor)) * 31) + Color.m6821hashCodeimpl(this.oddRowBackgroundColor);
        }

        public String toString() {
            return "TableStyle(cellPadding=" + Dp.m9698toStringimpl(this.cellPadding) + ", borderWidth=" + Dp.m9698toStringimpl(this.borderWidth) + ", borderColor=" + Color.m6822toStringimpl(this.borderColor) + ", headerRowBackgroundColor=" + Color.m6822toStringimpl(this.headerRowBackgroundColor) + ", evenRowBackgroundColor=" + Color.m6822toStringimpl(this.evenRowBackgroundColor) + ", oddRowBackgroundColor=" + Color.m6822toStringimpl(this.oddRowBackgroundColor) + ")";
        }

        private TableStyle(float f, float f2, long j, long j2, long j3, long j4) {
            this.cellPadding = f;
            this.borderWidth = f2;
            this.borderColor = j;
            this.headerRowBackgroundColor = j2;
            this.evenRowBackgroundColor = j3;
            this.oddRowBackgroundColor = j4;
        }

        public /* synthetic */ TableStyle(float f, float f2, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, (i & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2, (i & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3, (i & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4, null);
        }

        /* JADX INFO: renamed from: getCellPadding-D9Ej5fM, reason: not valid java name */
        public final float m11991getCellPaddingD9Ej5fM() {
            return this.cellPadding;
        }

        /* JADX INFO: renamed from: getBorderWidth-D9Ej5fM, reason: not valid java name */
        public final float m11990getBorderWidthD9Ej5fM() {
            return this.borderWidth;
        }

        /* JADX INFO: renamed from: getBorderColor-0d7_KjU, reason: not valid java name */
        public final long m11989getBorderColor0d7_KjU() {
            return this.borderColor;
        }

        /* JADX INFO: renamed from: getHeaderRowBackgroundColor-0d7_KjU, reason: not valid java name */
        public final long m11993getHeaderRowBackgroundColor0d7_KjU() {
            return this.headerRowBackgroundColor;
        }

        /* JADX INFO: renamed from: getEvenRowBackgroundColor-0d7_KjU, reason: not valid java name */
        public final long m11992getEvenRowBackgroundColor0d7_KjU() {
            return this.evenRowBackgroundColor;
        }

        /* JADX INFO: renamed from: getOddRowBackgroundColor-0d7_KjU, reason: not valid java name */
        public final long m11994getOddRowBackgroundColor0d7_KjU() {
            return this.oddRowBackgroundColor;
        }
    }
}
