package com.box.android.notes.navigationmodernization.tabsscreen;

import androidx.compose.runtime.Composer;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u001e\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsViewModels;", "", "viewModel", "Lkotlin/Function0;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsViewModel;", "Landroidx/compose/runtime/Composable;", "recentsViewModel", "Lcom/box/android/notes/presentation/cpl/NotesRecentsViewModel;", "favoritesViewModel", "Lcom/box/android/notes/presentation/cpl/NotesFavoritesViewModel;", "userAvatarViewModel", "Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getRecentsViewModel", "getFavoritesViewModel", "getUserAvatarViewModel", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesTabsViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, NotesFavoritesViewModel> favoritesViewModel;
    private final Function2<Composer, Integer, NotesRecentsViewModel> recentsViewModel;
    private final Function2<Composer, Integer, UserAvatarViewModel> userAvatarViewModel;
    private final Function2<Composer, Integer, NotesTabsViewModel> viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public NotesTabsViewModels(Function2<? super Composer, ? super Integer, NotesTabsViewModel> viewModel, Function2<? super Composer, ? super Integer, NotesRecentsViewModel> recentsViewModel, Function2<? super Composer, ? super Integer, NotesFavoritesViewModel> favoritesViewModel, Function2<? super Composer, ? super Integer, UserAvatarViewModel> userAvatarViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(recentsViewModel, "recentsViewModel");
        Intrinsics.checkNotNullParameter(favoritesViewModel, "favoritesViewModel");
        Intrinsics.checkNotNullParameter(userAvatarViewModel, "userAvatarViewModel");
        this.viewModel = viewModel;
        this.recentsViewModel = recentsViewModel;
        this.favoritesViewModel = favoritesViewModel;
        this.userAvatarViewModel = userAvatarViewModel;
    }

    public final Function2<Composer, Integer, NotesTabsViewModel> getViewModel() {
        return this.viewModel;
    }

    public final Function2<Composer, Integer, NotesRecentsViewModel> getRecentsViewModel() {
        return this.recentsViewModel;
    }

    public final Function2<Composer, Integer, NotesFavoritesViewModel> getFavoritesViewModel() {
        return this.favoritesViewModel;
    }

    public final Function2<Composer, Integer, UserAvatarViewModel> getUserAvatarViewModel() {
        return this.userAvatarViewModel;
    }
}
