package io.split.android.client.attributes;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesMergerImpl implements AttributesMerger {
    @Override // io.split.android.client.attributes.AttributesMerger
    public Map<String, Object> merge(final Map<String, Object> storedAttributes, final Map<String, Object> oneTimeAttributes) {
        HashMap map = new HashMap();
        if (storedAttributes != null) {
            map.putAll(storedAttributes);
        }
        if (oneTimeAttributes != null) {
            map.putAll(oneTimeAttributes);
        }
        return map;
    }
}
