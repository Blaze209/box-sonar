package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/media3/effect/GlShaderProgramPacketProcessor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.media3.effect.GlShaderProgramPacketProcessor$Companion$create$2", f = "GlShaderProgramPacketProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GlShaderProgramPacketProcessor$Companion$create$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GlShaderProgramPacketProcessor>, Object> {
    final /* synthetic */ GlObjectsProvider $glObjectsProvider;
    final /* synthetic */ CoroutineDispatcher $glThreadDispatcher;
    final /* synthetic */ GlShaderProgram $shaderProgram;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlShaderProgramPacketProcessor$Companion$create$2(CoroutineDispatcher coroutineDispatcher, GlShaderProgram glShaderProgram, GlObjectsProvider glObjectsProvider, Continuation<? super GlShaderProgramPacketProcessor$Companion$create$2> continuation) {
        super(2, continuation);
        this.$glThreadDispatcher = coroutineDispatcher;
        this.$shaderProgram = glShaderProgram;
        this.$glObjectsProvider = glObjectsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlShaderProgramPacketProcessor$Companion$create$2(this.$glThreadDispatcher, this.$shaderProgram, this.$glObjectsProvider, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GlShaderProgramPacketProcessor> continuation) {
        return ((GlShaderProgramPacketProcessor$Companion$create$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new GlShaderProgramPacketProcessor(this.$glThreadDispatcher, this.$shaderProgram, this.$glObjectsProvider, null);
    }
}
