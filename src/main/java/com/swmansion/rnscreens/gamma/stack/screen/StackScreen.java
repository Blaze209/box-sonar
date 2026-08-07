package com.swmansion.rnscreens.gamma.stack.screen;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigAttachListener;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig;
import com.swmansion.rnscreens.gamma.stack.host.StackHost;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenNativeDismissPreventedEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StackScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J;\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u00107\u001a\u0004\u0018\u0001052\n\b\u0002\u00108\u001a\u0004\u0018\u000105¢\u0006\u0002\u00109J\u0015\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020:H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u0002032\u0006\u0010C\u001a\u00020:H\u0000¢\u0006\u0002\bFJ\r\u0010S\u001a\u000203H\u0000¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0000¢\u0006\u0002\bYJ\r\u0010Z\u001a\u000203H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J0\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u0002052\u0006\u0010a\u001a\u0002052\u0006\u0010b\u001a\u0002052\u0006\u0010c\u001a\u000205H\u0014J\n\u0010d\u001a\u0004\u0018\u00010eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0007\u001a\u0004\u0018\u00010*8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b.\u0010/\"\u0004\b0\u00101*\u0004\b,\u0010-R\"\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\u0010\u001a\u0004\u0018\u00010:@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\"\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001a\u0010G\u001a\u00020HX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006g"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "Landroid/view/ViewGroup;", "Lcom/swmansion/rnscreens/gamma/common/FragmentProviding;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "<set-?>", "", "isPreventNativeDismissEnabled", "isPreventNativeDismissEnabled$react_native_screens_release", "()Z", "setPreventNativeDismissEnabled$react_native_screens_release", "(Z)V", "isPreventNativeDismissEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "value", "isNativelyDismissed", "isNativelyDismissed$react_native_screens_release", "setNativelyDismissed$react_native_screens_release", "stackHost", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "getStackHost$react_native_screens_release", "()Ljava/lang/ref/WeakReference;", "setStackHost$react_native_screens_release", "(Ljava/lang/ref/WeakReference;)V", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "activityMode", "getActivityMode", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "setActivityMode", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;)V", "activityMode$delegate", "", "screenKey", "getScreenKey", "()Ljava/lang/String;", "setScreenKey", "(Ljava/lang/String;)V", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "updateStateIfNeeded", "", "x", "", "y", "width", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "headerConfig", "getHeaderConfig$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "onHeaderConfigAttachListener", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigAttachListener;", "getOnHeaderConfigAttachListener$react_native_screens_release", "setOnHeaderConfigAttachListener$react_native_screens_release", "attachHeaderConfig", BoxAnalyticsParams.CTA_LOCATION_HEADER, "attachHeaderConfig$react_native_screens_release", "detachHeaderConfig", "detachHeaderConfig$react_native_screens_release", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;)V", "preventNativeDismissChangeObserver", "Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;", "getPreventNativeDismissChangeObserver$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;", "setPreventNativeDismissChangeObserver$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;)V", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "createAppearanceEventsEmitter", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenAppearanceEventsEmitter;", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "createAppearanceEventsEmitter$react_native_screens_release", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "onDismiss$react_native_screens_release", StackScreenNativeDismissPreventedEvent.EVENT_REGISTRATION_NAME, "onNativeDismissPrevented$react_native_screens_release", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "getAssociatedFragment", "Landroidx/fragment/app/Fragment;", "ActivityMode", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackScreen extends MAMViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "isPreventNativeDismissEnabled", "isPreventNativeDismissEnabled$react_native_screens_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "activityMode", "getActivityMode()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", 0))};

    /* JADX INFO: renamed from: activityMode$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty activityMode;
    public StackScreenEventEmitter eventEmitter;
    private StackHeaderConfig headerConfig;
    private boolean isNativelyDismissed;

    /* JADX INFO: renamed from: isPreventNativeDismissEnabled$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isPreventNativeDismissEnabled;
    private WeakReference<OnHeaderConfigAttachListener> onHeaderConfigAttachListener;
    private PreventNativeDismissChangeObserver preventNativeDismissChangeObserver;
    private final ThemedReactContext reactContext;
    private String screenKey;
    private final ShadowStateProxy shadowStateProxy;
    private WeakReference<StackHost> stackHost;

    /* JADX INFO: compiled from: StackScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "", "<init>", "(Ljava/lang/String;I)V", "DETACHED", "ATTACHED", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ActivityMode {
        DETACHED,
        ATTACHED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ActivityMode> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.isPreventNativeDismissEnabled = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                PreventNativeDismissChangeObserver preventNativeDismissChangeObserver;
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                if (oldValue.booleanValue() == zBooleanValue || (preventNativeDismissChangeObserver = this.getPreventNativeDismissChangeObserver()) == null) {
                    return;
                }
                preventNativeDismissChangeObserver.preventNativeDismissChanged(zBooleanValue);
            }
        };
        this.stackHost = new WeakReference<>(null);
        Delegates delegates2 = Delegates.INSTANCE;
        final ActivityMode activityMode = ActivityMode.DETACHED;
        this.activityMode = new ObservableProperty<ActivityMode>(activityMode) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackScreen.ActivityMode oldValue, StackScreen.ActivityMode newValue) {
                StackHost stackHost;
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue == newValue || (stackHost = this.getStackHost$react_native_screens_release().get()) == null) {
                    return;
                }
                stackHost.stackScreenChangedActivityMode$react_native_screens_release(this);
            }
        };
        this.shadowStateProxy = new ShadowStateProxy(false, 1, null);
    }

    public final boolean isPreventNativeDismissEnabled$react_native_screens_release() {
        return ((Boolean) this.isPreventNativeDismissEnabled.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setPreventNativeDismissEnabled$react_native_screens_release(boolean z) {
        this.isPreventNativeDismissEnabled.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: isNativelyDismissed$react_native_screens_release, reason: from getter */
    public final boolean getIsNativelyDismissed() {
        return this.isNativelyDismissed;
    }

    public final void setNativelyDismissed$react_native_screens_release(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("[RNScreens] Natively dismissed StackScreen must remain dismissed.".toString());
        }
        this.isNativelyDismissed = true;
    }

    public final WeakReference<StackHost> getStackHost$react_native_screens_release() {
        return this.stackHost;
    }

    public final void setStackHost$react_native_screens_release(WeakReference<StackHost> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.stackHost = weakReference;
    }

    public final ActivityMode getActivityMode() {
        return (ActivityMode) this.activityMode.getValue(this, $$delegatedProperties[1]);
    }

    public final void setActivityMode(ActivityMode activityMode) {
        Intrinsics.checkNotNullParameter(activityMode, "<set-?>");
        this.activityMode.setValue(this, $$delegatedProperties[1], activityMode);
    }

    public final String getScreenKey() {
        return this.screenKey;
    }

    public final void setScreenKey(String str) {
        if (this.screenKey != null) {
            throw new IllegalArgumentException("[RNScreens] StackScreen can't change its screenKey.".toString());
        }
        this.screenKey = str;
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    public static /* synthetic */ void updateStateIfNeeded$default(StackScreen stackScreen, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        stackScreen.updateStateIfNeeded(num, num2, num3, num4);
    }

    public final void updateStateIfNeeded(Integer x, Integer y, Integer width, Integer height) {
        this.shadowStateProxy.updateStateIfNeeded(width, height, x, y);
    }

    /* JADX INFO: renamed from: getHeaderConfig$react_native_screens_release, reason: from getter */
    public final StackHeaderConfig getHeaderConfig() {
        return this.headerConfig;
    }

    public final WeakReference<OnHeaderConfigAttachListener> getOnHeaderConfigAttachListener$react_native_screens_release() {
        return this.onHeaderConfigAttachListener;
    }

    public final void setOnHeaderConfigAttachListener$react_native_screens_release(WeakReference<OnHeaderConfigAttachListener> weakReference) {
        this.onHeaderConfigAttachListener = weakReference;
    }

    public final void attachHeaderConfig$react_native_screens_release(StackHeaderConfig header) {
        OnHeaderConfigAttachListener onHeaderConfigAttachListener;
        Intrinsics.checkNotNullParameter(header, "header");
        this.headerConfig = header;
        WeakReference<OnHeaderConfigAttachListener> weakReference = this.onHeaderConfigAttachListener;
        if (weakReference == null || (onHeaderConfigAttachListener = weakReference.get()) == null) {
            return;
        }
        onHeaderConfigAttachListener.onHeaderConfigAttach(header);
    }

    public final void detachHeaderConfig$react_native_screens_release(StackHeaderConfig header) {
        OnHeaderConfigAttachListener onHeaderConfigAttachListener;
        Intrinsics.checkNotNullParameter(header, "header");
        if (this.headerConfig == header) {
            this.headerConfig = null;
            WeakReference<OnHeaderConfigAttachListener> weakReference = this.onHeaderConfigAttachListener;
            if (weakReference == null || (onHeaderConfigAttachListener = weakReference.get()) == null) {
                return;
            }
            onHeaderConfigAttachListener.onHeaderConfigAttach(null);
        }
    }

    public final StackScreenEventEmitter getEventEmitter$react_native_screens_release() {
        StackScreenEventEmitter stackScreenEventEmitter = this.eventEmitter;
        if (stackScreenEventEmitter != null) {
            return stackScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(StackScreenEventEmitter stackScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(stackScreenEventEmitter, "<set-?>");
        this.eventEmitter = stackScreenEventEmitter;
    }

    /* JADX INFO: renamed from: getPreventNativeDismissChangeObserver$react_native_screens_release, reason: from getter */
    public final PreventNativeDismissChangeObserver getPreventNativeDismissChangeObserver() {
        return this.preventNativeDismissChangeObserver;
    }

    public final void setPreventNativeDismissChangeObserver$react_native_screens_release(PreventNativeDismissChangeObserver preventNativeDismissChangeObserver) {
        this.preventNativeDismissChangeObserver = preventNativeDismissChangeObserver;
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] StackScreen must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new StackScreenEventEmitter(this.reactContext, getId()));
    }

    public final StackScreenAppearanceEventsEmitter createAppearanceEventsEmitter$react_native_screens_release(LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        return new StackScreenAppearanceEventsEmitter(viewLifecycleOwner.getLifecycleRegistry(), getEventEmitter$react_native_screens_release());
    }

    public final void onDismiss$react_native_screens_release() {
        if (getActivityMode() == ActivityMode.ATTACHED) {
            setNativelyDismissed$react_native_screens_release(true);
        }
        getEventEmitter$react_native_screens_release().emitOnDismiss$react_native_screens_release(this.isNativelyDismissed);
    }

    public final void onNativeDismissPrevented$react_native_screens_release() {
        getEventEmitter$react_native_screens_release().emitOnNativeDismissPrevented$react_native_screens_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, Integer.valueOf(r - l), Integer.valueOf(b - t), null, null, 12, null);
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        Fragment fragmentFindFragmentOrNull = ViewExtKt.findFragmentOrNull(this);
        if (fragmentFindFragmentOrNull == null) {
            return null;
        }
        if (fragmentFindFragmentOrNull instanceof StackScreenFragment) {
            return fragmentFindFragmentOrNull;
        }
        throw new IllegalStateException(("[RNScreens] Unexpected fragment type: " + fragmentFindFragmentOrNull.getClass().getSimpleName()).toString());
    }
}
