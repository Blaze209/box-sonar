package com.box.android.navigationmodernization.homescreen.navigation.compose;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHostController;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.navigationmodernization.navigation.navigator.InnerNavigatorsProviderFactory;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenInnerNavigatorsProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cBG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "fabManager", "Lcom/box/android/browse/cpl/browse/fab/FabManager;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "<init>", "(Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/browse/cpl/browse/fab/FabManager;Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;)V", "browseNavigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "collectionsNavigator", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "notesNavigator", "Lcom/box/android/notes/navigationmodernization/NotesNavigator;", PasskeyWebListener.CREATE_UNIQUE_KEY, "navController", "Landroidx/navigation/NavHostController;", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenInnerNavigatorsProviderFactory implements InnerNavigatorsProviderFactory<HomeScreenInnerNavigatorsProvider> {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final BrowseNavigator browseNavigator;
    private final CollectionsNavigator collectionsNavigator;
    private final IItemClickHandler itemClickHandler;
    private final IItemMoreActionsHandler itemMoreActionsHandler;
    private final NotesNavigator notesNavigator;

    /* JADX INFO: compiled from: HomeScreenInnerNavigatorsProvider.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        HomeScreenInnerNavigatorsProviderFactory create(AppCompatActivity activity, IItemClickHandler itemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler);
    }

    @AssistedInject
    public HomeScreenInnerNavigatorsProviderFactory(IntentServices intentServices, IUserContextManager userContextManager, CopyOrMoveHelper copyOrMoveHelper, FabManager fabManager, @Assisted AppCompatActivity activity, @Assisted IItemClickHandler itemClickHandler, @Assisted IItemMoreActionsHandler itemMoreActionsHandler) {
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(fabManager, "fabManager");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        this.activity = activity;
        this.itemClickHandler = itemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
        this.browseNavigator = new BrowseNavigator(activity, intentServices, userContextManager, itemClickHandler, itemMoreActionsHandler, copyOrMoveHelper);
        this.collectionsNavigator = new CollectionsNavigator(itemClickHandler, itemMoreActionsHandler);
        this.notesNavigator = new NotesNavigator(activity, fabManager);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.navigationmodernization.navigation.navigator.InnerNavigatorsProviderFactory
    public HomeScreenInnerNavigatorsProvider create(NavHostController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavHostController navHostController = navController;
        this.browseNavigator.init(navHostController);
        this.collectionsNavigator.init(navHostController);
        return new HomeScreenInnerNavigatorsProvider(this.browseNavigator, this.collectionsNavigator, this.notesNavigator);
    }
}
