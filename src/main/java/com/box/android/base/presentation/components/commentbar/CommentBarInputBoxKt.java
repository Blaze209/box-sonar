package com.box.android.base.presentation.components.commentbar;

import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.box.androidsdk.content.models.BoxCollaborator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommentBarInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u000b\u001a\u001c\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"TAG_FORMAT", "", "MENTION_SYMBOL", "", "toTaggedString", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "getMentionPrefix", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "toMentionRepresentation", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "getUpdatedInputBoxValue", "newTextFieldValue", "ignoreMention", "Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "getDifferenceRange", "Lkotlin/ranges/IntRange;", "indexOfDiffStart", "", "oldText", "newText", "indexOfDifference", "otherString", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommentBarInputBoxKt {
    public static final char MENTION_SYMBOL = '@';
    public static final String TAG_FORMAT = "[%s:%s]";

    public static final String toTaggedString(InputBoxValue inputBoxValue, TimestampedCommentConfig timestampedCommentConfig) {
        Intrinsics.checkNotNullParameter(inputBoxValue, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(inputBoxValue.getTextFieldValue().getText());
        for (MentionSpanV2 mentionSpanV2 : CollectionsKt.reversed(inputBoxValue.getMentionSpans())) {
            sb.replace(mentionSpanV2.getStartIndex() + 1, mentionSpanV2.getEndIndex(), mentionSpanV2.getToTag());
        }
        if (timestampedCommentConfig != null && timestampedCommentConfig.getEnabled() && timestampedCommentConfig.getShouldShowToggle()) {
            sb.insert(0, TimestampUtil.INSTANCE.formatTimestampForSubmission(timestampedCommentConfig.getTimestampForSubmission(), timestampedCommentConfig.getVersionIdForSubmission()) + " ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String toTaggedString$default(InputBoxValue inputBoxValue, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            timestampedCommentConfig = null;
        }
        return toTaggedString(inputBoxValue, timestampedCommentConfig);
    }

    public static final String getMentionPrefix(TextFieldValueUIModel textFieldValueUIModel) {
        Intrinsics.checkNotNullParameter(textFieldValueUIModel, "<this>");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) textFieldValueUIModel.getText(), MENTION_SYMBOL, 0, false, 6, (Object) null);
        if (iLastIndexOf$default >= 0) {
            String strSubstring = textFieldValueUIModel.getText().substring(iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (!StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) " ", false, 2, (Object) null)) {
                return StringsKt.substringAfterLast$default(textFieldValueUIModel.getText(), MENTION_SYMBOL, (String) null, 2, (Object) null);
            }
        }
        return null;
    }

    public static final String toMentionRepresentation(BoxCollaborator boxCollaborator) {
        Intrinsics.checkNotNullParameter(boxCollaborator, "<this>");
        return CommentEntityDomainMapper.MENTIONS_SYMBOL + boxCollaborator.getUserName();
    }

    public static final InputBoxValue getUpdatedInputBoxValue(InputBoxValue inputBoxValue, TextFieldValueUIModel newTextFieldValue, MentionSpanV2 mentionSpanV2) {
        Intrinsics.checkNotNullParameter(inputBoxValue, "<this>");
        Intrinsics.checkNotNullParameter(newTextFieldValue, "newTextFieldValue");
        String text = inputBoxValue.getTextFieldValue().getText();
        int iIndexOfDifference = indexOfDifference(text, newTextFieldValue.getText());
        if (newTextFieldValue.m11827getCompositionMzsxiRA() != null) {
            return new InputBoxValue(newTextFieldValue, inputBoxValue.getMentionSpans());
        }
        if (iIndexOfDifference >= 0) {
            IntRange differenceRange = getDifferenceRange(iIndexOfDifference, text, newTextFieldValue.getText());
            List listSortedWith = CollectionsKt.sortedWith(inputBoxValue.getMentionSpans(), new Comparator() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt$getUpdatedInputBoxValue$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((MentionSpanV2) t).getEndIndex()), Integer.valueOf(((MentionSpanV2) t2).getEndIndex()));
                }
            });
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSortedWith) {
                MentionSpanV2 mentionSpanV3 = (MentionSpanV2) obj;
                boolean z = differenceRange.getFirst() < mentionSpanV3.getEndIndex() && differenceRange.getLast() > mentionSpanV3.getStartIndex();
                if (mentionSpanV3 != mentionSpanV2 && z) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                int iMax = Math.max(((MentionSpanV2) CollectionsKt.last((List) arrayList2)).getEndIndex(), differenceRange.getLast());
                int iMin = Math.min(differenceRange.getFirst(), ((MentionSpanV2) CollectionsKt.first((List) arrayList2)).getStartIndex());
                newTextFieldValue = new TextFieldValueUIModel(StringsKt.replaceRange((CharSequence) text, iMin, iMax, (CharSequence) "").toString(), iMin, iMin, null, 8, null);
            }
            List<MentionSpanV2> listMinus = CollectionsKt.minus((Iterable) inputBoxValue.getMentionSpans(), (Iterable) arrayList2);
            int length = -1;
            for (MentionSpanV2 mentionSpanV4 : listMinus) {
                String strReplace$default = StringsKt.replace$default(toMentionRepresentation(mentionSpanV4.getBoxCollaborator()), "@@", CommentEntityDomainMapper.MENTIONS_SYMBOL, false, 4, (Object) null);
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) newTextFieldValue.getText(), strReplace$default, length, false, 4, (Object) null);
                length = iIndexOf$default + strReplace$default.length();
                mentionSpanV4.setStartIndex(iIndexOf$default);
                mentionSpanV4.setEndIndex(length);
            }
            return new InputBoxValue(newTextFieldValue, listMinus);
        }
        return new InputBoxValue(newTextFieldValue, inputBoxValue.getMentionSpans());
    }

    private static final IntRange getDifferenceRange(int i, String str, String str2) {
        int iMax = Math.max(0, str.length());
        int iMin = Math.min(i, iMax);
        int iIndexOf$default = -1;
        int i2 = iMin;
        while (i2 <= iMax) {
            String strSubstring = str.substring(i2, iMax);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, strSubstring, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                break;
            }
            i2++;
        }
        if (iIndexOf$default >= 0) {
            return new IntRange(iMin, i2);
        }
        return new IntRange(iMin, iMax);
    }

    private static final int indexOfDifference(String str, String str2) {
        if (str.contentEquals(str2)) {
            return -1;
        }
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 0; i < iMin; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        if (str.length() != str2.length()) {
            return Math.min(str.length(), str2.length());
        }
        return -1;
    }
}
