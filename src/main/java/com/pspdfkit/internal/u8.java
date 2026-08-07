package com.pspdfkit.internal;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.Issuer;
import io.nutrient.data.models.Link;
import io.nutrient.data.models.Suggestion;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u8 {
    public static final Unit a(String str, long j, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290945162, i, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleAdditionalContextView.<anonymous> (ChatBubbleView.kt:271)");
            }
            str.getClass();
            TextKt.m4494TextNvy7gAk(StringsKt.replace$default(str, "\n", " ", false, 4, (Object) null), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), j, null, TextUnitKt.getSp(16), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 0, 0, null, null, composer, 24624, 384, 258024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(String str, long j, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1079120915, i, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleInnerLinkView.<anonymous> (ChatBubbleView.kt:301)");
            }
            str.getClass();
            TextKt.m4494TextNvy7gAk(StringsKt.replace$default(str, "\n", " ", false, 4, (Object) null), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), j, null, TextUnitKt.getSp(16), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer, 24624, 24960, 241640);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit c(String str, long j, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719364525, i, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleInnerView.<anonymous> (ChatBubbleView.kt:248)");
            }
            str.getClass();
            TextKt.m4494TextNvy7gAk(StringsKt.replace$default(str, "\n", " ", false, 4, (Object) null), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), j, null, TextUnitKt.getSp(16), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 0, 0, null, null, composer, 24624, 384, 258024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(Modifier modifier, String str, long j, long j2, Function0 function0, int i, int i2, Composer composer, int i3) {
        b(modifier, str, j, j2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit b(Function1 function1, Suggestion suggestion) {
        function1.invoke(suggestion);
        return Unit.INSTANCE;
    }

    public static final void b(Modifier modifier, final String str, final long j, final long j2, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function0<Unit> function1;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1788418658);
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        } else {
            function1 = function0;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1788418658, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleInnerView (ChatBubbleView.kt:235)");
            }
            Modifier modifierM1273widthInVpY3zN4$default = SizeKt.m1273widthInVpY3zN4$default(modifier4, 0.0f, Dp.m9687constructorimpl(280), 1, null);
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
            Color.Companion companion = Color.INSTANCE;
            composer2 = composerStartRestartGroup;
            CardKt.Card(function1, modifierM1273widthInVpY3zN4$default, false, roundedCornerShapeM1573RoundedCornerShape0680j_4, new CardColors(j, companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null), null, null, null, ComposableLambdaKt.rememberComposableLambda(-719364525, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return u8.c(str, j2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 12) & 14) | 100663296, BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return u8.b(modifier3, str, j, j2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Modifier modifier, String str, long j, long j2, int i, int i2, Composer composer, int i3) {
        a(modifier, str, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, String str, long j, long j2, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, str, j, j2, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, AiAssistantColorScheme aiAssistantColorScheme, CompletionResponse completionResponse, Function1 function1, Function1 function2, boolean z, int i, int i2, Composer composer, int i3) {
        a(modifier, aiAssistantColorScheme, completionResponse, (Function1<? super Suggestion, Unit>) function1, (Function1<? super Link, Unit>) function2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, AiAssistantColorScheme aiAssistantColorScheme, boolean z, boolean z2, String str, boolean z3, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, aiAssistantColorScheme, z, z2, str, z3, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:77:0x0104  */
    /* JADX WARN: Code duplicated, block: B:80:0x0134  */
    /* JADX WARN: Code duplicated, block: B:83:0x0140  */
    /* JADX WARN: Code duplicated, block: B:84:0x0144  */
    /* JADX WARN: Code duplicated, block: B:87:0x017a  */
    /* JADX WARN: Code duplicated, block: B:88:0x017f  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:96:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    public static final void a(Modifier modifier, final AiAssistantColorScheme aiAssistantColorScheme, final CompletionResponse completionResponse, final Function1<? super Suggestion, Unit> function1, final Function1<? super Link, Unit> function2, boolean z, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        AiAssistantColorScheme aiAssistantColorScheme2;
        CompletionResponse completionResponse2;
        boolean z2;
        final boolean z3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        final boolean zAreEqual;
        String content;
        Alignment.Horizontal start;
        Function0<ComposeUiNode> constructor;
        long jM13905getChatBackground0d7_KjU;
        aiAssistantColorScheme.getClass();
        completionResponse.getClass();
        function1.getClass();
        function2.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-596516794);
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
            aiAssistantColorScheme2 = aiAssistantColorScheme;
            i3 |= composerStartRestartGroup.changed(aiAssistantColorScheme2) ? 32 : 16;
        } else {
            aiAssistantColorScheme2 = aiAssistantColorScheme;
        }
        if ((i & 384) == 0) {
            completionResponse2 = completionResponse;
            i3 |= composerStartRestartGroup.changedInstance(completionResponse2) ? 256 : 128;
        } else {
            completionResponse2 = completionResponse;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int i5 = i2 & 32;
        if (i5 == 0) {
            if ((196608 & i) == 0) {
                i3 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-596516794, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleView (ChatBubbleView.kt:60)");
                }
                zAreEqual = Intrinsics.areEqual(completionResponse2.getSender(), Issuer.INSTANCE.value(Issuer.HUMAN));
                content = completionResponse2.getContent();
                if (content == null) {
                    content = "";
                }
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(4));
                if (zAreEqual) {
                    start = Alignment.INSTANCE.getEnd();
                } else {
                    start = Alignment.INSTANCE.getStart();
                }
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 0);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                f2.a(companion, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierM1273widthInVpY3zN4$default = SizeKt.m1273widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(280), 1, null);
                RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                if (zAreEqual) {
                    jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13910getMineChatBackground0d7_KjU();
                } else {
                    jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13905getChatBackground0d7_KjU();
                }
                CardColors cardColorsM2903cardColorsro_MJ88 = cardDefaults.m2903cardColorsro_MJ88(jM13905getChatBackground0d7_KjU, 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
                composerStartRestartGroup = composerStartRestartGroup;
                final boolean z5 = z4;
                final String str = content;
                final AiAssistantColorScheme aiAssistantColorScheme3 = aiAssistantColorScheme2;
                final CompletionResponse completionResponse3 = completionResponse2;
                CardKt.Card(modifierM1273widthInVpY3zN4$default, roundedCornerShapeM1573RoundedCornerShape0680j_4, cardColorsM2903cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(-436438482, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return u8.a(str, zAreEqual, aiAssistantColorScheme3, z5, completionResponse3, function1, function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 24);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return u8.a(modifier3, aiAssistantColorScheme, completionResponse, function1, function2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i5 != 0) {
                z4 = true;
            } else {
                z4 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-596516794, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleView (ChatBubbleView.kt:60)");
            }
            zAreEqual = Intrinsics.areEqual(completionResponse2.getSender(), Issuer.INSTANCE.value(Issuer.HUMAN));
            content = completionResponse2.getContent();
            if (content == null) {
                content = "";
            }
            Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(4));
            if (zAreEqual) {
                start = Alignment.INSTANCE.getEnd();
            } else {
                start = Alignment.INSTANCE.getStart();
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Modifier modifierM1273widthInVpY3zN4$default2 = SizeKt.m1273widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(280), 1, null);
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
            CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
            if (zAreEqual) {
                jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13910getMineChatBackground0d7_KjU();
            } else {
                jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13905getChatBackground0d7_KjU();
            }
            CardColors cardColorsM2903cardColorsro_MJ89 = cardDefaults2.m2903cardColorsro_MJ88(jM13905getChatBackground0d7_KjU, 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
            composerStartRestartGroup = composerStartRestartGroup;
            final boolean z6 = z4;
            final String str2 = content;
            final AiAssistantColorScheme aiAssistantColorScheme4 = aiAssistantColorScheme2;
            final CompletionResponse completionResponse4 = completionResponse2;
            CardKt.Card(modifierM1273widthInVpY3zN4$default2, roundedCornerShapeM1573RoundedCornerShape0680j_5, cardColorsM2903cardColorsro_MJ89, null, null, ComposableLambdaKt.rememberComposableLambda(-436438482, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return u8.a(str2, zAreEqual, aiAssistantColorScheme4, z6, completionResponse4, function1, function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 24);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z3 = z;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return u8.a(modifier3, aiAssistantColorScheme, completionResponse, function1, function2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(String str, boolean z, AiAssistantColorScheme aiAssistantColorScheme, boolean z2, CompletionResponse completionResponse, final Function1 function1, final Function1 function2, ColumnScope columnScope, Composer composer, int i) {
        Object obj;
        Object obj2;
        long jM13914getTextColor0d7_KjU;
        Composer composer2 = composer;
        columnScope.getClass();
        if (composer2.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-436438482, i, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleView.<anonymous>.<anonymous> (ChatBubbleView.kt:88)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1218padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str.length() > 0) {
                composer2.startReplaceGroup(201505641);
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(4), 7, null);
                long sp = TextUnitKt.getSp(16);
                if (z) {
                    jM13914getTextColor0d7_KjU = aiAssistantColorScheme.m13911getMineChatTextColor0d7_KjU();
                } else {
                    jM13914getTextColor0d7_KjU = aiAssistantColorScheme.m13914getTextColor0d7_KjU();
                }
                ap.a(str, modifierM1222paddingqDBjuR0$default, jM13914getTextColor0d7_KjU, sp, z2, composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(201974206);
                composer2.endReplaceGroup();
            }
            String quotedContext = completionResponse.getQuotedContext();
            if (quotedContext == null) {
                composer2.startReplaceGroup(202024518);
                composer2.endReplaceGroup();
                obj = null;
            } else {
                composer2.startReplaceGroup(202024519);
                obj = null;
                a(PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, Dp.m9687constructorimpl((float) r3), 1, null), quotedContext, aiAssistantColorScheme.m13915getTextFieldBackgroundColor0d7_KjU(), aiAssistantColorScheme.m13914getTextColor0d7_KjU(), composer, 6, 0);
                composer2 = composer;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
            }
            if (completionResponse.getAdditionalContext() == null) {
                composer2.startReplaceGroup(202522100);
                List<Suggestion> suggestions = completionResponse.getSuggestions();
                if (suggestions == null) {
                    composer2.startReplaceGroup(202522099);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(202522100);
                    for (final Suggestion suggestion : suggestions) {
                        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl((float) 4), 1, obj);
                        String text = suggestion.getText();
                        long jM13908getInnerChatBackground0d7_KjU = aiAssistantColorScheme.m13908getInnerChatBackground0d7_KjU();
                        long jM13909getInnerChatTextColor0d7_KjU = aiAssistantColorScheme.m13909getInnerChatTextColor0d7_KjU();
                        boolean zChanged = composer2.changed(function1) | composer2.changed(suggestion);
                        Object objRememberedValue = composer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return u8.a(function1, suggestion);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        b(modifierM1220paddingVpY3zN4$default, text, jM13908getInnerChatBackground0d7_KjU, jM13909getInnerChatTextColor0d7_KjU, (Function0) objRememberedValue, composer2, 6, 0);
                        obj = null;
                    }
                    composer2.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                obj2 = null;
            } else {
                float f = 0.0f;
                composer2.startReplaceGroup(202975847);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8)), companion2.getTop(), composer2, 6);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                f2.a(companion3, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                List<Suggestion> suggestions2 = completionResponse.getSuggestions();
                if (suggestions2 == null) {
                    composer2.startReplaceGroup(-1534077384);
                    composer2.endReplaceGroup();
                    obj2 = null;
                } else {
                    composer2.startReplaceGroup(-1534077383);
                    for (final Suggestion suggestion2 : suggestions2) {
                        Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, f, Dp.m9687constructorimpl((float) r3), 1, null);
                        String text2 = suggestion2.getText();
                        long jM13908getInnerChatBackground0d7_KjU2 = aiAssistantColorScheme.m13908getInnerChatBackground0d7_KjU();
                        long jM13909getInnerChatTextColor0d7_KjU2 = aiAssistantColorScheme.m13909getInnerChatTextColor0d7_KjU();
                        boolean zChanged2 = composer2.changed(function1) | composer2.changed(suggestion2);
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return u8.b(function1, suggestion2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        b(modifierM1220paddingVpY3zN4$default2, text2, jM13908getInnerChatBackground0d7_KjU2, jM13909getInnerChatTextColor0d7_KjU2, (Function0) objRememberedValue2, composer2, 6, 0);
                        f = 0.0f;
                    }
                    obj2 = null;
                    composer2.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                composer2.endNode();
                composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            composer2.startReplaceGroup(-963261811);
            for (final Link link : completionResponse.getLinks()) {
                Modifier modifierM1220paddingVpY3zN4$default3 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl((float) r3), 1, obj2);
                String text3 = link.getText();
                long jM13908getInnerChatBackground0d7_KjU3 = aiAssistantColorScheme.m13908getInnerChatBackground0d7_KjU();
                long jM13909getInnerChatTextColor0d7_KjU3 = aiAssistantColorScheme.m13909getInnerChatTextColor0d7_KjU();
                boolean zChanged3 = composer2.changed(function2) | composer2.changed(link);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return u8.a(function2, link);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                a(modifierM1220paddingVpY3zN4$default3, text3, jM13908getInnerChatBackground0d7_KjU3, jM13909getInnerChatTextColor0d7_KjU3, (Function0<Unit>) objRememberedValue3, composer2, 6, 0);
                composer2 = composer;
            }
            composer.endReplaceGroup();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, Suggestion suggestion) {
        function1.invoke(suggestion);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, Link link) {
        function1.invoke(link);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x0129  */
    /* JADX WARN: Code duplicated, block: B:87:0x0135  */
    /* JADX WARN: Code duplicated, block: B:88:0x0139  */
    /* JADX WARN: Code duplicated, block: B:91:0x0167  */
    /* JADX WARN: Code duplicated, block: B:92:0x016c  */
    /* JADX WARN: Code duplicated, block: B:95:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01b9  */
    public static final void a(Modifier modifier, final AiAssistantColorScheme aiAssistantColorScheme, final boolean z, final boolean z2, final String str, boolean z3, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        AiAssistantColorScheme aiAssistantColorScheme2;
        boolean z4;
        boolean z5;
        boolean z6;
        final Modifier modifier3;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final boolean z8;
        Alignment.Horizontal start;
        Function0<ComposeUiNode> constructor;
        long jM13905getChatBackground0d7_KjU;
        int i4;
        aiAssistantColorScheme.getClass();
        str.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1173083269);
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            aiAssistantColorScheme2 = aiAssistantColorScheme;
            i3 |= composerStartRestartGroup.changed(aiAssistantColorScheme2) ? 32 : 16;
        } else {
            aiAssistantColorScheme2 = aiAssistantColorScheme;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z4 = z2;
            i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
        } else {
            z4 = z2;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        int i6 = i2 & 32;
        if (i6 == 0) {
            if ((196608 & i) == 0) {
                z5 = z3;
                i3 |= composerStartRestartGroup.changed(z5) ? 131072 : 65536;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i4 = 1048576;
                } else {
                    i4 = 524288;
                }
                i3 |= i4;
            }
            if ((599187 & i3) != 599186) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    z8 = true;
                } else {
                    z8 = z5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1173083269, i3, -1, "io.nutrient.internal.ui.ai.ui.RetryBubble (ChatBubbleView.kt:164)");
                }
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m9687constructorimpl(4));
                if (z) {
                    start = Alignment.INSTANCE.getEnd();
                } else {
                    start = Alignment.INSTANCE.getStart();
                }
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 0);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                f2.a(companion, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                if (z) {
                    jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13910getMineChatBackground0d7_KjU();
                } else {
                    jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13905getChatBackground0d7_KjU();
                }
                CardColors cardColorsM2903cardColorsro_MJ88 = cardDefaults.m2903cardColorsro_MJ88(jM13905getChatBackground0d7_KjU, 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
                composerStartRestartGroup = composerStartRestartGroup;
                final AiAssistantColorScheme aiAssistantColorScheme3 = aiAssistantColorScheme2;
                final boolean z9 = z4;
                Modifier modifier5 = modifier4;
                CardKt.Card(modifierFillMaxWidth$default, roundedCornerShapeM1573RoundedCornerShape0680j_4, cardColorsM2903cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(1232663965, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return u8.a(str, z, aiAssistantColorScheme3, z8, z9, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 24);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z7 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return u8.a(modifier3, aiAssistantColorScheme, z, z2, str, z7, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z5 = z3;
        if ((1572864 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i4 = 1048576;
            } else {
                i4 = 524288;
            }
            i3 |= i4;
        }
        if ((599187 & i3) != 599186) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i6 != 0) {
                z8 = true;
            } else {
                z8 = z5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1173083269, i3, -1, "io.nutrient.internal.ui.ai.ui.RetryBubble (ChatBubbleView.kt:164)");
            }
            Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m9687constructorimpl(4));
            if (z) {
                start = Alignment.INSTANCE.getEnd();
            } else {
                start = Alignment.INSTANCE.getStart();
            }
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
            CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
            if (z) {
                jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13910getMineChatBackground0d7_KjU();
            } else {
                jM13905getChatBackground0d7_KjU = aiAssistantColorScheme2.m13905getChatBackground0d7_KjU();
            }
            CardColors cardColorsM2903cardColorsro_MJ89 = cardDefaults2.m2903cardColorsro_MJ88(jM13905getChatBackground0d7_KjU, 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
            composerStartRestartGroup = composerStartRestartGroup;
            final AiAssistantColorScheme aiAssistantColorScheme4 = aiAssistantColorScheme2;
            final boolean z10 = z4;
            Modifier modifier6 = modifier4;
            CardKt.Card(modifierFillMaxWidth$default2, roundedCornerShapeM1573RoundedCornerShape0680j_5, cardColorsM2903cardColorsro_MJ89, null, null, ComposableLambdaKt.rememberComposableLambda(1232663965, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return u8.a(str, z, aiAssistantColorScheme4, z8, z10, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 24);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z8;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z7 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return u8.a(modifier3, aiAssistantColorScheme, z, z2, str, z7, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(String str, boolean z, final AiAssistantColorScheme aiAssistantColorScheme, boolean z2, boolean z3, Function0 function0, ColumnScope columnScope, Composer composer, int i) {
        long jM13914getTextColor0d7_KjU;
        Composer composer2 = composer;
        columnScope.getClass();
        if (composer2.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232663965, i, -1, "io.nutrient.internal.ui.ai.ui.RetryBubble.<anonymous>.<anonymous> (ChatBubbleView.kt:188)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(12));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1218padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str.length() > 0) {
                composer2.startReplaceGroup(-124067130);
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(4), 7, null);
                long sp = TextUnitKt.getSp(16);
                if (z) {
                    jM13914getTextColor0d7_KjU = aiAssistantColorScheme.m13911getMineChatTextColor0d7_KjU();
                } else {
                    jM13914getTextColor0d7_KjU = aiAssistantColorScheme.m13914getTextColor0d7_KjU();
                }
                ap.a(str, modifierM1222paddingqDBjuR0$default, jM13914getTextColor0d7_KjU, sp, z2, composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-123598565);
                composer2.endReplaceGroup();
            }
            if (z3) {
                composer2.startReplaceGroup(-123538146);
                ButtonKt.Button((Function0<Unit>) function0, columnScopeInstance.align(PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), companion2.getEnd()), false, (Shape) null, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(aiAssistantColorScheme.m13912getRetryButtonBackgroundColor0d7_KjU(), 0L, 0L, 0L, composer, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1832873627, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return u8.a(aiAssistantColorScheme, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 805306368, 492);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-122833733);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1832873627, i, -1, "io.nutrient.internal.ui.ai.ui.RetryBubble.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatBubbleView.kt:216)");
            }
            TextKt.m4494TextNvy7gAk("Retry", null, aiAssistantColorScheme.m13911getMineChatTextColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final String str, final long j, final long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1050311420);
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050311420, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleAdditionalContextView (ChatBubbleView.kt:259)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            Color.Companion companion = Color.INSTANCE;
            CardKt.Card(modifierFillMaxWidth$default, rectangleShape, new CardColors(j, companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null), null, null, ComposableLambdaKt.rememberComposableLambda(-290945162, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return u8.a(str, j2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196656, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return u8.a(modifier3, str, j, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x0123  */
    /* JADX WARN: Code duplicated, block: B:67:0x0129  */
    /* JADX WARN: Code duplicated, block: B:70:0x0136  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final void a(Modifier modifier, final String str, final long j, final long j2, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function0<Unit> function1;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0<Unit> function3;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1996150200);
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return u8.a();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function3 = (Function0) objRememberedValue;
                } else {
                    function3 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1996150200, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleInnerLinkView (ChatBubbleView.kt:288)");
                }
                Modifier modifierM1273widthInVpY3zN4$default = SizeKt.m1273widthInVpY3zN4$default(modifier4, 0.0f, Dp.m9687constructorimpl(280), 1, null);
                RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
                Color.Companion companion = Color.INSTANCE;
                composer2 = composerStartRestartGroup;
                CardKt.Card(function3, modifierM1273widthInVpY3zN4$default, false, roundedCornerShapeM1573RoundedCornerShape0680j_4, new CardColors(j, companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null), null, null, null, ComposableLambdaKt.rememberComposableLambda(-1079120915, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return u8.b(str, j2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 12) & 14) | 100663296, BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function2 = function3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function2 = function1;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return u8.a(modifier3, str, j, j2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function1 = function0;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i5 != 0) {
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return u8.a();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function3 = (Function0) objRememberedValue;
            } else {
                function3 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1996150200, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatBubbleInnerLinkView (ChatBubbleView.kt:288)");
            }
            Modifier modifierM1273widthInVpY3zN4$default2 = SizeKt.m1273widthInVpY3zN4$default(modifier4, 0.0f, Dp.m9687constructorimpl(280), 1, null);
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20));
            Color.Companion companion2 = Color.INSTANCE;
            composer2 = composerStartRestartGroup;
            CardKt.Card(function3, modifierM1273widthInVpY3zN4$default2, false, roundedCornerShapeM1573RoundedCornerShape0680j_5, new CardColors(j, companion2.m6850getUnspecified0d7_KjU(), companion2.m6850getUnspecified0d7_KjU(), companion2.m6850getUnspecified0d7_KjU(), null), null, null, null, ComposableLambdaKt.rememberComposableLambda(-1079120915, true, new Function3() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return u8.b(str, j2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 12) & 14) | 100663296, BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function2 = function3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function2 = function1;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.u8$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return u8.a(modifier3, str, j, j2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
