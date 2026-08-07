package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.extractor.WavUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u001a2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a=\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010*\u001aT\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0082\b\u001a\u0091\u0001\u00103\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0083\b\u001a[\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0002¢\u0006\u0002\u0010<\u001a\u0096\u0001\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001aY\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010M\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002\u001a\u001c\u0010P\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u00104\u001a\u00020\u000bH\u0000\u001a\u001c\u0010S\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u0010/\u001a\u00020\u000bH\u0000\u001a9\u0010Z\u001a\u000207*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020[2\u0014\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001aQ\u0010`\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W\"\u0014\u0010X\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010W¨\u0006i"}, d2 = {"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", ViewProps.OVERFLOW, "Landroidx/compose/foundation/layout/FlowRowOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", BoxRepresentation.FIELD_INFO, "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", AlertFragment.ARG_ITEMS, "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(Alignment.INSTANCE.getStart());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$2(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, flowColumnOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$3(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$2(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, flowRowOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$3(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x013b  */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:109:0x0144  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:116:0x016b  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:142:0x0209  */
    /* JADX WARN: Code duplicated, block: B:144:0x0211  */
    /* JADX WARN: Code duplicated, block: B:147:0x0250  */
    /* JADX WARN: Code duplicated, block: B:150:0x025c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0260  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:156:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:97:0x011c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0128  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        int i7;
        int i8;
        Alignment.Vertical top;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z;
        final Modifier modifier2;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        Composer composer2;
        final int i17;
        final int i18;
        final FlowRowOverflow flowRowOverflow2;
        final Alignment.Vertical vertical4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Arrangement.Horizontal start;
        int i19;
        Arrangement.Vertical top2;
        int i20;
        int i21;
        FlowRowOverflow clip;
        int i22;
        boolean z2;
        Object objRememberedValue;
        FlowLayoutOverflowState flowLayoutOverflowState;
        MultiContentMeasurePolicy multiContentMeasurePolicyRowMeasurementMultiContentHelper;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        Object obj;
        boolean zChanged;
        Object objRememberedValue3;
        Function0<ComposeUiNode> constructor;
        int i23;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1956591841);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)100@4511L53,102@4597L226,111@4877L291,118@5174L75:FlowLayout.kt#2w3rfo");
        int i24 = i4 & 1;
        if (i24 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i25 = i4 & 2;
        if (i25 == 0) {
            if ((i3 & 48) == 0) {
                horizontal2 = horizontal;
                i5 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 3072) == 0) {
                        top = vertical2;
                        if (composerStartRestartGroup.changed(top)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((i3 & 24576) == 0) {
                            i11 = i;
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 16384;
                            } else {
                                i12 = 8192;
                            }
                            i5 |= i12;
                        }
                        i13 = i4 & 32;
                        if (i13 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i2)) {
                                i14 = 131072;
                            } else {
                                i14 = 65536;
                            }
                            i5 |= i14;
                        }
                        i15 = i4 & 64;
                        if (i15 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(flowRowOverflow)) {
                                i16 = 1048576;
                            } else {
                                i16 = 524288;
                            }
                            i5 |= i16;
                        }
                        if ((i3 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i23 = 8388608;
                            } else {
                                i23 = 4194304;
                            }
                            i5 |= i23;
                        }
                        if ((i5 & 4793491) != 4793490) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            vertical3 = vertical;
                            horizontal3 = horizontal2;
                            composer2 = composerStartRestartGroup;
                            i17 = i11;
                            i18 = i2;
                            flowRowOverflow2 = flowRowOverflow;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i25 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top2 = Arrangement.INSTANCE.getTop();
                                i19 = i8;
                            } else {
                                i19 = i8;
                                top2 = vertical;
                            }
                            if (i19 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            }
                            if (i10 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i11;
                            }
                            if (i13 != 0) {
                                i21 = Integer.MAX_VALUE;
                            } else {
                                i21 = i2;
                            }
                            if (i15 != 0) {
                                clip = FlowRowOverflow.INSTANCE.getClip();
                            } else {
                                clip = flowRowOverflow;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                            i22 = 3670016 & i5;
                            if (i22 == 1048576) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                            if (i22 == 1048576) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if ((29360128 & i5) == 8388608) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            boolean z7 = z3 | z4;
                            if ((i5 & 458752) == 131072) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = z7 | z5;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                obj = objRememberedValue2;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }));
                                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                composerStartRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            }
                            obj = objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Modifier modifier3 = companion;
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
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical3 = top2;
                            i17 = i20;
                            i18 = i21;
                            modifier2 = modifier3;
                            composer2 = composerStartRestartGroup;
                            flowRowOverflow2 = clip;
                            horizontal3 = start;
                        }
                        vertical4 = top;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                        }
                    }
                    i5 |= 24576;
                    i11 = i;
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowRowOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        vertical3 = vertical;
                        horizontal3 = horizontal2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowRowOverflow2 = flowRowOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top2 = Arrangement.INSTANCE.getTop();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            top2 = vertical;
                        }
                        if (i19 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowRowOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z8 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z8 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList2);
                            composerStartRestartGroup.updateRememberedValue(arrayList2);
                            obj = arrayList2;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList3);
                            composerStartRestartGroup.updateRememberedValue(arrayList3);
                            obj = arrayList3;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts2 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier4 = companion;
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts2.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical3 = top2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier4;
                        composer2 = composerStartRestartGroup;
                        flowRowOverflow2 = clip;
                        horizontal3 = start;
                    }
                    vertical4 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 3072;
                top = vertical2;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowRowOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        vertical3 = vertical;
                        horizontal3 = horizontal2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowRowOverflow2 = flowRowOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top2 = Arrangement.INSTANCE.getTop();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            top2 = vertical;
                        }
                        if (i19 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowRowOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z9 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z9 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList4);
                            composerStartRestartGroup.updateRememberedValue(arrayList4);
                            obj = arrayList4;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList5);
                            composerStartRestartGroup.updateRememberedValue(arrayList5);
                            obj = arrayList5;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts3 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier5 = companion;
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
                        Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts3.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical3 = top2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier5;
                        composer2 = composerStartRestartGroup;
                        flowRowOverflow2 = clip;
                        horizontal3 = start;
                    }
                    vertical4 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z10 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z10 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList6);
                        composerStartRestartGroup.updateRememberedValue(arrayList6);
                        obj = arrayList6;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList7 = new ArrayList();
                        arrayList7.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList7);
                        composerStartRestartGroup.updateRememberedValue(arrayList7);
                        obj = arrayList7;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts4 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier6 = companion;
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
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts4.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier6;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    top = vertical2;
                    if (composerStartRestartGroup.changed(top)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowRowOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        vertical3 = vertical;
                        horizontal3 = horizontal2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowRowOverflow2 = flowRowOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top2 = Arrangement.INSTANCE.getTop();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            top2 = vertical;
                        }
                        if (i19 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowRowOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z11 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z11 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList8 = new ArrayList();
                            arrayList8.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList8);
                            composerStartRestartGroup.updateRememberedValue(arrayList8);
                            obj = arrayList8;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList9 = new ArrayList();
                            arrayList9.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList9);
                            composerStartRestartGroup.updateRememberedValue(arrayList9);
                            obj = arrayList9;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts5 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy5 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier7 = companion;
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
                        Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts5.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical3 = top2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier7;
                        composer2 = composerStartRestartGroup;
                        flowRowOverflow2 = clip;
                        horizontal3 = start;
                    }
                    vertical4 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z12 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z12 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList10 = new ArrayList();
                        arrayList10.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList10);
                        composerStartRestartGroup.updateRememberedValue(arrayList10);
                        obj = arrayList10;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11 = new ArrayList();
                        arrayList11.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList11);
                        composerStartRestartGroup.updateRememberedValue(arrayList11);
                        obj = arrayList11;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts6 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier8 = companion;
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts6.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier8;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            top = vertical2;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z13 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z13 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList12 = new ArrayList();
                        arrayList12.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList12);
                        composerStartRestartGroup.updateRememberedValue(arrayList12);
                        obj = arrayList12;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList13 = new ArrayList();
                        arrayList13.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList13);
                        composerStartRestartGroup.updateRememberedValue(arrayList13);
                        obj = arrayList13;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts7 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier9 = companion;
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
                    Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts7.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier9;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowRowOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                vertical3 = vertical;
                horizontal3 = horizontal2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowRowOverflow2 = flowRowOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top2 = Arrangement.INSTANCE.getTop();
                    i19 = i8;
                } else {
                    i19 = i8;
                    top2 = vertical;
                }
                if (i19 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowRowOverflow.INSTANCE.getClip();
                } else {
                    clip = flowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z14 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z14 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList14 = new ArrayList();
                    arrayList14.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList14);
                    composerStartRestartGroup.updateRememberedValue(arrayList14);
                    obj = arrayList14;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList15 = new ArrayList();
                    arrayList15.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList15);
                    composerStartRestartGroup.updateRememberedValue(arrayList15);
                    obj = arrayList15;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts8 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier10 = companion;
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
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts8.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical3 = top2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier10;
                composer2 = composerStartRestartGroup;
                flowRowOverflow2 = clip;
                horizontal3 = start;
            }
            vertical4 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        horizontal2 = horizontal;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 384) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    top = vertical2;
                    if (composerStartRestartGroup.changed(top)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowRowOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        vertical3 = vertical;
                        horizontal3 = horizontal2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowRowOverflow2 = flowRowOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top2 = Arrangement.INSTANCE.getTop();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            top2 = vertical;
                        }
                        if (i19 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowRowOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z15 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z15 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList16 = new ArrayList();
                            arrayList16.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList16);
                            composerStartRestartGroup.updateRememberedValue(arrayList16);
                            obj = arrayList16;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList17 = new ArrayList();
                            arrayList17.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList17);
                            composerStartRestartGroup.updateRememberedValue(arrayList17);
                            obj = arrayList17;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts9 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy9 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier11 = companion;
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
                        Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts9.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical3 = top2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier11;
                        composer2 = composerStartRestartGroup;
                        flowRowOverflow2 = clip;
                        horizontal3 = start;
                    }
                    vertical4 = top;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z16 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z16 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList18 = new ArrayList();
                        arrayList18.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList18);
                        composerStartRestartGroup.updateRememberedValue(arrayList18);
                        obj = arrayList18;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList19 = new ArrayList();
                        arrayList19.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList19);
                        composerStartRestartGroup.updateRememberedValue(arrayList19);
                        obj = arrayList19;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts10 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy10 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier12 = companion;
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
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts10.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier12;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            top = vertical2;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z17 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z17 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList110 = new ArrayList();
                        arrayList110.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList110);
                        composerStartRestartGroup.updateRememberedValue(arrayList110);
                        obj = arrayList110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList111 = new ArrayList();
                        arrayList111.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList111);
                        composerStartRestartGroup.updateRememberedValue(arrayList111);
                        obj = arrayList111;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts11 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy11 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier13 = companion;
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
                    Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts11.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier13;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowRowOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                vertical3 = vertical;
                horizontal3 = horizontal2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowRowOverflow2 = flowRowOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top2 = Arrangement.INSTANCE.getTop();
                    i19 = i8;
                } else {
                    i19 = i8;
                    top2 = vertical;
                }
                if (i19 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowRowOverflow.INSTANCE.getClip();
                } else {
                    clip = flowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z18 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z18 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList112 = new ArrayList();
                    arrayList112.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList112);
                    composerStartRestartGroup.updateRememberedValue(arrayList112);
                    obj = arrayList112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList113 = new ArrayList();
                    arrayList113.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList113);
                    composerStartRestartGroup.updateRememberedValue(arrayList113);
                    obj = arrayList113;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts12 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy12 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier14 = companion;
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
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts12.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical3 = top2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier14;
                composer2 = composerStartRestartGroup;
                flowRowOverflow2 = clip;
                horizontal3 = start;
            }
            vertical4 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 3072) == 0) {
                top = vertical2;
                if (composerStartRestartGroup.changed(top)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowRowOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    vertical3 = vertical;
                    horizontal3 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowRowOverflow2 = flowRowOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top2 = Arrangement.INSTANCE.getTop();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        top2 = vertical;
                    }
                    if (i19 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowRowOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z19 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z19 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList114 = new ArrayList();
                        arrayList114.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList114);
                        composerStartRestartGroup.updateRememberedValue(arrayList114);
                        obj = arrayList114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList115 = new ArrayList();
                        arrayList115.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList115);
                        composerStartRestartGroup.updateRememberedValue(arrayList115);
                        obj = arrayList115;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts13 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy13 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier15 = companion;
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
                    Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts13.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical3 = top2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier15;
                    composer2 = composerStartRestartGroup;
                    flowRowOverflow2 = clip;
                    horizontal3 = start;
                }
                vertical4 = top;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowRowOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                vertical3 = vertical;
                horizontal3 = horizontal2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowRowOverflow2 = flowRowOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top2 = Arrangement.INSTANCE.getTop();
                    i19 = i8;
                } else {
                    i19 = i8;
                    top2 = vertical;
                }
                if (i19 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowRowOverflow.INSTANCE.getClip();
                } else {
                    clip = flowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z110 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z110 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList116 = new ArrayList();
                    arrayList116.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList116);
                    composerStartRestartGroup.updateRememberedValue(arrayList116);
                    obj = arrayList116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList117 = new ArrayList();
                    arrayList117.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList117);
                    composerStartRestartGroup.updateRememberedValue(arrayList117);
                    obj = arrayList117;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts14 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy14 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier16 = companion;
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
                Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts14.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical3 = top2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier16;
                composer2 = composerStartRestartGroup;
                flowRowOverflow2 = clip;
                horizontal3 = start;
            }
            vertical4 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        top = vertical2;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((i3 & 24576) == 0) {
                i11 = i;
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i5 |= i12;
            }
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowRowOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                vertical3 = vertical;
                horizontal3 = horizontal2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowRowOverflow2 = flowRowOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top2 = Arrangement.INSTANCE.getTop();
                    i19 = i8;
                } else {
                    i19 = i8;
                    top2 = vertical;
                }
                if (i19 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowRowOverflow.INSTANCE.getClip();
                } else {
                    clip = flowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z111 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z111 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList118 = new ArrayList();
                    arrayList118.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList118);
                    composerStartRestartGroup.updateRememberedValue(arrayList118);
                    obj = arrayList118;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList119 = new ArrayList();
                    arrayList119.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList119);
                    composerStartRestartGroup.updateRememberedValue(arrayList119);
                    obj = arrayList119;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts15 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy15 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier17 = companion;
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
                Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts15.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical3 = top2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier17;
                composer2 = composerStartRestartGroup;
                flowRowOverflow2 = clip;
                horizontal3 = start;
            }
            vertical4 = top;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        i11 = i;
        i13 = i4 & 32;
        if (i13 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i5 |= i14;
        }
        i15 = i4 & 64;
        if (i15 != 0) {
            i5 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(flowRowOverflow)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i5 |= i16;
        }
        if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i23 = 8388608;
            } else {
                i23 = 4194304;
            }
            i5 |= i23;
        }
        if ((i5 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            vertical3 = vertical;
            horizontal3 = horizontal2;
            composer2 = composerStartRestartGroup;
            i17 = i11;
            i18 = i2;
            flowRowOverflow2 = flowRowOverflow;
        } else {
            if (i24 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i25 != 0) {
                start = Arrangement.INSTANCE.getStart();
            } else {
                start = horizontal2;
            }
            if (i6 != 0) {
                top2 = Arrangement.INSTANCE.getTop();
                i19 = i8;
            } else {
                i19 = i8;
                top2 = vertical;
            }
            if (i19 != 0) {
                top = Alignment.INSTANCE.getTop();
            }
            if (i10 != 0) {
                i20 = Integer.MAX_VALUE;
            } else {
                i20 = i11;
            }
            if (i13 != 0) {
                i21 = Integer.MAX_VALUE;
            } else {
                i21 = i2;
            }
            if (i15 != 0) {
                clip = FlowRowOverflow.INSTANCE.getClip();
            } else {
                clip = flowRowOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910931156, "CC(remember):FlowLayout.kt#9igjgp");
            i22 = 3670016 & i5;
            if (i22 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = clip.createOverflowState$foundation_layout();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top2, top, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910943106, "CC(remember):FlowLayout.kt#9igjgp");
            if (i22 == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((29360128 & i5) == 8388608) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z112 = z3 | z4;
            if ((i5 & 458752) == 131072) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z112 | z5;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                obj = objRememberedValue2;
                ArrayList arrayList1110 = new ArrayList();
                arrayList1110.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList1110);
                composerStartRestartGroup.updateRememberedValue(arrayList1110);
                obj = arrayList1110;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList1111 = new ArrayList();
                arrayList1111.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowRow$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList1111);
                composerStartRestartGroup.updateRememberedValue(arrayList1111);
                obj = arrayList1111;
            }
            obj = objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts16 = LayoutKt.combineAsVirtualLayouts((List) obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MeasurePolicy measurePolicy16 = (MeasurePolicy) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier18 = companion;
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
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts16.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            vertical3 = top2;
            i17 = i20;
            i18 = i21;
            modifier2 = modifier18;
            composer2 = composerStartRestartGroup;
            flowRowOverflow2 = clip;
            horizontal3 = start;
        }
        vertical4 = top;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FlowLayoutKt.FlowRow$lambda$2(modifier2, horizontal3, vertical3, vertical4, i17, i18, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5051L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1192950673, i, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:113)");
            }
            function3.invoke(FlowRowScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0169  */
    /* JADX WARN: Code duplicated, block: B:106:0x0172  */
    /* JADX WARN: Code duplicated, block: B:109:0x0185  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0102  */
    /* JADX WARN: Code duplicated, block: B:89:0x010a  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x0127  */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Arrangement.Horizontal horizontal2;
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
        boolean z;
        Composer composer2;
        final Alignment.Vertical vertical3;
        final Modifier modifier3;
        final Arrangement.Horizontal horizontal3;
        final int i16;
        final Arrangement.Vertical vertical4;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i18;
        Arrangement.Horizontal start;
        Arrangement.Vertical top;
        int i19;
        Alignment.Vertical top2;
        int i20;
        int i21;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1303174015);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,content)162@7315L215:FlowLayout.kt#2w3rfo");
        int i22 = i4 & 1;
        if (i22 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        int i23 = i4 & 2;
        if (i23 == 0) {
            if ((i3 & 48) == 0) {
                horizontal2 = horizontal;
                i5 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 3072) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((i3 & 24576) == 0) {
                            i11 = i;
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 16384;
                            } else {
                                i12 = 8192;
                            }
                            i5 |= i12;
                        }
                        i13 = i4 & 32;
                        if (i13 != 0) {
                            if ((196608 & i3) == 0) {
                                i14 = i2;
                                if (composerStartRestartGroup.changed(i14)) {
                                    i15 = 131072;
                                } else {
                                    i15 = 65536;
                                }
                                i5 |= i15;
                            }
                            if ((i3 & 1572864) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i21 = 1048576;
                                } else {
                                    i21 = 524288;
                                }
                                i5 |= i21;
                            }
                            if ((i5 & 599187) != 599186) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                vertical3 = vertical2;
                                modifier3 = modifier2;
                                horizontal3 = horizontal2;
                                i16 = i14;
                                vertical4 = vertical;
                            } else {
                                if (i22 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i23 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                    i18 = i8;
                                } else {
                                    i18 = i8;
                                    start = horizontal2;
                                }
                                if (i6 != 0) {
                                    top = Arrangement.INSTANCE.getTop();
                                } else {
                                    top = vertical;
                                }
                                if (i18 != 0) {
                                    top2 = Alignment.INSTANCE.getTop();
                                    i19 = i10;
                                } else {
                                    i19 = i10;
                                    top2 = vertical2;
                                }
                                if (i19 != 0) {
                                    i11 = Integer.MAX_VALUE;
                                }
                                if (i13 != 0) {
                                    i20 = Integer.MAX_VALUE;
                                } else {
                                    i20 = i14;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                                }
                                composer2 = composerStartRestartGroup;
                                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                horizontal3 = start;
                                vertical4 = top;
                                vertical3 = top2;
                                i16 = i20;
                            }
                            i17 = i11;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i14 = i2;
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical3 = vertical2;
                            modifier3 = modifier2;
                            horizontal3 = horizontal2;
                            i16 = i14;
                            vertical4 = vertical;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical;
                            }
                            if (i18 != 0) {
                                top2 = Alignment.INSTANCE.getTop();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                top2 = vertical2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            horizontal3 = start;
                            vertical4 = top;
                            vertical3 = top2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= 24576;
                    i11 = i;
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical3 = vertical2;
                            modifier3 = modifier2;
                            horizontal3 = horizontal2;
                            i16 = i14;
                            vertical4 = vertical;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical;
                            }
                            if (i18 != 0) {
                                top2 = Alignment.INSTANCE.getTop();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                top2 = vertical2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            horizontal3 = start;
                            vertical4 = top;
                            vertical3 = top2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 3072;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical3 = vertical2;
                            modifier3 = modifier2;
                            horizontal3 = horizontal2;
                            i16 = i14;
                            vertical4 = vertical;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical;
                            }
                            if (i18 != 0) {
                                top2 = Alignment.INSTANCE.getTop();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                top2 = vertical2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            horizontal3 = start;
                            vertical4 = top;
                            vertical3 = top2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical3 = vertical2;
                            modifier3 = modifier2;
                            horizontal3 = horizontal2;
                            i16 = i14;
                            vertical4 = vertical;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical;
                            }
                            if (i18 != 0) {
                                top2 = Alignment.INSTANCE.getTop();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                top2 = vertical2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            horizontal3 = start;
                            vertical4 = top;
                            vertical3 = top2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                vertical3 = vertical2;
                modifier3 = modifier2;
                horizontal3 = horizontal2;
                i16 = i14;
                vertical4 = vertical;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                    i18 = i8;
                } else {
                    i18 = i8;
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical;
                }
                if (i18 != 0) {
                    top2 = Alignment.INSTANCE.getTop();
                    i19 = i10;
                } else {
                    i19 = i10;
                    top2 = vertical2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                horizontal3 = start;
                vertical4 = top;
                vertical3 = top2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        horizontal2 = horizontal;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 384) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical3 = vertical2;
                            modifier3 = modifier2;
                            horizontal3 = horizontal2;
                            i16 = i14;
                            vertical4 = vertical;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                start = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical;
                            }
                            if (i18 != 0) {
                                top2 = Alignment.INSTANCE.getTop();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                top2 = vertical2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            horizontal3 = start;
                            vertical4 = top;
                            vertical3 = top2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                vertical3 = vertical2;
                modifier3 = modifier2;
                horizontal3 = horizontal2;
                i16 = i14;
                vertical4 = vertical;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                    i18 = i8;
                } else {
                    i18 = i8;
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical;
                }
                if (i18 != 0) {
                    top2 = Alignment.INSTANCE.getTop();
                    i19 = i10;
                } else {
                    i19 = i10;
                    top2 = vertical2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                horizontal3 = start;
                vertical4 = top;
                vertical3 = top2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 3072) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        vertical3 = vertical2;
                        modifier3 = modifier2;
                        horizontal3 = horizontal2;
                        i16 = i14;
                        vertical4 = vertical;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            start = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical;
                        }
                        if (i18 != 0) {
                            top2 = Alignment.INSTANCE.getTop();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            top2 = vertical2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        horizontal3 = start;
                        vertical4 = top;
                        vertical3 = top2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                vertical3 = vertical2;
                modifier3 = modifier2;
                horizontal3 = horizontal2;
                i16 = i14;
                vertical4 = vertical;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                    i18 = i8;
                } else {
                    i18 = i8;
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical;
                }
                if (i18 != 0) {
                    top2 = Alignment.INSTANCE.getTop();
                    i19 = i10;
                } else {
                    i19 = i10;
                    top2 = vertical2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                horizontal3 = start;
                vertical4 = top;
                vertical3 = top2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((i3 & 24576) == 0) {
                i11 = i;
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i5 |= i12;
            }
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    vertical3 = vertical2;
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                    i16 = i14;
                    vertical4 = vertical;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        start = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical;
                    }
                    if (i18 != 0) {
                        top2 = Alignment.INSTANCE.getTop();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        top2 = vertical2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    horizontal3 = start;
                    vertical4 = top;
                    vertical3 = top2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                vertical3 = vertical2;
                modifier3 = modifier2;
                horizontal3 = horizontal2;
                i16 = i14;
                vertical4 = vertical;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                    i18 = i8;
                } else {
                    i18 = i8;
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical;
                }
                if (i18 != 0) {
                    top2 = Alignment.INSTANCE.getTop();
                    i19 = i10;
                } else {
                    i19 = i10;
                    top2 = vertical2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                horizontal3 = start;
                vertical4 = top;
                vertical3 = top2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        i11 = i;
        i13 = i4 & 32;
        if (i13 != 0) {
            if ((196608 & i3) == 0) {
                i14 = i2;
                if (composerStartRestartGroup.changed(i14)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i5 |= i15;
            }
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                vertical3 = vertical2;
                modifier3 = modifier2;
                horizontal3 = horizontal2;
                i16 = i14;
                vertical4 = vertical;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                    i18 = i8;
                } else {
                    i18 = i8;
                    start = horizontal2;
                }
                if (i6 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical;
                }
                if (i18 != 0) {
                    top2 = Alignment.INSTANCE.getTop();
                    i19 = i10;
                } else {
                    i19 = i10;
                    top2 = vertical2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                }
                composer2 = composerStartRestartGroup;
                FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                horizontal3 = start;
                vertical4 = top;
                vertical3 = top2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i14 = i2;
        if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i21 = 1048576;
            } else {
                i21 = 524288;
            }
            i5 |= i21;
        }
        if ((i5 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            vertical3 = vertical2;
            modifier3 = modifier2;
            horizontal3 = horizontal2;
            i16 = i14;
            vertical4 = vertical;
        } else {
            if (i22 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i23 != 0) {
                start = Arrangement.INSTANCE.getStart();
                i18 = i8;
            } else {
                i18 = i8;
                start = horizontal2;
            }
            if (i6 != 0) {
                top = Arrangement.INSTANCE.getTop();
            } else {
                top = vertical;
            }
            if (i18 != 0) {
                top2 = Alignment.INSTANCE.getTop();
                i19 = i10;
            } else {
                i19 = i10;
                top2 = vertical2;
            }
            if (i19 != 0) {
                i11 = Integer.MAX_VALUE;
            }
            if (i13 != 0) {
                i20 = Integer.MAX_VALUE;
            } else {
                i20 = i14;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
            }
            composer2 = composerStartRestartGroup;
            FlowRow(modifier4, start, top, top2, i11, i20, FlowRowOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            horizontal3 = start;
            vertical4 = top;
            vertical3 = top2;
            i16 = i20;
        }
        i17 = i11;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FlowLayoutKt.FlowRow$lambda$3(modifier3, horizontal3, vertical4, vertical3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x013b  */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:109:0x0144  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:116:0x016b  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:142:0x0209  */
    /* JADX WARN: Code duplicated, block: B:144:0x0211  */
    /* JADX WARN: Code duplicated, block: B:147:0x0250  */
    /* JADX WARN: Code duplicated, block: B:150:0x025c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0260  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:156:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:97:0x011c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0128  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        int i7;
        int i8;
        Alignment.Horizontal start;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z;
        final Modifier modifier2;
        final Arrangement.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        Composer composer2;
        final int i17;
        final int i18;
        final FlowColumnOverflow flowColumnOverflow2;
        final Alignment.Horizontal horizontal4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Arrangement.Vertical top;
        int i19;
        Arrangement.Horizontal start2;
        int i20;
        int i21;
        FlowColumnOverflow clip;
        int i22;
        boolean z2;
        Object objRememberedValue;
        FlowLayoutOverflowState flowLayoutOverflowState;
        MultiContentMeasurePolicy multiContentMeasurePolicyColumnMeasurementMultiContentHelper;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        Object obj;
        boolean zChanged;
        Object objRememberedValue3;
        Function0<ComposeUiNode> constructor;
        int i23;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1944405121);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)214@9466L53,216@9552L234,225@9840L294,231@10139L75:FlowLayout.kt#2w3rfo");
        int i24 = i4 & 1;
        if (i24 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i25 = i4 & 2;
        if (i25 == 0) {
            if ((i3 & 48) == 0) {
                vertical2 = vertical;
                i5 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 3072) == 0) {
                        start = horizontal2;
                        if (composerStartRestartGroup.changed(start)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((i3 & 24576) == 0) {
                            i11 = i;
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 16384;
                            } else {
                                i12 = 8192;
                            }
                            i5 |= i12;
                        }
                        i13 = i4 & 32;
                        if (i13 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i2)) {
                                i14 = 131072;
                            } else {
                                i14 = 65536;
                            }
                            i5 |= i14;
                        }
                        i15 = i4 & 64;
                        if (i15 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                                i16 = 1048576;
                            } else {
                                i16 = 524288;
                            }
                            i5 |= i16;
                        }
                        if ((i3 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i23 = 8388608;
                            } else {
                                i23 = 4194304;
                            }
                            i5 |= i23;
                        }
                        if ((i5 & 4793491) != 4793490) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            horizontal3 = horizontal;
                            vertical3 = vertical2;
                            composer2 = composerStartRestartGroup;
                            i17 = i11;
                            i18 = i2;
                            flowColumnOverflow2 = flowColumnOverflow;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i25 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start2 = Arrangement.INSTANCE.getStart();
                                i19 = i8;
                            } else {
                                i19 = i8;
                                start2 = horizontal;
                            }
                            if (i19 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            }
                            if (i10 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i11;
                            }
                            if (i13 != 0) {
                                i21 = Integer.MAX_VALUE;
                            } else {
                                i21 = i2;
                            }
                            if (i15 != 0) {
                                clip = FlowColumnOverflow.INSTANCE.getClip();
                            } else {
                                clip = flowColumnOverflow;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                            i22 = 3670016 & i5;
                            if (i22 == 1048576) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                            if (i22 == 1048576) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if ((29360128 & i5) == 8388608) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            boolean z7 = z3 | z4;
                            if ((i5 & 458752) == 131072) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = z7 | z5;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                obj = objRememberedValue2;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }));
                                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                composerStartRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            }
                            obj = objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Modifier modifier3 = companion;
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
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            horizontal3 = start2;
                            i17 = i20;
                            i18 = i21;
                            modifier2 = modifier3;
                            composer2 = composerStartRestartGroup;
                            flowColumnOverflow2 = clip;
                            vertical3 = top;
                        }
                        horizontal4 = start;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                        }
                    }
                    i5 |= 24576;
                    i11 = i;
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        horizontal3 = horizontal;
                        vertical3 = vertical2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowColumnOverflow2 = flowColumnOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start2 = Arrangement.INSTANCE.getStart();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            start2 = horizontal;
                        }
                        if (i19 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowColumnOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z8 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z8 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList2);
                            composerStartRestartGroup.updateRememberedValue(arrayList2);
                            obj = arrayList2;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList3);
                            composerStartRestartGroup.updateRememberedValue(arrayList3);
                            obj = arrayList3;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts2 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier4 = companion;
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts2.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal3 = start2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier4;
                        composer2 = composerStartRestartGroup;
                        flowColumnOverflow2 = clip;
                        vertical3 = top;
                    }
                    horizontal4 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 3072;
                start = horizontal2;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        horizontal3 = horizontal;
                        vertical3 = vertical2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowColumnOverflow2 = flowColumnOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start2 = Arrangement.INSTANCE.getStart();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            start2 = horizontal;
                        }
                        if (i19 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowColumnOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z9 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z9 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList4);
                            composerStartRestartGroup.updateRememberedValue(arrayList4);
                            obj = arrayList4;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList5);
                            composerStartRestartGroup.updateRememberedValue(arrayList5);
                            obj = arrayList5;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts3 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier5 = companion;
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
                        Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts3.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal3 = start2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier5;
                        composer2 = composerStartRestartGroup;
                        flowColumnOverflow2 = clip;
                        vertical3 = top;
                    }
                    horizontal4 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z10 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z10 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList6);
                        composerStartRestartGroup.updateRememberedValue(arrayList6);
                        obj = arrayList6;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList7 = new ArrayList();
                        arrayList7.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList7);
                        composerStartRestartGroup.updateRememberedValue(arrayList7);
                        obj = arrayList7;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts4 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier6 = companion;
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
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts4.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier6;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    start = horizontal2;
                    if (composerStartRestartGroup.changed(start)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        horizontal3 = horizontal;
                        vertical3 = vertical2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowColumnOverflow2 = flowColumnOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start2 = Arrangement.INSTANCE.getStart();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            start2 = horizontal;
                        }
                        if (i19 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowColumnOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z11 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z11 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList8 = new ArrayList();
                            arrayList8.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList8);
                            composerStartRestartGroup.updateRememberedValue(arrayList8);
                            obj = arrayList8;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList9 = new ArrayList();
                            arrayList9.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList9);
                            composerStartRestartGroup.updateRememberedValue(arrayList9);
                            obj = arrayList9;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts5 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy5 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier7 = companion;
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
                        Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts5.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal3 = start2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier7;
                        composer2 = composerStartRestartGroup;
                        flowColumnOverflow2 = clip;
                        vertical3 = top;
                    }
                    horizontal4 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z12 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z12 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList10 = new ArrayList();
                        arrayList10.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList10);
                        composerStartRestartGroup.updateRememberedValue(arrayList10);
                        obj = arrayList10;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11 = new ArrayList();
                        arrayList11.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList11);
                        composerStartRestartGroup.updateRememberedValue(arrayList11);
                        obj = arrayList11;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts6 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier8 = companion;
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts6.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier8;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            start = horizontal2;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z13 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z13 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList12 = new ArrayList();
                        arrayList12.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList12);
                        composerStartRestartGroup.updateRememberedValue(arrayList12);
                        obj = arrayList12;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList13 = new ArrayList();
                        arrayList13.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList13);
                        composerStartRestartGroup.updateRememberedValue(arrayList13);
                        obj = arrayList13;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts7 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier9 = companion;
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
                    Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts7.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier9;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                horizontal3 = horizontal;
                vertical3 = vertical2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowColumnOverflow2 = flowColumnOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i6 != 0) {
                    start2 = Arrangement.INSTANCE.getStart();
                    i19 = i8;
                } else {
                    i19 = i8;
                    start2 = horizontal;
                }
                if (i19 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowColumnOverflow.INSTANCE.getClip();
                } else {
                    clip = flowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z14 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z14 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList14 = new ArrayList();
                    arrayList14.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList14);
                    composerStartRestartGroup.updateRememberedValue(arrayList14);
                    obj = arrayList14;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList15 = new ArrayList();
                    arrayList15.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList15);
                    composerStartRestartGroup.updateRememberedValue(arrayList15);
                    obj = arrayList15;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts8 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier10 = companion;
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
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts8.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = start2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier10;
                composer2 = composerStartRestartGroup;
                flowColumnOverflow2 = clip;
                vertical3 = top;
            }
            horizontal4 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        vertical2 = vertical;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 384) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    start = horizontal2;
                    if (composerStartRestartGroup.changed(start)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i5 |= i14;
                    }
                    i15 = i4 & 64;
                    if (i15 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i5 |= i16;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                        i5 |= i23;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        horizontal3 = horizontal;
                        vertical3 = vertical2;
                        composer2 = composerStartRestartGroup;
                        i17 = i11;
                        i18 = i2;
                        flowColumnOverflow2 = flowColumnOverflow;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i25 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start2 = Arrangement.INSTANCE.getStart();
                            i19 = i8;
                        } else {
                            i19 = i8;
                            start2 = horizontal;
                        }
                        if (i19 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        }
                        if (i10 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i11;
                        }
                        if (i13 != 0) {
                            i21 = Integer.MAX_VALUE;
                        } else {
                            i21 = i2;
                        }
                        if (i15 != 0) {
                            clip = FlowColumnOverflow.INSTANCE.getClip();
                        } else {
                            clip = flowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                        i22 = 3670016 & i5;
                        if (i22 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                        if (i22 == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if ((29360128 & i5) == 8388608) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z15 = z3 | z4;
                        if ((i5 & 458752) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z15 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            obj = objRememberedValue2;
                            ArrayList arrayList16 = new ArrayList();
                            arrayList16.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList16);
                            composerStartRestartGroup.updateRememberedValue(arrayList16);
                            obj = arrayList16;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList17 = new ArrayList();
                            arrayList17.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }));
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList17);
                            composerStartRestartGroup.updateRememberedValue(arrayList17);
                            obj = arrayList17;
                        }
                        obj = objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts9 = LayoutKt.combineAsVirtualLayouts((List) obj);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy9 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier11 = companion;
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
                        Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts9.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal3 = start2;
                        i17 = i20;
                        i18 = i21;
                        modifier2 = modifier11;
                        composer2 = composerStartRestartGroup;
                        flowColumnOverflow2 = clip;
                        vertical3 = top;
                    }
                    horizontal4 = start;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z16 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z16 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList18 = new ArrayList();
                        arrayList18.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList18);
                        composerStartRestartGroup.updateRememberedValue(arrayList18);
                        obj = arrayList18;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList19 = new ArrayList();
                        arrayList19.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList19);
                        composerStartRestartGroup.updateRememberedValue(arrayList19);
                        obj = arrayList19;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts10 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy10 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier12 = companion;
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
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts10.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier12;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            start = horizontal2;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z17 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z17 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList110 = new ArrayList();
                        arrayList110.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList110);
                        composerStartRestartGroup.updateRememberedValue(arrayList110);
                        obj = arrayList110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList111 = new ArrayList();
                        arrayList111.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList111);
                        composerStartRestartGroup.updateRememberedValue(arrayList111);
                        obj = arrayList111;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts11 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy11 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier13 = companion;
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
                    Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts11.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier13;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                horizontal3 = horizontal;
                vertical3 = vertical2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowColumnOverflow2 = flowColumnOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i6 != 0) {
                    start2 = Arrangement.INSTANCE.getStart();
                    i19 = i8;
                } else {
                    i19 = i8;
                    start2 = horizontal;
                }
                if (i19 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowColumnOverflow.INSTANCE.getClip();
                } else {
                    clip = flowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z18 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z18 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList112 = new ArrayList();
                    arrayList112.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList112);
                    composerStartRestartGroup.updateRememberedValue(arrayList112);
                    obj = arrayList112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList113 = new ArrayList();
                    arrayList113.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList113);
                    composerStartRestartGroup.updateRememberedValue(arrayList113);
                    obj = arrayList113;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts12 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy12 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier14 = companion;
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
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts12.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = start2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier14;
                composer2 = composerStartRestartGroup;
                flowColumnOverflow2 = clip;
                vertical3 = top;
            }
            horizontal4 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 3072) == 0) {
                start = horizontal2;
                if (composerStartRestartGroup.changed(start)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i5 |= i14;
                }
                i15 = i4 & 64;
                if (i15 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i5 |= i16;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                    i5 |= i23;
                }
                if ((i5 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    horizontal3 = horizontal;
                    vertical3 = vertical2;
                    composer2 = composerStartRestartGroup;
                    i17 = i11;
                    i18 = i2;
                    flowColumnOverflow2 = flowColumnOverflow;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i25 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start2 = Arrangement.INSTANCE.getStart();
                        i19 = i8;
                    } else {
                        i19 = i8;
                        start2 = horizontal;
                    }
                    if (i19 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if (i10 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i11;
                    }
                    if (i13 != 0) {
                        i21 = Integer.MAX_VALUE;
                    } else {
                        i21 = i2;
                    }
                    if (i15 != 0) {
                        clip = FlowColumnOverflow.INSTANCE.getClip();
                    } else {
                        clip = flowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                    i22 = 3670016 & i5;
                    if (i22 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                    if (i22 == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((29360128 & i5) == 8388608) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z19 = z3 | z4;
                    if ((i5 & 458752) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z19 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        obj = objRememberedValue2;
                        ArrayList arrayList114 = new ArrayList();
                        arrayList114.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList114);
                        composerStartRestartGroup.updateRememberedValue(arrayList114);
                        obj = arrayList114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList115 = new ArrayList();
                        arrayList115.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList115);
                        composerStartRestartGroup.updateRememberedValue(arrayList115);
                        obj = arrayList115;
                    }
                    obj = objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts13 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy13 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier15 = companion;
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
                    Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts13.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = start2;
                    i17 = i20;
                    i18 = i21;
                    modifier2 = modifier15;
                    composer2 = composerStartRestartGroup;
                    flowColumnOverflow2 = clip;
                    vertical3 = top;
                }
                horizontal4 = start;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                horizontal3 = horizontal;
                vertical3 = vertical2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowColumnOverflow2 = flowColumnOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i6 != 0) {
                    start2 = Arrangement.INSTANCE.getStart();
                    i19 = i8;
                } else {
                    i19 = i8;
                    start2 = horizontal;
                }
                if (i19 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowColumnOverflow.INSTANCE.getClip();
                } else {
                    clip = flowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z110 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z110 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList116 = new ArrayList();
                    arrayList116.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList116);
                    composerStartRestartGroup.updateRememberedValue(arrayList116);
                    obj = arrayList116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList117 = new ArrayList();
                    arrayList117.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList117);
                    composerStartRestartGroup.updateRememberedValue(arrayList117);
                    obj = arrayList117;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts14 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy14 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier16 = companion;
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
                Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts14.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = start2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier16;
                composer2 = composerStartRestartGroup;
                flowColumnOverflow2 = clip;
                vertical3 = top;
            }
            horizontal4 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        start = horizontal2;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((i3 & 24576) == 0) {
                i11 = i;
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i5 |= i12;
            }
            i13 = i4 & 32;
            if (i13 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i5 |= i14;
            }
            i15 = i4 & 64;
            if (i15 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i5 |= i16;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
                i5 |= i23;
            }
            if ((i5 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                horizontal3 = horizontal;
                vertical3 = vertical2;
                composer2 = composerStartRestartGroup;
                i17 = i11;
                i18 = i2;
                flowColumnOverflow2 = flowColumnOverflow;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i25 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i6 != 0) {
                    start2 = Arrangement.INSTANCE.getStart();
                    i19 = i8;
                } else {
                    i19 = i8;
                    start2 = horizontal;
                }
                if (i19 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if (i10 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i11;
                }
                if (i13 != 0) {
                    i21 = Integer.MAX_VALUE;
                } else {
                    i21 = i2;
                }
                if (i15 != 0) {
                    clip = FlowColumnOverflow.INSTANCE.getClip();
                } else {
                    clip = flowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
                i22 = 3670016 & i5;
                if (i22 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
                if (i22 == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((29360128 & i5) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z111 = z3 | z4;
                if ((i5 & 458752) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z111 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    obj = objRememberedValue2;
                    ArrayList arrayList118 = new ArrayList();
                    arrayList118.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList118);
                    composerStartRestartGroup.updateRememberedValue(arrayList118);
                    obj = arrayList118;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList119 = new ArrayList();
                    arrayList119.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList119);
                    composerStartRestartGroup.updateRememberedValue(arrayList119);
                    obj = arrayList119;
                }
                obj = objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts15 = LayoutKt.combineAsVirtualLayouts((List) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy15 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier17 = companion;
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
                Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts15.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = start2;
                i17 = i20;
                i18 = i21;
                modifier2 = modifier17;
                composer2 = composerStartRestartGroup;
                flowColumnOverflow2 = clip;
                vertical3 = top;
            }
            horizontal4 = start;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        i11 = i;
        i13 = i4 & 32;
        if (i13 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i5 |= i14;
        }
        i15 = i4 & 64;
        if (i15 != 0) {
            i5 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(flowColumnOverflow)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i5 |= i16;
        }
        if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i23 = 8388608;
            } else {
                i23 = 4194304;
            }
            i5 |= i23;
        }
        if ((i5 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            horizontal3 = horizontal;
            vertical3 = vertical2;
            composer2 = composerStartRestartGroup;
            i17 = i11;
            i18 = i2;
            flowColumnOverflow2 = flowColumnOverflow;
        } else {
            if (i24 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i25 != 0) {
                top = Arrangement.INSTANCE.getTop();
            } else {
                top = vertical2;
            }
            if (i6 != 0) {
                start2 = Arrangement.INSTANCE.getStart();
                i19 = i8;
            } else {
                i19 = i8;
                start2 = horizontal;
            }
            if (i19 != 0) {
                start = Alignment.INSTANCE.getStart();
            }
            if (i10 != 0) {
                i20 = Integer.MAX_VALUE;
            } else {
                i20 = i11;
            }
            if (i13 != 0) {
                i21 = Integer.MAX_VALUE;
            } else {
                i21 = i2;
            }
            if (i15 != 0) {
                clip = FlowColumnOverflow.INSTANCE.getClip();
            } else {
                clip = flowColumnOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262532140, "CC(remember):FlowLayout.kt#9igjgp");
            i22 = 3670016 & i5;
            if (i22 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = clip.createOverflowState$foundation_layout();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start2, start, i20, i21, flowLayoutOverflowState, composerStartRestartGroup, (i5 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -262519931, "CC(remember):FlowLayout.kt#9igjgp");
            if (i22 == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((29360128 & i5) == 8388608) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z112 = z3 | z4;
            if ((i5 & 458752) == 131072) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z112 | z5;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                obj = objRememberedValue2;
                ArrayList arrayList1110 = new ArrayList();
                arrayList1110.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList1110);
                composerStartRestartGroup.updateRememberedValue(arrayList1110);
                obj = arrayList1110;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList1111 = new ArrayList();
                arrayList1111.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FlowLayoutKt.FlowColumn$lambda$1$0(function3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList1111);
                composerStartRestartGroup.updateRememberedValue(arrayList1111);
                obj = arrayList1111;
            }
            obj = objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts16 = LayoutKt.combineAsVirtualLayouts((List) obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 292526026, "CC(remember):Layout.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MeasurePolicy measurePolicy16 = (MeasurePolicy) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier18 = companion;
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
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts16.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontal3 = start2;
            i17 = i20;
            i18 = i21;
            modifier2 = modifier18;
            composer2 = composerStartRestartGroup;
            flowColumnOverflow2 = clip;
            vertical3 = top;
        }
        horizontal4 = start;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FlowLayoutKt.FlowColumn$lambda$2(modifier2, vertical3, horizontal3, horizontal4, i17, i18, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C227@10017L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1720407857, i, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:227)");
            }
            function3.invoke(FlowColumnScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0169  */
    /* JADX WARN: Code duplicated, block: B:106:0x0172  */
    /* JADX WARN: Code duplicated, block: B:109:0x0185  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0102  */
    /* JADX WARN: Code duplicated, block: B:89:0x010a  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x0127  */
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Arrangement.Vertical vertical2;
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
        boolean z;
        Composer composer2;
        final Alignment.Horizontal horizontal3;
        final Modifier modifier3;
        final Arrangement.Vertical vertical3;
        final int i16;
        final Arrangement.Horizontal horizontal4;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i18;
        Arrangement.Vertical top;
        Arrangement.Horizontal start;
        int i19;
        Alignment.Horizontal start2;
        int i20;
        int i21;
        Composer composerStartRestartGroup = composer.startRestartGroup(1371845627);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,content)271@11939L226:FlowLayout.kt#2w3rfo");
        int i22 = i4 & 1;
        if (i22 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        int i23 = i4 & 2;
        if (i23 == 0) {
            if ((i3 & 48) == 0) {
                vertical2 = vertical;
                i5 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 3072) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((i3 & 24576) == 0) {
                            i11 = i;
                            if (composerStartRestartGroup.changed(i11)) {
                                i12 = 16384;
                            } else {
                                i12 = 8192;
                            }
                            i5 |= i12;
                        }
                        i13 = i4 & 32;
                        if (i13 != 0) {
                            if ((196608 & i3) == 0) {
                                i14 = i2;
                                if (composerStartRestartGroup.changed(i14)) {
                                    i15 = 131072;
                                } else {
                                    i15 = 65536;
                                }
                                i5 |= i15;
                            }
                            if ((i3 & 1572864) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i21 = 1048576;
                                } else {
                                    i21 = 524288;
                                }
                                i5 |= i21;
                            }
                            if ((i5 & 599187) != 599186) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                horizontal3 = horizontal2;
                                modifier3 = modifier2;
                                vertical3 = vertical2;
                                i16 = i14;
                                horizontal4 = horizontal;
                            } else {
                                if (i22 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i23 != 0) {
                                    top = Arrangement.INSTANCE.getTop();
                                    i18 = i8;
                                } else {
                                    i18 = i8;
                                    top = vertical2;
                                }
                                if (i6 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                } else {
                                    start = horizontal;
                                }
                                if (i18 != 0) {
                                    start2 = Alignment.INSTANCE.getStart();
                                    i19 = i10;
                                } else {
                                    i19 = i10;
                                    start2 = horizontal2;
                                }
                                if (i19 != 0) {
                                    i11 = Integer.MAX_VALUE;
                                }
                                if (i13 != 0) {
                                    i20 = Integer.MAX_VALUE;
                                } else {
                                    i20 = i14;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                                }
                                composer2 = composerStartRestartGroup;
                                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                vertical3 = top;
                                horizontal4 = start;
                                horizontal3 = start2;
                                i16 = i20;
                            }
                            i17 = i11;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i14 = i2;
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal2;
                            modifier3 = modifier2;
                            vertical3 = vertical2;
                            i16 = i14;
                            horizontal4 = horizontal;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal;
                            }
                            if (i18 != 0) {
                                start2 = Alignment.INSTANCE.getStart();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                start2 = horizontal2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            vertical3 = top;
                            horizontal4 = start;
                            horizontal3 = start2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= 24576;
                    i11 = i;
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal2;
                            modifier3 = modifier2;
                            vertical3 = vertical2;
                            i16 = i14;
                            horizontal4 = horizontal;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal;
                            }
                            if (i18 != 0) {
                                start2 = Alignment.INSTANCE.getStart();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                start2 = horizontal2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            vertical3 = top;
                            horizontal4 = start;
                            horizontal3 = start2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 3072;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal2;
                            modifier3 = modifier2;
                            vertical3 = vertical2;
                            i16 = i14;
                            horizontal4 = horizontal;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal;
                            }
                            if (i18 != 0) {
                                start2 = Alignment.INSTANCE.getStart();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                start2 = horizontal2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            vertical3 = top;
                            horizontal4 = start;
                            horizontal3 = start2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal2;
                            modifier3 = modifier2;
                            vertical3 = vertical2;
                            i16 = i14;
                            horizontal4 = horizontal;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal;
                            }
                            if (i18 != 0) {
                                start2 = Alignment.INSTANCE.getStart();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                start2 = horizontal2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            vertical3 = top;
                            horizontal4 = start;
                            horizontal3 = start2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                horizontal3 = horizontal2;
                modifier3 = modifier2;
                vertical3 = vertical2;
                i16 = i14;
                horizontal4 = horizontal;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                    i18 = i8;
                } else {
                    i18 = i8;
                    top = vertical2;
                }
                if (i6 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal;
                }
                if (i18 != 0) {
                    start2 = Alignment.INSTANCE.getStart();
                    i19 = i10;
                } else {
                    i19 = i10;
                    start2 = horizontal2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                }
                composer2 = composerStartRestartGroup;
                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                vertical3 = top;
                horizontal4 = start;
                horizontal3 = start2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        vertical2 = vertical;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 384) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        i11 = i;
                        if (composerStartRestartGroup.changed(i11)) {
                            i12 = 16384;
                        } else {
                            i12 = 8192;
                        }
                        i5 |= i12;
                    }
                    i13 = i4 & 32;
                    if (i13 != 0) {
                        if ((196608 & i3) == 0) {
                            i14 = i2;
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i21 = 1048576;
                            } else {
                                i21 = 524288;
                            }
                            i5 |= i21;
                        }
                        if ((i5 & 599187) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal2;
                            modifier3 = modifier2;
                            vertical3 = vertical2;
                            i16 = i14;
                            horizontal4 = horizontal;
                        } else {
                            if (i22 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i23 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                                i18 = i8;
                            } else {
                                i18 = i8;
                                top = vertical2;
                            }
                            if (i6 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal;
                            }
                            if (i18 != 0) {
                                start2 = Alignment.INSTANCE.getStart();
                                i19 = i10;
                            } else {
                                i19 = i10;
                                start2 = horizontal2;
                            }
                            if (i19 != 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                            if (i13 != 0) {
                                i20 = Integer.MAX_VALUE;
                            } else {
                                i20 = i14;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                            }
                            composer2 = composerStartRestartGroup;
                            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            vertical3 = top;
                            horizontal4 = start;
                            horizontal3 = start2;
                            i16 = i20;
                        }
                        i17 = i11;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i14 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                i11 = i;
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                horizontal3 = horizontal2;
                modifier3 = modifier2;
                vertical3 = vertical2;
                i16 = i14;
                horizontal4 = horizontal;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                    i18 = i8;
                } else {
                    i18 = i8;
                    top = vertical2;
                }
                if (i6 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal;
                }
                if (i18 != 0) {
                    start2 = Alignment.INSTANCE.getStart();
                    i19 = i10;
                } else {
                    i19 = i10;
                    start2 = horizontal2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                }
                composer2 = composerStartRestartGroup;
                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                vertical3 = top;
                horizontal4 = start;
                horizontal3 = start2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 3072) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    i11 = i;
                    if (composerStartRestartGroup.changed(i11)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i5 |= i12;
                }
                i13 = i4 & 32;
                if (i13 != 0) {
                    if ((196608 & i3) == 0) {
                        i14 = i2;
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i21 = 1048576;
                        } else {
                            i21 = 524288;
                        }
                        i5 |= i21;
                    }
                    if ((i5 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        horizontal3 = horizontal2;
                        modifier3 = modifier2;
                        vertical3 = vertical2;
                        i16 = i14;
                        horizontal4 = horizontal;
                    } else {
                        if (i22 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i23 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                            i18 = i8;
                        } else {
                            i18 = i8;
                            top = vertical2;
                        }
                        if (i6 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal;
                        }
                        if (i18 != 0) {
                            start2 = Alignment.INSTANCE.getStart();
                            i19 = i10;
                        } else {
                            i19 = i10;
                            start2 = horizontal2;
                        }
                        if (i19 != 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                        if (i13 != 0) {
                            i20 = Integer.MAX_VALUE;
                        } else {
                            i20 = i14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                        }
                        composer2 = composerStartRestartGroup;
                        FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        vertical3 = top;
                        horizontal4 = start;
                        horizontal3 = start2;
                        i16 = i20;
                    }
                    i17 = i11;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i14 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            i11 = i;
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                horizontal3 = horizontal2;
                modifier3 = modifier2;
                vertical3 = vertical2;
                i16 = i14;
                horizontal4 = horizontal;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                    i18 = i8;
                } else {
                    i18 = i8;
                    top = vertical2;
                }
                if (i6 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal;
                }
                if (i18 != 0) {
                    start2 = Alignment.INSTANCE.getStart();
                    i19 = i10;
                } else {
                    i19 = i10;
                    start2 = horizontal2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                }
                composer2 = composerStartRestartGroup;
                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                vertical3 = top;
                horizontal4 = start;
                horizontal3 = start2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((i3 & 24576) == 0) {
                i11 = i;
                if (composerStartRestartGroup.changed(i11)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i5 |= i12;
            }
            i13 = i4 & 32;
            if (i13 != 0) {
                if ((196608 & i3) == 0) {
                    i14 = i2;
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i5 |= i15;
                }
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i21 = 1048576;
                    } else {
                        i21 = 524288;
                    }
                    i5 |= i21;
                }
                if ((i5 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    horizontal3 = horizontal2;
                    modifier3 = modifier2;
                    vertical3 = vertical2;
                    i16 = i14;
                    horizontal4 = horizontal;
                } else {
                    if (i22 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i23 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                        i18 = i8;
                    } else {
                        i18 = i8;
                        top = vertical2;
                    }
                    if (i6 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal;
                    }
                    if (i18 != 0) {
                        start2 = Alignment.INSTANCE.getStart();
                        i19 = i10;
                    } else {
                        i19 = i10;
                        start2 = horizontal2;
                    }
                    if (i19 != 0) {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i13 != 0) {
                        i20 = Integer.MAX_VALUE;
                    } else {
                        i20 = i14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                    }
                    composer2 = composerStartRestartGroup;
                    FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    vertical3 = top;
                    horizontal4 = start;
                    horizontal3 = start2;
                    i16 = i20;
                }
                i17 = i11;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i14 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                horizontal3 = horizontal2;
                modifier3 = modifier2;
                vertical3 = vertical2;
                i16 = i14;
                horizontal4 = horizontal;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                    i18 = i8;
                } else {
                    i18 = i8;
                    top = vertical2;
                }
                if (i6 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal;
                }
                if (i18 != 0) {
                    start2 = Alignment.INSTANCE.getStart();
                    i19 = i10;
                } else {
                    i19 = i10;
                    start2 = horizontal2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                }
                composer2 = composerStartRestartGroup;
                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                vertical3 = top;
                horizontal4 = start;
                horizontal3 = start2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        i11 = i;
        i13 = i4 & 32;
        if (i13 != 0) {
            if ((196608 & i3) == 0) {
                i14 = i2;
                if (composerStartRestartGroup.changed(i14)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i5 |= i15;
            }
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i21 = 1048576;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            if ((i5 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                horizontal3 = horizontal2;
                modifier3 = modifier2;
                vertical3 = vertical2;
                i16 = i14;
                horizontal4 = horizontal;
            } else {
                if (i22 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i23 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                    i18 = i8;
                } else {
                    i18 = i8;
                    top = vertical2;
                }
                if (i6 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal;
                }
                if (i18 != 0) {
                    start2 = Alignment.INSTANCE.getStart();
                    i19 = i10;
                } else {
                    i19 = i10;
                    start2 = horizontal2;
                }
                if (i19 != 0) {
                    i11 = Integer.MAX_VALUE;
                }
                if (i13 != 0) {
                    i20 = Integer.MAX_VALUE;
                } else {
                    i20 = i14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                }
                composer2 = composerStartRestartGroup;
                FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                vertical3 = top;
                horizontal4 = start;
                horizontal3 = start2;
                i16 = i20;
            }
            i17 = i11;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i14 = i2;
        if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i21 = 1048576;
            } else {
                i21 = 524288;
            }
            i5 |= i21;
        }
        if ((i5 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            horizontal3 = horizontal2;
            modifier3 = modifier2;
            vertical3 = vertical2;
            i16 = i14;
            horizontal4 = horizontal;
        } else {
            if (i22 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i23 != 0) {
                top = Arrangement.INSTANCE.getTop();
                i18 = i8;
            } else {
                i18 = i8;
                top = vertical2;
            }
            if (i6 != 0) {
                start = Arrangement.INSTANCE.getStart();
            } else {
                start = horizontal;
            }
            if (i18 != 0) {
                start2 = Alignment.INSTANCE.getStart();
                i19 = i10;
            } else {
                i19 = i10;
                start2 = horizontal2;
            }
            if (i19 != 0) {
                i11 = Integer.MAX_VALUE;
            }
            if (i13 != 0) {
                i20 = Integer.MAX_VALUE;
            } else {
                i20 = i14;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
            }
            composer2 = composerStartRestartGroup;
            FlowColumn(modifier4, top, start, start2, i11, i20, FlowColumnOverflow.INSTANCE.getClip(), function3, composer2, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            vertical3 = top;
            horizontal4 = start;
            horizontal3 = start2;
            i16 = i20;
        }
        i17 = i11;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FlowLayoutKt.FlowColumn$lambda$3(modifier3, vertical3, horizontal4, horizontal3, i17, i16, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1479255111, "C(rowMeasurementHelper)N(horizontalArrangement,verticalArrangement,maxItemsInMainAxis)440@17697L893:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -70006556, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1154measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2010142641, "C(rowMeasurementMultiContentHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState)471@18969L708:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2010142641, i3, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 988216051, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.changed(vertical2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2013098357, "C(columnMeasurementHelper)N(verticalArrangement,horizontalArrangement,maxItemsInMainAxis)501@19939L850:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1852231075, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1154measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -308635847, "C(columnMeasurementMultiContentHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState)529@21138L715:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-308635847, i3, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -246294460, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.changed(horizontal2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function4, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int i6 = i4;
        int i7 = i5;
        if (list2.isEmpty()) {
            return 0;
        }
        int size = list2.size();
        int[] iArr = new int[size];
        int size2 = list2.size();
        int[] iArr2 = new int[size2];
        int size3 = list2.size();
        for (int i8 = 0; i8 < size3; i8++) {
            IntrinsicMeasurable intrinsicMeasurable = list2.get(i8);
            int iIntValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(i)).intValue();
            iArr[i8] = iIntValue;
            iArr2[i8] = function4.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(iIntValue)).intValue();
        }
        int i9 = Integer.MAX_VALUE;
        if (i7 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
            i9 = i6 * i7;
        }
        int i10 = 1;
        int iMin = Math.min(i9 - (((i9 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i9 < list2.size() || i7 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout() || flowLayoutOverflowState.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list2.size());
        int iSum = ArraysKt.sum(iArr) + ((list2.size() - 1) * i2);
        if (size2 != 0) {
            int iM331getFirstimpl = iArr2[0];
            int lastIndex = ArraysKt.getLastIndex(iArr2);
            if (1 <= lastIndex) {
                int i11 = 1;
                while (true) {
                    int i12 = iArr2[i11];
                    if (iM331getFirstimpl < i12) {
                        iM331getFirstimpl = i12;
                    }
                    if (i11 == lastIndex) {
                        break;
                    }
                    i11++;
                }
            }
            if (size != 0) {
                int i13 = iArr[0];
                int lastIndex2 = ArraysKt.getLastIndex(iArr);
                if (1 <= lastIndex2) {
                    while (true) {
                        int i14 = iArr[i10];
                        if (i13 < i14) {
                            i13 = i14;
                        }
                        if (i10 == lastIndex2) {
                            break;
                        }
                        i10++;
                    }
                }
                int i15 = i13;
                int i16 = iSum;
                while (i15 <= i16 && iM331getFirstimpl != i) {
                    int i17 = (i15 + i16) / 2;
                    long jIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i17, i2, i3, i6, i7, flowLayoutOverflowState);
                    iM331getFirstimpl = IntIntPair.m331getFirstimpl(jIntrinsicCrossAxisSize);
                    int iM332getSecondimpl = IntIntPair.m332getSecondimpl(jIntrinsicCrossAxisSize);
                    if (iM331getFirstimpl > i || iM332getSecondimpl < iMin) {
                        i15 = i17 + 1;
                        if (i15 > i16) {
                            return i15;
                        }
                    } else {
                        if (iM331getFirstimpl >= i) {
                            return i17;
                        }
                        i16 = i17 - 1;
                    }
                    list2 = list;
                    i6 = i4;
                    i7 = i5;
                    iSum = i17;
                }
                return iSum;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function4, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i6;
        if (list.isEmpty()) {
            return IntIntPair.m327constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1184constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int iIntValue = intrinsicMeasurable != null ? function4.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue)).intValue() : 0;
        int i7 = 0;
        int iMax = 0;
        if (flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m327constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m324boximpl(IntIntPair.m327constructorimpl(iIntValue2, iIntValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM1135ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m1135ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m327constructorimpl(intIntPairM1135ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m332getSecondimpl(intIntPairM1135ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i8 = i;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = iMax;
            if (i9 >= size) {
                i6 = i10;
                break;
            }
            int i14 = i8 - iIntValue2;
            int i15 = i9 + 1;
            iMax = Math.max(i13, iIntValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i15);
            int iIntValue3 = intrinsicMeasurable2 != null ? function4.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(i)).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(iIntValue3)).intValue() + i2 : 0;
            int i16 = i15 - i11;
            i6 = i15;
            int i17 = i12;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1126getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(i9 + 2 < list.size(), i16, IntIntPair.m327constructorimpl(i14, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m324boximpl(IntIntPair.m327constructorimpl(iIntValue4, iIntValue3)), i17, i7, iMax, false, false);
            if (wrapInfoM1126getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM332getSecondimpl = i7 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1126getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i17, iM332getSecondimpl, i14, i16);
                iIntValue4 -= i2;
                i12 = i17 + 1;
                if (wrapInfoM1126getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM332getSecondimpl += IntIntPair.m332getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i7 = iM332getSecondimpl;
                    break;
                }
                i8 = i;
                i11 = i6;
                i7 = iM332getSecondimpl;
                iMax = 0;
            } else {
                i8 = i14;
                i12 = i17;
            }
            iIntValue2 = iIntValue4;
            iIntValue = iIntValue3;
            i9 = i6;
            i10 = i9;
        }
        return IntIntPair.m327constructorimpl(i7 - i3, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$0$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$2$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (it instanceof ContextualFlowItemIterator) {
                Intrinsics.checkNotNull(flowLineInfo);
                return ((ContextualFlowItemIterator) it).getNext$foundation_layout(flowLineInfo);
            }
            return it.next();
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m1131measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j, Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        Measurable measurable2 = measurable;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable2)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable2);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
                function1.invoke(placeableMo8265measureBRTryo0);
                return IntIntPair.m327constructorimpl(flowLineMeasurePolicy.mainAxisSize(placeableMo8265measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(placeableMo8265measureBRTryo0));
            }
        }
        int iMainAxisMin = mainAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m327constructorimpl(iMainAxisMin, crossAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), iMainAxisMin));
    }

    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m1132placeHelperBmaY500(MeasureScope measureScope, long j, int i, int i2, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int iM9639getMaxHeightimpl;
        int i3;
        int i4;
        boolean zIsHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (zIsHorizontal) {
            int i5 = i2 + (measureScope.mo748roundToPx0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
            iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
            if (i5 < iM9641getMinHeightimpl) {
                i5 = iM9641getMinHeightimpl;
            }
            if (i5 <= iM9639getMaxHeightimpl) {
                iM9639getMaxHeightimpl = i5;
            }
            verticalArrangement.arrange(measureScope, iM9639getMaxHeightimpl, iArr, iArr2);
        } else {
            int i6 = i2 + (measureScope.mo748roundToPx0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM9641getMinHeightimpl2 = Constraints.m9641getMinHeightimpl(j);
            int iM9639getMaxHeightimpl2 = Constraints.m9639getMaxHeightimpl(j);
            if (i6 < iM9641getMinHeightimpl2) {
                i6 = iM9641getMinHeightimpl2;
            }
            int i7 = i6 > iM9639getMaxHeightimpl2 ? iM9639getMaxHeightimpl2 : i6;
            horizontalArrangement.arrange(measureScope, i7, iArr, measureScope.getLayoutDirection(), iArr2);
            iM9639getMaxHeightimpl = i7;
        }
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        if (i < iM9642getMinWidthimpl) {
            i = iM9642getMinWidthimpl;
        }
        if (i <= iM9640getMaxWidthimpl) {
            iM9640getMaxWidthimpl = i;
        }
        if (zIsHorizontal) {
            i4 = iM9640getMaxWidthimpl;
            i3 = iM9639getMaxHeightimpl;
        } else {
            i3 = iM9640getMaxWidthimpl;
            i4 = iM9639getMaxHeightimpl;
        }
        return MeasureScope.layout$default(measureScope, i4, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.placeHelper_BmaY500$lambda$2(mutableVector, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int iIntValue = function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i7 = i4 + 1;
            if (i7 - i5 == i3 || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iIntValue) - i2);
                i6 = 0;
                i5 = i4;
            } else {
                i6 += iIntValue;
            }
            i4 = i7;
        }
        return iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return IntIntPair.m327constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1184constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int i6 = intrinsicMeasurable != null ? iArr2[0] : 0;
        int i7 = intrinsicMeasurable != null ? iArr[0] : 0;
        int i8 = 0;
        if (flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m327constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m324boximpl(IntIntPair.m327constructorimpl(i7, i6)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM1135ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m1135ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m327constructorimpl(intIntPairM1135ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m332getSecondimpl(intIntPairM1135ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i9 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i10 < size) {
            int i15 = i9 - i7;
            int i16 = i10 + 1;
            int iMax = Math.max(i14, i6);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i16);
            int i17 = intrinsicMeasurable2 != null ? iArr2[i16] : 0;
            int i18 = intrinsicMeasurable2 != null ? iArr[i16] + i2 : 0;
            int i19 = i16 - i12;
            int i20 = i13;
            int i21 = i17;
            int i22 = i18;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1126getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(i10 + 2 < list.size(), i19, IntIntPair.m327constructorimpl(i15, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m324boximpl(IntIntPair.m327constructorimpl(i18, i17)), i20, i8, iMax, false, false);
            if (wrapInfoM1126getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM332getSecondimpl = i8 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1126getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i20, iM332getSecondimpl, i15, i19);
                int i23 = i22 - i2;
                i13 = i20 + 1;
                if (wrapInfoM1126getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM332getSecondimpl += IntIntPair.m332getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i8 = iM332getSecondimpl;
                    i11 = i16;
                    break;
                }
                i14 = 0;
                i8 = iM332getSecondimpl;
                i7 = i23;
                i12 = i16;
                i9 = i;
            } else {
                i9 = i15;
                i13 = i20;
                i14 = iMax;
                i7 = i22;
            }
            i10 = i16;
            i11 = i10;
            i6 = i21;
        }
        return IntIntPair.m327constructorimpl(i8 - i3, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m1130breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f, float f2, long j, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i3;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        MutableIntObjectMap mutableIntObjectMap;
        int i4;
        int i5;
        int i6;
        int i7;
        MutableIntObjectMap mutableIntObjectMap2;
        IntIntPair intIntPairM324boximpl;
        int i8;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i9;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        boolean z;
        int i10;
        int i11;
        FlowLayoutData flowLayoutData;
        MeasureScope measureScope2 = measureScope;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        int iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
        int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(j);
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope2.mo754toPx0680j_4(f));
        int iCeil2 = (int) Math.ceil(measureScope2.mo754toPx0680j_4(f2));
        long jM1184constructorimpl = OrientationIndependentConstraints.m1184constructorimpl(0, iM9640getMaxWidthimpl, 0, iM9639getMaxHeightimpl);
        long jM1199toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m1199toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m1188copyyUG9Ft0$default(jM1184constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope2.mo751toDpu2uoSUM(iM9640getMaxWidthimpl), measureScope2.mo751toDpu2uoSUM(iM9639getMaxHeightimpl), null) : null;
        Measurable measurableSafeNext = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
        IntIntPair intIntPairM324boximpl2 = measurableSafeNext != null ? IntIntPair.m324boximpl(m1131measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy, jM1199toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.breakDownItems_di9J0FM$lambda$0$0(objectRef, (Placeable) obj);
            }
        })) : null;
        Integer numValueOf = intIntPairM324boximpl2 != null ? Integer.valueOf(IntIntPair.m331getFirstimpl(intIntPairM324boximpl2.getPackedValue())) : null;
        Integer numValueOf2 = intIntPairM324boximpl2 != null ? Integer.valueOf(IntIntPair.m332getSecondimpl(intIntPairM324boximpl2.getPackedValue())) : null;
        Integer numValueOf3 = numValueOf;
        Measurable measurable = measurableSafeNext;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j, i2, iCeil, iCeil2, null);
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1126getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(it2.hasNext(), 0, IntIntPair.m327constructorimpl(iM9640getMaxWidthimpl, iM9639getMaxHeightimpl), intIntPairM324boximpl2, 0, 0, 0, false, false);
        if (wrapInfoM1126getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1126getWrapInfoOpUlnko, intIntPairM324boximpl2 != null, -1, 0, iM9640getMaxWidthimpl, 0);
            i3 = iM9640getMaxWidthimpl;
        } else {
            i3 = iM9640getMaxWidthimpl;
            wrapEllipsisInfo = null;
        }
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i12 = i3;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoM1126getWrapInfoOpUlnko;
        int iMax = iM9642getMinWidthimpl;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z2 = false;
        int i16 = 0;
        int i17 = 0;
        MutableIntSet mutableIntSet = mutableIntSetMutableIntSetOf;
        int i18 = iM9639getMaxHeightimpl;
        Measurable measurableSafeNext2 = measurable;
        int i19 = 0;
        while (!wrapInfo.getIsLastItemInContainer() && measurableSafeNext2 != null) {
            Intrinsics.checkNotNull(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            Intrinsics.checkNotNull(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i20 = i3;
            int i21 = i15 + iIntValue;
            int iMax2 = Math.max(i14, numValueOf2.intValue());
            int i22 = i12 - iIntValue;
            int i23 = i13 + 1;
            int i24 = iMax;
            flowLayoutOverflowState.setItemShown$foundation_layout(i23);
            arrayList.add(measurableSafeNext2);
            mutableIntObjectMapMutableIntObjectMapOf.set(i13, objectRef.element);
            Object parentData = measurableSafeNext2.getParentData();
            RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) != null) {
                z2 = true;
            }
            int i25 = i23 - i19;
            boolean z3 = i25 < i;
            if (flowLineInfo != null) {
                int i26 = z3 ? i16 : i16 + 1;
                int i27 = z3 ? i25 : 0;
                if (z3) {
                    int i28 = i22 - iCeil;
                    z = z3;
                    i10 = i28 < 0 ? 0 : i28;
                } else {
                    z = z3;
                    i10 = i20;
                }
                float f3 = measureScope2.mo751toDpu2uoSUM(i10);
                if (z) {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i11 = i18;
                } else {
                    int i29 = (i18 - iMax2) - iCeil2;
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i11 = i29 < 0 ? 0 : i29;
                }
                flowLineInfo.m1143update4j6BHR0$foundation_layout(i26, i27, f3, measureScope2.mo751toDpu2uoSUM(i11));
                Unit unit = Unit.INSTANCE;
            } else {
                i25 = i25;
                mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
            }
            measurableSafeNext2 = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
            objectRef.element = null;
            IntIntPair intIntPairM324boximpl3 = measurableSafeNext2 != null ? IntIntPair.m324boximpl(m1131measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy, jM1199toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowLayoutKt.breakDownItems_di9J0FM$lambda$2$0(objectRef, (Placeable) obj);
                }
            })) : null;
            Integer numValueOf4 = intIntPairM324boximpl3 != null ? Integer.valueOf(IntIntPair.m331getFirstimpl(intIntPairM324boximpl3.getPackedValue()) + iCeil) : null;
            numValueOf2 = intIntPairM324boximpl3 != null ? Integer.valueOf(IntIntPair.m332getSecondimpl(intIntPairM324boximpl3.getPackedValue())) : null;
            boolean zHasNext = it2.hasNext();
            int i30 = i16;
            long jM327constructorimpl = IntIntPair.m327constructorimpl(i22, i18);
            if (intIntPairM324boximpl3 == null) {
                intIntPairM324boximpl = null;
            } else {
                Intrinsics.checkNotNull(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                Intrinsics.checkNotNull(numValueOf2);
                intIntPairM324boximpl = IntIntPair.m324boximpl(IntIntPair.m327constructorimpl(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM1126getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m1126getWrapInfoOpUlnko(zHasNext, i25, jM327constructorimpl, intIntPairM324boximpl, i30, i17, iMax2, false, false);
            if (wrapInfoM1126getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int iMin = Math.min(Math.max(i24, i21), i20);
                int i31 = i17 + iMax2;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM1126getWrapInfoOpUlnko2, intIntPairM324boximpl3 != null, i30, i31, i22, i25);
                mutableIntList2 = mutableIntList6;
                mutableIntList2.add(iMax2);
                MutableIntSet mutableIntSet2 = mutableIntSet;
                if (z2) {
                    mutableIntSet2.plusAssign(i30);
                }
                int i32 = (iM9639getMaxHeightimpl - i31) - iCeil2;
                mutableIntSet = mutableIntSet2;
                mutableIntList = mutableIntList5;
                mutableIntList.add(i23);
                i16 = i30 + 1;
                i17 = i31 + iCeil2;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                i20 = i20;
                i19 = i23;
                i21 = 0;
                z2 = false;
                i8 = 0;
                i9 = iMin;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                i18 = i32;
                i12 = i20;
            } else {
                i8 = iMax2;
                mutableIntList = mutableIntList5;
                mutableIntList2 = mutableIntList6;
                numValueOf3 = numValueOf4;
                i12 = i22;
                i16 = i30;
                i9 = i24;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            mutableIntList5 = mutableIntList;
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            mutableIntSet = mutableIntSet;
            iMax = i9;
            i13 = i23;
            mutableIntObjectMapMutableIntObjectMapOf = mutableIntObjectMap2;
            wrapInfo = wrapInfoM1126getWrapInfoOpUlnko2;
            it2 = it;
            mutableIntList4 = mutableIntList2;
            i15 = i21;
            i3 = i20;
            i14 = i8;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapMutableIntObjectMapOf;
        MutableIntList mutableIntList7 = mutableIntList4;
        MutableIntList mutableIntList8 = mutableIntList5;
        MutableIntSet mutableIntSet3 = mutableIntSet;
        if (wrapEllipsisInfo3 != null) {
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            MutableIntList mutableIntList9 = mutableIntList8;
            int i33 = mutableIntList9._size - 1;
            if (!wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                mutableIntList7.add(IntIntPair.m332getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                Boolean.valueOf(mutableIntList8.add(mutableIntList8.last() + 1));
            } else {
                int i34 = mutableIntList9._size - 1;
                mutableIntList7.set(i33, Math.max(mutableIntList7.get(i33), IntIntPair.m332getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList8.set(i34, mutableIntList8.last() + 1);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size = arrayList.size();
        ?? r4 = new Placeable[size];
        for (int i35 = 0; i35 < size; i35++) {
            r4[i35] = mutableIntObjectMap.get(i35);
        }
        MutableIntList mutableIntList10 = mutableIntList8;
        int[] iArr = new int[mutableIntList10._size];
        int[] iArr2 = new int[mutableIntList10._size];
        int[] iArr3 = mutableIntList10.content;
        int i36 = mutableIntList10._size;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        ?? r5 = r4;
        while (i38 < i36) {
            int i40 = iArr3[i38];
            int iM9639getMaxHeightimpl2 = mutableIntList7.get(i38);
            if (!mutableIntSet3.contains(i38)) {
                iM9639getMaxHeightimpl2 = Constraints.m9639getMaxHeightimpl(jM1184constructorimpl) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Constraints.m9639getMaxHeightimpl(jM1184constructorimpl) - i39;
            }
            int i41 = i36;
            MutableIntSet mutableIntSet4 = mutableIntSet3;
            int[] iArr4 = iArr;
            ?? r8 = r5;
            MutableIntList mutableIntList11 = mutableIntList7;
            MeasureResult measureResultMeasure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, iMax, Constraints.m9641getMinHeightimpl(jM1184constructorimpl), Constraints.m9640getMaxWidthimpl(jM1184constructorimpl), iM9639getMaxHeightimpl2, iCeil, measureScope2, arrayList, r8, i37, i40, iArr4, i38);
            if (flowLineMeasurePolicy.isHorizontal()) {
                i6 = measureResultMeasure.getWidth();
                i7 = measureResultMeasure.getHeight();
            } else {
                i6 = measureResultMeasure.getHeight();
                i7 = measureResultMeasure.getWidth();
            }
            iArr2[i38] = i7;
            i39 += i7;
            iMax = Math.max(iMax, i6);
            mutableVector.add(measureResultMeasure);
            i38++;
            r5 = r8;
            i37 = i40;
            iArr = iArr4;
            i36 = i41;
            mutableIntSet3 = mutableIntSet4;
            mutableIntList7 = mutableIntList11;
            measureScope2 = measureScope;
        }
        int[] iArr5 = iArr;
        if (mutableVector.getSize() == 0) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = iMax;
            i5 = i39;
        }
        return m1132placeHelperBmaY500(measureScope, j, i4, i5, iArr2, mutableVector, flowLineMeasurePolicy, iArr5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeHelper_BmaY500$lambda$2(MutableVector mutableVector, Placeable.PlacementScope placementScope) {
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            ((MeasureResult) objArr[i]).placeChildren();
        }
        return Unit.INSTANCE;
    }
}
