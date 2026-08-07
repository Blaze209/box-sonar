package com.yubico.yubikit.core.application;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationSession;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ApplicationSession<T extends ApplicationSession<T>> implements Closeable {
    public abstract Version getVersion();

    public boolean supports(Feature<T> feature) {
        return feature.isSupportedBy(getVersion());
    }

    protected void require(Feature<T> feature) {
        if (!supports(feature)) {
            throw new UnsupportedOperationException(feature.getRequiredMessage());
        }
    }
}
