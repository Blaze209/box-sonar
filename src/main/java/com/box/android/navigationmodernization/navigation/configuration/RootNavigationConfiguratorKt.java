package com.box.android.navigationmodernization.navigation.configuration;

import com.box.android.inbox.InboxDestination;
import com.box.android.navigationmodernization.MainNavigationTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationConfigurator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"getStartInboxTab", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RootNavigationConfiguratorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxDestination.TabsScreen.InboxTab getStartInboxTab(MainNavigationTarget mainNavigationTarget) {
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.Notifications.INSTANCE)) {
            return InboxDestination.TabsScreen.InboxTab.Notifications;
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.MyTasks.INSTANCE)) {
            return InboxDestination.TabsScreen.InboxTab.MyTasks;
        }
        if (Intrinsics.areEqual(mainNavigationTarget, MainNavigationTarget.SentTasks.INSTANCE)) {
            return InboxDestination.TabsScreen.InboxTab.SentTasks;
        }
        return null;
    }
}
