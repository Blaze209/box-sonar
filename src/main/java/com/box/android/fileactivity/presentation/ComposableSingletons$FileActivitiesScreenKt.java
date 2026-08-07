package com.box.android.fileactivity.presentation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.fileactivity.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FileActivitiesScreenKt {
    public static final ComposableSingletons$FileActivitiesScreenKt INSTANCE = new ComposableSingletons$FileActivitiesScreenKt();

    /* JADX INFO: renamed from: lambda$-1842365905, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f233lambda$1842365905 = ComposableLambdaKt.composableLambdaInstance(-1842365905, false, new Function2() { // from class: com.box.android.fileactivity.presentation.ComposableSingletons$FileActivitiesScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FileActivitiesScreenKt.lambda__1842365905$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1726490138, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f232lambda$1726490138 = ComposableLambdaKt.composableLambdaInstance(-1726490138, false, new Function2() { // from class: com.box.android.fileactivity.presentation.ComposableSingletons$FileActivitiesScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FileActivitiesScreenKt.lambda__1726490138$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1726490138$file_activity_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12594getLambda$1726490138$file_activity_generalProdRelease() {
        return f232lambda$1726490138;
    }

    /* JADX INFO: renamed from: getLambda$-1842365905$file_activity_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12595getLambda$1842365905$file_activity_generalProdRelease() {
        return f233lambda$1842365905;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1842365905$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C262@11168L6,259@11013L192:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1842365905, i, -1, "com.box.android.fileactivity.presentation.ComposableSingletons$FileActivitiesScreenKt.lambda$-1842365905.<anonymous> (FileActivitiesScreen.kt:259)");
            }
            IconKt.m3576Iconww6aTOc(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), CommonBoxUtil.LS(R.string.more_actions_for_comment), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1726490138$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C922@35007L217:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1726490138, i, -1, "com.box.android.fileactivity.presentation.ComposableSingletons$FileActivitiesScreenKt.lambda$-1726490138.<anonymous> (FileActivitiesScreen.kt:922)");
            }
            String upperCase = CommonBoxUtil.LS(R.string.file_activity_resolved_status).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m4494TextNvy7gAk(upperCase, PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(8), Dp.m9687constructorimpl(2)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold10(), composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
