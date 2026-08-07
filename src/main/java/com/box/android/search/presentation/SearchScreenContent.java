package com.box.android.search.presentation;

import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeFragmentInjectorImpl;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigationConfig;
import com.box.android.search.navigation.SearchNavigator;
import com.box.android.search.navigation.compose.SearchNavigationComposeKt;
import com.box.android.search.navigation.compose.SearchNavigationMappingKt;
import com.box.android.search.navigation.compose.SearchViewModels;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B|\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/search/presentation/SearchScreenContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "searchNavigationConfig", "Lcom/box/android/search/navigation/SearchNavigationConfig;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "searchViewModelsProvider", "Lkotlin/Function0;", "Lcom/box/android/search/navigation/compose/SearchViewModels;", "Landroidx/compose/runtime/Composable;", "boxSearchItemClickHandler", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "onFolderSelected", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/FolderModel;", "", "onFileSelected", "Lcom/box/android/domain/models/item/FileModel;", "aiCenterEnabled", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/search/navigation/SearchNavigationConfig;Lcom/box/android/coreservices/services/IntentServices;Lkotlin/jvm/functions/Function2;Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchScreenContent {
    public static final int $stable = 0;

    public SearchScreenContent(final FragmentActivity activity, final SearchNavigationConfig searchNavigationConfig, final IntentServices intentServices, final Function2<? super Composer, ? super Integer, SearchViewModels> searchViewModelsProvider, final BoxSearchItemClickHandler boxSearchItemClickHandler, final IItemMoreActionsHandler itemMoreActionsHandler, final Function1<? super FolderModel, Unit> function1, final Function1<? super FileModel, Unit> function2, final boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(searchNavigationConfig, "searchNavigationConfig");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(searchViewModelsProvider, "searchViewModelsProvider");
        Intrinsics.checkNotNullParameter(boxSearchItemClickHandler, "boxSearchItemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(1241402952, true, new Function2() { // from class: com.box.android.search.presentation.SearchScreenContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SearchScreenContent._init_$lambda$0(activity, intentServices, boxSearchItemClickHandler, itemMoreActionsHandler, function1, function2, searchNavigationConfig, z, searchViewModelsProvider, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    public /* synthetic */ SearchScreenContent(FragmentActivity fragmentActivity, SearchNavigationConfig searchNavigationConfig, IntentServices intentServices, Function2 function2, BoxSearchItemClickHandler boxSearchItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler, Function1 function1, Function1 function3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, searchNavigationConfig, intentServices, function2, boxSearchItemClickHandler, iItemMoreActionsHandler, (i & 64) != 0 ? null : function1, (i & 128) != 0 ? null : function3, (i & 256) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final FragmentActivity fragmentActivity, final IntentServices intentServices, final BoxSearchItemClickHandler boxSearchItemClickHandler, final IItemMoreActionsHandler iItemMoreActionsHandler, final Function1 function1, final Function1 function2, final SearchNavigationConfig searchNavigationConfig, final boolean z, final Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C180@7494L1711,180@7485L1720:SearchActivity.kt#42y6p");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1241402952, i, -1, "com.box.android.search.presentation.SearchScreenContent.<anonymous> (SearchActivity.kt:180)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1144965853, true, new Function2() { // from class: com.box.android.search.presentation.SearchScreenContent$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenContent.lambda$0$0(fragmentActivity, intentServices, boxSearchItemClickHandler, iItemMoreActionsHandler, function1, function2, searchNavigationConfig, z, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0(final FragmentActivity fragmentActivity, IntentServices intentServices, BoxSearchItemClickHandler boxSearchItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler, Function1 function1, Function1 function2, final SearchNavigationConfig searchNavigationConfig, final boolean z, final Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7532L23,182@7588L528,195@8217L11,197@8341L850,194@8134L1057:SearchActivity.kt#42y6p");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1144965853, i, -1, "com.box.android.search.presentation.SearchScreenContent.<anonymous>.<anonymous> (SearchActivity.kt:181)");
            }
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 800560493, "CC(remember):SearchActivity.kt#9igjgp");
            boolean zChanged = composer.changed(navHostControllerRememberNavController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object searchNavigator = new SearchNavigator(fragmentActivity, navHostControllerRememberNavController, intentServices, boxSearchItemClickHandler, iItemMoreActionsHandler, function1, function2);
                composer.updateRememberedValue(searchNavigator);
                objRememberedValue = searchNavigator;
            }
            final SearchNavigator searchNavigator2 = (SearchNavigator) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ScaffoldKt.m4038ScaffoldTvnljyQ(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM())), null, null, null, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(), ComposableLambdaKt.rememberComposableLambda(-1381461074, true, new Function3() { // from class: com.box.android.search.presentation.SearchScreenContent$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenContent.lambda$0$0$1(navHostControllerRememberNavController, searchNavigationConfig, searchNavigator2, fragmentActivity, z, function3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0$1(NavHostController navHostController, final SearchNavigationConfig searchNavigationConfig, final SearchNavigator searchNavigator, final FragmentActivity fragmentActivity, final boolean z, final Function2 function2, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)202@8598L575,198@8374L799:SearchActivity.kt#42y6p");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(padding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1381461074, i2, -1, "com.box.android.search.presentation.SearchScreenContent.<anonymous>.<anonymous>.<anonymous> (SearchActivity.kt:198)");
            }
            String strGraphToRoute = SearchNavigationMappingKt.graphToRoute(SearchDestination.INSTANCE);
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, padding);
            ComposerKt.sourceInformationMarkerStart(composer, -439188851, "CC(remember):SearchActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(searchNavigationConfig) | composer.changedInstance(searchNavigator) | composer.changedInstance(fragmentActivity) | composer.changed(z) | composer.changed(function2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.box.android.search.presentation.SearchScreenContent$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenContent.lambda$0$0$1$0$0(searchNavigationConfig, searchNavigator, z, function2, fragmentActivity, (NavGraphBuilder) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NavHostKt.NavHost(navHostController, strGraphToRoute, modifierPadding, null, null, null, null, null, null, null, (Function1) objRememberedValue, composer, 0, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0$1$0$0$0(FragmentActivity fragmentActivity) {
        fragmentActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0$1$0$0(SearchNavigationConfig searchNavigationConfig, SearchNavigator searchNavigator, boolean z, Function2 function2, final FragmentActivity fragmentActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        SearchNavigationComposeKt.searchNavigationGraph(NavHost, searchNavigationConfig, searchNavigator, new Function0() { // from class: com.box.android.search.presentation.SearchScreenContent$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchScreenContent.lambda$0$0$1$0$0$0(fragmentActivity);
            }
        }, new ComposeFragmentInjectorImpl(), true, z, function2);
        return Unit.INSTANCE;
    }
}
