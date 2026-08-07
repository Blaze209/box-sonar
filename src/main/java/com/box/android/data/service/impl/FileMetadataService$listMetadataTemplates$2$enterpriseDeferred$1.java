package com.box.android.data.service.impl;

import com.box.android.data.api.models.MetadataTemplateDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileMetadataService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/MetadataTemplateDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1", f = "FileMetadataService.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends MetadataTemplateDTO>, ? extends RemoteError>>, Object> {
    int label;
    final /* synthetic */ FileMetadataService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1(FileMetadataService fileMetadataService, Continuation<? super FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = fileMetadataService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends MetadataTemplateDTO>, ? extends RemoteError>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<? extends List<MetadataTemplateDTO>, ? extends RemoteError>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<MetadataTemplateDTO>, ? extends RemoteError>> continuation) {
        return ((FileMetadataService$listMetadataTemplates$2$enterpriseDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objListEnterpriseMetadataTemplates = this.this$0.metadataTemplatesRemoteDataSource.listEnterpriseMetadataTemplates(this);
        return objListEnterpriseMetadataTemplates == coroutine_suspended ? coroutine_suspended : objListEnterpriseMetadataTemplates;
    }
}
