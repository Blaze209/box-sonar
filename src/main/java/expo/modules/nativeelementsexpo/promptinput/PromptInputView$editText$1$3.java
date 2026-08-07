package expo.modules.nativeelementsexpo.promptinput;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: PromptInputView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"expo/modules/nativeelementsexpo/promptinput/PromptInputView$editText$1$3", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "afterTextChanged", "Landroid/text/Editable;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptInputView$editText$1$3 implements TextWatcher {
    final /* synthetic */ MentionEditText $this_apply;
    final /* synthetic */ PromptInputView this$0;

    PromptInputView$editText$1$3(PromptInputView promptInputView, MentionEditText mentionEditText) {
        this.this$0 = promptInputView;
        this.$this_apply = mentionEditText;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (this.this$0.isProgrammaticChange) {
            return;
        }
        Spannable spannable = s instanceof Spannable ? (Spannable) s : null;
        if (spannable == null) {
            return;
        }
        this.this$0.getTriggerHandler().beforeTextChanged(spannable, start, count);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.this$0.isProgrammaticChange) {
            return;
        }
        Spannable spannable = s instanceof Spannable ? (Spannable) s : null;
        if (spannable == null) {
            return;
        }
        this.this$0.getTriggerHandler().onTextChanged(spannable, start, count);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (this.this$0.isProgrammaticChange) {
            return;
        }
        if (s != null) {
            this.this$0.getTriggerHandler().afterTextChanged(s);
        }
        MentionEditText mentionEditText = this.$this_apply;
        final PromptInputView promptInputView = this.this$0;
        mentionEditText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$editText$1$3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromptInputView$editText$1$3.afterTextChanged$lambda$1(promptInputView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterTextChanged$lambda$1(PromptInputView promptInputView) {
        promptInputView.calculateAndReportHeight();
        promptInputView.scrollToCursor();
        promptInputView.reportDirtyChange();
    }
}
