package com.box.android.domain.models;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.R;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRemoteItemService;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/MarkForOfflineJobDisplayInfoProvider;", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", JobConstants.SHOW_NOTIFICATION, "", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/services/IRemoteItemService;Z)V", "getItemId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getShowNotification", "()Z", "getName", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "()Ljava/lang/String;", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getServerId", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkForOfflineJobDisplayInfoProvider implements IJobDisplayInfoProvider {
    private final ItemId.Remote itemId;
    private final IRemoteItemService itemService;
    private final String jobType;
    private final boolean showNotification;

    /* JADX INFO: renamed from: com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider$getItemModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {204}, m = "getItemModel", n = {}, s = {}, v = 1)
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
            return MarkForOfflineJobDisplayInfoProvider.this.getItemModel(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider$getName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {197}, m = "getName", n = {}, s = {}, v = 1)
    static final class C16131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16131(Continuation<? super C16131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineJobDisplayInfoProvider.this.getName(this);
        }
    }

    public MarkForOfflineJobDisplayInfoProvider(ItemId.Remote itemId, IRemoteItemService itemService, boolean z) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.itemId = itemId;
        this.itemService = itemService;
        this.showNotification = z;
        this.jobType = JobType.MARK_FOR_OFFLINE;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ Object getItemDescription(Continuation<? super String> continuation) {
        return super.getItemDescription(continuation);
    }

    public final ItemId.Remote getItemId() {
        return this.itemId;
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public boolean getShowNotification() {
        return this.showNotification;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getName(Continuation<? super String> continuation) {
        C16131 c16131;
        String name;
        if (continuation instanceof C16131) {
            c16131 = (C16131) continuation;
            if ((c16131.label & Integer.MIN_VALUE) != 0) {
                c16131.label -= Integer.MIN_VALUE;
            } else {
                c16131 = new C16131(continuation);
            }
        } else {
            c16131 = new C16131(continuation);
        }
        Object itemModel = c16131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            c16131.label = 1;
            itemModel = getItemModel(c16131);
            if (itemModel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemModel);
        }
        ItemModel itemModel2 = (ItemModel) itemModel;
        return (itemModel2 == null || (name = itemModel2.getName()) == null) ? CommonBoxUtil.LS(R.string.save_for_offline) : name;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public int getIconResId() {
        return CommonBoxUtil.getDrawableResIdByName("ic_checkmark_badge_underline");
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public String getJobType() {
        return this.jobType;
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
        Object objItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            IRemoteItemService iRemoteItemService = this.itemService;
            ItemId.Remote remote = this.itemId;
            DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
            anonymousClass1.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) anonymousClass1);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        return com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getServerId(Continuation<? super String> continuation) {
        return this.itemId.getBoxId();
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Integer errorStringRes(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Integer offlineErrorStringRes = JobInfoProvidersKt.getOfflineErrorStringRes(error);
        return offlineErrorStringRes == null ? JobInfoProvidersKt.getFileDownloadErrorStringRes(error) : offlineErrorStringRes;
    }
}
