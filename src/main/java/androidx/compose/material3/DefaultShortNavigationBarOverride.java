package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultShortNavigationBarOverride;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "<init>", "()V", "ShortNavigationBar", "", "Landroidx/compose/material3/ShortNavigationBarOverrideScope;", "(Landroidx/compose/material3/ShortNavigationBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultShortNavigationBarOverride implements ShortNavigationBarOverride {
    public static final int $stable = 0;
    public static final DefaultShortNavigationBarOverride INSTANCE = new DefaultShortNavigationBarOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBar$lambda$1(DefaultShortNavigationBarOverride defaultShortNavigationBarOverride, ShortNavigationBarOverrideScope shortNavigationBarOverrideScope, int i, Composer composer, int i2) {
        defaultShortNavigationBarOverride.ShortNavigationBar(shortNavigationBarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultShortNavigationBarOverride() {
    }

    @Override // androidx.compose.material3.ShortNavigationBarOverride
    public void ShortNavigationBar(final ShortNavigationBarOverrideScope shortNavigationBarOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(256157474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBar)125@5762L865,125@5680L947:ShortNavigationBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(shortNavigationBarOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(256157474, i2, -1, "androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar (ShortNavigationBar.kt:124)");
            }
            SurfaceKt.m4323SurfaceT9BRK9s(shortNavigationBarOverrideScope.getModifier(), null, shortNavigationBarOverrideScope.getContainerColor(), shortNavigationBarOverrideScope.getContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(236236519, true, new Function2() { // from class: androidx.compose.material3.DefaultShortNavigationBarOverride$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultShortNavigationBarOverride.ShortNavigationBar$lambda$0(shortNavigationBarOverrideScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultShortNavigationBarOverride$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultShortNavigationBarOverride.ShortNavigationBar$lambda$1(this.f$0, shortNavigationBarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBar$lambda$0(ShortNavigationBarOverrideScope shortNavigationBarOverrideScope, Composer composer, int i) {
        CenteredContentMeasurePolicy centeredContentMeasurePolicy;
        ComposerKt.sourceInformation(composer, "C126@5776L841:ShortNavigationBar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(236236519, i, -1, "androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar.<anonymous> (ShortNavigationBar.kt:126)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1251defaultMinSizeVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, shortNavigationBarOverrideScope.getWindowInsets()), 0.0f, NavigationBarTokens.INSTANCE.m5552getContainerHeightD9Ej5fM(), 1, null));
            Function2<Composer, Integer, Unit> content = shortNavigationBarOverrideScope.getContent();
            int arrangement = shortNavigationBarOverrideScope.getArrangement();
            if (ShortNavigationBarArrangement.m4166equalsimpl0(arrangement, ShortNavigationBarArrangement.INSTANCE.m4171getEqualWeightLnnQw40())) {
                centeredContentMeasurePolicy = new EqualWeightContentMeasurePolicy();
            } else if (ShortNavigationBarArrangement.m4166equalsimpl0(arrangement, ShortNavigationBarArrangement.INSTANCE.m4170getCenteredLnnQw40())) {
                centeredContentMeasurePolicy = new CenteredContentMeasurePolicy();
            } else {
                throw new IllegalArgumentException("Invalid ItemsArrangement value.");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSelectableGroup);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, centeredContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            content.invoke(composer, 0);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
