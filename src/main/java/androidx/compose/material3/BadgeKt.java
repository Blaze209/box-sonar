package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalRuler;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010%\u001a\u00020\b*\u00020\bH\u0000\"\u0016\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015\"\u0016\u0010\u0019\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015\"\u0016\u0010\u001b\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeWithContentHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getBadgeWithContentHorizontalPadding", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "BadgeOffset", "getBadgeOffset", "BadgeTopRuler", "Landroidx/compose/ui/layout/HorizontalRuler;", "getBadgeTopRuler", "()Landroidx/compose/ui/layout/HorizontalRuler;", "BadgeEndRuler", "Landroidx/compose/ui/layout/VerticalRuler;", "getBadgeEndRuler", "()Landroidx/compose/ui/layout/VerticalRuler;", "badgeBounds", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt {
    private static final float BadgeWithContentHorizontalPadding = Dp.m9687constructorimpl(4);
    private static final float BadgeWithContentHorizontalOffset = Dp.m9687constructorimpl(12);
    private static final float BadgeWithContentVerticalOffset = Dp.m9687constructorimpl(14);
    private static final float BadgeOffset = Dp.m9687constructorimpl(6);
    private static final HorizontalRuler BadgeTopRuler = new HorizontalRuler();
    private static final VerticalRuler BadgeEndRuler = new VerticalRuler();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Badge_eopBjH0$lambda$1(Modifier modifier, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2806BadgeeopBjH0(modifier, j, j2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BadgedBox$lambda$2(Function3 function3, Modifier modifier, Function3 function4, int i, int i2, Composer composer, int i3) {
        BadgedBox(function3, modifier, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x008a  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:54:0x0103  */
    /* JADX WARN: Code duplicated, block: B:57:0x0167  */
    /* JADX WARN: Code duplicated, block: B:60:0x0173  */
    /* JADX WARN: Code duplicated, block: B:61:0x0177  */
    /* JADX WARN: Code duplicated, block: B:66:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:69:0x022f  */
    /* JADX WARN: Code duplicated, block: B:72:0x023b  */
    /* JADX WARN: Code duplicated, block: B:73:0x023f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0272  */
    /* JADX WARN: Code duplicated, block: B:81:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:82:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:85:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        BadgeKt$BadgedBox$1$1 badgeKt$BadgedBox$1$1RememberedValue;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM6062constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1693825945);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BadgedBox)N(badge,modifier,content)78@3019L2193,68@2698L2514:Badge.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1693825945, i3, -1, "androidx.compose.material3.BadgedBox (Badge.kt:67)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 25889240, "CC(remember):Badge.kt#9igjgp");
                badgeKt$BadgedBox$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (badgeKt$BadgedBox$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    badgeKt$BadgedBox$1$1RememberedValue = BadgeKt$BadgedBox$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(badgeKt$BadgedBox$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) badgeKt$BadgedBox$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 174143753, "C71@2767L162,76@2942L59:Badge.kt#uh7d8r");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "anchor");
                Alignment center = Alignment.INSTANCE.getCenter();
                int i6 = ((i3 << 3) & 7168) | 54;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "badge");
                int i7 = ((i3 << 9) & 7168) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i7 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.BadgedBox$lambda$2(function3, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1693825945, i3, -1, "androidx.compose.material3.BadgedBox (Badge.kt:67)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 25889240, "CC(remember):Badge.kt#9igjgp");
            badgeKt$BadgedBox$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (badgeKt$BadgedBox$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                badgeKt$BadgedBox$1$1RememberedValue = BadgeKt$BadgedBox$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(badgeKt$BadgedBox$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) badgeKt$BadgedBox$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 174143753, "C71@2767L162,76@2942L59:Badge.kt#uh7d8r");
            Modifier modifierLayoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "anchor");
            Alignment center2 = Alignment.INSTANCE.getCenter();
            int i8 = ((i3 << 3) & 7168) | 54;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId3);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "badge");
            int i9 = ((i3 << 9) & 7168) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId4);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl3.getInserting()) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = companion;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BadgeKt.BadgedBox$lambda$2(function3, modifier4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:102:0x023b  */
    /* JADX WARN: Code duplicated, block: B:105:0x025d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0262  */
    /* JADX WARN: Code duplicated, block: B:110:0x0270  */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x0111  */
    /* JADX WARN: Code duplicated, block: B:85:0x0133  */
    /* JADX WARN: Code duplicated, block: B:86:0x013f  */
    /* JADX WARN: Code duplicated, block: B:89:0x018e  */
    /* JADX WARN: Code duplicated, block: B:92:0x019a  */
    /* JADX WARN: Code duplicated, block: B:93:0x019e  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d1  */
    /* JADX INFO: renamed from: Badge-eopBjH0, reason: not valid java name */
    public static final void m2806BadgeeopBjH0(Modifier modifier, long j, long j2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        BadgeTokens badgeTokens;
        float fM5148getSizeD9Ej5fM;
        Shape value;
        Modifier.Companion companionM1220paddingVpY3zN4$default;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final RowScopeInstance rowScopeInstance;
        Composer composerStartRestartGroup = composer.startRestartGroup(1428256508);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Badge)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)165@6561L876:Badge.kt#uh7d8r");
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
            containerColor = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(containerColor)) ? 32 : 16;
        } else {
            containerColor = j;
        }
        if ((i & 384) == 0) {
            jM3051contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                function4 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@6161L14,153@6203L31");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = BadgeDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i5 != 0) {
                        function4 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1428256508, i3, -1, "androidx.compose.material3.Badge (Badge.kt:155)");
                }
                badgeTokens = BadgeTokens.INSTANCE;
                if (function4 != null) {
                    fM5148getSizeD9Ej5fM = badgeTokens.m5147getLargeSizeD9Ej5fM();
                } else {
                    fM5148getSizeD9Ej5fM = badgeTokens.m5148getSizeD9Ej5fM();
                }
                if (function4 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1051024814);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6458L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1050967433);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@6511L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(SizeKt.m1250defaultMinSizeVpY3zN4(companion, fM5148getSizeD9Ej5fM, fM5148getSizeD9Ej5fM), containerColor, value);
                if (function4 != null) {
                    companionM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null);
                } else {
                    companionM1220paddingVpY3zN4$default = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierM588backgroundbw27NRU.then(companionM1220paddingVpY3zN4$default);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1345794914, "C:Badge.kt#uh7d8r");
                if (function4 != null) {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1338769290);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1345815094);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "180@7239L5,184@7393L13,181@7257L164");
                    ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(jM3051contentColorForek8zF_U, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(541712501, true, new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BadgeKt.Badge_eopBjH0$lambda$0$0(function4, rowScopeInstance, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384);
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            j3 = containerColor;
            j4 = jM3051contentColorForek8zF_U;
            function5 = function4;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.Badge_eopBjH0$lambda$1(modifier3, j3, j4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function4 = function3;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "152@6161L14,153@6203L31");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = BadgeDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i5 != 0) {
                    function4 = null;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = BadgeDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i5 != 0) {
                    function4 = null;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1428256508, i3, -1, "androidx.compose.material3.Badge (Badge.kt:155)");
            }
            badgeTokens = BadgeTokens.INSTANCE;
            if (function4 != null) {
                fM5148getSizeD9Ej5fM = badgeTokens.m5147getLargeSizeD9Ej5fM();
            } else {
                fM5148getSizeD9Ej5fM = badgeTokens.m5148getSizeD9Ej5fM();
            }
            if (function4 != null) {
                composerStartRestartGroup.startReplaceGroup(-1051024814);
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@6458L5");
                value = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1050967433);
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@6511L5");
                value = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(SizeKt.m1250defaultMinSizeVpY3zN4(companion, fM5148getSizeD9Ej5fM, fM5148getSizeD9Ej5fM), containerColor, value);
            if (function4 != null) {
                companionM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null);
            } else {
                companionM1220paddingVpY3zN4$default = Modifier.INSTANCE;
            }
            Modifier modifierThen2 = modifierM588backgroundbw27NRU2.then(companionM1220paddingVpY3zN4$default);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1345794914, "C:Badge.kt#uh7d8r");
            if (function4 != null) {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(1338769290);
            } else {
                composerStartRestartGroup.startReplaceGroup(1345815094);
                ComposerKt.sourceInformation(composerStartRestartGroup, "180@7239L5,184@7393L13,181@7257L164");
                ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(jM3051contentColorForek8zF_U, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(541712501, true, new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BadgeKt.Badge_eopBjH0$lambda$0$0(function4, rowScopeInstance, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384);
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        j3 = containerColor;
        j4 = jM3051contentColorForek8zF_U;
        function5 = function4;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BadgeKt.Badge_eopBjH0$lambda$1(modifier3, j3, j4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Badge_eopBjH0$lambda$0$0(Function3 function3, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C184@7395L9:Badge.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(541712501, i, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:184)");
            }
            function3.invoke(rowScope, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }

    public static final HorizontalRuler getBadgeTopRuler() {
        return BadgeTopRuler;
    }

    public static final VerticalRuler getBadgeEndRuler() {
        return BadgeEndRuler;
    }

    public static final Modifier badgeBounds(Modifier modifier) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BadgeKt.badgeBounds$lambda$0((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult badgeBounds$lambda$0(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BadgeKt.badgeBounds$lambda$0$0((RulerScope) obj);
            }
        }, new Function1() { // from class: androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BadgeKt.badgeBounds$lambda$0$1(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit badgeBounds$lambda$0$0(RulerScope rulerScope) {
        rulerScope.provides(BadgeEndRuler, (int) (rulerScope.getCoordinates().mo8273getSizeYbymL2g() >> 32));
        rulerScope.provides(BadgeTopRuler, 0.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit badgeBounds$lambda$0$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
