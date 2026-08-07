package com.box.android.data;

import com.box.android.domain.utils.Progress;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: SdkFileTransferUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/SdkFileTransferUtils;", "", "<init>", "()V", "copyTo", "", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "fileSize", "", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/box/android/domain/utils/Progress;", "(Ljava/io/InputStream;Ljava/io/OutputStream;JLkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SdkFileTransferUtils {
    public static final SdkFileTransferUtils INSTANCE = new SdkFileTransferUtils();

    private SdkFileTransferUtils() {
    }

    /* JADX INFO: renamed from: com.box.android.data.SdkFileTransferUtils$copyTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: SdkFileTransferUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.SdkFileTransferUtils$copyTo$2", f = "SdkFileTransferUtils.kt", i = {0, 0, 0}, l = {24}, m = "invokeSuspend", n = {"buffer", "bytesCopied", "bytes"}, s = {"L$0", "J$0", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $fileSize;
        final /* synthetic */ OutputStream $outputStream;
        final /* synthetic */ MutableStateFlow<Progress> $progressFlow;
        final /* synthetic */ InputStream $this_copyTo;
        int I$0;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InputStream inputStream, OutputStream outputStream, MutableStateFlow<Progress> mutableStateFlow, long j, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_copyTo = inputStream;
            this.$outputStream = outputStream;
            this.$progressFlow = mutableStateFlow;
            this.$fileSize = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_copyTo, this.$outputStream, this.$progressFlow, this.$fileSize, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            int i;
            long j;
            byte[] bArr;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                byte[] bArr2 = new byte[8192];
                i = this.$this_copyTo.read(bArr2);
                j = 0;
                bArr = bArr2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                j = this.J$0;
                bArr = (byte[]) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (i >= 0) {
                this.$outputStream.write(bArr, 0, i);
                j += (long) i;
                i = this.$this_copyTo.read(bArr);
                MutableStateFlow<Progress> mutableStateFlow = this.$progressFlow;
                if (mutableStateFlow != null) {
                    this.L$0 = bArr;
                    this.J$0 = j;
                    this.I$0 = i;
                    this.label = 1;
                    if (mutableStateFlow.emit(new Progress(j, this.$fileSize), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object copyTo$default(SdkFileTransferUtils sdkFileTransferUtils, InputStream inputStream, OutputStream outputStream, long j, MutableStateFlow mutableStateFlow, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableStateFlow = null;
        }
        return sdkFileTransferUtils.copyTo(inputStream, outputStream, j, mutableStateFlow, continuation);
    }

    public final Object copyTo(InputStream inputStream, OutputStream outputStream, long j, MutableStateFlow<Progress> mutableStateFlow, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(inputStream, outputStream, mutableStateFlow, j, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
