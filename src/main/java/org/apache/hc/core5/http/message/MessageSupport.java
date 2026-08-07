package org.apache.hc.core5.http.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.MessageHeaders;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class MessageSupport {
    private static final Tokenizer.Delimiter COMMA = Tokenizer.delimiters(AbstractJsonLexerKt.COMMA);
    private static final Set<String> HOP_BY_HOP;

    private MessageSupport() {
    }

    public static void formatTokens(CharArrayBuffer charArrayBuffer, List<String> list) {
        Args.notNull(charArrayBuffer, "Destination");
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (i > 0) {
                charArrayBuffer.append(", ");
            }
            charArrayBuffer.append(str);
        }
    }

    public static void formatTokens(CharArrayBuffer charArrayBuffer, String... strArr) {
        Args.notNull(charArrayBuffer, "Destination");
        int length = strArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (!z) {
                charArrayBuffer.append(", ");
            }
            charArrayBuffer.append(str);
            i++;
            z = false;
        }
    }

    public static void formatTokens(CharArrayBuffer charArrayBuffer, Set<String> set) {
        Args.notNull(charArrayBuffer, "Destination");
        if (set == null) {
            return;
        }
        boolean z = true;
        for (String str : set) {
            if (!z) {
                charArrayBuffer.append(", ");
            }
            charArrayBuffer.append(str);
            z = false;
        }
    }

    @Deprecated
    public static Header format(String str, Set<String> set) {
        return header(str, set);
    }

    public static Header headerOfTokens(String str, List<String> list) {
        Args.notBlank(str, "Header name");
        if (list == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(256);
        charArrayBuffer.append(str);
        charArrayBuffer.append(": ");
        formatTokens(charArrayBuffer, list);
        return BufferedHeader.create(charArrayBuffer);
    }

    public static Header header(String str, Set<String> set) {
        Args.notBlank(str, "Header name");
        if (set == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(256);
        charArrayBuffer.append(str);
        charArrayBuffer.append(": ");
        formatTokens(charArrayBuffer, set);
        return BufferedHeader.create(charArrayBuffer);
    }

    static {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.add("Connection");
        treeSet.add("Content-Length");
        treeSet.add("Transfer-Encoding");
        treeSet.add("Host");
        treeSet.add("Keep-Alive");
        treeSet.add("TE");
        treeSet.add("Upgrade");
        treeSet.add("Proxy-Authorization");
        treeSet.add("Proxy-Authentication-Info");
        treeSet.add("Proxy-Authenticate");
        HOP_BY_HOP = Collections.unmodifiableSet(treeSet);
    }

    public static Header header(String str, String... strArr) {
        Args.notBlank(str, "Header name");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(256);
        charArrayBuffer.append(str);
        charArrayBuffer.append(": ");
        formatTokens(charArrayBuffer, strArr);
        return BufferedHeader.create(charArrayBuffer);
    }

    @Deprecated
    public static Header format(String str, String... strArr) {
        return headerOfTokens(str, Arrays.asList(strArr));
    }

    public static void parseTokens(CharSequence charSequence, ParserCursor parserCursor, Consumer<String> consumer) {
        Args.notNull(charSequence, "Source");
        Args.notNull(parserCursor, "Cursor");
        Args.notNull(consumer, "Consumer");
        while (!parserCursor.atEnd()) {
            int pos = parserCursor.getPos();
            if (charSequence.charAt(pos) == ',') {
                parserCursor.updatePos(pos + 1);
            }
            consumer.accept(Tokenizer.INSTANCE.parseToken(charSequence, parserCursor, COMMA));
        }
    }

    public static void parseTokens(Header header, Consumer<String> consumer) {
        Args.notNull(header, "Header");
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            CharArrayBuffer buffer = formattedHeader.getBuffer();
            ParserCursor parserCursor = new ParserCursor(0, buffer.length());
            parserCursor.updatePos(formattedHeader.getValuePos());
            parseTokens(buffer, parserCursor, consumer);
            return;
        }
        String value = header.getValue();
        parseTokens(value, new ParserCursor(0, value.length()), consumer);
    }

    public static void parseTokens(MessageHeaders messageHeaders, String str, Consumer<String> consumer) {
        Args.notNull(messageHeaders, "Headers");
        Iterator<Header> itHeaderIterator = messageHeaders.headerIterator(str);
        while (itHeaderIterator.hasNext()) {
            parseTokens(itHeaderIterator.next(), consumer);
        }
    }

    public static Set<String> parseTokens(CharSequence charSequence, ParserCursor parserCursor) {
        Args.notNull(charSequence, "Source");
        Args.notNull(parserCursor, "Cursor");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        parseTokens(charSequence, parserCursor, new MessageSupport$$ExternalSyntheticLambda1(linkedHashSet));
        return linkedHashSet;
    }

    public static Set<String> parseTokens(Header header) {
        Args.notNull(header, "Header");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        parseTokens(header, new MessageSupport$$ExternalSyntheticLambda1(linkedHashSet));
        return linkedHashSet;
    }

    public static Iterator<String> iterateTokens(MessageHeaders messageHeaders, String str) {
        Args.notNull(messageHeaders, "Message headers");
        Args.notBlank(str, "Header name");
        return new BasicTokenIterator(messageHeaders.headerIterator(str));
    }

    public static void formatElements(CharArrayBuffer charArrayBuffer, List<HeaderElement> list) {
        Args.notNull(charArrayBuffer, "Destination");
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            HeaderElement headerElement = list.get(i);
            if (i > 0) {
                charArrayBuffer.append(", ");
            }
            BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, headerElement, false);
        }
    }

    public static void formatElements(CharArrayBuffer charArrayBuffer, HeaderElement... headerElementArr) {
        formatElements(charArrayBuffer, (List<HeaderElement>) Arrays.asList(headerElementArr));
    }

    public static Header headerOfElements(String str, List<HeaderElement> list) {
        Args.notBlank(str, "Header name");
        if (list == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(256);
        charArrayBuffer.append(str);
        charArrayBuffer.append(": ");
        formatElements(charArrayBuffer, list);
        return BufferedHeader.create(charArrayBuffer);
    }

    public static Header header(String str, HeaderElement... headerElementArr) {
        Args.notBlank(str, "Header name");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(256);
        charArrayBuffer.append(str);
        charArrayBuffer.append(": ");
        formatElements(charArrayBuffer, headerElementArr);
        return BufferedHeader.create(charArrayBuffer);
    }

    public static void parseElements(CharSequence charSequence, ParserCursor parserCursor, Consumer<HeaderElement> consumer) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(parserCursor, "Parser cursor");
        Args.notNull(consumer, "Consumer");
        while (!parserCursor.atEnd()) {
            consumer.accept(BasicHeaderValueParser.INSTANCE.parseHeaderElement(charSequence, parserCursor));
            if (!parserCursor.atEnd() && charSequence.charAt(parserCursor.getPos()) == ',') {
                parserCursor.updatePos(parserCursor.getPos() + 1);
            }
        }
    }

    public static void parseElements(Header header, Consumer<HeaderElement> consumer) {
        Args.notNull(header, "Header");
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            CharArrayBuffer buffer = formattedHeader.getBuffer();
            ParserCursor parserCursor = new ParserCursor(0, buffer.length());
            parserCursor.updatePos(formattedHeader.getValuePos());
            parseElements(buffer, parserCursor, consumer);
            return;
        }
        String value = header.getValue();
        parseElements(value, new ParserCursor(0, value.length()), consumer);
    }

    public static void parseElements(MessageHeaders messageHeaders, String str, Consumer<HeaderElement> consumer) {
        Args.notNull(messageHeaders, "Headers");
        Iterator<Header> itHeaderIterator = messageHeaders.headerIterator(str);
        while (itHeaderIterator.hasNext()) {
            parseElements(itHeaderIterator.next(), consumer);
        }
    }

    @Deprecated
    public static HeaderElement[] parse(Header header) {
        ArrayList arrayList = new ArrayList();
        parseElements(header, new MessageSupport$$ExternalSyntheticLambda0(arrayList));
        return (HeaderElement[]) arrayList.toArray(new HeaderElement[0]);
    }

    public static List<HeaderElement> parseElements(Header header) {
        ArrayList arrayList = new ArrayList();
        parseElements(header, new MessageSupport$$ExternalSyntheticLambda0(arrayList));
        return arrayList;
    }

    public static Iterator<HeaderElement> iterate(MessageHeaders messageHeaders, String str) {
        Args.notNull(messageHeaders, "Message headers");
        Args.notBlank(str, "Header name");
        return new BasicHeaderElementIterator(messageHeaders.headerIterator(str));
    }

    public static void formatParameters(CharArrayBuffer charArrayBuffer, List<NameValuePair> list) {
        Args.notNull(charArrayBuffer, "Destination");
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            NameValuePair nameValuePair = list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, nameValuePair, false);
        }
    }

    public static void formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair... nameValuePairArr) {
        Args.notNull(charArrayBuffer, "Destination");
        if (nameValuePairArr == null) {
            return;
        }
        int length = nameValuePairArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            NameValuePair nameValuePair = nameValuePairArr[i];
            if (!z) {
                charArrayBuffer.append("; ");
            }
            BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, nameValuePair, false);
            i++;
            z = false;
        }
    }

    public static void parseParameters(CharSequence charSequence, ParserCursor parserCursor, Consumer<NameValuePair> consumer) {
        Args.notNull(charSequence, "Source");
        Args.notNull(parserCursor, "Cursor");
        Args.notNull(consumer, "Consumer");
        while (!parserCursor.atEnd()) {
            consumer.accept(BasicHeaderValueParser.INSTANCE.parseNameValuePair(charSequence, parserCursor));
            if (!parserCursor.atEnd()) {
                char cCharAt = charSequence.charAt(parserCursor.getPos());
                if (cCharAt == ';') {
                    parserCursor.updatePos(parserCursor.getPos() + 1);
                }
                if (cCharAt == ',') {
                    return;
                }
            }
        }
    }

    public static void addContentTypeHeader(HttpMessage httpMessage, EntityDetails entityDetails) {
        if (entityDetails == null || entityDetails.getContentType() == null || httpMessage.containsHeader("Content-Type")) {
            return;
        }
        httpMessage.addHeader(new BasicHeader("Content-Type", entityDetails.getContentType()));
    }

    public static void addContentEncodingHeader(HttpMessage httpMessage, EntityDetails entityDetails) {
        if (entityDetails == null || entityDetails.getContentEncoding() == null || httpMessage.containsHeader("Content-Encoding")) {
            return;
        }
        httpMessage.addHeader(new BasicHeader("Content-Encoding", entityDetails.getContentEncoding()));
    }

    public static void addTrailerHeader(HttpMessage httpMessage, EntityDetails entityDetails) {
        Set<String> trailerNames;
        if (entityDetails == null || httpMessage.containsHeader("Trailer") || (trailerNames = entityDetails.getTrailerNames()) == null || trailerNames.isEmpty()) {
            return;
        }
        httpMessage.setHeader(header("Trailer", trailerNames));
    }

    public static boolean canResponseHaveBody(String str, HttpResponse httpResponse) {
        if (Method.HEAD.isSame(str)) {
            return false;
        }
        int code = httpResponse.getCode();
        return ((Method.CONNECT.isSame(str) && code == 200) || code < 200 || code == 204 || code == 304) ? false : true;
    }

    public static boolean isHopByHop(String str) {
        if (str == null) {
            return false;
        }
        return HOP_BY_HOP.contains(str);
    }

    public static Set<String> hopByHopConnectionSpecific(MessageHeaders messageHeaders) {
        Header firstHeader = messageHeaders.getFirstHeader("Connection");
        String value = firstHeader != null ? firstHeader.getValue() : null;
        if (value != null && !value.equalsIgnoreCase(HeaderElements.CLOSE) && !value.equalsIgnoreCase(HeaderElements.KEEP_ALIVE)) {
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            treeSet.addAll(HOP_BY_HOP);
            treeSet.addAll(parseTokens(firstHeader));
            return treeSet;
        }
        return HOP_BY_HOP;
    }
}
