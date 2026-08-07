package com.box.android.search.presentation.ui;

import android.app.Activity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.box.brownfieldApi.featuresNavigator.AiCenterInitialContext;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AiCenterLauncher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"AiCenterLauncher", "", "sessionId", "", AiCenterInitialContext.INITIAL_PROMPT_KEY, StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AiCenterLauncherKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$0(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        AiCenterLauncher(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$3(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        AiCenterLauncher(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AiCenterLauncher(final String str, final String str2, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-499559671);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AiCenterLauncher)N(sessionId,initialPrompt,onDismiss)13@590L7,17@737L27,15@628L136,21@791L269,21@770L290:AiCenterLauncher.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-499559671, i2, -1, "com.box.android.search.presentation.ui.AiCenterLauncher (AiCenterLauncher.kt:12)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Activity activity = (Activity) objConsume;
            if (activity != null) {
                ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959501988, "CC(remember):AiCenterLauncher.kt#9igjgp");
                boolean z = (i2 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.AiCenterLauncherKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AiCenterLauncherKt.AiCenterLauncher$lambda$1$0(onDismiss, (ActivityResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959503958, "CC(remember):AiCenterLauncher.kt#9igjgp");
                boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(activity) | ((i2 & 112) == 32);
                AiCenterLauncherKt$AiCenterLauncher$1$1 aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue = new AiCenterLauncherKt$AiCenterLauncher$1$1(managedActivityResultLauncherRememberLauncherForActivityResult, activity, str, str2, null);
                    composerStartRestartGroup.updateRememberedValue(aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aiCenterLauncherKt$AiCenterLauncher$1$1RememberedValue, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.search.presentation.ui.AiCenterLauncherKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AiCenterLauncherKt.AiCenterLauncher$lambda$0(str, str2, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.search.presentation.ui.AiCenterLauncherKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AiCenterLauncherKt.AiCenterLauncher$lambda$3(str, str2, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterLauncher$lambda$1$0(Function0 function0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }
}
