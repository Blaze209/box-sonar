package org.apache.hc.core5.http;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.common.MimeTypes;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.http.message.ParserCursor;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_NDJSON;
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_PDF;
    public static final ContentType APPLICATION_PROBLEM_JSON;
    public static final ContentType APPLICATION_PROBLEM_XML;
    public static final ContentType APPLICATION_RSS_XML;
    public static final ContentType APPLICATION_SOAP_XML;
    public static final ContentType APPLICATION_SVG_XML;
    public static final ContentType APPLICATION_XHTML_XML;
    public static final ContentType APPLICATION_XML;
    private static final String CHARSET = "charset";

    @Deprecated
    private static final Map<String, ContentType> CONTENT_TYPE_MAP;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;
    private static final NameValuePair[] EMPTY_NAME_VALUE_PAIR_ARRAY;
    public static final ContentType IMAGE_BMP;
    public static final ContentType IMAGE_GIF;
    public static final ContentType IMAGE_JPEG;
    public static final ContentType IMAGE_PNG;
    public static final ContentType IMAGE_SVG;
    public static final ContentType IMAGE_TIFF;
    public static final ContentType IMAGE_WEBP;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType MULTIPART_MIXED;
    public static final ContentType MULTIPART_RELATED;
    public static final ContentType TEXT_EVENT_STREAM;
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_MARKDOWN;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        ContentType contentTypeCreate = create("application/atom+xml", StandardCharsets.UTF_8);
        APPLICATION_ATOM_XML = contentTypeCreate;
        ContentType contentTypeCreate2 = create("application/x-www-form-urlencoded", StandardCharsets.ISO_8859_1);
        APPLICATION_FORM_URLENCODED = contentTypeCreate2;
        ContentType contentTypeCreate3 = create("application/json", StandardCharsets.UTF_8);
        APPLICATION_JSON = contentTypeCreate3;
        APPLICATION_NDJSON = create("application/x-ndjson", StandardCharsets.UTF_8);
        APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset) null);
        APPLICATION_PDF = create(DocumentSharingIntentHelper.MIME_TYPE_PDF, StandardCharsets.UTF_8);
        APPLICATION_SOAP_XML = create("application/soap+xml", StandardCharsets.UTF_8);
        ContentType contentTypeCreate4 = create("application/svg+xml", StandardCharsets.UTF_8);
        APPLICATION_SVG_XML = contentTypeCreate4;
        ContentType contentTypeCreate5 = create("application/xhtml+xml", StandardCharsets.UTF_8);
        APPLICATION_XHTML_XML = contentTypeCreate5;
        ContentType contentTypeCreate6 = create("application/xml", StandardCharsets.UTF_8);
        APPLICATION_XML = contentTypeCreate6;
        APPLICATION_PROBLEM_JSON = create("application/problem+json", StandardCharsets.UTF_8);
        APPLICATION_PROBLEM_XML = create("application/problem+xml", StandardCharsets.UTF_8);
        APPLICATION_RSS_XML = create("application/rss+xml", StandardCharsets.UTF_8);
        ContentType contentTypeCreate7 = create(MimeTypes.IMAGE_BMP);
        IMAGE_BMP = contentTypeCreate7;
        ContentType contentTypeCreate8 = create("image/gif");
        IMAGE_GIF = contentTypeCreate8;
        ContentType contentTypeCreate9 = create(MimeTypes.IMAGE_JPEG);
        IMAGE_JPEG = contentTypeCreate9;
        ContentType contentTypeCreate10 = create(MimeTypes.IMAGE_PNG);
        IMAGE_PNG = contentTypeCreate10;
        ContentType contentTypeCreate11 = create("image/svg+xml");
        IMAGE_SVG = contentTypeCreate11;
        ContentType contentTypeCreate12 = create("image/tiff");
        IMAGE_TIFF = contentTypeCreate12;
        ContentType contentTypeCreate13 = create(MimeTypes.IMAGE_WEBP);
        IMAGE_WEBP = contentTypeCreate13;
        ContentType contentTypeCreate14 = create(ShareTarget.ENCODING_TYPE_MULTIPART, StandardCharsets.ISO_8859_1);
        MULTIPART_FORM_DATA = contentTypeCreate14;
        MULTIPART_MIXED = create("multipart/mixed", StandardCharsets.ISO_8859_1);
        MULTIPART_RELATED = create("multipart/related", StandardCharsets.ISO_8859_1);
        ContentType contentTypeCreate15 = create("text/html", StandardCharsets.UTF_8);
        TEXT_HTML = contentTypeCreate15;
        TEXT_MARKDOWN = create("text/markdown", StandardCharsets.UTF_8);
        ContentType contentTypeCreate16 = create("text/plain", StandardCharsets.UTF_8);
        TEXT_PLAIN = contentTypeCreate16;
        ContentType contentTypeCreate17 = create("text/xml", StandardCharsets.UTF_8);
        TEXT_XML = contentTypeCreate17;
        TEXT_EVENT_STREAM = create("text/event-stream", StandardCharsets.UTF_8);
        WILDCARD = create("*/*", (Charset) null);
        EMPTY_NAME_VALUE_PAIR_ARRAY = new NameValuePair[0];
        ContentType[] contentTypeArr = {contentTypeCreate, contentTypeCreate2, contentTypeCreate3, contentTypeCreate4, contentTypeCreate5, contentTypeCreate6, contentTypeCreate7, contentTypeCreate8, contentTypeCreate9, contentTypeCreate10, contentTypeCreate11, contentTypeCreate12, contentTypeCreate13, contentTypeCreate14, contentTypeCreate15, contentTypeCreate16, contentTypeCreate17};
        HashMap map = new HashMap();
        for (int i = 0; i < 17; i++) {
            ContentType contentType = contentTypeArr[i];
            map.put(contentType.getMimeType(), contentType);
        }
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(map);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    ContentType(String str, Charset charset) {
        this.mimeType = str;
        this.charset = charset;
        this.params = null;
    }

    ContentType(String str, Charset charset, NameValuePair[] nameValuePairArr) {
        this.mimeType = str;
        this.charset = charset;
        this.params = nameValuePairArr;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public Charset getCharset(Charset charset) {
        Charset charset2 = this.charset;
        return charset2 != null ? charset2 : charset;
    }

    public String getParameter(String str) {
        Args.notEmpty(str, "Parameter name");
        NameValuePair[] nameValuePairArr = this.params;
        if (nameValuePairArr == null) {
            return null;
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            MessageSupport.formatParameters(charArrayBuffer, this.params);
        } else if (this.charset != null) {
            charArrayBuffer.append("; charset=");
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    private static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"' || cCharAt == ',' || cCharAt == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(String str, Charset charset) {
        String lowerCase = TextUtils.toLowerCase((String) Args.notBlank(str, "MIME type"));
        Args.check(valid(lowerCase), "MIME type may not contain reserved characters");
        return new ContentType(lowerCase, charset);
    }

    public static ContentType create(String str) {
        return create(str, (Charset) null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, !TextUtils.isBlank(str2) ? Charset.forName(str2) : null);
    }

    private static ContentType create(HeaderElement headerElement, boolean z) {
        if (TextUtils.isBlank(headerElement.getName())) {
            return null;
        }
        return create(headerElement.getName(), headerElement.getParameters(), z);
    }

    private static ContentType create(String str, NameValuePair[] nameValuePairArr, boolean z) {
        Charset charsetForName;
        if (nameValuePairArr == null) {
            charsetForName = null;
            break;
        }
        int length = nameValuePairArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                NameValuePair nameValuePair = nameValuePairArr[i];
                if (nameValuePair.getName().equalsIgnoreCase(CHARSET)) {
                    String value = nameValuePair.getValue();
                    if (!TextUtils.isBlank(value)) {
                        try {
                            charsetForName = Charset.forName(value);
                            break;
                        } catch (UnsupportedCharsetException e) {
                            if (z) {
                                throw e;
                            }
                            charsetForName = null;
                            break;
                        }
                    }
                } else {
                    i++;
                }
            }
            charsetForName = null;
            break;
        }
        if (nameValuePairArr == null || nameValuePairArr.length <= 0) {
            nameValuePairArr = null;
        }
        return new ContentType(str, charsetForName, nameValuePairArr);
    }

    public static ContentType create(String str, NameValuePair... nameValuePairArr) throws UnsupportedCharsetException {
        Args.check(valid(TextUtils.toLowerCase((String) Args.notBlank(str, "MIME type"))), "MIME type may not contain reserved characters");
        return create(str, nameValuePairArr != null ? (NameValuePair[]) nameValuePairArr.clone() : null, true);
    }

    public static ContentType parse(CharSequence charSequence) throws UnsupportedCharsetException {
        return parse(charSequence, true);
    }

    public static ContentType parseLenient(CharSequence charSequence) throws UnsupportedCharsetException {
        return parse(charSequence, false);
    }

    private static ContentType parse(CharSequence charSequence, boolean z) throws UnsupportedCharsetException {
        if (TextUtils.isBlank(charSequence)) {
            return null;
        }
        ParserCursor parserCursor = new ParserCursor(0, charSequence.length());
        final AtomicReference atomicReference = new AtomicReference();
        MessageSupport.parseElements(charSequence, parserCursor, (Consumer<HeaderElement>) new Consumer() { // from class: org.apache.hc.core5.http.ContentType$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, (HeaderElement) obj);
            }
        });
        HeaderElement headerElement = (HeaderElement) atomicReference.get();
        if (headerElement != null) {
            return create(headerElement, z);
        }
        return null;
    }

    @Deprecated
    public static ContentType getByMimeType(String str) {
        if (str == null) {
            return null;
        }
        return CONTENT_TYPE_MAP.get(str);
    }

    public static Charset getCharset(ContentType contentType, Charset charset) {
        return contentType != null ? contentType.getCharset(charset) : charset;
    }

    public ContentType withCharset(Charset charset) {
        return create(getMimeType(), charset);
    }

    public ContentType withCharset(String str) {
        return create(getMimeType(), str);
    }

    public ContentType withParameters(NameValuePair... nameValuePairArr) throws UnsupportedCharsetException {
        if (nameValuePairArr.length == 0) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        NameValuePair[] nameValuePairArr2 = this.params;
        if (nameValuePairArr2 != null) {
            for (NameValuePair nameValuePair : nameValuePairArr2) {
                linkedHashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
        }
        for (NameValuePair nameValuePair2 : nameValuePairArr) {
            linkedHashMap.put(nameValuePair2.getName(), nameValuePair2.getValue());
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size() + 1);
        if (this.charset != null && !linkedHashMap.containsKey(CHARSET)) {
            arrayList.add(new BasicNameValuePair(CHARSET, this.charset.name()));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return create(getMimeType(), (NameValuePair[]) arrayList.toArray(EMPTY_NAME_VALUE_PAIR_ARRAY), true);
    }

    public boolean isSameMimeType(ContentType contentType) {
        return contentType != null && this.mimeType.equalsIgnoreCase(contentType.getMimeType());
    }
}
