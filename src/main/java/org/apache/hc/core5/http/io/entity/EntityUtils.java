package org.apache.hc.core5.http.io.entity;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.net.WWWFormCodec;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.ByteArrayBuffer;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class EntityUtils {
    private static final Map<String, ContentType> CONTENT_TYPE_MAP;
    private static final int DEFAULT_BYTE_BUFFER_SIZE = 4096;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final int DEFAULT_CHAR_BUFFER_SIZE = 1024;
    private static final int DEFAULT_ENTITY_RETURN_MAX_LENGTH = Integer.MAX_VALUE;

    private static int toContentLength(int i) {
        if (i < 0) {
            return 4096;
        }
        return i;
    }

    static {
        ContentType[] contentTypeArr = {ContentType.APPLICATION_ATOM_XML, ContentType.APPLICATION_FORM_URLENCODED, ContentType.APPLICATION_JSON, ContentType.APPLICATION_SVG_XML, ContentType.APPLICATION_XHTML_XML, ContentType.APPLICATION_XML, ContentType.MULTIPART_FORM_DATA, ContentType.TEXT_HTML, ContentType.TEXT_PLAIN, ContentType.TEXT_XML};
        HashMap map = new HashMap();
        for (int i = 0; i < 10; i++) {
            ContentType contentType = contentTypeArr[i];
            map.put(contentType.getMimeType(), contentType);
        }
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(map);
    }

    private EntityUtils() {
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException unused) {
        }
    }

    public static void consume(HttpEntity httpEntity) throws IOException {
        if (httpEntity != null && httpEntity.isStreaming()) {
            Closer.close(httpEntity.getContent());
        }
    }

    static long checkContentLength(EntityDetails entityDetails) {
        return Args.checkRange(entityDetails.getContentLength(), -1L, SieveCacheKt.NodeLinkMask, "HTTP entity too large to be buffered in memory)");
    }

    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, "HttpEntity");
        int contentLength = toContentLength((int) checkContentLength(httpEntity));
        InputStream content = httpEntity.getContent();
        if (content == null) {
            if (content != null) {
                content.close();
            }
            return null;
        }
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = content.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayBuffer.append(bArr, 0, i);
            }
            byte[] byteArray = byteArrayBuffer.toByteArray();
            if (content != null) {
                content.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (content != null) {
                    try {
                        content.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static byte[] toByteArray(HttpEntity httpEntity, int i) throws IOException {
        Args.notNull(httpEntity, "HttpEntity");
        int contentLength = toContentLength((int) checkContentLength(httpEntity));
        InputStream content = httpEntity.getContent();
        if (content == null) {
            if (content != null) {
                content.close();
            }
            return null;
        }
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(Math.min(i, contentLength));
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = content.read(bArr);
                if (i2 == -1 || byteArrayBuffer.length() >= i) {
                    break;
                }
                byteArrayBuffer.append(bArr, 0, i2);
            }
            byteArrayBuffer.setLength(Math.min(byteArrayBuffer.length(), i));
            byte[] byteArray = byteArrayBuffer.toByteArray();
            if (content != null) {
                content.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (content != null) {
                    try {
                        content.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private static CharArrayBuffer toCharArrayBuffer(InputStream inputStream, int i, Charset charset, int i2) throws IOException {
        Args.notNull(inputStream, "InputStream");
        Args.positive(i2, "maxResultLength");
        if (charset == null) {
            charset = DEFAULT_CHARSET;
        }
        if (i <= 0) {
            i = 1024;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(Math.min(i2, i));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        char[] cArr = new char[1024];
        while (true) {
            int i3 = inputStreamReader.read(cArr);
            if (i3 == -1 || charArrayBuffer.length() >= i2) {
                break;
            }
            charArrayBuffer.append(cArr, 0, i3);
        }
        charArrayBuffer.setLength(Math.min(charArrayBuffer.length(), i2));
        return charArrayBuffer;
    }

    private static String toString(HttpEntity httpEntity, ContentType contentType, int i) throws IOException {
        Args.notNull(httpEntity, "HttpEntity");
        int contentLength = toContentLength((int) checkContentLength(httpEntity));
        InputStream content = httpEntity.getContent();
        Charset charset = null;
        if (content == null) {
            if (content != null) {
                content.close();
            }
            return null;
        }
        if (contentType != null) {
            try {
                Charset charset2 = contentType.getCharset();
                if (charset2 == null) {
                    ContentType contentType2 = CONTENT_TYPE_MAP.get(contentType.getMimeType());
                    if (contentType2 != null) {
                        charset = contentType2.getCharset();
                    }
                } else {
                    charset = charset2;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        String string = toCharArrayBuffer(content, contentLength, charset, i).toString();
        if (content != null) {
            content.close();
        }
        return string;
    }

    public static String toString(HttpEntity httpEntity, Charset charset) throws ParseException, IOException {
        return toString(httpEntity, charset, Integer.MAX_VALUE);
    }

    public static String toString(HttpEntity httpEntity, Charset charset, int i) throws ParseException, IOException {
        ContentType contentTypeWithCharset;
        Args.notNull(httpEntity, "HttpEntity");
        try {
            contentTypeWithCharset = ContentType.parse(httpEntity.getContentType());
        } catch (UnsupportedCharsetException e) {
            if (charset == null) {
                throw new UnsupportedEncodingException(e.getMessage());
            }
            contentTypeWithCharset = null;
        }
        if (contentTypeWithCharset != null) {
            if (contentTypeWithCharset.getCharset() == null) {
                contentTypeWithCharset = contentTypeWithCharset.withCharset(charset);
            }
        } else {
            contentTypeWithCharset = ContentType.DEFAULT_TEXT.withCharset(charset);
        }
        return toString(httpEntity, contentTypeWithCharset, i);
    }

    public static String toString(HttpEntity httpEntity, String str) throws ParseException, IOException {
        return toString(httpEntity, str, Integer.MAX_VALUE);
    }

    public static String toString(HttpEntity httpEntity, String str, int i) throws ParseException, IOException {
        return toString(httpEntity, str != null ? Charset.forName(str) : null, i);
    }

    public static String toString(HttpEntity httpEntity) throws ParseException, IOException {
        return toString(httpEntity, Integer.MAX_VALUE);
    }

    public static String toString(HttpEntity httpEntity, int i) throws ParseException, IOException {
        Args.notNull(httpEntity, "HttpEntity");
        return toString(httpEntity, ContentType.parse(httpEntity.getContentType()), i);
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws IOException {
        return parse(httpEntity, Integer.MAX_VALUE);
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity, int i) throws IOException {
        Args.notNull(httpEntity, "HttpEntity");
        int contentLength = toContentLength((int) checkContentLength(httpEntity));
        ContentType contentType = ContentType.parse(httpEntity.getContentType());
        if (!ContentType.APPLICATION_FORM_URLENCODED.isSameMimeType(contentType)) {
            return Collections.emptyList();
        }
        Charset charset = contentType.getCharset(DEFAULT_CHARSET);
        InputStream content = httpEntity.getContent();
        try {
            if (content == null) {
                List<NameValuePair> listEmptyList = Collections.emptyList();
                if (content != null) {
                    content.close();
                }
                return listEmptyList;
            }
            CharArrayBuffer charArrayBuffer = toCharArrayBuffer(content, contentLength, charset, i);
            if (content != null) {
                content.close();
            }
            if (charArrayBuffer.isEmpty()) {
                return Collections.emptyList();
            }
            return WWWFormCodec.parse(charArrayBuffer, charset);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (content != null) {
                    try {
                        content.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
