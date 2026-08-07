package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b \u0010!\u001a!\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010&\u001a7\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020)2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,\u001a\u008a\u0001\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b4\u00105\u001aq\u00106\u001a\u00020\u00012\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00162\u0006\u0010;\u001a\u00020$H\u0003¢\u0006\u0002\u0010<\u001a\u0014\u0010=\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000\u001a\u0014\u0010>\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000¨\u0006?"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "Landroidx/compose/material3/SheetState;", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;Landroidx/compose/runtime/Composer;I)V", "verticalScaleUp", "verticalScaleDown", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffoldLayout$lambda$1(Function2 function2, Function2 function3, Function2 function4, Function2 function5, Function0 function0, SheetState sheetState, int i, Composer composer, int i2) {
        BottomSheetScaffoldLayout(function2, function3, function4, function5, function0, sheetState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_sdMYb0k$lambda$1(Function3 function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2 function2, boolean z, Function2 function4, Function3 function5, long j3, long j4, Function3 function6, int i, int i2, int i3, Composer composer, int i4) {
        m2827BottomSheetScaffoldsdMYb0k(function3, modifier, bottomSheetScaffoldState, f, f2, shape, j, j2, f3, f4, function2, z, function4, function5, j3, j4, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$6(SheetState sheetState, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2 function2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2828StandardBottomSheetw7I5h1o(sheetState, f, f2, z, shape, j, j2, f3, f4, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberStandardBottomSheetState$lambda$0$0(SheetValue sheetValue) {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012a  */
    /* JADX WARN: Code duplicated, block: B:102:0x012d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0135  */
    /* JADX WARN: Code duplicated, block: B:107:0x013c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0140  */
    /* JADX WARN: Code duplicated, block: B:111:0x014a  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:117:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0161  */
    /* JADX WARN: Code duplicated, block: B:120:0x0165  */
    /* JADX WARN: Code duplicated, block: B:122:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0172  */
    /* JADX WARN: Code duplicated, block: B:125:0x0177  */
    /* JADX WARN: Code duplicated, block: B:128:0x0183  */
    /* JADX WARN: Code duplicated, block: B:129:0x0186  */
    /* JADX WARN: Code duplicated, block: B:131:0x018c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0194  */
    /* JADX WARN: Code duplicated, block: B:134:0x0197  */
    /* JADX WARN: Code duplicated, block: B:136:0x019c  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:153:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x01db  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:163:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:166:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:168:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:171:0x0204  */
    /* JADX WARN: Code duplicated, block: B:173:0x020a  */
    /* JADX WARN: Code duplicated, block: B:174:0x020d  */
    /* JADX WARN: Code duplicated, block: B:178:0x021c  */
    /* JADX WARN: Code duplicated, block: B:182:0x0229  */
    /* JADX WARN: Code duplicated, block: B:185:0x0232  */
    /* JADX WARN: Code duplicated, block: B:187:0x0242  */
    /* JADX WARN: Code duplicated, block: B:209:0x028e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x0290  */
    /* JADX WARN: Code duplicated, block: B:211:0x0295  */
    /* JADX WARN: Code duplicated, block: B:214:0x029b  */
    /* JADX WARN: Code duplicated, block: B:215:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:217:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:218:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:220:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:223:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:226:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:229:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:231:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:233:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:234:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:236:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:237:0x0302  */
    /* JADX WARN: Code duplicated, block: B:239:0x0306  */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:240:0x0309  */
    /* JADX WARN: Code duplicated, block: B:242:0x030d  */
    /* JADX WARN: Code duplicated, block: B:243:0x0310  */
    /* JADX WARN: Code duplicated, block: B:245:0x0314  */
    /* JADX WARN: Code duplicated, block: B:246:0x031b  */
    /* JADX WARN: Code duplicated, block: B:249:0x0321  */
    /* JADX WARN: Code duplicated, block: B:250:0x0334  */
    /* JADX WARN: Code duplicated, block: B:253:0x033c  */
    /* JADX WARN: Code duplicated, block: B:254:0x0347  */
    /* JADX WARN: Code duplicated, block: B:258:0x0358  */
    /* JADX WARN: Code duplicated, block: B:259:0x0363  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:262:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:265:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:266:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:269:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:271:0x0406  */
    /* JADX WARN: Code duplicated, block: B:274:0x048b  */
    /* JADX WARN: Code duplicated, block: B:276:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:279:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:281:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0100  */
    /* JADX WARN: Code duplicated, block: B:89:0x0106  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:92:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0119  */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0124  */
    /* JADX INFO: renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    public static final void m2827BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function4, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function5, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        int i5;
        int i6;
        int i7;
        int i8;
        float fM2815getSheetMaxWidthD9Ej5fM;
        int i9;
        Shape expandedShape;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        int i10;
        float fM9687constructorimpl;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z2;
        final Shape shape2;
        final long j5;
        final Modifier modifier2;
        final boolean z3;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function7;
        final long j6;
        final long j7;
        final float f5;
        final long j8;
        final BottomSheetScaffoldState bottomSheetScaffoldState3;
        final float f6;
        final float f7;
        final float f8;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        float fM2816getSheetPeekHeightD9Ej5fM;
        final float fM2813getElevationD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> lambda$1392012807$material3;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$1768941633$material3;
        long surface;
        long jM3051contentColorForek8zF_U2;
        long j9;
        Modifier modifier3;
        int i26;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Composer composerStartRestartGroup = composer.startRestartGroup(920075480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffold)N(sheetContent,modifier,scaffoldState,sheetPeekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetShape,sheetContainerColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetTonalElevation:c#ui.unit.Dp,sheetShadowElevation:c#ui.unit.Dp,sheetDragHandle,sheetSwipeEnabled,topBar,snackbarHost,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)138@7435L1424:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i32 = i3 & 2;
        if (i32 == 0) {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0) {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    int i33 = composerStartRestartGroup.changed(bottomSheetScaffoldState2) ? 256 : 128;
                    i4 |= i33;
                } else {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                }
                i4 |= i33;
            } else {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                i8 = 8192;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = f2;
                        if (composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i4 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        expandedShape = shape;
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(expandedShape)) {
                            i31 = 65536;
                        } else {
                            i31 = 131072;
                        }
                        i4 |= i31;
                    } else {
                        expandedShape = shape;
                    }
                    if ((i & 1572864) == 0) {
                        containerColor = j;
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                            i30 = 524288;
                        } else {
                            i30 = 1048576;
                        }
                        i4 |= i30;
                    } else {
                        containerColor = j;
                    }
                    if ((i & 12582912) == 0) {
                        jM3051contentColorForek8zF_U = j2;
                        if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                            i29 = 4194304;
                        } else {
                            i29 = 8388608;
                        }
                        i4 |= i29;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    i10 = i3 & 256;
                    if (i10 != 0) {
                        i4 |= 100663296;
                        fM9687constructorimpl = f3;
                    } else {
                        fM9687constructorimpl = f3;
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i4 |= i11;
                        }
                    }
                    i12 = i3 & 512;
                    if (i12 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i4 |= i13;
                    }
                    i14 = i3 & 1024;
                    if (i14 != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    i17 = i3 & 2048;
                    if (i17 != 0) {
                        i15 |= 48;
                    } else if ((i2 & 48) != 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i15 |= i18;
                    }
                    i19 = i15;
                    i20 = i3 & 4096;
                    if (i20 != 0) {
                        i22 = i19 | 384;
                    } else {
                        i21 = i19;
                        if ((i2 & 384) != 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i23 = 256;
                            } else {
                                i23 = 128;
                            }
                            i21 |= i23;
                        }
                        i22 = i21;
                    }
                    i24 = i3 & 8192;
                    if (i24 != 0) {
                        i25 = i22;
                        if ((i2 & 3072) == 0) {
                            i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                                i8 = 16384;
                            }
                            i25 |= i8;
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                            if ((i3 & 32768) == 0 || !composerStartRestartGroup.changed(j4)) {
                                i28 = 65536;
                            } else {
                                i28 = 131072;
                            }
                            i25 |= i28;
                        }
                        if ((i2 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i25 |= i27;
                        }
                        if ((306783379 & i4) == 306783378 || (i25 & 599187) != 599186) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i32 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i3 & 4) != 0) {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                                }
                                if (i5 != 0) {
                                    fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                                } else {
                                    fM2816getSheetPeekHeightD9Ej5fM = f;
                                }
                                if (i7 != 0) {
                                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                                }
                                if ((i3 & 32) != 0) {
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                    i4 = (-29360129) & i4;
                                }
                                if (i10 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                }
                                if (i12 != 0) {
                                    fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                                } else {
                                    fM2813getElevationD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                                } else {
                                    lambda$1392012807$material3 = function2;
                                }
                                if (i17 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z;
                                }
                                if (i20 != 0) {
                                    function10 = null;
                                } else {
                                    function10 = function4;
                                }
                                if (i24 != 0) {
                                    lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                                } else {
                                    lambda$1768941633$material3 = function5;
                                }
                                if ((i3 & 16384) != 0) {
                                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                    i25 &= -57345;
                                } else {
                                    surface = j3;
                                }
                                if ((i3 & 32768) != 0) {
                                    jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                    i25 &= -458753;
                                } else {
                                    jM3051contentColorForek8zF_U2 = j4;
                                }
                                j9 = surface;
                                modifier3 = companion;
                                i26 = i25;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 16384) != 0) {
                                    i25 &= -57345;
                                }
                                if ((i3 & 32768) != 0) {
                                    i25 &= -458753;
                                }
                                modifier3 = modifier;
                                fM2813getElevationD9Ej5fM = f4;
                                lambda$1392012807$material3 = function2;
                                z4 = z;
                                function10 = function4;
                                lambda$1768941633$material3 = function5;
                                jM3051contentColorForek8zF_U2 = j4;
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                                i26 = i25;
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                                j9 = j3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                            }
                            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                            long j10 = j9;
                            Modifier modifier4 = modifier3;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            final long j11 = jM3051contentColorForek8zF_U;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                            final float f9 = fM2815getSheetMaxWidthD9Ej5fM;
                            final BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            final Shape shape3 = expandedShape;
                            final long j12 = containerColor;
                            final float f10 = fM2816getSheetPeekHeightD9Ej5fM;
                            final Function2<? super Composer, ? super Integer, Unit> function11 = lambda$1392012807$material3;
                            final float f11 = fM9687constructorimpl;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function12 = lambda$1768941633$material3;
                            final boolean z5 = z4;
                            final Function2<? super Composer, ? super Integer, Unit> function13 = function10;
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState4, function13, function6, f10, f9, z5, shape3, j12, j11, f11, fM2813getElevationD9Ej5fM, function11, function3, function12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            f7 = fM2816getSheetPeekHeightD9Ej5fM;
                            function8 = lambda$1392012807$material3;
                            function7 = lambda$1768941633$material3;
                            modifier2 = modifier4;
                            z3 = z4;
                            j7 = jM3051contentColorForek8zF_U2;
                            j6 = j10;
                            long j13 = containerColor;
                            f8 = fM2813getElevationD9Ej5fM;
                            f6 = fM9687constructorimpl;
                            function9 = function10;
                            f5 = fM2815getSheetMaxWidthD9Ej5fM;
                            shape2 = expandedShape;
                            j8 = j13;
                            j5 = j11;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            shape2 = expandedShape;
                            j5 = jM3051contentColorForek8zF_U;
                            modifier2 = modifier;
                            z3 = z;
                            function7 = function5;
                            j6 = j3;
                            j7 = j4;
                            f5 = fM2815getSheetMaxWidthD9Ej5fM;
                            j8 = containerColor;
                            bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                            f6 = fM9687constructorimpl;
                            f7 = f;
                            f8 = f4;
                            function8 = function2;
                            function9 = function4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i25 = i22 | 3072;
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i8 = 16384;
                        }
                        i25 |= i8;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i3 & 32768) == 0) {
                            i28 = 65536;
                        } else {
                            i28 = 65536;
                        }
                        i25 |= i28;
                    }
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i25 |= i27;
                    }
                    if ((306783379 & i4) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                        if ((i & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                        }
                        Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                        long j14 = j9;
                        Modifier modifier5 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final long j15 = jM3051contentColorForek8zF_U;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                        final float f12 = fM2815getSheetMaxWidthD9Ej5fM;
                        final BottomSheetScaffoldState bottomSheetScaffoldState5 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final Shape shape4 = expandedShape;
                        final long j16 = containerColor;
                        final float f13 = fM2816getSheetPeekHeightD9Ej5fM;
                        final Function2 function14 = lambda$1392012807$material3;
                        final float f14 = fM9687constructorimpl;
                        final Function3 function15 = lambda$1768941633$material3;
                        final boolean z6 = z4;
                        final Function2 function16 = function10;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState5, function16, function6, f13, f12, z6, shape4, j16, j15, f14, fM2813getElevationD9Ej5fM, function14, function3, function15, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        f7 = fM2816getSheetPeekHeightD9Ej5fM;
                        function8 = lambda$1392012807$material3;
                        function7 = lambda$1768941633$material3;
                        modifier2 = modifier5;
                        z3 = z4;
                        j7 = jM3051contentColorForek8zF_U2;
                        j6 = j14;
                        long j17 = containerColor;
                        f8 = fM2813getElevationD9Ej5fM;
                        f6 = fM9687constructorimpl;
                        function9 = function10;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        shape2 = expandedShape;
                        j8 = j17;
                        j5 = j15;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape2 = expandedShape;
                        j5 = jM3051contentColorForek8zF_U;
                        modifier2 = modifier;
                        z3 = z;
                        function7 = function5;
                        j6 = j3;
                        j7 = j4;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        j8 = containerColor;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                        f6 = fM9687constructorimpl;
                        f7 = f;
                        f8 = f4;
                        function8 = function2;
                        function9 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                fM2815getSheetMaxWidthD9Ej5fM = f2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i31 = 65536;
                    } else {
                        i31 = 65536;
                    }
                    i4 |= i31;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i30 = 524288;
                    } else {
                        i30 = 524288;
                    }
                    i4 |= i30;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i29 = 4194304;
                    } else {
                        i29 = 4194304;
                    }
                    i4 |= i29;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i4 |= 100663296;
                    fM9687constructorimpl = f3;
                } else {
                    fM9687constructorimpl = f3;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 512;
                if (i12 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                i17 = i3 & 2048;
                if (i17 != 0) {
                    i15 |= 48;
                } else if ((i2 & 48) != 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i19 = i15;
                i20 = i3 & 4096;
                if (i20 != 0) {
                    i22 = i19 | 384;
                } else {
                    i21 = i19;
                    if ((i2 & 384) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i21 |= i23;
                    }
                    i22 = i21;
                }
                i24 = i3 & 8192;
                if (i24 != 0) {
                    i25 = i22;
                    if ((i2 & 3072) == 0) {
                        i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i8 = 16384;
                        }
                        i25 |= i8;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i3 & 32768) == 0) {
                            i28 = 65536;
                        } else {
                            i28 = 65536;
                        }
                        i25 |= i28;
                    }
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i25 |= i27;
                    }
                    if ((306783379 & i4) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                        if ((i & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                        }
                        Modifier modifierM589backgroundbw27NRU$default3 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                        long j18 = j9;
                        Modifier modifier6 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default3);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final long j19 = jM3051contentColorForek8zF_U;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                        final float f15 = fM2815getSheetMaxWidthD9Ej5fM;
                        final BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final Shape shape5 = expandedShape;
                        final long j110 = containerColor;
                        final float f16 = fM2816getSheetPeekHeightD9Ej5fM;
                        final Function2 function17 = lambda$1392012807$material3;
                        final float f17 = fM9687constructorimpl;
                        final Function3 function18 = lambda$1768941633$material3;
                        final boolean z7 = z4;
                        final Function2 function19 = function10;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState6, function19, function6, f16, f15, z7, shape5, j110, j19, f17, fM2813getElevationD9Ej5fM, function17, function3, function18, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        f7 = fM2816getSheetPeekHeightD9Ej5fM;
                        function8 = lambda$1392012807$material3;
                        function7 = lambda$1768941633$material3;
                        modifier2 = modifier6;
                        z3 = z4;
                        j7 = jM3051contentColorForek8zF_U2;
                        j6 = j18;
                        long j111 = containerColor;
                        f8 = fM2813getElevationD9Ej5fM;
                        f6 = fM9687constructorimpl;
                        function9 = function10;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        shape2 = expandedShape;
                        j8 = j111;
                        j5 = j19;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape2 = expandedShape;
                        j5 = jM3051contentColorForek8zF_U;
                        modifier2 = modifier;
                        z3 = z;
                        function7 = function5;
                        j6 = j3;
                        j7 = j4;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        j8 = containerColor;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                        f6 = fM9687constructorimpl;
                        f7 = f;
                        f8 = f4;
                        function8 = function2;
                        function9 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i25 = i22 | 3072;
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default4 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j112 = j9;
                    Modifier modifier7 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j113 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f18 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape6 = expandedShape;
                    final long j114 = containerColor;
                    final float f19 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function110 = lambda$1392012807$material3;
                    final float f110 = fM9687constructorimpl;
                    final Function3 function111 = lambda$1768941633$material3;
                    final boolean z8 = z4;
                    final Function2 function112 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState7, function112, function6, f19, f18, z8, shape6, j114, j113, f110, fM2813getElevationD9Ej5fM, function110, function3, function111, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier7;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j112;
                    long j115 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j115;
                    j5 = j113;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i7 = i3 & 16;
            i8 = 8192;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i4 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i31 = 65536;
                    } else {
                        i31 = 65536;
                    }
                    i4 |= i31;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i30 = 524288;
                    } else {
                        i30 = 524288;
                    }
                    i4 |= i30;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i29 = 4194304;
                    } else {
                        i29 = 4194304;
                    }
                    i4 |= i29;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i4 |= 100663296;
                    fM9687constructorimpl = f3;
                } else {
                    fM9687constructorimpl = f3;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 512;
                if (i12 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                i17 = i3 & 2048;
                if (i17 != 0) {
                    i15 |= 48;
                } else if ((i2 & 48) != 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i19 = i15;
                i20 = i3 & 4096;
                if (i20 != 0) {
                    i22 = i19 | 384;
                } else {
                    i21 = i19;
                    if ((i2 & 384) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i21 |= i23;
                    }
                    i22 = i21;
                }
                i24 = i3 & 8192;
                if (i24 != 0) {
                    i25 = i22;
                    if ((i2 & 3072) == 0) {
                        i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i8 = 16384;
                        }
                        i25 |= i8;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i3 & 32768) == 0) {
                            i28 = 65536;
                        } else {
                            i28 = 65536;
                        }
                        i25 |= i28;
                    }
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i25 |= i27;
                    }
                    if ((306783379 & i4) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                        if ((i & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                        }
                        Modifier modifierM589backgroundbw27NRU$default5 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                        long j116 = j9;
                        Modifier modifier8 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final long j117 = jM3051contentColorForek8zF_U;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                        final float f111 = fM2815getSheetMaxWidthD9Ej5fM;
                        final BottomSheetScaffoldState bottomSheetScaffoldState8 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final Shape shape7 = expandedShape;
                        final long j118 = containerColor;
                        final float f112 = fM2816getSheetPeekHeightD9Ej5fM;
                        final Function2 function113 = lambda$1392012807$material3;
                        final float f113 = fM9687constructorimpl;
                        final Function3 function114 = lambda$1768941633$material3;
                        final boolean z9 = z4;
                        final Function2 function115 = function10;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState8, function115, function6, f112, f111, z9, shape7, j118, j117, f113, fM2813getElevationD9Ej5fM, function113, function3, function114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        f7 = fM2816getSheetPeekHeightD9Ej5fM;
                        function8 = lambda$1392012807$material3;
                        function7 = lambda$1768941633$material3;
                        modifier2 = modifier8;
                        z3 = z4;
                        j7 = jM3051contentColorForek8zF_U2;
                        j6 = j116;
                        long j119 = containerColor;
                        f8 = fM2813getElevationD9Ej5fM;
                        f6 = fM9687constructorimpl;
                        function9 = function10;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        shape2 = expandedShape;
                        j8 = j119;
                        j5 = j117;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape2 = expandedShape;
                        j5 = jM3051contentColorForek8zF_U;
                        modifier2 = modifier;
                        z3 = z;
                        function7 = function5;
                        j6 = j3;
                        j7 = j4;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        j8 = containerColor;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                        f6 = fM9687constructorimpl;
                        f7 = f;
                        f8 = f4;
                        function8 = function2;
                        function9 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i25 = i22 | 3072;
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default6 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j1110 = j9;
                    Modifier modifier9 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j1111 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f114 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState9 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape8 = expandedShape;
                    final long j1112 = containerColor;
                    final float f115 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function116 = lambda$1392012807$material3;
                    final float f116 = fM9687constructorimpl;
                    final Function3 function117 = lambda$1768941633$material3;
                    final boolean z10 = z4;
                    final Function2 function118 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState9, function118, function6, f115, f114, z10, shape8, j1112, j1111, f116, fM2813getElevationD9Ej5fM, function116, function3, function117, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier9;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j1110;
                    long j1113 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j1113;
                    j5 = j1111;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            fM2815getSheetMaxWidthD9Ej5fM = f2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i31 = 65536;
                } else {
                    i31 = 65536;
                }
                i4 |= i31;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i30 = 524288;
                } else {
                    i30 = 524288;
                }
                i4 |= i30;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i29 = 4194304;
                } else {
                    i29 = 4194304;
                }
                i4 |= i29;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i4 |= 100663296;
                fM9687constructorimpl = f3;
            } else {
                fM9687constructorimpl = f3;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 512;
            if (i12 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i4 |= i13;
            }
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i19 = i15;
            i20 = i3 & 4096;
            if (i20 != 0) {
                i22 = i19 | 384;
            } else {
                i21 = i19;
                if ((i2 & 384) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i21 |= i23;
                }
                i22 = i21;
            }
            i24 = i3 & 8192;
            if (i24 != 0) {
                i25 = i22;
                if ((i2 & 3072) == 0) {
                    i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default7 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j1114 = j9;
                    Modifier modifier10 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j1115 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f117 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState10 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape9 = expandedShape;
                    final long j1116 = containerColor;
                    final float f118 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function119 = lambda$1392012807$material3;
                    final float f119 = fM9687constructorimpl;
                    final Function3 function1110 = lambda$1768941633$material3;
                    final boolean z11 = z4;
                    final Function2 function1111 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState10, function1111, function6, f118, f117, z11, shape9, j1116, j1115, f119, fM2813getElevationD9Ej5fM, function119, function3, function1110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier10;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j1114;
                    long j1117 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j1117;
                    j5 = j1115;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i25 = i22 | 3072;
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i25 |= i8;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i25 |= i28;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i25 |= i27;
            }
            if ((306783379 & i4) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                if ((i & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                }
                Modifier modifierM589backgroundbw27NRU$default8 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                long j1118 = j9;
                Modifier modifier11 = modifier3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default8);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final long j1119 = jM3051contentColorForek8zF_U;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                final float f1110 = fM2815getSheetMaxWidthD9Ej5fM;
                final BottomSheetScaffoldState bottomSheetScaffoldState11 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final Shape shape10 = expandedShape;
                final long j11110 = containerColor;
                final float f1111 = fM2816getSheetPeekHeightD9Ej5fM;
                final Function2 function1112 = lambda$1392012807$material3;
                final float f1112 = fM9687constructorimpl;
                final Function3 function1113 = lambda$1768941633$material3;
                final boolean z12 = z4;
                final Function2 function1114 = function10;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState11, function1114, function6, f1111, f1110, z12, shape10, j11110, j1119, f1112, fM2813getElevationD9Ej5fM, function1112, function3, function1113, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                f7 = fM2816getSheetPeekHeightD9Ej5fM;
                function8 = lambda$1392012807$material3;
                function7 = lambda$1768941633$material3;
                modifier2 = modifier11;
                z3 = z4;
                j7 = jM3051contentColorForek8zF_U2;
                j6 = j1118;
                long j11111 = containerColor;
                f8 = fM2813getElevationD9Ej5fM;
                f6 = fM9687constructorimpl;
                function9 = function10;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                shape2 = expandedShape;
                j8 = j11111;
                j5 = j1119;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = expandedShape;
                j5 = jM3051contentColorForek8zF_U;
                modifier2 = modifier;
                z3 = z;
                function7 = function5;
                j6 = j3;
                j7 = j4;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                j8 = containerColor;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                f6 = fM9687constructorimpl;
                f7 = f;
                f8 = f4;
                function8 = function2;
                function9 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i & 384) == 0) {
            if ((i3 & 4) == 0) {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                if (composerStartRestartGroup.changed(bottomSheetScaffoldState2)) {
                }
                i4 |= i33;
            } else {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
            }
            i4 |= i33;
        } else {
            bottomSheetScaffoldState2 = bottomSheetScaffoldState;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            i8 = 8192;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i4 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i31 = 65536;
                    } else {
                        i31 = 65536;
                    }
                    i4 |= i31;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i30 = 524288;
                    } else {
                        i30 = 524288;
                    }
                    i4 |= i30;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if ((i3 & 128) == 0) {
                        i29 = 4194304;
                    } else {
                        i29 = 4194304;
                    }
                    i4 |= i29;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i4 |= 100663296;
                    fM9687constructorimpl = f3;
                } else {
                    fM9687constructorimpl = f3;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 512;
                if (i12 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                i17 = i3 & 2048;
                if (i17 != 0) {
                    i15 |= 48;
                } else if ((i2 & 48) != 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i19 = i15;
                i20 = i3 & 4096;
                if (i20 != 0) {
                    i22 = i19 | 384;
                } else {
                    i21 = i19;
                    if ((i2 & 384) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i21 |= i23;
                    }
                    i22 = i21;
                }
                i24 = i3 & 8192;
                if (i24 != 0) {
                    i25 = i22;
                    if ((i2 & 3072) == 0) {
                        i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i8 = 16384;
                        }
                        i25 |= i8;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i3 & 32768) == 0) {
                            i28 = 65536;
                        } else {
                            i28 = 65536;
                        }
                        i25 |= i28;
                    }
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i25 |= i27;
                    }
                    if ((306783379 & i4) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                        if ((i & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                            }
                            if (i5 != 0) {
                                fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM2816getSheetPeekHeightD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 = (-29360129) & i4;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            if (i12 != 0) {
                                fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                            } else {
                                fM2813getElevationD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                            } else {
                                lambda$1392012807$material3 = function2;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i20 != 0) {
                                function10 = null;
                            } else {
                                function10 = function4;
                            }
                            if (i24 != 0) {
                                lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                            } else {
                                lambda$1768941633$material3 = function5;
                            }
                            if ((i3 & 16384) != 0) {
                                surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                i25 &= -57345;
                            } else {
                                surface = j3;
                            }
                            if ((i3 & 32768) != 0) {
                                jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                                i25 &= -458753;
                            } else {
                                jM3051contentColorForek8zF_U2 = j4;
                            }
                            j9 = surface;
                            modifier3 = companion;
                            i26 = i25;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                        }
                        Modifier modifierM589backgroundbw27NRU$default9 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                        long j11112 = j9;
                        Modifier modifier12 = modifier3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default9);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final long j11113 = jM3051contentColorForek8zF_U;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                        final float f1113 = fM2815getSheetMaxWidthD9Ej5fM;
                        final BottomSheetScaffoldState bottomSheetScaffoldState12 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final Shape shape11 = expandedShape;
                        final long j11114 = containerColor;
                        final float f1114 = fM2816getSheetPeekHeightD9Ej5fM;
                        final Function2 function1115 = lambda$1392012807$material3;
                        final float f1115 = fM9687constructorimpl;
                        final Function3 function1116 = lambda$1768941633$material3;
                        final boolean z13 = z4;
                        final Function2 function1117 = function10;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState12, function1117, function6, f1114, f1113, z13, shape11, j11114, j11113, f1115, fM2813getElevationD9Ej5fM, function1115, function3, function1116, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        f7 = fM2816getSheetPeekHeightD9Ej5fM;
                        function8 = lambda$1392012807$material3;
                        function7 = lambda$1768941633$material3;
                        modifier2 = modifier12;
                        z3 = z4;
                        j7 = jM3051contentColorForek8zF_U2;
                        j6 = j11112;
                        long j11115 = containerColor;
                        f8 = fM2813getElevationD9Ej5fM;
                        f6 = fM9687constructorimpl;
                        function9 = function10;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        shape2 = expandedShape;
                        j8 = j11115;
                        j5 = j11113;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        shape2 = expandedShape;
                        j5 = jM3051contentColorForek8zF_U;
                        modifier2 = modifier;
                        z3 = z;
                        function7 = function5;
                        j6 = j3;
                        j7 = j4;
                        f5 = fM2815getSheetMaxWidthD9Ej5fM;
                        j8 = containerColor;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                        f6 = fM9687constructorimpl;
                        f7 = f;
                        f8 = f4;
                        function8 = function2;
                        function9 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i25 = i22 | 3072;
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default10 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j11116 = j9;
                    Modifier modifier13 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default10);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j11117 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f1116 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState13 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape12 = expandedShape;
                    final long j11118 = containerColor;
                    final float f1117 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function1118 = lambda$1392012807$material3;
                    final float f1118 = fM9687constructorimpl;
                    final Function3 function1119 = lambda$1768941633$material3;
                    final boolean z14 = z4;
                    final Function2 function11110 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState13, function11110, function6, f1117, f1116, z14, shape12, j11118, j11117, f1118, fM2813getElevationD9Ej5fM, function1118, function3, function1119, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier13;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j11116;
                    long j11119 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j11119;
                    j5 = j11117;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            fM2815getSheetMaxWidthD9Ej5fM = f2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i31 = 65536;
                } else {
                    i31 = 65536;
                }
                i4 |= i31;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i30 = 524288;
                } else {
                    i30 = 524288;
                }
                i4 |= i30;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i29 = 4194304;
                } else {
                    i29 = 4194304;
                }
                i4 |= i29;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i4 |= 100663296;
                fM9687constructorimpl = f3;
            } else {
                fM9687constructorimpl = f3;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 512;
            if (i12 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i4 |= i13;
            }
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i19 = i15;
            i20 = i3 & 4096;
            if (i20 != 0) {
                i22 = i19 | 384;
            } else {
                i21 = i19;
                if ((i2 & 384) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i21 |= i23;
                }
                i22 = i21;
            }
            i24 = i3 & 8192;
            if (i24 != 0) {
                i25 = i22;
                if ((i2 & 3072) == 0) {
                    i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default11 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j111110 = j9;
                    Modifier modifier14 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default11);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j111111 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f1119 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState14 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape13 = expandedShape;
                    final long j111112 = containerColor;
                    final float f11110 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function11111 = lambda$1392012807$material3;
                    final float f11111 = fM9687constructorimpl;
                    final Function3 function11112 = lambda$1768941633$material3;
                    final boolean z15 = z4;
                    final Function2 function11113 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState14, function11113, function6, f11110, f1119, z15, shape13, j111112, j111111, f11111, fM2813getElevationD9Ej5fM, function11111, function3, function11112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier14;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j111110;
                    long j111113 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j111113;
                    j5 = j111111;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i25 = i22 | 3072;
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i25 |= i8;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i25 |= i28;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i25 |= i27;
            }
            if ((306783379 & i4) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                if ((i & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                }
                Modifier modifierM589backgroundbw27NRU$default12 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                long j111114 = j9;
                Modifier modifier15 = modifier3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default12);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final long j111115 = jM3051contentColorForek8zF_U;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                final float f11112 = fM2815getSheetMaxWidthD9Ej5fM;
                final BottomSheetScaffoldState bottomSheetScaffoldState15 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final Shape shape14 = expandedShape;
                final long j111116 = containerColor;
                final float f11113 = fM2816getSheetPeekHeightD9Ej5fM;
                final Function2 function11114 = lambda$1392012807$material3;
                final float f11114 = fM9687constructorimpl;
                final Function3 function11115 = lambda$1768941633$material3;
                final boolean z16 = z4;
                final Function2 function11116 = function10;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState15, function11116, function6, f11113, f11112, z16, shape14, j111116, j111115, f11114, fM2813getElevationD9Ej5fM, function11114, function3, function11115, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                f7 = fM2816getSheetPeekHeightD9Ej5fM;
                function8 = lambda$1392012807$material3;
                function7 = lambda$1768941633$material3;
                modifier2 = modifier15;
                z3 = z4;
                j7 = jM3051contentColorForek8zF_U2;
                j6 = j111114;
                long j111117 = containerColor;
                f8 = fM2813getElevationD9Ej5fM;
                f6 = fM9687constructorimpl;
                function9 = function10;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                shape2 = expandedShape;
                j8 = j111117;
                j5 = j111115;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = expandedShape;
                j5 = jM3051contentColorForek8zF_U;
                modifier2 = modifier;
                z3 = z;
                function7 = function5;
                j6 = j3;
                j7 = j4;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                j8 = containerColor;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                f6 = fM9687constructorimpl;
                f7 = f;
                f8 = f4;
                function8 = function2;
                function9 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        i7 = i3 & 16;
        i8 = 8192;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                fM2815getSheetMaxWidthD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i4 |= i9;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i31 = 65536;
                } else {
                    i31 = 65536;
                }
                i4 |= i31;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i30 = 524288;
                } else {
                    i30 = 524288;
                }
                i4 |= i30;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0) {
                    i29 = 4194304;
                } else {
                    i29 = 4194304;
                }
                i4 |= i29;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i4 |= 100663296;
                fM9687constructorimpl = f3;
            } else {
                fM9687constructorimpl = f3;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 512;
            if (i12 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i4 |= i13;
            }
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i2 & 48) != 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i19 = i15;
            i20 = i3 & 4096;
            if (i20 != 0) {
                i22 = i19 | 384;
            } else {
                i21 = i19;
                if ((i2 & 384) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i21 |= i23;
                }
                i22 = i21;
            }
            i24 = i3 & 8192;
            if (i24 != 0) {
                i25 = i22;
                if ((i2 & 3072) == 0) {
                    i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i25 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i3 & 32768) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i25 |= i28;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i25 |= i27;
                }
                if ((306783379 & i4) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                    if ((i & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                        }
                        if (i5 != 0) {
                            fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM2816getSheetPeekHeightD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 = (-29360129) & i4;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        if (i12 != 0) {
                            fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                        } else {
                            fM2813getElevationD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                        } else {
                            lambda$1392012807$material3 = function2;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i20 != 0) {
                            function10 = null;
                        } else {
                            function10 = function4;
                        }
                        if (i24 != 0) {
                            lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                        } else {
                            lambda$1768941633$material3 = function5;
                        }
                        if ((i3 & 16384) != 0) {
                            surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                            i25 &= -57345;
                        } else {
                            surface = j3;
                        }
                        if ((i3 & 32768) != 0) {
                            jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                            i25 &= -458753;
                        } else {
                            jM3051contentColorForek8zF_U2 = j4;
                        }
                        j9 = surface;
                        modifier3 = companion;
                        i26 = i25;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                    }
                    Modifier modifierM589backgroundbw27NRU$default13 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                    long j111118 = j9;
                    Modifier modifier16 = modifier3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default13);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final long j111119 = jM3051contentColorForek8zF_U;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                    final float f11115 = fM2815getSheetMaxWidthD9Ej5fM;
                    final BottomSheetScaffoldState bottomSheetScaffoldState16 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final Shape shape15 = expandedShape;
                    final long j1111110 = containerColor;
                    final float f11116 = fM2816getSheetPeekHeightD9Ej5fM;
                    final Function2 function11117 = lambda$1392012807$material3;
                    final float f11117 = fM9687constructorimpl;
                    final Function3 function11118 = lambda$1768941633$material3;
                    final boolean z17 = z4;
                    final Function2 function11119 = function10;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState16, function11119, function6, f11116, f11115, z17, shape15, j1111110, j111119, f11117, fM2813getElevationD9Ej5fM, function11117, function3, function11118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    f7 = fM2816getSheetPeekHeightD9Ej5fM;
                    function8 = lambda$1392012807$material3;
                    function7 = lambda$1768941633$material3;
                    modifier2 = modifier16;
                    z3 = z4;
                    j7 = jM3051contentColorForek8zF_U2;
                    j6 = j111118;
                    long j1111111 = containerColor;
                    f8 = fM2813getElevationD9Ej5fM;
                    f6 = fM9687constructorimpl;
                    function9 = function10;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    shape2 = expandedShape;
                    j8 = j1111111;
                    j5 = j111119;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    shape2 = expandedShape;
                    j5 = jM3051contentColorForek8zF_U;
                    modifier2 = modifier;
                    z3 = z;
                    function7 = function5;
                    j6 = j3;
                    j7 = j4;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    j8 = containerColor;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = fM9687constructorimpl;
                    f7 = f;
                    f8 = f4;
                    function8 = function2;
                    function9 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i25 = i22 | 3072;
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i25 |= i8;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i25 |= i28;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i25 |= i27;
            }
            if ((306783379 & i4) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                if ((i & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                }
                Modifier modifierM589backgroundbw27NRU$default14 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                long j1111112 = j9;
                Modifier modifier17 = modifier3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default14);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final long j1111113 = jM3051contentColorForek8zF_U;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                final float f11118 = fM2815getSheetMaxWidthD9Ej5fM;
                final BottomSheetScaffoldState bottomSheetScaffoldState17 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final Shape shape16 = expandedShape;
                final long j1111114 = containerColor;
                final float f11119 = fM2816getSheetPeekHeightD9Ej5fM;
                final Function2 function111110 = lambda$1392012807$material3;
                final float f111110 = fM9687constructorimpl;
                final Function3 function111111 = lambda$1768941633$material3;
                final boolean z18 = z4;
                final Function2 function111112 = function10;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState17, function111112, function6, f11119, f11118, z18, shape16, j1111114, j1111113, f111110, fM2813getElevationD9Ej5fM, function111110, function3, function111111, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                f7 = fM2816getSheetPeekHeightD9Ej5fM;
                function8 = lambda$1392012807$material3;
                function7 = lambda$1768941633$material3;
                modifier2 = modifier17;
                z3 = z4;
                j7 = jM3051contentColorForek8zF_U2;
                j6 = j1111112;
                long j1111115 = containerColor;
                f8 = fM2813getElevationD9Ej5fM;
                f6 = fM9687constructorimpl;
                function9 = function10;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                shape2 = expandedShape;
                j8 = j1111115;
                j5 = j1111113;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = expandedShape;
                j5 = jM3051contentColorForek8zF_U;
                modifier2 = modifier;
                z3 = z;
                function7 = function5;
                j6 = j3;
                j7 = j4;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                j8 = containerColor;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                f6 = fM9687constructorimpl;
                f7 = f;
                f8 = f4;
                function8 = function2;
                function9 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        fM2815getSheetMaxWidthD9Ej5fM = f2;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            expandedShape = shape;
            if ((i3 & 32) == 0) {
                i31 = 65536;
            } else {
                i31 = 65536;
            }
            i4 |= i31;
        } else {
            expandedShape = shape;
        }
        if ((i & 1572864) == 0) {
            containerColor = j;
            if ((i3 & 64) == 0) {
                i30 = 524288;
            } else {
                i30 = 524288;
            }
            i4 |= i30;
        } else {
            containerColor = j;
        }
        if ((i & 12582912) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i3 & 128) == 0) {
                i29 = 4194304;
            } else {
                i29 = 4194304;
            }
            i4 |= i29;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i10 = i3 & 256;
        if (i10 != 0) {
            i4 |= 100663296;
            fM9687constructorimpl = f3;
        } else {
            fM9687constructorimpl = f3;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(fM9687constructorimpl)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i4 |= i11;
            }
        }
        i12 = i3 & 512;
        if (i12 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(f4)) {
                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i13 = 268435456;
            }
            i4 |= i13;
        }
        i14 = i3 & 1024;
        if (i14 != 0) {
            i15 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i2 | i16;
        } else {
            i15 = i2;
        }
        i17 = i3 & 2048;
        if (i17 != 0) {
            i15 |= 48;
        } else if ((i2 & 48) != 0) {
            if (composerStartRestartGroup.changed(z)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i15 |= i18;
        }
        i19 = i15;
        i20 = i3 & 4096;
        if (i20 != 0) {
            i22 = i19 | 384;
        } else {
            i21 = i19;
            if ((i2 & 384) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i23 = 256;
                } else {
                    i23 = 128;
                }
                i21 |= i23;
            }
            i22 = i21;
        }
        i24 = i3 & 8192;
        if (i24 != 0) {
            i25 = i22;
            if ((i2 & 3072) == 0) {
                i25 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i25 |= i8;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32768) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i25 |= i28;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i25 |= i27;
            }
            if ((306783379 & i4) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
                if ((i & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                    }
                    if (i5 != 0) {
                        fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM2816getSheetPeekHeightD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 = (-29360129) & i4;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    if (i12 != 0) {
                        fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                    } else {
                        fM2813getElevationD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                    } else {
                        lambda$1392012807$material3 = function2;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i20 != 0) {
                        function10 = null;
                    } else {
                        function10 = function4;
                    }
                    if (i24 != 0) {
                        lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                    } else {
                        lambda$1768941633$material3 = function5;
                    }
                    if ((i3 & 16384) != 0) {
                        surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                        i25 &= -57345;
                    } else {
                        surface = j3;
                    }
                    if ((i3 & 32768) != 0) {
                        jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                        i25 &= -458753;
                    } else {
                        jM3051contentColorForek8zF_U2 = j4;
                    }
                    j9 = surface;
                    modifier3 = companion;
                    i26 = i25;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
                }
                Modifier modifierM589backgroundbw27NRU$default15 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
                long j1111116 = j9;
                Modifier modifier18 = modifier3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default15);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final long j1111117 = jM3051contentColorForek8zF_U;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
                final float f111111 = fM2815getSheetMaxWidthD9Ej5fM;
                final BottomSheetScaffoldState bottomSheetScaffoldState18 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final Shape shape17 = expandedShape;
                final long j1111118 = containerColor;
                final float f111112 = fM2816getSheetPeekHeightD9Ej5fM;
                final Function2 function111113 = lambda$1392012807$material3;
                final float f111113 = fM9687constructorimpl;
                final Function3 function111114 = lambda$1768941633$material3;
                final boolean z19 = z4;
                final Function2 function111115 = function10;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState18, function111115, function6, f111112, f111111, z19, shape17, j1111118, j1111117, f111113, fM2813getElevationD9Ej5fM, function111113, function3, function111114, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                f7 = fM2816getSheetPeekHeightD9Ej5fM;
                function8 = lambda$1392012807$material3;
                function7 = lambda$1768941633$material3;
                modifier2 = modifier18;
                z3 = z4;
                j7 = jM3051contentColorForek8zF_U2;
                j6 = j1111116;
                long j1111119 = containerColor;
                f8 = fM2813getElevationD9Ej5fM;
                f6 = fM9687constructorimpl;
                function9 = function10;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                shape2 = expandedShape;
                j8 = j1111119;
                j5 = j1111117;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = expandedShape;
                j5 = jM3051contentColorForek8zF_U;
                modifier2 = modifier;
                z3 = z;
                function7 = function5;
                j6 = j3;
                j7 = j4;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                j8 = containerColor;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                f6 = fM9687constructorimpl;
                f7 = f;
                f8 = f4;
                function8 = function2;
                function9 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i25 = i22 | 3072;
        if ((i2 & 24576) != 0) {
            if ((i3 & 16384) == 0) {
                i8 = 16384;
            }
            i25 |= i8;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i3 & 32768) == 0) {
                i28 = 65536;
            } else {
                i28 = 65536;
            }
            i25 |= i28;
        }
        if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i27 = 1048576;
            } else {
                i27 = 524288;
            }
            i25 |= i27;
        }
        if ((306783379 & i4) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "122@6548L34,125@6750L13,126@6818L14,127@6865L36,134@7297L11,135@7344L31");
            if ((i & 1) != 0) {
                if (i32 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                }
                if (i5 != 0) {
                    fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                } else {
                    fM2816getSheetPeekHeightD9Ej5fM = f;
                }
                if (i7 != 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                }
                if ((i3 & 32) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                    i4 = (-29360129) & i4;
                }
                if (i10 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                if (i12 != 0) {
                    fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                } else {
                    fM2813getElevationD9Ej5fM = f4;
                }
                if (i14 != 0) {
                    lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                } else {
                    lambda$1392012807$material3 = function2;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i20 != 0) {
                    function10 = null;
                } else {
                    function10 = function4;
                }
                if (i24 != 0) {
                    lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                } else {
                    lambda$1768941633$material3 = function5;
                }
                if ((i3 & 16384) != 0) {
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                    i25 &= -57345;
                } else {
                    surface = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                    i25 &= -458753;
                } else {
                    jM3051contentColorForek8zF_U2 = j4;
                }
                j9 = surface;
                modifier3 = companion;
                i26 = i25;
            } else {
                if (i32 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                }
                if (i5 != 0) {
                    fM2816getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m2816getSheetPeekHeightD9Ej5fM();
                } else {
                    fM2816getSheetPeekHeightD9Ej5fM = f;
                }
                if (i7 != 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                }
                if ((i3 & 32) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                    i4 = (-29360129) & i4;
                }
                if (i10 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                if (i12 != 0) {
                    fM2813getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM();
                } else {
                    fM2813getElevationD9Ej5fM = f4;
                }
                if (i14 != 0) {
                    lambda$1392012807$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
                } else {
                    lambda$1392012807$material3 = function2;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i20 != 0) {
                    function10 = null;
                } else {
                    function10 = function4;
                }
                if (i24 != 0) {
                    lambda$1768941633$material3 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
                } else {
                    lambda$1768941633$material3 = function5;
                }
                if ((i3 & 16384) != 0) {
                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                    i25 &= -57345;
                } else {
                    surface = j3;
                }
                if ((i3 & 32768) != 0) {
                    jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(surface, composerStartRestartGroup, (i25 >> 12) & 14);
                    i25 &= -458753;
                } else {
                    jM3051contentColorForek8zF_U2 = j4;
                }
                j9 = surface;
                modifier3 = companion;
                i26 = i25;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(920075480, i4, i26, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:137)");
            }
            Modifier modifierM589backgroundbw27NRU$default16 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j9, null, 2, null);
            long j11111110 = j9;
            Modifier modifier19 = modifier3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default16);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            final long j11111111 = jM3051contentColorForek8zF_U;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C141@7712L1141,141@7646L1207:BottomSheetScaffold.kt#uh7d8r");
            final float f111114 = fM2815getSheetMaxWidthD9Ej5fM;
            final BottomSheetScaffoldState bottomSheetScaffoldState19 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
            final Shape shape18 = expandedShape;
            final long j11111112 = containerColor;
            final float f111115 = fM2816getSheetPeekHeightD9Ej5fM;
            final Function2 function111116 = lambda$1392012807$material3;
            final float f111116 = fM9687constructorimpl;
            final Function3 function111117 = lambda$1768941633$material3;
            final boolean z110 = z4;
            final Function2 function111118 = function10;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U2)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0(bottomSheetScaffoldState19, function111118, function6, f111115, f111114, z110, shape18, j11111112, j11111111, f111116, fM2813getElevationD9Ej5fM, function111116, function3, function111117, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
            f7 = fM2816getSheetPeekHeightD9Ej5fM;
            function8 = lambda$1392012807$material3;
            function7 = lambda$1768941633$material3;
            modifier2 = modifier19;
            z3 = z4;
            j7 = jM3051contentColorForek8zF_U2;
            j6 = j11111110;
            long j11111113 = containerColor;
            f8 = fM2813getElevationD9Ej5fM;
            f6 = fM9687constructorimpl;
            function9 = function10;
            f5 = fM2815getSheetMaxWidthD9Ej5fM;
            shape2 = expandedShape;
            j8 = j11111113;
            j5 = j11111111;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            shape2 = expandedShape;
            j5 = jM3051contentColorForek8zF_U;
            modifier2 = modifier;
            z3 = z;
            function7 = function5;
            j6 = j3;
            j7 = j4;
            f5 = fM2815getSheetMaxWidthD9Ej5fM;
            j8 = containerColor;
            bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
            f6 = fM9687constructorimpl;
            f7 = f;
            f8 = f4;
            function8 = function2;
            function9 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f7, f5, shape2, j8, j5, f6, f8, function8, z3, function9, function7, j6, j7, function6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_sdMYb0k$lambda$0$0$0(Function3 function3, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C144@7811L48:BottomSheetScaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519581786, i, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:144)");
            }
            function3.invoke(PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_sdMYb0k$lambda$0$0$2(Function3 function3, BottomSheetScaffoldState bottomSheetScaffoldState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C145@7896L45:BottomSheetScaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1111667356, i, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:145)");
            }
            function3.invoke(bottomSheetScaffoldState.getSnackbarHostState(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomSheetScaffold_sdMYb0k$lambda$0$0$3$0(BottomSheetScaffoldState bottomSheetScaffoldState) {
        return bottomSheetScaffoldState.getBottomSheetState().requireOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_sdMYb0k$lambda$0$0(final BottomSheetScaffoldState bottomSheetScaffoldState, Function2 function2, final Function3 function3, final float f, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2 function4, final Function3 function5, final Function3 function6, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C144@7809L52,148@8118L710,145@7894L49,146@7975L50,142@7726L1117:BottomSheetScaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(999829022, i, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:142)");
            }
            SheetState bottomSheetState = bottomSheetScaffoldState.getBottomSheetState();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-519581786, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0$0(function3, f, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-815624571, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0$1(bottomSheetScaffoldState, f, f2, z, shape, j, j2, f3, f4, function4, function5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1111667356, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0$2(function6, bottomSheetScaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1236975696, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChanged = composer.changed(bottomSheetScaffoldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$0$0$3$0(bottomSheetScaffoldState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BottomSheetScaffoldLayout(function2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, (Function0) objRememberedValue, bottomSheetState, composer, 3504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_sdMYb0k$lambda$0$0$1(BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2 function2, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C149@8140L670:BottomSheetScaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-815624571, i, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:149)");
            }
            m2828StandardBottomSheetw7I5h1o(bottomSheetScaffoldState.getBottomSheetState(), f, f2, z, shape, j, j2, f3, f4, function2, function3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1474606134, "C(rememberBottomSheetScaffoldState)N(bottomSheetState,snackbarHostState)191@9623L34,192@9702L32,194@9777L197:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            sheetState = rememberStandardBottomSheetState(null, null, false, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 242717802, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:193)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 242720367, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(sheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        Function1<? super SheetValue, Boolean> function2;
        ComposerKt.sourceInformationMarkerStart(composer, 678511581, "C(rememberStandardBottomSheetState)N(initialValue,confirmValueChange,skipHiddenState)214@10555L8,217@10610L154:BottomSheetScaffold.kt#uh7d8r");
        SheetValue sheetValue2 = (i2 & 1) != 0 ? SheetValue.PartiallyExpanded : sheetValue;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -785395227, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BottomSheetScaffoldKt.rememberStandardBottomSheetState$lambda$0$0((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            function2 = function1;
        }
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:217)");
        }
        SheetState sheetStateM4161rememberSheetStateAGcomas = SheetDefaultsKt.m4161rememberSheetStateAGcomas(false, function2, sheetValue2, z2, 0.0f, 0.0f, composer, (i & 112) | ((i << 6) & 896) | ((i << 3) & 7168), 49);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM4161rememberSheetStateAGcomas;
    }

    /* JADX INFO: renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    private static final void m2828StandardBottomSheetw7I5h1o(final SheetState sheetState, final float f, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        Modifier.Companion companionNestedScroll$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2108849428);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StandardBottomSheet)N(state,peekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetSwipeEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,dragHandle,content)240@11343L7,241@11437L7,242@11528L7,244@11552L159,244@11541L170,250@11729L24,252@11838L7,256@12043L43,254@11944L207,280@12928L3007,353@16814L3838,274@12653L7999:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(f4) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2108849428, i3, i4, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:237)");
            }
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620286795, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i5 = i3 & 14;
            int i6 = i3;
            boolean zChangedInstance = (i5 == 4) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$0$0(sheetState, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Orientation orientation = Orientation.Vertical;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo754toPx0680j_4 = ((Density) objConsume).mo754toPx0680j_4(f);
            AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.INSTANCE;
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3 = sheetState.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620302391, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z2 = i5 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$2$0(sheetState, ((Float) obj).floatValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = anchoredDraggableDefaults.flingBehavior(anchoredDraggableState$material3, (Function1) objRememberedValue3, SheetDefaultsKt.getBottomSheetAnimationSpec(), composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(2049678787);
                ComposerKt.sourceInformation(composerStartRestartGroup, "263@12260L326");
                Modifier.Companion companion = Modifier.INSTANCE;
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material4 = sheetState.getAnchoredDraggableState$material3();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620309618, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(anchoredDraggableState$material4);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, targetedFlingBehaviorFlingBehavior);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) objRememberedValue4, null, 2, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2050073014);
                composerStartRestartGroup.endReplaceGroup();
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.m1257requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), 0.0f, 1, null), f, 0.0f, 2, null).then(companionNestedScroll$default);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material5 = sheetState.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620333675, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(fMo754toPx0680j_4) | (i5 == 4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$4$0(sheetState, fMo754toPx0680j_4, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            int i7 = i6 >> 9;
            SurfaceKt.m4323SurfaceT9BRK9s(verticalScaleUp(AnchoredDraggableKt.anchoredDraggable$default(DraggableAnchorsKt.draggableAnchors(modifierThen, anchoredDraggableState$material5, orientation, (Function2) objRememberedValue5), sheetState.getAnchoredDraggableState$material3(), orientation, z, null, null, targetedFlingBehaviorFlingBehavior, 24, null), sheetState), shape, j, j2, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(1508311921, true, new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5(sheetState, function2, coroutineScope, z, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (i7 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$6(sheetState, f, f2, z, shape, j, j2, f3, f4, function2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$0$0(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float StandardBottomSheet_w7I5h1o$lambda$2$0(SheetState sheetState, float f) {
        return sheetState.getPositionalThreshold$material3().invoke().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair StandardBottomSheet_w7I5h1o$lambda$4$0(final SheetState sheetState, final float f, IntSize intSize, Constraints constraints) {
        final float fM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(constraints.getValue());
        final float fM9862unboximpl = (int) (intSize.m9862unboximpl() & 4294967295L);
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$4$0$0(fM9862unboximpl, f, sheetState, fM9639getMaxHeightimpl, (DraggableAnchorsConfig) obj);
            }
        });
        SheetValue targetValue = sheetState.getTargetValue();
        int i = WhenMappings.$EnumSwitchMapping$0[targetValue.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                targetValue = DraggableAnchors.hasPositionFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
            } else if (DraggableAnchors.hasPositionFor(SheetValue.PartiallyExpanded)) {
                targetValue = SheetValue.PartiallyExpanded;
            } else if (DraggableAnchors.hasPositionFor(SheetValue.Expanded)) {
                targetValue = SheetValue.Expanded;
            } else if (DraggableAnchors.hasPositionFor(SheetValue.Hidden)) {
                targetValue = SheetValue.Hidden;
            }
        } else if (DraggableAnchors.hasPositionFor(SheetValue.Hidden)) {
            targetValue = SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, targetValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$4$0$0(float f, float f2, SheetState sheetState, float f3, DraggableAnchorsConfig draggableAnchorsConfig) {
        boolean z = f == 0.0f || f2 == 0.0f || !sheetState.getSkipHiddenState();
        boolean z2 = (sheetState.getSkipPartiallyExpanded() || f2 <= 0.0f || f2 == f) ? false : true;
        boolean z3 = f > 0.0f;
        if (!z && !z2 && !z3) {
            throw new IllegalArgumentException("Require at least 1 anchor to be initialized".toString());
        }
        if (z2) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f3 - f2);
        }
        if (z) {
            draggableAnchorsConfig.at(SheetValue.Hidden, f3);
        }
        if (z3) {
            draggableAnchorsConfig.at(SheetValue.Expanded, f3 - f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$5(final SheetState sheetState, Function2 function2, final CoroutineScope coroutineScope, final boolean z, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C354@16824L3822:BottomSheetScaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1508311921, i, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:354)");
            }
            Modifier modifierVerticalScaleDown = verticalScaleDown(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), sheetState);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScaleDown);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1044107094, "C420@20627L9:BottomSheetScaffold.kt#uh7d8r");
            if (function2 == null) {
                composer.startReplaceGroup(-1061240485);
            } else {
                composer.startReplaceGroup(-1044084713);
                ComposerKt.sourceInformation(composer, "363@17255L54,364@17351L48,365@17440L47,368@17601L738,383@18404L2135,366@17504L3096");
                Strings.Companion companion = Strings.INSTANCE;
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer, 0);
                Strings.Companion companion2 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer, 0);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1003500887, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean zChanged = composer.changed(sheetState) | composer.changedInstance(coroutineScope);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5$0$0$0(sheetState, coroutineScope);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM630clickableXHw0xAI$default = ClickableKt.m630clickableXHw0xAI$default(companion4, false, null, null, (Function0) objRememberedValue, 7, null);
                ComposerKt.sourceInformationMarkerStart(composer, -1003473794, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean zChanged2 = composer.changed(sheetState) | composer.changed(z) | composer.changed(strM5086getString2EP1pXo3) | composer.changedInstance(coroutineScope) | composer.changed(strM5086getString2EP1pXo) | composer.changed(strM5086getString2EP1pXo2);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5$0$1$0(sheetState, z, strM5086getString2EP1pXo3, strM5086getString2EP1pXo, strM5086getString2EP1pXo2, coroutineScope, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                    objRememberedValue2 = obj;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SheetDefaultsKt.DragHandleWithTooltip(SemanticsModifierKt.semantics(modifierM630clickableXHw0xAI$default, true, (Function1) objRememberedValue2), function2, composer, 0);
            }
            composer.endReplaceGroup();
            function3.invoke(columnScopeInstance, composer, 6);
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
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$5$0$0$0(SheetState sheetState, CoroutineScope coroutineScope) {
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
        if (i == 2) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2(sheetState, null), 3, null);
        } else if (i != 3) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$3(sheetState, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StandardBottomSheet_w7I5h1o$lambda$5$0$1$0(final SheetState sheetState, boolean z, String str, String str2, String str3, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (sheetState.getAnchoredDraggableState$material3().getAnchors().getSize() > 1 && z) {
            if (sheetState.getCurrentValue() == SheetValue.PartiallyExpanded) {
                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$0(sheetState, coroutineScope));
                    }
                });
            } else {
                SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$1(sheetState, coroutineScope));
                    }
                });
            }
            if (!sheetState.getSkipHiddenState()) {
                SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$2(sheetState, coroutineScope));
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$0(SheetState sheetState, CoroutineScope coroutineScope) {
        boolean zBooleanValue = sheetState.getConfirmValueChange$material3().invoke(SheetValue.Expanded).booleanValue();
        if (zBooleanValue) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$2$1$1$1$1(sheetState, null), 3, null);
        }
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$1(SheetState sheetState, CoroutineScope coroutineScope) {
        boolean zBooleanValue = sheetState.getConfirmValueChange$material3().invoke(SheetValue.PartiallyExpanded).booleanValue();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$2$1$1$2$1(sheetState, null), 3, null);
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StandardBottomSheet_w7I5h1o$lambda$5$0$1$0$0$2(SheetState sheetState, CoroutineScope coroutineScope) {
        boolean zBooleanValue = sheetState.getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$2$1$1$3$1(sheetState, null), 3, null);
        return zBooleanValue;
    }

    private static final void BottomSheetScaffoldLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function0<Float> function0, final SheetState sheetState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1217723575);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)N(topBar,body,bottomSheet,snackbarHost,sheetOffset,sheetState)437@21080L1942,435@20969L2053:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(sheetState) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1217723575, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:434)");
            }
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m3091getLambda$788244078$material3() : function2;
            function2Arr[1] = function3;
            function2Arr[2] = function4;
            function2Arr[3] = function5;
            List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001237473, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((458752 & i2) == 131072) | ((i2 & 57344) == 16384);
            BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetState, function0);
                composerStartRestartGroup.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicy);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffoldLayout$lambda$1(function2, function3, function4, function5, function0, sheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Modifier verticalScaleUp(Modifier modifier, final SheetState sheetState) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.verticalScaleUp$lambda$0(sheetState, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verticalScaleUp$lambda$0(SheetState sheetState, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fMinPosition = sheetState.getAnchoredDraggableState$material3().getAnchors().minPosition();
        float f = offset < fMinPosition ? fMinPosition - offset : 0.0f;
        graphicsLayerScope.setScaleY(f > 0.0f ? (Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)) + f) / Float.intBitsToFloat((int) (4294967295L & graphicsLayerScope.getSize())) : 1.0f);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0.0f));
        return Unit.INSTANCE;
    }

    public static final Modifier verticalScaleDown(Modifier modifier, final SheetState sheetState) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.verticalScaleDown$lambda$0(sheetState, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verticalScaleDown$lambda$0(SheetState sheetState, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fMinPosition = sheetState.getAnchoredDraggableState$material3().getAnchors().minPosition();
        float f = offset < fMinPosition ? fMinPosition - offset : 0.0f;
        graphicsLayerScope.setScaleY(f > 0.0f ? 1 / ((Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)) + f) / Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L))) : 1.0f);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0.0f));
        return Unit.INSTANCE;
    }
}
