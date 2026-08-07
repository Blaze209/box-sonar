package org.tinylog.format;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public class AdvancedMessageFormatter extends AbstractMessageFormatter {
    private final boolean escape;
    private final DecimalFormatSymbols symbols;

    public AdvancedMessageFormatter(Locale locale, boolean z) {
        this.symbols = new DecimalFormatSymbols(locale);
        this.escape = z;
    }

    @Override // org.tinylog.format.MessageFormatter
    public String format(String str, Object[] objArr) {
        return format(str, Arrays.asList(objArr).iterator());
    }

    private String format(String str, Iterator<Object> it) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int i2 = 0;
        int length2 = -1;
        int length3 = -1;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (this.escape && cCharAt == '\'' && (i = i2 + 1) < length && i3 == 0) {
                if (str.charAt(i) == '\'') {
                    sb.append('\'');
                    i2 = i;
                } else {
                    length3 = length3 < 0 ? sb.length() : -1;
                }
            } else if (cCharAt == '{' && i2 + 1 < length && it.hasNext() && length3 < 0) {
                int i4 = i3 + 1;
                if (i3 == 0) {
                    length2 = sb.length();
                } else {
                    sb.append(cCharAt);
                }
                i3 = i4;
            } else if (cCharAt != '}' || i3 <= 0 || length3 >= 0) {
                sb.append(cCharAt);
            } else {
                i3--;
                if (i3 == 0) {
                    Object objResolve = resolve(it.next());
                    if (length2 == sb.length()) {
                        sb.append(objResolve);
                    } else {
                        String strSubstring = sb.substring(length2);
                        sb.setLength(length2);
                        sb.append(format(strSubstring, objResolve));
                    }
                } else {
                    sb.append(cCharAt);
                }
            }
            i2++;
        }
        if (i3 > 0) {
            sb.insert(length2, AbstractJsonLexerKt.BEGIN_OBJ);
        }
        if (length3 >= 0) {
            sb.insert(length3, '\'');
        }
        return sb.toString();
    }

    private String format(String str, Object obj) {
        try {
            return getFormatter(str, obj).format(obj);
        } catch (IllegalArgumentException unused) {
            InternalLogger.log(Level.WARN, "Illegal argument '" + obj + "' for pattern '" + str + "'");
            return String.valueOf(obj);
        }
    }

    private Format getFormatter(String str, Object obj) {
        if (str.indexOf(124) != -1) {
            int iIndexOf = str.indexOf(123);
            if (iIndexOf >= 0 && iIndexOf < str.lastIndexOf(125)) {
                return new ChoiceFormat(format(str, (Iterator<Object>) new EndlessIterator(obj)));
            }
            return new ChoiceFormat(str);
        }
        return new DecimalFormat(str, this.symbols);
    }
}
