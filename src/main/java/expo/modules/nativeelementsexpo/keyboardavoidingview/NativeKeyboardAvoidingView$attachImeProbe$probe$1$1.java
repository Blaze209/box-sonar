package expo.modules.nativeelementsexpo.keyboardavoidingview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NativeKeyboardAvoidingView.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class NativeKeyboardAvoidingView$attachImeProbe$probe$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NativeKeyboardAvoidingView this$0;

    NativeKeyboardAvoidingView$attachImeProbe$probe$1$1(NativeKeyboardAvoidingView nativeKeyboardAvoidingView) {
        this.this$0 = nativeKeyboardAvoidingView;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@3760L82,98@3743L99:NativeKeyboardAvoidingView.kt#s1kn6k");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-843885879, i, -1, "expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView.attachImeProbe.<anonymous>.<anonymous> (NativeKeyboardAvoidingView.kt:98)");
        }
        NativeKeyboardAvoidingView nativeKeyboardAvoidingView = this.this$0;
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):NativeKeyboardAvoidingView.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(this.this$0);
        final NativeKeyboardAvoidingView nativeKeyboardAvoidingView2 = this.this$0;
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView$attachImeProbe$probe$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NativeKeyboardAvoidingView$attachImeProbe$probe$1$1.invoke$lambda$1$lambda$0(nativeKeyboardAvoidingView2, ((Integer) obj).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        nativeKeyboardAvoidingView.ImeInsetObserver((Function1) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NativeKeyboardAvoidingView nativeKeyboardAvoidingView, int i) {
        nativeKeyboardAvoidingView.applyImeOffset(i);
        return Unit.INSTANCE;
    }
}
