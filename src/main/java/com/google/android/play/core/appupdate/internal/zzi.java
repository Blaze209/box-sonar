package com.google.android.play.core.appupdate.internal;

import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.play:app-update@@2.1.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzi {
    private static final Set zza = new HashSet(Arrays.asList("app_update", "review"));
    private static final Set zzb = new HashSet(Arrays.asList("native", "unity"));
    private static final Map zzc = new HashMap();
    private static final zzm zzd = new zzm("PlayCoreVersion");

    public static synchronized Map zza(String str) {
        Map map;
        map = zzc;
        if (!map.containsKey("app_update")) {
            HashMap map2 = new HashMap();
            map2.put(ResourceAttributes.TelemetrySdkLanguageValues.JAVA, 11004);
            map.put("app_update", map2);
        }
        return (Map) map.get("app_update");
    }
}
