package sdk.pendo.io.w1;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static final a a = new a();

    public static class a implements Serializable {
        a() {
        }
    }

    public static <T> T a(T t, T t2) {
        return t != null ? t : t2;
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb = new StringBuilder(name.length() + 1 + hexString.length());
        sb.append(name).append(CommentBarInputBoxKt.MENTION_SYMBOL).append(hexString);
        return sb.toString();
    }

    public static void a(StringBuffer stringBuffer, Object obj) {
        h.a(obj, "object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name).append(CommentBarInputBoxKt.MENTION_SYMBOL).append(hexString);
    }
}
