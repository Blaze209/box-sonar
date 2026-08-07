package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxTypography;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemTaskStatus.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"InboxItemTaskStatus", "", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getTaskStatus", "Lcom/box/android/inbox/notifications/inboxitem/TaskStatus;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/TaskStatus;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemTaskStatusKt {

    /* JADX INFO: compiled from: InboxItemTaskStatus.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.values().length];
            try {
                iArr[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.APPROVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemTaskStatus$lambda$1(InboxNotificationModel inboxNotificationModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemTaskStatus(inboxNotificationModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:50:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemTaskStatus(final InboxNotificationModel notification, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TaskStatus taskStatus;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Composer composerStartRestartGroup = composer.startRestartGroup(1554768157);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemTaskStatus)N(notification,modifier)26@1249L27:InboxItemTaskStatus.kt#2fg1pg");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(notification) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1554768157, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTaskStatus (InboxItemTaskStatus.kt:25)");
                }
                taskStatus = getTaskStatus(notification, composerStartRestartGroup, i3 & 14);
                if (taskStatus != null) {
                    composerStartRestartGroup.startReplaceGroup(1171037325);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "28@1315L680");
                    Modifier modifierTestTag = TestTagKt.testTag(modifier3, "InboxItemTaskStatus_" + notification.getId());
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(4));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 941476210, "C34@1582L35,33@1550L215,43@1954L6,39@1778L207:InboxItemTaskStatus.kt#2fg1pg");
                    IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(taskStatus.getIconRes(), composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, Painter.$stable | 3504, 0);
                    TextKt.m4494TextNvy7gAk(taskStatus.getText(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxNormal13(), composerStartRestartGroup, 1572864, 0, 131002);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1169720197);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemTaskStatusKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemTaskStatusKt.InboxItemTaskStatus$lambda$1(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1554768157, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTaskStatus (InboxItemTaskStatus.kt:25)");
            }
            taskStatus = getTaskStatus(notification, composerStartRestartGroup, i3 & 14);
            if (taskStatus != null) {
                composerStartRestartGroup.startReplaceGroup(1171037325);
                ComposerKt.sourceInformation(composerStartRestartGroup, "28@1315L680");
                Modifier modifierTestTag2 = TestTagKt.testTag(modifier3, "InboxItemTaskStatus_" + notification.getId());
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(4));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 941476210, "C34@1582L35,33@1550L215,43@1954L6,39@1778L207:InboxItemTaskStatus.kt#2fg1pg");
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(taskStatus.getIconRes(), composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, Painter.$stable | 3504, 0);
                TextKt.m4494TextNvy7gAk(taskStatus.getText(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxNormal13(), composerStartRestartGroup, 1572864, 0, 131002);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(1169720197);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemTaskStatusKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemTaskStatusKt.InboxItemTaskStatus$lambda$1(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final TaskStatus getTaskStatus(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        TaskStatus taskStatus;
        ComposerKt.sourceInformationMarkerStart(composer, -1905093132, "C(getTaskStatus)N(notification):InboxItemTaskStatus.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1905093132, i, -1, "com.box.android.inbox.notifications.inboxitem.getTaskStatus (InboxItemTaskStatus.kt:52)");
        }
        InboxNotificationPayloadModel payload = inboxNotificationModel.getPayload();
        if (payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            composer.startReplaceGroup(-931464592);
            ComposerKt.sourceInformation(composer, "");
            int i2 = WhenMappings.$EnumSwitchMapping$0[((InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) payload).getStatus().ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(-1138423843);
                ComposerKt.sourceInformation(composer, "57@2424L34");
                taskStatus = new TaskStatus(R.drawable.ic_circle_check, StringResources_androidKt.stringResource(R.string.Completed, composer, 6));
                composer.endReplaceGroup();
            } else if (i2 == 2) {
                composer.startReplaceGroup(-1138417668);
                ComposerKt.sourceInformation(composer, "62@2617L33");
                taskStatus = new TaskStatus(R.drawable.ic_circle_check, StringResources_androidKt.stringResource(R.string.Approved, composer, 6));
                composer.endReplaceGroup();
            } else {
                if (i2 != 3) {
                    composer.startReplaceGroup(-1138425902);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(-1138411528);
                ComposerKt.sourceInformation(composer, "67@2805L33");
                taskStatus = new TaskStatus(R.drawable.ic_circle_x, StringResources_androidKt.stringResource(R.string.Rejected, composer, 6));
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-930862263);
            composer.endReplaceGroup();
            taskStatus = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return taskStatus;
    }
}
