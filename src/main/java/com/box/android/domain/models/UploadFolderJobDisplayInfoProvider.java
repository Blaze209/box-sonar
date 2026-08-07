package com.box.android.domain.models;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0017\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020#H\u0016¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/box/android/domain/models/UploadFolderJobDisplayInfoProvider;", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "itemId", "Lcom/box/android/domain/models/ItemId;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", JobConstants.SHOW_NOTIFICATION, "", "<init>", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IdMappingService;Z)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "getShowNotification", "()Z", "getName", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "()Ljava/lang/String;", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getServerId", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "getItemDescription", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFolderJobDisplayInfoProvider implements IJobDisplayInfoProvider {
    private final IdMappingService idMappingService;
    private final ItemId itemId;
    private final String jobType;
    private final ILocalItemService localItemService;
    private final boolean showNotification;

    /* JADX INFO: renamed from: com.box.android.domain.models.UploadFolderJobDisplayInfoProvider$getItemDescription$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.UploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {254}, m = "getItemDescription", n = {}, s = {}, v = 1)
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
            return UploadFolderJobDisplayInfoProvider.this.getItemDescription(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.UploadFolderJobDisplayInfoProvider$getItemModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.UploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {248}, m = "getItemModel", n = {}, s = {}, v = 1)
    static final class C16191 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16191(Continuation<? super C16191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJobDisplayInfoProvider.this.getItemModel(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.UploadFolderJobDisplayInfoProvider$getName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.UploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {241}, m = "getName", n = {}, s = {}, v = 1)
    static final class C16201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16201(Continuation<? super C16201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJobDisplayInfoProvider.this.getName(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.UploadFolderJobDisplayInfoProvider$getServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.UploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {250}, m = "getServerId", n = {}, s = {}, v = 1)
    static final class C16211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16211(Continuation<? super C16211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFolderJobDisplayInfoProvider.this.getServerId(this);
        }
    }

    public UploadFolderJobDisplayInfoProvider(ItemId itemId, ILocalItemService localItemService, IdMappingService idMappingService, boolean z) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.itemId = itemId;
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
        this.showNotification = z;
        this.jobType = JobType.UPLOAD_FOLDER_V2;
    }

    public final ItemId getItemId() {
        return this.itemId;
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public boolean getShowNotification() {
        return this.showNotification;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getName(Continuation<? super String> continuation) {
        C16201 c16201;
        if (continuation instanceof C16201) {
            c16201 = (C16201) continuation;
            if ((c16201.label & Integer.MIN_VALUE) != 0) {
                c16201.label -= Integer.MIN_VALUE;
            } else {
                c16201 = new C16201(continuation);
            }
        } else {
            c16201 = new C16201(continuation);
        }
        Object itemModel = c16201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            c16201.label = 1;
            itemModel = getItemModel(c16201);
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
        return CommonBoxUtil.getDrawableResIdByName("ic_file_upload_grey_24dp");
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public String getJobType() {
        return this.jobType;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemModel(Continuation<? super ItemModel> continuation) {
        C16191 c16191;
        if (continuation instanceof C16191) {
            c16191 = (C16191) continuation;
            if ((c16191.label & Integer.MIN_VALUE) != 0) {
                c16191.label -= Integer.MIN_VALUE;
            } else {
                c16191 = new C16191(continuation);
            }
        } else {
            c16191 = new C16191(continuation);
        }
        Object itemByLocalId = c16191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ILocalItemService iLocalItemService = this.localItemService;
            ItemId itemId = this.itemId;
            c16191.label = 1;
            itemByLocalId = iLocalItemService.getItemByLocalId(itemId, c16191);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getServerId(Continuation<? super String> continuation) {
        C16211 c16211;
        if (continuation instanceof C16211) {
            c16211 = (C16211) continuation;
            if ((c16211.label & Integer.MIN_VALUE) != 0) {
                c16211.label -= Integer.MIN_VALUE;
            } else {
                c16211 = new C16211(continuation);
            }
        } else {
            c16211 = new C16211(continuation);
        }
        Object remoteId = c16211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16211.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            ItemId itemId = this.itemId;
            c16211.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, c16211);
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

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Integer errorStringRes(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return JobInfoProvidersKt.getFileUploadErrorStringRes(error);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemDescription(Continuation<? super String> continuation) {
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
        Object itemModel = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            anonymousClass1.label = 1;
            itemModel = getItemModel(anonymousClass1);
            if (itemModel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemModel);
        }
        return ItemModelKt.parentConsideringRootFolder((ItemModel) itemModel);
    }
}
