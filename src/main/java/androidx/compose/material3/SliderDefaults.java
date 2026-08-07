package androidx.compose.material3;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010+J\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02%\b\u0002\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007¢\u0006\u0004\b6\u00107J\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u0002042\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02%\b\u0002\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007¢\u0006\u0004\b9\u0010:J\u009d\u0001\u0010;\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02%\b\u0002\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00108\u001a\u000204H\u0007¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u0002042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02#\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u001fH\u0003¢\u0006\u0004\bA\u0010BJ3\u0010(\u001a\u00020\u00192\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010EJ\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02%\b\u0002\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007¢\u0006\u0004\b6\u0010FJ\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010C\u001a\u00020D2\u0006\u00108\u001a\u0002042\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02%\b\u0002\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007¢\u0006\u0004\b9\u0010GJ\u008d\u0001\u0010>\u001a\u00020\u00192\u0006\u0010C\u001a\u00020D2\u0006\u00108\u001a\u0002042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02#\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0003¢\u0006\u0004\bH\u0010IJï\u0001\u0010J\u001a\u00020\u0019*\u00020.2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u0002042\u0006\u0010R\u001a\u0002042\u0006\u0010S\u001a\u0002042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00108\u001a\u0002042\u001f\u0010,\u001a\u001b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0019\u0018\u00010-¢\u0006\u0002\b02#\u00101\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001902¢\u0006\u0002\b02\u0006\u0010T\u001a\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u001f2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010@\u001a\u00020\u001fH\u0002¢\u0006\u0004\bW\u0010XJC\u0010Y\u001a\u00020\u0019*\u00020.2\u0006\u0010U\u001a\u00020V2\u0006\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020N2\u0006\u0010_\u001a\u00020NH\u0002¢\u0006\u0004\b`\u0010aJ)\u0010,\u001a\u00020\u0019*\u00020.2\u0006\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u0002042\u0006\u0010]\u001a\u00020\b¢\u0006\u0004\bb\u0010cR\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010d\u001a\u000204¢\u0006\n\n\u0002\u0010g\u001a\u0004\be\u0010fR\u0013\u0010h\u001a\u000204¢\u0006\n\n\u0002\u0010g\u001a\u0004\bi\u0010fR\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m5769getStopIndicatorSizeD9Ej5fM();
    private static final float TickSize = SliderTokens.INSTANCE.m5769getStopIndicatorSizeD9Ej5fM();
    private static final Path trackPath = AndroidPath_androidKt.Path();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$2(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4206CenteredTrack7LSsfP0(sliderState, modifier, z, sliderColors, function2, function3, f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumb_9LiSoMs$lambda$0(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4207Thumb9LiSoMs(mutableInteractionSource, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumb_HwbPF3A$lambda$0(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4208ThumbHwbPF3A(mutableInteractionSource, sliderState, modifier, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$1(SliderDefaults sliderDefaults, SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(sliderPositions, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$2(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, int i, int i2, Composer composer, int i3) {
        sliderDefaults.Track(rangeSliderState, modifier, sliderColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$3(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4201TrackImplVvwgllI(sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$2(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, Composer composer, int i2) {
        sliderDefaults.m4202TrackImplxlyIBlM(rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$2(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4210Track4EFweAY(sliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$5(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4209Track4EFweAY(rangeSliderState, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$2(SliderDefaults sliderDefaults, SliderState sliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4212TrackmnvyFg4(sliderState, f, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$5(SliderDefaults sliderDefaults, RangeSliderState rangeSliderState, float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f2, float f3, int i, int i2, Composer composer, int i3) {
        sliderDefaults.m4211TrackmnvyFg4(rangeSliderState, f, modifier, z, sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) function2, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) function3, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1376295968, "C(colors)1372@59703L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1372)");
        }
        SliderColors defaultSliderColors$material3 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors$material3;
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m4213colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 885588574, "C(colors)N(thumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)1414@62027L11:Slider.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1414)");
        }
        SliderColors sliderColorsM4181copyK518z4 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4181copyK518z4(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sliderColorsM4181copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached = colorScheme.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached != null) {
            return defaultSliderColorsCached;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSliderColorsCached$material3(sliderColors);
        return sliderColors;
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0110  */
    /* JADX WARN: Code duplicated, block: B:93:0x0135  */
    /* JADX WARN: Code duplicated, block: B:95:0x013d  */
    /* JADX WARN: Code duplicated, block: B:98:0x014c  */
    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m4207Thumb9LiSoMs(final MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        long j2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z4;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long j4;
        boolean z5;
        Modifier modifier4;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumb)N(interactionSource,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1478@65459L227:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i10 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        j2 = j;
                        if (composerStartRestartGroup.changed(j2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                                i3 &= -897;
                                sliderColors2 = sliderColorsColors;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                j4 = SliderKt.ThumbSize;
                            } else {
                                j4 = j2;
                            }
                            z5 = z2;
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            sliderColors2 = sliderColors2;
                            j4 = j2;
                            z5 = z2;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                        }
                        composer2 = composerStartRestartGroup;
                        SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        sliderColors3 = sliderColors2;
                        z4 = z5;
                        j3 = j4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        z4 = z2;
                        j3 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                j2 = j;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors3;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                    }
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    sliderColors3 = sliderColors2;
                    z4 = z5;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors4;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors5;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                    }
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    sliderColors3 = sliderColors2;
                    z4 = z5;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            j2 = j;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors6;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors7;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                }
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                sliderColors3 = sliderColors2;
                z4 = z5;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i10;
        } else {
            sliderColors2 = sliderColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors8 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors8;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors9 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors9;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                        } else {
                            j4 = j2;
                        }
                        z5 = z2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                    }
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    sliderColors3 = sliderColors2;
                    z4 = z5;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            j2 = j;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors10 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors10;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors11 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors11;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                }
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                sliderColors3 = sliderColors2;
                z4 = z5;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors12 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors12;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors13 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors13;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                    } else {
                        j4 = j2;
                    }
                    z5 = z2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
                }
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                sliderColors3 = sliderColors2;
                z4 = z5;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        j2 = j;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1474@65361L8");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsColors14 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -897;
                    sliderColors2 = sliderColorsColors14;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    j4 = SliderKt.ThumbSize;
                } else {
                    j4 = j2;
                }
                z5 = z2;
                modifier4 = companion;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsColors15 = colors(composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -897;
                    sliderColors2 = sliderColorsColors15;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    j4 = SliderKt.ThumbSize;
                } else {
                    j4 = j2;
                }
                z5 = z2;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1478)");
            }
            composer2 = composerStartRestartGroup;
            SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors2, z5, j4, false, composer2, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            sliderColors3 = sliderColors2;
            z4 = z5;
            j3 = j4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            z4 = z2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Thumb_9LiSoMs$lambda$0(this.f$0, mutableInteractionSource, modifier3, sliderColors3, z4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0134  */
    /* JADX WARN: Code duplicated, block: B:103:0x0154  */
    /* JADX WARN: Code duplicated, block: B:105:0x015c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0169  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef A[PHI: r3 r6 r7 r11
      0x00ef: PHI (r3v19 int) = (r3v14 int), (r3v12 int), (r3v20 int) binds: [B:92:0x010e, B:81:0x00eb, B:82:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r6v10 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:92:0x010e, B:81:0x00eb, B:82:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r7v12 androidx.compose.material3.SliderColors) = 
      (r7v9 androidx.compose.material3.SliderColors)
      (r7v6 androidx.compose.material3.SliderColors)
      (r7v6 androidx.compose.material3.SliderColors)
     binds: [B:92:0x010e, B:81:0x00eb, B:82:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r11v9 boolean) = (r11v4 boolean), (r11v2 boolean), (r11v2 boolean) binds: [B:92:0x010e, B:81:0x00eb, B:82:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    /* JADX WARN: Code duplicated, block: B:99:0x0131  */
    /* JADX INFO: renamed from: Thumb-HwbPF3A, reason: not valid java name */
    public final void m4208ThumbHwbPF3A(final MutableInteractionSource mutableInteractionSource, SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        SliderState sliderState2;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        long j2;
        int i7;
        boolean z3;
        Composer composer2;
        final SliderColors sliderColors3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j4;
        SliderColors sliderColors4;
        boolean z4;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-889714565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumb)N(interactionSource,sliderState,modifier,colors,enabled,thumbSize:c#ui.unit.DpSize)1513@66942L257:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            sliderState2 = sliderState;
            i3 |= composerStartRestartGroup.changedInstance(sliderState2) ? 32 : 16;
        } else {
            sliderState2 = sliderState;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    int i10 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        j2 = j;
                        if (composerStartRestartGroup.changed(j2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i3 |= i8;
                    }
                    if ((599187 & i3) != 599186) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -7169;
                                sliderColors2 = sliderColorsColors;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                j4 = SliderKt.ThumbSize;
                                sliderColors4 = sliderColors2;
                            }
                            boolean z5 = z2;
                            Modifier modifier3 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                            }
                            if (sliderState2.getOrientation() == Orientation.Vertical) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            int i11 = i3 & 14;
                            int i12 = i3 >> 3;
                            composer2 = composerStartRestartGroup;
                            SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier3, sliderColors4, z5, j4, z4, composer2, i11 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (i12 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            sliderColors3 = sliderColors4;
                            z2 = z5;
                            j3 = j4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                        boolean z6 = z2;
                        Modifier modifier4 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                        }
                        if (sliderState2.getOrientation() == Orientation.Vertical) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        int i13 = i3 & 14;
                        int i14 = i3 >> 3;
                        composer2 = composerStartRestartGroup;
                        SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier4, sliderColors4, z6, j4, z4, composer2, i13 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (i14 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        sliderColors3 = sliderColors4;
                        z2 = z6;
                        j3 = j4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        sliderColors3 = sliderColors2;
                        j3 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final SliderState sliderState3 = sliderState2;
                        final Modifier modifier5 = modifier2;
                        final boolean z7 = z2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState3, modifier5, sliderColors3, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                j2 = j;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors3;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    }
                    boolean z8 = z2;
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                    }
                    if (sliderState2.getOrientation() == Orientation.Vertical) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i15 = i3 & 14;
                    int i16 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier6, sliderColors4, z8, j4, z4, composer2, i15 | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (i16 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier6;
                    sliderColors3 = sliderColors4;
                    z2 = z8;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    sliderColors3 = sliderColors2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final SliderState sliderState4 = sliderState2;
                    final Modifier modifier7 = modifier2;
                    final boolean z9 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState4, modifier7, sliderColors3, z9, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors4;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors5;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    }
                    boolean z10 = z2;
                    Modifier modifier8 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                    }
                    if (sliderState2.getOrientation() == Orientation.Vertical) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i17 = i3 & 14;
                    int i18 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier8, sliderColors4, z10, j4, z4, composer2, i17 | (i18 & 112) | (i18 & 896) | (i18 & 7168) | (i18 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier8;
                    sliderColors3 = sliderColors4;
                    z2 = z10;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    sliderColors3 = sliderColors2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final SliderState sliderState5 = sliderState2;
                    final Modifier modifier9 = modifier2;
                    final boolean z11 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState5, modifier9, sliderColors3, z11, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            j2 = j;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors6;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors7;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                }
                boolean z12 = z2;
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                }
                if (sliderState2.getOrientation() == Orientation.Vertical) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i19 = i3 & 14;
                int i110 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier10, sliderColors4, z12, j4, z4, composer2, i19 | (i110 & 112) | (i110 & 896) | (i110 & 7168) | (i110 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier10;
                sliderColors3 = sliderColors4;
                z2 = z12;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                sliderColors3 = sliderColors2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final SliderState sliderState6 = sliderState2;
                final Modifier modifier11 = modifier2;
                final boolean z13 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState6, modifier11, sliderColors3, z13, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i10;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i10;
        } else {
            sliderColors2 = sliderColors;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors8 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors8;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors9 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors9;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            j4 = SliderKt.ThumbSize;
                            sliderColors4 = sliderColors2;
                        } else {
                            sliderColors4 = sliderColors2;
                            j4 = j2;
                        }
                    }
                    boolean z14 = z2;
                    Modifier modifier12 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                    }
                    if (sliderState2.getOrientation() == Orientation.Vertical) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i111 = i3 & 14;
                    int i112 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier12, sliderColors4, z14, j4, z4, composer2, i111 | (i112 & 112) | (i112 & 896) | (i112 & 7168) | (i112 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier12;
                    sliderColors3 = sliderColors4;
                    z2 = z14;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    sliderColors3 = sliderColors2;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final SliderState sliderState7 = sliderState2;
                    final Modifier modifier13 = modifier2;
                    final boolean z15 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState7, modifier13, sliderColors3, z15, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            j2 = j;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors10 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors10;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors11 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors11;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                }
                boolean z16 = z2;
                Modifier modifier14 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                }
                if (sliderState2.getOrientation() == Orientation.Vertical) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i113 = i3 & 14;
                int i114 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier14, sliderColors4, z16, j4, z4, composer2, i113 | (i114 & 112) | (i114 & 896) | (i114 & 7168) | (i114 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier14;
                sliderColors3 = sliderColors4;
                z2 = z16;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                sliderColors3 = sliderColors2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final SliderState sliderState8 = sliderState2;
                final Modifier modifier15 = modifier2;
                final boolean z17 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState8, modifier15, sliderColors3, z17, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors12 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors12;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors13 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors13;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        j4 = SliderKt.ThumbSize;
                        sliderColors4 = sliderColors2;
                    } else {
                        sliderColors4 = sliderColors2;
                        j4 = j2;
                    }
                }
                boolean z18 = z2;
                Modifier modifier16 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
                }
                if (sliderState2.getOrientation() == Orientation.Vertical) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i115 = i3 & 14;
                int i116 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier16, sliderColors4, z18, j4, z4, composer2, i115 | (i116 & 112) | (i116 & 896) | (i116 & 7168) | (i116 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier16;
                sliderColors3 = sliderColors4;
                z2 = z18;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                sliderColors3 = sliderColors2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final SliderState sliderState9 = sliderState2;
                final Modifier modifier17 = modifier2;
                final boolean z19 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState9, modifier17, sliderColors3, z19, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        j2 = j;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        }
        if ((599187 & i3) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1509@66844L8");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors14 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors14;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    j4 = SliderKt.ThumbSize;
                    sliderColors4 = sliderColors2;
                } else {
                    sliderColors4 = sliderColors2;
                    j4 = j2;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors15 = colors(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors15;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    j4 = SliderKt.ThumbSize;
                    sliderColors4 = sliderColors2;
                } else {
                    sliderColors4 = sliderColors2;
                    j4 = j2;
                }
            }
            boolean z110 = z2;
            Modifier modifier18 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889714565, i3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1513)");
            }
            if (sliderState2.getOrientation() == Orientation.Vertical) {
                z4 = true;
            } else {
                z4 = false;
            }
            int i117 = i3 & 14;
            int i118 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            SliderKt.m4237Thumb9LiSoMs(mutableInteractionSource, modifier18, sliderColors4, z110, j4, z4, composer2, i117 | (i118 & 112) | (i118 & 896) | (i118 & 7168) | (i118 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier18;
            sliderColors3 = sliderColors4;
            z2 = z110;
            j3 = j4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            sliderColors3 = sliderColors2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final SliderState sliderState10 = sliderState2;
            final Modifier modifier19 = modifier2;
            final boolean z111 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Thumb_HwbPF3A$lambda$0(this.f$0, mutableInteractionSource, sliderState10, modifier19, sliderColors3, z111, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba A[PHI: r3 r5 r8
      0x00ba: PHI (r3v17 androidx.compose.material3.SliderColors) = (r3v13 androidx.compose.material3.SliderColors), (r3v19 androidx.compose.material3.SliderColors) binds: [B:73:0x00d6, B:64:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r5v9 androidx.compose.ui.Modifier) = (r5v4 androidx.compose.ui.Modifier), (r5v12 androidx.compose.ui.Modifier) binds: [B:73:0x00d6, B:64:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r8v13 int) = (r8v9 int), (r8v14 int) binds: [B:73:0x00d6, B:64:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:80:0x0123  */
    /* JADX WARN: Code duplicated, block: B:81:0x0125  */
    /* JADX WARN: Code duplicated, block: B:84:0x013d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149  */
    /* JADX WARN: Code duplicated, block: B:91:0x0164  */
    /* JADX WARN: Code duplicated, block: B:93:0x016b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0177  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    @Deprecated(message = "Use version that supports slider state")
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i6;
        SliderColors sliderColors4;
        boolean z5;
        int i7;
        final long jM4194trackColorWaAFU9c$material3;
        final long jM4194trackColorWaAFU9c$material4;
        final long jM4193tickColorWaAFU9c$material3;
        final long jM4193tickColorWaAFU9c$material4;
        boolean z6;
        boolean zChanged;
        Object objRememberedValue;
        boolean z7;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderPositions,modifier,colors,enabled)1547@68513L1838,1547@68461L1890:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(sliderPositions) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i11 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i11;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i11;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1540@68108L8");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = sliderColorsColors;
                        }
                        SliderColors sliderColors5 = sliderColors2;
                        i6 = i3;
                        sliderColors4 = sliderColors5;
                        if (i4 != 0) {
                            z5 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1546713545, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1542)");
                        }
                        i7 = i6;
                        jM4194trackColorWaAFU9c$material3 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, false);
                        jM4194trackColorWaAFU9c$material4 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, true);
                        jM4193tickColorWaAFU9c$material3 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, false);
                        jM4193tickColorWaAFU9c$material4 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, true);
                        SliderColors sliderColors6 = sliderColors4;
                        modifier3 = companion;
                        Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333013595, "CC(remember):Slider.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3);
                        if ((i7 & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        zChanged = zChanged2 | z6 | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z7 = z5;
                            i8 = 0;
                            Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1);
                            objRememberedValue = function1;
                        } else {
                            z7 = z5;
                            i8 = 0;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM1252height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, i8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sliderColors3 = sliderColors6;
                        z4 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors7 = sliderColors2;
                        i6 = i3;
                        sliderColors4 = sliderColors7;
                        companion = modifier2;
                    }
                    z5 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1546713545, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1542)");
                    }
                    i7 = i6;
                    jM4194trackColorWaAFU9c$material3 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, false);
                    jM4194trackColorWaAFU9c$material4 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, true);
                    jM4193tickColorWaAFU9c$material3 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, false);
                    jM4193tickColorWaAFU9c$material4 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, true);
                    SliderColors sliderColors8 = sliderColors4;
                    modifier3 = companion;
                    Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333013595, "CC(remember):Slider.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3);
                    if ((i7 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = zChanged3 | z6 | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        z7 = z5;
                        i8 = 0;
                        Function1 function2 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function2);
                        objRememberedValue = function2;
                    } else {
                        z7 = z5;
                        i8 = 0;
                        Function1 function3 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function3);
                        objRememberedValue = function3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1252height3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, i8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sliderColors3 = sliderColors8;
                    z4 = z7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track$lambda$1(this.f$0, sliderPositions, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1540@68108L8");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors2;
                    }
                    SliderColors sliderColors9 = sliderColors2;
                    i6 = i3;
                    sliderColors4 = sliderColors9;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors3;
                    }
                    SliderColors sliderColors10 = sliderColors2;
                    i6 = i3;
                    sliderColors4 = sliderColors10;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1546713545, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1542)");
                }
                i7 = i6;
                jM4194trackColorWaAFU9c$material3 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, false);
                jM4194trackColorWaAFU9c$material4 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, true);
                jM4193tickColorWaAFU9c$material3 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, false);
                jM4193tickColorWaAFU9c$material4 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, true);
                SliderColors sliderColors11 = sliderColors4;
                modifier3 = companion;
                Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333013595, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3);
                if ((i7 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = zChanged4 | z6 | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    z7 = z5;
                    i8 = 0;
                    Function1 function4 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function4);
                    objRememberedValue = function4;
                } else {
                    z7 = z5;
                    i8 = 0;
                    Function1 function5 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function5);
                    objRememberedValue = function5;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1252height3ABfNKs3, (Function1) objRememberedValue, composerStartRestartGroup, i8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sliderColors3 = sliderColors11;
                z4 = z7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track$lambda$1(this.f$0, sliderPositions, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i11;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i11;
        } else {
            sliderColors2 = sliderColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1540@68108L8");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors4;
                    }
                    SliderColors sliderColors12 = sliderColors2;
                    i6 = i3;
                    sliderColors4 = sliderColors12;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                        sliderColors2 = sliderColorsColors5;
                    }
                    SliderColors sliderColors13 = sliderColors2;
                    i6 = i3;
                    sliderColors4 = sliderColors13;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1546713545, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1542)");
                }
                i7 = i6;
                jM4194trackColorWaAFU9c$material3 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, false);
                jM4194trackColorWaAFU9c$material4 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, true);
                jM4193tickColorWaAFU9c$material3 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, false);
                jM4193tickColorWaAFU9c$material4 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, true);
                SliderColors sliderColors14 = sliderColors4;
                modifier3 = companion;
                Modifier modifierM1252height3ABfNKs4 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333013595, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3);
                if ((i7 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = zChanged5 | z6 | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    z7 = z5;
                    i8 = 0;
                    Function1 function6 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function6);
                    objRememberedValue = function6;
                } else {
                    z7 = z5;
                    i8 = 0;
                    Function1 function7 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function7);
                    objRememberedValue = function7;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1252height3ABfNKs4, (Function1) objRememberedValue, composerStartRestartGroup, i8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sliderColors3 = sliderColors14;
                z4 = z7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track$lambda$1(this.f$0, sliderPositions, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1540@68108L8");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -897;
                    sliderColors2 = sliderColorsColors6;
                }
                SliderColors sliderColors15 = sliderColors2;
                i6 = i3;
                sliderColors4 = sliderColors15;
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -897;
                    sliderColors2 = sliderColorsColors7;
                }
                SliderColors sliderColors16 = sliderColors2;
                i6 = i3;
                sliderColors4 = sliderColors16;
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546713545, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1542)");
            }
            i7 = i6;
            jM4194trackColorWaAFU9c$material3 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, false);
            jM4194trackColorWaAFU9c$material4 = sliderColors4.m4194trackColorWaAFU9c$material3(z5, true);
            jM4193tickColorWaAFU9c$material3 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, false);
            jM4193tickColorWaAFU9c$material4 = sliderColors4.m4193tickColorWaAFU9c$material3(z5, true);
            SliderColors sliderColors17 = sliderColors4;
            modifier3 = companion;
            Modifier modifierM1252height3ABfNKs5 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -333013595, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged6 = composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3);
            if ((i7 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            zChanged = zChanged6 | z6 | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                z7 = z5;
                i8 = 0;
                Function1 function8 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function8);
                objRememberedValue = function8;
            } else {
                z7 = z5;
                i8 = 0;
                Function1 function9 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.Track$lambda$0$0(jM4194trackColorWaAFU9c$material3, sliderPositions, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function9);
                objRememberedValue = function9;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1252height3ABfNKs5, (Function1) objRememberedValue, composerStartRestartGroup, i8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sliderColors3 = sliderColors17;
            z4 = z7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track$lambda$1(this.f$0, sliderPositions, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$0$0(long j, SliderPositions sliderPositions, long j2, long j3, long j4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
        long jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)))) << 32));
        long j5 = jM6561constructorimpl;
        long j6 = z ? jM6561constructorimpl2 : j5;
        if (!z) {
            j5 = jM6561constructorimpl2;
        }
        float f = drawScope.mo754toPx0680j_4(TickSize);
        float f2 = drawScope.mo754toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, j6, j5, f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        int i = (int) (j6 >> 32);
        int i2 = (int) (j5 >> 32);
        long j7 = j6;
        long j8 = j5;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j2, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getStart().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * sliderPositions.getActiveRange().getEndInclusive().floatValue()))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)), f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float[] tickFractions = sliderPositions.getTickFractions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f3 = tickFractions[i3];
            Boolean boolValueOf = Boolean.valueOf(f3 > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f3 < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(boolValueOf);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(boolValueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f3));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                arrayList.add(Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (OffsetKt.m6592lerpWko1d7g(j7, j8, ((Number) list.get(i4)).floatValue()) >> 32)))) << 32))));
                i4++;
                zBooleanValue = zBooleanValue;
                list = list;
            }
            long j9 = j7;
            j8 = j8;
            DrawScope.m7386drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m7136getPointsr_lszbg(), zBooleanValue ? j3 : j4, f, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            j7 = j9;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$0$0(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4214drawStopIndicatorx3O1jOs(drawScope, offset.m6579unboximpl(), TrackStopIndicatorSize, jM4194trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x014d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x015a  */
    /* JADX WARN: Code duplicated, block: B:119:0x016b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:129:0x018e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0198  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:146:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:152:0x023b  */
    /* JADX WARN: Code duplicated, block: B:153:0x023f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0250  */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    public final void m4210Track4EFweAY(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        int i6;
        int i7;
        int i8;
        final float f3;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function5;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function6;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function7;
        int i12;
        SliderDefaults$Track$4$1 sliderDefaults$Track$4$1RememberedValue;
        boolean z5;
        Object objRememberedValue;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(49984771);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1630@72100L467:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i15 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i15;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function4 = function2;
                        int i16 = composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
                        i3 |= i16;
                    } else {
                        function4 = function2;
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1616@71541L8,1617@71610L199,1624@71865L107");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                            z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f3 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function5 = function7;
                            i12 = i3;
                            z4 = z2;
                            sliderColors3 = sliderColors2;
                            f4 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function5 = function7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(49984771, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1629)");
                        }
                        int i17 = i12 << 3;
                        modifier3 = modifier2;
                        function6 = function4;
                        m4201TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function6, function5, f3, f4, false, false, composerStartRestartGroup, (i12 & 14) | 805306416 | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (3670016 & i17) | (29360128 & i17) | (i17 & 234881024), ((i12 >> 21) & 112) | 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        function5 = function3;
                    }
                    i12 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(49984771, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1629)");
                    }
                    int i18 = i12 << 3;
                    modifier3 = modifier2;
                    function6 = function4;
                    m4201TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function6, function5, f3, f4, false, false, composerStartRestartGroup, (i12 & 14) | 805306416 | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & 234881024), ((i12 >> 21) & 112) | 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    function6 = function4;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_4EFweAY$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f3, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1616@71541L8,1617@71610L199,1624@71865L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors2;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors3;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(49984771, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1629)");
                }
                int i19 = i12 << 3;
                modifier3 = modifier2;
                function6 = function4;
                m4201TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function6, function5, f3, f4, false, false, composerStartRestartGroup, (i12 & 14) | 805306416 | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024), ((i12 >> 21) & 112) | 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function6 = function4;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_4EFweAY$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f3, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1616@71541L8,1617@71610L199,1624@71865L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors4;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors5;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function5 = function7;
                        i12 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(49984771, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1629)");
                }
                int i110 = i12 << 3;
                modifier3 = modifier2;
                function6 = function4;
                m4201TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function6, function5, f3, f4, false, false, composerStartRestartGroup, (i12 & 14) | 805306416 | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (i110 & 234881024), ((i12 >> 21) & 112) | 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function6 = function4;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_4EFweAY$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f3, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i15;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i3 |= i16;
        } else {
            function4 = function2;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            f3 = f;
        } else {
            f3 = f;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1616@71541L8,1617@71610L199,1624@71865L107");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors6;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f3 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    function5 = function7;
                    i12 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = SliderKt.TrackInsideCornerSize;
                } else {
                    function5 = function7;
                    i12 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors7;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790731818, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 790739886, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$4$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4220invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4220invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$4$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$4$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f3 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    function5 = function7;
                    i12 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = SliderKt.TrackInsideCornerSize;
                } else {
                    function5 = function7;
                    i12 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(49984771, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1629)");
            }
            int i111 = i12 << 3;
            modifier3 = modifier2;
            function6 = function4;
            m4201TrackImplVvwgllI(sliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function6, function5, f3, f4, false, false, composerStartRestartGroup, (i12 & 14) | 805306416 | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (458752 & i111) | (3670016 & i111) | (29360128 & i111) | (i111 & 234881024), ((i12 >> 21) & 112) | 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function3;
            modifier3 = modifier2;
            z4 = z2;
            sliderColors3 = sliderColors2;
            function6 = function4;
            f4 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track_4EFweAY$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f3, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$0$0(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4214drawStopIndicatorx3O1jOs(drawScope, offset.m6579unboximpl(), TrackStopIndicatorSize, jM4194trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012a  */
    /* JADX WARN: Code duplicated, block: B:102:0x012d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:107:0x0149  */
    /* JADX WARN: Code duplicated, block: B:117:0x0160 A[PHI: r1 r4 r7 r10 r11 r13 r14
      0x0160: PHI (r1v40 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit>) = 
      (r1v12 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit>)
      (r1v44 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit>)
     binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r4v25 int) = (r4v19 int), (r4v27 int) binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r7v10 androidx.compose.ui.Modifier) = (r7v5 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier) binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r10v21 boolean) = (r10v5 boolean), (r10v2 boolean) binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r11v26 androidx.compose.material3.SliderColors) = (r11v8 androidx.compose.material3.SliderColors), (r11v6 androidx.compose.material3.SliderColors) binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r13v8 float) = (r13v3 float), (r13v1 float) binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r14v9 kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>) = 
      (r14v4 kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>)
      (r14v3 kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>)
     binds: [B:153:0x01fb, B:116:0x015e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x0169 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x016b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0172  */
    /* JADX WARN: Code duplicated, block: B:125:0x0178  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:130:0x0199  */
    /* JADX WARN: Code duplicated, block: B:132:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:152:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:157:0x020d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0250  */
    /* JADX WARN: Code duplicated, block: B:162:0x025b  */
    /* JADX WARN: Code duplicated, block: B:165:0x026d  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0113  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116  */
    /* JADX INFO: renamed from: Track-mnvyFg4, reason: not valid java name */
    public final void m4212TrackmnvyFg4(final SliderState sliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        SliderState sliderState2;
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        int i6;
        int i7;
        int i8;
        float f4;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function5;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function6;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function7;
        float f7;
        SliderDefaults$Track$7$1 sliderDefaults$Track$7$1RememberedValue;
        boolean z5;
        Object objRememberedValue;
        int i12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(1691224881);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1687@74603L467:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            sliderState2 = sliderState;
            i3 = (composerStartRestartGroup.changedInstance(sliderState2) ? 4 : 2) | i;
        } else {
            sliderState2 = sliderState;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        sliderColors2 = sliderColors;
                        int i15 = composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        function4 = function2;
                        int i16 = composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
                        i3 |= i16;
                    } else {
                        function4 = function2;
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                    f4 = f2;
                } else {
                    f4 = f2;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1673@74044L8,1674@74113L199,1681@74368L107");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                            z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            f7 = SliderKt.TrackInsideCornerSize;
                        }
                        i12 = i3;
                        boolean z6 = z2;
                        SliderColors sliderColors4 = sliderColors2;
                        float f8 = f4;
                        Function2<? super DrawScope, ? super Offset, Unit> function8 = function4;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1686)");
                        }
                        int i17 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
                        int i18 = ((i12 >> 24) & 112) | 6;
                        Modifier modifier4 = modifier2;
                        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function9 = function7;
                        m4201TrackImplVvwgllI(sliderState2, f, modifier4, z6, sliderColors4, function8, function9, f8, f7, true, false, composerStartRestartGroup, i17, i18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f6 = f7;
                        f5 = f8;
                        function5 = function9;
                        function6 = function8;
                        sliderColors3 = sliderColors4;
                        z4 = z6;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        function7 = function3;
                    }
                    f7 = f3;
                    i12 = i3;
                    boolean z7 = z2;
                    SliderColors sliderColors5 = sliderColors2;
                    float f9 = f4;
                    Function2<? super DrawScope, ? super Offset, Unit> function10 = function4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1686)");
                    }
                    int i19 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
                    int i110 = ((i12 >> 24) & 112) | 6;
                    Modifier modifier5 = modifier2;
                    Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function11 = function7;
                    m4201TrackImplVvwgllI(sliderState2, f, modifier5, z7, sliderColors5, function10, function11, f9, f7, true, false, composerStartRestartGroup, i19, i110);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = f7;
                    f5 = f9;
                    function5 = function11;
                    function6 = function10;
                    sliderColors3 = sliderColors5;
                    z4 = z7;
                    modifier3 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f4;
                    function6 = function4;
                    f6 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_mnvyFg4$lambda$2(this.f$0, sliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                f4 = f2;
            } else {
                f4 = f2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1673@74044L8,1674@74113L199,1681@74368L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors2;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors3;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f3;
                    }
                }
                i12 = i3;
                boolean z8 = z2;
                SliderColors sliderColors6 = sliderColors2;
                float f10 = f4;
                Function2<? super DrawScope, ? super Offset, Unit> function12 = function4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1686)");
                }
                int i111 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
                int i112 = ((i12 >> 24) & 112) | 6;
                Modifier modifier6 = modifier2;
                Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function13 = function7;
                m4201TrackImplVvwgllI(sliderState2, f, modifier6, z8, sliderColors6, function12, function13, f10, f7, true, false, composerStartRestartGroup, i111, i112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f7;
                f5 = f10;
                function5 = function13;
                function6 = function12;
                sliderColors3 = sliderColors6;
                z4 = z8;
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                f5 = f4;
                function6 = function4;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_mnvyFg4$lambda$2(this.f$0, sliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                f4 = f2;
            } else {
                f4 = f2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1673@74044L8,1674@74113L199,1681@74368L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors4;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors5;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f3;
                    }
                }
                i12 = i3;
                boolean z9 = z2;
                SliderColors sliderColors7 = sliderColors2;
                float f11 = f4;
                Function2<? super DrawScope, ? super Offset, Unit> function14 = function4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1686)");
                }
                int i113 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
                int i114 = ((i12 >> 24) & 112) | 6;
                Modifier modifier7 = modifier2;
                Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function15 = function7;
                m4201TrackImplVvwgllI(sliderState2, f, modifier7, z9, sliderColors7, function14, function15, f11, f7, true, false, composerStartRestartGroup, i113, i114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f7;
                f5 = f11;
                function5 = function15;
                function6 = function14;
                sliderColors3 = sliderColors7;
                z4 = z9;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                f5 = f4;
                function6 = function4;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_mnvyFg4$lambda$2(this.f$0, sliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i15;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i3 |= i16;
        } else {
            function4 = function2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
            f4 = f2;
        } else {
            f4 = f2;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(f3)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i13 = 268435456;
            }
            i3 |= i13;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1673@74044L8,1674@74113L199,1681@74368L107");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -57345;
                    sliderColors2 = sliderColorsColors6;
                }
                if ((i2 & 32) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    f7 = SliderKt.TrackInsideCornerSize;
                } else {
                    f7 = f3;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -57345;
                    sliderColors2 = sliderColorsColors7;
                }
                if ((i2 & 32) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769480824, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1769488892, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$7$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$7$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4221invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4221invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$7$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    f7 = SliderKt.TrackInsideCornerSize;
                } else {
                    f7 = f3;
                }
            }
            i12 = i3;
            boolean z10 = z2;
            SliderColors sliderColors8 = sliderColors2;
            float f12 = f4;
            Function2<? super DrawScope, ? super Offset, Unit> function16 = function4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691224881, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1686)");
            }
            int i115 = (i12 & 14) | 805306368 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (234881024 & i12);
            int i116 = ((i12 >> 24) & 112) | 6;
            Modifier modifier8 = modifier2;
            Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function17 = function7;
            m4201TrackImplVvwgllI(sliderState2, f, modifier8, z10, sliderColors8, function16, function17, f12, f7, true, false, composerStartRestartGroup, i115, i116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f6 = f7;
            f5 = f12;
            function5 = function17;
            function6 = function16;
            sliderColors3 = sliderColors8;
            z4 = z10;
            modifier3 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function3;
            modifier3 = modifier2;
            z4 = z2;
            sliderColors3 = sliderColors2;
            f5 = f4;
            function6 = function4;
            f6 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track_mnvyFg4$lambda$2(this.f$0, sliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenteredTrack_7LSsfP0$lambda$0$0(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4214drawStopIndicatorx3O1jOs(drawScope, offset.m6579unboximpl(), TrackStopIndicatorSize, jM4194trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0131  */
    /* JADX WARN: Code duplicated, block: B:104:0x0134  */
    /* JADX WARN: Code duplicated, block: B:107:0x013e  */
    /* JADX WARN: Code duplicated, block: B:109:0x014a  */
    /* JADX WARN: Code duplicated, block: B:119:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x016f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:125:0x017c  */
    /* JADX WARN: Code duplicated, block: B:128:0x018b  */
    /* JADX WARN: Code duplicated, block: B:130:0x019b  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:150:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:152:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:154:0x0204  */
    /* JADX WARN: Code duplicated, block: B:155:0x0209  */
    /* JADX WARN: Code duplicated, block: B:157:0x020d  */
    /* JADX WARN: Code duplicated, block: B:158:0x021a  */
    /* JADX WARN: Code duplicated, block: B:161:0x022a  */
    /* JADX WARN: Code duplicated, block: B:164:0x026f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0274  */
    /* JADX WARN: Code duplicated, block: B:169:0x0287  */
    /* JADX WARN: Code duplicated, block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    /* JADX INFO: renamed from: CenteredTrack-7LSsfP0, reason: not valid java name */
    public final void m4206CenteredTrack7LSsfP0(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        int i6;
        int i7;
        int i8;
        final float f4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z3;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function5;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function6;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function7;
        float f7;
        int i14;
        float fM9707getUnspecifiedD9Ej5fM;
        SliderDefaults$CenteredTrack$2$1 sliderDefaults$CenteredTrack$2$1RememberedValue;
        boolean z5;
        Object objRememberedValue;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(1199441071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CenteredTrack)N(sliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,trackCornerSize:c#ui.unit.Dp)1743@77080L466:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i17 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i17;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i17;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function4 = function2;
                        int i18 = composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
                        i3 |= i18;
                    } else {
                        function4 = function2;
                    }
                    i3 |= i18;
                } else {
                    function4 = function2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f4 = f;
                } else {
                    f4 = f;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i15 = 268435456;
                    }
                    i3 |= i15;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1728@76475L8,1729@76544L199,1736@76799L107");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                            z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            f7 = SliderKt.TrackInsideCornerSize;
                        } else {
                            f7 = f2;
                        }
                        if (i12 != 0) {
                            function5 = function7;
                            i14 = i3;
                            z4 = z2;
                            f5 = f7;
                            fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                            sliderColors3 = sliderColors2;
                        } else {
                            function5 = function7;
                            i14 = i3;
                            z4 = z2;
                            sliderColors3 = sliderColors2;
                            f5 = f7;
                            fM9707getUnspecifiedD9Ej5fM = f3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        function5 = function3;
                        fM9707getUnspecifiedD9Ej5fM = f3;
                        i14 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1199441071, i14, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1742)");
                    }
                    int i19 = i14 << 3;
                    modifier3 = modifier2;
                    function6 = function4;
                    m4201TrackImplVvwgllI(sliderState, fM9707getUnspecifiedD9Ej5fM, modifier3, z4, sliderColors3, function6, function5, f4, f5, true, true, composerStartRestartGroup, (i14 & 14) | 805306368 | ((i14 >> 21) & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024), ((i14 >> 24) & 112) | 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = fM9707getUnspecifiedD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    function6 = function4;
                    f5 = f2;
                    f6 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.CenteredTrack_7LSsfP0$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f4, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i17;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i17;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i18;
                } else {
                    function4 = function2;
                }
                i3 |= i18;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f4 = f;
            } else {
                f4 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i15 = 268435456;
                }
                i3 |= i15;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1728@76475L8,1729@76544L199,1736@76799L107");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors2;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f2;
                    }
                    if (i12 != 0) {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                        sliderColors3 = sliderColors2;
                    } else {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = f3;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors3;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f2;
                    }
                    if (i12 != 0) {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                        sliderColors3 = sliderColors2;
                    } else {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1199441071, i14, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1742)");
                }
                int i110 = i14 << 3;
                modifier3 = modifier2;
                function6 = function4;
                m4201TrackImplVvwgllI(sliderState, fM9707getUnspecifiedD9Ej5fM, modifier3, z4, sliderColors3, function6, function5, f4, f5, true, true, composerStartRestartGroup, (i14 & 14) | 805306368 | ((i14 >> 21) & 112) | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (i110 & 234881024), ((i14 >> 24) & 112) | 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = fM9707getUnspecifiedD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function6 = function4;
                f5 = f2;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.CenteredTrack_7LSsfP0$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f4, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i17;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i17;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i18;
                } else {
                    function4 = function2;
                }
                i3 |= i18;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f4 = f;
            } else {
                f4 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i15 = 268435456;
                }
                i3 |= i15;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1728@76475L8,1729@76544L199,1736@76799L107");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors4;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f2;
                    }
                    if (i12 != 0) {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                        sliderColors3 = sliderColors2;
                    } else {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = f3;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors5;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        f7 = SliderKt.TrackInsideCornerSize;
                    } else {
                        f7 = f2;
                    }
                    if (i12 != 0) {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                        sliderColors3 = sliderColors2;
                    } else {
                        function5 = function7;
                        i14 = i3;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f7;
                        fM9707getUnspecifiedD9Ej5fM = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1199441071, i14, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1742)");
                }
                int i111 = i14 << 3;
                modifier3 = modifier2;
                function6 = function4;
                m4201TrackImplVvwgllI(sliderState, fM9707getUnspecifiedD9Ej5fM, modifier3, z4, sliderColors3, function6, function5, f4, f5, true, true, composerStartRestartGroup, (i14 & 14) | 805306368 | ((i14 >> 21) & 112) | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (458752 & i111) | (3670016 & i111) | (29360128 & i111) | (i111 & 234881024), ((i14 >> 24) & 112) | 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = fM9707getUnspecifiedD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function6 = function4;
                f5 = f2;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.CenteredTrack_7LSsfP0$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f4, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i17;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i17;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                }
                i3 |= i18;
            } else {
                function4 = function2;
            }
            i3 |= i18;
        } else {
            function4 = function2;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            f4 = f;
        } else {
            f4 = f;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        i12 = i2 & 256;
        if (i12 != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(f3)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i15 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i15 = 268435456;
            }
            i3 |= i15;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1728@76475L8,1729@76544L199,1736@76799L107");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors6;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    f7 = SliderKt.TrackInsideCornerSize;
                } else {
                    f7 = f2;
                }
                if (i12 != 0) {
                    function5 = function7;
                    i14 = i3;
                    z4 = z2;
                    f5 = f7;
                    fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                    sliderColors3 = sliderColors2;
                } else {
                    function5 = function7;
                    i14 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f7;
                    fM9707getUnspecifiedD9Ej5fM = f3;
                }
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors7;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611641302, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.CenteredTrack_7LSsfP0$lambda$0$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1611649370, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$CenteredTrack$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$CenteredTrack$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$CenteredTrack$2$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$CenteredTrack$2$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4217invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4217invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$CenteredTrack$2$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$CenteredTrack$2$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    f7 = SliderKt.TrackInsideCornerSize;
                } else {
                    f7 = f2;
                }
                if (i12 != 0) {
                    function5 = function7;
                    i14 = i3;
                    z4 = z2;
                    f5 = f7;
                    fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                    sliderColors3 = sliderColors2;
                } else {
                    function5 = function7;
                    i14 = i3;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f7;
                    fM9707getUnspecifiedD9Ej5fM = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1199441071, i14, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1742)");
            }
            int i112 = i14 << 3;
            modifier3 = modifier2;
            function6 = function4;
            m4201TrackImplVvwgllI(sliderState, fM9707getUnspecifiedD9Ej5fM, modifier3, z4, sliderColors3, function6, function5, f4, f5, true, true, composerStartRestartGroup, (i14 & 14) | 805306368 | ((i14 >> 21) & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (i112 & 234881024), ((i14 >> 24) & 112) | 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f6 = fM9707getUnspecifiedD9Ej5fM;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function3;
            modifier3 = modifier2;
            z4 = z2;
            sliderColors3 = sliderColors2;
            function6 = function4;
            f5 = f2;
            f6 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.CenteredTrack_7LSsfP0$lambda$2(this.f$0, sliderState, modifier3, z4, sliderColors3, function6, function5, f4, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01da  */
    /* JADX WARN: Code duplicated, block: B:122:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:127:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:130:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:131:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:134:0x0208  */
    /* JADX WARN: Code duplicated, block: B:135:0x020a  */
    /* JADX WARN: Code duplicated, block: B:138:0x0211  */
    /* JADX WARN: Code duplicated, block: B:139:0x0213  */
    /* JADX WARN: Code duplicated, block: B:146:0x0228  */
    /* JADX WARN: Code duplicated, block: B:149:0x025f  */
    /* JADX INFO: renamed from: TrackImpl-VvwgllI, reason: not valid java name */
    private final void m4201TrackImplVvwgllI(final SliderState sliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, final boolean z2, final boolean z3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int i5;
        Modifier modifierM1252height3ABfNKs;
        long j;
        Modifier modifierThen;
        boolean z4;
        final long j2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        Object objRememberedValue;
        Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(133396521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrackImpl)N(sliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp,enableCornerShrinking,isCentered)1786@78797L957,1807@79783L1481,1777@78384L2880:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(133396521, i3, i4, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1772)");
            }
            final long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, false);
            final long jM4194trackColorWaAFU9c$material4 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
            final long jM4193tickColorWaAFU9c$material3 = sliderColors.m4193tickColorWaAFU9c$material3(z, false);
            int i6 = i4;
            long jM4193tickColorWaAFU9c$material4 = sliderColors.m4193tickColorWaAFU9c$material3(z, true);
            if (sliderState.getOrientation() == Orientation.Vertical) {
                i5 = i3;
                modifierM1252height3ABfNKs = SizeKt.fillMaxHeight$default(SizeKt.m1271width3ABfNKs(modifier, SliderKt.getTrackHeight()), 0.0f, 1, null);
                if (sliderState.getReverseVerticalDirection()) {
                    modifierM1252height3ABfNKs = ScaleKt.scale(modifierM1252height3ABfNKs, 1.0f, -1.0f);
                }
            } else {
                i5 = i3;
                modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654923770, "CC(remember):Slider.kt#9igjgp");
            int i7 = i5 & 112;
            boolean zChangedInstance = (i7 == 32) | composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                j = jM4193tickColorWaAFU9c$material4;
            } else {
                j = jM4193tickColorWaAFU9c$material4;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierThen = modifierM1252height3ABfNKs.then(LayoutModifierKt.layout(companion, (Function3) objRememberedValue2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654891694, "CC(remember):Slider.kt#9igjgp");
                if (i7 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                j2 = j;
                boolean zChangedInstance2 = z4 | composerStartRestartGroup.changedInstance(sliderState) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(j2);
                if ((i5 & 29360128) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z12 = zChangedInstance2 | z5;
                if ((i5 & 234881024) == 67108864) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z13 = z12 | z6;
                if ((i5 & 458752) == 131072) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z14 = z13 | z7;
                if ((i5 & 3670016) == 1048576) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                boolean z15 = z14 | z8;
                if ((i5 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z16 = z15 | z9;
                if ((i6 & 14) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = z16 | z10;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    modifier2 = modifierThen;
                    Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SliderDefaults.TrackImpl_VvwgllI$lambda$2$0(f, sliderState, jM4194trackColorWaAFU9c$material3, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    composer2.updateRememberedValue(function1);
                    objRememberedValue = function1;
                } else {
                    modifier2 = modifierThen;
                    composer2 = composerStartRestartGroup;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifier2, (Function1) objRememberedValue, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$1$0(f, sliderState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifierThen = modifierM1252height3ABfNKs.then(LayoutModifierKt.layout(companion, (Function3) objRememberedValue2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -654891694, "CC(remember):Slider.kt#9igjgp");
            if (i7 == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            j2 = j;
            boolean zChangedInstance3 = z4 | composerStartRestartGroup.changedInstance(sliderState) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(j2);
            if ((i5 & 29360128) == 8388608) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z17 = zChangedInstance3 | z5;
            if ((i5 & 234881024) == 67108864) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z18 = z17 | z6;
            if ((i5 & 458752) == 131072) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z19 = z18 | z7;
            if ((i5 & 3670016) == 1048576) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean z110 = z19 | z8;
            if ((i5 & C.ENCODING_PCM_DOUBLE) == 536870912) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z111 = z110 | z9;
            if ((i6 & 14) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = z111 | z10;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11) {
                modifier2 = modifierThen;
                Function1 function4 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_VvwgllI$lambda$2$0(f, sliderState, jM4194trackColorWaAFU9c$material3, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function4);
                objRememberedValue = function4;
            } else {
                modifier2 = modifierThen;
                Function1 function5 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_VvwgllI$lambda$2$0(f, sliderState, jM4194trackColorWaAFU9c$material3, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, j2, f2, f3, function2, function3, z2, z3, (DrawScope) obj);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function5);
                objRememberedValue = function5;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) objRememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_VvwgllI$lambda$3(this.f$0, sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TrackImpl_VvwgllI$lambda$1$0(float f, SliderState sliderState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int height;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        if (Dp.m9692equalsimpl0(f, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation() == Orientation.Vertical) {
                height = placeableMo8265measureBRTryo0.getWidth() / 2;
            } else {
                height = placeableMo8265measureBRTryo0.getHeight() / 2;
            }
        } else {
            height = measureScope.mo748roundToPx0680j_4(f);
        }
        return measureScope.layout(placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(height))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_VvwgllI$lambda$1$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$1$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_VvwgllI$lambda$2$0(float f, SliderState sliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, boolean z, boolean z2, DrawScope drawScope) {
        float f4;
        float fIntBitsToFloat;
        if (Dp.m9692equalsimpl0(f, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())) {
            if (sliderState.getOrientation() == Orientation.Vertical) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32));
            } else {
                fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L));
            }
            f4 = fIntBitsToFloat / 2;
        } else {
            f4 = drawScope.mo754toPx0680j_4(f);
        }
        INSTANCE.m4203drawTrackGVD57ws(drawScope, sliderState.getTickFractions(), 0.0f, sliderState.getCoercedValueAsFraction(), j, j2, j3, j4, drawScope.mo751toDpu2uoSUM(0), drawScope.mo751toDpu2uoSUM(0), drawScope.mo751toDpu2uoSUM(sliderState.getThumbWidth$material3()), drawScope.mo751toDpu2uoSUM(sliderState.getThumbHeight$material3()), f2, f3, drawScope.mo750toDpu2uoSUM(f4), function2, function3, false, z, sliderState.getOrientation(), z2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:52:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4 A[PHI: r4 r5 r6
      0x00b4: PHI (r4v9 androidx.compose.ui.Modifier) = (r4v4 androidx.compose.ui.Modifier), (r4v11 androidx.compose.ui.Modifier) binds: [B:74:0x00cf, B:64:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v14 androidx.compose.material3.SliderColors) = (r5v7 androidx.compose.material3.SliderColors), (r5v15 androidx.compose.material3.SliderColors) binds: [B:74:0x00cf, B:64:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r6v13 int) = (r6v8 int), (r6v14 int) binds: [B:74:0x00cf, B:64:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x0113  */
    /* JADX WARN: Code duplicated, block: B:83:0x0119  */
    /* JADX WARN: Code duplicated, block: B:86:0x0125  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    public final /* synthetic */ void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SliderColors sliderColorsColors;
        int i6;
        boolean z5;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,modifier,colors,enabled)1874@82674L219:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i9 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i9;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1871@82615L8");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                        } else {
                            sliderColorsColors = sliderColors2;
                        }
                        i6 = i3;
                        if (i4 != 0) {
                            z5 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1617869097, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1873)");
                        }
                        Modifier modifier4 = companion;
                        sliderColors3 = sliderColorsColors;
                        m4209Track4EFweAY(rangeSliderState, modifier4, z5, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i6 & 14) | 14155776 | (i6 & 112) | ((i6 >> 3) & 896) | ((i6 << 3) & 7168) | ((i6 << 12) & 234881024), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                        sliderColorsColors = sliderColors2;
                        i6 = i3;
                    }
                    z5 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617869097, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1873)");
                    }
                    Modifier modifier5 = companion;
                    sliderColors3 = sliderColorsColors;
                    m4209Track4EFweAY(rangeSliderState, modifier5, z5, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i6 & 14) | 14155776 | (i6 & 112) | ((i6 >> 3) & 896) | ((i6 << 3) & 7168) | ((i6 << 12) & 234881024), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    modifier3 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track$lambda$2(this.f$0, rangeSliderState, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1871@82615L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                    } else {
                        sliderColorsColors = sliderColors2;
                    }
                    i6 = i3;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                    } else {
                        sliderColorsColors = sliderColors2;
                    }
                    i6 = i3;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1617869097, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1873)");
                }
                Modifier modifier6 = companion;
                sliderColors3 = sliderColorsColors;
                m4209Track4EFweAY(rangeSliderState, modifier6, z5, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i6 & 14) | 14155776 | (i6 & 112) | ((i6 >> 3) & 896) | ((i6 << 3) & 7168) | ((i6 << 12) & 234881024), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track$lambda$2(this.f$0, rangeSliderState, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i9;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i9;
        } else {
            sliderColors2 = sliderColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1871@82615L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                    } else {
                        sliderColorsColors = sliderColors2;
                    }
                    i6 = i3;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -897;
                    } else {
                        sliderColorsColors = sliderColors2;
                    }
                    i6 = i3;
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1617869097, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1873)");
                }
                Modifier modifier7 = companion;
                sliderColors3 = sliderColorsColors;
                m4209Track4EFweAY(rangeSliderState, modifier7, z5, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i6 & 14) | 14155776 | (i6 & 112) | ((i6 >> 3) & 896) | ((i6 << 3) & 7168) | ((i6 << 12) & 234881024), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track$lambda$2(this.f$0, rangeSliderState, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1871@82615L8");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -897;
                } else {
                    sliderColorsColors = sliderColors2;
                }
                i6 = i3;
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -897;
                } else {
                    sliderColorsColors = sliderColors2;
                }
                i6 = i3;
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1617869097, i6, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1873)");
            }
            Modifier modifier8 = companion;
            sliderColors3 = sliderColorsColors;
            m4209Track4EFweAY(rangeSliderState, modifier8, z5, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, composerStartRestartGroup, (i6 & 14) | 14155776 | (i6 & 112) | ((i6 >> 3) & 896) | ((i6 << 3) & 7168) | ((i6 << 12) & 234881024), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
            modifier3 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track$lambda$2(this.f$0, rangeSliderState, modifier3, sliderColors3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_4EFweAY$lambda$3$0(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4214drawStopIndicatorx3O1jOs(drawScope, offset.m6579unboximpl(), TrackStopIndicatorSize, jM4194trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0150  */
    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    /* JADX WARN: Code duplicated, block: B:115:0x015d  */
    /* JADX WARN: Code duplicated, block: B:118:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0182  */
    /* JADX WARN: Code duplicated, block: B:128:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x019b  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:151:0x023e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0242  */
    /* JADX WARN: Code duplicated, block: B:155:0x0254  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    public final void m4209Track4EFweAY(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        int i6;
        int i7;
        int i8;
        float f3;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        final Function2<? super DrawScope, ? super Offset, Unit> function5;
        final float f4;
        final float f5;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function7;
        int i12;
        SliderDefaults$Track$11$1 sliderDefaults$Track$11$1RememberedValue;
        boolean z5;
        Object objRememberedValue;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-541824132);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1920@84689L402:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        int i15 = composerStartRestartGroup.changed(sliderColors2) ? 2048 : 1024;
                        i3 |= i15;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        function4 = function2;
                        int i16 = composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
                        i3 |= i16;
                    } else {
                        function4 = function2;
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    f3 = f;
                } else {
                    f3 = f;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1906@84130L8,1907@84199L199,1914@84454L107");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                            i3 &= -7169;
                            sliderColors2 = sliderColorsColors;
                        }
                        if ((i2 & 16) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                            z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-57345) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f3 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            z4 = z2;
                            function5 = function4;
                            f5 = f3;
                            function6 = function7;
                            i12 = i3;
                            modifier3 = modifier2;
                            sliderColors3 = sliderColors2;
                            f4 = SliderKt.TrackInsideCornerSize;
                        } else {
                            z4 = z2;
                            function5 = function4;
                            f5 = f3;
                            function6 = function7;
                            i12 = i3;
                            modifier3 = modifier2;
                            sliderColors3 = sliderColors2;
                            f4 = f2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i12 = i3;
                        modifier3 = modifier2;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        function5 = function4;
                        f4 = f2;
                        f5 = f3;
                        function6 = function3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-541824132, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1919)");
                    }
                    int i17 = (i12 & 14) | 48;
                    int i18 = i12 << 3;
                    m4202TrackImplxlyIBlM(rangeSliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function5, function6, f5, f4, composerStartRestartGroup, i17 | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & C.ENCODING_PCM_DOUBLE));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    function5 = function4;
                    f4 = f2;
                    f5 = f3;
                    function6 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_4EFweAY$lambda$5(this.f$0, rangeSliderState, modifier3, z4, sliderColors3, function5, function6, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1906@84130L8,1907@84199L199,1914@84454L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors2;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors3;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-541824132, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1919)");
                }
                int i19 = (i12 & 14) | 48;
                int i110 = i12 << 3;
                m4202TrackImplxlyIBlM(rangeSliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function5, function6, f5, f4, composerStartRestartGroup, i19 | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (234881024 & i110) | (i110 & C.ENCODING_PCM_DOUBLE));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function5 = function4;
                f4 = f2;
                f5 = f3;
                function6 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_4EFweAY$lambda$5(this.f$0, rangeSliderState, modifier3, z4, sliderColors3, function5, function6, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1906@84130L8,1907@84199L199,1914@84454L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors4;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -7169;
                        sliderColors2 = sliderColorsColors5;
                    }
                    if ((i2 & 16) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                        z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-57345) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f3 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = SliderKt.TrackInsideCornerSize;
                    } else {
                        z4 = z2;
                        function5 = function4;
                        f5 = f3;
                        function6 = function7;
                        i12 = i3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        f4 = f2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-541824132, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1919)");
                }
                int i111 = (i12 & 14) | 48;
                int i112 = i12 << 3;
                m4202TrackImplxlyIBlM(rangeSliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function5, function6, f5, f4, composerStartRestartGroup, i111 | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & C.ENCODING_PCM_DOUBLE));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                function5 = function4;
                f4 = f2;
                f5 = f3;
                function6 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_4EFweAY$lambda$5(this.f$0, rangeSliderState, modifier3, z4, sliderColors3, function5, function6, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i15;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i3 |= i16;
        } else {
            function4 = function2;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            f3 = f;
        } else {
            f3 = f;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1906@84130L8,1907@84199L199,1914@84454L107");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors6;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f3 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    z4 = z2;
                    function5 = function4;
                    f5 = f3;
                    function6 = function7;
                    i12 = i3;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    f4 = SliderKt.TrackInsideCornerSize;
                } else {
                    z4 = z2;
                    function5 = function4;
                    f5 = f3;
                    function6 = function7;
                    i12 = i3;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                    i3 &= -7169;
                    sliderColors2 = sliderColorsColors7;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001940573, "CC(remember):Slider.kt#9igjgp");
                    z5 = ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 3072) == 2048) | ((i3 & 896) == 256);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_4EFweAY$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-57345) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1001932505, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$11$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$11$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4218invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4218invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$11$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$11$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f3 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    z4 = z2;
                    function5 = function4;
                    f5 = f3;
                    function6 = function7;
                    i12 = i3;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    f4 = SliderKt.TrackInsideCornerSize;
                } else {
                    z4 = z2;
                    function5 = function4;
                    f5 = f3;
                    function6 = function7;
                    i12 = i3;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    f4 = f2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-541824132, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1919)");
            }
            int i113 = (i12 & 14) | 48;
            int i114 = i12 << 3;
            m4202TrackImplxlyIBlM(rangeSliderState, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, z4, sliderColors3, function5, function6, f5, f4, composerStartRestartGroup, i113 | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (458752 & i114) | (3670016 & i114) | (29360128 & i114) | (234881024 & i114) | (i114 & C.ENCODING_PCM_DOUBLE));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            sliderColors3 = sliderColors2;
            function5 = function4;
            f4 = f2;
            f5 = f3;
            function6 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track_4EFweAY$lambda$5(this.f$0, rangeSliderState, modifier3, z4, sliderColors3, function5, function6, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track_mnvyFg4$lambda$3$0(SliderColors sliderColors, boolean z, DrawScope drawScope, Offset offset) {
        SliderDefaults sliderDefaults = INSTANCE;
        long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
        sliderDefaults.m4214drawStopIndicatorx3O1jOs(drawScope, offset.m6579unboximpl(), TrackStopIndicatorSize, jM4194trackColorWaAFU9c$material3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0130  */
    /* JADX WARN: Code duplicated, block: B:106:0x013a  */
    /* JADX WARN: Code duplicated, block: B:108:0x014c  */
    /* JADX WARN: Code duplicated, block: B:119:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x016f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:125:0x017c  */
    /* JADX WARN: Code duplicated, block: B:128:0x018d  */
    /* JADX WARN: Code duplicated, block: B:130:0x019d  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:141:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:152:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:154:0x0201  */
    /* JADX WARN: Code duplicated, block: B:155:0x020e  */
    /* JADX WARN: Code duplicated, block: B:158:0x021a  */
    /* JADX WARN: Code duplicated, block: B:161:0x0235  */
    /* JADX WARN: Code duplicated, block: B:163:0x0241  */
    /* JADX WARN: Code duplicated, block: B:166:0x0254  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    /* JADX INFO: renamed from: Track-mnvyFg4, reason: not valid java name */
    public final void m4211TrackmnvyFg4(final RangeSliderState rangeSliderState, final float f, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final SliderColors sliderColors2;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        int i6;
        int i7;
        int i8;
        float f4;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function5;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        final float f5;
        final Function2<? super DrawScope, ? super Offset, Unit> function6;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function7;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function8;
        int i12;
        Modifier modifier4;
        boolean z5;
        SliderColors sliderColors4;
        float f7;
        Function2<? super DrawScope, ? super Offset, Unit> function9;
        float f8;
        SliderDefaults$Track$14$1 sliderDefaults$Track$14$1RememberedValue;
        boolean z6;
        Object objRememberedValue;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(1952945688);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)1972@87016L403:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        sliderColors2 = sliderColors;
                        int i15 = composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        function4 = function2;
                        int i16 = composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
                        i3 |= i16;
                    } else {
                        function4 = function2;
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                    f4 = f2;
                } else {
                    f4 = f2;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f3)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                SliderColors sliderColorsColors = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                                i3 &= -57345;
                                sliderColors2 = sliderColorsColors;
                            }
                            if ((i2 & 32) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                                z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function2) objRememberedValue;
                                i3 = (-458753) & i3;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                                sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                            m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                        public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                            SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                                }
                                function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function7 = function3;
                            }
                            if (i8 != 0) {
                                f4 = SliderKt.ThumbTrackGapSize;
                            }
                            if (i10 != 0) {
                                function8 = function7;
                                i12 = i3;
                                modifier4 = modifier2;
                                z5 = z2;
                                sliderColors4 = sliderColors2;
                                f7 = f4;
                                function9 = function4;
                                f8 = SliderKt.TrackInsideCornerSize;
                            } else {
                                function8 = function7;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                            }
                            m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f6 = f8;
                            f5 = f7;
                            function5 = function8;
                            function6 = function9;
                            sliderColors3 = sliderColors4;
                            z4 = z5;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            function8 = function3;
                        }
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                        }
                        m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f6 = f8;
                        f5 = f7;
                        function5 = function8;
                        function6 = function9;
                        sliderColors3 = sliderColors4;
                        z4 = z5;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function3;
                        modifier3 = modifier2;
                        z4 = z2;
                        sliderColors3 = sliderColors2;
                        f5 = f4;
                        function6 = function4;
                        f6 = f3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors2 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors2;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors3 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors3;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                    }
                    m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = f8;
                    f5 = f7;
                    function5 = function8;
                    function6 = function9;
                    sliderColors3 = sliderColors4;
                    z4 = z5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f4;
                    function6 = function4;
                    f6 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                f4 = f2;
            } else {
                f4 = f2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors4 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors4;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors5 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors5;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                    }
                    m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = f8;
                    f5 = f7;
                    function5 = function8;
                    function6 = function9;
                    sliderColors3 = sliderColors4;
                    z4 = z5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f4;
                    function6 = function4;
                    f6 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors6 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors6;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors7 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors7;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                }
                m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f8;
                f5 = f7;
                function5 = function8;
                function6 = function9;
                sliderColors3 = sliderColors4;
                z4 = z5;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                f5 = f4;
                function6 = function4;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColors2 = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                    }
                    i3 |= i16;
                } else {
                    function4 = function2;
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                f4 = f2;
            } else {
                f4 = f2;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors8 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors8;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            SliderColors sliderColorsColors9 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                            i3 &= -57345;
                            sliderColors2 = sliderColorsColors9;
                        }
                        if ((i2 & 32) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                            z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function2) objRememberedValue;
                            i3 = (-458753) & i3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                            sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                        m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                    public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                        SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                            }
                            function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (i8 != 0) {
                            f4 = SliderKt.ThumbTrackGapSize;
                        }
                        if (i10 != 0) {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = SliderKt.TrackInsideCornerSize;
                        } else {
                            function8 = function7;
                            i12 = i3;
                            modifier4 = modifier2;
                            z5 = z2;
                            sliderColors4 = sliderColors2;
                            f7 = f4;
                            function9 = function4;
                            f8 = f3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                    }
                    m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = f8;
                    f5 = f7;
                    function5 = function8;
                    function6 = function9;
                    sliderColors3 = sliderColors4;
                    z4 = z5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    z4 = z2;
                    sliderColors3 = sliderColors2;
                    f5 = f4;
                    function6 = function4;
                    f6 = f3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors10 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors10;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors11 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors11;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                }
                m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f8;
                f5 = f7;
                function5 = function8;
                function6 = function9;
                sliderColors3 = sliderColors4;
                z4 = z5;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                f5 = f4;
                function6 = function4;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i3 |= i15;
            } else {
                sliderColors2 = sliderColors;
            }
            i3 |= i15;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                }
                i3 |= i16;
            } else {
                function4 = function2;
            }
            i3 |= i16;
        } else {
            function4 = function2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
            f4 = f2;
        } else {
            f4 = f2;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors12 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors12;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        SliderColors sliderColorsColors13 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                        i3 &= -57345;
                        sliderColors2 = sliderColorsColors13;
                    }
                    if ((i2 & 32) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                        z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function2) objRememberedValue;
                        i3 = (-458753) & i3;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                        sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                    m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                                public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                    SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                        }
                        function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (i8 != 0) {
                        f4 = SliderKt.ThumbTrackGapSize;
                    }
                    if (i10 != 0) {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = SliderKt.TrackInsideCornerSize;
                    } else {
                        function8 = function7;
                        i12 = i3;
                        modifier4 = modifier2;
                        z5 = z2;
                        sliderColors4 = sliderColors2;
                        f7 = f4;
                        function9 = function4;
                        f8 = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
                }
                m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f8;
                f5 = f7;
                function5 = function8;
                function6 = function9;
                sliderColors3 = sliderColors4;
                z4 = z5;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                z4 = z2;
                sliderColors3 = sliderColors2;
                f5 = f4;
                function6 = function4;
                f6 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i13 = 268435456;
            }
            i3 |= i13;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1958@86457L8,1959@86526L199,1966@86781L107");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    SliderColors sliderColorsColors14 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -57345;
                    sliderColors2 = sliderColorsColors14;
                }
                if ((i2 & 32) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                    z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    function8 = function7;
                    i12 = i3;
                    modifier4 = modifier2;
                    z5 = z2;
                    sliderColors4 = sliderColors2;
                    f7 = f4;
                    function9 = function4;
                    f8 = SliderKt.TrackInsideCornerSize;
                } else {
                    function8 = function7;
                    i12 = i3;
                    modifier4 = modifier2;
                    z5 = z2;
                    sliderColors4 = sliderColors2;
                    f7 = f4;
                    function9 = function4;
                    f8 = f3;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    SliderColors sliderColorsColors15 = colors(composerStartRestartGroup, (i3 >> 27) & 14);
                    i3 &= -57345;
                    sliderColors2 = sliderColorsColors15;
                }
                if ((i2 & 32) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119893793, "CC(remember):Slider.kt#9igjgp");
                    z6 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(sliderColors2)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SliderDefaults.Track_mnvyFg4$lambda$3$0(sliderColors2, z2, (DrawScope) obj, (Offset) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function2) objRememberedValue;
                    i3 = (-458753) & i3;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -119885725, "CC(remember):Slider.kt#9igjgp");
                    sliderDefaults$Track$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (sliderDefaults$Track$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        sliderDefaults$Track$14$1RememberedValue = new Function3<DrawScope, Offset, Color, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$14$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset, Color color) {
                                m4219invokewPWG1Vc(drawScope, offset.m6579unboximpl(), color.m6824unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-wPWG1Vc, reason: not valid java name */
                            public final void m4219invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
                                SliderDefaults.INSTANCE.m4214drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m4215getTickSizeD9Ej5fM(), j2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(sliderDefaults$Track$14$1RememberedValue);
                    }
                    function7 = (Function3) sliderDefaults$Track$14$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (i8 != 0) {
                    f4 = SliderKt.ThumbTrackGapSize;
                }
                if (i10 != 0) {
                    function8 = function7;
                    i12 = i3;
                    modifier4 = modifier2;
                    z5 = z2;
                    sliderColors4 = sliderColors2;
                    f7 = f4;
                    function9 = function4;
                    f8 = SliderKt.TrackInsideCornerSize;
                } else {
                    function8 = function7;
                    i12 = i3;
                    modifier4 = modifier2;
                    z5 = z2;
                    sliderColors4 = sliderColors2;
                    f7 = f4;
                    function9 = function4;
                    f8 = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1952945688, i12, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1971)");
            }
            m4202TrackImplxlyIBlM(rangeSliderState, f, modifier4, z5, sliderColors4, function9, function8, f7, f8, composerStartRestartGroup, i12 & 2147483646);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f6 = f8;
            f5 = f7;
            function5 = function8;
            function6 = function9;
            sliderColors3 = sliderColors4;
            z4 = z5;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function3;
            modifier3 = modifier2;
            z4 = z2;
            sliderColors3 = sliderColors2;
            f5 = f4;
            function6 = function4;
            f6 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.Track_mnvyFg4$lambda$5(this.f$0, rangeSliderState, f, modifier3, z4, sliderColors3, function6, function5, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: TrackImpl-xlyIBlM, reason: not valid java name */
    private final void m4202TrackImplxlyIBlM(final RangeSliderState rangeSliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2<? super DrawScope, ? super Offset, Unit> function2, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, final float f2, final float f3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1719396904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrackImpl)N(rangeSliderState,trackCornerSize:c#ui.unit.Dp,modifier,enabled,colors,drawStopIndicator,drawTick,thumbTrackGapSize:c#ui.unit.Dp,trackInsideCornerSize:c#ui.unit.Dp)2003@88229L449,2014@88689L1310,2002@88158L1841:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(rangeSliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1719396904, i2, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1997)");
            }
            final long jM4194trackColorWaAFU9c$material3 = sliderColors.m4194trackColorWaAFU9c$material3(z, false);
            int i3 = i2;
            final long jM4194trackColorWaAFU9c$material4 = sliderColors.m4194trackColorWaAFU9c$material3(z, true);
            final long jM4193tickColorWaAFU9c$material3 = sliderColors.m4193tickColorWaAFU9c$material3(z, false);
            final long jM4193tickColorWaAFU9c$material4 = sliderColors.m4193tickColorWaAFU9c$material3(z, true);
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222008025, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$0$0((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(modifierM1252height3ABfNKs, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1222023606, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(rangeSliderState) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4194trackColorWaAFU9c$material4) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material3) | composerStartRestartGroup.changed(jM4193tickColorWaAFU9c$material4) | ((i3 & 29360128) == 8388608) | ((i3 & 234881024) == 67108864) | ((i3 & 458752) == 131072) | ((i3 & 3670016) == 1048576);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderDefaults.TrackImpl_xlyIBlM$lambda$1$0(f, rangeSliderState, jM4194trackColorWaAFU9c$material3, jM4194trackColorWaAFU9c$material4, jM4193tickColorWaAFU9c$material3, jM4193tickColorWaAFU9c$material4, f2, f3, function2, function3, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                modifier2 = modifierLayout;
                composer2 = composerStartRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifier2, (Function1) objRememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderDefaults.TrackImpl_xlyIBlM$lambda$2(this.f$0, rangeSliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TrackImpl_xlyIBlM$lambda$0$0(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return measureScope.layout(placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(placeableMo8265measureBRTryo0.getHeight() / 2))), new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderDefaults.TrackImpl_xlyIBlM$lambda$0$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$0$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrackImpl_xlyIBlM$lambda$1$0(float f, RangeSliderState rangeSliderState, long j, long j2, long j3, long j4, float f2, float f3, Function2 function2, Function3 function3, DrawScope drawScope) {
        float fIntBitsToFloat;
        if (!Dp.m9692equalsimpl0(f, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())) {
            fIntBitsToFloat = drawScope.mo754toPx0680j_4(f);
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)) / 2;
        }
        m4204drawTrackGVD57ws$default(INSTANCE, drawScope, rangeSliderState.getTickFractions(), rangeSliderState.getCoercedActiveRangeStartAsFraction$material3(), rangeSliderState.getCoercedActiveRangeEndAsFraction$material3(), j, j2, j3, j4, drawScope.mo750toDpu2uoSUM(rangeSliderState.getStartThumbWidth$material3()), drawScope.mo750toDpu2uoSUM(rangeSliderState.getStartThumbHeight$material3()), drawScope.mo750toDpu2uoSUM(rangeSliderState.getEndThumbWidth$material3()), drawScope.mo750toDpu2uoSUM(rangeSliderState.getEndThumbHeight$material3()), f2, f3, drawScope.mo750toDpu2uoSUM(fIntBitsToFloat), function2, function3, true, false, null, false, 917504, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTrack-GVD57ws$default, reason: not valid java name */
    static /* synthetic */ void m4204drawTrackGVD57ws$default(SliderDefaults sliderDefaults, DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2 function2, Function3 function3, boolean z, boolean z2, Orientation orientation, boolean z3, int i, Object obj) {
        sliderDefaults.m4203drawTrackGVD57ws(drawScope, fArr, f, f2, j, j2, j3, j4, f3, f4, f5, f6, f7, f8, f9, function2, function3, z, (i & 131072) != 0 ? false : z2, (i & 262144) != 0 ? Orientation.Horizontal : orientation, (i & 524288) != 0 ? false : z3);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0261  */
    /* JADX WARN: Code duplicated, block: B:177:0x0400  */
    /* JADX WARN: Code duplicated, block: B:216:0x0532  */
    /* JADX WARN: Code duplicated, block: B:67:0x0121  */
    /* JADX INFO: renamed from: drawTrack-GVD57ws, reason: not valid java name */
    private final void m4203drawTrackGVD57ws(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, boolean z, boolean z2, Orientation orientation, boolean z3) {
        float f10;
        float f11;
        boolean z4;
        long jM6561constructorimpl;
        long jM6629constructorimpl;
        float f12;
        float f13;
        long jM6561constructorimpl2;
        float f14;
        float f15;
        float f16;
        ClosedFloatingPointRange<Float> closedFloatingPointRange;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        long jM6561constructorimpl3;
        long jM6561constructorimpl4;
        long jM6629constructorimpl2;
        long jM6561constructorimpl5;
        long jM6629constructorimpl3;
        long jM6561constructorimpl6;
        float f17;
        float f18;
        float f19;
        boolean z5 = orientation == Orientation.Vertical;
        boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        boolean z7 = z6 && !z5;
        float f20 = drawScope.mo754toPx0680j_4(f9);
        long jMo7395getSizeNHjbRc = drawScope.mo7395getSizeNHjbRc();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (z5 ? jMo7395getSizeNHjbRc & 4294967295L : jMo7395getSizeNHjbRc >> 32));
        boolean z8 = Intrinsics.areEqual(f, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f, ArraysKt.lastOrNull(fArr));
        float f21 = ((fArr.length == 0) || (Intrinsics.areEqual(f2, ArraysKt.firstOrNull(fArr)) || Intrinsics.areEqual(f2, ArraysKt.lastOrNull(fArr)))) ? 0.0f + ((fIntBitsToFloat - 0.0f) * f2) : (((fIntBitsToFloat - 0.0f) - (2 * f20)) * f2) + 0.0f + f20;
        float f22 = ((fArr.length == 0) || z8) ? 0.0f + ((fIntBitsToFloat - 0.0f) * f) : (((fIntBitsToFloat - 0.0f) - (2 * f20)) * f) + 0.0f + f20;
        float f23 = drawScope.mo754toPx0680j_4(f8);
        if (Dp.m9686compareTo0680j_4(f7, Dp.m9687constructorimpl(0)) > 0) {
            if (z5) {
                float f24 = 2;
                f17 = (drawScope.mo754toPx0680j_4(f4) / f24) + drawScope.mo754toPx0680j_4(f7);
                f18 = drawScope.mo754toPx0680j_4(f6) / f24;
                f19 = drawScope.mo754toPx0680j_4(f7);
            } else {
                float f25 = 2;
                f17 = (drawScope.mo754toPx0680j_4(f3) / f25) + drawScope.mo754toPx0680j_4(f7);
                f18 = drawScope.mo754toPx0680j_4(f5) / f25;
                f19 = drawScope.mo754toPx0680j_4(f7);
            }
            f10 = f17;
            f11 = f18 + f19;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        long jMo7394getCenterF1C5BW0 = drawScope.mo7394getCenterF1C5BW0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (z5 ? jMo7394getCenterF1C5BW0 & 4294967295L : jMo7394getCenterF1C5BW0 >> 32));
        float f26 = f10 + 0.0f;
        if (z2) {
            if (!(fArr.length == 0)) {
                f26 += f20;
            }
        } else {
            f26 += f20;
        }
        float fMin = z3 ? Math.min(f21, fIntBitsToFloat2) : f22;
        if ((z3 || z) && fMin > f26) {
            float f27 = z7 ? f23 : f20;
            float f28 = z7 ? f20 : f23;
            float f29 = fMin - f10;
            if (z7) {
                z4 = true;
                jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f29)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            } else {
                z4 = true;
                jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            }
            if (z5) {
                jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f29 - 0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)))) << 32));
            } else {
                jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(f29 - 0.0f)) << 32));
            }
            f12 = fIntBitsToFloat2;
            f13 = f21;
            m4205drawTrackPathzXTsYAs(drawScope, orientation, jM6561constructorimpl, jM6629constructorimpl, j, f27, f28);
            if (z5) {
                jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f20 + 0.0f)) & 4294967295L));
            } else if (z6) {
                jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - 0.0f) - f20)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
            } else {
                jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f20 + 0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
            }
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m6558boximpl(jM6561constructorimpl2));
                Unit unit = Unit.INSTANCE;
            }
        } else {
            f12 = fIntBitsToFloat2;
            f13 = f21;
            z4 = true;
        }
        float f30 = fIntBitsToFloat - f11;
        if (z2) {
            if (!(fArr.length == 0 ? z4 : false)) {
                f30 -= f20;
            }
        } else {
            f30 -= f20;
        }
        float fMax = z3 ? Math.max(f13, f12) : f13;
        if (fMax < f30) {
            float f31 = z7 ? f20 : f23;
            float f32 = z7 ? f23 : f20;
            float f33 = fMax + f11;
            float f34 = fIntBitsToFloat - f33;
            if (z5) {
                jM6561constructorimpl5 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f33)) & 4294967295L));
            } else if (z6) {
                jM6561constructorimpl5 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            } else {
                jM6561constructorimpl5 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f33)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            }
            if (z5) {
                jM6629constructorimpl3 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f34)) & 4294967295L));
            } else if (z6 && !z) {
                jM6629constructorimpl3 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f33)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L));
            } else {
                jM6629constructorimpl3 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f34)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L));
            }
            m4205drawTrackPathzXTsYAs(drawScope, orientation, jM6561constructorimpl5, jM6629constructorimpl3, j, f31, f32);
            if (z5) {
                jM6561constructorimpl6 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - f20)) & 4294967295L));
            } else if (z6) {
                jM6561constructorimpl6 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f20)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
            } else {
                jM6561constructorimpl6 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - f20)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
            }
            if (function2 != null) {
                function2.invoke(drawScope, Offset.m6558boximpl(jM6561constructorimpl6));
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (z3) {
            f14 = fMin + (fMin < f12 ? f10 : 0.0f);
        } else {
            f14 = z ? f22 + f10 : 0.0f;
        }
        if (z3) {
            f15 = fMax - (fMax > f12 ? f11 : 0.0f);
        } else {
            f15 = f13 - f11;
        }
        float f35 = (z7 || z3 || z) ? f23 : f20;
        float f36 = (!z7 || z3 || z) ? f23 : f20;
        float f37 = (!z7 || z3 || z) ? f15 - f14 : f15;
        if (z2) {
            if (fArr.length == 0 ? z4 : false) {
                f16 = 0.0f;
            } else {
                f16 = f35;
            }
        } else {
            f16 = f35;
        }
        if (f37 > f16) {
            if (z5) {
                jM6561constructorimpl4 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f14)) & 4294967295L));
            } else if (z6) {
                jM6561constructorimpl4 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f15)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            } else {
                jM6561constructorimpl4 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f14)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            }
            long j5 = jM6561constructorimpl4;
            if (z5) {
                jM6629constructorimpl2 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f37)) & 4294967295L));
            } else if (z6 && !z3 && !z) {
                jM6629constructorimpl2 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f15)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L));
            } else {
                jM6629constructorimpl2 = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f37)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)))) & 4294967295L));
            }
            m4205drawTrackPathzXTsYAs(drawScope, orientation, j5, jM6629constructorimpl2, j2, f35, f36);
        }
        float f38 = 0.0f + f20;
        float f39 = fIntBitsToFloat - f20;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(f14, f15);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo2 = RangesKt.rangeTo(f12 - f11, f12 + f11);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo3 = RangesKt.rangeTo(f22 - f10, f22 + f10);
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo4 = RangesKt.rangeTo(f13 - f11, f13 + f11);
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            float f40 = fArr[i2];
            int i3 = i + 1;
            if (function2 == null || !(((z3 || z) && i == 0) || i == fArr.length - 1)) {
                float fLerp = MathHelpersKt.lerp(f38, f39, f40);
                if ((z3 && closedFloatingPointRangeRangeTo2.contains(Float.valueOf(fLerp))) || ((z && closedFloatingPointRangeRangeTo3.contains(Float.valueOf(fLerp))) || closedFloatingPointRangeRangeTo4.contains(Float.valueOf(fLerp)))) {
                    closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                } else {
                    if (z5) {
                        closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                        jM6561constructorimpl3 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fLerp)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() >> 32)))) << 32));
                    } else {
                        closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
                        if (z6) {
                            jM6561constructorimpl3 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - fLerp)) << 32));
                        } else {
                            jM6561constructorimpl3 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fLerp)) << 32));
                        }
                    }
                    function3.invoke(drawScope, Offset.m6558boximpl(jM6561constructorimpl3), Color.m6804boximpl(closedFloatingPointRangeRangeTo.contains(Float.valueOf(fLerp)) ? j4 : j3));
                }
            } else {
                closedFloatingPointRange = closedFloatingPointRangeRangeTo2;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo3;
            }
            i2++;
            closedFloatingPointRangeRangeTo2 = closedFloatingPointRange;
            closedFloatingPointRangeRangeTo3 = closedFloatingPointRange2;
            i = i3;
        }
    }

    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public final void m4214drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, float f, long j2) {
        DrawScope.m7376drawCircleVaOC9Bg$default(drawScope, j2, drawScope.mo754toPx0680j_4(f) / 2.0f, j, 0.0f, null, null, 0, 120, null);
    }

    /* JADX INFO: renamed from: getTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m4216getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }

    /* JADX INFO: renamed from: getTickSize-D9Ej5fM, reason: not valid java name */
    public final float m4215getTickSizeD9Ej5fM() {
        return TickSize;
    }

    /* JADX INFO: renamed from: drawTrackPath-zXTsYAs, reason: not valid java name */
    private final void m4205drawTrackPathzXTsYAs(DrawScope drawScope, Orientation orientation, long j, long j2, long j3, float f, float f2) {
        RoundRect roundRectM6621RoundRectZAM2FJo;
        long jM6523constructorimpl = CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        long jM6523constructorimpl2 = CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        if (orientation == Orientation.Vertical) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM6621RoundRectZAM2FJo = RoundRectKt.m6621RoundRectZAM2FJo(RectKt.m6609Recttz77jQw(j, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32))), jM6523constructorimpl, jM6523constructorimpl, jM6523constructorimpl2, jM6523constructorimpl2);
        } else {
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
            roundRectM6621RoundRectZAM2FJo = RoundRectKt.m6621RoundRectZAM2FJo(RectKt.m6609Recttz77jQw(j, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32))), jM6523constructorimpl, jM6523constructorimpl2, jM6523constructorimpl2, jM6523constructorimpl);
        }
        Path path = trackPath;
        Path.addRoundRect$default(path, roundRectM6621RoundRectZAM2FJo, null, 2, null);
        DrawScope.m7385drawPathLG529CI$default(drawScope, path, j3, 0.0f, null, null, 0, 60, null);
        path.rewind();
    }
}
