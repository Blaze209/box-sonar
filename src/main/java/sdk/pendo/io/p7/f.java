package sdk.pendo.io.p7;

import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.gson.Gson;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.h7.r;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "userAgent", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class f {
    private static final Lazy a = LazyKt.lazy(a.a);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            Gson gson = new Gson();
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put("manufacturer", Build.MANUFACTURER);
            mapCreateMapBuilder.put("model", Build.MODEL);
            mapCreateMapBuilder.put("os", "Android");
            mapCreateMapBuilder.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
            mapCreateMapBuilder.put("brand", Build.BRAND);
            mapCreateMapBuilder.put("board", Build.BOARD);
            r rVar = r.a;
            mapCreateMapBuilder.put("sdkVersion", rVar.a());
            mapCreateMapBuilder.put("type", sdk.pendo.io.a6.b.INSTANCE.a().e());
            mapCreateMapBuilder.put("framework", rVar.b().toString());
            if (rVar.c() != null) {
                mapCreateMapBuilder.put(Pendo.PendoOptions.FRAMEWORK_TYPE, String.valueOf(rVar.c()));
            }
            if (rVar.d() != null) {
                mapCreateMapBuilder.put(Pendo.PendoOptions.FRAMEWORK_VERSION, rVar.d());
            }
            if (rVar.f() != null) {
                mapCreateMapBuilder.put(Pendo.PendoOptions.PLUGIN_VERSION, rVar.f());
            }
            return gson.a(MapsKt.build(mapCreateMapBuilder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b() {
        Object value = a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }
}
