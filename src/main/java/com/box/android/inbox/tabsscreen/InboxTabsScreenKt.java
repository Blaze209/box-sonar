package com.box.android.inbox.tabsscreen;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.LiveData;
import androidx.media3.common.C;
import com.box.android.R;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.presentation.components.tabscreen.TabBadgeData;
import com.box.android.base.presentation.components.tabscreen.TabsSelector;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.fragments.boxitem.MyTasksScreenKt;
import com.box.android.fragments.boxitem.SentTasksScreenKt;
import com.box.android.inbox.InboxDestination;
import com.box.android.inbox.notifications.NotificationsScreenKt;
import com.box.android.utils.InboxBadgeTextFormatter;
import com.box.android.vm.InboxBadgeVM;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u009f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001aH\u0002¨\u0006 ²\u0006\f\u0010!\u001a\u0004\u0018\u00010\u001fX\u008a\u0084\u0002²\u0006\u0012\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"InboxTabsScreen", "", "tabDestination", "Lcom/box/android/inbox/InboxDestination$TabsScreen;", "tabsViewModels", "Lcom/box/android/inbox/tabsscreen/InboxTabsViewModels;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "onNavigateToTask", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/ItemModel;", "Lkotlin/ParameterName;", "name", "itemModel", "Lcom/box/android/domain/models/preview/PreviewSource;", "source", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onNavigateBack", "Lkotlin/Function0;", "tabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/inbox/InboxDestination$TabsScreen;Lcom/box/android/inbox/tabsscreen/InboxTabsViewModels;Lcom/box/android/base/compose/ComposeFragmentInjector;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getTitleRes", "", "box_generalProdRelease", "unseenCount", "taskBadgeResponse", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/boxandroidlibv2private/model/BoxTaskBadge;", "currentVisibleTab"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxTabsScreenKt {

    /* JADX INFO: compiled from: InboxTabsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InboxDestination.TabsScreen.InboxTab.values().length];
            try {
                iArr[InboxDestination.TabsScreen.InboxTab.Notifications.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InboxDestination.TabsScreen.InboxTab.MyTasks.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InboxDestination.TabsScreen.InboxTab.SentTasks.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$10(InboxDestination.TabsScreen tabsScreen, InboxTabsViewModels inboxTabsViewModels, ComposeFragmentInjector composeFragmentInjector, IntentServices intentServices, IUserContextManager iUserContextManager, Function2 function2, SnackbarHostState snackbarHostState, Function0 function0, TabsSelector tabsSelector, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxTabsScreen(tabsScreen, inboxTabsViewModels, composeFragmentInjector, intentServices, iUserContextManager, function2, snackbarHostState, function0, tabsSelector, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void InboxTabsScreen(final InboxDestination.TabsScreen tabDestination, final InboxTabsViewModels tabsViewModels, final ComposeFragmentInjector composeFragmentInjector, final IntentServices intentServices, final IUserContextManager userContextManager, final Function2<? super ItemModel, ? super PreviewSource, Unit> onNavigateToTask, final SnackbarHostState snackbarHostState, final Function0<Unit> onNavigateBack, TabsSelector<InboxDestination.TabsScreen.InboxTab> tabsSelector, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final TabsSelector<InboxDestination.TabsScreen.InboxTab> tabsSelector2;
        final Modifier modifier2;
        final String badgeText;
        BoxTaskBadge boxTaskBadge;
        Intrinsics.checkNotNullParameter(tabDestination, "tabDestination");
        Intrinsics.checkNotNullParameter(tabsViewModels, "tabsViewModels");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(onNavigateToTask, "onNavigateToTask");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(1201291716);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxTabsScreen)N(tabDestination,tabsViewModels,composeFragmentInjector,intentServices,userContextManager,onNavigateToTask,snackbarHostState,onNavigateBack,tabsSelector,modifier)53@2579L11,55@2661L21,56@2751L30,57@2870L44,60@2940L45,60@2919L66,68@3315L89,79@3676L72,79@3661L87,72@3436L195,83@3801L2461,71@3409L2853:InboxTabsScreen.kt#iahda9");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(tabDestination) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(tabsViewModels) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intentServices) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(userContextManager) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToTask) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateBack) ? 8388608 : 4194304;
        }
        int i4 = i2 & 256;
        int i5 = 100663296;
        if (i4 != 0) {
            i3 |= i5;
        } else if ((i & 100663296) == 0) {
            i5 = (i & C.BUFFER_FLAG_FIRST_SAMPLE) == 0 ? composerStartRestartGroup.changed(tabsSelector) : composerStartRestartGroup.changedInstance(tabsSelector) ? 67108864 : 33554432;
            i3 |= i5;
        }
        int i6 = i2 & 512;
        if (i6 != 0) {
            i3 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            tabsSelector2 = tabsSelector;
            modifier2 = modifier;
        } else {
            TabsSelector<InboxDestination.TabsScreen.InboxTab> tabsSelector3 = i4 != 0 ? null : tabsSelector;
            Modifier modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1201291716, i3, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen (InboxTabsScreen.kt:52)");
            }
            final Store<InboxTabsReducer.State, InboxTabsReducer.Action> store = tabsViewModels.getViewModel().invoke(composerStartRestartGroup, 0).getStore();
            InboxBadgeVM inboxBadgeVMInvoke = tabsViewModels.getInboxBadgeViewModel().invoke(composerStartRestartGroup, 0);
            LiveData<Integer> notificationCountLiveData = inboxBadgeVMInvoke.getNotificationCountLiveData();
            Intrinsics.checkNotNullExpressionValue(notificationCountLiveData, "getNotificationCountLiveData(...)");
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(notificationCountLiveData, null, composerStartRestartGroup, 48);
            LiveData<BoxResponse<BoxTaskBadge>> taskBadgeLiveData = inboxBadgeVMInvoke.getTaskBadgeLiveData();
            final TabsSelector<InboxDestination.TabsScreen.InboxTab> tabsSelector4 = tabsSelector3;
            Intrinsics.checkNotNullExpressionValue(taskBadgeLiveData, "getTaskBadgeLiveData(...)");
            State stateObserveAsState2 = LiveDataAdapterKt.observeAsState(taskBadgeLiveData, null, composerStartRestartGroup, 48);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -904835247, "CC(remember):InboxTabsScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(inboxBadgeVMInvoke);
            InboxTabsScreenKt$InboxTabsScreen$1$1 inboxTabsScreenKt$InboxTabsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || inboxTabsScreenKt$InboxTabsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                inboxTabsScreenKt$InboxTabsScreen$1$1RememberedValue = new InboxTabsScreenKt$InboxTabsScreen$1$1(inboxBadgeVMInvoke, null);
                composerStartRestartGroup.updateRememberedValue(inboxTabsScreenKt$InboxTabsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxTabsScreenKt$InboxTabsScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            Integer numInboxTabsScreen$lambda$0 = InboxTabsScreen$lambda$0(stateObserveAsState);
            final String badgeText2 = InboxBadgeTextFormatter.formatBadgeText(numInboxTabsScreen$lambda$0 != null ? numInboxTabsScreen$lambda$0.intValue() : 0, false);
            BoxResponse<BoxTaskBadge> boxResponseInboxTabsScreen$lambda$1 = InboxTabsScreen$lambda$1(stateObserveAsState2);
            if (boxResponseInboxTabsScreen$lambda$1 == null || (boxTaskBadge = (BoxTaskBadge) boxResponseInboxTabsScreen$lambda$1.getResult()) == null) {
                badgeText = null;
            } else {
                Integer count = boxTaskBadge.getCount();
                badgeText = InboxBadgeTextFormatter.formatBadgeText(count != null ? count.intValue() : 0, Intrinsics.areEqual((Object) boxTaskBadge.hasMore(), (Object) true));
            }
            InboxDestination.TabsScreen.InboxTab startTab = tabDestination.getStartTab();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -904823203, "CC(remember):InboxTabsScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(startTab.ordinal());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(tabDestination.getStartTab(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -904811668, "CC(remember):InboxTabsScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(store);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxTabsScreenKt.InboxTabsScreen$lambda$7$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier4 = modifier3;
            ScaffoldKt.m4038ScaffoldTvnljyQ(AnalyticsUtilsKt.trackOnVisible(modifier3, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i3 >> 27) & 14, 1), ComposableLambdaKt.rememberComposableLambda(-1764474488, true, new Function2() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$8(onNavigateBack, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(), ComposableLambdaKt.rememberComposableLambda(352230035, true, new Function3() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$9(tabDestination, tabsSelector4, snackbarHostState, mutableState, badgeText2, badgeText, userContextManager, intentServices, store, tabsViewModels, composeFragmentInjector, onNavigateToTask, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 252);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tabsSelector2 = tabsSelector4;
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$10(tabDestination, tabsViewModels, composeFragmentInjector, intentServices, userContextManager, onNavigateToTask, snackbarHostState, onNavigateBack, tabsSelector2, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InboxDestination.TabsScreen.InboxTab InboxTabsScreen$lambda$5(MutableState<InboxDestination.TabsScreen.InboxTab> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$8(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3491L30,73@3450L171:InboxTabsScreen.kt#iahda9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1764474488, i, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen.<anonymous> (InboxTabsScreen.kt:73)");
            }
            BoxSimpleTopBarKt.BoxSimpleTopBar(StringResources_androidKt.stringResource(R.string.Inbox, composer, 6), function0, null, true, null, composer, 3072, 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$7$0(Store store) {
        store.send(InboxTabsReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9(InboxDestination.TabsScreen tabsScreen, TabsSelector tabsSelector, final SnackbarHostState snackbarHostState, final MutableState mutableState, final String str, final String str2, final IUserContextManager iUserContextManager, final IntentServices intentServices, final Store store, final InboxTabsViewModels inboxTabsViewModels, final ComposeFragmentInjector composeFragmentInjector, final Function2 function2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)105@4683L26,109@4837L1419,84@3828L2428:InboxTabsScreen.kt#iahda9");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352230035, i2, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen.<anonymous> (InboxTabsScreen.kt:84)");
            }
            List<InboxDestination.TabsScreen.InboxTab> tabs = tabsScreen.getTabs();
            InboxDestination.TabsScreen.InboxTab startTab = tabsScreen.getStartTab();
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.padding(Modifier.INSTANCE, paddingValues), "InboxTabsScreen");
            Function3 function3 = new Function3() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$9$0((InboxDestination.TabsScreen.InboxTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -809324499, "CC(remember):InboxTabsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InboxTabsScreenKt.InboxTabsScreen$lambda$9$1$0(mutableState, (InboxDestination.TabsScreen.InboxTab) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CommonTabsScreenKt.m11833CommonTabsScreenDuhZ5jU(tabs, startTab, function3, modifierTestTag, false, 0, 0L, 0L, 0L, 0L, tabsSelector, snackbarHostState, (Function1) objRememberedValue, new Function3() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$9$2(str, str2, (InboxDestination.TabsScreen.InboxTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, ComposableLambdaKt.rememberComposableLambda(974056199, true, new Function3() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxTabsScreenKt.InboxTabsScreen$lambda$9$3(iUserContextManager, intentServices, mutableState, store, inboxTabsViewModels, composeFragmentInjector, function2, snackbarHostState, (InboxDestination.TabsScreen.InboxTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, TabsSelector.$stable | 24576, 1008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String InboxTabsScreen$lambda$9$0(InboxDestination.TabsScreen.InboxTab tab, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        composer.startReplaceGroup(611256465);
        ComposerKt.sourceInformation(composer, "CN(tab)87@3973L33:InboxTabsScreen.kt#iahda9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611256465, i, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen.<anonymous>.<anonymous> (InboxTabsScreen.kt:87)");
        }
        String strStringResource = StringResources_androidKt.stringResource(getTitleRes(tab), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strStringResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TabBadgeData InboxTabsScreen$lambda$9$2(String str, String str2, InboxDestination.TabsScreen.InboxTab tab, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        composer.startReplaceGroup(-436553412);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-436553412, i, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen.<anonymous>.<anonymous> (InboxTabsScreen.kt:90)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[tab.ordinal()];
        TabBadgeData tabBadgeData = null;
        if (i2 != 1) {
            if (i2 == 2 && str2 != null) {
                tabBadgeData = new TabBadgeData(str2, "TasksBadge");
            }
        } else if (str != null) {
            tabBadgeData = new TabBadgeData(str, "NotificationsBadge");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tabBadgeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9$1$0(MutableState mutableState, InboxDestination.TabsScreen.InboxTab it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9$3(IUserContextManager iUserContextManager, IntentServices intentServices, final MutableState mutableState, final Store store, InboxTabsViewModels inboxTabsViewModels, ComposeFragmentInjector composeFragmentInjector, final Function2 function2, SnackbarHostState snackbarHostState, final InboxDestination.TabsScreen.InboxTab currentTab, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(currentTab, "currentTab");
        ComposerKt.sourceInformation(composer, "CN(currentTab):InboxTabsScreen.kt#iahda9");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(currentTab.ordinal()) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(974056199, i2, -1, "com.box.android.inbox.tabsscreen.InboxTabsScreen.<anonymous>.<anonymous> (InboxTabsScreen.kt:110)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[currentTab.ordinal()];
            if (i3 == 1) {
                composer.startReplaceGroup(1309280918);
                ComposerKt.sourceInformation(composer, "116@5194L35,117@5269L128,115@5136L287,121@5476L24,112@4949L573");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -234851830, "CC(remember):InboxTabsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(mutableState) | ((i2 & 14) == 4);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(InboxTabsScreenKt.InboxTabsScreen$lambda$9$3$0$0(currentTab, mutableState));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -234849337, "CC(remember):InboxTabsScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxTabsScreenKt.InboxTabsScreen$lambda$9$3$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                NotificationsScreenKt.NotificationsScreen(iUserContextManager, intentServices, AnalyticsUtilsKt.trackOnVisible(companion, function0, (Function0) objRememberedValue2, composer, 6, 0), inboxTabsViewModels.getNotificationsViewModel().invoke(composer, 0), composer, 0, 0);
                composer.endReplaceGroup();
            } else if (i3 == 2) {
                composer.startReplaceGroup(1309917162);
                ComposerKt.sourceInformation(composer, "128@5733L47,126@5600L265");
                ComposerKt.sourceInformationMarkerStart(composer, -234834570, "CC(remember):InboxTabsScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(function2);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return InboxTabsScreenKt.InboxTabsScreen$lambda$9$3$2$0(function2, (ItemModel) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                MyTasksScreenKt.MyTasksScreen(composeFragmentInjector, (Function1) objRememberedValue3, snackbarHostState, null, composer, 0, 8);
                composer.endReplaceGroup();
            } else {
                if (i3 != 3) {
                    composer.startReplaceGroup(-234861012);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1310259526);
                ComposerKt.sourceInformation(composer, "136@6080L49,134@5945L269");
                ComposerKt.sourceInformationMarkerStart(composer, -234823464, "CC(remember):InboxTabsScreen.kt#9igjgp");
                boolean zChanged4 = composer.changed(function2);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.inbox.tabsscreen.InboxTabsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return InboxTabsScreenKt.InboxTabsScreen$lambda$9$3$3$0(function2, (ItemModel) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SentTasksScreenKt.SentTasksScreen(composeFragmentInjector, (Function1) objRememberedValue4, snackbarHostState, null, composer, 0, 8);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean InboxTabsScreen$lambda$9$3$0$0(InboxDestination.TabsScreen.InboxTab inboxTab, MutableState mutableState) {
        return InboxTabsScreen$lambda$5(mutableState) == inboxTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9$3$1$0(Store store) {
        store.send(InboxTabsReducer.Action.NotificationsTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9$3$2$0(Function2 function2, ItemModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(it, PreviewSource.MyTasks.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxTabsScreen$lambda$9$3$3$0(Function2 function2, ItemModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(it, PreviewSource.SentTasks.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final int getTitleRes(InboxDestination.TabsScreen.InboxTab inboxTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[inboxTab.ordinal()];
        if (i == 1) {
            return R.string.notifications;
        }
        if (i == 2) {
            return R.string.my_tasks;
        }
        if (i == 3) {
            return R.string.sent_tasks;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Integer InboxTabsScreen$lambda$0(State<Integer> state) {
        return state.getValue();
    }

    private static final BoxResponse<BoxTaskBadge> InboxTabsScreen$lambda$1(State<? extends BoxResponse<BoxTaskBadge>> state) {
        return state.getValue();
    }
}
