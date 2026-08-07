package com.box.android.inbox.notifications;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.R;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.ViewInteropNestedScrollConnectionKt;
import com.box.android.base.compose.divider.BoxItemListingDividerKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.inbox.notifications.router.IInboxRouter;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxItemsList.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aK\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"InboxItemsList", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "inboxRouter", "Lcom/box/android/inbox/notifications/router/IInboxRouter;", "routingMapper", "Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;", "isRedesignedVersion", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/inbox/notifications/router/IInboxRouter;Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NotificationsWithPullToRefresh", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/inbox/notifications/router/IInboxRouter;Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;ZLandroidx/compose/runtime/Composer;I)V", "NotificationsList", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/inbox/notifications/router/IInboxRouter;Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;Landroidx/compose/runtime/Composer;I)V", "InboxLoadMoreItem", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease", "state", "shouldLoadMore"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemsListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemsList$lambda$3(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, IInboxRouter iInboxRouter, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemsList(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxLoadMoreItem$lambda$1(int i, Composer composer, int i2) {
        InboxLoadMoreItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsList$lambda$5(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, IInboxRouter iInboxRouter, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, int i, Composer composer, int i2) {
        NotificationsList(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsWithPullToRefresh$lambda$3(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, IInboxRouter iInboxRouter, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, boolean z, int i, Composer composer, int i2) {
        NotificationsWithPullToRefresh(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x0101  */
    /* JADX WARN: Code duplicated, block: B:70:0x0149  */
    /* JADX WARN: Code duplicated, block: B:72:0x014f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0159  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemsList(final Store<InboxItemsListReducer.State, InboxItemsListReducer.Action> store, final DefaultAvatarControllerWrapper avatarControllerWrapper, final IInboxRouter inboxRouter, final InboxNotificationRoutingMapper routingMapper, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier.Companion companionNestedScroll$default;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(inboxRouter, "inboxRouter");
        Intrinsics.checkNotNullParameter(routingMapper, "routingMapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1937238980);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemsList)N(store,avatarControllerWrapper,inboxRouter,routingMapper,isRedesignedVersion,modifier)56@2683L29,64@2949L1412,58@2718L1643:InboxItemsList.kt#1rb0q9");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(inboxRouter) : composerStartRestartGroup.changedInstance(inboxRouter) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(routingMapper) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1937238980, i3, -1, "com.box.android.inbox.notifications.InboxItemsList (InboxItemsList.kt:55)");
                }
                Modifier modifier4 = companion;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup.startReplaceGroup(-1965806845);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*61@2845L43");
                if (!z) {
                    companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null);
                } else {
                    companionNestedScroll$default = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifier4.then(companionNestedScroll$default);
                composerStartRestartGroup.endReplaceGroup();
                SurfaceKt.m4323SurfaceT9BRK9s(TestTagKt.testTag(modifierThen, "InboxItemsList"), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-97566783, true, new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemsListKt.InboxItemsList$lambda$2(z, store, avatarControllerWrapper, inboxRouter, routingMapper, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemsListKt.InboxItemsList$lambda$3(store, avatarControllerWrapper, inboxRouter, routingMapper, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937238980, i3, -1, "com.box.android.inbox.notifications.InboxItemsList (InboxItemsList.kt:55)");
            }
            Modifier modifier5 = companion;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup.startReplaceGroup(-1965806845);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*61@2845L43");
            if (!z) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null);
            } else {
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen2 = modifier5.then(companionNestedScroll$default);
            composerStartRestartGroup.endReplaceGroup();
            SurfaceKt.m4323SurfaceT9BRK9s(TestTagKt.testTag(modifierThen2, "InboxItemsList"), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-97566783, true, new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemsListKt.InboxItemsList$lambda$2(z, store, avatarControllerWrapper, inboxRouter, routingMapper, stateCollectAsStateWithLifecycle2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemsListKt.InboxItemsList$lambda$3(store, avatarControllerWrapper, inboxRouter, routingMapper, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemsList$lambda$2(boolean z, Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, IInboxRouter iInboxRouter, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:InboxItemsList.kt#1rb0q9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-97566783, i, -1, "com.box.android.inbox.notifications.InboxItemsList.<anonymous> (InboxItemsList.kt:65)");
            }
            InboxItemsListReducer.NotificationsState notificationsState = InboxItemsList$lambda$0(state).getNotificationsState();
            if (notificationsState instanceof InboxItemsListReducer.NotificationsState.Loading) {
                composer.startReplaceGroup(1080944872);
                ComposerKt.sourceInformation(composer, "67@3078L61,68@3197L98,68@3156L139");
                ItemStateScreensKt.LoadingItemsScreen(null, z, composer, 0, 1);
                InboxItemsListReducer.NotificationsState notificationsState2 = InboxItemsList$lambda$0(state).getNotificationsState();
                ComposerKt.sourceInformationMarkerStart(composer, 727610083, "CC(remember):InboxItemsList.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                InboxItemsListKt$InboxItemsList$2$1$1 inboxItemsListKt$InboxItemsList$2$1$1RememberedValue = composer.rememberedValue();
                if (zChanged || inboxItemsListKt$InboxItemsList$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    inboxItemsListKt$InboxItemsList$2$1$1RememberedValue = new InboxItemsListKt$InboxItemsList$2$1$1(store, null);
                    composer.updateRememberedValue(inboxItemsListKt$InboxItemsList$2$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(notificationsState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxItemsListKt$InboxItemsList$2$1$1RememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else if (notificationsState instanceof InboxItemsListReducer.NotificationsState.Error) {
                composer.startReplaceGroup(1081284508);
                ComposerKt.sourceInformation(composer, "78@3619L49,79@3704L52,74@3394L517");
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_bell140, StringResources_androidKt.stringResource(R.string.empty_notifications_text, composer, 6), StringResources_androidKt.stringResource(R.string.empty_notifications_subtext, composer, 6), null, 8, null), "ErrorNotifications", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z, 0L, composer, 432, 40);
                composer.endReplaceGroup();
            } else {
                if (!(notificationsState instanceof InboxItemsListReducer.NotificationsState.FullyLoaded)) {
                    composer.startReplaceGroup(727603765);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1081878406);
                ComposerKt.sourceInformation(composer, "87@4016L315");
                NotificationsWithPullToRefresh(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, z, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void NotificationsWithPullToRefresh(final Store<InboxItemsListReducer.State, InboxItemsListReducer.Action> store, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final IInboxRouter iInboxRouter, final InboxNotificationRoutingMapper inboxNotificationRoutingMapper, final boolean z, Composer composer, final int i) {
        int i2;
        DefaultAvatarControllerWrapper defaultAvatarControllerWrapper2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783782512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationsWithPullToRefresh)N(store,avatarControllerWrapper,inboxRouter,routingMapper,isRedesignedVersion)107@4707L28,108@4765L29,116@5002L65,110@4800L1224:InboxItemsList.kt#1rb0q9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
            i2 |= composerStartRestartGroup.changed(defaultAvatarControllerWrapper2) ? 32 : 16;
        } else {
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(iInboxRouter) : composerStartRestartGroup.changedInstance(iInboxRouter) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(inboxNotificationRoutingMapper) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783782512, i2, -1, "com.box.android.inbox.notifications.NotificationsWithPullToRefresh (InboxItemsList.kt:106)");
            }
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zIsRefreshing = NotificationsWithPullToRefresh$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -523023119, "CC(remember):InboxItemsList.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxItemsListKt.NotificationsWithPullToRefresh$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default, zIsRefreshing, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, (Function0) objRememberedValue, 12, null), "NotificationsWithPullToRefresh");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1043065940, "C138@5836L182:InboxItemsList.kt#1rb0q9");
            if (NotificationsWithPullToRefresh$lambda$0(stateCollectAsStateWithLifecycle).isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1043061353);
                ComposerKt.sourceInformation(composerStartRestartGroup, "124@5343L49,125@5424L52,121@5186L381");
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.ic_bell140, StringResources_androidKt.stringResource(R.string.empty_notifications_text, composerStartRestartGroup, 6), StringResources_androidKt.stringResource(R.string.empty_notifications_subtext, composerStartRestartGroup, 6), null, 8, null), null, z, composerStartRestartGroup, (i2 >> 6) & 896, 2);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1042658663);
                ComposerKt.sourceInformation(composerStartRestartGroup, "130@5597L219");
                NotificationsList(store, defaultAvatarControllerWrapper2, iInboxRouter, inboxNotificationRoutingMapper, composerStartRestartGroup, i2 & 8190);
                composerStartRestartGroup.endReplaceGroup();
            }
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState, NotificationsWithPullToRefresh$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing(), boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemsListKt.NotificationsWithPullToRefresh$lambda$3(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsWithPullToRefresh$lambda$1$0(Store store) {
        store.send(InboxItemsListReducer.Action.RefreshNotifications.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void NotificationsList(final Store<InboxItemsListReducer.State, InboxItemsListReducer.Action> store, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final IInboxRouter iInboxRouter, final InboxNotificationRoutingMapper inboxNotificationRoutingMapper, Composer composer, final int i) {
        int i2;
        DefaultAvatarControllerWrapper defaultAvatarControllerWrapper2;
        LazyListState lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1144445513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationsList)N(store,avatarControllerWrapper,inboxRouter,routingMapper)153@6318L23,154@6371L29,156@6428L225,163@6690L122,163@6659L153,172@6918L6,176@7109L1557,169@6818L1848:InboxItemsList.kt#1rb0q9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
            i2 |= composerStartRestartGroup.changed(defaultAvatarControllerWrapper2) ? 32 : 16;
        } else {
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(iInboxRouter) : composerStartRestartGroup.changedInstance(iInboxRouter) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(inboxNotificationRoutingMapper) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1144445513, i2, -1, "com.box.android.inbox.notifications.NotificationsList (InboxItemsList.kt:152)");
            }
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -300497832, "CC(remember):InboxItemsList.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(InboxItemsListKt.NotificationsList$lambda$1$0(lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Boolean boolValueOf = Boolean.valueOf(NotificationsList$lambda$2(state));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -300489551, "CC(remember):InboxItemsList.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            InboxItemsListKt$NotificationsList$1$1 inboxItemsListKt$NotificationsList$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || inboxItemsListKt$NotificationsList$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                inboxItemsListKt$NotificationsList$1$1RememberedValue = new InboxItemsListKt$NotificationsList$1$1(store, state, null);
                composerStartRestartGroup.updateRememberedValue(inboxItemsListKt$NotificationsList$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxItemsListKt$NotificationsList$1$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), "NotificationsList");
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -300474708, "CC(remember):InboxItemsList.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | (i3 == 4) | ((i2 & 112) == 32) | ((i2 & 896) == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(iInboxRouter))) | ((i2 & 7168) == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState = lazyListStateRememberLazyListState;
                final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper3 = defaultAvatarControllerWrapper2;
                Function1 function1 = new Function1() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InboxItemsListKt.NotificationsList$lambda$4$0(store, stateCollectAsStateWithLifecycle, defaultAvatarControllerWrapper3, iInboxRouter, inboxNotificationRoutingMapper, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                lazyListState = lazyListStateRememberLazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(modifierTestTag, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 504);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemsListKt.NotificationsList$lambda$5(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NotificationsList$lambda$1$0(LazyListState lazyListState, State state) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull((List) lazyListState.getLayoutInfo().getVisibleItemsInfo());
        return lazyListItemInfo != null && lazyListItemInfo.getIndex() >= NotificationsList$lambda$0(state).getItems().size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsList$lambda$4$0(final Store store, final State state, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final IInboxRouter iInboxRouter, final InboxNotificationRoutingMapper inboxNotificationRoutingMapper, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InboxItemsListKt.NotificationsList$lambda$4$0$0(store, (String) obj);
            }
        };
        final IdentifiedList<String, InboxItemReducer.State> items = NotificationsList$lambda$0(state).getItems();
        final Function2 function2 = new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return InboxItemsListKt.NotificationsList$lambda$4$0$1(((Integer) obj).intValue(), (InboxItemReducer.State) obj2);
            }
        };
        LazyColumn.items(items.size(), new Function1<Integer, Object>() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$NotificationsList$lambda$4$0$$inlined$itemsIndexed$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(Integer.valueOf(i), items.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$NotificationsList$lambda$4$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                items.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$NotificationsList$lambda$4$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                boolean z = false;
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                InboxItemReducer.State state2 = (InboxItemReducer.State) items.get(i);
                composer.startReplaceGroup(-2076442306);
                ComposerKt.sourceInformation(composer, "CN(index,itemState)*189@7580L934:InboxItemsList.kt#1rb0q9");
                Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 283161350, "C190@7644L266:InboxItemsList.kt#1rb0q9");
                InboxItemKt.InboxItem((Store) function1.invoke(state2.getId()), defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, null, composer, 0, 16);
                if (!state2.getNotification().isRead() || (i != InboxItemsListKt.NotificationsList$lambda$0(state).getItems().size() - 1 && !((InboxItemReducer.State) InboxItemsListKt.NotificationsList$lambda$0(state).getItems().get(i + 1)).getNotification().isRead())) {
                    z = true;
                }
                if (Intrinsics.areEqual(state2, CollectionsKt.last((List) InboxItemsListKt.NotificationsList$lambda$0(state).getItems())) || z) {
                    composer.startReplaceGroup(275550973);
                } else {
                    composer.startReplaceGroup(283807141);
                    ComposerKt.sourceInformation(composer, "200@8338L144");
                    BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(Dp.m9687constructorimpl(76), 0.0f, 0.0f, composer, 6, 6);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (NotificationsList$lambda$0(state).isLoadingMore()) {
            LazyListScope.item$default(LazyColumn, "InboxLoadMoreItem", null, ComposableSingletons$InboxItemsListKt.INSTANCE.getLambda$1977082503$box_generalProdRelease(), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store NotificationsList$lambda$4$0$0(Store store, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InboxItemsListReducer.State) obj).getItems();
            }
        }, id, InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$2.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object NotificationsList$lambda$4$0$1(int i, InboxItemReducer.State itemState) {
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        return itemState.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InboxLoadMoreItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1977884273);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxLoadMoreItem)217@8720L292:InboxItemsList.kt#1rb0q9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1977884273, i, -1, "com.box.android.inbox.notifications.InboxLoadMoreItem (InboxItemsList.kt:216)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16)), "InboxLoadMoreProgressBar");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -703995906, "C225@8982L24:InboxItemsList.kt#1rb0q9");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 127);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemsListKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemsListKt.InboxLoadMoreItem$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InboxItemsListReducer.State InboxItemsList$lambda$0(State<InboxItemsListReducer.State> state) {
        return state.getValue();
    }

    private static final InboxItemsListReducer.State NotificationsWithPullToRefresh$lambda$0(State<InboxItemsListReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxItemsListReducer.State NotificationsList$lambda$0(State<InboxItemsListReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NotificationsList$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
