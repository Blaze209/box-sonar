package com.box.android.data.service.impl;

import android.content.Context;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileMetadataService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService$extractAndUploadFileProperties$2$1", f = "FileMetadataService.kt", i = {0, 1, 1}, l = {84, 92}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "formattedProperties"}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class FileMetadataService$extractAndUploadFileProperties$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $contentUriOrPath;
    final /* synthetic */ Context $context;
    final /* synthetic */ ItemId.Remote $fileId;
    final /* synthetic */ String $fileName;
    final /* synthetic */ boolean $replaceExistingCaptureMetadata;
    final /* synthetic */ FileMetadataService $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileMetadataService$extractAndUploadFileProperties$2$1(boolean z, FileMetadataService fileMetadataService, ItemId.Remote remote, Context context, String str, String str2, Continuation<? super FileMetadataService$extractAndUploadFileProperties$2$1> continuation) {
        super(2, continuation);
        this.$replaceExistingCaptureMetadata = z;
        this.$this_runCatching = fileMetadataService;
        this.$fileId = remote;
        this.$context = context;
        this.$contentUriOrPath = str;
        this.$fileName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileMetadataService$extractAndUploadFileProperties$2$1 fileMetadataService$extractAndUploadFileProperties$2$1 = new FileMetadataService$extractAndUploadFileProperties$2$1(this.$replaceExistingCaptureMetadata, this.$this_runCatching, this.$fileId, this.$context, this.$contentUriOrPath, this.$fileName, continuation);
        fileMetadataService$extractAndUploadFileProperties$2$1.L$0 = obj;
        return fileMetadataService$extractAndUploadFileProperties$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileMetadataService$extractAndUploadFileProperties$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r8 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
    
        if (r8 == r1) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileMetadataService$extractAndUploadFileProperties$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
