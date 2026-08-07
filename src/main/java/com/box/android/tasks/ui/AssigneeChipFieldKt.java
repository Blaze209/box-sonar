package com.box.android.tasks.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InputChipDefaults;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.PopupProperties;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt;
import com.box.android.base.models.UserMiniUIModel;
import com.box.android.tasks.R;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AssigneeChipField.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\u0016\u001aA\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u008e\u0002"}, d2 = {"AssigneeChipField", "", "selected", "", "Lcom/box/android/base/models/UserMiniUIModel;", "query", "", "onQueryChange", "Lkotlin/Function1;", "suggestions", "onSelect", "onRemove", "isLoading", "", "invalidUser", "onFocusLost", "Lkotlin/Function0;", "enabled", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "AssigneeSuggestionDropdownContent", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FlowChips", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "assigneeChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "AssigneeSuggestionContent", "assignee", "(Lcom/box/android/base/models/UserMiniUIModel;Landroidx/compose/runtime/Composer;I)V", "AssigneeChipFieldPreview", "(Landroidx/compose/runtime/Composer;I)V", "tasks_generalProdRelease", "isFocused", "dropDownShown", "anchorWidth", "Landroidx/compose/ui/unit/Dp;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AssigneeChipFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$15(List list, String str, Function1 function1, List list2, Function1 function2, Function1 function3, boolean z, boolean z2, Function0 function0, boolean z3, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        AssigneeChipField(list, str, function1, list2, function2, function3, z, z2, function0, z3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipFieldPreview$lambda$0(int i, Composer composer, int i2) {
        AssigneeChipFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeSuggestionContent$lambda$1(UserMiniUIModel userMiniUIModel, int i, Composer composer, int i2) {
        AssigneeSuggestionContent(userMiniUIModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeSuggestionDropdownContent$lambda$2(List list, boolean z, Function1 function1, int i, Composer composer, int i2) {
        AssigneeSuggestionDropdownContent(list, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowChips$lambda$1(List list, Function1 function1, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FlowChips(list, function1, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v44, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v46 */
    public static final void AssigneeChipField(final List<UserMiniUIModel> selected, final String query, final Function1<? super String, Unit> onQueryChange, final List<UserMiniUIModel> suggestions, final Function1<? super UserMiniUIModel, Unit> onSelect, final Function1<? super UserMiniUIModel, Unit> onRemove, final boolean z, boolean z2, Function0<Unit> function0, boolean z3, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        int i5;
        Composer composer2;
        final Function0<Unit> function1;
        final boolean z5;
        final boolean z6;
        final Modifier modifier2;
        final Function0<Unit> function2;
        Object obj;
        float f;
        ?? r9;
        Object obj2;
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Intrinsics.checkNotNullParameter(suggestions, "suggestions");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(onRemove, "onRemove");
        Composer composerStartRestartGroup = composer.startRestartGroup(622330964);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssigneeChipField)N(selected,query,onQueryChange,suggestions,onSelect,onRemove,isLoading,invalidUser,onFocusLost,enabled,modifier)75@3658L2,79@3750L34,82@4005L33,87@4290L24,87@4262L52,89@4344L39,91@4511L157,91@4477L191,97@4701L7,98@4732L33,103@4859L61,100@4771L2494:AssigneeChipField.kt#w4i53x");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(selected) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(query) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onQueryChange) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(suggestions) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onSelect) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onRemove) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        int i6 = i3 & 128;
        if (i6 != 0) {
            i4 |= 12582912;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
            }
        }
        int i7 = i3 & 256;
        if (i7 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 67108864 : 33554432;
        }
        int i8 = i3 & 512;
        if (i8 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i9 = i3 & 1024;
        if (i9 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 3) == 2) ? false : true, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function1 = function0;
            z5 = z3;
            z6 = z4;
            modifier2 = modifier;
        } else {
            if (i6 != 0) {
                z4 = false;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059612694, "CC(remember):AssigneeChipField.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function2 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function2 = function0;
            }
            boolean z7 = i8 != 0 ? true : z3;
            Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(622330964, i4, i5, "com.box.android.tasks.ui.AssigneeChipField (AssigneeChipField.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059615670, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z8 = (AssigneeChipField$lambda$2(mutableState) || !StringsKt.isBlank(query)) && (z || !suggestions.isEmpty());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059623829, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue3 = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z9 = z7 && z8 && AssigneeChipField$lambda$5(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059632940, "CC(remember):AssigneeChipField.kt#9igjgp");
            AssigneeChipFieldKt$AssigneeChipField$2$1 assigneeChipFieldKt$AssigneeChipField$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (assigneeChipFieldKt$AssigneeChipField$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                assigneeChipFieldKt$AssigneeChipField$2$1RememberedValue = new AssigneeChipFieldKt$AssigneeChipField$2$1(mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(assigneeChipFieldKt$AssigneeChipField$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(suggestions, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) assigneeChipFieldKt$AssigneeChipField$2$1RememberedValue, composerStartRestartGroup, (i4 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059634683, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059640145, "CC(remember):AssigneeChipField.kt#9igjgp");
            AssigneeChipFieldKt$AssigneeChipField$3$1 assigneeChipFieldKt$AssigneeChipField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (assigneeChipFieldKt$AssigneeChipField$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                assigneeChipFieldKt$AssigneeChipField$3$1RememberedValue = new AssigneeChipFieldKt$AssigneeChipField$3$1(mutableInteractionSource, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(assigneeChipFieldKt$AssigneeChipField$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) assigneeChipFieldKt$AssigneeChipField$3$1RememberedValue, composerStartRestartGroup, 6);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059647093, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                obj = null;
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                obj = null;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1059651185, "CC(remember):AssigneeChipField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(density);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return AssigneeChipFieldKt.AssigneeChipField$lambda$13$0(density, mutableState3, (IntSize) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxWidth$default, (Function1) objRememberedValue6), "AddTask:AssigneeChipField");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            boolean z10 = z4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -376301623, "C106@4987L1663,153@6864L6,151@6738L25,158@7069L190,149@6660L599:AssigneeChipField.kt#w4i53x");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1593135049, "C109@5127L108,121@5708L211,107@5044L889:AssigneeChipField.kt#w4i53x");
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "AddTask:AssigneeField");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1334083036, "CC(remember):AssigneeChipField.kt#9igjgp");
            boolean z11 = (i4 & 896) == 256;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return AssigneeChipFieldKt.AssigneeChipField$lambda$14$0$0$0(onQueryChange, mutableState2, (String) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function3 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function2<Composer, Integer, Unit> function2M13064getLambda$232995039$tasks_generalProdRelease = ComposableSingletons$AssigneeChipFieldKt.INSTANCE.m13064getLambda$232995039$tasks_generalProdRelease();
            Function2<Composer, Integer, Unit> function2M13063getLambda$1948593630$tasks_generalProdRelease = ComposableSingletons$AssigneeChipFieldKt.INSTANCE.m13063getLambda$1948593630$tasks_generalProdRelease();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1334101731, "CC(remember):AssigneeChipField.kt#9igjgp");
            boolean z12 = (234881024 & i4) == 67108864;
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return AssigneeChipFieldKt.AssigneeChipField$lambda$14$0$1$0(function2, mutableState, mutableState2, (FocusState) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0<Unit> function4 = function2;
            Modifier modifier3 = companion;
            int i10 = i4;
            boolean z13 = z7;
            BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU(query, function3, modifierTestTag2, z13, function2M13064getLambda$232995039$tasks_generalProdRelease, function2M13063getLambda$1948593630$tasks_generalProdRelease, 0, 0, z10, 0L, mutableInteractionSource, (Function1) objRememberedValue8, composerStartRestartGroup, ((i4 >> 3) & 14) | 221568 | ((i4 >> 18) & 7168) | ((i4 << 3) & 234881024), 6, TypedValues.TransitionType.TYPE_AUTO_TRANSITION);
            z6 = z10;
            composer2 = composerStartRestartGroup;
            if (z6) {
                composer2.startReplaceGroup(-1592244823);
                ComposerKt.sourceInformation(composer2, "130@6015L50,132@6165L6,129@5982L297");
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_invalid_assignee, composer2, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(8), Dp.m9687constructorimpl(4), 0.0f, 0.0f, 12, null), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11563getTextFieldError0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 48, 0, 131064);
            } else {
                composer2.startReplaceGroup(-1598189166);
            }
            composer2.endReplaceGroup();
            if (selected.isEmpty()) {
                f = 0.0f;
                r9 = 1;
                obj2 = null;
                composer2.startReplaceGroup(-1598189166);
            } else {
                composer2.startReplaceGroup(-1591895360);
                ComposerKt.sourceInformation(composer2, "138@6352L274");
                f = 0.0f;
                r9 = 1;
                obj2 = null;
                FlowChips(selected, onRemove, z13, PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m9687constructorimpl(4), 0.0f, 0.0f, 13, null), composer2, (i10 & 14) | 3072 | ((i10 >> 12) & 112) | ((i10 >> 21) & 896), 0);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            PopupProperties popupProperties = new PopupProperties(false, false, false, false, 14, (DefaultConstructorMarker) null);
            long jM11542getPopupBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11542getPopupBackground0d7_KjU();
            Modifier modifierTestTag3 = TestTagKt.testTag(SizeKt.m1254heightInVpY3zN4$default(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, AssigneeChipField$lambda$11(mutableState3)), f, Dp.m9687constructorimpl(PsExtractor.VIDEO_STREAM_MASK), r9, obj2), "AddTask:AssigneeSuggestionDropdown");
            ComposerKt.sourceInformationMarkerStart(composer2, 126462355, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssigneeChipFieldKt.AssigneeChipField$lambda$14$1$0(mutableState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(z9, (Function0) objRememberedValue9, modifierTestTag3, 0L, null, popupProperties, null, jM11542getPopupBackground0d7_KjU, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(400349951, r9, new Function3() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return AssigneeChipFieldKt.AssigneeChipField$lambda$14$2(suggestions, z, onSelect, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer2, 54), composer2, 196656, 48, 1880);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z13;
            modifier2 = modifier3;
            function1 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return AssigneeChipFieldKt.AssigneeChipField$lambda$15(selected, query, onQueryChange, suggestions, onSelect, onRemove, z, z6, function1, z5, modifier2, i, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final boolean AssigneeChipField$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AssigneeChipField$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AssigneeChipField$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AssigneeChipField$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float AssigneeChipField$lambda$11(MutableState<Dp> mutableState) {
        return mutableState.getValue().m9701unboximpl();
    }

    private static final void AssigneeChipField$lambda$12(MutableState<Dp> mutableState, float f) {
        mutableState.setValue(Dp.m9685boximpl(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$13$0(Density density, MutableState mutableState, IntSize intSize) {
        AssigneeChipField$lambda$12(mutableState, density.mo751toDpu2uoSUM((int) (intSize.m9862unboximpl() >> 32)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$14$0$0$0(Function1 function1, MutableState mutableState, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        AssigneeChipField$lambda$6(mutableState, true);
        function1.invoke(text);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$14$0$1$0(Function0 function0, MutableState mutableState, MutableState mutableState2, FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        AssigneeChipField$lambda$3(mutableState, focusState.getHasFocus());
        if (focusState.getHasFocus()) {
            AssigneeChipField$lambda$6(mutableState2, true);
        }
        if (!focusState.getHasFocus()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$14$1$0(MutableState mutableState) {
        AssigneeChipField$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeChipField$lambda$14$2(List list, boolean z, Function1 function1, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C159@7083L166:AssigneeChipField.kt#w4i53x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(400349951, i, -1, "com.box.android.tasks.ui.AssigneeChipField.<anonymous>.<anonymous> (AssigneeChipField.kt:159)");
            }
            AssigneeSuggestionDropdownContent(list, z, function1, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void AssigneeSuggestionDropdownContent(final List<UserMiniUIModel> suggestions, final boolean z, final Function1<? super UserMiniUIModel, Unit> onSelect, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(suggestions, "suggestions");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(537235624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssigneeSuggestionDropdownContent)N(suggestions,isLoading,onSelect):AssigneeChipField.kt#w4i53x");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(suggestions) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i3 = 256;
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSelect) ? 256 : 128;
        }
        boolean z2 = true;
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537235624, i2, -1, "com.box.android.tasks.ui.AssigneeSuggestionDropdownContent (AssigneeChipField.kt:174)");
            }
            String str = "CC(remember):AssigneeChipField.kt#9igjgp";
            if (suggestions.isEmpty() && z) {
                composerStartRestartGroup.startReplaceGroup(1738530942);
                ComposerKt.sourceInformation(composerStartRestartGroup, "178@7630L2,176@7561L364");
                Function2<Composer, Integer, Unit> lambda$1984108701$tasks_generalProdRelease = ComposableSingletons$AssigneeChipFieldKt.INSTANCE.getLambda$1984108701$tasks_generalProdRelease();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 887367786, "CC(remember):AssigneeChipField.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidMenu_androidKt.DropdownMenuItem(lambda$1984108701$tasks_generalProdRelease, (Function0) objRememberedValue, null, null, null, false, null, null, null, composerStartRestartGroup, 196662, 476);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1738911560);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*192@8174L39,190@8037L22,189@7993L234");
                for (final UserMiniUIModel userMiniUIModel : suggestions) {
                    Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "AddTask:AssigneeSuggestion:" + userMiniUIModel.getId());
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-705566312, z2, new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AssigneeChipFieldKt.AssigneeSuggestionDropdownContent$lambda$1$0(userMiniUIModel, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2020438590, str);
                    boolean zChangedInstance = ((i2 & 896) == i3 ? z2 : false) | composerStartRestartGroup.changedInstance(userMiniUIModel);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AssigneeChipFieldKt.AssigneeSuggestionDropdownContent$lambda$1$1$0(onSelect, userMiniUIModel);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue2, modifierTestTag, null, null, false, null, null, null, composerStartRestartGroup, 6, 504);
                    i3 = i3;
                    i2 = i2;
                    z2 = z2;
                    str = str;
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AssigneeChipFieldKt.AssigneeSuggestionDropdownContent$lambda$2(suggestions, z, onSelect, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeSuggestionDropdownContent$lambda$1$1$0(Function1 function1, UserMiniUIModel userMiniUIModel) {
        function1.invoke(userMiniUIModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssigneeSuggestionDropdownContent$lambda$1$0(UserMiniUIModel userMiniUIModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@8176L35:AssigneeChipField.kt#w4i53x");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-705566312, i, -1, "com.box.android.tasks.ui.AssigneeSuggestionDropdownContent.<anonymous>.<anonymous> (AssigneeChipField.kt:192)");
            }
            AssigneeSuggestionContent(userMiniUIModel, composer, UserMiniUIModel.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    private static final void FlowChips(final List<UserMiniUIModel> list, final Function1<? super UserMiniUIModel, Unit> function1, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(-931453409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowChips)N(selected,onRemove,enabled,modifier)210@8655L1003,206@8494L1164:AssigneeChipField.kt#w4i53x");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-931453409, i3, -1, "com.box.android.tasks.ui.FlowChips (AssigneeChipField.kt:205)");
                }
                float f = 4;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
                Modifier modifier4 = companion;
                FlowLayoutKt.FlowRow(modifier4, horizontalOrVerticalM1073spacedBy0680j_4, Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f)), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(2032401924, true, new Function3() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AssigneeChipFieldKt.FlowChips$lambda$0(list, z, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | 1573296, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AssigneeChipFieldKt.FlowChips$lambda$1(list, function1, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-931453409, i3, -1, "com.box.android.tasks.ui.FlowChips (AssigneeChipField.kt:205)");
            }
            float f2 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f2));
            Modifier modifier5 = companion;
            FlowLayoutKt.FlowRow(modifier5, horizontalOrVerticalM1073spacedBy0680j_5, Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f2)), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(2032401924, true, new Function3() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AssigneeChipFieldKt.FlowChips$lambda$0(list, z, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | 1573296, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AssigneeChipFieldKt.FlowChips$lambda$1(list, function1, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowChips$lambda$0(List list, final boolean z, final Function1 function1, FlowRowScope FlowRow, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*232@9532L20,214@8778L3,216@8842L208,223@9083L422,212@8708L934:AssigneeChipField.kt#w4i53x");
        int i2 = 0;
        boolean z2 = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032401924, i, -1, "com.box.android.tasks.ui.FlowChips.<anonymous> (AssigneeChipField.kt:211)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final UserMiniUIModel userMiniUIModel = (UserMiniUIModel) it.next();
                SelectableChipColors selectableChipColorsAssigneeChipColors = assigneeChipColors(composer2, i2);
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "AddTask:Chip:" + userMiniUIModel.getId());
                ComposerKt.sourceInformationMarkerStart(composer2, 589392803, "CC(remember):AssigneeChipField.kt#9igjgp");
                Object objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.InputChip(true, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-438681751, z2, new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AssigneeChipFieldKt.FlowChips$lambda$0$0$1(userMiniUIModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), modifierTestTag, z, null, null, ComposableLambdaKt.rememberComposableLambda(-134288444, z2, new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AssigneeChipFieldKt.FlowChips$lambda$0$0$2(z, function1, userMiniUIModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, selectableChipColorsAssigneeChipColors, null, null, null, composer2, 12583350, 0, 7520);
                composer2 = composer;
                i2 = i2;
                z2 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowChips$lambda$0$0$1(UserMiniUIModel userMiniUIModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C217@8864L168:AssigneeChipField.kt#w4i53x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-438681751, i, -1, "com.box.android.tasks.ui.FlowChips.<anonymous>.<anonymous>.<anonymous> (AssigneeChipField.kt:217)");
            }
            TextKt.m4494TextNvy7gAk(userMiniUIModel.getName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer, 0, 24960, 241662);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowChips$lambda$0$0$2(boolean z, final Function1 function1, final UserMiniUIModel userMiniUIModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C226@9216L49,228@9369L22,224@9105L382:AssigneeChipField.kt#w4i53x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-134288444, i, -1, "com.box.android.tasks.ui.FlowChips.<anonymous>.<anonymous>.<anonymous> (AssigneeChipField.kt:224)");
            }
            ImageVector close = CloseKt.getClose(Icons.Outlined.INSTANCE);
            String strStringResource = StringResources_androidKt.stringResource(R.string.add_task_remove_assignee, composer, 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -202166630, "CC(remember):AssigneeChipField.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changedInstance(userMiniUIModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AssigneeChipFieldKt.FlowChips$lambda$0$0$2$0$0(function1, userMiniUIModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.m3576Iconww6aTOc(close, strStringResource, TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(companion, z, null, null, null, (Function0) objRememberedValue, 14, null), "AddTask:RemoveChip:" + userMiniUIModel.getId()), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowChips$lambda$0$0$2$0$0(Function1 function1, UserMiniUIModel userMiniUIModel) {
        function1.invoke(userMiniUIModel);
        return Unit.INSTANCE;
    }

    private static final SelectableChipColors assigneeChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -881728159, "C(assigneeChipColors)241@9782L6,242@9852L6,243@9919L6,244@9991L6,245@10081L6,246@10173L6,240@9727L497:AssigneeChipField.kt#w4i53x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-881728159, i, -1, "com.box.android.tasks.ui.assigneeChipColors (AssigneeChipField.kt:240)");
        }
        InputChipDefaults inputChipDefaults = InputChipDefaults.INSTANCE;
        long jM11534getMainActiveControlBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11534getMainActiveControlBackground0d7_KjU();
        long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
        long jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
        SelectableChipColors selectableChipColorsM3600inputChipColorskwJvTHA = inputChipDefaults.m3600inputChipColorskwJvTHA(0L, 0L, 0L, 0L, 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), jM11534getMainActiveControlBackground0d7_KjU, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11561getTextFieldContainer0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), jM11533getMainActiveControl0d7_KjU, 0L, jM11533getMainActiveControl0d7_KjU2, composer, 0, InputChipDefaults.$stable << 9, 2143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM3600inputChipColorskwJvTHA;
    }

    public static final void AssigneeSuggestionContent(final UserMiniUIModel assignee, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(assignee, "assignee");
        Composer composerStartRestartGroup = composer.startRestartGroup(-214700349);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssigneeSuggestionContent)N(assignee)251@10310L554:AssigneeChipField.kt#w4i53x");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(assignee) : composerStartRestartGroup.changedInstance(assignee) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-214700349, i2, -1, "com.box.android.tasks.ui.AssigneeSuggestionContent (AssigneeChipField.kt:250)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1732574153, "C255@10449L6,252@10327L221:AssigneeChipField.kt#w4i53x");
            TextKt.m4494TextNvy7gAk(assignee.getName(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composerStartRestartGroup, 0, 24960, 110586);
            String login = assignee.getLogin();
            if (login == null) {
                composerStartRestartGroup.startReplaceGroup(-1732337749);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1732337748);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*263@10726L6,260@10600L248");
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(login, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 0, 24960, 110586);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AssigneeChipFieldKt.AssigneeSuggestionContent$lambda$1(assignee, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void AssigneeChipFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1404497105);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssigneeChipFieldPreview)276@11026L1355:AssigneeChipField.kt#w4i53x");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404497105, i, -1, "com.box.android.tasks.ui.AssigneeChipFieldPreview (AssigneeChipField.kt:275)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$AssigneeChipFieldKt.INSTANCE.getLambda$2106287964$tasks_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.ui.AssigneeChipFieldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AssigneeChipFieldKt.AssigneeChipFieldPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
