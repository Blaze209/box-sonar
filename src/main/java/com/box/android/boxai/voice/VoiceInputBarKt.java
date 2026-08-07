package com.box.android.boxai.voice;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CancelKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeFadingEdgeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.boxai.R;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.cpl.Store;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VoiceInputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\t\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a]\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0002\u0010\u0019\u001a#\u0010\u001a\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0002\u0010\u0019\u001a/\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0003¢\u0006\u0004\b \u0010!\u001a\u0017\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010&\u001a\r\u0010'\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010(\u001a\r\u0010)\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010(¨\u0006*²\u0006\n\u0010+\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u008a\u0084\u0002"}, d2 = {"VoiceInputBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/box/android/boxai/voice/VoiceInputReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action;", "(Landroidx/compose/ui/Modifier;Lcom/box/android/boxai/voice/VoiceInputReducer$State;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;II)V", "isEnabled", "", "audioLevelSamplingInterval", "Lkotlin/time/Duration;", "audioLevelSamples", "", "", "elapsedTime", "onCancel", "Lkotlin/Function0;", "onFinish", "VoiceInputBar-JS_gyfw", "(Landroidx/compose/ui/Modifier;ZJLjava/util/List;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CancelButton", ViewProps.ON_CLICK, "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FinishButton", "WaveformAnimation", "samplingInterval", "WaveformAnimation-NcHsxvU", "(Landroidx/compose/ui/Modifier;JLjava/util/List;Landroidx/compose/runtime/Composer;II)V", "DurationText", "DurationText-WPwdCS8", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "formatTimeText", "", "time", "formatTimeText-LRDsOJo", "(J)Ljava/lang/String;", "BoxAiVoiceInputBarStartingPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiVoiceInputBarInProgressPreview", "boxai_generalProdRelease", "cursorPosition", "samples"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VoiceInputBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiVoiceInputBarInProgressPreview$lambda$3(int i, Composer composer, int i2) {
        BoxAiVoiceInputBarInProgressPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiVoiceInputBarStartingPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiVoiceInputBarStartingPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CancelButton$lambda$1(boolean z, Function0 function0, int i, Composer composer, int i2) {
        CancelButton(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DurationText_WPwdCS8$lambda$1(Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m12137DurationTextWPwdCS8(modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FinishButton$lambda$1(boolean z, Function0 function0, int i, Composer composer, int i2) {
        FinishButton(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceInputBar$lambda$2(Modifier modifier, VoiceInputReducer.State state, Store store, int i, int i2, Composer composer, int i3) {
        VoiceInputBar(modifier, state, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceInputBar_JS_gyfw$lambda$1(Modifier modifier, boolean z, long j, List list, long j2, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        m12138VoiceInputBarJS_gyfw(modifier, z, j, list, j2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WaveformAnimation_NcHsxvU$lambda$3(Modifier modifier, long j, List list, int i, int i2, Composer composer, int i3) {
        m12139WaveformAnimationNcHsxvU(modifier, j, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void VoiceInputBar(Modifier modifier, final VoiceInputReducer.State state, final Store<VoiceInputReducer.State, VoiceInputReducer.Action> store, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(1183160855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VoiceInputBar)N(modifier,state,store)68@2940L57,69@3018L57,62@2608L473:VoiceInputBar.kt#7b8luw");
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
            i3 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1183160855, i3, -1, "com.box.android.boxai.voice.VoiceInputBar (VoiceInputBar.kt:61)");
            }
            boolean z = state instanceof VoiceInputReducer.State.Listening;
            long jM12148getAUDIO_LEVEL_SAMPLE_INTERVALUwyO8pc = VoiceInputReducer.INSTANCE.m12148getAUDIO_LEVEL_SAMPLE_INTERVALUwyO8pc();
            List<Float> audioLevelSamples = state.getAudioLevelSamples();
            if (audioLevelSamples == null) {
                audioLevelSamples = CollectionsKt.emptyList();
            }
            List<Float> list = audioLevelSamples;
            Duration elapsedTime = state.getElapsedTime();
            long rawValue = elapsedTime != null ? elapsedTime.getRawValue() : Duration.INSTANCE.m16251getZEROUwyO8pc();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148735760, "CC(remember):VoiceInputBar.kt#9igjgp");
            int i5 = i3 & 896;
            boolean z2 = i5 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VoiceInputBarKt.VoiceInputBar$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148733264, "CC(remember):VoiceInputBar.kt#9igjgp");
            boolean z3 = i5 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VoiceInputBarKt.VoiceInputBar$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m12138VoiceInputBarJS_gyfw(modifier2, z, jM12148getAUDIO_LEVEL_SAMPLE_INTERVALUwyO8pc, list, rawValue, function0, (Function0) objRememberedValue2, composerStartRestartGroup, (i3 & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier3 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.VoiceInputBar$lambda$2(modifier3, state, store, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceInputBar$lambda$0$0(Store store) {
        if (store != null) {
            store.send(VoiceInputReducer.Action.CancelListening.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceInputBar$lambda$1$0(Store store) {
        if (store != null) {
            store.send(VoiceInputReducer.Action.FinishListening.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x017a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0186  */
    /* JADX WARN: Code duplicated, block: B:81:0x018a  */
    /* JADX WARN: Code duplicated, block: B:84:0x024e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0255  */
    /* JADX WARN: Code duplicated, block: B:89:0x0260  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: VoiceInputBar-JS_gyfw, reason: not valid java name */
    public static final void m12138VoiceInputBarJS_gyfw(Modifier modifier, boolean z, final long j, final List<Float> list, final long j2, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Function0<ComposeUiNode> constructor;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1011007875);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VoiceInputBar)N(modifier,isEnabled,audioLevelSamplingInterval:kotlin.time.Duration,audioLevelSamples,elapsedTime:kotlin.time.Duration,onCancel,onFinish)88@3494L6,83@3354L958:VoiceInputBar.kt#7b8luw");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i3 |= i8;
            }
            if ((i & 3072) != 0) {
                if (composerStartRestartGroup.changedInstance(list)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i4 = 1048576;
                } else {
                    i4 = 524288;
                }
                i3 |= i4;
            }
            if ((i3 & 599187) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1011007875, i3, -1, "com.box.android.boxai.voice.VoiceInputBar (VoiceInputBar.kt:82)");
                }
                int i11 = i3;
                float f = 8;
                Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m588backgroundbw27NRU(SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(companion, Dp.m9687constructorimpl(44), 0.0f, 2, null), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11582getTopLayerInteractiveBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18))), Dp.m9687constructorimpl(f), 0.0f, 2, null), "VoiceInputBar");
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                Modifier modifier4 = companion;
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1936376180, "C95@3738L89,99@3836L242,106@4087L121,110@4217L89:VoiceInputBar.kt#7b8luw");
                int i12 = i11 >> 3;
                int i13 = i12 & 14;
                CancelButton(z5, function0, composerStartRestartGroup, ((i11 >> 12) & 112) | i13);
                int i14 = i12 & 1008;
                boolean z6 = z5;
                m12139WaveformAnimationNcHsxvU(PaddingKt.m1220paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m9687constructorimpl(f), 0.0f, 2, null), j, list, composerStartRestartGroup, i14, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                m12137DurationTextWPwdCS8(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), 0.0f, 2, null), j2, composerStartRestartGroup, ((i11 >> 9) & 112) | 6, 0);
                FinishButton(z6, function1, composerStartRestartGroup, ((i11 >> 15) & 112) | i13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return VoiceInputBarKt.VoiceInputBar_JS_gyfw$lambda$1(modifier3, z4, j, list, j2, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        }
        if ((i & 3072) != 0) {
            if (composerStartRestartGroup.changedInstance(list)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i4 = 1048576;
            } else {
                i4 = 524288;
            }
            i3 |= i4;
        }
        if ((i3 & 599187) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i10 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1011007875, i3, -1, "com.box.android.boxai.voice.VoiceInputBar (VoiceInputBar.kt:82)");
            }
            int i15 = i3;
            float f2 = 8;
            Modifier modifierTestTag2 = TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m588backgroundbw27NRU(SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(companion, Dp.m9687constructorimpl(44), 0.0f, 2, null), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11582getTopLayerInteractiveBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18))), Dp.m9687constructorimpl(f2), 0.0f, 2, null), "VoiceInputBar");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
            Modifier modifier5 = companion;
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1936376180, "C95@3738L89,99@3836L242,106@4087L121,110@4217L89:VoiceInputBar.kt#7b8luw");
            int i16 = i15 >> 3;
            int i17 = i16 & 14;
            CancelButton(z5, function0, composerStartRestartGroup, ((i15 >> 12) & 112) | i17);
            int i18 = i16 & 1008;
            boolean z7 = z5;
            m12139WaveformAnimationNcHsxvU(PaddingKt.m1220paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m9687constructorimpl(f2), 0.0f, 2, null), j, list, composerStartRestartGroup, i18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            m12137DurationTextWPwdCS8(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), 0.0f, 2, null), j2, composerStartRestartGroup, ((i15 >> 9) & 112) | 6, 0);
            FinishButton(z7, function1, composerStartRestartGroup, ((i15 >> 15) & 112) | i17);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z7;
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.VoiceInputBar_JS_gyfw$lambda$1(modifier3, z4, j, list, j2, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CancelButton(final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(12758141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CancelButton)N(isEnabled,onClick)124@4587L24,125@4631L42,126@4704L59,127@4791L6,119@4400L420:VoiceInputBar.kt#7b8luw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(12758141, i2, -1, "com.box.android.boxai.voice.CancelButton (VoiceInputBar.kt:118)");
            }
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), RoundedCornerShapeKt.RoundedCornerShape(50)), z, null, null, null, function0, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -624320331, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VoiceInputBarKt.CancelButton$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(CancelKt.getCancel(Icons.Filled.INSTANCE), composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.box_ai_voice_cancel_talkback_label, composerStartRestartGroup, 0), SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default, false, (Function1) objRememberedValue, 1, null), BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12055getContentSecondary0d7_KjU(), composerStartRestartGroup, VectorPainter.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.CancelButton$lambda$1(z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CancelButton$lambda$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
        return Unit.INSTANCE;
    }

    private static final void FinishButton(final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1600832964);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FinishButton)N(isEnabled,onClick)139@5122L24,140@5166L44,141@5241L59,142@5326L6,133@4908L448:VoiceInputBar.kt#7b8luw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1600832964, i2, -1, "com.box.android.boxai.voice.FinishButton (VoiceInputBar.kt:132)");
            }
            Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.RoundedCornerShape(50)), z, null, null, null, function0, 14, null), Dp.m9687constructorimpl(2)), Dp.m9687constructorimpl(28));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 802195356, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VoiceInputBarKt.FinishButton$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_circlecheck16, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.box_ai_voice_finish_talkback_label, composerStartRestartGroup, 0), SemanticsModifierKt.semantics$default(modifierM1266size3ABfNKs, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composerStartRestartGroup, Painter.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.FinishButton$lambda$1(z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FinishButton$lambda$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -2.0f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: WaveformAnimation-NcHsxvU, reason: not valid java name */
    private static final void m12139WaveformAnimationNcHsxvU(Modifier modifier, final long j, final List<Float> list, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        Composer composer2;
        final Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(157908275);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WaveformAnimation)N(modifier,samplingInterval:kotlin.time.Duration,audioLevelSamples)148@5521L6,149@5572L6,150@5623L6,151@5694L6,153@5756L410,167@6317L399,178@6735L142,163@6172L711:VoiceInputBar.kt#7b8luw");
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
            j2 = j;
            i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        } else {
            j2 = j;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(157908275, i3, -1, "com.box.android.boxai.voice.WaveformAnimation (VoiceInputBar.kt:147)");
            }
            float f = 2;
            final float fM11638toPx8Feqmps = ComposeUtilsKt.m11638toPx8Feqmps(Dp.m9687constructorimpl(f), composerStartRestartGroup, 6);
            final float fM11638toPx8Feqmps2 = ComposeUtilsKt.m11638toPx8Feqmps(Dp.m9687constructorimpl(f), composerStartRestartGroup, 6);
            final int iM6868toArgb8_81llA = ColorKt.m6868toArgb8_81llA(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU());
            final int iM6868toArgb8_81llA2 = ColorKt.m6868toArgb8_81llA(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12064getWaveformSilenceBar0d7_KjU());
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(list.size(), new FloatTweenSpec(((int) Duration.m16167getInWholeMillisecondsimpl(j2)) * 2, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, "Waveform cursor position", null, composerStartRestartGroup, (FloatTweenSpec.$stable << 3) | 3072, 20);
            float f2 = 16;
            Modifier modifierM11629rightFadingEdge3ABfNKs = ComposeFadingEdgeKt.m11629rightFadingEdge3ABfNKs(ComposeFadingEdgeKt.m11628leftFadingEdge3ABfNKs(SizeKt.m1252height3ABfNKs(companion, Dp.m9687constructorimpl(24)), Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1426027298, "CC(remember):VoiceInputBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fM11638toPx8Feqmps) | composerStartRestartGroup.changed(fM11638toPx8Feqmps2) | composerStartRestartGroup.changed(iM6868toArgb8_81llA) | composerStartRestartGroup.changed(iM6868toArgb8_81llA2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VoiceInputBarKt.WaveformAnimation_NcHsxvU$lambda$1$0(fM11638toPx8Feqmps, fM11638toPx8Feqmps2, iM6868toArgb8_81llA, iM6868toArgb8_81llA2, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1426040417, "CC(remember):VoiceInputBar.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VoiceInputBarKt.WaveformAnimation_NcHsxvU$lambda$2$0(list, stateAnimateFloatAsState, (VoiceInputWaveVisualizer) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function1, modifierM11629rightFadingEdge3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.WaveformAnimation_NcHsxvU$lambda$3(companion, j, list, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VoiceInputWaveVisualizer WaveformAnimation_NcHsxvU$lambda$1$0(float f, float f2, int i, int i2, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        VoiceInputWaveVisualizer voiceInputWaveVisualizer = new VoiceInputWaveVisualizer(context);
        voiceInputWaveVisualizer.setStyle(f, f2, 0.3f, i, i2);
        return voiceInputWaveVisualizer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WaveformAnimation_NcHsxvU$lambda$2$0(List list, State state, VoiceInputWaveVisualizer view) {
        Intrinsics.checkNotNullParameter(view, "view");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((Number) it.next()).floatValue()));
        }
        view.updateAmps(arrayList);
        view.updateCursorPosition(WaveformAnimation_NcHsxvU$lambda$0(state));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DurationText-WPwdCS8, reason: not valid java name */
    private static final void m12137DurationTextWPwdCS8(Modifier modifier, final long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-338126669);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DurationText)N(modifier,elapsedTime:kotlin.time.Duration)188@7028L21,191@7171L6,187@6984L210:VoiceInputBar.kt#7b8luw");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            j2 = j;
            i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        } else {
            j2 = j;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-338126669, i3, -1, "com.box.android.boxai.voice.DurationText (VoiceInputBar.kt:186)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1477789480, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VoiceInputBarKt.DurationText_WPwdCS8$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            Modifier modifier4 = companion;
            TextKt.m4494TextNvy7gAk(m12141formatTimeTextLRDsOJo(j2), SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold12(), composer2, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.DurationText_WPwdCS8$lambda$1(modifier3, j, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DurationText_WPwdCS8$lambda$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.invisibleToUser(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: formatTimeText-LRDsOJo, reason: not valid java name */
    private static final String m12141formatTimeTextLRDsOJo(long j) {
        String strValueOf = String.valueOf(Duration.m16168getInWholeMinutesimpl(j));
        long jM16170getInWholeSecondsimpl = Duration.m16170getInWholeSecondsimpl(j);
        Duration.Companion companion = Duration.INSTANCE;
        return strValueOf + ":" + StringsKt.padStart(String.valueOf(jM16170getInWholeSecondsimpl % Duration.m16170getInWholeSecondsimpl(DurationKt.toDuration(1, DurationUnit.MINUTES))), 2, '0');
    }

    private static final void BoxAiVoiceInputBarStartingPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2133480531);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiVoiceInputBarStartingPreview)207@7593L278:VoiceInputBar.kt#7b8luw");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2133480531, i, -1, "com.box.android.boxai.voice.BoxAiVoiceInputBarStartingPreview (VoiceInputBar.kt:206)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$VoiceInputBarKt.INSTANCE.m12126getLambda$1262982344$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.BoxAiVoiceInputBarStartingPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiVoiceInputBarInProgressPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1393758789);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiVoiceInputBarInProgressPreview)223@8006L273,232@8311L37,233@8362L231,233@8353L240:VoiceInputBar.kt#7b8luw");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1393758789, i, -1, "com.box.android.boxai.voice.BoxAiVoiceInputBarInProgressPreview (VoiceInputBar.kt:222)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 627602508, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = FlowKt.runningFold(FlowKt.onEach(FlowKt.flow(new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1(null)), new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2(null)), CollectionsKt.emptyList(), new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3(null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateCollectAsState = SnapshotStateKt.collectAsState((Flow) objRememberedValue, CollectionsKt.emptyList(), null, composerStartRestartGroup, 48, 2);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1931343494, true, new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.BoxAiVoiceInputBarInProgressPreview$lambda$2(stateCollectAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceInputBarKt.BoxAiVoiceInputBarInProgressPreview$lambda$3(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiVoiceInputBarInProgressPreview$lambda$2(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C238@8548L2,239@8575L2,234@8372L215:VoiceInputBar.kt#7b8luw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931343494, i, -1, "com.box.android.boxai.voice.BoxAiVoiceInputBarInProgressPreview.<anonymous> (VoiceInputBar.kt:234)");
            }
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
            List<Float> listBoxAiVoiceInputBarInProgressPreview$lambda$1 = BoxAiVoiceInputBarInProgressPreview$lambda$1(state);
            Duration.Companion companion2 = Duration.INSTANCE;
            long duration2 = DurationKt.toDuration(74, DurationUnit.SECONDS);
            ComposerKt.sourceInformationMarkerStart(composer, 595231816, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 595232680, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.voice.VoiceInputBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m12138VoiceInputBarJS_gyfw(null, false, duration, listBoxAiVoiceInputBarInProgressPreview$lambda$1, duration2, function0, (Function0) objRememberedValue2, composer, 1769472, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final float WaveformAnimation_NcHsxvU$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final List<Float> BoxAiVoiceInputBarInProgressPreview$lambda$1(State<? extends List<Float>> state) {
        return state.getValue();
    }
}
