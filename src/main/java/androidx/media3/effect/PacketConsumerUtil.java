package androidx.media3.effect;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.guava.ListenableFutureKt;

/* JADX INFO: compiled from: PacketConsumerUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/media3/effect/PacketConsumerUtil;", "", "<init>", "()V", "release", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", ExifInterface.GPS_DIRECTION_TRUE, "consumer", "Landroidx/media3/effect/PacketConsumer;", "executor", "Ljava/util/concurrent/ExecutorService;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PacketConsumerUtil {
    public static final PacketConsumerUtil INSTANCE = new PacketConsumerUtil();

    private PacketConsumerUtil() {
    }

    /* JADX INFO: renamed from: androidx.media3.effect.PacketConsumerUtil$release$1, reason: invalid class name */
    /* JADX INFO: compiled from: PacketConsumerUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.PacketConsumerUtil$release$1", f = "PacketConsumerUtil.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Void>, Object> {
        final /* synthetic */ PacketConsumer<T> $consumer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PacketConsumer<T> packetConsumer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$consumer = packetConsumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$consumer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Void> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return null;
            }
            ResultKt.throwOnFailure(obj);
            PacketConsumer<T> packetConsumer = this.$consumer;
            this.label = 1;
            if (packetConsumer.release(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return null;
        }
    }

    @JvmStatic
    public static final <T> ListenableFuture<Void> release(PacketConsumer<T> consumer, ExecutorService executor) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return ListenableFutureKt.future$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executor)), null, null, new AnonymousClass1(consumer, null), 3, null);
    }
}
