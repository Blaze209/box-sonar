package com.box.android.navigationmodernization.homescreen.navigation.compose;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.media3.common.C;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.boxai.homescreen.BoxAiNavigationComposeKt;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt;
import com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.hubs.navigationmodernization.HubsNavigationComposeKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator;
import com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0091\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001326\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"HomeScreenNavHost", "", "navigationConfigurator", "Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;", "startDestination", "", "innerNavigatorsProvider", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "navController", "Landroidx/navigation/NavHostController;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "homeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onInnerTabChanged", "Lkotlin/Function2;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "Lkotlin/ParameterName;", "name", "bottomTab", "innerTabName", "onNavigateToFilesSearch", "Lkotlin/Function0;", "onNavigateToNotesSearch", "onNavigateToSettings", "onNavigateToJobsUI", "onNavigateToInbox", "onNavigateToItem", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/preview/PreviewSource;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "browseTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/navigationmodernization/homescreen/navigation/configuration/HomeScreenNavigationConfigurator;Ljava/lang/String;Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;Landroidx/navigation/NavHostController;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/cpl/IPreviewLauncher;Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavHost$lambda$1(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, String str, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, NavHostController navHostController, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Function2 function2, Function0 function0, Function0 function1, Function0 function3, Function0 function4, Function0 function5, Function2 function6, AiCenterViewFactory aiCenterViewFactory, TabsSelector tabsSelector, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        HomeScreenNavHost(homeScreenNavigationConfigurator, str, homeScreenInnerNavigatorsProvider, navHostController, intentServices, iPreviewLauncher, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, function2, function0, function1, function3, function4, function5, function6, aiCenterViewFactory, tabsSelector, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x021d A[PHI: r24
      0x021d: PHI (r24v7 int) = (r24v1 int), (r24v4 int), (r24v5 int) binds: [B:149:0x021b, B:156:0x022f, B:155:0x022c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:151:0x0220  */
    /* JADX WARN: Code duplicated, block: B:153:0x0226  */
    /* JADX WARN: Code duplicated, block: B:155:0x022c  */
    /* JADX WARN: Code duplicated, block: B:156:0x022f  */
    /* JADX WARN: Code duplicated, block: B:163:0x024f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0259 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:167:0x025b  */
    /* JADX WARN: Code duplicated, block: B:168:0x025e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0262  */
    /* JADX WARN: Code duplicated, block: B:171:0x0269  */
    /* JADX WARN: Code duplicated, block: B:174:0x0271  */
    /* JADX WARN: Code duplicated, block: B:183:0x0299  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:187:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:196:0x02be  */
    /* JADX WARN: Code duplicated, block: B:199:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:200:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:203:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:204:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:207:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:208:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:211:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:212:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:215:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:216:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:219:0x0306  */
    /* JADX WARN: Code duplicated, block: B:220:0x0309  */
    /* JADX WARN: Code duplicated, block: B:229:0x0321  */
    /* JADX WARN: Code duplicated, block: B:232:0x032b  */
    /* JADX WARN: Code duplicated, block: B:233:0x032e  */
    /* JADX WARN: Code duplicated, block: B:236:0x0337  */
    /* JADX WARN: Code duplicated, block: B:237:0x033a  */
    /* JADX WARN: Code duplicated, block: B:244:0x0359  */
    /* JADX WARN: Code duplicated, block: B:251:0x0373  */
    /* JADX WARN: Code duplicated, block: B:254:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:256:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:259:0x03da  */
    /* JADX WARN: Code duplicated, block: B:261:? A[RETURN, SYNTHETIC] */
    public static final void HomeScreenNavHost(final HomeScreenNavigationConfigurator navigationConfigurator, final String startDestination, final HomeScreenInnerNavigatorsProvider innerNavigatorsProvider, final NavHostController navController, final IntentServices intentServices, final IPreviewLauncher previewLauncher, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, final BoxMessageDispatcher boxMessageDispatcher, final SnackbarHostState snackbarHostState, final Function2<? super HomeNavigationBarDestination, ? super String, Unit> onInnerTabChanged, final Function0<Unit> onNavigateToFilesSearch, final Function0<Unit> onNavigateToNotesSearch, final Function0<Unit> onNavigateToSettings, final Function0<Unit> onNavigateToJobsUI, final Function0<Unit> onNavigateToInbox, final Function2<? super ItemModel, ? super PreviewSource, Unit> onNavigateToItem, final AiCenterViewFactory aiCenterViewFactory, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        Composer composer2;
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector2;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector3;
        Modifier modifier3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(navigationConfigurator, "navigationConfigurator");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(innerNavigatorsProvider, "innerNavigatorsProvider");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(homeScreenViewsVisibilityState, "homeScreenViewsVisibilityState");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onInnerTabChanged, "onInnerTabChanged");
        Intrinsics.checkNotNullParameter(onNavigateToFilesSearch, "onNavigateToFilesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToNotesSearch, "onNavigateToNotesSearch");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(onNavigateToJobsUI, "onNavigateToJobsUI");
        Intrinsics.checkNotNullParameter(onNavigateToInbox, "onNavigateToInbox");
        Intrinsics.checkNotNullParameter(onNavigateToItem, "onNavigateToItem");
        Intrinsics.checkNotNullParameter(aiCenterViewFactory, "aiCenterViewFactory");
        Composer composerStartRestartGroup = composer.startRestartGroup(-768578983);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HomeScreenNavHost)N(navigationConfigurator,startDestination,innerNavigatorsProvider,navController,intentServices,previewLauncher,homeScreenViewsVisibilityState,boxMessageDispatcher,snackbarHostState,onInnerTabChanged,onNavigateToFilesSearch,onNavigateToNotesSearch,onNavigateToSettings,onNavigateToJobsUI,onNavigateToInbox,onNavigateToItem,aiCenterViewFactory,browseTabsSelector,modifier)56@2890L2910,52@2763L3037:HomeScreenNavHost.kt#lfei41");
        if ((i & 6) == 0) {
            i4 = i | (composerStartRestartGroup.changedInstance(navigationConfigurator) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(startDestination) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= (i & 512) == 0 ? composerStartRestartGroup.changed(innerNavigatorsProvider) : composerStartRestartGroup.changedInstance(innerNavigatorsProvider) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(navController) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(intentServices) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(previewLauncher) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(homeScreenViewsVisibilityState) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= (i & 16777216) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 8388608 : 4194304;
        }
        int i8 = 100663296;
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(snackbarHostState) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onInnerTabChanged) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i9 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(onNavigateToFilesSearch) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onNavigateToNotesSearch) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onNavigateToSettings) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onNavigateToJobsUI) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onNavigateToInbox) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onNavigateToItem) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            obj = aiCenterViewFactory;
            i5 |= (i2 & 2097152) == 0 ? composerStartRestartGroup.changed(obj) : composerStartRestartGroup.changedInstance(obj) ? 1048576 : 524288;
        } else {
            obj = aiCenterViewFactory;
        }
        int i10 = i3 & 131072;
        if (i10 == 0) {
            if ((i2 & 12582912) == 0) {
                i5 |= (i2 & 16777216) == 0 ? composerStartRestartGroup.changed(tabsSelector) : composerStartRestartGroup.changedInstance(tabsSelector) ? 8388608 : 4194304;
            }
            i6 = i3 & 262144;
            if (i6 == 0) {
                i5 |= i8;
            } else if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i5 |= i8;
            }
            i7 = i5;
            z = false;
            if ((i9 & 306783379) == 306783378 || (38347923 & i7) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i9 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                tabsSelector2 = tabsSelector;
                modifier2 = modifier;
            } else {
                if (i10 != 0) {
                    tabsSelector3 = null;
                } else {
                    tabsSelector3 = tabsSelector;
                }
                if (i6 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-768578983, i9, i7, "com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHost (HomeScreenNavHost.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 130010775, "CC(remember):HomeScreenNavHost.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(navigationConfigurator);
                if ((i9 & 896) != 256 || ((i9 & 512) != 0 && composerStartRestartGroup.changedInstance(innerNavigatorsProvider))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z16 = z3 | zChangedInstance;
                if ((3670016 & i9) == 1048576) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z17 = z16 | z4;
                if ((29360128 & i9) != 8388608 || ((i9 & 16777216) != 0 && composerStartRestartGroup.changedInstance(boxMessageDispatcher))) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z18 = z17 | z5;
                if ((234881024 & i9) == 67108864) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z19 = z18 | z6;
                if ((1879048192 & i9) == 536870912) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z20 = z19 | z7;
                if ((i7 & 896) == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                boolean z21 = z20 | z8;
                if ((i7 & 14) == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z22 = z21 | z9;
                if ((i7 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z23 = z22 | z10;
                if ((57344 & i7) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z24 = z23 | z11;
                if ((29360128 & i7) != 8388608 || ((i7 & 16777216) != 0 && composerStartRestartGroup.changedInstance(tabsSelector3))) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z25 = z24 | z12;
                if ((458752 & i7) == 131072) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z26 = z25 | z13;
                if ((i7 & 112) == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean zChangedInstance2 = z26 | z14 | composerStartRestartGroup.changedInstance(intentServices) | composerStartRestartGroup.changedInstance(previewLauncher);
                if ((3670016 & i7) != 1048576 || ((2097152 & i7) != 0 && composerStartRestartGroup.changedInstance(obj))) {
                    z = true;
                }
                z15 = zChangedInstance2 | z;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z15 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function1 = new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0(navigationConfigurator, innerNavigatorsProvider, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onNavigateToSettings, onNavigateToFilesSearch, onNavigateToJobsUI, onNavigateToInbox, tabsSelector3, onNavigateToNotesSearch, intentServices, previewLauncher, aiCenterViewFactory, onInnerTabChanged, onNavigateToItem, (NavGraphBuilder) obj2);
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    composer2.updateRememberedValue(function1);
                    objRememberedValue = function1;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifier4 = modifier3;
                NavHostKt.NavHost(navController, startDestination, modifier4, null, null, null, null, null, null, null, (Function1) objRememberedValue, composer2, ((i9 >> 9) & 14) | (i9 & 112) | ((i7 >> 18) & 896), 0, 1016);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
                tabsSelector2 = tabsSelector3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$1(navigationConfigurator, startDestination, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onInnerTabChanged, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector2, modifier2, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 12582912;
        i6 = i3 & 262144;
        if (i6 == 0) {
            i5 |= i8;
        } else if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(modifier)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i5 |= i8;
        }
        i7 = i5;
        z = false;
        if ((i9 & 306783379) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i9 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            tabsSelector2 = tabsSelector;
            modifier2 = modifier;
        } else {
            if (i10 != 0) {
                tabsSelector3 = null;
            } else {
                tabsSelector3 = tabsSelector;
            }
            if (i6 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768578983, i9, i7, "com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHost (HomeScreenNavHost.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 130010775, "CC(remember):HomeScreenNavHost.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(navigationConfigurator);
            if ((i9 & 896) != 256) {
                z3 = true;
            } else {
                z3 = true;
            }
            boolean z110 = z3 | zChangedInstance3;
            if ((3670016 & i9) == 1048576) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z111 = z110 | z4;
            if ((29360128 & i9) != 8388608) {
                z5 = true;
            } else {
                z5 = true;
            }
            boolean z112 = z111 | z5;
            if ((234881024 & i9) == 67108864) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z113 = z112 | z6;
            if ((1879048192 & i9) == 536870912) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z27 = z113 | z7;
            if ((i7 & 896) == 256) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z28 = z27 | z8;
            if ((i7 & 14) == 4) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z29 = z28 | z9;
            if ((i7 & 7168) == 2048) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z210 = z29 | z10;
            if ((57344 & i7) == 16384) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z211 = z210 | z11;
            if ((29360128 & i7) != 8388608) {
                z12 = true;
            } else {
                z12 = true;
            }
            boolean z212 = z211 | z12;
            if ((458752 & i7) == 131072) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z213 = z212 | z13;
            if ((i7 & 112) == 32) {
                z14 = true;
            } else {
                z14 = false;
            }
            boolean zChangedInstance4 = z213 | z14 | composerStartRestartGroup.changedInstance(intentServices) | composerStartRestartGroup.changedInstance(previewLauncher);
            if ((3670016 & i7) != 1048576) {
                z = true;
            } else {
                z = true;
            }
            z15 = zChangedInstance4 | z;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z15) {
                Function1 function2 = new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0(navigationConfigurator, innerNavigatorsProvider, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onNavigateToSettings, onNavigateToFilesSearch, onNavigateToJobsUI, onNavigateToInbox, tabsSelector3, onNavigateToNotesSearch, intentServices, previewLauncher, aiCenterViewFactory, onInnerTabChanged, onNavigateToItem, (NavGraphBuilder) obj2);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function2);
                objRememberedValue = function2;
            } else {
                Function1 function3 = new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0(navigationConfigurator, innerNavigatorsProvider, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onNavigateToSettings, onNavigateToFilesSearch, onNavigateToJobsUI, onNavigateToInbox, tabsSelector3, onNavigateToNotesSearch, intentServices, previewLauncher, aiCenterViewFactory, onInnerTabChanged, onNavigateToItem, (NavGraphBuilder) obj2);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function3);
                objRememberedValue = function3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifier5 = modifier3;
            NavHostKt.NavHost(navController, startDestination, modifier5, null, null, null, null, null, null, null, (Function1) objRememberedValue, composer2, ((i9 >> 9) & 14) | (i9 & 112) | ((i7 >> 18) & 896), 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
            tabsSelector2 = tabsSelector3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return HomeScreenNavHostKt.HomeScreenNavHost$lambda$1(navigationConfigurator, startDestination, innerNavigatorsProvider, navController, intentServices, previewLauncher, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onInnerTabChanged, onNavigateToFilesSearch, onNavigateToNotesSearch, onNavigateToSettings, onNavigateToJobsUI, onNavigateToInbox, onNavigateToItem, aiCenterViewFactory, tabsSelector2, modifier2, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavHost$lambda$0$0(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, HomeScreenInnerNavigatorsProvider homeScreenInnerNavigatorsProvider, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Function0 function0, Function0 function1, Function0 function2, Function0 function3, TabsSelector tabsSelector, Function0 function4, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, AiCenterViewFactory aiCenterViewFactory, final Function2 function5, final Function2 function6, NavGraphBuilder navGraphBuilder) {
        NavGraphBuilder NavHost = navGraphBuilder;
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        for (final HomeNavigationBarDestination homeNavigationBarDestination : homeScreenNavigationConfigurator.getNavigationBarGraphs()) {
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
                BrowseNavigationComposeKt.browseNavigationGraph(NavHost, homeScreenNavigationConfigurator.getBrowseNavigationConfig(), homeScreenInnerNavigatorsProvider.getBrowseNavigator(), homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, (4096 & 32) != 0 ? new Function1() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BrowseNavigationComposeKt.browseNavigationGraph$lambda$0((String) obj);
                    }
                } : new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0$0$0(function5, homeNavigationBarDestination, (String) obj);
                    }
                }, function0, function1, function2, function3, (4096 & 1024) != 0 ? null : tabsSelector, (4096 & 2048) != 0 ? false : homeScreenNavigationConfigurator.getUseAiCenterForMultiDoc(), (4096 & 4096) != 0 ? new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationComposeKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseNavigationComposeKt.browseNavigationGraph$lambda$1((Composer) obj, ((Integer) obj2).intValue());
                    }
                } : null);
            } else if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
                NotesNavigationComposeKt.notesNavigationGraph(navGraphBuilder, homeScreenNavigationConfigurator.getNotesNavigationConfig(), homeScreenInnerNavigatorsProvider.getNotesNavigator(), new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0$0$1(function6, (ItemModel) obj);
                    }
                }, function4, function0, snackbarHostState, (128 & 64) != 0 ? new Function1() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesNavigationComposeKt.notesNavigationGraph$lambda$0((String) obj);
                    }
                } : new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavHostKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HomeScreenNavHostKt.HomeScreenNavHost$lambda$0$0$0$2(function5, homeNavigationBarDestination, (String) obj);
                    }
                }, (128 & 128) != 0 ? new Function2() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesNavigationComposeKt.notesNavigationGraph$lambda$1((Composer) obj, ((Integer) obj2).intValue());
                    }
                } : null);
            } else if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
                HubsNavigationComposeKt.hubsNavigationGraph(navGraphBuilder, intentServices);
            } else if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
                CollectionsNavigationComposeKt.collectionsNavigationGraph$default(navGraphBuilder, homeScreenNavigationConfigurator.getCollectionsNavigationConfig(), homeScreenInnerNavigatorsProvider.getCollectionsNavigator(), function0, null, 8, null);
            } else {
                if (!Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxAiNavigationComposeKt.boxAiNavigationGraph$default(navGraphBuilder, intentServices, iPreviewLauncher, snackbarHostState, aiCenterViewFactory, null, 16, null);
            }
            NavHost = navGraphBuilder;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavHost$lambda$0$0$0$0(Function2 function2, HomeNavigationBarDestination homeNavigationBarDestination, String tabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        function2.invoke(homeNavigationBarDestination, tabName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavHost$lambda$0$0$0$1(Function2 function2, ItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        function2.invoke(item, PreviewSource.Notes.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavHost$lambda$0$0$0$2(Function2 function2, HomeNavigationBarDestination homeNavigationBarDestination, String tabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        function2.invoke(homeNavigationBarDestination, tabName);
        return Unit.INSTANCE;
    }
}
