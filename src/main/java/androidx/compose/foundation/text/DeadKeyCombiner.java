package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: DeadKeyCombiner.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "<init>", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeadKeyCombiner {
    public static final int $stable = 8;
    private Integer deadKeyCode;

    /* JADX INFO: renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m1659consumeZmokQxo(KeyEvent event) {
        int iM7979getUtf16CodePointZmokQxo = KeyEvent_androidKt.m7979getUtf16CodePointZmokQxo(event);
        if ((Integer.MIN_VALUE & iM7979getUtf16CodePointZmokQxo) != 0) {
            this.deadKeyCode = Integer.valueOf(iM7979getUtf16CodePointZmokQxo & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num != null) {
            this.deadKeyCode = null;
            Integer numValueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), iM7979getUtf16CodePointZmokQxo));
            Integer num2 = numValueOf.intValue() != 0 ? numValueOf : null;
            if (num2 != null) {
                iM7979getUtf16CodePointZmokQxo = num2.intValue();
            }
            return Integer.valueOf(iM7979getUtf16CodePointZmokQxo);
        }
        return Integer.valueOf(iM7979getUtf16CodePointZmokQxo);
    }
}
