package com.yubico.yubikit.core.application;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationSession;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Feature<T extends ApplicationSession<T>> {
    protected final String featureName;

    public abstract boolean isSupportedBy(Version version);

    protected Feature(String str) {
        this.featureName = str;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    protected String getRequiredMessage() {
        return String.format("%s is not supported by this YubiKey", this.featureName);
    }

    public static class Versioned<T extends ApplicationSession<T>> extends Feature<T> {
        private final Version requiredVersion;

        public Versioned(String str, int i, int i2, int i3) {
            super(str);
            this.requiredVersion = new Version(i, i2, i3);
        }

        @Override // com.yubico.yubikit.core.application.Feature
        protected String getRequiredMessage() {
            return String.format("%s requires YubiKey %s or later", this.featureName, this.requiredVersion);
        }

        @Override // com.yubico.yubikit.core.application.Feature
        public boolean isSupportedBy(Version version) {
            return version.major == 0 || version.compareTo(this.requiredVersion) >= 0;
        }
    }
}
