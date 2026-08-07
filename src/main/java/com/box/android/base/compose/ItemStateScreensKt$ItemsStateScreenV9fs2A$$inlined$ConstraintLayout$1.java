package com.box.android.base.compose;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.box.android.base.compose.button.BoxOutlinedButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: renamed from: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$1, reason: invalid class name */
/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$contentDelegate$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
public final class ItemStateScreensKt$ItemsStateScreenV9fs2A$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ ItemsStateConfig $itemsStateConfig$inlined;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ boolean $shouldCenterContent$inlined;
    final /* synthetic */ MutableState $start;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemStateScreensKt$ItemsStateScreenV9fs2A$$inlined$ConstraintLayout$1(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, ItemsStateConfig itemsStateConfig, boolean z) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$itemsStateConfig$inlined = itemsStateConfig;
        this.$shouldCenterContent$inlined = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        float f;
        ComposerKt.sourceInformation(composer, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
            }
            this.$contentTracker.setValue(Unit.INSTANCE);
            if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
                this.$compositionSource.setValue(CompositionSource.Content);
            }
            this.$scope.reset();
            ConstraintLayoutScope constraintLayoutScope = this.$scope;
            composer.startReplaceGroup(1475404531);
            ComposerKt.sourceInformation(composer, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope.createRefs();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
            Painter painterPainterResource = PainterResources_androidKt.painterResource(this.$itemsStateConfig$inlined.getDrawableId(), composer, 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
            boolean zChanged = composer.changed(this.$shouldCenterContent$inlined) | composer.changed(constrainedLayoutReferenceComponent1);
            ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer.rememberedValue();
            if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(this.$shouldCenterContent$inlined, constrainedLayoutReferenceComponent1);
                composer.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(this.$itemsStateConfig$inlined.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
            Composer composer2 = composer;
            float f2 = 24;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
            boolean zChanged2 = composer2.changed(this.$shouldCenterContent$inlined) | composer2.changed(constrainedLayoutReferenceComponent2);
            ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer2.rememberedValue();
            if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(this.$shouldCenterContent$inlined, constrainedLayoutReferenceComponent2);
                composer2.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierConstrainAs = constraintLayoutScope.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierConstrainAs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1633959809, "C:ItemStateScreens.kt#vejmn0");
            if (this.$itemsStateConfig$inlined.getMainText() == null) {
                composer2.startReplaceGroup(-1633973172);
                composer2.endReplaceGroup();
                f = f2;
            } else {
                composer2.startReplaceGroup(-1633973171);
                ComposerKt.sourceInformation(composer2, "*162@6240L6,157@5957L318");
                f = f2;
                TextKt.m4494TextNvy7gAk(this.$itemsStateConfig$inlined.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer2, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer, 48, 12582912, 130040);
                composer2 = composer;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            String subText = this.$itemsStateConfig$inlined.getSubText();
            if (subText == null) {
                composer2.startReplaceGroup(-1633581363);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1633581362);
                ComposerKt.sourceInformation(composer2, "*167@6351L30,173@6661L6,168@6398L302");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer2, 6);
                TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer2, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 48, 12582912, 130040);
                composer2 = composer;
                Unit unit3 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ButtonItem.TextButtonItem actionItem = this.$itemsStateConfig$inlined.getActionItem();
            if (actionItem == null) {
                composer2.startReplaceGroup(-1633143922);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1633143921);
                ComposerKt.sourceInformation(composer2, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer2, 6);
                composer2 = composer;
                BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer2, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer2, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer2, 221184, 2);
                Unit unit5 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer2, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer2.changedInstance(this.$scope) | composer2.changedInstance(this.$channel);
            final ConstraintLayoutScope constraintLayoutScope2 = this.$scope;
            final MutableState mutableState = this.$start;
            final MutableState mutableState2 = this.$end;
            final Channel channel = this.$channel;
            Object objRememberedValue = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.getContainerObject().mo10168clone());
                        if (mutableState.getValue() == null || mutableState2.getValue() == null) {
                            mutableState.setValue(rawConstraintSet);
                            mutableState2.setValue(mutableState.getValue());
                        } else {
                            channel.mo11206trySendJP2dKIU(rawConstraintSet);
                        }
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.SideEffect((Function0) objRememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
