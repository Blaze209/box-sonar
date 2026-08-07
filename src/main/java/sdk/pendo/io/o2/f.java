package sdk.pendo.io.o2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUser;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000  2\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001c\u0010\u001d\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015¨\u0006!"}, d2 = {"Lsdk/pendo/io/o2/f;", "Lsdk/pendo/io/o2/k;", "", "isSupported", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "matchesSocket", "", BoxUser.FIELD_HOSTNAME, "", "Lsdk/pendo/io/e2/a0;", "protocols", "", "configureTlsExtensions", "getSelectedProtocol", "Ljava/lang/Class;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Class;", "sslSocketClass", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "setUseSessionTickets", "kotlin.jvm.PlatformType", "c", "setHostname", "d", "getAlpnSelectedProtocol", "e", "setAlpnProtocols", "<init>", "(Ljava/lang/Class;)V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
public class f implements k {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final j.a g;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Class<? super SSLSocket> sslSocketClass;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Method setUseSessionTickets;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Method setHostname;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Method getAlpnSelectedProtocol;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Method setAlpnProtocols;

    /* JADX INFO: renamed from: sdk.pendo.io.o2.f$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/o2/f$a;", "", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "Lsdk/pendo/io/o2/f;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Lsdk/pendo/io/o2/j$a;", "playProviderFactory", "Lsdk/pendo/io/o2/j$a;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: sdk.pendo.io.o2.f$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/o2/f$a$a", "Lsdk/pendo/io/o2/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "Lsdk/pendo/io/o2/k;", PasskeyWebListener.CREATE_UNIQUE_KEY, "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class C0443a implements j.a {
            final /* synthetic */ String a;

            C0443a(String str) {
                this.a = str;
            }

            @Override // sdk.pendo.io.o2.j.a
            public k create(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                return f.INSTANCE.a((Class<? super SSLSocket>) sslSocket.getClass());
            }

            @Override // sdk.pendo.io.o2.j.a
            public boolean matchesSocket(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "sslSocket.javaClass.name");
                return StringsKt.startsWith$default(name, this.a + '.', false, 2, (Object) null);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f a(Class<? super SSLSocket> actualSSLSocketClass) {
            Class<? super SSLSocket> superclass = actualSSLSocketClass;
            while (superclass != null && !Intrinsics.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + actualSSLSocketClass);
                }
            }
            Intrinsics.checkNotNull(superclass);
            return new f(superclass);
        }

        public final j.a a(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new C0443a(packageName);
        }

        public final j.a a() {
            return f.g;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        g = companion.a("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> sslSocketClass) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.sslSocketClass = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // sdk.pendo.io.o2.k
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (matchesSocket(sslSocket)) {
            try {
                this.setUseSessionTickets.invoke(sslSocket, Boolean.TRUE);
                if (hostname != null) {
                    this.setHostname.invoke(sslSocket, hostname);
                }
                this.setAlpnProtocols.invoke(sslSocket, sdk.pendo.io.n2.h.INSTANCE.b(protocols));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // sdk.pendo.io.o2.k
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!matchesSocket(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, Charsets.UTF_8);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof NullPointerException) || !Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                throw new AssertionError(e2);
            }
        }
        return null;
    }

    @Override // sdk.pendo.io.o2.k
    public boolean isSupported() {
        return sdk.pendo.io.n2.b.INSTANCE.b();
    }

    @Override // sdk.pendo.io.o2.k
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
    }
}
