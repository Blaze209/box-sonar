package org.tinylog.format;

import java.text.MessageFormat;
import java.util.Locale;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public class JavaTextMessageFormatFormatter extends AbstractMessageFormatter {
    private final Locale locale;

    public JavaTextMessageFormatFormatter(Locale locale) {
        this.locale = locale;
    }

    @Override // org.tinylog.format.MessageFormatter
    public String format(String str, Object[] objArr) {
        try {
            return new MessageFormat(str, this.locale).format(resolve(objArr));
        } catch (IllegalArgumentException e) {
            InternalLogger.log(Level.WARN, e, "Illegal message format pattern '" + str + "'");
            return str;
        }
    }
}
