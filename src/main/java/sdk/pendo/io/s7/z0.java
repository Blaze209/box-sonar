package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0014\u0010\u0002\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006\u001a\u0014\u0010\u0005\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u001a\u0014\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¨\u0006\u000b"}, d2 = {"", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "value", "b", "", "names", "", "values", "c", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class z0 {
    public static final void a(Collection<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String strA = a(it.next());
            if (strA != null) {
                PendoLogger.w("ValidationUtils", strA, null);
            }
        }
    }

    public static final void b(Collection<? extends Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        Iterator<? extends Object> it = values.iterator();
        while (it.hasNext()) {
            String strA = a(it.next());
            if (strA != null) {
                PendoLogger.w("ValidationUtils", strA, null);
            }
        }
    }

    public static final void c(Collection<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String strB = b(it.next());
            if (strB != null) {
                PendoLogger.w("ValidationUtils", strB, null);
            }
        }
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() > 32) {
            sb.append("Must be under 32 characters. ");
        }
        if (StringsKt.startsWith$default(str, "__", false, 2, (Object) null) || StringsKt.endsWith$default(str, "__", false, 2, (Object) null)) {
            sb.append("Must not start or end with double underscores. ");
        }
        Character chFirstOrNull = StringsKt.firstOrNull(str);
        if (chFirstOrNull != null && Character.isDigit(chFirstOrNull.charValue())) {
            sb.append("Must not start with a number. ");
        }
        if (!new Regex("^[A-Za-z0-9_]+$").matches(str)) {
            sb.append("Use only letters, numbers and underscores.");
        }
        if (sb.length() > 0) {
            return "Invalid Track Event Property Name [" + str + "]. " + ((Object) sb);
        }
        return null;
    }

    private static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        Character chFirstOrNull = StringsKt.firstOrNull(str);
        if (chFirstOrNull != null && Character.isDigit(chFirstOrNull.charValue())) {
            sb.append("Must not start with a number. ");
        }
        if (!new Regex("^[A-Za-z0-9_]+$").matches(str)) {
            sb.append("Use only letters, numbers and underscores.");
        }
        if (sb.length() > 0) {
            return "Invalid Metadata Field Name [" + str + "]. " + ((Object) sb);
        }
        return null;
    }

    private static final String a(Object obj) {
        if ((obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        return "Warning, Track Event Property Value [" + obj + "], Property values must be categorized as string or boolean to use Group By in Data Explorer and funnels.";
    }
}
