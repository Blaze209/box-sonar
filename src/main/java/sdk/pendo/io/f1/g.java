package sdk.pendo.io.f1;

import com.pspdfkit.ui.transition.EpicenterTranslateClipReveal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public enum g {
    UNIX_LINES(1, 'd'),
    CASE_INSENSITIVE(2, 'i'),
    COMMENTS(4, EpicenterTranslateClipReveal.StateProperty.TARGET_X),
    MULTILINE(8, 'm'),
    DOTALL(32, 's'),
    UNICODE_CASE(64, AbstractJsonLexerKt.UNICODE_ESC),
    UNICODE_CHARACTER_CLASS(256, 'U');

    private final int code;
    private final char flag;

    g(int i, char c) {
        this.code = i;
        this.flag = c;
    }

    private static int a(char c) {
        for (g gVar : values()) {
            if (gVar.flag == c) {
                return gVar.code;
            }
        }
        return 0;
    }

    public static int a(char[] cArr) {
        int iA = 0;
        for (char c : cArr) {
            iA |= a(c);
        }
        return iA;
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        for (g gVar : values()) {
            int i2 = gVar.code;
            if ((i2 & i) == i2) {
                sb.append(gVar.flag);
            }
        }
        return sb.toString();
    }
}
