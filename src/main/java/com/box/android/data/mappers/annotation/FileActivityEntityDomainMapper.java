package com.box.android.data.mappers.annotation;

import com.box.android.data.mappers.DomainMapper;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntities;
import com.box.android.data.persistence.annotations.FileActivityType;
import com.box.android.data.persistence.annotations.GroupedFileVersionEntities;
import com.box.android.domain.models.annotations.FileActivityModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/mappers/annotation/FileActivityEntityDomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "commentEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;", "groupedFileVersionEntitiesDomainMapper", "Lcom/box/android/data/mappers/annotation/GroupedFileVersionEntitiesDomainMapper;", "annotationEntityDomainMapper", "Lcom/box/android/data/mappers/annotation/AnnotationEntityDomainMapper;", "<init>", "(Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;Lcom/box/android/data/mappers/annotation/GroupedFileVersionEntitiesDomainMapper;Lcom/box/android/data/mappers/annotation/AnnotationEntityDomainMapper;)V", "toDomain", "dataModel", "fileId", "", "replies", "", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityEntityDomainMapper implements DomainMapper<FileActivityModel, FileActivityEntities> {
    private final AnnotationEntityDomainMapper annotationEntityDomainMapper;
    private final CommentEntityDomainMapper commentEntityDomainMapper;
    private final GroupedFileVersionEntitiesDomainMapper groupedFileVersionEntitiesDomainMapper;

    /* JADX INFO: compiled from: FileActivityEntityDomainMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileActivityType.values().length];
            try {
                iArr[FileActivityType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileActivityType.VERSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileActivityType.ANNOTATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public FileActivityEntityDomainMapper(CommentEntityDomainMapper commentEntityDomainMapper, GroupedFileVersionEntitiesDomainMapper groupedFileVersionEntitiesDomainMapper, AnnotationEntityDomainMapper annotationEntityDomainMapper) {
        Intrinsics.checkNotNullParameter(commentEntityDomainMapper, "commentEntityDomainMapper");
        Intrinsics.checkNotNullParameter(groupedFileVersionEntitiesDomainMapper, "groupedFileVersionEntitiesDomainMapper");
        Intrinsics.checkNotNullParameter(annotationEntityDomainMapper, "annotationEntityDomainMapper");
        this.commentEntityDomainMapper = commentEntityDomainMapper;
        this.groupedFileVersionEntitiesDomainMapper = groupedFileVersionEntitiesDomainMapper;
        this.annotationEntityDomainMapper = annotationEntityDomainMapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileActivityModel toDomain$default(FileActivityEntityDomainMapper fileActivityEntityDomainMapper, FileActivityEntities fileActivityEntities, String str, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return fileActivityEntityDomainMapper.toDomain(fileActivityEntities, str, list);
    }

    public final FileActivityModel toDomain(FileActivityEntities dataModel, String fileId, List<CommentEntity> replies) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(replies, "replies");
        int i = WhenMappings.$EnumSwitchMapping$0[dataModel.getFileActivityEntity().getType().ordinal()];
        if (i == 1) {
            CommentEntityDomainMapper commentEntityDomainMapper = this.commentEntityDomainMapper;
            CommentEntity commentEntity = dataModel.getCommentEntity();
            Intrinsics.checkNotNull(commentEntity);
            return commentEntityDomainMapper.toDomain(commentEntity, replies);
        }
        if (i == 2) {
            GroupedFileVersionEntitiesDomainMapper groupedFileVersionEntitiesDomainMapper = this.groupedFileVersionEntitiesDomainMapper;
            GroupedFileVersionEntities versions = dataModel.getVersions();
            Intrinsics.checkNotNull(versions);
            return groupedFileVersionEntitiesDomainMapper.toDomain(versions);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AnnotationEntityDomainMapper annotationEntityDomainMapper = this.annotationEntityDomainMapper;
        AnnotationEntity annotationEntity = dataModel.getAnnotationEntity();
        Intrinsics.checkNotNull(annotationEntity);
        return annotationEntityDomainMapper.toDomain(annotationEntity, fileId, replies);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityEntities fromDomain(FileActivityModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityModel toDomain(FileActivityEntities dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
