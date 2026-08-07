package expo.modules.nativeelementsexpo.promptinput.trackeditem;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackedItemTextWatcher.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J*\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/TrackedItemTextWatcher;", "Landroid/text/TextWatcher;", "isProgrammaticChange", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "pendingRemovals", "", "Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/PendingTrackedItemSpan;", "beforeTextChanged", "", "s", "", "start", "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "afterTextChanged", "Landroid/text/Editable;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackedItemTextWatcher implements TextWatcher {
    public static final int $stable = 8;
    private final Function0<Boolean> isProgrammaticChange;
    private List<PendingTrackedItemSpan> pendingRemovals;

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public TrackedItemTextWatcher(Function0<Boolean> isProgrammaticChange) {
        Intrinsics.checkNotNullParameter(isProgrammaticChange, "isProgrammaticChange");
        this.isProgrammaticChange = isProgrammaticChange;
        this.pendingRemovals = CollectionsKt.emptyList();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        List listEmptyList;
        ArrayList arrayListEmptyList;
        if (this.isProgrammaticChange.invoke().booleanValue()) {
            return;
        }
        Spannable spannable = s instanceof Spannable ? (Spannable) s : null;
        if (spannable == null) {
            return;
        }
        if (count > 0) {
            Object[] spans = spannable.getSpans(start, count + start, PendingTrackedItemSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            listEmptyList = ArraysKt.toList(spans);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (after > 0) {
            Object[] spans2 = spannable.getSpans(start, start, PendingTrackedItemSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : spans2) {
                PendingTrackedItemSpan pendingTrackedItemSpan = (PendingTrackedItemSpan) obj;
                if (spannable.getSpanStart(pendingTrackedItemSpan) < start && start < spannable.getSpanEnd(pendingTrackedItemSpan)) {
                    arrayList.add(obj);
                }
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        List listDistinct = CollectionsKt.distinct(CollectionsKt.plus((Collection) listEmptyList, (Iterable) arrayListEmptyList));
        if (listDistinct.isEmpty()) {
            return;
        }
        this.pendingRemovals = CollectionsKt.plus((Collection) this.pendingRemovals, (Iterable) listDistinct);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (this.isProgrammaticChange.invoke().booleanValue() || this.pendingRemovals.isEmpty()) {
            return;
        }
        List<PendingTrackedItemSpan> list = this.pendingRemovals;
        this.pendingRemovals = CollectionsKt.emptyList();
        for (PendingTrackedItemSpan pendingTrackedItemSpan : list) {
            if (s != null) {
                s.removeSpan(pendingTrackedItemSpan);
            }
        }
    }
}
