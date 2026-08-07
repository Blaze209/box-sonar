package sdk.pendo.io.p7;

import android.util.Base64;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null), 1);
        if (str2 == null) {
            throw new IllegalArgumentException("Invalid JWT format");
        }
        byte[] bArrDecode = Base64.decode(b(str2), 10);
        Intrinsics.checkNotNull(bArrDecode);
        return new String(bArrDecode, Charsets.UTF_8);
    }

    private static final String b(String str) {
        int length = 4 - (str.length() % 4);
        if (length >= 4) {
            length = 0;
        }
        return str + StringsKt.repeat(SimpleComparison.EQUAL_TO_OPERATION, length);
    }

    public static final byte[] a(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gZIPOutputStream, th);
                throw th2;
            }
        }
    }

    public static final byte[] b(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(deflaterOutputStream, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(deflaterOutputStream, th);
                throw th2;
            }
        }
    }
}
