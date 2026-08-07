package org.tinylog.format;

import java.util.IllegalFormatException;
import java.util.Locale;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public class PrintfStyleFormatter extends AbstractMessageFormatter {
    private final Locale locale;

    public PrintfStyleFormatter(Locale locale) {
        this.locale = locale;
    }

    @Override // org.tinylog.format.MessageFormatter
    public String format(String str, Object[] objArr) {
        try {
            return String.format(this.locale, str, resolve(objArr));
        } catch (IllegalFormatException e) {
            InternalLogger.log(Level.WARN, e, "Illegal printf format message '" + str + "'");
            return str;
        }
    }
}
