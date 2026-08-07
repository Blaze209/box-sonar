package io.split.android.client.network;

import com.google.gson.reflect.TypeToken;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class CertificatePinningConfigurationProvider {
    public static CertificatePinningConfiguration getCertificatePinningConfiguration(String pinsJson) {
        try {
            Map map = (Map) Json.fromJson(pinsJson, new TypeToken<Map<String, Set<CertificatePin>>>() { // from class: io.split.android.client.network.CertificatePinningConfigurationProvider.1
            }.getType());
            if (map == null || map.isEmpty()) {
                return null;
            }
            CertificatePinningConfiguration.Builder builder = CertificatePinningConfiguration.builder();
            for (Map.Entry entry : map.entrySet()) {
                builder.addPins((String) entry.getKey(), (Set) entry.getValue());
            }
            return builder.build();
        } catch (Exception e) {
            Logger.e("Error parsing certificate pinning configuration for background sync worker", e.getLocalizedMessage());
            return null;
        }
    }
}
