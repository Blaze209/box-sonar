package com.box.android.preview.previewtype.boxnote;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.WebView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: compiled from: BoxNotePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\r\u001a5\u0010\u000e\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006\u0018²\u0006\n\u0010\f\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002"}, d2 = {"BoxNotePreviewScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "assetCache", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;", "(Landroidx/compose/ui/Modifier;Lcom/box/android/cpl/Store;Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;Landroidx/compose/runtime/Composer;II)V", "BoxNoteEditorContent", "state", "(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;Lcom/box/android/cpl/Store;Lcom/box/android/preview/previewtype/boxnote/BoxNotesWebviewAssetCache;Landroidx/compose/runtime/Composer;I)V", "BoxNoteEditorViewEffectProcessor", GuideTransition.GUIDE_TRANSITION_EFFECT_FIELD, "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;", "webView", "Landroid/webkit/WebView;", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;Landroid/webkit/WebView;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "callNotesFunction", "", "request", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequest;", "preview_generalProdRelease", "isKeyboardVisible", "", "containerHeightPx", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxNotePreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteEditorContent$lambda$6(BoxNotePreviewReducer.State state, Store store, BoxNotesWebviewAssetCache boxNotesWebviewAssetCache, int i, Composer composer, int i2) {
        BoxNoteEditorContent(state, store, boxNotesWebviewAssetCache, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteEditorViewEffectProcessor$lambda$1(BoxNoteEditModeReducer.ViewEffect viewEffect, WebView webView, Store store, int i, Composer composer, int i2) {
        BoxNoteEditorViewEffectProcessor(viewEffect, webView, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotePreviewScreen$lambda$9(Modifier modifier, Store store, BoxNotesWebviewAssetCache boxNotesWebviewAssetCache, int i, int i2, Composer composer, int i3) {
        BoxNotePreviewScreen(modifier, store, boxNotesWebviewAssetCache, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BoxNotePreviewScreen(Modifier modifier, final Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, final BoxNotesWebviewAssetCache assetCache, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(assetCache, "assetCache");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1739955683);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNotePreviewScreen)N(modifier,store,assetCache)35@1438L7,36@1475L29,37@1534L25,38@1589L33,40@1657L3,43@1751L101,43@1717L135,47@1905L328,47@1858L375,61@2332L6,63@2432L149,58@2239L440:BoxNotePreviewScreen.kt#m6nu90");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(assetCache) ? 256 : 128;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & Token.DOTQUERY) != 146, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1739955683, i5, -1, "com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreen (BoxNotePreviewScreen.kt:34)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            State<Boolean> stateKeyboardIsOpenedAsState = ComposeUtilsKt.keyboardIsOpenedAsState(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1355121474, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int bottom = WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
            Boolean boolValueOf = Boolean.valueOf(BoxNotePreviewScreen$lambda$1(stateKeyboardIsOpenedAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1355116222, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            int i6 = i5 & 112;
            boolean zChanged = (i6 == 32) | composerStartRestartGroup.changed(stateKeyboardIsOpenedAsState);
            BoxNotePreviewScreenKt$BoxNotePreviewScreen$1$1 boxNotePreviewScreenKt$BoxNotePreviewScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || boxNotePreviewScreenKt$BoxNotePreviewScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxNotePreviewScreenKt$BoxNotePreviewScreen$1$1RememberedValue = new BoxNotePreviewScreenKt$BoxNotePreviewScreen$1$1(store, stateKeyboardIsOpenedAsState, null);
                composerStartRestartGroup.updateRememberedValue(boxNotePreviewScreenKt$BoxNotePreviewScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxNotePreviewScreenKt$BoxNotePreviewScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Integer numValueOf = Integer.valueOf(BoxNotePreviewScreen$lambda$3(mutableIntState));
            Integer numValueOf2 = Integer.valueOf(bottom);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1355111067, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            boolean zChanged2 = (i6 == 32) | composerStartRestartGroup.changed(bottom);
            BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1 boxNotePreviewScreenKt$BoxNotePreviewScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || boxNotePreviewScreenKt$BoxNotePreviewScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxNotePreviewScreenKt$BoxNotePreviewScreen$2$1RememberedValue = new BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1(bottom, store, mutableIntState, null);
                composerStartRestartGroup.updateRememberedValue(boxNotePreviewScreenKt$BoxNotePreviewScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, numValueOf2, (Function2) boxNotePreviewScreenKt$BoxNotePreviewScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), null, 2, null), "Preview:BoxNotePreview");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1355094382, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxNotePreviewScreenKt.BoxNotePreviewScreen$lambda$7$0(mutableIntState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierTestTag, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1737949867, "C69@2598L75:BoxNotePreviewScreen.kt#m6nu90");
            BoxNoteEditorContent(BoxNotePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle), store, assetCache, composerStartRestartGroup, i5 & 1008);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotePreviewScreenKt.BoxNotePreviewScreen$lambda$9(companion, store, assetCache, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BoxNotePreviewScreen$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotePreviewScreen$lambda$7$0(MutableIntState mutableIntState, IntSize intSize) {
        if (((int) (intSize.m9862unboximpl() & 4294967295L)) != BoxNotePreviewScreen$lambda$3(mutableIntState)) {
            mutableIntState.setIntValue((int) (intSize.m9862unboximpl() & 4294967295L));
        }
        return Unit.INSTANCE;
    }

    private static final void BoxNoteEditorContent(final BoxNotePreviewReducer.State state, final Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, final BoxNotesWebviewAssetCache boxNotesWebviewAssetCache, Composer composer, final int i) {
        int i2;
        BoxNoteEditModeReducer.State editState;
        Composer composerStartRestartGroup = composer.startRestartGroup(752705321);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNoteEditorContent)N(state,store,assetCache)79@2911L45,81@2977L46,82@3044L231,89@3300L56,91@3362L122,97@3490L177:BoxNotePreviewScreen.kt#m6nu90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(boxNotesWebviewAssetCache) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(752705321, i2, -1, "com.box.android.preview.previewtype.boxnote.BoxNoteEditorContent (BoxNotePreviewScreen.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1795314454, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            BoxNoteEditModeReducer.ViewEffect viewEffect = null;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1795316567, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new BoxNotesBridgeDelegateImpl(store);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final BoxNotesBridgeDelegateImpl boxNotesBridgeDelegateImpl = (BoxNotesBridgeDelegateImpl) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1795318896, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new BoxNoteWebViewCallbacks(boxNotesBridgeDelegateImpl, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxNotePreviewScreenKt.BoxNoteEditorContent$lambda$4$0(mutableState, (WebView) obj);
                    }
                }, new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotePreviewScreenKt.BoxNoteEditorContent$lambda$4$1(boxNotesBridgeDelegateImpl);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            BoxNoteWebViewCallbacks boxNoteWebViewCallbacks = (BoxNoteWebViewCallbacks) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1795326913, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new BoxNoteWebViewLoader(boxNoteWebViewCallbacks, boxNotesWebviewAssetCache);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNoteWebViewContainerKt.BoxNoteWebViewContainer(state, (BoxNoteWebViewLoader) objRememberedValue4, boxNoteWebViewCallbacks, composerStartRestartGroup, i2 & 14);
            BoxNotePreviewReducer.State.Editing editing = state instanceof BoxNotePreviewReducer.State.Editing ? (BoxNotePreviewReducer.State.Editing) state : null;
            if (editing != null && (editState = editing.getEditState()) != null) {
                viewEffect = editState.getViewEffect();
            }
            BoxNoteEditorViewEffectProcessor(viewEffect, BoxNoteEditorContent$lambda$1(mutableState), store, composerStartRestartGroup, (i2 << 3) & 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotePreviewScreenKt.BoxNoteEditorContent$lambda$6(state, store, boxNotesWebviewAssetCache, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final WebView BoxNoteEditorContent$lambda$1(MutableState<WebView> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteEditorContent$lambda$4$0(MutableState mutableState, WebView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteEditorContent$lambda$4$1(BoxNotesBridgeDelegateImpl boxNotesBridgeDelegateImpl) {
        boxNotesBridgeDelegateImpl.setLoadStartTime(SystemClock.uptimeMillis());
        return Unit.INSTANCE;
    }

    public static final void BoxNoteEditorViewEffectProcessor(final BoxNoteEditModeReducer.ViewEffect viewEffect, final WebView webView, final Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(2127099141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNoteEditorViewEffectProcessor)N(effect,webView,store)110@3903L7,111@3938L664,111@3915L687:BoxNotePreviewScreen.kt#m6nu90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(viewEffect) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(webView) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2127099141, i3, -1, "com.box.android.preview.previewtype.boxnote.BoxNoteEditorViewEffectProcessor (BoxNotePreviewScreen.kt:109)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262149571, "CC(remember):BoxNotePreviewScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(viewEffect) | composerStartRestartGroup.changedInstance(webView) | composerStartRestartGroup.changedInstance(context) | ((i3 & 896) == 256);
            BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1 boxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || boxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1RememberedValue = new BoxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1(viewEffect, webView, store, context, null);
                composerStartRestartGroup.updateRememberedValue(boxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(viewEffect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxNotePreviewScreenKt$BoxNoteEditorViewEffectProcessor$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotePreviewScreenKt.BoxNoteEditorViewEffectProcessor$lambda$1(viewEffect, webView, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String callNotesFunction(BoxNoteRequest boxNoteRequest) {
        StringBuilder sb = new StringBuilder("javascript:platformAdapter.call('");
        sb.append(boxNoteRequest.getCommand());
        sb.append("', '{");
        int i = 0;
        for (Object obj : boxNoteRequest.getParams().entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            sb.append("\"" + ((String) entry.getKey()) + "\":\"" + ((String) entry.getValue()) + "\"");
            if (i < boxNoteRequest.getParams().size() - 1) {
                sb.append(",");
            }
            i = i2;
        }
        sb.append("}');");
        return sb.toString();
    }

    private static final BoxNotePreviewReducer.State BoxNotePreviewScreen$lambda$0(State<? extends BoxNotePreviewReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BoxNotePreviewScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
