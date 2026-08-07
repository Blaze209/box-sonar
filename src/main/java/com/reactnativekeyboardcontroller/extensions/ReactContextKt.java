package com.reactnativekeyboardcontroller.extensions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"archType", "", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "Lcom/facebook/react/bridge/ReactContext;", "getUiManager", "(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/bridge/UIManager;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcher", "(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/uimanager/events/EventDispatcher;", "rootView", "Landroid/view/View;", "getRootView", "(Lcom/facebook/react/bridge/ReactContext;)Landroid/view/View;", "content", "Landroid/view/ViewGroup;", "getContent", "(Lcom/facebook/react/bridge/ReactContext;)Landroid/view/ViewGroup;", "windowSoftInputMode", "getWindowSoftInputMode", "(Lcom/facebook/react/bridge/ReactContext;)I", "react-native-keyboard-controller_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReactContextKt {
    private static final int archType = 2;

    public static final UIManager getUiManager(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        return UIManagerHelper.getUIManager(reactContext, archType);
    }

    public static final EventDispatcher getEventDispatcher(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        return UIManagerHelper.getEventDispatcher(reactContext, archType);
    }

    public static final View getRootView(ReactContext reactContext) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getRootView();
    }

    public static final ViewGroup getContent(ReactContext reactContext) {
        Window window;
        View decorView;
        View rootView;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootView = decorView.getRootView()) == null) {
            return null;
        }
        return (ViewGroup) rootView.findViewById(R.id.action_bar_root);
    }

    public static final int getWindowSoftInputMode(ReactContext reactContext) {
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return 0;
        }
        return attributes.softInputMode;
    }
}
