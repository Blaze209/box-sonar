package external.sdk.pendo.io.mozilla.javascript.tools;

import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.ParsedContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes4.dex */
public class SourceReader {
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static Object readFileOrUrl(String str, boolean z, String str2) throws Throwable {
        ?? r4;
        InputStream inputStream;
        String contentType;
        int contentLength;
        FileInputStream fileInputStream;
        URL url = toUrl(str);
        Object obj = null;
        obj = null;
        String encoding = null;
        try {
            if (url == null) {
                File file = new File(str);
                contentLength = (int) file.length();
                fileInputStream = new FileInputStream(file);
                contentType = null;
            } else {
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                inputStream = uRLConnectionOpenConnection.getInputStream();
                if (z) {
                    try {
                        ParsedContentType parsedContentType = new ParsedContentType(uRLConnectionOpenConnection.getContentType());
                        contentType = parsedContentType.getContentType();
                        encoding = parsedContentType.getEncoding();
                    } catch (Throwable th) {
                        th = th;
                        obj = inputStream;
                        r4 = obj;
                        if (r4 != 0) {
                            r4.close();
                        }
                        throw th;
                    }
                } else {
                    contentType = null;
                }
                contentLength = uRLConnectionOpenConnection.getContentLength();
                obj = encoding;
                r4 = inputStream;
                if (contentLength > 1048576) {
                    contentLength = -1;
                }
            }
            if (contentLength <= 0) {
                obj = encoding;
                r4 = inputStream;
                r4 = fileInputStream;
                contentLength = 4096;
            }
            try {
                obj = encoding;
                r4 = inputStream;
                r4 = fileInputStream;
                byte[] stream = Kit.readStream(r4, contentLength);
                if (r4 != 0) {
                    r4.close();
                }
                if (!z) {
                    return stream;
                }
                if (obj != null) {
                    str2 = obj;
                } else if (stream.length > 3 && stream[0] == -1 && stream[1] == -2 && stream[2] == 0 && stream[3] == 0) {
                    str2 = "UTF-32LE";
                } else if (stream.length > 3 && stream[0] == 0 && stream[1] == 0 && stream[2] == -2 && stream[3] == -1) {
                    str2 = "UTF-32BE";
                } else if (stream.length > 2 && stream[0] == -17 && stream[1] == -69 && stream[2] == -65) {
                    str2 = "UTF-8";
                } else if (stream.length > 1 && stream[0] == -1 && stream[1] == -2) {
                    str2 = "UTF-16LE";
                } else if (stream.length > 1 && stream[0] == -2 && stream[1] == -1) {
                    str2 = "UTF-16BE";
                } else if (str2 == 0) {
                    if (url == null) {
                        str2 = System.getProperty("file.encoding");
                    } else if (contentType == null || !contentType.startsWith("application/")) {
                        str2 = "US-ASCII";
                    } else {
                        str2 = "UTF-8";
                    }
                }
                String str3 = new String(stream, (String) str2);
                return (str3.length() <= 0 || str3.charAt(0) != 65279) ? str3 : str3.substring(1);
            } catch (Throwable th2) {
                th = th2;
                if (r4 != 0) {
                    r4.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static URL toUrl(String str) {
        if (str.indexOf(58) < 2) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
