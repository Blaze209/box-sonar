package sdk.pendo.io.n2;

import android.security.NetworkSecurityPolicy;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.o2.i;
import sdk.pendo.io.o2.j;
import sdk.pendo.io.o2.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u0010\u0010\n\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/n2/a;", "Lsdk/pendo/io/n2/h;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "protocols", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/q2/c;", "Lsdk/pendo/io/o2/k;", "d", "Ljava/util/List;", "socketAdapters", "<init>", "()V", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a extends h {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean f = h.INSTANCE.e();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<k> socketAdapters;

    /* JADX INFO: renamed from: sdk.pendo.io.n2.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/n2/a$a;", "", "Lsdk/pendo/io/n2/h;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f;
        }
    }

    public a() {
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new k[]{sdk.pendo.io.o2.a.INSTANCE.a(), new j(sdk.pendo.io.o2.f.INSTANCE.a()), new j(i.INSTANCE.a()), new j(sdk.pendo.io.o2.g.INSTANCE.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((k) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // sdk.pendo.io.n2.h
    public sdk.pendo.io.q2.c a(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        sdk.pendo.io.o2.b bVarA = sdk.pendo.io.o2.b.INSTANCE.a(trustManager);
        return bVarA != null ? bVarA : super.a(trustManager);
    }

    @Override // sdk.pendo.io.n2.h
    public String b(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).matchesSocket(sslSocket));
        k kVar = (k) next;
        if (kVar != null) {
            return kVar.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override // sdk.pendo.io.n2.h
    public void a(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).matchesSocket(sslSocket));
        k kVar = (k) next;
        if (kVar != null) {
            kVar.configureTlsExtensions(sslSocket, hostname, protocols);
        }
    }

    @Override // sdk.pendo.io.n2.h
    public boolean b(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
