package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.FileActivityDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntities;
import com.box.android.data.persistence.annotations.FileActivityEntity;
import com.box.android.data.persistence.annotations.FileActivityType;
import com.box.android.data.persistence.annotations.GroupedFileVersionEntities;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTOEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/mappers/annotation/FileActivityDTOEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "annotationDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/AnnotationDTOEntityMapper;", "commentDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;", "versionsDTOGroupedFileVersionEntitiesMapper", "Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionEntitiesMapper;", "<init>", "(Lcom/box/android/data/mappers/annotation/AnnotationDTOEntityMapper;Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionEntitiesMapper;)V", "toEntities", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "sourceModel", "fileId", "", BoxIterator.FIELD_ORDER, "", "toEntity", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityDTOEntityMapper implements EntityMapper<FileActivityEntity, FileActivityDTO> {
    private final AnnotationDTOEntityMapper annotationDTOEntityMapper;
    private final CommentDTOEntityMapper commentDTOEntityMapper;
    private final VersionsDTOGroupedFileVersionEntitiesMapper versionsDTOGroupedFileVersionEntitiesMapper;

    @Inject
    public FileActivityDTOEntityMapper(AnnotationDTOEntityMapper annotationDTOEntityMapper, CommentDTOEntityMapper commentDTOEntityMapper, VersionsDTOGroupedFileVersionEntitiesMapper versionsDTOGroupedFileVersionEntitiesMapper) {
        Intrinsics.checkNotNullParameter(annotationDTOEntityMapper, "annotationDTOEntityMapper");
        Intrinsics.checkNotNullParameter(commentDTOEntityMapper, "commentDTOEntityMapper");
        Intrinsics.checkNotNullParameter(versionsDTOGroupedFileVersionEntitiesMapper, "versionsDTOGroupedFileVersionEntitiesMapper");
        this.annotationDTOEntityMapper = annotationDTOEntityMapper;
        this.commentDTOEntityMapper = commentDTOEntityMapper;
        this.versionsDTOGroupedFileVersionEntitiesMapper = versionsDTOGroupedFileVersionEntitiesMapper;
    }

    public final FileActivityEntities toEntities(FileActivityDTO sourceModel, String fileId, int order) {
        GroupedFileVersionEntities entity;
        CommentEntity entity2;
        AnnotationEntity entity3;
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        AnnotationEntity annotationEntity = null;
        if (sourceModel instanceof FileActivityDTO.AnnotationActivityDTO) {
            entity3 = this.annotationDTOEntityMapper.toEntity(((FileActivityDTO.AnnotationActivityDTO) sourceModel).getSource().getAnnotation());
        } else {
            if (sourceModel instanceof FileActivityDTO.EnhancedAnnotationActivityDTO) {
                entity3 = this.annotationDTOEntityMapper.toEntity(((FileActivityDTO.EnhancedAnnotationActivityDTO) sourceModel).getSource().getEnhancedAnnotation());
            } else {
                if (sourceModel instanceof FileActivityDTO.CommentActivityDTO) {
                    entity2 = this.commentDTOEntityMapper.toEntity(((FileActivityDTO.CommentActivityDTO) sourceModel).getSource().getComment(), fileId);
                } else if (sourceModel instanceof FileActivityDTO.EnhancedCommentActivityDTO) {
                    entity2 = this.commentDTOEntityMapper.toEntity(((FileActivityDTO.EnhancedCommentActivityDTO) sourceModel).getSource().getEnhancedComment(), fileId);
                } else {
                    if (!(sourceModel instanceof FileActivityDTO.VersionsActivityDTO)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    entity = this.versionsDTOGroupedFileVersionEntitiesMapper.toEntity(((FileActivityDTO.VersionsActivityDTO) sourceModel).getSource().getVersions(), fileId);
                    entity2 = null;
                }
                entity = null;
            }
            return new FileActivityEntities(toEntity(sourceModel, fileId, order), entity2, annotationEntity, entity);
        }
        entity = null;
        annotationEntity = entity3;
        entity2 = null;
        return new FileActivityEntities(toEntity(sourceModel, fileId, order), entity2, annotationEntity, entity);
    }

    public final FileActivityEntity toEntity(FileActivityDTO sourceModel, String fileId, int order) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        if (sourceModel instanceof FileActivityDTO.AnnotationActivityDTO) {
            FileActivityDTO.AnnotationActivityDTO annotationActivityDTO = (FileActivityDTO.AnnotationActivityDTO) sourceModel;
            return new FileActivityEntity(annotationActivityDTO.getSource().getAnnotation().getId(), FileActivityType.ANNOTATION, fileId, annotationActivityDTO.getSource().getAnnotation().getCreatedAt(), new Date(), order);
        }
        if (sourceModel instanceof FileActivityDTO.EnhancedAnnotationActivityDTO) {
            FileActivityDTO.EnhancedAnnotationActivityDTO enhancedAnnotationActivityDTO = (FileActivityDTO.EnhancedAnnotationActivityDTO) sourceModel;
            return new FileActivityEntity(enhancedAnnotationActivityDTO.getSource().getEnhancedAnnotation().getId(), FileActivityType.ANNOTATION, fileId, enhancedAnnotationActivityDTO.getSource().getEnhancedAnnotation().getCreatedAt(), new Date(), order);
        }
        if (sourceModel instanceof FileActivityDTO.CommentActivityDTO) {
            FileActivityDTO.CommentActivityDTO commentActivityDTO = (FileActivityDTO.CommentActivityDTO) sourceModel;
            return new FileActivityEntity(commentActivityDTO.getSource().getComment().getId(), FileActivityType.COMMENT, fileId, commentActivityDTO.getSource().getComment().getCreatedAt(), new Date(), order);
        }
        if (sourceModel instanceof FileActivityDTO.EnhancedCommentActivityDTO) {
            FileActivityDTO.EnhancedCommentActivityDTO enhancedCommentActivityDTO = (FileActivityDTO.EnhancedCommentActivityDTO) sourceModel;
            return new FileActivityEntity(enhancedCommentActivityDTO.getSource().getEnhancedComment().getId(), FileActivityType.COMMENT, fileId, enhancedCommentActivityDTO.getSource().getEnhancedComment().getCreatedAt(), new Date(), order);
        }
        if (!(sourceModel instanceof FileActivityDTO.VersionsActivityDTO)) {
            throw new NoWhenBranchMatchedException();
        }
        FileActivityDTO.VersionsActivityDTO versionsActivityDTO = (FileActivityDTO.VersionsActivityDTO) sourceModel;
        return new FileActivityEntity(versionsActivityDTO.getSource().getVersions().getStart().getId(), FileActivityType.VERSIONS, fileId, versionsActivityDTO.getSource().getVersions().getStart().getCreatedAt(), new Date(), order);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public FileActivityEntity toEntity(FileActivityDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public FileActivityDTO fromEntity(FileActivityEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
