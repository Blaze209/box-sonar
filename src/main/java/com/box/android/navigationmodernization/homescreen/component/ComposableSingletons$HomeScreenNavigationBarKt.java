package com.box.android.navigationmodernization.homescreen.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigationBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$HomeScreenNavigationBarKt {
    public static final ComposableSingletons$HomeScreenNavigationBarKt INSTANCE = new ComposableSingletons$HomeScreenNavigationBarKt();

    /* JADX INFO: renamed from: lambda$-657446497, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f242lambda$657446497 = ComposableLambdaKt.composableLambdaInstance(-657446497, false, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.ComposableSingletons$HomeScreenNavigationBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HomeScreenNavigationBarKt.lambda__657446497$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-657446497$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12744getLambda$657446497$box_generalProdRelease() {
        return f242lambda$657446497;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__657446497$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@6109L3,137@5672L450:HomeScreenNavigationBar.kt#tptr0a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-657446497, i, -1, "com.box.android.navigationmodernization.homescreen.component.ComposableSingletons$HomeScreenNavigationBarKt.lambda$-657446497.<anonymous> (HomeScreenNavigationBar.kt:137)");
            }
            HomeNavigationBarDestination.Browse browse = HomeNavigationBarDestination.Browse.INSTANCE;
            List listListOf = CollectionsKt.listOf((Object[]) new HomeNavigationBarDestination[]{HomeNavigationBarDestination.Browse.INSTANCE, HomeNavigationBarDestination.Notes.INSTANCE, HomeNavigationBarDestination.Hubs.INSTANCE, HomeNavigationBarDestination.Collections.INSTANCE, HomeNavigationBarDestination.BoxAi.INSTANCE});
            ComposerKt.sourceInformationMarkerStart(composer, -445876798, "CC(remember):HomeScreenNavigationBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.navigationmodernization.homescreen.component.ComposableSingletons$HomeScreenNavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$HomeScreenNavigationBarKt.lambda__657446497$lambda$0$0$0((HomeNavigationBarDestination) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            HomeScreenNavigationBarKt.HomeScreenNavigationBar(browse, listListOf, (Function1) objRememberedValue, composer, 438);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__657446497$lambda$0$0$0(HomeNavigationBarDestination it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
