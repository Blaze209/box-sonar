package com.box.android.boxai.markdown;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.ext.tables.TableTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkdownStyle.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¨\u0006\u0016"}, d2 = {"applyTo", "", "Lcom/box/android/boxai/markdown/MarkdownStyle$TextStyle;", "textView", "Landroid/widget/TextView;", "Lcom/box/android/boxai/markdown/MarkdownStyle$LinkStyle;", "builder", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "Lcom/box/android/boxai/markdown/MarkdownStyle$BlockQuoteStyle;", "context", "Landroid/content/Context;", "Lcom/box/android/boxai/markdown/MarkdownStyle$BulletListStyle;", "Lcom/box/android/boxai/markdown/MarkdownStyle$HeadingStyle;", "Lcom/box/android/boxai/markdown/MarkdownStyle$ThematicBreakStyle;", "Lcom/box/android/boxai/markdown/MarkdownStyle$TableStyle;", "Lio/noties/markwon/ext/tables/TableTheme$Builder;", "dpToPx", "", "dp", "", "spToPx", "sp", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MarkdownStyleKt {
    public static final void applyTo(MarkdownStyle.TextStyle textStyle, TextView textView) {
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (textStyle.m12004getTextColor0d7_KjU() != 16) {
            textView.setTextColor(ColorKt.m6868toArgb8_81llA(textStyle.m12004getTextColor0d7_KjU()));
        }
        long jM9880getTypeUIouoOA = TextUnit.m9880getTypeUIouoOA(textStyle.m12001getFontSizeXSAIIZE());
        if (TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA, TextUnitType.INSTANCE.m9914getSpUIouoOA())) {
            textView.setTextSize(TextUnit.m9881getValueimpl(textStyle.m12001getFontSizeXSAIIZE()));
        } else {
            if (TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA, TextUnitType.INSTANCE.m9913getEmUIouoOA())) {
                throw new IllegalArgumentException("Em is not supported");
            }
            TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA, TextUnitType.INSTANCE.m9915getUnspecifiedUIouoOA());
        }
        long jM9880getTypeUIouoOA2 = TextUnit.m9880getTypeUIouoOA(textStyle.m12002getLineHeightXSAIIZE());
        if (TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA2, TextUnitType.INSTANCE.m9914getSpUIouoOA())) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setLineHeight(spToPx(context, TextUnit.m9881getValueimpl(textStyle.m12002getLineHeightXSAIIZE())));
        } else {
            if (TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA2, TextUnitType.INSTANCE.m9913getEmUIouoOA())) {
                throw new IllegalArgumentException("Em is not supported");
            }
            TextUnitType.m9909equalsimpl0(jM9880getTypeUIouoOA2, TextUnitType.INSTANCE.m9915getUnspecifiedUIouoOA());
        }
        if (textStyle.getFontWeight() != null) {
            textView.setTypeface(Typeface.create(null, textStyle.getFontWeight().getWeight(), false));
        }
        if (Float.isNaN(textStyle.m12003getTextBlockBottomPaddingD9Ej5fM())) {
            return;
        }
        int paddingLeft = textView.getPaddingLeft();
        int paddingTop = textView.getPaddingTop();
        int paddingRight = textView.getPaddingRight();
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setPadding(paddingLeft, paddingTop, paddingRight, dpToPx(context2, textStyle.m12003getTextBlockBottomPaddingD9Ej5fM()));
    }

    public static final void applyTo(MarkdownStyle.LinkStyle linkStyle, MarkwonTheme.Builder builder) {
        Intrinsics.checkNotNullParameter(linkStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (linkStyle.m11980getTextColor0d7_KjU() != 16) {
            builder.linkColor(ColorKt.m6868toArgb8_81llA(linkStyle.m11980getTextColor0d7_KjU()));
        }
    }

    public static final void applyTo(MarkdownStyle.BlockQuoteStyle blockQuoteStyle, MarkwonTheme.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(blockQuoteStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Float.isNaN(blockQuoteStyle.m11966getStripeWidthD9Ej5fM())) {
            builder.blockQuoteWidth(dpToPx(context, blockQuoteStyle.m11966getStripeWidthD9Ej5fM()));
        }
        if (blockQuoteStyle.m11965getStripeColor0d7_KjU() != 16) {
            builder.blockQuoteColor(ColorKt.m6868toArgb8_81llA(blockQuoteStyle.m11965getStripeColor0d7_KjU()));
        }
    }

    public static final void applyTo(MarkdownStyle.BulletListStyle bulletListStyle, MarkwonTheme.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(bulletListStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Float.isNaN(bulletListStyle.m11971getBulletStrokeWidthD9Ej5fM())) {
            builder.bulletListItemStrokeWidth(dpToPx(context, bulletListStyle.m11971getBulletStrokeWidthD9Ej5fM()));
        }
        if (Float.isNaN(bulletListStyle.m11972getBulletWidthD9Ej5fM())) {
            return;
        }
        builder.bulletWidth(dpToPx(context, bulletListStyle.m11972getBulletWidthD9Ej5fM()));
    }

    public static final void applyTo(MarkdownStyle.HeadingStyle headingStyle, MarkwonTheme.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(headingStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Float.isNaN(headingStyle.m11976getLineHeightD9Ej5fM())) {
            return;
        }
        builder.headingBreakHeight(dpToPx(context, headingStyle.m11976getLineHeightD9Ej5fM()));
    }

    public static final void applyTo(MarkdownStyle.ThematicBreakStyle thematicBreakStyle, MarkwonTheme.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(thematicBreakStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Float.isNaN(thematicBreakStyle.m12010getLineHeightD9Ej5fM())) {
            builder.thematicBreakHeight(dpToPx(context, thematicBreakStyle.m12010getLineHeightD9Ej5fM()));
        }
        if (thematicBreakStyle.m12009getLineColor0d7_KjU() != 16) {
            builder.thematicBreakColor(ColorKt.m6868toArgb8_81llA(thematicBreakStyle.m12009getLineColor0d7_KjU()));
        }
    }

    public static final void applyTo(MarkdownStyle.TableStyle tableStyle, TableTheme.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(tableStyle, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Float.isNaN(tableStyle.m11991getCellPaddingD9Ej5fM())) {
            builder.tableCellPadding(dpToPx(context, tableStyle.m11991getCellPaddingD9Ej5fM()));
        }
        if (!Float.isNaN(tableStyle.m11990getBorderWidthD9Ej5fM())) {
            builder.tableBorderWidth(dpToPx(context, tableStyle.m11990getBorderWidthD9Ej5fM()));
        }
        if (tableStyle.m11989getBorderColor0d7_KjU() != 16) {
            builder.tableBorderColor(ColorKt.m6868toArgb8_81llA(tableStyle.m11989getBorderColor0d7_KjU()));
        }
        if (tableStyle.m11993getHeaderRowBackgroundColor0d7_KjU() != 16) {
            builder.tableHeaderRowBackgroundColor(ColorKt.m6868toArgb8_81llA(tableStyle.m11993getHeaderRowBackgroundColor0d7_KjU()));
        }
        if (tableStyle.m11992getEvenRowBackgroundColor0d7_KjU() != 16) {
            builder.tableEvenRowBackgroundColor(ColorKt.m6868toArgb8_81llA(tableStyle.m11992getEvenRowBackgroundColor0d7_KjU()));
        }
        if (tableStyle.m11994getOddRowBackgroundColor0d7_KjU() != 16) {
            builder.tableOddRowBackgroundColor(ColorKt.m6868toArgb8_81llA(tableStyle.m11994getOddRowBackgroundColor0d7_KjU()));
        }
    }

    private static final int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private static final int spToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
