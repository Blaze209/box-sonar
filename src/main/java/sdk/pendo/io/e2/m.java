package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 &2\u00020\u0001:\u0001\nBQ\b\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001a\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001c\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010!\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0017\u0010#\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001d¨\u0006'"}, d2 = {"Lsdk/pendo/io/e2/m;", "", "other", "", "equals", "", "hashCode", "", "toString", "forObsoleteRfc2965", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Z)Ljava/lang/String;", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "b", "f", "value", "", "c", "J", "expiresAt", "()J", "d", "domain", "path", "Z", "secure", "()Z", "g", "httpOnly", CmcdData.STREAMING_FORMAT_HLS, "persistent", "i", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "j", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class m {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern k = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern m = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String value;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long expiresAt;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String domain;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String path;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean secure;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final boolean httpOnly;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final boolean persistent;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final boolean hostOnly;

    /* JADX INFO: renamed from: sdk.pendo.io.e2.m$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\u0006\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007J)\u0010\u0006\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0014J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007R\u001c\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001c\u0010\u001d\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001c\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lsdk/pendo/io/e2/m$a;", "", "", "urlHost", "domain", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "s", "", "pos", BoxIterator.FIELD_LIMIT, "", "input", "invert", "b", "Lsdk/pendo/io/e2/v;", "url", "setCookie", "Lsdk/pendo/io/e2/m;", "currentTimeMillis", "(JLsdk/pendo/io/e2/v;Ljava/lang/String;)Lsdk/pendo/io/e2/m;", "Lsdk/pendo/io/e2/u;", "headers", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(String input, int pos, int limit, boolean invert) {
            while (pos < limit) {
                char cCharAt = input.charAt(pos);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!invert)) {
                    return pos;
                }
                pos++;
            }
            return limit;
        }

        private final long b(String s) {
            try {
                long j = Long.parseLong(s);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                if (new Regex("-?\\d+").matches(s)) {
                    return StringsKt.startsWith$default(s, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, false, 2, (Object) null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        private final boolean a(String urlHost, String domain) {
            if (Intrinsics.areEqual(urlHost, domain)) {
                return true;
            }
            return StringsKt.endsWith$default(urlHost, domain, false, 2, (Object) null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !sdk.pendo.io.f2.b.a(urlHost);
        }

        @JvmStatic
        public final m a(v url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return a(System.currentTimeMillis(), url, setCookie);
        }

        public final m a(long currentTimeMillis, v url, String setCookie) {
            long j;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int iA = sdk.pendo.io.f2.b.a(setCookie, ';', 0, 0, 6, null);
            int iA2 = sdk.pendo.io.f2.b.a(setCookie, '=', 0, iA, 2, null);
            m mVar = null;
            if (iA2 == iA) {
                return null;
            }
            String strC = sdk.pendo.io.f2.b.c(setCookie, 0, iA2, 1, null);
            if (strC.length() == 0 || sdk.pendo.io.f2.b.b(strC) != -1) {
                return null;
            }
            String strC2 = sdk.pendo.io.f2.b.c(setCookie, iA2 + 1, iA);
            if (sdk.pendo.io.f2.b.b(strC2) != -1) {
                return null;
            }
            int i = iA + 1;
            int length = setCookie.length();
            String strA = null;
            String strSubstring = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = true;
            long jB = -1;
            long jA = DatesKt.MAX_DATE;
            while (i < length) {
                int iA3 = sdk.pendo.io.f2.b.a(setCookie, ';', i, length);
                int iA4 = sdk.pendo.io.f2.b.a(setCookie, '=', i, iA3);
                String strC3 = sdk.pendo.io.f2.b.c(setCookie, i, iA4);
                String strC4 = iA4 < iA3 ? sdk.pendo.io.f2.b.c(setCookie, iA4 + 1, iA3) : "";
                m mVar2 = mVar;
                if (StringsKt.equals(strC3, "expires", true)) {
                    try {
                        jA = a(strC4, 0, strC4.length());
                        z = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (StringsKt.equals(strC3, "max-age", true)) {
                    jB = b(strC4);
                    z = true;
                } else if (StringsKt.equals(strC3, "domain", true)) {
                    strA = a(strC4);
                    z4 = false;
                } else if (StringsKt.equals(strC3, "path", true)) {
                    strSubstring = strC4;
                } else if (StringsKt.equals(strC3, "secure", true)) {
                    z2 = true;
                } else if (StringsKt.equals(strC3, "httponly", true)) {
                    z3 = true;
                }
                i = iA3 + 1;
                mVar = mVar2;
            }
            m mVar3 = mVar;
            if (jB == Long.MIN_VALUE) {
                j = Long.MIN_VALUE;
            } else if (jB != -1) {
                long j2 = currentTimeMillis + (jB <= 9223372036854775L ? jB * ((long) 1000) : Long.MAX_VALUE);
                j = (j2 < currentTimeMillis || j2 > DatesKt.MAX_DATE) ? 253402300799999L : j2;
            } else {
                j = jA;
            }
            String host = url.getHost();
            if (strA == null) {
                strA = host;
            } else if (!a(host, strA)) {
                return mVar3;
            }
            if (host.length() != strA.length() && PublicSuffixDatabase.INSTANCE.a().a(strA) == null) {
                return mVar3;
            }
            if (strSubstring == null || !StringsKt.startsWith$default(strSubstring, "/", false, 2, (Object) mVar3)) {
                String strD = url.d();
                int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) strD, '/', 0, false, 6, (Object) null);
                if (iLastIndexOf$default != 0) {
                    strSubstring = strD.substring(0, iLastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                } else {
                    strSubstring = "/";
                }
            }
            return new m(strC, strC2, j, strA, strSubstring, z2, z3, z, z4, null);
        }

        @JvmStatic
        public final List<m> a(v url, u headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> listB = headers.b("Set-Cookie");
            int size = listB.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                m mVarA = a(url, listB.get(i));
                if (mVarA != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(mVarA);
                }
            }
            if (arrayList == null) {
                return CollectionsKt.emptyList();
            }
            List<m> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        private final String a(String s) {
            if (StringsKt.endsWith$default(s, ".", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strB = sdk.pendo.io.f2.a.b(StringsKt.removePrefix(s, (CharSequence) "."));
            if (strB != null) {
                return strB;
            }
            throw new IllegalArgumentException();
        }

        private final long a(String s, int pos, int limit) {
            int iA = a(s, pos, limit, false);
            Matcher matcher = m.n.matcher(s);
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int iIndexOf$default = -1;
            int i4 = -1;
            int i5 = -1;
            while (iA < limit) {
                int iA2 = a(s, iA + 1, limit, true);
                matcher.region(iA, iA2);
                if (i2 == -1 && matcher.usePattern(m.n).matches()) {
                    String strGroup = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
                    i2 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "matcher.group(2)");
                    i4 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(strGroup3, "matcher.group(3)");
                    i5 = Integer.parseInt(strGroup3);
                } else if (i3 == -1 && matcher.usePattern(m.m).matches()) {
                    String strGroup4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup4, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup4);
                } else if (iIndexOf$default == -1 && matcher.usePattern(m.l).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "matcher.group(1)");
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = m.l.pattern();
                    Intrinsics.checkNotNullExpressionValue(strPattern, "MONTH_PATTERN.pattern()");
                    iIndexOf$default = StringsKt.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i == -1 && matcher.usePattern(m.k).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "matcher.group(1)");
                    i = Integer.parseInt(strGroup6);
                }
                iA = a(s, iA2 + 1, limit, false);
            }
            if (70 <= i && i < 100) {
                i += 1900;
            }
            if (i >= 0 && i < 70) {
                i += 2000;
            }
            if (i < 1601) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (iIndexOf$default == -1) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (1 > i3 || i3 >= 32) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i2 < 0 || i2 >= 24) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i4 < 0 || i4 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i5 < 0 || i5 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(sdk.pendo.io.f2.b.f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i);
            gregorianCalendar.set(2, iIndexOf$default - 1);
            gregorianCalendar.set(5, i3);
            gregorianCalendar.set(11, i2);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private m(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return Intrinsics.areEqual(mVar.name, this.name) && Intrinsics.areEqual(mVar.value, this.value) && mVar.expiresAt == this.expiresAt && Intrinsics.areEqual(mVar.domain, this.domain) && Intrinsics.areEqual(mVar.path, this.path) && mVar.secure == this.secure && mVar.httpOnly == this.httpOnly && mVar.persistent == this.persistent && mVar.hostOnly == this.hostOnly;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((((((((((((((this.name.hashCode() + 527) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly);
    }

    public String toString() {
        return a(false);
    }

    public /* synthetic */ m(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    public final String a(boolean forObsoleteRfc2965) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(sdk.pendo.io.k2.c.a(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (forObsoleteRfc2965) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=").append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }
}
