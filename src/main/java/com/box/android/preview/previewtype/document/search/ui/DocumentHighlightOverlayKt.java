package com.box.android.preview.previewtype.document.search.ui;

import android.graphics.RectF;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.cpl.Store;
import com.box.android.preview.previewtype.document.CitationHighlightReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.utils.PdfUtils;
import com.pspdfkit.utils.Size;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: DocumentHighlightOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001ay\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a.\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002\"\u000e\u0010\"\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"DocumentHighlightOverlay", "", "searchStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "citationsStore", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "getSearchResultHighlighter", "Lkotlin/Function0;", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "getCitationResultHighlighter", "getTextSearchManager", "Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "pdfFragmentWrapper", "Lcom/box/android/base/compose/ImmutableWrapper;", "Lcom/pspdfkit/ui/PdfUiFragment;", "pdfConfiguration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "(Lcom/box/android/cpl/Store;Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/compose/ImmutableWrapper;Lcom/pspdfkit/configuration/PdfConfiguration;Landroidx/compose/runtime/Composer;I)V", "navigateToResult", "pdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "selectedResult", "Lcom/pspdfkit/document/search/SearchResult;", "searchResultHighlighter", "(Lcom/pspdfkit/ui/PdfFragment;Lcom/pspdfkit/document/search/SearchResult;Lcom/pspdfkit/configuration/PdfConfiguration;Lcom/pspdfkit/ui/search/SearchResultHighlighter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPageFullyVisibleWithNoZoom", "", "pageToShowIndex", "", "document", "Lcom/pspdfkit/document/PdfDocument;", "SCROLL_DURATION", "", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentHighlightOverlayKt {
    private static final long SCROLL_DURATION = 250;

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$navigateToResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentHighlightOverlay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt", f = "DocumentHighlightOverlay.kt", i = {0, 0, 0, 0, 0, 0}, l = {135}, m = "navigateToResult", n = {"pdfFragment", "selectedResult", "pdfConfiguration", "searchResultHighlighter", "document", "textRect"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentHighlightOverlayKt.navigateToResult(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentHighlightOverlay$lambda$6(Store store, Store store2, Function0 function0, Function0 function1, Function0 function2, ImmutableWrapper immutableWrapper, PdfConfiguration pdfConfiguration, int i, Composer composer, int i2) {
        DocumentHighlightOverlay(store, store2, function0, function1, function2, immutableWrapper, pdfConfiguration, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void DocumentHighlightOverlay(final Store<DocumentSearchReducer.State, DocumentSearchReducer.Action> searchStore, final Store<CitationHighlightReducer.State, CitationHighlightReducer.Action> citationsStore, final Function0<SearchResultHighlighter> getSearchResultHighlighter, final Function0<SearchResultHighlighter> getCitationResultHighlighter, final Function0<TextSearchManager> getTextSearchManager, final ImmutableWrapper<PdfUiFragment> pdfFragmentWrapper, final PdfConfiguration pdfConfiguration, Composer composer, final int i) {
        int i2;
        Object obj;
        char c;
        boolean z;
        SearchResult searchResult;
        final SearchResultHighlighter searchResultHighlighter;
        Intrinsics.checkNotNullParameter(searchStore, "searchStore");
        Intrinsics.checkNotNullParameter(citationsStore, "citationsStore");
        Intrinsics.checkNotNullParameter(getSearchResultHighlighter, "getSearchResultHighlighter");
        Intrinsics.checkNotNullParameter(getCitationResultHighlighter, "getCitationResultHighlighter");
        Intrinsics.checkNotNullParameter(getTextSearchManager, "getTextSearchManager");
        Intrinsics.checkNotNullParameter(pdfFragmentWrapper, "pdfFragmentWrapper");
        Intrinsics.checkNotNullParameter(pdfConfiguration, "pdfConfiguration");
        Composer composerStartRestartGroup = composer.startRestartGroup(730971625);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DocumentHighlightOverlay)N(searchStore,citationsStore,getSearchResultHighlighter,getCitationResultHighlighter,getTextSearchManager,pdfFragmentWrapper,pdfConfiguration)42@2047L29,45@2207L29,48@2334L6,49@2406L6,50@2465L6,51@2506L286,58@2823L211,65@3082L509,65@3040L551,80@3639L174,80@3597L216,86@3848L338,86@3819L367,94@4215L147,94@4192L170:DocumentHighlightOverlay.kt#z0e3so");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchStore) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(citationsStore) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getSearchResultHighlighter) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getCitationResultHighlighter) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getTextSearchManager) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(pdfFragmentWrapper) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (i & 2097152) == 0 ? composerStartRestartGroup.changed(pdfConfiguration) : composerStartRestartGroup.changedInstance(pdfConfiguration) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(730971625, i2, -1, "com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlay (DocumentHighlightOverlay.kt:41)");
            }
            DocumentSearchReducer.State state = (DocumentSearchReducer.State) FlowExtKt.collectAsStateWithLifecycle(searchStore.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
            DocumentSearchReducer.SearchState searchState = state != null ? state.getSearchState() : null;
            DocumentSearchReducer.SearchState.Results results = searchState instanceof DocumentSearchReducer.SearchState.Results ? (DocumentSearchReducer.SearchState.Results) searchState : null;
            SearchResult citationText = ((CitationHighlightReducer.State) FlowExtKt.collectAsStateWithLifecycle(citationsStore.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue()).getCitationText();
            long jM11546getPreviewSearchHighlight0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11546getPreviewSearchHighlight0d7_KjU();
            long jM11545getPreviewCitationHighlight0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11545getPreviewCitationHighlight0d7_KjU();
            int iM11638toPx8Feqmps = ComposeUtilsKt.m11638toPx8Feqmps(Dp.m9687constructorimpl(1), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910873817, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj2 = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                SearchResultHighlighter searchResultHighlighterInvoke = getSearchResultHighlighter.invoke();
                searchResultHighlighterInvoke.setSearchResultBackgroundColor(ColorKt.m6868toArgb8_81llA(Color.m6813copywmQWz5c$default(jM11546getPreviewSearchHighlight0d7_KjU, 0.3f, 0.0f, 0.0f, 0.0f, 14, null)));
                searchResultHighlighterInvoke.setSearchResultBorderColor(ColorKt.m6868toArgb8_81llA(jM11546getPreviewSearchHighlight0d7_KjU));
                searchResultHighlighterInvoke.setSearchResultBorderWidth(iM11638toPx8Feqmps);
                composerStartRestartGroup.updateRememberedValue(searchResultHighlighterInvoke);
                obj2 = searchResultHighlighterInvoke;
            }
            final SearchResultHighlighter searchResultHighlighter2 = (SearchResultHighlighter) obj2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910863748, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                SearchResultHighlighter searchResultHighlighterInvoke2 = getCitationResultHighlighter.invoke();
                searchResultHighlighterInvoke2.setSearchResultBackgroundColor(ColorKt.m6868toArgb8_81llA(Color.m6813copywmQWz5c$default(jM11545getPreviewCitationHighlight0d7_KjU, 0.16f, 0.0f, 0.0f, 0.0f, 14, null)));
                searchResultHighlighterInvoke2.setSearchResultBorderWidth(0);
                composerStartRestartGroup.updateRememberedValue(searchResultHighlighterInvoke2);
                obj = searchResultHighlighterInvoke2;
            } else {
                obj = objRememberedValue2;
            }
            SearchResultHighlighter searchResultHighlighter3 = (SearchResultHighlighter) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910855162, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            int i3 = i2 & 458752;
            int i4 = i2 & 3670016;
            boolean zChanged = composerStartRestartGroup.changed(results) | composerStartRestartGroup.changedInstance(searchResultHighlighter2) | (i3 == 131072) | (i4 == 1048576 || ((i2 & 2097152) != 0 && composerStartRestartGroup.changedInstance(pdfConfiguration)));
            DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1 documentHighlightOverlayKt$DocumentHighlightOverlay$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || documentHighlightOverlayKt$DocumentHighlightOverlay$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                c = 16384;
                z = true;
                documentHighlightOverlayKt$DocumentHighlightOverlay$1$1RememberedValue = new DocumentHighlightOverlayKt$DocumentHighlightOverlay$1$1(results, searchResultHighlighter2, pdfFragmentWrapper, pdfConfiguration, null);
                composerStartRestartGroup.updateRememberedValue(documentHighlightOverlayKt$DocumentHighlightOverlay$1$1RememberedValue);
            } else {
                c = 16384;
                z = true;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(results, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) documentHighlightOverlayKt$DocumentHighlightOverlay$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910837673, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            boolean z2 = ((i2 & 57344) == c ? z : false) | (r17 == 131072 ? z : false) | ((i4 == 1048576 || ((i2 & 2097152) != 0 && composerStartRestartGroup.changedInstance(pdfConfiguration))) ? z : false);
            DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1 documentHighlightOverlayKt$DocumentHighlightOverlay$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || documentHighlightOverlayKt$DocumentHighlightOverlay$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                documentHighlightOverlayKt$DocumentHighlightOverlay$2$1RememberedValue = new DocumentHighlightOverlayKt$DocumentHighlightOverlay$2$1(pdfFragmentWrapper, getTextSearchManager, pdfConfiguration, null);
                composerStartRestartGroup.updateRememberedValue(documentHighlightOverlayKt$DocumentHighlightOverlay$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(pdfFragmentWrapper, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) documentHighlightOverlayKt$DocumentHighlightOverlay$2$1RememberedValue, composerStartRestartGroup, (i2 >> 15) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910830821, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            boolean zChangedInstance = (i3 == 131072 ? z : false) | composerStartRestartGroup.changedInstance(citationText) | composerStartRestartGroup.changedInstance(searchResultHighlighter3);
            if (i4 != 1048576 && ((i2 & 2097152) == 0 || !composerStartRestartGroup.changedInstance(pdfConfiguration))) {
                z = false;
            }
            boolean z3 = zChangedInstance | z;
            DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1 documentHighlightOverlayKt$DocumentHighlightOverlay$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || documentHighlightOverlayKt$DocumentHighlightOverlay$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchResult = citationText;
                searchResultHighlighter = searchResultHighlighter3;
                documentHighlightOverlayKt$DocumentHighlightOverlay$3$1RememberedValue = new DocumentHighlightOverlayKt$DocumentHighlightOverlay$3$1(searchResult, searchResultHighlighter, pdfFragmentWrapper, pdfConfiguration, null);
                composerStartRestartGroup.updateRememberedValue(documentHighlightOverlayKt$DocumentHighlightOverlay$3$1RememberedValue);
            } else {
                searchResult = citationText;
                searchResultHighlighter = searchResultHighlighter3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(searchResult, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) documentHighlightOverlayKt$DocumentHighlightOverlay$3$1RememberedValue, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910819268, "CC(remember):DocumentHighlightOverlay.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(searchResultHighlighter2) | composerStartRestartGroup.changedInstance(searchResultHighlighter);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return DocumentHighlightOverlayKt.DocumentHighlightOverlay$lambda$5$0(searchResultHighlighter2, searchResultHighlighter, (DisposableEffectScope) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return DocumentHighlightOverlayKt.DocumentHighlightOverlay$lambda$6(searchStore, citationsStore, getSearchResultHighlighter, getCitationResultHighlighter, getTextSearchManager, pdfFragmentWrapper, pdfConfiguration, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object navigateToResult(PdfFragment pdfFragment, SearchResult searchResult, PdfConfiguration pdfConfiguration, SearchResultHighlighter searchResultHighlighter, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        RectF rectF;
        SearchResultHighlighter searchResultHighlighter2;
        SearchResult searchResult2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PdfDocument document = pdfFragment.getDocument();
            if (document == null) {
                return Unit.INSTANCE;
            }
            RectF rectFCreatePdfRectUnion = PdfUtils.createPdfRectUnion(searchResult.textBlock.pageRects);
            Intrinsics.checkNotNullExpressionValue(rectFCreatePdfRectUnion, "createPdfRectUnion(...)");
            if (pdfConfiguration.getScrollMode() == PageScrollMode.CONTINUOUS && searchResult.pageIndex != pdfFragment.getPageIndex()) {
                int iCenterX = (int) rectFCreatePdfRectUnion.centerX();
                int iCenterY = (int) rectFCreatePdfRectUnion.centerY();
                float zoomScale = pdfFragment.getZoomScale(searchResult.pageIndex);
                if (isPageFullyVisibleWithNoZoom(pdfFragment, searchResult.pageIndex, document)) {
                    Size pageSize = document.getPageSize(searchResult.pageIndex);
                    Intrinsics.checkNotNullExpressionValue(pageSize, "getPageSize(...)");
                    int i2 = ((int) pageSize.width) / 2;
                    zoomScale = 1.0f;
                    iCenterY = ((int) pageSize.height) / 2;
                    iCenterX = i2;
                }
                pdfFragment.zoomTo(iCenterX, iCenterY, searchResult.pageIndex, zoomScale, SCROLL_DURATION);
                rectF = rectFCreatePdfRectUnion;
            } else {
                rectF = rectFCreatePdfRectUnion;
                pdfFragment.scrollTo(rectF, searchResult.pageIndex, SCROLL_DURATION, false);
            }
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(pdfFragment);
            anonymousClass2.L$1 = searchResult;
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(pdfConfiguration);
            searchResultHighlighter2 = searchResultHighlighter;
            anonymousClass2.L$3 = searchResultHighlighter2;
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(document);
            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(rectF);
            anonymousClass2.label = 1;
            if (DelayKt.delay(100L, anonymousClass2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            searchResult2 = searchResult;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            searchResultHighlighter2 = (SearchResultHighlighter) anonymousClass2.L$3;
            searchResult2 = (SearchResult) anonymousClass2.L$1;
            ResultKt.throwOnFailure(obj);
        }
        searchResultHighlighter2.setSelectedSearchResult(searchResult2);
        return Unit.INSTANCE;
    }

    private static final boolean isPageFullyVisibleWithNoZoom(PdfFragment pdfFragment, int i, PdfDocument pdfDocument) {
        Size pageSize = pdfDocument.getPageSize(i);
        Intrinsics.checkNotNullExpressionValue(pageSize, "getPageSize(...)");
        float zoomScale = pdfFragment.getZoomScale(i);
        RectF rectF = new RectF(0.0f, pageSize.height, pageSize.width, 0.0f);
        pdfFragment.getViewProjection().toViewRect(rectF, i);
        View view = pdfFragment.getView();
        if (view != null) {
            int height = view.getHeight();
            View view2 = pdfFragment.getView();
            if (view2 != null) {
                int width = view2.getWidth();
                if (height >= rectF.height() / zoomScale && width >= rectF.width() / zoomScale) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DocumentHighlightOverlay$lambda$5$0(final SearchResultHighlighter searchResultHighlighter, final SearchResultHighlighter searchResultHighlighter2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentHighlightOverlayKt$DocumentHighlightOverlay$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                searchResultHighlighter.clearSearchResults();
                searchResultHighlighter2.clearSearchResults();
            }
        };
    }
}
