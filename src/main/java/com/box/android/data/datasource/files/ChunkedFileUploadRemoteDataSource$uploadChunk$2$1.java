package com.box.android.data.datasource.files;

import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$uploadChunk$2$1", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0, 1, 1}, l = {Token.XMLATTR, Token.ARRAYCOMP}, m = "invokeSuspend", n = {"$this$launch", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$uploadChunk$2$1$result$1", "$this$launch", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "I$0", "I$1", "L$0", "L$1"}, v = 1)
final class ChunkedFileUploadRemoteDataSource$uploadChunk$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $contentRange;
    final /* synthetic */ String $digest;
    final /* synthetic */ RequestBody $progressBody;
    final /* synthetic */ MutableStateFlow<Result<UploadFileChunkDTO, RemoteError>> $resultFlow;
    final /* synthetic */ String $uploadChunkEndpoint;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChunkedFileUploadRemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChunkedFileUploadRemoteDataSource$uploadChunk$2$1(MutableStateFlow<Result<UploadFileChunkDTO, RemoteError>> mutableStateFlow, ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource, String str, String str2, String str3, RequestBody requestBody, Continuation<? super ChunkedFileUploadRemoteDataSource$uploadChunk$2$1> continuation) {
        super(2, continuation);
        this.$resultFlow = mutableStateFlow;
        this.this$0 = chunkedFileUploadRemoteDataSource;
        this.$uploadChunkEndpoint = str;
        this.$contentRange = str2;
        this.$digest = str3;
        this.$progressBody = requestBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChunkedFileUploadRemoteDataSource$uploadChunk$2$1 chunkedFileUploadRemoteDataSource$uploadChunk$2$1 = new ChunkedFileUploadRemoteDataSource$uploadChunk$2$1(this.$resultFlow, this.this$0, this.$uploadChunkEndpoint, this.$contentRange, this.$digest, this.$progressBody, continuation);
        chunkedFileUploadRemoteDataSource$uploadChunk$2$1.L$0 = obj;
        return chunkedFileUploadRemoteDataSource$uploadChunk$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChunkedFileUploadRemoteDataSource$uploadChunk$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (r10.$resultFlow.emit(r12, r10) == r2) goto L35;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r11.label
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L2d
            if (r0 == r4) goto L24
            if (r0 != r3) goto L1c
            java.lang.Object r11 = r11.L$1
            com.box.android.domain.utils.result.Result r11 = (com.box.android.domain.utils.result.Result) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbe
        L1c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L24:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L29
            r10 = r11
            goto L4f
        L29:
            r0 = move-exception
            r12 = r0
            r10 = r11
            goto L62
        L2d:
            kotlin.ResultKt.throwOnFailure(r12)
            com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource r12 = r11.this$0
            java.lang.String r6 = r11.$uploadChunkEndpoint
            java.lang.String r7 = r11.$contentRange
            java.lang.String r8 = r11.$digest
            okhttp3.RequestBody r9 = r11.$progressBody
            com.box.android.data.api.requests.ChunkedFileUploadRequest r5 = com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource.access$getChunkedFileUploadRequest$p(r12)     // Catch: java.lang.Exception -> L5f
            r11.L$0 = r1     // Catch: java.lang.Exception -> L5f
            r12 = 0
            r11.I$0 = r12     // Catch: java.lang.Exception -> L5f
            r11.I$1 = r12     // Catch: java.lang.Exception -> L5f
            r11.label = r4     // Catch: java.lang.Exception -> L5f
            r10 = r11
            java.lang.Object r12 = r5.uploadPart(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L5d
            if (r12 != r2) goto L4f
            goto Lbd
        L4f:
            com.box.android.data.api.models.upload.UploadFileChunkDTOWrapper r12 = (com.box.android.data.api.models.upload.UploadFileChunkDTOWrapper) r12     // Catch: java.lang.Exception -> L5d
            com.box.android.data.api.models.upload.UploadFileChunkDTO r11 = r12.getPart()     // Catch: java.lang.Exception -> L5d
            com.box.android.domain.utils.result.Result$Success r12 = new com.box.android.domain.utils.result.Result$Success     // Catch: java.lang.Exception -> L5d
            r12.<init>(r11)     // Catch: java.lang.Exception -> L5d
            com.box.android.domain.utils.result.Result r12 = (com.box.android.domain.utils.result.Result) r12     // Catch: java.lang.Exception -> L5d
            goto L6a
        L5d:
            r0 = move-exception
            goto L61
        L5f:
            r0 = move-exception
            r10 = r11
        L61:
            r12 = r0
        L62:
            com.box.android.domain.utils.result.Result$Error r11 = new com.box.android.domain.utils.result.Result$Error
            r11.<init>(r12)
            r12 = r11
            com.box.android.domain.utils.result.Result r12 = (com.box.android.domain.utils.result.Result) r12
        L6a:
            com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource r11 = r10.this$0
            boolean r0 = r12 instanceof com.box.android.domain.utils.result.Result.Success
            if (r0 == 0) goto L71
            goto La4
        L71:
            boolean r0 = r12 instanceof com.box.android.domain.utils.result.Result.Error
            if (r0 == 0) goto Lc1
            com.box.android.domain.utils.result.Result$Error r12 = (com.box.android.domain.utils.result.Result.Error) r12
            java.lang.Object r12 = r12.getValue()
            java.lang.Exception r12 = (java.lang.Exception) r12
            java.lang.String r0 = com.box.android.domain.utils.ExtensionsKt.getTAG(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Exception uploading chunk: "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r4 = r4.toString()
            com.box.androidsdk.content.utils.BoxLogUtils.e(r0, r4)
            com.box.android.data.datasource.errors.UploadErrorUtil r0 = com.box.android.data.datasource.errors.UploadErrorUtil.INSTANCE
            com.squareup.moshi.Moshi r11 = com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource.access$getMoshi$p(r11)
            com.box.android.data.datasource.errors.RemoteError r11 = r0.getRemoteErrorFromApiException(r12, r11)
            com.box.android.domain.utils.result.Result$Error r12 = new com.box.android.domain.utils.result.Result$Error
            r12.<init>(r11)
            com.box.android.domain.utils.result.Result r12 = (com.box.android.domain.utils.result.Result) r12
        La4:
            kotlinx.coroutines.flow.MutableStateFlow<com.box.android.domain.utils.result.Result<com.box.android.data.api.models.upload.UploadFileChunkDTO, com.box.android.data.datasource.errors.RemoteError>> r11 = r10.$resultFlow
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r10.L$1 = r1
            r10.label = r3
            java.lang.Object r11 = r11.emit(r12, r0)
            if (r11 != r2) goto Lbe
        Lbd:
            return r2
        Lbe:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lc1:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$uploadChunk$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
