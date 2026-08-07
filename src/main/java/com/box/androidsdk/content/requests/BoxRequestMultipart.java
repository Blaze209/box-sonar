package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.ProgressOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestMultipart extends BoxHttpRequest {
    private static final String BOUNDARY = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
    private static final int BUFFER_SIZE = 8192;
    private static final Logger LOGGER = Logger.getLogger(BoxRequestMultipart.class.getName());
    private Map<String, String> fields;
    private long fileSize;
    private String filename;
    private boolean firstBoundary;
    private InputStream inputStream;
    private final StringBuilder loggedRequest;
    private OutputStream outputStream;

    @Override // com.box.androidsdk.content.requests.BoxHttpRequest
    public /* bridge */ /* synthetic */ BoxHttpRequest addHeader(String str, String str2) {
        return super.addHeader(str, str2);
    }

    @Override // com.box.androidsdk.content.requests.BoxHttpRequest
    public /* bridge */ /* synthetic */ HttpURLConnection getUrlConnection() {
        return super.getUrlConnection();
    }

    public BoxRequestMultipart(URL url, BoxRequest.Methods methods, ProgressListener progressListener) throws IOException {
        super(url, methods, progressListener);
        this.loggedRequest = new StringBuilder();
        this.fields = new HashMap();
        this.firstBoundary = true;
        addHeader("Content-Type", "multipart/form-data; boundary=da39a3ee5e6b4b0d3255bfef95601890afd80709");
    }

    public void putField(String str, String str2) {
        this.fields.put(str, str2);
    }

    public void putField(String str, Date date) {
        this.fields.put(str, BoxDateFormat.format(date));
    }

    public void setFile(InputStream inputStream, String str) {
        this.inputStream = inputStream;
        this.filename = str;
    }

    public void setFile(InputStream inputStream, String str, long j) {
        setFile(inputStream, str);
        this.fileSize = j;
    }

    @Override // com.box.androidsdk.content.requests.BoxHttpRequest
    public BoxHttpRequest setBody(InputStream inputStream) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void setBody(String str) {
        throw new UnsupportedOperationException();
    }

    private OutputStream getOutputStream(HttpURLConnection httpURLConnection, ProgressListener progressListener) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        this.outputStream = outputStream;
        return progressListener != null ? new ProgressOutputStream(this.outputStream, progressListener, this.fileSize) : outputStream;
    }

    protected void writeBody(HttpURLConnection httpURLConnection, ProgressListener progressListener) throws BoxException {
        httpURLConnection.setChunkedStreamingMode(0);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        try {
            OutputStream outputStream = getOutputStream(httpURLConnection, progressListener);
            try {
                for (Map.Entry<String, String> entry : this.fields.entrySet()) {
                    writePartHeader(new String[][]{new String[]{"name", entry.getKey()}});
                    writeOutput(entry.getValue());
                }
                writePartHeader(new String[][]{new String[]{"name", "filename"}, new String[]{"filename", this.filename}}, "application/octet-stream");
                byte[] bArr = new byte[8192];
                int i = this.inputStream.read(bArr);
                while (i != -1) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    outputStream.write(bArr, 0, i);
                    i = this.inputStream.read(bArr);
                }
                if (LOGGER.isLoggable(Level.FINE)) {
                    this.loggedRequest.append("<File Contents Omitted>");
                }
                writeBoundary();
                writeOutput("--");
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            throw new BoxException("Couldn't connect to the Box API due to a network error.", e);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new BoxException("Thread has been interrupted", e2);
        }
    }

    protected void resetBody() throws IOException {
        this.firstBoundary = true;
        this.inputStream.reset();
        this.loggedRequest.setLength(0);
    }

    protected String bodyToString() {
        return this.loggedRequest.toString();
    }

    private void writeBoundary() throws IOException {
        if (!this.firstBoundary) {
            writeOutput(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.firstBoundary = false;
        writeOutput("--");
        writeOutput(BOUNDARY);
    }

    private void writePartHeader(String[][] strArr) throws IOException {
        writePartHeader(strArr, null);
    }

    private void writePartHeader(String[][] strArr, String str) throws IOException {
        writeBoundary();
        writeOutput(IOUtils.LINE_SEPARATOR_WINDOWS);
        writeOutput("Content-Disposition: form-data");
        for (int i = 0; i < strArr.length; i++) {
            writeOutput("; ");
            writeOutput(strArr[i][0]);
            writeOutput("=\"");
            writeOutput(strArr[i][1]);
            writeOutput("\"");
        }
        if (str != null) {
            writeOutput("\r\nContent-Type: ");
            writeOutput(str);
        }
        writeOutput("\r\n\r\n");
    }

    private void writeOutput(String str) throws IOException {
        this.outputStream.write(str.getBytes(Charset.forName("UTF-8")));
        if (LOGGER.isLoggable(Level.FINE)) {
            this.loggedRequest.append(str);
        }
    }

    private void writeOutput(int i) throws IOException {
        this.outputStream.write(i);
    }
}
