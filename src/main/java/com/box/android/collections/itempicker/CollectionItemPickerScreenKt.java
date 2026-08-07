package com.box.android.collections.itempicker;

import android.net.Uri;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.browse.cpl.browse.FolderItemPickerScreenKt;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.collections.R;
import com.box.android.collections.presentation.navigationmodernization.CollectionsReducerKt;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel;
import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer;
import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt;
import com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionItemsNavArg;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\u00072*\u0010\u000e\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011\u0012\u0004\u0012\u00020\u00040\u0007H\u0007¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0014\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"defaultCollectionItemPickerViewModels", "Lcom/box/android/collections/itempicker/CollectionItemPickerViewModels;", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/collections/itempicker/CollectionItemPickerViewModels;", "CollectionItemPickerScreen", "", "viewModels", "onNavigationChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "title", "", "isRootScreen", "onFolderStackChanged", "", "Lcom/box/android/domain/models/item/FolderModel;", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/collections/itempicker/CollectionItemPickerViewModels;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "COLLECTIONS_LIST_ROUTE", "COLLECTION_ITEMS_ROUTE_PREFIX", "COLLECTION_ITEMS_ROUTE", "FOLDER_ROUTE_PREFIX", "FOLDER_ROUTE", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemPickerScreenKt {
    private static final String COLLECTIONS_LIST_ROUTE = "collections_list";
    private static final String COLLECTION_ITEMS_ROUTE = "collection_items/{collection_id}/{collection_name}/{collection_type}";
    private static final String COLLECTION_ITEMS_ROUTE_PREFIX = "collection_items";
    private static final String FOLDER_ROUTE = "folder/{folderId}?folderName={folderName}";
    private static final String FOLDER_ROUTE_PREFIX = "folder";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$1(CollectionItemPickerViewModels collectionItemPickerViewModels, Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        CollectionItemPickerScreen(collectionItemPickerViewModels, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final CollectionItemPickerViewModels defaultCollectionItemPickerViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -552359359, "C(defaultCollectionItemPickerViewModels)37@2010L222:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-552359359, i, -1, "com.box.android.collections.itempicker.defaultCollectionItemPickerViewModels (CollectionItemPickerScreen.kt:37)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1758603423, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CollectionItemPickerViewModels(new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.defaultCollectionItemPickerViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.defaultCollectionItemPickerViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.defaultCollectionItemPickerViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        CollectionItemPickerViewModels collectionItemPickerViewModels = (CollectionItemPickerViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return collectionItemPickerViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionsViewModel defaultCollectionItemPickerViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(239253197);
        ComposerKt.sourceInformation(composer, "C39@2090L15:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239253197, i, -1, "com.box.android.collections.itempicker.defaultCollectionItemPickerViewModels.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:39)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CollectionsViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        CollectionsViewModel collectionsViewModel = (CollectionsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionItemsListViewModel defaultCollectionItemPickerViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(364334467);
        ComposerKt.sourceInformation(composer, "C40@2150L15:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(364334467, i, -1, "com.box.android.collections.itempicker.defaultCollectionItemPickerViewModels.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:40)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CollectionItemsListViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        CollectionItemsListViewModel collectionItemsListViewModel = (CollectionItemsListViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionItemsListViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderItemPickerViewModel defaultCollectionItemPickerViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-115943879);
        ComposerKt.sourceInformation(composer, "C41@2207L15:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-115943879, i, -1, "com.box.android.collections.itempicker.defaultCollectionItemPickerViewModels.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:41)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FolderItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        FolderItemPickerViewModel folderItemPickerViewModel = (FolderItemPickerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return folderItemPickerViewModel;
    }

    public static final void CollectionItemPickerScreen(final CollectionItemPickerViewModels viewModels, final Function2<? super String, ? super Boolean, Unit> onNavigationChanged, final Function2<? super List<FolderModel>, ? super Function1<? super ItemId.Remote, Unit>, Unit> onFolderStackChanged, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModels, "viewModels");
        Intrinsics.checkNotNullParameter(onNavigationChanged, "onNavigationChanged");
        Intrinsics.checkNotNullParameter(onFolderStackChanged, "onFolderStackChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(1813847109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemPickerScreen)N(viewModels,onNavigationChanged,onFolderStackChanged)51@2508L23,56@2707L2853,52@2536L3024:CollectionItemPickerScreen.kt#b188g9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(viewModels) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNavigationChanged) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderStackChanged) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1813847109, i2, -1, "com.box.android.collections.itempicker.CollectionItemPickerScreen (CollectionItemPickerScreen.kt:50)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "CollectionItemPickerScreen");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -649632822, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0(viewModels, navHostControllerRememberNavController, onNavigationChanged, onFolderStackChanged, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            NavHostKt.NavHost(navHostControllerRememberNavController, COLLECTIONS_LIST_ROUTE, modifierTestTag, null, null, null, null, null, null, null, (Function1) objRememberedValue, composer2, 432, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$1(viewModels, onNavigationChanged, onFolderStackChanged, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0(final CollectionItemPickerViewModels collectionItemPickerViewModels, final NavHostController navHostController, final Function2 function2, final Function2 function3, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, COLLECTIONS_LIST_ROUTE, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-932852542, true, new Function4() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$0(collectionItemPickerViewModels, navHostController, function2, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, COLLECTION_ITEMS_ROUTE, CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("collection_id", new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$1((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument(CollectionItemsNavArg.COLLECTION_NAME, new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$2((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument("collection_type", new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$3((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument(CollectionItemsNavArg.ITEM_PICKER_MODE, new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$4((NavArgumentBuilder) obj);
            }
        })}), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(98534507, true, new Function4() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$5(collectionItemPickerViewModels, navHostController, function2, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, FOLDER_ROUTE, CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("folderId", new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$6((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument(BoxCommonConstants.EXTRA_FOLDER_NAME, new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$7((NavArgumentBuilder) obj);
            }
        })}), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1505469366, true, new Function4() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$8(collectionItemPickerViewModels, function2, function3, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$0(CollectionItemPickerViewModels collectionItemPickerViewModels, final NavHostController navHostController, Function2 function2, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)58@2801L22,62@2989L223,60@2899L327,68@3256L36,69@3326L76,69@3305L97:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-932852542, i, -1, "com.box.android.collections.itempicker.CollectionItemPickerScreen.<anonymous>.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:58)");
        }
        Store<CollectionsListReducer.State, CollectionsListReducer.Action> storeScopeCollectionsList = CollectionsReducerKt.scopeCollectionsList(collectionItemPickerViewModels.getCollectionsViewModel().invoke(composer, 0).getStore());
        ComposerKt.sourceInformationMarkerStart(composer, 1176879553, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$0$0$0(navHostController, (CollectionModel) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CollectionsListScreenKt.CollectionsListScreen(storeScopeCollectionsList, (Function1) objRememberedValue, null, composer, 0, 4);
        String strStringResource = StringResources_androidKt.stringResource(R.string.Collections, composer, 0);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1176890190, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(function2) | composer.changed(strStringResource);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1(function2, strStringResource, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$0$0$0(NavHostController navHostController, CollectionModel collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        NavController.navigate$default((NavController) navHostController, "collection_items/" + collection.getId() + "/" + Uri.encode(collection.getName()) + "/" + collection.getType(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(new NavType.EnumType(CollectionType.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$4(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.BoolType);
        navArgument.setDefaultValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$5(CollectionItemPickerViewModels collectionItemPickerViewModels, final NavHostController navHostController, Function2 function2, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)86@4065L30,90@4207L308,96@4561L11,88@4109L477,99@4694L77,99@4673L98:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(98534507, i, -1, "com.box.android.collections.itempicker.CollectionItemPickerScreen.<anonymous>.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:86)");
        }
        CollectionItemsListViewModel collectionItemsListViewModelInvoke = collectionItemPickerViewModels.getCollectionItemsListViewModel().invoke(composer, 0);
        Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> store = collectionItemsListViewModelInvoke.getStore();
        ComposerKt.sourceInformationMarkerStart(composer, 202386879, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$5$0$0(navHostController, (ItemModel) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 202397910, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$5$1$0((ItemModel) obj, (BottomSheetAttributes.BottomSheetMenuType) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CollectionItemsListScreenKt.CollectionItemsListContent(store, function1, (Function2) objRememberedValue2, null, null, composer, 384, 24);
        String name = ((CollectionItemsListReducer.State) StoreKt.stateValue(collectionItemsListViewModelInvoke.getStore())).getCollection().getName();
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 202402232, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(function2) | composer.changed(name);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$6$3$1(function2, name, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$5$0$0(NavHostController navHostController, ItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof FolderModel) {
            String strBoxIdOrNull = item.boxIdOrNull();
            if (strBoxIdOrNull == null) {
                return Unit.INSTANCE;
            }
            NavController.navigate$default((NavController) navHostController, "folder/" + strBoxIdOrNull + "?folderName=" + Uri.encode(((FolderModel) item).getName()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$5$1$0(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
        Intrinsics.checkNotNullParameter(itemModel, "<unused var>");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$6(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$7(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        navArgument.setDefaultValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$8(CollectionItemPickerViewModels collectionItemPickerViewModels, final Function2 function2, final Function2 function3, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)114@5151L27,117@5288L90,120@5419L111,115@5191L353:CollectionItemPickerScreen.kt#b188g9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1505469366, i, -1, "com.box.android.collections.itempicker.CollectionItemPickerScreen.<anonymous>.<anonymous>.<anonymous> (CollectionItemPickerScreen.kt:114)");
        }
        FolderItemPickerViewModel folderItemPickerViewModelInvoke = collectionItemPickerViewModels.getFolderItemPickerViewModel().invoke(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 647923812, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(function2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$8$0$0(function2, (String) obj, ((Boolean) obj2).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2 function4 = (Function2) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 647928025, "CC(remember):CollectionItemPickerScreen.kt#9igjgp");
        boolean zChanged2 = composer.changed(function3);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function2() { // from class: com.box.android.collections.itempicker.CollectionItemPickerScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemPickerScreenKt.CollectionItemPickerScreen$lambda$0$0$8$1$0(function3, (List) obj, (Function1) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        FolderItemPickerScreenKt.FolderItemPickerScreen(folderItemPickerViewModelInvoke, function4, (Function2) objRememberedValue2, composer, FolderItemPickerViewModel.$stable, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$8$0$0(Function2 function2, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        function2.invoke(name, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemPickerScreen$lambda$0$0$8$1$0(Function2 function2, List folders, Function1 navigateFn) {
        Intrinsics.checkNotNullParameter(folders, "folders");
        Intrinsics.checkNotNullParameter(navigateFn, "navigateFn");
        function2.invoke(folders, navigateFn);
        return Unit.INSTANCE;
    }
}
