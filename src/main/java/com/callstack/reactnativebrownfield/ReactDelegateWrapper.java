package com.callstack.reactnativebrownfield;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactHost;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactDelegateWrapper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0013\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactDelegateWrapper;", "Lcom/facebook/react/ReactDelegate;", "activity", "Landroidx/activity/ComponentActivity;", "resolvedReactHost", "Lcom/facebook/react/ReactHost;", "moduleName", "", "launchOptions", "Landroid/os/Bundle;", "<init>", "(Landroidx/activity/ComponentActivity;Lcom/facebook/react/ReactHost;Ljava/lang/String;Landroid/os/Bundle;)V", "hardwareBackHandler", "Lkotlin/Function0;", "", "backBtnHandler", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "setHardwareBackHandler", "backHandler", "onReactHostResume", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactDelegateWrapper extends ReactDelegate {
    private final ComponentActivity activity;
    private final DefaultHardwareBackBtnHandler backBtnHandler;
    private Function0<Unit> hardwareBackHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactDelegateWrapper(ComponentActivity componentActivity, ReactHost reactHost, String moduleName, Bundle bundle) {
        super(componentActivity, reactHost, moduleName, bundle);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNull(componentActivity);
        this.activity = componentActivity;
        this.backBtnHandler = new DefaultHardwareBackBtnHandler() { // from class: com.callstack.reactnativebrownfield.ReactDelegateWrapper$$ExternalSyntheticLambda0
            @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
            public final void invokeDefaultOnBackPressed() {
                ReactDelegateWrapper.backBtnHandler$lambda$0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backBtnHandler$lambda$0(ReactDelegateWrapper reactDelegateWrapper) {
        Function0<Unit> function0 = reactDelegateWrapper.hardwareBackHandler;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hardwareBackHandler");
            function0 = null;
        }
        function0.invoke();
    }

    public final void setHardwareBackHandler(Function0<Unit> backHandler) {
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        this.hardwareBackHandler = backHandler;
    }

    public final void onReactHostResume() {
        ReactHost reactHost = super.getReactHost();
        if (reactHost != null) {
            reactHost.onHostResume(this.activity, this.backBtnHandler);
        }
    }
}
