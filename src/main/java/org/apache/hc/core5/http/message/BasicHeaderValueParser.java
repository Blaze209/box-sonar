package org.apache.hc.core5.http.message;

import java.util.ArrayList;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderValueParser implements HeaderValueParser {
    private static final char ELEM_DELIMITER = ',';
    private final Tokenizer tokenizer = Tokenizer.INSTANCE;
    public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
    private static final char PARAM_DELIMITER = ';';
    private static final Tokenizer.Delimiter TOKEN_DELIMITER = Tokenizer.delimiters('=', PARAM_DELIMITER, ',');
    private static final Tokenizer.Delimiter VALUE_DELIMITER = Tokenizer.delimiters(PARAM_DELIMITER, ',');
    private static final HeaderElement[] EMPTY_HEADER_ELEMENT_ARRAY = new HeaderElement[0];
    private static final NameValuePair[] EMPTY_NAME_VALUE_ARRAY = new NameValuePair[0];

    @Override // org.apache.hc.core5.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharSequence charSequence, ParserCursor parserCursor) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(parserCursor, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            HeaderElement headerElement = parseHeaderElement(charSequence, parserCursor);
            if (!headerElement.getName().isEmpty() || headerElement.getValue() != null) {
                arrayList.add(headerElement);
            }
        }
        return (HeaderElement[]) arrayList.toArray(EMPTY_HEADER_ELEMENT_ARRAY);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0034  */
    @Override // org.apache.hc.core5.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharSequence charSequence, ParserCursor parserCursor) {
        NameValuePair[] parameters;
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair nameValuePair = parseNameValuePair(charSequence, parserCursor);
        if (parserCursor.atEnd()) {
            parameters = null;
        } else {
            char cCharAt = charSequence.charAt(parserCursor.getPos());
            if (cCharAt == ';' || cCharAt == ',') {
                parserCursor.updatePos(parserCursor.getPos() + 1);
            }
            if (cCharAt != ',') {
                parameters = parseParameters(charSequence, parserCursor);
            } else {
                parameters = null;
            }
        }
        return new BasicHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), parameters);
    }

    @Override // org.apache.hc.core5.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharSequence charSequence, ParserCursor parserCursor) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(parserCursor, "Parser cursor");
        this.tokenizer.skipWhiteSpace(charSequence, parserCursor);
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charSequence, parserCursor));
            if (!parserCursor.atEnd()) {
                char cCharAt = charSequence.charAt(parserCursor.getPos());
                if (cCharAt == ';') {
                    parserCursor.updatePos(parserCursor.getPos() + 1);
                }
                if (cCharAt == ',') {
                    break;
                }
            }
        }
        return (NameValuePair[]) arrayList.toArray(EMPTY_NAME_VALUE_ARRAY);
    }

    @Override // org.apache.hc.core5.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharSequence charSequence, ParserCursor parserCursor) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(parserCursor, "Parser cursor");
        String token = this.tokenizer.parseToken(charSequence, parserCursor, TOKEN_DELIMITER);
        if (parserCursor.atEnd()) {
            return new BasicNameValuePair(token, null);
        }
        if (charSequence.charAt(parserCursor.getPos()) != '=') {
            return new BasicNameValuePair(token, null);
        }
        parserCursor.updatePos(parserCursor.getPos() + 1);
        return new BasicNameValuePair(token, this.tokenizer.parseValue(charSequence, parserCursor, VALUE_DELIMITER));
    }
}
