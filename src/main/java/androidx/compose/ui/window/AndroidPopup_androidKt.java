package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001a \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002\u001a(\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u001b2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\"\u001a+\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0013\b\b\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0083\b¢\u0006\u0002\u0010&\u001a\f\u0010'\u001a\u00020\u0015*\u00020(H\u0000\u001a\u0014\u0010)\u001a\u00020\u0012*\u00020\t2\u0006\u0010*\u001a\u00020\u0015H\u0002\u001a\f\u0010+\u001a\u00020,*\u00020-H\u0002\u001a\u001c\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001bH\u0007\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u00061²\u0006\u0015\u00102\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bX\u008a\u0084\u0002"}, d2 = {"Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupPropertiesBaseFlags", "", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalIsInPopupLayout", "getLocalIsInPopupLayout", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "Landroid/view/View;", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "isPopupLayout", "view", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "ui", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPopup_androidKt {
    private static final int PopupPropertiesBaseFlags = 262144;
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Boolean> LocalIsInPopupLayout = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Boolean>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalIsInPopupLayout$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return false;
        }
    }, 1, null);

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
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x0104  */
    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:82:0x010e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0117  */
    /* JADX WARN: Code duplicated, block: B:87:0x011f  */
    /* JADX WARN: Code duplicated, block: B:90:0x013e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0151  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Popup-K5zGePQ, reason: not valid java name */
    public static final void m9942PopupK5zGePQ(Alignment alignment, long j, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Alignment alignment2;
        int i3;
        long j2;
        int i4;
        Function0<Unit> function1;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function3;
        boolean z;
        final Alignment topStart;
        final long jM9809constructorimpl;
        final Function0<Unit> function4;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        DefaultConstructorMarker defaultConstructorMarker;
        Function0<Unit> function5;
        PopupProperties popupProperties4;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(71005054);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)271@12454L82,273@12542L166:AndroidPopup.android.kt#2oxthz");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            alignment2 = alignment;
        } else if ((i & 6) == 0) {
            alignment2 = alignment;
            i3 = (composerStartRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    } else {
                        function3 = function2;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        topStart = alignment2;
                        jM9809constructorimpl = j2;
                        function4 = function1;
                        popupProperties3 = popupProperties2;
                    } else {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            long j3 = 0;
                            jM9809constructorimpl = IntOffset.m9809constructorimpl((j3 & 4294967295L) | (j3 << 32));
                        } else {
                            jM9809constructorimpl = j2;
                        }
                        defaultConstructorMarker = null;
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function1;
                        }
                        if (i6 != 0) {
                            popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                        } else {
                            popupProperties4 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = ((i3 & 112) == 32) | z2;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function5;
                        popupProperties3 = popupProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                            public final void invoke(Composer composer2, int i11) {
                                AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                popupProperties2 = popupProperties;
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    topStart = alignment2;
                    jM9809constructorimpl = j2;
                    function4 = function1;
                    popupProperties3 = popupProperties2;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        long j4 = 0;
                        jM9809constructorimpl = IntOffset.m9809constructorimpl((j4 & 4294967295L) | (j4 << 32));
                    } else {
                        jM9809constructorimpl = j2;
                    }
                    defaultConstructorMarker = null;
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function1;
                    }
                    if (i6 != 0) {
                        popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties4 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = ((i3 & 112) == 32) | z2;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                    popupProperties3 = popupProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                        public final void invoke(Composer composer2, int i11) {
                            AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            function1 = function0;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    topStart = alignment2;
                    jM9809constructorimpl = j2;
                    function4 = function1;
                    popupProperties3 = popupProperties2;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        long j5 = 0;
                        jM9809constructorimpl = IntOffset.m9809constructorimpl((j5 & 4294967295L) | (j5 << 32));
                    } else {
                        jM9809constructorimpl = j2;
                    }
                    defaultConstructorMarker = null;
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function1;
                    }
                    if (i6 != 0) {
                        popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties4 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = ((i3 & 112) == 32) | z2;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                    popupProperties3 = popupProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                        public final void invoke(Composer composer2, int i11) {
                            AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                topStart = alignment2;
                jM9809constructorimpl = j2;
                function4 = function1;
                popupProperties3 = popupProperties2;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    long j6 = 0;
                    jM9809constructorimpl = IntOffset.m9809constructorimpl((j6 & 4294967295L) | (j6 << 32));
                } else {
                    jM9809constructorimpl = j2;
                }
                defaultConstructorMarker = null;
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function1;
                }
                if (i6 != 0) {
                    popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                } else {
                    popupProperties4 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = ((i3 & 112) == 32) | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
                popupProperties3 = popupProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                    public final void invoke(Composer composer2, int i11) {
                        AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        j2 = j;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                } else {
                    function3 = function2;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    topStart = alignment2;
                    jM9809constructorimpl = j2;
                    function4 = function1;
                    popupProperties3 = popupProperties2;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        long j7 = 0;
                        jM9809constructorimpl = IntOffset.m9809constructorimpl((j7 & 4294967295L) | (j7 << 32));
                    } else {
                        jM9809constructorimpl = j2;
                    }
                    defaultConstructorMarker = null;
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function1;
                    }
                    if (i6 != 0) {
                        popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties4 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = ((i3 & 112) == 32) | z2;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                    popupProperties3 = popupProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                        public final void invoke(Composer composer2, int i11) {
                            AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                topStart = alignment2;
                jM9809constructorimpl = j2;
                function4 = function1;
                popupProperties3 = popupProperties2;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    long j8 = 0;
                    jM9809constructorimpl = IntOffset.m9809constructorimpl((j8 & 4294967295L) | (j8 << 32));
                } else {
                    jM9809constructorimpl = j2;
                }
                defaultConstructorMarker = null;
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function1;
                }
                if (i6 != 0) {
                    popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                } else {
                    popupProperties4 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = ((i3 & 112) == 32) | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
                popupProperties3 = popupProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                    public final void invoke(Composer composer2, int i11) {
                        AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                function3 = function2;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                topStart = alignment2;
                jM9809constructorimpl = j2;
                function4 = function1;
                popupProperties3 = popupProperties2;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    long j9 = 0;
                    jM9809constructorimpl = IntOffset.m9809constructorimpl((j9 & 4294967295L) | (j9 << 32));
                } else {
                    jM9809constructorimpl = j2;
                }
                defaultConstructorMarker = null;
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function1;
                }
                if (i6 != 0) {
                    popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                } else {
                    popupProperties4 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = ((i3 & 112) == 32) | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
                popupProperties3 = popupProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                    public final void invoke(Composer composer2, int i11) {
                        AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        popupProperties2 = popupProperties;
        if ((i & 24576) == 0) {
            function3 = function2;
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        } else {
            function3 = function2;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            topStart = alignment2;
            jM9809constructorimpl = j2;
            function4 = function1;
            popupProperties3 = popupProperties2;
        } else {
            if (i9 != 0) {
                topStart = Alignment.INSTANCE.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i10 != 0) {
                long j10 = 0;
                jM9809constructorimpl = IntOffset.m9809constructorimpl((j10 & 4294967295L) | (j10 << 32));
            } else {
                jM9809constructorimpl = j2;
            }
            defaultConstructorMarker = null;
            if (i4 != 0) {
                function5 = null;
            } else {
                function5 = function1;
            }
            if (i6 != 0) {
                popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
            } else {
                popupProperties4 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = ((i3 & 112) == 32) | z2;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9809constructorimpl, defaultConstructorMarker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function5, popupProperties4, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function5;
            popupProperties3 = popupProperties4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                public final void invoke(Composer composer2, int i11) {
                    AndroidPopup_androidKt.m9942PopupK5zGePQ(topStart, jM9809constructorimpl, function4, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0287  */
    /* JADX WARN: Code duplicated, block: B:102:0x028f  */
    /* JADX WARN: Code duplicated, block: B:105:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:107:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:110:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:112:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:115:0x0334  */
    /* JADX WARN: Code duplicated, block: B:118:0x0340  */
    /* JADX WARN: Code duplicated, block: B:119:0x0344  */
    /* JADX WARN: Code duplicated, block: B:122:0x0396  */
    /* JADX WARN: Code duplicated, block: B:124:0x039e  */
    /* JADX WARN: Code duplicated, block: B:127:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x0119  */
    /* JADX WARN: Code duplicated, block: B:59:0x0154  */
    /* JADX WARN: Code duplicated, block: B:60:0x018c  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:71:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:77:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:80:0x0204  */
    /* JADX WARN: Code duplicated, block: B:81:0x0206  */
    /* JADX WARN: Code duplicated, block: B:84:0x021c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0228  */
    /* JADX WARN: Code duplicated, block: B:91:0x0252  */
    /* JADX WARN: Code duplicated, block: B:92:0x0254  */
    /* JADX WARN: Code duplicated, block: B:95:0x025c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0264  */
    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        int i4;
        PopupProperties popupProperties2;
        int i5;
        boolean z;
        final Function0<Unit> function3;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function4;
        final PopupProperties popupProperties4;
        View view;
        Density density;
        String str;
        final LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        final State stateRememberUpdatedState;
        AndroidPopup_androidKt$Popup$popupId$1$1 androidPopup_androidKt$Popup$popupId$1$1RememberedValue;
        UUID uuid;
        boolean zBooleanValue;
        Object objRememberedValue;
        boolean z2;
        String str2;
        int i6;
        final PopupLayout popupLayout;
        int i7;
        boolean z3;
        int i8;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue2;
        boolean z5;
        boolean z6;
        boolean zChanged2;
        Object objRememberedValue3;
        int i9;
        boolean z7;
        boolean z8;
        Object objRememberedValue4;
        boolean zChangedInstance;
        AndroidPopup_androidKt$Popup$5$1 androidPopup_androidKt$Popup$5$1RememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue5;
        boolean zChangedInstance3;
        MeasurePolicy measurePolicyRememberedValue;
        Function0<ComposeUiNode> constructor;
        int i10;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1772091631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(2,1,3)299@13430L7,300@13469L7,301@13513L7,302@13568L7,303@13604L28,304@13659L29,305@13724L21,305@13707L38,307@13875L7,308@13905L1203,338@15144L388,338@15114L418,353@15549L219,353@15538L230,362@15814L126,362@15774L166,374@16531L147,374@16503L175,387@16947L573,395@17528L99,384@16856L771:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 2048;
                    } else {
                        i10 = 1024;
                    }
                    i3 |= i10;
                }
                if ((i3 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function3 = function1;
                    popupProperties3 = popupProperties2;
                } else {
                    if (i11 != 0) {
                        function4 = null;
                    } else {
                        function4 = function1;
                    }
                    if (i4 != 0) {
                        popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties4 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1772091631, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
                    }
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume2;
                    ProvidableCompositionLocal<String> providableCompositionLocal = LocalPopupTestTag;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str = (String) objConsume3;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume4;
                    compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121974854, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    androidPopup_androidKt$Popup$popupId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (androidPopup_androidKt$Popup$popupId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        androidPopup_androidKt$Popup$popupId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final UUID invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$popupId$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) androidPopup_androidKt$Popup$popupId$1$1RememberedValue, composerStartRestartGroup, 48);
                    ProvidableCompositionLocal<Boolean> providableCompositionLocal2 = LocalIsInPopupLayout;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zBooleanValue = ((Boolean) objConsume5).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121981828, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i6 = 32;
                        str2 = str;
                        final PopupLayout popupLayout2 = new PopupLayout(function4, popupProperties4, str2, view, density, popupPositionProvider2, uuid, zBooleanValue, null, 256, null);
                        popupPositionProvider2 = popupPositionProvider2;
                        z2 = true;
                        popupLayout2.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                            public final void invoke(Composer composer2, int i12) {
                                ComposerKt.sourceInformation(composer2, "C321@14454L616,321@14393L677:AndroidPopup.android.kt#2oxthz");
                                if (!composer2.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-297523940, i12, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                                }
                                ProvidedValue<Boolean> providedValueProvides = AndroidPopup_androidKt.getLocalIsInPopupLayout().provides(true);
                                final PopupLayout popupLayout3 = popupLayout2;
                                final State<Function2<Composer, Integer, Unit>> state = stateRememberUpdatedState;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1022273628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
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

                                    public final void invoke(Composer composer3, int i13) {
                                        ComposerKt.sourceInformation(composer3, "C323@14540L16,325@14667L146,322@14480L568:AndroidPopup.android.kt#2oxthz");
                                        if (!composer3.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1022273628, i13, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:322)");
                                        }
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1142551508, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1 androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = composer3.rememberedValue();
                                        if (androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                                }
                                            };
                                            composer3.updateRememberedValue(androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue, 1, null);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1142547314, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        boolean zChangedInstance4 = composer3.changedInstance(popupLayout3);
                                        final PopupLayout popupLayout4 = popupLayout3;
                                        Object objRememberedValue6 = composer3.rememberedValue();
                                        if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                    m9943invokeozmzZPI(intSize.m9862unboximpl());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                public final void m9943invokeozmzZPI(long j) {
                                                    popupLayout4.m9946setPopupContentSizefhxjrPA(IntSize.m9850boximpl(j));
                                                    popupLayout4.updatePosition();
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue6);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue6), popupLayout3.getCanCalculatePosition() ? 1.0f : 0.0f);
                                        Function2 function2Popup$lambda$0 = AndroidPopup_androidKt.Popup$lambda$0(state);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
                                        ComposerKt.sourceInformationMarkerStart(composer3, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer3.rememberedValue();
                                        if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                            composer3.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
                                        }
                                        MeasurePolicy measurePolicy = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                        function2Popup$lambda$0.invoke(composer3, 0);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        composerStartRestartGroup.updateRememberedValue(popupLayout2);
                        objRememberedValue = popupLayout2;
                    } else {
                        z2 = true;
                        str2 = str;
                        i6 = 32;
                    }
                    popupLayout = (PopupLayout) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122020661, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(popupLayout);
                    int i12 = i3;
                    i7 = i12 & 112;
                    if (i7 == i6) {
                        z3 = z2;
                    } else {
                        z3 = false;
                    }
                    boolean z9 = zChangedInstance4 | z3;
                    i8 = i12 & 896;
                    if (i8 == 256) {
                        z4 = z2;
                    } else {
                        z4 = false;
                    }
                    LayoutDirection layoutDirection2 = layoutDirection;
                    zChanged = z9 | z4 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final String str3 = str2;
                        objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                popupLayout.show();
                                popupLayout.updateParameters(function4, popupProperties4, str3, layoutDirection);
                                final PopupLayout popupLayout3 = popupLayout;
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        popupLayout3.disposeComposition();
                                        popupLayout3.dismiss();
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122033452, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(popupLayout);
                    if (i7 == i6) {
                        z5 = z2;
                    } else {
                        z5 = false;
                    }
                    boolean z10 = zChangedInstance5 | z5;
                    if (i8 == 256) {
                        z6 = z2;
                    } else {
                        z6 = false;
                    }
                    zChanged2 = z10 | z6 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final String str4 = str2;
                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                popupLayout.updateParameters(function4, popupProperties4, str4, layoutDirection);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122041839, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(popupLayout);
                    i9 = i12 & 14;
                    if (i9 == 4) {
                        z7 = z2;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance6 | z7;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z8 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                popupLayout.setPositionProvider(popupPositionProvider2);
                                popupLayout.updatePosition();
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, i9);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122064804, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout);
                    androidPopup_androidKt$Popup$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || androidPopup_androidKt$Popup$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                        composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) androidPopup_androidKt$Popup$5$1RememberedValue, composerStartRestartGroup, 0);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122078542, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                Intrinsics.checkNotNull(parentLayoutCoordinates);
                                popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122096660, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                popupLayout.setParentLayoutDirection(layoutDirection);
                                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    popupProperties3 = popupProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
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

                        public final void invoke(Composer composer2, int i13) {
                            AndroidPopup_androidKt.Popup(popupPositionProvider2, function3, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            popupProperties2 = popupProperties;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i3 |= i10;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                popupProperties3 = popupProperties2;
            } else {
                if (i11 != 0) {
                    function4 = null;
                } else {
                    function4 = function1;
                }
                if (i4 != 0) {
                    popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                } else {
                    popupProperties4 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1772091631, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
                }
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume6;
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume7;
                ProvidableCompositionLocal<String> providableCompositionLocal3 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume8;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume9;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121974854, "CC(remember):AndroidPopup.android.kt#9igjgp");
                androidPopup_androidKt$Popup$popupId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (androidPopup_androidKt$Popup$popupId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    androidPopup_androidKt$Popup$popupId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final UUID invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$popupId$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr2, (Function0) androidPopup_androidKt$Popup$popupId$1$1RememberedValue, composerStartRestartGroup, 48);
                ProvidableCompositionLocal<Boolean> providableCompositionLocal4 = LocalIsInPopupLayout;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(providableCompositionLocal4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) objConsume10).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121981828, "CC(remember):AndroidPopup.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i6 = 32;
                    str2 = str;
                    final PopupLayout popupLayout3 = new PopupLayout(function4, popupProperties4, str2, view, density, popupPositionProvider2, uuid, zBooleanValue, null, 256, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    z2 = true;
                    popupLayout3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C321@14454L616,321@14393L677:AndroidPopup.android.kt#2oxthz");
                            if (!composer2.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-297523940, i13, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                            }
                            ProvidedValue<Boolean> providedValueProvides = AndroidPopup_androidKt.getLocalIsInPopupLayout().provides(true);
                            final PopupLayout popupLayout4 = popupLayout3;
                            final State<? extends Function2<? super Composer, ? super Integer, Unit>> state = stateRememberUpdatedState;
                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1022273628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
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

                                public final void invoke(Composer composer3, int i14) {
                                    ComposerKt.sourceInformation(composer3, "C323@14540L16,325@14667L146,322@14480L568:AndroidPopup.android.kt#2oxthz");
                                    if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1022273628, i14, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:322)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1142551508, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1 androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = composer3.rememberedValue();
                                    if (androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                            }
                                        };
                                        composer3.updateRememberedValue(androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue, 1, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1142547314, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    boolean zChangedInstance7 = composer3.changedInstance(popupLayout4);
                                    final PopupLayout popupLayout5 = popupLayout4;
                                    Object objRememberedValue6 = composer3.rememberedValue();
                                    if (zChangedInstance7 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                m9943invokeozmzZPI(intSize.m9862unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final void m9943invokeozmzZPI(long j) {
                                                popupLayout5.m9946setPopupContentSizefhxjrPA(IntSize.m9850boximpl(j));
                                                popupLayout5.updatePosition();
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue6), popupLayout4.getCanCalculatePosition() ? 1.0f : 0.0f);
                                    Function2 function2Popup$lambda$0 = AndroidPopup_androidKt.Popup$lambda$0(state);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer3.rememberedValue();
                                    if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                        composer3.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
                                    }
                                    MeasurePolicy measurePolicy2 = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer3);
                                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    function2Popup$lambda$0.invoke(composer3, 0);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(popupLayout3);
                    objRememberedValue = popupLayout3;
                } else {
                    z2 = true;
                    str2 = str;
                    i6 = 32;
                }
                popupLayout = (PopupLayout) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122020661, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(popupLayout);
                int i13 = i3;
                i7 = i13 & 112;
                if (i7 == i6) {
                    z3 = z2;
                } else {
                    z3 = false;
                }
                boolean z11 = zChangedInstance7 | z3;
                i8 = i13 & 896;
                if (i8 == 256) {
                    z4 = z2;
                } else {
                    z4 = false;
                }
                LayoutDirection layoutDirection3 = layoutDirection;
                zChanged = z11 | z4 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    final String str5 = str2;
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.show();
                            popupLayout.updateParameters(function4, popupProperties4, str5, layoutDirection);
                            final PopupLayout popupLayout4 = popupLayout;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    popupLayout4.disposeComposition();
                                    popupLayout4.dismiss();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final String str6 = str2;
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.show();
                            popupLayout.updateParameters(function4, popupProperties4, str6, layoutDirection);
                            final PopupLayout popupLayout4 = popupLayout;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    popupLayout4.disposeComposition();
                                    popupLayout4.dismiss();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122033452, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(popupLayout);
                if (i7 == i6) {
                    z5 = z2;
                } else {
                    z5 = false;
                }
                boolean z12 = zChangedInstance8 | z5;
                if (i8 == 256) {
                    z6 = z2;
                } else {
                    z6 = false;
                }
                zChanged2 = z12 | z6 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    final String str7 = str2;
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            popupLayout.updateParameters(function4, popupProperties4, str7, layoutDirection);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final String str8 = str2;
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            popupLayout.updateParameters(function4, popupProperties4, str8, layoutDirection);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122041839, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(popupLayout);
                i9 = i13 & 14;
                if (i9 == 4) {
                    z7 = z2;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance9 | z7;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.setPositionProvider(popupPositionProvider2);
                            popupLayout.updatePosition();
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.setPositionProvider(popupPositionProvider2);
                            popupLayout.updatePosition();
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, i9);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122064804, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout);
                androidPopup_androidKt$Popup$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                } else {
                    androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) androidPopup_androidKt$Popup$5$1RememberedValue, composerStartRestartGroup, 0);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122078542, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                            Intrinsics.checkNotNull(parentLayoutCoordinates);
                            popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                            Intrinsics.checkNotNull(parentLayoutCoordinates);
                            popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122096660, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            popupLayout.setParentLayoutDirection(layoutDirection);
                            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            popupLayout.setParentLayoutDirection(layoutDirection);
                            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy2 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                popupProperties3 = popupProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
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

                    public final void invoke(Composer composer2, int i14) {
                        AndroidPopup_androidKt.Popup(popupPositionProvider2, function3, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        function1 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i3 |= i10;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                popupProperties3 = popupProperties2;
            } else {
                if (i11 != 0) {
                    function4 = null;
                } else {
                    function4 = function1;
                }
                if (i4 != 0) {
                    popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
                } else {
                    popupProperties4 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1772091631, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
                }
                ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localView3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume11;
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume12;
                ProvidableCompositionLocal<String> providableCompositionLocal5 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(providableCompositionLocal5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume13;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume14;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                Object[] objArr3 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121974854, "CC(remember):AndroidPopup.android.kt#9igjgp");
                androidPopup_androidKt$Popup$popupId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (androidPopup_androidKt$Popup$popupId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    androidPopup_androidKt$Popup$popupId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final UUID invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$popupId$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr3, (Function0) androidPopup_androidKt$Popup$popupId$1$1RememberedValue, composerStartRestartGroup, 48);
                ProvidableCompositionLocal<Boolean> providableCompositionLocal6 = LocalIsInPopupLayout;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(providableCompositionLocal6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zBooleanValue = ((Boolean) objConsume15).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121981828, "CC(remember):AndroidPopup.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    i6 = 32;
                    str2 = str;
                    final PopupLayout popupLayout4 = new PopupLayout(function4, popupProperties4, str2, view, density, popupPositionProvider2, uuid, zBooleanValue, null, 256, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    z2 = true;
                    popupLayout4.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C321@14454L616,321@14393L677:AndroidPopup.android.kt#2oxthz");
                            if (!composer2.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-297523940, i14, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                            }
                            ProvidedValue<Boolean> providedValueProvides = AndroidPopup_androidKt.getLocalIsInPopupLayout().provides(true);
                            final PopupLayout popupLayout5 = popupLayout4;
                            final State<? extends Function2<? super Composer, ? super Integer, Unit>> state = stateRememberUpdatedState;
                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1022273628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
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

                                public final void invoke(Composer composer3, int i15) {
                                    ComposerKt.sourceInformation(composer3, "C323@14540L16,325@14667L146,322@14480L568:AndroidPopup.android.kt#2oxthz");
                                    if (!composer3.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1022273628, i15, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:322)");
                                    }
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1142551508, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1 androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = composer3.rememberedValue();
                                    if (androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                            }
                                        };
                                        composer3.updateRememberedValue(androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue, 1, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1142547314, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    boolean zChangedInstance10 = composer3.changedInstance(popupLayout5);
                                    final PopupLayout popupLayout6 = popupLayout5;
                                    Object objRememberedValue6 = composer3.rememberedValue();
                                    if (zChangedInstance10 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                m9943invokeozmzZPI(intSize.m9862unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final void m9943invokeozmzZPI(long j) {
                                                popupLayout6.m9946setPopupContentSizefhxjrPA(IntSize.m9850boximpl(j));
                                                popupLayout6.updatePosition();
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue6), popupLayout5.getCanCalculatePosition() ? 1.0f : 0.0f);
                                    Function2 function2Popup$lambda$0 = AndroidPopup_androidKt.Popup$lambda$0(state);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                    AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer3.rememberedValue();
                                    if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                        composer3.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
                                    }
                                    MeasurePolicy measurePolicy3 = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer3);
                                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                    function2Popup$lambda$0.invoke(composer3, 0);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(popupLayout4);
                    objRememberedValue = popupLayout4;
                } else {
                    z2 = true;
                    str2 = str;
                    i6 = 32;
                }
                popupLayout = (PopupLayout) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122020661, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance10 = composerStartRestartGroup.changedInstance(popupLayout);
                int i14 = i3;
                i7 = i14 & 112;
                if (i7 == i6) {
                    z3 = z2;
                } else {
                    z3 = false;
                }
                boolean z13 = zChangedInstance10 | z3;
                i8 = i14 & 896;
                if (i8 == 256) {
                    z4 = z2;
                } else {
                    z4 = false;
                }
                LayoutDirection layoutDirection4 = layoutDirection;
                zChanged = z13 | z4 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection4.ordinal());
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    final String str9 = str2;
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.show();
                            popupLayout.updateParameters(function4, popupProperties4, str9, layoutDirection);
                            final PopupLayout popupLayout5 = popupLayout;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    popupLayout5.disposeComposition();
                                    popupLayout5.dismiss();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final String str10 = str2;
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.show();
                            popupLayout.updateParameters(function4, popupProperties4, str10, layoutDirection);
                            final PopupLayout popupLayout5 = popupLayout;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    popupLayout5.disposeComposition();
                                    popupLayout5.dismiss();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122033452, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance11 = composerStartRestartGroup.changedInstance(popupLayout);
                if (i7 == i6) {
                    z5 = z2;
                } else {
                    z5 = false;
                }
                boolean z14 = zChangedInstance11 | z5;
                if (i8 == 256) {
                    z6 = z2;
                } else {
                    z6 = false;
                }
                zChanged2 = z14 | z6 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection4.ordinal());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    final String str11 = str2;
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            popupLayout.updateParameters(function4, popupProperties4, str11, layoutDirection);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final String str12 = str2;
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            popupLayout.updateParameters(function4, popupProperties4, str12, layoutDirection);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122041839, "CC(remember):AndroidPopup.android.kt#9igjgp");
                boolean zChangedInstance12 = composerStartRestartGroup.changedInstance(popupLayout);
                i9 = i14 & 14;
                if (i9 == 4) {
                    z7 = z2;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance12 | z7;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.setPositionProvider(popupPositionProvider2);
                            popupLayout.updatePosition();
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            popupLayout.setPositionProvider(popupPositionProvider2);
                            popupLayout.updatePosition();
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, i9);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122064804, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout);
                androidPopup_androidKt$Popup$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                } else {
                    androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                    composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) androidPopup_androidKt$Popup$5$1RememberedValue, composerStartRestartGroup, 0);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122078542, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                            Intrinsics.checkNotNull(parentLayoutCoordinates);
                            popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                            Intrinsics.checkNotNull(parentLayoutCoordinates);
                            popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion3, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122096660, "CC(remember):AndroidPopup.android.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout) | composerStartRestartGroup.changed(layoutDirection4.ordinal());
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            popupLayout.setParentLayoutDirection(layoutDirection);
                            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            popupLayout.setParentLayoutDirection(layoutDirection);
                            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy3 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                popupProperties3 = popupProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
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

                    public final void invoke(Composer composer2, int i15) {
                        AndroidPopup_androidKt.Popup(popupPositionProvider2, function3, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        popupProperties2 = popupProperties;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 2048;
            } else {
                i10 = 1024;
            }
            i3 |= i10;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function1;
            popupProperties3 = popupProperties2;
        } else {
            if (i11 != 0) {
                function4 = null;
            } else {
                function4 = function1;
            }
            if (i4 != 0) {
                popupProperties4 = new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null);
            } else {
                popupProperties4 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1772091631, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
            }
            ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localView4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume16;
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume17;
            ProvidableCompositionLocal<String> providableCompositionLocal7 = LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume18 = composerStartRestartGroup.consume(providableCompositionLocal7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            str = (String) objConsume18;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume19 = composerStartRestartGroup.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume19;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
            Object[] objArr4 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121974854, "CC(remember):AndroidPopup.android.kt#9igjgp");
            androidPopup_androidKt$Popup$popupId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (androidPopup_androidKt$Popup$popupId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                androidPopup_androidKt$Popup$popupId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final UUID invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$popupId$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr4, (Function0) androidPopup_androidKt$Popup$popupId$1$1RememberedValue, composerStartRestartGroup, 48);
            ProvidableCompositionLocal<Boolean> providableCompositionLocal8 = LocalIsInPopupLayout;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume110 = composerStartRestartGroup.consume(providableCompositionLocal8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zBooleanValue = ((Boolean) objConsume110).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121981828, "CC(remember):AndroidPopup.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i6 = 32;
                str2 = str;
                final PopupLayout popupLayout5 = new PopupLayout(function4, popupProperties4, str2, view, density, popupPositionProvider2, uuid, zBooleanValue, null, 256, null);
                popupPositionProvider2 = popupPositionProvider2;
                z2 = true;
                popupLayout5.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C321@14454L616,321@14393L677:AndroidPopup.android.kt#2oxthz");
                        if (!composer2.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-297523940, i15, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                        }
                        ProvidedValue<Boolean> providedValueProvides = AndroidPopup_androidKt.getLocalIsInPopupLayout().provides(true);
                        final PopupLayout popupLayout6 = popupLayout5;
                        final State<? extends Function2<? super Composer, ? super Integer, Unit>> state = stateRememberUpdatedState;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1022273628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
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

                            public final void invoke(Composer composer3, int i16) {
                                ComposerKt.sourceInformation(composer3, "C323@14540L16,325@14667L146,322@14480L568:AndroidPopup.android.kt#2oxthz");
                                if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1022273628, i16, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:322)");
                                }
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1142551508, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1 androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = composer3.rememberedValue();
                                if (androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                        }
                                    };
                                    composer3.updateRememberedValue(androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion4, false, (Function1) androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1142547314, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                boolean zChangedInstance13 = composer3.changedInstance(popupLayout6);
                                final PopupLayout popupLayout7 = popupLayout6;
                                Object objRememberedValue6 = composer3.rememberedValue();
                                if (zChangedInstance13 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                            m9943invokeozmzZPI(intSize.m9862unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final void m9943invokeozmzZPI(long j) {
                                            popupLayout7.m9946setPopupContentSizefhxjrPA(IntSize.m9850boximpl(j));
                                            popupLayout7.updatePosition();
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue6), popupLayout6.getCanCalculatePosition() ? 1.0f : 0.0f);
                                Function2 function2Popup$lambda$0 = AndroidPopup_androidKt.Popup$lambda$0(state);
                                ComposerKt.sourceInformationMarkerStart(composer3, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
                                ComposerKt.sourceInformationMarkerStart(composer3, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer3.rememberedValue();
                                if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                    composer3.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
                                }
                                MeasurePolicy measurePolicy4 = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composer3);
                                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                function2Popup$lambda$0.invoke(composer3, 0);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(popupLayout5);
                objRememberedValue = popupLayout5;
            } else {
                z2 = true;
                str2 = str;
                i6 = 32;
            }
            popupLayout = (PopupLayout) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122020661, "CC(remember):AndroidPopup.android.kt#9igjgp");
            boolean zChangedInstance13 = composerStartRestartGroup.changedInstance(popupLayout);
            int i15 = i3;
            i7 = i15 & 112;
            if (i7 == i6) {
                z3 = z2;
            } else {
                z3 = false;
            }
            boolean z15 = zChangedInstance13 | z3;
            i8 = i15 & 896;
            if (i8 == 256) {
                z4 = z2;
            } else {
                z4 = false;
            }
            LayoutDirection layoutDirection5 = layoutDirection;
            zChanged = z15 | z4 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection5.ordinal());
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                final String str13 = str2;
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout.show();
                        popupLayout.updateParameters(function4, popupProperties4, str13, layoutDirection);
                        final PopupLayout popupLayout6 = popupLayout;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                popupLayout6.disposeComposition();
                                popupLayout6.dismiss();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                final String str14 = str2;
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout.show();
                        popupLayout.updateParameters(function4, popupProperties4, str14, layoutDirection);
                        final PopupLayout popupLayout6 = popupLayout;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                popupLayout6.disposeComposition();
                                popupLayout6.dismiss();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122033452, "CC(remember):AndroidPopup.android.kt#9igjgp");
            boolean zChangedInstance14 = composerStartRestartGroup.changedInstance(popupLayout);
            if (i7 == i6) {
                z5 = z2;
            } else {
                z5 = false;
            }
            boolean z16 = zChangedInstance14 | z5;
            if (i8 == 256) {
                z6 = z2;
            } else {
                z6 = false;
            }
            zChanged2 = z16 | z6 | composerStartRestartGroup.changed(str2) | composerStartRestartGroup.changed(layoutDirection5.ordinal());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                final String str15 = str2;
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        popupLayout.updateParameters(function4, popupProperties4, str15, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                final String str16 = str2;
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        popupLayout.updateParameters(function4, popupProperties4, str16, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122041839, "CC(remember):AndroidPopup.android.kt#9igjgp");
            boolean zChangedInstance15 = composerStartRestartGroup.changedInstance(popupLayout);
            i9 = i15 & 14;
            if (i9 == 4) {
                z7 = z2;
            } else {
                z7 = false;
            }
            z8 = zChangedInstance15 | z7;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout.setPositionProvider(popupPositionProvider2);
                        popupLayout.updatePosition();
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        popupLayout.setPositionProvider(popupPositionProvider2);
                        popupLayout.updatePosition();
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, i9);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122064804, "CC(remember):AndroidPopup.android.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout);
            androidPopup_androidKt$Popup$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
            } else {
                androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) androidPopup_androidKt$Popup$5$1RememberedValue, composerStartRestartGroup, 0);
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122078542, "CC(remember):AndroidPopup.android.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                        Intrinsics.checkNotNull(parentLayoutCoordinates);
                        popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
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
                        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                        Intrinsics.checkNotNull(parentLayoutCoordinates);
                        popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion4, (Function1) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122096660, "CC(remember):AndroidPopup.android.kt#9igjgp");
            zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout) | composerStartRestartGroup.changed(layoutDirection5.ordinal());
            measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance3) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        popupLayout.setParentLayoutDirection(layoutDirection);
                        return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            } else {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        popupLayout.setParentLayoutDirection(layoutDirection);
                        return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy4 = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            popupProperties3 = popupProperties4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
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

                public final void invoke(Composer composer2, int i16) {
                    AndroidPopup_androidKt.Popup(popupPositionProvider2, function3, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int createFlags(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i = !z ? 262152 : 262144;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i |= 8192;
        }
        return !z2 ? i | 512 : i;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalIsInPopupLayout() {
        return LocalIsInPopupLayout;
    }

    public static final void PopupTestTag(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1357513789);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PopupTestTag)P(1)441@19264L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357513789, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:440)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPopupTestTag.provides(str), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.PopupTestTag.1
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

                public final void invoke(Composer composer2, int i3) {
                    AndroidPopup_androidKt.PopupTestTag(str, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
        ComposerKt.sourceInformationMarkerStart(composer, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
        AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer.rememberedValue();
        if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
            composer.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((i << 3) & 112) | ((i >> 3) & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i3 = ((i2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z) {
        if (popupProperties.getInheritSecurePolicy() && z) {
            return popupProperties.getFlags() | 8192;
        }
        if (popupProperties.getInheritSecurePolicy() && !z) {
            return popupProperties.getFlags() & (-8193);
        }
        return popupProperties.getFlags();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        if (view instanceof PopupLayout) {
            return str == null || Intrinsics.areEqual(str, ((PopupLayout) view).getTestTag());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
