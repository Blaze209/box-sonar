package org.yaml.snakeyaml.util;

/* JADX INFO: loaded from: classes5.dex */
public class PlatformFeatureDetector {
    private Boolean isRunningOnAndroid = null;

    public boolean isRunningOnAndroid() {
        if (this.isRunningOnAndroid == null) {
            String property = System.getProperty("java.runtime.name");
            this.isRunningOnAndroid = Boolean.valueOf(property != null && property.startsWith("Android Runtime"));
        }
        return this.isRunningOnAndroid.booleanValue();
    }
}
