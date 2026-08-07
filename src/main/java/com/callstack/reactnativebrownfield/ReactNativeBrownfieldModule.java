package com.callstack.reactnativebrownfield;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeBrownfieldModule.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0017J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeBrownfieldModule;", "Lcom/callstack/reactnativebrownfield/NativeReactNativeBrownfieldModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "popToNative", "", "animated", "", "setPopGestureRecognizerEnabled", "enabled", "setHardwareBackButtonEnabled", "onBackPressed", "getName", "", "Companion", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeBrownfieldModule extends NativeReactNativeBrownfieldModuleSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean shouldPopToNative;

    /* JADX INFO: compiled from: ReactNativeBrownfieldModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeBrownfieldModule$Companion;", "", "<init>", "()V", "shouldPopToNative", "", "getShouldPopToNative", "()Z", "setShouldPopToNative", "(Z)V", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getShouldPopToNative() {
            return ReactNativeBrownfieldModule.shouldPopToNative;
        }

        public final void setShouldPopToNative(boolean z) {
            ReactNativeBrownfieldModule.shouldPopToNative = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeBrownfieldModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.callstack.reactnativebrownfield.NativeReactNativeBrownfieldModuleSpec
    @ReactMethod
    public void popToNative(boolean animated) {
        shouldPopToNative = true;
        onBackPressed();
    }

    @Override // com.callstack.reactnativebrownfield.NativeReactNativeBrownfieldModuleSpec
    @ReactMethod
    public void setPopGestureRecognizerEnabled(boolean enabled) {
        shouldPopToNative = enabled;
    }

    @Override // com.callstack.reactnativebrownfield.NativeReactNativeBrownfieldModuleSpec
    @ReactMethod
    public void setHardwareBackButtonEnabled(boolean enabled) {
        shouldPopToNative = enabled;
    }

    private final void onBackPressed() {
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfieldModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReactNativeBrownfieldModule.onBackPressed$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$0(ReactNativeBrownfieldModule reactNativeBrownfieldModule) {
        Activity currentActivity = reactNativeBrownfieldModule.getReactApplicationContext().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.onBackPressed();
        }
    }

    @Override // com.callstack.reactnativebrownfield.NativeReactNativeBrownfieldModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeReactNativeBrownfieldModuleSpec.NAME;
    }
}
