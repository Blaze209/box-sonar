package expo.modules.ui.icon;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.icon.IconView$Content$1$1", f = "IconView.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
final class IconView$Content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Drawable> $drawable$delegate;
    final /* synthetic */ MutableState<ImageVector> $imageVector$delegate;
    final /* synthetic */ Source $source;
    int label;
    final /* synthetic */ IconView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IconView$Content$1$1(Source source, IconView iconView, MutableState<ImageVector> mutableState, MutableState<Drawable> mutableState2, Continuation<? super IconView$Content$1$1> continuation) {
        super(2, continuation);
        this.$source = source;
        this.this$0 = iconView;
        this.$imageVector$delegate = mutableState;
        this.$drawable$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IconView$Content$1$1(this.$source, this.this$0, this.$imageVector$delegate, this.$drawable$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IconView$Content$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$imageVector$delegate.setValue(null);
            this.$drawable$delegate.setValue(null);
            Source source = this.$source;
            String strResolveUri = source != null ? this.this$0.resolveUri(source) : null;
            if (strResolveUri != null) {
                this.label = 1;
                obj = this.this$0.getIconLoader().loadFromUri(strResolveUri, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        VectorIconLoader.IconResult iconResult = (VectorIconLoader.IconResult) obj;
        this.$imageVector$delegate.setValue(iconResult.getImageVector());
        this.$drawable$delegate.setValue(iconResult.getDrawable());
        return Unit.INSTANCE;
    }
}
