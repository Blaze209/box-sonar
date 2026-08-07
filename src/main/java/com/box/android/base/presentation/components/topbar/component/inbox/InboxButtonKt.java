package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"InboxButton", "", "viewModel", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountViewModel;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InboxButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxButton$lambda$0(InboxCountViewModel inboxCountViewModel, Function0 function0, int i, Composer composer, int i2) {
        InboxButton(inboxCountViewModel, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxButton$lambda$4(Store store, Function0 function0, int i, Composer composer, int i2) {
        InboxButton((Store<InboxCountReducer.State, InboxCountReducer.Action>) store, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxButtonPreview$lambda$0(int i, Composer composer, int i2) {
        InboxButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void InboxButton(final InboxCountViewModel viewModel, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1152022772);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxButton)N(viewModel,onClick)35@1507L37:InboxButton.kt#beimh5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1152022772, i2, -1, "com.box.android.base.presentation.components.topbar.component.inbox.InboxButton (InboxButton.kt:34)");
            }
            InboxButton(viewModel.getStore(), onClick, composerStartRestartGroup, i2 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxButtonKt.InboxButton$lambda$0(viewModel, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void InboxButton(final Store<InboxCountReducer.State, InboxCountReducer.Action> store, Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1120682426);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxButton)N(store,onClick)40@1693L29,43@1798L63,43@1776L85,53@2049L1383,47@1867L1565:InboxButton.kt#beimh5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120682426, i2, -1, "com.box.android.base.presentation.components.topbar.component.inbox.InboxButton (InboxButton.kt:39)");
            }
            Integer inboxBadgeCount = InboxButton$lambda$1(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getInboxBadgeCount();
            final int iIntValue = inboxBadgeCount != null ? inboxBadgeCount.intValue() : 0;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1060987589, "CC(remember):InboxButton.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            InboxButtonKt$InboxButton$2$1 inboxButtonKt$InboxButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || inboxButtonKt$InboxButton$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                inboxButtonKt$InboxButton$2$1RememberedValue = new InboxButtonKt$InboxButton$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(inboxButtonKt$InboxButton$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(store, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxButtonKt$InboxButton$2$1RememberedValue, composerStartRestartGroup, i3);
            function0 = onClick;
            IconButtonKt.IconButton(function0, SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Inbox")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1139849112, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxButtonKt.InboxButton$lambda$3(iIntValue, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 1572912, 60);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxButtonKt.InboxButton$lambda$4(store, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxButton$lambda$3(int i, Composer composer, int i2) {
        final String strValueOf;
        ComposerKt.sourceInformation(composer, "C61@2254L954,60@2223L1203:InboxButton.kt#beimh5");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1139849112, i2, -1, "com.box.android.base.presentation.components.topbar.component.inbox.InboxButton.<anonymous> (InboxButton.kt:54)");
            }
            if (i < 1) {
                strValueOf = null;
            } else if (i <= 9) {
                strValueOf = String.valueOf(i);
            } else {
                strValueOf = "9+";
            }
            BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(1722263264, true, new Function3() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxButtonKt.InboxButton$lambda$3$0(strValueOf, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), null, ComposableSingletons$InboxButtonKt.INSTANCE.getLambda$1845544930$base_generalProdRelease(), composer, 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxButton$lambda$3$0(String str, BoxScope BadgedBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C:InboxButton.kt#beimh5");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1722263264, i, -1, "com.box.android.base.presentation.components.topbar.component.inbox.InboxButton.<anonymous>.<anonymous> (InboxButton.kt:62)");
            }
            if (str == null) {
                composer.startReplaceGroup(265636818);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(265636819);
                ComposerKt.sourceInformation(composer, "*66@2474L6,69@2642L6,63@2317L859");
                float f = 2;
                Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(OffsetKt.m1174offsetVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(-6)), BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m9687constructorimpl(f)), Dp.m9687constructorimpl(14)), BoxTheme.INSTANCE.getColors(composer, 6).m11540getNotificationContainer0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM588backgroundbw27NRU);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1608287177, "C74@2886L6,72@2794L360:InboxButton.kt#beimh5");
                TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, "TopBar:InboxBadge"), BoxTheme.INSTANCE.getColors(composer, 6).m11541getNotificationText0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.getSp(9), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(9), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null), composer, 48, 12582912, 130040);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
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

    public static final void InboxButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1492771083);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxButtonPreview)97@3550L315:InboxButton.kt#beimh5");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1492771083, i, -1, "com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonPreview (InboxButton.kt:96)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxButtonKt.INSTANCE.m11839getLambda$448211680$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxButtonKt.InboxButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InboxCountReducer.State InboxButton$lambda$1(State<InboxCountReducer.State> state) {
        return state.getValue();
    }
}
