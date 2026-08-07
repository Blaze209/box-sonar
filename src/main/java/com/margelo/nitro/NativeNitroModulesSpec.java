package com.margelo.nitro;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public abstract class NativeNitroModulesSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NitroModules";

    @ReactMethod(isBlockingSynchronousMethod = true)
    @Nullable
    public abstract String install();

    public NativeNitroModulesSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "NitroModules";
    }
}
