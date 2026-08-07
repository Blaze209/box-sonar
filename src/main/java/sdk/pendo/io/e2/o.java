package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lsdk/pendo/io/e2/o;", "", "", "username", "password", "Ljava/nio/charset/Charset;", "charset", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class o {
    public static final o a = new o();

    private o() {
    }

    @JvmStatic
    public static final String a(String username, String password, Charset charset) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return "Basic " + sdk.pendo.io.s2.g.INSTANCE.a(username + AbstractJsonLexerKt.COLON + password, charset).a();
    }
}
