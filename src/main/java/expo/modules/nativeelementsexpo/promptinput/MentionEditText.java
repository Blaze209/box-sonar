package expo.modules.nativeelementsexpo.promptinput;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.microsoft.intune.mam.client.widget.MAMEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MentionEditText.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0018\u001a\u00020\r28\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016R@\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000Ra\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/MentionEditText;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onSelectionChangedListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selStart", "selEnd", "", "onPasteListener", "Lkotlin/Function3;", "", "pastedText", "pasteStart", "pasteEnd", "getOnPasteListener", "()Lkotlin/jvm/functions/Function3;", "setOnPasteListener", "(Lkotlin/jvm/functions/Function3;)V", "setOnSelectionChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onSelectionChanged", "onTextContextMenuItem", "", "id", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MentionEditText extends MAMEditText {
    public static final int $stable = 8;
    private Function3<? super String, ? super Integer, ? super Integer, Unit> onPasteListener;
    private Function2<? super Integer, ? super Integer, Unit> onSelectionChangedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MentionEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Function3<String, Integer, Integer, Unit> getOnPasteListener() {
        return this.onPasteListener;
    }

    public final void setOnPasteListener(Function3<? super String, ? super Integer, ? super Integer, Unit> function3) {
        this.onPasteListener = function3;
    }

    public final void setOnSelectionChangedListener(Function2<? super Integer, ? super Integer, Unit> listener) {
        this.onSelectionChangedListener = listener;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        Function2<? super Integer, ? super Integer, Unit> function2 = this.onSelectionChangedListener;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(selStart), Integer.valueOf(selEnd));
        }
    }

    @Override // com.microsoft.intune.mam.client.widget.MAMEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id) {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence charSequenceCoerceToText;
        if (id == 16908322 || id == 16908337) {
            Object systemService = getContext().getSystemService("clipboard");
            String string = null;
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager != null && (primaryClip = MAMClipboard.getPrimaryClip(clipboardManager)) != null && (itemAt = primaryClip.getItemAt(0)) != null && (charSequenceCoerceToText = itemAt.coerceToText(getContext())) != null) {
                string = charSequenceCoerceToText.toString();
            }
            boolean zOnTextContextMenuItem = super.onTextContextMenuItem(id);
            String str = string;
            if (str != null && str.length() != 0) {
                int selectionEnd = getSelectionEnd();
                int iCoerceAtLeast = RangesKt.coerceAtLeast(selectionEnd - string.length(), 0);
                Function3<? super String, ? super Integer, ? super Integer, Unit> function3 = this.onPasteListener;
                if (function3 != null) {
                    function3.invoke(string, Integer.valueOf(iCoerceAtLeast), Integer.valueOf(selectionEnd));
                }
            }
            return zOnTextContextMenuItem;
        }
        return super.onTextContextMenuItem(id);
    }
}
