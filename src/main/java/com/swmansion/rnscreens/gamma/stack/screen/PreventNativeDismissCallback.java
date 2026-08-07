package com.swmansion.rnscreens.gamma.stack.screen;

import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreventNativeDismissCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "screen", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "canBeEnabled", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;Z)V", "value", "getCanBeEnabled$react_native_screens_release", "()Z", "setCanBeEnabled$react_native_screens_release", "(Z)V", "shouldBeEnabled", "getShouldBeEnabled", "handleOnBackPressed", "", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "preventNativeDismissChanged", "newValue", "determineEnabledStatus", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreventNativeDismissCallback extends OnBackPressedCallback implements LifecycleEventObserver, PreventNativeDismissChangeObserver {
    private boolean canBeEnabled;
    private final StackScreen screen;

    /* JADX INFO: compiled from: PreventNativeDismissCallback.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreventNativeDismissCallback(LifecycleOwner lifecycleOwner, StackScreen screen, boolean z) {
        super(false);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
        this.canBeEnabled = z;
        lifecycleOwner.getLifecycleRegistry().addObserver(this);
    }

    /* JADX INFO: renamed from: getCanBeEnabled$react_native_screens_release, reason: from getter */
    public final boolean getCanBeEnabled() {
        return this.canBeEnabled;
    }

    public final void setCanBeEnabled$react_native_screens_release(boolean z) {
        this.canBeEnabled = z;
        determineEnabledStatus();
    }

    private final boolean getShouldBeEnabled() {
        return this.canBeEnabled && this.screen.isPreventNativeDismissEnabled$react_native_screens_release();
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        Log.i("RNScreens", "PreventNativeDismissCallback called for screen " + this.screen.getScreenKey());
        this.screen.onNativeDismissPrevented$react_native_screens_release();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            this.screen.setPreventNativeDismissChangeObserver$react_native_screens_release(this);
            return;
        }
        if (i == 2) {
            determineEnabledStatus();
            return;
        }
        if (i == 3) {
            setEnabled(false);
        } else {
            if (i != 4) {
                return;
            }
            source.getLifecycleRegistry().removeObserver(this);
            this.screen.setPreventNativeDismissChangeObserver$react_native_screens_release(null);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.stack.screen.PreventNativeDismissChangeObserver
    public void preventNativeDismissChanged(boolean newValue) {
        determineEnabledStatus();
    }

    private final void determineEnabledStatus() {
        setEnabled(getShouldBeEnabled());
    }
}
