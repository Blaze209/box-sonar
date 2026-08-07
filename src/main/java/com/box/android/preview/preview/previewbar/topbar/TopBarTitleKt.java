package com.box.android.preview.preview.previewbar.topbar;

import android.view.View;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.fileactivity.R;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TopBarTitle.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0015\u001a9\u0010\u0016\u001a\u00020\u00012\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u001c\u001aO\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\t\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010 \"\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#\"\u0010\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#\"\u0010\u0010%\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006&²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002"}, d2 = {"PreviewTopBarTitle", "", BoxCommonConstants.EXTRA_FILE_NAME, "", "subtitle", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "isRenaming", "", "focusOnRename", "showRenamePendingIndicator", "renameTransition", "Landroidx/compose/animation/core/Transition;", "errorMessage", "onFileNameChange", "Lkotlin/Function1;", "onFinishEditing", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;ZZZLandroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PreviewTopBarSubtitle", "(Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PreviewTopBarSubtitleElement", "drawableRes", "", "text", "contentDescription", "iconModifier", "(ILjava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "EditableFileName", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "TitleExpandedOffsetY", "Landroidx/compose/ui/unit/Dp;", "F", "ExpandedTitlePadding", "CollapsedTitlePadding", "preview_generalProdRelease", "titleTranslation", "Landroidx/compose/ui/geometry/Offset;", "paddingAnimation", "textStyleFraction", "", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TopBarTitleKt {
    private static final float TitleExpandedOffsetY = Dp.m9687constructorimpl(44);
    private static final float ExpandedTitlePadding = Dp.m9687constructorimpl(16);
    private static final float CollapsedTitlePadding = Dp.m9687constructorimpl(48);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableFileName$lambda$5(String str, TextStyle textStyle, Modifier modifier, Function1 function1, Function0 function0, boolean z, int i, Composer composer, int i2) {
        EditableFileName(str, textStyle, modifier, function1, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarSubtitle$lambda$1(TopBarReducer.SubtitleState subtitleState, Modifier modifier, int i, Composer composer, int i2) {
        PreviewTopBarSubtitle(subtitleState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarSubtitleElement$lambda$1(int i, String str, String str2, Modifier modifier, Modifier modifier2, int i2, Composer composer, int i3) {
        PreviewTopBarSubtitleElement(i, str, str2, modifier, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarTitle$lambda$7(String str, TopBarReducer.SubtitleState subtitleState, boolean z, boolean z2, boolean z3, Transition transition, String str2, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewTopBarTitle(str, subtitleState, z, z2, z3, transition, str2, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0253  */
    /* JADX WARN: Code duplicated, block: B:144:0x027f  */
    /* JADX WARN: Code duplicated, block: B:145:0x028b  */
    /* JADX WARN: Code duplicated, block: B:147:0x0292  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:151:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:164:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:167:0x0346  */
    /* JADX WARN: Code duplicated, block: B:179:0x0372  */
    /* JADX WARN: Code duplicated, block: B:181:0x037a  */
    /* JADX WARN: Code duplicated, block: B:182:0x0381  */
    /* JADX WARN: Code duplicated, block: B:190:0x039d  */
    /* JADX WARN: Code duplicated, block: B:193:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:195:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:196:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:199:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:212:0x0401  */
    /* JADX WARN: Code duplicated, block: B:215:0x042a  */
    /* JADX WARN: Code duplicated, block: B:216:0x0434  */
    /* JADX WARN: Code duplicated, block: B:218:0x0438  */
    /* JADX WARN: Code duplicated, block: B:219:0x043b  */
    /* JADX WARN: Code duplicated, block: B:222:0x0443  */
    /* JADX WARN: Code duplicated, block: B:235:0x0471  */
    /* JADX WARN: Code duplicated, block: B:238:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:250:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:252:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:253:0x0501  */
    /* JADX WARN: Code duplicated, block: B:261:0x051d  */
    /* JADX WARN: Code duplicated, block: B:264:0x053f  */
    /* JADX WARN: Code duplicated, block: B:266:0x0548  */
    /* JADX WARN: Code duplicated, block: B:267:0x054b  */
    /* JADX WARN: Code duplicated, block: B:270:0x0553  */
    /* JADX WARN: Code duplicated, block: B:283:0x0581  */
    /* JADX WARN: Code duplicated, block: B:286:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:288:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:289:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:292:0x05be  */
    /* JADX WARN: Code duplicated, block: B:305:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:308:0x0705  */
    /* JADX WARN: Code duplicated, block: B:311:0x0711  */
    /* JADX WARN: Code duplicated, block: B:312:0x0715  */
    /* JADX WARN: Code duplicated, block: B:315:0x0763  */
    /* JADX WARN: Code duplicated, block: B:317:0x0782  */
    /* JADX WARN: Code duplicated, block: B:320:0x07be  */
    /* JADX WARN: Code duplicated, block: B:321:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:324:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:325:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:332:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:334:0x0848  */
    /* JADX WARN: Code duplicated, block: B:337:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:338:0x08de  */
    /* JADX WARN: Code duplicated, block: B:341:0x095a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void PreviewTopBarTitle(final String fileName, final TopBarReducer.SubtitleState subtitle, final boolean z, final boolean z2, final boolean z3, final Transition<Boolean> renameTransition, final String str, final Function1<? super String, Unit> onFileNameChange, final Function0<Unit> onFinishEditing, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        Object currentState;
        float f;
        long jFloatToRawIntBits;
        int iFloatToRawIntBits;
        int i4;
        boolean z4;
        Object objRememberedValue;
        boolean zBooleanValue;
        long jFloatToRawIntBits2;
        int iFloatToRawIntBits2;
        boolean z5;
        Object objRememberedValue2;
        Object currentState2;
        boolean zBooleanValue2;
        float f2;
        boolean z6;
        Object objRememberedValue3;
        boolean zBooleanValue3;
        float f3;
        boolean z7;
        Object objRememberedValue4;
        State stateCreateTransitionAnimation;
        Object currentState3;
        boolean zBooleanValue4;
        float f4;
        boolean z8;
        Object objRememberedValue5;
        boolean zBooleanValue5;
        float f5;
        boolean z9;
        Object objRememberedValue6;
        TextStyle textStyleLerp;
        float f6;
        Function0<ComposeUiNode> constructor;
        int i5;
        Object objRememberedValue7;
        FocusRequester focusRequester;
        View view;
        boolean z10;
        boolean z11;
        boolean zChangedInstance;
        TopBarTitleKt$PreviewTopBarTitle$1$1$1 topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue;
        int i6;
        boolean z12;
        Snapshot.Companion companion;
        Snapshot currentThreadSnapshot;
        Function1<Object, Unit> readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        boolean z13;
        Snapshot.Companion companion2;
        Snapshot currentThreadSnapshot2;
        Function1<Object, Unit> readObserver2;
        Snapshot snapshotMakeCurrentNonObservable2;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(renameTransition, "renameTransition");
        Intrinsics.checkNotNullParameter(onFileNameChange, "onFileNameChange");
        Intrinsics.checkNotNullParameter(onFinishEditing, "onFinishEditing");
        Composer composerStartRestartGroup = composer.startRestartGroup(-885062066);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewTopBarTitle)N(fileName,subtitle,isRenaming,focusOnRename,showRenamePendingIndicator,renameTransition,errorMessage,onFileNameChange,onFinishEditing,modifier)70@3097L154,73@3297L122,76@3466L113,80@3668L6,81@3759L6,85@3825L1912:TopBarTitle.kt#l0df2e");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(fileName) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(subtitle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(renameTransition) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFileNameChange) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFinishEditing) ? 67108864 : 33554432;
        }
        int i7 = i2 & 512;
        if (i7 != 0) {
            i3 |= 805306368;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 805306368) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            Modifier.Companion companion3 = i7 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-885062066, i3, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle (TopBarTitle.kt:69)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -787164050, "CC(animateOffset)N(transitionSpec,label,targetValueByState)2011@87059L79:Transition.kt#pdpnli");
            TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$1 topBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$1 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Offset>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Offset> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final SpringSpec<Offset> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i8) {
                    composer2.startReplaceGroup(-1662821959);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1662821959, i8, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:2007)");
                    }
                    SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m6558boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
            TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.INSTANCE);
            int i8 = ((((i3 >> 15) & 14) | 384) & 14) | 3072;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (renameTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState = renameTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean z14 = (((i8 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                currentState = composerStartRestartGroup.rememberedValue();
                if (z14 || currentState == Composer.INSTANCE.getEmpty()) {
                    Snapshot.Companion companion4 = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot3 = companion4.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver3 = currentThreadSnapshot3 != null ? currentThreadSnapshot3.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable3 = companion4.makeCurrentNonObservable(currentThreadSnapshot3);
                    try {
                        Boolean currentState4 = renameTransition.getCurrentState();
                        companion4.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                        composerStartRestartGroup.updateRememberedValue(currentState4);
                        currentState = currentState4;
                    } catch (Throwable th) {
                        companion4.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                        throw th;
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean zBooleanValue6 = ((Boolean) currentState).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1658690771);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1658690771, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:71)");
            }
            if (zBooleanValue6) {
                float f7 = TitleExpandedOffsetY;
                f = 0.0f;
                jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
                iFloatToRawIntBits = Float.floatToRawIntBits(f7);
            } else {
                f = 0.0f;
                jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
                iFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
            }
            long jM6561constructorimpl = Offset.m6561constructorimpl((jFloatToRawIntBits << 32) | (((long) iFloatToRawIntBits) & 4294967295L));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Offset offsetM6558boximpl = Offset.m6558boximpl(jM6561constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            int i9 = i8 & 14;
            int i10 = i9 ^ 6;
            if (i10 <= 4 || !composerStartRestartGroup.changed(renameTransition)) {
                i4 = i9;
                if ((i8 & 6) != 4) {
                    z4 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$2
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return renameTransition.getTargetState();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) ((State) objRememberedValue).getValue()).booleanValue();
                composerStartRestartGroup.startReplaceGroup(-1658690771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1658690771, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:71)");
                }
                if (zBooleanValue) {
                    float f8 = TitleExpandedOffsetY;
                    jFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f8);
                } else {
                    jFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                }
                long jM6561constructorimpl2 = Offset.m6561constructorimpl((jFloatToRawIntBits2 << 32) | (((long) iFloatToRawIntBits2) & 4294967295L));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Offset offsetM6558boximpl2 = Offset.m6558boximpl(jM6561constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
                z5 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Transition.Segment<Boolean> invoke() {
                            return renameTransition.getSegment();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpringSpec<Offset> springSpecInvoke = topBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$1.invoke(((State) objRememberedValue2).getValue(), composerStartRestartGroup, 0);
                int i11 = i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(renameTransition, offsetM6558boximpl, offsetM6558boximpl2, springSpecInvoke, vectorConverter, "rename title translation", composerStartRestartGroup, i11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
                TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1 topBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Dp>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i12) {
                        composer2.startReplaceGroup(-1953972046);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1953972046, i12, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1977)");
                        }
                        SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m9685boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return springSpecSpring$default;
                    }
                };
                TwoWayConverter<Dp, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
                if (renameTransition.isSeeking()) {
                    composerStartRestartGroup.startReplaceGroup(1666827533);
                    composerStartRestartGroup.endReplaceGroup();
                    currentState2 = renameTransition.getCurrentState();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1666573488);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                    z13 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                    currentState2 = composerStartRestartGroup.rememberedValue();
                    if (z13 || currentState2 == Composer.INSTANCE.getEmpty()) {
                        companion2 = Snapshot.INSTANCE;
                        currentThreadSnapshot2 = companion2.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot2 != null) {
                            readObserver2 = currentThreadSnapshot2.getReadObserver();
                        } else {
                            readObserver2 = null;
                        }
                        snapshotMakeCurrentNonObservable2 = companion2.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Boolean currentState5 = renameTransition.getCurrentState();
                            companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            composerStartRestartGroup.updateRememberedValue(currentState5);
                            currentState2 = currentState5;
                        } catch (Throwable th2) {
                            companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th2;
                        }
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                zBooleanValue2 = ((Boolean) currentState2).booleanValue();
                composerStartRestartGroup.startReplaceGroup(-1058937773);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1058937773, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:74)");
                }
                if (zBooleanValue2) {
                    f2 = ExpandedTitlePadding;
                } else {
                    f2 = CollapsedTitlePadding;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Dp dpM9685boximpl = Dp.m9685boximpl(f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
                z6 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$2
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return renameTransition.getTargetState();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue3 = ((Boolean) ((State) objRememberedValue3).getValue()).booleanValue();
                composerStartRestartGroup.startReplaceGroup(-1058937773);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1058937773, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:74)");
                }
                if (zBooleanValue3) {
                    f3 = ExpandedTitlePadding;
                } else {
                    f3 = CollapsedTitlePadding;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Dp dpM9685boximpl2 = Dp.m9685boximpl(f3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
                z7 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Transition.Segment<Boolean> invoke() {
                            return renameTransition.getSegment();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(renameTransition, dpM9685boximpl, dpM9685boximpl2, topBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1.invoke(((State) objRememberedValue4).getValue(), composerStartRestartGroup, 0), vectorConverter2, ViewProps.PADDING, composerStartRestartGroup, i11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
                TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1 topBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Float>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i12) {
                        composer2.startReplaceGroup(-985243360);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-985243360, i12, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1947)");
                        }
                        SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return springSpecSpring$default;
                    }
                };
                TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
                if (renameTransition.isSeeking()) {
                    composerStartRestartGroup.startReplaceGroup(1666827533);
                    composerStartRestartGroup.endReplaceGroup();
                    currentState3 = renameTransition.getCurrentState();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1666573488);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                    z12 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                    currentState3 = composerStartRestartGroup.rememberedValue();
                    if (z12 || currentState3 == Composer.INSTANCE.getEmpty()) {
                        companion = Snapshot.INSTANCE;
                        currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot != null) {
                            readObserver = currentThreadSnapshot.getReadObserver();
                        } else {
                            readObserver = null;
                        }
                        snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Boolean currentState6 = renameTransition.getCurrentState();
                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            composerStartRestartGroup.updateRememberedValue(currentState6);
                            currentState3 = currentState6;
                        } catch (Throwable th3) {
                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th3;
                        }
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                zBooleanValue4 = ((Boolean) currentState3).booleanValue();
                composerStartRestartGroup.startReplaceGroup(978057430);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(978057430, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:77)");
                }
                if (zBooleanValue4) {
                    f4 = f;
                } else {
                    f4 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf = Float.valueOf(f4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
                z8 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$2
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return renameTransition.getTargetState();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue5 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
                composerStartRestartGroup.startReplaceGroup(978057430);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(978057430, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:77)");
                }
                if (zBooleanValue5) {
                    f5 = f;
                } else {
                    f5 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
                z9 = (i10 <= 4 && composerStartRestartGroup.changed(renameTransition)) || (i8 & 6) == 4;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z9 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Transition.Segment<Boolean> invoke() {
                            return renameTransition.getSegment();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(renameTransition, fValueOf, fValueOf2, topBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1.invoke(((State) objRememberedValue6).getValue(), composerStartRestartGroup, 0), vectorConverter3, "textStyle fraction animation", composerStartRestartGroup, i11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                textStyleLerp = TextStyleKt.lerp(TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal22(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), PreviewTopBarTitle$lambda$5(stateCreateTransitionAnimation3));
                f6 = f;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(OffsetKt.m1174offsetVpY3zN4(companion3, Dp.m9687constructorimpl(Float.intBitsToFloat((int) (PreviewTopBarTitle$lambda$1(stateCreateTransitionAnimation2) >> 32))), Dp.m9687constructorimpl(Float.intBitsToFloat((int) (PreviewTopBarTitle$lambda$1(stateCreateTransitionAnimation2) & 4294967295L)))), f6, 1, null);
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 157531568, "C123@5348L114:TopBarTitle.kt#l0df2e");
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(157521337);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "92@4071L29,93@4134L7,94@4215L175,94@4154L236,99@4403L492");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410560383, "CC(remember):TopBarTitle.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    focusRequester = (FocusRequester) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume;
                    Boolean currentState7 = renameTransition.getCurrentState();
                    Boolean boolValueOf = Boolean.valueOf(z2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410555629, "CC(remember):TopBarTitle.kt#9igjgp");
                    if ((458752 & i3) == 131072) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if ((i3 & 7168) == 2048) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zChangedInstance = z10 | z11 | composerStartRestartGroup.changedInstance(view);
                    topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        i5 = i3;
                        i6 = 2;
                        topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue = new TopBarTitleKt$PreviewTopBarTitle$1$1$1(renameTransition, z2, view, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue);
                    } else {
                        i5 = i3;
                        i6 = 2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(currentState7, boolValueOf, (Function2) topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue, composerStartRestartGroup, (i5 >> 6) & 112);
                    Modifier modifierTestTag = TestTagKt.testTag(FocusRequesterModifierKt.focusRequester(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), f6, i6, null), focusRequester), "Preview:RenameItemTextField");
                    int i12 = i5 >> 12;
                    composerStartRestartGroup = composerStartRestartGroup;
                    EditableFileName(fileName, textStyleLerp, modifierTestTag, onFileNameChange, onFinishEditing, z3, composerStartRestartGroup, (i5 & 14) | (i12 & 7168) | (i12 & 57344) | ((i5 << 3) & 458752));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i5 = i3;
                    composerStartRestartGroup.startReplaceGroup(158388810);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@4925L404");
                    TextKt.m4494TextNvy7gAk(fileName, TestTagKt.testTag(SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), f6, 2, null), f6, 1, null), "Preview:TopBarTitleFileName"), 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9531getStarte0LSkKk()), 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, textStyleLerp, composerStartRestartGroup, i5 & 14, 24960, 109564);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PreviewTopBarSubtitle(subtitle, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), 0.0f, 2, null), composerStartRestartGroup, (i5 >> 3) & 14);
                if (str == null) {
                    composerStartRestartGroup.startReplaceGroup(158939431);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(158939432);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*131@5629L6,128@5503L218");
                    Composer composer2 = composerStartRestartGroup;
                    TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11563getTextFieldError0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 48, 0, 131064);
                    composerStartRestartGroup = composer2;
                    Unit unit = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion3;
            } else {
                i4 = i9;
            }
            z4 = true;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zBooleanValue = ((Boolean) ((State) objRememberedValue).getValue()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1658690771);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1658690771, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:71)");
            }
            if (zBooleanValue) {
                float f9 = TitleExpandedOffsetY;
                jFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                iFloatToRawIntBits2 = Float.floatToRawIntBits(f9);
            } else {
                jFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                iFloatToRawIntBits2 = Float.floatToRawIntBits(f);
            }
            long jM6561constructorimpl3 = Offset.m6561constructorimpl((jFloatToRawIntBits2 << 32) | (((long) iFloatToRawIntBits2) & 4294967295L));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Offset offsetM6558boximpl3 = Offset.m6558boximpl(jM6561constructorimpl3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            if (i10 <= 4) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpringSpec<Offset> springSpecInvoke2 = topBarTitleKt$PreviewTopBarTitle$$inlined$animateOffset$1.invoke(((State) objRememberedValue2).getValue(), composerStartRestartGroup, 0);
            int i13 = i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(renameTransition, offsetM6558boximpl, offsetM6558boximpl3, springSpecInvoke2, vectorConverter, "rename title translation", composerStartRestartGroup, i13);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
            TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1 topBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Dp>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer3, int i14) {
                    composer3.startReplaceGroup(-1953972046);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953972046, i14, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1977)");
                    }
                    SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m9685boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
            TwoWayConverter<Dp, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (renameTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                if (i10 <= 4) {
                }
                currentState2 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    companion2 = Snapshot.INSTANCE;
                    currentThreadSnapshot2 = companion2.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = companion2.makeCurrentNonObservable(currentThreadSnapshot2);
                    Boolean currentState8 = renameTransition.getCurrentState();
                    companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    composerStartRestartGroup.updateRememberedValue(currentState8);
                    currentState2 = currentState8;
                } else {
                    companion2 = Snapshot.INSTANCE;
                    currentThreadSnapshot2 = companion2.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = companion2.makeCurrentNonObservable(currentThreadSnapshot2);
                    Boolean currentState9 = renameTransition.getCurrentState();
                    companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    composerStartRestartGroup.updateRememberedValue(currentState9);
                    currentState2 = currentState9;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState2 = renameTransition.getCurrentState();
            }
            zBooleanValue2 = ((Boolean) currentState2).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1058937773);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1058937773, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:74)");
            }
            if (zBooleanValue2) {
                f2 = ExpandedTitlePadding;
            } else {
                f2 = CollapsedTitlePadding;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Dp dpM9685boximpl3 = Dp.m9685boximpl(f2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            if (i10 <= 4) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z6) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zBooleanValue3 = ((Boolean) ((State) objRememberedValue3).getValue()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1058937773);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1058937773, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:74)");
            }
            if (zBooleanValue3) {
                f3 = ExpandedTitlePadding;
            } else {
                f3 = CollapsedTitlePadding;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Dp dpM9685boximpl4 = Dp.m9685boximpl(f3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            if (i10 <= 4) {
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z7) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(renameTransition, dpM9685boximpl3, dpM9685boximpl4, topBarTitleKt$PreviewTopBarTitle$$inlined$animateDp$2.invoke(((State) objRememberedValue4).getValue(), composerStartRestartGroup, 0), vectorConverter4, ViewProps.PADDING, composerStartRestartGroup, i13);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1 topBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Float>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }

                public final SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, int i14) {
                    composer3.startReplaceGroup(-985243360);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-985243360, i14, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1947)");
                    }
                    SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (renameTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                if (i10 <= 4) {
                }
                currentState3 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    companion = Snapshot.INSTANCE;
                    currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    Boolean currentState10 = renameTransition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composerStartRestartGroup.updateRememberedValue(currentState10);
                    currentState3 = currentState10;
                } else {
                    companion = Snapshot.INSTANCE;
                    currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    Boolean currentState11 = renameTransition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composerStartRestartGroup.updateRememberedValue(currentState11);
                    currentState3 = currentState11;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState3 = renameTransition.getCurrentState();
            }
            zBooleanValue4 = ((Boolean) currentState3).booleanValue();
            composerStartRestartGroup.startReplaceGroup(978057430);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(978057430, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:77)");
            }
            if (zBooleanValue4) {
                f4 = f;
            } else {
                f4 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(f4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            if (i10 <= 4) {
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z8) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return renameTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zBooleanValue5 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(978057430);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):TopBarTitle.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(978057430, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle.<anonymous> (TopBarTitle.kt:77)");
            }
            if (zBooleanValue5) {
                f5 = f;
            } else {
                f5 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf4 = Float.valueOf(f5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            if (i10 <= 4) {
            }
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z9) {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return renameTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(renameTransition, fValueOf3, fValueOf4, topBarTitleKt$PreviewTopBarTitle$$inlined$animateFloat$2.invoke(((State) objRememberedValue6).getValue(), composerStartRestartGroup, 0), vectorConverter5, "textStyle fraction animation", composerStartRestartGroup, i13);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            textStyleLerp = TextStyleKt.lerp(TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal22(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), PreviewTopBarTitle$lambda$5(stateCreateTransitionAnimation5));
            f6 = f;
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(OffsetKt.m1174offsetVpY3zN4(companion3, Dp.m9687constructorimpl(Float.intBitsToFloat((int) (PreviewTopBarTitle$lambda$1(stateCreateTransitionAnimation4) >> 32))), Dp.m9687constructorimpl(Float.intBitsToFloat((int) (PreviewTopBarTitle$lambda$1(stateCreateTransitionAnimation4) & 4294967295L)))), f6, 1, null);
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 157531568, "C123@5348L114:TopBarTitle.kt#l0df2e");
            if (z) {
                composerStartRestartGroup.startReplaceGroup(157521337);
                ComposerKt.sourceInformation(composerStartRestartGroup, "92@4071L29,93@4134L7,94@4215L175,94@4154L236,99@4403L492");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410560383, "CC(remember):TopBarTitle.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                focusRequester = (FocusRequester) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume2;
                Boolean currentState12 = renameTransition.getCurrentState();
                Boolean boolValueOf2 = Boolean.valueOf(z2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410555629, "CC(remember):TopBarTitle.kt#9igjgp");
                if ((458752 & i3) == 131072) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((i3 & 7168) == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChangedInstance = z10 | z11 | composerStartRestartGroup.changedInstance(view);
                topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    i5 = i3;
                    i6 = 2;
                    topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue = new TopBarTitleKt$PreviewTopBarTitle$1$1$1(renameTransition, z2, view, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue);
                } else {
                    i5 = i3;
                    i6 = 2;
                    topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue = new TopBarTitleKt$PreviewTopBarTitle$1$1$1(renameTransition, z2, view, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(currentState12, boolValueOf2, (Function2) topBarTitleKt$PreviewTopBarTitle$1$1$1RememberedValue, composerStartRestartGroup, (i5 >> 6) & 112);
                Modifier modifierTestTag2 = TestTagKt.testTag(FocusRequesterModifierKt.focusRequester(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), f6, i6, null), focusRequester), "Preview:RenameItemTextField");
                int i14 = i5 >> 12;
                composerStartRestartGroup = composerStartRestartGroup;
                EditableFileName(fileName, textStyleLerp, modifierTestTag2, onFileNameChange, onFinishEditing, z3, composerStartRestartGroup, (i5 & 14) | (i14 & 7168) | (i14 & 57344) | ((i5 << 3) & 458752));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i5 = i3;
                composerStartRestartGroup.startReplaceGroup(158388810);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4925L404");
                TextKt.m4494TextNvy7gAk(fileName, TestTagKt.testTag(SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), f6, 2, null), f6, 1, null), "Preview:TopBarTitleFileName"), 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9531getStarte0LSkKk()), 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, textStyleLerp, composerStartRestartGroup, i5 & 14, 24960, 109564);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            PreviewTopBarSubtitle(subtitle, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, PreviewTopBarTitle$lambda$3(stateCreateTransitionAnimation), 0.0f, 2, null), composerStartRestartGroup, (i5 >> 3) & 14);
            if (str == null) {
                composerStartRestartGroup.startReplaceGroup(158939431);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(158939432);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*131@5629L6,128@5503L218");
                Composer composer3 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11563getTextFieldError0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 48, 0, 131064);
                composerStartRestartGroup = composer3;
                Unit unit3 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarTitleKt.PreviewTopBarTitle$lambda$7(fileName, subtitle, z, z2, z3, renameTransition, str, onFileNameChange, onFinishEditing, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PreviewTopBarSubtitle(final TopBarReducer.SubtitleState subtitleState, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1095092576);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewTopBarSubtitle)N(subtitle,modifier)140@5838L1226:TopBarTitle.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(subtitleState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1095092576, i2, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarSubtitle (TopBarTitle.kt:139)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1366500004, "C:TopBarTitle.kt#l0df2e");
            if (subtitleState instanceof TopBarReducer.SubtitleState.Locked) {
                composerStartRestartGroup.startReplaceGroup(-1366462898);
                ComposerKt.sourceInformation(composerStartRestartGroup, "145@6053L178,143@5948L526");
                int i3 = R.drawable.ic_lock_outline;
                int i4 = com.box.android.preview.R.string.preview_subtitle_lock;
                String lockedByUsername = ((TopBarReducer.SubtitleState.Locked) subtitleState).getLockedByUsername();
                if (lockedByUsername == null) {
                    lockedByUsername = "";
                }
                PreviewTopBarSubtitleElement(i3, StringResources_androidKt.stringResource(i4, new Object[]{lockedByUsername}, composerStartRestartGroup, 0), "", Modifier.INSTANCE, SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(2), Dp.m9687constructorimpl(4), 0.0f, 9, null), Dp.m9687constructorimpl(12)), composerStartRestartGroup, 3456);
                composerStartRestartGroup.endReplaceGroup();
            } else if (subtitleState instanceof TopBarReducer.SubtitleState.ViewOnly) {
                composerStartRestartGroup.startReplaceGroup(-1365869310);
                ComposerKt.sourceInformation(composerStartRestartGroup, "160@6677L126,158@6549L442");
                PreviewTopBarSubtitleElement(com.box.android.preview.R.drawable.ic_edit_off_12, StringResources_androidKt.stringResource(com.box.android.preview.R.string.preview_subtitle_view_only, composerStartRestartGroup, 0), "", SizeKt.wrapContentWidth$default(Modifier.INSTANCE, null, false, 3, null), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 11, null), composerStartRestartGroup, 28032);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(subtitleState instanceof TopBarReducer.SubtitleState.None)) {
                    composerStartRestartGroup.startReplaceGroup(371561351);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(371597642);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarTitleKt.PreviewTopBarSubtitle$lambda$1(subtitleState, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PreviewTopBarSubtitleElement(final int i, final String str, final String str2, final Modifier modifier, final Modifier modifier2, Composer composer, final int i2) {
        int i3;
        String str3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-948051857);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewTopBarSubtitleElement)N(drawableRes,text,contentDescription,modifier,iconModifier)182@7267L593:TopBarTitle.kt#l0df2e");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            str3 = str;
            i3 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
        } else {
            str3 = str;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-948051857, i3, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarSubtitleElement (TopBarTitle.kt:181)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 204441710, "C187@7400L33,189@7516L6,186@7372L214,198@7821L6,192@7595L259:TopBarTitle.kt#l0df2e");
            int i4 = i3 >> 3;
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i3 & 14), str2, modifier2, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, Painter.$stable | (i4 & 112) | ((i3 >> 6) & 896), 0);
            String str4 = str3;
            TextKt.m4494TextNvy7gAk(str4, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9531getStarte0LSkKk()), 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composerStartRestartGroup, i4 & 14, 24960, 109562);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarTitleKt.PreviewTopBarSubtitleElement$lambda$1(i, str, str2, modifier, modifier2, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void EditableFileName(final String str, final TextStyle textStyle, final Modifier modifier, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Continuation continuation;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1108797662);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditableFileName)N(fileName,textStyle,modifier,onFileNameChange,onFinishEditing,showRenamePendingIndicator)212@8136L7,213@8170L115,218@8315L146,218@8290L171,225@8590L6,226@8655L6,228@8715L1314,223@8466L1563:TopBarTitle.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1108797662, i2, -1, "com.box.android.preview.preview.previewbar.topbar.EditableFileName (TopBarTitle.kt:211)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -402654507, "CC(remember):TopBarTitle.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                continuation = null;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, TextRangeKt.TextRange(str.length()), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                continuation = null;
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -402649836, "CC(remember):TopBarTitle.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            TopBarTitleKt$EditableFileName$1$1 topBarTitleKt$EditableFileName$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || topBarTitleKt$EditableFileName$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                topBarTitleKt$EditableFileName$1$1RememberedValue = new TopBarTitleKt$EditableFileName$1$1(str, mutableState, continuation);
                composerStartRestartGroup.updateRememberedValue(topBarTitleKt$EditableFileName$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) topBarTitleKt$EditableFileName$1$1RememberedValue, composerStartRestartGroup, i3);
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(new TextSelectionColors(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null)), ComposableLambdaKt.rememberComposableLambda(471272418, true, new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarTitleKt.EditableFileName$lambda$4(focusManager, modifier, function0, function1, z, textStyle, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarTitleKt.EditableFileName$lambda$5(str, textStyle, modifier, function1, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue EditableFileName$lambda$1(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableFileName$lambda$4(final FocusManager focusManager, Modifier modifier, final Function0 function0, final Function1 function1, boolean z, TextStyle textStyle, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C229@8725L1298:TopBarTitle.kt#l0df2e");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(471272418, i, -1, "com.box.android.preview.preview.previewbar.topbar.EditableFileName.<anonymous> (TopBarTitle.kt:229)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1545094333, "C242@9235L6,245@9421L73,251@9618L140,235@8949L105,233@8861L911:TopBarTitle.kt#l0df2e");
            TextFieldValue textFieldValueEditableFileName$lambda$1 = EditableFileName$lambda$1(mutableState);
            SolidColor solidColor = new SolidColor(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1573879247, "CC(remember):TopBarTitle.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(focusManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TopBarTitleKt.EditableFileName$lambda$4$0$0$0(focusManager, (KeyboardActionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue, null, null, null, null, null, 62, null);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, modifier, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1573885618, "CC(remember):TopBarTitle.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TopBarTitleKt.EditableFileName$lambda$4$0$1$0(function0, (FocusState) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnFocusChanged = FocusChangedModifierKt.onFocusChanged(modifierWeight$default, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer, 1573864175, "CC(remember):TopBarTitle.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TopBarTitleKt.EditableFileName$lambda$4$0$2$0(function1, mutableState, (TextFieldValue) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicTextFieldKt.BasicTextField(textFieldValueEditableFileName$lambda$1, (Function1<? super TextFieldValue, Unit>) objRememberedValue3, modifierOnFocusChanged, false, z, textStyle, keyboardOptions, keyboardActions, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) null, composer, 102236160, 0, 48648);
            if (z) {
                composer.startReplaceGroup(1546013048);
                ComposerKt.sourceInformation(composer, "258@9835L164");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 0.0f, 11, null), Dp.m9687constructorimpl(24)), null, 0L, 0L, 0.0f, 0, null, composer, 6, 126);
            } else {
                composer.startReplaceGroup(1536267516);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableFileName$lambda$4$0$2$0(Function1 function1, MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        function1.invoke(it.getText());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableFileName$lambda$4$0$0$0(FocusManager focusManager, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableFileName$lambda$4$0$1$0(Function0 function0, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isFocused()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final long PreviewTopBarTitle$lambda$1(State<Offset> state) {
        return state.getValue().m6579unboximpl();
    }

    private static final float PreviewTopBarTitle$lambda$3(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    private static final float PreviewTopBarTitle$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }
}
