package com.box.android.preview.previewtype.document;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.base.compose.ImmutableWrapperKt;
import com.box.android.base.presentation.views.TouchInterceptorViewGroup;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt;
import com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt;
import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import com.box.android.preview.integration.nutrient.NutrientPdfInitializeHelperKt;
import com.box.android.preview.integration.nutrient.NutrientPdfViewConfigurator;
import com.box.android.preview.integration.nutrient.NutrientPdfViewKt;
import com.box.android.preview.previewtype.document.copytext.SelectedTextOverlayKt;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import com.box.android.preview.previewtype.document.print.PrintOverlayKt;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0013H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0091\u0001\u0010\u0019\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0013H\u0003¢\u0006\u0002\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0002\u0010#\u001a\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0010\u0010'\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0010\u0010(\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0010\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0002¨\u0006*²\u0006\n\u0010+\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\f\u0010,\u001a\u0004\u0018\u00010-X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\u0012\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/X\u008a\u008e\u0002"}, d2 = {"DocumentPreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "shouldShowPageLabel", "", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "getTextSelectionManager", "Lkotlin/Function0;", "Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "getSearchResultHighlighter", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "getCitationResultHighlighter", "getTextSearchManager", "Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "getPdfAnnotationManager", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "(Lcom/box/android/cpl/Store;ZLandroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "NutrientDocumentView", "documentViewHeight", "", "(Lcom/box/android/cpl/Store;FLandroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PageNumberLabel", "pageScrollDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "pageNumber", "", "pageCount", "(Lcom/pspdfkit/configuration/page/PageScrollDirection;IILandroidx/compose/runtime/Composer;I)V", "showOutline", "activity", "Landroidx/fragment/app/FragmentActivity;", "showThumbnails", "showPageView", "hidePageView", "preview_generalProdRelease", "state", "selectedTextViewBoundingBox", "Landroid/graphics/RectF;", "pdfUiFragmentWrapper", "Lcom/box/android/base/compose/ImmutableWrapper;", "Lcom/pspdfkit/ui/PdfUiFragment;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentPreviewScreenKt {

    /* JADX INFO: compiled from: DocumentPreviewScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageScrollDirection.values().length];
            try {
                iArr[PageScrollDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageScrollDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentPreviewScreen$lambda$6(Store store, boolean z, SnackbarHostState snackbarHostState, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function1 function4, Function1 function5, int i, Composer composer, int i2) {
        DocumentPreviewScreen(store, z, snackbarHostState, function0, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientDocumentView$lambda$25(Store store, float f, SnackbarHostState snackbarHostState, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function1 function4, Function1 function5, int i, Composer composer, int i2) {
        NutrientDocumentView(store, f, snackbarHostState, function0, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageNumberLabel$lambda$1(PageScrollDirection pageScrollDirection, int i, int i2, int i3, Composer composer, int i4) {
        PageNumberLabel(pageScrollDirection, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void DocumentPreviewScreen(final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store, final boolean z, final SnackbarHostState snackbarHostState, final Function0<TextSelectionManager> getTextSelectionManager, final Function0<SearchResultHighlighter> getSearchResultHighlighter, final Function0<SearchResultHighlighter> getCitationResultHighlighter, final Function0<TextSearchManager> getTextSearchManager, final Function1<? super ItemId, BoxPdfAnnotationManager> getPdfAnnotationManager, final Function1<? super ItemId, CreateAnnotationsManager> getCreateAnnotationManager, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(getTextSelectionManager, "getTextSelectionManager");
        Intrinsics.checkNotNullParameter(getSearchResultHighlighter, "getSearchResultHighlighter");
        Intrinsics.checkNotNullParameter(getCitationResultHighlighter, "getCitationResultHighlighter");
        Intrinsics.checkNotNullParameter(getTextSearchManager, "getTextSearchManager");
        Intrinsics.checkNotNullParameter(getPdfAnnotationManager, "getPdfAnnotationManager");
        Intrinsics.checkNotNullParameter(getCreateAnnotationManager, "getCreateAnnotationManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-532340991);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DocumentPreviewScreen)N(store,shouldShowPageLabel,snackbarHostState,getTextSelectionManager,getSearchResultHighlighter,getCitationResultHighlighter,getTextSearchManager,getPdfAnnotationManager,getCreateAnnotationManager)81@4053L29,83@4114L36,88@4297L101,84@4155L1696:DocumentPreviewScreen.kt#neoro");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getTextSelectionManager) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getSearchResultHighlighter) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getCitationResultHighlighter) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getTextSearchManager) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getPdfAnnotationManager) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getCreateAnnotationManager) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532340991, i2, -1, "com.box.android.preview.previewtype.document.DocumentPreviewScreen (DocumentPreviewScreen.kt:80)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -478563387, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment topCenter = Alignment.INSTANCE.getTopCenter();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -478557466, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentPreviewScreenKt.DocumentPreviewScreen$lambda$4$0(mutableFloatState, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topCenter, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1411188090, "C92@4415L555,105@5033L7,108@5136L433,108@5102L467:DocumentPreviewScreen.kt#neoro");
            composer2 = composerStartRestartGroup;
            NutrientDocumentView(store, DocumentPreviewScreen$lambda$2(mutableFloatState), snackbarHostState, getTextSelectionManager, getSearchResultHighlighter, getCitationResultHighlighter, getTextSearchManager, getPdfAnnotationManager, getCreateAnnotationManager, composer2, i2 & 268435342);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Context context = (Context) objConsume;
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            DisplayMode displayMode = DocumentPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getDisplayMode();
            ComposerKt.sourceInformationMarkerStart(composer2, 1617067864, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            boolean zChangedInstance = composer2.changedInstance(fragmentActivity) | composer2.changed(stateCollectAsStateWithLifecycle);
            DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1 documentPreviewScreenKt$DocumentPreviewScreen$2$1$1RememberedValue = composer2.rememberedValue();
            if (zChangedInstance || documentPreviewScreenKt$DocumentPreviewScreen$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                documentPreviewScreenKt$DocumentPreviewScreen$2$1$1RememberedValue = new DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1(fragmentActivity, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(documentPreviewScreenKt$DocumentPreviewScreen$2$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(displayMode, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) documentPreviewScreenKt$DocumentPreviewScreen$2$1$1RememberedValue, composer2, 0);
            if (z) {
                composer2.startReplaceGroup(-1410045462);
                ComposerKt.sourceInformation(composer2, "126@5618L217");
                PageNumberLabel(DocumentPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getPdfPreviewConfiguration().getPageScrollDirection(), DocumentPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getCurrentPageNumber(), DocumentPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getPageCount(), composer2, 0);
            } else {
                composer2.startReplaceGroup(-1415613093);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentPreviewScreenKt.DocumentPreviewScreen$lambda$6(store, z, snackbarHostState, getTextSelectionManager, getSearchResultHighlighter, getCitationResultHighlighter, getTextSearchManager, getPdfAnnotationManager, getCreateAnnotationManager, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float DocumentPreviewScreen$lambda$2(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentPreviewScreen$lambda$4$0(MutableFloatState mutableFloatState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(coordinates);
        mutableFloatState.setFloatValue(rectBoundsInRoot.getBottom() - rectBoundsInRoot.getTop());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void NutrientDocumentView(final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store, final float f, final SnackbarHostState snackbarHostState, final Function0<TextSelectionManager> function0, final Function0<SearchResultHighlighter> function1, final Function0<SearchResultHighlighter> function2, final Function0<TextSearchManager> function3, final Function1<? super ItemId, BoxPdfAnnotationManager> function4, final Function1<? super ItemId, CreateAnnotationsManager> function5, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store2;
        int i3;
        Function0 function6;
        String str;
        int i4;
        final MutableState mutableState;
        int i5;
        int i6;
        int i7;
        Composer composer3;
        final SearchResultHighlighter searchResultHighlighter;
        final PdfActivityConfiguration pdfActivityConfiguration;
        MutableState mutableState2;
        final SearchResultHighlighter searchResultHighlighter2;
        final TextSelectionManager textSelectionManager;
        Composer composerStartRestartGroup = composer.startRestartGroup(1124166975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NutrientDocumentView)N(store,documentViewHeight,snackbarHostState,getTextSelectionManager,getSearchResultHighlighter,getCitationResultHighlighter,getTextSearchManager,getPdfAnnotationManager,getCreateAnnotationManager)149@6658L7,150@6713L48,154@6803L153,154@6792L164,161@6987L29,163@7064L234,163@7053L245,172@7366L66,266@11193L88,268@11287L59,273@11471L39,270@11352L337,283@11804L36,280@11695L186,288@11910L138,288@11887L161:DocumentPreviewScreen.kt#neoro");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            store2 = store;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1124166975, i2, -1, "com.box.android.preview.previewtype.document.NutrientDocumentView (DocumentPreviewScreen.kt:148)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2007275121, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new RectF(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2007272136, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            int i8 = i2 & 14;
            boolean z = i8 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DocumentPreviewScreenKt.NutrientDocumentView$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            int i9 = i2;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Composer composer4 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composer4, -2007263703, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            boolean zChanged = composer4.changed(stateCollectAsStateWithLifecycle) | (i8 == 4);
            Object objRememberedValue3 = composer4.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DocumentPreviewScreenKt.NutrientDocumentView$lambda$5$0(stateCollectAsStateWithLifecycle, store);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Function0 function0Remembered2 = ComposeUtilsKt.remembered((Function0) objRememberedValue3, composer4, 0);
            ComposerKt.sourceInformationMarkerStart(composer4, -2007254207, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
            Object objRememberedValue4 = composer4.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImmutableWrapperKt.ofNull(ImmutableWrapper.INSTANCE), null, 2, null);
                composer4.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            if (!NutrientPdfViewConfigurator.INSTANCE.isEnvironmentSetUp(context)) {
                store2 = store;
                i3 = 0;
                function6 = function0Remembered;
                str = "CC(remember):DocumentPreviewScreen.kt#9igjgp";
                i4 = i8;
                mutableState = mutableState3;
                i5 = i9;
                i6 = 4;
                composer4.startReplaceGroup(-2091614272);
                composer4.endReplaceGroup();
                BoxLogUtils.e("Nutrient environment is not set up");
            } else {
                composer4.startReplaceGroup(-2095096316);
                ComposerKt.sourceInformation(composer4, "177@7522L162,181@7721L38,182@7798L41,183@7880L43,185@7960L75,189@8075L78,195@8266L856,219@9234L75,222@9342L232,233@9738L354,242@10299L106,216@9132L1283,250@10565L37,254@10737L40,247@10425L683");
                PdfPreviewConfiguration pdfPreviewConfiguration = NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getPdfPreviewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer4, -2007249119, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                boolean zChanged2 = composer4.changed(pdfPreviewConfiguration);
                Object objRememberedValue5 = composer4.rememberedValue();
                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = NutrientPdfViewConfigurator.INSTANCE.createPdfActivityConfiguration(context, NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getPdfPreviewConfiguration());
                    composer4.updateRememberedValue(objRememberedValue5);
                }
                PdfActivityConfiguration pdfActivityConfiguration2 = (PdfActivityConfiguration) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, -2007242875, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                TextSelectionManager textSelectionManagerRememberedValue = composer4.rememberedValue();
                if (textSelectionManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    textSelectionManagerRememberedValue = function0.invoke();
                    composer4.updateRememberedValue(textSelectionManagerRememberedValue);
                }
                TextSelectionManager textSelectionManager2 = (TextSelectionManager) textSelectionManagerRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, -2007240408, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                SearchResultHighlighter searchResultHighlighterRememberedValue = composer4.rememberedValue();
                if (searchResultHighlighterRememberedValue == Composer.INSTANCE.getEmpty()) {
                    searchResultHighlighterRememberedValue = function1.invoke();
                    composer4.updateRememberedValue(searchResultHighlighterRememberedValue);
                }
                SearchResultHighlighter searchResultHighlighter3 = (SearchResultHighlighter) searchResultHighlighterRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, -2007237782, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                SearchResultHighlighter searchResultHighlighterRememberedValue2 = composer4.rememberedValue();
                if (searchResultHighlighterRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    searchResultHighlighterRememberedValue2 = function2.invoke();
                    composer4.updateRememberedValue(searchResultHighlighterRememberedValue2);
                }
                final SearchResultHighlighter searchResultHighlighter4 = (SearchResultHighlighter) searchResultHighlighterRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, -2007235190, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                BoxPdfAnnotationManager boxPdfAnnotationManagerRememberedValue = composer4.rememberedValue();
                if (boxPdfAnnotationManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    boxPdfAnnotationManagerRememberedValue = function4.invoke(NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getFile().getItemId());
                    composer4.updateRememberedValue(boxPdfAnnotationManagerRememberedValue);
                }
                BoxPdfAnnotationManager boxPdfAnnotationManager = (BoxPdfAnnotationManager) boxPdfAnnotationManagerRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerStart(composer4, -2007231507, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                CreateAnnotationsManager createAnnotationsManagerRememberedValue = composer4.rememberedValue();
                if (createAnnotationsManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    createAnnotationsManagerRememberedValue = function5.invoke(NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getFile().getItemId());
                    composer4.updateRememberedValue(createAnnotationsManagerRememberedValue);
                }
                CreateAnnotationsManager createAnnotationsManager = (CreateAnnotationsManager) createAnnotationsManagerRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer4);
                Uri uri = Uri.parse(NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getUrl().toString());
                ComposerKt.sourceInformationMarkerStart(composer4, -2007224617, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                Object objRememberedValue6 = composer4.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    i7 = 0;
                    composer3 = composer4;
                    searchResultHighlighter = searchResultHighlighter3;
                    pdfActivityConfiguration = pdfActivityConfiguration2;
                    mutableState = mutableState3;
                    textSelectionManager = textSelectionManager2;
                    objRememberedValue6 = new Function1() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DocumentPreviewScreenKt.NutrientDocumentView$lambda$15$0(pdfActivityConfiguration, store, searchResultHighlighter, searchResultHighlighter4, textSelectionManager, mutableState4, stateCollectAsStateWithLifecycle, mutableState, (PdfUiFragment) obj);
                        }
                    };
                    store2 = store;
                    searchResultHighlighter2 = searchResultHighlighter4;
                    mutableState2 = mutableState4;
                    composer3.updateRememberedValue(objRememberedValue6);
                } else {
                    i7 = 0;
                    composer3 = composer4;
                    searchResultHighlighter = searchResultHighlighter3;
                    pdfActivityConfiguration = pdfActivityConfiguration2;
                    mutableState2 = mutableState4;
                    searchResultHighlighter2 = searchResultHighlighter4;
                    mutableState = mutableState3;
                    textSelectionManager = textSelectionManager2;
                    store2 = store;
                }
                Function1 function7 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Intrinsics.checkNotNull(uri);
                ComposerKt.sourceInformationMarkerStart(composer3, -2007194422, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                Object objRememberedValue7 = composer3.rememberedValue();
                MutableState mutableState5 = mutableState2;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new DocumentPdfFragmentBuilder(pdfActivityConfiguration);
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                DocumentPdfFragmentBuilder documentPdfFragmentBuilder = (DocumentPdfFragmentBuilder) objRememberedValue7;
                ComposerKt.sourceInformationMarkerStart(composer3, -2007190809, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                Object objRememberedValue8 = composer3.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new BoxDocumentListener(store2, function0Remembered, boxPdfAnnotationManager, createAnnotationsManager);
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                BoxDocumentListener boxDocumentListener = (BoxDocumentListener) objRememberedValue8;
                ComposerKt.sourceInformationMarkerStart(composer3, -2007178015, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                boolean z2 = (((i8 == 4 ? 1 : i7) | (composer3.changedInstance(searchResultHighlighter) ? 1 : 0)) == true ? 1 : 0) | (composer3.changedInstance(searchResultHighlighter2) ? 1 : 0) | (composer3.changedInstance(textSelectionManager) ? 1 : 0);
                Object objRememberedValue9 = composer3.rememberedValue();
                if (z2 != 0 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function2() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DocumentPreviewScreenKt.NutrientDocumentView$lambda$18$0(store2, searchResultHighlighter, searchResultHighlighter2, textSelectionManager, (TouchInterceptorViewGroup) obj, (PdfUiFragment) obj2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                Function2 function8 = (Function2) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -2007160311, "CC(remember):DocumentPreviewScreen.kt#9igjgp");
                Object objRememberedValue10 = composer3.rememberedValue();
                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function0() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DocumentPreviewScreenKt.NutrientDocumentView$lambda$19$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer5 = composer3;
                function6 = function0Remembered;
                i4 = i8;
                str = "CC(remember):DocumentPreviewScreen.kt#9igjgp";
                i3 = i7;
                i6 = 4;
                NutrientPdfViewKt.NutrientPdfView(pdfActivityConfiguration, uri, null, documentPdfFragmentBuilder, boxDocumentListener, boxPdfAnnotationManager, createAnnotationsManager, function8, function7, function6, function0Remembered2, (Function0) objRememberedValue10, composer5, PdfActivityConfiguration.$stable | 100663296 | (PdfActivityConfiguration.$stable << 9), 48, 4);
                composer4 = composer5;
                AnonymousClass5 anonymousClass5 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt.NutrientDocumentView.5
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((DocumentPreviewReducer.State) obj).getSearchState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer4, -2007151868, str);
                DocumentPreviewScreenKt$NutrientDocumentView$6$1 documentPreviewScreenKt$NutrientDocumentView$6$1RememberedValue = composer4.rememberedValue();
                if (documentPreviewScreenKt$NutrientDocumentView$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    documentPreviewScreenKt$NutrientDocumentView$6$1RememberedValue = DocumentPreviewScreenKt$NutrientDocumentView$6$1.INSTANCE;
                    composer4.updateRememberedValue(documentPreviewScreenKt$NutrientDocumentView$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer4);
                Store<LocalState, LocalAction> storeScope = store2.scope(anonymousClass5, (Function1) ((KFunction) documentPreviewScreenKt$NutrientDocumentView$6$1RememberedValue));
                AnonymousClass7 anonymousClass7 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt.NutrientDocumentView.7
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((DocumentPreviewReducer.State) obj).getCitationState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer4, -2007146361, str);
                DocumentPreviewScreenKt$NutrientDocumentView$8$1 documentPreviewScreenKt$NutrientDocumentView$8$1RememberedValue = composer4.rememberedValue();
                if (documentPreviewScreenKt$NutrientDocumentView$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    documentPreviewScreenKt$NutrientDocumentView$8$1RememberedValue = DocumentPreviewScreenKt$NutrientDocumentView$8$1.INSTANCE;
                    composer4.updateRememberedValue(documentPreviewScreenKt$NutrientDocumentView$8$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer4);
                i5 = i9;
                DocumentHighlightOverlayKt.DocumentHighlightOverlay(storeScope, store2.scope(anonymousClass7, (Function1) ((KFunction) documentPreviewScreenKt$NutrientDocumentView$8$1RememberedValue)), function1, function2, function3, NutrientDocumentView$lambda$7(mutableState5), pdfActivityConfiguration.getConfiguration(), composer4, ((i5 >> 6) & 65408) | (PdfConfiguration.$stable << 18));
                composer4.endReplaceGroup();
            }
            AnnotationsOverlayKt.AnnotationMessaging((Store) function6.invoke(), snackbarHostState, composer4, (i5 >> 3) & 112);
            CreateAnnotationDialogsKt.CreateAnnotationDialogs((Store) function0Remembered2.invoke(), composer4, i3);
            AnonymousClass9 anonymousClass9 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt.NutrientDocumentView.9
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((DocumentPreviewReducer.State) obj).getCopyTextState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer4, -2007122874, str);
            DocumentPreviewScreenKt$NutrientDocumentView$10$1 documentPreviewScreenKt$NutrientDocumentView$10$1RememberedValue = composer4.rememberedValue();
            if (documentPreviewScreenKt$NutrientDocumentView$10$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                documentPreviewScreenKt$NutrientDocumentView$10$1RememberedValue = DocumentPreviewScreenKt$NutrientDocumentView$10$1.INSTANCE;
                composer4.updateRememberedValue(documentPreviewScreenKt$NutrientDocumentView$10$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            String str2 = str;
            Composer composer6 = composer4;
            SelectedTextOverlayKt.SelectedTextOverlay(store2.scope(anonymousClass9, (Function1) ((KFunction) documentPreviewScreenKt$NutrientDocumentView$10$1RememberedValue)), f, snackbarHostState, NutrientDocumentView$lambda$1(mutableState), composer6, i5 & 1008);
            composer2 = composer6;
            AnonymousClass11 anonymousClass11 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt.NutrientDocumentView.11
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((DocumentPreviewReducer.State) obj).getPrintState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer2, -2007112221, str2);
            DocumentPreviewScreenKt$NutrientDocumentView$12$1 documentPreviewScreenKt$NutrientDocumentView$12$1RememberedValue = composer2.rememberedValue();
            if (documentPreviewScreenKt$NutrientDocumentView$12$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                documentPreviewScreenKt$NutrientDocumentView$12$1RememberedValue = DocumentPreviewScreenKt$NutrientDocumentView$12$1.INSTANCE;
                composer2.updateRememberedValue(documentPreviewScreenKt$NutrientDocumentView$12$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            PrintOverlayKt.PrintOverlay(store2.scope(anonymousClass11, (Function1) ((KFunction) documentPreviewScreenKt$NutrientDocumentView$12$1RememberedValue)), NutrientDocumentView$lambda$4(stateCollectAsStateWithLifecycle).getUrl(), composer2, i3);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -2007108727, str2);
            int i10 = i4 != i6 ? i3 : 1;
            Object objRememberedValue11 = composer2.rememberedValue();
            if (i10 != 0 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentPreviewScreenKt.NutrientDocumentView$lambda$24$0(store2, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue11, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store3 = store2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentPreviewScreenKt.NutrientDocumentView$lambda$25(store3, f, snackbarHostState, function0, function1, function2, function3, function4, function5, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final RectF NutrientDocumentView$lambda$1(MutableState<RectF> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store NutrientDocumentView$lambda$3$0(Store store) {
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$NutrientDocumentView$getAnnotationStore$1$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getAnnotationsState();
            }
        }, DocumentPreviewScreenKt$NutrientDocumentView$getAnnotationStore$1$1$2.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store NutrientDocumentView$lambda$5$0(State state, Store store) {
        if (NutrientDocumentView$lambda$4(state).getCreateAnnotationState() != null) {
            return store.ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((DocumentPreviewReducer.State) obj).getCreateAnnotationState();
                }
            }, DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$2.INSTANCE);
        }
        return null;
    }

    private static final ImmutableWrapper<PdfUiFragment> NutrientDocumentView$lambda$7(MutableState<ImmutableWrapper<PdfUiFragment>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientDocumentView$lambda$15$0(PdfActivityConfiguration pdfActivityConfiguration, Store store, SearchResultHighlighter searchResultHighlighter, SearchResultHighlighter searchResultHighlighter2, TextSelectionManager textSelectionManager, MutableState mutableState, State state, MutableState mutableState2, PdfUiFragment remember) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(remember, "$this$remember");
        if (!Intrinsics.areEqual(NutrientDocumentView$lambda$7(mutableState).getValue(), remember)) {
            mutableState.setValue(new ImmutableWrapper(remember));
        }
        CopySelectedTextReducer.TextSelection selectedText = NutrientDocumentView$lambda$4(state).getCopyTextState().getSelectedText();
        if (selectedText != null) {
            rectF = new RectF(selectedText.getBoundingBox());
            remember.requirePdfFragment().getViewProjection().toViewRect(rectF, selectedText.getPageIndex());
        } else {
            rectF = null;
        }
        mutableState2.setValue(rectF);
        if (!Intrinsics.areEqual(pdfActivityConfiguration, remember.getConfiguration())) {
            NutrientPdfInitializeHelperKt.initializeDocumentComponents(remember, store, searchResultHighlighter, searchResultHighlighter2, textSelectionManager);
        }
        remember.requirePdfFragment().setScrollingEnabled(NutrientDocumentView$lambda$4(state).getPdfPreviewConfiguration().isScrollEnabled());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientDocumentView$lambda$18$0(final Store store, SearchResultHighlighter searchResultHighlighter, SearchResultHighlighter searchResultHighlighter2, TextSelectionManager textSelectionManager, TouchInterceptorViewGroup root, PdfUiFragment pdfUiFragment) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
        root.setOnInterceptTouchEvent(new Function1() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentPreviewScreenKt.NutrientDocumentView$lambda$18$0$0(store, (MotionEvent) obj);
            }
        });
        NutrientPdfInitializeHelperKt.initializeDocumentComponents(pdfUiFragment, store, searchResultHighlighter, searchResultHighlighter2, textSelectionManager);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientDocumentView$lambda$18$0$0(Store store, MotionEvent motionEvent) {
        DocumentViewTouchEventInterceptor.INSTANCE.onInterceptTouchEvent(motionEvent, store);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientDocumentView$lambda$19$0(Store store) {
        store.send(DocumentPreviewReducer.Action.PasswordViewVisible.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void PageNumberLabel(final PageScrollDirection pageScrollDirection, final int i, final int i2, Composer composer, final int i3) {
        int i4;
        final int i5;
        Intrinsics.checkNotNullParameter(pageScrollDirection, "pageScrollDirection");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1871720946);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageNumberLabel)N(pageScrollDirection,pageNumber,pageCount)305@12491L6,308@12604L913,303@12415L1102:DocumentPreviewScreen.kt#neoro");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(pageScrollDirection.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & Token.DOTQUERY) != 146, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1871720946, i4, -1, "com.box.android.preview.previewtype.document.PageNumberLabel (DocumentPreviewScreen.kt:297)");
            }
            int i6 = WhenMappings.$EnumSwitchMapping$0[pageScrollDirection.ordinal()];
            if (i6 == 1) {
                i5 = R.drawable.horizontal_scroll_indicator;
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i5 = R.drawable.vertical_scroll_indicator;
            }
            SurfaceKt.m4323SurfaceT9BRK9s(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(24), 0.0f, 0.0f, 13, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(8)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11574getTooltipBackground0d7_KjU(), 0L, 0.0f, Dp.m9687constructorimpl(6), null, ComposableLambdaKt.rememberComposableLambda(212010345, true, new Function2() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentPreviewScreenKt.PageNumberLabel$lambda$0(i5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12779526, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentPreviewScreenKt.PageNumberLabel$lambda$1(pageScrollDirection, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageNumberLabel$lambda$0(int i, int i2, int i3, Composer composer, int i4) {
        ComposerKt.sourceInformation(composer, "C309@12614L897:DocumentPreviewScreen.kt#neoro");
        if (!composer.shouldExecute((i4 & 3) != 2, i4 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(212010345, i4, -1, "com.box.android.preview.previewtype.document.PageNumberLabel.<anonymous> (DocumentPreviewScreen.kt:309)");
            }
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1218padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1142551073, "C311@12737L41,312@12836L6,310@12704L353,318@13070L38,320@13143L153,327@13470L6,319@13121L380:DocumentPreviewScreen.kt#neoro");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, TestTagKt.testTag(Modifier.INSTANCE, "Preview:PageLabel:ScrollIndicator:" + i), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0, 2, null), composer, Painter.$stable | 48, 56);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(6)), composer, 6);
            String upperCase = StringResources_androidKt.stringResource(R.string.box_previewsdk_page_overlay, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m4494TextNvy7gAk(upperCase, TestTagKt.testTag(Modifier.INSTANCE, "Preview:PageLabelText"), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOutline(FragmentActivity fragmentActivity) {
        PdfOutlineView pdfOutlineView = (PdfOutlineView) fragmentActivity.findViewById(R.id.pspdf__activity_outline_view);
        if (pdfOutlineView != null) {
            pdfOutlineView.show();
            ViewGroup.LayoutParams layoutParams = pdfOutlineView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
            }
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            pdfOutlineView.setLayoutParams(layoutParams);
        }
        PdfThumbnailGrid pdfThumbnailGrid = (PdfThumbnailGrid) fragmentActivity.findViewById(R.id.pspdf__activity_thumbnail_grid);
        if (pdfThumbnailGrid != null) {
            pdfThumbnailGrid.hide();
        }
        hidePageView(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showThumbnails(FragmentActivity fragmentActivity) {
        PdfThumbnailGrid pdfThumbnailGrid = (PdfThumbnailGrid) fragmentActivity.findViewById(R.id.pspdf__activity_thumbnail_grid);
        if (pdfThumbnailGrid != null) {
            pdfThumbnailGrid.show();
        }
        PdfOutlineView pdfOutlineView = (PdfOutlineView) fragmentActivity.findViewById(R.id.pspdf__activity_outline_view);
        if (pdfOutlineView != null) {
            pdfOutlineView.hide();
        }
        hidePageView(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPageView(FragmentActivity fragmentActivity) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator startDelay;
        PdfThumbnailGrid pdfThumbnailGrid = (PdfThumbnailGrid) fragmentActivity.findViewById(R.id.pspdf__activity_thumbnail_grid);
        if (pdfThumbnailGrid != null) {
            pdfThumbnailGrid.hide();
        }
        PdfOutlineView pdfOutlineView = (PdfOutlineView) fragmentActivity.findViewById(R.id.pspdf__activity_outline_view);
        if (pdfOutlineView != null) {
            pdfOutlineView.hide();
        }
        DocumentView documentView = (DocumentView) fragmentActivity.findViewById(R.id.pspdf__document_view);
        if (documentView != null) {
            documentView.setTranslationY(200.0f);
        }
        DocumentView documentView2 = (DocumentView) fragmentActivity.findViewById(R.id.pspdf__document_view);
        if (documentView2 == null || (viewPropertyAnimatorAnimate = documentView2.animate()) == null || (duration = viewPropertyAnimatorAnimate.setDuration(200L)) == null || (viewPropertyAnimatorAlpha = duration.alpha(1.0f)) == null || (viewPropertyAnimatorTranslationY = viewPropertyAnimatorAlpha.translationY(0.0f)) == null || (startDelay = viewPropertyAnimatorTranslationY.setStartDelay(100L)) == null) {
            return;
        }
        startDelay.start();
    }

    private static final void hidePageView(FragmentActivity fragmentActivity) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        DocumentView documentView = (DocumentView) fragmentActivity.findViewById(R.id.pspdf__document_view);
        if (documentView == null || (viewPropertyAnimatorAnimate = documentView.animate()) == null || (duration = viewPropertyAnimatorAnimate.setDuration(200L)) == null || (viewPropertyAnimatorAlpha = duration.alpha(0.0f)) == null) {
            return;
        }
        viewPropertyAnimatorAlpha.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentPreviewReducer.State DocumentPreviewScreen$lambda$0(State<DocumentPreviewReducer.State> state) {
        return state.getValue();
    }

    private static final DocumentPreviewReducer.State NutrientDocumentView$lambda$4(State<DocumentPreviewReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult NutrientDocumentView$lambda$24$0(final Store store, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$NutrientDocumentView$lambda$24$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                store.send(new DocumentPreviewReducer.Action.Annotations(AnnotationsReducer.Action.Release.INSTANCE));
            }
        };
    }
}
