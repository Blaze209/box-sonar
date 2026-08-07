package expo.modules.nativeelementsexpo.promptinput;

import android.text.Editable;
import android.text.Spannable;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import expo.modules.nativeelementsexpo.promptinput.tag.EntityTag;
import expo.modules.nativeelementsexpo.promptinput.tag.TagInserter;
import expo.modules.nativeelementsexpo.promptinput.tag.TagSpan;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TriggerStringHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ.\u0010!\u001a\u00020\"2\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003J\u001e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003J\u001e\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020*J\u001e\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003J*\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u0010$\u001a\u00020*2\u0006\u00101\u001a\u00020\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0019J\u000e\u00103\u001a\u0002042\u0006\u0010$\u001a\u00020%J\u0006\u00105\u001a\u00020\"J\u0018\u00106\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003H\u0002J\b\u0010:\u001a\u00020\"H\u0002J \u0010;\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerStringHandler;", "", "tokenBackgroundColor", "", "pendingTokenBackgroundColor", "tokenTextColor", "pendingTokenTextColor", "tagInserter", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "<init>", "(IIIILexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;)V", "delegate", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingDelegate;", "getDelegate", "()Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingDelegate;", "setDelegate", "(Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingDelegate;)V", "triggerConfigs", "", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerConfig;", "getTriggerConfigs", "()Ljava/util/List;", "setTriggerConfigs", "(Ljava/util/List;)V", "value", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState;", "currentState", "getCurrentState", "()Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingState;", "pendingSpanRemovals", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagSpan;", "isExpandingSelection", "", "updateColors", "", "beforeTextChanged", "text", "Landroid/text/Spannable;", "start", "count", "onTextChanged", "afterTextChanged", "Landroid/text/Editable;", "selectionDidChange", "selStart", "selEnd", SemanticAttributes.FaasDocumentOperationValues.INSERT, "item", "Lexpo/modules/nativeelementsexpo/promptinput/tag/EntityTag;", "selectionStart", "capturedState", "buildTaggedMessageResult", "", "resetTracking", "transitionToTracking", "trigger", "", "anchorOffset", "cancelTracking", "expandSelectionOverTags", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TriggerStringHandler {
    public static final int $stable = 8;
    private TriggerTrackingState currentState;
    private TriggerTrackingDelegate delegate;
    private boolean isExpandingSelection;
    private List<TagSpan> pendingSpanRemovals;
    private int pendingTokenBackgroundColor;
    private int pendingTokenTextColor;
    private final TagInserter tagInserter;
    private int tokenBackgroundColor;
    private int tokenTextColor;
    private List<TriggerConfig> triggerConfigs;

    public TriggerStringHandler(int i, int i2, int i3, int i4, TagInserter tagInserter) {
        Intrinsics.checkNotNullParameter(tagInserter, "tagInserter");
        this.tokenBackgroundColor = i;
        this.pendingTokenBackgroundColor = i2;
        this.tokenTextColor = i3;
        this.pendingTokenTextColor = i4;
        this.tagInserter = tagInserter;
        this.triggerConfigs = CollectionsKt.listOf(new TriggerConfig(CommentBarInputBoxKt.MENTION_SYMBOL, 0, 2, null));
        this.currentState = TriggerTrackingState.Idle.INSTANCE;
        this.pendingSpanRemovals = CollectionsKt.emptyList();
    }

    public /* synthetic */ TriggerStringHandler(int i, int i2, int i3, int i4, TagInserter tagInserter, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? -14540254 : i3, (i5 & 8) != 0 ? -14540254 : i4, tagInserter);
    }

    public final TriggerTrackingDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(TriggerTrackingDelegate triggerTrackingDelegate) {
        this.delegate = triggerTrackingDelegate;
    }

    public final List<TriggerConfig> getTriggerConfigs() {
        return this.triggerConfigs;
    }

    public final void setTriggerConfigs(List<TriggerConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.triggerConfigs = list;
    }

    public final TriggerTrackingState getCurrentState() {
        return this.currentState;
    }

    public static /* synthetic */ void updateColors$default(TriggerStringHandler triggerStringHandler, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = triggerStringHandler.tokenTextColor;
        }
        if ((i5 & 8) != 0) {
            i4 = triggerStringHandler.pendingTokenTextColor;
        }
        triggerStringHandler.updateColors(i, i2, i3, i4);
    }

    public final void updateColors(int tokenBackgroundColor, int pendingTokenBackgroundColor, int tokenTextColor, int pendingTokenTextColor) {
        this.tokenBackgroundColor = tokenBackgroundColor;
        this.pendingTokenBackgroundColor = pendingTokenBackgroundColor;
        this.tokenTextColor = tokenTextColor;
        this.pendingTokenTextColor = pendingTokenTextColor;
    }

    public final void beforeTextChanged(Spannable text, int start, int count) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (count == 0) {
            return;
        }
        TagSpan[] tagSpanArr = (TagSpan[]) text.getSpans(start, count + start, TagSpan.class);
        Intrinsics.checkNotNull(tagSpanArr);
        if (tagSpanArr.length == 0) {
            return;
        }
        this.pendingSpanRemovals = ArraysKt.toList(tagSpanArr);
    }

    public final void onTextChanged(Spannable text, int start, int count) {
        Character orNull;
        Object next;
        Intrinsics.checkNotNullParameter(text, "text");
        if ((this.currentState instanceof TriggerTrackingState.Idle) && count == 1 && (orNull = StringsKt.getOrNull(text, start)) != null) {
            char cCharValue = orNull.charValue();
            Iterator<T> it = this.triggerConfigs.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((TriggerConfig) next).getCharacter() != cCharValue);
            if (((TriggerConfig) next) == null) {
                return;
            }
            if (start != 0) {
                int i = start - 1;
                if (text.charAt(i) != ' ' && text.charAt(i) != '\n') {
                    return;
                }
            }
            transitionToTracking(cCharValue, start);
        }
    }

    public final void afterTextChanged(Editable text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.pendingSpanRemovals.isEmpty()) {
            return;
        }
        List<TagSpan> list = this.pendingSpanRemovals;
        this.pendingSpanRemovals = CollectionsKt.emptyList();
        Iterator<TagSpan> it = list.iterator();
        while (it.hasNext()) {
            text.removeSpan(it.next());
        }
        if (this.currentState instanceof TriggerTrackingState.Tracking) {
            cancelTracking();
        }
    }

    public final void selectionDidChange(Spannable text, int selStart, int selEnd) {
        Object next;
        Intrinsics.checkNotNullParameter(text, "text");
        TriggerTrackingState triggerTrackingState = this.currentState;
        if (triggerTrackingState instanceof TriggerTrackingState.Idle) {
            expandSelectionOverTags(text, selStart, selEnd);
            return;
        }
        if (!(triggerTrackingState instanceof TriggerTrackingState.Tracking)) {
            throw new NoWhenBranchMatchedException();
        }
        Iterator<T> it = this.triggerConfigs.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((TriggerConfig) next).getCharacter() != ((TriggerTrackingState.Tracking) triggerTrackingState).getTrigger());
        TriggerConfig triggerConfig = (TriggerConfig) next;
        if (triggerConfig == null) {
            cancelTracking();
            return;
        }
        if (selStart != selEnd) {
            cancelTracking();
            return;
        }
        TriggerTrackingState.Tracking tracking = (TriggerTrackingState.Tracking) triggerTrackingState;
        int anchorOffset = tracking.getAnchorOffset();
        if (selStart <= anchorOffset) {
            cancelTracking();
            return;
        }
        if (selStart - anchorOffset >= triggerConfig.getMaxRange()) {
            cancelTracking();
            return;
        }
        TagSpan[] tagSpanArr = (TagSpan[]) text.getSpans(anchorOffset, selStart, TagSpan.class);
        Intrinsics.checkNotNull(tagSpanArr);
        if (!(tagSpanArr.length == 0)) {
            cancelTracking();
            return;
        }
        int i = anchorOffset + 1;
        if (i > selStart || i > text.length()) {
            cancelTracking();
            return;
        }
        String string = text.subSequence(i, selStart).toString();
        TriggerTrackingDelegate triggerTrackingDelegate = this.delegate;
        if (triggerTrackingDelegate != null) {
            triggerTrackingDelegate.filterForPrefix(tracking.getTrigger(), string);
        }
        TriggerTrackingDelegate triggerTrackingDelegate2 = this.delegate;
        if (triggerTrackingDelegate2 != null) {
            triggerTrackingDelegate2.applyPendingStyle(anchorOffset, selStart);
        }
    }

    public static /* synthetic */ void insert$default(TriggerStringHandler triggerStringHandler, EntityTag entityTag, Editable editable, int i, TriggerTrackingState triggerTrackingState, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            triggerTrackingState = null;
        }
        triggerStringHandler.insert(entityTag, editable, i, triggerTrackingState);
    }

    public final void insert(EntityTag item, Editable text, int selectionStart, TriggerTrackingState capturedState) {
        Triple triple;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(text, "text");
        if (StringsKt.isBlank(item.getId()) || StringsKt.isBlank(item.getName()) || item.getId().length() > 100 || item.getName().length() > 200) {
            return;
        }
        if (capturedState == null) {
            capturedState = this.currentState;
        }
        if (capturedState instanceof TriggerTrackingState.Tracking) {
            TriggerTrackingState.Tracking tracking = (TriggerTrackingState.Tracking) capturedState;
            triple = new Triple(Character.valueOf(tracking.getTrigger()), Integer.valueOf(tracking.getAnchorOffset()), Integer.valueOf(selectionStart));
        } else {
            if (!(capturedState instanceof TriggerTrackingState.Idle)) {
                throw new NoWhenBranchMatchedException();
            }
            TriggerConfig triggerConfig = (TriggerConfig) CollectionsKt.firstOrNull((List) this.triggerConfigs);
            triple = new Triple(Character.valueOf(triggerConfig != null ? triggerConfig.getCharacter() : CommentBarInputBoxKt.MENTION_SYMBOL), Integer.valueOf(selectionStart), Integer.valueOf(selectionStart));
        }
        char cCharValue = ((Character) triple.component1()).charValue();
        int iIntValue = ((Number) triple.component2()).intValue();
        int iIntValue2 = ((Number) triple.component3()).intValue();
        if (iIntValue > iIntValue2 || iIntValue > text.length()) {
            return;
        }
        int iInsertTag = this.tagInserter.insertTag(item, text, iIntValue, iIntValue2, cCharValue, this.tokenBackgroundColor, this.tokenTextColor);
        text.insert(iInsertTag, " ");
        int i = iInsertTag + 1;
        this.currentState = TriggerTrackingState.Idle.INSTANCE;
        TriggerTrackingDelegate triggerTrackingDelegate = this.delegate;
        if (triggerTrackingDelegate != null) {
            triggerTrackingDelegate.removePendingStyle();
        }
        TriggerTrackingDelegate triggerTrackingDelegate2 = this.delegate;
        if (triggerTrackingDelegate2 != null) {
            triggerTrackingDelegate2.endTracking();
        }
        TriggerTrackingDelegate triggerTrackingDelegate3 = this.delegate;
        if (triggerTrackingDelegate3 != null) {
            triggerTrackingDelegate3.updateSelection(i, i);
        }
    }

    public final String buildTaggedMessageResult(Spannable text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            return "";
        }
        int i = 0;
        Object[] spans = text.getSpans(0, text.length(), TagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            TagSpan tagSpan = (TagSpan) obj;
            int spanStart = text.getSpanStart(tagSpan);
            int spanEnd = text.getSpanEnd(tagSpan);
            Triple triple = (spanStart == -1 || spanEnd == -1 || spanStart < 0 || spanEnd > text.length() || spanStart >= spanEnd) ? null : new Triple(Integer.valueOf(spanStart), Integer.valueOf(spanEnd), tagSpan.getTagValue());
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        List<Triple> listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: expo.modules.nativeelementsexpo.promptinput.TriggerStringHandler$buildTaggedMessageResult$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Triple) t).getFirst(), (Integer) ((Triple) t2).getFirst());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Triple triple2 : listSortedWith) {
            int iIntValue = ((Number) triple2.component1()).intValue();
            int iIntValue2 = ((Number) triple2.component2()).intValue();
            String str = (String) triple2.component3();
            if (iIntValue > i) {
                sb.append(text.subSequence(i, iIntValue));
            }
            sb.append(str);
            i = iIntValue2;
        }
        if (i < text.length()) {
            sb.append(text.subSequence(i, text.length()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void resetTracking() {
        if (this.currentState instanceof TriggerTrackingState.Tracking) {
            cancelTracking();
        }
    }

    private final void transitionToTracking(char trigger, int anchorOffset) {
        this.currentState = new TriggerTrackingState.Tracking(trigger, anchorOffset);
        TriggerTrackingDelegate triggerTrackingDelegate = this.delegate;
        if (triggerTrackingDelegate != null) {
            triggerTrackingDelegate.beginTracking(trigger);
        }
    }

    private final void cancelTracking() {
        this.currentState = TriggerTrackingState.Idle.INSTANCE;
        TriggerTrackingDelegate triggerTrackingDelegate = this.delegate;
        if (triggerTrackingDelegate != null) {
            triggerTrackingDelegate.removePendingStyle();
        }
        TriggerTrackingDelegate triggerTrackingDelegate2 = this.delegate;
        if (triggerTrackingDelegate2 != null) {
            triggerTrackingDelegate2.endTracking();
        }
    }

    private final void expandSelectionOverTags(Spannable text, int selStart, int selEnd) {
        if (this.isExpandingSelection) {
            return;
        }
        this.isExpandingSelection = true;
        try {
            Iterator it = ArrayIteratorKt.iterator((TagSpan[]) text.getSpans(RangesKt.coerceAtLeast(selStart - 500, 0), RangesKt.coerceAtMost(selEnd + 500, text.length()), TagSpan.class));
            int i = selStart;
            int i2 = selEnd;
            while (it.hasNext()) {
                TagSpan tagSpan = (TagSpan) it.next();
                int spanStart = text.getSpanStart(tagSpan);
                int spanEnd = text.getSpanEnd(tagSpan);
                boolean z = i > spanStart && i < spanEnd;
                boolean z2 = i2 > spanStart && i2 < spanEnd;
                if (z) {
                    i = spanStart;
                }
                if (z2) {
                    i2 = spanEnd;
                }
            }
            if (i != selStart || i2 != selEnd) {
                TriggerTrackingDelegate triggerTrackingDelegate = this.delegate;
                if (triggerTrackingDelegate != null) {
                    triggerTrackingDelegate.removePendingStyle();
                }
                TriggerTrackingDelegate triggerTrackingDelegate2 = this.delegate;
                if (triggerTrackingDelegate2 != null) {
                    triggerTrackingDelegate2.updateSelection(i, i2);
                }
            }
        } finally {
            this.isExpandingSelection = false;
        }
    }
}
