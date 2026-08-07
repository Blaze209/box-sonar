package com.box.android.boxai.voice;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: VoiceInputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$VoiceInputBarKt {
    public static final ComposableSingletons$VoiceInputBarKt INSTANCE = new ComposableSingletons$VoiceInputBarKt();

    /* JADX INFO: renamed from: lambda$-1262982344, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f218lambda$1262982344 = ComposableLambdaKt.composableLambdaInstance(-1262982344, false, new Function2() { // from class: com.box.android.boxai.voice.ComposableSingletons$VoiceInputBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$VoiceInputBarKt.lambda__1262982344$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1262982344$boxai_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12126getLambda$1262982344$boxai_generalProdRelease() {
        return f218lambda$1262982344;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1262982344$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@7826L2,214@7853L2,208@7612L253:VoiceInputBar.kt#7b8luw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262982344, i, -1, "com.box.android.boxai.voice.ComposableSingletons$VoiceInputBarKt.lambda$-1262982344.<anonymous> (VoiceInputBar.kt:208)");
            }
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
            List listEmptyList = CollectionsKt.emptyList();
            long jM16251getZEROUwyO8pc = Duration.INSTANCE.m16251getZEROUwyO8pc();
            ComposerKt.sourceInformationMarkerStart(composer, 1749719354, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.voice.ComposableSingletons$VoiceInputBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1749720218, "CC(remember):VoiceInputBar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.voice.ComposableSingletons$VoiceInputBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            VoiceInputBarKt.m12138VoiceInputBarJS_gyfw(null, false, duration, listEmptyList, jM16251getZEROUwyO8pc, function0, (Function0) objRememberedValue2, composer, 1772592, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
