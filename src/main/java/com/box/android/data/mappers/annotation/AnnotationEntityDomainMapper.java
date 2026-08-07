package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.annotations.DescriptionDTO;
import com.box.android.data.api.models.annotations.FileActivityPermissionsDTO;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityStatus;
import com.box.android.domain.models.annotations.AnnotationFileVersionModel;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import com.box.android.domain.models.annotations.CommentMentionModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.domain.models.annotations.UserEventModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J&\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/mappers/annotation/AnnotationEntityDomainMapper;", "Lcom/box/android/data/mappers/annotation/ActivityWithTagsEntityDomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "commentEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getCommentEntityDomainMapper", "()Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;", "toDomain", "dataModel", "fileId", "", "replies", "", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationEntityDomainMapper extends ActivityWithTagsEntityDomainMapper<FileActivityModel.AnnotationModel, AnnotationEntity> {
    private final CommentEntityDomainMapper commentEntityDomainMapper;
    private final Moshi moshi;

    /* JADX INFO: compiled from: AnnotationEntityDomainMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileActivityStatus.values().length];
            try {
                iArr[FileActivityStatus.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileActivityStatus.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileActivityStatus.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public AnnotationEntityDomainMapper(Moshi moshi, CommentEntityDomainMapper commentEntityDomainMapper) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(commentEntityDomainMapper, "commentEntityDomainMapper");
        this.moshi = moshi;
        this.commentEntityDomainMapper = commentEntityDomainMapper;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final CommentEntityDomainMapper getCommentEntityDomainMapper() {
        return this.commentEntityDomainMapper;
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityModel.AnnotationModel toDomain(AnnotationEntity dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileActivityModel.AnnotationModel toDomain$default(AnnotationEntityDomainMapper annotationEntityDomainMapper, AnnotationEntity annotationEntity, String str, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return annotationEntityDomainMapper.toDomain(annotationEntity, str, list);
    }

    public final FileActivityModel.AnnotationModel toDomain(AnnotationEntity dataModel, String fileId, List<CommentEntity> replies) {
        Location location;
        FileActivityModel.Status status;
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(DescriptionDTO.class);
        JsonAdapter jsonAdapterAdapter2 = this.moshi.adapter(UserMiniDTO.class);
        JsonAdapter jsonAdapterAdapter3 = this.moshi.adapter(TargetDTO.class);
        JsonAdapter jsonAdapterAdapter4 = this.moshi.adapter(FileActivityPermissionsDTO.class);
        Intrinsics.checkNotNull(jsonAdapterAdapter);
        byte[] descriptionJsonData = dataModel.getDescriptionJsonData();
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        DescriptionDTO descriptionDTO = (DescriptionDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, new String(descriptionJsonData, charsetForName));
        if (descriptionDTO == null) {
            descriptionDTO = new DescriptionDTO("");
        }
        List<CommentEntity> list = replies;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.commentEntityDomainMapper.toDomain((CommentEntity) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        byte[] createdByJsonData = dataModel.getCreatedByJsonData();
        Charset charsetForName2 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
        String str = new String(createdByJsonData, charsetForName2);
        Intrinsics.checkNotNull(jsonAdapterAdapter2);
        UserMiniDTO userMiniDTO = (UserMiniDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter2, str);
        if (userMiniDTO == null) {
            throw new IllegalStateException("annotation mapping, createdByUser not parsed correctly ".concat(str));
        }
        byte[] modifiedByJsonData = dataModel.getModifiedByJsonData();
        Charset charsetForName3 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName3, "forName(...)");
        String str2 = new String(modifiedByJsonData, charsetForName3);
        UserMiniDTO userMiniDTO2 = (UserMiniDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter2, str2);
        if (userMiniDTO2 == null) {
            throw new IllegalStateException("annotation mapping, modifiedByUser not parsed correctly ".concat(str2));
        }
        byte[] targetJsonData = dataModel.getTargetJsonData();
        Charset charsetForName4 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName4, "forName(...)");
        String str3 = new String(targetJsonData, charsetForName4);
        Intrinsics.checkNotNull(jsonAdapterAdapter3);
        TargetDTO targetDTO = (TargetDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter3, str3);
        if (targetDTO == null) {
            throw new IllegalStateException("annotation mapping, targetData not parsed correctly ".concat(str3));
        }
        byte[] permissionsJsonData = dataModel.getPermissionsJsonData();
        Charset charsetForName5 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName5, "forName(...)");
        String str4 = new String(permissionsJsonData, charsetForName5);
        Intrinsics.checkNotNull(jsonAdapterAdapter4);
        FileActivityPermissionsDTO fileActivityPermissionsDTO = (FileActivityPermissionsDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter4, str4);
        if (fileActivityPermissionsDTO == null) {
            throw new IllegalStateException("annotation mapping, permissionsData not parsed correctly ".concat(str4));
        }
        String message = descriptionDTO.getMessage();
        Intrinsics.checkNotNull(message);
        Pair<String, List<CommentMentionModel>> pairTaggedCommentToCommentMentionModels = taggedCommentToCommentMentionModels(message, descriptionDTO.getMessage());
        String strComponent1 = pairTaggedCommentToCommentMentionModels.component1();
        List<CommentMentionModel> listComponent2 = pairTaggedCommentToCommentMentionModels.component2();
        String annotationId = dataModel.getAnnotationId();
        UserEventModel userEvent = UserEventMapper.INSTANCE.toUserEvent(dataModel.getCreatedAt(), userMiniDTO);
        UserEventModel userEvent2 = UserEventMapper.INSTANCE.toUserEvent(dataModel.getModifiedAt(), userMiniDTO2);
        AnnotationTargetModel domain = TargetDTOToTargetModelMapper.INSTANCE.toDomain(targetDTO);
        LocationDomainModelMapper locationDomainModelMapper = LocationDomainModelMapper.INSTANCE;
        if (targetDTO instanceof TargetDTO.Region) {
            location = ((TargetDTO.Region) targetDTO).getLocation();
        } else if (targetDTO instanceof TargetDTO.Drawing) {
            location = ((TargetDTO.Drawing) targetDTO).getLocation();
        } else {
            if (!(targetDTO instanceof TargetDTO.Highlight)) {
                throw new NoWhenBranchMatchedException();
            }
            location = ((TargetDTO.Highlight) targetDTO).getLocation();
        }
        AnnotationLocationModel domain2 = locationDomainModelMapper.toDomain(location);
        FileActivityPermissionsModel domain3 = FileActivityPermissionsDTOToDomainModelMapper.INSTANCE.toDomain(fileActivityPermissionsDTO);
        AnnotationFileVersionModel annotationFileVersionModel = new AnnotationFileVersionModel(dataModel.getFileVersionId(), fileId, Integer.valueOf(dataModel.getFileVersionNumber()));
        int totalReplyCount = dataModel.getTotalReplyCount();
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
        return new FileActivityModel.AnnotationModel(annotationId, strComponent1, listComponent2, annotationFileVersionModel, userEvent, userEvent2, domain, domain2, domain3, arrayList2, totalReplyCount, status);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public AnnotationEntity fromDomain(FileActivityModel.AnnotationModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
