package com.box.android.inbox.notifications.inboxitem;

import android.content.Context;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTargetItemModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.domain.models.inboxnotifications.TaskCollaboratorMiniModel;
import com.box.android.domain.models.inboxnotifications.TaskLinkModel;
import com.box.android.domain.models.inboxnotifications.TextAtomModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import com.box.android.domain.models.item.ItemType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxItemContent.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\n\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a\u001d\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0003¢\u0006\u0002\u0010 \u001a\u0015\u0010!\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\"H\u0003¢\u0006\u0002\u0010#\u001a\u0015\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001a\u0015\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020*H\u0003¢\u0006\u0002\u0010+\u001a\u001d\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a\u0015\u00101\u001a\u00020\t2\u0006\u0010\u001d\u001a\u000202H\u0003¢\u0006\u0002\u00103\u001a\u0015\u00104\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u000205H\u0003¢\u0006\u0002\u00106\u001a\u0015\u00107\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u000208H\u0003¢\u0006\u0002\u00109\u001a\u0015\u0010:\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020;H\u0003¢\u0006\u0002\u0010<\u001a\r\u0010=\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010>\u001a\r\u0010?\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010>\u001a\r\u0010@\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010>¨\u0006A"}, d2 = {"InboxItemTitle", "", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InboxItemDescription", "getItemDescription", "", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "InboxItemTimestamp", "getAbsoluteDateTimeString", "getSentTime", "", "buildItemTitle", "Landroidx/compose/ui/text/AnnotatedString;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "getInboxItemPayload", "Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildSendSharedLinkPayload", "payload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$SendSharedLinkPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$SendSharedLinkPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildCollabInvitePayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CollabInvitePayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "getCollabInviteVerb", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "itemType", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "buildNotifyCollabPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$NotifyCollabPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$NotifyCollabPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "getNotifyCollabVerb", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "buildAtMentionPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$AtMentionPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$AtMentionPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildTaskUpdatedPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildTaskCollaboratorsText", "firstCollaboratorName", "otherCollaboratorsCount", "", "(Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getTaskUpdatedVerb", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$TaskUpdatedPayloadInboxStatus;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "buildCommentPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommentPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommentPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildEditFilePayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$EditFilePayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$EditFilePayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "buildCommonPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;Landroidx/compose/runtime/Composer;I)Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "InboxItemTitlePreview", "(Landroidx/compose/runtime/Composer;I)V", "InboxItemDescriptionPreview", "InboxItemTimestampPreview", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemContentKt {

    /* JADX INFO: compiled from: InboxItemContent.kt */
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
                iArr[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus.APPROVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemDescription$lambda$0(InboxNotificationModel inboxNotificationModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemDescription(inboxNotificationModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemDescriptionPreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemDescriptionPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemTimestamp$lambda$0(InboxNotificationModel inboxNotificationModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemTimestamp(inboxNotificationModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemTimestampPreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemTimestampPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemTitle$lambda$0(InboxNotificationModel inboxNotificationModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemTitle(inboxNotificationModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemTitlePreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemTitlePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemTitle(final InboxNotificationModel notification, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Composer composerStartRestartGroup = composer.startRestartGroup(668026668);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemTitle)N(notification,modifier)42@2476L28,45@2602L6,41@2455L286:InboxItemContent.kt#2fg1pg");
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(668026668, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTitle (InboxItemContent.kt:40)");
                }
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4495TextZ58ophY(buildItemTitle(notification, composerStartRestartGroup, i3 & 14), TestTagKt.testTag(companion, "InboxItemTitle_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer2, 0, 24960, 241656);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemContentKt.InboxItemTitle$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(668026668, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTitle (InboxItemContent.kt:40)");
            }
            modifier3 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4495TextZ58ophY(buildItemTitle(notification, composerStartRestartGroup, i3 & 14), TestTagKt.testTag(companion, "InboxItemTitle_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer2, 0, 24960, 241656);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemTitle$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:39:0x0107  */
    /* JADX WARN: Code duplicated, block: B:40:0x010b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0115  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemDescription(final InboxNotificationModel notification, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        String itemDescription;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1800674032);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemDescription)N(notification,modifier)53@2875L32:InboxItemContent.kt#2fg1pg");
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
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1800674032, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemDescription (InboxItemContent.kt:52)");
                }
                itemDescription = getItemDescription(notification, composerStartRestartGroup, i3 & 14);
                if (StringsKt.isBlank(itemDescription)) {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(258703794);
                } else {
                    composerStartRestartGroup.startReplaceGroup(261642563);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "58@3072L6,55@2952L303");
                    modifier3 = companion;
                    TextKt.m4494TextNvy7gAk(itemDescription, TestTagKt.testTag(companion, "InboxItemDescription_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 0, 24960, 110584);
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemContentKt.InboxItemDescription$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1800674032, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemDescription (InboxItemContent.kt:52)");
            }
            itemDescription = getItemDescription(notification, composerStartRestartGroup, i3 & 14);
            if (StringsKt.isBlank(itemDescription)) {
                composerStartRestartGroup.startReplaceGroup(261642563);
                ComposerKt.sourceInformation(composerStartRestartGroup, "58@3072L6,55@2952L303");
                modifier3 = companion;
                TextKt.m4494TextNvy7gAk(itemDescription, TestTagKt.testTag(companion, "InboxItemDescription_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 0, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(258703794);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemDescription$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String getItemDescription(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -955430802, "C(getItemDescription)N(notification)68@3374L33:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-955430802, i, -1, "com.box.android.inbox.notifications.inboxitem.getItemDescription (InboxItemContent.kt:67)");
        }
        String description = getInboxItemPayload(inboxNotificationModel, composer, i & 14).getDescription();
        if (description == null) {
            description = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return description;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemTimestamp(final InboxNotificationModel notification, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Composer composerStartRestartGroup = composer.startRestartGroup(425731946);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemTimestamp)N(notification,modifier)75@3579L39,78@3772L6,74@3558L243:InboxItemContent.kt#2fg1pg");
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(425731946, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTimestamp (InboxItemContent.kt:73)");
                }
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(getAbsoluteDateTimeString(notification, composerStartRestartGroup, i3 & 14), TestTagKt.testTag(companion, "InboxItemTimestamp_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 0, 0, 131064);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemContentKt.InboxItemTimestamp$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(425731946, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTimestamp (InboxItemContent.kt:73)");
            }
            modifier3 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(getAbsoluteDateTimeString(notification, composerStartRestartGroup, i3 & 14), TestTagKt.testTag(companion, "InboxItemTimestamp_" + notification.getId()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemTimestamp$lambda$0(notification, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String getAbsoluteDateTimeString(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, -247263644, "C(getAbsoluteDateTimeString)N(notification):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-247263644, i, -1, "com.box.android.inbox.notifications.inboxitem.getAbsoluteDateTimeString (InboxItemContent.kt:83)");
        }
        long sentTime = getSentTime(inboxNotificationModel);
        if (sentTime > 0) {
            composer.startReplaceGroup(-1397155595);
            ComposerKt.sourceInformation(composer, "88@4099L7");
            Date date = new Date(sentTime);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            strStringResource = BoxDateUtils.formatDateAndTimeAccordingToLocalConventions(date, (Context) objConsume);
            Intrinsics.checkNotNull(strStringResource);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-362002954);
            ComposerKt.sourceInformation(composer, "91@4138L56");
            strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_unknown_time, composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    private static final long getSentTime(InboxNotificationModel inboxNotificationModel) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault()).parse(inboxNotificationModel.getCreatedAt());
            return date != null ? date.getTime() : System.currentTimeMillis();
        } catch (Exception unused) {
            return System.currentTimeMillis();
        }
    }

    private static final AnnotatedString buildItemTitle(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1351943630, "C(buildItemTitle)N(notification)104@4607L33:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1351943630, i, -1, "com.box.android.inbox.notifications.inboxitem.buildItemTitle (InboxItemContent.kt:103)");
        }
        NotificationPayload inboxItemPayload = getInboxItemPayload(inboxNotificationModel, composer, i & 14);
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        for (NotificationSegment notificationSegment : inboxItemPayload.getSegments()) {
            if (!notificationSegment.isBold()) {
                builder.append(notificationSegment.getText());
            } else {
                int iPushStyle = builder.pushStyle(new SpanStyle(0L, 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null));
                try {
                    builder.append(notificationSegment.getText());
                    Unit unit = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                } catch (Throwable th) {
                    builder.pop(iPushStyle);
                    throw th;
                }
            }
        }
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return annotatedString;
    }

    private static final NotificationPayload getInboxItemPayload(InboxNotificationModel inboxNotificationModel, Composer composer, int i) {
        NotificationPayload notificationPayloadBuildCommonPayload;
        ComposerKt.sourceInformationMarkerStart(composer, 1721310636, "C(getInboxItemPayload)N(notification):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1721310636, i, -1, "com.box.android.inbox.notifications.inboxitem.getInboxItemPayload (InboxItemContent.kt:119)");
        }
        InboxNotificationPayloadModel payload = inboxNotificationModel.getPayload();
        if (payload instanceof InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) {
            composer.startReplaceGroup(617117743);
            ComposerKt.sourceInformation(composer, "120@5163L35");
            notificationPayloadBuildCommonPayload = buildSendSharedLinkPayload((InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
            composer.startReplaceGroup(617120173);
            ComposerKt.sourceInformation(composer, "121@5239L33");
            notificationPayloadBuildCommonPayload = buildCollabInvitePayload((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) {
            composer.startReplaceGroup(617122541);
            ComposerKt.sourceInformation(composer, "122@5313L33");
            notificationPayloadBuildCommonPayload = buildNotifyCollabPayload((InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.AtMentionPayloadInboxModel) {
            composer.startReplaceGroup(617124810);
            ComposerKt.sourceInformation(composer, "123@5384L30");
            notificationPayloadBuildCommonPayload = buildAtMentionPayload((InboxNotificationPayloadModel.AtMentionPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) {
            composer.startReplaceGroup(617127052);
            ComposerKt.sourceInformation(composer, "124@5454L32");
            notificationPayloadBuildCommonPayload = buildTaskUpdatedPayload((InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.CommentPayloadInboxModel) {
            composer.startReplaceGroup(617129224);
            ComposerKt.sourceInformation(composer, "125@5522L28");
            notificationPayloadBuildCommonPayload = buildCommentPayload((InboxNotificationPayloadModel.CommentPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else if (payload instanceof InboxNotificationPayloadModel.EditFilePayloadInboxModel) {
            composer.startReplaceGroup(617131305);
            ComposerKt.sourceInformation(composer, "126@5587L29");
            notificationPayloadBuildCommonPayload = buildEditFilePayload((InboxNotificationPayloadModel.EditFilePayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (!(payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel)) {
                composer.startReplaceGroup(617115559);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(617133351);
            ComposerKt.sourceInformation(composer, "127@5651L27");
            notificationPayloadBuildCommonPayload = buildCommonPayload((InboxNotificationPayloadModel.CommonPayloadInboxModel) payload, composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayloadBuildCommonPayload;
    }

    private static final NotificationPayload buildSendSharedLinkPayload(InboxNotificationPayloadModel.SendSharedLinkPayloadInboxModel sendSharedLinkPayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1935156858, "C(buildSendSharedLinkPayload)N(payload)137@6050L55:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1935156858, i, -1, "com.box.android.inbox.notifications.inboxitem.buildSendSharedLinkPayload (InboxItemContent.kt:131)");
        }
        InboxNotificationUserModel sentBy = sendSharedLinkPayloadInboxModel.getSentBy();
        String name = sentBy != null ? sentBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(35102969);
            ComposerKt.sourceInformation(composer, "132@5836L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(35102225);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(" " + StringResources_androidKt.stringResource(R.string.inbox_notification_shared_link, composer, 6) + " ", false), new NotificationSegment(sendSharedLinkPayloadInboxModel.getSharedLink(), true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final NotificationPayload buildCollabInvitePayload(InboxNotificationPayloadModel.CollabInvitePayloadInboxModel collabInvitePayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1771343900, "C(buildCollabInvitePayload)N(payload)147@6438L63:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1771343900, i, -1, "com.box.android.inbox.notifications.inboxitem.buildCollabInvitePayload (InboxItemContent.kt:144)");
        }
        InboxNotificationUserModel invitedBy = collabInvitePayloadInboxModel.getInvitedBy();
        String name = invitedBy != null ? invitedBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(-1454434377);
            ComposerKt.sourceInformation(composer, "145@6334L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(-1454435214);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(getCollabInviteVerb(collabInvitePayloadInboxModel.getCollab().getStatus(), collabInvitePayloadInboxModel.getTarget().getType(), composer, 0), false), new NotificationSegment(collabInvitePayloadInboxModel.getTarget().getName(), true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final String getCollabInviteVerb(InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, String str, Composer composer, int i) {
        String str2;
        ComposerKt.sourceInformationMarkerStart(composer, 1000363035, "C(getCollabInviteVerb)N(status,itemType):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1000363035, i, -1, "com.box.android.inbox.notifications.inboxitem.getCollabInviteVerb (InboxItemContent.kt:159)");
        }
        if (inboxNotificationCollaborationStatus == InboxNotificationCollaborationStatus.ACCEPTED) {
            composer.startReplaceGroup(-962722307);
            ComposerKt.sourceInformation(composer, "");
            if (Intrinsics.areEqual(str, ItemType.FOLDER.getValue())) {
                composer.startReplaceGroup(-962678163);
                ComposerKt.sourceInformation(composer, "161@6955L59");
                str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_added_to_folder, composer, 6) + " ";
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-962583148);
                ComposerKt.sourceInformation(composer, "163@7051L52");
                str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_added_to, composer, 6) + " ";
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-962483731);
            ComposerKt.sourceInformation(composer, "");
            if (Intrinsics.areEqual(str, ItemType.FOLDER.getValue())) {
                composer.startReplaceGroup(-962440021);
                ComposerKt.sourceInformation(composer, "167@7195L61");
                str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_invited_to_folder, composer, 6) + " ";
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-962342650);
                ComposerKt.sourceInformation(composer, "169@7293L66");
                str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_invited_to_collaborate, composer, 6) + " ";
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str2;
    }

    private static final NotificationPayload buildNotifyCollabPayload(InboxNotificationPayloadModel.NotifyCollabPayloadInboxModel notifyCollabPayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1475451292, "C(buildNotifyCollabPayload)N(payload)177@7634L40:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1475451292, i, -1, "com.box.android.inbox.notifications.inboxitem.buildNotifyCollabPayload (InboxItemContent.kt:174)");
        }
        InboxNotificationUserModel sentBy = notifyCollabPayloadInboxModel.getSentBy();
        String name = sentBy != null ? sentBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(-569479721);
            ComposerKt.sourceInformation(composer, "175@7530L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(-569480465);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(getNotifyCollabVerb(notifyCollabPayloadInboxModel.getTarget().getType(), composer, 0), false), new NotificationSegment(notifyCollabPayloadInboxModel.getTarget().getName(), true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final String getNotifyCollabVerb(String str, Composer composer, int i) {
        String str2;
        ComposerKt.sourceInformationMarkerStart(composer, -82570933, "C(getNotifyCollabVerb)N(itemType):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-82570933, i, -1, "com.box.android.inbox.notifications.inboxitem.getNotifyCollabVerb (InboxItemContent.kt:188)");
        }
        if (Intrinsics.areEqual(str, ItemType.FOLDER.getValue())) {
            composer.startReplaceGroup(1145688173);
            ComposerKt.sourceInformation(composer, "189@7999L59");
            str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_added_to_folder, composer, 6) + " ";
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1145767316);
            ComposerKt.sourceInformation(composer, "191@8079L52");
            str2 = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_added_to, composer, 6) + " ";
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str2;
    }

    private static final NotificationPayload buildAtMentionPayload(InboxNotificationPayloadModel.AtMentionPayloadInboxModel atMentionPayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -93830172, "C(buildAtMentionPayload)N(payload)202@8552L64:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-93830172, i, -1, "com.box.android.inbox.notifications.inboxitem.buildAtMentionPayload (InboxItemContent.kt:195)");
        }
        InboxNotificationUserModel sentBy = atMentionPayloadInboxModel.getSentBy();
        String name = sentBy != null ? sentBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(23521943);
            ComposerKt.sourceInformation(composer, "196@8282L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(23521199);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(" " + StringResources_androidKt.stringResource(R.string.inbox_notification_mentioned_in_comment, composer, 6) + " ", false), new NotificationSegment(atMentionPayloadInboxModel.getTarget().getName(), true)}), atMentionPayloadInboxModel.getComment().getMessage());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final NotificationPayload buildTaskUpdatedPayload(InboxNotificationPayloadModel.TaskUpdatedPayloadInboxModel taskUpdatedPayloadInboxModel, Composer composer, int i) {
        TaskLinkModel taskLinkModel;
        InboxNotificationTargetItemModel target;
        InboxNotificationUserModel target2;
        ComposerKt.sourceInformationMarkerStart(composer, 1199582660, "C(buildTaskUpdatedPayload)N(payload)214@9124L74,216@9344L34:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1199582660, i, -1, "com.box.android.inbox.notifications.inboxitem.buildTaskUpdatedPayload (InboxItemContent.kt:210)");
        }
        List<TaskCollaboratorMiniModel> taskCollaborators = taskUpdatedPayloadInboxModel.getTask().getTaskCollaborators();
        if (taskCollaborators == null) {
            taskCollaborators = CollectionsKt.emptyList();
        }
        TaskCollaboratorMiniModel taskCollaboratorMiniModel = (TaskCollaboratorMiniModel) CollectionsKt.firstOrNull((List) taskCollaborators);
        String name = (taskCollaboratorMiniModel == null || (target2 = taskCollaboratorMiniModel.getTarget()) == null) ? null : target2.getName();
        if (name == null) {
            composer.startReplaceGroup(1747708567);
            ComposerKt.sourceInformation(composer, "212@8982L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(1747707172);
        }
        composer.endReplaceGroup();
        String strBuildTaskCollaboratorsText = buildTaskCollaboratorsText(name, RangesKt.coerceAtLeast(taskCollaborators.size() - 1, 0), composer, 0);
        List<TaskLinkModel> taskLinks = taskUpdatedPayloadInboxModel.getTask().getTaskLinks();
        String name2 = (taskLinks == null || (taskLinkModel = (TaskLinkModel) CollectionsKt.firstOrNull((List) taskLinks)) == null || (target = taskLinkModel.getTarget()) == null) ? null : target.getName();
        if (name2 == null) {
            composer.startReplaceGroup(1747717821);
            ComposerKt.sourceInformation(composer, "215@9271L57");
            name2 = StringResources_androidKt.stringResource(R.string.inbox_notification_task_fallback, composer, 6);
        } else {
            composer.startReplaceGroup(1747716116);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(strBuildTaskCollaboratorsText, true), new NotificationSegment(getTaskUpdatedVerb(taskUpdatedPayloadInboxModel.getStatus(), composer, 0), false), new NotificationSegment(name2, true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final String buildTaskCollaboratorsText(String str, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -201677674, "C(buildTaskCollaboratorsText)N(firstCollaboratorName,otherCollaboratorsCount):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-201677674, i2, -1, "com.box.android.inbox.notifications.inboxitem.buildTaskCollaboratorsText (InboxItemContent.kt:228)");
        }
        if (i == 0) {
            composer.startReplaceGroup(-538711509);
            composer.endReplaceGroup();
        } else if (i == 1) {
            composer.startReplaceGroup(-538710320);
            ComposerKt.sourceInformation(composer, "230@9815L62");
            str = str + " " + StringResources_androidKt.stringResource(R.string.inbox_notification_task_and_one_other, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-538706874);
            ComposerKt.sourceInformation(composer, "231@9922L84");
            str = str + " " + StringResources_androidKt.stringResource(R.string.inbox_notification_task_and_others, new Object[]{Integer.valueOf(i)}, composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str;
    }

    private static final String getTaskUpdatedVerb(InboxNotificationPayloadModel.TaskUpdatedPayloadInboxStatus taskUpdatedPayloadInboxStatus, Composer composer, int i) {
        String str;
        ComposerKt.sourceInformationMarkerStart(composer, -1651470668, "C(getTaskUpdatedVerb)N(status):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1651470668, i, -1, "com.box.android.inbox.notifications.inboxitem.getTaskUpdatedVerb (InboxItemContent.kt:235)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[taskUpdatedPayloadInboxStatus.ordinal()];
        if (i2 == 1) {
            composer.startReplaceGroup(2074591957);
            ComposerKt.sourceInformation(composer, "236@10175L58");
            str = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_task_completed, composer, 6) + " ";
            composer.endReplaceGroup();
        } else if (i2 == 2) {
            composer.startReplaceGroup(2074595540);
            ComposerKt.sourceInformation(composer, "237@10287L57");
            str = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_task_rejected, composer, 6) + " ";
            composer.endReplaceGroup();
        } else {
            if (i2 != 3) {
                composer.startReplaceGroup(2074590228);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(2074599092);
            ComposerKt.sourceInformation(composer, "238@10398L57");
            str = " " + StringResources_androidKt.stringResource(R.string.inbox_notification_task_approved, composer, 6) + " ";
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str;
    }

    private static final NotificationPayload buildCommentPayload(InboxNotificationPayloadModel.CommentPayloadInboxModel commentPayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1035589284, "C(buildCommentPayload)N(payload)248@10819L56:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1035589284, i, -1, "com.box.android.inbox.notifications.inboxitem.buildCommentPayload (InboxItemContent.kt:242)");
        }
        InboxNotificationUserModel sentBy = commentPayloadInboxModel.getSentBy();
        String name = sentBy != null ? sentBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(-1231106857);
            ComposerKt.sourceInformation(composer, "243@10602L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(-1231107601);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(" " + StringResources_androidKt.stringResource(R.string.inbox_notification_commented_on, composer, 6) + " ", false), new NotificationSegment(commentPayloadInboxModel.getTarget().getName(), true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final NotificationPayload buildEditFilePayload(InboxNotificationPayloadModel.EditFilePayloadInboxModel editFilePayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -847707580, "C(buildEditFilePayload)N(payload)261@11312L50:InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-847707580, i, -1, "com.box.android.inbox.notifications.inboxitem.buildEditFilePayload (InboxItemContent.kt:255)");
        }
        InboxNotificationUserModel sentBy = editFilePayloadInboxModel.getSentBy();
        String name = sentBy != null ? sentBy.getName() : null;
        if (name == null) {
            composer.startReplaceGroup(1396805815);
            ComposerKt.sourceInformation(composer, "256@11095L51");
            name = StringResources_androidKt.stringResource(R.string.inbox_notification_someone, composer, 6);
        } else {
            composer.startReplaceGroup(1396805071);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(CollectionsKt.listOf((Object[]) new NotificationSegment[]{new NotificationSegment(name, true), new NotificationSegment(" " + StringResources_androidKt.stringResource(R.string.inbox_notification_edited, composer, 6) + " ", false), new NotificationSegment(editFilePayloadInboxModel.getTarget().getName(), true)}), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    private static final NotificationPayload buildCommonPayload(InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1136269326, "C(buildCommonPayload)N(payload):InboxItemContent.kt#2fg1pg");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1136269326, i, -1, "com.box.android.inbox.notifications.inboxitem.buildCommonPayload (InboxItemContent.kt:268)");
        }
        composer.startReplaceGroup(1033133100);
        ComposerKt.sourceInformation(composer, "*272@11693L60");
        List<TextAtomModel> atoms = commonPayloadInboxModel.getTitle().getAtoms();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(atoms, 10));
        for (TextAtomModel textAtomModel : atoms) {
            arrayList.add(new NotificationSegment(textAtomModel.getValue(), Intrinsics.areEqual(textAtomModel.getFontWeight(), StringResources_androidKt.stringResource(R.string.inbox_notification_bold_font_weight, composer, 6))));
        }
        ArrayList arrayList2 = arrayList;
        composer.endReplaceGroup();
        TextModel message = commonPayloadInboxModel.getMessage();
        String strJoinToString$default = null;
        List<TextAtomModel> atoms2 = message != null ? message.getAtoms() : null;
        if (atoms2 == null) {
            composer.startReplaceGroup(1962585142);
        } else {
            composer.startReplaceGroup(1033140523);
            ComposerKt.sourceInformation(composer, "275@11833L12");
            List<TextAtomModel> list = atoms2;
            ComposerKt.sourceInformationMarkerStart(composer, 1033141050, "CC(remember):InboxItemContent.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InboxItemContentKt.buildCommonPayload$lambda$1$0((TextAtomModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            strJoinToString$default = CollectionsKt.joinToString$default(list, str, null, null, 0, null, (Function1) objRememberedValue, 30, null);
        }
        composer.endReplaceGroup();
        NotificationPayload notificationPayload = new NotificationPayload(arrayList2, strJoinToString$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notificationPayload;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCommonPayload$lambda$1$0(TextAtomModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }

    private static final void InboxItemTitlePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(548520937);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemTitlePreview)288@12231L192:InboxItemContent.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(548520937, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTitlePreview (InboxItemContent.kt:287)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemContentKt.INSTANCE.m12670getLambda$1705619266$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemTitlePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void InboxItemDescriptionPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(852676045);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemDescriptionPreview)302@12532L198:InboxItemContent.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(852676045, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemDescriptionPreview (InboxItemContent.kt:301)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemContentKt.INSTANCE.m12671getLambda$848451870$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemDescriptionPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void InboxItemTimestampPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(991690279);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemTimestampPreview)316@12837L196:InboxItemContent.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(991690279, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemTimestampPreview (InboxItemContent.kt:315)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemContentKt.INSTANCE.getLambda$55842940$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemContentKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemContentKt.InboxItemTimestampPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
