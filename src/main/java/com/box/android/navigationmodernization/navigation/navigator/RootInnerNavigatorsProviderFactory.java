package com.box.android.navigationmodernization.navigation.navigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHostController;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.search.navigation.FilesSearchNavigator;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.search.navigation.SearchNavigator;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootInnerNavigatorsProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;", "Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;", "boxSearchItemClickHandlerFactory", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "<init>", "(Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;Lcom/box/android/coreservices/services/IntentServices;Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;)V", "boxSearchItemClickHandler", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "filesSearchNavigator", "Lcom/box/android/browse/search/navigation/FilesSearchNavigator;", PasskeyWebListener.CREATE_UNIQUE_KEY, "navController", "Landroidx/navigation/NavHostController;", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RootInnerNavigatorsProviderFactory implements InnerNavigatorsProviderFactory<RootInnerNavigatorsProvider> {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final BoxSearchItemClickHandler boxSearchItemClickHandler;
    private final FilesSearchNavigator filesSearchNavigator;
    private final IntentServices intentServices;
    private final IItemClickHandler itemClickHandler;
    private final IItemMoreActionsHandler itemMoreActionsHandler;

    /* JADX INFO: compiled from: RootInnerNavigatorsProvider.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        RootInnerNavigatorsProviderFactory create(AppCompatActivity activity, IItemClickHandler itemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler);
    }

    @AssistedInject
    public RootInnerNavigatorsProviderFactory(BoxSearchItemClickHandler.Factory boxSearchItemClickHandlerFactory, IntentServices intentServices, @Assisted AppCompatActivity activity, @Assisted IItemClickHandler itemClickHandler, @Assisted IItemMoreActionsHandler itemMoreActionsHandler) {
        Intrinsics.checkNotNullParameter(boxSearchItemClickHandlerFactory, "boxSearchItemClickHandlerFactory");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        this.intentServices = intentServices;
        this.activity = activity;
        this.itemClickHandler = itemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
        BoxSearchItemClickHandler boxSearchItemClickHandlerCreate = boxSearchItemClickHandlerFactory.create(activity, itemClickHandler);
        this.boxSearchItemClickHandler = boxSearchItemClickHandlerCreate;
        this.filesSearchNavigator = new FilesSearchNavigator(boxSearchItemClickHandlerCreate, itemMoreActionsHandler);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.navigationmodernization.navigation.navigator.InnerNavigatorsProviderFactory
    public RootInnerNavigatorsProvider create(NavHostController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavHostController navHostController = navController;
        this.filesSearchNavigator.init(navHostController);
        return new RootInnerNavigatorsProvider(this.filesSearchNavigator, new SearchNavigator(this.activity, navHostController, this.intentServices, this.boxSearchItemClickHandler, this.itemMoreActionsHandler, null, null, 96, null));
    }
}
