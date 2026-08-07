package com.box.android.data.mappers.annotation;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.annotations.CommentMentionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ActivityWithTagsEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0004¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/mappers/annotation/ActivityWithTagsEntityDomainMapper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/DomainModel;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/box/android/data/mappers/DomainMapper;", "<init>", "()V", "taggedCommentToCommentMentionModels", "Lkotlin/Pair;", "", "", "Lcom/box/android/domain/models/annotations/CommentMentionModel;", "message", "taggedMessage", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ActivityWithTagsEntityDomainMapper<T extends DomainModel, V> implements DomainMapper<T, V> {
    protected final Pair<String, List<CommentMentionModel>> taggedCommentToCommentMentionModels(String message, String taggedMessage) {
        Intrinsics.checkNotNullParameter(message, "message");
        Pattern patternCompile = Pattern.compile(CommentEntityDomainMapper.TAG_REGEX);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (taggedMessage != null) {
            String str = taggedMessage;
            if (str.length() != 0) {
                Matcher matcher = patternCompile.matcher(str);
                Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
                int iEnd = 0;
                while (matcher.find()) {
                    String strSubstring = taggedMessage.substring(iEnd, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    String strGroup = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    String str2 = CommentEntityDomainMapper.MENTIONS_SYMBOL + matcher.group(2);
                    arrayList.add(new CommentMentionModel(new IntRange(sb.toString().length(), (sb.toString().length() + str2.length()) - 1), strGroup));
                    sb.append(str2);
                    iEnd = matcher.end();
                }
                if (iEnd < taggedMessage.length()) {
                    String strSubstring2 = taggedMessage.substring(iEnd, taggedMessage.length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    sb.append(strSubstring2);
                }
                return new Pair<>(sb.toString(), arrayList);
            }
        }
        return new Pair<>(message, CollectionsKt.emptyList());
    }
}
