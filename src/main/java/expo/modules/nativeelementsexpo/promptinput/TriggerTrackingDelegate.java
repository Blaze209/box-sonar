package expo.modules.nativeelementsexpo.promptinput;

import kotlin.Metadata;

/* JADX INFO: compiled from: TriggerHandling.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/TriggerTrackingDelegate;", "", "beginTracking", "", "trigger", "", "endTracking", "filterForPrefix", "prefix", "", "updateSelection", "selStart", "", "selEnd", "applyPendingStyle", "start", "end", "removePendingStyle", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TriggerTrackingDelegate {
    void applyPendingStyle(int start, int end);

    void beginTracking(char trigger);

    void endTracking();

    void filterForPrefix(char trigger, String prefix);

    void removePendingStyle();

    void updateSelection(int selStart, int selEnd);
}
