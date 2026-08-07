package sdk.pendo.io.e2;

import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u0000 '2\u00020\u0001:\u0002\u0005\nBs\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0011\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0019\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u001d\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\bR\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lsdk/pendo/io/e2/d;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "g", "()Z", "noCache", "b", CmcdData.STREAMING_FORMAT_HLS, "noStore", "", "c", "I", "()I", "maxAgeSeconds", "d", "sMaxAgeSeconds", "e", "isPrivate", "f", "isPublic", "mustRevalidate", "maxStaleSeconds", "i", "minFreshSeconds", "j", "onlyIfCached", "k", "noTransform", CmcdData.STREAM_TYPE_LIVE, "immutable", CmcdData.OBJECT_TYPE_MANIFEST, "Ljava/lang/String;", "headerValue", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "n", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d {

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final d o = new a().b().a();
    public static final d p = new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean noCache;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean noStore;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int maxAgeSeconds;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int sMaxAgeSeconds;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean isPrivate;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean isPublic;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final boolean mustRevalidate;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int maxStaleSeconds;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final int minFreshSeconds;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean onlyIfCached;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final boolean noTransform;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final boolean immutable;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private String headerValue;

    /* JADX INFO: renamed from: sdk.pendo.io.e2.d$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/e2/d$b;", "", "", "characters", "", "startIndex", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/u;", "headers", "Lsdk/pendo/io/e2/d;", "FORCE_CACHE", "Lsdk/pendo/io/e2/d;", "FORCE_NETWORK", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004a  */
        /* JADX WARN: Code duplicated, block: B:17:0x006a  */
        /* JADX WARN: Code duplicated, block: B:28:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:32:0x00db  */
        /* JADX WARN: Code duplicated, block: B:34:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:36:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:37:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:39:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:41:0x0105  */
        /* JADX WARN: Code duplicated, block: B:43:0x010d  */
        /* JADX WARN: Code duplicated, block: B:44:0x0113  */
        /* JADX WARN: Code duplicated, block: B:46:0x011b  */
        /* JADX WARN: Code duplicated, block: B:47:0x0121  */
        /* JADX WARN: Code duplicated, block: B:49:0x0129  */
        /* JADX WARN: Code duplicated, block: B:50:0x012f  */
        /* JADX WARN: Code duplicated, block: B:52:0x0137  */
        /* JADX WARN: Code duplicated, block: B:53:0x013e  */
        /* JADX WARN: Code duplicated, block: B:55:0x0146  */
        /* JADX WARN: Code duplicated, block: B:56:0x014e  */
        /* JADX WARN: Code duplicated, block: B:58:0x0156  */
        /* JADX WARN: Code duplicated, block: B:59:0x015c  */
        /* JADX WARN: Code duplicated, block: B:61:0x0165  */
        /* JADX WARN: Code duplicated, block: B:62:0x016d  */
        /* JADX WARN: Code duplicated, block: B:64:0x0175  */
        /* JADX WARN: Code duplicated, block: B:65:0x017d  */
        /* JADX WARN: Code duplicated, block: B:67:0x0185  */
        @JvmStatic
        public final d a(u headers) {
            int iA;
            int iA2;
            boolean z;
            String string;
            int i;
            String str;
            String string2;
            u headers2 = headers;
            Intrinsics.checkNotNullParameter(headers2, "headers");
            int size = headers2.size();
            boolean z2 = true;
            boolean z3 = true;
            int i2 = 0;
            String str2 = null;
            boolean z4 = false;
            boolean z5 = false;
            int iB = -1;
            int iB2 = -1;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int iB3 = -1;
            int iB4 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (i2 < size) {
                String strA = headers2.a(i2);
                String strB = headers2.b(i2);
                if (StringsKt.equals(strA, "Cache-Control", z2)) {
                    if (str2 == null) {
                        str2 = strB;
                    }
                    iA = 0;
                    while (iA < strB.length()) {
                        iA2 = a(strB, "=,;", iA);
                        String strSubstring = strB.substring(iA, iA2);
                        z = z2;
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = StringsKt.trim((CharSequence) strSubstring).toString();
                        if (iA2 != strB.length()) {
                            i = size;
                            if (strB.charAt(iA2) == ',' && strB.charAt(iA2) != ';') {
                                int iA3 = sdk.pendo.io.f2.b.a(strB, iA2 + 1);
                                if (iA3 >= strB.length() || strB.charAt(iA3) != '\"') {
                                    str = strB;
                                    iA = a(str, ",;", iA3);
                                    String strSubstring2 = str.substring(iA3, iA);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = StringsKt.trim((CharSequence) strSubstring2).toString();
                                } else {
                                    int i3 = iA3 + 1;
                                    String str3 = strB;
                                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str3, '\"', i3, false, 4, (Object) null);
                                    str = str3;
                                    String strSubstring3 = str.substring(i3, iIndexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iA = iIndexOf$default + 1;
                                    string2 = strSubstring3;
                                }
                            }
                            if (StringsKt.equals("no-cache", string, z)) {
                                z2 = z;
                                z4 = z2;
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_STORE, string, z)) {
                                z2 = z;
                                z5 = z2;
                            } else {
                                if (StringsKt.equals("max-age", string, z)) {
                                    iB = sdk.pendo.io.f2.b.b(string2, -1);
                                } else if (StringsKt.equals("s-maxage", string, z)) {
                                    iB2 = sdk.pendo.io.f2.b.b(string2, -1);
                                } else if (StringsKt.equals(HeaderConstants.PRIVATE, string, z)) {
                                    z2 = z;
                                    z6 = z2;
                                } else if (StringsKt.equals(HeaderConstants.PUBLIC, string, z)) {
                                    z2 = z;
                                    z7 = z2;
                                } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, string, z)) {
                                    z2 = z;
                                    z8 = z2;
                                } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MAX_STALE, string, z)) {
                                    iB3 = sdk.pendo.io.f2.b.b(string2, Integer.MAX_VALUE);
                                } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MIN_FRESH, string, z)) {
                                    iB4 = sdk.pendo.io.f2.b.b(string2, -1);
                                } else if (StringsKt.equals("only-if-cached", string, z)) {
                                    z2 = z;
                                    z9 = z2;
                                } else if (StringsKt.equals("no-transform", string, z)) {
                                    z2 = z;
                                    z10 = z2;
                                } else if (StringsKt.equals("immutable", string, z)) {
                                    z2 = z;
                                    z11 = z2;
                                }
                                z2 = z;
                            }
                            strB = str;
                            size = i;
                        } else {
                            i = size;
                        }
                        str = strB;
                        iA = iA2 + 1;
                        string2 = null;
                        if (StringsKt.equals("no-cache", string, z)) {
                            z2 = z;
                            z4 = z2;
                        } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_STORE, string, z)) {
                            z2 = z;
                            z5 = z2;
                        } else {
                            if (StringsKt.equals("max-age", string, z)) {
                                iB = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals("s-maxage", string, z)) {
                                iB2 = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals(HeaderConstants.PRIVATE, string, z)) {
                                z2 = z;
                                z6 = z2;
                            } else if (StringsKt.equals(HeaderConstants.PUBLIC, string, z)) {
                                z2 = z;
                                z7 = z2;
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, string, z)) {
                                z2 = z;
                                z8 = z2;
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MAX_STALE, string, z)) {
                                iB3 = sdk.pendo.io.f2.b.b(string2, Integer.MAX_VALUE);
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MIN_FRESH, string, z)) {
                                iB4 = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals("only-if-cached", string, z)) {
                                z2 = z;
                                z9 = z2;
                            } else if (StringsKt.equals("no-transform", string, z)) {
                                z2 = z;
                                z10 = z2;
                            } else if (StringsKt.equals("immutable", string, z)) {
                                z2 = z;
                                z11 = z2;
                            }
                            z2 = z;
                        }
                        strB = str;
                        size = i;
                    }
                    i2++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                } else {
                    if (StringsKt.equals(strA, "Pragma", z2)) {
                    }
                    i2++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                }
                z3 = false;
                iA = 0;
                while (iA < strB.length()) {
                    iA2 = a(strB, "=,;", iA);
                    String strSubstring4 = strB.substring(iA, iA2);
                    z = z2;
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = StringsKt.trim((CharSequence) strSubstring4).toString();
                    if (iA2 != strB.length()) {
                        i = size;
                        if (strB.charAt(iA2) == ',') {
                        }
                        if (StringsKt.equals("no-cache", string, z)) {
                            z2 = z;
                            z4 = z2;
                        } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_STORE, string, z)) {
                            z2 = z;
                            z5 = z2;
                        } else {
                            if (StringsKt.equals("max-age", string, z)) {
                                iB = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals("s-maxage", string, z)) {
                                iB2 = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals(HeaderConstants.PRIVATE, string, z)) {
                                z2 = z;
                                z6 = z2;
                            } else if (StringsKt.equals(HeaderConstants.PUBLIC, string, z)) {
                                z2 = z;
                                z7 = z2;
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, string, z)) {
                                z2 = z;
                                z8 = z2;
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MAX_STALE, string, z)) {
                                iB3 = sdk.pendo.io.f2.b.b(string2, Integer.MAX_VALUE);
                            } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MIN_FRESH, string, z)) {
                                iB4 = sdk.pendo.io.f2.b.b(string2, -1);
                            } else if (StringsKt.equals("only-if-cached", string, z)) {
                                z2 = z;
                                z9 = z2;
                            } else if (StringsKt.equals("no-transform", string, z)) {
                                z2 = z;
                                z10 = z2;
                            } else if (StringsKt.equals("immutable", string, z)) {
                                z2 = z;
                                z11 = z2;
                            }
                            z2 = z;
                        }
                        strB = str;
                        size = i;
                    } else {
                        i = size;
                    }
                    str = strB;
                    iA = iA2 + 1;
                    string2 = null;
                    if (StringsKt.equals("no-cache", string, z)) {
                        z2 = z;
                        z4 = z2;
                    } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_STORE, string, z)) {
                        z2 = z;
                        z5 = z2;
                    } else {
                        if (StringsKt.equals("max-age", string, z)) {
                            iB = sdk.pendo.io.f2.b.b(string2, -1);
                        } else if (StringsKt.equals("s-maxage", string, z)) {
                            iB2 = sdk.pendo.io.f2.b.b(string2, -1);
                        } else if (StringsKt.equals(HeaderConstants.PRIVATE, string, z)) {
                            z2 = z;
                            z6 = z2;
                        } else if (StringsKt.equals(HeaderConstants.PUBLIC, string, z)) {
                            z2 = z;
                            z7 = z2;
                        } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, string, z)) {
                            z2 = z;
                            z8 = z2;
                        } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MAX_STALE, string, z)) {
                            iB3 = sdk.pendo.io.f2.b.b(string2, Integer.MAX_VALUE);
                        } else if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MIN_FRESH, string, z)) {
                            iB4 = sdk.pendo.io.f2.b.b(string2, -1);
                        } else if (StringsKt.equals("only-if-cached", string, z)) {
                            z2 = z;
                            z9 = z2;
                        } else if (StringsKt.equals("no-transform", string, z)) {
                            z2 = z;
                            z10 = z2;
                        } else if (StringsKt.equals("immutable", string, z)) {
                            z2 = z;
                            z11 = z2;
                        }
                        z2 = z;
                    }
                    strB = str;
                    size = i;
                }
                i2++;
                headers2 = headers;
                z2 = z2;
                size = size;
            }
            return new d(z4, z5, iB, iB2, z6, z7, z8, iB3, iB4, z9, z10, z11, !z3 ? null : str2, null);
        }
    }

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0000J\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\u0004\u001a\u00020\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\f¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/e2/d$a;", "", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "maxStale", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "c", "Lsdk/pendo/io/e2/d;", "", "Z", "noCache", "noStore", "I", "maxAgeSeconds", "d", "maxStaleSeconds", "e", "minFreshSeconds", "f", "onlyIfCached", "g", "noTransform", CmcdData.STREAMING_FORMAT_HLS, "immutable", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private boolean noCache;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean noStore;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private int maxAgeSeconds = -1;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private int maxStaleSeconds = -1;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private int minFreshSeconds = -1;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private boolean onlyIfCached;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private boolean noTransform;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private boolean immutable;

        private final int a(long j) {
            if (j > SieveCacheKt.NodeLinkMask) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final d a() {
            return new d(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final a b() {
            this.noCache = true;
            return this;
        }

        public final a c() {
            this.onlyIfCached = true;
            return this;
        }

        public final a a(int maxStale, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxStale < 0) {
                throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
            }
            this.maxStaleSeconds = a(timeUnit.toSeconds(maxStale));
            return this;
        }
    }

    public /* synthetic */ d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }
}
