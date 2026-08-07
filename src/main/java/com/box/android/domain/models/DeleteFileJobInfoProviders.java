package com.box.android.domain.models;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobInfoProviders.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u0012J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/DeleteFileJobInfoProviders;", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "itemId", "Lcom/box/android/domain/models/ItemId;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IdMappingService;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "getName", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "()Ljava/lang/String;", "getServerId", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteFileJobInfoProviders implements IJobDisplayInfoProvider {
    private final IdMappingService idMappingService;
    private final ItemId itemId;
    private final ILocalItemService localItemService;

    /* JADX INFO: renamed from: com.box.android.domain.models.DeleteFileJobInfoProviders$getItemModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.DeleteFileJobInfoProviders", f = "JobInfoProviders.kt", i = {}, l = {28}, m = "getItemModel", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteFileJobInfoProviders.this.getItemModel(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.DeleteFileJobInfoProviders$getName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.DeleteFileJobInfoProviders", f = "JobInfoProviders.kt", i = {}, l = {18}, m = "getName", n = {}, s = {}, v = 1)
    static final class C16111 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16111(Continuation<? super C16111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteFileJobInfoProviders.this.getName(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.DeleteFileJobInfoProviders$getServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.DeleteFileJobInfoProviders", f = "JobInfoProviders.kt", i = {}, l = {26}, m = "getServerId", n = {}, s = {}, v = 1)
    static final class C16121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16121(Continuation<? super C16121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteFileJobInfoProviders.this.getServerId(this);
        }
    }

    public DeleteFileJobInfoProviders(ItemId itemId, ILocalItemService localItemService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.itemId = itemId;
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
    }

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ Object getItemDescription(Continuation<? super String> continuation) {
        return super.getItemDescription(continuation);
    }

    public final ItemId getItemId() {
        return this.itemId;
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ boolean getShowNotification() {
        return super.getShowNotification();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getName(Continuation<? super String> continuation) {
        C16111 c16111;
        if (continuation instanceof C16111) {
            c16111 = (C16111) continuation;
            if ((c16111.label & Integer.MIN_VALUE) != 0) {
                c16111.label -= Integer.MIN_VALUE;
            } else {
                c16111 = new C16111(continuation);
            }
        } else {
            c16111 = new C16111(continuation);
        }
        Object itemModel = c16111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            c16111.label = 1;
            itemModel = getItemModel(c16111);
            if (itemModel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemModel);
        }
        return ((ItemModel) itemModel).getName();
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public int getIconResId() {
        return CommonBoxUtil.getDrawableResIdByName("ic_trash24");
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public String getJobType() {
        return JobType.DELETE_FILE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getServerId(Continuation<? super String> continuation) {
        C16121 c16121;
        if (continuation instanceof C16121) {
            c16121 = (C16121) continuation;
            if ((c16121.label & Integer.MIN_VALUE) != 0) {
                c16121.label -= Integer.MIN_VALUE;
            } else {
                c16121 = new C16121(continuation);
            }
        } else {
            c16121 = new C16121(continuation);
        }
        Object remoteId = c16121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16121.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            ItemId itemId = this.itemId;
            c16121.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, c16121);
            if (remoteId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteId);
        }
        ItemId.Remote remote = (ItemId.Remote) remoteId;
        if (remote != null) {
            return remote.getBoxId();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemModel(Continuation<? super ItemModel> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object itemByLocalId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ILocalItemService iLocalItemService = this.localItemService;
            ItemId itemId = this.itemId;
            anonymousClass1.label = 1;
            itemByLocalId = iLocalItemService.getItemByLocalId(itemId, anonymousClass1);
            if (itemByLocalId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemByLocalId);
        }
        Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) itemByLocalId);
        Intrinsics.checkNotNull(orNull);
        return orNull;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Integer errorStringRes(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String str = error instanceof FileUploadDomainError.AccessDeniedError ? "upload_job_permissions_error" : null;
        if (str != null) {
            return Integer.valueOf(CommonBoxUtil.getStringResIdByName(str));
        }
        return null;
    }
}
