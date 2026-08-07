package androidx.compose.material3;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePicker.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "(Landroidx/compose/runtime/Composer;I)I", "rememberTimeInputErrorHandler", "Landroidx/compose/material3/TimeInputErrorHandler;", "isTouchExplorationEnabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TimeInputErrorHandler;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePicker_androidKt {
    public static final int defaultTimePickerLayoutType(Composer composer, int i) {
        int iM4582getVerticalQJTpgSE;
        ComposerKt.sourceInformationMarkerStart(composer, -721362352, "C(defaultTimePickerLayoutType)34@1384L7:TimePicker.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721362352, i, -1, "androidx.compose.material3.defaultTimePickerLayoutType (TimePicker.android.kt:34)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        if (configuration.screenHeightDp < configuration.screenWidthDp) {
            iM4582getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m4581getHorizontalQJTpgSE();
        } else {
            iM4582getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m4582getVerticalQJTpgSE();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM4582getVerticalQJTpgSE;
    }

    public static final TimeInputErrorHandler rememberTimeInputErrorHandler(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 216223160, "C(rememberTimeInputErrorHandler)N(isTouchExplorationEnabled)46@1721L7,47@1767L7,49@1806L85,51@1904L250:TimePicker.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(216223160, i, -1, "androidx.compose.material3.rememberTimeInputErrorHandler (TimePicker.android.kt:45)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localHapticFeedback);
        ComposerKt.sourceInformationMarkerEnd(composer);
        HapticFeedback hapticFeedback = (HapticFeedback) objConsume2;
        ComposerKt.sourceInformationMarkerStart(composer, 1632033581, "CC(remember):TimePicker.android.kt#9igjgp");
        boolean zChanged = composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object systemService = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            objRememberedValue = (AudioManager) systemService;
            composer.updateRememberedValue(objRememberedValue);
        }
        AudioManager audioManager = (AudioManager) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1632036882, "CC(remember):TimePicker.android.kt#9igjgp");
        boolean zChanged2 = ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4) | composer.changed(hapticFeedback) | composer.changed(audioManager);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new TimeInputErrorHandlerImpl(hapticFeedback, audioManager, z);
            composer.updateRememberedValue(objRememberedValue2);
        }
        TimeInputErrorHandlerImpl timeInputErrorHandlerImpl = (TimeInputErrorHandlerImpl) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timeInputErrorHandlerImpl;
    }
}
