package com.box.android.browse.search.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesRecentSearchQueries.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FilesRecentSearchQueriesKt {
    public static final ComposableSingletons$FilesRecentSearchQueriesKt INSTANCE = new ComposableSingletons$FilesRecentSearchQueriesKt();
    private static Function2<Composer, Integer, Unit> lambda$869976111 = ComposableLambdaKt.composableLambdaInstance(869976111, false, new Function2() { // from class: com.box.android.browse.search.component.ComposableSingletons$FilesRecentSearchQueriesKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FilesRecentSearchQueriesKt.lambda_869976111$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$869976111$browse_generalProdRelease() {
        return lambda$869976111;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_869976111$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4000L3,108@4050L3,105@3860L203:FilesRecentSearchQueries.kt#8xusuk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(869976111, i, -1, "com.box.android.browse.search.component.ComposableSingletons$FilesRecentSearchQueriesKt.lambda$869976111.<anonymous> (FilesRecentSearchQueries.kt:105)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"Query 1", "Query 2", "Query 3"});
            ComposerKt.sourceInformationMarkerStart(composer, -1471575246, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.search.component.ComposableSingletons$FilesRecentSearchQueriesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$FilesRecentSearchQueriesKt.lambda_869976111$lambda$0$0$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1471573646, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.search.component.ComposableSingletons$FilesRecentSearchQueriesKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$FilesRecentSearchQueriesKt.lambda_869976111$lambda$0$1$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FilesRecentSearchQueriesKt.FilesRecentSearchQueries(listListOf, function1, (Function1) objRememberedValue2, null, composer, 438, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_869976111$lambda$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_869976111$lambda$0$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
