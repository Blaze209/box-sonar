package com.swmansion.rnscreens.gamma.tabs.screen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsScreenFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b\f\u0010\r*\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012*\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "Landroidx/fragment/app/Fragment;", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "<init>", "(Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;)V", "getTabsScreen$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "requireScreenKey", "", "getRequireScreenKey$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;)Ljava/lang/Object;", "getRequireScreenKey$react_native_screens_release", "()Ljava/lang/String;", "isPreventNativeSelectionEnabled", "", "isPreventNativeSelectionEnabled$react_native_screens_release$delegate", "isPreventNativeSelectionEnabled$react_native_screens_release", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onResume", "onPause", "onStop", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsScreenFragment extends Fragment {
    private final TabsScreen tabsScreen;

    /* JADX INFO: renamed from: getTabsScreen$react_native_screens_release, reason: from getter */
    public final TabsScreen getTabsScreen() {
        return this.tabsScreen;
    }

    public TabsScreenFragment(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        this.tabsScreen = tabsScreen;
    }

    public final String getRequireScreenKey$react_native_screens_release() {
        return this.tabsScreen.getRequireScreenKey$react_native_screens_release();
    }

    public final boolean isPreventNativeSelectionEnabled$react_native_screens_release() {
        return this.tabsScreen.getPreventNativeSelection();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return this.tabsScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnWillAppear();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnDidAppear();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnWillDisappear();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnDidDisappear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.tabsScreen.onFragmentConfigurationChange$react_native_screens_release(this, newConfig);
    }
}
