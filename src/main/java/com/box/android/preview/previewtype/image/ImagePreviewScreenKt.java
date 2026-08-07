package com.box.android.preview.previewtype.image;

import android.content.Context;
import android.net.Uri;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt;
import com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt;
import com.box.android.preview.integration.nutrient.NutrientPdfViewConfigurator;
import com.box.android.preview.integration.nutrient.NutrientPdfViewKt;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.page.PageFitMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: ImagePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"ImagePreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "getPdfAnnotationManager", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "(Lcom/box/android/cpl/Store;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImagePreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreviewScreen$lambda$8(Store store, SnackbarHostState snackbarHostState, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        ImagePreviewScreen(store, snackbarHostState, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ImagePreviewScreen(final Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> store, final SnackbarHostState snackbarHostState, final Function1<? super ItemId, BoxPdfAnnotationManager> getPdfAnnotationManager, final Function1<? super ItemId, CreateAnnotationsManager> getCreateAnnotationManager, Composer composer, final int i) {
        int i2;
        String str;
        int i3;
        Function0 function0;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(getPdfAnnotationManager, "getPdfAnnotationManager");
        Intrinsics.checkNotNullParameter(getCreateAnnotationManager, "getCreateAnnotationManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(760314679);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImagePreviewScreen)N(store,snackbarHostState,getPdfAnnotationManager,getCreateAnnotationManager)30@1534L7,31@1571L29,32@1641L147,32@1630L158,38@1835L228,38@1824L239,72@3207L88,74@3301L59,76@3389L135,76@3366L158:ImagePreviewScreen.kt#205h4q");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getPdfAnnotationManager) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getCreateAnnotationManager) ? 2048 : 1024;
        }
        int i4 = i2;
        if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(760314679, i4, -1, "com.box.android.preview.previewtype.image.ImagePreviewScreen (ImagePreviewScreen.kt:29)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 517979658, "CC(remember):ImagePreviewScreen.kt#9igjgp");
            int i5 = i4 & 14;
            boolean z = i5 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ImagePreviewScreenKt.ImagePreviewScreen$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 517985947, "CC(remember):ImagePreviewScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | (i5 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ImagePreviewScreenKt.ImagePreviewScreen$lambda$2$0(stateCollectAsStateWithLifecycle, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0 function0Remembered2 = ComposeUtilsKt.remembered((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            if (!NutrientPdfViewConfigurator.INSTANCE.isEnvironmentSetUp(context)) {
                str = "CC(remember):ImagePreviewScreen.kt#9igjgp";
                i3 = 0;
                function0 = function0Remembered;
                composerStartRestartGroup.startReplaceGroup(-1124133205);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1121987013);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2202L127,52@2366L55,53@2460L58,59@2670L72,55@2528L667");
                Uri uri = Uri.parse(ImagePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getUrl().toString());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 517997590, "CC(remember):ImagePreviewScreen.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = NutrientPdfViewConfigurator.INSTANCE.createPdfActivityConfiguration(context, PageFitMode.FIT_TO_SCREEN);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 518002766, "CC(remember):ImagePreviewScreen.kt#9igjgp");
                BoxPdfAnnotationManager boxPdfAnnotationManagerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (boxPdfAnnotationManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    boxPdfAnnotationManagerRememberedValue = getPdfAnnotationManager.invoke(ImagePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFile().getItemId());
                    composerStartRestartGroup.updateRememberedValue(boxPdfAnnotationManagerRememberedValue);
                }
                BoxPdfAnnotationManager boxPdfAnnotationManager = (BoxPdfAnnotationManager) boxPdfAnnotationManagerRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 518005777, "CC(remember):ImagePreviewScreen.kt#9igjgp");
                CreateAnnotationsManager createAnnotationsManagerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (createAnnotationsManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    createAnnotationsManagerRememberedValue = getCreateAnnotationManager.invoke(ImagePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFile().getItemId());
                    composerStartRestartGroup.updateRememberedValue(createAnnotationsManagerRememberedValue);
                }
                CreateAnnotationsManager createAnnotationsManager = (CreateAnnotationsManager) createAnnotationsManagerRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ItemId itemId = ImagePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFile().getItemId();
                Intrinsics.checkNotNull(uri);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 518012511, "CC(remember):ImagePreviewScreen.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ImagePdfFragmentBuilder(pdfActivityConfiguration);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function0 = function0Remembered;
                i3 = 0;
                str = "CC(remember):ImagePreviewScreen.kt#9igjgp";
                NutrientPdfViewKt.NutrientPdfView(pdfActivityConfiguration, uri, itemId, (ImagePdfFragmentBuilder) objRememberedValue4, new BoxImageDocumentListener(store, function0Remembered, boxPdfAnnotationManager, createAnnotationsManager), boxPdfAnnotationManager, createAnnotationsManager, null, null, function0, function0Remembered2, null, composerStartRestartGroup, PdfActivityConfiguration.$stable | 113246208 | (PdfActivityConfiguration.$stable << 9), 0, 2048);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            AnnotationsOverlayKt.AnnotationMessaging((Store) function0.invoke(), snackbarHostState, composerStartRestartGroup, i4 & 112);
            CreateAnnotationDialogsKt.CreateAnnotationDialogs((Store) function0Remembered2.invoke(), composerStartRestartGroup, i3);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 518035582, str);
            int i6 = i5 != 4 ? i3 : 1;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (i6 != 0 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImagePreviewScreenKt.ImagePreviewScreen$lambda$7$0(store, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagePreviewScreenKt.ImagePreviewScreen$lambda$8(store, snackbarHostState, getPdfAnnotationManager, getCreateAnnotationManager, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store ImagePreviewScreen$lambda$1$0(Store store) {
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ImagePreviewReducer.State) obj).getAnnotationsState();
            }
        }, ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$2.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store ImagePreviewScreen$lambda$2$0(State state, Store store) {
        if (ImagePreviewScreen$lambda$0(state).getCreateAnnotationState() != null) {
            return store.ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ImagePreviewReducer.State) obj).getCreateAnnotationState();
                }
            }, ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$2.INSTANCE);
        }
        return null;
    }

    private static final ImagePreviewReducer.State ImagePreviewScreen$lambda$0(State<ImagePreviewReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ImagePreviewScreen$lambda$7$0(final Store store, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.image.ImagePreviewScreenKt$ImagePreviewScreen$lambda$7$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                store.send(new ImagePreviewReducer.Action.Annotations(AnnotationsReducer.Action.Release.INSTANCE));
            }
        };
    }
}
