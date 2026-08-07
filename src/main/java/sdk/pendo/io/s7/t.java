package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lsdk/pendo/io/s7/t;", "", "", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "applyBase64", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class t {
    public static final t a = new t();

    private t() {
    }

    private final String a(String value) {
        String strA;
        String string = value != null ? StringsKt.trim((CharSequence) value).toString() : null;
        if (string == null || StringsKt.isBlank(string) || (strA = y0.a(string)) == null || StringsKt.isBlank(strA)) {
            return null;
        }
        return strA;
    }

    public final String a(String value, boolean applyBase64) {
        try {
            if (applyBase64) {
                value = a(value);
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value == null) {
                return null;
            }
            String strA = sdk.pendo.io.v7.a.a.a(value);
            if (StringsKt.isBlank(strA)) {
                return null;
            }
            return y0.a(strA, 8);
        } catch (Exception e) {
            PendoLogger.d("IdentifierHasher", "Failed to hash identifier: " + e.getMessage());
            return null;
        }
    }

    public static /* synthetic */ String a(t tVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return tVar.a(str, z);
    }
}
