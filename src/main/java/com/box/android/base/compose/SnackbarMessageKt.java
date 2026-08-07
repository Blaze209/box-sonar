package com.box.android.base.compose;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"SnackbarMessage", "", "message", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "snackbarAction", "Lcom/box/android/base/compose/SnackbarAction;", "onSnackbarShown", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/material3/SnackbarDuration;Landroidx/compose/material3/SnackbarHostState;Lkotlinx/coroutines/CoroutineScope;Lcom/box/android/base/compose/SnackbarAction;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SnackbarMessageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarMessage$lambda$1(String str, SnackbarDuration snackbarDuration, SnackbarHostState snackbarHostState, CoroutineScope coroutineScope, SnackbarAction snackbarAction, Function0 function0, int i, int i2, Composer composer, int i3) {
        SnackbarMessage(str, snackbarDuration, snackbarHostState, coroutineScope, snackbarAction, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0158  */
    /* JADX WARN: Code duplicated, block: B:103:0x0164  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:80:0x0108  */
    /* JADX WARN: Code duplicated, block: B:81:0x010b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0114  */
    /* JADX WARN: Code duplicated, block: B:85:0x0117  */
    /* JADX WARN: Code duplicated, block: B:88:0x0121  */
    /* JADX WARN: Code duplicated, block: B:95:0x0138  */
    /* JADX WARN: Code duplicated, block: B:98:0x0153  */
    public static final void SnackbarMessage(final String str, SnackbarDuration snackbarDuration, final SnackbarHostState snackbarHostState, final CoroutineScope coroutineScope, SnackbarAction snackbarAction, final Function0<Unit> onSnackbarShown, Composer composer, final int i, final int i2) {
        int i3;
        SnackbarAction snackbarAction2;
        boolean z;
        final SnackbarDuration snackbarDuration2;
        final SnackbarAction snackbarAction3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SnackbarDuration snackbarDuration3;
        SnackbarAction snackbarAction4;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        SnackbarDuration snackbarDuration4;
        SnackbarMessageKt$SnackbarMessage$1$1 snackbarMessageKt$SnackbarMessage$1$1;
        int i5;
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(onSnackbarShown, "onSnackbarShown");
        Composer composerStartRestartGroup = composer.startRestartGroup(-731835647);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SnackbarMessage)N(message,duration,snackbarHostState,coroutineScope,snackbarAction,onSnackbarShown)20@685L538,20@661L562:SnackbarMessage.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarDuration == null ? -1 : snackbarDuration.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 2048 : 1024;
        }
        int i7 = i2 & 16;
        if (i7 == 0) {
            if ((i & 24576) == 0) {
                snackbarAction2 = snackbarAction;
                i3 |= composerStartRestartGroup.changed(snackbarAction2) ? 16384 : 8192;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onSnackbarShown)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                snackbarDuration2 = snackbarDuration;
                snackbarAction3 = snackbarAction2;
            } else {
                if (i6 != 0) {
                    snackbarDuration3 = SnackbarDuration.Short;
                } else {
                    snackbarDuration3 = snackbarDuration;
                }
                if (i7 != 0) {
                    snackbarAction4 = null;
                } else {
                    snackbarAction4 = snackbarAction2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731835647, i3, -1, "com.box.android.base.compose.SnackbarMessage (SnackbarMessage.kt:19)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1080589467, "CC(remember):SnackbarMessage.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((i3 & 896) == 256) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean zChangedInstance = z2 | z3 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((57344 & i3) == 16384) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z7 = zChangedInstance | z4;
                if ((i3 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z7 | z5 | ((i3 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    snackbarDuration4 = snackbarDuration3;
                    snackbarAction3 = snackbarAction4;
                    snackbarMessageKt$SnackbarMessage$1$1 = new SnackbarMessageKt$SnackbarMessage$1$1(str, snackbarHostState, coroutineScope, onSnackbarShown, snackbarAction3, snackbarDuration4, null);
                    composerStartRestartGroup.updateRememberedValue(snackbarMessageKt$SnackbarMessage$1$1);
                } else {
                    snackbarMessageKt$SnackbarMessage$1$1 = objRememberedValue;
                    snackbarDuration4 = snackbarDuration3;
                    snackbarAction3 = snackbarAction4;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) snackbarMessageKt$SnackbarMessage$1$1, composerStartRestartGroup, i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarDuration2 = snackbarDuration4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SnackbarMessageKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarMessageKt.SnackbarMessage$lambda$1(str, snackbarDuration2, snackbarHostState, coroutineScope, snackbarAction3, onSnackbarShown, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        snackbarAction2 = snackbarAction;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(onSnackbarShown)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        }
        if ((i3 & 74899) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            snackbarDuration2 = snackbarDuration;
            snackbarAction3 = snackbarAction2;
        } else {
            if (i6 != 0) {
                snackbarDuration3 = SnackbarDuration.Short;
            } else {
                snackbarDuration3 = snackbarDuration;
            }
            if (i7 != 0) {
                snackbarAction4 = null;
            } else {
                snackbarAction4 = snackbarAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-731835647, i3, -1, "com.box.android.base.compose.SnackbarMessage (SnackbarMessage.kt:19)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1080589467, "CC(remember):SnackbarMessage.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i3 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean zChangedInstance2 = z2 | z3 | composerStartRestartGroup.changedInstance(coroutineScope);
            if ((57344 & i3) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z8 = zChangedInstance2 | z4;
            if ((i3 & 112) == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z8 | z5 | ((i3 & 458752) == 131072);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z6) {
                snackbarDuration4 = snackbarDuration3;
                snackbarAction3 = snackbarAction4;
                snackbarMessageKt$SnackbarMessage$1$1 = new SnackbarMessageKt$SnackbarMessage$1$1(str, snackbarHostState, coroutineScope, onSnackbarShown, snackbarAction3, snackbarDuration4, null);
                composerStartRestartGroup.updateRememberedValue(snackbarMessageKt$SnackbarMessage$1$1);
            } else {
                snackbarDuration4 = snackbarDuration3;
                snackbarAction3 = snackbarAction4;
                snackbarMessageKt$SnackbarMessage$1$1 = new SnackbarMessageKt$SnackbarMessage$1$1(str, snackbarHostState, coroutineScope, onSnackbarShown, snackbarAction3, snackbarDuration4, null);
                composerStartRestartGroup.updateRememberedValue(snackbarMessageKt$SnackbarMessage$1$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) snackbarMessageKt$SnackbarMessage$1$1, composerStartRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            snackbarDuration2 = snackbarDuration4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SnackbarMessageKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarMessageKt.SnackbarMessage$lambda$1(str, snackbarDuration2, snackbarHostState, coroutineScope, snackbarAction3, onSnackbarShown, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
