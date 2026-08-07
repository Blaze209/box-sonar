package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u001c\u001aQ\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2 \u0010$\u001a\u001c\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000H\u0001¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00020*2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0005H\u0000\u001a\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0000\u001a\u0012\u00100\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0000\"\u001a\u00101\u001a\u0004\u0018\u000102*\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u000e\u00106\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020-X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020-X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020-X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010>\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010A\"\u0016\u0010C\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\bD\u0010A¨\u0006E"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", FirebaseAnalytics.Param.INDEX, "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "widthOrZero", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "heightOrZero", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "AnimationDuration", "PlaceholderAnimationDuration", "PlaceholderAnimationDelayOrDuration", "TextFieldPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldPadding", "()F", "F", "HorizontalIconPadding", "getHorizontalIconPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final float TextFieldPadding = Dp.m9687constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m9687constructorimpl(12);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$3(TextFieldType textFieldType, String str, Function2 function2, VisualTransformation visualTransformation, Function2 function3, Function2 function4, Function2 function5, Function2 function6, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, Shape shape, TextFieldColors textFieldColors, Function2 function7, int i, int i2, Composer composer, int i3) {
        CommonDecorationBox(textFieldType, str, function2, visualTransformation, function3, function4, function5, function6, z, z2, z3, interactionSource, paddingValues, shape, textFieldColors, function7, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_euL9pac$lambda$1(long j, TextStyle textStyle, Float f, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2643DecorationeuL9pac(j, textStyle, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CommonDecorationBox(final TextFieldType textFieldType, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final boolean z, final boolean z2, final boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final Shape shape, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function7, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i4;
        Composer composer2;
        InputPhase inputPhase;
        Composer composerStartRestartGroup = composer.startRestartGroup(418608794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonDecorationBox)N(type,value,innerTextField,visualTransformation,label,placeholder,leadingIcon,trailingIcon,singleLine,enabled,isError,interactionSource,contentPadding,shape,colors,border)80@3060L121,86@3257L25,106@3942L10,116@4385L10,121@4612L10,127@4852L4436,113@4277L5011:TextFieldImpl.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(textFieldType.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function8 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function8) ? 256 : 128;
        } else {
            function8 = function2;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            function9 = function4;
            i3 |= composerStartRestartGroup.changedInstance(function9) ? 131072 : 65536;
        } else {
            function9 = function4;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldColors) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function7) ? 131072 : 65536;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(418608794, i3, i5, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1443855405, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean z4 = ((i3 & 112) == 32) | ((i3 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i5 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            Function3<InputPhase, Composer, Integer, Color> function10 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                    return Color.m6804boximpl(m2645invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                }

                /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m2645invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i6) {
                    composer3.startReplaceGroup(1423138213);
                    ComposerKt.sourceInformation(composer3, "CN(it)96@3582L298:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1423138213, i6, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:95)");
                    }
                    long jM6824unboximpl = textFieldColors.labelColor(z2, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z3, interactionSource, composer3, 0).getValue().m6824unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return jM6824unboximpl;
                }
            };
            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            boolean z5 = (Color.m6815equalsimpl0(subtitle1.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()) && !Color.m6815equalsimpl0(caption.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU())) || (!Color.m6815equalsimpl0(subtitle1.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()) && Color.m6815equalsimpl0(caption.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-1443813555);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            long jM9121getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getCaption().m9121getColor0d7_KjU();
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(-887928539);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*117@4481L22");
                if (jM9121getColor0d7_KjU == 16) {
                    jM9121getColor0d7_KjU = function10.invoke(inputPhase, composerStartRestartGroup, 0).m6824unboximpl();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1218284988);
                composerStartRestartGroup.endReplaceGroup();
            }
            long j = jM9121getColor0d7_KjU;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1443806289);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            long jM9121getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1().m9121getColor0d7_KjU();
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(-1026713946);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*122@4710L22");
                if (jM9121getColor0d7_KjU2 == 16) {
                    jM9121getColor0d7_KjU2 = function10.invoke(inputPhase, composerStartRestartGroup, 0).m6824unboximpl();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(798166043);
                composerStartRestartGroup.endReplaceGroup();
            }
            long j2 = jM9121getColor0d7_KjU2;
            composerStartRestartGroup.endReplaceGroup();
            textFieldTransitionScope.m2656TransitionDTcfvLk(inputPhase, j, j2, function10, function3 != null, ComposableLambdaKt.rememberComposableLambda(33336375, true, new AnonymousClass3(function3, function9, text, textFieldColors, z2, z3, interactionSource, function5, function6, shape, textFieldType, function8, z, paddingValues, z5, function7), composerStartRestartGroup, 54), composerStartRestartGroup, 1769472);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldImplKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.CommonDecorationBox$lambda$3(textFieldType, str, function2, visualTransformation, function3, function4, function5, function6, z, z2, z3, interactionSource, paddingValues, shape, textFieldColors, function7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $shouldOverrideTextStyleColor;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ String $transformedText;
        final /* synthetic */ TextFieldType $type;

        /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
        /* JADX INFO: compiled from: TextFieldImpl.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TextFieldType.values().length];
                try {
                    iArr[TextFieldType.Filled.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, String str, TextFieldColors textFieldColors, boolean z, boolean z2, InteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function6, boolean z3, PaddingValues paddingValues, boolean z4, Function2<? super Composer, ? super Integer, Unit> function7) {
            this.$label = function2;
            this.$placeholder = function3;
            this.$transformedText = str;
            this.$colors = textFieldColors;
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$leadingIcon = function4;
            this.$trailingIcon = function5;
            this.$shape = shape;
            this.$type = textFieldType;
            this.$innerTextField = function6;
            this.$singleLine = z3;
            this.$contentPadding = paddingValues;
            this.$shouldOverrideTextStyleColor = z4;
            this.$border = function7;
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer, Integer num) {
            m2644invokeRIQooxk(f.floatValue(), color.m6824unboximpl(), color2.m6824unboximpl(), f2.floatValue(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
        public final void m2644invokeRIQooxk(float f, long j, final long j2, final float f2, Composer composer, int i) {
            int i2;
            long j3;
            int i3;
            ComposableLambda composableLambda;
            ComposableLambda composableLambda2;
            ComposableLambda composableLambda3;
            final float f3 = f;
            ComposerKt.sourceInformation(composer, "CN(labelProgress,labelTextStyleColor:c#ui.graphics.Color,labelContentColor:c#ui.graphics.Color,placeholderAlphaProgress)161@6500L53,167@6793L54,173@7111L24:TextFieldImpl.kt#jmzs0o");
            if ((i & 6) == 0) {
                i2 = (composer.changed(f3) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                j3 = j;
                i2 |= composer.changed(j3) ? 32 : 16;
            } else {
                j3 = j;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(j2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(f2) ? 2048 : 1024;
            }
            int i4 = i2;
            if (!composer.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(33336375, i4, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:128)");
            }
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            ComposableLambda composableLambdaRememberComposableLambda = null;
            if (function2 == null) {
                composer.startReplaceGroup(986681709);
                composer.endReplaceGroup();
                i3 = 54;
            } else {
                composer.startReplaceGroup(986681710);
                ComposerKt.sourceInformation(composer, "*130@5046L621");
                final boolean z = this.$shouldOverrideTextStyleColor;
                i3 = 54;
                final long j4 = j3;
                Function2 function3 = new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$0$0(f3, j2, function2, z, j4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                f3 = f3;
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(723429411, true, function3, composer, 54);
                composer.endReplaceGroup();
            }
            ComposableLambda composableLambda4 = composableLambdaRememberComposableLambda;
            if (this.$placeholder != null && this.$transformedText.length() == 0 && f2 > 0.0f) {
                composer.startReplaceGroup(987666549);
                ComposerKt.sourceInformation(composer, "150@6042L394");
                final TextFieldColors textFieldColors = this.$colors;
                final boolean z2 = this.$enabled;
                final Function2<Composer, Integer, Unit> function4 = this.$placeholder;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-426706263, true, new Function3() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$1(f2, textFieldColors, z2, function4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, i3);
                composer.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            } else {
                composer.startReplaceGroup(988093542);
                composer.endReplaceGroup();
                composableLambda = null;
            }
            final long jM6824unboximpl = this.$colors.leadingIconColor(this.$enabled, this.$isError, this.$interactionSource, composer, 0).getValue().m6824unboximpl();
            final Function2<Composer, Integer, Unit> function5 = this.$leadingIcon;
            if (function5 == null) {
                composer.startReplaceGroup(988282301);
                composer.endReplaceGroup();
                composableLambda2 = null;
            } else {
                composer.startReplaceGroup(988282302);
                ComposerKt.sourceInformation(composer, "*164@6677L61");
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-317090443, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$2$0(jM6824unboximpl, function5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, i3);
                composer.endReplaceGroup();
                composableLambda2 = composableLambdaRememberComposableLambda3;
            }
            final long jM6824unboximpl2 = this.$colors.trailingIconColor(this.$enabled, this.$isError, this.$interactionSource, composer, 0).getValue().m6824unboximpl();
            final Function2<Composer, Integer, Unit> function6 = this.$trailingIcon;
            if (function6 == null) {
                composer.startReplaceGroup(988575964);
                composer.endReplaceGroup();
                composableLambda3 = null;
            } else {
                composer.startReplaceGroup(988575965);
                ComposerKt.sourceInformation(composer, "*170@6973L62");
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(262889693, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$3$0(jM6824unboximpl2, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, i3);
                composer.endReplaceGroup();
                composableLambda3 = composableLambdaRememberComposableLambda4;
            }
            Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(Modifier.INSTANCE, this.$colors.backgroundColor(this.$enabled, composer, 0).getValue().m6824unboximpl(), this.$shape);
            int i5 = WhenMappings.$EnumSwitchMapping$0[this.$type.ordinal()];
            if (i5 == 1) {
                composer.startReplaceGroup(988856360);
                ComposerKt.sourceInformation(composer, "177@7227L483");
                TextFieldKt.TextFieldLayout(modifierM588backgroundbw27NRU, this.$innerTextField, composableLambda4, composableLambda, composableLambda2, composableLambda3, this.$singleLine, f, this.$contentPadding, composer, (i4 << 21) & 29360128);
                composer.endReplaceGroup();
            } else {
                if (i5 != 2) {
                    composer.startReplaceGroup(1971561250);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(989436742);
                ComposerKt.sourceInformation(composer, "191@7832L38,192@7928L287,209@8638L453,201@8233L1025");
                ComposerKt.sourceInformationMarkerStart(composer, 1971580701, "CC(remember):TextFieldImpl.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m6626boximpl(Size.INSTANCE.m6647getZeroNHjbRc()), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                final PaddingValues paddingValues = this.$contentPadding;
                final Function2<Composer, Integer, Unit> function7 = this.$border;
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1107746014, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$5(mutableState, paddingValues, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, i3);
                Function2<Composer, Integer, Unit> function8 = this.$innerTextField;
                boolean z3 = this.$singleLine;
                ComposerKt.sourceInformationMarkerStart(composer, 1971606908, "CC(remember):TextFieldImpl.kt#9igjgp");
                boolean z4 = (i4 & 14) == 4;
                Object objRememberedValue2 = composer.rememberedValue();
                if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TextFieldImplKt.AnonymousClass3.invoke_RIQooxk$lambda$6$0(f3, mutableState, (Size) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierM588backgroundbw27NRU, function8, composableLambda, composableLambda4, composableLambda2, composableLambda3, z3, f3, (Function1) objRememberedValue2, composableLambdaRememberComposableLambda5, this.$contentPadding, composer, 805306368 | ((i4 << 21) & 29360128), 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke_RIQooxk$lambda$0$0(float f, long j, Function2 function2, boolean z, long j2, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C133@5165L10,134@5233L10,142@5594L55:TextFieldImpl.kt#jmzs0o");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(723429411, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:131)");
                }
                TextStyle textStyleLerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption(), f);
                if (z) {
                    textStyleLerp = TextStyle.m9104copyp1EtxEg$default(textStyleLerp, j2, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                }
                TextFieldImplKt.m2643DecorationeuL9pac(j, textStyleLerp, null, function2, composer, 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke_RIQooxk$lambda$1(float f, TextFieldColors textFieldColors, boolean z, Function2 function2, Modifier modifier, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "CN(modifier)151@6076L342:TextFieldImpl.kt#jmzs0o");
            if ((i & 6) == 0) {
                i |= composer.changed(modifier) ? 4 : 2;
            }
            if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-426706263, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:151)");
                }
                Modifier modifierAlpha = AlphaKt.alpha(modifier, f);
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlpha);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1083624968, "C153@6210L25,154@6298L10,152@6148L248:TextFieldImpl.kt#jmzs0o");
                TextFieldImplKt.m2643DecorationeuL9pac(textFieldColors.placeholderColor(z, composer, 0).getValue().m6824unboximpl(), MaterialTheme.INSTANCE.getTypography(composer, 6).getSubtitle1(), null, function2, composer, 0, 4);
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
        public static final Unit invoke_RIQooxk$lambda$2$0(long j, Function2 function2, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C164@6679L57:TextFieldImpl.kt#jmzs0o");
            if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-317090443, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:164)");
                }
                TextFieldImplKt.m2643DecorationeuL9pac(j, null, null, function2, composer, 0, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer.skipToGroupEnd();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke_RIQooxk$lambda$3$0(long j, Function2 function2, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C170@6975L58:TextFieldImpl.kt#jmzs0o");
            if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262889693, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:170)");
                }
                TextFieldImplKt.m2643DecorationeuL9pac(j, null, null, function2, composer, 0, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer.skipToGroupEnd();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke_RIQooxk$lambda$5(MutableState mutableState, PaddingValues paddingValues, Function2 function2, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C193@7950L247:TextFieldImpl.kt#jmzs0o");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1107746014, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:193)");
                }
                Modifier modifierM2492outlineCutout12SF9DM = OutlinedTextFieldKt.m2492outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), ((Size) mutableState.getValue()).m6643unboximpl(), paddingValues);
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2492outlineCutout12SF9DM);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1295987369, "C:TextFieldImpl.kt#jmzs0o");
                if (function2 == null) {
                    composer.startReplaceGroup(-1295979683);
                } else {
                    composer.startReplaceGroup(235288868);
                    ComposerKt.sourceInformation(composer, "197@8167L8");
                    function2.invoke(composer, 0);
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
        public static final Unit invoke_RIQooxk$lambda$6$0(float f, MutableState mutableState, Size size) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m6643unboximpl() >> 32)) * f;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m6643unboximpl() & 4294967295L)) * f;
            if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6643unboximpl() >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6643unboximpl() & 4294967295L)) != fIntBitsToFloat2) {
                mutableState.setValue(Size.m6626boximpl(Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m2643DecorationeuL9pac(final long j, TextStyle textStyle, Float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final TextStyle textStyle2;
        final Float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2064632657);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,typography,contentAlpha,content)238@9675L550:TextFieldImpl.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            textStyle2 = textStyle;
            f2 = f;
        } else {
            TextStyle textStyle3 = i4 != 0 ? null : textStyle;
            final Float f3 = i5 != 0 ? null : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2064632657, i3, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:236)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-650790565, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_euL9pac$lambda$0(j, f3, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            if (textStyle3 != null) {
                composerStartRestartGroup.startReplaceGroup(-162880673);
                ComposerKt.sourceInformation(composerStartRestartGroup, "253@10254L46");
                TextKt.ProvideTextStyle(textStyle3, composableLambdaRememberComposableLambda, composerStartRestartGroup, ((i3 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceGroup(-162879037);
                ComposerKt.sourceInformation(composerStartRestartGroup, "253@10306L18");
                composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle2 = textStyle3;
            f2 = f3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldImplKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_euL9pac$lambda$1(j, textStyle2, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_euL9pac$lambda$0(final long j, final Float f, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C239@9755L460,239@9689L526:TextFieldImpl.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-650790565, i, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:239)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j)), ComposableLambdaKt.rememberComposableLambda(-1624601445, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_euL9pac$lambda$0$0(f, function2, j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_euL9pac$lambda$0$0(Float f, Function2 function2, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:TextFieldImpl.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624601445, i, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:240)");
            }
            if (f != null) {
                composer.startReplaceGroup(1484860324);
                ComposerKt.sourceInformation(composer, "241@9821L155");
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(f), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1485059902);
                ComposerKt.sourceInformation(composer, "246@10022L161");
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(j))), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
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

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material.TextFieldImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.defaultErrorSemantics$lambda$0(str, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultErrorSemantics$lambda$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }
}
