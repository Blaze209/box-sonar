package com.reactnativekeyboardcontroller;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardControllerModule;", "Lcom/reactnativekeyboardcontroller/NativeKeyboardControllerSpec;", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "module", "Lcom/reactnativekeyboardcontroller/modules/KeyboardControllerModuleImpl;", "getName", "", "getTypedExportedConstants", "", "", "setInputMode", "", DiagnosisParams.DIAGNOSIS_MODE, "", "setDefaultMode", "preload", BoxAnalyticsParams.ACTION_DISMISS, "keepFocus", "", "animated", "setFocusTo", "direction", "viewPositionInWindow", "viewTag", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "addListener", "eventName", "removeListeners", "count", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerModule extends NativeKeyboardControllerSpec {
    private final KeyboardControllerModuleImpl module;

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void addListener(String eventName) {
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardControllerModule(ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new KeyboardControllerModuleImpl(mReactContext);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "KeyboardController";
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    protected Map<String, Object> getTypedExportedConstants() {
        return this.module.getConstants();
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setInputMode(double mode) {
        this.module.setInputMode((int) mode);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setDefaultMode() {
        this.module.setDefaultMode();
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void preload() {
        this.module.preload();
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void dismiss(boolean keepFocus, boolean animated) {
        this.module.dismiss(keepFocus, animated);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.module.setFocusTo(direction);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void viewPositionInWindow(double viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.module.viewPositionInWindow(viewTag, promise);
    }
}
