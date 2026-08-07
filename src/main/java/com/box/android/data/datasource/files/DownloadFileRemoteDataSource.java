package com.box.android.data.datasource.files;

import com.box.android.data.SdkFileTransferUtils;
import com.box.android.data.api.requests.DownloadFileRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.squareup.moshi.Moshi;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: DownloadFileRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJB\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017JJ\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u001bJ4\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0087@¢\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/datasource/files/DownloadFileRemoteDataSource;", "", "downloadFileRequest", "Lcom/box/android/data/api/requests/DownloadFileRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/api/requests/DownloadFileRequest;Lcom/squareup/moshi/Moshi;Lkotlinx/coroutines/CoroutineDispatcher;)V", "downloadFile", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "", "Lcom/box/android/data/datasource/errors/RemoteError;", "Lcom/box/android/domain/utils/Progress;", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "fileSize", "", "sharedLinkHeader", "", "targetFile", "Ljava/io/File;", "(Lcom/box/android/domain/models/ItemId$Remote;JLjava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFileChunk", "startByte", "endByte", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/io/File;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTargetFile", "inputStream", "Ljava/io/InputStream;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "(Ljava/io/InputStream;JLjava/io/File;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFileRemoteDataSource {
    private final DownloadFileRequest downloadFileRequest;
    private final CoroutineDispatcher ioDispatcher;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.DownloadFileRemoteDataSource$downloadFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.DownloadFileRemoteDataSource", f = "DownloadFileRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {50, 49, 47}, m = "downloadFile", n = {"fileId", "sharedLinkHeader", "targetFile", "progressFlow", "resultFlow", "it", "fileSize", "$i$a$-also-DownloadFileRemoteDataSource$downloadFile$2", "$i$f$resultOf", "$i$a$-resultOf-DownloadFileRemoteDataSource$downloadFile$2$1", "fileId", "sharedLinkHeader", "targetFile", "progressFlow", "resultFlow", "it", "fileSize", "$i$a$-also-DownloadFileRemoteDataSource$downloadFile$2", "$i$f$resultOf", "$i$a$-resultOf-DownloadFileRemoteDataSource$downloadFile$2$1", "fileId", "sharedLinkHeader", "targetFile", "progressFlow", "resultFlow", "it", "fileSize", "$i$a$-also-DownloadFileRemoteDataSource$downloadFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "J$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "J$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "J$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileRemoteDataSource.this.downloadFile(null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.DownloadFileRemoteDataSource$downloadFileChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.DownloadFileRemoteDataSource", f = "DownloadFileRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {87, 86, 84}, m = "downloadFileChunk", n = {"fileId", "targetFile", "sharedLinkHeader", "rangeHeader", "progressFlow", "resultFlow", "it", "startByte", "endByte", "$i$a$-also-DownloadFileRemoteDataSource$downloadFileChunk$2", "$i$f$resultOf", "$i$a$-resultOf-DownloadFileRemoteDataSource$downloadFileChunk$2$1", "fileId", "targetFile", "sharedLinkHeader", "rangeHeader", "progressFlow", "resultFlow", "it", "startByte", "endByte", "$i$a$-also-DownloadFileRemoteDataSource$downloadFileChunk$2", "$i$f$resultOf", "$i$a$-resultOf-DownloadFileRemoteDataSource$downloadFileChunk$2$1", "fileId", "targetFile", "sharedLinkHeader", "rangeHeader", "progressFlow", "resultFlow", "it", "startByte", "endByte", "$i$a$-also-DownloadFileRemoteDataSource$downloadFileChunk$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "J$0", "J$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "J$0", "J$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "J$0", "J$1", "I$0"}, v = 1)
    static final class C11471 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C11471(Continuation<? super C11471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileRemoteDataSource.this.downloadFileChunk(null, null, 0L, 0L, null, this);
        }
    }

    @Inject
    public DownloadFileRemoteDataSource(DownloadFileRequest downloadFileRequest, Moshi moshi, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(downloadFileRequest, "downloadFileRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.downloadFileRequest = downloadFileRequest;
        this.moshi = moshi;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:60:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:63:0x024d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x024e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x024f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object downloadFile(ItemId.Remote remote, long j, String str, File file, Continuation<? super ResultProgressWrapper<Unit, RemoteError, Progress>> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        MutableStateFlow<Progress> MutableStateFlow;
        String str2;
        File file2;
        ItemId.Remote remote2;
        MutableStateFlow mutableStateFlow;
        ResultProgressWrapper resultProgressWrapper;
        ResultProgressWrapper resultProgressWrapper2;
        String str3;
        File file3;
        MutableStateFlow mutableStateFlow2;
        int i;
        long j2;
        Object objDownloadFile;
        DownloadFileRemoteDataSource downloadFileRemoteDataSource;
        MutableStateFlow mutableStateFlow3;
        int i2;
        int i3;
        InputStream inputStreamByteStream;
        DownloadFileRemoteDataSource downloadFileRemoteDataSource2;
        long j3;
        ResultProgressWrapper resultProgressWrapper3;
        ResultProgressWrapper resultProgressWrapper4;
        ItemId.Remote remote3;
        MutableStateFlow<Progress> mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        String str4;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass2.label;
        if (i4 == 0) {
            obj = null;
            ResultKt.throwOnFailure(obj2);
            MutableStateFlow = StateFlowKt.MutableStateFlow(new Progress(0L, j));
            MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
            ResultProgressWrapper resultProgressWrapper5 = new ResultProgressWrapper(MutableStateFlow, MutableStateFlow2);
            try {
                DownloadFileRequest downloadFileRequest = this.downloadFileRequest;
                String boxId = remote.getBoxId();
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str);
                file2 = file;
                try {
                    anonymousClass2.L$2 = file2;
                    anonymousClass2.L$3 = MutableStateFlow;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow2);
                    anonymousClass2.L$5 = resultProgressWrapper5;
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper5);
                    anonymousClass2.L$7 = MutableStateFlow2;
                    anonymousClass2.L$8 = this;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.I$0 = 0;
                    anonymousClass2.I$1 = 0;
                    anonymousClass2.I$2 = 0;
                    anonymousClass2.label = 1;
                    str2 = str;
                    try {
                        objDownloadFile = downloadFileRequest.downloadFile(boxId, str2, anonymousClass2);
                        if (objDownloadFile != coroutine_suspended) {
                            remote2 = remote;
                            mutableStateFlow = MutableStateFlow2;
                            resultProgressWrapper = resultProgressWrapper5;
                            resultProgressWrapper2 = resultProgressWrapper;
                            str3 = str2;
                            file3 = file2;
                            downloadFileRemoteDataSource = this;
                            mutableStateFlow3 = mutableStateFlow;
                            i2 = 0;
                            j2 = j;
                            i = 0;
                            i3 = 0;
                            inputStreamByteStream = ((ResponseBody) objDownloadFile).byteStream();
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                            anonymousClass2.L$5 = resultProgressWrapper2;
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                            anonymousClass2.L$7 = mutableStateFlow3;
                            downloadFileRemoteDataSource2 = downloadFileRemoteDataSource;
                            anonymousClass2.L$8 = obj;
                            anonymousClass2.J$0 = j2;
                            anonymousClass2.I$0 = i;
                            anonymousClass2.I$1 = i2;
                            anonymousClass2.I$2 = i3;
                            anonymousClass2.label = 2;
                            if (downloadFileRemoteDataSource2.copyToTargetFile(inputStreamByteStream, j2, file3, MutableStateFlow, anonymousClass2) != coroutine_suspended) {
                                j3 = j2;
                                mutableStateFlow2 = mutableStateFlow3;
                                resultProgressWrapper3 = resultProgressWrapper;
                                resultProgressWrapper4 = resultProgressWrapper2;
                                remote3 = remote2;
                                mutableStateFlow4 = MutableStateFlow;
                                mutableStateFlow5 = mutableStateFlow;
                                str4 = str3;
                                error = new Result.Success(Unit.INSTANCE);
                                if (!(error instanceof Result.Success)) {
                                    if (error instanceof Result.Error) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                                }
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
                                anonymousClass2.L$5 = resultProgressWrapper4;
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                                anonymousClass2.L$7 = null;
                                anonymousClass2.L$8 = null;
                                anonymousClass2.J$0 = j3;
                                anonymousClass2.I$0 = i;
                                anonymousClass2.label = 3;
                                if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                                    return resultProgressWrapper4;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        remote2 = remote;
                        mutableStateFlow = MutableStateFlow2;
                        resultProgressWrapper = resultProgressWrapper5;
                        resultProgressWrapper2 = resultProgressWrapper;
                        str3 = str2;
                        file3 = file2;
                        mutableStateFlow2 = mutableStateFlow;
                        i = 0;
                        j2 = j;
                        j3 = j2;
                        resultProgressWrapper3 = resultProgressWrapper;
                        resultProgressWrapper4 = resultProgressWrapper2;
                        remote3 = remote2;
                        error = new Result.Error(e);
                        mutableStateFlow4 = MutableStateFlow;
                        mutableStateFlow5 = mutableStateFlow;
                        str4 = str3;
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                        }
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
                        anonymousClass2.L$5 = resultProgressWrapper4;
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                        anonymousClass2.L$7 = null;
                        anonymousClass2.L$8 = null;
                        anonymousClass2.J$0 = j3;
                        anonymousClass2.I$0 = i;
                        anonymousClass2.label = 3;
                        if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return resultProgressWrapper4;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = str;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str;
                file2 = file;
            }
        } else if (i4 == 1) {
            int i5 = anonymousClass2.I$2;
            int i6 = anonymousClass2.I$1;
            int i7 = anonymousClass2.I$0;
            j2 = anonymousClass2.J$0;
            DownloadFileRemoteDataSource downloadFileRemoteDataSource3 = (DownloadFileRemoteDataSource) anonymousClass2.L$8;
            MutableStateFlow mutableStateFlow6 = (MutableStateFlow) anonymousClass2.L$7;
            ResultProgressWrapper resultProgressWrapper6 = (ResultProgressWrapper) anonymousClass2.L$6;
            resultProgressWrapper2 = (ResultProgressWrapper) anonymousClass2.L$5;
            mutableStateFlow = (MutableStateFlow) anonymousClass2.L$4;
            MutableStateFlow<Progress> mutableStateFlow7 = (MutableStateFlow) anonymousClass2.L$3;
            obj = null;
            File file4 = (File) anonymousClass2.L$2;
            str3 = (String) anonymousClass2.L$1;
            remote2 = (ItemId.Remote) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                i3 = i5;
                i = i7;
                i2 = i6;
                MutableStateFlow = mutableStateFlow7;
                downloadFileRemoteDataSource = downloadFileRemoteDataSource3;
                file3 = file4;
                resultProgressWrapper = resultProgressWrapper6;
                mutableStateFlow3 = mutableStateFlow6;
                objDownloadFile = obj2;
                try {
                    inputStreamByteStream = ((ResponseBody) objDownloadFile).byteStream();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                    anonymousClass2.L$5 = resultProgressWrapper2;
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                    anonymousClass2.L$7 = mutableStateFlow3;
                    downloadFileRemoteDataSource2 = downloadFileRemoteDataSource;
                    anonymousClass2.L$8 = obj;
                    anonymousClass2.J$0 = j2;
                    anonymousClass2.I$0 = i;
                    anonymousClass2.I$1 = i2;
                    anonymousClass2.I$2 = i3;
                    anonymousClass2.label = 2;
                    if (downloadFileRemoteDataSource2.copyToTargetFile(inputStreamByteStream, j2, file3, MutableStateFlow, anonymousClass2) != coroutine_suspended) {
                        j3 = j2;
                        mutableStateFlow2 = mutableStateFlow3;
                        resultProgressWrapper3 = resultProgressWrapper;
                        resultProgressWrapper4 = resultProgressWrapper2;
                        remote3 = remote2;
                        mutableStateFlow4 = MutableStateFlow;
                        mutableStateFlow5 = mutableStateFlow;
                        str4 = str3;
                        error = new Result.Success(Unit.INSTANCE);
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                        }
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
                        anonymousClass2.L$5 = resultProgressWrapper4;
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                        anonymousClass2.L$7 = null;
                        anonymousClass2.L$8 = null;
                        anonymousClass2.J$0 = j3;
                        anonymousClass2.I$0 = i;
                        anonymousClass2.label = 3;
                        if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                            return resultProgressWrapper4;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    mutableStateFlow2 = mutableStateFlow3;
                    j3 = j2;
                    resultProgressWrapper3 = resultProgressWrapper;
                    resultProgressWrapper4 = resultProgressWrapper2;
                    remote3 = remote2;
                    error = new Result.Error(e);
                    mutableStateFlow4 = MutableStateFlow;
                    mutableStateFlow5 = mutableStateFlow;
                    str4 = str3;
                }
            } catch (Exception e5) {
                e = e5;
                i = i7;
                mutableStateFlow2 = mutableStateFlow6;
                file3 = file4;
                MutableStateFlow = mutableStateFlow7;
                resultProgressWrapper = resultProgressWrapper6;
                j3 = j2;
                resultProgressWrapper3 = resultProgressWrapper;
                resultProgressWrapper4 = resultProgressWrapper2;
                remote3 = remote2;
                error = new Result.Error(e);
                mutableStateFlow4 = MutableStateFlow;
                mutableStateFlow5 = mutableStateFlow;
                str4 = str3;
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                }
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
                anonymousClass2.L$5 = resultProgressWrapper4;
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                anonymousClass2.L$7 = null;
                anonymousClass2.L$8 = null;
                anonymousClass2.J$0 = j3;
                anonymousClass2.I$0 = i;
                anonymousClass2.label = 3;
                if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return resultProgressWrapper4;
            }
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = anonymousClass2.I$0;
                long j4 = anonymousClass2.J$0;
                ResultProgressWrapper resultProgressWrapper7 = (ResultProgressWrapper) anonymousClass2.L$5;
                ResultKt.throwOnFailure(obj2);
                return resultProgressWrapper7;
            }
            int i9 = anonymousClass2.I$2;
            int i10 = anonymousClass2.I$1;
            i = anonymousClass2.I$0;
            j3 = anonymousClass2.J$0;
            mutableStateFlow2 = (MutableStateFlow) anonymousClass2.L$7;
            resultProgressWrapper3 = (ResultProgressWrapper) anonymousClass2.L$6;
            resultProgressWrapper4 = (ResultProgressWrapper) anonymousClass2.L$5;
            MutableStateFlow mutableStateFlow8 = (MutableStateFlow) anonymousClass2.L$4;
            MutableStateFlow = (MutableStateFlow) anonymousClass2.L$3;
            File file5 = (File) anonymousClass2.L$2;
            str4 = (String) anonymousClass2.L$1;
            remote3 = (ItemId.Remote) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                mutableStateFlow4 = MutableStateFlow;
                mutableStateFlow5 = mutableStateFlow8;
                file3 = file5;
                try {
                    error = new Result.Success(Unit.INSTANCE);
                } catch (Exception e6) {
                    e = e6;
                    resultProgressWrapper2 = resultProgressWrapper4;
                    remote2 = remote3;
                    str3 = str4;
                    mutableStateFlow = mutableStateFlow5;
                    MutableStateFlow = mutableStateFlow4;
                    resultProgressWrapper = resultProgressWrapper3;
                    j2 = j3;
                    j3 = j2;
                    resultProgressWrapper3 = resultProgressWrapper;
                    resultProgressWrapper4 = resultProgressWrapper2;
                    remote3 = remote2;
                    error = new Result.Error(e);
                    mutableStateFlow4 = MutableStateFlow;
                    mutableStateFlow5 = mutableStateFlow;
                    str4 = str3;
                }
            } catch (Exception e7) {
                e = e7;
                resultProgressWrapper = resultProgressWrapper3;
                remote2 = remote3;
                str3 = str4;
                mutableStateFlow = mutableStateFlow8;
                file3 = file5;
                resultProgressWrapper2 = resultProgressWrapper4;
                j2 = j3;
                j3 = j2;
                resultProgressWrapper3 = resultProgressWrapper;
                resultProgressWrapper4 = resultProgressWrapper2;
                remote3 = remote2;
                error = new Result.Error(e);
                mutableStateFlow4 = MutableStateFlow;
                mutableStateFlow5 = mutableStateFlow;
                str4 = str3;
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                }
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
                anonymousClass2.L$5 = resultProgressWrapper4;
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                anonymousClass2.L$7 = null;
                anonymousClass2.L$8 = null;
                anonymousClass2.J$0 = j3;
                anonymousClass2.I$0 = i;
                anonymousClass2.label = 3;
                if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return resultProgressWrapper4;
            }
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
            }
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote3);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(file3);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(mutableStateFlow4);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(mutableStateFlow5);
            anonymousClass2.L$5 = resultProgressWrapper4;
            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
            anonymousClass2.L$7 = null;
            anonymousClass2.L$8 = null;
            anonymousClass2.J$0 = j3;
            anonymousClass2.I$0 = i;
            anonymousClass2.label = 3;
            if (mutableStateFlow2.emit(error, anonymousClass2) != coroutine_suspended) {
                return resultProgressWrapper4;
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0223  */
    /* JADX WARN: Code duplicated, block: B:67:0x0270  */
    /* JADX WARN: Code duplicated, block: B:69:0x0274  */
    /* JADX WARN: Code duplicated, block: B:73:0x02d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object downloadFileChunk(ItemId.Remote remote, File file, long j, long j2, String str, Continuation<? super ResultProgressWrapper<Unit, RemoteError, Progress>> continuation) {
        C11471 c11471;
        Object obj;
        MutableStateFlow<Progress> MutableStateFlow;
        int i;
        File file2;
        String str2;
        ItemId.Remote remote2;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        String str3;
        ResultProgressWrapper resultProgressWrapper;
        String str4;
        long j3;
        ResultProgressWrapper resultProgressWrapper2;
        int i2;
        Object objDownloadFileChunk;
        DownloadFileRemoteDataSource downloadFileRemoteDataSource;
        MutableStateFlow mutableStateFlow3;
        int i3;
        InputStream inputStreamByteStream;
        long j4;
        C11471 c11472;
        File file3;
        MutableStateFlow<Progress> mutableStateFlow4;
        long j5;
        String str5;
        MutableStateFlow mutableStateFlow5;
        Result.Error error;
        long j6 = j2;
        if (continuation instanceof C11471) {
            c11471 = (C11471) continuation;
            if ((c11471.label & Integer.MIN_VALUE) != 0) {
                c11471.label -= Integer.MIN_VALUE;
            } else {
                c11471 = new C11471(continuation);
            }
        } else {
            c11471 = new C11471(continuation);
        }
        Object obj2 = c11471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c11471.label;
        if (i4 == 0) {
            obj = null;
            ResultKt.throwOnFailure(obj2);
            String str6 = "bytes=" + j + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + j6;
            MutableStateFlow = StateFlowKt.MutableStateFlow(new Progress(0L, j6 - j));
            MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
            ResultProgressWrapper resultProgressWrapper3 = new ResultProgressWrapper(MutableStateFlow, MutableStateFlow2);
            i = 0;
            try {
                DownloadFileRequest downloadFileRequest = this.downloadFileRequest;
                String boxId = remote.getBoxId();
                c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote);
                file2 = file;
                try {
                    c11471.L$1 = file2;
                    c11471.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    c11471.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                    c11471.L$4 = MutableStateFlow;
                    c11471.L$5 = SpillingKt.nullOutSpilledVariable(MutableStateFlow2);
                    c11471.L$6 = resultProgressWrapper3;
                    c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper3);
                    c11471.L$8 = MutableStateFlow2;
                    c11471.L$9 = this;
                    c11471.J$0 = j;
                    c11471.J$1 = j6;
                    c11471.I$0 = 0;
                    c11471.I$1 = 0;
                    c11471.I$2 = 0;
                    c11471.label = 1;
                    str2 = str;
                    try {
                        objDownloadFileChunk = downloadFileRequest.downloadFileChunk(boxId, str6, str2, c11471);
                        if (objDownloadFileChunk != coroutine_suspended) {
                            remote2 = remote;
                            downloadFileRemoteDataSource = this;
                            mutableStateFlow = MutableStateFlow2;
                            str3 = str6;
                            resultProgressWrapper = resultProgressWrapper3;
                            str4 = str2;
                            j3 = j;
                            mutableStateFlow3 = mutableStateFlow;
                            resultProgressWrapper2 = resultProgressWrapper;
                            i2 = 0;
                            i3 = 0;
                            inputStreamByteStream = ((ResponseBody) objDownloadFileChunk).byteStream();
                            j4 = j6 - j3;
                            c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                            c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                            c11471.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                            c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                            c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                            c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                            c11471.L$6 = resultProgressWrapper2;
                            c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                            c11471.L$8 = mutableStateFlow3;
                            mutableStateFlow2 = mutableStateFlow3;
                            c11471.L$9 = obj;
                            c11471.J$0 = j3;
                            c11471.J$1 = j6;
                            c11471.I$0 = i2;
                            c11471.I$1 = i3;
                            c11471.I$2 = i;
                            c11471.label = 2;
                            c11472 = c11471;
                            file3 = file2;
                            mutableStateFlow4 = MutableStateFlow;
                            file2 = file3;
                            MutableStateFlow = mutableStateFlow4;
                            c11471 = c11472;
                            if (downloadFileRemoteDataSource.copyToTargetFile(inputStreamByteStream, j4, file3, mutableStateFlow4, c11472) != coroutine_suspended) {
                                j5 = j6;
                                str5 = str4;
                                mutableStateFlow5 = mutableStateFlow2;
                                error = new Result.Success(Unit.INSTANCE);
                                if (!(error instanceof Result.Success)) {
                                    if (!(error instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                                }
                                c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                                c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                                c11471.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                                c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                                c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                                c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                                c11471.L$6 = resultProgressWrapper2;
                                c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                                c11471.L$8 = null;
                                c11471.L$9 = null;
                                c11471.J$0 = j3;
                                c11471.J$1 = j5;
                                c11471.I$0 = i2;
                                c11471.label = 3;
                                if (mutableStateFlow5.emit(error, c11471) == coroutine_suspended) {
                                    return resultProgressWrapper2;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        remote2 = remote;
                        mutableStateFlow = MutableStateFlow2;
                        mutableStateFlow2 = mutableStateFlow;
                        str3 = str6;
                        resultProgressWrapper = resultProgressWrapper3;
                        str4 = str2;
                        j3 = j;
                        resultProgressWrapper2 = resultProgressWrapper;
                        i2 = 0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = str;
                    remote2 = remote;
                    mutableStateFlow = MutableStateFlow2;
                    mutableStateFlow2 = mutableStateFlow;
                    str3 = str6;
                    resultProgressWrapper = resultProgressWrapper3;
                    str4 = str2;
                    j3 = j;
                    resultProgressWrapper2 = resultProgressWrapper;
                    i2 = 0;
                    error = new Result.Error(e);
                    j5 = j6;
                    str5 = str4;
                    mutableStateFlow5 = mutableStateFlow2;
                    if (!(error instanceof Result.Success)) {
                        if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                    }
                    c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                    c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                    c11471.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                    c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                    c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                    c11471.L$6 = resultProgressWrapper2;
                    c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                    c11471.L$8 = null;
                    c11471.L$9 = null;
                    c11471.J$0 = j3;
                    c11471.J$1 = j5;
                    c11471.I$0 = i2;
                    c11471.label = 3;
                    if (mutableStateFlow5.emit(error, c11471) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return resultProgressWrapper2;
                }
            } catch (Exception e3) {
                e = e3;
                file2 = file;
            }
        } else {
            if (i4 == 1) {
                obj = null;
                int i5 = c11471.I$2;
                int i6 = c11471.I$1;
                int i7 = c11471.I$0;
                j6 = c11471.J$1;
                j3 = c11471.J$0;
                DownloadFileRemoteDataSource downloadFileRemoteDataSource2 = (DownloadFileRemoteDataSource) c11471.L$9;
                MutableStateFlow mutableStateFlow6 = (MutableStateFlow) c11471.L$8;
                resultProgressWrapper = (ResultProgressWrapper) c11471.L$7;
                ResultProgressWrapper resultProgressWrapper4 = (ResultProgressWrapper) c11471.L$6;
                MutableStateFlow mutableStateFlow7 = (MutableStateFlow) c11471.L$5;
                MutableStateFlow<Progress> mutableStateFlow8 = (MutableStateFlow) c11471.L$4;
                str3 = (String) c11471.L$3;
                String str7 = (String) c11471.L$2;
                File file4 = (File) c11471.L$1;
                remote2 = (ItemId.Remote) c11471.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    i3 = i6;
                    i2 = i7;
                    MutableStateFlow = mutableStateFlow8;
                    mutableStateFlow3 = mutableStateFlow6;
                    i = i5;
                    str4 = str7;
                    mutableStateFlow = mutableStateFlow7;
                    objDownloadFileChunk = obj2;
                    downloadFileRemoteDataSource = downloadFileRemoteDataSource2;
                    resultProgressWrapper2 = resultProgressWrapper4;
                    file2 = file4;
                    try {
                        inputStreamByteStream = ((ResponseBody) objDownloadFileChunk).byteStream();
                        j4 = j6 - j3;
                        c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                        c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                        c11471.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                        c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                        c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                        c11471.L$6 = resultProgressWrapper2;
                        c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                        c11471.L$8 = mutableStateFlow3;
                        mutableStateFlow2 = mutableStateFlow3;
                        try {
                            c11471.L$9 = obj;
                            c11471.J$0 = j3;
                            c11471.J$1 = j6;
                            c11471.I$0 = i2;
                            c11471.I$1 = i3;
                            c11471.I$2 = i;
                            c11471.label = 2;
                            c11472 = c11471;
                            file3 = file2;
                            mutableStateFlow4 = MutableStateFlow;
                            try {
                                file2 = file3;
                                MutableStateFlow = mutableStateFlow4;
                                c11471 = c11472;
                                if (downloadFileRemoteDataSource.copyToTargetFile(inputStreamByteStream, j4, file3, mutableStateFlow4, c11472) != coroutine_suspended) {
                                    j5 = j6;
                                    str5 = str4;
                                    mutableStateFlow5 = mutableStateFlow2;
                                    error = new Result.Success(Unit.INSTANCE);
                                    if (!(error instanceof Result.Success)) {
                                        if (!(error instanceof Result.Error)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                                    }
                                    c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                                    c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                                    c11471.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                                    c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                                    c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                                    c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                                    c11471.L$6 = resultProgressWrapper2;
                                    c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                                    c11471.L$8 = null;
                                    c11471.L$9 = null;
                                    c11471.J$0 = j3;
                                    c11471.J$1 = j5;
                                    c11471.I$0 = i2;
                                    c11471.label = 3;
                                    if (mutableStateFlow5.emit(error, c11471) == coroutine_suspended) {
                                        return resultProgressWrapper2;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                file2 = file3;
                                MutableStateFlow = mutableStateFlow4;
                                c11471 = c11472;
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        mutableStateFlow2 = mutableStateFlow3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    i2 = i7;
                    resultProgressWrapper2 = resultProgressWrapper4;
                    str4 = str7;
                    file2 = file4;
                    mutableStateFlow2 = mutableStateFlow6;
                    mutableStateFlow = mutableStateFlow7;
                    MutableStateFlow = mutableStateFlow8;
                }
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i8 = c11471.I$0;
                    long j7 = c11471.J$1;
                    long j8 = c11471.J$0;
                    ResultProgressWrapper resultProgressWrapper5 = (ResultProgressWrapper) c11471.L$6;
                    ResultKt.throwOnFailure(obj2);
                    return resultProgressWrapper5;
                }
                int i9 = c11471.I$2;
                int i10 = c11471.I$1;
                i2 = c11471.I$0;
                j5 = c11471.J$1;
                long j9 = c11471.J$0;
                mutableStateFlow5 = (MutableStateFlow) c11471.L$8;
                ResultProgressWrapper resultProgressWrapper6 = (ResultProgressWrapper) c11471.L$7;
                ResultProgressWrapper resultProgressWrapper7 = (ResultProgressWrapper) c11471.L$6;
                MutableStateFlow mutableStateFlow9 = (MutableStateFlow) c11471.L$5;
                MutableStateFlow = (MutableStateFlow) c11471.L$4;
                String str8 = (String) c11471.L$3;
                str5 = (String) c11471.L$2;
                File file5 = (File) c11471.L$1;
                ItemId.Remote remote3 = (ItemId.Remote) c11471.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    str3 = str8;
                    mutableStateFlow = mutableStateFlow9;
                    file2 = file5;
                    remote2 = remote3;
                    resultProgressWrapper = resultProgressWrapper6;
                    j3 = j9;
                    resultProgressWrapper2 = resultProgressWrapper7;
                    try {
                        error = new Result.Success(Unit.INSTANCE);
                    } catch (Exception e8) {
                        e = e8;
                        mutableStateFlow2 = mutableStateFlow5;
                        str4 = str5;
                        j6 = j5;
                        error = new Result.Error(e);
                        j5 = j6;
                        str5 = str4;
                        mutableStateFlow5 = mutableStateFlow2;
                    }
                } catch (Exception e9) {
                    e = e9;
                    mutableStateFlow2 = mutableStateFlow5;
                    str3 = str8;
                    mutableStateFlow = mutableStateFlow9;
                    file2 = file5;
                    remote2 = remote3;
                    j6 = j5;
                    str4 = str5;
                    resultProgressWrapper = resultProgressWrapper6;
                    j3 = j9;
                    resultProgressWrapper2 = resultProgressWrapper7;
                }
                if (!(error instanceof Result.Success)) {
                    if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                }
                c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
                c11471.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
                c11471.L$6 = resultProgressWrapper2;
                c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
                c11471.L$8 = null;
                c11471.L$9 = null;
                c11471.J$0 = j3;
                c11471.J$1 = j5;
                c11471.I$0 = i2;
                c11471.label = 3;
                if (mutableStateFlow5.emit(error, c11471) == coroutine_suspended) {
                    return resultProgressWrapper2;
                }
            }
            error = new Result.Error(e);
            j5 = j6;
            str5 = str4;
            mutableStateFlow5 = mutableStateFlow2;
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
            }
            c11471.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
            c11471.L$1 = SpillingKt.nullOutSpilledVariable(file2);
            c11471.L$2 = SpillingKt.nullOutSpilledVariable(str5);
            c11471.L$3 = SpillingKt.nullOutSpilledVariable(str3);
            c11471.L$4 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
            c11471.L$5 = SpillingKt.nullOutSpilledVariable(mutableStateFlow);
            c11471.L$6 = resultProgressWrapper2;
            c11471.L$7 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
            c11471.L$8 = null;
            c11471.L$9 = null;
            c11471.J$0 = j3;
            c11471.J$1 = j5;
            c11471.I$0 = i2;
            c11471.label = 3;
            if (mutableStateFlow5.emit(error, c11471) == coroutine_suspended) {
                return resultProgressWrapper2;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.DownloadFileRemoteDataSource$copyToTargetFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.DownloadFileRemoteDataSource$copyToTargetFile$2", f = "DownloadFileRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {108}, m = "invokeSuspend", n = {"outputStream", "it", "$i$a$-use-DownloadFileRemoteDataSource$copyToTargetFile$2$1", "$i$a$-use-DownloadFileRemoteDataSource$copyToTargetFile$2$1$1"}, s = {"L$1", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $fileSize;
        final /* synthetic */ InputStream $inputStream;
        final /* synthetic */ MutableStateFlow<Progress> $progressFlow;
        final /* synthetic */ File $targetFile;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, InputStream inputStream, long j, MutableStateFlow<Progress> mutableStateFlow, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$targetFile = file;
            this.$inputStream = inputStream;
            this.$fileSize = j;
            this.$progressFlow = mutableStateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$targetFile, this.$inputStream, this.$fileSize, this.$progressFlow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [com.box.android.data.datasource.files.DownloadFileRemoteDataSource$copyToTargetFile$2, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Throwable th;
            ?? r11;
            InputStream inputStream;
            Throwable th2;
            Closeable closeable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FileOutputStream fileOutputStream = new FileOutputStream(this.$targetFile);
                    InputStream inputStream2 = this.$inputStream;
                    long j = this.$fileSize;
                    MutableStateFlow<Progress> mutableStateFlow = this.$progressFlow;
                    try {
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        inputStream = inputStream2;
                        try {
                            InputStream inputStream3 = inputStream;
                            this.L$0 = fileOutputStream;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(fileOutputStream2);
                            this.L$2 = inputStream;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(inputStream3);
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.label = 1;
                            if (SdkFileTransferUtils.INSTANCE.copyTo(inputStream3, fileOutputStream2, j, mutableStateFlow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeable = fileOutputStream;
                        } catch (Throwable th3) {
                            th2 = th3;
                            this = fileOutputStream;
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r11 = fileOutputStream;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(r11, th);
                            throw th5;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inputStream = (Closeable) this.L$2;
                    closeable = (Closeable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        closeable = closeable;
                    } catch (Throwable th6) {
                        th2 = th6;
                        this = closeable;
                        try {
                            throw th2;
                        } catch (Throwable th7) {
                            CloseableKt.closeFinally(inputStream, th2);
                            throw th7;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, null);
                return Unit.INSTANCE;
            } catch (Throwable th8) {
                th = th8;
                r11 = this;
                throw th;
            }
        }
    }

    public final Object copyToTargetFile(InputStream inputStream, long j, File file, MutableStateFlow<Progress> mutableStateFlow, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(file, inputStream, j, mutableStateFlow, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
