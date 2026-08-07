package com.box.android.data.datasource;

import com.box.android.data.api.requests.PreviewDownloadRequest;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxDocumentFile;
import com.squareup.moshi.Moshi;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: PreviewDownloadRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/datasource/PreviewDownloadRemoteDataSource;", "", "previewDownloadRequest", "Lcom/box/android/data/api/requests/PreviewDownloadRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "legacyPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/api/requests/PreviewDownloadRequest;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/controller/IPreviewController;Lkotlinx/coroutines/CoroutineDispatcher;)V", "downloadOriginalPreview", "Lcom/box/android/domain/utils/result/Result;", "Ljava/net/URI;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTargetFile", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/io/InputStream;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewDownloadRemoteDataSource {
    private final CoroutineDispatcher ioDispatcher;
    private final IPreviewController legacyPreviewController;
    private final Moshi moshi;
    private final PreviewDownloadRequest previewDownloadRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.PreviewDownloadRemoteDataSource$downloadOriginalPreview$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewDownloadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PreviewDownloadRemoteDataSource", f = "PreviewDownloadRemoteDataSource.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {32, 41}, m = "downloadOriginalPreview", n = {"fileModel", "$i$f$resultOf", "$i$a$-resultOf-PreviewDownloadRemoteDataSource$downloadOriginalPreview$2", "fileModel", "responseBody", "notifyingOutputStream", "$i$f$resultOf", "$i$a$-resultOf-PreviewDownloadRemoteDataSource$downloadOriginalPreview$2", "$i$a$-use-PreviewDownloadRemoteDataSource$downloadOriginalPreview$2$1"}, s = {"L$0", "I$0", "I$1", "L$0", "L$2", "L$3", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewDownloadRemoteDataSource.this.downloadOriginalPreview(null, this);
        }
    }

    @Inject
    public PreviewDownloadRemoteDataSource(PreviewDownloadRequest previewDownloadRequest, Moshi moshi, IPreviewController legacyPreviewController, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(previewDownloadRequest, "previewDownloadRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(legacyPreviewController, "legacyPreviewController");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.previewDownloadRequest = previewDownloadRequest;
        this.moshi = moshi;
        this.legacyPreviewController = legacyPreviewController;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:59:0x010a  */
    /* JADX WARN: Code duplicated, block: B:60:0x014f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:67:0x015c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0179  */
    /* JADX WARN: Code duplicated, block: B:71:0x017f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    public final Object downloadOriginalPreview(FileModel fileModel, Continuation<? super Result<URI, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        FileModel fileModel2;
        int i;
        int i2;
        Closeable closeable;
        ResponseBody responseBody;
        OutputStream fileOutputStream;
        Closeable closeable2;
        Result.Error error;
        Throwable th;
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
        Object objDownloadPreview$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objDownloadPreview$default);
            try {
                PreviewDownloadRequest previewDownloadRequest = this.previewDownloadRequest;
                String strBoxIdOrThrow = fileModel.boxIdOrThrow();
                FileVersionMiniModel fileVersion = fileModel.getFileVersion();
                String id = fileVersion != null ? fileVersion.getId() : null;
                fileModel2 = fileModel;
                try {
                    anonymousClass2.L$0 = fileModel2;
                    anonymousClass2.I$0 = 0;
                    anonymousClass2.I$1 = 0;
                    anonymousClass2.label = 1;
                    objDownloadPreview$default = PreviewDownloadRequest.downloadPreview$default(previewDownloadRequest, strBoxIdOrThrow, id, false, null, anonymousClass2, 12, null);
                    if (objDownloadPreview$default != coroutine_suspended) {
                        i = 0;
                        i2 = 0;
                        closeable = (Closeable) objDownloadPreview$default;
                        responseBody = (ResponseBody) closeable;
                        File cachedPreviewFile = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                        Intrinsics.checkNotNullExpressionValue(cachedPreviewFile, "getCachedPreviewFile(...)");
                        fileOutputStream = new FileOutputStream(cachedPreviewFile);
                        anonymousClass2.L$0 = fileModel2;
                        anonymousClass2.L$1 = closeable;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(fileOutputStream);
                        anonymousClass2.I$0 = i2;
                        anonymousClass2.I$1 = i;
                        anonymousClass2.I$2 = 0;
                        anonymousClass2.label = 2;
                        if (copyToTargetFile(responseBody.byteStream(), fileOutputStream, anonymousClass2) != coroutine_suspended) {
                            closeable2 = closeable;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(closeable2, null);
                            error = new Result.Success(Unit.INSTANCE);
                            if (error instanceof Result.Success) {
                                File cachedPreviewFile2 = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                                BoxDocumentFile boxDocumentFile = new BoxDocumentFile(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel2, false, 1, null));
                                boxDocumentFile.setContentLength(cachedPreviewFile2.length());
                                this.legacyPreviewController.getStorage().cacheMetadata(boxDocumentFile, "doc", PreviewContentType.Original.INSTANCE);
                                error = new Result.Success(cachedPreviewFile2.toURI());
                            } else if (!(error instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (error instanceof Result.Success) {
                                return error;
                            }
                            if (error instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e) {
                    e = e;
                    error = new Result.Error(e);
                    if (error instanceof Result.Success) {
                        File cachedPreviewFile3 = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                        BoxDocumentFile boxDocumentFile2 = new BoxDocumentFile(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel2, false, 1, null));
                        boxDocumentFile2.setContentLength(cachedPreviewFile3.length());
                        this.legacyPreviewController.getStorage().cacheMetadata(boxDocumentFile2, "doc", PreviewContentType.Original.INSTANCE);
                        error = new Result.Success(cachedPreviewFile3.toURI());
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (error instanceof Result.Success) {
                        return error;
                    }
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                }
            } catch (Exception e2) {
                e = e2;
                fileModel2 = fileModel;
                error = new Result.Error(e);
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = anonymousClass2.I$2;
                int i5 = anonymousClass2.I$1;
                int i6 = anonymousClass2.I$0;
                closeable2 = (Closeable) anonymousClass2.L$1;
                FileModel fileModel3 = (FileModel) anonymousClass2.L$0;
                try {
                    ResultKt.throwOnFailure(objDownloadPreview$default);
                    fileModel2 = fileModel3;
                    try {
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable2, null);
                        error = new Result.Success(Unit.INSTANCE);
                        if (error instanceof Result.Success) {
                            File cachedPreviewFile4 = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                            BoxDocumentFile boxDocumentFile3 = new BoxDocumentFile(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel2, false, 1, null));
                            boxDocumentFile3.setContentLength(cachedPreviewFile4.length());
                            this.legacyPreviewController.getStorage().cacheMetadata(boxDocumentFile3, "doc", PreviewContentType.Original.INSTANCE);
                            error = new Result.Success(cachedPreviewFile4.toURI());
                        } else if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (error instanceof Result.Success) {
                            return error;
                        }
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = closeable2;
                        th = th;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(closeable, th);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    closeable = closeable2;
                    fileModel2 = fileModel3;
                    th = th;
                    throw th;
                }
            }
            i = anonymousClass2.I$1;
            i2 = anonymousClass2.I$0;
            FileModel fileModel4 = (FileModel) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(objDownloadPreview$default);
                fileModel2 = fileModel4;
                closeable = (Closeable) objDownloadPreview$default;
                try {
                    responseBody = (ResponseBody) closeable;
                    File cachedPreviewFile5 = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(cachedPreviewFile5, "getCachedPreviewFile(...)");
                    fileOutputStream = new FileOutputStream(cachedPreviewFile5);
                    anonymousClass2.L$0 = fileModel2;
                    anonymousClass2.L$1 = closeable;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(fileOutputStream);
                    anonymousClass2.I$0 = i2;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.I$2 = 0;
                    anonymousClass2.label = 2;
                    if (copyToTargetFile(responseBody.byteStream(), fileOutputStream, anonymousClass2) != coroutine_suspended) {
                        closeable2 = closeable;
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable2, null);
                        error = new Result.Success(Unit.INSTANCE);
                        if (error instanceof Result.Success) {
                            File cachedPreviewFile6 = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel2, (String) null, PreviewContentType.Original.INSTANCE);
                            BoxDocumentFile boxDocumentFile4 = new BoxDocumentFile(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel2, false, 1, null));
                            boxDocumentFile4.setContentLength(cachedPreviewFile6.length());
                            this.legacyPreviewController.getStorage().cacheMetadata(boxDocumentFile4, "doc", PreviewContentType.Original.INSTANCE);
                            error = new Result.Success(cachedPreviewFile6.toURI());
                        } else if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (error instanceof Result.Success) {
                            return error;
                        }
                        if (error instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
                    }
                    return coroutine_suspended;
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileModel2 = fileModel4;
                error = new Result.Error(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.PreviewDownloadRemoteDataSource$copyToTargetFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewDownloadRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PreviewDownloadRemoteDataSource$copyToTargetFile$2", f = "PreviewDownloadRemoteDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ InputStream $inputStream;
        final /* synthetic */ OutputStream $outputStream;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InputStream inputStream, OutputStream outputStream, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$inputStream = inputStream;
            this.$outputStream = outputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$inputStream, this.$outputStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                long jCopyTo$default = ByteStreamsKt.copyTo$default(this.$inputStream, this.$outputStream, 0, 2, null);
                return Boxing.boxLong(jCopyTo$default);
            } finally {
                this.$inputStream.close();
                this.$outputStream.flush();
                this.$outputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object copyToTargetFile(InputStream inputStream, OutputStream outputStream, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(inputStream, outputStream, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
