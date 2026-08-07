package com.box.android.inbox.tabsscreen;

import androidx.compose.runtime.Composer;
import com.box.android.inbox.notifications.InboxViewModel;
import com.box.android.vm.InboxBadgeVM;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B@\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/tabsscreen/InboxTabsViewModels;", "", "viewModel", "Lkotlin/Function0;", "Lcom/box/android/inbox/tabsscreen/InboxTabsViewModel;", "Landroidx/compose/runtime/Composable;", "notificationsViewModel", "Lcom/box/android/inbox/notifications/InboxViewModel;", "inboxBadgeViewModel", "Lcom/box/android/vm/InboxBadgeVM;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getNotificationsViewModel", "getInboxBadgeViewModel", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxTabsViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, InboxBadgeVM> inboxBadgeViewModel;
    private final Function2<Composer, Integer, InboxViewModel> notificationsViewModel;
    private final Function2<Composer, Integer, InboxTabsViewModel> viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public InboxTabsViewModels(Function2<? super Composer, ? super Integer, InboxTabsViewModel> viewModel, Function2<? super Composer, ? super Integer, InboxViewModel> notificationsViewModel, Function2<? super Composer, ? super Integer, ? extends InboxBadgeVM> inboxBadgeViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(notificationsViewModel, "notificationsViewModel");
        Intrinsics.checkNotNullParameter(inboxBadgeViewModel, "inboxBadgeViewModel");
        this.viewModel = viewModel;
        this.notificationsViewModel = notificationsViewModel;
        this.inboxBadgeViewModel = inboxBadgeViewModel;
    }

    public final Function2<Composer, Integer, InboxTabsViewModel> getViewModel() {
        return this.viewModel;
    }

    public final Function2<Composer, Integer, InboxViewModel> getNotificationsViewModel() {
        return this.notificationsViewModel;
    }

    public final Function2<Composer, Integer, InboxBadgeVM> getInboxBadgeViewModel() {
        return this.inboxBadgeViewModel;
    }
}
