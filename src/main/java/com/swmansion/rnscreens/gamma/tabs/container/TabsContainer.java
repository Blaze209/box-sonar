package com.swmansion.rnscreens.gamma.tabs.container;

import android.content.Context;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.ScreenStack;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorScheme;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeCoordinator;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeListener;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelper;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelperKt;
import com.swmansion.rnscreens.gamma.helpers.ViewFinder;
import com.swmansion.rnscreens.gamma.helpers.ViewIdGenerator;
import com.swmansion.rnscreens.gamma.tabs.appearance.TabsAppearanceCoordinator;
import com.swmansion.rnscreens.gamma.tabs.host.TabsHost;
import com.swmansion.rnscreens.gamma.tabs.host.TabsHostA11yCoordinator;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import com.swmansion.rnscreens.safearea.EdgeInsets;
import com.swmansion.rnscreens.safearea.SafeAreaProvider;
import com.swmansion.rnscreens.safearea.SafeAreaView;
import com.swmansion.rnscreens.utils.RNSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TabsContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004²\u0001³\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020NJ\u000e\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020\u00112\u0006\u0010S\u001a\u00020TJ\u0017\u0010V\u001a\u00020N2\b\u0010W\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\bXJ\u001d\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0000¢\u0006\u0002\b^J\u0017\u0010_\u001a\u0004\u0018\u00010]2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]H\u0000¢\u0006\u0002\bbJ\r\u0010c\u001a\u00020NH\u0000¢\u0006\u0002\bdJ\r\u0010e\u001a\u00020NH\u0000¢\u0006\u0002\bfJ\r\u0010g\u001a\u00020NH\u0000¢\u0006\u0002\bhJ\r\u0010i\u001a\u00020NH\u0000¢\u0006\u0002\bjJ\u001d\u0010k\u001a\u00020N2\u0006\u0010l\u001a\u00020[2\u0006\u0010m\u001a\u00020nH\u0000¢\u0006\u0002\boJ\b\u0010p\u001a\u00020NH\u0014J\b\u0010q\u001a\u00020NH\u0014J\u0012\u0010r\u001a\u00020N2\b\u0010s\u001a\u0004\u0018\u00010tH\u0014J\u0014\u0010u\u001a\u0004\u0018\u00010v2\b\u0010w\u001a\u0004\u0018\u00010vH\u0016JU\u0010x\u001a\u00020N2\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020[2\u0006\u0010|\u001a\u00020[2\u0006\u0010}\u001a\u00020[2\u0006\u0010~\u001a\u00020[2\u0006\u0010\u007f\u001a\u00020[2\u0007\u0010\u0080\u0001\u001a\u00020[2\u0007\u0010\u0081\u0001\u001a\u00020[2\u0007\u0010\u0082\u0001\u001a\u00020[H\u0016J\u0012\u0010\u0083\u0001\u001a\u00020N2\u0007\u0010\u0084\u0001\u001a\u00020DH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020N2\u0007\u0010\u0084\u0001\u001a\u00020DH\u0016J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\t\u0010\u0088\u0001\u001a\u00020[H\u0016J\u0013\u0010\u0089\u0001\u001a\u00020N2\b\u0010\u0084\u0001\u001a\u00030\u008a\u0001H\u0016J\u0013\u0010\u008b\u0001\u001a\u00020N2\b\u0010\u0084\u0001\u001a\u00030\u008a\u0001H\u0016J\u0011\u0010\u008c\u0001\u001a\u00020N2\u0006\u0010\\\u001a\u00020]H\u0016J\u0011\u0010\u008d\u0001\u001a\u00020N2\u0006\u0010\\\u001a\u00020]H\u0016J\u0013\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\\\u001a\u00020]H\u0016J\u001a\u0010\u008f\u0001\u001a\u00020N2\u0006\u0010\\\u001a\u00020]2\u0007\u0010\u0090\u0001\u001a\u00020tH\u0016J\t\u0010\u0091\u0001\u001a\u00020NH\u0002J\t\u0010\u0092\u0001\u001a\u00020NH\u0002J\t\u0010\u0093\u0001\u001a\u00020NH\u0002J\t\u0010\u0094\u0001\u001a\u00020NH\u0002J\t\u0010\u0095\u0001\u001a\u00020NH\u0002J\t\u0010\u0096\u0001\u001a\u00020NH\u0002J\t\u0010\u0097\u0001\u001a\u00020NH\u0002J\t\u0010\u0098\u0001\u001a\u00020NH\u0002J\t\u0010\u0099\u0001\u001a\u00020NH\u0002J\u001a\u0010\u009a\u0001\u001a\u00020\u00112\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020nH\u0002J\u001a\u0010\u009c\u0001\u001a\u00020N2\u0007\u0010\u009d\u0001\u001a\u00020P2\u0006\u0010m\u001a\u00020nH\u0002J\u0013\u0010\u009e\u0001\u001a\u00020\u00112\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\t\u0010¡\u0001\u001a\u00020NH\u0002J\u0012\u0010¢\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020[H\u0002J\u0013\u0010¤\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010l\u001a\u00020[H\u0002J\u001a\u0010¥\u0001\u001a\u0004\u0018\u00010[2\u0007\u0010¦\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0003\u0010©\u0001J\u0014\u0010ª\u0001\u001a\u0005\u0018\u00010 \u00012\u0006\u0010\\\u001a\u00020]H\u0002J\u0013\u0010«\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020PH\u0002J\u0011\u0010¬\u0001\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020PH\u0002J\u001c\u0010\u00ad\u0001\u001a\u00020N2\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0003\u0010¯\u0001J\u0013\u0010°\u0001\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020vH\u0002J\u0011\u0010±\u0001\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00060-R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00104\u001a\u0002032\u0006\u00102\u001a\u0002038@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b7\u00108\"\u0004\b9\u0010:*\u0004\b5\u00106R\u001a\u0010;\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R\u000e\u0010>\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010E\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bF\u0010\u0013\"\u0004\bG\u0010\u0015R\u0011\u0010J\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006´\u0001"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "Landroid/widget/FrameLayout;", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeProviding;", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenDelegate;", "Lcom/swmansion/rnscreens/safearea/SafeAreaProvider;", "Landroid/view/View$OnLayoutChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "navState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "lastUINavState", "tabsModel", "", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "rejectStaleNavigationStateUpdates", "", "getRejectStaleNavigationStateUpdates$react_native_screens_release", "()Z", "setRejectStaleNavigationStateUpdates$react_native_screens_release", "(Z)V", "selectedTab", "getSelectedTab$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "invalidationFlags", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainerInvalidationFlags;", "getInvalidationFlags$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainerInvalidationFlags;", "pendingStateUpdateRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", "requirePendingStateUpdateRequest", "isInExternalOperationContext", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "requireFragmentManager", "getRequireFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "themedContext", "Landroidx/appcompat/view/ContextThemeWrapper;", "bottomNavigationView", "Lcom/swmansion/rnscreens/gamma/tabs/container/CustomBottomNavigationView;", "getBottomNavigationView$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/container/CustomBottomNavigationView;", "specialEffectsHandler", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer$SpecialEffectsHandler;", "colorSchemeCoordinator", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeCoordinator;", "observerRegistry", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserverRegistry;", "<set-?>", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "colorScheme", "getColorScheme$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;)Ljava/lang/Object;", "getColorScheme$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "setColorScheme$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;)V", "tabBarRespectsIMEInsets", "getTabBarRespectsIMEInsets$react_native_screens_release", "setTabBarRespectsIMEInsets$react_native_screens_release", "contentView", "appearanceCoordinator", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearanceCoordinator;", "a11yCoordinator", "Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostA11yCoordinator;", "interfaceInsetsChangeListener", "Lcom/swmansion/rnscreens/safearea/SafeAreaView;", "tabBarHidden", "getTabBarHidden$react_native_screens_release", "setTabBarHidden$react_native_screens_release", "tabBarHidden$delegate", "Lkotlin/properties/ReadWriteProperty;", "navigationState", "getNavigationState", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "submitSelectionOfTabsScreenWithKey", "", "screenKey", "", "flushPendingUpdates", "addNavigationStateObserver", "observer", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserver;", "removeNavigationStateObserver", "setPendingNavigationStateUpdate", "request", "setPendingNavigationStateUpdate$react_native_screens_release", "addTabsScreenAt", FirebaseAnalytics.Param.INDEX, "", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "addTabsScreenAt$react_native_screens_release", "removeTabsScreenAt", "removeTabsScreenAt$react_native_screens_release", "removeTabsScreen", "removeTabsScreen$react_native_screens_release", "removeAllTabsScreens", "removeAllTabsScreens$react_native_screens_release", "setupFragmentManager", "setupFragmentManager$react_native_screens_release", "teardownFragmentManager", "teardownFragmentManager$react_native_screens_release", "tearDown", "tearDown$react_native_screens_release", "onAfterSetSelectedItemId", "itemId", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "onAfterSetSelectedItemId$react_native_screens_release", "onAttachedToWindow", "onDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onLayoutChange", "view", "Landroid/view/View;", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "oldLeft", "oldTop", "oldRight", "oldBottom", "setOnInterfaceInsetsChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeOnInterfaceInsetsChangeListener", "getInterfaceInsets", "Lcom/swmansion/rnscreens/safearea/EdgeInsets;", "getResolvedUiNightMode", "addColorSchemeListener", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeListener;", "removeColorSchemeListener", "onAppearanceChanged", "onMenuItemAttributesChange", "getFragmentForTabsScreen", "onFragmentConfigurationChange", "config", "performContainerUpdate", "performPreSelectedTabUpdateActions", "performPostSelectedTabUpdateActions", "updateNavigationMenuStructureIfNeeded", "performSelectedTabUpdateIfNeeded", "updateBottomNavigationViewAppearanceIfNeeded", "performSelectedTabUpdate", "updateNavigationMenuStructure", "updateBottomNavigationViewAppearance", "updateSelectedFragment", "nextSelectedFragment", "progressNavigationState", "selectedScreenKey", "onMenuItemSelected", "item", "Landroid/view/MenuItem;", "restoreNavigationStateIfNeeded", "applyDayNightUiMode", "uiMode", "getFragmentForMenuItemId", "getMenuItemIdForFragment", "tabsScreenFragment", "(Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;)Ljava/lang/Integer;", "getSelectedTabsScreenFragmentId", "()Ljava/lang/Integer;", "getMenuItemForTabsScreen", "getFragmentForScreenKey", "requireFragmentForScreenKey", "updateInterfaceInsets", "newHeight", "(Ljava/lang/Integer;)V", "getInsetsForBottomNavigationView", "isNavigationStateStale", "SpecialEffectsHandler", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsContainer extends FrameLayout implements ColorSchemeProviding, TabsScreenDelegate, SafeAreaProvider, View.OnLayoutChangeListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsContainer.class, "tabBarHidden", "getTabBarHidden$react_native_screens_release()Z", 0))};
    public static final String TAG = "TabsContainer";
    private final TabsHostA11yCoordinator a11yCoordinator;
    private final TabsAppearanceCoordinator appearanceCoordinator;
    private final CustomBottomNavigationView bottomNavigationView;
    private final ColorSchemeCoordinator colorSchemeCoordinator;
    private final FrameLayout contentView;
    private final Context context;
    private FragmentManager fragmentManager;
    private SafeAreaView interfaceInsetsChangeListener;
    private final TabsContainerInvalidationFlags invalidationFlags;
    private boolean isInExternalOperationContext;
    private TabsNavigationState lastUINavState;
    private TabsNavigationState navState;
    private final TabsNavigationStateObserverRegistry observerRegistry;
    private TabsNavigationStateUpdateRequest pendingStateUpdateRequest;
    private boolean rejectStaleNavigationStateUpdates;
    private final SpecialEffectsHandler specialEffectsHandler;

    /* JADX INFO: renamed from: tabBarHidden$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty tabBarHidden;
    private boolean tabBarRespectsIMEInsets;
    private final List<TabsScreenFragment> tabsModel;
    private final ContextThemeWrapper themedContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        setId(ViewIdGenerator.INSTANCE.generateViewId());
        this.navState = TabsNavigationState.INSTANCE.getEMPTY();
        this.lastUINavState = TabsNavigationState.INSTANCE.getEMPTY();
        ArrayList arrayList = new ArrayList();
        this.tabsModel = arrayList;
        TabsContainerInvalidationFlags tabsContainerInvalidationFlags = new TabsContainerInvalidationFlags(false, false, false, 7, null);
        this.invalidationFlags = tabsContainerInvalidationFlags;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_Material3_DayNight_NoActionBar);
        this.themedContext = contextThemeWrapper;
        CustomBottomNavigationView customBottomNavigationView = new CustomBottomNavigationView(contextThemeWrapper, this);
        customBottomNavigationView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.bottomNavigationView = customBottomNavigationView;
        this.specialEffectsHandler = new SpecialEffectsHandler();
        this.colorSchemeCoordinator = new ColorSchemeCoordinator();
        this.observerRegistry = new TabsNavigationStateObserverRegistry();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setId(ViewIdGenerator.INSTANCE.generateViewId());
        this.contentView = frameLayout;
        this.appearanceCoordinator = new TabsAppearanceCoordinator(customBottomNavigationView, arrayList);
        this.a11yCoordinator = new TabsHostA11yCoordinator(customBottomNavigationView, arrayList);
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.tabBarHidden = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (newValue.booleanValue() != oldValue.booleanValue()) {
                    TabsContainer.updateInterfaceInsets$default(this, null, 1, null);
                    this.getInvalidationFlags().setNavigationMenuAppearanceInvalidated(true);
                    TabsContainer tabsContainer = this;
                    final TabsContainer tabsContainer2 = this;
                    tabsContainer.post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$tabBarHidden$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            tabsContainer2.flushPendingUpdates();
                        }
                    });
                }
            }
        };
        addView(frameLayout);
        addView(customBottomNavigationView);
        customBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda3
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return this.f$0.onMenuItemSelected(menuItem);
            }
        });
        tabsContainerInvalidationFlags.invalidateAll$react_native_screens_release();
    }

    /* JADX INFO: compiled from: TabsContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer$SpecialEffectsHandler;", "", "<init>", "(Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;)V", "handleRepeatedTabSelection", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class SpecialEffectsHandler {
        public SpecialEffectsHandler() {
        }

        public final boolean handleRepeatedTabSelection() {
            ScrollView scrollViewFindScrollViewInFirstDescendantChain;
            ScreenStack screenStackFindScreenStackInFirstDescendantChain;
            FrameLayout frameLayout = TabsContainer.this.contentView;
            TabsScreenFragment selectedTab$react_native_screens_release = TabsContainer.this.getSelectedTab$react_native_screens_release();
            if (selectedTab$react_native_screens_release.getTabsScreen().getShouldUseRepeatedTabSelectionPopToRootSpecialEffect() && (screenStackFindScreenStackInFirstDescendantChain = ViewFinder.INSTANCE.findScreenStackInFirstDescendantChain(frameLayout)) != null && screenStackFindScreenStackInFirstDescendantChain.popToRoot()) {
                return true;
            }
            if (!selectedTab$react_native_screens_release.getTabsScreen().getShouldUseRepeatedTabSelectionScrollToTopSpecialEffect() || (scrollViewFindScrollViewInFirstDescendantChain = ViewFinder.INSTANCE.findScrollViewInFirstDescendantChain(frameLayout)) == null || scrollViewFindScrollViewInFirstDescendantChain.getScrollY() <= 0) {
                return false;
            }
            scrollViewFindScrollViewInFirstDescendantChain.smoothScrollTo(scrollViewFindScrollViewInFirstDescendantChain.getScrollX(), 0);
            return true;
        }
    }

    /* JADX INFO: renamed from: getRejectStaleNavigationStateUpdates$react_native_screens_release, reason: from getter */
    public final boolean getRejectStaleNavigationStateUpdates() {
        return this.rejectStaleNavigationStateUpdates;
    }

    public final void setRejectStaleNavigationStateUpdates$react_native_screens_release(boolean z) {
        this.rejectStaleNavigationStateUpdates = z;
    }

    public final TabsScreenFragment getSelectedTab$react_native_screens_release() {
        TabsScreenFragment fragmentForScreenKey = getFragmentForScreenKey(this.navState.getSelectedScreenKey());
        if (fragmentForScreenKey != null) {
            return fragmentForScreenKey;
        }
        throw new IllegalStateException("[RNScreens] No selected tab present".toString());
    }

    /* JADX INFO: renamed from: getInvalidationFlags$react_native_screens_release, reason: from getter */
    public final TabsContainerInvalidationFlags getInvalidationFlags() {
        return this.invalidationFlags;
    }

    private final TabsNavigationStateUpdateRequest requirePendingStateUpdateRequest() {
        TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequest = this.pendingStateUpdateRequest;
        if (tabsNavigationStateUpdateRequest != null) {
            return tabsNavigationStateUpdateRequest;
        }
        throw new IllegalStateException("[RNScreens] Attempt to require nullish pendingStateUpdateRequest".toString());
    }

    private final FragmentManager getRequireFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("[RNScreens] Attempt to use nullish FragmentManager".toString());
    }

    /* JADX INFO: renamed from: getBottomNavigationView$react_native_screens_release, reason: from getter */
    public final CustomBottomNavigationView getBottomNavigationView() {
        return this.bottomNavigationView;
    }

    public final ColorScheme getColorScheme$react_native_screens_release() {
        return this.colorSchemeCoordinator.getColorScheme$react_native_screens_release();
    }

    public final void setColorScheme$react_native_screens_release(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "<set-?>");
        this.colorSchemeCoordinator.setColorScheme$react_native_screens_release(colorScheme);
    }

    /* JADX INFO: renamed from: getTabBarRespectsIMEInsets$react_native_screens_release, reason: from getter */
    public final boolean getTabBarRespectsIMEInsets() {
        return this.tabBarRespectsIMEInsets;
    }

    public final void setTabBarRespectsIMEInsets$react_native_screens_release(boolean z) {
        this.tabBarRespectsIMEInsets = z;
    }

    public final boolean getTabBarHidden$react_native_screens_release() {
        return ((Boolean) this.tabBarHidden.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setTabBarHidden$react_native_screens_release(boolean z) {
        this.tabBarHidden.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: getNavigationState, reason: from getter */
    public final TabsNavigationState getNavState() {
        return this.navState;
    }

    public final void submitSelectionOfTabsScreenWithKey(String screenKey) {
        Intrinsics.checkNotNullParameter(screenKey, "screenKey");
        setPendingNavigationStateUpdate$react_native_screens_release(new TabsNavigationStateUpdateRequest(screenKey, getNavState().getProvenance(), TabsActionOrigin.PROGRAMMATIC_NATIVE));
    }

    public final void flushPendingUpdates() {
        if (this.invalidationFlags.any$react_native_screens_release() && isAttachedToWindow()) {
            performContainerUpdate();
        }
    }

    public final boolean addNavigationStateObserver(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.observerRegistry.add(observer);
    }

    public final boolean removeNavigationStateObserver(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.observerRegistry.remove(observer);
    }

    public final void setPendingNavigationStateUpdate$react_native_screens_release(TabsNavigationStateUpdateRequest request) {
        this.pendingStateUpdateRequest = request;
        this.invalidationFlags.setSelectedTabInvalidated(request != null);
    }

    public final void addTabsScreenAt$react_native_screens_release(int index, TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        this.tabsModel.add(index, new TabsScreenFragment(tabsScreen));
        this.invalidationFlags.invalidateAll$react_native_screens_release();
    }

    public final TabsScreen removeTabsScreenAt$react_native_screens_release(int index) {
        TabsScreen tabsScreen = this.tabsModel.remove(index).getTabsScreen();
        this.invalidationFlags.invalidateAll$react_native_screens_release();
        return tabsScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeTabsScreen$lambda$7(TabsScreen tabsScreen, TabsScreenFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTabsScreen() == tabsScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeTabsScreen$lambda$8(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final boolean removeTabsScreen$react_native_screens_release(final TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        List<TabsScreenFragment> list = this.tabsModel;
        final Function1 function1 = new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TabsContainer.removeTabsScreen$lambda$7(tabsScreen, (TabsScreenFragment) obj));
            }
        };
        boolean zRemoveIf = list.removeIf(new Predicate() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TabsContainer.removeTabsScreen$lambda$8(function1, obj);
            }
        });
        if (zRemoveIf) {
            this.invalidationFlags.invalidateAll$react_native_screens_release();
        }
        return zRemoveIf;
    }

    public final void removeAllTabsScreens$react_native_screens_release() {
        this.tabsModel.clear();
        this.invalidationFlags.invalidateAll$react_native_screens_release();
    }

    public final void setupFragmentManager$react_native_screens_release() {
        FragmentManager fragmentManagerFindFragmentManagerForView = FragmentManagerHelper.INSTANCE.findFragmentManagerForView(this);
        if (fragmentManagerFindFragmentManagerForView != null) {
            this.fragmentManager = fragmentManagerFindFragmentManagerForView;
            return;
        }
        throw new IllegalStateException("[RNScreens] Nullish fragment manager - can't run container operations".toString());
    }

    public final void teardownFragmentManager$react_native_screens_release() {
        this.fragmentManager = null;
    }

    public final void tearDown$react_native_screens_release() {
        this.observerRegistry.clear();
        setPendingNavigationStateUpdate$react_native_screens_release(null);
    }

    public final void onAfterSetSelectedItemId$react_native_screens_release(int itemId, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        if (actionOrigin == TabsActionOrigin.USER) {
            performPostSelectedTabUpdateActions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d(TAG, "TabsContainer [" + getId() + "] attached to window");
        super.onAttachedToWindow();
        setupFragmentManager$react_native_screens_release();
        if (this.navState.isNotEmpty$react_native_screens_release()) {
            restoreNavigationStateIfNeeded();
        }
        flushPendingUpdates();
        this.colorSchemeCoordinator.setup$react_native_screens_release(this, new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsContainer.onAttachedToWindow$lambda$11(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachedToWindow$lambda$11(TabsContainer tabsContainer, int i) {
        tabsContainer.applyDayNightUiMode(i);
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        teardownFragmentManager$react_native_screens_release();
        this.colorSchemeCoordinator.teardown$react_native_screens_release();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.colorSchemeCoordinator.onConfigurationChanged$react_native_screens_release(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        if (!(insets != null ? insets.isConsumed() : true)) {
            for (View view : ViewGroupKt.getChildren(this)) {
                if (view == this.bottomNavigationView) {
                    ((CustomBottomNavigationView) view).dispatchApplyWindowInsets(getInsetsForBottomNavigationView(insets));
                } else {
                    view.dispatchApplyWindowInsets(insets);
                }
            }
        }
        return insets;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (!(view instanceof BottomNavigationView)) {
            throw new IllegalArgumentException(("[RNScreens] TabsContainer's onLayoutChange expects BottomNavigationView, received " + view + " instead").toString());
        }
        int i = bottom - top;
        if (i != oldBottom - oldTop) {
            updateInterfaceInsets(Integer.valueOf(i));
        }
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public void setOnInterfaceInsetsChangeListener(SafeAreaView listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.interfaceInsetsChangeListener == null) {
            this.bottomNavigationView.addOnLayoutChangeListener(this);
        }
        this.interfaceInsetsChangeListener = listener;
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public void removeOnInterfaceInsetsChangeListener(SafeAreaView listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Intrinsics.areEqual(this.interfaceInsetsChangeListener, listener)) {
            this.interfaceInsetsChangeListener = null;
            this.bottomNavigationView.removeOnLayoutChangeListener(this);
        }
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public EdgeInsets getInterfaceInsets() {
        return new EdgeInsets(0.0f, 0.0f, 0.0f, this.bottomNavigationView.getHeight());
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public int getResolvedUiNightMode() {
        return this.colorSchemeCoordinator.getResolvedUiNightMode();
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void addColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.colorSchemeCoordinator.addColorSchemeListener(listener);
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void removeColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.colorSchemeCoordinator.removeColorSchemeListener(listener);
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onAppearanceChanged(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        if (getSelectedTab$react_native_screens_release().getTabsScreen() == tabsScreen) {
            this.invalidationFlags.setNavigationMenuAppearanceInvalidated(true);
            post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.flushPendingUpdates();
                }
            });
        }
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onMenuItemAttributesChange(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        MenuItem menuItemForTabsScreen = getMenuItemForTabsScreen(tabsScreen);
        if (menuItemForTabsScreen != null) {
            this.appearanceCoordinator.updateMenuItemAppearance$react_native_screens_release(this.themedContext, menuItemForTabsScreen, tabsScreen, getSelectedTab$react_native_screens_release().getTabsScreen().getAppearance$react_native_screens_release());
            this.a11yCoordinator.setA11yPropertiesToTabItem(menuItemForTabsScreen, tabsScreen);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public TabsScreenFragment getFragmentForTabsScreen(TabsScreen tabsScreen) {
        Object next;
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((TabsScreenFragment) next).getTabsScreen() == tabsScreen) {
                return (TabsScreenFragment) next;
            }
        }
        next = null;
        return (TabsScreenFragment) next;
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onFragmentConfigurationChange(TabsScreen tabsScreen, Configuration config) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        Intrinsics.checkNotNullParameter(config, "config");
        onConfigurationChanged(config);
    }

    private final void performContainerUpdate() {
        performPreSelectedTabUpdateActions();
        performSelectedTabUpdateIfNeeded();
        performPostSelectedTabUpdateActions();
    }

    private final void performPreSelectedTabUpdateActions() {
        updateNavigationMenuStructureIfNeeded();
    }

    private final void performPostSelectedTabUpdateActions() {
        updateBottomNavigationViewAppearanceIfNeeded();
    }

    private final void updateNavigationMenuStructureIfNeeded() {
        if (this.invalidationFlags.getIsNavigationMenuStructureInvalidated()) {
            this.invalidationFlags.setNavigationMenuStructureInvalidated(false);
            updateNavigationMenuStructure();
        }
    }

    private final void performSelectedTabUpdateIfNeeded() {
        if (this.invalidationFlags.getIsSelectedTabInvalidated()) {
            this.invalidationFlags.setSelectedTabInvalidated(false);
            performSelectedTabUpdate();
        }
    }

    private final void updateBottomNavigationViewAppearanceIfNeeded() {
        if (this.invalidationFlags.getIsNavigationMenuAppearanceInvalidated()) {
            this.invalidationFlags.setNavigationMenuAppearanceInvalidated(false);
            updateBottomNavigationViewAppearance();
            this.a11yCoordinator.setA11yPropertiesToAllTabItems();
        }
    }

    private final void performSelectedTabUpdate() {
        if (this.pendingStateUpdateRequest == null) {
            RNSLog.INSTANCE.w(TAG, "TabsContainer::performSelectedTabUpdate called w/o pending operation; skipping update");
            return;
        }
        TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest = requirePendingStateUpdateRequest();
        Integer menuItemIdForFragment = getMenuItemIdForFragment(requireFragmentForScreenKey(tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getSelectedScreenKey()));
        if (menuItemIdForFragment == null) {
            throw new IllegalStateException(("[RNScreens] Failed to find Menu Item for screenKey: " + tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getSelectedScreenKey()).toString());
        }
        int iIntValue = menuItemIdForFragment.intValue();
        if (this.rejectStaleNavigationStateUpdates && isNavigationStateStale(tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest)) {
            this.observerRegistry.emitOnNavigationStateUpdateRejected(this.navState, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest, TabsNavigationStateRejectionReason.STALE);
            this.pendingStateUpdateRequest = null;
            return;
        }
        if (this.bottomNavigationView.getSelectedItemId() != iIntValue || this.navState.isEmpty$react_native_screens_release()) {
            this.isInExternalOperationContext = true;
            this.bottomNavigationView.setSelectedItemIdWithActionOrigin$react_native_screens_release(iIntValue, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getActionOrigin());
            this.isInExternalOperationContext = false;
        } else {
            this.observerRegistry.emitOnNavigationStateUpdateRejected(this.navState, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest, TabsNavigationStateRejectionReason.REPEATED);
        }
        this.pendingStateUpdateRequest = null;
    }

    private final void updateNavigationMenuStructure() {
        Menu menu = this.bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        if (menu.size() != this.tabsModel.size()) {
            this.bottomNavigationView.getMenu().clear();
        }
        int i = 0;
        for (Object obj : this.tabsModel) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Menu menu2 = this.bottomNavigationView.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu2, "getMenu(...)");
            if (MenuHelpersKt.fragmentIndexForMenuItemId(MenuHelpersKt.getOrCreateMenuItemForFragmentAt(menu2, i, ((TabsScreenFragment) obj).getTabsScreen()).getItemId()) != i) {
                throw new IllegalStateException("[RNScreens] Illegal state: menu items are shuffled".toString());
            }
            i = i2;
        }
    }

    private final void updateBottomNavigationViewAppearance() {
        RNSLog.INSTANCE.d(TAG, "updateBottomNavigationViewAppearance");
        this.appearanceCoordinator.updateTabAppearance(this.themedContext, this);
        post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.requestLayout();
            }
        });
    }

    private final boolean updateSelectedFragment(TabsScreenFragment nextSelectedFragment, TabsActionOrigin actionOrigin) {
        if (this.navState.isEmpty$react_native_screens_release()) {
            if (!this.isInExternalOperationContext || this.pendingStateUpdateRequest == null) {
                throw new IllegalStateException("Check failed.");
            }
            this.navState = new TabsNavigationState(nextSelectedFragment.getRequireScreenKey$react_native_screens_release(), 0);
            FragmentManagerHelperKt.createTransactionWithReordering(getRequireFragmentManager()).add(this.contentView.getId(), nextSelectedFragment).commitNowAllowingStateLoss();
            return true;
        }
        TabsScreenFragment selectedTab$react_native_screens_release = getSelectedTab$react_native_screens_release();
        if (nextSelectedFragment == selectedTab$react_native_screens_release) {
            progressNavigationState(this.navState.getSelectedScreenKey(), actionOrigin);
            return true;
        }
        progressNavigationState(nextSelectedFragment.getRequireScreenKey$react_native_screens_release(), actionOrigin);
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(getRequireFragmentManager());
        fragmentTransactionCreateTransactionWithReordering.remove(selectedTab$react_native_screens_release);
        fragmentTransactionCreateTransactionWithReordering.add(this.contentView.getId(), nextSelectedFragment).commitNowAllowingStateLoss();
        return true;
    }

    private final void progressNavigationState(String selectedScreenKey, TabsActionOrigin actionOrigin) {
        this.navState = new TabsNavigationState(selectedScreenKey, this.navState.getProvenance() + 1);
        if (actionOrigin != TabsActionOrigin.PROGRAMMATIC_JS) {
            this.lastUINavState = this.navState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onMenuItemSelected(MenuItem item) {
        TabsActionOrigin actionOrigin;
        RNSLog.INSTANCE.d(TabsHost.TAG, "Item selected " + item);
        TabsScreenFragment selectedTab$react_native_screens_release = this.navState.isNotEmpty$react_native_screens_release() ? getSelectedTab$react_native_screens_release() : null;
        TabsScreenFragment fragmentForMenuItemId = getFragmentForMenuItemId(item.getItemId());
        if (fragmentForMenuItemId == null) {
            throw new IllegalStateException(("[RNScreens] Can not select item with id: " + item.getItemId() + " - associated fragment does not exist").toString());
        }
        boolean z = fragmentForMenuItemId == selectedTab$react_native_screens_release;
        if (this.isInExternalOperationContext) {
            actionOrigin = requirePendingStateUpdateRequest().getActionOrigin();
        } else {
            actionOrigin = TabsActionOrigin.USER;
        }
        if (!z && actionOrigin == TabsActionOrigin.USER && fragmentForMenuItemId.isPreventNativeSelectionEnabled$react_native_screens_release()) {
            this.observerRegistry.emitOnNavigationStateUpdatePrevented(this.navState, fragmentForMenuItemId.getRequireScreenKey$react_native_screens_release());
            return false;
        }
        boolean zUpdateSelectedFragment = updateSelectedFragment(fragmentForMenuItemId, actionOrigin);
        boolean zHandleRepeatedTabSelection = z ? this.specialEffectsHandler.handleRepeatedTabSelection() : false;
        if (zUpdateSelectedFragment && !z) {
            this.invalidationFlags.invalidateOnSelectedTabChanged$react_native_screens_release();
        }
        if (zUpdateSelectedFragment) {
            this.observerRegistry.emitOnNavigationStateUpdate(this.navState, z, zHandleRepeatedTabSelection, actionOrigin);
        }
        return true;
    }

    private final void restoreNavigationStateIfNeeded() {
        if (this.navState.isEmpty$react_native_screens_release()) {
            return;
        }
        List<Fragment> fragments = getRequireFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof TabsScreenFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (this.tabsModel.contains((TabsScreenFragment) obj2)) {
                arrayList2.add(obj2);
            }
        }
        List list = CollectionsKt.toList(arrayList2);
        if (list.size() == 1 && list.get(0) == getSelectedTab$react_native_screens_release()) {
            return;
        }
        if (list.isEmpty()) {
            FragmentManagerHelperKt.createTransactionWithReordering(getRequireFragmentManager()).add(this.contentView.getId(), getSelectedTab$react_native_screens_release()).commitNowAllowingStateLoss();
            return;
        }
        throw new IllegalStateException("[RNScreens] Unexpected fragment manager state.".toString());
    }

    private final void applyDayNightUiMode(int uiMode) {
        if (uiMode == 16) {
            this.themedContext.setTheme(R.style.Theme_Material3_Light_NoActionBar);
        } else if (uiMode == 32) {
            this.themedContext.setTheme(R.style.Theme_Material3_Dark_NoActionBar);
        } else {
            this.themedContext.setTheme(R.style.Theme_Material3_DayNight_NoActionBar);
        }
        this.appearanceCoordinator.updateTabAppearance(this.themedContext, this);
    }

    private final TabsScreenFragment getFragmentForMenuItemId(int itemId) {
        return (TabsScreenFragment) CollectionsKt.getOrNull(this.tabsModel, MenuHelpersKt.fragmentIndexForMenuItemId(itemId));
    }

    private final Integer getMenuItemIdForFragment(TabsScreenFragment tabsScreenFragment) {
        Iterator<TabsScreenFragment> it = this.tabsModel.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next() == tabsScreenFragment) {
                break;
            }
            i++;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return Integer.valueOf(MenuHelpersKt.menuItemIdForFragmentAtIndex(numValueOf.intValue()));
        }
        return null;
    }

    private final Integer getSelectedTabsScreenFragmentId() {
        Iterator<TabsScreenFragment> it = this.tabsModel.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getRequireScreenKey$react_native_screens_release(), this.navState.getSelectedScreenKey())) {
                break;
            }
            i++;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() != -1) {
            return numValueOf;
        }
        return null;
    }

    private final MenuItem getMenuItemForTabsScreen(TabsScreen tabsScreen) {
        Iterator<TabsScreenFragment> it = this.tabsModel.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getTabsScreen() == tabsScreen) {
                break;
            }
            i++;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        return this.bottomNavigationView.getMenu().findItem(MenuHelpersKt.menuItemIdForFragmentAtIndex(numValueOf.intValue()));
    }

    private final TabsScreenFragment getFragmentForScreenKey(String screenKey) {
        Object next;
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((TabsScreenFragment) next).getRequireScreenKey$react_native_screens_release(), screenKey)) {
                return (TabsScreenFragment) next;
            }
        }
        next = null;
        return (TabsScreenFragment) next;
    }

    private final TabsScreenFragment requireFragmentForScreenKey(String screenKey) {
        TabsScreenFragment fragmentForScreenKey = getFragmentForScreenKey(screenKey);
        if (fragmentForScreenKey != null) {
            return fragmentForScreenKey;
        }
        throw new IllegalStateException(("[RNScreens] Requested fragment for key: " + screenKey + " does not exist").toString());
    }

    static /* synthetic */ void updateInterfaceInsets$default(TabsContainer tabsContainer, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        tabsContainer.updateInterfaceInsets(num);
    }

    private final void updateInterfaceInsets(Integer newHeight) {
        int iIntValue;
        if (getTabBarHidden$react_native_screens_release()) {
            iIntValue = 0;
        } else {
            iIntValue = newHeight != null ? newHeight.intValue() : this.bottomNavigationView.getHeight();
        }
        SafeAreaView safeAreaView = this.interfaceInsetsChangeListener;
        if (safeAreaView != null) {
            safeAreaView.onInterfaceInsetsChange(new EdgeInsets(0.0f, 0.0f, 0.0f, iIntValue));
        }
    }

    private final WindowInsets getInsetsForBottomNavigationView(WindowInsets insets) {
        if (this.tabBarRespectsIMEInsets) {
            return insets;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, this);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        return new WindowInsetsCompat.Builder(windowInsetsCompat).setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE).build().toWindowInsets();
    }

    private final boolean isNavigationStateStale(TabsNavigationStateUpdateRequest request) {
        return (this.navState.isEmpty$react_native_screens_release() || this.lastUINavState.isEmpty$react_native_screens_release() || request.getBaseProvenance() >= this.lastUINavState.getProvenance()) ? false : true;
    }
}
