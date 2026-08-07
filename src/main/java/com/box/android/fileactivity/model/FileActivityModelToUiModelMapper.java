package com.box.android.fileactivity.model;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.annotations.CommentMentionModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.fileactivity.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileActivityModelToUiModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\tH\u0007¨\u0006\u001d"}, d2 = {"Lcom/box/android/fileactivity/model/FileActivityModelToUiModelMapper;", "", "<init>", "()V", "toUIModel", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "fileActivityModel", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "latestVersionId", "", "toCommentUIModel", "Lcom/box/android/fileactivity/model/CommentUIModelV2;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "toVersionUIModel", "Lcom/box/android/fileactivity/model/VersionsUIModelV2;", "Lcom/box/android/domain/models/annotations/FileActivityModel$GroupedFileVersionModel;", "toAnnotationUIModel", "Lcom/box/android/fileactivity/model/AnnotationUIModelV2;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "buildReplyCountMessage", "replyCount", "", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "toMentionInfoList", "", "Lcom/box/android/fileactivity/model/MentionInfo;", "Lcom/box/android/domain/models/annotations/CommentMentionModel;", "message", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityModelToUiModelMapper {
    public static final int $stable = 0;
    public static final FileActivityModelToUiModelMapper INSTANCE = new FileActivityModelToUiModelMapper();

    private FileActivityModelToUiModelMapper() {
    }

    public final FileActivityUIModelV2 toUIModel(FileActivityModel fileActivityModel, String latestVersionId) {
        Intrinsics.checkNotNullParameter(fileActivityModel, "fileActivityModel");
        if (fileActivityModel instanceof FileActivityModel.AnnotationModel) {
            return toAnnotationUIModel((FileActivityModel.AnnotationModel) fileActivityModel, latestVersionId);
        }
        if (fileActivityModel instanceof FileActivityModel.CommentModel) {
            return toCommentUIModel((FileActivityModel.CommentModel) fileActivityModel);
        }
        if (fileActivityModel instanceof FileActivityModel.GroupedFileVersionModel) {
            return toVersionUIModel((FileActivityModel.GroupedFileVersionModel) fileActivityModel);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CommentUIModelV2 toCommentUIModel(FileActivityModel.CommentModel commentModel) {
        String id = commentModel.getId();
        TaggedMessageV2 taggedMessageV2 = new TaggedMessageV2(commentModel.getMessage(), toMentionInfoList(commentModel.getMentions(), commentModel.getMessage()));
        Date date = commentModel.getCreated().getDate();
        Date modifiedDate = commentModel.getModifiedDate();
        if (modifiedDate == null) {
            modifiedDate = commentModel.getCreated().getDate();
        }
        Date date2 = modifiedDate;
        String userName = commentModel.getCreated().getUserName();
        String userLogin = commentModel.getCreated().getUserLogin();
        String userId = commentModel.getCreated().getUserId();
        List<FileActivityModel.CommentModel> replies = commentModel.getReplies();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(replies, 10));
        Iterator<T> it = replies.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toCommentUIModel((FileActivityModel.CommentModel) it.next()));
        }
        return new CommentUIModelV2(id, taggedMessageV2, userId, userName, userLogin, arrayList, buildReplyCountMessage(commentModel.getReplies().size(), commentModel.getStatus()), date, date2, commentModel.getStatus() == FileActivityModel.Status.RESOLVED, commentModel.getPermissions());
    }

    private final VersionsUIModelV2 toVersionUIModel(FileActivityModel.GroupedFileVersionModel groupedFileVersionModel) {
        String strValueOf;
        String strLS;
        if (groupedFileVersionModel.getEndNumber() != groupedFileVersionModel.getStartNumber()) {
            strValueOf = String.format("%d - %d", Arrays.copyOf(new Object[]{Integer.valueOf(groupedFileVersionModel.getStartNumber()), Integer.valueOf(groupedFileVersionModel.getEndNumber())}, 2));
            Intrinsics.checkNotNullExpressionValue(strValueOf, "format(...)");
        } else {
            strValueOf = String.valueOf(groupedFileVersionModel.getStartNumber());
        }
        int size = groupedFileVersionModel.getCreatedByNames().size();
        if (size == 0) {
            strLS = CommonBoxUtil.LS(R.string.version_upload_with_unknown_collaborator, strValueOf);
        } else if (size == 1) {
            strLS = CommonBoxUtil.LS(R.string.version_upload_with_one_collaborator, groupedFileVersionModel.getCreatedByNames().get(0), strValueOf);
        } else {
            strLS = CommonBoxUtil.pluralNative(R.plurals.version_upload_with_multiple_collaborator, size, String.valueOf(size), strValueOf);
        }
        return new VersionsUIModelV2(strLS);
    }

    private final AnnotationUIModelV2 toAnnotationUIModel(FileActivityModel.AnnotationModel annotationModel, String str) {
        String id = annotationModel.getId();
        TaggedMessageV2 taggedMessageV2 = new TaggedMessageV2(annotationModel.getDescription(), toMentionInfoList(annotationModel.getMentions(), annotationModel.getDescription()));
        Date date = annotationModel.getCreated().getDate();
        Date date2 = annotationModel.getModified().getDate();
        String userName = annotationModel.getCreated().getUserName();
        String userLogin = annotationModel.getCreated().getUserLogin();
        String userId = annotationModel.getCreated().getUserId();
        List<FileActivityModel.CommentModel> replies = annotationModel.getReplies();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(replies, 10));
        Iterator<T> it = replies.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toCommentUIModel((FileActivityModel.CommentModel) it.next()));
        }
        return new AnnotationUIModelV2(id, taggedMessageV2, userId, userName, userLogin, arrayList, buildReplyCountMessage(annotationModel.getReplies().size(), annotationModel.getStatus()), date, date2, AnnotationLocationModelMapper.INSTANCE.toAnnotationLocationUIModel(annotationModel.getLocation()), annotationModel.getFileVersion(), annotationModel.getStatus() == FileActivityModel.Status.RESOLVED, Intrinsics.areEqual(annotationModel.getFileVersion().getId(), str), annotationModel.getPermissions());
    }

    public final String buildReplyCountMessage(int replyCount, FileActivityModel.Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        boolean z = status == FileActivityModel.Status.RESOLVED;
        if (z && replyCount > 0) {
            return CommonBoxUtil.pluralNative(R.plurals.see_replies, replyCount);
        }
        if (z || replyCount <= 1) {
            return null;
        }
        return CommonBoxUtil.pluralNative(R.plurals.see_more_replies, replyCount - 1);
    }

    public final List<MentionInfo> toMentionInfoList(List<CommentMentionModel> list, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (list != null) {
            List<CommentMentionModel> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (CommentMentionModel commentMentionModel : list2) {
                arrayList.add(new MentionInfo(new UserUIModel(commentMentionModel.getUserId(), StringsKt.substring(message, commentMentionModel.getRange()), null, null), commentMentionModel.getRange().getFirst(), commentMentionModel.getRange().getLast()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
