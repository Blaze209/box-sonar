package com.box.android.search.presentation.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.domain.models.boxai.AiRecentSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SearchScreenKt {
    public static final ComposableSingletons$SearchScreenKt INSTANCE = new ComposableSingletons$SearchScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$892582132 = ComposableLambdaKt.composableLambdaInstance(892582132, false, new Function2() { // from class: com.box.android.search.presentation.ui.ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SearchScreenKt.lambda_892582132$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$892582132$search_generalProdRelease() {
        return lambda$892582132;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_892582132$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C797@32182L2,798@32214L2,801@32414L2,794@32012L414:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892582132, i, -1, "com.box.android.search.presentation.ui.ComposableSingletons$SearchScreenKt.lambda$892582132.<anonymous> (SearchScreen.kt:794)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"brand design", "FY26 Goals"});
            List listListOf2 = CollectionsKt.listOf(new AiRecentSession("1", "Provide brief outline of investor decks"));
            ComposerKt.sourceInformationMarkerStart(composer, -1222024586, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SearchScreenKt.lambda_892582132$lambda$0$0$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1222023562, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SearchScreenKt.lambda_892582132$lambda$0$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1222017162, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.search.presentation.ui.ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SearchScreenKt.lambda_892582132$lambda$0$2$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SearchScreenKt.SearchRecentsScreen("Recent Searches", "Recent AI Sessions", listListOf, function1, function2, listListOf2, (Function1) objRememberedValue3, composer, 1600950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_892582132$lambda$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_892582132$lambda$0$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_892582132$lambda$0$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
