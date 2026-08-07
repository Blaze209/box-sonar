package com.box.android.domain.services;

import androidx.paging.DataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IFileActivitiesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u0004\u0012\u00020\u00070\u00030\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0011\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IFileActivitiesService;", "", "activities", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "activitiesV2", "Lkotlinx/coroutines/flow/Flow;", "", "fileItemId", "Lcom/box/android/domain/models/ItemId;", "replies", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "activityID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchActivitiesFromRemote", "", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFileActivitiesService {
    Result<DataSource.Factory<Integer, FileActivityModel>, DomainError> activities(String fileId);

    Flow<Result<List<FileActivityModel>, DomainError>> activitiesV2(ItemId fileItemId);

    Object fetchActivitiesFromRemote(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object replies(String str, Continuation<? super Result<? extends List<FileActivityModel.CommentModel>, ? extends DomainError>> continuation);
}
