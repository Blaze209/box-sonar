package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 \b2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0005\bB\u0017\b\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0004\u001a\u00020\u0003J\u001b\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\nH\u0096\u0002J\u0006\u0010\u0005\u001a\u00020\fJ\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/e2/u;", "", "Lkotlin/Pair;", "", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", FirebaseAnalytics.Param.INDEX, "b", "", "", "iterator", "Lsdk/pendo/io/e2/u$a;", "", "other", "", "equals", "hashCode", "toString", "", "", "[Ljava/lang/String;", "namesAndValues", "size", "()I", "<init>", "([Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class u implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String[] namesAndValues;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u001f\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002J\u0019\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\u0004\u001a\u00020\bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\n\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/e2/u$a;", "", "", "line", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;)Lsdk/pendo/io/e2/u$a;", "name", "value", "Lsdk/pendo/io/e2/u;", "headers", "b", "(Ljava/lang/String;Ljava/lang/String;)Lsdk/pendo/io/e2/u$a;", "c", "", "Ljava/util/List;", "()Ljava/util/List;", "namesAndValues", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final List<String> namesAndValues = new ArrayList(20);

        public final a a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = u.INSTANCE;
            companion.a(name);
            companion.a(value, name);
            b(name, value);
            return this;
        }

        public final a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(StringsKt.trim((CharSequence) value).toString());
            return this;
        }

        public final a c(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = u.INSTANCE;
            companion.a(name);
            companion.a(value, name);
            b(name);
            b(name, value);
            return this;
        }

        public final a a(u headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                b(headers.a(i), headers.b(i));
            }
            return this;
        }

        public final List<String> b() {
            return this.namesAndValues;
        }

        public final a a(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) line, AbstractJsonLexerKt.COLON, 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = line.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                b(strSubstring, strSubstring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                b("", line);
                return this;
            }
            String strSubstring3 = line.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
            b("", strSubstring3);
            return this;
        }

        public final a b(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (StringsKt.equals(name, this.namesAndValues.get(i), true)) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final u a() {
            return new u((String[]) this.namesAndValues.toArray(new String[0]), null);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.u$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u0006\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J#\u0010\r\u001a\u00020\n2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/e2/u$b;", "", "", "", "namesAndValues", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "value", "Lsdk/pendo/io/e2/u;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String name) {
            if (name.length() <= 0) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(sdk.pendo.io.f2.b.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), name).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String value, String name) {
            int length = value.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = value.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    throw new IllegalArgumentException((sdk.pendo.io.f2.b.a("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), name) + (sdk.pendo.io.f2.b.c(name) ? "" : ": " + value)).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(String[] namesAndValues, String name) {
            int length = namesAndValues.length - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
            if (progressionLastElement > length) {
                return null;
            }
            while (!StringsKt.equals(name, namesAndValues[length], true)) {
                if (length == progressionLastElement) {
                    return null;
                }
                length -= 2;
            }
            return namesAndValues[length + 1];
        }

        @JvmStatic
        public final u a(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                strArr[i2] = StringsKt.trim((CharSequence) str).toString();
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str2 = strArr[i];
                    String str3 = strArr[i + 1];
                    a(str2);
                    a(str3, str2);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new u(strArr, null);
        }
    }

    private u(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.a(this.namesAndValues, name);
    }

    public final Map<String, List<String>> b() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i = 0; i < size; i++) {
            String strA = a(i);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strA.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(b(i));
        }
        return treeMap;
    }

    public boolean equals(Object other) {
        return (other instanceof u) && Arrays.equals(this.namesAndValues, ((u) other).namesAndValues);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.to(a(i), b(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strA = a(i);
            String strB = b(i);
            sb.append(strA);
            sb.append(": ");
            if (sdk.pendo.io.f2.b.c(strA)) {
                strB = "██";
            }
            sb.append(strB);
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public /* synthetic */ u(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public final String a(int index) {
        return this.namesAndValues[index * 2];
    }

    public final String b(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public final a a() {
        a aVar = new a();
        CollectionsKt.addAll(aVar.b(), this.namesAndValues);
        return aVar;
    }

    public final List<String> b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(name, a(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList == null) {
            return CollectionsKt.emptyList();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    @JvmStatic
    public static final u a(String... strArr) {
        return INSTANCE.a(strArr);
    }
}
