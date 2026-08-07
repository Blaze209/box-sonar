package androidx.constraintlayout.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$1;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import androidx.constraintlayout.compose.carousel.FractionalThreshold;
import androidx.constraintlayout.compose.carousel.SwipeableDefaults;
import androidx.constraintlayout.compose.carousel.ThresholdConfig;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.modules.dialog.AlertFragment;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001af\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aP\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2(\b\u0004\u0010 \u001a\"\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010$\u001ao\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2G\b\u0004\u0010 \u001aA\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060'R\u00020(0\u001a¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010*¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"ItemHolder", "", "i", "", "slotPrefix", "", "showSlot", "", "function", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "MotionCarousel", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "initialSlotIndex", "numSlots", "backwardTransition", "forwardTransition", "showSlots", "content", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionCarouselScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/MotionScene;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberStateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionItemsProvider;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", AlertFragment.ARG_ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "itemContent", "Lkotlin/ParameterName;", "name", "item", "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "itemsWithProperties", "Lkotlin/Function2;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "properties", "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release", "componentWidth", "", "state", "Landroidx/constraintlayout/compose/CarouselState;", "currentIndex"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionCarouselKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:119:0x0213  */
    /* JADX WARN: Code duplicated, block: B:121:0x0225  */
    /* JADX WARN: Code duplicated, block: B:122:0x0246  */
    /* JADX WARN: Code duplicated, block: B:125:0x028b  */
    /* JADX WARN: Code duplicated, block: B:128:0x029c  */
    /* JADX WARN: Code duplicated, block: B:131:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:136:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:146:0x0349  */
    /* JADX WARN: Code duplicated, block: B:148:0x035b  */
    /* JADX WARN: Code duplicated, block: B:156:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:158:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:161:0x0418  */
    /* JADX WARN: Code duplicated, block: B:164:0x0455  */
    /* JADX WARN: Code duplicated, block: B:167:0x047d  */
    /* JADX WARN: Code duplicated, block: B:170:0x04da  */
    /* JADX WARN: Code duplicated, block: B:174:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0113  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118  */
    /* JADX WARN: Code duplicated, block: B:99:0x011e  */
    public static final void MotionCarousel(final MotionScene motionScene, final int i, final int i2, String str, String str2, String str3, boolean z, final Function1<? super MotionCarouselScope, Unit> function1, Composer composer, final int i3, final int i4) {
        MotionScene motionScene2;
        int i5;
        int i6;
        String str4;
        int i7;
        String str5;
        int i8;
        int i9;
        String str6;
        int i10;
        int i11;
        final boolean z2;
        int i12;
        int i13;
        final int i14;
        String str7;
        final String str8;
        final boolean z3;
        androidx.compose.runtime.State<MotionItemsProvider> stateRememberStateOfItemsProvider;
        Object objRememberedValue;
        final MutableFloatState mutableFloatState;
        String str9;
        CarouselSwipeableState carouselSwipeableStateRememberCarouselSwipeableState;
        float floatValue;
        Object objRememberedValue2;
        MutableState mutableState;
        Object objRememberedValue3;
        final MutableIntState mutableIntState;
        int i15;
        Map mapMapOf;
        Object objRememberedValue4;
        MutableState mutableState2;
        float f;
        CarouselSwipeableState carouselSwipeableState;
        androidx.compose.runtime.State<MotionItemsProvider> state;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object obj;
        final String str10;
        final String str11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1035994944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MotionCarousel)P(4,3,5!1,2,7,6)153@6669L37,155@6734L39,156@6799L47,159@6937L107,162@7069L33,177@7610L46,230@9571L49,215@8950L1326:MotionCarousel.kt#fysre8");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            motionScene2 = motionScene;
        } else {
            motionScene2 = motionScene;
            if ((i3 & 6) == 0) {
                i5 = (composerStartRestartGroup.changed(motionScene2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
            i6 = i2;
        } else {
            i6 = i2;
            if ((i3 & 384) == 0) {
                i5 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
            }
        }
        int i16 = i4 & 8;
        if (i16 == 0) {
            if ((i3 & 3072) == 0) {
                str4 = str;
                i5 |= composerStartRestartGroup.changed(str4) ? 2048 : 1024;
            }
            i7 = i4 & 16;
            if (i7 != 0) {
                if ((i3 & 24576) == 0) {
                    str5 = str2;
                    if (composerStartRestartGroup.changed(str5)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i5 |= i8;
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                    if ((196608 & i3) == 0) {
                        str6 = str3;
                        if (composerStartRestartGroup.changed(str6)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i5 |= i10;
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                        i5 |= 1572864;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(z2)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i5 |= i12;
                        }
                    }
                    if ((i4 & 128) != 0) {
                        i5 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i5 |= i13;
                    }
                    i14 = i5;
                    if ((4793491 & i14) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        if (i16 != 0) {
                            str7 = "backward";
                        } else {
                            str7 = str4;
                        }
                        if (i7 != 0) {
                            str5 = "forward";
                        }
                        if (i9 != 0) {
                            str8 = "slot";
                        } else {
                            str8 = str6;
                        }
                        if (i11 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                        }
                        stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableFloatState = (MutableFloatState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str9 = str5;
                        String str12 = str7;
                        carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                        floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        } else {
                            if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                                mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                            } else {
                                i15 = 2;
                                mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            Map map = mapMapOf;
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            mutableState2 = (MutableState) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (floatValue >= 0.0f && MotionCarousel$lambda$4(mutableState).getIndex() > 0) {
                                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.BACKWARD);
                                mutableState2.setValue(str12);
                                f = (-1) * floatValue;
                            } else {
                                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                                mutableState2.setValue(str9);
                                f = floatValue;
                            }
                            composerStartRestartGroup.startReplaceGroup(1162062662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                            } else {
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD && ((String) carouselSwipeableStateRememberCarouselSwipeableState.getCurrentValue()).equals(ES6Iterator.NEXT_METHOD)) {
                                    composerStartRestartGroup.startReplaceGroup(1664382685);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "193@8202L260,193@8181L281");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162069496, "CC(remember):MotionCarousel.kt#9igjgp");
                                    boolean zChanged = composerStartRestartGroup.changed(stateRememberStateOfItemsProvider) | composerStartRestartGroup.changed(carouselSwipeableStateRememberCarouselSwipeableState);
                                    MotionCarouselKt$MotionCarousel$1$1 motionCarouselKt$MotionCarousel$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged || motionCarouselKt$MotionCarousel$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        MotionCarouselKt$MotionCarousel$1$1 motionCarouselKt$MotionCarousel$1$1 = new MotionCarouselKt$MotionCarousel$1$1(stateRememberStateOfItemsProvider, carouselSwipeableStateRememberCarouselSwipeableState, "start", mutableState, null);
                                        state = stateRememberStateOfItemsProvider;
                                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                        motionCarouselKt$MotionCarousel$1$1RememberedValue = motionCarouselKt$MotionCarousel$1$1;
                                        composerStartRestartGroup.updateRememberedValue(motionCarouselKt$MotionCarousel$1$1RememberedValue);
                                    } else {
                                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                        state = stateRememberStateOfItemsProvider;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) motionCarouselKt$MotionCarousel$1$1RememberedValue, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                    state = stateRememberStateOfItemsProvider;
                                    mutableState = mutableState;
                                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD && ((String) carouselSwipeableState.getCurrentValue()).equals("previous")) {
                                        composerStartRestartGroup.startReplaceGroup(1664841950);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "204@8666L227,204@8645L248");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162084311, "CC(remember):MotionCarousel.kt#9igjgp");
                                        boolean zChanged2 = composerStartRestartGroup.changed(carouselSwipeableState);
                                        MotionCarouselKt$MotionCarousel$2$1 motionCarouselKt$MotionCarousel$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChanged2 || motionCarouselKt$MotionCarousel$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            motionCarouselKt$MotionCarousel$2$1RememberedValue = new MotionCarouselKt$MotionCarousel$2$1(carouselSwipeableState, r1, mutableState, null);
                                            composerStartRestartGroup.updateRememberedValue(motionCarouselKt$MotionCarousel$2$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) motionCarouselKt$MotionCarousel$2$1RememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1665103342);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                                mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            String str13 = (String) mutableState2.getValue();
                            Modifier modifierM10161carouselSwipeablepPrIpRY = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(String str14, String str15) {
                                    return new FractionalThreshold(0.3f);
                                }
                            }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                        m10088invokeozmzZPI(intSize.m9862unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final void m10088invokeozmzZPI(long j) {
                                        mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY, (Function1) objRememberedValue5);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                            int iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            final InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            final MutableState mutableState3 = (MutableState) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            obj = objRememberedValue7;
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                Ref ref = new Ref();
                                ref.setValue(CompositionSource.Unknown);
                                composerStartRestartGroup.updateRememberedValue(ref);
                                obj = ref;
                            }
                            final Ref ref2 = (Ref) obj;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final androidx.compose.runtime.State<MotionItemsProvider> state2 = state;
                            final int i17 = i6;
                            Function3<MotionLayoutScope, Composer, Integer, Unit> function3 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                    invoke(motionLayoutScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i18) {
                                    ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-23317463, i18, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                    }
                                    mutableState3.setValue(Unit.INSTANCE);
                                    if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                                        ref2.setValue(CompositionSource.Content);
                                    }
                                    composer2.startReplaceGroup(-1854403913);
                                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                    composer2.startReplaceGroup(1187106508);
                                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                    int i19 = 0;
                                    while (i19 < i17) {
                                        final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i19) - i;
                                        final boolean z4 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state2.getValue()).getItemsCount();
                                        String str14 = str8;
                                        boolean z5 = z3;
                                        final int i20 = i19;
                                        final androidx.compose.runtime.State state3 = state2;
                                        final String str15 = str8;
                                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i21) {
                                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                                if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                    }
                                                    if (z4) {
                                                        if (state3.getValue().hasItemsWithProperties()) {
                                                            composer3.startReplaceGroup(-2023112919);
                                                            ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                            state3.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str15 + i20, composer3, 0)).invoke(composer3, 0);
                                                            composer3.endReplaceGroup();
                                                        } else {
                                                            composer3.startReplaceGroup(-2022913031);
                                                            ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                            state3.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                            composer3.endReplaceGroup();
                                                        }
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54);
                                        int i21 = i14;
                                        MotionCarouselKt.ItemHolder(i20, str14, z5, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                        i19 = i20 + 1;
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            String str14 = str8;
                            boolean z4 = z3;
                            MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str13, 257, iM10045getNonebfy_xzQ, modifierOnSizeChanged, mutableState3, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z2 = z4;
                            str10 = str9;
                            str4 = str12;
                            str11 = str14;
                        }
                        i15 = 2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map2 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str15 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY2 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map2, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str16, String str17) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map2.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY2, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ2 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy2 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState4 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref3 = new Ref();
                            ref3.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref3);
                            obj = ref3;
                        }
                        final Ref ref4 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state3 = state;
                        final int i18 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function4 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i19) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i19, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState4.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy2.getOnObservedStateChange() == null && ref4.getValue() == CompositionSource.Unknown) {
                                    ref4.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i110 = 0;
                                while (i110 < i18) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i110) - i;
                                    final boolean z5 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state3.getValue()).getItemsCount();
                                    String str16 = str8;
                                    boolean z6 = z3;
                                    final int i20 = i110;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state4 = state3;
                                    final String str17 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z5) {
                                                    if (state4.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state4.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str17 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state4.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str16, z6, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i110 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str16 = str8;
                        boolean z5 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str15, 257, iM10045getNonebfy_xzQ2, modifierOnSizeChanged2, mutableState4, ref4, defaultInvalidationStrategy2, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z5;
                        str10 = str9;
                        str4 = str12;
                        str11 = str16;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        str10 = str5;
                        str11 = str6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final String str17 = str4;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i19) {
                                MotionCarouselKt.MotionCarousel(motionScene, i, i2, str17, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str6 = str3;
                i11 = i4 & 64;
                if (i11 != 0) {
                    i5 |= 1572864;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i5 |= i12;
                    }
                }
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i5 |= i13;
                }
                i14 = i5;
                if ((4793491 & i14) == 4793490) {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str18 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map3 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str19 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY3 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map3, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str110, String str111) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map3.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged3 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY3, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ3 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy3 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState5 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref5 = new Ref();
                            ref5.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref5);
                            obj = ref5;
                        }
                        final Ref ref6 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state4 = state;
                        final int i19 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function5 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i110) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i110, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState5.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy3.getOnObservedStateChange() == null && ref6.getValue() == CompositionSource.Unknown) {
                                    ref6.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i111 = 0;
                                while (i111 < i19) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i111) - i;
                                    final boolean z6 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state4.getValue()).getItemsCount();
                                    String str110 = str8;
                                    boolean z7 = z3;
                                    final int i20 = i111;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state5 = state4;
                                    final String str111 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z6) {
                                                    if (state5.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state5.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state5.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str110, z7, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i111 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str110 = str8;
                        boolean z6 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str19, 257, iM10045getNonebfy_xzQ3, modifierOnSizeChanged3, mutableState5, ref6, defaultInvalidationStrategy3, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function5, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z6;
                        str10 = str9;
                        str4 = str18;
                        str11 = str110;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map4 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str111 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY4 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map4, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str112, String str113) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map4.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged4 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY4, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ4 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy4 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState6 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref7 = new Ref();
                        ref7.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref7);
                        obj = ref7;
                    }
                    final Ref ref8 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state5 = state;
                    final int i110 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function6 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i111) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i111, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState6.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy4.getOnObservedStateChange() == null && ref8.getValue() == CompositionSource.Unknown) {
                                ref8.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i112 = 0;
                            while (i112 < i110) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i112) - i;
                                final boolean z7 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state5.getValue()).getItemsCount();
                                String str112 = str8;
                                boolean z8 = z3;
                                final int i20 = i112;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state6 = state5;
                                final String str113 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z7) {
                                                if (state6.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state6.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str113 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state6.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str112, z8, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i112 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str112 = str8;
                    boolean z7 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111, 257, iM10045getNonebfy_xzQ4, modifierOnSizeChanged4, mutableState6, ref8, defaultInvalidationStrategy4, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function6, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z7;
                    str10 = str9;
                    str4 = str18;
                    str11 = str112;
                } else {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str113 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map5 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str114 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY5 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map5, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str115, String str116) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map5.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged5 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY5, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ5 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy5 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState7 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref9 = new Ref();
                            ref9.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref9);
                            obj = ref9;
                        }
                        final Ref ref10 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state6 = state;
                        final int i111 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function7 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i112) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i112, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState7.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy5.getOnObservedStateChange() == null && ref10.getValue() == CompositionSource.Unknown) {
                                    ref10.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i113 = 0;
                                while (i113 < i111) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i113) - i;
                                    final boolean z8 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state6.getValue()).getItemsCount();
                                    String str115 = str8;
                                    boolean z9 = z3;
                                    final int i20 = i113;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state7 = state6;
                                    final String str116 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z8) {
                                                    if (state7.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state7.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str116 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state7.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str115, z9, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i113 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str115 = str8;
                        boolean z8 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str114, 257, iM10045getNonebfy_xzQ5, modifierOnSizeChanged5, mutableState7, ref10, defaultInvalidationStrategy5, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function7, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z8;
                        str10 = str9;
                        str4 = str113;
                        str11 = str115;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map6 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str116 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY6 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map6, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str117, String str118) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map6.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged6 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY6, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ6 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy6 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState8 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref11 = new Ref();
                        ref11.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref11);
                        obj = ref11;
                    }
                    final Ref ref12 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state7 = state;
                    final int i112 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function8 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i113) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i113, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState8.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy6.getOnObservedStateChange() == null && ref12.getValue() == CompositionSource.Unknown) {
                                ref12.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i114 = 0;
                            while (i114 < i112) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i114) - i;
                                final boolean z9 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state7.getValue()).getItemsCount();
                                String str117 = str8;
                                boolean z10 = z3;
                                final int i20 = i114;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state8 = state7;
                                final String str118 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z9) {
                                                if (state8.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state8.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str118 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state8.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str117, z10, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i114 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str117 = str8;
                    boolean z9 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str116, 257, iM10045getNonebfy_xzQ6, modifierOnSizeChanged6, mutableState8, ref12, defaultInvalidationStrategy6, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function8, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z9;
                    str10 = str9;
                    str4 = str113;
                    str11 = str117;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final String str118 = str4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            MotionCarouselKt.MotionCarousel(motionScene, i, i2, str118, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                        }
                    });
                }
            }
            i5 |= 24576;
            str5 = str2;
            i9 = i4 & 32;
            if (i9 != 0) {
                if ((196608 & i3) == 0) {
                    str6 = str3;
                    if (composerStartRestartGroup.changed(str6)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i5 |= i10;
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                    i5 |= 1572864;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i5 |= i12;
                    }
                }
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i5 |= i13;
                }
                i14 = i5;
                if ((4793491 & i14) == 4793490) {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str119 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map7 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str1110 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY7 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map7, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str1111, String str1112) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map7.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged7 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY7, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ7 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy7 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState9 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref13 = new Ref();
                            ref13.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref13);
                            obj = ref13;
                        }
                        final Ref ref14 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state8 = state;
                        final int i113 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function9 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i114) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i114, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState9.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy7.getOnObservedStateChange() == null && ref14.getValue() == CompositionSource.Unknown) {
                                    ref14.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i115 = 0;
                                while (i115 < i113) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i115) - i;
                                    final boolean z10 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state8.getValue()).getItemsCount();
                                    String str1111 = str8;
                                    boolean z11 = z3;
                                    final int i20 = i115;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state9 = state8;
                                    final String str1112 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z10) {
                                                    if (state9.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state9.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1112 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state9.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str1111, z11, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i115 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str1111 = str8;
                        boolean z10 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1110, 257, iM10045getNonebfy_xzQ7, modifierOnSizeChanged7, mutableState9, ref14, defaultInvalidationStrategy7, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function9, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z10;
                        str10 = str9;
                        str4 = str119;
                        str11 = str1111;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map8 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str1112 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY8 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map8, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str1113, String str1114) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map8.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged8 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY8, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ8 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy8 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState10 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref15 = new Ref();
                        ref15.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref15);
                        obj = ref15;
                    }
                    final Ref ref16 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state9 = state;
                    final int i114 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function10 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i115) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i115, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState10.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy8.getOnObservedStateChange() == null && ref16.getValue() == CompositionSource.Unknown) {
                                ref16.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i116 = 0;
                            while (i116 < i114) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i116) - i;
                                final boolean z11 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state9.getValue()).getItemsCount();
                                String str1113 = str8;
                                boolean z12 = z3;
                                final int i20 = i116;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state10 = state9;
                                final String str1114 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z11) {
                                                if (state10.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state10.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1114 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state10.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str1113, z12, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i116 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str1113 = str8;
                    boolean z11 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1112, 257, iM10045getNonebfy_xzQ8, modifierOnSizeChanged8, mutableState10, ref16, defaultInvalidationStrategy8, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function10, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z11;
                    str10 = str9;
                    str4 = str119;
                    str11 = str1113;
                } else {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str1114 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map9 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str1115 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY9 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map9, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str1116, String str1117) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map9.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged9 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY9, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ9 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy9 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState11 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref17 = new Ref();
                            ref17.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref17);
                            obj = ref17;
                        }
                        final Ref ref18 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state10 = state;
                        final int i115 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function11 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i116) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i116, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState11.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy9.getOnObservedStateChange() == null && ref18.getValue() == CompositionSource.Unknown) {
                                    ref18.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i117 = 0;
                                while (i117 < i115) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i117) - i;
                                    final boolean z12 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state10.getValue()).getItemsCount();
                                    String str1116 = str8;
                                    boolean z13 = z3;
                                    final int i20 = i117;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state11 = state10;
                                    final String str1117 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z12) {
                                                    if (state11.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state11.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1117 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state11.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str1116, z13, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i117 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str1116 = str8;
                        boolean z12 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1115, 257, iM10045getNonebfy_xzQ9, modifierOnSizeChanged9, mutableState11, ref18, defaultInvalidationStrategy9, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function11, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z12;
                        str10 = str9;
                        str4 = str1114;
                        str11 = str1116;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map10 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str1117 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY10 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map10, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str1118, String str1119) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map10.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged10 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY10, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ10 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy10 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState12 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref19 = new Ref();
                        ref19.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref19);
                        obj = ref19;
                    }
                    final Ref ref110 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state11 = state;
                    final int i116 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function12 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i117) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i117, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState12.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy10.getOnObservedStateChange() == null && ref110.getValue() == CompositionSource.Unknown) {
                                ref110.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i118 = 0;
                            while (i118 < i116) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i118) - i;
                                final boolean z13 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state11.getValue()).getItemsCount();
                                String str1118 = str8;
                                boolean z14 = z3;
                                final int i20 = i118;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state12 = state11;
                                final String str1119 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z13) {
                                                if (state12.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state12.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1119 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state12.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str1118, z14, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i118 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str1118 = str8;
                    boolean z13 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1117, 257, iM10045getNonebfy_xzQ10, modifierOnSizeChanged10, mutableState12, ref110, defaultInvalidationStrategy10, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function12, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z13;
                    str10 = str9;
                    str4 = str1114;
                    str11 = str1118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final String str1119 = str4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i117) {
                            MotionCarouselKt.MotionCarousel(motionScene, i, i2, str1119, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str6 = str3;
            i11 = i4 & 64;
            if (i11 != 0) {
                i5 |= 1572864;
                z2 = z;
            } else {
                z2 = z;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i5 |= i12;
                }
            }
            if ((i4 & 128) != 0) {
                i5 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i5;
            if ((4793491 & i14) == 4793490) {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str11110 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map11 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str11111 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY11 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map11, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str11112, String str11113) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map11.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged11 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY11, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ11 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy11 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState13 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref111 = new Ref();
                        ref111.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref111);
                        obj = ref111;
                    }
                    final Ref ref112 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state12 = state;
                    final int i117 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function13 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i118) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i118, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState13.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy11.getOnObservedStateChange() == null && ref112.getValue() == CompositionSource.Unknown) {
                                ref112.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i119 = 0;
                            while (i119 < i117) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i119) - i;
                                final boolean z14 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state12.getValue()).getItemsCount();
                                String str11112 = str8;
                                boolean z15 = z3;
                                final int i20 = i119;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state13 = state12;
                                final String str11113 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z14) {
                                                if (state13.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state13.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11113 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state13.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str11112, z15, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i119 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str11112 = str8;
                    boolean z14 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11111, 257, iM10045getNonebfy_xzQ11, modifierOnSizeChanged11, mutableState13, ref112, defaultInvalidationStrategy11, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function13, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z14;
                    str10 = str9;
                    str4 = str11110;
                    str11 = str11112;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map12 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str11113 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY12 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map12, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str11114, String str11115) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map12.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged12 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY12, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ12 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy12 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState14 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref113 = new Ref();
                    ref113.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref113);
                    obj = ref113;
                }
                final Ref ref114 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state13 = state;
                final int i118 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function14 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i119) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i119, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState14.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy12.getOnObservedStateChange() == null && ref114.getValue() == CompositionSource.Unknown) {
                            ref114.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i1110 = 0;
                        while (i1110 < i118) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1110) - i;
                            final boolean z15 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state13.getValue()).getItemsCount();
                            String str11114 = str8;
                            boolean z16 = z3;
                            final int i20 = i1110;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state14 = state13;
                            final String str11115 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z15) {
                                            if (state14.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state14.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11115 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state14.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str11114, z16, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i1110 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str11114 = str8;
                boolean z15 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11113, 257, iM10045getNonebfy_xzQ12, modifierOnSizeChanged12, mutableState14, ref114, defaultInvalidationStrategy12, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function14, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z15;
                str10 = str9;
                str4 = str11110;
                str11 = str11114;
            } else {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str11115 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map13 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str11116 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY13 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map13, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str11117, String str11118) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map13.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged13 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY13, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ13 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy13 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState15 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref115 = new Ref();
                        ref115.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref115);
                        obj = ref115;
                    }
                    final Ref ref116 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state14 = state;
                    final int i119 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function15 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1110) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i1110, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState15.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy13.getOnObservedStateChange() == null && ref116.getValue() == CompositionSource.Unknown) {
                                ref116.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i1111 = 0;
                            while (i1111 < i119) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1111) - i;
                                final boolean z16 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state14.getValue()).getItemsCount();
                                String str11117 = str8;
                                boolean z17 = z3;
                                final int i20 = i1111;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state15 = state14;
                                final String str11118 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z16) {
                                                if (state15.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state15.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11118 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state15.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str11117, z17, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i1111 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str11117 = str8;
                    boolean z16 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11116, 257, iM10045getNonebfy_xzQ13, modifierOnSizeChanged13, mutableState15, ref116, defaultInvalidationStrategy13, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function15, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z16;
                    str10 = str9;
                    str4 = str11115;
                    str11 = str11117;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map14 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str11118 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY14 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map14, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str11119, String str111110) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map14.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged14 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY14, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ14 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy14 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState16 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref117 = new Ref();
                    ref117.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref117);
                    obj = ref117;
                }
                final Ref ref118 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state15 = state;
                final int i1110 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function16 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1111) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i1111, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState16.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy14.getOnObservedStateChange() == null && ref118.getValue() == CompositionSource.Unknown) {
                            ref118.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i1112 = 0;
                        while (i1112 < i1110) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1112) - i;
                            final boolean z17 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state15.getValue()).getItemsCount();
                            String str11119 = str8;
                            boolean z18 = z3;
                            final int i20 = i1112;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state16 = state15;
                            final String str111110 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z17) {
                                            if (state16.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state16.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111110 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state16.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str11119, z18, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i1112 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str11119 = str8;
                boolean z17 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11118, 257, iM10045getNonebfy_xzQ14, modifierOnSizeChanged14, mutableState16, ref118, defaultInvalidationStrategy14, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function16, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z17;
                str10 = str9;
                str4 = str11115;
                str11 = str11119;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final String str11120 = str4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111) {
                        MotionCarouselKt.MotionCarousel(motionScene, i, i2, str11120, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                    }
                });
            }
        }
        i5 |= 3072;
        str4 = str;
        i7 = i4 & 16;
        if (i7 != 0) {
            if ((i3 & 24576) == 0) {
                str5 = str2;
                if (composerStartRestartGroup.changed(str5)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i5 |= i8;
            }
            i9 = i4 & 32;
            if (i9 != 0) {
                if ((196608 & i3) == 0) {
                    str6 = str3;
                    if (composerStartRestartGroup.changed(str6)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i5 |= i10;
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                    i5 |= 1572864;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i5 |= i12;
                    }
                }
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i5 |= i13;
                }
                i14 = i5;
                if ((4793491 & i14) == 4793490) {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str111110 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map15 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str111111 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY15 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map15, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str111112, String str111113) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map15.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged15 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY15, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ15 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy15 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState17 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref119 = new Ref();
                            ref119.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref119);
                            obj = ref119;
                        }
                        final Ref ref1110 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state16 = state;
                        final int i1111 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function17 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1112) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i1112, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState17.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy15.getOnObservedStateChange() == null && ref1110.getValue() == CompositionSource.Unknown) {
                                    ref1110.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i1113 = 0;
                                while (i1113 < i1111) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1113) - i;
                                    final boolean z18 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state16.getValue()).getItemsCount();
                                    String str111112 = str8;
                                    boolean z19 = z3;
                                    final int i20 = i1113;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state17 = state16;
                                    final String str111113 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z18) {
                                                    if (state17.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state17.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111113 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state17.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str111112, z19, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i1113 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str111112 = str8;
                        boolean z18 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111111, 257, iM10045getNonebfy_xzQ15, modifierOnSizeChanged15, mutableState17, ref1110, defaultInvalidationStrategy15, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function17, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z18;
                        str10 = str9;
                        str4 = str111110;
                        str11 = str111112;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map16 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str111113 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY16 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map16, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str111114, String str111115) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map16.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged16 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY16, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ16 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy16 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState18 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref1111 = new Ref();
                        ref1111.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref1111);
                        obj = ref1111;
                    }
                    final Ref ref1112 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state17 = state;
                    final int i1112 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function18 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1113) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i1113, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState18.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy16.getOnObservedStateChange() == null && ref1112.getValue() == CompositionSource.Unknown) {
                                ref1112.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i1114 = 0;
                            while (i1114 < i1112) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1114) - i;
                                final boolean z19 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state17.getValue()).getItemsCount();
                                String str111114 = str8;
                                boolean z110 = z3;
                                final int i20 = i1114;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state18 = state17;
                                final String str111115 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z19) {
                                                if (state18.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state18.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111115 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state18.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str111114, z110, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i1114 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str111114 = str8;
                    boolean z19 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111113, 257, iM10045getNonebfy_xzQ16, modifierOnSizeChanged16, mutableState18, ref1112, defaultInvalidationStrategy16, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function18, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z19;
                    str10 = str9;
                    str4 = str111110;
                    str11 = str111114;
                } else {
                    if (i16 != 0) {
                        str7 = "backward";
                    } else {
                        str7 = str4;
                    }
                    if (i7 != 0) {
                        str5 = "forward";
                    }
                    if (i9 != 0) {
                        str8 = "slot";
                    } else {
                        str8 = str6;
                    }
                    if (i11 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                    }
                    stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str9 = str5;
                    String str111115 = str7;
                    carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    } else {
                        if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            i15 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map17 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState2 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        } else {
                            MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState2.setValue(str9);
                            f = floatValue;
                        }
                        composerStartRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                                state = stateRememberStateOfItemsProvider;
                                mutableState = mutableState;
                                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1665103342);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        String str111116 = (String) mutableState2.getValue();
                        Modifier modifierM10161carouselSwipeablepPrIpRY17 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map17, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str111117, String str111118) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map17.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m10088invokeozmzZPI(intSize.m9862unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m10088invokeozmzZPI(long j) {
                                    mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged17 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY17, (Function1) objRememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                        int iM10045getNonebfy_xzQ17 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy17 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        final MutableState mutableState19 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue7;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Ref ref1113 = new Ref();
                            ref1113.setValue(CompositionSource.Unknown);
                            composerStartRestartGroup.updateRememberedValue(ref1113);
                            obj = ref1113;
                        }
                        final Ref ref1114 = (Ref) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final androidx.compose.runtime.State state18 = state;
                        final int i1113 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function19 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1114) {
                                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i1114, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                }
                                mutableState19.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy17.getOnObservedStateChange() == null && ref1114.getValue() == CompositionSource.Unknown) {
                                    ref1114.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i1115 = 0;
                                while (i1115 < i1113) {
                                    final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1115) - i;
                                    final boolean z110 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state18.getValue()).getItemsCount();
                                    String str111117 = str8;
                                    boolean z111 = z3;
                                    final int i20 = i1115;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state19 = state18;
                                    final String str111118 = str8;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i21) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z110) {
                                                    if (state19.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state19.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111118 + i20, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state19.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i21 = i14;
                                    MotionCarouselKt.ItemHolder(i20, str111117, z111, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                    i1115 = i20 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str111117 = str8;
                        boolean z110 = z3;
                        MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111116, 257, iM10045getNonebfy_xzQ17, modifierOnSizeChanged17, mutableState19, ref1114, defaultInvalidationStrategy17, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function19, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z2 = z110;
                        str10 = str9;
                        str4 = str111115;
                        str11 = str111117;
                    }
                    i15 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map18 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str111118 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY18 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map18, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str111119, String str1111110) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map18.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged18 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY18, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ18 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy18 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState110 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref1115 = new Ref();
                        ref1115.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref1115);
                        obj = ref1115;
                    }
                    final Ref ref1116 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state19 = state;
                    final int i1114 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function110 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1115) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i1115, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState110.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy18.getOnObservedStateChange() == null && ref1116.getValue() == CompositionSource.Unknown) {
                                ref1116.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i1116 = 0;
                            while (i1116 < i1114) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1116) - i;
                                final boolean z111 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state19.getValue()).getItemsCount();
                                String str111119 = str8;
                                boolean z112 = z3;
                                final int i20 = i1116;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state110 = state19;
                                final String str1111110 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z111) {
                                                if (state110.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state110.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1111110 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state110.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str111119, z112, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i1116 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str111119 = str8;
                    boolean z111 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111118, 257, iM10045getNonebfy_xzQ18, modifierOnSizeChanged18, mutableState110, ref1116, defaultInvalidationStrategy18, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function110, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z111;
                    str10 = str9;
                    str4 = str111115;
                    str11 = str111119;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final String str11121 = str4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1115) {
                            MotionCarouselKt.MotionCarousel(motionScene, i, i2, str11121, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str6 = str3;
            i11 = i4 & 64;
            if (i11 != 0) {
                i5 |= 1572864;
                z2 = z;
            } else {
                z2 = z;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i5 |= i12;
                }
            }
            if ((i4 & 128) != 0) {
                i5 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i5;
            if ((4793491 & i14) == 4793490) {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str1111110 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map19 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str1111111 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY19 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map19, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str1111112, String str1111113) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map19.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged19 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY19, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ19 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy19 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState111 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref1117 = new Ref();
                        ref1117.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref1117);
                        obj = ref1117;
                    }
                    final Ref ref1118 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state110 = state;
                    final int i1115 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function111 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1116) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i1116, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState111.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy19.getOnObservedStateChange() == null && ref1118.getValue() == CompositionSource.Unknown) {
                                ref1118.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i1117 = 0;
                            while (i1117 < i1115) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1117) - i;
                                final boolean z112 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state110.getValue()).getItemsCount();
                                String str1111112 = str8;
                                boolean z113 = z3;
                                final int i20 = i1117;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state111 = state110;
                                final String str1111113 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z112) {
                                                if (state111.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state111.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1111113 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state111.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str1111112, z113, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i1117 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str1111112 = str8;
                    boolean z112 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1111111, 257, iM10045getNonebfy_xzQ19, modifierOnSizeChanged19, mutableState111, ref1118, defaultInvalidationStrategy19, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function111, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z112;
                    str10 = str9;
                    str4 = str1111110;
                    str11 = str1111112;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map110 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str1111113 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY110 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map110, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str1111114, String str1111115) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map110.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged110 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY110, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ110 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy110 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState112 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref1119 = new Ref();
                    ref1119.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref1119);
                    obj = ref1119;
                }
                final Ref ref11110 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state111 = state;
                final int i1116 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function112 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1117) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i1117, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState112.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy110.getOnObservedStateChange() == null && ref11110.getValue() == CompositionSource.Unknown) {
                            ref11110.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i1118 = 0;
                        while (i1118 < i1116) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1118) - i;
                            final boolean z113 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state111.getValue()).getItemsCount();
                            String str1111114 = str8;
                            boolean z114 = z3;
                            final int i20 = i1118;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state112 = state111;
                            final String str1111115 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z113) {
                                            if (state112.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state112.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1111115 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state112.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str1111114, z114, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i1118 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str1111114 = str8;
                boolean z113 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1111113, 257, iM10045getNonebfy_xzQ110, modifierOnSizeChanged110, mutableState112, ref11110, defaultInvalidationStrategy110, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function112, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z113;
                str10 = str9;
                str4 = str1111110;
                str11 = str1111114;
            } else {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str1111115 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map111 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str1111116 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY111 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map111, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str1111117, String str1111118) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map111.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged111 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY111, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ111 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy111 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState113 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref11111 = new Ref();
                        ref11111.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref11111);
                        obj = ref11111;
                    }
                    final Ref ref11112 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state112 = state;
                    final int i1117 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function113 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1118) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i1118, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState113.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy111.getOnObservedStateChange() == null && ref11112.getValue() == CompositionSource.Unknown) {
                                ref11112.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i1119 = 0;
                            while (i1119 < i1117) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i1119) - i;
                                final boolean z114 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state112.getValue()).getItemsCount();
                                String str1111117 = str8;
                                boolean z115 = z3;
                                final int i20 = i1119;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state113 = state112;
                                final String str1111118 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z114) {
                                                if (state113.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state113.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1111118 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state113.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str1111117, z115, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i1119 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str1111117 = str8;
                    boolean z114 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1111116, 257, iM10045getNonebfy_xzQ111, modifierOnSizeChanged111, mutableState113, ref11112, defaultInvalidationStrategy111, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function113, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z114;
                    str10 = str9;
                    str4 = str1111115;
                    str11 = str1111117;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map112 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str1111118 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY112 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map112, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str1111119, String str11111110) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map112.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged112 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY112, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ112 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy112 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState114 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref11113 = new Ref();
                    ref11113.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref11113);
                    obj = ref11113;
                }
                final Ref ref11114 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state113 = state;
                final int i1118 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function114 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i1119) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i1119, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState114.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy112.getOnObservedStateChange() == null && ref11114.getValue() == CompositionSource.Unknown) {
                            ref11114.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i11110 = 0;
                        while (i11110 < i1118) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11110) - i;
                            final boolean z115 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state113.getValue()).getItemsCount();
                            String str1111119 = str8;
                            boolean z116 = z3;
                            final int i20 = i11110;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state114 = state113;
                            final String str11111110 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z115) {
                                            if (state114.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state114.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11111110 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state114.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str1111119, z116, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i11110 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str1111119 = str8;
                boolean z115 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str1111118, 257, iM10045getNonebfy_xzQ112, modifierOnSizeChanged112, mutableState114, ref11114, defaultInvalidationStrategy112, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function114, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z115;
                str10 = str9;
                str4 = str1111115;
                str11 = str1111119;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final String str11122 = str4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1119) {
                        MotionCarouselKt.MotionCarousel(motionScene, i, i2, str11122, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                    }
                });
            }
        }
        i5 |= 24576;
        str5 = str2;
        i9 = i4 & 32;
        if (i9 != 0) {
            if ((196608 & i3) == 0) {
                str6 = str3;
                if (composerStartRestartGroup.changed(str6)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i5 |= i10;
            }
            i11 = i4 & 64;
            if (i11 != 0) {
                i5 |= 1572864;
                z2 = z;
            } else {
                z2 = z;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i5 |= i12;
                }
            }
            if ((i4 & 128) != 0) {
                i5 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i5;
            if ((4793491 & i14) == 4793490) {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str11111110 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map113 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str11111111 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY113 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map113, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str11111112, String str11111113) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map113.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged113 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY113, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ113 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy113 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState115 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref11115 = new Ref();
                        ref11115.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref11115);
                        obj = ref11115;
                    }
                    final Ref ref11116 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state114 = state;
                    final int i1119 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function115 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11110) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i11110, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState115.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy113.getOnObservedStateChange() == null && ref11116.getValue() == CompositionSource.Unknown) {
                                ref11116.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i11111 = 0;
                            while (i11111 < i1119) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11111) - i;
                                final boolean z116 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state114.getValue()).getItemsCount();
                                String str11111112 = str8;
                                boolean z117 = z3;
                                final int i20 = i11111;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state115 = state114;
                                final String str11111113 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z116) {
                                                if (state115.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state115.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11111113 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state115.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str11111112, z117, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i11111 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str11111112 = str8;
                    boolean z116 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11111111, 257, iM10045getNonebfy_xzQ113, modifierOnSizeChanged113, mutableState115, ref11116, defaultInvalidationStrategy113, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function115, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z116;
                    str10 = str9;
                    str4 = str11111110;
                    str11 = str11111112;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map114 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str11111113 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY114 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map114, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str11111114, String str11111115) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map114.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged114 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY114, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ114 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy114 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState116 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref11117 = new Ref();
                    ref11117.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref11117);
                    obj = ref11117;
                }
                final Ref ref11118 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state115 = state;
                final int i11110 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function116 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11111) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i11111, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState116.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy114.getOnObservedStateChange() == null && ref11118.getValue() == CompositionSource.Unknown) {
                            ref11118.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i11112 = 0;
                        while (i11112 < i11110) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11112) - i;
                            final boolean z117 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state115.getValue()).getItemsCount();
                            String str11111114 = str8;
                            boolean z118 = z3;
                            final int i20 = i11112;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state116 = state115;
                            final String str11111115 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z117) {
                                            if (state116.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state116.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11111115 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state116.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str11111114, z118, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i11112 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str11111114 = str8;
                boolean z117 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11111113, 257, iM10045getNonebfy_xzQ114, modifierOnSizeChanged114, mutableState116, ref11118, defaultInvalidationStrategy114, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function116, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z117;
                str10 = str9;
                str4 = str11111110;
                str11 = str11111114;
            } else {
                if (i16 != 0) {
                    str7 = "backward";
                } else {
                    str7 = str4;
                }
                if (i7 != 0) {
                    str5 = "forward";
                }
                if (i9 != 0) {
                    str8 = "slot";
                } else {
                    str8 = str6;
                }
                if (i11 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                }
                stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str9 = str5;
                String str11111115 = str7;
                carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                } else {
                    if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                    } else {
                        i15 = 2;
                        mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map115 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    } else {
                        MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState2.setValue(str9);
                        f = floatValue;
                    }
                    composerStartRestartGroup.startReplaceGroup(1162062662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                            state = stateRememberStateOfItemsProvider;
                            mutableState = mutableState;
                            if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1665103342);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    String str11111116 = (String) mutableState2.getValue();
                    Modifier modifierM10161carouselSwipeablepPrIpRY115 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map115, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(String str11111117, String str11111118) {
                            return new FractionalThreshold(0.3f);
                        }
                    }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map115.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                m10088invokeozmzZPI(intSize.m9862unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m10088invokeozmzZPI(long j) {
                                mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged115 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY115, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                    int iM10045getNonebfy_xzQ115 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    final InvalidationStrategy defaultInvalidationStrategy115 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    final MutableState mutableState117 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue7;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        Ref ref11119 = new Ref();
                        ref11119.setValue(CompositionSource.Unknown);
                        composerStartRestartGroup.updateRememberedValue(ref11119);
                        obj = ref11119;
                    }
                    final Ref ref111110 = (Ref) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final androidx.compose.runtime.State state116 = state;
                    final int i11111 = i6;
                    Function3<MotionLayoutScope, Composer, Integer, Unit> function117 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                            invoke(motionLayoutScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11112) {
                            ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-23317463, i11112, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                            }
                            mutableState117.setValue(Unit.INSTANCE);
                            if (defaultInvalidationStrategy115.getOnObservedStateChange() == null && ref111110.getValue() == CompositionSource.Unknown) {
                                ref111110.setValue(CompositionSource.Content);
                            }
                            composer2.startReplaceGroup(-1854403913);
                            ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                            composer2.startReplaceGroup(1187106508);
                            ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                            int i11113 = 0;
                            while (i11113 < i11111) {
                                final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11113) - i;
                                final boolean z118 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state116.getValue()).getItemsCount();
                                String str11111117 = str8;
                                boolean z119 = z3;
                                final int i20 = i11113;
                                final androidx.compose.runtime.State<? extends MotionItemsProvider> state117 = state116;
                                final String str11111118 = str8;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                            }
                                            if (z118) {
                                                if (state117.getValue().hasItemsWithProperties()) {
                                                    composer3.startReplaceGroup(-2023112919);
                                                    ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                    state117.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str11111118 + i20, composer3, 0)).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                } else {
                                                    composer3.startReplaceGroup(-2022913031);
                                                    ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                    state117.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                    composer3.endReplaceGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                                int i21 = i14;
                                MotionCarouselKt.ItemHolder(i20, str11111117, z119, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                                i11113 = i20 + 1;
                            }
                            composer2.endReplaceGroup();
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    String str11111117 = str8;
                    boolean z118 = z3;
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11111116, 257, iM10045getNonebfy_xzQ115, modifierOnSizeChanged115, mutableState117, ref111110, defaultInvalidationStrategy115, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function117, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z2 = z118;
                    str10 = str9;
                    str4 = str11111115;
                    str11 = str11111117;
                }
                i15 = 2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map116 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str11111118 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY116 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map116, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str11111119, String str111111110) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map116.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged116 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY116, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ116 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy116 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState118 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref111111 = new Ref();
                    ref111111.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref111111);
                    obj = ref111111;
                }
                final Ref ref111112 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state117 = state;
                final int i11112 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function118 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11113) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i11113, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState118.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy116.getOnObservedStateChange() == null && ref111112.getValue() == CompositionSource.Unknown) {
                            ref111112.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i11114 = 0;
                        while (i11114 < i11112) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11114) - i;
                            final boolean z119 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state117.getValue()).getItemsCount();
                            String str11111119 = str8;
                            boolean z1110 = z3;
                            final int i20 = i11114;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state118 = state117;
                            final String str111111110 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z119) {
                                            if (state118.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state118.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111111110 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state118.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str11111119, z1110, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i11114 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str11111119 = str8;
                boolean z119 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str11111118, 257, iM10045getNonebfy_xzQ116, modifierOnSizeChanged116, mutableState118, ref111112, defaultInvalidationStrategy116, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function118, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z119;
                str10 = str9;
                str4 = str11111115;
                str11 = str11111119;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final String str11123 = str4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11113) {
                        MotionCarouselKt.MotionCarousel(motionScene, i, i2, str11123, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str6 = str3;
        i11 = i4 & 64;
        if (i11 != 0) {
            i5 |= 1572864;
            z2 = z;
        } else {
            z2 = z;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i5 |= i12;
            }
        }
        if ((i4 & 128) != 0) {
            i5 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i5 |= i13;
        }
        i14 = i5;
        if ((4793491 & i14) == 4793490) {
            if (i16 != 0) {
                str7 = "backward";
            } else {
                str7 = str4;
            }
            if (i7 != 0) {
                str5 = "forward";
            }
            if (i9 != 0) {
                str8 = "slot";
            } else {
                str8 = str6;
            }
            if (i11 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
            }
            stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableFloatState = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            str9 = str5;
            String str111111110 = str7;
            carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
            floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableIntState = (MutableIntState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
            } else {
                if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                } else {
                    i15 = 2;
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map117 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str111111111 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY117 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map117, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str111111112, String str111111113) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map117.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged117 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY117, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ117 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy117 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState119 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref111113 = new Ref();
                    ref111113.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref111113);
                    obj = ref111113;
                }
                final Ref ref111114 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state118 = state;
                final int i11113 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function119 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11114) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i11114, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState119.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy117.getOnObservedStateChange() == null && ref111114.getValue() == CompositionSource.Unknown) {
                            ref111114.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i11115 = 0;
                        while (i11115 < i11113) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11115) - i;
                            final boolean z1110 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state118.getValue()).getItemsCount();
                            String str111111112 = str8;
                            boolean z1111 = z3;
                            final int i20 = i11115;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state119 = state118;
                            final String str111111113 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z1110) {
                                            if (state119.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state119.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111111113 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state119.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str111111112, z1111, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i11115 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str111111112 = str8;
                boolean z1110 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111111111, 257, iM10045getNonebfy_xzQ117, modifierOnSizeChanged117, mutableState119, ref111114, defaultInvalidationStrategy117, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function119, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z1110;
                str10 = str9;
                str4 = str111111110;
                str11 = str111111112;
            }
            i15 = 2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            Map map118 = mapMapOf;
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (floatValue >= 0.0f) {
                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                mutableState2.setValue(str9);
                f = floatValue;
            } else {
                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                mutableState2.setValue(str9);
                f = floatValue;
            }
            composerStartRestartGroup.startReplaceGroup(1162062662);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                    mutableState = mutableState;
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                    mutableState = mutableState;
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
            } else {
                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                state = stateRememberStateOfItemsProvider;
            }
            composerStartRestartGroup.endReplaceGroup();
            String str111111113 = (String) mutableState2.getValue();
            Modifier modifierM10161carouselSwipeablepPrIpRY118 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map118, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                @Override // kotlin.jvm.functions.Function2
                public final ThresholdConfig invoke(String str111111114, String str111111115) {
                    return new FractionalThreshold(0.3f);
                }
            }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map118.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m10088invokeozmzZPI(intSize.m9862unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m10088invokeozmzZPI(long j) {
                        mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged118 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY118, (Function1) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
            int iM10045getNonebfy_xzQ118 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            final InvalidationStrategy defaultInvalidationStrategy118 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState1110 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue7;
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Ref ref111115 = new Ref();
                ref111115.setValue(CompositionSource.Unknown);
                composerStartRestartGroup.updateRememberedValue(ref111115);
                obj = ref111115;
            }
            final Ref ref111116 = (Ref) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final androidx.compose.runtime.State state119 = state;
            final int i11114 = i6;
            Function3<MotionLayoutScope, Composer, Integer, Unit> function1110 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                    invoke(motionLayoutScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11115) {
                    ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-23317463, i11115, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                    }
                    mutableState1110.setValue(Unit.INSTANCE);
                    if (defaultInvalidationStrategy118.getOnObservedStateChange() == null && ref111116.getValue() == CompositionSource.Unknown) {
                        ref111116.setValue(CompositionSource.Content);
                    }
                    composer2.startReplaceGroup(-1854403913);
                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                    composer2.startReplaceGroup(1187106508);
                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                    int i11116 = 0;
                    while (i11116 < i11114) {
                        final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11116) - i;
                        final boolean z1111 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state119.getValue()).getItemsCount();
                        String str111111114 = str8;
                        boolean z1112 = z3;
                        final int i20 = i11116;
                        final androidx.compose.runtime.State<? extends MotionItemsProvider> state1110 = state119;
                        final String str111111115 = str8;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i21) {
                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                    }
                                    if (z1111) {
                                        if (state1110.getValue().hasItemsWithProperties()) {
                                            composer3.startReplaceGroup(-2023112919);
                                            ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                            state1110.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111111115 + i20, composer3, 0)).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(-2022913031);
                                            ComposerKt.sourceInformation(composer3, "241@10198L8");
                                            state1110.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54);
                        int i21 = i14;
                        MotionCarouselKt.ItemHolder(i20, str111111114, z1112, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                        i11116 = i20 + 1;
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            };
            String str111111114 = str8;
            boolean z1111 = z3;
            MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111111113, 257, iM10045getNonebfy_xzQ118, modifierOnSizeChanged118, mutableState1110, ref111116, defaultInvalidationStrategy118, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function1110, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z1111;
            str10 = str9;
            str4 = str111111110;
            str11 = str111111114;
        } else {
            if (i16 != 0) {
                str7 = "backward";
            } else {
                str7 = str4;
            }
            if (i7 != 0) {
                str5 = "forward";
            }
            if (i9 != 0) {
                str8 = "slot";
            } else {
                str8 = str6;
            }
            if (i11 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1035994944, i14, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
            }
            stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i14 >> 21) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableFloatState = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            str9 = str5;
            String str111111115 = str7;
            carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
            floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableIntState = (MutableIntState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (MotionCarousel$lambda$7(mutableIntState) == 0) {
                mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
            } else {
                if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                } else {
                    i15 = 2;
                    mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), ES6Iterator.NEXT_METHOD));
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                Map map119 = mapMapOf;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (floatValue >= 0.0f) {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                } else {
                    MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                    mutableState2.setValue(str9);
                    f = floatValue;
                }
                composerStartRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                        state = stateRememberStateOfItemsProvider;
                        mutableState = mutableState;
                        if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1665103342);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                }
                composerStartRestartGroup.endReplaceGroup();
                String str111111116 = (String) mutableState2.getValue();
                Modifier modifierM10161carouselSwipeablepPrIpRY119 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map119, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str111111117, String str111111118) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map119.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m10088invokeozmzZPI(intSize.m9862unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m10088invokeozmzZPI(long j) {
                            mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged119 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY119, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                int iM10045getNonebfy_xzQ119 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy119 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState1111 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue7;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    Ref ref111117 = new Ref();
                    ref111117.setValue(CompositionSource.Unknown);
                    composerStartRestartGroup.updateRememberedValue(ref111117);
                    obj = ref111117;
                }
                final Ref ref111118 = (Ref) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final androidx.compose.runtime.State state1110 = state;
                final int i11115 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function1111 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11116) {
                        ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i11116, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                        }
                        mutableState1111.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy119.getOnObservedStateChange() == null && ref111118.getValue() == CompositionSource.Unknown) {
                            ref111118.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i11117 = 0;
                        while (i11117 < i11115) {
                            final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11117) - i;
                            final boolean z1112 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state1110.getValue()).getItemsCount();
                            String str111111117 = str8;
                            boolean z1113 = z3;
                            final int i20 = i11117;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state1111 = state1110;
                            final String str111111118 = str8;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z1112) {
                                            if (state1111.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state1111.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str111111118 + i20, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state1111.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i21 = i14;
                            MotionCarouselKt.ItemHolder(i20, str111111117, z1113, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                            i11117 = i20 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str111111117 = str8;
                boolean z1112 = z3;
                MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111111116, 257, iM10045getNonebfy_xzQ119, modifierOnSizeChanged119, mutableState1111, ref111118, defaultInvalidationStrategy119, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function1111, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z1112;
                str10 = str9;
                str4 = str111111115;
                str11 = str111111117;
            }
            i15 = 2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            Map map1110 = mapMapOf;
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i15, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (floatValue >= 0.0f) {
                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                mutableState2.setValue(str9);
                f = floatValue;
            } else {
                MotionCarousel$lambda$4(mutableState).setDirection(MotionCarouselDirection.FORWARD);
                mutableState2.setValue(str9);
                f = floatValue;
            }
            composerStartRestartGroup.startReplaceGroup(1162062662);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.FORWARD) {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                    mutableState = mutableState;
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                    state = stateRememberStateOfItemsProvider;
                    mutableState = mutableState;
                    if (MotionCarousel$lambda$4(mutableState).getDirection() != MotionCarouselDirection.BACKWARD) {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1665103342);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState).getIndex());
            } else {
                carouselSwipeableState = carouselSwipeableStateRememberCarouselSwipeableState;
                state = stateRememberStateOfItemsProvider;
            }
            composerStartRestartGroup.endReplaceGroup();
            String str111111118 = (String) mutableState2.getValue();
            Modifier modifierM10161carouselSwipeablepPrIpRY1110 = CarouselSwipeableKt.m10161carouselSwipeablepPrIpRY(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map1110, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                @Override // kotlin.jvm.functions.Function2
                public final ThresholdConfig invoke(String str111111119, String str1111111110) {
                    return new FractionalThreshold(0.3f);
                }
            }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map1110.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m10166getVelocityThresholdD9Ej5fM() : 0.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m10088invokeozmzZPI(intSize.m9862unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m10088invokeozmzZPI(long j) {
                        mutableFloatState.setFloatValue(IntSize.m9858getWidthimpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged1110 = OnRemeasuredModifierKt.onSizeChanged(modifierM10161carouselSwipeablepPrIpRY1110, (Function1) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
            int iM10045getNonebfy_xzQ1110 = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            final InvalidationStrategy defaultInvalidationStrategy1110 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState1112 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue7;
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Ref ref111119 = new Ref();
                ref111119.setValue(CompositionSource.Unknown);
                composerStartRestartGroup.updateRememberedValue(ref111119);
                obj = ref111119;
            }
            final Ref ref1111110 = (Ref) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final androidx.compose.runtime.State state1111 = state;
            final int i11116 = i6;
            Function3<MotionLayoutScope, Composer, Integer, Unit> function1112 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                    invoke(motionLayoutScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i11117) {
                    ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-23317463, i11117, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                    }
                    mutableState1112.setValue(Unit.INSTANCE);
                    if (defaultInvalidationStrategy1110.getOnObservedStateChange() == null && ref1111110.getValue() == CompositionSource.Unknown) {
                        ref1111110.setValue(CompositionSource.Content);
                    }
                    composer2.startReplaceGroup(-1854403913);
                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                    composer2.startReplaceGroup(1187106508);
                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                    int i11118 = 0;
                    while (i11118 < i11116) {
                        final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i11118) - i;
                        final boolean z1113 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state1111.getValue()).getItemsCount();
                        String str111111119 = str8;
                        boolean z1114 = z3;
                        final int i20 = i11118;
                        final androidx.compose.runtime.State<? extends MotionItemsProvider> state1112 = state1111;
                        final String str1111111110 = str8;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i21) {
                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2020349941, i21, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                    }
                                    if (z1113) {
                                        if (state1112.getValue().hasItemsWithProperties()) {
                                            composer3.startReplaceGroup(-2023112919);
                                            ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                            state1112.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str1111111110 + i20, composer3, 0)).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(-2022913031);
                                            ComposerKt.sourceInformation(composer3, "241@10198L8");
                                            state1112.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54);
                        int i21 = i14;
                        MotionCarouselKt.ItemHolder(i20, str111111119, z1114, composableLambdaRememberComposableLambda, composer2, ((i21 >> 12) & 896) | ((i21 >> 12) & 112) | 3072);
                        i11118 = i20 + 1;
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            };
            String str111111119 = str8;
            boolean z1113 = z3;
            MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene2, f, str111111118, 257, iM10045getNonebfy_xzQ1110, modifierOnSizeChanged1110, mutableState1112, ref1111110, defaultInvalidationStrategy1110, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function1112, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i14 & 14) | (Ref.$stable << 21));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z1113;
            str10 = str9;
            str4 = str111111115;
            str11 = str111111119;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str11124 = str4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11117) {
                    MotionCarouselKt.MotionCarousel(motionScene, i, i2, str11124, str10, str11, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                }
            });
        }
    }

    private static final float MotionCarousel$lambda$1(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarouselState MotionCarousel$lambda$4(MutableState<CarouselState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MotionCarousel$lambda$7(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final void ItemHolder(final int i, final String str, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1970516035);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemHolder)P(1,3,2)259@10665L83:MotionCarousel.kt#fysre8");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970516035, i3, -1, "androidx.constraintlayout.compose.ItemHolder (MotionCarousel.kt:250)");
            }
            Modifier modifierLayoutId$default = ConstraintLayoutTagKt.layoutId$default(Modifier.INSTANCE, str + i, null, 2, null);
            if (z) {
                float f = 20;
                modifierLayoutId$default = BorderKt.m604borderxT4_qwU(ClipKt.clip(modifierLayoutId$default, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), Dp.m9687constructorimpl(2), ColorKt.Color(0, 0, 0, 60), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f)));
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1063080426, "C259@10738L8:MotionCarousel.kt#fysre8");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.ItemHolder.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    MotionCarouselKt.ItemHolder(i, str, z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final <T> void items(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        motionCarouselScope.items(list.size(), ComposableLambdaKt.composableLambdaInstance(85623574, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.items.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer, Integer num2) {
                invoke(num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(int i, Composer composer, int i2) {
                ComposerKt.sourceInformation(composer, "C278@11161L25:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i2 |= composer.changed(i) ? 4 : 2;
                }
                if ((i2 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(85623574, i2, -1, "androidx.constraintlayout.compose.items.<anonymous> (MotionCarousel.kt:278)");
                }
                function3.invoke((T) list.get(i), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final <T> void itemsWithProperties(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function4<? super T, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> function4) {
        motionCarouselScope.itemsWithProperties(list.size(), ComposableLambdaKt.composableLambdaInstance(1304172608, true, new Function4<Integer, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties>, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.itemsWithProperties.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties> state, Composer composer, Integer num2) {
                invoke(num.intValue(), (androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>) state, composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(int i, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties> state, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C302@11988L37:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(i) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(state) ? 32 : 16;
                }
                if ((i3 & Token.DOTQUERY) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1304172608, i3, -1, "androidx.constraintlayout.compose.itemsWithProperties.<anonymous> (MotionCarousel.kt:302)");
                }
                function4.invoke((T) list.get(i), state, composer, Integer.valueOf(i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    private static final androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider(Function1<? super MotionCarouselScope, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1507876322, "C(rememberStateOfItemsProvider)308@12208L29,309@12249L84:MotionCarousel.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507876322, i, -1, "androidx.constraintlayout.compose.rememberStateOfItemsProvider (MotionCarousel.kt:307)");
        }
        final androidx.compose.runtime.State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1350480360, "CC(remember):MotionCarousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<MotionCarouselScopeImpl>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$rememberStateOfItemsProvider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MotionCarouselScopeImpl invoke() {
                    MotionCarouselScopeImpl motionCarouselScopeImpl = new MotionCarouselScopeImpl();
                    stateRememberUpdatedState.getValue().invoke(motionCarouselScopeImpl);
                    return motionCarouselScopeImpl;
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        androidx.compose.runtime.State<MotionItemsProvider> state = (androidx.compose.runtime.State) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }
}
