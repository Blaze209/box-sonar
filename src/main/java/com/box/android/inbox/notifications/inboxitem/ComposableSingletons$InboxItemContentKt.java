package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.box.android.utilities.PreviewModels;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InboxItemContent.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemContentKt {
    public static final ComposableSingletons$InboxItemContentKt INSTANCE = new ComposableSingletons$InboxItemContentKt();

    /* JADX INFO: renamed from: lambda$-1705619266, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f236lambda$1705619266 = ComposableLambdaKt.composableLambdaInstance(-1705619266, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemContentKt.lambda__1705619266$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-848451870, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f237lambda$848451870 = ComposableLambdaKt.composableLambdaInstance(-848451870, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemContentKt.lambda__848451870$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$55842940 = ComposableLambdaKt.composableLambdaInstance(55842940, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemContentKt.lambda_55842940$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1705619266$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12670getLambda$1705619266$box_generalProdRelease() {
        return f236lambda$1705619266;
    }

    /* JADX INFO: renamed from: getLambda$-848451870$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12671getLambda$848451870$box_generalProdRelease() {
        return f237lambda$848451870;
    }

    public final Function2<Composer, Integer, Unit> getLambda$55842940$box_generalProdRelease() {
        return lambda$55842940;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1705619266$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C291@12300L117:InboxItemContent.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1705619266, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt.lambda$-1705619266.<anonymous> (InboxItemContent.kt:289)");
            }
            InboxItemContentKt.InboxItemTitle(PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION(), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__848451870$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C305@12601L123:InboxItemContent.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-848451870, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt.lambda$-848451870.<anonymous> (InboxItemContent.kt:303)");
            }
            InboxItemContentKt.InboxItemDescription(PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION(), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_55842940$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C319@12906L121:InboxItemContent.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(55842940, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemContentKt.lambda$55842940.<anonymous> (InboxItemContent.kt:317)");
            }
            InboxItemContentKt.InboxItemTimestamp(PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION(), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
