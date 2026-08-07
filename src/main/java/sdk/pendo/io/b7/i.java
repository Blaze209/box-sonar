package sdk.pendo.io.b7;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;
import sdk.pendo.io.h7.l;
import sdk.pendo.io.h7.s;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0005\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\f\u0010\r\u001a\u00020\u0007*\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0002H\u0002J0\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J(\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J6\u0010\u0005\u001a\u00060!j\u0002`\"2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b\u0005\u0010%J\u0019\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010'J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010'J!\u0010\u0005\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0005\u0010,J\u0017\u0010-\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0005\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b5\u00106¨\u00069"}, d2 = {"Lsdk/pendo/io/b7/i;", "", "Landroid/widget/TextView;", "view", "Landroid/text/TextPaint;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/Pair;", "", "", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/h7/l;", "privacyMode", "isUserInput", "i", "fontFamily", "b", "Landroid/graphics/Typeface;", "typeface", "Landroid/view/View;", "j", "Landroid/text/Layout;", "layout", "", "line", "topPadding", "visibleTop", "visibleBottom", "textView", "original", "lineStart", "baseLineText", "Landroid/text/Spanned;", "spanned", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lsdk/pendo/io/h7/s;", "privacyConfig", "(Landroid/widget/TextView;Lsdk/pendo/io/h7/s;)Ljava/lang/String;", "c", "(Landroid/widget/TextView;)Ljava/lang/String;", "g", "k", "at", "", "(Landroid/widget/TextView;I)F", "f", "(Landroid/widget/TextView;)I", "text", "(Ljava/lang/String;)Z", "Lsdk/pendo/io/h7/e;", "e", "(Landroid/widget/TextView;)Lsdk/pendo/io/h7/e;", "Lsdk/pendo/io/h7/d;", "d", "(Landroid/widget/TextView;)Lsdk/pendo/io/h7/d;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i {
    public static final i a = new i();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TextUtils.TruncateAt.values().length];
            try {
                iArr[TextUtils.TruncateAt.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextUtils.TruncateAt.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private i() {
    }

    private final String a(String str, l lVar, boolean z) {
        if (z) {
            return StringsKt.repeat("*", 10);
        }
        if (lVar != l.MAX_PRIVACY) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\t') {
                sb.append(cCharAt);
            } else {
                sb.append("*");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054 A[PHI: r3
      0x0054: PHI (r3v5 java.lang.CharSequence) = 
      (r3v2 java.lang.CharSequence)
      (r3v9 java.lang.CharSequence)
      (r3v11 java.lang.CharSequence)
      (r3v12 java.lang.CharSequence)
     binds: [B:29:0x0052, B:21:0x003c, B:18:0x0035, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    private final Pair<String, Boolean> h(TextView view) {
        String strI;
        CharSequence hint;
        String string = null;
        boolean z = false;
        if (view instanceof EditText) {
            strI = i(view);
            if (StringsKt.isBlank(strI)) {
                EditText editText = (EditText) view;
                ViewParent parent = editText.getParent();
                ViewParent parent2 = parent != null ? parent.getParent() : null;
                if (!(parent2 instanceof TextInputLayout) ? !(!(parent instanceof TextInputLayout) ? (hint = editText.getHint()) == null : (hint = ((TextInputLayout) parent).getHint()) == null) : (hint = ((TextInputLayout) parent2).getHint()) != null) {
                    string = hint.toString();
                }
                z = true;
                strI = string;
            }
        } else {
            boolean z2 = view instanceof Chip;
            strI = i(view);
            if (!z2 && StringsKt.isBlank(strI)) {
                hint = view.getHint();
                if (hint != null) {
                    string = hint.toString();
                }
                z = true;
                strI = string;
            }
        }
        return TuplesKt.to(strI, Boolean.valueOf(z));
    }

    private final String i(TextView textView) {
        CharSequence transformation;
        String string;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        String strJ = j(textView);
        return (transformationMethod == null || (transformation = transformationMethod.getTransformation(strJ, textView)) == null || (string = transformation.toString()) == null) ? strJ : string;
    }

    private final String j(TextView textView) {
        Spanned spanned;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return "";
        }
        String string = textView.getText().toString();
        CharSequence text = textView.getText();
        Spanned spanned2 = text instanceof Spanned ? (Spanned) text : null;
        int totalPaddingTop = textView.getTotalPaddingTop();
        int totalPaddingBottom = textView.getTotalPaddingBottom();
        int scrollY = textView.getScrollY() + totalPaddingTop;
        int scrollY2 = (textView.getScrollY() + textView.getHeight()) - totalPaddingBottom;
        StringBuilder sb = new StringBuilder();
        int lineCount = layout.getLineCount();
        int i = 0;
        while (i < lineCount) {
            int i2 = totalPaddingTop;
            int i3 = scrollY;
            int i4 = scrollY2;
            if (a(layout, i, totalPaddingTop, scrollY, scrollY2)) {
                int i5 = i;
                String strA = a(i5, layout, textView, string);
                Layout layout2 = layout;
                spanned = spanned2;
                StringBuilder sbA = a(i5, strA, layout2, textView, spanned);
                i = i5;
                layout = layout2;
                sb.append((CharSequence) sbA);
                if (i < layout.getLineCount() - 1 && !StringsKt.endsWith$default((CharSequence) strA, '\n', false, 2, (Object) null)) {
                    sb.append('\n');
                }
            } else {
                spanned = spanned2;
            }
            i++;
            spanned2 = spanned;
            totalPaddingTop = i2;
            scrollY = i3;
            scrollY2 = i4;
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public final String b(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        int textDirection = textView.getTextDirection();
        if (textDirection == 0) {
            return "inherit";
        }
        if (textDirection == 1) {
            return "isolate";
        }
        if (textDirection != 2) {
            return (textDirection == 3 || textDirection == 4) ? "embed" : SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL;
        }
        return "bidi-override";
    }

    public final String c(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 34) {
            Typeface typeface = view.getTypeface();
            String systemFontFamilyName = typeface != null ? typeface.getSystemFontFamilyName() : null;
            if (systemFontFamilyName != null) {
                return b(systemFontFamilyName);
            }
        }
        return b(a(view.getTypeface()));
    }

    public final sdk.pendo.io.h7.d d(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TextPaint textPaintA = a(view);
        Typeface typeface = textPaintA.getTypeface();
        return (((typeface != null ? typeface.getStyle() : 0) & 2) != 0 || Math.abs(textPaintA.getTextSkewX()) > 0.01f) ? sdk.pendo.io.h7.d.ITALIC : sdk.pendo.io.h7.d.NORMAL;
    }

    public final sdk.pendo.io.h7.e e(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TextPaint textPaintA = a(view);
        Typeface typeface = textPaintA.getTypeface();
        return (((typeface != null ? typeface.getStyle() : 0) & 1) != 0 || textPaintA.isFakeBoldText()) ? sdk.pendo.io.h7.e.BOLD : sdk.pendo.io.h7.e.NORMAL;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public final int f(TextView view) {
        ForegroundColorSpan foregroundColorSpan;
        Intrinsics.checkNotNullParameter(view, "view");
        CharSequence text = view.getText();
        if (!(text instanceof Spanned) || text.length() <= 0) {
            return view.getCurrentTextColor();
        }
        Spanned spanned = (Spanned) text;
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spanned.getSpans(0, 0, ForegroundColorSpan.class);
        Intrinsics.checkNotNull(foregroundColorSpanArr);
        if (foregroundColorSpanArr.length == 0) {
            foregroundColorSpan = null;
        } else {
            ForegroundColorSpan foregroundColorSpan2 = foregroundColorSpanArr[0];
            int lastIndex = ArraysKt.getLastIndex(foregroundColorSpanArr);
            if (lastIndex != 0) {
                int spanStart = spanned.getSpanStart(foregroundColorSpan2);
                ?? it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    ForegroundColorSpan foregroundColorSpan3 = foregroundColorSpanArr[it.nextInt()];
                    int spanStart2 = spanned.getSpanStart(foregroundColorSpan3);
                    if (spanStart < spanStart2) {
                        foregroundColorSpan2 = foregroundColorSpan3;
                        spanStart = spanStart2;
                    }
                }
            }
            foregroundColorSpan = foregroundColorSpan2;
        }
        return foregroundColorSpan != null ? foregroundColorSpan.getForegroundColor() : view.getCurrentTextColor();
    }

    public final String g(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        int textDirection = textView.getTextDirection();
        if (textDirection == 2) {
            return "rtl";
        }
        if (textDirection == 3) {
            return "ltr";
        }
        if (textDirection == 4) {
            return "rtl";
        }
        if (textDirection != 5) {
            return k(textView);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? "rtl" : "ltr";
    }

    public final String k(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Layout layout = textView.getLayout();
        return (layout == null || layout.getLineCount() <= 0 || layout.getParagraphDirection(0) != -1) ? "ltr" : "rtl";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    private final StringBuilder a(int lineStart, String baseLineText, Layout layout, TextView textView, Spanned spanned) {
        boolean z;
        StrikethroughSpan[] strikethroughSpanArr;
        UnderlineSpan[] underlineSpanArr;
        StringBuilder sb = new StringBuilder();
        int length = baseLineText.length();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            int lineStart2 = layout.getLineStart(lineStart) + i;
            boolean z4 = true;
            boolean z5 = (textView.getPaintFlags() & 8) != 0;
            boolean z6 = (textView.getPaintFlags() & 16) != 0;
            if (z5) {
                z = true;
            } else {
                if (spanned != null && (underlineSpanArr = (UnderlineSpan[]) spanned.getSpans(lineStart2, lineStart2 + 1, UnderlineSpan.class)) != null) {
                    if (!(underlineSpanArr.length == 0)) {
                        z = true;
                    }
                }
                z = false;
            }
            if (!z6) {
                if (spanned == null || (strikethroughSpanArr = (StrikethroughSpan[]) spanned.getSpans(lineStart2, lineStart2 + 1, StrikethroughSpan.class)) == null) {
                    z4 = false;
                } else {
                    if (!(!(strikethroughSpanArr.length == 0))) {
                        z4 = false;
                    }
                }
            }
            if (z2 && !z4) {
                sb.append("</pendo_s>");
            }
            if (z3 && !z) {
                sb.append("</pendo_u>");
            }
            if (!z3 && z) {
                sb.append("<pendo_u>");
            }
            if (!z2 && z4) {
                sb.append("<pendo_s>");
            }
            sb.append(baseLineText.charAt(i));
            i++;
            z3 = z;
            z2 = z4;
        }
        if (z2) {
            sb.append("</pendo_s>");
        }
        if (z3) {
            sb.append("</pendo_u>");
        }
        return sb;
    }

    private final String b(String fontFamily) {
        if (fontFamily == null || StringsKt.isBlank(fontFamily)) {
            return null;
        }
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"-thin", "-light", "-regular", "-medium", "-semibold", "-bold", "-extrabold", "-black", "-italic", "-condensed", "-narrow"});
        String lowerCase = fontFamily.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (String str : listListOf) {
            if (StringsKt.endsWith$default(lowerCase, str, false, 2, (Object) null)) {
                return StringsKt.trimEnd(StringsKt.removeSuffix(lowerCase, (CharSequence) str), Soundex.SILENT_MARKER);
            }
        }
        return lowerCase;
    }

    private final TextPaint a(TextView view) {
        TextPaint textPaint = new TextPaint(view.getPaint());
        CharSequence text = view.getText();
        if ((text instanceof Spanned) && text.length() > 0) {
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) ((Spanned) text).getSpans(0, 1, MetricAffectingSpan.class);
            Intrinsics.checkNotNull(metricAffectingSpanArr);
            for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                metricAffectingSpan.updateMeasureState(textPaint);
            }
        }
        return textPaint;
    }

    public final String a(TextView view, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Pair<String, Boolean> pairH = h(view);
        String strComponent1 = pairH.component1();
        boolean z = a((View) view) && !pairH.component2().booleanValue();
        if (strComponent1 != null) {
            return a(strComponent1, privacyConfig.getPrivacyMode(), z);
        }
        return null;
    }

    public final float a(TextView view, int at) {
        Intrinsics.checkNotNullParameter(view, "view");
        CharSequence text = view.getText();
        if ((text instanceof Spanned) && text.length() > 0) {
            int iCoerceIn = RangesKt.coerceIn(at, 0, text.length() - 1);
            Spanned spanned = (Spanned) text;
            Object[] spans = spanned.getSpans(iCoerceIn, iCoerceIn, AbsoluteSizeSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) ArraysKt.lastOrNull(spans);
            if (absoluteSizeSpan != null) {
                return absoluteSizeSpan.getDip() ? TypedValue.applyDimension(1, absoluteSizeSpan.getSize(), view.getResources().getDisplayMetrics()) : absoluteSizeSpan.getSize();
            }
            Object[] spans2 = spanned.getSpans(iCoerceIn, iCoerceIn, RelativeSizeSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
            RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) ArraysKt.lastOrNull(spans2);
            if (relativeSizeSpan != null) {
                return view.getTextSize() * relativeSizeSpan.getSizeChange();
            }
            TextPaint textPaint = new TextPaint(view.getPaint());
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(iCoerceIn, iCoerceIn, MetricAffectingSpan.class);
            Intrinsics.checkNotNull(metricAffectingSpanArr);
            if (!(metricAffectingSpanArr.length == 0)) {
                for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                    metricAffectingSpan.updateMeasureState(textPaint);
                }
                return textPaint.getTextSize();
            }
        }
        return view.getTextSize();
    }

    public static /* synthetic */ float a(i iVar, TextView textView, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return iVar.a(textView, i);
    }

    private final String a(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("sSystemFontMap");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue(), typeface)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Set setKeySet = linkedHashMap.keySet();
            if (!setKeySet.isEmpty()) {
                return (String) CollectionsKt.first(setKeySet);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final String a(int line, Layout layout, TextView textView, String original) {
        int lineStart = layout.getLineStart(line);
        int lineEnd = layout.getLineEnd(line);
        int ellipsisStart = layout.getEllipsisStart(line);
        int ellipsisCount = layout.getEllipsisCount(line);
        if (ellipsisCount <= 0) {
            String strSubstring = original.substring(lineStart, lineEnd);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        TextUtils.TruncateAt ellipsize = textView.getEllipsize();
        int i = ellipsize == null ? -1 : a.a[ellipsize.ordinal()];
        if (i == 1) {
            String strSubstring2 = original.substring(lineStart + ellipsisStart + ellipsisCount, lineEnd);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return "…" + strSubstring2;
        }
        int i2 = ellipsisStart + lineStart;
        String strSubstring3 = original.substring(lineStart, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
        if (i != 2) {
            return strSubstring3 + "…";
        }
        String strSubstring4 = original.substring(i2 + ellipsisCount, lineEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring3 + "…" + strSubstring4;
    }

    public final boolean a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() != 1) {
            return false;
        }
        int iCodePointAt = text.codePointAt(0);
        return (57344 <= iCodePointAt && iCodePointAt < 63744) || (983040 <= iCodePointAt && iCodePointAt < 1048574) || (1048576 <= iCodePointAt && iCodePointAt < 1114110);
    }

    private final boolean a(View view) {
        if (view instanceof EditText) {
            return true;
        }
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        return textView.isEnabled() && textView.isFocusable() && textView.isFocusableInTouchMode() && textView.getInputType() != 0;
    }

    private final boolean a(Layout layout, int line, int topPadding, int visibleTop, int visibleBottom) {
        return layout.getLineBottom(line) + topPadding > visibleTop && layout.getLineTop(line) + topPadding < visibleBottom;
    }
}
