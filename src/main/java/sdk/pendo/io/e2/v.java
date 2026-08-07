package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxIterator;
import com.google.common.base.Ascii;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0018\u0018\u0000 '2\u00020\u0001:\u0002\u0015\u000eBc\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\u0012\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0$\u0012\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010$\u0012\b\u0010,\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010.\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\bJ\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u0017\u0010\u0019\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010#\u001a\u00020\u00128\u0007¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0$8\u0007¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010&R\u0019\u0010,\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0016R\u0017\u00101\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b-\u00100R\u0011\u00102\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b*\u0010\u0018R\u0011\u00103\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0011\u00104\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0018R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\b0$8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010(R\u0013\u00106\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b%\u0010\u0018R\u0013\u00108\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b7\u0010\u0018R\u0013\u00109\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0018¨\u0006<"}, d2 = {"Lsdk/pendo/io/e2/v;", "", "Ljava/net/URL;", "q", "()Ljava/net/URL;", "Ljava/net/URI;", "p", "()Ljava/net/URI;", "", "n", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK, "d", "Lsdk/pendo/io/e2/v$a;", "j", "b", "other", "", "equals", "", "hashCode", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "o", "()Ljava/lang/String;", "scheme", "username", "c", "password", CmcdData.STREAMING_FORMAT_HLS, "host", "e", "I", CmcdData.STREAM_TYPE_LIVE, "()I", "port", "", "f", "Ljava/util/List;", "k", "()Ljava/util/List;", "pathSegments", "g", "queryNamesAndValues", BuildConfig.FLAVOR, "i", "url", "Z", "()Z", "isHttps", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", CmcdData.OBJECT_TYPE_MANIFEST, "query", "encodedFragment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class v {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String scheme;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String username;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String password;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String host;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int port;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final List<String> pathSegments;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final List<String> queryNamesAndValues;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final String fragment;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean isHttps;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u000f\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u001fJ\u0006\u0010\t\u001a\u00020 J\b\u0010!\u001a\u00020\u0004H\u0016J!\u0010\t\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010#R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\"\u0010.\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010$\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103\"\u0004\b\u0003\u00104R \u00108\u001a\b\u0012\u0004\u0012\u00020\u0004058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u00106\u001a\u0004\b\u0017\u00107R,\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u00106\u001a\u0004\b9\u00107\"\u0004\b:\u0010;R$\u0010?\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010$\u001a\u0004\b>\u0010&\"\u0004\b=\u0010(¨\u0006B"}, d2 = {"Lsdk/pendo/io/e2/v$a;", "", "", "b", "", "input", "startPos", BoxIterator.FIELD_LIMIT, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pos", "", "addTrailingSlash", "alreadyEncoded", "d", "e", "scheme", "g", "username", CmcdData.OBJECT_TYPE_MANIFEST, "password", "f", "host", "c", "port", "pathSegment", "encodedQuery", "name", "value", "encodedName", "encodedValue", "()Lsdk/pendo/io/e2/v$a;", "Lsdk/pendo/io/e2/v;", "toString", "base", "(Lsdk/pendo/io/e2/v;Ljava/lang/String;)Lsdk/pendo/io/e2/v$a;", "Ljava/lang/String;", "getScheme$okhttp", "()Ljava/lang/String;", CmcdData.STREAM_TYPE_LIVE, "(Ljava/lang/String;)V", "getEncodedUsername$okhttp", "j", "encodedUsername", "getEncodedPassword$okhttp", "i", "encodedPassword", "getHost$okhttp", "k", "I", "getPort$okhttp", "()I", "(I)V", "", "Ljava/util/List;", "()Ljava/util/List;", "encodedPathSegments", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", CmcdData.STREAMING_FORMAT_HLS, "getEncodedFragment$okhttp", "encodedFragment", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private String scheme;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private String host;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private final List<String> encodedPathSegments;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private List<String> encodedQueryNamesAndValues;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private String encodedFragment;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private String encodedUsername = "";

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private String encodedPassword = "";

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private int port = -1;

        /* JADX INFO: renamed from: sdk.pendo.io.e2.v$a$a, reason: collision with other inner class name and from kotlin metadata */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/e2/v$a$a;", "", "", "input", "", "pos", BoxIterator.FIELD_LIMIT, "c", "d", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int a(String input, int pos, int limit) {
                try {
                    int i = Integer.parseInt(Companion.a(v.INSTANCE, input, pos, limit, "", false, false, false, false, null, 248, null));
                    if (1 > i || i >= 65536) {
                        return -1;
                    }
                    return i;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int b(String input, int pos, int limit) {
                while (pos < limit) {
                    char cCharAt = input.charAt(pos);
                    if (cCharAt == '[') {
                        do {
                            pos++;
                            if (pos >= limit) {
                                break;
                            }
                        } while (input.charAt(pos) != ']');
                    } else if (cCharAt == ':') {
                        return pos;
                    }
                    pos++;
                }
                return limit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int c(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char cCharAt = input.charAt(pos);
                if ((Intrinsics.compare((int) cCharAt, 97) >= 0 && Intrinsics.compare((int) cCharAt, 122) <= 0) || (Intrinsics.compare((int) cCharAt, 65) >= 0 && Intrinsics.compare((int) cCharAt, 90) <= 0)) {
                    while (true) {
                        pos++;
                        if (pos >= limit) {
                            break;
                        }
                        char cCharAt2 = input.charAt(pos);
                        if ('a' > cCharAt2 || cCharAt2 >= '{') {
                            if ('A' > cCharAt2 || cCharAt2 >= '[') {
                                if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                    if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                        if (cCharAt2 == ':') {
                                            return pos;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int d(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final boolean d(String input) {
            return Intrinsics.areEqual(input, ".") || StringsKt.equals(input, "%2e", true);
        }

        private final boolean e(String input) {
            return Intrinsics.areEqual(input, "..") || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        public final a a(String encodedName, String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.a(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, BoxCommonConstants.REQUEST_DELETE, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(encodedValue != null ? Companion.a(companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, BoxCommonConstants.REQUEST_DELETE, null) : null);
            return this;
        }

        public final a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.a(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, BoxCommonConstants.REQUEST_INVITE_COLLABORATORS, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(value != null ? Companion.a(companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, BoxCommonConstants.REQUEST_INVITE_COLLABORATORS, null) : null);
            return this;
        }

        public final List<String> c() {
            return this.encodedPathSegments;
        }

        public final a f(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.encodedPassword = Companion.a(v.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a g(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.equals(scheme, "http", true)) {
                this.scheme = "http";
                return this;
            }
            if (!StringsKt.equals(scheme, "https", true)) {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
            this.scheme = "https";
            return this;
        }

        public final void h(String str) {
            this.encodedFragment = str;
        }

        public final void i(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final void j(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void k(String str) {
            this.host = str;
        }

        public final void l(String str) {
            this.scheme = str;
        }

        public final a m(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.encodedUsername = Companion.a(v.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0082  */
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.scheme;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.encodedPassword);
                }
                sb.append(CommentBarInputBoxKt.MENTION_SYMBOL);
            }
            String str3 = this.host;
            if (str3 != null) {
                Intrinsics.checkNotNull(str3);
                if (StringsKt.contains$default((CharSequence) str3, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(this.host);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iB = b();
                String str4 = this.scheme;
                if (str4 != null) {
                    Companion companion = v.INSTANCE;
                    Intrinsics.checkNotNull(str4);
                    if (iB != companion.a(str4)) {
                        sb.append(AbstractJsonLexerKt.COLON);
                        sb.append(iB);
                    }
                } else {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(iB);
                }
            }
            Companion companion2 = v.INSTANCE;
            companion2.a(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                companion2.b(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append(ColorSerializer.PREFIX);
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        private final int b() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = v.INSTANCE;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.a(str);
        }

        private final void d() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        public final a a(String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            a(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final a c(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String strB = sdk.pendo.io.f2.a.b(Companion.a(v.INSTANCE, host, 0, 0, false, 7, null));
            if (strB == null) {
                throw new IllegalArgumentException("unexpected host: " + host);
            }
            this.host = strB;
            return this;
        }

        public final a e() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, Companion.a(v.INSTANCE, list.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? Companion.a(v.INSTANCE, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.a(v.INSTANCE, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, Token.GENEXPR, null) : null;
            return this;
        }

        public final v a() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = v.INSTANCE;
            String strA = Companion.a(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strA2 = Companion.a(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iB = b();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.a(v.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList3.add(str3 != null ? Companion.a(v.INSTANCE, str3, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new v(str, strA, strA2, str2, iB, arrayList2, arrayList, str4 != null ? Companion.a(v.INSTANCE, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final a b(String encodedQuery) {
            Companion companion;
            String strA;
            this.encodedQueryNamesAndValues = (encodedQuery == null || (strA = Companion.a((companion = v.INSTANCE), encodedQuery, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, BoxCommonConstants.REQUEST_DELETE, null)) == null) ? null : companion.d(strA);
            return this;
        }

        public final a a(v base, String input) {
            int iA;
            int i;
            boolean z;
            int i2;
            int i3;
            int i4;
            char c;
            int i5;
            String input2 = input;
            Intrinsics.checkNotNullParameter(input2, "input");
            int iA2 = sdk.pendo.io.f2.b.a(input2, 0, 0, 3, null);
            int iB = sdk.pendo.io.f2.b.b(input2, iA2, 0, 2, null);
            Companion companion = INSTANCE;
            int iC = companion.c(input2, iA2, iB);
            String str = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean z2 = true;
            int i6 = -1;
            if (iC != -1) {
                if (StringsKt.startsWith(input2, "https:", iA2, true)) {
                    this.scheme = "https";
                    iA2 += 6;
                } else {
                    if (!StringsKt.startsWith(input2, "http:", iA2, true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input2.substring(0, iC);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        throw new IllegalArgumentException(sb.append(strSubstring).append('\'').toString());
                    }
                    this.scheme = "http";
                    iA2 += 5;
                }
            } else {
                if (base == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + (input2.length() > 6 ? StringsKt.take(input2, 6) + "..." : input2));
                }
                this.scheme = base.getScheme();
            }
            int iD = companion.d(input2, iA2, iB);
            int i7 = 63;
            int i8 = 35;
            if (iD >= 2 || base == null || !Intrinsics.areEqual(base.getScheme(), this.scheme)) {
                int i9 = iA2 + iD;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    iA = sdk.pendo.io.f2.b.a(input2, "@/\\?#", i9, iB);
                    int iCharAt = iA != iB ? input2.charAt(iA) : i6;
                    if (iCharAt == i6 || iCharAt == i8 || iCharAt == 47 || iCharAt == 92 || iCharAt == i7) {
                        break;
                    }
                    if (iCharAt == 64) {
                        if (z3) {
                            z = z2;
                            i2 = i6;
                            input2 = input;
                            i3 = iA;
                            this.encodedPassword += "%40" + Companion.a(v.INSTANCE, input2, i9, iA, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                        } else {
                            int iA3 = sdk.pendo.io.f2.b.a(input2, AbstractJsonLexerKt.COLON, i9, iA);
                            Companion companion2 = v.INSTANCE;
                            i2 = i6;
                            z = z2;
                            String strA = Companion.a(companion2, input2, i9, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                            if (z4) {
                                strA = this.encodedUsername + "%40" + strA;
                            }
                            this.encodedUsername = strA;
                            if (iA3 != iA) {
                                i4 = iA;
                                this.encodedPassword = Companion.a(companion2, input, iA3 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                                z3 = z;
                            } else {
                                i4 = iA;
                            }
                            input2 = input;
                            i3 = i4;
                            z4 = z;
                        }
                        i9 = i3 + 1;
                        i6 = i2;
                        iB = iB;
                        str = str;
                        z2 = z;
                        i7 = 63;
                        i8 = 35;
                    }
                }
                i = iB;
                String str2 = str;
                int i10 = i6;
                Companion companion3 = INSTANCE;
                int iB2 = companion3.b(input2, i9, iA);
                int i11 = iB2 + 1;
                if (i11 < iA) {
                    this.host = sdk.pendo.io.f2.a.b(Companion.a(v.INSTANCE, input2, i9, iB2, false, 4, null));
                    int iA4 = companion3.a(input2, i11, iA);
                    this.port = iA4;
                    if (iA4 == i10) {
                        StringBuilder sb2 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = input2.substring(i11, iA);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, str2);
                        throw new IllegalArgumentException(sb2.append(strSubstring2).append('\"').toString().toString());
                    }
                } else {
                    Companion companion4 = v.INSTANCE;
                    this.host = sdk.pendo.io.f2.a.b(Companion.a(companion4, input2, i9, iB2, false, 4, null));
                    String str3 = this.scheme;
                    Intrinsics.checkNotNull(str3);
                    this.port = companion4.a(str3);
                }
                if (this.host == null) {
                    StringBuilder sb3 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = input2.substring(i9, iB2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, str2);
                    throw new IllegalArgumentException(sb3.append(strSubstring3).append('\"').toString().toString());
                }
                iA2 = iA;
            } else {
                this.encodedUsername = base.g();
                this.encodedPassword = base.c();
                this.host = base.getHost();
                this.port = base.getPort();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.e());
                if (iA2 == iB || input2.charAt(iA2) == '#') {
                    b(base.f());
                }
                i = iB;
            }
            int i12 = i;
            int iA5 = sdk.pendo.io.f2.b.a(input2, "?#", iA2, i12);
            a(input2, iA2, iA5);
            if (iA5 >= i12 || input2.charAt(iA5) != '?') {
                c = ColorSerializer.PREFIX;
                i5 = iA5;
            } else {
                c = ColorSerializer.PREFIX;
                int iA6 = sdk.pendo.io.f2.b.a(input2, ColorSerializer.PREFIX, iA5, i12);
                Companion companion5 = v.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.d(Companion.a(companion5, input2, iA5 + 1, iA6, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                i5 = iA6;
            }
            if (i5 < i12 && input2.charAt(i5) == c) {
                this.encodedFragment = Companion.a(v.INSTANCE, input2, i5 + 1, i12, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final void b(int i) {
            this.port = i;
        }

        public final a a(int port) {
            if (1 > port || port >= 65536) {
                throw new IllegalArgumentException(("unexpected port: " + port).toString());
            }
            this.port = port;
            return this;
        }

        private final void a(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String strA = Companion.a(v.INSTANCE, input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
            if (d(strA)) {
                return;
            }
            if (e(strA)) {
                d();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strA);
            } else {
                this.encodedPathSegments.add(strA);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add("");
            }
        }

        private final void a(String input, int startPos, int limit) {
            if (startPos == limit) {
                return;
            }
            char cCharAt = input.charAt(startPos);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                startPos++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i = startPos;
            while (i < limit) {
                int iA = sdk.pendo.io.f2.b.a(input, "/\\", i, limit);
                boolean z = iA < limit;
                this = this;
                input = input;
                this.a(input, i, iA, z, true);
                i = z ? iA + 1 : iA;
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.v$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b1\u00102J,\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JV\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0007J%\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u00142\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0000¢\u0006\u0004\b\u000b\u0010\u0018J'\u0010\u0019\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00142\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001a*\u00020\u0003H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0019\u001a\u00020\u001d*\u00020\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010\u001eJ1\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010 Jc\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u000b\u0010!R\u0014\u0010\"\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010+\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b,\u0010#R\u0014\u0010-\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010#R\u0014\u0010.\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b.\u0010#R\u0014\u0010/\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010#R\u0014\u00100\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b0\u0010#¨\u00063"}, d2 = {"Lsdk/pendo/io/e2/v$b;", "", "Lsdk/pendo/io/s2/d;", "", "encoded", "", "pos", BoxIterator.FIELD_LIMIT, "", "plusIsSpace", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "scheme", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "b", "", "d", "(Ljava/lang/String;)Ljava/util/List;", "Lsdk/pendo/io/e2/v;", "(Ljava/lang/String;)Lsdk/pendo/io/e2/v;", "c", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str, int i, int i2, String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int iCharCount = i;
            while (iCharCount < i2) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || StringsKt.contains$default((CharSequence) encodeSet, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z || (z2 && !a(str, iCharCount, i2)))) || (iCodePointAt == 43 && z3)))) {
                    sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
                    dVar.a(str, i, iCharCount);
                    a(dVar, str, iCharCount, i2, encodeSet, z, z2, z3, z4, charset);
                    return dVar.readUtf8();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        @JvmStatic
        public final v b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new a().a((v) null, str).a();
        }

        @JvmStatic
        public final v c(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return b(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final List<String> d(String str) {
            String strSubstring;
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                String str2 = str;
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, Typography.amp, i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str2.length();
                }
                int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, '=', i, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                    String strSubstring2 = str2.substring(i, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    strSubstring = null;
                } else {
                    String strSubstring3 = str2.substring(i, iIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                    strSubstring = str2.substring(iIndexOf$default2 + 1, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strSubstring);
                i = iIndexOf$default + 1;
                str = str2;
            }
            return arrayList;
        }

        public static /* synthetic */ String a(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            if ((i3 & 16) != 0) {
                z2 = false;
            }
            if ((i3 & 32) != 0) {
                z3 = false;
            }
            if ((i3 & 64) != 0) {
                z4 = false;
            }
            if ((i3 & 128) != 0) {
                charset = null;
            }
            return companion.a(str, i, i2, str2, z, z2, z3, z4, charset);
        }

        public final void b(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    out.append(Typography.amp);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first += step;
                }
            }
        }

        @JvmStatic
        public final int a(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
        }

        private final boolean a(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && sdk.pendo.io.f2.b.a(str.charAt(i + 1)) != -1 && sdk.pendo.io.f2.b.a(str.charAt(i3)) != -1;
        }

        public final String a(String str, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
                    dVar.a(str, i, i3);
                    a(dVar, str, i3, i2, z);
                    return dVar.readUtf8();
                }
            }
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public static /* synthetic */ String a(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.a(str, i, i2, z);
        }

        public final void a(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append(list.get(i));
            }
        }

        private final void a(sdk.pendo.io.s2.d dVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            int iCharCount = i;
            sdk.pendo.io.s2.d dVar2 = null;
            while (iCharCount < i2) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z3) {
                        dVar.writeUtf8(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                    } else {
                        if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || z4)) {
                            if (!StringsKt.contains$default((CharSequence) str2, (char) iCodePointAt, false, 2, (Object) null) && (iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i2))))) {
                                dVar.f(iCodePointAt);
                            }
                        }
                        if (dVar2 == null) {
                            dVar2 = new sdk.pendo.io.s2.d();
                        }
                        if (charset == null || Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                            dVar2.f(iCodePointAt);
                        } else {
                            dVar2.a(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!dVar2.exhausted()) {
                            byte b = dVar2.readByte();
                            dVar.writeByte(37);
                            dVar.writeByte((int) v.l[((b & 255) >> 4) & 15]);
                            dVar.writeByte((int) v.l[b & Ascii.SI]);
                        }
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void a(sdk.pendo.io.s2.d dVar, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int iA = sdk.pendo.io.f2.b.a(str.charAt(i + 1));
                    int iA2 = sdk.pendo.io.f2.b.a(str.charAt(i3));
                    if (iA == -1 || iA2 == -1) {
                        dVar.f(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        dVar.writeByte((iA << 4) + iA2);
                        i = i3 + Character.charCount(iCodePointAt);
                    }
                } else if (iCodePointAt == 43 && z) {
                    dVar.writeByte(32);
                    i++;
                } else {
                    dVar.f(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }
    }

    public v(String scheme, String username, String password, String host, int i, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.areEqual(scheme, "https");
    }

    public final String b() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, ColorSerializer.PREFIX, 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String c() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, AbstractJsonLexerKt.COLON, this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.url, CommentBarInputBoxKt.MENTION_SYMBOL, 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String d() {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String strSubstring = this.url.substring(iIndexOf$default, sdk.pendo.io.f2.b.a(str, "?#", iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> e() {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int iA = sdk.pendo.io.f2.b.a(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iA) {
            int i = iIndexOf$default + 1;
            int iA2 = sdk.pendo.io.f2.b.a(this.url, '/', i, iA);
            String strSubstring = this.url.substring(i, iA2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iA2;
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        return (other instanceof v) && Intrinsics.areEqual(((v) other).url, this.url);
    }

    public final String f() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iIndexOf$default, sdk.pendo.io.f2.b.a(str, ColorSerializer.PREFIX, iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, sdk.pendo.io.f2.b.a(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    public final a j() {
        a aVar = new a();
        aVar.l(this.scheme);
        aVar.j(g());
        aVar.i(c());
        aVar.k(this.host);
        aVar.b(this.port != INSTANCE.a(this.scheme) ? this.port : -1);
        aVar.c().clear();
        aVar.c().addAll(e());
        aVar.b(f());
        aVar.h(b());
        return aVar;
    }

    public final List<String> k() {
        return this.pathSegments;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final String m() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.b(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String n() {
        a aVarB = b("/...");
        Intrinsics.checkNotNull(aVarB);
        return aVarB.m("").f("").a().getUrl();
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public final URI p() {
        String string = j().e().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNullExpressionValue(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL q() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final v a(String str) {
        return INSTANCE.b(str);
    }

    @JvmStatic
    public static final v c(String str) {
        return INSTANCE.c(str);
    }

    public final a b(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new a().a(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final v d(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        a aVarB = b(link);
        if (aVarB != null) {
            return aVarB.a();
        }
        return null;
    }
}
