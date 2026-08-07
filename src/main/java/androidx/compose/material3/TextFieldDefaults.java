package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
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
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0018\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;JU\u0010<\u001a\u000207*\u0002072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t¢\u0006\u0004\b>\u0010?J¦\u0002\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010GJ5\u0010H\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bM\u0010NJ5\u0010O\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bP\u0010NJ7\u0010Q\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0000¢\u0006\u0004\bR\u0010NJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010SJÂ\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020U2\b\b\u0002\u0010W\u001a\u00020U2\b\b\u0002\u0010X\u001a\u00020U2\b\b\u0002\u0010Y\u001a\u00020U2\b\b\u0002\u0010Z\u001a\u00020U2\b\b\u0002\u0010[\u001a\u00020U2\b\b\u0002\u0010\\\u001a\u00020U2\b\b\u0002\u0010]\u001a\u00020U2\b\b\u0002\u0010^\u001a\u00020U2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010a\u001a\u00020U2\b\b\u0002\u0010b\u001a\u00020U2\b\b\u0002\u0010c\u001a\u00020U2\b\b\u0002\u0010d\u001a\u00020U2\b\b\u0002\u0010e\u001a\u00020U2\b\b\u0002\u0010f\u001a\u00020U2\b\b\u0002\u0010g\u001a\u00020U2\b\b\u0002\u0010h\u001a\u00020U2\b\b\u0002\u0010i\u001a\u00020U2\b\b\u0002\u0010j\u001a\u00020U2\b\b\u0002\u0010k\u001a\u00020U2\b\b\u0002\u0010l\u001a\u00020U2\b\b\u0002\u0010m\u001a\u00020U2\b\b\u0002\u0010n\u001a\u00020U2\b\b\u0002\u0010o\u001a\u00020U2\b\b\u0002\u0010p\u001a\u00020U2\b\b\u0002\u0010q\u001a\u00020U2\b\b\u0002\u0010r\u001a\u00020U2\b\b\u0002\u0010s\u001a\u00020U2\b\b\u0002\u0010t\u001a\u00020U2\b\b\u0002\u0010u\u001a\u00020U2\b\b\u0002\u0010v\u001a\u00020U2\b\b\u0002\u0010w\u001a\u00020U2\b\b\u0002\u0010x\u001a\u00020U2\b\b\u0002\u0010y\u001a\u00020U2\b\b\u0002\u0010z\u001a\u00020U2\b\b\u0002\u0010{\u001a\u00020U2\b\b\u0002\u0010|\u001a\u00020U2\b\b\u0002\u0010}\u001a\u00020U2\b\b\u0002\u0010~\u001a\u00020U2\b\b\u0002\u0010\u007f\u001a\u00020U2\t\b\u0002\u0010\u0080\u0001\u001a\u00020UH\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001d\u0010\u0083\u0001\u001a\u000200*\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020`H\u0000¢\u0006\u0003\b\u0086\u0001J9\u0010\u0087\u0001\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010\u0088\u0001J9\u0010\u0096\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u0097\u0001\u0010NJ9\u0010\u0098\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u0099\u0001\u0010NJ9\u0010\u009a\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u009b\u0001\u0010NR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u001e\u0010\u0089\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000f\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010\u0007R\u001e\u0010\u008d\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000f\u0012\u0006\b\u008e\u0001\u0010\u008b\u0001\u001a\u0005\b\u008f\u0001\u0010\u0007R!\u0010\u0090\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0091\u0001\u0010\u0003\u001a\u0005\b\u0092\u0001\u0010\u000bR!\u0010\u0093\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0094\u0001\u0010\u0003\u001a\u0005\b\u0095\u0001\u0010\u000b¨\u0006\u009c\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", TtmlNode.RUBY_CONTAINER, "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", TextFieldImplKt.ContainerId, "modifier", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "indicatorLine", "textFieldShape", "indicatorLine-AWlRVLg", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/ui/Modifier;", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "contentPaddingWithLabel", "start", "end", ViewProps.TOP, ViewProps.BOTTOM, "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "localTextSelectionColors", "defaultTextFieldColors$material3", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "outlinedShape", "getOutlinedShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getOutlinedShape", "filledShape", "getFilledShape$annotations", "getFilledShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m9687constructorimpl(56);
    private static final float MinWidth = Dp.m9687constructorimpl(280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContainerBox$lambda$0(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.ContainerBox(z, z2, interactionSource, textFieldColors, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Container_4EFweAY$lambda$0(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.m4465Container4EFweAY(z, z2, interactionSource, modifier, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$3(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, Function2 function9, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function10, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, function7, function8, function9, shape, textFieldColors, paddingValues, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations(Composer composer, int i) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m4458getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations(Composer composer, int i) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m4459getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1941327459, "C(<get-shape>)68@3251L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:68)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m4471getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m4472getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m4474getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m4470getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit decorator$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C173@9367L5,168@9174L367:TextFieldDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(245572296, i, -1, "androidx.compose.material3.TextFieldDefaults.decorator.<anonymous> (TextFieldDefaults.kt:168)");
            }
            TextFieldDefaults textFieldDefaults = INSTANCE;
            textFieldDefaults.m4465Container4EFweAY(z, z2, interactionSource, null, textFieldColors, textFieldDefaults.getShape(composer, 6), FocusedIndicatorThickness, UnfocusedIndicatorThickness, composer, 114819072, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldDefaults$decorator$2, reason: invalid class name */
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
            Composer composerStartRestartGroup = composer.startRestartGroup(-94654579);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)191@10152L718:TextFieldDefaults.kt#uh7d8r");
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
                    ComposerKt.traceEventStart(-94654579, i2, -1, "androidx.compose.material3.TextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:179)");
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
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, charSequenceAsCharSequence, function2, this.$labelPosition, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE), this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer2, ((i2 << 6) & 896) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$decorator$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.AnonymousClass2.Decoration$lambda$2(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    public final TextFieldDecorator decorator(TextFieldState textFieldState, boolean z, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, InteractionSource interactionSource, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean z2, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function9, Composer composer, int i, int i2, int i3) {
        TextFieldDefaults textFieldDefaults;
        final TextFieldColors textFieldColorsColors;
        PaddingValues paddingValues2;
        final boolean z3;
        final InteractionSource interactionSource2;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        PaddingValues paddingValuesM4457contentPaddingWithoutLabela9UjIt4$default;
        ComposerKt.sourceInformationMarkerStart(composer, 320881373, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)160@8861L8,167@9160L391:TextFieldDefaults.kt#uh7d8r");
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
            textFieldDefaults = this;
            textFieldColorsColors = textFieldDefaults.colors(composer, (i2 >> 21) & 14);
        } else {
            textFieldDefaults = this;
            textFieldColorsColors = textFieldColors;
        }
        if ((32768 & i3) != 0) {
            if (function10 == null || (attached instanceof TextFieldLabelPosition.Above)) {
                paddingValuesM4457contentPaddingWithoutLabela9UjIt4$default = m4457contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            } else {
                paddingValuesM4457contentPaddingWithoutLabela9UjIt4$default = m4456contentPaddingWithLabela9UjIt4$default(textFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            }
            paddingValues2 = paddingValuesM4457contentPaddingWithoutLabela9UjIt4$default;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i3 & 65536) != 0) {
            z3 = z;
            interactionSource2 = interactionSource;
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(245572296, true, new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.decorator$lambda$0(z3, z4, interactionSource2, textFieldColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
        } else {
            z3 = z;
            interactionSource2 = interactionSource;
            function2RememberComposableLambda = function9;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(320881373, i, i2, "androidx.compose.material3.TextFieldDefaults.decorator (TextFieldDefaults.kt:178)");
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(outputTransformation, textFieldState, textFieldLineLimits, attached, function10, function11, function12, function13, function14, function15, function16, z3, z4, interactionSource2, paddingValues2, textFieldColorsColors, function2RememberComposableLambda);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return anonymousClass2;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0140  */
    /* JADX WARN: Code duplicated, block: B:114:0x0149  */
    /* JADX WARN: Code duplicated, block: B:115:0x0154  */
    /* JADX WARN: Code duplicated, block: B:118:0x015a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:122:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x016d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0172  */
    /* JADX WARN: Code duplicated, block: B:127:0x0180  */
    /* JADX WARN: Code duplicated, block: B:130:0x0192  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:138:0x020d  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
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
    public final void m4465Container4EFweAY(final boolean z, final boolean z2, final InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        float f3;
        float f4;
        boolean z3;
        final TextFieldColors textFieldColors2;
        final Modifier modifier3;
        Composer composer2;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextFieldColors textFieldColorsColors;
        Shape shape4;
        float f7;
        TextFieldColors textFieldColors3;
        Modifier modifier4;
        float f8;
        int i4;
        float f9;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-818661242);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedIndicatorLineThickness:c#ui.unit.Dp,unfocusedIndicatorLineThickness:c#ui.unit.Dp)242@12387L25,247@12703L7,245@12536L189,249@12734L540:TextFieldDefaults.kt#uh7d8r");
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
            if ((i & 24576) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 8192 : 16384;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    int i7 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                    i3 |= i7;
                } else {
                    shape2 = shape;
                }
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    f3 = f;
                    int i8 = composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    i3 |= i8;
                } else {
                    f3 = f;
                }
                i3 |= i8;
            } else {
                f3 = f;
            }
            if ((12582912 & i) == 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    int i9 = composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
                    i3 |= i9;
                } else {
                    f4 = f2;
                }
                i3 |= i9;
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "237@12135L8,238@12186L5");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i2 & 32) != 0) {
                        shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        f7 = FocusedIndicatorThickness;
                        i3 &= -3670017;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        int i10 = i3 & (-29360129);
                        textFieldColors3 = textFieldColorsColors;
                        modifier4 = modifier2;
                        f8 = f7;
                        i4 = i10;
                        f9 = UnfocusedIndicatorThickness;
                    } else {
                        int i11 = i3;
                        textFieldColors3 = textFieldColorsColors;
                        modifier4 = modifier2;
                        f8 = f7;
                        i4 = i11;
                        f9 = f4;
                    }
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
                    modifier4 = modifier2;
                    shape4 = shape2;
                    f8 = f3;
                    f9 = f4;
                    i4 = i3;
                    textFieldColors3 = textFieldColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818661242, i4, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:241)");
                }
                final State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(textFieldColors3.m4400containerColorXeAY9LY(z, z2, FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i4 >> 6) & 14).getValue().booleanValue()), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                Modifier modifierTextFieldBackground = TextFieldImplKt.textFieldBackground(modifier4, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM437animateColorAsStateeuL9pac) { // from class: androidx.compose.material3.TextFieldDefaults$Container$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), shape4);
                Modifier modifier5 = modifier4;
                TextFieldColors textFieldColors4 = textFieldColors3;
                Shape shape5 = shape4;
                float f10 = f8;
                float f11 = f9;
                BoxKt.Box(m4475indicatorLineAWlRVLg(modifierTextFieldBackground, z, z2, interactionSource, textFieldColors4, shape5, f10, f11), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                f6 = f11;
                f5 = f10;
                shape3 = shape5;
                textFieldColors2 = textFieldColors4;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                textFieldColors2 = textFieldColors;
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                shape3 = shape2;
                f5 = f3;
                f6 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.Container_4EFweAY$lambda$0(this.f$0, z, z2, interactionSource, modifier3, textFieldColors2, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 8192 : 16384;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                }
                i3 |= i8;
            } else {
                f3 = f;
            }
            i3 |= i8;
        } else {
            f3 = f;
        }
        if ((12582912 & i) == 0) {
            if ((i2 & 128) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                }
                i3 |= i9;
            } else {
                f4 = f2;
            }
            i3 |= i9;
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
            ComposerKt.sourceInformation(composerStartRestartGroup, "237@12135L8,238@12186L5");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i2 & 32) != 0) {
                    shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 64) != 0) {
                    f7 = FocusedIndicatorThickness;
                    i3 &= -3670017;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    int i12 = i3 & (-29360129);
                    textFieldColors3 = textFieldColorsColors;
                    modifier4 = modifier2;
                    f8 = f7;
                    i4 = i12;
                    f9 = UnfocusedIndicatorThickness;
                } else {
                    int i13 = i3;
                    textFieldColors3 = textFieldColorsColors;
                    modifier4 = modifier2;
                    f8 = f7;
                    i4 = i13;
                    f9 = f4;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -57345;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i2 & 32) != 0) {
                    shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 64) != 0) {
                    f7 = FocusedIndicatorThickness;
                    i3 &= -3670017;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    int i14 = i3 & (-29360129);
                    textFieldColors3 = textFieldColorsColors;
                    modifier4 = modifier2;
                    f8 = f7;
                    i4 = i14;
                    f9 = UnfocusedIndicatorThickness;
                } else {
                    int i15 = i3;
                    textFieldColors3 = textFieldColorsColors;
                    modifier4 = modifier2;
                    f8 = f7;
                    i4 = i15;
                    f9 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818661242, i4, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:241)");
            }
            final Object stateM437animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(textFieldColors3.m4400containerColorXeAY9LY(z, z2, FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i4 >> 6) & 14).getValue().booleanValue()), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
            Modifier modifierTextFieldBackground2 = TextFieldImplKt.textFieldBackground(modifier4, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM437animateColorAsStateeuL9pac2) { // from class: androidx.compose.material3.TextFieldDefaults$Container$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            }), shape4);
            Modifier modifier6 = modifier4;
            TextFieldColors textFieldColors5 = textFieldColors3;
            Shape shape6 = shape4;
            float f12 = f8;
            float f13 = f9;
            BoxKt.Box(m4475indicatorLineAWlRVLg(modifierTextFieldBackground2, z, z2, interactionSource, textFieldColors5, shape6, f12, f13), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            f6 = f13;
            f5 = f12;
            shape3 = shape6;
            textFieldColors2 = textFieldColors5;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            textFieldColors2 = textFieldColors;
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.Container_4EFweAY$lambda$0(this.f$0, z, z2, interactionSource, modifier3, textFieldColors2, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4460indicatorLineAWlRVLg$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, Object obj) {
        if ((i & 8) != 0) {
            textFieldColors = null;
        }
        if ((i & 16) != 0) {
            shape = null;
        }
        if ((i & 32) != 0) {
            f = FocusedIndicatorThickness;
        }
        if ((i & 64) != 0) {
            f2 = UnfocusedIndicatorThickness;
        }
        return textFieldDefaults.m4475indicatorLineAWlRVLg(modifier, z, z2, interactionSource, textFieldColors, shape, f, f2);
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg, reason: not valid java name */
    public final Modifier m4475indicatorLineAWlRVLg(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2) {
        return modifier.then(new IndicatorLineElement(z, z2, interactionSource, textFieldColors, shape, f, f2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C390@20670L404:TextFieldDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(417908150, i, -1, "androidx.compose.material3.TextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:390)");
            }
            INSTANCE.m4465Container4EFweAY(z, z2, interactionSource, Modifier.INSTANCE, textFieldColors, shape, FocusedIndicatorThickness, UnfocusedIndicatorThickness, composer, 114822144, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0139  */
    /* JADX WARN: Code duplicated, block: B:103:0x0143  */
    /* JADX WARN: Code duplicated, block: B:104:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0156  */
    /* JADX WARN: Code duplicated, block: B:109:0x0159  */
    /* JADX WARN: Code duplicated, block: B:111:0x015e  */
    /* JADX WARN: Code duplicated, block: B:114:0x016a  */
    /* JADX WARN: Code duplicated, block: B:115:0x016d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0173  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:120:0x017e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0185  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0196  */
    /* JADX WARN: Code duplicated, block: B:128:0x019c  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:150:0x01df  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:162:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:165:0x0204  */
    /* JADX WARN: Code duplicated, block: B:166:0x0209  */
    /* JADX WARN: Code duplicated, block: B:168:0x020f  */
    /* JADX WARN: Code duplicated, block: B:170:0x0215  */
    /* JADX WARN: Code duplicated, block: B:171:0x0218  */
    /* JADX WARN: Code duplicated, block: B:175:0x0220  */
    /* JADX WARN: Code duplicated, block: B:177:0x0226  */
    /* JADX WARN: Code duplicated, block: B:178:0x0229  */
    /* JADX WARN: Code duplicated, block: B:186:0x0249  */
    /* JADX WARN: Code duplicated, block: B:189:0x0252  */
    /* JADX WARN: Code duplicated, block: B:204:0x02a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:205:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:207:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:209:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:212:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:213:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:215:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:216:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:218:0x02be  */
    /* JADX WARN: Code duplicated, block: B:219:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:221:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:222:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:224:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:225:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:228:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:229:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:232:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:233:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:236:0x02ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:237:0x0301  */
    /* JADX WARN: Code duplicated, block: B:238:0x0320  */
    /* JADX WARN: Code duplicated, block: B:240:0x0344  */
    /* JADX WARN: Code duplicated, block: B:242:0x0348  */
    /* JADX WARN: Code duplicated, block: B:243:0x0374  */
    /* JADX WARN: Code duplicated, block: B:247:0x039b  */
    /* JADX WARN: Code duplicated, block: B:250:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:251:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:254:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:261:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:264:0x040b  */
    /* JADX WARN: Code duplicated, block: B:265:0x041a  */
    /* JADX WARN: Code duplicated, block: B:268:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:270:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:273:0x04db  */
    /* JADX WARN: Code duplicated, block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127  */
    /* JADX WARN: Code duplicated, block: B:97:0x0131  */
    /* JADX WARN: Code duplicated, block: B:98:0x0134  */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, Function2<? super Composer, ? super Integer, Unit> function9, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function10, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function11;
        boolean z4;
        InteractionSource interactionSource2;
        boolean z5;
        Function2<? super Composer, ? super Integer, Unit> function12;
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
        boolean z6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function17;
        final Function2<? super Composer, ? super Integer, Unit> function18;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function19;
        final Function2<? super Composer, ? super Integer, Unit> function20;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        TextFieldColors textFieldColorsColors;
        PaddingValues paddingValuesM4456contentPaddingWithLabela9UjIt4$default;
        Shape shape4;
        TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        TextFieldColors textFieldColors4;
        Shape shape5;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        boolean z8;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function30;
        Function2<? super Composer, ? super Integer, Unit> function31;
        Function2<? super Composer, ? super Integer, Unit> function32;
        PaddingValues paddingValues3;
        Function2<? super Composer, ? super Integer, Unit> function33;
        boolean z9;
        boolean z10;
        Object objRememberedValue;
        ComposableLambda composableLambda;
        int i20;
        int i21;
        int i22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1806980801);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,shape,colors,contentPadding,container)403@21131L129,409@21314L749:TextFieldDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function11 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function11) ? 32 : 16;
        } else {
            function11 = function2;
        }
        if ((i & 384) == 0) {
            z4 = z;
            i4 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
        } else {
            z4 = z;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        int i23 = 8192;
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            interactionSource2 = interactionSource;
            i4 |= composerStartRestartGroup.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        int i24 = i3 & 64;
        if (i24 != 0) {
            i4 |= 1572864;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
            }
        }
        int i25 = i3 & 128;
        if (i25 != 0) {
            i4 |= 12582912;
            function12 = function3;
        } else {
            function12 = function3;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
            }
        }
        int i26 = i3 & 256;
        if (i26 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
        }
        int i27 = i3 & 512;
        if (i27 == 0) {
            if ((i & 805306368) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
            i5 = i3 & 1024;
            if (i5 != 0) {
                i6 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i7 = 4;
                } else {
                    i7 = 2;
                }
                i6 = i2 | i7;
            } else {
                i6 = i2;
            }
            i8 = i3 & 2048;
            if (i8 != 0) {
                i6 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i9 = 32;
                } else {
                    i9 = 16;
                }
                i6 |= i9;
            }
            i10 = i6;
            i11 = i3 & 4096;
            if (i11 != 0) {
                i12 = i10 | 384;
            } else if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
                i12 = i10 | i13;
            } else {
                i12 = i10;
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
                i16 = i12 | 3072;
            } else {
                i15 = i12;
                if ((i2 & 3072) == 0) {
                    i16 = i15 | (composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024);
                } else {
                    i16 = i15;
                }
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(shape)) {
                    i23 = 16384;
                }
                i16 |= i23;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0 || !composerStartRestartGroup.changed(textFieldColors)) {
                    i22 = 65536;
                } else {
                    i22 = 131072;
                }
                i16 |= i22;
            }
            if ((i2 & 1572864) != 0) {
                if ((i3 & 65536) == 0 || !composerStartRestartGroup.changed(paddingValues)) {
                    i21 = 524288;
                } else {
                    i21 = 1048576;
                }
                i16 |= i21;
            }
            i17 = i3 & 131072;
            if (i17 != 0) {
                i16 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i16 |= i18;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i16 |= i20;
            }
            if ((i4 & 306783379) == 306783378 || (i16 & 38347923) != 38347922) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "381@20365L5,382@20406L8,389@20656L428");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i24 != 0) {
                        z5 = false;
                    }
                    if (i25 != 0) {
                        function12 = null;
                    }
                    if (i26 != 0) {
                        function21 = null;
                    } else {
                        function21 = function4;
                    }
                    if (i27 != 0) {
                        function22 = null;
                    } else {
                        function22 = function5;
                    }
                    if (i5 != 0) {
                        function23 = null;
                    } else {
                        function23 = function6;
                    }
                    if (i8 != 0) {
                        function24 = null;
                    } else {
                        function24 = function7;
                    }
                    if (i11 != 0) {
                        function25 = null;
                    } else {
                        function25 = function8;
                    }
                    if (i14 != 0) {
                        function26 = null;
                    } else {
                        function26 = function9;
                    }
                    if ((i3 & 16384) != 0) {
                        shape3 = INSTANCE.getShape(composerStartRestartGroup, 6);
                        i16 &= -57345;
                    } else {
                        shape3 = shape;
                    }
                    if ((i3 & 32768) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 24) & 14);
                        i16 &= -458753;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    if ((i3 & 65536) != 0) {
                        if (function12 == null) {
                            paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4457contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4456contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i16 &= -3670017;
                    } else {
                        paddingValuesM4456contentPaddingWithLabela9UjIt4$default = paddingValues;
                    }
                    if (i17 != 0) {
                        final TextFieldColors textFieldColors5 = textFieldColorsColors;
                        final Shape shape6 = shape3;
                        final boolean z11 = z4;
                        final InteractionSource interactionSource3 = interactionSource2;
                        final boolean z12 = z5;
                        textFieldColors3 = textFieldColors5;
                        shape4 = shape6;
                        function27 = function21;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(417908150, true, new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.DecorationBox$lambda$0(z11, z12, interactionSource3, textFieldColors5, shape6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        shape4 = shape3;
                        textFieldColors3 = textFieldColorsColors;
                        function27 = function21;
                        function2RememberComposableLambda = function10;
                    }
                    textFieldColors4 = textFieldColors3;
                    shape5 = shape4;
                    function28 = function12;
                    z8 = z5;
                    i19 = i16;
                    function29 = function25;
                    function30 = function23;
                    function31 = function26;
                    function32 = function24;
                    paddingValues3 = paddingValuesM4456contentPaddingWithLabela9UjIt4$default;
                    function33 = function22;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 16384) != 0) {
                        i16 &= -57345;
                    }
                    if ((i3 & 32768) != 0) {
                        i16 &= -458753;
                    }
                    if ((i3 & 65536) != 0) {
                        i16 &= -3670017;
                    }
                    function27 = function4;
                    function30 = function6;
                    function31 = function9;
                    shape5 = shape;
                    textFieldColors4 = textFieldColors;
                    paddingValues3 = paddingValues;
                    function2RememberComposableLambda = function10;
                    function28 = function12;
                    z8 = z5;
                    i19 = i16;
                    function33 = function5;
                    function32 = function7;
                    function29 = function8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1806980801, i4, i19, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:401)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341808930, "CC(remember):TextFieldDefaults.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z9 | ((57344 & i4) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String text = ((TransformedText) objRememberedValue).getText().getText();
                TextFieldType textFieldType = TextFieldType.Filled;
                TextFieldLabelPosition.Attached attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                if (function28 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1353147063);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1353147062);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*415@21593L15");
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1110058497, true, new Function3() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TextFieldDefaults.DecorationBox$lambda$2$0(function28, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda;
                }
                int i28 = i4 >> 9;
                int i29 = i19 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(textFieldType, text, function11, attached, composableLambda, function27, function33, function30, function32, function29, function31, z2, z, z8, interactionSource, paddingValues3, textFieldColors4, function2RememberComposableLambda, composer2, ((i4 << 3) & 896) | 6 | (458752 & i28) | (3670016 & i28) | (i29 & 29360128) | (i29 & 234881024) | (i29 & C.ENCODING_PCM_DOUBLE), ((i19 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i28 & 7168) | (57344 & (i4 >> 3)) | ((i19 >> 3) & 458752) | ((i19 << 3) & 3670016) | (29360128 & i19));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function18 = function28;
                function13 = function27;
                function14 = function33;
                function15 = function30;
                function19 = function32;
                function16 = function29;
                function20 = function31;
                z7 = z8;
                paddingValues2 = paddingValues3;
                textFieldColors2 = textFieldColors4;
                function17 = function2RememberComposableLambda;
                shape2 = shape5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function13 = function4;
                function14 = function5;
                function15 = function6;
                function16 = function8;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                paddingValues2 = paddingValues;
                function17 = function10;
                function18 = function12;
                z7 = z5;
                function19 = function7;
                function20 = function9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z7, function18, function13, function14, function15, function19, function16, function20, shape2, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i5 = i3 & 1024;
        if (i5 != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i6 = i2 | i7;
        } else {
            i6 = i2;
        }
        i8 = i3 & 2048;
        if (i8 != 0) {
            i6 |= 48;
        } else if ((i2 & 48) != 0) {
            if (composerStartRestartGroup.changedInstance(function7)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i6 |= i9;
        }
        i10 = i6;
        i11 = i3 & 4096;
        if (i11 != 0) {
            i12 = i10 | 384;
        } else if ((i2 & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function8)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 = i10 | i13;
        } else {
            i12 = i10;
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
            i16 = i12 | 3072;
        } else {
            i15 = i12;
            if ((i2 & 3072) == 0) {
                i16 = i15 | (composerStartRestartGroup.changedInstance(function9) ? 2048 : 1024);
            } else {
                i16 = i15;
            }
        }
        if ((i2 & 24576) != 0) {
            if ((i3 & 16384) == 0) {
                i23 = 16384;
            }
            i16 |= i23;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i3 & 32768) == 0) {
                i22 = 65536;
            } else {
                i22 = 65536;
            }
            i16 |= i22;
        }
        if ((i2 & 1572864) != 0) {
            if ((i3 & 65536) == 0) {
                i21 = 524288;
            } else {
                i21 = 524288;
            }
            i16 |= i21;
        }
        i17 = i3 & 131072;
        if (i17 != 0) {
            i16 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function10)) {
                i18 = 8388608;
            } else {
                i18 = 4194304;
            }
            i16 |= i18;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i20 = 67108864;
            } else {
                i20 = 33554432;
            }
            i16 |= i20;
        }
        if ((i4 & 306783379) == 306783378) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "381@20365L5,382@20406L8,389@20656L428");
            if ((i & 1) != 0) {
                if (i24 != 0) {
                    z5 = false;
                }
                if (i25 != 0) {
                    function12 = null;
                }
                if (i26 != 0) {
                    function21 = null;
                } else {
                    function21 = function4;
                }
                if (i27 != 0) {
                    function22 = null;
                } else {
                    function22 = function5;
                }
                if (i5 != 0) {
                    function23 = null;
                } else {
                    function23 = function6;
                }
                if (i8 != 0) {
                    function24 = null;
                } else {
                    function24 = function7;
                }
                if (i11 != 0) {
                    function25 = null;
                } else {
                    function25 = function8;
                }
                if (i14 != 0) {
                    function26 = null;
                } else {
                    function26 = function9;
                }
                if ((i3 & 16384) != 0) {
                    shape3 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i16 &= -57345;
                } else {
                    shape3 = shape;
                }
                if ((i3 & 32768) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 24) & 14);
                    i16 &= -458753;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i3 & 65536) != 0) {
                    if (function12 == null) {
                        paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4457contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4456contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i16 &= -3670017;
                } else {
                    paddingValuesM4456contentPaddingWithLabela9UjIt4$default = paddingValues;
                }
                if (i17 != 0) {
                    final TextFieldColors textFieldColors6 = textFieldColorsColors;
                    final Shape shape7 = shape3;
                    final boolean z13 = z4;
                    final InteractionSource interactionSource4 = interactionSource2;
                    final boolean z14 = z5;
                    textFieldColors3 = textFieldColors6;
                    shape4 = shape7;
                    function27 = function21;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(417908150, true, new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.DecorationBox$lambda$0(z13, z14, interactionSource4, textFieldColors6, shape7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    shape4 = shape3;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function21;
                    function2RememberComposableLambda = function10;
                }
                textFieldColors4 = textFieldColors3;
                shape5 = shape4;
                function28 = function12;
                z8 = z5;
                i19 = i16;
                function29 = function25;
                function30 = function23;
                function31 = function26;
                function32 = function24;
                paddingValues3 = paddingValuesM4456contentPaddingWithLabela9UjIt4$default;
                function33 = function22;
            } else {
                if (i24 != 0) {
                    z5 = false;
                }
                if (i25 != 0) {
                    function12 = null;
                }
                if (i26 != 0) {
                    function21 = null;
                } else {
                    function21 = function4;
                }
                if (i27 != 0) {
                    function22 = null;
                } else {
                    function22 = function5;
                }
                if (i5 != 0) {
                    function23 = null;
                } else {
                    function23 = function6;
                }
                if (i8 != 0) {
                    function24 = null;
                } else {
                    function24 = function7;
                }
                if (i11 != 0) {
                    function25 = null;
                } else {
                    function25 = function8;
                }
                if (i14 != 0) {
                    function26 = null;
                } else {
                    function26 = function9;
                }
                if ((i3 & 16384) != 0) {
                    shape3 = INSTANCE.getShape(composerStartRestartGroup, 6);
                    i16 &= -57345;
                } else {
                    shape3 = shape;
                }
                if ((i3 & 32768) != 0) {
                    textFieldColorsColors = colors(composerStartRestartGroup, (i16 >> 24) & 14);
                    i16 &= -458753;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i3 & 65536) != 0) {
                    if (function12 == null) {
                        paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4457contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM4456contentPaddingWithLabela9UjIt4$default = m4456contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i16 &= -3670017;
                } else {
                    paddingValuesM4456contentPaddingWithLabela9UjIt4$default = paddingValues;
                }
                if (i17 != 0) {
                    final TextFieldColors textFieldColors7 = textFieldColorsColors;
                    final Shape shape8 = shape3;
                    final boolean z15 = z4;
                    final InteractionSource interactionSource5 = interactionSource2;
                    final boolean z16 = z5;
                    textFieldColors3 = textFieldColors7;
                    shape4 = shape8;
                    function27 = function21;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(417908150, true, new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.DecorationBox$lambda$0(z15, z16, interactionSource5, textFieldColors7, shape8, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    shape4 = shape3;
                    textFieldColors3 = textFieldColorsColors;
                    function27 = function21;
                    function2RememberComposableLambda = function10;
                }
                textFieldColors4 = textFieldColors3;
                shape5 = shape4;
                function28 = function12;
                z8 = z5;
                i19 = i16;
                function29 = function25;
                function30 = function23;
                function31 = function26;
                function32 = function24;
                paddingValues3 = paddingValuesM4456contentPaddingWithLabela9UjIt4$default;
                function33 = function22;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1806980801, i4, i19, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:401)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341808930, "CC(remember):TextFieldDefaults.kt#9igjgp");
            if ((i4 & 14) == 4) {
                z9 = true;
            } else {
                z9 = false;
            }
            z10 = z9 | ((57344 & i4) == 16384);
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
            TextFieldType textFieldType2 = TextFieldType.Filled;
            TextFieldLabelPosition.Attached attached2 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
            if (function28 == null) {
                composerStartRestartGroup.startReplaceGroup(-1353147063);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1353147062);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*415@21593L15");
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1110058497, true, new Function3() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TextFieldDefaults.DecorationBox$lambda$2$0(function28, (TextFieldLabelScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            }
            int i210 = i4 >> 9;
            int i211 = i19 << 21;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(textFieldType2, text2, function11, attached2, composableLambda, function27, function33, function30, function32, function29, function31, z2, z, z8, interactionSource, paddingValues3, textFieldColors4, function2RememberComposableLambda, composer2, ((i4 << 3) & 896) | 6 | (458752 & i210) | (3670016 & i210) | (i211 & 29360128) | (i211 & 234881024) | (i211 & C.ENCODING_PCM_DOUBLE), ((i19 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i210 & 7168) | (57344 & (i4 >> 3)) | ((i19 >> 3) & 458752) | ((i19 << 3) & 3670016) | (29360128 & i19));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function18 = function28;
            function13 = function27;
            function14 = function33;
            function15 = function30;
            function19 = function32;
            function16 = function29;
            function20 = function31;
            z7 = z8;
            paddingValues2 = paddingValues3;
            textFieldColors2 = textFieldColors4;
            function17 = function2RememberComposableLambda;
            shape2 = shape5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function13 = function4;
            function14 = function5;
            function15 = function6;
            function16 = function8;
            shape2 = shape;
            textFieldColors2 = textFieldColors;
            paddingValues2 = paddingValues;
            function17 = function10;
            function18 = function12;
            z7 = z5;
            function19 = function7;
            function20 = function9;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z7, function18, function13, function14, function15, function19, function16, function20, shape2, textFieldColors2, paddingValues2, function17, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$2$0(Function2 function2, TextFieldLabelScope textFieldLabelScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C415@21598L8:TextFieldDefaults.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1110058497, i, -1, "androidx.compose.material3.TextFieldDefaults.DecorationBox.<anonymous>.<anonymous> (TextFieldDefaults.kt:415)");
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

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4456contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m4467contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m4467contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4457contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m4468contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m4468contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4462supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = Dp.m9687constructorimpl(0);
        }
        return textFieldDefaults.m4477supportingTextPaddinga9UjIt4$material3(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3, reason: not valid java name */
    public final PaddingValues m4477supportingTextPaddinga9UjIt4$material3(float start, float top, float end, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 831731228, "C(colors)478@24135L11,478@24195L7:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:478)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTextSelectionColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldColors textFieldColorsDefaultTextFieldColors$material3 = defaultTextFieldColors$material3(colorScheme, (TextSelectionColors) objConsume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsDefaultTextFieldColors$material3;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m4466colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        ComposerKt.sourceInformationMarkerStart(composer, 1513344955, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)580@31011L11,581@31084L7:TextFieldDefaults.kt#uh7d8r");
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
            ComposerKt.traceEventStart(1513344955, i, i2, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:580)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTextSelectionColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldColors textFieldColorsM4401copyejIjP34 = defaultTextFieldColors$material3(colorScheme, (TextSelectionColors) objConsume).m4401copyejIjP34(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, textSelectionColors2, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU14, jM6850getUnspecified0d7_KjU15, jM6850getUnspecified0d7_KjU16, jM6850getUnspecified0d7_KjU17, jM6850getUnspecified0d7_KjU18, jM6850getUnspecified0d7_KjU19, jM6850getUnspecified0d7_KjU20, jM6850getUnspecified0d7_KjU21, jM6850getUnspecified0d7_KjU22, jM6850getUnspecified0d7_KjU23, jM6850getUnspecified0d7_KjU24, jM6850getUnspecified0d7_KjU25, jM6850getUnspecified0d7_KjU26, jM6850getUnspecified0d7_KjU27, jM6850getUnspecified0d7_KjU28, jM6850getUnspecified0d7_KjU29, jM6850getUnspecified0d7_KjU30, jM6850getUnspecified0d7_KjU31, jM6850getUnspecified0d7_KjU32, jM6850getUnspecified0d7_KjU33, jM6850getUnspecified0d7_KjU34, jM6850getUnspecified0d7_KjU35, jM6850getUnspecified0d7_KjU36, jM6850getUnspecified0d7_KjU37, jM6850getUnspecified0d7_KjU38, jM6850getUnspecified0d7_KjU39, jM6850getUnspecified0d7_KjU40, jM6850getUnspecified0d7_KjU41, jM6850getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4401copyejIjP34;
    }

    public final TextFieldColors defaultTextFieldColors$material3(ColorScheme colorScheme, TextSelectionColors textSelectionColors) {
        TextFieldColors defaultTextFieldColorsCached = colorScheme.getDefaultTextFieldColorsCached();
        if (defaultTextFieldColorsCached != null) {
            if (!Intrinsics.areEqual(defaultTextFieldColorsCached.getTextSelectionColors(), textSelectionColors)) {
                defaultTextFieldColorsCached = defaultTextFieldColorsCached.m4401copyejIjP34(((-1025) & 1) != 0 ? defaultTextFieldColorsCached.focusedTextColor : 0L, ((-1025) & 2) != 0 ? defaultTextFieldColorsCached.unfocusedTextColor : 0L, ((-1025) & 4) != 0 ? defaultTextFieldColorsCached.disabledTextColor : 0L, ((-1025) & 8) != 0 ? defaultTextFieldColorsCached.errorTextColor : 0L, ((-1025) & 16) != 0 ? defaultTextFieldColorsCached.focusedContainerColor : 0L, ((-1025) & 32) != 0 ? defaultTextFieldColorsCached.unfocusedContainerColor : 0L, ((-1025) & 64) != 0 ? defaultTextFieldColorsCached.disabledContainerColor : 0L, ((-1025) & 128) != 0 ? defaultTextFieldColorsCached.errorContainerColor : 0L, ((-1025) & 256) != 0 ? defaultTextFieldColorsCached.cursorColor : 0L, ((-1025) & 512) != 0 ? defaultTextFieldColorsCached.errorCursorColor : 0L, ((-1025) & 1024) != 0 ? defaultTextFieldColorsCached.textSelectionColors : textSelectionColors, ((-1025) & 2048) != 0 ? defaultTextFieldColorsCached.focusedIndicatorColor : 0L, ((-1025) & 4096) != 0 ? defaultTextFieldColorsCached.unfocusedIndicatorColor : 0L, ((-1025) & 8192) != 0 ? defaultTextFieldColorsCached.disabledIndicatorColor : 0L, ((-1025) & 16384) != 0 ? defaultTextFieldColorsCached.errorIndicatorColor : 0L, ((-1025) & 32768) != 0 ? defaultTextFieldColorsCached.focusedLeadingIconColor : 0L, ((-1025) & 65536) != 0 ? defaultTextFieldColorsCached.unfocusedLeadingIconColor : 0L, ((-1025) & 131072) != 0 ? defaultTextFieldColorsCached.disabledLeadingIconColor : 0L, ((-1025) & 262144) != 0 ? defaultTextFieldColorsCached.errorLeadingIconColor : 0L, ((-1025) & 524288) != 0 ? defaultTextFieldColorsCached.focusedTrailingIconColor : 0L, ((-1025) & 1048576) != 0 ? defaultTextFieldColorsCached.unfocusedTrailingIconColor : 0L, ((-1025) & 2097152) != 0 ? defaultTextFieldColorsCached.disabledTrailingIconColor : 0L, ((-1025) & 4194304) != 0 ? defaultTextFieldColorsCached.errorTrailingIconColor : 0L, ((-1025) & 8388608) != 0 ? defaultTextFieldColorsCached.focusedLabelColor : 0L, ((-1025) & 16777216) != 0 ? defaultTextFieldColorsCached.unfocusedLabelColor : 0L, ((-1025) & 33554432) != 0 ? defaultTextFieldColorsCached.disabledLabelColor : 0L, ((-1025) & 67108864) != 0 ? defaultTextFieldColorsCached.errorLabelColor : 0L, ((-1025) & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? defaultTextFieldColorsCached.focusedPlaceholderColor : 0L, ((-1025) & 268435456) != 0 ? defaultTextFieldColorsCached.unfocusedPlaceholderColor : 0L, ((-1025) & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? defaultTextFieldColorsCached.disabledPlaceholderColor : 0L, ((-1025) & 1073741824) != 0 ? defaultTextFieldColorsCached.errorPlaceholderColor : 0L, ((-1025) & Integer.MIN_VALUE) != 0 ? defaultTextFieldColorsCached.focusedSupportingTextColor : 0L, (2047 & 1) != 0 ? defaultTextFieldColorsCached.unfocusedSupportingTextColor : 0L, (2047 & 2) != 0 ? defaultTextFieldColorsCached.disabledSupportingTextColor : 0L, (2047 & 4) != 0 ? defaultTextFieldColorsCached.errorSupportingTextColor : 0L, (2047 & 8) != 0 ? defaultTextFieldColorsCached.focusedPrefixColor : 0L, (2047 & 16) != 0 ? defaultTextFieldColorsCached.unfocusedPrefixColor : 0L, (2047 & 32) != 0 ? defaultTextFieldColorsCached.disabledPrefixColor : 0L, (2047 & 64) != 0 ? defaultTextFieldColorsCached.errorPrefixColor : 0L, (2047 & 128) != 0 ? defaultTextFieldColorsCached.focusedSuffixColor : 0L, (2047 & 256) != 0 ? defaultTextFieldColorsCached.unfocusedSuffixColor : 0L, (2047 & 512) != 0 ? defaultTextFieldColorsCached.disabledSuffixColor : 0L, (2047 & 1024) != 0 ? defaultTextFieldColorsCached.errorSuffixColor : 0L);
                colorScheme.setDefaultTextFieldColorsCached$material3(defaultTextFieldColorsCached);
            }
            if (defaultTextFieldColorsCached != null) {
                return defaultTextFieldColorsCached;
            }
        }
        TextFieldColors textFieldColors = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusInputColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorInputColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getCaretColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor()), textSelectionColors, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
        colorScheme.setDefaultTextFieldColorsCached$material3(textFieldColors);
        return textFieldColors;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n)", imports = {}))
    public final void ContainerBox(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        Composer composer2;
        final Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(918564008);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape)738@40549L368:TextFieldDefaults.kt#uh7d8r");
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
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                int i4 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                i3 |= i4;
            } else {
                shape2 = shape;
            }
            i3 |= i4;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "736@40526L5");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
            } else if ((i2 & 16) != 0) {
                shape2 = INSTANCE.getShape(composerStartRestartGroup, 6);
                i3 &= -57345;
            }
            Shape shape4 = shape2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(918564008, i3, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:738)");
            }
            int i5 = i3 << 3;
            composer2 = composerStartRestartGroup;
            m4465Container4EFweAY(z, z2, interactionSource, Modifier.INSTANCE, textFieldColors, shape4, FocusedIndicatorThickness, UnfocusedIndicatorThickness, composer2, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896) | (57344 & i5) | (i5 & 458752) | ((i3 << 9) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            shape3 = shape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.ContainerBox$lambda$0(this.f$0, z, z2, interactionSource, textFieldColors, shape3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -584749279, "C(<get-outlinedShape>)759@41317L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:759)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 611926497, "C(<get-filledShape>)767@41564L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:767)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m4473getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m4469getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4463textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m4478textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m4478textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m4467contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4464textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m4479textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m4479textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m4468contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m4461outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m4476outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m4476outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m3950contentPaddinga9UjIt4(start, top, end, bottom);
    }

    static {
        float fM9687constructorimpl = Dp.m9687constructorimpl(1);
        UnfocusedIndicatorThickness = fM9687constructorimpl;
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(2);
        FocusedIndicatorThickness = fM9687constructorimpl2;
        UnfocusedBorderThickness = fM9687constructorimpl;
        FocusedBorderThickness = fM9687constructorimpl2;
    }
}
