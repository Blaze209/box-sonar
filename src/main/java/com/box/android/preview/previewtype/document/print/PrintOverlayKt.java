package com.box.android.preview.previewtype.document.print;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.dialog.PasswordEnterDialogKt;
import com.box.android.cpl.Store;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PrintOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PrintOverlay", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "uri", "Ljava/net/URI;", "(Lcom/box/android/cpl/Store;Ljava/net/URI;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PrintOverlayKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintOverlay$lambda$0(Store store, URI uri, int i, Composer composer, int i2) {
        PrintOverlay(store, uri, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintOverlay$lambda$3(Store store, URI uri, int i, Composer composer, int i2) {
        PrintOverlay(store, uri, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PrintOverlay(final Store<PrintReducer.State, PrintReducer.Action> store, final URI uri, Composer composer, final int i) {
        int i2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        int i3;
        PrintReducer.State state;
        PrintOverlayKt$PrintOverlay$1$1 printOverlayKt$PrintOverlay$1$1;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Composer composerStartRestartGroup = composer.startRestartGroup(2043003786);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrintOverlay)N(store,uri)17@771L7,18@807L29,19@890L584,19@857L617:PrintOverlay.kt#g6pi6z");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(uri) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043003786, i2, -1, "com.box.android.preview.previewtype.document.print.PrintOverlay (PrintOverlay.kt:16)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            composer2 = composerStartRestartGroup;
            PrintReducer.State state2 = (PrintReducer.State) FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer2, 0, 7).getValue();
            if (state2 != null) {
                Boolean boolValueOf = Boolean.valueOf(state2.isPrinting());
                ComposerKt.sourceInformationMarkerStart(composer2, 526591346, "CC(remember):PrintOverlay.kt#9igjgp");
                int i4 = i2 & 14;
                boolean zChanged = (i4 == 4) | composer2.changed(state2) | composer2.changedInstance(context) | composer2.changedInstance(uri);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i3 = 0;
                    state = state2;
                    printOverlayKt$PrintOverlay$1$1 = new PrintOverlayKt$PrintOverlay$1$1(state, context, uri, store, null);
                    composer2.updateRememberedValue(printOverlayKt$PrintOverlay$1$1);
                } else {
                    i3 = 0;
                    printOverlayKt$PrintOverlay$1$1 = objRememberedValue;
                    state = state2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) printOverlayKt$PrintOverlay$1$1, composer2, i3);
                PrintReducer.PasswordDialogState passwordDialogState = state.getPasswordDialogState();
                if (passwordDialogState == null) {
                    composer2.startReplaceGroup(-854931035);
                } else {
                    composer2.startReplaceGroup(-854931034);
                    ComposerKt.sourceInformation(composer2, "*40@1656L116,45@1798L95,38@1539L364");
                    boolean invalidPassword = passwordDialogState.getInvalidPassword();
                    ComposerKt.sourceInformationMarkerStart(composer2, 893111431, "CC(remember):PrintOverlay.kt#9igjgp");
                    int i5 = i4 == 4 ? 1 : i3;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (i5 != 0 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.document.print.PrintOverlayKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PrintOverlayKt.PrintOverlay$lambda$2$0$0(store, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function1 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 893115954, "CC(remember):PrintOverlay.kt#9igjgp");
                    int i6 = i4 != 4 ? i3 : 1;
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (i6 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.preview.previewtype.document.print.PrintOverlayKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PrintOverlayKt.PrintOverlay$lambda$2$1$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    PasswordEnterDialogKt.PasswordInputDialog(invalidPassword, function1, (Function0) objRememberedValue3, composer2, 0, 0);
                    composer2 = composer2;
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.print.PrintOverlayKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PrintOverlayKt.PrintOverlay$lambda$0(store, uri, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.print.PrintOverlayKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrintOverlayKt.PrintOverlay$lambda$3(store, uri, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintOverlay$lambda$2$0$0(Store store, String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        store.send(new PrintReducer.Action.Print(password));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintOverlay$lambda$2$1$0(Store store) {
        store.send(PrintReducer.Action.Finish.INSTANCE);
        return Unit.INSTANCE;
    }
}
