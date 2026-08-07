package com.box.android.navigationmodernization.homescreen;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.common.C;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityStateKt;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProvider;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavigationMappingKt;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001eH\u0007¢\u0006\u0002\u0010!\u001a%\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#2\u0006\u0010\u0006\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010&\u001a\u0016\u0010*\u001a\u0004\u0018\u00010+*\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002\u001a\u0018\u0010-\u001a\u00020.*\u0004\u0018\u00010$2\b\u0010/\u001a\u0004\u0018\u00010+H\u0002\"\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u00060²\u0006\n\u00101\u001a\u00020.X\u008a\u0084\u0002²\u0006\f\u00102\u001a\u0004\u0018\u00010$X\u008a\u0084\u0002²\u0006\f\u00103\u001a\u0004\u0018\u00010+X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u00105\u001a\u0004\u0018\u000106X\u008a\u0084\u0002"}, d2 = {"HomeScreen", "", "navigationConfigurator", "Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;", "navigator", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;", "navController", "Landroidx/navigation/NavHostController;", "innerNavigatorsProvider", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "viewModel", "Lcom/box/android/navigationmodernization/homescreen/HomeScreenViewModel;", "browseTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "onNavigateToFilesSearch", "Lkotlin/Function0;", "onNavigateToNotesSearch", "onNavigateToSettings", "onNavigateToJobsUI", "onNavigateToInbox", "onNavigateToItem", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/preview/PreviewSource;", "(Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;Landroidx/navigation/NavHostController;Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/cpl/IPreviewLauncher;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Lcom/box/android/navigationmodernization/homescreen/HomeScreenViewModel;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "currentGraphAsState", "Landroidx/compose/runtime/State;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "FAB_AREA_HEIGHT", "Landroidx/compose/ui/unit/Dp;", "F", "getStartInnerTabName", "", "configurator", "hasFab", "", "innerTabName", "box_generalProdRelease", "initialized", "currentGraph", "currentInnerTabName", "animatedSnackbarBottomPadding", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenKt {
    private static final float FAB_AREA_HEIGHT = Dp.m9687constructorimpl(80);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$14(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, HomeScreenNavigator homeScreenNavigator, NavHostController navHostController, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, HomeScreenViewModel homeScreenViewModel, TabsSelector tabsSelector, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function2 function5, int i, int i2, int i3, Composer composer, int i4) {
        HomeScreen(homeScreenNavigationConfigurator, homeScreenNavigator, navHostController, homeScreenInnerNavigatorsProvider, intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel, tabsSelector, function0, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$7(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, HomeScreenNavigator homeScreenNavigator, NavHostController navHostController, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, HomeScreenViewModel homeScreenViewModel, TabsSelector tabsSelector, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function2 function5, int i, int i2, int i3, Composer composer, int i4) {
        HomeScreen(homeScreenNavigationConfigurator, homeScreenNavigator, navHostController, homeScreenInnerNavigatorsProvider, intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel, tabsSelector, function0, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:172:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:176:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:183:0x0332  */
    /* JADX WARN: Code duplicated, block: B:184:0x033c  */
    /* JADX WARN: Code duplicated, block: B:187:0x036a  */
    /* JADX WARN: Code duplicated, block: B:191:0x037f  */
    /* JADX WARN: Code duplicated, block: B:194:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:196:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:199:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:202:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:204:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:207:0x0413  */
    /* JADX WARN: Code duplicated, block: B:211:0x041c  */
    /* JADX WARN: Code duplicated, block: B:214:0x042b  */
    /* JADX WARN: Code duplicated, block: B:215:0x042e  */
    /* JADX WARN: Code duplicated, block: B:218:0x045a  */
    /* JADX WARN: Code duplicated, block: B:219:0x0474  */
    /* JADX WARN: Code duplicated, block: B:222:0x0511  */
    /* JADX WARN: Code duplicated, block: B:228:0x0554 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void HomeScreen(final HomeScreenNavigationConfigurator navigationConfigurator, final HomeScreenNavigator navigator, final NavHostController navController, final HomeScreenInnerNavigatorsProvider innerNavigatorsProvider, final IntentServices intentServices, final IPreviewLauncher previewLauncher, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, HomeScreenViewModel homeScreenViewModel, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector, final Function0<Unit> onNavigateToFilesSearch, final Function0<Unit> onNavigateToNotesSearch, final Function0<Unit> onNavigateToSettings, final Function0<Unit> onNavigateToJobsUI, final Function0<Unit> onNavigateToInbox, final Function2<? super ItemModel, ? super PreviewSource, Unit> onNavigateToItem, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Composer composer2;
        final HomeScreenViewModel homeScreenViewModel2;
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector2;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ScopeUpdateScope scopeUpdateScope;
        HomeScreenViewModel homeScreenViewModel3;
        int i8;
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        boolean zChangedInstance;
        HomeScreenKt$HomeScreen$initialized$2$1 homeScreenKt$HomeScreen$initialized$2$1RememberedValue;
        int i9;
        State stateProduceState;
        State<HomeNavigationBarDestination> stateCurrentGraphAsState;
        final HomeScreenViewsVisibilityState homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState;
        Object objRememberedValue;
        Object objMutableStateOf$default;
        MutableState mutableState;
        HomeNavigationBarDestination homeNavigationBarDestinationHomeScreen$lambda$2;
        boolean zChanged;
        HomeNavigationBarDestination homeNavigationBarDestination;
        Composer composer3;
        Object obj;
        HomeScreenViewModel homeScreenViewModel4;
        State<HomeNavigationBarDestination> state;
        final MutableState mutableState2;
        HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$1;
        Object objRememberedValue2;
        boolean z;
        float fM9687constructorimpl;
        Composer composer4;
        Modifier.Companion companionConsumeWindowInsets;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(innerNavigatorsProvider, "innerNavigatorsProvider");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(aiCenterViewFactory, "aiCenterViewFactory");
        Intrinsics.checkNotNullParameter(onNavigateToFilesSearch, "onNavigateToFilesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToNotesSearch, "onNavigateToNotesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(onNavigateToJobsUI, "onNavigateToJobsUI");
        Intrinsics.checkNotNullParameter(onNavigateToInbox, "onNavigateToInbox");
        Intrinsics.checkNotNullParameter(onNavigateToItem, "onNavigateToItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2126972250);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HomeScreen)N(navigationConfigurator,navigator,navController,innerNavigatorsProvider,intentServices,previewLauncher,boxMessageDispatcher,aiCenterViewFactory,viewModel,browseTabsSelector,onNavigateToFilesSearch,onNavigateToNotesSearch,onNavigateToSettings,onNavigateToJobsUI,onNavigateToInbox,onNavigateToItem)81@4377L72,81@4333L116,86@4475L58,87@4575L40,88@4647L42,90@4724L188,90@4695L217,99@4972L32,105@5382L92,119@5914L6,120@5956L865,137@6846L199,145@7179L1503,107@5480L3202:HomeScreen.kt#hf0ugn");
        if ((i & 6) == 0) {
            i4 = i | (composerStartRestartGroup.changedInstance(navigationConfigurator) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(navigator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(innerNavigatorsProvider) : composerStartRestartGroup.changedInstance(innerNavigatorsProvider) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(intentServices) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(previewLauncher) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= (i & 2097152) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= (i & 16777216) == 0 ? composerStartRestartGroup.changed(aiCenterViewFactory) : composerStartRestartGroup.changedInstance(aiCenterViewFactory) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i5 = i3;
            i4 |= ((i5 & 256) == 0 && composerStartRestartGroup.changedInstance(homeScreenViewModel)) ? 67108864 : 33554432;
        } else {
            i5 = i3;
        }
        int i10 = i5 & 512;
        if (i10 != 0) {
            i10 = i10;
            i6 = i4 | 805306368;
        } else {
            if ((i & 805306368) == 0) {
                i4 |= (i & 1073741824) == 0 ? composerStartRestartGroup.changed(tabsSelector) : composerStartRestartGroup.changedInstance(tabsSelector) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            } else {
                i10 = i10;
            }
            i6 = i4;
        }
        if ((i2 & 6) == 0) {
            i7 = i2 | (composerStartRestartGroup.changedInstance(onNavigateToFilesSearch) ? 4 : 2);
        } else {
            i7 = i2;
        }
        if ((i2 & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(onNavigateToNotesSearch) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(onNavigateToSettings) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(onNavigateToJobsUI) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(onNavigateToInbox) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(onNavigateToItem) ? 131072 : 65536;
        }
        int i11 = i7;
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i11) == 74898) ? false : true, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "72@3938L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i5 & 256) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) HomeScreenViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    homeScreenViewModel3 = (HomeScreenViewModel) viewModel;
                    i6 &= -234881025;
                } else {
                    homeScreenViewModel3 = homeScreenViewModel;
                }
                if (i10 != 0) {
                    i8 = i6;
                    tabsSelector3 = null;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2126972250, i8, i11, "com.box.android.navigationmodernization.homescreen.HomeScreen (HomeScreen.kt:80)");
                }
                Boolean boolValueOf = Boolean.valueOf((boolean) r6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384128270, "CC(remember):HomeScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(navigationConfigurator);
                homeScreenKt$HomeScreen$initialized$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    i9 = i8;
                    if (homeScreenKt$HomeScreen$initialized$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i12 = (i9 << 3) & 112;
                    stateProduceState = SnapshotStateKt.produceState(boolValueOf, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$initialized$2$1RememberedValue, composerStartRestartGroup, i12 | 6);
                    stateCurrentGraphAsState = currentGraphAsState(navController, navigationConfigurator, composerStartRestartGroup, ((i9 >> 6) & 14) | i12);
                    homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState = HomeScreenViewsVisibilityStateKt.rememberHomeScreenViewsVisibilityState(false, false, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384136880, "CC(remember):HomeScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                    } else {
                        objMutableStateOf$default = objRememberedValue;
                    }
                    mutableState = (MutableState) objMutableStateOf$default;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreen$lambda$2(stateCurrentGraphAsState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384139490, "CC(remember):HomeScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateCurrentGraphAsState) | composerStartRestartGroup.changedInstance(navigationConfigurator) | composerStartRestartGroup.changedInstance(homeScreenViewModel3);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                        composer3 = composerStartRestartGroup;
                        obj = null;
                        homeScreenViewModel4 = homeScreenViewModel3;
                        HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$2 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                        state = stateCurrentGraphAsState;
                        mutableState2 = mutableState;
                        homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$2;
                        composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
                    } else {
                        homeScreenKt$HomeScreen$1$1 = objRememberedValue3;
                        composer3 = composerStartRestartGroup;
                        homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                        obj = null;
                        mutableState2 = mutableState;
                        state = stateCurrentGraphAsState;
                        homeScreenViewModel4 = homeScreenViewModel3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(homeNavigationBarDestination, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$1$1, composer3, 0);
                    if (!HomeScreen$lambda$1(stateProduceState)) {
                        final HomeScreenViewModel homeScreenViewModel5 = homeScreenViewModel4;
                        ComposerKt.sourceInformationMarkerStart(composer3, 384147270, "CC(remember):HomeScreen.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new SnackbarHostState();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final String route = HomeScreenNavigationMappingKt.toRoute(navigationConfigurator.getStartNavigationBarGraph());
                        if (homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState.isNavigationBarVisible() || HomeScreen$lambda$2(state) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (hasFab(HomeScreen$lambda$2(state), HomeScreen$lambda$4(mutableState2))) {
                            fM9687constructorimpl = FAB_AREA_HEIGHT;
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        composer4 = composer3;
                        final State<Dp> stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, null, "snackbarBottomPadding", null, composer4, 384, 10);
                        composer4.startReplaceGroup(384166275);
                        ComposerKt.sourceInformation(composer4, "*114@5744L14");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
                        if (z) {
                            companionConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer4, 6), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
                        } else {
                            companionConsumeWindowInsets = Modifier.INSTANCE;
                        }
                        Modifier modifierThen = modifierFillMaxSize$default.then(companionConsumeWindowInsets);
                        composer4.endReplaceGroup();
                        Modifier modifierTestTag = TestTagKt.testTag(modifierThen, "HomeScreen");
                        long jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer4, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                        WindowInsets WindowInsets = WindowInsetsKt.WindowInsets();
                        final State<HomeNavigationBarDestination> state2 = state;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(344368833, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return HomeScreenKt.HomeScreen$lambda$11(homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, state2, navigationConfigurator, navigator, snackbarHostState, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54);
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(655759904, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return HomeScreenKt.HomeScreen$lambda$12(snackbarHostState, stateM464animateDpAsStateAjpBEmI, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54);
                        composer2 = composer4;
                        ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag, null, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, null, 0, jM11498getAppBackground0d7_KjU, 0L, WindowInsets, ComposableLambdaKt.rememberComposableLambda(318614455, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                return HomeScreenKt.HomeScreen$lambda$13(navigationConfigurator, route, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, homeScreenViewModel5, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector3, mutableState2, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer2, 805309824, 178);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        homeScreenViewModel2 = homeScreenViewModel5;
                        tabsSelector2 = tabsSelector3;
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            return;
                        }
                        final HomeScreenViewModel homeScreenViewModel6 = homeScreenViewModel4;
                        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector4 = tabsSelector3;
                        function2 = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return HomeScreenKt.HomeScreen$lambda$7(navigationConfigurator, navigator, navController, innerNavigatorsProvider, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel6, tabsSelector4, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        };
                        scopeUpdateScope = scopeUpdateScopeEndRestartGroup;
                    }
                    scopeUpdateScope.updateScope(function2);
                }
                i9 = i8;
                homeScreenKt$HomeScreen$initialized$2$1RememberedValue = new HomeScreenKt$HomeScreen$initialized$2$1(navigationConfigurator, null);
                composerStartRestartGroup.updateRememberedValue(homeScreenKt$HomeScreen$initialized$2$1RememberedValue);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i13 = (i9 << 3) & 112;
                stateProduceState = SnapshotStateKt.produceState(boolValueOf, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$initialized$2$1RememberedValue, composerStartRestartGroup, i13 | 6);
                stateCurrentGraphAsState = currentGraphAsState(navController, navigationConfigurator, composerStartRestartGroup, ((i9 >> 6) & 14) | i13);
                homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState = HomeScreenViewsVisibilityStateKt.rememberHomeScreenViewsVisibilityState(false, false, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384136880, "CC(remember):HomeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                } else {
                    objMutableStateOf$default = objRememberedValue;
                }
                mutableState = (MutableState) objMutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreen$lambda$2(stateCurrentGraphAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384139490, "CC(remember):HomeScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCurrentGraphAsState) | composerStartRestartGroup.changedInstance(navigationConfigurator) | composerStartRestartGroup.changedInstance(homeScreenViewModel3);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                    composer3 = composerStartRestartGroup;
                    obj = null;
                    homeScreenViewModel4 = homeScreenViewModel3;
                    HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$3 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                    state = stateCurrentGraphAsState;
                    mutableState2 = mutableState;
                    homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$3;
                    composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
                } else {
                    homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                    composer3 = composerStartRestartGroup;
                    obj = null;
                    homeScreenViewModel4 = homeScreenViewModel3;
                    HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$4 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                    state = stateCurrentGraphAsState;
                    mutableState2 = mutableState;
                    homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$4;
                    composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(homeNavigationBarDestination, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$1$1, composer3, 0);
                if (!HomeScreen$lambda$1(stateProduceState)) {
                    final HomeScreenViewModel homeScreenViewModel7 = homeScreenViewModel4;
                    ComposerKt.sourceInformationMarkerStart(composer3, 384147270, "CC(remember):HomeScreen.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SnackbarHostState();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final String route2 = HomeScreenNavigationMappingKt.toRoute(navigationConfigurator.getStartNavigationBarGraph());
                    if (homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState.isNavigationBarVisible()) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (hasFab(HomeScreen$lambda$2(state), HomeScreen$lambda$4(mutableState2))) {
                        fM9687constructorimpl = FAB_AREA_HEIGHT;
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    composer4 = composer3;
                    final State stateM464animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, null, "snackbarBottomPadding", null, composer4, 384, 10);
                    composer4.startReplaceGroup(384166275);
                    ComposerKt.sourceInformation(composer4, "*114@5744L14");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
                    if (z) {
                        companionConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer4, 6), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
                    } else {
                        companionConsumeWindowInsets = Modifier.INSTANCE;
                    }
                    Modifier modifierThen2 = modifierFillMaxSize$default2.then(companionConsumeWindowInsets);
                    composer4.endReplaceGroup();
                    Modifier modifierTestTag2 = TestTagKt.testTag(modifierThen2, "HomeScreen");
                    long jM11498getAppBackground0d7_KjU2 = BoxTheme.INSTANCE.getColors(composer4, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                    WindowInsets WindowInsets2 = WindowInsetsKt.WindowInsets();
                    final State state3 = state;
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(344368833, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$11(homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, state3, navigationConfigurator, navigator, snackbarHostState2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(655759904, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$12(snackbarHostState2, stateM464animateDpAsStateAjpBEmI2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    composer2 = composer4;
                    ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag2, null, composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, null, 0, jM11498getAppBackground0d7_KjU2, 0L, WindowInsets2, ComposableLambdaKt.rememberComposableLambda(318614455, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return HomeScreenKt.HomeScreen$lambda$13(navigationConfigurator, route2, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState2, homeScreenViewModel7, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector3, mutableState2, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, 805309824, 178);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    homeScreenViewModel2 = homeScreenViewModel7;
                    tabsSelector2 = tabsSelector3;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final HomeScreenViewModel homeScreenViewModel8 = homeScreenViewModel4;
                    final TabsSelector tabsSelector5 = tabsSelector3;
                    function2 = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$7(navigationConfigurator, navigator, navController, innerNavigatorsProvider, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel8, tabsSelector5, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    scopeUpdateScope = scopeUpdateScopeEndRestartGroup;
                }
                scopeUpdateScope.updateScope(function2);
            }
            composerStartRestartGroup.skipToGroupEnd();
            if ((i5 & 256) != 0) {
                i6 &= -234881025;
            }
            homeScreenViewModel3 = homeScreenViewModel;
            tabsSelector3 = tabsSelector;
            i8 = i6;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126972250, i8, i11, "com.box.android.navigationmodernization.homescreen.HomeScreen (HomeScreen.kt:80)");
            }
            Boolean boolValueOf2 = Boolean.valueOf((boolean) r6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384128270, "CC(remember):HomeScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(navigationConfigurator);
            homeScreenKt$HomeScreen$initialized$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                i9 = i8;
                if (homeScreenKt$HomeScreen$initialized$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i14 = (i9 << 3) & 112;
                stateProduceState = SnapshotStateKt.produceState(boolValueOf2, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$initialized$2$1RememberedValue, composerStartRestartGroup, i14 | 6);
                stateCurrentGraphAsState = currentGraphAsState(navController, navigationConfigurator, composerStartRestartGroup, ((i9 >> 6) & 14) | i14);
                homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState = HomeScreenViewsVisibilityStateKt.rememberHomeScreenViewsVisibilityState(false, false, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384136880, "CC(remember):HomeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                } else {
                    objMutableStateOf$default = objRememberedValue;
                }
                mutableState = (MutableState) objMutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreen$lambda$2(stateCurrentGraphAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384139490, "CC(remember):HomeScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCurrentGraphAsState) | composerStartRestartGroup.changedInstance(navigationConfigurator) | composerStartRestartGroup.changedInstance(homeScreenViewModel3);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                    composer3 = composerStartRestartGroup;
                    obj = null;
                    homeScreenViewModel4 = homeScreenViewModel3;
                    HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$5 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                    state = stateCurrentGraphAsState;
                    mutableState2 = mutableState;
                    homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$5;
                    composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
                } else {
                    homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                    composer3 = composerStartRestartGroup;
                    obj = null;
                    homeScreenViewModel4 = homeScreenViewModel3;
                    HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$6 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                    state = stateCurrentGraphAsState;
                    mutableState2 = mutableState;
                    homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$6;
                    composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(homeNavigationBarDestination, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$1$1, composer3, 0);
                if (!HomeScreen$lambda$1(stateProduceState)) {
                    final HomeScreenViewModel homeScreenViewModel9 = homeScreenViewModel4;
                    ComposerKt.sourceInformationMarkerStart(composer3, 384147270, "CC(remember):HomeScreen.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SnackbarHostState();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    final SnackbarHostState snackbarHostState3 = (SnackbarHostState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final String route3 = HomeScreenNavigationMappingKt.toRoute(navigationConfigurator.getStartNavigationBarGraph());
                    if (homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState.isNavigationBarVisible()) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (hasFab(HomeScreen$lambda$2(state), HomeScreen$lambda$4(mutableState2))) {
                        fM9687constructorimpl = FAB_AREA_HEIGHT;
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    composer4 = composer3;
                    final State stateM464animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, null, "snackbarBottomPadding", null, composer4, 384, 10);
                    composer4.startReplaceGroup(384166275);
                    ComposerKt.sourceInformation(composer4, "*114@5744L14");
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
                    if (z) {
                        companionConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer4, 6), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
                    } else {
                        companionConsumeWindowInsets = Modifier.INSTANCE;
                    }
                    Modifier modifierThen3 = modifierFillMaxSize$default3.then(companionConsumeWindowInsets);
                    composer4.endReplaceGroup();
                    Modifier modifierTestTag3 = TestTagKt.testTag(modifierThen3, "HomeScreen");
                    long jM11498getAppBackground0d7_KjU3 = BoxTheme.INSTANCE.getColors(composer4, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                    WindowInsets WindowInsets3 = WindowInsetsKt.WindowInsets();
                    final State state4 = state;
                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(344368833, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$11(homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, state4, navigationConfigurator, navigator, snackbarHostState3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(655759904, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$12(snackbarHostState3, stateM464animateDpAsStateAjpBEmI3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54);
                    composer2 = composer4;
                    ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag3, null, composableLambdaRememberComposableLambda5, composableLambdaRememberComposableLambda6, null, 0, jM11498getAppBackground0d7_KjU3, 0L, WindowInsets3, ComposableLambdaKt.rememberComposableLambda(318614455, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return HomeScreenKt.HomeScreen$lambda$13(navigationConfigurator, route3, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState3, homeScreenViewModel9, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector3, mutableState2, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, 805309824, 178);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    homeScreenViewModel2 = homeScreenViewModel9;
                    tabsSelector2 = tabsSelector3;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final HomeScreenViewModel homeScreenViewModel10 = homeScreenViewModel4;
                    final TabsSelector tabsSelector6 = tabsSelector3;
                    function2 = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeScreenKt.HomeScreen$lambda$7(navigationConfigurator, navigator, navController, innerNavigatorsProvider, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel10, tabsSelector6, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    scopeUpdateScope = scopeUpdateScopeEndRestartGroup;
                }
                scopeUpdateScope.updateScope(function2);
            }
            i9 = i8;
            homeScreenKt$HomeScreen$initialized$2$1RememberedValue = new HomeScreenKt$HomeScreen$initialized$2$1(navigationConfigurator, null);
            composerStartRestartGroup.updateRememberedValue(homeScreenKt$HomeScreen$initialized$2$1RememberedValue);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i15 = (i9 << 3) & 112;
            stateProduceState = SnapshotStateKt.produceState(boolValueOf2, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$initialized$2$1RememberedValue, composerStartRestartGroup, i15 | 6);
            stateCurrentGraphAsState = currentGraphAsState(navController, navigationConfigurator, composerStartRestartGroup, ((i9 >> 6) & 14) | i15);
            homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState = HomeScreenViewsVisibilityStateKt.rememberHomeScreenViewsVisibilityState(false, false, composerStartRestartGroup, 0, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384136880, "CC(remember):HomeScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue;
            }
            mutableState = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreen$lambda$2(stateCurrentGraphAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 384139490, "CC(remember):HomeScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCurrentGraphAsState) | composerStartRestartGroup.changedInstance(navigationConfigurator) | composerStartRestartGroup.changedInstance(homeScreenViewModel3);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                composer3 = composerStartRestartGroup;
                obj = null;
                homeScreenViewModel4 = homeScreenViewModel3;
                HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$7 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                state = stateCurrentGraphAsState;
                mutableState2 = mutableState;
                homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$7;
                composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
            } else {
                homeNavigationBarDestination = homeNavigationBarDestinationHomeScreen$lambda$2;
                composer3 = composerStartRestartGroup;
                obj = null;
                homeScreenViewModel4 = homeScreenViewModel3;
                HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$8 = new HomeScreenKt$HomeScreen$1$1(navigationConfigurator, stateCurrentGraphAsState, mutableState, homeScreenViewModel4, null);
                state = stateCurrentGraphAsState;
                mutableState2 = mutableState;
                homeScreenKt$HomeScreen$1$1 = homeScreenKt$HomeScreen$1$8;
                composer3.updateRememberedValue(homeScreenKt$HomeScreen$1$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(homeNavigationBarDestination, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) homeScreenKt$HomeScreen$1$1, composer3, 0);
            if (!HomeScreen$lambda$1(stateProduceState)) {
                final HomeScreenViewModel homeScreenViewModel11 = homeScreenViewModel4;
                ComposerKt.sourceInformationMarkerStart(composer3, 384147270, "CC(remember):HomeScreen.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SnackbarHostState();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                final SnackbarHostState snackbarHostState4 = (SnackbarHostState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final String route4 = HomeScreenNavigationMappingKt.toRoute(navigationConfigurator.getStartNavigationBarGraph());
                if (homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState.isNavigationBarVisible()) {
                    z = true;
                } else {
                    z = true;
                }
                if (hasFab(HomeScreen$lambda$2(state), HomeScreen$lambda$4(mutableState2))) {
                    fM9687constructorimpl = FAB_AREA_HEIGHT;
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                composer4 = composer3;
                final State stateM464animateDpAsStateAjpBEmI4 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, null, "snackbarBottomPadding", null, composer4, 384, 10);
                composer4.startReplaceGroup(384166275);
                ComposerKt.sourceInformation(composer4, "*114@5744L14");
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
                if (z) {
                    companionConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer4, 6), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
                } else {
                    companionConsumeWindowInsets = Modifier.INSTANCE;
                }
                Modifier modifierThen4 = modifierFillMaxSize$default4.then(companionConsumeWindowInsets);
                composer4.endReplaceGroup();
                Modifier modifierTestTag4 = TestTagKt.testTag(modifierThen4, "HomeScreen");
                long jM11498getAppBackground0d7_KjU4 = BoxTheme.INSTANCE.getColors(composer4, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                WindowInsets WindowInsets4 = WindowInsetsKt.WindowInsets();
                final State state5 = state;
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(344368833, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HomeScreenKt.HomeScreen$lambda$11(homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, state5, navigationConfigurator, navigator, snackbarHostState4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(655759904, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HomeScreenKt.HomeScreen$lambda$12(snackbarHostState4, stateM464animateDpAsStateAjpBEmI4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer4, 54);
                composer2 = composer4;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag4, null, composableLambdaRememberComposableLambda7, composableLambdaRememberComposableLambda8, null, 0, jM11498getAppBackground0d7_KjU4, 0L, WindowInsets4, ComposableLambdaKt.rememberComposableLambda(318614455, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return HomeScreenKt.HomeScreen$lambda$13(navigationConfigurator, route4, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityStateRememberHomeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState4, homeScreenViewModel11, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector3, mutableState2, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, 805309824, 178);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                homeScreenViewModel2 = homeScreenViewModel11;
                tabsSelector2 = tabsSelector3;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final HomeScreenViewModel homeScreenViewModel12 = homeScreenViewModel4;
                final TabsSelector tabsSelector7 = tabsSelector3;
                function2 = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HomeScreenKt.HomeScreen$lambda$7(navigationConfigurator, navigator, navController, innerNavigatorsProvider, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel12, tabsSelector7, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                scopeUpdateScope = scopeUpdateScopeEndRestartGroup;
            }
            scopeUpdateScope.updateScope(function2);
        }
        composer2 = composerStartRestartGroup;
        composer2.skipToGroupEnd();
        homeScreenViewModel2 = homeScreenViewModel;
        tabsSelector2 = tabsSelector;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            function2 = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return HomeScreenKt.HomeScreen$lambda$14(navigationConfigurator, navigator, navController, innerNavigatorsProvider, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, homeScreenViewModel2, tabsSelector2, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            scopeUpdateScope = scopeUpdateScopeEndRestartGroup2;
            scopeUpdateScope.updateScope(function2);
        }
    }

    private static final String HomeScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$11(HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, final State state, final HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, final HomeScreenNavigator homeScreenNavigator, final SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C126@6410L401,122@6076L735:HomeScreen.kt#hf0ugn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(344368833, i, -1, "com.box.android.navigationmodernization.homescreen.HomeScreen.<anonymous> (HomeScreen.kt:121)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(homeScreenViewsVisibilityState.isNavigationBarVisible() && HomeScreen$lambda$2(state) != null, (Modifier) null, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null), Alignment.INSTANCE.getBottom(), false, null, 12, null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null), Alignment.INSTANCE.getBottom(), false, null, 12, null), (String) null, ComposableLambdaKt.rememberComposableLambda(212367593, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HomeScreenKt.HomeScreen$lambda$11$0(homeScreenNavigationConfigurator, homeScreenNavigator, state, snackbarHostState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$11$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, final HomeScreenNavigator homeScreenNavigator, State state, final SnackbarHostState snackbarHostState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C130@6622L157,127@6428L369:HomeScreen.kt#hf0ugn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(212367593, i, -1, "com.box.android.navigationmodernization.homescreen.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:127)");
        }
        HomeNavigationBarDestination homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreen$lambda$2(state);
        List<HomeNavigationBarDestination> navigationBarGraphs = homeScreenNavigationConfigurator.getNavigationBarGraphs();
        ComposerKt.sourceInformationMarkerStart(composer, -2073166394, "CC(remember):HomeScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(homeScreenNavigator);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HomeScreenKt.HomeScreen$lambda$11$0$0$0(homeScreenNavigator, snackbarHostState, (HomeNavigationBarDestination) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        HomeScreenNavigationBarKt.HomeScreenNavigationBar(homeNavigationBarDestinationHomeScreen$lambda$2, navigationBarGraphs, (Function1) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$11$0$0$0(HomeScreenNavigator homeScreenNavigator, SnackbarHostState snackbarHostState, HomeNavigationBarDestination graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        homeScreenNavigator.navigateTo(graph);
        SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
        if (currentSnackbarData != null) {
            currentSnackbarData.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$12(SnackbarHostState snackbarHostState, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C138@6860L175:HomeScreen.kt#hf0ugn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(655759904, i, -1, "com.box.android.navigationmodernization.homescreen.HomeScreen.<anonymous> (HomeScreen.kt:138)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, HomeScreen$lambda$9(state), 7, null), composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$13(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, String str, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, NavHostController navHostController, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, final HomeScreenViewModel homeScreenViewModel, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function2 function5, AiCenterViewFactory aiCenterViewFactory, TabsSelector tabsSelector, final MutableState mutableState, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)146@7200L1476:HomeScreen.kt#hf0ugn");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(padding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(318614455, i2, -1, "com.box.android.navigationmodernization.homescreen.HomeScreen.<anonymous> (HomeScreen.kt:146)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -517223894, "C161@7918L179,151@7326L1261,175@8601L65:HomeScreen.kt#hf0ugn");
            ComposerKt.sourceInformationMarkerStart(composer, -1263592848, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(homeScreenViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.box.android.navigationmodernization.homescreen.HomeScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HomeScreenKt.HomeScreen$lambda$13$0$0$0(homeScreenViewModel, mutableState, (HomeNavigationBarDestination) obj, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            HomeScreenNavHostKt.HomeScreenNavHost(homeScreenNavigationConfigurator, str, homeScreenInnerNavigatorsProvider, navHostController, intentServices, iPreviewLauncher, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, (Function2) objRememberedValue, function0, function1, function2, function3, function4, function5, aiCenterViewFactory, tabsSelector, null, composer, (((BrowseNavigator.$stable | CollectionsNavigator.$stable) | NotesNavigator.$stable) << 6) | 100663296 | (BoxMessageDispatcher.$stable << 21), (AiCenterViewFactory.$stable << 18) | (TabsSelector.$stable << 21), 262144);
            AppUpdateProposalComponentKt.AppUpdateProposalComponent(snackbarHostState, null, composer, 6, 2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$13$0$0$0(HomeScreenViewModel homeScreenViewModel, MutableState mutableState, HomeNavigationBarDestination bottomTabRoute, String innerTabName) {
        Intrinsics.checkNotNullParameter(bottomTabRoute, "bottomTabRoute");
        Intrinsics.checkNotNullParameter(innerTabName, "innerTabName");
        mutableState.setValue(innerTabName);
        homeScreenViewModel.saveInnerTab(bottomTabRoute, innerTabName);
        return Unit.INSTANCE;
    }

    private static final State<HomeNavigationBarDestination> currentGraphAsState(NavController navController, HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, Composer composer, int i) {
        Object next;
        ComposerKt.sourceInformationMarkerStart(composer, 1746821304, "C(currentGraphAsState)N(navController,navigationConfigurator)185@8911L30,198@9360L34:HomeScreen.kt#hf0ugn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1746821304, i, -1, "com.box.android.navigationmodernization.homescreen.currentGraphAsState (HomeScreen.kt:184)");
        }
        NavBackStackEntry navBackStackEntryCurrentGraphAsState$lambda$0 = currentGraphAsState$lambda$0(NavHostControllerKt.currentBackStackEntryAsState(navController, composer, i & 14));
        HomeNavigationBarDestination homeNavigationBarDestination = null;
        NavDestination destination = navBackStackEntryCurrentGraphAsState$lambda$0 != null ? navBackStackEntryCurrentGraphAsState$lambda$0.getDestination() : null;
        List<HomeNavigationBarDestination> navigationBarGraphs = homeScreenNavigationConfigurator.getNavigationBarGraphs();
        if (destination != null) {
            for (NavDestination navDestination : NavDestination.INSTANCE.getHierarchy(destination)) {
                Iterator<T> it = navigationBarGraphs.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(navDestination.getRoute(), HomeScreenNavigationMappingKt.toRoute((HomeNavigationBarDestination) next)));
                HomeNavigationBarDestination homeNavigationBarDestination2 = (HomeNavigationBarDestination) next;
                if (homeNavigationBarDestination2 != null) {
                    homeNavigationBarDestination = homeNavigationBarDestination2;
                    break;
                }
            }
        }
        State<HomeNavigationBarDestination> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(homeNavigationBarDestination, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberUpdatedState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getStartInnerTabName(HomeNavigationBarDestination homeNavigationBarDestination, HomeScreenNavigationConfigurator homeScreenNavigationConfigurator) {
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
            return homeScreenNavigationConfigurator.getBrowseNavigationConfig().getStartDestination().getStartTab().name();
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
            return homeScreenNavigationConfigurator.getNotesNavigationConfig().getStartDestination().getStartTab().name();
        }
        return null;
    }

    private static final boolean hasFab(HomeNavigationBarDestination homeNavigationBarDestination, String str) {
        if (homeNavigationBarDestination instanceof HomeNavigationBarDestination.Browse) {
            return Intrinsics.areEqual(str, "AllFilesTab");
        }
        if (homeNavigationBarDestination instanceof HomeNavigationBarDestination.Notes) {
            return Intrinsics.areEqual(str, "RecentsTab");
        }
        return false;
    }

    private static final boolean HomeScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeNavigationBarDestination HomeScreen$lambda$2(State<? extends HomeNavigationBarDestination> state) {
        return state.getValue();
    }

    private static final float HomeScreen$lambda$9(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    private static final NavBackStackEntry currentGraphAsState$lambda$0(State<NavBackStackEntry> state) {
        return state.getValue();
    }
}
