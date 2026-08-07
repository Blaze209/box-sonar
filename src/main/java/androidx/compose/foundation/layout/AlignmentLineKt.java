package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"paddingFrom", "Landroidx/compose/ui/Modifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", TtmlNode.ANNOTATION_POSITION_BEFORE, "Landroidx/compose/ui/unit/Dp;", TtmlNode.ANNOTATION_POSITION_AFTER, "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", ViewProps.TOP, ViewProps.BOTTOM, "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "horizontal", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlignmentLineKt {
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1040paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
        }
        return m1039paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m1039paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, Dp.m9685boximpl(f));
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, Dp.m9685boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1042paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
        }
        return m1041paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m1041paddingFromY_r0B1c(Modifier modifier, final AlignmentLine alignmentLine, final long j, final long j2) {
        AlignmentLine alignmentLine2;
        long j3;
        long j4;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
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
                    inspectorInfo.setName("paddingFrom");
                    inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, TextUnit.m9871boximpl(j));
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, TextUnit.m9871boximpl(j2));
                }
            };
        } else {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j3, j4, noInspectorInfo, null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1044paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
        }
        return m1043paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1046paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
        }
        return m1045paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m1038alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int iMax;
        int height;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo8265measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? placeableMo8265measureBRTryo0.getHeight() : placeableMo8265measureBRTryo0.getWidth();
        int iM9639getMaxHeightimpl = (getHorizontal(alignmentLine) ? Constraints.m9639getMaxHeightimpl(j) : Constraints.m9640getMaxWidthimpl(j)) - height2;
        final int iCoerceIn = RangesKt.coerceIn((!Float.isNaN(f) ? measureScope.mo748roundToPx0680j_4(f) : 0) - i, 0, iM9639getMaxHeightimpl);
        final int iCoerceIn2 = RangesKt.coerceIn(((!Float.isNaN(f2) ? measureScope.mo748roundToPx0680j_4(f2) : 0) - height2) + i, 0, iM9639getMaxHeightimpl - iCoerceIn);
        if (getHorizontal(alignmentLine)) {
            iMax = placeableMo8265measureBRTryo0.getWidth();
        } else {
            iMax = Math.max(placeableMo8265measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m9642getMinWidthimpl(j));
        }
        final int i2 = iMax;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(placeableMo8265measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m9641getMinHeightimpl(j));
        } else {
            height = placeableMo8265measureBRTryo0.getHeight();
        }
        final int i3 = height;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlignmentLineKt.alignmentLineOffsetMeasure_tjqqzMA$lambda$1(alignmentLine, f, iCoerceIn, i2, iCoerceIn2, placeableMo8265measureBRTryo0, i3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$1(AlignmentLine alignmentLine, float f, int i, int i2, int i3, Placeable placeable, int i4, Placeable.PlacementScope placementScope) {
        int width;
        int i5;
        if (getHorizontal(alignmentLine)) {
            width = 0;
        } else {
            width = !Dp.m9692equalsimpl0(f, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM()) ? i : (i2 - i3) - placeable.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            if (Dp.m9692equalsimpl0(f, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())) {
                i = (i4 - i3) - placeable.getHeight();
            }
            i5 = i;
        } else {
            i5 = 0;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, i5, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m1043paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier.Companion companionM1040paddingFrom4j6BHR0$default;
        Modifier.Companion companionM1040paddingFrom4j6BHR0$default2;
        if (!Float.isNaN(f)) {
            companionM1040paddingFrom4j6BHR0$default = m1040paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            companionM1040paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = modifier.then(companionM1040paddingFrom4j6BHR0$default);
        if (!Float.isNaN(f2)) {
            companionM1040paddingFrom4j6BHR0$default2 = m1040paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            companionM1040paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM1040paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m1045paddingFromBaselinewCyjxdI(Modifier modifier, long j, long j2) {
        Modifier.Companion companionM1042paddingFromY_r0B1c$default;
        Modifier modifierThen = modifier.then(TextUnit.m9879getRawTypeimpl(j) == 0 ? Modifier.INSTANCE : m1042paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null));
        if (TextUnit.m9879getRawTypeimpl(j2) != 0) {
            companionM1042paddingFromY_r0B1c$default = m1042paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null);
        } else {
            companionM1042paddingFromY_r0B1c$default = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM1042paddingFromY_r0B1c$default);
    }
}
