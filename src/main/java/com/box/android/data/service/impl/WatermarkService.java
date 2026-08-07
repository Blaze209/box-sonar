package com.box.android.data.service.impl;

import com.box.android.data.datasource.WatermarkRemoteDataSource;
import com.box.android.domain.services.IWatermarkService;
import com.box.android.domain.services.IdMappingService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0011\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0011\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/service/impl/WatermarkService;", "Lcom/box/android/domain/services/IWatermarkService;", "watermarkRemoteDataSource", "Lcom/box/android/data/datasource/WatermarkRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/WatermarkRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;)V", "applyWatermarkToFile", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeWatermarkFromFile", "applyWatermarkToFolder", "folderId", "removeWatermarkFromFolder", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkService implements IWatermarkService {
    private final IdMappingService idMappingService;
    private final WatermarkRemoteDataSource watermarkRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.WatermarkService$applyWatermarkToFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: WatermarkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.WatermarkService", f = "WatermarkService.kt", i = {0, 1, 1, 1, 1, 1}, l = {21, 22}, m = "applyWatermarkToFile", n = {"fileId", "fileId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-WatermarkService$applyWatermarkToFile$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkService.this.applyWatermarkToFile(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.WatermarkService$applyWatermarkToFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.WatermarkService", f = "WatermarkService.kt", i = {0, 1, 1, 1, 1, 1}, l = {31, 32}, m = "applyWatermarkToFolder", n = {"folderId", "folderId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-WatermarkService$applyWatermarkToFolder$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C15351 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15351(Continuation<? super C15351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkService.this.applyWatermarkToFolder(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.WatermarkService", f = "WatermarkService.kt", i = {0, 1, 1, 1, 1, 1}, l = {26, 27}, m = "removeWatermarkFromFile", n = {"fileId", "fileId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-WatermarkService$removeWatermarkFromFile$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C15361 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15361(Continuation<? super C15361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkService.this.removeWatermarkFromFile(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.WatermarkService", f = "WatermarkService.kt", i = {0, 1, 1, 1, 1, 1}, l = {36, 37}, m = "removeWatermarkFromFolder", n = {"folderId", "folderId", "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-WatermarkService$removeWatermarkFromFolder$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C15371 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15371(Continuation<? super C15371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkService.this.removeWatermarkFromFolder(null, this);
        }
    }

    @Inject
    public WatermarkService(WatermarkRemoteDataSource watermarkRemoteDataSource, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(watermarkRemoteDataSource, "watermarkRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.watermarkRemoteDataSource = watermarkRemoteDataSource;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IWatermarkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object applyWatermarkToFile(com.box.android.domain.models.ItemId r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.service.impl.WatermarkService.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.service.impl.WatermarkService$applyWatermarkToFile$1 r0 = (com.box.android.data.service.impl.WatermarkService.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.service.impl.WatermarkService$applyWatermarkToFile$1 r0 = new com.box.android.data.service.impl.WatermarkService$applyWatermarkToFile$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L96
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L4d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.domain.services.IdMappingService r7 = r5.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getRemoteIdOrError(r6, r0)
            if (r7 != r1) goto L61
            goto L95
        L61:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L99
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.data.datasource.WatermarkRemoteDataSource r5 = r5.watermarkRemoteDataSource
            java.lang.String r4 = r2.getBoxId()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.applyWatermarkToFile(r4, r0)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            return r7
        L99:
            boolean r5 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L9e
            return r7
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.WatermarkService.applyWatermarkToFile(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IWatermarkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object removeWatermarkFromFile(com.box.android.domain.models.ItemId r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.service.impl.WatermarkService.C15361
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFile$1 r0 = (com.box.android.data.service.impl.WatermarkService.C15361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFile$1 r0 = new com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFile$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L96
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L4d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.domain.services.IdMappingService r7 = r5.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getRemoteIdOrError(r6, r0)
            if (r7 != r1) goto L61
            goto L95
        L61:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L99
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.data.datasource.WatermarkRemoteDataSource r5 = r5.watermarkRemoteDataSource
            java.lang.String r4 = r2.getBoxId()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.removeWatermarkFromFile(r4, r0)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            return r7
        L99:
            boolean r5 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L9e
            return r7
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.WatermarkService.removeWatermarkFromFile(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IWatermarkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object applyWatermarkToFolder(com.box.android.domain.models.ItemId r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.service.impl.WatermarkService.C15351
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.service.impl.WatermarkService$applyWatermarkToFolder$1 r0 = (com.box.android.data.service.impl.WatermarkService.C15351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.service.impl.WatermarkService$applyWatermarkToFolder$1 r0 = new com.box.android.data.service.impl.WatermarkService$applyWatermarkToFolder$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L96
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L4d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.domain.services.IdMappingService r7 = r5.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getRemoteIdOrError(r6, r0)
            if (r7 != r1) goto L61
            goto L95
        L61:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L99
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.data.datasource.WatermarkRemoteDataSource r5 = r5.watermarkRemoteDataSource
            java.lang.String r4 = r2.getBoxId()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.applyWatermarkToFolder(r4, r0)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            return r7
        L99:
            boolean r5 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L9e
            return r7
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.WatermarkService.applyWatermarkToFolder(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IWatermarkService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object removeWatermarkFromFolder(com.box.android.domain.models.ItemId r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.service.impl.WatermarkService.C15371
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFolder$1 r0 = (com.box.android.data.service.impl.WatermarkService.C15371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFolder$1 r0 = new com.box.android.data.service.impl.WatermarkService$removeWatermarkFromFolder$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L96
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L4d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.domain.services.IdMappingService r7 = r5.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getRemoteIdOrError(r6, r0)
            if (r7 != r1) goto L61
            goto L95
        L61:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L99
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.data.datasource.WatermarkRemoteDataSource r5 = r5.watermarkRemoteDataSource
            java.lang.String r4 = r2.getBoxId()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.removeWatermarkFromFolder(r4, r0)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            return r7
        L99:
            boolean r5 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L9e
            return r7
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.WatermarkService.removeWatermarkFromFolder(com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
