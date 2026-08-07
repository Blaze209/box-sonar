package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.utilities.PreviewModels;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemMenuActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemMenuActionsKt {
    public static final ComposableSingletons$InboxItemMenuActionsKt INSTANCE = new ComposableSingletons$InboxItemMenuActionsKt();

    /* JADX INFO: renamed from: lambda$-737246617, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f238lambda$737246617 = ComposableLambdaKt.composableLambdaInstance(-737246617, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemMenuActionsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemMenuActionsKt.lambda__737246617$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-737246617$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12673getLambda$737246617$box_generalProdRelease() {
        return f238lambda$737246617;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__737246617$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3029L3,75@2851L236:InboxItemMenuActions.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-737246617, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemMenuActionsKt.lambda$-737246617.<anonymous> (InboxItemMenuActions.kt:73)");
            }
            InboxNotificationModel inboxNotificationModelCopy$default = InboxNotificationModel.copy$default(PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION(), null, null, null, false, false, PreviewModels.Inbox.INSTANCE.getMOCK_COMMON_PAYLOAD(), null, null, 223, null);
            String id = inboxNotificationModelCopy$default.getId();
            InboxNotificationPayloadModel payload = inboxNotificationModelCopy$default.getPayload();
            Intrinsics.checkNotNull(payload, "null cannot be cast to non-null type com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CommonPayloadInboxModel");
            InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload;
            ComposerKt.sourceInformationMarkerStart(composer, 175613674, "CC(remember):InboxItemMenuActions.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemMenuActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$InboxItemMenuActionsKt.lambda__737246617$lambda$0$0$0((ActionModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxItemMenuActionsKt.InboxItemMenuActions(id, commonPayloadInboxModel, (Function1) objRememberedValue, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__737246617$lambda$0$0$0(ActionModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
