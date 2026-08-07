package sdk.pendo.io.a2;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class b {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public abstract int a(CharSequence charSequence, int i, Writer writer);

    public final String a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            a(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence == null) {
            return;
        }
        int length = charSequence.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iA = a(charSequence, iCharCount, writer);
            if (iA == 0) {
                char cCharAt = charSequence.charAt(iCharCount);
                writer.write(cCharAt);
                int i = iCharCount + 1;
                if (Character.isHighSurrogate(cCharAt) && i < length) {
                    char cCharAt2 = charSequence.charAt(i);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        writer.write(cCharAt2);
                        iCharCount += 2;
                    }
                }
                iCharCount = i;
            } else {
                for (int i2 = 0; i2 < iA; i2++) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                }
            }
        }
    }

    public final b a(b... bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length + 1];
        bVarArr2[0] = this;
        System.arraycopy(bVarArr, 0, bVarArr2, 1, bVarArr.length);
        return new a(bVarArr2);
    }
}
