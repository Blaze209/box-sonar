package sdk.pendo.io.actions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "sdk.pendo.io.actions.GuidesManager$runGuide$2$1$3", f = "GuidesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GuidesManager$runGuide$2$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivationManager.ActivationEvents $guideActivatedBy;
    final /* synthetic */ GuideCandidate $guideCandidate;
    final /* synthetic */ GuideModel $guideModel;
    final /* synthetic */ int $stepIndex;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuidesManager$runGuide$2$1$3(GuideModel guideModel, ActivationManager.ActivationEvents activationEvents, int i, GuideCandidate guideCandidate, Continuation<? super GuidesManager$runGuide$2$1$3> continuation) {
        super(2, continuation);
        this.$guideModel = guideModel;
        this.$guideActivatedBy = activationEvents;
        this.$stepIndex = i;
        this.$guideCandidate = guideCandidate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuidesManager$runGuide$2$1$3(this.$guideModel, this.$guideActivatedBy, this.$stepIndex, this.$guideCandidate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GuidesManager.INSTANCE.internalRunGuide$pendoIO_release(this.$guideModel, false, this.$guideActivatedBy, this.$stepIndex, this.$guideCandidate.getTargetView());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuidesManager$runGuide$2$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
