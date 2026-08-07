package com.swmansion.rnscreens.gamma.tabs.container;

import android.content.Context;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomBottomNavigationView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/CustomBottomNavigationView;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "context", "Landroid/content/Context;", TtmlNode.RUBY_CONTAINER, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "<init>", "(Landroid/content/Context;Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;)V", "getContainer", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "setSelectedItemIdWithActionOrigin", "", "itemId", "", "setSelectedItemIdWithActionOrigin$react_native_screens_release", "setSelectedItemId", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBottomNavigationView extends BottomNavigationView {
    private TabsActionOrigin actionOrigin;
    private final TabsContainer container;

    public final TabsContainer getContainer() {
        return this.container;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomBottomNavigationView(Context context, TabsContainer container) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    public final void setSelectedItemIdWithActionOrigin$react_native_screens_release(int itemId, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        if (actionOrigin == TabsActionOrigin.USER) {
            throw new IllegalArgumentException("[RNScreens] User-triggered actions should be processed via regular setSelectedItemId callback".toString());
        }
        this.actionOrigin = actionOrigin;
        setSelectedItemId(itemId);
        this.actionOrigin = null;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setSelectedItemId(int itemId) {
        if (this.actionOrigin == null) {
            this.actionOrigin = TabsActionOrigin.USER;
        }
        TabsActionOrigin tabsActionOrigin = this.actionOrigin;
        if (tabsActionOrigin == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        super.setSelectedItemId(itemId);
        this.container.onAfterSetSelectedItemId$react_native_screens_release(itemId, tabsActionOrigin);
        this.actionOrigin = null;
    }
}
