package expo.modules.nativeelementsexpo;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuAction.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"getTextWithColor", "Landroid/text/SpannableStringBuilder;", "text", "", "color", "", "cirrus-native-elements-expo_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MenuActionKt {
    public static final SpannableStringBuilder getTextWithColor(String text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) text);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, text.length(), 33);
        return spannableStringBuilder;
    }
}
