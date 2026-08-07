package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u000223B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ#\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ%\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\rJ%\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J%\u0010 \u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\rJ\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001f\u0010#\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000$2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010&J\u001c\u0010#\u001a\u00060%R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0007JJ\u0010(\u001a\u00020)*\u00020)2\u0006\u0010*\u001a\u00020\u000126\u0010+\u001a2\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b\u000b\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b\u000b\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope;", "", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/MutableFloatState;)V", "customColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "customColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "customDistance", "Landroidx/compose/ui/unit/Dp;", "customDistance-chRvn1I", "(Ljava/lang/String;Ljava/lang/String;)F", "customFloat", "", "customFontSize", "Landroidx/compose/ui/unit/TextUnit;", "customFontSize-5XXgJZs", "customInt", "", "customProperties", "Landroidx/constraintlayout/compose/MotionLayoutScope$CustomProperties;", "motionColor", "motionColor-WaAFU9c", "motionDistance", "motionDistance-chRvn1I", "motionFloat", "motionFontSize", "motionFontSize-5XXgJZs", "motionInt", "motionProperties", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tag", "onStartEndBoundsChanged", "Landroidx/compose/ui/Modifier;", "layoutId", "onBoundsChanged", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "startBounds", "endBounds", "", "CustomProperties", "MotionProperties", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MotionLayoutScope {
    public static final int $stable = 8;
    private final MotionMeasurer measurer;
    private final MutableFloatState motionProgress;

    public MotionLayoutScope(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.measurer = motionMeasurer;
        this.motionProgress = mutableFloatState;
    }

    /* JADX INFO: compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0003J\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$CustomProperties;", "", "id", "", "(Landroidx/constraintlayout/compose/MotionLayoutScope;Ljava/lang/String;)V", "color", "Landroidx/compose/ui/graphics/Color;", "name", "color-vNxB06k", "(Ljava/lang/String;)J", "distance", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", TypedValues.Custom.S_FLOAT, "", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "int", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class CustomProperties {
        private final String id;

        public CustomProperties(String str) {
            this.id = str;
        }

        /* JADX INFO: renamed from: color-vNxB06k, reason: not valid java name */
        public final long m10112colorvNxB06k(String name) {
            return MotionLayoutScope.this.measurer.m10127getCustomColorXeAY9LY(this.id, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: float, reason: not valid java name */
        public final float m10114float(String name) {
            return MotionLayoutScope.this.measurer.getCustomFloat(this.id, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: int, reason: not valid java name */
        public final int m10116int(String name) {
            return (int) MotionLayoutScope.this.measurer.getCustomFloat(this.id, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: distance-u2uoSUM, reason: not valid java name */
        public final float m10113distanceu2uoSUM(String name) {
            return Dp.m9687constructorimpl(MotionLayoutScope.this.measurer.getCustomFloat(this.id, name, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }

        /* JADX INFO: renamed from: fontSize-kPz2Gy4, reason: not valid java name */
        public final long m10115fontSizekPz2Gy4(String name) {
            return TextUnitKt.getSp(MotionLayoutScope.this.measurer.getCustomFloat(this.id, name, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }
    }

    /* JADX INFO: compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0003J\u001b\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "", "id", "", "tag", "(Landroidx/constraintlayout/compose/MotionLayoutScope;Ljava/lang/String;Ljava/lang/String;)V", "myId", "myTag", "color", "Landroidx/compose/ui/graphics/Color;", "name", "color-vNxB06k", "(Ljava/lang/String;)J", "distance", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", TypedValues.Custom.S_FLOAT, "", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "int", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MotionProperties {
        private String myId;
        private String myTag;

        public MotionProperties(String str, String str2) {
            this.myId = str;
            this.myTag = str2;
        }

        /* JADX INFO: renamed from: id, reason: from getter */
        public final String getMyId() {
            return this.myId;
        }

        /* JADX INFO: renamed from: tag, reason: from getter */
        public final String getMyTag() {
            return this.myTag;
        }

        /* JADX INFO: renamed from: color-vNxB06k, reason: not valid java name */
        public final long m10117colorvNxB06k(String name) {
            return MotionLayoutScope.this.measurer.m10127getCustomColorXeAY9LY(this.myId, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: float, reason: not valid java name */
        public final float m10119float(String name) {
            return MotionLayoutScope.this.measurer.getCustomFloat(this.myId, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: int, reason: not valid java name */
        public final int m10121int(String name) {
            return (int) MotionLayoutScope.this.measurer.getCustomFloat(this.myId, name, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* JADX INFO: renamed from: distance-u2uoSUM, reason: not valid java name */
        public final float m10118distanceu2uoSUM(String name) {
            return Dp.m9687constructorimpl(MotionLayoutScope.this.measurer.getCustomFloat(this.myId, name, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }

        /* JADX INFO: renamed from: fontSize-kPz2Gy4, reason: not valid java name */
        public final long m10120fontSizekPz2Gy4(String name) {
            return TextUnitKt.getSp(MotionLayoutScope.this.measurer.getCustomFloat(this.myId, name, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }
    }

    @Deprecated(message = "Unnecessary composable, name is also inconsistent for custom properties", replaceWith = @ReplaceWith(expression = "customProperties(id)", imports = {}))
    public final androidx.compose.runtime.State<MotionProperties> motionProperties(String str, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1417298021, "C(motionProperties)871@35132L59:MotionLayout.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1417298021, i, -1, "androidx.constraintlayout.compose.MotionLayoutScope.motionProperties (MotionLayout.kt:871)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2036802948, "CC(remember):MotionLayout.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new MotionProperties(str, null), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customProperties(id)", imports = {}))
    public final MotionProperties motionProperties(String id, String tag) {
        return new MotionProperties(id, tag);
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customColor(id, name)", imports = {}))
    /* JADX INFO: renamed from: motionColor-WaAFU9c, reason: not valid java name */
    public final long m10109motionColorWaAFU9c(String id, String name) {
        return this.measurer.m10127getCustomColorXeAY9LY(id, name, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customFloat(id, name)", imports = {}))
    public final float motionFloat(String id, String name) {
        return this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customInt(id, name)", imports = {}))
    public final int motionInt(String id, String name) {
        return (int) this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customDistance(id, name)", imports = {}))
    /* JADX INFO: renamed from: motionDistance-chRvn1I, reason: not valid java name */
    public final float m10110motionDistancechRvn1I(String id, String name) {
        return Dp.m9687constructorimpl(this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue()));
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customFontSize(id, name)", imports = {}))
    /* JADX INFO: renamed from: motionFontSize-5XXgJZs, reason: not valid java name */
    public final long m10111motionFontSize5XXgJZs(String id, String name) {
        return TextUnitKt.getSp(this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue()));
    }

    public final CustomProperties customProperties(String id) {
        return new CustomProperties(id);
    }

    /* JADX INFO: renamed from: customColor-WaAFU9c, reason: not valid java name */
    public final long m10106customColorWaAFU9c(String id, String name) {
        return this.measurer.m10127getCustomColorXeAY9LY(id, name, this.motionProgress.getFloatValue());
    }

    public final float customFloat(String id, String name) {
        return this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue());
    }

    public final int customInt(String id, String name) {
        return (int) this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue());
    }

    /* JADX INFO: renamed from: customDistance-chRvn1I, reason: not valid java name */
    public final float m10107customDistancechRvn1I(String id, String name) {
        return Dp.m9687constructorimpl(this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue()));
    }

    /* JADX INFO: renamed from: customFontSize-5XXgJZs, reason: not valid java name */
    public final long m10108customFontSize5XXgJZs(String id, String name) {
        return TextUnitKt.getSp(this.measurer.getCustomFloat(id, name, this.motionProgress.getFloatValue()));
    }

    public final Modifier onStartEndBoundsChanged(Modifier modifier, final Object obj, final Function2<? super Rect, ? super Rect, Unit> function2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("onStartEndBoundsChanged");
                inspectorInfo.getProperties().set("layoutId", obj);
                inspectorInfo.getProperties().set("onBoundsChanged", function2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope.onStartEndBoundsChanged.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1096247907);
                ComposerKt.sourceInformation(composer, "C712@29032L42,715@29166L30,716@29230L52,719@29372L30,720@29434L52,724@29646L2269:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1096247907, i, -1, "androidx.constraintlayout.compose.MotionLayoutScope.onStartEndBoundsChanged.<anonymous> (MotionLayout.kt:712)");
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1528964744, "CC(remember):MotionLayout.kt#9igjgp");
                boolean zChanged = composer.changed(obj);
                Object obj2 = obj;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = obj2.toString();
                    composer.updateRememberedValue(objRememberedValue);
                }
                final String str = (String) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528960468, "CC(remember):MotionLayout.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                Object obj3 = objRememberedValue2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    int[] iArr = new int[4];
                    for (int i2 = 0; i2 < 4; i2++) {
                        iArr[i2] = 0;
                    }
                    composer.updateRememberedValue(iArr);
                    obj3 = iArr;
                }
                final int[] iArr2 = (int[]) obj3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528958398, "CC(remember):MotionLayout.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                Object obj4 = objRememberedValue3;
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    Ref ref = new Ref();
                    ref.setValue(Rect.INSTANCE.getZero());
                    composer.updateRememberedValue(ref);
                    obj4 = ref;
                }
                final Ref ref2 = (Ref) obj4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528953876, "CC(remember):MotionLayout.kt#9igjgp");
                Object objRememberedValue4 = composer.rememberedValue();
                Object obj5 = objRememberedValue4;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    int[] iArr3 = new int[4];
                    for (int i3 = 0; i3 < 4; i3++) {
                        iArr3[i3] = 0;
                    }
                    composer.updateRememberedValue(iArr3);
                    obj5 = iArr3;
                }
                final int[] iArr4 = (int[]) obj5;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528951870, "CC(remember):MotionLayout.kt#9igjgp");
                Object objRememberedValue5 = composer.rememberedValue();
                Object obj6 = objRememberedValue5;
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    Ref ref3 = new Ref();
                    ref3.setValue(Rect.INSTANCE.getZero());
                    composer.updateRememberedValue(ref3);
                    obj6 = ref3;
                }
                final Ref ref4 = (Ref) obj6;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528942869, "CC(remember):MotionLayout.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(this) | composer.changed(str) | composer.changedInstance(iArr2) | composer.changedInstance(ref2) | composer.changedInstance(iArr4) | composer.changedInstance(ref4) | composer.changed(function2);
                final MotionLayoutScope motionLayoutScope = this;
                final Function2<Rect, Rect, Unit> function3 = function2;
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            boolean z;
                            WidgetFrame start = motionLayoutScope.measurer.getTransition().getStart(str);
                            boolean z2 = true;
                            if (start.left == iArr2[0] && start.top == iArr2[1] && start.right == iArr2[2] && start.bottom == iArr2[3]) {
                                z = false;
                            } else {
                                iArr2[0] = start.left;
                                iArr2[1] = start.top;
                                iArr2[2] = start.right;
                                iArr2[3] = start.bottom;
                                Ref<Rect> ref5 = ref2;
                                int[] iArr5 = iArr2;
                                ref5.setValue(new Rect(iArr5[0], iArr5[1], iArr5[2], iArr5[3]));
                                z = true;
                            }
                            WidgetFrame end = motionLayoutScope.measurer.getTransition().getEnd(str);
                            if (end.left == iArr4[0] && end.top == iArr4[1] && end.right == iArr4[2] && end.bottom == iArr4[3]) {
                                z2 = z;
                            } else {
                                iArr4[0] = end.left;
                                iArr4[1] = end.top;
                                iArr4[2] = end.right;
                                iArr4[3] = end.bottom;
                                Ref<Rect> ref6 = ref4;
                                int[] iArr6 = iArr4;
                                ref6.setValue(new Rect(iArr6[0], iArr6[1], iArr6[2], iArr6[3]));
                            }
                            if (z2) {
                                Function2<Rect, Rect, Unit> function4 = function3;
                                Rect value = ref2.getValue();
                                if (value == null) {
                                    value = Rect.INSTANCE.getZero();
                                }
                                Rect value2 = ref4.getValue();
                                if (value2 == null) {
                                    value2 = Rect.INSTANCE.getZero();
                                }
                                function4.invoke(value, value2);
                            }
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierOnPlaced = OnPlacedModifierKt.onPlaced(modifier2, (Function1) objRememberedValue6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierOnPlaced;
            }
        });
    }
}
