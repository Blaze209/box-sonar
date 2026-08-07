package sdk.pendo.io.v7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.s7.y0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/v7/a;", "", "", "byteArray", "Ljava/security/MessageDigest;", "digest", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONObject;", "jsonObject", "text", "b", "kotlin.jvm.PlatformType", "Ljava/security/MessageDigest;", "digestSHA2", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final MessageDigest digestSHA2 = MessageDigest.getInstance("SHA-256");

    private a() {
    }

    public final synchronized String a(byte[] byteArray) {
        String strA;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        strA = y0.a(b.a.a(byteArray));
        Intrinsics.checkNotNullExpressionValue(strA, "bytesToHex(...)");
        return strA;
    }

    public final synchronized String b(byte[] byteArray) {
        MessageDigest digestSHA3;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        digestSHA3 = digestSHA2;
        Intrinsics.checkNotNullExpressionValue(digestSHA3, "digestSHA2");
        return a(byteArray, digestSHA3);
    }

    public final synchronized String a(JSONObject jsonObject) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        bytes = string.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return a(bytes);
    }

    public final synchronized String b(String text) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(text, "text");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        bytes = text.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return a(bytes);
    }

    public final synchronized String a(String text) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(text, "text");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        bytes = text.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return b(bytes);
    }

    private final String a(byte[] byteArray, MessageDigest digest) {
        digest.reset();
        digest.update(byteArray);
        String strA = y0.a(digest.digest());
        Intrinsics.checkNotNullExpressionValue(strA, "bytesToHex(...)");
        return strA;
    }
}
