package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;J\u009c\u0002\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>2\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010CJ5\u00101\u001a\u0002022\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t¢\u0006\u0004\bH\u0010IJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010JJ¿\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u0010O\u001a\u00020L2\b\b\u0002\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020L2\b\b\u0002\u0010R\u001a\u00020L2\b\b\u0002\u0010S\u001a\u00020L2\b\b\u0002\u0010T\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020L2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020L2\b\b\u0002\u0010Y\u001a\u00020L2\b\b\u0002\u0010Z\u001a\u00020L2\b\b\u0002\u0010[\u001a\u00020L2\b\b\u0002\u0010\\\u001a\u00020L2\b\b\u0002\u0010]\u001a\u00020L2\b\b\u0002\u0010^\u001a\u00020L2\b\b\u0002\u0010_\u001a\u00020L2\b\b\u0002\u0010`\u001a\u00020L2\b\b\u0002\u0010a\u001a\u00020L2\b\b\u0002\u0010b\u001a\u00020L2\b\b\u0002\u0010c\u001a\u00020L2\b\b\u0002\u0010d\u001a\u00020L2\b\b\u0002\u0010e\u001a\u00020L2\b\b\u0002\u0010f\u001a\u00020L2\b\b\u0002\u0010g\u001a\u00020L2\b\b\u0002\u0010h\u001a\u00020L2\b\b\u0002\u0010i\u001a\u00020L2\b\b\u0002\u0010j\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020L2\b\b\u0002\u0010n\u001a\u00020L2\b\b\u0002\u0010o\u001a\u00020L2\b\b\u0002\u0010p\u001a\u00020L2\b\b\u0002\u0010q\u001a\u00020L2\b\b\u0002\u0010r\u001a\u00020L2\b\b\u0002\u0010s\u001a\u00020L2\b\b\u0002\u0010t\u001a\u00020L2\b\b\u0002\u0010u\u001a\u00020L2\b\b\u0002\u0010v\u001a\u00020L2\b\b\u0002\u0010w\u001a\u00020LH\u0007¢\u0006\u0004\bx\u0010yJP\u0010~\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0018\u0010z\u001a\u000200*\u00020{8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", TtmlNode.RUBY_CONTAINER, "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", TextFieldImplKt.ContainerId, "modifier", "Landroidx/compose/ui/Modifier;", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "start", ViewProps.TOP, "end", ViewProps.BOTTOM, "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m9687constructorimpl(56);
    private static final float MinWidth = Dp.m9687constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m9687constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m9687constructorimpl(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContainerBox_nbWgWpA$lambda$0(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m3948ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m3947Container4EFweAY(z, z2, interactionSource, modifier, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$3(OutlinedTextFieldDefaults outlinedTextFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, Function2 function9, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function10, int i, int i2, int i3, Composer composer, int i4) {
        outlinedTextFieldDefaults.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, function7, function8, function9, textFieldColors, paddingValues, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1066756961, "C(<get-shape>)864@45231L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:864)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3952getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3953getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3954getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3951getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit decorator$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C965@51269L5,960@51076L347:TextFieldDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163468598, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<anonymous> (TextFieldDefaults.kt:960)");
            }
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = INSTANCE;
            outlinedTextFieldDefaults.m3947Container4EFweAY(z, z2, interactionSource, null, textFieldColors, outlinedTextFieldDefaults.getShape(composer, 6), FocusedBorderThickness, UnfocusedBorderThickness, composer, 114819072, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ Function2<Composer, Integer, Unit> $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(OutputTransformation outputTransformation, TextFieldState textFieldState, TextFieldLineLimits textFieldLineLimits, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean z, boolean z2, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function9) {
            this.$outputTransformation = outputTransformation;
            this.$state = textFieldState;
            this.$lineLimits = textFieldLineLimits;
            this.$labelPosition = textFieldLabelPosition;
            this.$label = function3;
            this.$placeholder = function2;
            this.$leadingIcon = function4;
            this.$trailingIcon = function5;
            this.$prefix = function6;
            this.$suffix = function7;
            this.$supportingText = function8;
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$container = function9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit Decoration$lambda$2(AnonymousClass2 anonymousClass2, Function2 function2, int i, Composer composer, int i2) {
            anonymousClass2.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            TextFieldBuffer textFieldBuffer;
            CharSequence charSequenceAsCharSequence;
            Composer composerStartRestartGroup = composer.startRestartGroup(794272399);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)983@52034L720:TextFieldDefaults.kt#uh7d8r");
            if ((i & 6) == 0) {
                i2 = i | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
            }
            if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(794272399, i2, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:971)");
                }
                if (this.$outputTransformation == null) {
                    charSequenceAsCharSequence = this.$state.getText();
                } else {
                    TextFieldState textFieldState = this.$state;
                    TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
                    try {
                        textFieldState.commitEdit(textFieldBufferStartEdit);
                        textFieldState.finishEditing();
                        OutputTransformation outputTransformation = this.$outputTransformation;
                        if (textFieldBufferStartEdit == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("buffer");
                            textFieldBuffer = null;
                        } else {
                            textFieldBuffer = textFieldBufferStartEdit;
                        }
                        outputTransformation.transformOutput(textFieldBuffer);
                        charSequenceAsCharSequence = textFieldBufferStartEdit.asCharSequence();
                    } catch (Throwable th) {
                        textFieldState.finishEditing();
                        throw th;
                    }
                }
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, charSequenceAsCharSequence, function2, this.$labelPosition, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE), this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer2, ((i2 << 6) & 896) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.AnonymousClass2.Decoration$lambda$2(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    public final TextFieldDecorator decorator(TextFieldState textFieldState, boolean z, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, InteractionSource interactionSource, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean z2, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function9, Composer composer, int i, int i2, int i3) {
        OutlinedTextFieldDefaults outlinedTextFieldDefaults;
        final TextFieldColors textFieldColorsColors;
        final boolean z3;
        final InteractionSource interactionSource2;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -449059361, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)957@50950L8,959@51062L371:TextFieldDefaults.kt#uh7d8r");
        TextFieldLabelPosition attached = (i3 & 32) != 0 ? new TextFieldLabelPosition.Attached(false, null, null, 7, null) : textFieldLabelPosition;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function10 = (i3 & 64) != 0 ? null : function3;
        Function2<? super Composer, ? super Integer, Unit> function11 = (i3 & 128) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function12 = (i3 & 256) != 0 ? null : function4;
        Function2<? super Composer, ? super Integer, Unit> function13 = (i3 & 512) != 0 ? null : function5;
        Function2<? super Composer, ? super Integer, Unit> function14 = (i3 & 1024) != 0 ? null : function6;
        Function2<? super Composer, ? super Integer, Unit> function15 = (i3 & 2048) != 0 ? null : function7;
        Function2<? super Composer, ? super Integer, Unit> function16 = (i3 & 4096) != 0 ? null : function8;
        final boolean z4 = (i3 & 8192) != 0 ? false : z2;
        if ((i3 & 16384) != 0) {
            outlinedTextFieldDefaults = this;
            textFieldColorsColors = outlinedTextFieldDefaults.colors(composer, (i2 >> 21) & 14);
        } else {
            outlinedTextFieldDefaults = this;
            textFieldColorsColors = textFieldColors;
        }
        PaddingValues paddingValuesM3946contentPaddinga9UjIt4$default = (32768 & i3) != 0 ? m3946contentPaddinga9UjIt4$default(outlinedTextFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
        if ((i3 & 65536) != 0) {
            z3 = z;
            interactionSource2 = interactionSource;
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-163468598, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldDefaults.decorator$lambda$0(z3, z4, interactionSource2, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
        } else {
            z3 = z;
            interactionSource2 = interactionSource;
            function2RememberComposableLambda = function9;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449059361, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator (TextFieldDefaults.kt:970)");
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(outputTransformation, textFieldState, textFieldLineLimits, attached, function10, function11, function12, function13, function14, function15, function16, z3, z4, interactionSource2, paddingValuesM3946contentPaddinga9UjIt4$default, textFieldColorsColors, function2RememberComposableLambda);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return anonymousClass2;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x013d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0142  */
    /* JADX WARN: Code duplicated, block: B:115:0x0147  */
    /* JADX WARN: Code duplicated, block: B:116:0x0152  */
    /* JADX WARN: Code duplicated, block: B:119:0x0157  */
    /* JADX WARN: Code duplicated, block: B:120:0x0160  */
    /* JADX WARN: Code duplicated, block: B:123:0x0165  */
    /* JADX WARN: Code duplicated, block: B:124:0x016a  */
    /* JADX WARN: Code duplicated, block: B:127:0x016f  */
    /* JADX WARN: Code duplicated, block: B:128:0x017a  */
    /* JADX WARN: Code duplicated, block: B:132:0x0189  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:137:0x0208  */
    /* JADX WARN: Code duplicated, block: B:140:0x0217  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fa  */
    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public final void m3947Container4EFweAY(final boolean z, final boolean z2, final InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TextFieldColors textFieldColors2;
        Shape shape2;
        float f3;
        float f4;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final TextFieldColors textFieldColors3;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        TextFieldColors textFieldColorsColors;
        Shape shape4;
        float f7;
        Modifier modifier4;
        int i4;
        TextFieldColors textFieldColors4;
        Shape shape5;
        float f8;
        float f9;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1035477640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1032@54214L25,1034@54285L222,1046@54792L7,1044@54625L189,1048@54823L153:TextFieldDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    textFieldColors2 = textFieldColors;
                    int i7 = composerStartRestartGroup.changed(textFieldColors2) ? 16384 : 8192;
                    i3 |= i7;
                } else {
                    textFieldColors2 = textFieldColors;
                }
                i3 |= i7;
            } else {
                textFieldColors2 = textFieldColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    int i8 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    f3 = f;
                    int i9 = composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    i3 |= i9;
                } else {
                    f3 = f;
                }
                i3 |= i9;
            } else {
                f3 = f;
            }
            if ((12582912 & i) == 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    int i10 = composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
                    i3 |= i10;
                } else {
                    f4 = f2;
                }
                i3 |= i10;
            } else {
                f4 = f2;
            }
            if ((100663296 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i3 |= i5;
            }
            if ((38347923 & i3) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1027@53974L8,1028@54033L5");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors2;
                    }
                    if ((i2 & 32) != 0) {
                        shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        f7 = FocusedBorderThickness;
                        i3 &= -3670017;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        shape5 = shape4;
                        f9 = UnfocusedBorderThickness;
                        modifier4 = companion;
                        i4 = i3 & (-29360129);
                        textFieldColors4 = textFieldColorsColors;
                        f8 = f7;
                    } else {
                        modifier4 = companion;
                        i4 = i3;
                        textFieldColors4 = textFieldColorsColors;
                        shape5 = shape4;
                        f8 = f7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035477640, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1031)");
                    }
                    int i11 = i4 >> 6;
                    boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, i11 & 14).getValue().booleanValue();
                    State<BorderStroke> stateM5104animateBorderStrokeAsStateNuRrP5Q = TextFieldImplKt.m5104animateBorderStrokeAsStateNuRrP5Q(z, z2, zBooleanValue, textFieldColors4, f8, f9, composerStartRestartGroup, (i11 & 458752) | ((i4 >> 3) & 7168) | (i4 & 126) | (57344 & i11));
                    Modifier modifier5 = modifier4;
                    Shape shape6 = shape5;
                    final State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(textFieldColors4.m4400containerColorXeAY9LY(z, z2, zBooleanValue), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                    composer2 = composerStartRestartGroup;
                    BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier5, stateM5104animateBorderStrokeAsStateNuRrP5Q.getValue(), shape6), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM437animateColorAsStateeuL9pac) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                        public Object get() {
                            return ((State) this.receiver).getValue();
                        }
                    }), shape6), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f5 = f8;
                    f6 = f9;
                    shape3 = shape6;
                    textFieldColors3 = textFieldColors4;
                    modifier3 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    i4 = i3;
                    textFieldColors4 = textFieldColors2;
                    f8 = f3;
                    shape5 = shape2;
                    modifier4 = modifier2;
                }
                f9 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035477640, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1031)");
                }
                int i12 = i4 >> 6;
                boolean zBooleanValue2 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, i12 & 14).getValue().booleanValue();
                State<BorderStroke> stateM5104animateBorderStrokeAsStateNuRrP5Q2 = TextFieldImplKt.m5104animateBorderStrokeAsStateNuRrP5Q(z, z2, zBooleanValue2, textFieldColors4, f8, f9, composerStartRestartGroup, (i12 & 458752) | ((i4 >> 3) & 7168) | (i4 & 126) | (57344 & i12));
                Modifier modifier6 = modifier4;
                Shape shape7 = shape5;
                final Object stateM437animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(textFieldColors4.m4400containerColorXeAY9LY(z, z2, zBooleanValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                composer2 = composerStartRestartGroup;
                BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier6, stateM5104animateBorderStrokeAsStateNuRrP5Q2.getValue(), shape7), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM437animateColorAsStateeuL9pac2) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), shape7), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f5 = f8;
                f6 = f9;
                shape3 = shape7;
                textFieldColors3 = textFieldColors4;
                modifier3 = modifier6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                textFieldColors3 = textFieldColors2;
                shape3 = shape2;
                f5 = f3;
                f6 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.Container_4EFweAY$lambda$0(this.f$0, z, z2, interactionSource, modifier3, textFieldColors3, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                textFieldColors2 = textFieldColors;
                if (composerStartRestartGroup.changed(textFieldColors2)) {
                }
                i3 |= i7;
            } else {
                textFieldColors2 = textFieldColors;
            }
            i3 |= i7;
        } else {
            textFieldColors2 = textFieldColors;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            i3 |= i8;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                }
                i3 |= i9;
            } else {
                f3 = f;
            }
            i3 |= i9;
        } else {
            f3 = f;
        }
        if ((12582912 & i) == 0) {
            if ((i2 & 128) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                }
                i3 |= i10;
            } else {
                f4 = f2;
            }
            i3 |= i10;
        } else {
            f4 = f2;
        }
        if ((100663296 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i5 = 67108864;
            } else {
                i5 = 33554432;
            }
            i3 |= i5;
        }
        if ((38347923 & i3) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1027@53974L8,1028@54033L5");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors2;
                }
                if ((i2 & 32) != 0) {
                    shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 64) != 0) {
                    f7 = FocusedBorderThickness;
                    i3 &= -3670017;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    shape5 = shape4;
                    f9 = UnfocusedBorderThickness;
                    modifier4 = companion;
                    i4 = i3 & (-29360129);
                    textFieldColors4 = textFieldColorsColors;
                    f8 = f7;
                } else {
                    modifier4 = companion;
                    i4 = i3;
                    textFieldColors4 = textFieldColorsColors;
                    shape5 = shape4;
                    f8 = f7;
                    f9 = f4;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors2;
                }
                if ((i2 & 32) != 0) {
                    shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 64) != 0) {
                    f7 = FocusedBorderThickness;
                    i3 &= -3670017;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    shape5 = shape4;
                    f9 = UnfocusedBorderThickness;
                    modifier4 = companion;
                    i4 = i3 & (-29360129);
                    textFieldColors4 = textFieldColorsColors;
                    f8 = f7;
                } else {
                    modifier4 = companion;
                    i4 = i3;
                    textFieldColors4 = textFieldColorsColors;
                    shape5 = shape4;
                    f8 = f7;
                    f9 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035477640, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1031)");
            }
            int i13 = i4 >> 6;
            boolean zBooleanValue3 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, i13 & 14).getValue().booleanValue();
            State<BorderStroke> stateM5104animateBorderStrokeAsStateNuRrP5Q3 = TextFieldImplKt.m5104animateBorderStrokeAsStateNuRrP5Q(z, z2, zBooleanValue3, textFieldColors4, f8, f9, composerStartRestartGroup, (i13 & 458752) | ((i4 >> 3) & 7168) | (i4 & 126) | (57344 & i13));
            Modifier modifier7 = modifier4;
            Shape shape8 = shape5;
            final Object stateM437animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(textFieldColors4.m4400containerColorXeAY9LY(z, z2, zBooleanValue3), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
            composer2 = composerStartRestartGroup;
            BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier7, stateM5104animateBorderStrokeAsStateNuRrP5Q3.getValue(), shape8), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM437animateColorAsStateeuL9pac3) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            }), shape8), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f5 = f8;
            f6 = f9;
            shape3 = shape8;
            textFieldColors3 = textFieldColors4;
            modifier3 = modifier7;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            textFieldColors3 = textFieldColors2;
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldDefaults.Container_4EFweAY$lambda$0(this.f$0, z, z2, interactionSource, modifier3, textFieldColors3, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1140@60463L5,1134@60233L384:TextFieldDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-896270173, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1134)");
            }
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = INSTANCE;
            outlinedTextFieldDefaults.m3947Container4EFweAY(z, z2, interactionSource, Modifier.INSTANCE, textFieldColors, outlinedTextFieldDefaults.getShape(composer, 6), FocusedBorderThickness, UnfocusedBorderThickness, composer, 114822144, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0143  */
    /* JADX WARN: Code duplicated, block: B:103:0x0148  */
    /* JADX WARN: Code duplicated, block: B:105:0x014c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0156  */
    /* JADX WARN: Code duplicated, block: B:108:0x0159  */
    /* JADX WARN: Code duplicated, block: B:110:0x015e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0168  */
    /* JADX WARN: Code duplicated, block: B:114:0x016b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0171  */
    /* JADX WARN: Code duplicated, block: B:118:0x0179  */
    /* JADX WARN: Code duplicated, block: B:120:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x018a  */
    /* JADX WARN: Code duplicated, block: B:124:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0195  */
    /* JADX WARN: Code duplicated, block: B:129:0x019e  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:136:0x01af  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:149:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01de  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:164:0x0200  */
    /* JADX WARN: Code duplicated, block: B:166:0x0206  */
    /* JADX WARN: Code duplicated, block: B:167:0x0209  */
    /* JADX WARN: Code duplicated, block: B:171:0x021b  */
    /* JADX WARN: Code duplicated, block: B:175:0x0229  */
    /* JADX WARN: Code duplicated, block: B:178:0x0232  */
    /* JADX WARN: Code duplicated, block: B:180:0x023e  */
    /* JADX WARN: Code duplicated, block: B:190:0x0277 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x0279  */
    /* JADX WARN: Code duplicated, block: B:193:0x027d  */
    /* JADX WARN: Code duplicated, block: B:194:0x027f  */
    /* JADX WARN: Code duplicated, block: B:196:0x0283  */
    /* JADX WARN: Code duplicated, block: B:197:0x0285  */
    /* JADX WARN: Code duplicated, block: B:199:0x0289  */
    /* JADX WARN: Code duplicated, block: B:200:0x028b  */
    /* JADX WARN: Code duplicated, block: B:202:0x028f  */
    /* JADX WARN: Code duplicated, block: B:203:0x0292  */
    /* JADX WARN: Code duplicated, block: B:205:0x0296  */
    /* JADX WARN: Code duplicated, block: B:206:0x0299  */
    /* JADX WARN: Code duplicated, block: B:208:0x029d  */
    /* JADX WARN: Code duplicated, block: B:209:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:211:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:212:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:215:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:216:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:219:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:220:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:222:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:223:0x0310  */
    /* JADX WARN: Code duplicated, block: B:227:0x0334  */
    /* JADX WARN: Code duplicated, block: B:230:0x0349  */
    /* JADX WARN: Code duplicated, block: B:231:0x034b  */
    /* JADX WARN: Code duplicated, block: B:234:0x0356  */
    /* JADX WARN: Code duplicated, block: B:235:0x0358  */
    /* JADX WARN: Code duplicated, block: B:238:0x0360  */
    /* JADX WARN: Code duplicated, block: B:242:0x036b  */
    /* JADX WARN: Code duplicated, block: B:245:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:246:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:249:0x0447  */
    /* JADX WARN: Code duplicated, block: B:251:0x045b  */
    /* JADX WARN: Code duplicated, block: B:254:0x047b  */
    /* JADX WARN: Code duplicated, block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:83:0x0100  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code duplicated, block: B:91:0x011a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0123  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:96:0x0131  */
    /* JADX WARN: Code duplicated, block: B:97:0x0134  */
    /* JADX WARN: Code duplicated, block: B:99:0x0139  */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, Function2<? super Composer, ? super Integer, Unit> function9, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function10, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z5;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function17;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        final TextFieldColors textFieldColorsColors;
        PaddingValues paddingValuesM3946contentPaddinga9UjIt4$default;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        boolean z7;
        TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        PaddingValues paddingValues3;
        boolean z8;
        boolean z9;
        boolean z10;
        Object objRememberedValue;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i19;
        int i20;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1732281618);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,colors,contentPadding,container)1147@60674L129,1153@60857L751:TextFieldDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        int i21 = 8192;
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i22 = i3 & 64;
        if (i22 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i23 = i3 & 128;
        if (i23 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i24 = i3 & 256;
        if (i24 == 0) {
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
            }
            i5 = i3 & 512;
            if (i5 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i6 = 268435456;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 1024;
                if (i7 != 0) {
                    i8 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 4;
                    } else {
                        i9 = 2;
                    }
                    i8 = i2 | i9;
                } else {
                    i8 = i2;
                }
                i10 = i3 & 2048;
                if (i10 != 0) {
                    i8 |= 48;
                } else if ((i2 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i11 = 32;
                    } else {
                        i11 = 16;
                    }
                    i8 |= i11;
                }
                i12 = i8;
                i13 = i3 & 4096;
                if (i13 != 0) {
                    i14 = i12 | 384;
                } else if ((i2 & 384) == 0) {
                    i14 = i12 | (composerStartRestartGroup.changedInstance(function8) ? 256 : 128);
                } else {
                    i14 = i12;
                }
                i15 = i3 & 8192;
                if (i15 != 0) {
                    i16 = i14;
                    if ((i2 & 3072) == 0) {
                        i16 |= composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(textFieldColors)) {
                            i21 = 16384;
                        }
                        i16 |= i21;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i3 & 32768) == 0 || !composerStartRestartGroup.changed(paddingValues)) {
                            i20 = 65536;
                        } else {
                            i20 = 131072;
                        }
                        i16 |= i20;
                    }
                    i17 = i3 & 65536;
                    if (i17 != 0) {
                        i16 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i18 = 1048576;
                        } else {
                            i18 = 524288;
                        }
                        i16 |= i18;
                    }
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i19 = 8388608;
                        } else {
                            i19 = 4194304;
                        }
                        i16 |= i19;
                    }
                    if ((i4 & 306783379) == 306783378 || (i16 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i22 != 0) {
                                z4 = false;
                            }
                            if (i23 != 0) {
                                function19 = null;
                            } else {
                                function19 = function3;
                            }
                            if (i24 != 0) {
                                function20 = null;
                            } else {
                                function20 = function4;
                            }
                            if (i5 != 0) {
                                function21 = null;
                            } else {
                                function21 = function5;
                            }
                            if (i7 != 0) {
                                function22 = null;
                            } else {
                                function22 = function6;
                            }
                            if (i10 != 0) {
                                function23 = null;
                            } else {
                                function23 = function7;
                            }
                            if (i13 != 0) {
                                function24 = null;
                            } else {
                                function24 = function8;
                            }
                            if (i15 != 0) {
                                function25 = null;
                            } else {
                                function25 = function9;
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                                i16 &= -57345;
                            } else {
                                textFieldColorsColors = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i16 &= -458753;
                            } else {
                                paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i17 != 0) {
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                function26 = function19;
                            } else {
                                function26 = function19;
                                function2RememberComposableLambda = function10;
                            }
                            z7 = z4;
                            textFieldColors3 = textFieldColorsColors;
                            function27 = function23;
                            paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16384) != 0) {
                                i16 &= -57345;
                            }
                            if ((i3 & 32768) != 0) {
                                i16 &= -458753;
                            }
                            function26 = function3;
                            function20 = function4;
                            function21 = function5;
                            function22 = function6;
                            function24 = function8;
                            function25 = function9;
                            paddingValues3 = paddingValues;
                            function2RememberComposableLambda = function10;
                            z7 = z4;
                            i16 = i16;
                            function27 = function7;
                            textFieldColors3 = textFieldColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        int i25 = i16;
                        if ((57344 & i4) == 16384) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        z10 = z9 | z8;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String text = ((TransformedText) objRememberedValue).getText().getText();
                        TextFieldType textFieldType = TextFieldType.Outlined;
                        TextFieldLabelPosition.Attached attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                        if (function26 == null) {
                            composerStartRestartGroup.startReplaceGroup(1927042940);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1927042941);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        int i26 = i4 >> 9;
                        int i27 = i25 << 21;
                        int i28 = ((i4 << 3) & 896) | 6 | (i26 & 458752) | (i26 & 3670016) | (i27 & 29360128) | (i27 & 234881024) | (i27 & C.ENCODING_PCM_DOUBLE);
                        int i29 = ((i25 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i26 & 7168) | (57344 & (i4 >> 3)) | (i25 & 458752) | ((i25 << 6) & 3670016) | (29360128 & (i25 << 3));
                        composer2 = composerStartRestartGroup;
                        Function2<? super Composer, ? super Integer, Unit> function28 = function20;
                        Function2<? super Composer, ? super Integer, Unit> function29 = function21;
                        Function2<? super Composer, ? super Integer, Unit> function30 = function22;
                        TextFieldImplKt.CommonDecorationBox(textFieldType, text, function2, attached, composableLambdaRememberComposableLambda, function28, function29, function30, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i28, i29);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function15 = function24;
                        function16 = function25;
                        paddingValues2 = paddingValues3;
                        function17 = function2RememberComposableLambda;
                        function13 = function30;
                        function14 = function27;
                        function12 = function28;
                        function18 = function29;
                        z6 = z7;
                        textFieldColors2 = textFieldColors3;
                        function11 = function26;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function11 = function3;
                        function12 = function4;
                        function13 = function6;
                        function14 = function7;
                        function15 = function8;
                        function16 = function9;
                        textFieldColors2 = textFieldColors;
                        paddingValues2 = paddingValues;
                        function17 = function10;
                        z6 = z4;
                        function18 = function5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i16 = i14 | 3072;
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i21 = 16384;
                    }
                    i16 |= i21;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i20 = 65536;
                    } else {
                        i20 = 65536;
                    }
                    i16 |= i20;
                }
                i17 = i3 & 65536;
                if (i17 != 0) {
                    i16 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i16 |= i18;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i16 |= i19;
                }
                if ((i4 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    } else {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                    if ((i4 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    int i210 = i16;
                    if ((57344 & i4) == 16384) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z10 = z9 | z8;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String text2 = ((TransformedText) objRememberedValue).getText().getText();
                    TextFieldType textFieldType2 = TextFieldType.Outlined;
                    TextFieldLabelPosition.Attached attached2 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                    if (function26 == null) {
                        composerStartRestartGroup.startReplaceGroup(1927042940);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1927042941);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i211 = i4 >> 9;
                    int i212 = i210 << 21;
                    int i213 = ((i4 << 3) & 896) | 6 | (i211 & 458752) | (i211 & 3670016) | (i212 & 29360128) | (i212 & 234881024) | (i212 & C.ENCODING_PCM_DOUBLE);
                    int i214 = ((i210 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i211 & 7168) | (57344 & (i4 >> 3)) | (i210 & 458752) | ((i210 << 6) & 3670016) | (29360128 & (i210 << 3));
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function210 = function20;
                    Function2<? super Composer, ? super Integer, Unit> function211 = function21;
                    Function2<? super Composer, ? super Integer, Unit> function31 = function22;
                    TextFieldImplKt.CommonDecorationBox(textFieldType2, text2, function2, attached2, composableLambdaRememberComposableLambda, function210, function211, function31, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i213, i214);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function15 = function24;
                    function16 = function25;
                    paddingValues2 = paddingValues3;
                    function17 = function2RememberComposableLambda;
                    function13 = function31;
                    function14 = function27;
                    function12 = function210;
                    function18 = function211;
                    z6 = z7;
                    textFieldColors2 = textFieldColors3;
                    function11 = function26;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function11 = function3;
                    function12 = function4;
                    function13 = function6;
                    function14 = function7;
                    function15 = function8;
                    function16 = function9;
                    textFieldColors2 = textFieldColors;
                    paddingValues2 = paddingValues;
                    function17 = function10;
                    z6 = z4;
                    function18 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i7 = i3 & 1024;
            if (i7 != 0) {
                i8 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 4;
                } else {
                    i9 = 2;
                }
                i8 = i2 | i9;
            } else {
                i8 = i2;
            }
            i10 = i3 & 2048;
            if (i10 != 0) {
                i8 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i11 = 32;
                } else {
                    i11 = 16;
                }
                i8 |= i11;
            }
            i12 = i8;
            i13 = i3 & 4096;
            if (i13 != 0) {
                i14 = i12 | 384;
            } else if ((i2 & 384) == 0) {
                i14 = i12 | (composerStartRestartGroup.changedInstance(function8) ? 256 : 128);
            } else {
                i14 = i12;
            }
            i15 = i3 & 8192;
            if (i15 != 0) {
                i16 = i14;
                if ((i2 & 3072) == 0) {
                    i16 |= composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i21 = 16384;
                    }
                    i16 |= i21;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i20 = 65536;
                    } else {
                        i20 = 65536;
                    }
                    i16 |= i20;
                }
                i17 = i3 & 65536;
                if (i17 != 0) {
                    i16 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i16 |= i18;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i16 |= i19;
                }
                if ((i4 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    } else {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                    if ((i4 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    int i215 = i16;
                    if ((57344 & i4) == 16384) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z10 = z9 | z8;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String text3 = ((TransformedText) objRememberedValue).getText().getText();
                    TextFieldType textFieldType3 = TextFieldType.Outlined;
                    TextFieldLabelPosition.Attached attached3 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                    if (function26 == null) {
                        composerStartRestartGroup.startReplaceGroup(1927042940);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1927042941);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i216 = i4 >> 9;
                    int i217 = i215 << 21;
                    int i218 = ((i4 << 3) & 896) | 6 | (i216 & 458752) | (i216 & 3670016) | (i217 & 29360128) | (i217 & 234881024) | (i217 & C.ENCODING_PCM_DOUBLE);
                    int i219 = ((i215 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i216 & 7168) | (57344 & (i4 >> 3)) | (i215 & 458752) | ((i215 << 6) & 3670016) | (29360128 & (i215 << 3));
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function212 = function20;
                    Function2<? super Composer, ? super Integer, Unit> function213 = function21;
                    Function2<? super Composer, ? super Integer, Unit> function32 = function22;
                    TextFieldImplKt.CommonDecorationBox(textFieldType3, text3, function2, attached3, composableLambdaRememberComposableLambda, function212, function213, function32, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i218, i219);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function15 = function24;
                    function16 = function25;
                    paddingValues2 = paddingValues3;
                    function17 = function2RememberComposableLambda;
                    function13 = function32;
                    function14 = function27;
                    function12 = function212;
                    function18 = function213;
                    z6 = z7;
                    textFieldColors2 = textFieldColors3;
                    function11 = function26;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function11 = function3;
                    function12 = function4;
                    function13 = function6;
                    function14 = function7;
                    function15 = function8;
                    function16 = function9;
                    textFieldColors2 = textFieldColors;
                    paddingValues2 = paddingValues;
                    function17 = function10;
                    z6 = z4;
                    function18 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i16 = i14 | 3072;
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i21 = 16384;
                }
                i16 |= i21;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i20 = 65536;
                } else {
                    i20 = 65536;
                }
                i16 |= i20;
            }
            i17 = i3 & 65536;
            if (i17 != 0) {
                i16 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i18 = 1048576;
                } else {
                    i18 = 524288;
                }
                i16 |= i18;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i16 |= i19;
            }
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                } else {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i2110 = i16;
                if ((57344 & i4) == 16384) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z9 | z8;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String text4 = ((TransformedText) objRememberedValue).getText().getText();
                TextFieldType textFieldType4 = TextFieldType.Outlined;
                TextFieldLabelPosition.Attached attached4 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                if (function26 == null) {
                    composerStartRestartGroup.startReplaceGroup(1927042940);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1927042941);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i2111 = i4 >> 9;
                int i2112 = i2110 << 21;
                int i2113 = ((i4 << 3) & 896) | 6 | (i2111 & 458752) | (i2111 & 3670016) | (i2112 & 29360128) | (i2112 & 234881024) | (i2112 & C.ENCODING_PCM_DOUBLE);
                int i2114 = ((i2110 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i2111 & 7168) | (57344 & (i4 >> 3)) | (i2110 & 458752) | ((i2110 << 6) & 3670016) | (29360128 & (i2110 << 3));
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function214 = function20;
                Function2<? super Composer, ? super Integer, Unit> function215 = function21;
                Function2<? super Composer, ? super Integer, Unit> function33 = function22;
                TextFieldImplKt.CommonDecorationBox(textFieldType4, text4, function2, attached4, composableLambdaRememberComposableLambda, function214, function215, function33, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i2113, i2114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function15 = function24;
                function16 = function25;
                paddingValues2 = paddingValues3;
                function17 = function2RememberComposableLambda;
                function13 = function33;
                function14 = function27;
                function12 = function214;
                function18 = function215;
                z6 = z7;
                textFieldColors2 = textFieldColors3;
                function11 = function26;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function11 = function3;
                function12 = function4;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                function16 = function9;
                textFieldColors2 = textFieldColors;
                paddingValues2 = paddingValues;
                function17 = function10;
                z6 = z4;
                function18 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        i5 = i3 & 512;
        if (i5 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i6 = 268435456;
                }
                i4 |= i6;
            }
            i7 = i3 & 1024;
            if (i7 != 0) {
                i8 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 4;
                } else {
                    i9 = 2;
                }
                i8 = i2 | i9;
            } else {
                i8 = i2;
            }
            i10 = i3 & 2048;
            if (i10 != 0) {
                i8 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i11 = 32;
                } else {
                    i11 = 16;
                }
                i8 |= i11;
            }
            i12 = i8;
            i13 = i3 & 4096;
            if (i13 != 0) {
                i14 = i12 | 384;
            } else if ((i2 & 384) == 0) {
                i14 = i12 | (composerStartRestartGroup.changedInstance(function8) ? 256 : 128);
            } else {
                i14 = i12;
            }
            i15 = i3 & 8192;
            if (i15 != 0) {
                i16 = i14;
                if ((i2 & 3072) == 0) {
                    i16 |= composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i21 = 16384;
                    }
                    i16 |= i21;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i20 = 65536;
                    } else {
                        i20 = 65536;
                    }
                    i16 |= i20;
                }
                i17 = i3 & 65536;
                if (i17 != 0) {
                    i16 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i18 = 1048576;
                    } else {
                        i18 = 524288;
                    }
                    i16 |= i18;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i16 |= i19;
                }
                if ((i4 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    } else {
                        if (i22 != 0) {
                            z4 = false;
                        }
                        if (i23 != 0) {
                            function19 = null;
                        } else {
                            function19 = function3;
                        }
                        if (i24 != 0) {
                            function20 = null;
                        } else {
                            function20 = function4;
                        }
                        if (i5 != 0) {
                            function21 = null;
                        } else {
                            function21 = function5;
                        }
                        if (i7 != 0) {
                            function22 = null;
                        } else {
                            function22 = function6;
                        }
                        if (i10 != 0) {
                            function23 = null;
                        } else {
                            function23 = function7;
                        }
                        if (i13 != 0) {
                            function24 = null;
                        } else {
                            function24 = function8;
                        }
                        if (i15 != 0) {
                            function25 = null;
                        } else {
                            function25 = function9;
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                            i16 &= -57345;
                        } else {
                            textFieldColorsColors = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i16 &= -458753;
                        } else {
                            paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i17 != 0) {
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            function26 = function19;
                        } else {
                            function26 = function19;
                            function2RememberComposableLambda = function10;
                        }
                        z7 = z4;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function23;
                        paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                    if ((i4 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    int i2115 = i16;
                    if ((57344 & i4) == 16384) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z10 = z9 | z8;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String text5 = ((TransformedText) objRememberedValue).getText().getText();
                    TextFieldType textFieldType5 = TextFieldType.Outlined;
                    TextFieldLabelPosition.Attached attached5 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                    if (function26 == null) {
                        composerStartRestartGroup.startReplaceGroup(1927042940);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1927042941);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i2116 = i4 >> 9;
                    int i2117 = i2115 << 21;
                    int i2118 = ((i4 << 3) & 896) | 6 | (i2116 & 458752) | (i2116 & 3670016) | (i2117 & 29360128) | (i2117 & 234881024) | (i2117 & C.ENCODING_PCM_DOUBLE);
                    int i2119 = ((i2115 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i2116 & 7168) | (57344 & (i4 >> 3)) | (i2115 & 458752) | ((i2115 << 6) & 3670016) | (29360128 & (i2115 << 3));
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function216 = function20;
                    Function2<? super Composer, ? super Integer, Unit> function217 = function21;
                    Function2<? super Composer, ? super Integer, Unit> function34 = function22;
                    TextFieldImplKt.CommonDecorationBox(textFieldType5, text5, function2, attached5, composableLambdaRememberComposableLambda, function216, function217, function34, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i2118, i2119);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function15 = function24;
                    function16 = function25;
                    paddingValues2 = paddingValues3;
                    function17 = function2RememberComposableLambda;
                    function13 = function34;
                    function14 = function27;
                    function12 = function216;
                    function18 = function217;
                    z6 = z7;
                    textFieldColors2 = textFieldColors3;
                    function11 = function26;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function11 = function3;
                    function12 = function4;
                    function13 = function6;
                    function14 = function7;
                    function15 = function8;
                    function16 = function9;
                    textFieldColors2 = textFieldColors;
                    paddingValues2 = paddingValues;
                    function17 = function10;
                    z6 = z4;
                    function18 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i16 = i14 | 3072;
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i21 = 16384;
                }
                i16 |= i21;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i20 = 65536;
                } else {
                    i20 = 65536;
                }
                i16 |= i20;
            }
            i17 = i3 & 65536;
            if (i17 != 0) {
                i16 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i18 = 1048576;
                } else {
                    i18 = 524288;
                }
                i16 |= i18;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i16 |= i19;
            }
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                } else {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i21110 = i16;
                if ((57344 & i4) == 16384) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z9 | z8;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String text6 = ((TransformedText) objRememberedValue).getText().getText();
                TextFieldType textFieldType6 = TextFieldType.Outlined;
                TextFieldLabelPosition.Attached attached6 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                if (function26 == null) {
                    composerStartRestartGroup.startReplaceGroup(1927042940);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1927042941);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i21111 = i4 >> 9;
                int i21112 = i21110 << 21;
                int i21113 = ((i4 << 3) & 896) | 6 | (i21111 & 458752) | (i21111 & 3670016) | (i21112 & 29360128) | (i21112 & 234881024) | (i21112 & C.ENCODING_PCM_DOUBLE);
                int i21114 = ((i21110 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i21111 & 7168) | (57344 & (i4 >> 3)) | (i21110 & 458752) | ((i21110 << 6) & 3670016) | (29360128 & (i21110 << 3));
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function218 = function20;
                Function2<? super Composer, ? super Integer, Unit> function219 = function21;
                Function2<? super Composer, ? super Integer, Unit> function35 = function22;
                TextFieldImplKt.CommonDecorationBox(textFieldType6, text6, function2, attached6, composableLambdaRememberComposableLambda, function218, function219, function35, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i21113, i21114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function15 = function24;
                function16 = function25;
                paddingValues2 = paddingValues3;
                function17 = function2RememberComposableLambda;
                function13 = function35;
                function14 = function27;
                function12 = function218;
                function18 = function219;
                z6 = z7;
                textFieldColors2 = textFieldColors3;
                function11 = function26;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function11 = function3;
                function12 = function4;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                function16 = function9;
                textFieldColors2 = textFieldColors;
                paddingValues2 = paddingValues;
                function17 = function10;
                z6 = z4;
                function18 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i7 = i3 & 1024;
        if (i7 != 0) {
            i8 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i8 = i2 | i9;
        } else {
            i8 = i2;
        }
        i10 = i3 & 2048;
        if (i10 != 0) {
            i8 |= 48;
        } else if ((i2 & 48) != 0) {
            if (composerStartRestartGroup.changedInstance(function7)) {
                i11 = 32;
            } else {
                i11 = 16;
            }
            i8 |= i11;
        }
        i12 = i8;
        i13 = i3 & 4096;
        if (i13 != 0) {
            i14 = i12 | 384;
        } else if ((i2 & 384) == 0) {
            i14 = i12 | (composerStartRestartGroup.changedInstance(function8) ? 256 : 128);
        } else {
            i14 = i12;
        }
        i15 = i3 & 8192;
        if (i15 != 0) {
            i16 = i14;
            if ((i2 & 3072) == 0) {
                i16 |= composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i21 = 16384;
                }
                i16 |= i21;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i20 = 65536;
                } else {
                    i20 = 65536;
                }
                i16 |= i20;
            }
            i17 = i3 & 65536;
            if (i17 != 0) {
                i16 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i18 = 1048576;
                } else {
                    i18 = 524288;
                }
                i16 |= i18;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i16 |= i19;
            }
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                } else {
                    if (i22 != 0) {
                        z4 = false;
                    }
                    if (i23 != 0) {
                        function19 = null;
                    } else {
                        function19 = function3;
                    }
                    if (i24 != 0) {
                        function20 = null;
                    } else {
                        function20 = function4;
                    }
                    if (i5 != 0) {
                        function21 = null;
                    } else {
                        function21 = function5;
                    }
                    if (i7 != 0) {
                        function22 = null;
                    } else {
                        function22 = function6;
                    }
                    if (i10 != 0) {
                        function23 = null;
                    } else {
                        function23 = function7;
                    }
                    if (i13 != 0) {
                        function24 = null;
                    } else {
                        function24 = function8;
                    }
                    if (i15 != 0) {
                        function25 = null;
                    } else {
                        function25 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                        i16 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i16 &= -458753;
                    } else {
                        paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        function26 = function19;
                    } else {
                        function26 = function19;
                        function2RememberComposableLambda = function10;
                    }
                    z7 = z4;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function23;
                    paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i21115 = i16;
                if ((57344 & i4) == 16384) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z9 | z8;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String text7 = ((TransformedText) objRememberedValue).getText().getText();
                TextFieldType textFieldType7 = TextFieldType.Outlined;
                TextFieldLabelPosition.Attached attached7 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                if (function26 == null) {
                    composerStartRestartGroup.startReplaceGroup(1927042940);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1927042941);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i21116 = i4 >> 9;
                int i21117 = i21115 << 21;
                int i21118 = ((i4 << 3) & 896) | 6 | (i21116 & 458752) | (i21116 & 3670016) | (i21117 & 29360128) | (i21117 & 234881024) | (i21117 & C.ENCODING_PCM_DOUBLE);
                int i21119 = ((i21115 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i21116 & 7168) | (57344 & (i4 >> 3)) | (i21115 & 458752) | ((i21115 << 6) & 3670016) | (29360128 & (i21115 << 3));
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function2110 = function20;
                Function2<? super Composer, ? super Integer, Unit> function2111 = function21;
                Function2<? super Composer, ? super Integer, Unit> function36 = function22;
                TextFieldImplKt.CommonDecorationBox(textFieldType7, text7, function2, attached7, composableLambdaRememberComposableLambda, function2110, function2111, function36, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i21118, i21119);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function15 = function24;
                function16 = function25;
                paddingValues2 = paddingValues3;
                function17 = function2RememberComposableLambda;
                function13 = function36;
                function14 = function27;
                function12 = function2110;
                function18 = function2111;
                z6 = z7;
                textFieldColors2 = textFieldColors3;
                function11 = function26;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function11 = function3;
                function12 = function4;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                function16 = function9;
                textFieldColors2 = textFieldColors;
                paddingValues2 = paddingValues;
                function17 = function10;
                z6 = z4;
                function18 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i16 = i14 | 3072;
        if ((i2 & 24576) != 0) {
            if ((i3 & 16384) == 0) {
                i21 = 16384;
            }
            i16 |= i21;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i3 & 32768) == 0) {
                i20 = 65536;
            } else {
                i20 = 65536;
            }
            i16 |= i20;
        }
        i17 = i3 & 65536;
        if (i17 != 0) {
            i16 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function10)) {
                i18 = 1048576;
            } else {
                i18 = 524288;
            }
            i16 |= i18;
        }
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i19 = 8388608;
            } else {
                i19 = 4194304;
            }
            i16 |= i19;
        }
        if ((i4 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1131@60107L8,1133@60219L408");
            if ((i & 1) != 0) {
                if (i22 != 0) {
                    z4 = false;
                }
                if (i23 != 0) {
                    function19 = null;
                } else {
                    function19 = function3;
                }
                if (i24 != 0) {
                    function20 = null;
                } else {
                    function20 = function4;
                }
                if (i5 != 0) {
                    function21 = null;
                } else {
                    function21 = function5;
                }
                if (i7 != 0) {
                    function22 = null;
                } else {
                    function22 = function6;
                }
                if (i10 != 0) {
                    function23 = null;
                } else {
                    function23 = function7;
                }
                if (i13 != 0) {
                    function24 = null;
                } else {
                    function24 = function8;
                }
                if (i15 != 0) {
                    function25 = null;
                } else {
                    function25 = function9;
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                    i16 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i16 &= -458753;
                } else {
                    paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                }
                if (i17 != 0) {
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    function26 = function19;
                } else {
                    function26 = function19;
                    function2RememberComposableLambda = function10;
                }
                z7 = z4;
                textFieldColors3 = textFieldColorsColors;
                function27 = function23;
                paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
            } else {
                if (i22 != 0) {
                    z4 = false;
                }
                if (i23 != 0) {
                    function19 = null;
                } else {
                    function19 = function3;
                }
                if (i24 != 0) {
                    function20 = null;
                } else {
                    function20 = function4;
                }
                if (i5 != 0) {
                    function21 = null;
                } else {
                    function21 = function5;
                }
                if (i7 != 0) {
                    function22 = null;
                } else {
                    function22 = function6;
                }
                if (i10 != 0) {
                    function23 = null;
                } else {
                    function23 = function7;
                }
                if (i13 != 0) {
                    function24 = null;
                } else {
                    function24 = function8;
                }
                if (i15 != 0) {
                    function25 = null;
                } else {
                    function25 = function9;
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 21) & 14);
                    i16 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM3946contentPaddinga9UjIt4$default = m3946contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i16 &= -458753;
                } else {
                    paddingValuesM3946contentPaddinga9UjIt4$default = paddingValues;
                }
                if (i17 != 0) {
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.DecorationBox$lambda$0(z, z4, interactionSource, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    function26 = function19;
                } else {
                    function26 = function19;
                    function2RememberComposableLambda = function10;
                }
                z7 = z4;
                textFieldColors3 = textFieldColorsColors;
                function27 = function23;
                paddingValues3 = paddingValuesM3946contentPaddinga9UjIt4$default;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1732281618, i4, i16, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1145)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716111, "CC(remember):TextFieldDefaults.kt#9igjgp");
            if ((i4 & 14) == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            int i211110 = i16;
            if ((57344 & i4) == 16384) {
                z9 = true;
            } else {
                z9 = false;
            }
            z10 = z9 | z8;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String text8 = ((TransformedText) objRememberedValue).getText().getText();
            TextFieldType textFieldType8 = TextFieldType.Outlined;
            TextFieldLabelPosition.Attached attached8 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
            if (function26 == null) {
                composerStartRestartGroup.startReplaceGroup(1927042940);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1927042941);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*1159@61138L15");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OutlinedTextFieldDefaults.DecorationBox$lambda$2$0(function26, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            int i211111 = i4 >> 9;
            int i211112 = i211110 << 21;
            int i211113 = ((i4 << 3) & 896) | 6 | (i211111 & 458752) | (i211111 & 3670016) | (i211112 & 29360128) | (i211112 & 234881024) | (i211112 & C.ENCODING_PCM_DOUBLE);
            int i211114 = ((i211110 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i211111 & 7168) | (57344 & (i4 >> 3)) | (i211110 & 458752) | ((i211110 << 6) & 3670016) | (29360128 & (i211110 << 3));
            composer2 = composerStartRestartGroup;
            Function2<? super Composer, ? super Integer, Unit> function2112 = function20;
            Function2<? super Composer, ? super Integer, Unit> function2113 = function21;
            Function2<? super Composer, ? super Integer, Unit> function37 = function22;
            TextFieldImplKt.CommonDecorationBox(textFieldType8, text8, function2, attached8, composableLambdaRememberComposableLambda, function2112, function2113, function37, function27, function24, function25, z2, z, z7, interactionSource, paddingValues3, textFieldColors3, function2RememberComposableLambda, composer2, i211113, i211114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function15 = function24;
            function16 = function25;
            paddingValues2 = paddingValues3;
            function17 = function2RememberComposableLambda;
            function13 = function37;
            function14 = function27;
            function12 = function2112;
            function18 = function2113;
            z6 = z7;
            textFieldColors2 = textFieldColors3;
            function11 = function26;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function11 = function3;
            function12 = function4;
            function13 = function6;
            function14 = function7;
            function15 = function8;
            function16 = function9;
            textFieldColors2 = textFieldColors;
            paddingValues2 = paddingValues;
            function17 = function10;
            z6 = z4;
            function18 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function11, function12, function18, function13, function14, function15, function16, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$2$0(Function2 function2, TextFieldLabelScope textFieldLabelScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1159@61143L8:TextFieldDefaults.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459717586, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous>.<anonymous> (TextFieldDefaults.kt:1159)");
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

    /* JADX INFO: renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3946contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m3950contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3950contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -471651810, "C(colors)1192@62395L11,1192@62407L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1192)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedTextFieldColors;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m3949colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        ComposerKt.sourceInformationMarkerStart(composer, 1767617725, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)1294@69218L11,1294@69230L30:TextFieldDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i6 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i6 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i6 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i6 & 1024) != 0 ? null : textSelectionColors;
        long jM6850getUnspecified0d7_KjU11 = (i6 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        long jM6850getUnspecified0d7_KjU12 = (i6 & 4096) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j12;
        long jM6850getUnspecified0d7_KjU13 = (i6 & 8192) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j13;
        long jM6850getUnspecified0d7_KjU14 = (i6 & 16384) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j14;
        long jM6850getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j15;
        long jM6850getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j16;
        long jM6850getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j17;
        long jM6850getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j18;
        long jM6850getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j19;
        long jM6850getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j20;
        long jM6850getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j21;
        long jM6850getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j22;
        long jM6850getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j23;
        long jM6850getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j24;
        long jM6850getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j25;
        long jM6850getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j26;
        long jM6850getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j27;
        long jM6850getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j28;
        long jM6850getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j29;
        long jM6850getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j30;
        long jM6850getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j31;
        long jM6850getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j32;
        long jM6850getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j33;
        long jM6850getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j34;
        long jM6850getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j35;
        long jM6850getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j36;
        long jM6850getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j37;
        long jM6850getUnspecified0d7_KjU38 = (i7 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j38;
        long jM6850getUnspecified0d7_KjU39 = (i7 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j39;
        long jM6850getUnspecified0d7_KjU40 = (i7 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j40;
        long jM6850getUnspecified0d7_KjU41 = (i7 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j41;
        long jM6850getUnspecified0d7_KjU42 = (i7 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1294)");
        }
        TextFieldColors textFieldColorsM4401copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m4401copyejIjP34(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, textSelectionColors2, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU14, jM6850getUnspecified0d7_KjU15, jM6850getUnspecified0d7_KjU16, jM6850getUnspecified0d7_KjU17, jM6850getUnspecified0d7_KjU18, jM6850getUnspecified0d7_KjU19, jM6850getUnspecified0d7_KjU20, jM6850getUnspecified0d7_KjU21, jM6850getUnspecified0d7_KjU22, jM6850getUnspecified0d7_KjU23, jM6850getUnspecified0d7_KjU24, jM6850getUnspecified0d7_KjU25, jM6850getUnspecified0d7_KjU26, jM6850getUnspecified0d7_KjU27, jM6850getUnspecified0d7_KjU28, jM6850getUnspecified0d7_KjU29, jM6850getUnspecified0d7_KjU30, jM6850getUnspecified0d7_KjU31, jM6850getUnspecified0d7_KjU32, jM6850getUnspecified0d7_KjU33, jM6850getUnspecified0d7_KjU34, jM6850getUnspecified0d7_KjU35, jM6850getUnspecified0d7_KjU36, jM6850getUnspecified0d7_KjU37, jM6850getUnspecified0d7_KjU38, jM6850getUnspecified0d7_KjU39, jM6850getUnspecified0d7_KjU40, jM6850getUnspecified0d7_KjU41, jM6850getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4401copyejIjP34;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        TextFieldColors textFieldColors;
        ComposerKt.sourceInformationMarkerStart(composer, -292363577, "C(<get-defaultOutlinedTextFieldColors>):TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1342)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached = colorScheme.getDefaultOutlinedTextFieldColorsCached();
        if (defaultOutlinedTextFieldColorsCached == null) {
            composer.startReplaceGroup(390452338);
            composer.endReplaceGroup();
            textFieldColors = null;
        } else {
            composer.startReplaceGroup(390452339);
            ComposerKt.sourceInformation(composer, "*1344@72025L7");
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextSelectionColors textSelectionColors = (TextSelectionColors) objConsume;
            if (!Intrinsics.areEqual(defaultOutlinedTextFieldColorsCached.getTextSelectionColors(), textSelectionColors)) {
                defaultOutlinedTextFieldColorsCached = defaultOutlinedTextFieldColorsCached.m4401copyejIjP34(((-1025) & 1) != 0 ? defaultOutlinedTextFieldColorsCached.focusedTextColor : 0L, ((-1025) & 2) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedTextColor : 0L, ((-1025) & 4) != 0 ? defaultOutlinedTextFieldColorsCached.disabledTextColor : 0L, ((-1025) & 8) != 0 ? defaultOutlinedTextFieldColorsCached.errorTextColor : 0L, ((-1025) & 16) != 0 ? defaultOutlinedTextFieldColorsCached.focusedContainerColor : 0L, ((-1025) & 32) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedContainerColor : 0L, ((-1025) & 64) != 0 ? defaultOutlinedTextFieldColorsCached.disabledContainerColor : 0L, ((-1025) & 128) != 0 ? defaultOutlinedTextFieldColorsCached.errorContainerColor : 0L, ((-1025) & 256) != 0 ? defaultOutlinedTextFieldColorsCached.cursorColor : 0L, ((-1025) & 512) != 0 ? defaultOutlinedTextFieldColorsCached.errorCursorColor : 0L, ((-1025) & 1024) != 0 ? defaultOutlinedTextFieldColorsCached.textSelectionColors : textSelectionColors, ((-1025) & 2048) != 0 ? defaultOutlinedTextFieldColorsCached.focusedIndicatorColor : 0L, ((-1025) & 4096) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedIndicatorColor : 0L, ((-1025) & 8192) != 0 ? defaultOutlinedTextFieldColorsCached.disabledIndicatorColor : 0L, ((-1025) & 16384) != 0 ? defaultOutlinedTextFieldColorsCached.errorIndicatorColor : 0L, ((-1025) & 32768) != 0 ? defaultOutlinedTextFieldColorsCached.focusedLeadingIconColor : 0L, ((-1025) & 65536) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedLeadingIconColor : 0L, ((-1025) & 131072) != 0 ? defaultOutlinedTextFieldColorsCached.disabledLeadingIconColor : 0L, ((-1025) & 262144) != 0 ? defaultOutlinedTextFieldColorsCached.errorLeadingIconColor : 0L, ((-1025) & 524288) != 0 ? defaultOutlinedTextFieldColorsCached.focusedTrailingIconColor : 0L, ((-1025) & 1048576) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedTrailingIconColor : 0L, ((-1025) & 2097152) != 0 ? defaultOutlinedTextFieldColorsCached.disabledTrailingIconColor : 0L, ((-1025) & 4194304) != 0 ? defaultOutlinedTextFieldColorsCached.errorTrailingIconColor : 0L, ((-1025) & 8388608) != 0 ? defaultOutlinedTextFieldColorsCached.focusedLabelColor : 0L, ((-1025) & 16777216) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedLabelColor : 0L, ((-1025) & 33554432) != 0 ? defaultOutlinedTextFieldColorsCached.disabledLabelColor : 0L, ((-1025) & 67108864) != 0 ? defaultOutlinedTextFieldColorsCached.errorLabelColor : 0L, ((-1025) & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? defaultOutlinedTextFieldColorsCached.focusedPlaceholderColor : 0L, ((-1025) & 268435456) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedPlaceholderColor : 0L, ((-1025) & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? defaultOutlinedTextFieldColorsCached.disabledPlaceholderColor : 0L, ((-1025) & 1073741824) != 0 ? defaultOutlinedTextFieldColorsCached.errorPlaceholderColor : 0L, ((-1025) & Integer.MIN_VALUE) != 0 ? defaultOutlinedTextFieldColorsCached.focusedSupportingTextColor : 0L, (2047 & 1) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedSupportingTextColor : 0L, (2047 & 2) != 0 ? defaultOutlinedTextFieldColorsCached.disabledSupportingTextColor : 0L, (2047 & 4) != 0 ? defaultOutlinedTextFieldColorsCached.errorSupportingTextColor : 0L, (2047 & 8) != 0 ? defaultOutlinedTextFieldColorsCached.focusedPrefixColor : 0L, (2047 & 16) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedPrefixColor : 0L, (2047 & 32) != 0 ? defaultOutlinedTextFieldColorsCached.disabledPrefixColor : 0L, (2047 & 64) != 0 ? defaultOutlinedTextFieldColorsCached.errorPrefixColor : 0L, (2047 & 128) != 0 ? defaultOutlinedTextFieldColorsCached.focusedSuffixColor : 0L, (2047 & 256) != 0 ? defaultOutlinedTextFieldColorsCached.unfocusedSuffixColor : 0L, (2047 & 512) != 0 ? defaultOutlinedTextFieldColorsCached.disabledSuffixColor : 0L, (2047 & 1024) != 0 ? defaultOutlinedTextFieldColorsCached.errorSuffixColor : 0L);
                colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(defaultOutlinedTextFieldColorsCached);
            }
            composer.endReplaceGroup();
            textFieldColors = defaultOutlinedTextFieldColorsCached;
        }
        if (textFieldColors != null) {
            composer.startReplaceGroup(-1788515437);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1788321191);
            ComposerKt.sourceInformation(composer, "1366@73448L7");
            long jFromToken = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long jM6849getTransparent0d7_KjU = Color.INSTANCE.m6849getTransparent0d7_KjU();
            long jM6849getTransparent0d7_KjU2 = Color.INSTANCE.m6849getTransparent0d7_KjU();
            long jM6849getTransparent0d7_KjU3 = Color.INSTANCE.m6849getTransparent0d7_KjU();
            long jM6849getTransparent0d7_KjU4 = Color.INSTANCE.m6849getTransparent0d7_KjU();
            long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long jFromToken5 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localTextSelectionColors2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors2 = new TextFieldColors(jFromToken, jFromToken2, jM6813copywmQWz5c$default, jFromToken3, jM6849getTransparent0d7_KjU, jM6849getTransparent0d7_KjU2, jM6849getTransparent0d7_KjU3, jM6849getTransparent0d7_KjU4, jFromToken4, jFromToken5, (TextSelectionColors) objConsume2, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(textFieldColors2);
            composer.endReplaceGroup();
            textFieldColors = textFieldColors2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColors;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n    focusedBorderThickness = focusedBorderThickness,\n    unfocusedBorderThickness = unfocusedBorderThickness,\n)", imports = {}))
    /* JADX INFO: renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    public final void m3948ContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        boolean z4;
        InteractionSource interactionSource2;
        TextFieldColors textFieldColorsColors;
        Shape shape2;
        float f3;
        float f4;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final float f5;
        final float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1459@79302L348:TextFieldDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            z4 = z2;
            i3 |= composerStartRestartGroup.changed(z4) ? 32 : 16;
        } else {
            z4 = z2;
        }
        if ((i & 384) == 0) {
            interactionSource2 = interactionSource;
            i3 |= composerStartRestartGroup.changed(interactionSource2) ? 256 : 128;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                textFieldColorsColors = textFieldColors;
                int i4 = composerStartRestartGroup.changed(textFieldColorsColors) ? 2048 : 1024;
                i3 |= i4;
            } else {
                textFieldColorsColors = textFieldColors;
            }
            i3 |= i4;
        } else {
            textFieldColorsColors = textFieldColors;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                int i5 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                i3 |= i5;
            } else {
                shape2 = shape;
            }
            i3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                int i6 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                i3 |= i6;
            } else {
                f3 = f;
            }
            i3 |= i6;
        } else {
            f3 = f;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                int i7 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                i3 |= i7;
            } else {
                f4 = f2;
            }
            i3 |= i7;
        } else {
            f4 = f2;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1454@79094L8,1455@79153L5");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 8) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    shape2 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    f3 = FocusedBorderThickness;
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    f4 = UnfocusedBorderThickness;
                    i3 &= -3670017;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1459)");
            }
            int i8 = (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896);
            int i9 = i3 << 3;
            int i10 = (i9 & 234881024) | i8 | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9);
            InteractionSource interactionSource3 = interactionSource2;
            textFieldColors2 = textFieldColorsColors;
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
            m3947Container4EFweAY(z3, z4, interactionSource3, Modifier.INSTANCE, textFieldColors2, shape3, f5, f6, composerStartRestartGroup, i10, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            textFieldColors2 = textFieldColorsColors;
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldDefaults.ContainerBox_nbWgWpA$lambda$0(this.f$0, z, z2, interactionSource, textFieldColors2, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
