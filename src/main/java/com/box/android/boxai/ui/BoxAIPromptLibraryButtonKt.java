package com.box.android.boxai.ui;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxTextButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.boxai.R;
import com.box.brownfieldApi.featuresNavigator.activities.AiPromptLibraryActivity;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAIPromptLibraryButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"PromptLibraryButton", "", "onPromptSelected", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PromptLibraryButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAIPromptLibraryButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PromptLibraryButton$lambda$3(Function1 function1, int i, int i2, Composer composer, int i3) {
        PromptLibraryButton(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PromptLibraryButtonPreview$lambda$0(int i, Composer composer, int i2) {
        PromptLibraryButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PromptLibraryButton(final Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-26606670);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PromptLibraryButton)N(onPromptSelected)22@1031L2,23@1068L7,26@1206L216,24@1108L314,37@1567L150,34@1428L305:BoxAIPromptLibraryButton.kt#bwxcym");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 200795860, "CC(remember):BoxAIPromptLibraryButton.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAIPromptLibraryButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAIPromptLibraryButtonKt.PromptLibraryButton$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-26606670, i3, -1, "com.box.android.boxai.ui.PromptLibraryButton (BoxAIPromptLibraryButton.kt:22)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 200801674, "CC(remember):BoxAIPromptLibraryButton.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAIPromptLibraryButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAIPromptLibraryButtonKt.PromptLibraryButton$lambda$1$0(function1, (ActivityResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            int i5 = R.string.box_ai_prompt_library;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 200813160, "CC(remember):BoxAIPromptLibraryButton.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.boxai.ui.BoxAIPromptLibraryButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAIPromptLibraryButtonKt.PromptLibraryButton$lambda$2$0(context, managedActivityResultLauncherRememberLauncherForActivityResult);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxTextButtonKt.BoxTextButton(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue3, i5, 1, null), null, null, composerStartRestartGroup, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAIPromptLibraryButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAIPromptLibraryButtonKt.PromptLibraryButton$lambda$3(function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PromptLibraryButton$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PromptLibraryButton$lambda$1$0(Function1 function1, ActivityResult result) {
        Intent data;
        String stringExtra;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1 && (data = result.getData()) != null && (stringExtra = data.getStringExtra(ReactNativeFeatureActivity.RESULT_EXTRA_KEY)) != null) {
            function1.invoke(stringExtra);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PromptLibraryButton$lambda$2$0(Context context, ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(new Intent(context, (Class<?>) AiPromptLibraryActivity.class));
        return Unit.INSTANCE;
    }

    private static final void PromptLibraryButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1038579421);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PromptLibraryButtonPreview)52@1896L134:BoxAIPromptLibraryButton.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038579421, i, -1, "com.box.android.boxai.ui.PromptLibraryButtonPreview (BoxAIPromptLibraryButton.kt:51)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAIPromptLibraryButtonKt.INSTANCE.getLambda$177060600$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAIPromptLibraryButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAIPromptLibraryButtonKt.PromptLibraryButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
