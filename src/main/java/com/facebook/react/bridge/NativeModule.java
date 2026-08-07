package com.facebook.react.bridge;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes13.dex */
public interface NativeModule {
    @Deprecated
    default boolean canOverrideExistingModule() {
        return false;
    }

    @Nonnull
    String getName();

    void initialize();

    void invalidate();

    @Deprecated(forRemoval = true, since = "Use invalidate method instead")
    default void onCatalystInstanceDestroy() {
    }
}
