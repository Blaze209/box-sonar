package sdk.pendo.io.o2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import external.sdk.pendo.io.org.conscrypt.Conscrypt;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/o2/i;", "Lsdk/pendo/io/o2/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "isSupported", "", "getSelectedProtocol", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "protocols", "", "configureTlsExtensions", "<init>", "()V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class i implements k {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final j.a b = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/o2/i$a", "Lsdk/pendo/io/o2/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "Lsdk/pendo/io/o2/k;", PasskeyWebListener.CREATE_UNIQUE_KEY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a implements j.a {
        a() {
        }

        @Override // sdk.pendo.io.o2.j.a
        public k create(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return new i();
        }

        @Override // sdk.pendo.io.o2.j.a
        public boolean matchesSocket(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return sdk.pendo.io.n2.d.INSTANCE.b() && Conscrypt.isConscrypt(sslSocket);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.o2.i$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lsdk/pendo/io/o2/i$b;", "", "Lsdk/pendo/io/o2/j$a;", "factory", "Lsdk/pendo/io/o2/j$a;", "getFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j.a a() {
            return i.b;
        }
    }

    @Override // sdk.pendo.io.o2.k
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (matchesSocket(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) sdk.pendo.io.n2.h.INSTANCE.a(protocols).toArray(new String[0]));
        }
    }

    @Override // sdk.pendo.io.o2.k
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (matchesSocket(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.o2.k
    public boolean isSupported() {
        return sdk.pendo.io.n2.d.INSTANCE.b();
    }

    @Override // sdk.pendo.io.o2.k
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }
}
