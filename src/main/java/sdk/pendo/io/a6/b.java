package sdk.pendo.io.a6;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.webkit.UserAgentMetadata;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.z;
import sdk.pendo.io.utilities.AndroidUtils;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/a6/b;", "Lsdk/pendo/io/a6/a;", "Lorg/json/JSONObject;", "json", "", "b", "", "c", "[Lsdk/pendo/io/a6/a;", "mDeviceInfoCollectors", "d", "()Lorg/json/JSONObject;", "deviceInfo", "", "e", "()Ljava/lang/String;", "deviceType", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends sdk.pendo.io.a6.a {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<b> e = LazyKt.lazy(a.a);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.a6.a[] mDeviceInfoCollectors = {new sdk.pendo.io.b6.a(), new sdk.pendo.io.b6.b()};

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/a6/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/a6/b;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<b> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return c.a.a();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.a6.b$b, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lsdk/pendo/io/a6/b$b;", "", "Lsdk/pendo/io/a6/b;", "instance$delegate", "Lkotlin/Lazy;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/a6/b;", "instance", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return (b) b.e.getValue();
        }
    }

    private final JSONObject d() {
        Resources resources;
        Configuration configuration;
        Resources resources2;
        Configuration configuration2;
        LocaleList locales;
        JSONObject jSONObject = new JSONObject();
        String strG = AndroidUtils.g();
        if (strG == null) {
            d.a(new sdk.pendo.io.y5.b("Cannot get device id!"), "No Device Id");
            strG = "ERROR";
        }
        z.a(jSONObject, "deviceId", strG);
        z.a(jSONObject, "idType", "UUID");
        Context contextA = a();
        String languageTags = (contextA == null || (resources2 = contextA.getResources()) == null || (configuration2 = resources2.getConfiguration()) == null || (locales = configuration2.getLocales()) == null) ? null : locales.toLanguageTags();
        if (languageTags != null) {
            z.a(jSONObject, "locale", languageTags);
        }
        Context contextA2 = a();
        z.a(jSONObject, "type", ((contextA2 == null || (resources = contextA2.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.smallestScreenWidthDp) >= 600 ? UserAgentMetadata.FORM_FACTOR_TABLET : "Smartphone");
        for (sdk.pendo.io.a6.a aVar : this.mDeviceInfoCollectors) {
            aVar.a(jSONObject);
        }
        return jSONObject;
    }

    @Override // sdk.pendo.io.a6.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        z.a(json, "device_info", d());
    }

    public final String e() {
        Resources resources;
        Configuration configuration;
        Context contextA = a();
        return ((contextA == null || (resources = contextA.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.smallestScreenWidthDp) >= 600 ? UserAgentMetadata.FORM_FACTOR_TABLET : "Smartphone";
    }
}
