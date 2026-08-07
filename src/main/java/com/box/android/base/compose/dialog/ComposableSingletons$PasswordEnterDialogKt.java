package com.box.android.base.compose.dialog;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PasswordEnterDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PasswordEnterDialogKt {
    public static final ComposableSingletons$PasswordEnterDialogKt INSTANCE = new ComposableSingletons$PasswordEnterDialogKt();

    /* JADX INFO: renamed from: lambda$-641322112, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f178lambda$641322112 = ComposableLambdaKt.composableLambdaInstance(-641322112, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$PasswordEnterDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PasswordEnterDialogKt.lambda__641322112$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-641322112$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11722getLambda$641322112$base_generalProdRelease() {
        return f178lambda$641322112;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__641322112$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C30@1228L51,33@1434L6,29@1199L266:PasswordEnterDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-641322112, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$PasswordEnterDialogKt.lambda$-641322112.<anonymous> (PasswordEnterDialog.kt:29)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.password_prompt_title, composer, 0), TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogTitle"), BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal24(), composer, 48, 12582912, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
