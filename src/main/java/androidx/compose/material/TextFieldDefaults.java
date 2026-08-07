package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%JM\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J5\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J5\u00105\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b6\u00104J5\u00107\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b8\u00104Já\u0001\u00109\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bP\u0010QJá\u0001\u0010R\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010S\u001a\u00020;2\b\b\u0002\u0010T\u001a\u00020;2\b\b\u0002\u0010U\u001a\u00020;2\b\b\u0002\u0010V\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bW\u0010QJÌ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010fJá\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010iJÂ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010jJ×\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010kR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "IconOpacity", "", "TextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "OutlinedTextFieldShape", "getOutlinedTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "BackgroundOpacity", "UnfocusedIndicatorLineOpacity", "indicatorLine", "Landroidx/compose/ui/Modifier;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "BorderBox", "", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "textFieldWithLabelPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "end", ViewProps.TOP, ViewProps.BOTTOM, "textFieldWithLabelPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "textFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "textFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-dx8h9Zs", "TextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, "leadingIcon", "trailingIcon", "contentPadding", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldDecorationBox", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m9687constructorimpl(56);
    private static final float MinWidth = Dp.m9687constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m9687constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m9687constructorimpl(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BorderBox_nbWgWpA$lambda$0(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.m2630BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextFieldDecorationBox$lambda$1(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function7, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, shape, textFieldColors, paddingValues, function7, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextFieldDecorationBox$lambda$3(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function7, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, textFieldColors, paddingValues, function7, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldDecorationBox$lambda$0(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, shape, textFieldColors, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldDecorationBox$lambda$1(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, TextFieldColors textFieldColors, PaddingValues paddingValues, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function3, function4, function5, function6, textFieldColors, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2632getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2633getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1117199624, "C(<get-TextFieldShape>)221@8326L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:221)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cornerBasedShapeCopy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1899109048, "C(<get-OutlinedTextFieldShape>)228@8634L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:228)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return small;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2634getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2631getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2626indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedBorderThickness;
        }
        return textFieldDefaults.m2635indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedBorderThickness : f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier indicatorLine_gv0btCI$lambda$1(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1398930845);
        ComposerKt.sourceInformation(composer, "C289@11188L375:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1398930845, i, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:288)");
        }
        Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m2642animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f, f2, composer, 0).getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDrawIndicatorLine;
    }

    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    public final void m2630BorderBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Shape outlinedTextFieldShape;
        float f3;
        float f4;
        final float f5;
        final float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(943754022);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BorderBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)326@12897L333,334@13239L47:TextFieldDefaults.kt#jmzs0o");
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
                outlinedTextFieldShape = shape;
                int i4 = composerStartRestartGroup.changed(outlinedTextFieldShape) ? 16384 : 8192;
                i3 |= i4;
            } else {
                outlinedTextFieldShape = shape;
            }
            i3 |= i4;
        } else {
            outlinedTextFieldShape = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                int i5 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                i3 |= i5;
            } else {
                f3 = f;
            }
            i3 |= i5;
        } else {
            f3 = f;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                int i6 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                i3 |= i6;
            } else {
                f4 = f2;
            }
            i3 |= i6;
        } else {
            f4 = f2;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "321@12700L22");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
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
            float f7 = f3;
            float f8 = f4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:324)");
            }
            int i7 = i3 & 8190;
            int i8 = i3 >> 3;
            BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m2642animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f7, f8, composerStartRestartGroup, i7 | (57344 & i8) | (i8 & 458752)).getValue(), outlinedTextFieldShape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f6 = f7;
            f5 = f8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f4;
            f6 = f3;
        }
        final Shape shape2 = outlinedTextFieldShape;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.BorderBox_nbWgWpA$lambda$0(this.f$0, z, z2, interactionSource, textFieldColors, shape2, f6, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2628textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m2639textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2639textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2629textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m2640textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2640textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2627outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m2637outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2637outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1214PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m2638textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM6813copywmQWz5c$default;
        long j22;
        long jM6813copywmQWz5c$default2;
        long j23;
        long jM6813copywmQWz5c$default3;
        long j24;
        long jM6813copywmQWz5c$default4;
        long j25;
        long jM6813copywmQWz5c$default5;
        long jM6813copywmQWz5c$default6;
        ComposerKt.sourceInformationMarkerStart(composer, 231892599, "C(textFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)374@14935L7,374@14966L7,375@15039L8,376@15097L6,377@15190L6,378@15254L6,379@15321L6,379@15362L4,381@15436L6,382@15588L8,383@15650L6,384@15712L6,385@15841L8,387@15958L6,388@16089L8,389@16154L6,390@16217L6,390@16258L4,391@16316L6,391@16351L6,392@16434L8,393@16492L6,394@16554L6,394@16589L6,395@16675L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        long jM6813copywmQWz5c$default7 = (i4 & 2) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default8 = (i4 & 4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM2342getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j4;
        long jM2336getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j5;
        long jM6813copywmQWz5c$default9 = (i4 & 32) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6813copywmQWz5c$default10 = (i4 & 64) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j26 = jM6813copywmQWz5c$default10;
            j22 = j26;
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(j26, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default2 = j8;
        }
        long jM2336getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j9;
        long jM6813copywmQWz5c$default11 = (i4 & 512) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j27 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j23 = j27;
        } else {
            j23 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default3 = j11;
        }
        long j28 = (i4 & 2048) != 0 ? j23 : j12;
        long jM6813copywmQWz5c$default12 = (i4 & 4096) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j29 = jM6813copywmQWz5c$default12;
            jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j29;
        } else {
            j24 = jM6813copywmQWz5c$default12;
            jM6813copywmQWz5c$default4 = j14;
        }
        long jM2336getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j15;
        long jM6813copywmQWz5c$default13 = (32768 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM6813copywmQWz5c$default14 = (65536 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j30 = jM6813copywmQWz5c$default14;
            jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6813copywmQWz5c$default14;
            jM6813copywmQWz5c$default5 = j18;
        }
        long jM2336getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j19;
        long jM6813copywmQWz5c$default15 = (524288 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        if ((i4 & 1048576) != 0) {
            jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default6 = j21;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:397)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM6813copywmQWz5c$default, jM6813copywmQWz5c$default7, jM2342getPrimary0d7_KjU, jM2336getError0d7_KjU, jM6813copywmQWz5c$default9, j22, jM2336getError0d7_KjU2, jM6813copywmQWz5c$default2, j23, jM6813copywmQWz5c$default3, j28, j24, jM6813copywmQWz5c$default4, jM2336getError0d7_KjU3, jM6813copywmQWz5c$default8, jM6813copywmQWz5c$default13, j25, jM6813copywmQWz5c$default5, jM2336getError0d7_KjU4, jM6813copywmQWz5c$default15, jM6813copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m2636outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM6813copywmQWz5c$default;
        long j22;
        long jM6813copywmQWz5c$default2;
        long j23;
        long jM6813copywmQWz5c$default3;
        long j24;
        long jM6813copywmQWz5c$default4;
        long j25;
        long jM6813copywmQWz5c$default5;
        long jM6813copywmQWz5c$default6;
        ComposerKt.sourceInformationMarkerStart(composer, 1762667317, "C(outlinedTextFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)428@18205L7,428@18236L7,429@18309L8,431@18415L6,432@18479L6,433@18543L6,433@18584L4,435@18655L6,435@18698L8,436@18793L8,437@18852L6,438@18914L6,439@19043L8,441@19160L6,442@19291L8,443@19356L6,444@19419L6,444@19460L4,445@19518L6,445@19553L6,446@19636L8,447@19694L6,448@19756L6,448@19791L6,449@19877L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default = j;
        }
        long jM6813copywmQWz5c$default7 = (i4 & 2) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6849getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j3;
        long jM2342getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j4;
        long jM2336getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j5;
        long jM6813copywmQWz5c$default8 = (i4 & 32) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6813copywmQWz5c$default9 = (i4 & 64) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j26 = jM6813copywmQWz5c$default9;
            j22 = j26;
            jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(j26, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jM6813copywmQWz5c$default9;
            jM6813copywmQWz5c$default2 = j8;
        }
        long jM2336getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j9;
        long jM6813copywmQWz5c$default10 = (i4 & 512) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j27 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j23 = j27;
        } else {
            j23 = jM6813copywmQWz5c$default10;
            jM6813copywmQWz5c$default3 = j11;
        }
        long j28 = (i4 & 2048) != 0 ? j23 : j12;
        long jM6813copywmQWz5c$default11 = (i4 & 4096) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j29 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j29;
        } else {
            j24 = jM6813copywmQWz5c$default11;
            jM6813copywmQWz5c$default4 = j14;
        }
        long jM2336getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j15;
        long jM6813copywmQWz5c$default12 = (32768 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM6813copywmQWz5c$default13 = (65536 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j30 = jM6813copywmQWz5c$default13;
            jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6813copywmQWz5c$default13;
            jM6813copywmQWz5c$default5 = j18;
        }
        long jM2336getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2336getError0d7_KjU() : j19;
        long jM6813copywmQWz5c$default14 = (524288 & i4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        if ((i4 & 1048576) != 0) {
            jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6813copywmQWz5c$default6 = j21;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:451)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM6813copywmQWz5c$default, jM6813copywmQWz5c$default7, jM2342getPrimary0d7_KjU, jM2336getError0d7_KjU, jM6813copywmQWz5c$default8, j22, jM2336getError0d7_KjU2, jM6813copywmQWz5c$default2, j23, jM6813copywmQWz5c$default3, j28, j24, jM6813copywmQWz5c$default4, jM2336getError0d7_KjU3, jM6849getTransparent0d7_KjU, jM6813copywmQWz5c$default12, j25, jM6813copywmQWz5c$default5, jM2336getError0d7_KjU4, jM6813copywmQWz5c$default14, jM6813copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColors;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x015c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0162  */
    /* JADX WARN: Code duplicated, block: B:122:0x0178  */
    /* JADX WARN: Code duplicated, block: B:125:0x017e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0192  */
    /* JADX WARN: Code duplicated, block: B:135:0x0198  */
    /* JADX WARN: Code duplicated, block: B:138:0x019f  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:164:0x01fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:166:0x0202  */
    /* JADX WARN: Code duplicated, block: B:169:0x0207  */
    /* JADX WARN: Code duplicated, block: B:170:0x020a  */
    /* JADX WARN: Code duplicated, block: B:172:0x020e  */
    /* JADX WARN: Code duplicated, block: B:173:0x0211  */
    /* JADX WARN: Code duplicated, block: B:175:0x0215  */
    /* JADX WARN: Code duplicated, block: B:176:0x0218  */
    /* JADX WARN: Code duplicated, block: B:178:0x021c  */
    /* JADX WARN: Code duplicated, block: B:179:0x021f  */
    /* JADX WARN: Code duplicated, block: B:182:0x0225  */
    /* JADX WARN: Code duplicated, block: B:183:0x0235  */
    /* JADX WARN: Code duplicated, block: B:186:0x023c  */
    /* JADX WARN: Code duplicated, block: B:187:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:190:0x02d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x02da  */
    /* JADX WARN: Code duplicated, block: B:192:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:194:0x0314  */
    /* JADX WARN: Code duplicated, block: B:198:0x032d  */
    /* JADX WARN: Code duplicated, block: B:199:0x0338  */
    /* JADX WARN: Code duplicated, block: B:202:0x039e  */
    /* JADX WARN: Code duplicated, block: B:204:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:207:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x011f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0126  */
    /* JADX WARN: Code duplicated, block: B:95:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0134  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    public final void TextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Composer composer, final int i, final int i2, int i3) {
        int i4;
        final boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        int i9;
        Shape textFieldShape;
        int i10;
        TextFieldColors textFieldColorsM2638textFieldColorsdx8h9Zs;
        PaddingValues paddingValues3;
        TextFieldColors textFieldColors3;
        boolean z7;
        PaddingValues paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default;
        int i11;
        int i12 = i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2088762355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,shape,colors,contentPadding)551@25856L624:TextFieldDefaults.kt#jmzs0o");
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
        int i13 = 1024;
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i14 = i12 & 64;
        if (i14 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i15 = i12 & 128;
        if (i15 != 0) {
            i4 |= 12582912;
            function7 = function3;
        } else {
            function7 = function3;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function7) ? 8388608 : 4194304;
            }
        }
        int i16 = i12 & 256;
        if (i16 != 0) {
            i4 |= 100663296;
            function8 = function4;
        } else {
            function8 = function4;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function8) ? 67108864 : 33554432;
            }
        }
        int i17 = i12 & 512;
        if (i17 == 0) {
            if ((i & 805306368) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
            i5 = i12 & 1024;
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
            if ((i2 & 48) != 0) {
                i6 |= ((i12 & 2048) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
            }
            if ((i2 & 384) != 0) {
                i6 |= ((i12 & 4096) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 128 : 256;
            }
            if ((i2 & 3072) != 0) {
                if ((i12 & 8192) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                    i13 = 2048;
                }
                i6 |= i13;
            }
            if ((i2 & 24576) == 0) {
                i6 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
            }
            i8 = i6;
            if ((i4 & 306783379) == 306783378 || (i8 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "542@25571L14,543@25621L17");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i14 != 0) {
                        z6 = false;
                    } else {
                        z6 = z4;
                    }
                    if (i15 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i16 != 0) {
                        function14 = null;
                    } else {
                        function14 = function8;
                    }
                    if (i17 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i5 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    if ((i12 & 2048) != 0) {
                        i9 = i8 & (-113);
                        textFieldShape = getTextFieldShape(composerStartRestartGroup, (i8 >> 12) & 14);
                    } else {
                        i9 = i8;
                        textFieldShape = shape;
                    }
                    if ((i12 & 4096) != 0) {
                        int i18 = i9;
                        i10 = i4;
                        textFieldColorsM2638textFieldColorsdx8h9Zs = m2638textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i9 >> 9) & 112, 2097151);
                        composer2 = composerStartRestartGroup;
                        i8 = i18 & (-897);
                    } else {
                        i8 = i9;
                        composer2 = composerStartRestartGroup;
                        i10 = i4;
                        textFieldColorsM2638textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i12 = i3;
                    if ((i12 & 8192) != 0) {
                        if (function13 == null) {
                            paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2629textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2628textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i8 &= -7169;
                        paddingValues3 = paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textFieldColors3 = textFieldColorsM2638textFieldColorsdx8h9Zs;
                    z7 = z6;
                    function10 = function13;
                    function11 = function14;
                    function9 = function15;
                    function12 = function16;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i12 & 2048) != 0) {
                        i8 &= -113;
                    }
                    if ((i12 & 4096) != 0) {
                        i8 &= -897;
                    }
                    if ((i12 & 8192) != 0) {
                        i8 &= -7169;
                    }
                    function9 = function5;
                    textFieldShape = shape;
                    textFieldColors3 = textFieldColors;
                    paddingValues3 = paddingValues;
                    composer2 = composerStartRestartGroup;
                    i10 = i4;
                    function10 = function7;
                    function11 = function8;
                    function12 = function6;
                    z7 = z4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i11 = i10;
                    ComposerKt.traceEventStart(2088762355, i11, i8, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:550)");
                } else {
                    i11 = i10;
                }
                TextFieldType textFieldType = TextFieldType.Filled;
                int i19 = i11 << 3;
                int i20 = i11 >> 9;
                int i21 = (i19 & 896) | (i19 & 112) | 6 | ((i11 >> 3) & 7168) | (57344 & i20) | (458752 & i20) | (i20 & 3670016) | ((i8 << 21) & 29360128) | ((i11 << 15) & 234881024) | ((i11 << 21) & C.ENCODING_PCM_DOUBLE);
                int i22 = ((i11 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i11 >> 12) & 112) | ((i8 >> 3) & 896);
                int i23 = i8 << 6;
                TextFieldImplKt.CommonDecorationBox(textFieldType, str, function2, visualTransformation, function10, function11, function9, function12, z2, z, z7, interactionSource, paddingValues3, textFieldShape, textFieldColors3, null, composer2, i21, i22 | (i23 & 7168) | (i23 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
                paddingValues2 = paddingValues3;
                shape2 = textFieldShape;
                textFieldColors2 = textFieldColors3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function9 = function5;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                function10 = function7;
                function11 = function8;
                function12 = function6;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i24 = i12;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.TextFieldDecorationBox$lambda$0(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function10, function11, function9, function12, shape2, textFieldColors2, paddingValues2, i, i2, i24, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i5 = i12 & 1024;
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
        if ((i2 & 48) != 0) {
            i6 |= ((i12 & 2048) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
        }
        if ((i2 & 384) != 0) {
            i6 |= ((i12 & 4096) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 128 : 256;
        }
        if ((i2 & 3072) != 0) {
            if ((i12 & 8192) == 0) {
                i13 = 2048;
            }
            i6 |= i13;
        }
        if ((i2 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
        }
        i8 = i6;
        if ((i4 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "542@25571L14,543@25621L17");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    z6 = false;
                } else {
                    z6 = z4;
                }
                if (i15 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i16 != 0) {
                    function14 = null;
                } else {
                    function14 = function8;
                }
                if (i17 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i5 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                if ((i12 & 2048) != 0) {
                    i9 = i8 & (-113);
                    textFieldShape = getTextFieldShape(composerStartRestartGroup, (i8 >> 12) & 14);
                } else {
                    i9 = i8;
                    textFieldShape = shape;
                }
                if ((i12 & 4096) != 0) {
                    int i110 = i9;
                    i10 = i4;
                    textFieldColorsM2638textFieldColorsdx8h9Zs = m2638textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i9 >> 9) & 112, 2097151);
                    composer2 = composerStartRestartGroup;
                    i8 = i110 & (-897);
                } else {
                    i8 = i9;
                    composer2 = composerStartRestartGroup;
                    i10 = i4;
                    textFieldColorsM2638textFieldColorsdx8h9Zs = textFieldColors;
                }
                i12 = i3;
                if ((i12 & 8192) != 0) {
                    if (function13 == null) {
                        paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2629textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2628textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i8 &= -7169;
                    paddingValues3 = paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues3 = paddingValues;
                }
                textFieldColors3 = textFieldColorsM2638textFieldColorsdx8h9Zs;
                z7 = z6;
                function10 = function13;
                function11 = function14;
                function9 = function15;
                function12 = function16;
            } else {
                if (i14 != 0) {
                    z6 = false;
                } else {
                    z6 = z4;
                }
                if (i15 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i16 != 0) {
                    function14 = null;
                } else {
                    function14 = function8;
                }
                if (i17 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i5 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                if ((i12 & 2048) != 0) {
                    i9 = i8 & (-113);
                    textFieldShape = getTextFieldShape(composerStartRestartGroup, (i8 >> 12) & 14);
                } else {
                    i9 = i8;
                    textFieldShape = shape;
                }
                if ((i12 & 4096) != 0) {
                    int i111 = i9;
                    i10 = i4;
                    textFieldColorsM2638textFieldColorsdx8h9Zs = m2638textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i9 >> 9) & 112, 2097151);
                    composer2 = composerStartRestartGroup;
                    i8 = i111 & (-897);
                } else {
                    i8 = i9;
                    composer2 = composerStartRestartGroup;
                    i10 = i4;
                    textFieldColorsM2638textFieldColorsdx8h9Zs = textFieldColors;
                }
                i12 = i3;
                if ((i12 & 8192) != 0) {
                    if (function13 == null) {
                        paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2629textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default = m2628textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i8 &= -7169;
                    paddingValues3 = paddingValuesM2628textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues3 = paddingValues;
                }
                textFieldColors3 = textFieldColorsM2638textFieldColorsdx8h9Zs;
                z7 = z6;
                function10 = function13;
                function11 = function14;
                function9 = function15;
                function12 = function16;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i11 = i10;
                ComposerKt.traceEventStart(2088762355, i11, i8, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:550)");
            } else {
                i11 = i10;
            }
            TextFieldType textFieldType2 = TextFieldType.Filled;
            int i112 = i11 << 3;
            int i25 = i11 >> 9;
            int i26 = (i112 & 896) | (i112 & 112) | 6 | ((i11 >> 3) & 7168) | (57344 & i25) | (458752 & i25) | (i25 & 3670016) | ((i8 << 21) & 29360128) | ((i11 << 15) & 234881024) | ((i11 << 21) & C.ENCODING_PCM_DOUBLE);
            int i27 = ((i11 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i11 >> 12) & 112) | ((i8 >> 3) & 896);
            int i28 = i8 << 6;
            TextFieldImplKt.CommonDecorationBox(textFieldType2, str, function2, visualTransformation, function10, function11, function9, function12, z2, z, z7, interactionSource, paddingValues3, textFieldShape, textFieldColors3, null, composer2, i26, i27 | (i28 & 7168) | (i28 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z7;
            paddingValues2 = paddingValues3;
            shape2 = textFieldShape;
            textFieldColors2 = textFieldColors3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function9 = function5;
            shape2 = shape;
            textFieldColors2 = textFieldColors;
            function10 = function7;
            function11 = function8;
            function12 = function6;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i29 = i12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.TextFieldDecorationBox$lambda$0(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function10, function11, function9, function12, shape2, textFieldColors2, paddingValues2, i, i2, i29, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextFieldDecorationBox$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C644@31420L61:TextFieldDefaults.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212923596, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:644)");
            }
            INSTANCE.m2630BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x015c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0162  */
    /* JADX WARN: Code duplicated, block: B:122:0x0178  */
    /* JADX WARN: Code duplicated, block: B:125:0x017e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0192  */
    /* JADX WARN: Code duplicated, block: B:135:0x019a  */
    /* JADX WARN: Code duplicated, block: B:136:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:148:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:175:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x0229  */
    /* JADX WARN: Code duplicated, block: B:177:0x022b  */
    /* JADX WARN: Code duplicated, block: B:180:0x022f  */
    /* JADX WARN: Code duplicated, block: B:181:0x0232  */
    /* JADX WARN: Code duplicated, block: B:183:0x0236  */
    /* JADX WARN: Code duplicated, block: B:184:0x0239  */
    /* JADX WARN: Code duplicated, block: B:186:0x023d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0240  */
    /* JADX WARN: Code duplicated, block: B:189:0x0244  */
    /* JADX WARN: Code duplicated, block: B:190:0x0247  */
    /* JADX WARN: Code duplicated, block: B:193:0x024d  */
    /* JADX WARN: Code duplicated, block: B:194:0x025a  */
    /* JADX WARN: Code duplicated, block: B:197:0x0260  */
    /* JADX WARN: Code duplicated, block: B:198:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:201:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:202:0x0319  */
    /* JADX WARN: Code duplicated, block: B:204:0x031d  */
    /* JADX WARN: Code duplicated, block: B:205:0x0349  */
    /* JADX WARN: Code duplicated, block: B:209:0x0367  */
    /* JADX WARN: Code duplicated, block: B:210:0x0372  */
    /* JADX WARN: Code duplicated, block: B:213:0x03de  */
    /* JADX WARN: Code duplicated, block: B:215:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:218:0x0404  */
    /* JADX WARN: Code duplicated, block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x011f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0126  */
    /* JADX WARN: Code duplicated, block: B:95:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0134  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    public final void OutlinedTextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function7, Composer composer, final int i, final int i2, int i3) {
        int i4;
        final boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z5;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function17;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Shape shape3;
        Composer composer3;
        int i11;
        int i12;
        int i13;
        TextFieldColors textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
        PaddingValues paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
        boolean z7;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Shape shape4;
        boolean z8;
        int i14;
        int i15;
        int i16 = i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1154925202);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,shape,colors,contentPadding,border)647@31509L628:TextFieldDefaults.kt#jmzs0o");
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
        int i17 = 1024;
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i18 = i16 & 64;
        if (i18 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i19 = i16 & 128;
        if (i19 != 0) {
            i4 |= 12582912;
            function8 = function3;
        } else {
            function8 = function3;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function8) ? 8388608 : 4194304;
            }
        }
        int i20 = i16 & 256;
        if (i20 != 0) {
            i4 |= 100663296;
            function9 = function4;
        } else {
            function9 = function4;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function9) ? 67108864 : 33554432;
            }
        }
        int i21 = i16 & 512;
        if (i21 == 0) {
            if ((i & 805306368) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
            i5 = i16 & 1024;
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
            if ((i2 & 48) != 0) {
                i6 |= ((i16 & 2048) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
            }
            if ((i2 & 384) != 0) {
                i6 |= ((i16 & 4096) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 128 : 256;
            }
            if ((i2 & 3072) != 0) {
                if ((i16 & 8192) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                    i17 = 2048;
                }
                i6 |= i17;
            }
            i8 = i6;
            i9 = i16 & 16384;
            if (i9 != 0) {
                i10 = i8;
                if ((i2 & 24576) == 0) {
                    i10 |= composerStartRestartGroup.changedInstance(function7) ? 16384 : 8192;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i10 |= i15;
                }
                if ((i4 & 306783379) == 306783378 || (i10 & 74899) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "640@31212L22,641@31270L25,643@31406L85");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            z6 = false;
                        } else {
                            z6 = z4;
                        }
                        if (i19 != 0) {
                            function15 = null;
                        } else {
                            function15 = function8;
                        }
                        if (i20 != 0) {
                            function16 = null;
                        } else {
                            function16 = function9;
                        }
                        if (i21 != 0) {
                            function17 = null;
                        } else {
                            function17 = function5;
                        }
                        if (i5 != 0) {
                            function18 = null;
                        } else {
                            function18 = function6;
                        }
                        if ((i16 & 2048) != 0) {
                            Shape outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -113;
                            shape3 = outlinedTextFieldShape;
                        } else {
                            shape3 = shape;
                        }
                        if ((i16 & 4096) != 0) {
                            i13 = i9;
                            i11 = i4;
                            textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                            composer3 = composerStartRestartGroup;
                            i12 = i10 & (-897);
                        } else {
                            composer3 = composerStartRestartGroup;
                            i11 = i4;
                            i12 = i10;
                            i13 = i9;
                            textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        i16 = i3;
                        if ((i16 & 8192) != 0) {
                            paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i12 &= -7169;
                        } else {
                            paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i13 != 0) {
                            final boolean z9 = z6;
                            final TextFieldColors textFieldColors3 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                            final Shape shape5 = shape3;
                            z7 = z9;
                            shape4 = shape5;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z9, interactionSource, textFieldColors3, shape5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                        } else {
                            z7 = z6;
                            function2RememberComposableLambda = function7;
                            shape4 = shape3;
                        }
                        z8 = z7;
                        function12 = function15;
                        function13 = function16;
                        function10 = function17;
                        function14 = function18;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i16 & 2048) != 0) {
                            i10 &= -113;
                        }
                        i12 = i10;
                        if ((i16 & 4096) != 0) {
                            i12 &= -897;
                        }
                        if ((i16 & 8192) != 0) {
                            i12 &= -7169;
                        }
                        function10 = function5;
                        shape4 = shape;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        function2RememberComposableLambda = function7;
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        function12 = function8;
                        function13 = function9;
                        function14 = function6;
                        z8 = z4;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        i14 = i11;
                        ComposerKt.traceEventStart(1154925202, i14, i12, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:646)");
                    } else {
                        i14 = i11;
                    }
                    int i22 = i14 << 3;
                    int i23 = i14 >> 9;
                    int i24 = i12 << 6;
                    Composer composer4 = composer3;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function12, function13, function10, function14, z2, z, z8, interactionSource, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, shape4, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, function2RememberComposableLambda, composer4, (i22 & 896) | (i22 & 112) | 6 | ((i14 >> 3) & 7168) | (57344 & i23) | (458752 & i23) | (i23 & 3670016) | ((i12 << 21) & 29360128) | ((i14 << 15) & 234881024) | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), ((i14 >> 18) & 14) | ((i14 >> 12) & 112) | ((i12 >> 3) & 896) | (i24 & 7168) | (i24 & 57344) | ((i12 << 3) & 458752));
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z8;
                    paddingValues2 = paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
                    shape2 = shape4;
                    textFieldColors2 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                    function11 = function2RememberComposableLambda;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function5;
                    shape2 = shape;
                    textFieldColors2 = textFieldColors;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function6;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i25 = i16;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function12, function13, function10, function14, shape2, textFieldColors2, paddingValues2, function11, i, i2, i25, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 = i8 | 24576;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i10 |= i15;
            }
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "640@31212L22,641@31270L25,643@31406L85");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        z6 = false;
                    } else {
                        z6 = z4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i20 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i21 != 0) {
                        function17 = null;
                    } else {
                        function17 = function5;
                    }
                    if (i5 != 0) {
                        function18 = null;
                    } else {
                        function18 = function6;
                    }
                    if ((i16 & 2048) != 0) {
                        Shape outlinedTextFieldShape2 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -113;
                        shape3 = outlinedTextFieldShape2;
                    } else {
                        shape3 = shape;
                    }
                    if ((i16 & 4096) != 0) {
                        i13 = i9;
                        i11 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i12 = i10 & (-897);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        i12 = i10;
                        i13 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i16 = i3;
                    if ((i16 & 8192) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i12 &= -7169;
                    } else {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i13 != 0) {
                        final boolean z10 = z6;
                        final TextFieldColors textFieldColors4 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                        final Shape shape6 = shape3;
                        z7 = z10;
                        shape4 = shape6;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z10, interactionSource, textFieldColors4, shape6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z7 = z6;
                        function2RememberComposableLambda = function7;
                        shape4 = shape3;
                    }
                    z8 = z7;
                    function12 = function15;
                    function13 = function16;
                    function10 = function17;
                    function14 = function18;
                } else {
                    if (i18 != 0) {
                        z6 = false;
                    } else {
                        z6 = z4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i20 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i21 != 0) {
                        function17 = null;
                    } else {
                        function17 = function5;
                    }
                    if (i5 != 0) {
                        function18 = null;
                    } else {
                        function18 = function6;
                    }
                    if ((i16 & 2048) != 0) {
                        Shape outlinedTextFieldShape3 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -113;
                        shape3 = outlinedTextFieldShape3;
                    } else {
                        shape3 = shape;
                    }
                    if ((i16 & 4096) != 0) {
                        i13 = i9;
                        i11 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i12 = i10 & (-897);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        i12 = i10;
                        i13 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i16 = i3;
                    if ((i16 & 8192) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i12 &= -7169;
                    } else {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i13 != 0) {
                        final boolean z11 = z6;
                        final TextFieldColors textFieldColors5 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                        final Shape shape7 = shape3;
                        z7 = z11;
                        shape4 = shape7;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z11, interactionSource, textFieldColors5, shape7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z7 = z6;
                        function2RememberComposableLambda = function7;
                        shape4 = shape3;
                    }
                    z8 = z7;
                    function12 = function15;
                    function13 = function16;
                    function10 = function17;
                    function14 = function18;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i14 = i11;
                    ComposerKt.traceEventStart(1154925202, i14, i12, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:646)");
                } else {
                    i14 = i11;
                }
                int i26 = i14 << 3;
                int i27 = i14 >> 9;
                int i28 = i12 << 6;
                Composer composer5 = composer3;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function12, function13, function10, function14, z2, z, z8, interactionSource, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, shape4, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, function2RememberComposableLambda, composer5, (i26 & 896) | (i26 & 112) | 6 | ((i14 >> 3) & 7168) | (57344 & i27) | (458752 & i27) | (i27 & 3670016) | ((i12 << 21) & 29360128) | ((i14 << 15) & 234881024) | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), ((i14 >> 18) & 14) | ((i14 >> 12) & 112) | ((i12 >> 3) & 896) | (i28 & 7168) | (i28 & 57344) | ((i12 << 3) & 458752));
                composer2 = composer5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z8;
                paddingValues2 = paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
                shape2 = shape4;
                textFieldColors2 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                function11 = function2RememberComposableLambda;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function5;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function6;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i29 = i16;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function12, function13, function10, function14, shape2, textFieldColors2, paddingValues2, function11, i, i2, i29, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i5 = i16 & 1024;
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
        if ((i2 & 48) != 0) {
            i6 |= ((i16 & 2048) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
        }
        if ((i2 & 384) != 0) {
            i6 |= ((i16 & 4096) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 128 : 256;
        }
        if ((i2 & 3072) != 0) {
            if ((i16 & 8192) == 0) {
                i17 = 2048;
            }
            i6 |= i17;
        }
        i8 = i6;
        i9 = i16 & 16384;
        if (i9 != 0) {
            i10 = i8;
            if ((i2 & 24576) == 0) {
                i10 |= composerStartRestartGroup.changedInstance(function7) ? 16384 : 8192;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i10 |= i15;
            }
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "640@31212L22,641@31270L25,643@31406L85");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        z6 = false;
                    } else {
                        z6 = z4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i20 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i21 != 0) {
                        function17 = null;
                    } else {
                        function17 = function5;
                    }
                    if (i5 != 0) {
                        function18 = null;
                    } else {
                        function18 = function6;
                    }
                    if ((i16 & 2048) != 0) {
                        Shape outlinedTextFieldShape4 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -113;
                        shape3 = outlinedTextFieldShape4;
                    } else {
                        shape3 = shape;
                    }
                    if ((i16 & 4096) != 0) {
                        i13 = i9;
                        i11 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i12 = i10 & (-897);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        i12 = i10;
                        i13 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i16 = i3;
                    if ((i16 & 8192) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i12 &= -7169;
                    } else {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i13 != 0) {
                        final boolean z12 = z6;
                        final TextFieldColors textFieldColors6 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                        final Shape shape8 = shape3;
                        z7 = z12;
                        shape4 = shape8;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z12, interactionSource, textFieldColors6, shape8, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z7 = z6;
                        function2RememberComposableLambda = function7;
                        shape4 = shape3;
                    }
                    z8 = z7;
                    function12 = function15;
                    function13 = function16;
                    function10 = function17;
                    function14 = function18;
                } else {
                    if (i18 != 0) {
                        z6 = false;
                    } else {
                        z6 = z4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function8;
                    }
                    if (i20 != 0) {
                        function16 = null;
                    } else {
                        function16 = function9;
                    }
                    if (i21 != 0) {
                        function17 = null;
                    } else {
                        function17 = function5;
                    }
                    if (i5 != 0) {
                        function18 = null;
                    } else {
                        function18 = function6;
                    }
                    if ((i16 & 2048) != 0) {
                        Shape outlinedTextFieldShape5 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -113;
                        shape3 = outlinedTextFieldShape5;
                    } else {
                        shape3 = shape;
                    }
                    if ((i16 & 4096) != 0) {
                        i13 = i9;
                        i11 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i12 = i10 & (-897);
                    } else {
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        i12 = i10;
                        i13 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i16 = i3;
                    if ((i16 & 8192) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i12 &= -7169;
                    } else {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i13 != 0) {
                        final boolean z13 = z6;
                        final TextFieldColors textFieldColors7 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                        final Shape shape9 = shape3;
                        z7 = z13;
                        shape4 = shape9;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z13, interactionSource, textFieldColors7, shape9, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z7 = z6;
                        function2RememberComposableLambda = function7;
                        shape4 = shape3;
                    }
                    z8 = z7;
                    function12 = function15;
                    function13 = function16;
                    function10 = function17;
                    function14 = function18;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i14 = i11;
                    ComposerKt.traceEventStart(1154925202, i14, i12, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:646)");
                } else {
                    i14 = i11;
                }
                int i210 = i14 << 3;
                int i211 = i14 >> 9;
                int i212 = i12 << 6;
                Composer composer6 = composer3;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function12, function13, function10, function14, z2, z, z8, interactionSource, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, shape4, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, function2RememberComposableLambda, composer6, (i210 & 896) | (i210 & 112) | 6 | ((i14 >> 3) & 7168) | (57344 & i211) | (458752 & i211) | (i211 & 3670016) | ((i12 << 21) & 29360128) | ((i14 << 15) & 234881024) | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), ((i14 >> 18) & 14) | ((i14 >> 12) & 112) | ((i12 >> 3) & 896) | (i212 & 7168) | (i212 & 57344) | ((i12 << 3) & 458752));
                composer2 = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z8;
                paddingValues2 = paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
                shape2 = shape4;
                textFieldColors2 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                function11 = function2RememberComposableLambda;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function5;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function6;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i213 = i16;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function12, function13, function10, function14, shape2, textFieldColors2, paddingValues2, function11, i, i2, i213, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i10 = i8 | 24576;
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i10 |= i15;
        }
        if ((i4 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "640@31212L22,641@31270L25,643@31406L85");
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    z6 = false;
                } else {
                    z6 = z4;
                }
                if (i19 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i20 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i21 != 0) {
                    function17 = null;
                } else {
                    function17 = function5;
                }
                if (i5 != 0) {
                    function18 = null;
                } else {
                    function18 = function6;
                }
                if ((i16 & 2048) != 0) {
                    Shape outlinedTextFieldShape6 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                    i10 &= -113;
                    shape3 = outlinedTextFieldShape6;
                } else {
                    shape3 = shape;
                }
                if ((i16 & 4096) != 0) {
                    i13 = i9;
                    i11 = i4;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                    composer3 = composerStartRestartGroup;
                    i12 = i10 & (-897);
                } else {
                    composer3 = composerStartRestartGroup;
                    i11 = i4;
                    i12 = i10;
                    i13 = i9;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                i16 = i3;
                if ((i16 & 8192) != 0) {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i12 &= -7169;
                } else {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i13 != 0) {
                    final boolean z14 = z6;
                    final TextFieldColors textFieldColors8 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                    final Shape shape10 = shape3;
                    z7 = z14;
                    shape4 = shape10;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z14, interactionSource, textFieldColors8, shape10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                } else {
                    z7 = z6;
                    function2RememberComposableLambda = function7;
                    shape4 = shape3;
                }
                z8 = z7;
                function12 = function15;
                function13 = function16;
                function10 = function17;
                function14 = function18;
            } else {
                if (i18 != 0) {
                    z6 = false;
                } else {
                    z6 = z4;
                }
                if (i19 != 0) {
                    function15 = null;
                } else {
                    function15 = function8;
                }
                if (i20 != 0) {
                    function16 = null;
                } else {
                    function16 = function9;
                }
                if (i21 != 0) {
                    function17 = null;
                } else {
                    function17 = function5;
                }
                if (i5 != 0) {
                    function18 = null;
                } else {
                    function18 = function6;
                }
                if ((i16 & 2048) != 0) {
                    Shape outlinedTextFieldShape7 = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                    i10 &= -113;
                    shape3 = outlinedTextFieldShape7;
                } else {
                    shape3 = shape;
                }
                if ((i16 & 4096) != 0) {
                    i13 = i9;
                    i11 = i4;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                    composer3 = composerStartRestartGroup;
                    i12 = i10 & (-897);
                } else {
                    composer3 = composerStartRestartGroup;
                    i11 = i4;
                    i12 = i10;
                    i13 = i9;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                i16 = i3;
                if ((i16 & 8192) != 0) {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i12 &= -7169;
                } else {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i13 != 0) {
                    final boolean z15 = z6;
                    final TextFieldColors textFieldColors9 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
                    final Shape shape11 = shape3;
                    z7 = z15;
                    shape4 = shape11;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z15, interactionSource, textFieldColors9, shape11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                } else {
                    z7 = z6;
                    function2RememberComposableLambda = function7;
                    shape4 = shape3;
                }
                z8 = z7;
                function12 = function15;
                function13 = function16;
                function10 = function17;
                function14 = function18;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i14 = i11;
                ComposerKt.traceEventStart(1154925202, i14, i12, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:646)");
            } else {
                i14 = i11;
            }
            int i214 = i14 << 3;
            int i215 = i14 >> 9;
            int i216 = i12 << 6;
            Composer composer7 = composer3;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function12, function13, function10, function14, z2, z, z8, interactionSource, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, shape4, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, function2RememberComposableLambda, composer7, (i214 & 896) | (i214 & 112) | 6 | ((i14 >> 3) & 7168) | (57344 & i215) | (458752 & i215) | (i215 & 3670016) | ((i12 << 21) & 29360128) | ((i14 << 15) & 234881024) | ((i14 << 21) & C.ENCODING_PCM_DOUBLE), ((i14 >> 18) & 14) | ((i14 >> 12) & 112) | ((i12 >> 3) & 896) | (i216 & 7168) | (i216 & 57344) | ((i12 << 3) & 458752));
            composer2 = composer7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z8;
            paddingValues2 = paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
            shape2 = shape4;
            textFieldColors2 = textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
            function11 = function2RememberComposableLambda;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function10 = function5;
            shape2 = shape;
            textFieldColors2 = textFieldColors;
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function6;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i217 = i16;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function12, function13, function10, function14, shape2, textFieldColors2, paddingValues2, function11, i, i2, i217, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8461. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final /* synthetic */ void TextFieldDecorationBox(java.lang.String r58, kotlin.jvm.functions.Function2 r59, boolean r60, boolean r61, androidx.compose.ui.text.input.VisualTransformation r62, androidx.compose.foundation.interaction.InteractionSource r63, boolean r64, kotlin.jvm.functions.Function2 r65, kotlin.jvm.functions.Function2 r66, kotlin.jvm.functions.Function2 r67, kotlin.jvm.functions.Function2 r68, androidx.compose.material.TextFieldColors r69, androidx.compose.foundation.layout.PaddingValues r70, androidx.compose.runtime.Composer r71, int r72, int r73, int r74) {
        /*
            Method dump skipped, instruction units count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextFieldDecorationBox$lambda$2(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C730@34582L54:TextFieldDefaults.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922186815, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:730)");
            }
            INSTANCE.m2630BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, null, 0.0f, 0.0f, composer, 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0146  */
    /* JADX WARN: Code duplicated, block: B:110:0x015c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0162  */
    /* JADX WARN: Code duplicated, block: B:121:0x0176  */
    /* JADX WARN: Code duplicated, block: B:124:0x017e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0183  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:134:0x019c  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:160:0x0200 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0202  */
    /* JADX WARN: Code duplicated, block: B:162:0x0204  */
    /* JADX WARN: Code duplicated, block: B:165:0x0208  */
    /* JADX WARN: Code duplicated, block: B:166:0x020b  */
    /* JADX WARN: Code duplicated, block: B:168:0x020f  */
    /* JADX WARN: Code duplicated, block: B:169:0x0212  */
    /* JADX WARN: Code duplicated, block: B:171:0x0216  */
    /* JADX WARN: Code duplicated, block: B:172:0x0219  */
    /* JADX WARN: Code duplicated, block: B:174:0x021d  */
    /* JADX WARN: Code duplicated, block: B:175:0x0220  */
    /* JADX WARN: Code duplicated, block: B:178:0x0226  */
    /* JADX WARN: Code duplicated, block: B:179:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:182:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:183:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:185:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:186:0x0307  */
    /* JADX WARN: Code duplicated, block: B:190:0x0321  */
    /* JADX WARN: Code duplicated, block: B:191:0x032c  */
    /* JADX WARN: Code duplicated, block: B:194:0x036d  */
    /* JADX WARN: Code duplicated, block: B:196:0x0376  */
    /* JADX WARN: Code duplicated, block: B:199:0x038f  */
    /* JADX WARN: Code duplicated, block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x011f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0126  */
    /* JADX WARN: Code duplicated, block: B:94:0x012a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0134  */
    /* JADX WARN: Code duplicated, block: B:97:0x0137  */
    /* JADX WARN: Code duplicated, block: B:99:0x013c  */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2 function3, Function2 function4, Function2 function5, Function2 function6, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function7, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final boolean z4;
        Function2 function8;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        Composer composer2;
        final Function2 function9;
        final Function2 function10;
        final Function2 function11;
        final PaddingValues paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default;
        final Function2 function2RememberComposableLambda;
        final boolean z6;
        final Function2 function12;
        final TextFieldColors textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z7;
        Function2 function13;
        Function2 function14;
        Function2 function15;
        Function2 function16;
        int i12;
        Composer composer3;
        int i13;
        int i14;
        TextFieldDefaults textFieldDefaults;
        final boolean z8;
        Function2 function17;
        Function2 function18;
        Function2 function19;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2141154809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,colors,contentPadding,border)744@35133L22,732@34656L613:TextFieldDefaults.kt#jmzs0o");
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
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i16 = i3 & 64;
        if (i16 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i17 = i3 & 128;
        if (i17 != 0) {
            i4 |= 12582912;
            function8 = function3;
        } else {
            function8 = function3;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function8) ? 8388608 : 4194304;
            }
        }
        int i18 = i3 & 256;
        if (i18 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
        }
        int i19 = i3 & 512;
        if (i19 == 0) {
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
            if ((i2 & 48) != 0) {
                i6 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 384) != 0) {
                i6 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i8 = i6;
            i9 = i3 & 8192;
            if (i9 != 0) {
                i10 = i8;
                if ((i2 & 3072) == 0) {
                    i10 |= composerStartRestartGroup.changedInstance(function7) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    i10 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                i11 = i10;
                if ((i4 & 306783379) == 306783378 || (i11 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "728@34444L25,730@34580L58");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            z7 = false;
                        } else {
                            z7 = z4;
                        }
                        if (i17 != 0) {
                            function13 = null;
                        } else {
                            function13 = function8;
                        }
                        if (i18 != 0) {
                            function14 = null;
                        } else {
                            function14 = function4;
                        }
                        if (i19 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i5 != 0) {
                            function16 = null;
                        } else {
                            function16 = function6;
                        }
                        if ((i3 & 2048) != 0) {
                            i14 = i9;
                            i12 = i3;
                            i13 = i4;
                            textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                            composer3 = composerStartRestartGroup;
                            i11 &= -113;
                        } else {
                            i12 = i3;
                            composer3 = composerStartRestartGroup;
                            i13 = i4;
                            i14 = i9;
                            textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            i11 = i11;
                        }
                        if ((i12 & 4096) != 0) {
                            paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            textFieldDefaults = this;
                            i11 &= -897;
                        } else {
                            textFieldDefaults = this;
                            paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i14 != 0) {
                            z8 = z;
                            z4 = z7;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                        } else {
                            z8 = z;
                            z4 = z7;
                            function2RememberComposableLambda = function7;
                        }
                        function17 = function13;
                        function18 = function15;
                        function19 = function16;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2048) != 0) {
                            i11 &= -113;
                        }
                        if ((i3 & 4096) != 0) {
                            i11 &= -897;
                        }
                        function14 = function4;
                        function18 = function5;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        function2RememberComposableLambda = function7;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        function17 = function8;
                        function19 = function6;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        z8 = z;
                        textFieldDefaults = this;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        i15 = i13;
                        ComposerKt.traceEventStart(-2141154809, i15, i11, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:732)");
                    } else {
                        i15 = i13;
                    }
                    int i20 = i11 & 14;
                    int i21 = i11 << 3;
                    int i22 = i20 | (i21 & 896) | (i21 & 7168) | (57344 & i21) | (i21 & 458752);
                    Composer composer4 = composer3;
                    boolean z9 = z8;
                    boolean z10 = z4;
                    Function2 function20 = function14;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z9, z2, visualTransformation, interactionSource, z10, function17, function20, function18, function19, textFieldDefaults.getOutlinedTextFieldShape(composer3, (i11 >> 12) & 14), textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, composer4, i15 & 2147483646, i22, 0);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function11 = function19;
                    function10 = function18;
                    function9 = function20;
                    function12 = function17;
                    z6 = z10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function9 = function4;
                    function10 = function5;
                    function11 = function6;
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    function2RememberComposableLambda = function7;
                    z6 = z4;
                    function12 = function8;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function12, function9, function10, function11, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 = i8 | 3072;
            if ((i2 & 24576) == 0) {
                i10 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
            }
            i11 = i10;
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "728@34444L25,730@34580L58");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (i17 != 0) {
                        function13 = null;
                    } else {
                        function13 = function8;
                    }
                    if (i18 != 0) {
                        function14 = null;
                    } else {
                        function14 = function4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i5 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    if ((i3 & 2048) != 0) {
                        i14 = i9;
                        i12 = i3;
                        i13 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i11 &= -113;
                    } else {
                        i12 = i3;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        i14 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        i11 = i11;
                    }
                    if ((i12 & 4096) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        textFieldDefaults = this;
                        i11 &= -897;
                    } else {
                        textFieldDefaults = this;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i14 != 0) {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = function7;
                    }
                    function17 = function13;
                    function18 = function15;
                    function19 = function16;
                } else {
                    if (i16 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (i17 != 0) {
                        function13 = null;
                    } else {
                        function13 = function8;
                    }
                    if (i18 != 0) {
                        function14 = null;
                    } else {
                        function14 = function4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i5 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    if ((i3 & 2048) != 0) {
                        i14 = i9;
                        i12 = i3;
                        i13 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i11 &= -113;
                    } else {
                        i12 = i3;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        i14 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        i11 = i11;
                    }
                    if ((i12 & 4096) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        textFieldDefaults = this;
                        i11 &= -897;
                    } else {
                        textFieldDefaults = this;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i14 != 0) {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = function7;
                    }
                    function17 = function13;
                    function18 = function15;
                    function19 = function16;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i15 = i13;
                    ComposerKt.traceEventStart(-2141154809, i15, i11, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:732)");
                } else {
                    i15 = i13;
                }
                int i23 = i11 & 14;
                int i24 = i11 << 3;
                int i25 = i23 | (i24 & 896) | (i24 & 7168) | (57344 & i24) | (i24 & 458752);
                Composer composer5 = composer3;
                boolean z11 = z8;
                boolean z12 = z4;
                Function2 function21 = function14;
                textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z11, z2, visualTransformation, interactionSource, z12, function17, function21, function18, function19, textFieldDefaults.getOutlinedTextFieldShape(composer3, (i11 >> 12) & 14), textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, composer5, i15 & 2147483646, i25, 0);
                composer2 = composer5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function11 = function19;
                function10 = function18;
                function9 = function21;
                function12 = function17;
                z6 = z12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function9 = function4;
                function10 = function5;
                function11 = function6;
                paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                function2RememberComposableLambda = function7;
                z6 = z4;
                function12 = function8;
                textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function12, function9, function10, function11, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
        if ((i2 & 48) != 0) {
            i6 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
        }
        if ((i2 & 384) != 0) {
            i6 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
        }
        i8 = i6;
        i9 = i3 & 8192;
        if (i9 != 0) {
            i10 = i8;
            if ((i2 & 3072) == 0) {
                i10 |= composerStartRestartGroup.changedInstance(function7) ? 2048 : 1024;
            }
            if ((i2 & 24576) == 0) {
                i10 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
            }
            i11 = i10;
            if ((i4 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "728@34444L25,730@34580L58");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (i17 != 0) {
                        function13 = null;
                    } else {
                        function13 = function8;
                    }
                    if (i18 != 0) {
                        function14 = null;
                    } else {
                        function14 = function4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i5 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    if ((i3 & 2048) != 0) {
                        i14 = i9;
                        i12 = i3;
                        i13 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i11 &= -113;
                    } else {
                        i12 = i3;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        i14 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        i11 = i11;
                    }
                    if ((i12 & 4096) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        textFieldDefaults = this;
                        i11 &= -897;
                    } else {
                        textFieldDefaults = this;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i14 != 0) {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = function7;
                    }
                    function17 = function13;
                    function18 = function15;
                    function19 = function16;
                } else {
                    if (i16 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (i17 != 0) {
                        function13 = null;
                    } else {
                        function13 = function8;
                    }
                    if (i18 != 0) {
                        function14 = null;
                    } else {
                        function14 = function4;
                    }
                    if (i19 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i5 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    if ((i3 & 2048) != 0) {
                        i14 = i9;
                        i12 = i3;
                        i13 = i4;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                        composer3 = composerStartRestartGroup;
                        i11 &= -113;
                    } else {
                        i12 = i3;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        i14 = i9;
                        textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        i11 = i11;
                    }
                    if ((i12 & 4096) != 0) {
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        textFieldDefaults = this;
                        i11 &= -897;
                    } else {
                        textFieldDefaults = this;
                        paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i14 != 0) {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                    } else {
                        z8 = z;
                        z4 = z7;
                        function2RememberComposableLambda = function7;
                    }
                    function17 = function13;
                    function18 = function15;
                    function19 = function16;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i15 = i13;
                    ComposerKt.traceEventStart(-2141154809, i15, i11, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:732)");
                } else {
                    i15 = i13;
                }
                int i26 = i11 & 14;
                int i27 = i11 << 3;
                int i28 = i26 | (i27 & 896) | (i27 & 7168) | (57344 & i27) | (i27 & 458752);
                Composer composer6 = composer3;
                boolean z13 = z8;
                boolean z14 = z4;
                Function2 function22 = function14;
                textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z13, z2, visualTransformation, interactionSource, z14, function17, function22, function18, function19, textFieldDefaults.getOutlinedTextFieldShape(composer3, (i11 >> 12) & 14), textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, composer6, i15 & 2147483646, i28, 0);
                composer2 = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function11 = function19;
                function10 = function18;
                function9 = function22;
                function12 = function17;
                z6 = z14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function9 = function4;
                function10 = function5;
                function11 = function6;
                paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                function2RememberComposableLambda = function7;
                z6 = z4;
                function12 = function8;
                textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function12, function9, function10, function11, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i10 = i8 | 3072;
        if ((i2 & 24576) == 0) {
            i10 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
        }
        i11 = i10;
        if ((i4 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "728@34444L25,730@34580L58");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (i17 != 0) {
                    function13 = null;
                } else {
                    function13 = function8;
                }
                if (i18 != 0) {
                    function14 = null;
                } else {
                    function14 = function4;
                }
                if (i19 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i5 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                if ((i3 & 2048) != 0) {
                    i14 = i9;
                    i12 = i3;
                    i13 = i4;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                    composer3 = composerStartRestartGroup;
                    i11 &= -113;
                } else {
                    i12 = i3;
                    composer3 = composerStartRestartGroup;
                    i13 = i4;
                    i14 = i9;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    i11 = i11;
                }
                if ((i12 & 4096) != 0) {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    textFieldDefaults = this;
                    i11 &= -897;
                } else {
                    textFieldDefaults = this;
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i14 != 0) {
                    z8 = z;
                    z4 = z7;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                } else {
                    z8 = z;
                    z4 = z7;
                    function2RememberComposableLambda = function7;
                }
                function17 = function13;
                function18 = function15;
                function19 = function16;
            } else {
                if (i16 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (i17 != 0) {
                    function13 = null;
                } else {
                    function13 = function8;
                }
                if (i18 != 0) {
                    function14 = null;
                } else {
                    function14 = function4;
                }
                if (i19 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i5 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                if ((i3 & 2048) != 0) {
                    i14 = i9;
                    i12 = i3;
                    i13 = i4;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = m2636outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                    composer3 = composerStartRestartGroup;
                    i11 &= -113;
                } else {
                    i12 = i3;
                    composer3 = composerStartRestartGroup;
                    i13 = i4;
                    i14 = i9;
                    textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    i11 = i11;
                }
                if ((i12 & 4096) != 0) {
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = m2627outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    textFieldDefaults = this;
                    i11 &= -897;
                } else {
                    textFieldDefaults = this;
                    paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i14 != 0) {
                    z8 = z;
                    z4 = z7;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z8, z4, interactionSource, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                } else {
                    z8 = z;
                    z4 = z7;
                    function2RememberComposableLambda = function7;
                }
                function17 = function13;
                function18 = function15;
                function19 = function16;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i15 = i13;
                ComposerKt.traceEventStart(-2141154809, i15, i11, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:732)");
            } else {
                i15 = i13;
            }
            int i29 = i11 & 14;
            int i210 = i11 << 3;
            int i211 = i29 | (i210 & 896) | (i210 & 7168) | (57344 & i210) | (i210 & 458752);
            Composer composer7 = composer3;
            boolean z15 = z8;
            boolean z16 = z4;
            Function2 function23 = function14;
            textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z15, z2, visualTransformation, interactionSource, z16, function17, function23, function18, function19, textFieldDefaults.getOutlinedTextFieldShape(composer3, (i11 >> 12) & 14), textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, composer7, i15 & 2147483646, i211, 0);
            composer2 = composer7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function11 = function19;
            function10 = function18;
            function9 = function23;
            function12 = function17;
            z6 = z16;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function9 = function4;
            function10 = function5;
            function11 = function6;
            paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
            function2RememberComposableLambda = function7;
            z6 = z4;
            function12 = function8;
            textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs = textFieldColors;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function12, function9, function10, function11, textFieldColorsM2636outlinedTextFieldColorsdx8h9Zs, paddingValuesM2627outlinedTextFieldPaddinga9UjIt4$default, function2RememberComposableLambda, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m2635indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        final boolean z3;
        final boolean z4;
        final InteractionSource interactionSource2;
        final TextFieldColors textFieldColors2;
        final float f3;
        final float f4;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            z3 = z;
            z4 = z2;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f3 = f;
            f4 = f2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("indicatorLine");
                    inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z3));
                    inspectorInfo.getProperties().set("isError", Boolean.valueOf(z4));
                    inspectorInfo.getProperties().set("interactionSource", interactionSource2);
                    inspectorInfo.getProperties().set("colors", textFieldColors2);
                    inspectorInfo.getProperties().set("focusedIndicatorLineThickness", Dp.m9685boximpl(f3));
                    inspectorInfo.getProperties().set("unfocusedIndicatorLineThickness", Dp.m9685boximpl(f4));
                }
            };
        } else {
            z3 = z;
            z4 = z2;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f3 = f;
            f4 = f2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final float f5 = f4;
        final float f6 = f3;
        final TextFieldColors textFieldColors3 = textFieldColors2;
        final InteractionSource interactionSource3 = interactionSource2;
        final boolean z5 = z4;
        final boolean z6 = z3;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new Function3() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldDefaults.indicatorLine_gv0btCI$lambda$1(z6, z5, interactionSource3, textFieldColors3, f6, f5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }
}
