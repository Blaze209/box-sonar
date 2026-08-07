package com.box.android.inbox.notifications.inboxitem;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.utilities.PreviewModels;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.views.DefaultAvatarController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InboxItemAvatar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemAvatarKt {
    public static final ComposableSingletons$InboxItemAvatarKt INSTANCE = new ComposableSingletons$InboxItemAvatarKt();

    /* JADX INFO: renamed from: lambda$-1041561839, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f234lambda$1041561839 = ComposableLambdaKt.composableLambdaInstance(-1041561839, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemAvatarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemAvatarKt.lambda__1041561839$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1041561839$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12667getLambda$1041561839$box_generalProdRelease() {
        return f234lambda$1041561839;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1041561839$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C140@6807L7,136@6589L370:InboxItemAvatar.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1041561839, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemAvatarKt.lambda$-1041561839.<anonymous> (InboxItemAvatar.kt:136)");
            }
            InboxNotificationModel mock_notification = PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxItemAvatarKt.InboxItemAvatar(mock_notification, new DefaultAvatarControllerWrapper(new DefaultAvatarController(new BoxSession((Context) objConsume, false))), false, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
