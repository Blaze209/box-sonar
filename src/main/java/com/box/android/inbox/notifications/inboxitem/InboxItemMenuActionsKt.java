package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.R;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemMenuActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"InboxItemMenuActions", "", "notificationId", "", "payload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "onActionSelected", "Lkotlin/Function1;", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InboxNotificationMenuActionsPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease", "expanded", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemMenuActionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemMenuActions$lambda$4(String str, InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemMenuActions(str, commonPayloadInboxModel, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxNotificationMenuActionsPreview$lambda$0(int i, Composer composer, int i2) {
        InboxNotificationMenuActionsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x00af  */
    /* JADX WARN: Code duplicated, block: B:52:0x0122  */
    /* JADX WARN: Code duplicated, block: B:55:0x012e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0132  */
    /* JADX WARN: Code duplicated, block: B:59:0x019b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0207  */
    /* JADX WARN: Code duplicated, block: B:65:0x0213  */
    /* JADX WARN: Code duplicated, block: B:66:0x0216  */
    /* JADX WARN: Code duplicated, block: B:69:0x0224  */
    /* JADX WARN: Code duplicated, block: B:70:0x0227  */
    /* JADX WARN: Code duplicated, block: B:75:0x023b  */
    /* JADX WARN: Code duplicated, block: B:79:0x027d  */
    /* JADX WARN: Code duplicated, block: B:82:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:84:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:87:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemMenuActions(final String notificationId, final InboxNotificationPayloadModel.CommonPayloadInboxModel payload, final Function1<? super ActionModel, Unit> onActionSelected, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Object objRememberedValue;
        final MutableState mutableState;
        String strStringResource;
        Function0<ComposeUiNode> constructor;
        Object objRememberedValue2;
        ArrayList arrayList;
        Object objRememberedValue3;
        String value;
        String str;
        boolean z2;
        boolean zChangedInstance;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(onActionSelected, "onActionSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1141903379);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemMenuActions)N(notificationId,payload,onActionSelected,modifier)33@1494L34,35@1559L59,36@1645L56,38@1707L869:InboxItemMenuActions.kt#2fg1pg");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changed(notificationId) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(payload) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onActionSelected) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1141903379, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemMenuActions (InboxItemMenuActions.kt:32)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2142486831, "CC(remember):InboxItemMenuActions.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.inbox_notification_more_options, composerStartRestartGroup, 6);
                Modifier modifierTestTag = TestTagKt.testTag(companion, "InboxItemMenuActions_" + notificationId);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791829712, "C42@1983L19,39@1790L335,60@2505L20,58@2434L136:InboxItemMenuActions.kt#2fg1pg");
                ButtonItemIconResource.ImageVectorResource imageVectorResource = new ButtonItemIconResource.ImageVectorResource(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1604772442, "CC(remember):InboxItemMenuActions.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$0$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier4 = companion;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource2, imageVectorResource, false, 17, null), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), null, 0L, 0.0f, composerStartRestartGroup, 48, 28);
                composerStartRestartGroup.startReplaceGroup(1604778692);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*51@2299L101");
                List<ActionModel> menuActions = payload.getMenuActions();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(menuActions, 10));
                for (final ActionModel actionModel : menuActions) {
                    value = actionModel.getValue();
                    if (value == null) {
                        str = strStringResource;
                    } else {
                        str = value;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846104432, "CC(remember):InboxItemMenuActions.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = composerStartRestartGroup.changedInstance(actionModel) | z2;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$1$0$0(onActionSelected, actionModel, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    arrayList.add(new PopupMenuItem(str, (Function0) objRememberedValue4, (PopupMenuItem.IconResource) null, (PopupMenuItem.IconResource) null, (PaddingValues) null, false, 60, (DefaultConstructorMarker) null));
                }
                ArrayList arrayList2 = arrayList;
                composerStartRestartGroup.endReplaceGroup();
                boolean zInboxItemMenuActions$lambda$1 = InboxItemMenuActions$lambda$1(mutableState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1604789147, "CC(remember):InboxItemMenuActions.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$2$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(zInboxItemMenuActions$lambda$1, (Function0) objRememberedValue3, arrayList2, null, null, 0L, composerStartRestartGroup, 48, 56);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$4(notificationId, payload, onActionSelected, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141903379, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemMenuActions (InboxItemMenuActions.kt:32)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2142486831, "CC(remember):InboxItemMenuActions.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.inbox_notification_more_options, composerStartRestartGroup, 6);
            Modifier modifierTestTag2 = TestTagKt.testTag(companion, "InboxItemMenuActions_" + notificationId);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791829712, "C42@1983L19,39@1790L335,60@2505L20,58@2434L136:InboxItemMenuActions.kt#2fg1pg");
            ButtonItemIconResource.ImageVectorResource imageVectorResource2 = new ButtonItemIconResource.ImageVectorResource(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1604772442, "CC(remember):InboxItemMenuActions.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$0$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier5 = companion;
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource3, imageVectorResource2, false, 17, null), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), null, 0L, 0.0f, composerStartRestartGroup, 48, 28);
            composerStartRestartGroup.startReplaceGroup(1604778692);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*51@2299L101");
            List<ActionModel> menuActions2 = payload.getMenuActions();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(menuActions2, 10));
            while (r6.hasNext()) {
                value = actionModel.getValue();
                if (value == null) {
                    str = strStringResource;
                } else {
                    str = value;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846104432, "CC(remember):InboxItemMenuActions.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = composerStartRestartGroup.changedInstance(actionModel) | z2;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$1$0$0(onActionSelected, actionModel, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$1$0$0(onActionSelected, actionModel, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                arrayList.add(new PopupMenuItem(str, (Function0) objRememberedValue4, (PopupMenuItem.IconResource) null, (PopupMenuItem.IconResource) null, (PaddingValues) null, false, 60, (DefaultConstructorMarker) null));
            }
            ArrayList arrayList3 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            boolean zInboxItemMenuActions$lambda$2 = InboxItemMenuActions$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1604789147, "CC(remember):InboxItemMenuActions.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$3$2$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(zInboxItemMenuActions$lambda$2, (Function0) objRememberedValue3, arrayList3, null, null, 0L, composerStartRestartGroup, 48, 56);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemMenuActionsKt.InboxItemMenuActions$lambda$4(notificationId, payload, onActionSelected, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean InboxItemMenuActions$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void InboxItemMenuActions$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemMenuActions$lambda$3$0$0(MutableState mutableState) {
        InboxItemMenuActions$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemMenuActions$lambda$3$1$0$0(Function1 function1, ActionModel actionModel, MutableState mutableState) {
        InboxItemMenuActions$lambda$2(mutableState, false);
        function1.invoke(actionModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemMenuActions$lambda$3$2$0(MutableState mutableState) {
        InboxItemMenuActions$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void InboxNotificationMenuActionsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1355702062);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxNotificationMenuActionsPreview)72@2746L347:InboxItemMenuActions.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1355702062, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationMenuActionsPreview (InboxItemMenuActions.kt:71)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemMenuActionsKt.INSTANCE.m12673getLambda$737246617$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemMenuActionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemMenuActionsKt.InboxNotificationMenuActionsPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
