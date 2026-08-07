package expo.modules.nativeelementsexpo.promptinput.trackeditem;

import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import expo.modules.nativeelementsexpo.promptinput.tag.EntityTag;
import expo.modules.nativeelementsexpo.promptinput.tag.TagInserter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: TrackedItemHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tJ`\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001426\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0017J2\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\b\u0001\u0010\"\u001a\u00020\u00142\b\b\u0001\u0010#\u001a\u00020\u0014J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000eJ\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/TrackedItemHandler;", "", "tagInserter", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "<init>", "(Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;)V", "getTagInserter", "()Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "compiledTrackedPatterns", "", "Ljava/util/regex/Pattern;", "setTrackedPatterns", "", "trackedItems", "", "checkAndFireTrackedItem", "text", ComposeIdentificationData.FIELD_IS_EDITABLE_TEXT, "Landroid/text/Editable;", "pasteStart", "", "pasteEnd", "onItemTracked", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "matchedText", "uuid", "insertTrackedItem", "", "editText", "Landroid/widget/EditText;", "entityTag", "Lexpo/modules/nativeelementsexpo/promptinput/tag/EntityTag;", "tokenBackgroundColor", "tokenTextColor", "cancelTrackedItem", "findPendingSpan", "Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/PendingTrackedItemSpan;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackedItemHandler {
    public static final int $stable = 8;
    private List<Pattern> compiledTrackedPatterns;
    private final TagInserter tagInserter;

    public TrackedItemHandler(TagInserter tagInserter) {
        Intrinsics.checkNotNullParameter(tagInserter, "tagInserter");
        this.tagInserter = tagInserter;
        this.compiledTrackedPatterns = CollectionsKt.emptyList();
    }

    public final TagInserter getTagInserter() {
        return this.tagInserter;
    }

    public final void setTrackedPatterns(List<String> trackedItems) {
        Object objM14780constructorimpl;
        Intrinsics.checkNotNullParameter(trackedItems, "trackedItems");
        ArrayList arrayList = new ArrayList();
        for (String str : trackedItems) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TrackedItemHandler trackedItemHandler = this;
                objM14780constructorimpl = Result.m14780constructorimpl(Pattern.compile(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
                objM14780constructorimpl = null;
            }
            Pattern pattern = (Pattern) objM14780constructorimpl;
            if (pattern != null) {
                arrayList.add(pattern);
            }
        }
        this.compiledTrackedPatterns = arrayList;
    }

    public final void checkAndFireTrackedItem(String text, Editable editable, int pasteStart, int pasteEnd, Function2<? super String, ? super String, Unit> onItemTracked) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onItemTracked, "onItemTracked");
        List<Pattern> list = this.compiledTrackedPatterns;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Pattern) it.next()).matcher(text).find()) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (editable != null && pasteStart >= 0 && pasteEnd > pasteStart && pasteEnd <= editable.length()) {
                    editable.setSpan(new PendingTrackedItemSpan(string), pasteStart, pasteEnd, 33);
                }
                onItemTracked.invoke(text, string);
                return;
            }
        }
    }

    public final boolean insertTrackedItem(EditText editText, String uuid, EntityTag entityTag, int tokenBackgroundColor, int tokenTextColor) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(entityTag, "entityTag");
        Editable text = editText.getText();
        Intrinsics.checkNotNull(text);
        PendingTrackedItemSpan pendingTrackedItemSpanFindPendingSpan = findPendingSpan(text, uuid);
        if (pendingTrackedItemSpanFindPendingSpan == null) {
            Log.e("TrackedItemHandler", "insertTrackedItem: no pending span found for uuid=" + uuid);
            return false;
        }
        int spanStart = text.getSpanStart(pendingTrackedItemSpanFindPendingSpan);
        int spanEnd = text.getSpanEnd(pendingTrackedItemSpanFindPendingSpan);
        text.removeSpan(pendingTrackedItemSpanFindPendingSpan);
        if (spanStart < 0 || spanEnd <= spanStart) {
            Log.e("TrackedItemHandler", "insertTrackedItem: invalid span bounds for uuid=" + uuid);
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int iInsertTag$default = TagInserter.insertTag$default(this.tagInserter, entityTag, text, spanStart, spanEnd, (char) 0, tokenBackgroundColor, tokenTextColor, 16, null);
        if (iInsertTag$default >= text.length() || text.charAt(iInsertTag$default) != ' ') {
            text.insert(iInsertTag$default, " ");
        }
        if (spanStart <= selectionStart && selectionStart <= spanEnd + 1) {
            editText.setSelection(RangesKt.coerceIn(iInsertTag$default + 1, 0, text.length()));
        }
        return true;
    }

    public final boolean cancelTrackedItem(Editable editable, String uuid) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        PendingTrackedItemSpan pendingTrackedItemSpanFindPendingSpan = findPendingSpan(editable, uuid);
        if (pendingTrackedItemSpanFindPendingSpan == null) {
            return false;
        }
        editable.removeSpan(pendingTrackedItemSpanFindPendingSpan);
        return true;
    }

    private final PendingTrackedItemSpan findPendingSpan(Editable editable, String uuid) {
        Object obj;
        Object[] spans = editable.getSpans(0, editable.length(), PendingTrackedItemSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        int length = spans.length;
        for (int i = 0; i < length; i++) {
            obj = spans[i];
            if (Intrinsics.areEqual(((PendingTrackedItemSpan) obj).getUuid(), uuid)) {
                return (PendingTrackedItemSpan) obj;
            }
        }
        obj = null;
        return (PendingTrackedItemSpan) obj;
    }
}
