package sdk.pendo.io.j2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/j2/b;", "", "Ljavax/net/ssl/SSLSocket;", "socket", "", "b", "sslSocket", "Lsdk/pendo/io/e2/l;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/IOException;", "e", "", "Ljava/util/List;", "connectionSpecs", "", "I", "nextModeIndex", "c", "Z", "isFallbackPossible", "d", "isFallback", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<l> connectionSpecs;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int nextModeIndex;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean isFallbackPossible;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean isFallback;

    public b(List<l> connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean b(SSLSocket socket) {
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            if (this.connectionSpecs.get(i).a(socket)) {
                return true;
            }
        }
        return false;
    }

    public final l a(SSLSocket sslSocket) throws UnknownServiceException {
        l lVar;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                lVar = null;
                break;
            }
            lVar = this.connectionSpecs.get(i);
            i++;
            if (lVar.a(sslSocket)) {
                this.nextModeIndex = i;
                break;
            }
        }
        if (lVar != null) {
            this.isFallbackPossible = b(sslSocket);
            lVar.a(sslSocket, this.isFallback);
            return lVar;
        }
        StringBuilder sbAppend = new StringBuilder("Unable to find acceptable protocols. isFallback=").append(this.isFallback).append(", modes=").append(this.connectionSpecs).append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        throw new UnknownServiceException(sbAppend.append(string).toString());
    }

    public final boolean a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.isFallback = true;
        if (!this.isFallbackPossible || (e instanceof ProtocolException) || (e instanceof InterruptedIOException)) {
            return false;
        }
        return (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true;
    }
}
