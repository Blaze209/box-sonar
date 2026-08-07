package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.domain.models.inboxnotifications.ActionHandlerModel;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.ActionStyleLevel;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InboxItemCommonCardActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemCommonCardActionsKt {
    public static final ComposableSingletons$InboxItemCommonCardActionsKt INSTANCE = new ComposableSingletons$InboxItemCommonCardActionsKt();

    /* JADX INFO: renamed from: lambda$-415966017, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f235lambda$415966017 = ComposableLambdaKt.composableLambdaInstance(-415966017, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemCommonCardActionsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemCommonCardActionsKt.lambda__415966017$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-415966017$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12668getLambda$415966017$box_generalProdRelease() {
        return f235lambda$415966017;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__415966017$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C141@5393L3,142@5429L3,110@4261L1211:InboxItemCommonCardActions.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-415966017, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemCommonCardActionsKt.lambda$-415966017.<anonymous> (InboxItemCommonCardActions.kt:110)");
            }
            ActionModel actionModel = new ActionModel(Analytics.Data.ACTION, true, null, "Accept", ActionStyleLevel.SUCCESS, new ActionHandlerModel("post-action-handler", null, "accept", null, null, null));
            ActionModel actionModel2 = new ActionModel(Analytics.Data.ACTION, false, null, "Decline", ActionStyleLevel.DEFAULT, new ActionHandlerModel("post-action-handler", null, "decline", null, null, null));
            ComposerKt.sourceInformationMarkerStart(composer, -311347262, "CC(remember):InboxItemCommonCardActions.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemCommonCardActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -311346110, "CC(remember):InboxItemCommonCardActions.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemCommonCardActionsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxItemCommonCardActionsKt.InboxItemCommonCardActions(actionModel, actionModel2, function0, (Function0) objRememberedValue2, null, true, composer, 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
