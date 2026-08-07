package androidx.compose.material3;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: DragHandle.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragHandleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$10(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        VerticalDragHandle(modifier, dragHandleSizes, dragHandleColors, dragHandleShapes, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0142  */
    /* JADX WARN: Code duplicated, block: B:102:0x0152  */
    /* JADX WARN: Code duplicated, block: B:105:0x0177  */
    /* JADX WARN: Code duplicated, block: B:108:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:124:0x0204  */
    /* JADX WARN: Code duplicated, block: B:137:0x0244  */
    /* JADX WARN: Code duplicated, block: B:150:0x0284  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:155:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:158:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x0105  */
    /* JADX WARN: Code duplicated, block: B:92:0x0110  */
    /* JADX WARN: Code duplicated, block: B:95:0x011a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void VerticalDragHandle(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        DragHandleSizes dragHandleSizes2;
        final DragHandleColors dragHandleColorsColors;
        final DragHandleShapes dragHandleShapesShapes;
        MutableInteractionSource mutableInteractionSource2;
        boolean z;
        boolean z2;
        final DragHandleSizes dragHandleSizes3;
        final DragHandleColors dragHandleColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final DragHandleSizes dragHandleSizesSizes;
        MutableInteractionSource mutableInteractionSource4;
        final State<Boolean> stateCollectIsDraggedAsState;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        boolean zChanged;
        Object objRememberedValue4;
        boolean zChanged2;
        Object objRememberedValue5;
        boolean z3;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1693656835);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalDragHandle)N(modifier,sizes,colors,shapes,interactionSource)81@3988L25,82@4035L34,88@4262L20,88@4284L21,89@4338L307,98@4670L796,115@5495L299,83@4074L1783:DragHandle.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                dragHandleSizes2 = dragHandleSizes;
                int i5 = composerStartRestartGroup.changed(dragHandleSizes2) ? 32 : 16;
                i3 |= i5;
            } else {
                dragHandleSizes2 = dragHandleSizes;
            }
            i3 |= i5;
        } else {
            dragHandleSizes2 = dragHandleSizes;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                dragHandleColorsColors = dragHandleColors;
                int i6 = composerStartRestartGroup.changed(dragHandleColorsColors) ? 256 : 128;
                i3 |= i6;
            } else {
                dragHandleColorsColors = dragHandleColors;
            }
            i3 |= i6;
        } else {
            dragHandleColorsColors = dragHandleColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                dragHandleShapesShapes = dragHandleShapes;
                int i7 = composerStartRestartGroup.changed(dragHandleShapesShapes) ? 2048 : 1024;
                i3 |= i7;
            } else {
                dragHandleShapesShapes = dragHandleShapes;
            }
            i3 |= i7;
        } else {
            dragHandleShapesShapes = dragHandleShapes;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
            }
            z = true;
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3689L8,76@3757L8");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        dragHandleSizesSizes = VerticalDragHandleDefaults.INSTANCE.sizes();
                        i3 &= -113;
                    } else {
                        dragHandleSizesSizes = dragHandleSizes2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        dragHandleColorsColors = VerticalDragHandleDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        dragHandleShapesShapes = VerticalDragHandleDefaults.INSTANCE.shapes(composerStartRestartGroup, 6);
                    }
                    if (i8 != 0) {
                        mutableInteractionSource2 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = modifier2;
                    dragHandleSizesSizes = dragHandleSizes2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693656835, i3, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
                }
                if (mutableInteractionSource2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1544621928);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@3909L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188373846, "CC(remember):DragHandle.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-188374497);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                stateCollectIsDraggedAsState = DragInteractionKt.collectIsDraggedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188369819, "CC(remember):DragHandle.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier3 = companion;
                Modifier modifierHoverable$default = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), mutableInteractionSource4, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188362569, "CC(remember):DragHandle.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$5$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188361864, "CC(remember):DragHandle.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$6$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPressable = pressable(modifierHoverable$default, mutableInteractionSource4, function0, (Function0) objRememberedValue3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188359850, "CC(remember):DragHandle.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(dragHandleShapesShapes)) || (i3 & 3072) == 2048);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DragHandleKt.VerticalDragHandle$lambda$7$0(dragHandleShapesShapes, stateCollectIsDraggedAsState, mutableState, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierPressable, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188348737, "CC(remember):DragHandle.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(dragHandleSizesSizes)) || (i3 & 48) == 32);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function3() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return DragHandleKt.VerticalDragHandle$lambda$8$0(dragHandleSizesSizes, stateCollectIsDraggedAsState, mutableState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierLayout = LayoutModifierKt.layout(modifierGraphicsLayer, (Function3) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188322834, "CC(remember):DragHandle.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState);
                if ((((i3 & 896) ^ 384) > 256 || !composerStartRestartGroup.changed(dragHandleColorsColors)) && (i3 & 384) != 256) {
                }
                z3 = zChanged3 | z;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DragHandleKt.VerticalDragHandle$lambda$9$0(dragHandleColorsColors, stateCollectIsDraggedAsState, mutableState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(modifierLayout, (Function1) objRememberedValue6), mutableInteractionSource5, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dragHandleSizes3 = dragHandleSizesSizes;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                dragHandleSizes3 = dragHandleSizes2;
            }
            dragHandleColors2 = dragHandleColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier2;
                final DragHandleShapes dragHandleShapes2 = dragHandleShapesShapes;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DragHandleKt.VerticalDragHandle$lambda$10(modifier4, dragHandleSizes3, dragHandleColors2, dragHandleShapes2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        z = true;
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3689L8,76@3757L8");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    dragHandleSizesSizes = VerticalDragHandleDefaults.INSTANCE.sizes();
                    i3 &= -113;
                } else {
                    dragHandleSizesSizes = dragHandleSizes2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    dragHandleColorsColors = VerticalDragHandleDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    dragHandleShapesShapes = VerticalDragHandleDefaults.INSTANCE.shapes(composerStartRestartGroup, 6);
                }
                if (i8 != 0) {
                    mutableInteractionSource2 = null;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    dragHandleSizesSizes = VerticalDragHandleDefaults.INSTANCE.sizes();
                    i3 &= -113;
                } else {
                    dragHandleSizesSizes = dragHandleSizes2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    dragHandleColorsColors = VerticalDragHandleDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    dragHandleShapesShapes = VerticalDragHandleDefaults.INSTANCE.shapes(composerStartRestartGroup, 6);
                }
                if (i8 != 0) {
                    mutableInteractionSource2 = null;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1693656835, i3, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
            }
            if (mutableInteractionSource2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1544621928);
                ComposerKt.sourceInformation(composerStartRestartGroup, "80@3909L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188373846, "CC(remember):DragHandle.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-188374497);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource2;
            }
            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
            stateCollectIsDraggedAsState = DragInteractionKt.collectIsDraggedAsState(mutableInteractionSource6, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188369819, "CC(remember):DragHandle.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier5 = companion;
            Modifier modifierHoverable$default2 = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), mutableInteractionSource4, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188362569, "CC(remember):DragHandle.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DragHandleKt.VerticalDragHandle$lambda$5$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188361864, "CC(remember):DragHandle.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DragHandleKt.VerticalDragHandle$lambda$6$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPressable2 = pressable(modifierHoverable$default2, mutableInteractionSource4, function1, (Function0) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188359850, "CC(remember):DragHandle.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(dragHandleShapesShapes)) || (i3 & 3072) == 2048);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DragHandleKt.VerticalDragHandle$lambda$7$0(dragHandleShapesShapes, stateCollectIsDraggedAsState, mutableState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DragHandleKt.VerticalDragHandle$lambda$7$0(dragHandleShapesShapes, stateCollectIsDraggedAsState, mutableState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierPressable2, (Function1) objRememberedValue4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188348737, "CC(remember):DragHandle.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(dragHandleSizesSizes)) || (i3 & 48) == 32);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                objRememberedValue5 = new Function3() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DragHandleKt.VerticalDragHandle$lambda$8$0(dragHandleSizesSizes, stateCollectIsDraggedAsState, mutableState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function3() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DragHandleKt.VerticalDragHandle$lambda$8$0(dragHandleSizesSizes, stateCollectIsDraggedAsState, mutableState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout2 = LayoutModifierKt.layout(modifierGraphicsLayer2, (Function3) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188322834, "CC(remember):DragHandle.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState);
            z = ((i3 & 896) ^ 384) > 256 ? false : false;
            z3 = zChanged4 | z;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z3) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DragHandleKt.VerticalDragHandle$lambda$9$0(dragHandleColorsColors, stateCollectIsDraggedAsState, mutableState, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DragHandleKt.VerticalDragHandle$lambda$9$0(dragHandleColorsColors, stateCollectIsDraggedAsState, mutableState, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(modifierLayout2, (Function1) objRememberedValue6), mutableInteractionSource6, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dragHandleSizes3 = dragHandleSizesSizes;
            modifier2 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            dragHandleSizes3 = dragHandleSizes2;
        }
        dragHandleColors2 = dragHandleColorsColors;
        mutableInteractionSource3 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final DragHandleShapes dragHandleShapes3 = dragHandleShapesShapes;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DragHandleKt.VerticalDragHandle$lambda$10(modifier6, dragHandleSizes3, dragHandleColors2, dragHandleShapes3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerticalDragHandle$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$5$0(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$6$0(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$7$0(DragHandleShapes dragHandleShapes, State state, MutableState mutableState, GraphicsLayerScope graphicsLayerScope) {
        Shape pressedShape;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedShape = dragHandleShapes.getDraggedShape();
        } else {
            pressedShape = VerticalDragHandle$lambda$3(mutableState) ? dragHandleShapes.getPressedShape() : dragHandleShapes.getShape();
        }
        graphicsLayerScope.setShape(pressedShape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult VerticalDragHandle$lambda$8$0(DragHandleSizes dragHandleSizes, State state, MutableState mutableState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long pressedSize;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedSize = dragHandleSizes.getDraggedSize();
        } else {
            pressedSize = VerticalDragHandle$lambda$3(mutableState) ? dragHandleSizes.getPressedSize() : dragHandleSizes.getSize();
        }
        long j = measureScope.mo755toSizeXkaWNTQ(pressedSize);
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(Math.round(Float.intBitsToFloat((int) (j >> 32))), Math.round(Float.intBitsToFloat((int) (j & 4294967295L)))));
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragHandleKt.VerticalDragHandle$lambda$8$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$8$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$9$0(DragHandleColors dragHandleColors, State state, MutableState mutableState, DrawScope drawScope) {
        long pressedColor;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedColor = dragHandleColors.getDraggedColor();
        } else {
            pressedColor = VerticalDragHandle$lambda$3(mutableState) ? dragHandleColors.getPressedColor() : dragHandleColors.getColor();
        }
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, pressedColor, 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    private static final Modifier pressable(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mutableInteractionSource, new PointerInputEventHandler() { // from class: androidx.compose.material3.DragHandleKt.pressable.1

            /* JADX INFO: renamed from: androidx.compose.material3.DragHandleKt$pressable$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragHandle.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DragHandleKt$pressable$1$1", f = "DragHandle.kt", i = {0}, l = {341, 343}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
            static final class C00551 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onPressed;
                final /* synthetic */ Function0<Unit> $onReleasedOrCancelled;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00551(Function0<Unit> function0, Function0<Unit> function1, Continuation<? super C00551> continuation) {
                    super(2, continuation);
                    this.$onPressed = function0;
                    this.$onReleasedOrCancelled = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00551 c00551 = new C00551(this.$onPressed, this.$onReleasedOrCancelled, continuation);
                    c00551.L$0 = obj;
                    return c00551;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00551) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
                
                    if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, androidx.compose.ui.input.pointer.PointerEventPass.Initial, r10) == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L23
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L55
                    L12:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L1b:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3f
                    L23:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r8 = 1
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3e
                        goto L54
                    L3e:
                        r1 = r4
                    L3f:
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.$onPressed
                        r11.invoke()
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r10
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4 = 0
                        r10.L$0 = r4
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r11, r3)
                        if (r11 != r0) goto L55
                    L54:
                        return r0
                    L55:
                        kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r10.$onReleasedOrCancelled
                        r10.invoke()
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragHandleKt.AnonymousClass1.C00551.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00551(function0, function1, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    private static final boolean VerticalDragHandle$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
