package com.box.android.inbox.notifications;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.cpl.Store;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.inbox.notifications.inboxitem.InboxItemAvatarKt;
import com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt;
import com.box.android.inbox.notifications.inboxitem.InboxItemContentKt;
import com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt;
import com.box.android.inbox.notifications.inboxitem.InboxItemTaskStatusKt;
import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt;
import com.box.android.inbox.notifications.router.IInboxRouter;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: InboxItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"InboxItem", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "inboxRouter", "Lcom/box/android/inbox/notifications/router/IInboxRouter;", "routingMapper", "Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/inbox/notifications/router/IInboxRouter;Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "box_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$3(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, IInboxRouter iInboxRouter, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItem(store, defaultAvatarControllerWrapper, iInboxRouter, inboxNotificationRoutingMapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x009e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x0105  */
    /* JADX WARN: Code duplicated, block: B:75:0x0117  */
    /* JADX WARN: Code duplicated, block: B:78:0x018d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0192  */
    /* JADX WARN: Code duplicated, block: B:83:0x019c  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final void InboxItem(final Store<InboxItemReducer.State, InboxItemReducer.Action> store, final DefaultAvatarControllerWrapper avatarControllerWrapper, final IInboxRouter inboxRouter, final InboxNotificationRoutingMapper routingMapper, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final State stateCollectAsStateWithLifecycle;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(inboxRouter, "inboxRouter");
        Intrinsics.checkNotNullParameter(routingMapper, "routingMapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1228202208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItem)N(store,avatarControllerWrapper,inboxRouter,routingMapper,modifier)45@2278L29,49@2400L1473,83@3959L6,84@4001L2990,46@2312L4679:InboxItem.kt#1rb0q9");
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
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            z = false;
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1228202208, i3, -1, "com.box.android.inbox.notifications.InboxItem (InboxItem.kt:44)");
                }
                Modifier modifier4 = modifier2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 813699233, "CC(remember):InboxItem.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((i3 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean zChanged = z4 | z3 | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i3 & 896) != 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(inboxRouter))) {
                    z = true;
                }
                z5 = zChanged | z;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemKt.InboxItem$lambda$1$0(store, routingMapper, inboxRouter, stateCollectAsStateWithLifecycle);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SurfaceKt.m4323SurfaceT9BRK9s(TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null), "InboxItem_" + InboxItem$lambda$0(stateCollectAsStateWithLifecycle).getNotification().getId()), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-582118939, true, new Function2() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemKt.InboxItem$lambda$2(stateCollectAsStateWithLifecycle, avatarControllerWrapper, store, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 122);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemKt.InboxItem$lambda$3(store, avatarControllerWrapper, inboxRouter, routingMapper, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        z = false;
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1228202208, i3, -1, "com.box.android.inbox.notifications.InboxItem (InboxItem.kt:44)");
            }
            Modifier modifier5 = modifier2;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 813699233, "CC(remember):InboxItem.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i3 & 7168) == 2048) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean zChanged2 = z4 | z3 | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            if ((i3 & 896) != 256) {
                z = true;
            } else {
                z = true;
            }
            z5 = zChanged2 | z;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxItemKt.InboxItem$lambda$1$0(store, routingMapper, inboxRouter, stateCollectAsStateWithLifecycle);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxItemKt.InboxItem$lambda$1$0(store, routingMapper, inboxRouter, stateCollectAsStateWithLifecycle);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SurfaceKt.m4323SurfaceT9BRK9s(TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default2, false, null, null, null, (Function0) objRememberedValue, 15, null), "InboxItem_" + InboxItem$lambda$0(stateCollectAsStateWithLifecycle).getNotification().getId()), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-582118939, true, new Function2() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemKt.InboxItem$lambda$2(stateCollectAsStateWithLifecycle, avatarControllerWrapper, store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 122);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemKt.InboxItem$lambda$3(store, avatarControllerWrapper, inboxRouter, routingMapper, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$1$0(Store store, InboxNotificationRoutingMapper inboxNotificationRoutingMapper, IInboxRouter iInboxRouter, State state) {
        store.send(InboxItemReducer.Action.Clicked.INSTANCE);
        InboxItemReducer.RoutingTarget routingTarget = inboxNotificationRoutingMapper.getRoutingTarget(InboxItem$lambda$0(state).getNotification());
        if (routingTarget instanceof InboxItemReducer.RoutingTarget.File) {
            InboxItemReducer.RoutingTarget.File file = (InboxItemReducer.RoutingTarget.File) routingTarget;
            iInboxRouter.navigateToFile(file.getId(), file.getName());
        } else if (routingTarget instanceof InboxItemReducer.RoutingTarget.FileWithComment) {
            InboxItemReducer.RoutingTarget.FileWithComment fileWithComment = (InboxItemReducer.RoutingTarget.FileWithComment) routingTarget;
            iInboxRouter.navigateToFileWithComment(fileWithComment.getId(), fileWithComment.getName(), fileWithComment.getCommentId());
        } else if (routingTarget instanceof InboxItemReducer.RoutingTarget.FileWithAnnotation) {
            InboxItemReducer.RoutingTarget.FileWithAnnotation fileWithAnnotation = (InboxItemReducer.RoutingTarget.FileWithAnnotation) routingTarget;
            iInboxRouter.navigateToFileWithAnnotation(fileWithAnnotation.getId(), fileWithAnnotation.getName(), fileWithAnnotation.getAnnotationId());
        } else if (routingTarget instanceof InboxItemReducer.RoutingTarget.Folder) {
            InboxItemReducer.RoutingTarget.Folder folder = (InboxItemReducer.RoutingTarget.Folder) routingTarget;
            iInboxRouter.navigateToFolder(folder.getId(), folder.getName());
        } else if (routingTarget instanceof InboxItemReducer.RoutingTarget.Task) {
            InboxItemReducer.RoutingTarget.Task task = (InboxItemReducer.RoutingTarget.Task) routingTarget;
            iInboxRouter.navigateToTask(task.getTaskId(), task.isMyTask());
        } else if (routingTarget instanceof InboxItemReducer.RoutingTarget.Url) {
            iInboxRouter.navigateToUrl(((InboxItemReducer.RoutingTarget.Url) routingTarget).getUrl());
        } else if (!(routingTarget instanceof InboxItemReducer.RoutingTarget.None)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$2(final State state, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final Store store, Composer composer, int i) {
        Modifier.Companion companionM589backgroundbw27NRU$default;
        ComposerKt.sourceInformation(composer, "C85@4011L2974:InboxItem.kt#1rb0q9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-582118939, i, -1, "com.box.android.inbox.notifications.InboxItem.<anonymous> (InboxItem.kt:85)");
            }
            composer.startReplaceGroup(-1070548576);
            ComposerKt.sourceInformation(composer, "*91@4264L6");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (!InboxItem$lambda$0(state).getNotification().isRead()) {
                companionM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11531getItemListingContentBackgroundSelected0d7_KjU(), null, 2, null);
            } else {
                companionM589backgroundbw27NRU$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierFillMaxWidth$default.then(companionM589backgroundbw27NRU$default);
            composer.endReplaceGroup();
            float f = 12;
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(modifierThen, Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1219paddingVpY3zN4);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -569153040, "C97@4501L306,104@4821L1627:InboxItem.kt#1rb0q9");
            InboxItemAvatarKt.InboxItemAvatar(InboxItem$lambda$0(state).getNotification(), defaultAvatarControllerWrapper, InboxItem$lambda$0(state).getCollaborationState().getPendingAcceptanceRequirement() != null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), composer, 3072, 0);
            Composer composer2 = composer;
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, Alignment.INSTANCE.getStart(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxHeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1508657814, "C110@5032L49,111@5098L55,112@5170L53,113@5240L54,117@5493L44,114@5311L266:InboxItem.kt#1rb0q9");
            InboxItemContentKt.InboxItemTitle(InboxItem$lambda$0(state).getNotification(), null, composer2, 0, 2);
            InboxItemContentKt.InboxItemDescription(InboxItem$lambda$0(state).getNotification(), null, composer2, 0, 2);
            InboxItemContentKt.InboxItemTimestamp(InboxItem$lambda$0(state).getNotification(), null, composer2, 0, 2);
            InboxItemTaskStatusKt.InboxItemTaskStatus(InboxItem$lambda$0(state).getNotification(), null, composer2, 0, 2);
            InboxItemKt$InboxItem$2$2$1$1 inboxItemKt$InboxItem$2$2$1$1 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.InboxItemKt$InboxItem$2$2$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((InboxItemReducer.State) obj).getCollaborationState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer2, -1988315637, "CC(remember):InboxItem.kt#9igjgp");
            InboxItemKt$InboxItem$2$2$1$2$1 inboxItemKt$InboxItem$2$2$1$2$1RememberedValue = composer2.rememberedValue();
            if (inboxItemKt$InboxItem$2$2$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                inboxItemKt$InboxItem$2$2$1$2$1RememberedValue = InboxItemKt$InboxItem$2$2$1$2$1.INSTANCE;
                composer2.updateRememberedValue(inboxItemKt$InboxItem$2$2$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            InboxItemCollaborationKt.InboxItemCollaboration(store.scope(inboxItemKt$InboxItem$2$2$1$1, (Function1) ((KFunction) inboxItemKt$InboxItem$2$2$1$2$1RememberedValue)), null, composer2, 0, 2);
            if (InboxItem$lambda$0(state).getPrimaryAction() == null && InboxItem$lambda$0(state).getSecondaryAction() == null) {
                composer2.startReplaceGroup(-1513694013);
            } else {
                composer2.startReplaceGroup(-1508053346);
                ComposerKt.sourceInformation(composer2, "125@5878L208,130@6131L210,122@5683L733");
                ActionModel primaryAction = InboxItem$lambda$0(state).getPrimaryAction();
                ActionModel secondaryAction = InboxItem$lambda$0(state).getSecondaryAction();
                ComposerKt.sourceInformationMarkerStart(composer2, -1988303153, "CC(remember):InboxItem.kt#9igjgp");
                boolean zChanged = composer2.changed(state) | composer2.changed(store);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemKt.InboxItem$lambda$2$1$0$1$0(state, store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1988295055, "CC(remember):InboxItem.kt#9igjgp");
                boolean zChanged2 = composer2.changed(state) | composer2.changed(store);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemKt.InboxItem$lambda$2$1$0$2$0(state, store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                InboxItemCommonCardActionsKt.InboxItemCommonCardActions(primaryAction, secondaryAction, function0, (Function0) objRememberedValue2, null, InboxItem$lambda$0(state).isEnabled(), composer, 0, 16);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            List<ActionModel> moreActions = InboxItem$lambda$0(state).getMoreActions();
            if (moreActions == null) {
                composer2.startReplaceGroup(-567250262);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-567250261);
                ComposerKt.sourceInformation(composer2, "");
                if (moreActions.isEmpty()) {
                    composer2.startReplaceGroup(1501929642);
                } else {
                    composer2.startReplaceGroup(1508439053);
                    ComposerKt.sourceInformation(composer2, "145@6788L133,142@6570L373");
                    String id = InboxItem$lambda$0(state).getNotification().getId();
                    InboxNotificationPayloadModel payload = InboxItem$lambda$0(state).getNotification().getPayload();
                    Intrinsics.checkNotNull(payload, "null cannot be cast to non-null type com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CommonPayloadInboxModel");
                    InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload;
                    ComposerKt.sourceInformationMarkerStart(composer2, 879950717, "CC(remember):InboxItem.kt#9igjgp");
                    boolean zChanged3 = composer2.changed(store);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.inbox.notifications.InboxItemKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return InboxItemKt.InboxItem$lambda$2$1$1$0$0(store, (ActionModel) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    InboxItemMenuActionsKt.InboxItemMenuActions(id, commonPayloadInboxModel, (Function1) objRememberedValue3, null, composer2, 0, 8);
                }
                composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$2$1$0$1$0(State state, Store store) {
        ActionModel primaryAction = InboxItem$lambda$0(state).getPrimaryAction();
        if (primaryAction != null) {
            store.send(new InboxItemReducer.Action.ExecuteCommonCardAction(primaryAction));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$2$1$0$2$0(State state, Store store) {
        ActionModel secondaryAction = InboxItem$lambda$0(state).getSecondaryAction();
        if (secondaryAction != null) {
            store.send(new InboxItemReducer.Action.ExecuteCommonCardAction(secondaryAction));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItem$lambda$2$1$1$0$0(Store store, ActionModel action) {
        Intrinsics.checkNotNullParameter(action, "action");
        store.send(new InboxItemReducer.Action.ExecuteCommonCardAction(action));
        return Unit.INSTANCE;
    }

    private static final InboxItemReducer.State InboxItem$lambda$0(State<InboxItemReducer.State> state) {
        return state.getValue();
    }
}
