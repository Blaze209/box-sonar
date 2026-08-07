package com.box.android.search.navigation.compose;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.core.os.BundleKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigationConfig;
import com.box.android.search.navigation.SearchNavigator;
import com.box.android.search.presentation.cpl.SearchReducer;
import com.box.android.search.presentation.ui.AiCenterLauncherKt;
import com.box.android.search.presentation.ui.FiltersScreenKt;
import com.box.android.search.presentation.ui.SearchScreenKt;
import com.box.android.search.presentation.vm.SearchViewModel;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: SearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"searchNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "searchNavigationConfig", "Lcom/box/android/search/navigation/SearchNavigationConfig;", "navigator", "Lcom/box/android/search/navigation/SearchNavigator;", "onCloseSearch", "Lkotlin/Function0;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "isRedesignedVersion", "", "aiCenterEnabled", "searchViewModelsProvider", "Lcom/box/android/search/navigation/compose/SearchViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/search/navigation/SearchNavigationConfig;Lcom/box/android/search/navigation/SearchNavigator;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/compose/ComposeFragmentInjector;ZZLkotlin/jvm/functions/Function2;)V", "defaultSearchViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/search/navigation/compose/SearchViewModels;", "search_generalProdRelease", "aiCenterSessionId", "", "aiCenterInitialPrompt", "isAiCenterLauncherVisible"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchNavigationComposeKt {
    public static /* synthetic */ void searchNavigationGraph$default(NavGraphBuilder navGraphBuilder, SearchNavigationConfig searchNavigationConfig, SearchNavigator searchNavigator, Function0 function0, ComposeFragmentInjector composeFragmentInjector, boolean z, boolean z2, Function2 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = true;
        }
        searchNavigationGraph(navGraphBuilder, searchNavigationConfig, searchNavigator, function0, composeFragmentInjector, z3, z2, (i & 64) != 0 ? new Function2() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return SearchNavigationComposeKt.searchNavigationGraph$lambda$0((Composer) obj2, ((Integer) obj3).intValue());
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchViewModels searchNavigationGraph$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(-255662718);
        ComposerKt.sourceInformation(composer, "C40@1943L25:SearchNavigationCompose.kt#p48wz3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-255662718, i, -1, "com.box.android.search.navigation.compose.searchNavigationGraph.<anonymous> (SearchNavigationCompose.kt:40)");
        }
        SearchViewModels searchViewModelsDefaultSearchViewModels = defaultSearchViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return searchViewModelsDefaultSearchViewModels;
    }

    public static final void searchNavigationGraph(NavGraphBuilder navGraphBuilder, final SearchNavigationConfig searchNavigationConfig, final SearchNavigator navigator, final Function0<Unit> onCloseSearch, final ComposeFragmentInjector composeFragmentInjector, final boolean z, final boolean z2, final Function2<? super Composer, ? super Integer, SearchViewModels> searchViewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(searchNavigationConfig, "searchNavigationConfig");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(onCloseSearch, "onCloseSearch");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(searchViewModelsProvider, "searchViewModelsProvider");
        String strGraphToRoute = SearchNavigationMappingKt.graphToRoute(SearchDestination.INSTANCE);
        NavGraphBuilderKt.navigation$default(navGraphBuilder, SearchNavigationMappingKt.toRoute(searchNavigationConfig.getStartDestination()), strGraphToRoute, (List) null, (List) null, ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), (Function1) null, new Function1() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchNavigationComposeKt.searchNavigationGraph$lambda$1(searchNavigationConfig, z2, searchViewModelsProvider, z, onCloseSearch, navigator, composeFragmentInjector, (NavGraphBuilder) obj);
            }
        }, 268, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1(final SearchNavigationConfig searchNavigationConfig, final boolean z, final Function2 function2, final boolean z2, final Function0 function0, final SearchNavigator searchNavigator, final ComposeFragmentInjector composeFragmentInjector, NavGraphBuilder navigation) {
        Intrinsics.checkNotNullParameter(navigation, "$this$navigation");
        NavGraphBuilderKt.composable$default(navigation, SearchNavigationMappingKt.toRoute(SearchDestination.InnerDestination.Search.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(591892963, true, new Function4() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0(searchNavigationConfig, z, function2, z2, function0, searchNavigator, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(navigation, SearchNavigationMappingKt.toRoute(SearchDestination.InnerDestination.Filters.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(776692250, true, new Function4() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$1(composeFragmentInjector, searchNavigator, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState searchNavigationGraph$lambda$1$0$1$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private static final String searchNavigationGraph$lambda$1$0$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState searchNavigationGraph$lambda$1$0$4$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private static final String searchNavigationGraph$lambda$1$0$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState searchNavigationGraph$lambda$1$0$7$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private static final boolean searchNavigationGraph$lambda$1$0$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void searchNavigationGraph$lambda$1$0$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchNavigationGraph$lambda$1$0$showAiCenterLauncher(MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, String str, String str2) {
        if (searchNavigationGraph$lambda$1$0$8(mutableState)) {
            return;
        }
        mutableState2.setValue(str);
        mutableState3.setValue(str2);
        searchNavigationGraph$lambda$1$0$9(mutableState, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchNavigationGraph$lambda$1$0$dismissAiCenterLauncher(MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3) {
        mutableState.setValue(null);
        mutableState2.setValue(null);
        searchNavigationGraph$lambda$1$0$9(mutableState3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$0$10$0(SearchNavigator searchNavigator, ItemModel item, String str) {
        Intrinsics.checkNotNullParameter(item, "item");
        searchNavigator.navigateTo(new SearchDestination.OuterDestination.Item(item, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$0$12$0(SearchNavigator searchNavigator, String hubId) {
        Intrinsics.checkNotNullParameter(hubId, "hubId");
        searchNavigator.navigateTo(new SearchDestination.OuterDestination.Hub(hubId));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$0$11$0(SearchNavigator searchNavigator, ItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        searchNavigator.navigateTo(new SearchDestination.OuterDestination.ItemMoreActionsMenu(item));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$1(ComposeFragmentInjector composeFragmentInjector, final SearchNavigator searchNavigator, AnimatedContentScope composable, NavBackStackEntry entry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(entry, "entry");
        ComposerKt.sourceInformation(composer, "CN(entry)115@5663L91,122@5956L47,123@6030L28,119@5792L280:SearchNavigationCompose.kt#p48wz3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(776692250, i, -1, "com.box.android.search.navigation.compose.searchNavigationGraph.<anonymous>.<anonymous> (SearchNavigationCompose.kt:115)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1696826545, "CC(rememberNavArgs)N(key)16@695L45:NavBackStackEntryExt.kt#i3t43k");
        ComposerKt.sourceInformationMarkerStart(composer, -1437260482, "CC(remember):NavBackStackEntryExt.kt#9igjgp");
        boolean zChanged = composer.changed(entry);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = entry.getSavedStateHandle().get(SearchDestination.InnerDestination.Filters.FILTERS_ARGS_KEY);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FilesSearchFilters filesSearchFilters = (FilesSearchFilters) objRememberedValue;
        FilesSearchFilters filesSearchFilters2 = filesSearchFilters == null ? new FilesSearchFilters(null, null, null, 7, null) : filesSearchFilters;
        ComposerKt.sourceInformationMarkerStart(composer, -923046231, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(searchNavigator);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$1$0$0(searchNavigator, (FilesSearchFilters) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -923043882, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(searchNavigator);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$1$1$0(searchNavigator);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiltersScreenKt.FiltersScreen(filesSearchFilters2, composeFragmentInjector, function1, (Function0) objRememberedValue3, null, composer, 0, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$1$0$0(SearchNavigator searchNavigator, FilesSearchFilters filters) {
        Intrinsics.checkNotNullParameter(filters, "filters");
        searchNavigator.popWithResult(filters);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$1$1$0(SearchNavigator searchNavigator) {
        searchNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    public static final SearchViewModels defaultSearchViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1277131588, "C(defaultSearchViewModels)133@6272L106:SearchNavigationCompose.kt#p48wz3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1277131588, i, -1, "com.box.android.search.navigation.compose.defaultSearchViewModels (SearchNavigationCompose.kt:133)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1037188882, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SearchViewModels(new Function3() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchNavigationComposeKt.defaultSearchViewModels$lambda$0$0((Bundle) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        SearchViewModels searchViewModels = (SearchViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchViewModel defaultSearchViewModels$lambda$0$0(final Bundle args, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(args, "args");
        composer.startReplaceGroup(1141902668);
        ComposerKt.sourceInformation(composer, "CN(args)135@6341L27:SearchNavigationCompose.kt#p48wz3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141902668, i, -1, "com.box.android.search.navigation.compose.defaultSearchViewModels.<anonymous>.<anonymous> (SearchNavigationCompose.kt:135)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1556966040, "CC(hiltViewModelWithArgs)N(args)176@6582L35,176@6534L83:ComposeUtils.kt#vejmn0");
        ComposerKt.sourceInformationMarkerStart(composer, -1595741461, "CC(remember):ComposeUtils.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(args);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<ViewModelAssistedFactory<SearchViewModel>, SearchViewModel>() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$defaultSearchViewModels$lambda$0$0$$inlined$hiltViewModelWithArgs$1
                /* JADX WARN: Type inference failed for: r1v2, types: [androidx.lifecycle.ViewModel, com.box.android.search.presentation.vm.SearchViewModel] */
                @Override // kotlin.jvm.functions.Function1
                public final SearchViewModel invoke(ViewModelAssistedFactory<SearchViewModel> factory) {
                    Intrinsics.checkNotNullParameter(factory, "factory");
                    return factory.create(args);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceableGroup(-83599083);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(2,1)*68@2969L7,74@3156L47,75@3215L430:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        CreationExtras creationExtrasWithCreationCallback = current instanceof HasDefaultViewModelProviderFactory ? HiltViewModelExtensions.withCreationCallback(((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras(), function1) : HiltViewModelExtensions.withCreationCallback(CreationExtras.Empty.INSTANCE, function1);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SearchViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, creationExtrasWithCreationCallback, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchViewModel searchViewModel = (SearchViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return searchViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchNavigationGraph$lambda$1$0(SearchNavigationConfig searchNavigationConfig, boolean z, Function2 function2, boolean z2, Function0 function0, final SearchNavigator searchNavigator, AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        ComposerKt.sourceInformation(composer, "CN(backStackEntry)54@2737L47,56@2913L60,58@3089L325,66@3445L26,67@3526L33,67@3509L50,68@3618L33,68@3601L50,69@3714L25,69@3697L42,85@4298L21,87@4415L240,95@4855L142,92@4685L124,99@5094L110,102@5239L22,84@4249L1026:SearchNavigationCompose.kt#p48wz3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(591892963, i, -1, "com.box.android.search.navigation.compose.searchNavigationGraph.<anonymous>.<anonymous> (SearchNavigationCompose.kt:54)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1696826545, "CC(rememberNavArgs)N(key)16@695L45:NavBackStackEntryExt.kt#i3t43k");
        ComposerKt.sourceInformationMarkerStart(composer, -1437260482, "CC(remember):NavBackStackEntryExt.kt#9igjgp");
        boolean zChanged = composer.changed(backStackEntry);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = backStackEntry.getSavedStateHandle().get(SearchDestination.InnerDestination.Search.SEARCH_MODE);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object searchMode = (SearchMode) objRememberedValue;
        if (searchMode == null) {
            searchMode = searchNavigationConfig.getStartDestination().getSearchMode();
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1696826545, "CC(rememberNavArgs)N(key)16@695L45:NavBackStackEntryExt.kt#i3t43k");
        ComposerKt.sourceInformationMarkerStart(composer, -1437260482, "CC(remember):NavBackStackEntryExt.kt#9igjgp");
        boolean zChanged2 = composer.changed(backStackEntry);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = backStackEntry.getSavedStateHandle().get(SearchDestination.InnerDestination.Search.INCLUDE_RECENT_SHARED_LINKS);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Boolean bool = (Boolean) objRememberedValue2;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : searchNavigationConfig.getStartDestination().getIncludeRecentSharedLinks();
        ComposerKt.sourceInformationMarkerStart(composer, 1873474024, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChanged3 = composer.changed(searchMode) | composer.changed(z) | composer.changed(zBooleanValue);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = BundleKt.bundleOf(TuplesKt.to(SearchDestination.InnerDestination.Search.SEARCH_MODE, searchMode), TuplesKt.to("ai_center_enabled", Boolean.valueOf(z)), TuplesKt.to(SearchDestination.InnerDestination.Search.INCLUDE_RECENT_SHARED_LINKS, Boolean.valueOf(zBooleanValue)));
            composer.updateRememberedValue(objRememberedValue3);
        }
        Bundle bundle = (Bundle) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchViewModels searchViewModels = (SearchViewModels) function2.invoke(composer, 0);
        Object[] objArr = new Object[0];
        ComposerKt.sourceInformationMarkerStart(composer, 1873487716, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$1$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue4, composer, 48);
        Object[] objArr2 = new Object[0];
        ComposerKt.sourceInformationMarkerStart(composer, 1873490660, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        Object objRememberedValue5 = composer.rememberedValue();
        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function0() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$4$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue5, composer, 48);
        Object[] objArr3 = new Object[0];
        ComposerKt.sourceInformationMarkerStart(composer, 1873493724, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        Object objRememberedValue6 = composer.rememberedValue();
        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new Function0() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$7$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue6, composer, 48);
        Store<SearchReducer.State, SearchReducer.Action> store = searchViewModels.getSearchViewModel().invoke(bundle, composer, 0).getStore();
        ComposerKt.sourceInformationMarkerStart(composer, 1873516371, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(searchNavigator);
        Object objRememberedValue7 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue7 = new Function2() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$10$0(searchNavigator, (ItemModel) obj, (String) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        }
        Function2 function3 = (Function2) objRememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1873530353, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(searchNavigator);
        Object objRememberedValue8 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = new Function1() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$11$0(searchNavigator, (ItemModel) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        Function1 function1 = (Function1) objRememberedValue8;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1873524895, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance3 = composer.changedInstance(searchNavigator);
        Object objRememberedValue9 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue9 = new Function1() { // from class: com.box.android.search.navigation.compose.SearchNavigationComposeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$12$0(searchNavigator, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue9);
        }
        Function1 function4 = (Function1) objRememberedValue9;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1873537969, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChangedInstance4 = composer.changedInstance(searchNavigator);
        Object objRememberedValue10 = composer.rememberedValue();
        if (zChangedInstance4 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue10 = (Function2) new SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1(searchNavigator, null);
            composer.updateRememberedValue(objRememberedValue10);
        }
        Function2 function5 = (Function2) objRememberedValue10;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1873542521, "CC(remember):SearchNavigationCompose.kt#9igjgp");
        boolean zChanged4 = composer.changed(mutableState3) | composer.changed(mutableState) | composer.changed(mutableState2);
        Object objRememberedValue11 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue11 = (KFunction) new SearchNavigationComposeKt$searchNavigationGraph$2$1$5$1(mutableState3, mutableState, mutableState2);
            composer.updateRememberedValue(objRememberedValue11);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchScreenKt.SearchScreen(store, z2, function0, function3, function1, function4, function5, (Function2) ((KFunction) objRememberedValue11), composer, 0, 0);
        if (!searchNavigationGraph$lambda$1$0$8(mutableState3)) {
            composer.startReplaceGroup(-2054922753);
        } else {
            composer.startReplaceGroup(-2049637036);
            ComposerKt.sourceInformation(composer, "109@5498L25,106@5338L203");
            String strSearchNavigationGraph$lambda$1$0$2 = searchNavigationGraph$lambda$1$0$2(mutableState);
            String strSearchNavigationGraph$lambda$1$0$5 = searchNavigationGraph$lambda$1$0$5(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 1873550812, "CC(remember):SearchNavigationCompose.kt#9igjgp");
            boolean zChanged5 = composer.changed(mutableState) | composer.changed(mutableState2) | composer.changed(mutableState3);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = (KFunction) new SearchNavigationComposeKt$searchNavigationGraph$2$1$6$1(mutableState, mutableState2, mutableState3);
                composer.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AiCenterLauncherKt.AiCenterLauncher(strSearchNavigationGraph$lambda$1$0$2, strSearchNavigationGraph$lambda$1$0$5, (Function0) ((KFunction) objRememberedValue12), composer, 0);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
