package com.pspdfkit.internal;

import android.content.Context;
import android.widget.TextView;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.res.ResourcesCompat;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.SoftBreakAddsNewLinePlugin;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.linkify.LinkifyPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ap {
    public static final void a(final String str, Modifier modifier, final long j, final long j2, final boolean z, Composer composer) {
        str.getClass();
        final int iM9531getStarte0LSkKk = TextAlign.INSTANCE.m9531getStarte0LSkKk();
        final TextStyle textStyle = (TextStyle) composer.consume(TextKt.getLocalTextStyle());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1555175908, 3120, -1, "io.nutrient.internal.ui.markdown.MarkdownTextView (MarkdownTextView.kt:58)");
        }
        final long jM6824unboximpl = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m6824unboximpl();
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            context.getClass();
            objRememberedValue = Markwon.builder(context).usePlugin(SoftBreakAddsNewLinePlugin.create()).usePlugin(LinkifyPlugin.create()).usePlugin(CorePlugin.create()).usePlugin(HtmlPlugin.create()).usePlugin(StrikethroughPlugin.create()).usePlugin(TablePlugin.create(context)).usePlugin(SoftBreakAddsNewLinePlugin.create()).build();
            objRememberedValue.getClass();
            composer.updateRememberedValue(objRememberedValue);
        }
        final Markwon markwon = (Markwon) objRememberedValue;
        final int i = Integer.MAX_VALUE;
        final Integer num = null;
        final Integer num2 = null;
        boolean zChanged = composer.changed(j) | composer.changed(jM6824unboximpl) | composer.changed(iM9531getStarte0LSkKk) | composer.changed(z) | composer.changed(Integer.MAX_VALUE) | composer.changed((Object) null) | composer.changed(textStyle) | composer.changed((Object) null);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            Object obj = new Function1() { // from class: com.pspdfkit.internal.ap$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ap.a(j, jM6824unboximpl, j2, iM9531getStarte0LSkKk, z, i, num, textStyle, num2, (Context) obj2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        Function1 function1 = (Function1) objRememberedValue2;
        boolean zChangedInstance = composer.changedInstance(markwon) | composer.changed(str);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ap$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ap.a(markwon, str, (TextView) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        AndroidView_androidKt.AndroidView(function1, modifier, (Function1) objRememberedValue3, composer, 48, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    public static final Unit a(Markwon markwon, String str, TextView textView) {
        textView.getClass();
        markwon.setMarkdown(textView, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c6  */
    public static final TextView a(long j, long j2, long j3, int i, boolean z, int i2, Integer num, TextStyle textStyle, Integer num2, Context context) {
        long j4;
        int i3;
        context.getClass();
        if (j != 16) {
            j4 = j;
        } else {
            long jM9121getColor0d7_KjU = textStyle.m9121getColor0d7_KjU();
            j4 = jM9121getColor0d7_KjU != 16 ? jM9121getColor0d7_KjU : j2;
        }
        long j5 = j4;
        TextStyle textStyleMerge = textStyle.merge(new TextStyle(j4, j3, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, i, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744444, (DefaultConstructorMarker) null));
        MAMTextView mAMTextView = new MAMTextView(context);
        mAMTextView.setTextColor(ColorKt.m6868toArgb8_81llA(j5));
        mAMTextView.setMaxLines(i2);
        mAMTextView.setTextSize(1, TextUnit.m9881getValueimpl(textStyleMerge.m9122getFontSizeXSAIIZE()));
        mAMTextView.setTextIsSelectable(z);
        if (num != null) {
            mAMTextView.setTypeface(ResourcesCompat.getFont(context, num.intValue()));
        }
        if (num2 != null) {
            mAMTextView.setId(num2.intValue());
        }
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m9522equalsimpl0(i, companion.m9529getLefte0LSkKk()) || TextAlign.m9522equalsimpl0(i, companion.m9531getStarte0LSkKk())) {
            i3 = 2;
        } else if (TextAlign.m9522equalsimpl0(i, companion.m9530getRighte0LSkKk()) || TextAlign.m9522equalsimpl0(i, companion.m9527getEnde0LSkKk())) {
            i3 = 3;
        } else if (TextAlign.m9522equalsimpl0(i, companion.m9526getCentere0LSkKk())) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        mAMTextView.setTextAlignment(i3);
        if (num != null) {
            mAMTextView.setTypeface(ResourcesCompat.getFont(context, num.intValue()));
        }
        return mAMTextView;
    }
}
