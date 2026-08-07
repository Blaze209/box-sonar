package com.box.android.fileactivity.model;

import com.box.android.base.presentation.components.commentbar.MentionSpanV2;
import com.box.android.base.presentation.components.commentbar.TimestampUtil;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a\f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0003\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0003\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005\u001a\n\u0010\u000f\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0003\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0003\u001a\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"getReplies", "", "Lcom/box/android/fileactivity/model/CommentUIModelV2;", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "isResolved", "", "getMessage", "Lcom/box/android/fileactivity/model/TaggedMessageV2;", "getPermissions", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "getReplyCountMessage", "", "toInputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "shouldProcessTimestampComment", "getCreatedByUserId", "getCreatedByUserName", "getCreatedAt", "Ljava/util/Date;", "getModifiedAt", "getPageNumber", "", "(Lcom/box/android/fileactivity/model/FileActivityUIModelV2;)Ljava/lang/Integer;", "file-activity_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActivityUIModelsV2Kt {
    public static final List<CommentUIModelV2> getReplies(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getReplies();
        }
        return fileActivityUIModelV2 instanceof AnnotationUIModelV2 ? ((AnnotationUIModelV2) fileActivityUIModelV2).getReplies() : CollectionsKt.emptyList();
    }

    public static final boolean isResolved(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).isResolved();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).isResolved();
        }
        return false;
    }

    public static final TaggedMessageV2 getMessage(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getMessage();
        }
        return fileActivityUIModelV2 instanceof AnnotationUIModelV2 ? ((AnnotationUIModelV2) fileActivityUIModelV2).getDescription() : new TaggedMessageV2("", CollectionsKt.emptyList());
    }

    public static final FileActivityPermissionsModel getPermissions(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getPermissions();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).getPermissions();
        }
        return null;
    }

    public static final String getReplyCountMessage(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getReplyCountMessage();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).getReplyCountMessage();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0036  */
    public static final InputBoxValue toInputBoxValue(TaggedMessageV2 taggedMessageV2, boolean z) {
        String message;
        ArrayList arrayList;
        MatchResult matchResultFind$default;
        Intrinsics.checkNotNullParameter(taggedMessageV2, "<this>");
        if (!z || (matchResultFind$default = Regex.find$default(TimestampUtil.INSTANCE.getSUBMISSION_FORMAT_REGEX(), taggedMessageV2.getMessage(), 0, 2, null)) == null) {
            message = taggedMessageV2.getMessage();
        } else {
            message = StringsKt.removeRange((CharSequence) taggedMessageV2.getMessage(), 0, matchResultFind$default.getValue().length() + 1).toString();
            if (message == null) {
                message = taggedMessageV2.getMessage();
            }
        }
        String str = message;
        int length = taggedMessageV2.getMessage().length() - str.length();
        if (length > 0) {
            List<MentionInfo> mentionSpans = taggedMessageV2.getMentionSpans();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mentionSpans, 10));
            for (MentionInfo mentionInfo : mentionSpans) {
                arrayList2.add(new MentionSpanV2(mentionInfo.getUserUIModel(), mentionInfo.getStartIndex() - length, (mentionInfo.getEndIndex() + 1) - length));
            }
            arrayList = arrayList2;
        } else {
            List<MentionInfo> mentionSpans2 = taggedMessageV2.getMentionSpans();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mentionSpans2, 10));
            for (MentionInfo mentionInfo2 : mentionSpans2) {
                arrayList3.add(new MentionSpanV2(mentionInfo2.getUserUIModel(), mentionInfo2.getStartIndex(), mentionInfo2.getEndIndex() + 1));
            }
            arrayList = arrayList3;
        }
        return new InputBoxValue(new TextFieldValueUIModel(str, str.length(), str.length(), null, 8, null), arrayList);
    }

    public static final String getCreatedByUserId(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getCreatedByUserId();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).getCreatedByUserId();
        }
        if (fileActivityUIModelV2 instanceof VersionsUIModelV2) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getCreatedByUserName(FileActivityUIModelV2 fileActivityUIModelV2) {
        String createdByUserName;
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            createdByUserName = ((CommentUIModelV2) fileActivityUIModelV2).getCreatedByUserName();
        } else if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            createdByUserName = ((AnnotationUIModelV2) fileActivityUIModelV2).getCreatedByUserName();
        } else {
            if (!(fileActivityUIModelV2 instanceof VersionsUIModelV2)) {
                throw new NoWhenBranchMatchedException();
            }
            createdByUserName = "";
        }
        return createdByUserName == null ? "" : createdByUserName;
    }

    public static final Date getCreatedAt(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getCreatedAt();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).getCreatedAt();
        }
        if (fileActivityUIModelV2 instanceof VersionsUIModelV2) {
            return new Date();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Date getModifiedAt(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return ((CommentUIModelV2) fileActivityUIModelV2).getModifiedAt();
        }
        if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
            return ((AnnotationUIModelV2) fileActivityUIModelV2).getModifiedAt();
        }
        if (fileActivityUIModelV2 instanceof VersionsUIModelV2) {
            return new Date();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Integer getPageNumber(FileActivityUIModelV2 fileActivityUIModelV2) {
        Intrinsics.checkNotNullParameter(fileActivityUIModelV2, "<this>");
        if (fileActivityUIModelV2 instanceof CommentUIModelV2) {
            return null;
        }
        if (!(fileActivityUIModelV2 instanceof AnnotationUIModelV2)) {
            if (fileActivityUIModelV2 instanceof VersionsUIModelV2) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        AnnotationLocationUIModel location = ((AnnotationUIModelV2) fileActivityUIModelV2).getLocation();
        AnnotationLocationUIModel.Page page = location instanceof AnnotationLocationUIModel.Page ? (AnnotationLocationUIModel.Page) location : null;
        if (page != null) {
            return Integer.valueOf(page.getPageNumber());
        }
        return null;
    }
}
