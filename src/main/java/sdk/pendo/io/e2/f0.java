package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\r\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/e2/f0;", "", "", "c", "other", "equals", "", "hashCode", "", "toString", "Lsdk/pendo/io/e2/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/a;", IDToken.ADDRESS, "()Lokhttp3/Address;", "Ljava/net/Proxy;", "b", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "Ljava/net/InetSocketAddress;", "d", "()Ljava/net/InetSocketAddress;", "socketAddress", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class f0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a address;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Proxy proxy;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final InetSocketAddress socketAddress;

    public f0(a address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final a getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    public final boolean c() {
        return this.address.getSslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final InetSocketAddress getSocketAddress() {
        return this.socketAddress;
    }

    public boolean equals(Object other) {
        if (!(other instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) other;
        return Intrinsics.areEqual(f0Var.address, this.address) && Intrinsics.areEqual(f0Var.proxy, this.proxy) && Intrinsics.areEqual(f0Var.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return ((((this.address.hashCode() + 527) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    public String toString() {
        return "Route{" + this.socketAddress + AbstractJsonLexerKt.END_OBJ;
    }
}
