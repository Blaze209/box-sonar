package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.TextFieldLabelScope;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.common.C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\u001a\u0099\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010 \u001a2\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b0\u00101\u001a*\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b2\u00103\u001a\u001c\u00104\u001a\u000205*\u0002052\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0000\u001a\u001c\u00108\u001a\u000205*\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0000\u001a\u001a\u0010=\u001a\u000205*\u0002052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0007H\u0000\u001aÔ\u0001\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010!\u001a\u00020\u00162\u0099\u0001\u0010/\u001a\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(L\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(N\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\b\bH\u0083\b¢\u0006\u0004\bP\u0010Q\u001aE\u0010R\u001a\b\u0012\u0004\u0012\u00020S0G2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020?H\u0001¢\u0006\u0004\bW\u0010X\u001a\r\u0010b\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\u001a\r\u0010d\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\"\u0018\u0010!\u001a\u00020\u0016*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0018\u0010(\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'\"\u000e\u0010Y\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010e\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0016\u0010i\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010g\"\u0016\u0010k\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bl\u0010g\"\u0016\u0010m\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bn\u0010g\"\u0016\u0010o\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bp\u0010g\"\u0016\u0010q\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\br\u0010g\"\u0016\u0010s\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bt\u0010g\"\u0016\u0010u\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bv\u0010g¨\u0006w²\u0006\n\u0010x\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010y\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "visualText", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Lkotlin/ExtensionFunctionType;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", TtmlNode.RUBY_CONTAINER, "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "showExpandedLabel", "getShowExpandedLabel", "(Landroidx/compose/material3/TextFieldLabelPosition;)Z", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getMinimizedAlignment", "(Landroidx/compose/material3/TextFieldLabelPosition;)Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "getExpandedAlignment", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "textFieldLabelMinHeight", ViewProps.MIN_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "textFieldHorizontalIconPadding", "(Landroidx/compose/runtime/Composer;I)F", "minimizedLabelHalfHeight", "TextFieldPadding", "getTextFieldPadding", "()F", "F", "AboveLabelHorizontalPadding", "getAboveLabelHorizontalPadding", "AboveLabelBottomPadding", "getAboveLabelBottomPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "material3", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldImplKt {
    private static final float AboveLabelBottomPadding;
    private static final float AboveLabelHorizontalPadding;
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final float PrefixSuffixTextPadding = Dp.m9687constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m9687constructorimpl(24);

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$3(TextFieldType textFieldType, CharSequence charSequence, Function2 function2, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, Function2 function9, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2 function10, int i, int i2, Composer composer, int i3) {
        CommonDecorationBox(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function4, function5, function6, function7, function8, function9, z, z2, z3, interactionSource, paddingValues, textFieldColors, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_3J_VO9M$lambda$0(long j, TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        m5101Decoration3JVO9M(j, textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_Iv8Zu3U$lambda$0(long j, Function2 function2, int i, Composer composer, int i2) {
        m5102DecorationIv8Zu3U(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:231:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:249:0x041c  */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final CharSequence charSequence, final Function2<? super Composer, ? super Integer, Unit> function2, final TextFieldLabelPosition textFieldLabelPosition, final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final Function2<? super Composer, ? super Integer, Unit> function7, final Function2<? super Composer, ? super Integer, Unit> function8, final Function2<? super Composer, ? super Integer, Unit> function9, final boolean z, final boolean z2, final boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function10, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        TextFieldColors textFieldColors2;
        Composer composer2;
        InputPhase inputPhase;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i6;
        Composer composer3;
        int i7;
        final TextStyle textStyle;
        final TextStyle textStyle2;
        final State state;
        ComposableLambda composableLambda;
        final State state2;
        final State state3;
        ComposableLambda composableLambda2;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ComposableLambda composableLambda3;
        int i8;
        ComposableLambda composableLambdaRememberComposableLambda3;
        Composer composerStartRestartGroup = composer.startRestartGroup(546805032);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonDecorationBox)N(type,visualText,innerTextField,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,singleLine,enabled,isError,interactionSource,contentPadding,colors,container)99@4125L25,109@4463L10,116@4780L8045:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(textFieldType.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i4 = i3 | (composerStartRestartGroup.changedInstance(charSequence) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldLabelPosition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function8) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i9 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function9) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            textFieldColors2 = textFieldColors;
            i5 |= composerStartRestartGroup.changed(textFieldColors2) ? 1048576 : 524288;
        } else {
            textFieldColors2 = textFieldColors;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function10) ? 8388608 : 4194304;
        }
        int i10 = i5;
        if (composerStartRestartGroup.shouldExecute(((i9 & 306783379) == 306783378 && (4793491 & i10) == 4793490) ? false : true, i9 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546805032, i9, i10, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:98)");
            }
            boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i10 >> 12) & 14).getValue().booleanValue();
            if (zBooleanValue) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = charSequence.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            long jM4446labelColorXeAY9LY = textFieldColors2.m4446labelColorXeAY9LY(z2, z3, zBooleanValue);
            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            final TextStyle bodyLarge = typography.getBodyLarge();
            final TextStyle bodySmall = typography.getBodySmall();
            boolean z4 = (Color.m6815equalsimpl0(bodyLarge.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()) && !Color.m6815equalsimpl0(bodySmall.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU())) || (!Color.m6815equalsimpl0(bodyLarge.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()) && Color.m6815equalsimpl0(bodySmall.m9121getColor0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU()));
            long jM9121getColor0d7_KjU = bodySmall.m9121getColor0d7_KjU();
            if (z4 && jM9121getColor0d7_KjU == 16) {
                jM9121getColor0d7_KjU = jM4446labelColorXeAY9LY;
            }
            long jM9121getColor0d7_KjU2 = bodyLarge.m9121getColor0d7_KjU();
            if (z4 && jM9121getColor0d7_KjU2 == 16) {
                jM9121getColor0d7_KjU2 = jM4446labelColorXeAY9LY;
            }
            boolean z5 = function3 != null && getShowExpandedLabel(textFieldLabelPosition);
            long j = jM9121getColor0d7_KjU;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2132505973, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
            Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composerStartRestartGroup, 48, 0);
            TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$1 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase2 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1436405362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
            }
            int i11 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
            float f6 = 1.0f;
            if (i11 == 1) {
                f = 1.0f;
            } else {
                if (i11 != 2) {
                    if (i11 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z5) {
                    f = 0.0f;
                }
                f = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f);
            InputPhase inputPhase3 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-1436405362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
            }
            int i12 = WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()];
            if (i12 == 1) {
                f2 = 1.0f;
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z5) {
                    f2 = 0.0f;
                }
                f2 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composerStartRestartGroup, 6));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase4 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1093194547);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
            }
            int i13 = WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()];
            if (i13 == 1) {
                f3 = 1.0f;
            } else {
                if (i13 != 2) {
                    if (i13 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (!z5) {
                    f3 = 1.0f;
                }
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f3);
            InputPhase inputPhase5 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-1093194547);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
            }
            int i14 = WhenMappings.$EnumSwitchMapping$1[inputPhase5.ordinal()];
            if (i14 == 1) {
                f4 = 1.0f;
            } else {
                if (i14 != 2) {
                    if (i14 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (!z5) {
                    f4 = 1.0f;
                }
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase6 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }
            int i15 = WhenMappings.$EnumSwitchMapping$1[inputPhase6.ordinal()];
            if (i15 == 1) {
                f5 = 1.0f;
            } else {
                if (i15 != 2) {
                    if (i15 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z5) {
                    f5 = 0.0f;
                }
                f5 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(f5);
            InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }
            int i16 = WhenMappings.$EnumSwitchMapping$1[inputPhase7.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z5) {
                    f6 = 0.0f;
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            long j2 = WhenMappings.$EnumSwitchMapping$1[inputPhase8.ordinal()] == 1 ? j : jM9121getColor0d7_KjU2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            ColorSpace colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM6818getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase9 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            long j3 = WhenMappings.$EnumSwitchMapping$1[inputPhase9.ordinal()] == 1 ? j : jM9121getColor0d7_KjU2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6804boximpl = Color.m6804boximpl(j3);
            InputPhase inputPhase10 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase10.ordinal()] == 1) {
                jM9121getColor0d7_KjU2 = j;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl, Color.m6804boximpl(jM9121getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "LabelTextStyleColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            composerStartRestartGroup.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            ColorSpace colorSpaceM6818getColorSpaceimpl2 = Color.m6818getColorSpaceimpl(jM4446labelColorXeAY9LY);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(colorSpaceM6818getColorSpaceimpl2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            composerStartRestartGroup.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6804boximpl2 = Color.m6804boximpl(jM4446labelColorXeAY9LY);
            composerStartRestartGroup.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                i6 = 0;
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            } else {
                i6 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl2, Color.m6804boximpl(jM4446labelColorXeAY9LY), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, Integer.valueOf(i6)), twoWayConverter2, "LabelContentColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891788529, "CN(labelProgress,labelTextStyleColor,labelContentColor,placeholderAlpha,prefixSuffixAlpha)130@5443L184,155@6570L107,172@7353L108:TextFieldImpl.kt#mqatfk");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493157227, "CC(remember):TextFieldImpl.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new TextFieldLabelScope() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1
                    @Override // androidx.compose.material3.TextFieldLabelScope
                    public float getLabelMinimizedProgress() {
                        return stateCreateTransitionAnimation.getValue().floatValue();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$1 = (TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda4 = null;
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(-1891724857);
                composerStartRestartGroup.endReplaceGroup();
                composer3 = composerStartRestartGroup;
                textStyle = bodyLarge;
                textStyle2 = bodySmall;
                i7 = 54;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1891724856);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*138@5746L526");
                composer3 = composerStartRestartGroup;
                i7 = 54;
                final boolean z6 = z4;
                Function2 function11 = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$1$0(bodyLarge, bodySmall, stateCreateTransitionAnimation, stateCreateTransitionAnimation5, z6, stateCreateTransitionAnimation4, function3, textFieldImplKt$CommonDecorationBox$3$labelScope$1$1, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                textStyle = bodyLarge;
                textStyle2 = bodySmall;
                composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1076580032, true, function11, composer3, 54);
                composer3.endReplaceGroup();
            }
            ComposableLambda composableLambda4 = composableLambdaRememberComposableLambda4;
            final long jM4448placeholderColorXeAY9LY = textFieldColors.m4448placeholderColorXeAY9LY(z2, z3, r35);
            ComposerKt.sourceInformationMarkerStart(composer3, 493193214, r2);
            Object objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                state = stateCreateTransitionAnimation2;
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$2$2$0(state));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue4);
            } else {
                state = stateCreateTransitionAnimation2;
            }
            State state4 = (State) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (function4 != null && charSequence.length() == 0 && CommonDecorationBox$lambda$2$3(state4)) {
                composer3.startReplaceGroup(-1890614312);
                ComposerKt.sourceInformation(composer3, "160@6858L363");
                final State state5 = state;
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1405547205, true, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$4(state5, jM4448placeholderColorXeAY9LY, textStyle, function4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, i7);
                composer3.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda5;
            } else {
                composer3.startReplaceGroup(-1890217110);
                composer3.endReplaceGroup();
                composableLambda = null;
            }
            final long jM4449prefixColorXeAY9LY = textFieldColors.m4449prefixColorXeAY9LY(z2, z3, r35);
            ComposerKt.sourceInformationMarkerStart(composer3, 493218271, r2);
            Object objRememberedValue5 = composer3.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                state2 = stateCreateTransitionAnimation3;
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$2$5$0(state2));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue5);
            } else {
                state2 = stateCreateTransitionAnimation3;
            }
            State state6 = (State) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (function7 == null || !CommonDecorationBox$lambda$2$6(state6)) {
                state3 = state2;
                composer3.startReplaceGroup(-1889500886);
                composer3.endReplaceGroup();
                composableLambda2 = null;
            } else {
                composer3.startReplaceGroup(-1889877907);
                ComposerKt.sourceInformation(composer3, "177@7601L342");
                state3 = state2;
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(606594655, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$7(state3, jM4449prefixColorXeAY9LY, textStyle, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, i7);
                composer3.endReplaceGroup();
                composableLambda2 = composableLambdaRememberComposableLambda6;
            }
            final long jM4450suffixColorXeAY9LY = textFieldColors.m4450suffixColorXeAY9LY(z2, z3, r35);
            if (function8 == null || !CommonDecorationBox$lambda$2$6(state6)) {
                composer3.startReplaceGroup(-1888924534);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composer3.startReplaceGroup(-1889301555);
                ComposerKt.sourceInformation(composer3, "191@8182L342");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-45078754, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$8(state3, jM4450suffixColorXeAY9LY, textStyle, function8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, i7);
                composer3.endReplaceGroup();
            }
            final long jM4447leadingIconColorXeAY9LY = textFieldColors.m4447leadingIconColorXeAY9LY(z2, z3, r35);
            if (function5 == null) {
                composer3.startReplaceGroup(-1888749663);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composer3.startReplaceGroup(-1888749662);
                ComposerKt.sourceInformation(composer3, "*205@8751L61");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1736293487, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$9$0(jM4447leadingIconColorXeAY9LY, function5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, i7);
                composer3.endReplaceGroup();
            }
            final long jM4453trailingIconColorXeAY9LY = textFieldColors.m4453trailingIconColorXeAY9LY(z2, z3, r35);
            if (function6 == null) {
                composer3.startReplaceGroup(-1888469888);
                composer3.endReplaceGroup();
                composableLambda3 = null;
            } else {
                composer3.startReplaceGroup(-1888469887);
                ComposerKt.sourceInformation(composer3, "*211@9033L62");
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(1334518521, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$10$0(jM4453trailingIconColorXeAY9LY, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda3 = composableLambdaRememberComposableLambda7;
            }
            final long jM4451supportingTextColorXeAY9LY = textFieldColors.m4451supportingTextColorXeAY9LY(z2, z3, zBooleanValue);
            if (function9 == null) {
                composer3.startReplaceGroup(-1888176380);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda3 = null;
                i8 = 1;
            } else {
                composer3.startReplaceGroup(-1888176379);
                ComposerKt.sourceInformation(composer3, "*217@9324L218");
                Function2 function12 = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$11$0(jM4451supportingTextColorXeAY9LY, textStyle2, function9, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                i8 = 1;
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(837168720, true, function12, composer3, 54);
                composer3.endReplaceGroup();
            }
            int i17 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
            if (i17 == i8) {
                Composer composer4 = composer3;
                composer4.startReplaceGroup(-1887830698);
                ComposerKt.sourceInformation(composer4, "228@9680L167,234@9865L722");
                ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-1729858187, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$12(function10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer4, 54);
                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda4, composableLambda, composableLambdaRememberComposableLambda2, composableLambda3, composableLambda2, composableLambdaRememberComposableLambda, z, textFieldLabelPosition, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new PropertyReference0Impl(stateCreateTransitionAnimation) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), composableLambdaRememberComposableLambda8, composableLambdaRememberComposableLambda3, paddingValues, composer4, ((i9 >> 3) & 112) | 6 | ((i10 << 21) & 234881024) | ((i9 << 18) & C.ENCODING_PCM_DOUBLE), ((i10 >> 6) & 7168) | 48);
                composer2 = composer4;
                composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else {
                if (i17 != 2) {
                    Composer composer5 = composer3;
                    composer5.startReplaceGroup(493292232);
                    composer5.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer3.startReplaceGroup(-1886778186);
                ComposerKt.sourceInformation(composer3, "253@10710L38,254@10817L517,279@11893L667,268@11352L1443");
                ComposerKt.sourceInformationMarkerStart(composer3, 493325625, r2);
                Object objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m6626boximpl(Size.INSTANCE.m6647getZeroNHjbRc()), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposableLambda composableLambda5 = composableLambdaRememberComposableLambda3;
                ComposableLambda composableLambda6 = composableLambdaRememberComposableLambda;
                ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(528115858, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$14(mutableState, textFieldLabelPosition, paddingValues, function10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                Modifier.Companion companion = Modifier.INSTANCE;
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new PropertyReference0Impl(stateCreateTransitionAnimation) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$2
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                });
                Modifier.Companion companion2 = companion;
                ComposerKt.sourceInformationMarkerStart(composer3, 493364110, "CC(remember):TextFieldImpl.kt#9igjgp");
                boolean zChanged3 = ((i9 & 7168) == 2048) | composer3.changed(stateCreateTransitionAnimation);
                Object objRememberedValue7 = composer3.rememberedValue();
                if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TextFieldImplKt.CommonDecorationBox$lambda$2$15$0(textFieldLabelPosition, stateCreateTransitionAnimation, mutableState, (Size) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion2, function2, composableLambda, composableLambda4, composableLambdaRememberComposableLambda2, composableLambda3, composableLambda2, composableLambda6, z, textFieldLabelPosition, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, (Function1) objRememberedValue7, composableLambdaRememberComposableLambda9, composableLambda5, paddingValues, composer3, ((i9 >> 3) & 112) | 6 | ((i10 << 21) & 234881024) | ((i9 << 18) & C.ENCODING_PCM_DOUBLE), (57344 & (i10 >> 3)) | 384);
                Composer composer6 = composer3;
                composer6.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
                composer2 = composer6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.CommonDecorationBox$lambda$3(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function4, function5, function6, function7, function8, function9, z, z2, z3, interactionSource, paddingValues, textFieldColors, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$1$0(TextStyle textStyle, TextStyle textStyle2, State state, State state2, boolean z, State state3, final Function3 function3, final TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@6232L22,147@6180L74:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076580032, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:139)");
            }
            TextStyle textStyleLerp = TextStyleKt.lerp(textStyle, textStyle2, ((Number) state.getValue()).floatValue());
            if (z) {
                textStyleLerp = TextStyle.m9104copyp1EtxEg$default(textStyleLerp, ((Color) state3.getValue()).m6824unboximpl(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            }
            m5101Decoration3JVO9M(((Color) state2.getValue()).m6824unboximpl(), textStyleLerp, ComposableLambdaKt.rememberComposableLambda(1157484991, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.CommonDecorationBox$lambda$2$1$0$1(function3, textFieldImplKt$CommonDecorationBox$3$labelScope$1$1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$1$0$1(Function3 function3, TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@6245L7:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1157484991, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:147)");
            }
            function3.invoke(textFieldImplKt$CommonDecorationBox$3$labelScope$1$1, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$2$2$0(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$4(final State state, long j, TextStyle textStyle, Function2 function2, Modifier modifier, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(modifier)161@6919L34,161@6892L311:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i |= composer.changed(modifier) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1405547205, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:161)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2111135047, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean zChanged = composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$4$0$0(state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composer, -468847204, "C162@6981L200:TextFieldImpl.kt#mqatfk");
            m5101Decoration3JVO9M(j, textStyle, function2, composer, 0);
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
    public static final Unit CommonDecorationBox$lambda$2$4$0$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$2$5$0(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$7(final State state, long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C178@7650L35,178@7623L302:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(606594655, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:178)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1178087198, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean zChanged = composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$7$0$0(state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1145412160, "C179@7713L190:TextFieldImpl.kt#mqatfk");
            m5101Decoration3JVO9M(j, textStyle, function2, composer, 0);
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
    public static final Unit CommonDecorationBox$lambda$2$7$0$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$8(final State state, long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@8231L35,192@8204L302:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-45078754, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:192)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -371008031, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean zChanged = composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$2$8$0$0(state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1895761759, "C193@8294L190:TextFieldImpl.kt#mqatfk");
            m5101Decoration3JVO9M(j, textStyle, function2, composer, 0);
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
    public static final Unit CommonDecorationBox$lambda$2$8$0$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$9$0(long j, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C205@8753L57:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1736293487, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:205)");
            }
            m5102DecorationIv8Zu3U(j, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$10$0(long j, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C211@9035L58:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1334518521, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:211)");
            }
            m5102DecorationIv8Zu3U(j, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$11$0(long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C218@9346L178:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(837168720, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:218)");
            }
            m5101Decoration3JVO9M(j, textStyle, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$2$12(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C229@9702L127:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1729858187, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:229)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, ContainerId);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2113149629, "C230@9796L11:TextFieldImpl.kt#mqatfk");
            function2.invoke(composer, 0);
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
    public static final Unit CommonDecorationBox$lambda$2$14(final MutableState mutableState, TextFieldLabelPosition textFieldLabelPosition, PaddingValues paddingValues, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C255@10839L477:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(528115858, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:255)");
            }
            Modifier modifierOutlineCutout = OutlinedTextFieldKt.outlineCutout(LayoutIdKt.layoutId(Modifier.INSTANCE, ContainerId), new MutablePropertyReference0Impl(mutableState) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((MutableState) this.receiver).getValue();
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    ((MutableState) this.receiver).setValue(obj);
                }
            }, getMinimizedAlignment(textFieldLabelPosition), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOutlineCutout);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1233755264, "C264@11283L11:TextFieldImpl.kt#mqatfk");
            function2.invoke(composer, 0);
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
    public static final Unit CommonDecorationBox$lambda$2$15$0(TextFieldLabelPosition textFieldLabelPosition, State state, MutableState mutableState, Size size) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return Unit.INSTANCE;
        }
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m6643unboximpl() >> 32)) * fFloatValue;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m6643unboximpl() & 4294967295L)) * fFloatValue;
        if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6643unboximpl() >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6643unboximpl() & 4294967295L)) != fIntBitsToFloat2) {
            mutableState.setValue(Size.m6626boximpl(Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    private static final boolean getShowExpandedLabel(TextFieldLabelPosition textFieldLabelPosition) {
        return (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) && !((TextFieldLabelPosition.Attached) textFieldLabelPosition).getAlwaysMinimize();
    }

    public static final Alignment.Horizontal getMinimizedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getMinimizedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    public static final Alignment.Horizontal getExpandedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getExpandedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    private static final void m5101Decoration3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        final TextStyle textStyle2;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(396611577);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,textStyle,content)325@13794L62:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(396611577, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:325)");
            }
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, composerStartRestartGroup, i2 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
            j2 = j;
            textStyle2 = textStyle;
            function3 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function3 = function2;
            textStyle2 = textStyle;
            j2 = j;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_3J_VO9M$lambda$0(j2, textStyle2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    private static final void m5102DecorationIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(590397809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,content)330@14001L84:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590397809, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:330)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_Iv8Zu3U$lambda$0(j, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda8
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

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$0(shape, colorProducer, (CacheDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult textFieldBackground$lambda$0(Shape shape, final ColorProducer colorProducer, CacheDrawScope cacheDrawScope) {
        final Outline outlineMo655createOutlinePq9zytI = shape.mo655createOutlinePq9zytI(cacheDrawScope.m6349getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        return cacheDrawScope.onDrawBehind(new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$0$0(outlineMo655createOutlinePq9zytI, colorProducer, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldBackground$lambda$0$0(Outline outline, ColorProducer colorProducer, DrawScope drawScope) {
        OutlineKt.m7089drawOutlinewDX37Ww$default(drawScope, outline, colorProducer.mo2379invoke0d7_KjU(), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldLabelMinHeight(Modifier modifier, final Function0<Dp> function0) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$0(function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult textFieldLabelMinHeight$lambda$0(Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fM9701unboximpl = ((Dp) function0.invoke()).m9701unboximpl();
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), 0, 0, ConstraintsKt.m9656constrainHeightK40F9xA(constraints.getValue(), !Dp.m9692equalsimpl0(fM9701unboximpl, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM()) ? measureScope.mo748roundToPx0680j_4(fM9701unboximpl) : 0), 0, 11, null));
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldLabelMinHeight$lambda$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0251 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0254  */
    /* JADX WARN: Code duplicated, block: B:105:0x025c  */
    /* JADX WARN: Code duplicated, block: B:108:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:112:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:118:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:120:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:123:0x031a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0327  */
    /* JADX WARN: Code duplicated, block: B:127:0x032a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0332  */
    /* JADX WARN: Code duplicated, block: B:133:0x034e  */
    /* JADX WARN: Code duplicated, block: B:136:0x035b  */
    /* JADX WARN: Code duplicated, block: B:137:0x035e  */
    /* JADX WARN: Code duplicated, block: B:140:0x0366  */
    /* JADX WARN: Code duplicated, block: B:143:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:146:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:149:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:154:0x040d  */
    /* JADX WARN: Code duplicated, block: B:157:0x0416  */
    /* JADX WARN: Code duplicated, block: B:160:0x0432  */
    /* JADX WARN: Code duplicated, block: B:163:0x043b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0157  */
    /* JADX WARN: Code duplicated, block: B:55:0x0173  */
    /* JADX WARN: Code duplicated, block: B:58:0x0180  */
    /* JADX WARN: Code duplicated, block: B:60:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0188  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0191  */
    /* JADX WARN: Code duplicated, block: B:69:0x0199  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:75:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:77:0x0201  */
    /* JADX WARN: Code duplicated, block: B:80:0x0205  */
    /* JADX WARN: Code duplicated, block: B:82:0x020b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x020d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0210  */
    /* JADX WARN: Code duplicated, block: B:87:0x0218  */
    /* JADX WARN: Code duplicated, block: B:90:0x0234  */
    /* JADX WARN: Code duplicated, block: B:93:0x0244  */
    /* JADX WARN: Code duplicated, block: B:95:0x0247  */
    /* JADX WARN: Code duplicated, block: B:98:0x024b  */
    /* JADX INFO: renamed from: TextFieldTransitionScope-Jy8F4Js, reason: not valid java name */
    private static final void m5103TextFieldTransitionScopeJy8F4Js(InputPhase inputPhase, long j, long j2, long j3, boolean z, Function7<? super State<Float>, ? super State<Color>, ? super State<Color>, ? super State<Float>, ? super State<Float>, ? super Composer, ? super Integer, Unit> function7, Composer composer, int i) {
        float f;
        float f2;
        int i2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        InputPhase inputPhase2;
        long j4;
        ColorSpace colorSpaceM6818getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        InputPhase inputPhase3;
        long j5;
        InputPhase inputPhase4;
        long j6;
        ColorSpace colorSpaceM6818getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue2;
        ComposerKt.sourceInformationMarkerStart(composer, -2132505973, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
        Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composer, (i & 14) | 48, 0);
        TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$1 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6));
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase5 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1436405362);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[inputPhase5.ordinal()];
        float f6 = 0.0f;
        if (i6 == 1) {
            f = 1.0f;
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f = 0.0f;
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        InputPhase inputPhase6 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1436405362);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
        }
        int i7 = WhenMappings.$EnumSwitchMapping$1[inputPhase6.ordinal()];
        if (i7 == 1) {
            f2 = 1.0f;
        } else {
            if (i7 != 2) {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f2 = 0.0f;
            }
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter, "LabelProgress", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer, 6));
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1093194547);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
        }
        int i8 = WhenMappings.$EnumSwitchMapping$1[inputPhase7.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                i2 = 3;
                if (z) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f3);
                InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-1093194547);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
                }
                i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase8.ordinal()];
                if (i3 == 1) {
                    f4 = 1.0f;
                } else {
                    if (i3 != 2) {
                        if (i3 != i2) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (!z) {
                        f4 = 1.0f;
                    }
                    f4 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                InputPhase inputPhase9 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composer.startReplaceGroup(-1258455321);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase9.ordinal()];
                if (i4 == 1) {
                    f5 = 1.0f;
                } else {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (z) {
                        f5 = 0.0f;
                    }
                    f5 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf3 = Float.valueOf(f5);
                InputPhase inputPhase10 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-1258455321);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                }
                i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase10.ordinal()];
                if (i5 == 1) {
                    f6 = 1.0f;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (!z) {
                    }
                    f6 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter3, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
                TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue2);
                ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                if (WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()] == 1) {
                    j4 = j;
                } else {
                    j4 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j4);
                ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
                zChanged = composer.changed(colorSpaceM6818getColorSpaceimpl);
                objRememberedValue = composer.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                if (WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1) {
                    j5 = j;
                } else {
                    j5 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Color colorM6804boximpl = Color.m6804boximpl(j5);
                inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                if (WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()] == 1) {
                    j6 = j;
                } else {
                    j6 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl, Color.m6804boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue2);
                ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                colorSpaceM6818getColorSpaceimpl2 = Color.m6818getColorSpaceimpl(j3);
                ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
                zChanged2 = composer.changed(colorSpaceM6818getColorSpaceimpl2);
                objRememberedValue2 = composer.rememberedValue();
                if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Color colorM6804boximpl2 = Color.m6804boximpl(j3);
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl2, Color.m6804boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter2, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation4, stateCreateTransitionAnimation5, stateCreateTransitionAnimation2, stateCreateTransitionAnimation3, composer, Integer.valueOf(i & 458752));
                ComposerKt.sourceInformationMarkerEnd(composer);
            }
            i2 = 3;
            if (i8 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f3 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Float fValueOf4 = Float.valueOf(f3);
            InputPhase inputPhase11 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-1093194547);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
            }
            i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase11.ordinal()];
            if (i3 == 1) {
                f4 = 1.0f;
            } else {
                if (i3 != 2) {
                    if (i3 != i2) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (!z) {
                    f4 = 1.0f;
                }
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation6 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf4, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$2 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
            ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase12 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composer.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }
            i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase12.ordinal()];
            if (i4 == 1) {
                f5 = 1.0f;
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z) {
                    f5 = 0.0f;
                }
                f5 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Float fValueOf5 = Float.valueOf(f5);
            InputPhase inputPhase13 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }
            i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase13.ordinal()];
            if (i5 == 1) {
                f6 = 1.0f;
            } else {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (!z) {
                }
                f6 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation7 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf5, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$2.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter4, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$2 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()] == 1) {
                j4 = j;
            } else {
                j4 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j4);
            ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
            zChanged = composer.changed(colorSpaceM6818getColorSpaceimpl);
            objRememberedValue = composer.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                composer.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter3 = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1) {
                j5 = j;
            } else {
                j5 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Color colorM6804boximpl3 = Color.m6804boximpl(j5);
            inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()] == 1) {
                j6 = j;
            } else {
                j6 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation8 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl3, Color.m6804boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$2.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter3, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$2 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            colorSpaceM6818getColorSpaceimpl2 = Color.m6818getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
            zChanged2 = composer.changed(colorSpaceM6818getColorSpaceimpl2);
            objRememberedValue2 = composer.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            TwoWayConverter twoWayConverter4 = (TwoWayConverter) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Color colorM6804boximpl4 = Color.m6804boximpl(j3);
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation9 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl4, Color.m6804boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$2.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter4, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation8, stateCreateTransitionAnimation9, stateCreateTransitionAnimation6, stateCreateTransitionAnimation7, composer, Integer.valueOf(i & 458752));
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        i2 = 3;
        f3 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf6 = Float.valueOf(f3);
        InputPhase inputPhase14 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1093194547);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
        }
        i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase14.ordinal()];
        if (i3 == 1) {
            f4 = 1.0f;
        } else {
            if (i3 != 2) {
                if (i3 != i2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (!z) {
                f4 = 1.0f;
            }
            f4 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation10 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf6, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$3 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase15 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1258455321);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
        }
        i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase15.ordinal()];
        if (i4 == 1) {
            f5 = 1.0f;
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f5 = 0.0f;
            }
            f5 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf7 = Float.valueOf(f5);
        InputPhase inputPhase16 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1258455321);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
        }
        i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase16.ordinal()];
        if (i5 == 1) {
            f6 = 1.0f;
        } else {
            if (i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (!z) {
            }
            f6 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation11 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf7, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$3.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter5, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$3 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue4);
        ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()] == 1) {
            j4 = j;
        } else {
            j4 = j2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j4);
        ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
        zChanged = composer.changed(colorSpaceM6818getColorSpaceimpl);
        objRememberedValue = composer.rememberedValue();
        if (!zChanged) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        TwoWayConverter twoWayConverter5 = (TwoWayConverter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        inputPhase3 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1) {
            j5 = j;
        } else {
            j5 = j2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM6804boximpl5 = Color.m6804boximpl(j5);
        inputPhase4 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()] == 1) {
            j6 = j;
        } else {
            j6 = j2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation12 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl5, Color.m6804boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$3.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter5, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$3 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue4);
        ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        colorSpaceM6818getColorSpaceimpl2 = Color.m6818getColorSpaceimpl(j3);
        ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
        zChanged2 = composer.changed(colorSpaceM6818getColorSpaceimpl2);
        objRememberedValue2 = composer.rememberedValue();
        if (!zChanged2) {
            objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
            composer.updateRememberedValue(objRememberedValue2);
        } else {
            objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        TwoWayConverter twoWayConverter6 = (TwoWayConverter) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM6804boximpl6 = Color.m6804boximpl(j3);
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation13 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl6, Color.m6804boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$3.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter6, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation12, stateCreateTransitionAnimation13, stateCreateTransitionAnimation10, stateCreateTransitionAnimation11, composer, Integer.valueOf(i & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m5104animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, boolean z3, TextFieldColors textFieldColors, float f, float f2, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        State<Dp> stateRememberUpdatedState2;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 2047013045, "C(animateBorderStrokeAsState)N(enabled,isError,focused,colors,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)475@19543L14,483@19812L11,492@20135L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:472)");
        }
        long jM4445indicatorColorXeAY9LY = textFieldColors.m4445indicatorColorXeAY9LY(z, z2, z3);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674528831);
            ComposerKt.sourceInformation(composer2, "478@19618L52");
            stateRememberUpdatedState = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(jM4445indicatorColorXeAY9LY, finiteAnimationSpecValue, null, null, composer, 0, 12);
            composer2 = composer;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674448076);
            ComposerKt.sourceInformation(composer2, "480@19700L33");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6804boximpl(jM4445indicatorColorXeAY9LY), composer2, 0);
            composer2.endReplaceGroup();
        }
        FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674266664);
            ComposerKt.sourceInformation(composer2, "487@19979L57");
            stateRememberUpdatedState2 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(z3 ? f : f2, finiteAnimationSpecValue2, null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674084601);
            ComposerKt.sourceInformation(composer2, "489@20066L46");
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Dp.m9685boximpl(f2), composer2, (i >> 15) & 14);
            composer2.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m622BorderStrokecXLIe8U(stateRememberUpdatedState2.getValue().m9701unboximpl(), stateRememberUpdatedState.getValue().m6824unboximpl()), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return stateRememberUpdatedState3;
    }

    public static final float textFieldHorizontalIconPadding(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1986450462, "C(textFieldHorizontalIconPadding)521@21199L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1986450462, i, -1, "androidx.compose.material3.internal.textFieldHorizontalIconPadding (TextFieldImpl.kt:520)");
        }
        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM9701unboximpl = ((Dp) objConsume).m9701unboximpl();
        if (Float.isNaN(fM9701unboximpl)) {
            fM9701unboximpl = Dp.m9687constructorimpl(0);
        }
        float fM9687constructorimpl = Dp.m9687constructorimpl(RangesKt.coerceAtLeast(Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM9701unboximpl - SmallIconButtonTokens.INSTANCE.m5775getIconSizeD9Ej5fM()) / 2), Dp.m9687constructorimpl(0)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM9687constructorimpl;
    }

    public static final float minimizedLabelHalfHeight(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1251545215, "C(minimizedLabelHalfHeight)528@21499L10,531@21709L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1251545215, i, -1, "androidx.compose.material3.internal.minimizedLabelHalfHeight (TextFieldImpl.kt:527)");
        }
        long jM9130getLineHeightXSAIIZE = MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall().m9130getLineHeightXSAIIZE();
        long jM5884getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m5884getBodySmallLineHeightXSAIIZE();
        if (!TextUnit.m9884isSpimpl(jM9130getLineHeightXSAIIZE)) {
            jM9130getLineHeightXSAIIZE = jM5884getBodySmallLineHeightXSAIIZE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM9687constructorimpl = Dp.m9687constructorimpl(((Density) objConsume).mo749toDpGaN1DYA(jM9130getLineHeightXSAIIZE) / 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM9687constructorimpl;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getAboveLabelHorizontalPadding() {
        return AboveLabelHorizontalPadding;
    }

    public static final float getAboveLabelBottomPadding() {
        return AboveLabelBottomPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    private static final boolean CommonDecorationBox$lambda$2$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$2$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f = 16;
        TextFieldPadding = Dp.m9687constructorimpl(f);
        float f2 = 4;
        AboveLabelHorizontalPadding = Dp.m9687constructorimpl(f2);
        AboveLabelBottomPadding = Dp.m9687constructorimpl(f2);
        SupportingTopPadding = Dp.m9687constructorimpl(f2);
        MinFocusedLabelLineHeight = Dp.m9687constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m9687constructorimpl(f);
    }
}
