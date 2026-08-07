package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {369, Token.LETEXPR}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"}, v = 1)
final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-text-TextRange$-selection$0, reason: not valid java name */
    final /* synthetic */ long f59$$v$c$androidxcomposeuitextTextRange$selection$0;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence charSequence, long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.f59$$v$c$androidxcomposeuitextTextRange$selection$0 = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.f59$$v$c$androidxcomposeuitextTextRange$selection$0, this.this$0, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(textClassifier, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        CharSequence charSequence;
        TextSelection textSelection;
        Mutex mutex;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = (TextClassifier) this.L$0;
            TextSelection.Request.Builder defaultLocales = new TextSelection.Request.Builder(this.$text, TextRange.m9089getMinimpl(this.f59$$v$c$androidxcomposeuitextTextRange$selection$0), TextRange.m9088getMaximpl(this.f59$$v$c$androidxcomposeuitextTextRange$selection$0)).setDefaultLocales(this.this$0.getAndroidLocalList());
            if (Build.VERSION.SDK_INT >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long jTextRange = TextRangeKt.TextRange(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            if (Build.VERSION.SDK_INT < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.J$0 = jTextRange;
                this.label = 2;
                if (this.this$0.m2129classifyTextM8tDOmk(this.$text, jTextRange, textClassifier, this) != coroutine_suspended) {
                    j = jTextRange;
                    j2 = j;
                }
            } else {
                Mutex mutex2 = this.this$0.mutex;
                platformSelectionBehaviorsImpl = this.this$0;
                charSequence = this.$text;
                this.L$0 = textSelectionSuggestSelection;
                this.L$1 = mutex2;
                this.L$2 = platformSelectionBehaviorsImpl;
                this.L$3 = charSequence;
                this.J$0 = jTextRange;
                this.label = 1;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    textSelection = textSelectionSuggestSelection;
                    mutex = mutex2;
                    j2 = jTextRange;
                    CharSequence charSequence2 = charSequence;
                    TextClassification textClassification = textSelection.getTextClassification();
                    Intrinsics.checkNotNull(textClassification);
                    platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence2, j2, textClassification, null));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            long j3 = this.J$0;
            charSequence = (CharSequence) this.L$3;
            PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = (PlatformSelectionBehaviorsImpl) this.L$2;
            Mutex mutex3 = (Mutex) this.L$1;
            textSelection = (TextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            j2 = j3;
            platformSelectionBehaviorsImpl = platformSelectionBehaviorsImpl2;
            CharSequence charSequence3 = charSequence;
            try {
                TextClassification textClassification2 = textSelection.getTextClassification();
                Intrinsics.checkNotNull(textClassification2);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence3, j2, textClassification2, null));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j2 = j;
        }
        return TextRange.m9079boximpl(j2);
    }
}
