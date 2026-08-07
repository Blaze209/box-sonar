package io.split.android.client.attributes;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesMerger {
    Map<String, Object> merge(Map<String, Object> storedAttributes, Map<String, Object> oneTimeAttributes);
}
