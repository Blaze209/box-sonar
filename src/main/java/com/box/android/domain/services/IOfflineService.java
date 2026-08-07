package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IOfflineService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 !2\u00020\u0001:\u0001!J \u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0011\"\u00020\u0006H&¢\u0006\u0002\u0010\u0012J8\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\u001f\u001a\u00020 H&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IOfflineService;", "", "offlineItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "getOutdatedOfflineItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineItems", "", AlertFragment.ARG_ITEMS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSizeBigEnoughToSaveOnlyPreviews", "", "itemsToOffline", "", "([Lcom/box/android/domain/models/item/ItemModel;)Z", "makeAvailableOffline", "shouldSaveOriginal", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "(Ljava/util/List;ZLcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromOffline", "isFileOfflined", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatusOfJob", "Lcom/box/android/domain/models/JobInfo$Status;", "itemId", "Lcom/box/android/domain/models/ItemId;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IOfflineService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int SAVE_PREVIEW_PROMPT_LIMIT = 20971520;

    Object getOutdatedOfflineItems(Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation);

    Flow<Result<JobInfo.Status, DomainError>> getStatusOfJob(ItemId itemId);

    Object isFileOfflined(FileModel fileModel, Continuation<? super Boolean> continuation);

    boolean isSizeBigEnoughToSaveOnlyPreviews(ItemModel... itemsToOffline);

    Object makeAvailableOffline(List<? extends ItemModel> list, boolean z, JobTags.JobSource jobSource, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Flow<Result<List<ItemModel>, DomainError>> offlineItems();

    Object removeFromOffline(List<? extends ItemModel> list, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object syncOfflineItems(List<? extends ItemModel> list, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IOfflineService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/services/IOfflineService$Companion;", "", "<init>", "()V", "SAVE_PREVIEW_PROMPT_LIMIT", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SAVE_PREVIEW_PROMPT_LIMIT = 20971520;

        private Companion() {
        }
    }
}
