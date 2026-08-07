package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CollectionItemsListScreenKt {
    public static final ComposableSingletons$CollectionItemsListScreenKt INSTANCE = new ComposableSingletons$CollectionItemsListScreenKt();

    /* JADX INFO: renamed from: lambda$-60776023, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f223lambda$60776023 = ComposableLambdaKt.composableLambdaInstance(-60776023, false, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.ComposableSingletons$CollectionItemsListScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CollectionItemsListScreenKt.lambda__60776023$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-60776023$collections_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12391getLambda$60776023$collections_generalProdRelease() {
        return f223lambda$60776023;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__60776023$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C355@13657L3,357@13726L3,358@13761L3,344@13184L590:CollectionItemsListScreen.kt#avvpft");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-60776023, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.ComposableSingletons$CollectionItemsListScreenKt.lambda$-60776023.<anonymous> (CollectionItemsListScreen.kt:344)");
            }
            CollectionItemsListReducer.State state = new CollectionItemsListReducer.State(new CollectionModel("1", CollectionType.FAVORITES, "Favorites", null, null), null, CollectionItemsListReducer.LoadingState.Loaded.INSTANCE, false, null, null, null, 122, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1723799500, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.ComposableSingletons$CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$CollectionItemsListScreenKt.lambda__60776023$lambda$0$0$0((CollectionItemsListReducer.Action) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1723801708, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.ComposableSingletons$CollectionItemsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1723802828, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.ComposableSingletons$CollectionItemsListScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh(state, function1, false, function0, (Function0) objRememberedValue3, null, composer, 28080, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__60776023$lambda$0$0$0(CollectionItemsListReducer.Action it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
