package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.media3.common.C;
import com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt;
import com.box.android.base.presentation.components.topbar.CenterSpaceConfig;
import com.box.android.base.presentation.components.topbar.InboxButtonConfig;
import com.box.android.base.presentation.components.topbar.JobsButtonConfig;
import com.box.android.base.presentation.components.topbar.SearchButtonConfig;
import com.box.android.base.presentation.components.topbar.SettingsButtonConfig;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import com.box.android.browse.R;
import com.box.android.browse.cpl.browse.AllFilesScreenKt;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.browse.cpl.offlined.OfflinedScreenKt;
import com.box.android.browse.cpl.recents.RecentsScreenKt;
import com.box.android.cpl.Store;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseTabsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a¯\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0018H\u0002¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"BrowseTabsScreen", "", "tabDestination", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "tabsViewModels", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsViewModels;", "navigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "homeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onInnerTabChanged", "Lkotlin/Function1;", "", "onNavigateToSettings", "Lkotlin/Function0;", "onNavigateToSearch", "onNavigateToJobs", "onNavigateToInbox", "tabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "shouldUseAiCenter", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsViewModels;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "getTitleRes", "", "browse_generalProdRelease", "currentVisibleTab"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseTabsScreenKt {

    /* JADX INFO: compiled from: BrowseTabsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.values().length];
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.RecentsTab.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.OfflinedTab.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$6(BrowseDestination.InnerDestination.TabsScreen tabsScreen, BrowseTabsViewModels browseTabsViewModels, BrowseNavigator browseNavigator, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, Function1 function1, Function0 function0, Function0 function2, Function0 function3, Function0 function4, TabsSelector tabsSelector, boolean z, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        BrowseTabsScreen(tabsScreen, browseTabsViewModels, browseNavigator, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, function1, function0, function2, function3, function4, tabsSelector, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final void BrowseTabsScreen(final BrowseDestination.InnerDestination.TabsScreen tabDestination, final BrowseTabsViewModels tabsViewModels, final BrowseNavigator navigator, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, final BoxMessageDispatcher boxMessageDispatcher, final SnackbarHostState snackbarHostState, final Function1<? super String, Unit> onInnerTabChanged, final Function0<Unit> onNavigateToSettings, final Function0<Unit> onNavigateToSearch, final Function0<Unit> onNavigateToJobs, final Function0<Unit> onNavigateToInbox, TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector, boolean z, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer composer2;
        final boolean z2;
        final Modifier modifier2;
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector2 = tabsSelector;
        Intrinsics.checkNotNullParameter(tabDestination, "tabDestination");
        Intrinsics.checkNotNullParameter(tabsViewModels, "tabsViewModels");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(homeScreenViewsVisibilityState, "homeScreenViewsVisibilityState");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onInnerTabChanged, "onInnerTabChanged");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(onNavigateToSearch, "onNavigateToSearch");
        Intrinsics.checkNotNullParameter(onNavigateToJobs, "onNavigateToJobs");
        Intrinsics.checkNotNullParameter(onNavigateToInbox, "onNavigateToInbox");
        Composer composerStartRestartGroup = composer.startRestartGroup(2004541543);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BrowseTabsScreen)N(tabDestination,tabsViewModels,navigator,homeScreenViewsVisibilityState,boxMessageDispatcher,snackbarHostState,onInnerTabChanged,onNavigateToSettings,onNavigateToSearch,onNavigateToJobs,onNavigateToInbox,tabsSelector,shouldUseAiCenter,modifier)59@3266L89,62@3391L11,66@3487L1289,97@4821L73,97@4806L88,101@4947L3784,65@3440L5291:BrowseTabsScreen.kt#bta42d");
        if ((i & 6) == 0) {
            i4 = i | (composerStartRestartGroup.changedInstance(tabDestination) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(tabsViewModels) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(navigator) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(homeScreenViewsVisibilityState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(snackbarHostState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onInnerTabChanged) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onNavigateToSettings) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onNavigateToSearch) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onNavigateToJobs) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i9 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(onNavigateToInbox) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i10 = i3 & 2048;
        if (i10 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= (i2 & 64) == 0 ? composerStartRestartGroup.changed(tabsSelector2) : composerStartRestartGroup.changedInstance(tabsSelector2) ? 32 : 16;
        }
        int i11 = i5;
        int i12 = i3 & 4096;
        if (i12 != 0) {
            i7 = i11 | 384;
            i6 = i2;
        } else {
            i6 = i2;
            int i13 = i11;
            if ((i6 & 384) == 0) {
                i13 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            i7 = i13;
        }
        int i14 = i3 & 8192;
        if (i14 != 0) {
            i8 = i7 | 3072;
        } else {
            int i15 = i7;
            if ((i6 & 3072) == 0) {
                i15 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            i8 = i15;
        }
        if (!composerStartRestartGroup.shouldExecute(((i9 & 306783379) == 306783378 && (i8 & 1171) == 1170) ? false : true, i9 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z2 = z;
            modifier2 = modifier;
        } else {
            TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector3 = i10 != 0 ? null : tabsSelector2;
            final boolean z3 = i12 != 0 ? false : z;
            Modifier modifier3 = i14 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2004541543, i9, i8, "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreen (BrowseTabsScreen.kt:58)");
            }
            BrowseDestination.InnerDestination.TabsScreen.BrowseTab startTab = tabDestination.getStartTab();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2075871424, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(startTab.ordinal());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(tabDestination.getStartTab(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Store<BrowseTabsReducer.State, BrowseTabsReducer.Action> store = tabsViewModels.getViewModel().invoke(composerStartRestartGroup, 0).getStore();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1739748874, true, new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseTabsScreenKt.BrowseTabsScreen$lambda$3(tabsViewModels, store, onNavigateToSettings, onNavigateToJobs, onNavigateToInbox, onNavigateToSearch, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2075821680, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(store);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseTabsScreenKt.BrowseTabsScreen$lambda$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTrackOnVisible = AnalyticsUtilsKt.trackOnVisible(modifier3, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i8 >> 9) & 14, 1);
            WindowInsets WindowInsets = WindowInsetsKt.WindowInsets();
            tabsSelector2 = tabsSelector3;
            boolean z4 = z3;
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1600682353, true, new Function3() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5(tabDestination, homeScreenViewsVisibilityState, tabsSelector2, snackbarHostState, mutableState, onInnerTabChanged, store, navigator, boxMessageDispatcher, z3, tabsViewModels, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            composer2 = composerStartRestartGroup;
            ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar(composableLambdaRememberComposableLambda, modifierTrackOnVisible, null, WindowInsets, composableLambdaRememberComposableLambda2, composer2, 24582, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z2 = z4;
        }
        final TabsSelector<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabsSelector4 = tabsSelector2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseTabsScreenKt.BrowseTabsScreen$lambda$6(tabDestination, tabsViewModels, navigator, homeScreenViewsVisibilityState, boxMessageDispatcher, snackbarHostState, onInnerTabChanged, onNavigateToSettings, onNavigateToSearch, onNavigateToJobs, onNavigateToInbox, tabsSelector4, z2, modifier2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BrowseDestination.InnerDestination.TabsScreen.BrowseTab BrowseTabsScreen$lambda$1(MutableState<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$3(BrowseTabsViewModels browseTabsViewModels, final Store store, final Function0 function0, final Function0 function1, Function0 function2, final Function0 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@3627L21,70@3680L147,76@3944L30,79@4094L23,80@4149L143,86@4414L21,90@4591L143,67@3501L1265:BrowseTabsScreen.kt#bta42d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1739748874, i, -1, "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreen.<anonymous> (BrowseTabsScreen.kt:67)");
            }
            UserAvatarViewModel userAvatarViewModelInvoke = browseTabsViewModels.getUserAvatarViewModel().invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1156383447, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseTabsScreenKt.BrowseTabsScreen$lambda$3$0$0(store, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsButtonConfig settingsButtonConfig = new SettingsButtonConfig(userAvatarViewModelInvoke, (Function0) objRememberedValue);
            CenterSpaceConfig.TitleBarConfig titleBarConfig = new CenterSpaceConfig.TitleBarConfig(StringResources_androidKt.stringResource(R.string.files, composer, 0));
            JobsProgressViewModel jobsProgressViewModelInvoke = browseTabsViewModels.getJobsProgressViewModel().invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1156368443, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store) | composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseTabsScreenKt.BrowseTabsScreen$lambda$3$1$0(store, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobsButtonConfig jobsButtonConfig = new JobsButtonConfig(jobsProgressViewModelInvoke, (Function0) objRememberedValue2);
            InboxButtonConfig inboxButtonConfig = new InboxButtonConfig(browseTabsViewModels.getInboxCountViewModel().invoke(composer, 0), function2);
            ComposerKt.sourceInformationMarkerStart(composer, -1156354299, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged3 = composer.changed(store) | composer.changed(function3);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseTabsScreenKt.BrowseTabsScreen$lambda$3$2$0(store, function3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxPrimaryTopBarKt.BoxPrimaryTopBar(null, settingsButtonConfig, jobsButtonConfig, titleBarConfig, inboxButtonConfig, new SearchButtonConfig((Function0) objRememberedValue3), composer, (SettingsButtonConfig.$stable << 3) | (JobsButtonConfig.$stable << 6) | (CenterSpaceConfig.TitleBarConfig.$stable << 9) | (InboxButtonConfig.$stable << 12) | (SearchButtonConfig.$stable << 15), 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$3$0$0(Store store, Function0 function0) {
        store.send(BrowseTabsReducer.Action.SettingsClicked.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$3$1$0(Store store, Function0 function0) {
        store.send(BrowseTabsReducer.Action.TransferClicked.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$3$2$0(Store store, Function0 function0) {
        store.send(BrowseTabsReducer.Action.SearchClicked.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$4$0(Store store) {
        store.send(BrowseTabsReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5(BrowseDestination.InnerDestination.TabsScreen tabsScreen, final HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, TabsSelector tabsSelector, final SnackbarHostState snackbarHostState, final MutableState mutableState, final Function1 function1, final Store store, final BrowseNavigator browseNavigator, final BoxMessageDispatcher boxMessageDispatcher, final boolean z, final BrowseTabsViewModels browseTabsViewModels, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)109@5365L478,124@6003L2722,102@4974L3751:BrowseTabsScreen.kt#bta42d");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1600682353, i2, -1, "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreen.<anonymous> (BrowseTabsScreen.kt:102)");
            }
            List<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> tabs = tabsScreen.getTabs();
            BrowseDestination.InnerDestination.TabsScreen.BrowseTab startTab = tabsScreen.getStartTab();
            boolean zIsPrimaryTabRowVisible = homeScreenViewsVisibilityState.isPrimaryTabRowVisible();
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), "BrowseTabsScreen");
            Function3 function3 = new Function3() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$0((BrowseDestination.InnerDestination.TabsScreen.BrowseTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -657435411, "CC(remember):BrowseTabsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState) | composer.changed(function1) | composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$1$0(function1, store, mutableState, (BrowseDestination.InnerDestination.TabsScreen.BrowseTab) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CommonTabsScreenKt.m11833CommonTabsScreenDuhZ5jU(tabs, startTab, function3, modifierTestTag, zIsPrimaryTabRowVisible, 0, 0L, 0L, 0L, 0L, tabsSelector, snackbarHostState, (Function1) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-2008017663, true, new Function3() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2(homeScreenViewsVisibilityState, browseNavigator, boxMessageDispatcher, snackbarHostState, mutableState, store, z, browseTabsViewModels, (BrowseDestination.InnerDestination.TabsScreen.BrowseTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, TabsSelector.$stable | 24576, 9184);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BrowseTabsScreen$lambda$5$0(BrowseDestination.InnerDestination.TabsScreen.BrowseTab tab, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        composer.startReplaceGroup(910790955);
        ComposerKt.sourceInformation(composer, "CN(tab)105@5119L33:BrowseTabsScreen.kt#bta42d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(910790955, i, -1, "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreen.<anonymous>.<anonymous> (BrowseTabsScreen.kt:105)");
        }
        String strStringResource = StringResources_androidKt.stringResource(getTitleRes(tab), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strStringResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5$1$0(Function1 function1, Store store, MutableState mutableState, BrowseDestination.InnerDestination.TabsScreen.BrowseTab tab) {
        BrowseTabsReducer.Action action;
        Intrinsics.checkNotNullParameter(tab, "tab");
        mutableState.setValue(tab);
        function1.invoke(tab.name());
        int i = WhenMappings.$EnumSwitchMapping$0[tab.ordinal()];
        if (i == 1) {
            action = BrowseTabsReducer.Action.AllTabChanged.INSTANCE;
        } else if (i == 2) {
            action = BrowseTabsReducer.Action.RecentsTabChanged.INSTANCE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            action = BrowseTabsReducer.Action.OfflineTabChanged.INSTANCE;
        }
        store.send(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5$2(HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, BrowseNavigator browseNavigator, BoxMessageDispatcher boxMessageDispatcher, SnackbarHostState snackbarHostState, final MutableState mutableState, final Store store, boolean z, BrowseTabsViewModels browseTabsViewModels, final BrowseDestination.InnerDestination.TabsScreen.BrowseTab tab, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(tab, "tab");
        ComposerKt.sourceInformation(composer, "CN(tab):BrowseTabsScreen.kt#bta42d");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(tab.ordinal()) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2008017663, i2, -1, "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreen.<anonymous>.<anonymous> (BrowseTabsScreen.kt:126)");
            }
            if (BrowseTabsScreen$lambda$1(mutableState) != tab) {
                homeScreenViewsVisibilityState = null;
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[tab.ordinal()];
            if (i3 == 1) {
                composer.startReplaceGroup(-549428369);
                ComposerKt.sourceInformation(composer, "135@6571L28,136@6639L119,134@6513L271,142@6979L19,130@6274L746");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1264640035, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(mutableState) | ((i2 & 14) == 4);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$0$0(tab, mutableState));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1264637768, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AllFilesScreenKt.AllFilesScreen(browseNavigator, boxMessageDispatcher, snackbarHostState, AnalyticsUtilsKt.trackOnVisible(companion, function0, (Function0) objRememberedValue2, composer, 6, 0), homeScreenViewsVisibilityState, z, browseTabsViewModels.getAllFilesViewModel().invoke(composer, 0), composer, BoxMessageDispatcher.$stable << 3, 0);
                composer.endReplaceGroup();
            } else if (i3 == 2) {
                composer.startReplaceGroup(-547780595);
                ComposerKt.sourceInformation(composer, "169@8231L28,170@8299L123,168@8173L275,176@8643L18,164@7935L748");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1264586915, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(mutableState) | ((i2 & 14) == 4);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$4$0(tab, mutableState));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1264584644, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged4 = composer.changed(store);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$5$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                RecentsScreenKt.RecentsScreen(browseNavigator, boxMessageDispatcher, snackbarHostState, AnalyticsUtilsKt.trackOnVisible(companion2, function1, (Function0) objRememberedValue4, composer, 6, 0), homeScreenViewsVisibilityState, z, browseTabsViewModels.getRecentsViewModel().invoke(composer, 0), composer, BoxMessageDispatcher.$stable << 3, 0);
                composer.endReplaceGroup();
            } else {
                if (i3 != 3) {
                    composer.startReplaceGroup(-1264649482);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(-548605877);
                ComposerKt.sourceInformation(composer, "152@7400L28,153@7468L123,151@7342L275,159@7812L19,147@7103L750");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1264613507, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged5 = composer.changed(mutableState) | ((i2 & 14) == 4);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$2$0(tab, mutableState));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Function0 function2 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1264611236, "CC(remember):BrowseTabsScreen.kt#9igjgp");
                boolean zChanged6 = composer.changed(store);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BrowseTabsScreenKt.BrowseTabsScreen$lambda$5$2$3$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                OfflinedScreenKt.OfflinedScreen(browseNavigator, boxMessageDispatcher, snackbarHostState, AnalyticsUtilsKt.trackOnVisible(companion3, function2, (Function0) objRememberedValue6, composer, 6, 0), homeScreenViewsVisibilityState, z, browseTabsViewModels.getOfflinedViewModel().invoke(composer, 0), composer, BoxMessageDispatcher.$stable << 3, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BrowseTabsScreen$lambda$5$2$0$0(BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab, MutableState mutableState) {
        return BrowseTabsScreen$lambda$1(mutableState) == browseTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5$2$1$0(Store store) {
        store.send(BrowseTabsReducer.Action.AllTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BrowseTabsScreen$lambda$5$2$2$0(BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab, MutableState mutableState) {
        return BrowseTabsScreen$lambda$1(mutableState) == browseTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5$2$3$0(Store store) {
        store.send(BrowseTabsReducer.Action.OfflineTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BrowseTabsScreen$lambda$5$2$4$0(BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab, MutableState mutableState) {
        return BrowseTabsScreen$lambda$1(mutableState) == browseTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseTabsScreen$lambda$5$2$5$0(Store store) {
        store.send(BrowseTabsReducer.Action.RecentsTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final int getTitleRes(BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[browseTab.ordinal()];
        if (i == 1) {
            return R.string.subtitle_all_files;
        }
        if (i == 2) {
            return R.string.subtitle_recents;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.subtitle_offlined;
    }
}
