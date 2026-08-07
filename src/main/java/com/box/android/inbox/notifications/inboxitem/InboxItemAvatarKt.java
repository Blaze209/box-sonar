package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.UserAvatarKt;
import com.box.android.domain.models.inboxnotifications.IconModel;
import com.box.android.domain.models.inboxnotifications.ImageSourceModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.domain.models.inboxnotifications.TaskCollaboratorMiniModel;
import com.box.android.utilities.inbox.InboxNotificationTypeIcons;
import com.box.android.utilities.inbox.NotificationTypeIcons;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemAvatar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\u0003H\u0003¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\f*\u00020\u0003H\u0002\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"InboxItemAvatar", "", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "shouldShowRequirementsButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getSourceUserName", "", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getSourceUserId", "resolveContainerSize", "Landroidx/compose/ui/unit/Dp;", "hasSubIcon", "(Z)F", "resolveSubIconUrl", "commonPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "isDarkTheme", "InboxItemAvatarPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemAvatarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemAvatar$lambda$1(InboxNotificationModel inboxNotificationModel, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemAvatar(inboxNotificationModel, defaultAvatarControllerWrapper, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemAvatarPreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemAvatarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0112  */
    /* JADX WARN: Code duplicated, block: B:56:0x019d  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:73:0x0219  */
    /* JADX WARN: Code duplicated, block: B:76:0x027d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0289  */
    /* JADX WARN: Code duplicated, block: B:80:0x028d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0329  */
    /* JADX WARN: Code duplicated, block: B:85:0x034a  */
    /* JADX WARN: Code duplicated, block: B:87:0x034f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0359  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemAvatar(final InboxNotificationModel notification, final DefaultAvatarControllerWrapper avatarControllerWrapper, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean zIsDarkTheme;
        NotificationTypeIcons notificationTypeIcons;
        Function0<ComposeUiNode> constructor;
        BoxScopeInstance boxScopeInstance;
        InboxNotificationPayloadModel payload;
        InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel;
        IconModel subIcon;
        boolean z3;
        Color colorM6804boximpl;
        long jM11531getItemListingContentBackgroundSelected0d7_KjU;
        Function0<ComposeUiNode> constructor2;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-286601338);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemAvatar)N(notification,avatarControllerWrapper,shouldShowRequirementsButton,modifier)41@2346L11,44@2502L1831:InboxItemAvatar.kt#2fg1pg");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(notification) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-286601338, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemAvatar (InboxItemAvatar.kt:40)");
                }
                zIsDarkTheme = BoxTheme.INSTANCE.isDarkTheme(composerStartRestartGroup, BoxTheme.$stable);
                notificationTypeIcons = new InboxNotificationTypeIcons().getNotificationTypeIcons(notification.getPayload(), z, zIsDarkTheme);
                Modifier modifierTestTag = TestTagKt.testTag(modifier4, "InboxItemAvatar_" + notification.getId());
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
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 85937639, "C47@2684L19,45@2583L257:InboxItemAvatar.kt#2fg1pg");
                UserAvatarKt.UserAvatar(getSourceUserId(notification), getSourceUserName(notification, composerStartRestartGroup, i3 & 14), avatarControllerWrapper.getDefaultAvatarController(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 3072, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (notificationTypeIcons.isVisible()) {
                    composerStartRestartGroup.startReplaceGroup(83320246);
                } else {
                    composerStartRestartGroup.startReplaceGroup(86218250);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "64@3482L835");
                    payload = notification.getPayload();
                    if (payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel) {
                        commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload;
                    } else {
                        commonPayloadInboxModel = null;
                    }
                    if (commonPayloadInboxModel != null) {
                        subIcon = commonPayloadInboxModel.getSubIcon();
                    } else {
                        subIcon = null;
                    }
                    if (subIcon != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    float fResolveContainerSize = resolveContainerSize(z3);
                    String strResolveSubIconUrl = resolveSubIconUrl(commonPayloadInboxModel, zIsDarkTheme);
                    if (z3) {
                        composerStartRestartGroup.startReplaceGroup(-1936871939);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "57@3209L6");
                        long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                        colorM6804boximpl = Color.m6804boximpl(jM11533getMainActiveControl0d7_KjU);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(86534449);
                        composerStartRestartGroup.endReplaceGroup();
                        colorM6804boximpl = null;
                    }
                    if (notification.isRead()) {
                        composerStartRestartGroup.startReplaceGroup(86599178);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "59@3329L6");
                        jM11531getItemListingContentBackgroundSelected0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(86680770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "61@3411L6");
                        jM11531getItemListingContentBackgroundSelected0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierAlign = boxScopeInstance.align(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fResolveContainerSize), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1020981571, "C69@3644L289,77@3951L352:InboxItemAvatar.kt#2fg1pg");
                    InboxNotificationRemoteIconKt.m12682InboxNotificationRemoteIconSj8uqqQ(notificationTypeIcons.getOutlineIcon(), strResolveSubIconUrl, null, Color.m6804boximpl(jM11531getItemListingContentBackgroundSelected0d7_KjU), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 24960, 0);
                    InboxNotificationRemoteIconKt.m12682InboxNotificationRemoteIconSj8uqqQ(notificationTypeIcons.getFillIcon(), strResolveSubIconUrl, null, colorM6804boximpl, SizeKt.m1266size3ABfNKs(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m9687constructorimpl(18)), composerStartRestartGroup, 384, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                composerStartRestartGroup.endReplaceGroup();
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemAvatarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemAvatarKt.InboxItemAvatar$lambda$1(notification, avatarControllerWrapper, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-286601338, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemAvatar (InboxItemAvatar.kt:40)");
            }
            zIsDarkTheme = BoxTheme.INSTANCE.isDarkTheme(composerStartRestartGroup, BoxTheme.$stable);
            notificationTypeIcons = new InboxNotificationTypeIcons().getNotificationTypeIcons(notification.getPayload(), z, zIsDarkTheme);
            Modifier modifierTestTag2 = TestTagKt.testTag(modifier4, "InboxItemAvatar_" + notification.getId());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
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
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 85937639, "C47@2684L19,45@2583L257:InboxItemAvatar.kt#2fg1pg");
            UserAvatarKt.UserAvatar(getSourceUserId(notification), getSourceUserName(notification, composerStartRestartGroup, i3 & 14), avatarControllerWrapper.getDefaultAvatarController(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 3072, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (notificationTypeIcons.isVisible()) {
                composerStartRestartGroup.startReplaceGroup(83320246);
            } else {
                composerStartRestartGroup.startReplaceGroup(86218250);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@3482L835");
                payload = notification.getPayload();
                if (payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel) {
                    commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload;
                } else {
                    commonPayloadInboxModel = null;
                }
                if (commonPayloadInboxModel != null) {
                    subIcon = commonPayloadInboxModel.getSubIcon();
                } else {
                    subIcon = null;
                }
                if (subIcon != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                float fResolveContainerSize2 = resolveContainerSize(z3);
                String strResolveSubIconUrl2 = resolveSubIconUrl(commonPayloadInboxModel, zIsDarkTheme);
                if (z3) {
                    composerStartRestartGroup.startReplaceGroup(-1936871939);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@3209L6");
                    long jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                    colorM6804boximpl = Color.m6804boximpl(jM11533getMainActiveControl0d7_KjU2);
                } else {
                    composerStartRestartGroup.startReplaceGroup(86534449);
                    composerStartRestartGroup.endReplaceGroup();
                    colorM6804boximpl = null;
                }
                if (notification.isRead()) {
                    composerStartRestartGroup.startReplaceGroup(86599178);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@3329L6");
                    jM11531getItemListingContentBackgroundSelected0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(86680770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "61@3411L6");
                    jM11531getItemListingContentBackgroundSelected0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11531getItemListingContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierAlign2 = boxScopeInstance.align(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fResolveContainerSize2), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1020981571, "C69@3644L289,77@3951L352:InboxItemAvatar.kt#2fg1pg");
                InboxNotificationRemoteIconKt.m12682InboxNotificationRemoteIconSj8uqqQ(notificationTypeIcons.getOutlineIcon(), strResolveSubIconUrl2, null, Color.m6804boximpl(jM11531getItemListingContentBackgroundSelected0d7_KjU), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 24960, 0);
                InboxNotificationRemoteIconKt.m12682InboxNotificationRemoteIconSj8uqqQ(notificationTypeIcons.getFillIcon(), strResolveSubIconUrl2, null, colorM6804boximpl, SizeKt.m1266size3ABfNKs(boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m9687constructorimpl(18)), composerStartRestartGroup, 384, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemAvatarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemAvatarKt.InboxItemAvatar$lambda$1(notification, avatarControllerWrapper, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String getSourceUserName(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        TaskCollaboratorMiniModel taskCollaboratorMiniModel;
        InboxNotificationUserModel target;
        ComposerKt.sourceInformationMarkerStart(composer, -810636572, "C(getSourceUserName):InboxItemAvatar.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810636572, i, -1, "com.box.android.inbox.notifications.inboxitem.getSourceUserName (InboxItemAvatar.kt:92)");
        }
        InboxNotificationPayloadModel payload = inboxNotificationModel.getPayload();
        String displayName = null;
        if (payload instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) {
            composer.startReplaceGroup(927125358);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel sentBy = ((InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) payload).getSentBy();
            displayName = sentBy != null ? sentBy.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632659972);
                ComposerKt.sourceInformation(composer, "93@4516L56");
                displayName = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
            } else {
                composer.startReplaceGroup(-1632660716);
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
            composer.startReplaceGroup(927246475);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel invitedBy = ((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload).getInvitedBy();
            displayName = invitedBy != null ? invitedBy.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632655972);
                ComposerKt.sourceInformation(composer, "95@4641L56");
                String strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource;
            } else {
                composer.startReplaceGroup(-1632656809);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) {
            composer.startReplaceGroup(927367406);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel sentBy2 = ((InboxNotificationPayloadModel.AtMentionPayloadInboxModel) payload).getSentBy();
            displayName = sentBy2 != null ? sentBy2.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632652164);
                ComposerKt.sourceInformation(composer, "97@4760L56");
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource2;
            } else {
                composer.startReplaceGroup(-1632652908);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) {
            composer.startReplaceGroup(927488430);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel sentBy3 = ((InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) payload).getSentBy();
            displayName = sentBy3 != null ? sentBy3.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632648260);
                ComposerKt.sourceInformation(composer, "99@4882L56");
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource3;
            } else {
                composer.startReplaceGroup(-1632649004);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            composer.startReplaceGroup(927609919);
            ComposerKt.sourceInformation(composer, "");
            List<TaskCollaboratorMiniModel> taskCollaborators = ((InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) payload).getTask().getTaskCollaborators();
            if (taskCollaborators != null && (taskCollaboratorMiniModel = (TaskCollaboratorMiniModel) CollectionsKt.firstOrNull((List) taskCollaborators)) != null && (target = taskCollaboratorMiniModel.getTarget()) != null) {
                displayName = target.getName();
            }
            if (displayName != null) {
                composer.startReplaceGroup(-1632645085);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1632642884);
                ComposerKt.sourceInformation(composer, "102@5050L56");
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource4;
            }
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel) {
            composer.startReplaceGroup(927771150);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel sentBy4 = ((InboxNotificationPayloadModel.CommentPayloadInboxModel) payload).getSentBy();
            displayName = sentBy4 != null ? sentBy4.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632639140);
                ComposerKt.sourceInformation(composer, "104@5167L56");
                String strStringResource5 = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource5;
            } else {
                composer.startReplaceGroup(-1632639884);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel) {
            composer.startReplaceGroup(927888206);
            ComposerKt.sourceInformation(composer, "");
            InboxNotificationUserModel sentBy5 = ((InboxNotificationPayloadModel.EditFilePayloadInboxModel) payload).getSentBy();
            displayName = sentBy5 != null ? sentBy5.getName() : null;
            if (displayName == null) {
                composer.startReplaceGroup(-1632635364);
                ComposerKt.sourceInformation(composer, "106@5285L56");
                String strStringResource6 = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_user, composer, 6);
                composer.endReplaceGroup();
                displayName = strStringResource6;
            } else {
                composer.startReplaceGroup(-1632636108);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else {
            if (!(payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel)) {
                composer.startReplaceGroup(-1632662299);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-1632631921);
            composer.endReplaceGroup();
            displayName = ((InboxNotificationPayloadModel.CommonPayloadInboxModel) payload).getMainIcon().getDisplayName();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return displayName;
    }

    private static final String getSourceUserId(InboxNotificationModel inboxNotificationModel) {
        String id;
        String id2;
        TaskCollaboratorMiniModel taskCollaboratorMiniModel;
        InboxNotificationUserModel target;
        String id3;
        String id4;
        String id5;
        String id6;
        String id7;
        InboxNotificationPayloadModel payload = inboxNotificationModel.getPayload();
        if (payload instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) {
            InboxNotificationUserModel sentBy = ((InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) payload).getSentBy();
            return (sentBy == null || (id7 = sentBy.getId()) == null) ? "" : id7;
        }
        if (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
            InboxNotificationUserModel invitedBy = ((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload).getInvitedBy();
            return (invitedBy == null || (id6 = invitedBy.getId()) == null) ? "" : id6;
        }
        if (payload instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) {
            InboxNotificationUserModel sentBy2 = ((InboxNotificationPayloadModel.AtMentionPayloadInboxModel) payload).getSentBy();
            return (sentBy2 == null || (id5 = sentBy2.getId()) == null) ? "" : id5;
        }
        if (payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) {
            InboxNotificationUserModel sentBy3 = ((InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) payload).getSentBy();
            return (sentBy3 == null || (id4 = sentBy3.getId()) == null) ? "" : id4;
        }
        if (payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            List<TaskCollaboratorMiniModel> taskCollaborators = ((InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) payload).getTask().getTaskCollaborators();
            return (taskCollaborators == null || (taskCollaboratorMiniModel = (TaskCollaboratorMiniModel) CollectionsKt.firstOrNull((List) taskCollaborators)) == null || (target = taskCollaboratorMiniModel.getTarget()) == null || (id3 = target.getId()) == null) ? "" : id3;
        }
        if (payload instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel) {
            InboxNotificationUserModel sentBy4 = ((InboxNotificationPayloadModel.CommentPayloadInboxModel) payload).getSentBy();
            return (sentBy4 == null || (id2 = sentBy4.getId()) == null) ? "" : id2;
        }
        if (payload instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel) {
            InboxNotificationUserModel sentBy5 = ((InboxNotificationPayloadModel.EditFilePayloadInboxModel) payload).getSentBy();
            return (sentBy5 == null || (id = sentBy5.getId()) == null) ? "" : id;
        }
        if (payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel) {
            return ((InboxNotificationPayloadModel.CommonPayloadInboxModel) payload).getMainIcon().getUserId();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String resolveSubIconUrl(InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel, boolean z) {
        IconModel subIcon;
        ImageSourceModel imageSource;
        String urlDark;
        if (commonPayloadInboxModel == null || (subIcon = commonPayloadInboxModel.getSubIcon()) == null || (imageSource = subIcon.getImageSource()) == null) {
            return null;
        }
        return (!z || (urlDark = imageSource.getUrlDark()) == null) ? imageSource.getUrl() : urlDark;
    }

    private static final void InboxItemAvatarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1212578364);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemAvatarPreview)135@6570L395:InboxItemAvatar.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212578364, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemAvatarPreview (InboxItemAvatar.kt:134)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemAvatarKt.INSTANCE.m12667getLambda$1041561839$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemAvatarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemAvatarKt.InboxItemAvatarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float resolveContainerSize(boolean z) {
        return Dp.m9687constructorimpl(z ? 22 : 20);
    }
}
