package com.box.android.search.presentation.ui;

import android.net.Uri;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.extractor.ts.PsExtractor;
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
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.browse.cpl.browse.FolderItemPickerScreenKt;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.search.presentation.cpl.SearchReducer;
import com.box.android.search.presentation.vm.SearchItemPickerViewModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchItemPickerScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"defaultSearchItemPickerViewModels", "Lcom/box/android/search/presentation/ui/SearchItemPickerViewModels;", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/search/presentation/ui/SearchItemPickerViewModels;", "SearchItemPickerScreen", "", "viewModels", "initialSearchMode", "", "onDismissSearch", "Lkotlin/Function0;", "(Lcom/box/android/search/presentation/ui/SearchItemPickerViewModels;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SEARCH_SCREEN_ROUTE_PREFIX", "SEARCH_SCREEN_ROUTE", "FOLDER_ROUTE_PREFIX", "FOLDER_ROUTE", "search_generalProdRelease", "state", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchItemPickerScreenKt {
    private static final String FOLDER_ROUTE = "folder/{folderId}?folderName={folderName}";
    private static final String FOLDER_ROUTE_PREFIX = "folder";
    private static final String SEARCH_SCREEN_ROUTE = "search_screen/{initial_search_mode}";
    private static final String SEARCH_SCREEN_ROUTE_PREFIX = "search_screen";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$1(SearchItemPickerViewModels searchItemPickerViewModels, String str, Function0 function0, int i, Composer composer, int i2) {
        SearchItemPickerScreen(searchItemPickerViewModels, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final SearchItemPickerViewModels defaultSearchItemPickerViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1657663683, "C(defaultSearchItemPickerViewModels)34@1643L163:SearchItemPickerScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1657663683, i, -1, "com.box.android.search.presentation.ui.defaultSearchItemPickerViewModels (SearchItemPickerScreen.kt:34)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -418065050, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SearchItemPickerViewModels(new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.defaultSearchItemPickerViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.defaultSearchItemPickerViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        SearchItemPickerViewModels searchItemPickerViewModels = (SearchItemPickerViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchItemPickerViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchItemPickerViewModel defaultSearchItemPickerViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-344840247);
        ComposerKt.sourceInformation(composer, "C36@1724L15:SearchItemPickerScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-344840247, i, -1, "com.box.android.search.presentation.ui.defaultSearchItemPickerViewModels.<anonymous>.<anonymous> (SearchItemPickerScreen.kt:36)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SearchItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        SearchItemPickerViewModel searchItemPickerViewModel = (SearchItemPickerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return searchItemPickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderItemPickerViewModel defaultSearchItemPickerViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-124718396);
        ComposerKt.sourceInformation(composer, "C37@1781L15:SearchItemPickerScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-124718396, i, -1, "com.box.android.search.presentation.ui.defaultSearchItemPickerViewModels.<anonymous>.<anonymous> (SearchItemPickerScreen.kt:37)");
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

    public static final void SearchItemPickerScreen(final SearchItemPickerViewModels viewModels, final String initialSearchMode, final Function0<Unit> onDismissSearch, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModels, "viewModels");
        Intrinsics.checkNotNullParameter(initialSearchMode, "initialSearchMode");
        Intrinsics.checkNotNullParameter(onDismissSearch, "onDismissSearch");
        Composer composerStartRestartGroup = composer.startRestartGroup(473678816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchItemPickerScreen)N(viewModels,initialSearchMode,onDismissSearch)44@2019L23,49@2240L1991,45@2047L2184:SearchItemPickerScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(viewModels) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(initialSearchMode) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissSearch) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(473678816, i2, -1, "com.box.android.search.presentation.ui.SearchItemPickerScreen (SearchItemPickerScreen.kt:43)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            String str = "search_screen/" + initialSearchMode;
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "SearchItemPickerScreen");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -61177369, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0(viewModels, onDismissSearch, navHostControllerRememberNavController, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            NavHostKt.NavHost(navHostControllerRememberNavController, str, modifierTestTag, null, null, null, null, null, null, null, (Function1) objRememberedValue, composer2, 384, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$1(viewModels, initialSearchMode, onDismissSearch, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0(final SearchItemPickerViewModels searchItemPickerViewModels, final Function0 function0, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, SEARCH_SCREEN_ROUTE, CollectionsKt.listOf(NamedNavArgumentKt.navArgument(SearchItemPickerNavArg.INITIAL_SEARCH_MODE_KEY, new Function1() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$0((NavArgumentBuilder) obj);
            }
        })), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(746178819, true, new Function4() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$1(searchItemPickerViewModels, function0, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, FOLDER_ROUTE, CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("folderId", new Function1() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$2((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument(BoxCommonConstants.EXTRA_FOLDER_NAME, new Function1() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$3((NavArgumentBuilder) obj);
            }
        })}), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-323562374, true, new Function4() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$4(searchItemPickerViewModels, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$0(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$1(SearchItemPickerViewModels searchItemPickerViewModels, Function0 function0, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)58@2519L27,63@2738L297,59@2559L490:SearchItemPickerScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(746178819, i, -1, "com.box.android.search.presentation.ui.SearchItemPickerScreen.<anonymous>.<anonymous>.<anonymous> (SearchItemPickerScreen.kt:58)");
        }
        Store<SearchReducer.State, SearchReducer.Action> store = searchItemPickerViewModels.getSearchItemPickerViewModel().invoke(composer, 0).getStore();
        ComposerKt.sourceInformationMarkerStart(composer, -181684756, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$1$0$0(navHostController, (ItemModel) obj, (String) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchScreenKt.SearchScreen(store, true, function0, (Function2) objRememberedValue, null, null, null, null, composer, 48, PsExtractor.VIDEO_STREAM_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$1$0$0(NavHostController navHostController, ItemModel item, String str) {
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
    public static final Unit SearchItemPickerScreen$lambda$0$0$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        navArgument.setDefaultValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$4(SearchItemPickerViewModels searchItemPickerViewModels, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)82@3429L27,83@3469L746:SearchItemPickerScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-323562374, i, -1, "com.box.android.search.presentation.ui.SearchItemPickerScreen.<anonymous>.<anonymous>.<anonymous> (SearchItemPickerScreen.kt:82)");
        }
        FolderItemPickerViewModel folderItemPickerViewModelInvoke = searchItemPickerViewModels.getFolderItemPickerViewModel().invoke(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -915483920, "C85@3563L29,95@4028L10,88@3710L270,86@3609L516,98@4176L11,98@4189L11,98@4142L59:SearchItemPickerScreen.kt#vkhrzj");
        final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = folderItemPickerViewModelInvoke.getStore();
        final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
        String name = SearchItemPickerScreen$lambda$0$0$4$0$0(stateCollectAsStateWithLifecycle).getCurrentFolder().getName();
        TextStyle titleLargeEmphasized = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLargeEmphasized();
        ComposerKt.sourceInformationMarkerStart(composer, -1692093250, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(navHostController) | composer.changed(store);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$4$0$1$0(navHostController, store, stateCollectAsStateWithLifecycle);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BoxSimpleTopBarKt.BoxSimpleTopBar(name, (Function0) objRememberedValue, null, true, titleLargeEmphasized, composer, 3072, 4);
        ComposerKt.sourceInformationMarkerStart(composer, -1692078597, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$4$0$2$0((String) obj, ((Boolean) obj2).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function2 function2 = (Function2) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1692078181, "CC(remember):SearchItemPickerScreen.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchItemPickerScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchItemPickerScreenKt.SearchItemPickerScreen$lambda$0$0$4$0$3$0((List) obj, (Function1) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        FolderItemPickerScreenKt.FolderItemPickerScreen(folderItemPickerViewModelInvoke, function2, (Function2) objRememberedValue3, composer, FolderItemPickerViewModel.$stable | 432, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$4$0$1$0(NavHostController navHostController, Store store, State state) {
        if (SearchItemPickerScreen$lambda$0$0$4$0$0(state).getStack().size() == 1) {
            NavControllerExtensionsKt.popBackStackSafely(navHostController);
        } else {
            store.send(ItemPickerReducer.Action.GoBack.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$4$0$2$0(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchItemPickerScreen$lambda$0$0$4$0$3$0(List list, Function1 function1) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        Intrinsics.checkNotNullParameter(function1, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final ItemPickerReducer.State SearchItemPickerScreen$lambda$0$0$4$0$0(State<ItemPickerReducer.State> state) {
        return state.getValue();
    }
}
