package org.tinylog.pattern;

import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxOrder;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.tinylog.Level;
import org.tinylog.configuration.ServiceLoader;
import org.tinylog.provider.InternalLogger;
import org.tinylog.throwable.ThrowableFilter;

/* JADX INFO: loaded from: classes5.dex */
public final class FormatPatternParser {
    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");
    private final List<ThrowableFilter> filters;

    public FormatPatternParser(String str) {
        if (str == null) {
            this.filters = Collections.emptyList();
        } else {
            this.filters = new ServiceLoader(ThrowableFilter.class, String.class).createList(str);
        }
    }

    public Token parse(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '{') {
                if (i == 0) {
                    if (i2 < i3) {
                        arrayList.add(new PlainTextToken(str.substring(i2, i3)));
                    }
                    i2 = i3;
                }
                i++;
            } else if (cCharAt == '}') {
                if (i == 0) {
                    InternalLogger.log(Level.ERROR, "Opening curly bracket is missing: '" + str + "'");
                } else {
                    i--;
                    if (i == 0) {
                        arrayList.add(parse(str.substring(i2 + 1, i3)));
                        i2 = i3 + 1;
                    }
                }
            }
        }
        if (i > 0) {
            InternalLogger.log(Level.ERROR, "Closing curly bracket is missing: '" + str + "'");
        }
        int iIndexOf = str.indexOf(124, i2);
        if (iIndexOf == -1) {
            arrayList.add(createPlainToken(str.substring(i2)));
            return arrayList.size() == 1 ? (Token) arrayList.get(0) : new BundleToken(arrayList);
        }
        arrayList.add(createPlainToken(str.substring(i2, iIndexOf).trim()));
        return styleToken(arrayList.size() == 1 ? (Token) arrayList.get(0) : new BundleToken(arrayList), SPLIT_PATTERN.split(str.substring(iIndexOf + 1)));
    }

    private Token createPlainToken(String str) {
        Token tokenCreatePlainToken;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            tokenCreatePlainToken = createPlainToken(str.trim(), null);
        } else {
            tokenCreatePlainToken = createPlainToken(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1).trim());
        }
        return tokenCreatePlainToken == null ? new PlainTextToken(str) : tokenCreatePlainToken;
    }

    private Token createPlainToken(String str, String str2) {
        if (str.equals(BoxOrder.SORT_DATE)) {
            return createDateToken(str2);
        }
        if ("timestamp".equals(str)) {
            return new TimestampToken(str2);
        }
        if ("uptime".equals(str)) {
            return str2 == null ? new UptimeToken() : new UptimeToken(str2);
        }
        if ("pid".equals(str)) {
            return new ProcessIdToken();
        }
        if ("thread".equals(str)) {
            return new ThreadNameToken();
        }
        if ("thread-id".equals(str)) {
            return new ThreadIdToken();
        }
        if ("context".equals(str)) {
            return createThreadContextToken(str2);
        }
        if (TextRecognitionConverter.Attributes.CLASS.equals(str)) {
            return new FullClassNameToken();
        }
        if ("class-name".equals(str)) {
            return new SimpleClassNameToken();
        }
        if ("package".equals(str)) {
            return new PackageNameToken();
        }
        if (FirebaseAnalytics.Param.METHOD.equals(str)) {
            return new MethodNameToken();
        }
        if ("file".equals(str)) {
            return new FileNameToken();
        }
        if ("line".equals(str)) {
            return new LineNumberToken();
        }
        if ("tag".equals(str)) {
            return str2 == null ? new LoggerTagToken() : new LoggerTagToken(str2);
        }
        if (FirebaseAnalytics.Param.LEVEL.equals(str)) {
            return new SeverityLevelToken();
        }
        if ("level-code".equals(str)) {
            return new SeverityLevelIntegerToken();
        }
        if ("message".equals(str)) {
            return new MessageAndExceptionToken(this.filters);
        }
        if ("message-only".equals(str)) {
            return new MessageToken();
        }
        if ("exception".equals(str)) {
            return new ExceptionToken(this.filters);
        }
        if ("opening-curly-bracket".equals(str)) {
            return new PlainTextToken("{");
        }
        if ("closing-curly-bracket".equals(str)) {
            return new PlainTextToken("}");
        }
        if (SemanticAttributes.NetTransportValues.PIPE.equals(str)) {
            return new PlainTextToken("|");
        }
        return null;
    }

    private static Token createDateToken(String str) {
        if (str == null) {
            return new DateToken();
        }
        try {
            return new DateToken(str);
        } catch (IllegalArgumentException unused) {
            InternalLogger.log(Level.ERROR, "'" + str + "' is an invalid date format pattern");
            return new DateToken();
        }
    }

    private static Token createThreadContextToken(String str) {
        if (str == null) {
            InternalLogger.log(Level.ERROR, "\"{context}\" requires a key");
            return new PlainTextToken("");
        }
        int iIndexOf = str.indexOf(44);
        String strTrim = iIndexOf == -1 ? str.trim() : str.substring(0, iIndexOf).trim();
        if (strTrim.isEmpty()) {
            InternalLogger.log(Level.ERROR, "\"{context}\" requires a key");
            return new PlainTextToken("");
        }
        String strTrim2 = iIndexOf == -1 ? null : str.substring(iIndexOf + 1).trim();
        return strTrim2 == null ? new ThreadContextToken(strTrim) : new ThreadContextToken(strTrim, strTrim2);
    }

    private static Token styleToken(Token token, String[] strArr) {
        Token indentationToken;
        for (String str : strArr) {
            int iIndexOf = str.indexOf(61);
            if (iIndexOf == -1) {
                InternalLogger.log(Level.ERROR, "No value set for '" + str.trim() + "'");
            } else {
                String strTrim = str.substring(0, iIndexOf).trim();
                String strTrim2 = str.substring(iIndexOf + 1).trim();
                try {
                    int positiveInteger = parsePositiveInteger(strTrim2);
                    if ("min-size".equals(strTrim)) {
                        indentationToken = new MinimumSizeToken(token, positiveInteger);
                    } else if ("max-size".equals(strTrim)) {
                        indentationToken = new MaximumSizeToken(token, positiveInteger);
                    } else if ("size".equals(strTrim)) {
                        indentationToken = new SizeToken(token, positiveInteger);
                    } else if (!BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT.equals(strTrim)) {
                        InternalLogger.log(Level.ERROR, "Unknown style option: '" + strTrim + "'");
                    } else {
                        indentationToken = new IndentationToken(token, positiveInteger);
                    }
                    token = indentationToken;
                } catch (NumberFormatException unused) {
                    InternalLogger.log(Level.ERROR, "'" + strTrim2 + "' is an invalid value for '" + strTrim + "'");
                }
            }
        }
        return token;
    }

    private static int parsePositiveInteger(String str) throws NumberFormatException {
        int i = Integer.parseInt(str);
        if (i >= 0) {
            return i;
        }
        throw new NumberFormatException();
    }
}
