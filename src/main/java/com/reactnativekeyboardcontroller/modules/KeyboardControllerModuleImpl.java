package com.reactnativekeyboardcontroller.modules;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerModuleImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativekeyboardcontroller/modules/KeyboardControllerModuleImpl;", "", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "controller", "Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController;", "mDefaultMode", "", "setInputMode", "", DiagnosisParams.DIAGNOSIS_MODE, "setDefaultMode", "preload", BoxAnalyticsParams.ACTION_DISMISS, "keepFocus", "", "animated", "setFocusTo", "direction", "", "viewPositionInWindow", "viewTag", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "setSoftInputMode", "getConstants", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerModuleImpl {
    public static final String NAME = "KeyboardController";
    private final KeyboardAnimationController controller;
    private final int mDefaultMode;
    private final ReactApplicationContext mReactContext;
    private final UIManager uiManager;

    public final void preload() {
    }

    public KeyboardControllerModuleImpl(ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.uiManager = ReactContextKt.getUiManager(mReactContext);
        this.controller = new KeyboardAnimationController();
        this.mDefaultMode = ReactContextKt.getWindowSoftInputMode(mReactContext);
    }

    public final void setInputMode(int mode) {
        setSoftInputMode(mode);
    }

    public final void setDefaultMode() {
        setSoftInputMode(this.mDefaultMode);
    }

    public final void dismiss(final boolean keepFocus, final boolean animated) {
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        final EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.dismiss$lambda$2(animated, this, editText, currentActivity, keepFocus);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$2$maybeClearFocus(boolean z, View view) {
        if (z) {
            return;
        }
        view.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$2(boolean z, KeyboardControllerModuleImpl keyboardControllerModuleImpl, final View view, Activity activity, final boolean z2) {
        if (!z) {
            keyboardControllerModuleImpl.controller.startControlRequest(view, new Function1() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return KeyboardControllerModuleImpl.dismiss$lambda$2$lambda$1(view, z2, (WindowInsetsAnimationControllerCompat) obj);
                }
            });
            return;
        }
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        dismiss$lambda$2$maybeClearFocus(z2, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismiss$lambda$2$lambda$1(final View view, final boolean z, WindowInsetsAnimationControllerCompat insetsController) {
        Intrinsics.checkNotNullParameter(insetsController, "insetsController");
        insetsController.finish(false);
        view.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.dismiss$lambda$2$maybeClearFocus(z, view);
            }
        });
        return Unit.INSTANCE;
    }

    public final void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (Intrinsics.areEqual(direction, "current")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.setFocusTo$lambda$3();
                }
            });
            return;
        }
        EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            ViewHierarchyNavigator.INSTANCE.setFocusTo(direction, editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusTo$lambda$3() {
        FocusedInputHolder.INSTANCE.focus();
    }

    public final void viewPositionInWindow(final double viewTag, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.viewPositionInWindow$lambda$4(this.f$0, viewTag, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewPositionInWindow$lambda$4(KeyboardControllerModuleImpl keyboardControllerModuleImpl, double d, Promise promise) {
        View viewResolveView = null;
        try {
            UIManager uIManager = keyboardControllerModuleImpl.uiManager;
            if (uIManager != null) {
                viewResolveView = uIManager.resolveView((int) d);
            }
        } catch (IllegalViewOperationException e) {
            Logger.INSTANCE.w(KeyboardControllerModuleImplKt.TAG, "Could not resolve view for tag " + ((int) d), e);
        }
        if (viewResolveView == null) {
            promise.reject("E_VIEW_NOT_FOUND", "Could not find view for tag");
            return;
        }
        int[] screenLocation = ViewKt.getScreenLocation(viewResolveView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("x", FloatKt.getDp(screenLocation[0]));
        writableMapCreateMap.putDouble("y", FloatKt.getDp(screenLocation[1]));
        writableMapCreateMap.putDouble("width", FloatKt.getDp(viewResolveView.getWidth()));
        writableMapCreateMap.putDouble("height", FloatKt.getDp(viewResolveView.getHeight()));
        promise.resolve(writableMapCreateMap);
    }

    private final void setSoftInputMode(final int mode) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.setSoftInputMode$lambda$5(this.f$0, mode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSoftInputMode$lambda$5(KeyboardControllerModuleImpl keyboardControllerModuleImpl, int i) {
        Activity currentActivity;
        Window window;
        if (ReactContextKt.getWindowSoftInputMode(keyboardControllerModuleImpl.mReactContext) == i || (currentActivity = keyboardControllerModuleImpl.mReactContext.getCurrentActivity()) == null || (window = currentActivity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(i);
    }

    public final Map<String, Object> getConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to("keyboardBorderRadius", 0));
    }
}
