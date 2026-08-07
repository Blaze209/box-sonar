package com.swmansion.rnscreens.gamma.tabs.screen;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ThemedReactContext;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.BuildConfig;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.helpers.SystemDrawableKt;
import com.swmansion.rnscreens.gamma.tabs.appearance.TabsAppearance;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TabsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001oB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0014J#\u0010[\u001a\u00020\n\"\u0004\b\u0000\u0010\\2\u0006\u0010]\u001a\u0002H\\2\u0006\u0010^\u001a\u0002H\\H\u0002¢\u0006\u0002\u0010_J\b\u0010`\u001a\u00020\nH\u0014J\u0017\u0010a\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\bcJ\n\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020\nH\u0002J\r\u0010g\u001a\u00020\nH\u0000¢\u0006\u0002\bhJ\u001d\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0000¢\u0006\u0002\bnR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR/\u0010%\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010$\u001a\u0004\u0018\u00010*8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010)\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00101\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010)\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R/\u00105\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010)\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R/\u00109\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010)\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R/\u0010=\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010)\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R/\u0010A\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010)\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R/\u0010F\u001a\u0004\u0018\u00010E2\b\u0010$\u001a\u0004\u0018\u00010E8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010)\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR/\u0010L\u001a\u0004\u0018\u00010E2\b\u0010$\u001a\u0004\u0018\u00010E8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010)\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR\u001a\u0010P\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010R\"\u0004\bW\u0010TR\u001a\u0010X\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010R\"\u0004\bZ\u0010T¨\u0006p"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "Landroid/view/ViewGroup;", "Lcom/swmansion/rnscreens/gamma/common/FragmentProviding;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "onLayout", "", "changed", "", CmcdData.STREAM_TYPE_LIVE, "", "t", "r", "b", "tabsScreenDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenDelegate;", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenEventEmitter;)V", "value", "", "screenKey", "getScreenKey", "()Ljava/lang/String;", "setScreenKey", "(Ljava/lang/String;)V", "requireScreenKey", "getRequireScreenKey$react_native_screens_release", "<set-?>", "tabTitle", "getTabTitle", "setTabTitle", "tabTitle$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;", "appearance", "getAppearance$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;", "setAppearance$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;)V", "appearance$delegate", "badgeValue", "getBadgeValue", "setBadgeValue", "badgeValue$delegate", "tabBarItemTestID", "getTabBarItemTestID", "setTabBarItemTestID", "tabBarItemTestID$delegate", "tabBarItemAccessibilityLabel", "getTabBarItemAccessibilityLabel", "setTabBarItemAccessibilityLabel", "tabBarItemAccessibilityLabel$delegate", "drawableIconResourceName", "getDrawableIconResourceName", "setDrawableIconResourceName", "drawableIconResourceName$delegate", "selectedDrawableIconResourceName", "getSelectedDrawableIconResourceName", "setSelectedDrawableIconResourceName", "selectedDrawableIconResourceName$delegate", "Landroid/graphics/drawable/Drawable;", HubsObservability.HUB_ASSET_ICON, "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "icon$delegate", "selectedIcon", "getSelectedIcon", "setSelectedIcon", "selectedIcon$delegate", "shouldUseRepeatedTabSelectionScrollToTopSpecialEffect", "getShouldUseRepeatedTabSelectionScrollToTopSpecialEffect", "()Z", "setShouldUseRepeatedTabSelectionScrollToTopSpecialEffect", "(Z)V", "shouldUseRepeatedTabSelectionPopToRootSpecialEffect", "getShouldUseRepeatedTabSelectionPopToRootSpecialEffect", "setShouldUseRepeatedTabSelectionPopToRootSpecialEffect", "preventNativeSelection", "getPreventNativeSelection", "setPreventNativeSelection", "updateMenuItemAttributesIfNeeded", ExifInterface.GPS_DIRECTION_TRUE, "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onAttachedToWindow", "setTabsScreenDelegate", "delegate", "setTabsScreenDelegate$react_native_screens_release", "getAssociatedFragment", "Landroidx/fragment/app/Fragment;", "onMenuItemAttributesChange", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "onFragmentConfigurationChange", BuildConfig.FLAVOR, "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "config", "Landroid/content/res/Configuration;", "onFragmentConfigurationChange$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsScreen extends MAMViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabTitle", "getTabTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "appearance", "getAppearance$react_native_screens_release()Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "badgeValue", "getBadgeValue()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemTestID", "getTabBarItemTestID()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemAccessibilityLabel", "getTabBarItemAccessibilityLabel()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "drawableIconResourceName", "getDrawableIconResourceName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "selectedDrawableIconResourceName", "getSelectedDrawableIconResourceName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, HubsObservability.HUB_ASSET_ICON, "getIcon()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "selectedIcon", "getSelectedIcon()Landroid/graphics/drawable/Drawable;", 0))};
    public static final String TAG = "TabsScreen";

    /* JADX INFO: renamed from: appearance$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty appearance;

    /* JADX INFO: renamed from: badgeValue$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty badgeValue;

    /* JADX INFO: renamed from: drawableIconResourceName$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty drawableIconResourceName;
    public TabsScreenEventEmitter eventEmitter;

    /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty icon;
    private boolean preventNativeSelection;
    private final ThemedReactContext reactContext;
    private String screenKey;

    /* JADX INFO: renamed from: selectedDrawableIconResourceName$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty selectedDrawableIconResourceName;

    /* JADX INFO: renamed from: selectedIcon$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty selectedIcon;
    private boolean shouldUseRepeatedTabSelectionPopToRootSpecialEffect;
    private boolean shouldUseRepeatedTabSelectionScrollToTopSpecialEffect;

    /* JADX INFO: renamed from: tabBarItemAccessibilityLabel$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty tabBarItemAccessibilityLabel;

    /* JADX INFO: renamed from: tabBarItemTestID$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty tabBarItemTestID;

    /* JADX INFO: renamed from: tabTitle$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty tabTitle;
    private WeakReference<TabsScreenDelegate> tabsScreenDelegate;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsScreen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final Object obj = null;
        this.tabsScreenDelegate = new WeakReference<>(null);
        Delegates delegates = Delegates.INSTANCE;
        this.tabTitle = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        Delegates delegates2 = Delegates.INSTANCE;
        this.appearance = new ObservableProperty<TabsAppearance>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, TabsAppearance oldValue, TabsAppearance newValue) {
                TabsScreenDelegate tabsScreenDelegate;
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue) || (tabsScreenDelegate = (TabsScreenDelegate) this.tabsScreenDelegate.get()) == null) {
                    return;
                }
                tabsScreenDelegate.onAppearanceChanged(this);
            }
        };
        Delegates delegates3 = Delegates.INSTANCE;
        this.badgeValue = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        Delegates delegates4 = Delegates.INSTANCE;
        this.tabBarItemTestID = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        Delegates delegates5 = Delegates.INSTANCE;
        this.tabBarItemAccessibilityLabel = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        Delegates delegates6 = Delegates.INSTANCE;
        this.drawableIconResourceName = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                String str = newValue;
                if (Intrinsics.areEqual(str, oldValue)) {
                    return;
                }
                TabsScreen tabsScreen = this;
                tabsScreen.setIcon(SystemDrawableKt.getSystemDrawableResource(tabsScreen.getReactContext(), str));
            }
        };
        Delegates delegates7 = Delegates.INSTANCE;
        this.selectedDrawableIconResourceName = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                String str = newValue;
                if (Intrinsics.areEqual(str, oldValue)) {
                    return;
                }
                TabsScreen tabsScreen = this;
                tabsScreen.setSelectedIcon(SystemDrawableKt.getSystemDrawableResource(tabsScreen.getReactContext(), str));
            }
        };
        Delegates delegates8 = Delegates.INSTANCE;
        this.icon = new ObservableProperty<Drawable>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$8
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Drawable oldValue, Drawable newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        Delegates delegates9 = Delegates.INSTANCE;
        this.selectedIcon = new ObservableProperty<Drawable>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen$special$$inlined$observable$9
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Drawable oldValue, Drawable newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect = true;
        this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect = true;
    }

    public final TabsScreenEventEmitter getEventEmitter$react_native_screens_release() {
        TabsScreenEventEmitter tabsScreenEventEmitter = this.eventEmitter;
        if (tabsScreenEventEmitter != null) {
            return tabsScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(TabsScreenEventEmitter tabsScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(tabsScreenEventEmitter, "<set-?>");
        this.eventEmitter = tabsScreenEventEmitter;
    }

    public final String getScreenKey() {
        return this.screenKey;
    }

    public final void setScreenKey(String str) {
        if (str != null && StringsKt.isBlank(str)) {
            str = null;
        }
        this.screenKey = str;
    }

    public final String getRequireScreenKey$react_native_screens_release() {
        String str = this.screenKey;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("[RNScreens] screenKey MUST NOT be null".toString());
    }

    public final String getTabTitle() {
        return (String) this.tabTitle.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTabTitle(String str) {
        this.tabTitle.setValue(this, $$delegatedProperties[0], str);
    }

    public final TabsAppearance getAppearance$react_native_screens_release() {
        return (TabsAppearance) this.appearance.getValue(this, $$delegatedProperties[1]);
    }

    public final void setAppearance$react_native_screens_release(TabsAppearance tabsAppearance) {
        this.appearance.setValue(this, $$delegatedProperties[1], tabsAppearance);
    }

    public final String getBadgeValue() {
        return (String) this.badgeValue.getValue(this, $$delegatedProperties[2]);
    }

    public final void setBadgeValue(String str) {
        this.badgeValue.setValue(this, $$delegatedProperties[2], str);
    }

    public final String getTabBarItemTestID() {
        return (String) this.tabBarItemTestID.getValue(this, $$delegatedProperties[3]);
    }

    public final void setTabBarItemTestID(String str) {
        this.tabBarItemTestID.setValue(this, $$delegatedProperties[3], str);
    }

    public final String getTabBarItemAccessibilityLabel() {
        return (String) this.tabBarItemAccessibilityLabel.getValue(this, $$delegatedProperties[4]);
    }

    public final void setTabBarItemAccessibilityLabel(String str) {
        this.tabBarItemAccessibilityLabel.setValue(this, $$delegatedProperties[4], str);
    }

    public final String getDrawableIconResourceName() {
        return (String) this.drawableIconResourceName.getValue(this, $$delegatedProperties[5]);
    }

    public final void setDrawableIconResourceName(String str) {
        this.drawableIconResourceName.setValue(this, $$delegatedProperties[5], str);
    }

    public final String getSelectedDrawableIconResourceName() {
        return (String) this.selectedDrawableIconResourceName.getValue(this, $$delegatedProperties[6]);
    }

    public final void setSelectedDrawableIconResourceName(String str) {
        this.selectedDrawableIconResourceName.setValue(this, $$delegatedProperties[6], str);
    }

    public final Drawable getIcon() {
        return (Drawable) this.icon.getValue(this, $$delegatedProperties[7]);
    }

    public final void setIcon(Drawable drawable) {
        this.icon.setValue(this, $$delegatedProperties[7], drawable);
    }

    public final Drawable getSelectedIcon() {
        return (Drawable) this.selectedIcon.getValue(this, $$delegatedProperties[8]);
    }

    public final void setSelectedIcon(Drawable drawable) {
        this.selectedIcon.setValue(this, $$delegatedProperties[8], drawable);
    }

    public final boolean getShouldUseRepeatedTabSelectionScrollToTopSpecialEffect() {
        return this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect;
    }

    public final void setShouldUseRepeatedTabSelectionScrollToTopSpecialEffect(boolean z) {
        this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect = z;
    }

    public final boolean getShouldUseRepeatedTabSelectionPopToRootSpecialEffect() {
        return this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect;
    }

    public final void setShouldUseRepeatedTabSelectionPopToRootSpecialEffect(boolean z) {
        this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect = z;
    }

    public final boolean getPreventNativeSelection() {
        return this.preventNativeSelection;
    }

    public final void setPreventNativeSelection(boolean z) {
        this.preventNativeSelection = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void updateMenuItemAttributesIfNeeded(T oldValue, T newValue) {
        if (Intrinsics.areEqual(newValue, oldValue)) {
            return;
        }
        onMenuItemAttributesChange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d(TAG, "TabsScreen [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    public final void setTabsScreenDelegate$react_native_screens_release(TabsScreenDelegate delegate) {
        this.tabsScreenDelegate = new WeakReference<>(delegate);
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        TabsScreenDelegate tabsScreenDelegate = this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            return tabsScreenDelegate.getFragmentForTabsScreen(this);
        }
        return null;
    }

    private final void onMenuItemAttributesChange() {
        TabsScreenDelegate tabsScreenDelegate = this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            tabsScreenDelegate.onMenuItemAttributesChange(this);
        }
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabsScreen must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new TabsScreenEventEmitter(this.reactContext, getId()));
    }

    public final void onFragmentConfigurationChange$react_native_screens_release(TabsScreenFragment fragment, Configuration config) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(config, "config");
        TabsScreenDelegate tabsScreenDelegate = this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            tabsScreenDelegate.onFragmentConfigurationChange(this, config);
        }
    }
}
