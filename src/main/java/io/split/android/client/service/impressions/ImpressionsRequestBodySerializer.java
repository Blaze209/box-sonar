package io.split.android.client.service.impressions;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.dtos.TestImpressions;
import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsRequestBodySerializer implements HttpRequestBodySerializer<List<KeyImpression>> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(List<KeyImpression> data) {
        return Json.toJson(groupImpressions(data));
    }

    private List<TestImpressions> groupImpressions(List<KeyImpression> impressions) {
        HashMap map = new HashMap();
        for (KeyImpression keyImpression : impressions) {
            List arrayList = (List) map.get(keyImpression.feature);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(keyImpression);
            map.put(keyImpression.feature, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            TestImpressions testImpressions = new TestImpressions();
            testImpressions.testName = (String) entry.getKey();
            testImpressions.keyImpressions = (List) entry.getValue();
            arrayList2.add(testImpressions);
        }
        return arrayList2;
    }
}
