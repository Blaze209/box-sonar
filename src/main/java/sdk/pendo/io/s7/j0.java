package sdk.pendo.io.s7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b2\u00103J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000eJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0006\u0010\u0011J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u000b\u0010\u0011J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR$\u0010#\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u00100\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038G@@X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0013\u00101\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b$\u0010\u0011¨\u00064"}, d2 = {"Lsdk/pendo/io/s7/j0;", "", "Lsdk/pendo/io/w5/a;", "", "url", "", "c", "newEndpoint", "", "isRedirect", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "d", "dataCenter", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "f", "()Landroid/net/Uri;", "customUrl", "(Ljava/lang/String;)Landroid/net/Uri;", "e", "(Ljava/lang/String;)Z", "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "Lkotlin/Lazy;", "()Landroid/content/Context;", "context", "customHostUrl", "Z", "redirectionEnable", "Landroid/net/Uri;", "getRedirectionHost$pendoIO_release", "setRedirectionHost$pendoIO_release", "(Landroid/net/Uri;)V", "redirectionHost", "g", "getHostRedirectionEnable$pendoIO_release", "()Z", "setHostRedirectionEnable$pendoIO_release", "(Z)V", "hostRedirectionEnable", "<set-?>", CmcdData.STREAMING_FORMAT_HLS, "getDatacenter", "()Ljava/lang/String;", "setDatacenter$pendoIO_release", "(Ljava/lang/String;)V", "datacenter", "productionUri", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j0 implements sdk.pendo.io.w5.a {
    public static final j0 a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final String TAG;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final Lazy context;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static String customHostUrl;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static boolean redirectionEnable;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static Uri redirectionHost;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static boolean hostRedirectionEnable;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private static String datacenter;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class a extends Lambda implements Function0<Context> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(Context.class), this.b, this.c);
        }
    }

    static {
        j0 j0Var = new j0();
        a = j0Var;
        TAG = "PendoEndpointUtil";
        context = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new a(j0Var, null, null));
        datacenter = "";
    }

    private j0() {
    }

    @JvmStatic
    public static final void d() {
        hostRedirectionEnable = true;
    }

    private final Context e() {
        return (Context) context.getValue();
    }

    public Uri a() {
        return redirectionEnable ? c() : b();
    }

    public final Uri b() {
        Uri uriF = f();
        return uriF == null ? g() : uriF;
    }

    public final Uri c() {
        Uri uri = redirectionHost;
        return uri == null ? g() : uri;
    }

    public Uri f() {
        String strA = customHostUrl;
        if (strA == null) {
            strA = u0.a(e());
        }
        return b(strA);
    }

    public final Uri g() {
        String strA = a(datacenter);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return Uri.parse(strA);
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.w5.a.C0510a.a(this);
    }

    @JvmStatic
    public static final void c(String url) {
        customHostUrl = url;
    }

    @JvmStatic
    public static final boolean d(String str) {
        return a(str, false, 2, null);
    }

    public final String a(String dataCenter) {
        if (dataCenter != null) {
            int iHashCode = dataCenter.hashCode();
            if (iHashCode != 3124) {
                if (iHashCode != 3248) {
                    if (iHashCode != 3398) {
                        if (iHashCode != 3742) {
                            if (iHashCode != 102542) {
                                if (iHashCode != 116051) {
                                    if (iHashCode == 3211916 && dataCenter.equals("hsbc")) {
                                        return "https://data.hsbc.pendo.io";
                                    }
                                } else if (dataCenter.equals("us1")) {
                                    return "https://us1.data.pendo.io";
                                }
                            } else if (dataCenter.equals("gov")) {
                                return "https://data.gov.pendo.io";
                            }
                        } else if (dataCenter.equals("us")) {
                            return "https://data.pendo.io";
                        }
                    } else if (dataCenter.equals("jp")) {
                        return "https://data.jpn.pendo.io";
                    }
                } else if (dataCenter.equals("eu")) {
                    return "https://data.eu.pendo.io";
                }
            } else if (dataCenter.equals("au")) {
                return "https://data.au.pendo.io";
            }
        }
        PendoLogger.w(TAG + ", GetEndpoint got an invalid datacenter " + dataCenter + ", please contact Pendo support.", new Object[0]);
        return null;
    }

    public final Uri b(String customUrl) {
        if (v0.a(customUrl)) {
            return null;
        }
        return Uri.parse(customUrl);
    }

    public final boolean e(String newEndpoint) {
        Intrinsics.checkNotNullParameter(newEndpoint, "newEndpoint");
        return a(newEndpoint) != null;
    }

    public final boolean f(String newEndpoint) {
        Intrinsics.checkNotNullParameter(newEndpoint, "newEndpoint");
        return hostRedirectionEnable && !StringsKt.isBlank(newEndpoint);
    }

    @JvmStatic
    public static final boolean a(String newEndpoint, boolean isRedirect) {
        if (newEndpoint != null && a.e(newEndpoint)) {
            redirectionEnable = isRedirect;
            datacenter = newEndpoint;
            return true;
        }
        datacenter = "";
        redirectionEnable = false;
        PendoLogger.w(TAG + ", validateAndSetDatacenterEndpoint got an invalid endpoint " + newEndpoint + ", please contact Pendo support.", new Object[0]);
        return false;
    }

    @JvmStatic
    public static final boolean b(String newEndpoint, boolean isRedirect) {
        if (newEndpoint == null || !a.f(newEndpoint)) {
            redirectionEnable = false;
            redirectionHost = null;
            return false;
        }
        StringsKt.replace(newEndpoint, "http://", AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX, true);
        if (!StringsKt.startsWith(newEndpoint, "https", true)) {
            newEndpoint = AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + newEndpoint;
        }
        redirectionHost = Uri.parse(newEndpoint);
        redirectionEnable = isRedirect;
        return true;
    }

    public static /* synthetic */ boolean a(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(str, z);
    }
}
