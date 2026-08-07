package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.ReferenceDTO;
import com.box.android.data.api.models.annotations.Status;
import com.box.android.domain.models.annotations.CommentMentionModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.UserEventModel;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/annotation/CommentDTODomainMapper;", "Lcom/box/android/data/mappers/annotation/ActivityWithTagsEntityDomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentDTODomainMapper extends ActivityWithTagsEntityDomainMapper<FileActivityModel.CommentModel, CommentDTO> {

    /* JADX INFO: compiled from: CommentDTODomainMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CommentDTODomainMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityModel.CommentModel toDomain(CommentDTO dataModel) {
        FileActivityModel.Status status;
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        String id = dataModel.getId();
        Pair<String, List<CommentMentionModel>> pairTaggedCommentToCommentMentionModels = taggedCommentToCommentMentionModels(dataModel.getMessage(), dataModel.getTaggedMessage());
        String first = pairTaggedCommentToCommentMentionModels != null ? pairTaggedCommentToCommentMentionModels.getFirst() : null;
        if (first == null) {
            first = "";
        }
        Pair<String, List<CommentMentionModel>> pairTaggedCommentToCommentMentionModels2 = taggedCommentToCommentMentionModels(dataModel.getMessage(), dataModel.getTaggedMessage());
        List<CommentMentionModel> second = pairTaggedCommentToCommentMentionModels2 != null ? pairTaggedCommentToCommentMentionModels2.getSecond() : null;
        if (second == null) {
            second = CollectionsKt.emptyList();
        }
        List<CommentMentionModel> list = second;
        UserEventModel userEvent = UserEventMapper.INSTANCE.toUserEvent(dataModel.getCreatedAt(), dataModel.getCreatedBy());
        Date modifiedAt = dataModel.getModifiedAt();
        int totalReplies = dataModel.getTotalReplies();
        int i = WhenMappings.$EnumSwitchMapping$0[dataModel.getStatus().ordinal()];
        if (i == 1) {
            status = FileActivityModel.Status.OPEN;
        } else if (i == 2) {
            status = FileActivityModel.Status.RESOLVED;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            status = FileActivityModel.Status.DELETED;
        }
        FileActivityModel.Status status2 = status;
        FileActivityPermissionsModel domain = FileActivityPermissionsDTOToDomainModelMapper.INSTANCE.toDomain(dataModel.getPermissions());
        ReferenceDTO parent = dataModel.getParent();
        return new FileActivityModel.CommentModel(id, first, list, userEvent, modifiedAt, null, totalReplies, status2, domain, parent != null ? parent.getId() : null, 32, null);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public CommentDTO fromDomain(FileActivityModel.CommentModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
