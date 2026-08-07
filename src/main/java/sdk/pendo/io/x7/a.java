package sdk.pendo.io.x7;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/x7/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex b = new Regex("\\[(.*?)]\\((.*?)\\)");
    private static final Regex c = new Regex("\\+\\+(.*?)\\+\\+");
    private static final Regex d = new Regex("~~(.*?)~~");
    private static final Regex e = new Regex("\\*\\*(.*?)\\*\\*");
    private static final Regex f = new Regex("_(.*?)_|\\*(.*?)\\*");
    private static final Regex g = new Regex("\\{color: (#[0-9a-fA-F]{6})\\}((?:(?!\\{color:).)*?)\\{/color\\}", RegexOption.DOT_MATCHES_ALL);
    private static final Regex h = new Regex("\\\\([*~_+\\[\\]()\\\\])");
    private static final List<Regex> i = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("^\\* (.*)$", RegexOption.MULTILINE), new Regex("^\\+ (.*)$", RegexOption.MULTILINE), new Regex("^- (.*)$", RegexOption.MULTILINE)});
    private static final List<String> j = CollectionsKt.listOf((Object[]) new String[]{"\\\\", "\\*\\*", "_", "\\+\\+", "~~", "\\*", "\\{color: #[0-9A-Fa-f]{6}\\}", "\\{/color\\}"});

    /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b(\u0010)J8\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002JD\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042*\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0007R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0019¨\u0006*"}, d2 = {"Lsdk/pendo/io/x7/a$a;", "", "Landroid/text/SpannableStringBuilder;", "spannableString", "Lkotlin/text/Regex;", "pattern", "Lkotlin/Function3;", "Landroid/text/Spannable;", "", "", "styleMarkdownFunction", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/Function5;", "", "styleFunction", "b", "c", "spannable", "start", "end", "", "Landroid/widget/TextView;", "textView", "text", "BOLD_REGEX", "Lkotlin/text/Regex;", "BULLET_POINT", "Ljava/lang/String;", "COLORS_PATTERN", "ESCAPED_CHAR_REGEX", "ITALIC_REGEX", "LINKS_PATTERN", "", "LIST_PATTERN", "Ljava/util/List;", "MARKDOWN_SYMBOL_PATTERNS", "MAX_COLOR_NESTING_DEPTH", "I", "STRIKETHROUGH_REGEX", "UNDERLINE_REGEX", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/x7/a$a$a;", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
        private static final class C0530a {
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$b */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Pair) t).getFirst(), (Integer) ((Pair) t2).getFirst());
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$c */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", "<anonymous parameter 3>", "linkUrl", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;IILjava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 9, 0})
        static final class c extends Lambda implements Function5<Spannable, Integer, Integer, String, String, Unit> {
            public static final c a = new c();

            c() {
                super(5);
            }

            public final void a(Spannable spannable, int i, int i2, String str, String linkUrl) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 3>");
                Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
                spannable.setSpan(new sdk.pendo.io.x7.b(linkUrl), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2, String str, String str2) {
                a(spannable, num.intValue(), num2.intValue(), str, str2);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$d */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class d extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            public static final d a = new d();

            d() {
                super(3);
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                spannable.setSpan(new C0530a(), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$e */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "<anonymous parameter 0>", "", "start", "<anonymous parameter 2>", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class e extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            final /* synthetic */ SpannableStringBuilder a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(SpannableStringBuilder spannableStringBuilder) {
                super(3);
                this.a = spannableStringBuilder;
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "<anonymous parameter 0>");
                this.a.replace(i, i + 1, (CharSequence) "●");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$f */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "<anonymous parameter 0>", "", "start", "<anonymous parameter 2>", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class f extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            final /* synthetic */ SpannableStringBuilder a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(SpannableStringBuilder spannableStringBuilder) {
                super(3);
                this.a = spannableStringBuilder;
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "<anonymous parameter 0>");
                this.a.replace(i, i + 1, (CharSequence) "●");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$g */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "<anonymous parameter 0>", "", "start", "<anonymous parameter 2>", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class g extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            final /* synthetic */ SpannableStringBuilder a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(SpannableStringBuilder spannableStringBuilder) {
                super(3);
                this.a = spannableStringBuilder;
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "<anonymous parameter 0>");
                this.a.replace(i, i + 1, (CharSequence) "●");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$h */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class h extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            public static final h a = new h();

            h() {
                super(3);
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$i */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class i extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            public static final i a = new i();

            i() {
                super(3);
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                spannable.setSpan(new StyleSpan(1), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$j */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class j extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            public static final j a = new j();

            j() {
                super(3);
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                spannable.setSpan(new StyleSpan(2), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.x7.a$a$k */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/text/Spannable;", "spannable", "", "start", "end", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/text/Spannable;II)V"}, k = 3, mv = {1, 9, 0})
        static final class k extends Lambda implements Function3<Spannable, Integer, Integer, Unit> {
            public static final k a = new k();

            k() {
                super(3);
            }

            public final void a(Spannable spannable, int i, int i2) {
                Intrinsics.checkNotNullParameter(spannable, "spannable");
                spannable.setSpan(new UnderlineSpan(), i, i2, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Spannable spannable, Integer num, Integer num2) {
                a(spannable, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(SpannableStringBuilder spannableString, Regex pattern, Function3<? super Spannable, ? super Integer, ? super Integer, Unit> styleMarkdownFunction) {
            for (MatchResult matchResult : Regex.findAll$default(pattern, spannableString, 0, 2, null)) {
                styleMarkdownFunction.invoke(spannableString, Integer.valueOf(matchResult.getRange().getFirst()), Integer.valueOf(matchResult.getRange().getLast() + 1));
            }
        }

        private final void b(SpannableStringBuilder spannableString) {
            for (MatchResult matchResult : CollectionsKt.reversed(SequencesKt.toList(Regex.findAll$default(a.b, spannableString, 0, 2, null)))) {
                spannableString.replace(matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1, (CharSequence) matchResult.getGroupValues().get(1));
            }
        }

        private final void c(SpannableStringBuilder spannableString) {
            int i2;
            Iterator it = a.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                for (MatchResult matchResult : CollectionsKt.asReversed(SequencesKt.toList(Regex.findAll$default(new Regex((String) it.next()), spannableString, 0, 2, null)))) {
                    int first = matchResult.getRange().getFirst();
                    int last = matchResult.getRange().getLast() + 1;
                    if (!a(spannableString, first, last)) {
                        spannableString.delete(first, last);
                    }
                }
            }
            C0530a[] c0530aArr = (C0530a[]) spannableString.getSpans(0, spannableString.length(), C0530a.class);
            Intrinsics.checkNotNull(c0530aArr);
            List listReversed = ArraysKt.reversed(c0530aArr);
            int size = listReversed.size();
            for (i2 = 0; i2 < size; i2++) {
                C0530a c0530a = (C0530a) listReversed.get(i2);
                int spanStart = spannableString.getSpanStart(c0530a);
                int spanEnd = spannableString.getSpanEnd(c0530a);
                spannableString.removeSpan(c0530a);
                if (spanEnd - spanStart == 2 && spannableString.charAt(spanStart) == '\\') {
                    spannableString.delete(spanStart, spanStart + 1);
                }
            }
        }

        private final void a(SpannableStringBuilder spannableString) {
            MatchResult matchResultFind$default;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 50 || (matchResultFind$default = Regex.find$default(a.g, spannableString, 0, 2, null)) == null) {
                    return;
                }
                String str = matchResultFind$default.getGroupValues().get(1);
                int color = Color.parseColor(str);
                int first = matchResultFind$default.getRange().getFirst();
                int last = matchResultFind$default.getRange().getLast();
                int i4 = last + 1;
                int length = ("{color: " + str + "}").length() + first;
                int i5 = last - 7;
                ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableString.getSpans(length, i5, ForegroundColorSpan.class);
                Intrinsics.checkNotNull(foregroundColorSpanArr);
                ArrayList arrayList = new ArrayList(foregroundColorSpanArr.length);
                for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                    arrayList.add(TuplesKt.to(Integer.valueOf(spannableString.getSpanStart(foregroundColorSpan)), Integer.valueOf(spannableString.getSpanEnd(foregroundColorSpan))));
                }
                int iMax = length;
                for (Pair pair : CollectionsKt.sortedWith(arrayList, new b())) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    if (iMax < iIntValue) {
                        spannableString.setSpan(new ForegroundColorSpan(color), iMax, iIntValue, 33);
                    }
                    iMax = Math.max(iMax, iIntValue2);
                }
                if (iMax < i5) {
                    spannableString.setSpan(new ForegroundColorSpan(color), iMax, i5, 33);
                }
                spannableString.delete(i5, i4);
                spannableString.delete(first, length);
                i2 = i3;
            }
        }

        private final void a(SpannableStringBuilder spannableString, Regex pattern, Function5<? super Spannable, ? super Integer, ? super Integer, ? super String, ? super String, Unit> styleFunction) {
            for (MatchResult matchResult : Regex.findAll$default(pattern, spannableString, 0, 2, null)) {
                int first = matchResult.getRange().getFirst();
                int last = matchResult.getRange().getLast() + 1;
                styleFunction.invoke(spannableString, Integer.valueOf(first), Integer.valueOf(last), matchResult.getGroupValues().get(1), matchResult.getGroupValues().get(2));
            }
        }

        @JvmStatic
        public final void a(TextView textView, String text) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(text, "text");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            a(spannableStringBuilder, a.b, c.a);
            b(spannableStringBuilder);
            a(spannableStringBuilder, a.h, d.a);
            a(spannableStringBuilder, (Regex) a.i.get(0), new e(spannableStringBuilder));
            a(spannableStringBuilder, (Regex) a.i.get(1), new f(spannableStringBuilder));
            a(spannableStringBuilder, (Regex) a.i.get(2), new g(spannableStringBuilder));
            a(spannableStringBuilder, a.d, h.a);
            a(spannableStringBuilder, a.e, i.a);
            a(spannableStringBuilder, a.f, j.a);
            a(spannableStringBuilder, a.c, k.a);
            a(spannableStringBuilder);
            c(spannableStringBuilder);
            textView.setText(spannableStringBuilder);
            textView.setLinksClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        private final boolean a(Spannable spannable, int start, int end) {
            Object[] spans = spannable.getSpans(start, end, C0530a.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            return !(spans.length == 0);
        }
    }

    @JvmStatic
    public static final void a(TextView textView, String str) {
        INSTANCE.a(textView, str);
    }
}
