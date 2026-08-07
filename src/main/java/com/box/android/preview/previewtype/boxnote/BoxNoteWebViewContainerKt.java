package com.box.android.preview.previewtype.boxnote;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxNoteWebViewContainer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001aL\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0002\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016²\u0006\f\u0010\f\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\f\u0010\u000e\u001a\u0004\u0018\u00010\nX\u008a\u008e\u0002"}, d2 = {"BoxNoteWebViewContainer", "", "state", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "webViewLoader", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewLoader;", "callbacks", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewCallbacks;", "(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewLoader;Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewCallbacks;Landroidx/compose/runtime/Composer;I)V", "noteLoadParams", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebLoadParams;", "handleWebViewUpdate", "webView", "Landroid/webkit/WebView;", "loadedParams", "onParamsLoaded", "Lkotlin/Function1;", "onLoadStarted", "Lkotlin/Function0;", "toggleConnectionBanner", "show", "", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteWebViewContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteWebViewContainer$lambda$9(BoxNotePreviewReducer.State state, BoxNoteWebViewLoader boxNoteWebViewLoader, BoxNoteWebViewCallbacks boxNoteWebViewCallbacks, int i, Composer composer, int i2) {
        BoxNoteWebViewContainer(state, boxNoteWebViewLoader, boxNoteWebViewCallbacks, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxNoteWebViewContainer(final BoxNotePreviewReducer.State state, final BoxNoteWebViewLoader webViewLoader, final BoxNoteWebViewCallbacks callbacks, Composer composer, final int i) {
        int i2;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(webViewLoader, "webViewLoader");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1652773844);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNoteWebViewContainer)N(state,webViewLoader,callbacks)19@786L45,20@856L58,26@1054L406,37@1479L824,22@920L1389,57@2349L79,57@2315L113:BoxNoteWebViewContainer.kt#m6nu90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(webViewLoader) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(callbacks) : composerStartRestartGroup.changedInstance(callbacks) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1652773844, i2, -1, "com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainer (BoxNoteWebViewContainer.kt:18)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 822240537, "CC(remember):BoxNoteWebViewContainer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 822242790, "CC(remember):BoxNoteWebViewContainer.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "Preview:BoxNoteWebView");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 822249474, "CC(remember):BoxNoteWebViewContainer.kt#9igjgp");
            int i3 = i2 & 896;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(webViewLoader) | (i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(callbacks)));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxNoteWebViewContainerKt.BoxNoteWebViewContainer$lambda$6$0(webViewLoader, callbacks, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 822263492, "CC(remember):BoxNoteWebViewContainer.kt#9igjgp");
            boolean zChangedInstance2 = (i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(callbacks))) | composerStartRestartGroup.changedInstance(state) | composerStartRestartGroup.changedInstance(webViewLoader);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                Function1 function2 = new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxNoteWebViewContainerKt.BoxNoteWebViewContainer$lambda$7$0(state, webViewLoader, callbacks, mutableState, mutableState3, (WebView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function2);
                objRememberedValue4 = function2;
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function1, modifierTestTag, (Function1) objRememberedValue4, composerStartRestartGroup, 48, 0);
            Boolean boolValueOf = Boolean.valueOf(state.getIsConnected());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 822290587, "CC(remember):BoxNoteWebViewContainer.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(state);
            BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1 boxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || boxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1RememberedValue = new BoxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1(mutableState, state, null);
                composerStartRestartGroup.updateRememberedValue(boxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxNoteWebViewContainerKt$BoxNoteWebViewContainer$3$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNoteWebViewContainerKt.BoxNoteWebViewContainer$lambda$9(state, webViewLoader, callbacks, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView BoxNoteWebViewContainer$lambda$1(MutableState<WebView> mutableState) {
        return mutableState.getValue();
    }

    private static final BoxNoteWebLoadParams BoxNoteWebViewContainer$lambda$4(MutableState<BoxNoteWebLoadParams> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView BoxNoteWebViewContainer$lambda$6$0(BoxNoteWebViewLoader boxNoteWebViewLoader, BoxNoteWebViewCallbacks boxNoteWebViewCallbacks, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        MAMWebView mAMWebView = new MAMWebView(ctx);
        mAMWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        mAMWebView.setVerticalScrollBarEnabled(true);
        boxNoteWebViewLoader.initWebView(mAMWebView);
        Function1<WebView, Unit> onWebViewCreated = boxNoteWebViewCallbacks.getOnWebViewCreated();
        if (onWebViewCreated != null) {
            onWebViewCreated.invoke(mAMWebView);
        }
        return mAMWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteWebViewContainer$lambda$7$0(BoxNotePreviewReducer.State state, BoxNoteWebViewLoader boxNoteWebViewLoader, BoxNoteWebViewCallbacks boxNoteWebViewCallbacks, MutableState mutableState, final MutableState mutableState2, WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (BoxNoteWebViewContainer$lambda$1(mutableState) != null && BoxNoteWebViewContainer$lambda$1(mutableState) != view) {
            mutableState2.setValue(null);
        }
        mutableState.setValue(view);
        handleWebViewUpdate(view, state, boxNoteWebViewLoader, BoxNoteWebViewContainer$lambda$4(mutableState2), new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteWebViewContainerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxNoteWebViewContainerKt.BoxNoteWebViewContainer$lambda$7$0$0(mutableState2, (BoxNoteWebLoadParams) obj);
            }
        }, boxNoteWebViewCallbacks.getOnLoadStarted());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNoteWebViewContainer$lambda$7$0$0(MutableState mutableState, BoxNoteWebLoadParams it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    private static final BoxNoteWebLoadParams noteLoadParams(BoxNotePreviewReducer.State state) {
        if (state instanceof BoxNotePreviewReducer.State.EditorInitializing) {
            BoxNotePreviewReducer.State.EditorInitializing editorInitializing = (BoxNotePreviewReducer.State.EditorInitializing) state;
            return new BoxNoteWebLoadParams(editorInitializing.getNoteUrl(), editorInitializing.getHeaders());
        }
        if (state instanceof BoxNotePreviewReducer.State.EditorReady) {
            BoxNotePreviewReducer.State.EditorReady editorReady = (BoxNotePreviewReducer.State.EditorReady) state;
            return new BoxNoteWebLoadParams(editorReady.getNoteUrl(), editorReady.getHeaders());
        }
        if (!(state instanceof BoxNotePreviewReducer.State.Editing)) {
            return null;
        }
        BoxNotePreviewReducer.State.Editing editing = (BoxNotePreviewReducer.State.Editing) state;
        return new BoxNoteWebLoadParams(editing.getEditState().getNoteUrl(), editing.getEditState().getHeaders());
    }

    private static final void handleWebViewUpdate(WebView webView, BoxNotePreviewReducer.State state, BoxNoteWebViewLoader boxNoteWebViewLoader, BoxNoteWebLoadParams boxNoteWebLoadParams, Function1<? super BoxNoteWebLoadParams, Unit> function1, Function0<Unit> function0) {
        BoxNoteWebLoadParams boxNoteWebLoadParamsNoteLoadParams = noteLoadParams(state);
        if (boxNoteWebLoadParamsNoteLoadParams != null && boxNoteWebLoadParamsNoteLoadParams.getUrl().length() > 0 && !Intrinsics.areEqual(boxNoteWebLoadParamsNoteLoadParams, boxNoteWebLoadParams)) {
            function0.invoke();
            boxNoteWebViewLoader.loadUrl(webView, boxNoteWebLoadParamsNoteLoadParams.getUrl(), boxNoteWebLoadParamsNoteLoadParams.getHeaders());
            function1.invoke(boxNoteWebLoadParamsNoteLoadParams);
        }
        if (((state instanceof BoxNotePreviewReducer.State.EditorReady) || (state instanceof BoxNotePreviewReducer.State.Editing)) && webView.getVisibility() != 0) {
            webView.setVisibility(0);
            toggleConnectionBanner(webView, !state.getIsConnected());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleConnectionBanner(WebView webView, boolean z) {
        webView.evaluateJavascript(StringsKt.trimIndent("\n        (function() {\n            var elements = document.getElementsByClassName('mobile-connection-banner');\n            for (var i = 0; i < elements.length; i++) {\n                elements[i].style.display = '" + (z ? "block" : "none") + "';\n            }\n        })();\n        "), null);
    }
}
