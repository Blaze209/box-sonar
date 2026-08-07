package io.split.android.client;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessedEventProperties {
    private final boolean isValid;
    private final Map<String, Object> properties;
    private final int sizeInBytes;

    public static ProcessedEventProperties InvalidProperties() {
        return new ProcessedEventProperties(false, null, 0);
    }

    public ProcessedEventProperties(boolean isValid, Map<String, Object> properties, int sizeInBytes) {
        this.isValid = isValid;
        this.properties = properties;
        this.sizeInBytes = sizeInBytes;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public int getSizeInBytes() {
        return this.sizeInBytes;
    }
}
