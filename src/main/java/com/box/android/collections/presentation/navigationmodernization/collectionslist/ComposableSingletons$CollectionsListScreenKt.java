package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CollectionsListScreenKt {
    public static final ComposableSingletons$CollectionsListScreenKt INSTANCE = new ComposableSingletons$CollectionsListScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$382700579 = ComposableLambdaKt.composableLambdaInstance(382700579, false, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CollectionsListScreenKt.lambda_382700579$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-55518788, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f224lambda$55518788 = ComposableLambdaKt.composableLambdaInstance(-55518788, false, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CollectionsListScreenKt.lambda__55518788$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-55518788$collections_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12399getLambda$55518788$collections_generalProdRelease() {
        return f224lambda$55518788;
    }

    public final Function2<Composer, Integer, Unit> getLambda$382700579$collections_generalProdRelease() {
        return lambda$382700579;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_382700579$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C305@11186L3,298@10890L309:CollectionsListScreen.kt#60bvu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(382700579, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt.lambda$382700579.<anonymous> (CollectionsListScreen.kt:268)");
            }
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new CollectionsListReducer.State(CollectionsKt.listOf((Object[]) new CollectionModel[]{new CollectionModel("1", CollectionType.FAVORITES, "Favorites", null, null), new CollectionModel("2", CollectionType.PERSONAL, "Q1 2026 Reports", null, null), new CollectionModel(ExifInterface.GPS_MEASUREMENT_3D, CollectionType.PERSONAL, "Annual Planning  and Marketing strategy overview 2026", null, null), new CollectionModel(GrpcStatusUtil.GRPC_STATUS_DEADLINE_EXCEEDED, CollectionType.PERSONAL, "Architecture Diagrams", null, null)}), CollectionsListReducer.LoadingState.Loaded.INSTANCE, false, null, 12, null));
            ComposerKt.sourceInformationMarkerStart(composer, -1591889562, "CC(remember):CollectionsListScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$CollectionsListScreenKt.lambda_382700579$lambda$0$0$0((CollectionModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollectionsListScreenKt.CollectionsListScreen(storeCreateMockStore, (Function1) objRememberedValue, null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_382700579$lambda$0$0$0(CollectionModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__55518788$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C321@11608L3,314@11312L309:CollectionsListScreen.kt#60bvu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-55518788, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt.lambda$-55518788.<anonymous> (CollectionsListScreen.kt:314)");
            }
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new CollectionsListReducer.State(CollectionsKt.emptyList(), CollectionsListReducer.LoadingState.Loaded.INSTANCE, false, null, 12, null));
            ComposerKt.sourceInformationMarkerStart(composer, -1813937921, "CC(remember):CollectionsListScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.ComposableSingletons$CollectionsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$CollectionsListScreenKt.lambda__55518788$lambda$0$0$0((CollectionModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollectionsListScreenKt.CollectionsListScreen(storeCreateMockStore, (Function1) objRememberedValue, null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__55518788$lambda$0$0$0(CollectionModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
