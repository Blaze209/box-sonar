package com.swmansion.rnscreens.gamma.stack.header;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigAttachListener;
import com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigChangeListener;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "stackScreen", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "canNavigateBack", "", "<init>", "(Landroid/content/Context;Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;Z)V", "getStackScreen$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "headerCoordinator", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinator;", "onHeaderConfigAttach", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigAttachListener;", "isHeaderUpdatePending", "onHeaderConfigChange", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigChangeListener;", "currentConfig", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigProviding;", "stackScreenWrapper", "Landroid/widget/FrameLayout;", "getStackScreenWrapper$react_native_screens_release", "()Landroid/widget/FrameLayout;", "setStackScreenWrapper$react_native_screens_release", "(Landroid/widget/FrameLayout;)V", "handleHeaderConfigAttach", "", "config", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHeaderCoordinatorLayout extends CoordinatorLayout {
    private StackHeaderConfigProviding currentConfig;
    private final StackHeaderCoordinator headerCoordinator;
    private boolean isHeaderUpdatePending;
    private final OnHeaderConfigAttachListener onHeaderConfigAttach;
    private final OnHeaderConfigChangeListener onHeaderConfigChange;
    private final StackScreen stackScreen;
    private FrameLayout stackScreenWrapper;

    /* JADX INFO: renamed from: getStackScreen$react_native_screens_release, reason: from getter */
    public final StackScreen getStackScreen() {
        return this.stackScreen;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackHeaderCoordinatorLayout(Context context, StackScreen stackScreen, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.stackScreen = stackScreen;
        this.headerCoordinator = new StackHeaderCoordinator(context, z, new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StackHeaderCoordinatorLayout.headerCoordinator$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function0() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StackHeaderCoordinatorLayout.headerCoordinator$lambda$1(this.f$0);
            }
        });
        OnHeaderConfigAttachListener onHeaderConfigAttachListener = new OnHeaderConfigAttachListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda3
            @Override // com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigAttachListener
            public final void onHeaderConfigAttach(StackHeaderConfigProviding stackHeaderConfigProviding) {
                this.f$0.handleHeaderConfigAttach(stackHeaderConfigProviding);
            }
        };
        this.onHeaderConfigAttach = onHeaderConfigAttachListener;
        this.onHeaderConfigChange = new OnHeaderConfigChangeListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda4
            @Override // com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigChangeListener
            public final void onHeaderConfigChange(StackHeaderConfigProviding stackHeaderConfigProviding) {
                StackHeaderCoordinatorLayout.onHeaderConfigChange$lambda$4(this.f$0, stackHeaderConfigProviding);
            }
        };
        setTransitionGroup(true);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(stackScreen);
        this.stackScreenWrapper = frameLayout;
        addView(frameLayout, new CoordinatorLayout.LayoutParams(-1, -1));
        stackScreen.setOnHeaderConfigAttachListener$react_native_screens_release(new WeakReference<>(onHeaderConfigAttachListener));
        handleHeaderConfigAttach(stackScreen.getHeaderConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit headerCoordinator$lambda$0(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout, int i) {
        StackScreen.updateStateIfNeeded$default(stackHeaderCoordinatorLayout.stackScreen, null, Integer.valueOf(i), null, null, 13, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit headerCoordinator$lambda$1(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Context context = stackHeaderCoordinatorLayout.stackScreen.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        Activity currentActivity = reactContext != null ? reactContext.getCurrentActivity() : null;
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = currentActivity instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) currentActivity : null;
        if (onBackPressedDispatcherOwner != null && (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHeaderConfigChange$lambda$4(final StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout, StackHeaderConfigProviding it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (stackHeaderCoordinatorLayout.isHeaderUpdatePending) {
            return;
        }
        stackHeaderCoordinatorLayout.isHeaderUpdatePending = true;
        stackHeaderCoordinatorLayout.post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StackHeaderCoordinatorLayout.onHeaderConfigChange$lambda$4$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHeaderConfigChange$lambda$4$lambda$3(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout) {
        stackHeaderCoordinatorLayout.isHeaderUpdatePending = false;
        stackHeaderCoordinatorLayout.headerCoordinator.applyHeaderConfig$react_native_screens_release(stackHeaderCoordinatorLayout, stackHeaderCoordinatorLayout.currentConfig);
    }

    /* JADX INFO: renamed from: getStackScreenWrapper$react_native_screens_release, reason: from getter */
    public final FrameLayout getStackScreenWrapper() {
        return this.stackScreenWrapper;
    }

    public final void setStackScreenWrapper$react_native_screens_release(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.stackScreenWrapper = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHeaderConfigAttach(StackHeaderConfigProviding config) {
        StackHeaderConfigProviding stackHeaderConfigProviding = this.currentConfig;
        if (stackHeaderConfigProviding != null) {
            stackHeaderConfigProviding.setOnConfigChangeListener(null);
        }
        this.currentConfig = config;
        if (config != null) {
            config.setOnConfigChangeListener(this.onHeaderConfigChange);
        }
        this.headerCoordinator.applyHeaderConfig$react_native_screens_release(this, config);
    }
}
