package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/s7/p0;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class p0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SecureRandom b = new SecureRandom();
    private static final String c = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* JADX INFO: renamed from: sdk.pendo.io.s7.p0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lsdk/pendo/io/s7/p0$a;", "", "", "sizeOfRandomString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "ALLOWED_CHARACTERS", "Ljava/lang/String;", "Ljava/security/SecureRandom;", "random", "Ljava/security/SecureRandom;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int sizeOfRandomString) {
            if (sizeOfRandomString < 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder(sizeOfRandomString);
            for (int i = 0; i < sizeOfRandomString; i++) {
                sb.append(p0.c.charAt(p0.b.nextInt(p0.c.length())));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
