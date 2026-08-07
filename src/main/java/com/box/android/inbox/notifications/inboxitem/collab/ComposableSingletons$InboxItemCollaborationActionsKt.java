package com.box.android.inbox.notifications.inboxitem.collab;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaborationActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemCollaborationActionsKt {
    public static final ComposableSingletons$InboxItemCollaborationActionsKt INSTANCE = new ComposableSingletons$InboxItemCollaborationActionsKt();

    /* JADX INFO: renamed from: lambda$-2004083978, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f241lambda$2004083978 = ComposableLambdaKt.composableLambdaInstance(-2004083978, false, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.ComposableSingletons$InboxItemCollaborationActionsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InboxItemCollaborationActionsKt.lambda__2004083978$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1097741108 = ComposableLambdaKt.composableLambdaInstance(1097741108, false, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.ComposableSingletons$InboxItemCollaborationActionsKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InboxItemCollaborationActionsKt.lambda_1097741108$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2004083978$box_generalProdRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12685getLambda$2004083978$box_generalProdRelease() {
        return f241lambda$2004083978;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1097741108$box_generalProdRelease() {
        return lambda$1097741108;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2004083978$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C47@1751L51,48@1837L6,46@1722L215:InboxItemCollaborationActions.kt#46vz6n");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004083978, i, -1, "com.box.android.inbox.notifications.inboxitem.collab.ComposableSingletons$InboxItemCollaborationActionsKt.lambda$-2004083978.<anonymous> (InboxItemCollaborationActions.kt:46)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.inbox_collaboration_accept, composer, 6), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11535getMainActiveControlContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1097741108$lambda$0(RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C67@2517L52,68@2604L6,66@2488L209:InboxItemCollaborationActions.kt#46vz6n");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097741108, i, -1, "com.box.android.inbox.notifications.inboxitem.collab.ComposableSingletons$InboxItemCollaborationActionsKt.lambda$1097741108.<anonymous> (InboxItemCollaborationActions.kt:66)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.inbox_collaboration_decline, composer, 6), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
