package sdk.pendo.io.o2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/o2/j;", "Lsdk/pendo/io/o2/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "isSupported", "matchesSocket", "", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "protocols", "", "configureTlsExtensions", "getSelectedProtocol", "Lsdk/pendo/io/o2/j$a;", "Lsdk/pendo/io/o2/j$a;", "socketAdapterFactory", "b", "Lsdk/pendo/io/o2/k;", "delegate", "<init>", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a socketAdapterFactory;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private k delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lsdk/pendo/io/o2/j$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "Lsdk/pendo/io/o2/k;", PasskeyWebListener.CREATE_UNIQUE_KEY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        k create(SSLSocket sslSocket);

        boolean matchesSocket(SSLSocket sslSocket);
    }

    public j(a socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    private final synchronized k a(SSLSocket sslSocket) {
        if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sslSocket)) {
            this.delegate = this.socketAdapterFactory.create(sslSocket);
        }
        return this.delegate;
    }

    @Override // sdk.pendo.io.o2.k
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        k kVarA = a(sslSocket);
        if (kVarA != null) {
            kVarA.configureTlsExtensions(sslSocket, hostname, protocols);
        }
    }

    @Override // sdk.pendo.io.o2.k
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        k kVarA = a(sslSocket);
        if (kVarA != null) {
            return kVarA.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.o2.k
    public boolean isSupported() {
        return true;
    }

    @Override // sdk.pendo.io.o2.k
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sslSocket);
    }
}
