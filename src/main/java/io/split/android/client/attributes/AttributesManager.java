package io.split.android.client.attributes;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesManager {
    boolean clearAttributes();

    Map<String, Object> getAllAttributes();

    Object getAttribute(String attributeName);

    boolean removeAttribute(String attributeName);

    boolean setAttribute(String attributeName, Object value);

    boolean setAttributes(Map<String, Object> attributes);
}
