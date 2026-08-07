package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import androidx.compose.runtime.Composer;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.browse.cpl.browse.AllFilesViewModel;
import com.box.android.browse.cpl.offlined.OfflinedViewModel;
import com.box.android.browse.cpl.recents.RecentsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseTabsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u008c\u0001\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u001e\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\f\u001a\r\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u001e\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsViewModels;", "", "viewModel", "Lkotlin/Function0;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsViewModel;", "Landroidx/compose/runtime/Composable;", "allFilesViewModel", "Lcom/box/android/browse/cpl/browse/AllFilesViewModel;", "offlinedViewModel", "Lcom/box/android/browse/cpl/offlined/OfflinedViewModel;", "recentsViewModel", "Lcom/box/android/browse/cpl/recents/RecentsViewModel;", "userAvatarViewModel", "Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", "jobsProgressViewModel", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressViewModel;", "inboxCountViewModel", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountViewModel;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getAllFilesViewModel", "getOfflinedViewModel", "getRecentsViewModel", "getUserAvatarViewModel", "getJobsProgressViewModel", "getInboxCountViewModel", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseTabsViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, AllFilesViewModel> allFilesViewModel;
    private final Function2<Composer, Integer, InboxCountViewModel> inboxCountViewModel;
    private final Function2<Composer, Integer, JobsProgressViewModel> jobsProgressViewModel;
    private final Function2<Composer, Integer, OfflinedViewModel> offlinedViewModel;
    private final Function2<Composer, Integer, RecentsViewModel> recentsViewModel;
    private final Function2<Composer, Integer, UserAvatarViewModel> userAvatarViewModel;
    private final Function2<Composer, Integer, BrowseTabsViewModel> viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public BrowseTabsViewModels(Function2<? super Composer, ? super Integer, BrowseTabsViewModel> viewModel, Function2<? super Composer, ? super Integer, AllFilesViewModel> allFilesViewModel, Function2<? super Composer, ? super Integer, OfflinedViewModel> offlinedViewModel, Function2<? super Composer, ? super Integer, RecentsViewModel> recentsViewModel, Function2<? super Composer, ? super Integer, UserAvatarViewModel> userAvatarViewModel, Function2<? super Composer, ? super Integer, JobsProgressViewModel> jobsProgressViewModel, Function2<? super Composer, ? super Integer, InboxCountViewModel> inboxCountViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(allFilesViewModel, "allFilesViewModel");
        Intrinsics.checkNotNullParameter(offlinedViewModel, "offlinedViewModel");
        Intrinsics.checkNotNullParameter(recentsViewModel, "recentsViewModel");
        Intrinsics.checkNotNullParameter(userAvatarViewModel, "userAvatarViewModel");
        Intrinsics.checkNotNullParameter(jobsProgressViewModel, "jobsProgressViewModel");
        Intrinsics.checkNotNullParameter(inboxCountViewModel, "inboxCountViewModel");
        this.viewModel = viewModel;
        this.allFilesViewModel = allFilesViewModel;
        this.offlinedViewModel = offlinedViewModel;
        this.recentsViewModel = recentsViewModel;
        this.userAvatarViewModel = userAvatarViewModel;
        this.jobsProgressViewModel = jobsProgressViewModel;
        this.inboxCountViewModel = inboxCountViewModel;
    }

    public final Function2<Composer, Integer, BrowseTabsViewModel> getViewModel() {
        return this.viewModel;
    }

    public final Function2<Composer, Integer, AllFilesViewModel> getAllFilesViewModel() {
        return this.allFilesViewModel;
    }

    public final Function2<Composer, Integer, OfflinedViewModel> getOfflinedViewModel() {
        return this.offlinedViewModel;
    }

    public final Function2<Composer, Integer, RecentsViewModel> getRecentsViewModel() {
        return this.recentsViewModel;
    }

    public final Function2<Composer, Integer, UserAvatarViewModel> getUserAvatarViewModel() {
        return this.userAvatarViewModel;
    }

    public final Function2<Composer, Integer, JobsProgressViewModel> getJobsProgressViewModel() {
        return this.jobsProgressViewModel;
    }

    public final Function2<Composer, Integer, InboxCountViewModel> getInboxCountViewModel() {
        return this.inboxCountViewModel;
    }
}
