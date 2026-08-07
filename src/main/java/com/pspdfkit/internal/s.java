package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import com.pspdfkit.compose.theme.UiThemeKt;
import io.nutrient.data.models.Document;
import io.nutrient.data.models.DocumentIdentifiers;
import io.nutrient.domain.ai.AiAssistant;
import io.nutrient.domain.ai.AiAssistantNavigationListener;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/s;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class s extends BottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public v b;
    public AiAssistantNavigationListener c;
    public AiAssistant d;
    public String e;

    public static final Unit a(s sVar, boolean z, Function0 function0, Function2 function2, int i, Composer composer, int i2) {
        sVar.a(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(final s sVar, final Dialog dialog, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208203059, i, -1, "com.pspdfkit.internal.ai.AiAssistantDialog.setupDialog.<anonymous>.<anonymous> (AiAssistantDialog.kt:120)");
            }
            final AiAssistant aiAssistant = sVar.d;
            if (aiAssistant == null) {
                composer.startReplaceGroup(-644488346);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-644488345);
                boolean z = sVar.a;
                boolean zChangedInstance = composer.changedInstance(dialog);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return s.a(dialog);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                sVar.a(z, (Function0<Unit>) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-728514800, true, new Function2() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return s.a(aiAssistant, sVar, dialog, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 384);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (v) new ViewModelProvider(this).get(v.class);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        setStyle(2, R.style.PSPDFKit_AIAssistantDialog);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getClass();
        dialogOnCreateDialog.setCancelable(true);
        dialogOnCreateDialog.setCanceledOnTouchOutside(true);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (!requireActivity().isChangingConfigurations()) {
            v vVar = this.b;
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                vVar = null;
            }
            vVar.a = null;
        }
        synchronized (q10.class) {
            q10.e = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View viewFindViewById = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            viewFindViewById.getClass();
            FrameLayout frameLayout = (FrameLayout) viewFindViewById;
            frameLayout.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
            bottomSheetBehaviorFrom.setDraggable(false);
            bottomSheetBehaviorFrom.setState(3);
            Window window = dialog.getWindow();
            if (window == null) {
                return;
            }
            this.a = (uc.a(requireContext(), 540) || uc.d(requireContext())) ? false : true;
            Object systemService = requireContext().getSystemService("window");
            systemService.getClass();
            new DisplayMetrics();
            WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
            currentWindowMetrics.getClass();
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            insetsIgnoringVisibility.getClass();
            int iHeight = currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top;
            int dimension = this.a ? -1 : (int) getResources().getDimension(R.dimen.pspdf__aiassistant_max_width);
            if (this.a) {
                iHeight = -1;
            }
            WindowCompat.setDecorFitsSystemWindows(window, false);
            window.setLayout(dimension, iHeight);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.setGravity(8388693);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final void setupDialog(final Dialog dialog, int i) {
        dialog.getClass();
        super.setupDialog(dialog, i);
        AiAssistant aiAssistant = this.d;
        v vVar = this.b;
        if (aiAssistant != null) {
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                vVar = null;
            }
            vVar.a = this.d;
        } else {
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                vVar = null;
            }
            this.d = vVar.a;
            Unit unit = Unit.INSTANCE;
        }
        Context context = dialog.getContext();
        context.getClass();
        dialog.setContentView(y9.a(context, ComposableLambdaKt.composableLambdaInstance(-891702166, true, new Function2() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return s.a(this.f$0, dialog, (Composer) obj, ((Integer) obj2).intValue());
            }
        })));
    }

    public static final Unit a(final s sVar, final Dialog dialog, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891702166, i, -1, "com.pspdfkit.internal.ai.AiAssistantDialog.setupDialog.<anonymous> (AiAssistantDialog.kt:119)");
            }
            ThemeWrapperKt.WithUiTheme(UiThemeKt.getUiColors(composer, 0), ComposableLambdaKt.rememberComposableLambda(-208203059, true, new Function2() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return s.b(this.f$0, dialog, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    public static final Unit a(final AiAssistant aiAssistant, final s sVar, final Dialog dialog, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-728514800, i, -1, "com.pspdfkit.internal.ai.AiAssistantDialog.setupDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AiAssistantDialog.kt:122)");
            }
            String str = sVar.e;
            boolean zChangedInstance = composer.changedInstance(sVar) | composer.changedInstance(aiAssistant);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return s.a(this.f$0, aiAssistant, (List) obj, ((Integer) obj2).intValue(), (Document) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function3 function3 = (Function3) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(dialog);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return s.b(dialog);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            z.a(aiAssistant, (Modifier) null, str, (Function3<? super List<? extends RectF>, ? super Integer, ? super Document, Unit>) function3, (Function0<Unit>) objRememberedValue2, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    public static final Unit a(s sVar, AiAssistant aiAssistant, List list, int i, Document document) {
        list.getClass();
        document.getClass();
        AiAssistantNavigationListener aiAssistantNavigationListener = sVar.c;
        if (aiAssistantNavigationListener != null) {
            String documentId = document.getDocumentId();
            Iterator<DocumentIdentifiers> it = aiAssistant.getIdentifiers().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getPermanentId(), documentId)) {
                    break;
                }
                i2++;
            }
            aiAssistantNavigationListener.navigateTo(list, i, i2);
        }
        return Unit.INSTANCE;
    }

    public final void a(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1292829049);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1292829049, i2, -1, "com.pspdfkit.internal.ai.AiAssistantDialog.AiAssistantWrapper (AiAssistantDialog.kt:143)");
            }
            AiAssistantColorScheme aiAssistantColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getAiAssistantColorScheme();
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1698647233);
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 14));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1698723462);
                int dimension = (int) getResources().getDimension(R.dimen.pspdf__aiassistant_padding);
                int dimension2 = (int) getResources().getDimension(R.dimen.pspdf__aiassistant_header_spacing);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                Modifier.Companion companion = Modifier.INSTANCE;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                boolean z2 = (i2 & 112) == 32;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return s.a(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ClickableKt.m628clickableO2vRcR0$default(companion, mutableInteractionSource, null, false, null, null, (Function0) objRememberedValue2, 28, null), 0.0f, 1, null);
                density.getClass();
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxSize$default, 0.0f, 0.0f, density.mo751toDpu2uoSUM(dimension), density.mo751toDpu2uoSUM(dimension), 3, null), 0.0f, density.mo751toDpu2uoSUM(dimension2), 0.0f, 0.0f, 13, null);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return s.a();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                CardKt.Card(ClickableKt.m632clickableoSLSa3U$default(modifierM1222paddingqDBjuR0$default, false, null, null, null, (Function0) objRememberedValue3, 14, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), null, null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl((float) 0.5d), aiAssistantColorScheme.m13905getChatBackground0d7_KjU()), ComposableLambdaKt.rememberComposableLambda(-1010545501, true, new Function3() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return s.a(function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 12);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.s$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return s.a(this.f$0, z, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }

    public static final Unit a(Function2 function2, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1010545501, i, -1, "com.pspdfkit.internal.ai.AiAssistantDialog.AiAssistantWrapper.<anonymous> (AiAssistantDialog.kt:167)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
