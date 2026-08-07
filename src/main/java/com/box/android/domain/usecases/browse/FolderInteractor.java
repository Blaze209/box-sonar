package com.box.android.domain.usecases.browse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/usecases/browse/FolderInteractor;", "Lcom/box/android/domain/usecases/browse/FolderUseCase;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;)V", "rootFolder", "Lcom/box/android/domain/models/ItemId$Remote;", "getFolderHierarchy", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", TypedValues.TransitionType.S_FROM, "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolder", "Lcom/box/android/domain/models/item/FolderModel;", "folderId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FolderInteractor implements FolderUseCase {
    private final IRemoteItemService itemService;
    private final ItemId.Remote rootFolder;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderInteractor$getFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: FolderInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderInteractor", f = "FolderInteractor.kt", i = {0}, l = {59}, m = "getFolder", n = {"folderId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FolderInteractor.this.getFolder(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderInteractor$getFolderHierarchy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FolderInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderInteractor", f = "FolderInteractor.kt", i = {0, 0, 0, 1, 1, 1}, l = {30, 40}, m = "getFolderHierarchy", n = {TypedValues.TransitionType.S_FROM, "resultList", "parentFolderRemoteId", TypedValues.TransitionType.S_FROM, "resultList", "parentFolderRemoteId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C16241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C16241(Continuation<? super C16241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FolderInteractor.this.getFolderHierarchy(null, this);
        }
    }

    @Inject
    public FolderInteractor(IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.itemService = itemService;
        this.rootFolder = new ItemId.Remote("0", ItemType.FOLDER);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:22:0x008a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0096  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008a -> B:23:0x0090). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.usecases.browse.FolderUseCase
    public java.lang.Object getFolderHierarchy(com.box.android.domain.models.ItemId.Remote r31, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<? extends com.box.android.domain.models.item.ItemModel>, ? extends com.box.android.domain.models.DomainError>> r32) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.browse.FolderInteractor.getFolderHierarchy(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.browse.FolderUseCase
    public Object getFolder(ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
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
            DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
            anonymousClass1.L$0 = remote;
            anonymousClass1.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) anonymousClass1);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            remote = (ItemId.Remote) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objItem);
        }
        Result result = (Result) objItem;
        if (result instanceof Result.Success) {
            ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
            if (itemModel instanceof FolderModel) {
                return new Result.Success(itemModel);
            }
            return new Result.Error(new DomainError.UnknownError("Fetched item of id " + remote.getBoxId() + " is not a folder"));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }
}
