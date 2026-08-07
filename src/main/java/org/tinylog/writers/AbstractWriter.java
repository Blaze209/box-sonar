package org.tinylog.writers;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractWriter implements Writer {
    private final Map<String, String> properties;

    public AbstractWriter(Map<String, String> map) {
        this.properties = map;
    }

    public String getStringValue(String str) {
        String str2 = this.properties.get(str);
        if (str2 == null) {
            return null;
        }
        return str2.trim();
    }

    public boolean getBooleanValue(String str) {
        return Boolean.parseBoolean(getStringValue(str));
    }
}
