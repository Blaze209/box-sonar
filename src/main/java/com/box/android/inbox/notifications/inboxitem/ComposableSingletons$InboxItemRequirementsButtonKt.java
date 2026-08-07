package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemRequirementsButton.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemRequirementsButtonKt {
    public static final ComposableSingletons$InboxItemRequirementsButtonKt INSTANCE = new ComposableSingletons$InboxItemRequirementsButtonKt();

    /* JADX INFO: renamed from: lambda$-652823967, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f240lambda$652823967 = ComposableLambdaKt.composableLambdaInstance(-652823967, false, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemRequirementsButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InboxItemRequirementsButtonKt.lambda__652823967$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1154800281, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f239lambda$1154800281 = ComposableLambdaKt.composableLambdaInstance(-1154800281, false, new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemRequirementsButtonKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxItemRequirementsButtonKt.lambda__1154800281$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1154800281$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12674getLambda$1154800281$box_generalProdRelease() {
        return f239lambda$1154800281;
    }

    /* JADX INFO: renamed from: getLambda$-652823967$box_generalProdRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m12675getLambda$652823967$box_generalProdRelease() {
        return f240lambda$652823967;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__652823967$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C33@1315L43,32@1290L162:InboxItemRequirementsButton.kt#2fg1pg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652823967, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemRequirementsButtonKt.lambda$-652823967.<anonymous> (InboxItemRequirementsButton.kt:32)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.inbox_view_details, composer, 6), null, Color.INSTANCE.m6851getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 384, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1154800281$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@1716L3,47@1654L123:InboxItemRequirementsButton.kt#2fg1pg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1154800281, i, -1, "com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemRequirementsButtonKt.lambda$-1154800281.<anonymous> (InboxItemRequirementsButton.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1661505366, "CC(remember):InboxItemRequirementsButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.ComposableSingletons$InboxItemRequirementsButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxItemRequirementsButtonKt.InboxItemRequirementsButton((Function0) objRememberedValue, PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer, 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
