package expo.modules.nativeelementsexpo.promptinput.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import androidx.core.content.ContextCompat;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: TagInserter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0015\u001a\u00020\u000bJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tagIcons", "", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "Landroid/graphics/drawable/Drawable;", "insertTag", "", "item", "Lexpo/modules/nativeelementsexpo/promptinput/tag/EntityTag;", ComposeIdentificationData.FIELD_IS_EDITABLE_TEXT, "Landroid/text/Editable;", "replaceStart", "replaceEnd", "trigger", "", "tokenBackgroundColor", "tokenTextColor", "updateTag", "", "spannable", "Landroid/text/Spannable;", "oldSpan", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagSpan;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagInserter {
    public static final int $stable = 8;
    private final Context context;
    private Map<TagType, ? extends Drawable> tagIcons;

    public TagInserter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.tagIcons = MapsKt.emptyMap();
        EnumEntries<TagType> entries = TagType.getEntries();
        ArrayList arrayList = new ArrayList();
        for (TagType tagType : entries) {
            if (tagType.getIconResId() != null) {
                arrayList.add(tagType);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Context context2 = this.context;
            Integer iconResId = ((TagType) obj).getIconResId();
            Intrinsics.checkNotNull(iconResId);
            Drawable drawable = ContextCompat.getDrawable(context2, iconResId.intValue());
            linkedHashMap2.put(obj, drawable != null ? drawable.mutate() : null);
        }
        this.tagIcons = linkedHashMap;
    }

    public static /* synthetic */ int insertTag$default(TagInserter tagInserter, EntityTag entityTag, Editable editable, int i, int i2, char c, int i3, int i4, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            c = CommentBarInputBoxKt.MENTION_SYMBOL;
        }
        return tagInserter.insertTag(entityTag, editable, i, i2, c, i3, i4);
    }

    public final int insertTag(EntityTag item, Editable editable, int replaceStart, int replaceEnd, char trigger, int tokenBackgroundColor, int tokenTextColor) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(editable, "editable");
        Drawable drawable = this.tagIcons.get(item.getType());
        if (drawable == null) {
            str = " " + trigger + item.getName() + " ";
        } else {
            str = " " + item.getName() + " ";
        }
        String str2 = trigger + "[" + item.getId() + ":" + item.getName() + "]";
        editable.replace(replaceStart, replaceEnd, str);
        int length = str.length() + replaceStart;
        editable.setSpan(new TagSpan(tokenBackgroundColor, str2, item.getType(), drawable, tokenTextColor), replaceStart, length, 33);
        return length;
    }

    public final void updateTag(Spannable spannable, TagSpan oldSpan, int tokenBackgroundColor, int tokenTextColor) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(oldSpan, "oldSpan");
        int spanStart = spannable.getSpanStart(oldSpan);
        int spanEnd = spannable.getSpanEnd(oldSpan);
        if (spanStart < 0 || spanEnd < 0 || spanStart >= spanEnd) {
            return;
        }
        spannable.removeSpan(oldSpan);
        spannable.setSpan(new TagSpan(tokenBackgroundColor, oldSpan.getTagValue(), oldSpan.getType(), this.tagIcons.get(oldSpan.getType()), tokenTextColor), spanStart, spanEnd, 33);
    }
}
