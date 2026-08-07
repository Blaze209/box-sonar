package com.callstack.reactnativebrownfield;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes13.dex */
public abstract class NativeReactNativeBrownfieldModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ReactNativeBrownfield";

    @ReactMethod
    public abstract void popToNative(boolean z);

    @ReactMethod
    public abstract void setHardwareBackButtonEnabled(boolean z);

    @ReactMethod
    public abstract void setPopGestureRecognizerEnabled(boolean z);

    public NativeReactNativeBrownfieldModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
