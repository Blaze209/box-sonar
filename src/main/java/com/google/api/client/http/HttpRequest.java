package com.google.api.client.http;

import com.amplitude.api.Constants;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.opencensus.common.Scope;
import io.opencensus.contrib.http.util.HttpTraceAttributeConstants;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX;
    public static final String VERSION;

    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = 20000;
    private int readTimeout = 20000;
    private int writeTimeout = 0;
    private boolean followRedirects = true;
    private boolean useRawRedirectUrls = false;
    private boolean throwExceptionOnExecuteError = true;

    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;
    private final Tracer tracer = OpenCensusUtils.getTracer();
    private boolean responseReturnRawInputStream = false;

    static {
        String version = getVersion();
        VERSION = version;
        USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/" + version + " (gzip)";
    }

    HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public HttpRequest setWriteTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.writeTimeout = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public boolean getUseRawRedirectUrls() {
        return this.useRawRedirectUrls;
    }

    public HttpRequest setUseRawRedirectUrls(boolean z) {
        this.useRawRedirectUrls = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    public boolean getResponseReturnRawInputStream() {
        return this.responseReturnRawInputStream;
    }

    public HttpRequest setResponseReturnRawInputStream(boolean z) {
        this.responseReturnRawInputStream = z;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x02d4 A[Catch: all -> 0x0317, TryCatch #3 {all -> 0x0317, blocks: (B:113:0x02ce, B:115:0x02d4, B:117:0x02d8, B:120:0x02e0, B:124:0x02f2, B:126:0x02f6, B:128:0x0300, B:131:0x030a, B:135:0x0313), top: B:175:0x02ce }] */
    /* JADX WARN: Code duplicated, block: B:117:0x02d8 A[Catch: all -> 0x0317, TryCatch #3 {all -> 0x0317, blocks: (B:113:0x02ce, B:115:0x02d4, B:117:0x02d8, B:120:0x02e0, B:124:0x02f2, B:126:0x02f6, B:128:0x0300, B:131:0x030a, B:135:0x0313), top: B:175:0x02ce }] */
    /* JADX WARN: Code duplicated, block: B:118:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e0 A[Catch: all -> 0x0317, TryCatch #3 {all -> 0x0317, blocks: (B:113:0x02ce, B:115:0x02d4, B:117:0x02d8, B:120:0x02e0, B:124:0x02f2, B:126:0x02f6, B:128:0x0300, B:131:0x030a, B:135:0x0313), top: B:175:0x02ce }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:123:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:135:0x0313 A[Catch: all -> 0x0317, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0317, blocks: (B:113:0x02ce, B:115:0x02d4, B:117:0x02d8, B:120:0x02e0, B:124:0x02f2, B:126:0x02f6, B:128:0x0300, B:131:0x030a, B:135:0x0313), top: B:175:0x02ce }] */
    /* JADX WARN: Code duplicated, block: B:141:0x031e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x0320  */
    /* JADX WARN: Code duplicated, block: B:143:0x0322  */
    /* JADX WARN: Code duplicated, block: B:148:0x032a  */
    /* JADX WARN: Code duplicated, block: B:149:0x032d  */
    /* JADX WARN: Code duplicated, block: B:152:0x033e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0342  */
    /* JADX WARN: Code duplicated, block: B:166:0x035c  */
    /* JADX WARN: Code duplicated, block: B:167:0x035d A[LOOP:0: B:10:0x0035->B:167:0x035d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:175:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x030a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:38:0x0129  */
    /* JADX WARN: Code duplicated, block: B:45:0x013b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0140  */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:51:0x015b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0165  */
    /* JADX WARN: Code duplicated, block: B:55:0x016f  */
    /* JADX WARN: Code duplicated, block: B:57:0x017f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0183  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x01da  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:70:0x020d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0215  */
    /* JADX WARN: Code duplicated, block: B:74:0x0227  */
    /* JADX WARN: Code duplicated, block: B:76:0x0235  */
    /* JADX WARN: Code duplicated, block: B:78:0x023e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0251  */
    /* JADX WARN: Code duplicated, block: B:85:0x0263  */
    /* JADX WARN: Code duplicated, block: B:89:0x0285 A[Catch: all -> 0x02a3, IOException -> 0x02a6, TRY_LEAVE, TryCatch #1 {IOException -> 0x02a6, blocks: (B:87:0x027f, B:89:0x0285, B:93:0x0299, B:95:0x029f, B:96:0x02a2), top: B:171:0x027f, outer: #0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.google.api.client.http.HttpResponseInterceptor] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.api.client.http.HttpUnsuccessfulResponseHandler] */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.google.api.client.http.LowLevelHttpRequest] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public HttpResponse execute() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        String userAgent;
        HttpContent httpContent;
        boolean z;
        Span span;
        boolean z2;
        boolean z3;
        Integer num;
        long j;
        StreamingContent streamingContent;
        boolean z4;
        Span span2;
        Scope scopeWithSpan;
        ?? r4;
        HttpIOExceptionHandler httpIOExceptionHandler;
        ?? r0;
        ?? r5;
        boolean zHandleResponse;
        boolean z5;
        BackOffPolicy backOffPolicy;
        long nextBackOffMillis;
        Integer numValueOf;
        ?? r1;
        boolean z6;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        String type;
        StreamingContent loggingStreamingContent;
        HttpEncoding httpEncoding;
        String name;
        StreamingContent httpEncodingStreamingContent;
        long length;
        ?? r6;
        String str;
        String str2;
        Preconditions.checkArgument(this.numRetries >= 0);
        int i = this.numRetries;
        BackOffPolicy backOffPolicy2 = this.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(this.requestMethod);
        Preconditions.checkNotNull(this.url);
        Span spanStartSpan = this.tracer.spanBuilder(OpenCensusUtils.SPAN_NAME_HTTP_REQUEST_EXECUTE).setRecordEvents(OpenCensusUtils.isRecordEvent()).startSpan();
        int i2 = i;
        ?? r2 = 0;
        while (true) {
            spanStartSpan.addAnnotation("retry #" + (this.numRetries - i2));
            if (r2 != 0) {
                r2.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = this.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(this);
            }
            String strBuild = this.url.build();
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_METHOD, this.requestMethod);
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_HOST, this.url.getHost());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_PATH, this.url.getRawPath());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_URL, strBuild);
            ?? BuildRequest = this.transport.buildRequest(this.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z7 = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                try {
                    try {
                        if (z7) {
                            sb = new StringBuilder();
                            sb.append("-------------- REQUEST  --------------").append(StringUtils.LINE_SEPARATOR);
                            sb.append(this.requestMethod).append(' ').append(strBuild).append(StringUtils.LINE_SEPARATOR);
                            if (this.curlLoggingEnabled) {
                                sb2 = new StringBuilder("curl -v --compressed");
                                if (!this.requestMethod.equals("GET")) {
                                    sb2.append(" -X ").append(this.requestMethod);
                                }
                            }
                            userAgent = this.headers.getUserAgent();
                            if (!this.suppressUserAgentSuffix) {
                                if (userAgent == null) {
                                    HttpHeaders httpHeaders = this.headers;
                                    String str3 = USER_AGENT_SUFFIX;
                                    httpHeaders.setUserAgent(str3);
                                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str3);
                                } else {
                                    String str4 = userAgent + " " + USER_AGENT_SUFFIX;
                                    this.headers.setUserAgent(str4);
                                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str4);
                                }
                            }
                            OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
                            HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, BuildRequest);
                            if (!this.suppressUserAgentSuffix) {
                                this.headers.setUserAgent(userAgent);
                            }
                            httpContent = this.content;
                            if (httpContent != null || httpContent.retrySupported()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (httpContent != null) {
                                type = this.content.getType();
                                if (z7) {
                                    num = null;
                                    j = -1;
                                    loggingStreamingContent = new LoggingStreamingContent(httpContent, HttpTransport.LOGGER, Level.CONFIG, this.contentLoggingLimit);
                                } else {
                                    num = null;
                                    j = -1;
                                    loggingStreamingContent = httpContent;
                                }
                                httpEncoding = this.encoding;
                                if (httpEncoding == null) {
                                    length = this.content.getLength();
                                    r6 = num;
                                } else {
                                    name = httpEncoding.getName();
                                    httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                                    length = j;
                                }
                                if (z7) {
                                    r6 = name;
                                    if (type != null) {
                                        z2 = z7;
                                        z3 = z;
                                        str2 = "Content-Type: " + type;
                                        span = spanStartSpan;
                                        sb.append(str2).append(StringUtils.LINE_SEPARATOR);
                                        if (sb2 != null) {
                                            httpEncodingStreamingContent = loggingStreamingContent;
                                            sb2.append(" -H '" + str2 + "'");
                                        }
                                    } else {
                                        httpEncodingStreamingContent = loggingStreamingContent;
                                        span = spanStartSpan;
                                        z2 = z7;
                                        z3 = z;
                                    }
                                    if (r6 != 0) {
                                        str = "Content-Encoding: " + r6;
                                        sb.append(str).append(StringUtils.LINE_SEPARATOR);
                                        if (sb2 != null) {
                                            sb2.append(" -H '" + str + "'");
                                        }
                                    }
                                    if (length >= 0) {
                                        sb.append("Content-Length: " + length).append(StringUtils.LINE_SEPARATOR);
                                    }
                                } else {
                                    r6 = name;
                                    span = spanStartSpan;
                                    z2 = z7;
                                    z3 = z;
                                }
                                if (sb2 != null) {
                                    httpEncodingStreamingContent = loggingStreamingContent;
                                    sb2.append(" -d '@-'");
                                }
                                httpEncodingStreamingContent = loggingStreamingContent;
                                BuildRequest.setContentType(type);
                                BuildRequest.setContentEncoding(r6);
                                BuildRequest.setContentLength(length);
                                BuildRequest.setStreamingContent(httpEncodingStreamingContent);
                                streamingContent = httpEncodingStreamingContent;
                            } else {
                                span = spanStartSpan;
                                i2 = i2;
                                z2 = z7;
                                z3 = z;
                                num = null;
                                j = -1;
                            }
                            if (z2) {
                                streamingContent = httpContent;
                                logger.config(sb.toString());
                                if (sb2 != null) {
                                    sb2.append(" -- '");
                                    sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                                    sb2.append("'");
                                    if (streamingContent != null) {
                                        sb2.append(" << $$$");
                                    }
                                    logger.config(sb2.toString());
                                }
                            }
                            if (z3 || i2 <= 0) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
                            BuildRequest.setWriteTimeout(this.writeTimeout);
                            span2 = span;
                            scopeWithSpan = this.tracer.withSpan(span2);
                            OpenCensusUtils.recordSentMessageEvent(span2, BuildRequest.getContentLength());
                            lowLevelHttpResponseExecute = BuildRequest.execute();
                            if (lowLevelHttpResponseExecute != null) {
                                OpenCensusUtils.recordReceivedMessageEvent(span2, lowLevelHttpResponseExecute.getContentLength());
                            }
                            HttpResponse httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                            scopeWithSpan.close();
                            r4 = httpResponse;
                            r0 = num;
                            if (r4 == 0) {
                                try {
                                    if (r4.isSuccessStatusCode()) {
                                        if (r4 == 0) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        z5 = z4 & z6;
                                    } else {
                                        r5 = this.unsuccessfulResponseHandler;
                                        if (r5 != 0) {
                                            zHandleResponse = r5.handleResponse(this, r4, z4);
                                        } else {
                                            zHandleResponse = false;
                                        }
                                        if (!zHandleResponse) {
                                            if (!handleRedirect(r4.getStatusCode(), r4.getHeaders())) {
                                                zHandleResponse = true;
                                            } else if (z4 && (backOffPolicy = this.backOffPolicy) != null && backOffPolicy.isBackOffRequired(r4.getStatusCode())) {
                                                nextBackOffMillis = this.backOffPolicy.getNextBackOffMillis();
                                                if (nextBackOffMillis != j) {
                                                    try {
                                                        this.sleeper.sleep(nextBackOffMillis);
                                                    } catch (InterruptedException unused) {
                                                    }
                                                    zHandleResponse = true;
                                                }
                                            }
                                        }
                                        z5 = z4 & zHandleResponse;
                                        if (z5) {
                                            r4.ignore();
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (r4 != 0) {
                                        r4.disconnect();
                                    }
                                    throw th;
                                }
                            } else {
                                if (r4 == 0) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                z5 = z4 & z6;
                            }
                            i2--;
                            if (!z5) {
                                if (r4 == 0) {
                                    numValueOf = num;
                                } else {
                                    numValueOf = Integer.valueOf(r4.getStatusCode());
                                }
                                span2.end(OpenCensusUtils.getEndSpanOptions(numValueOf));
                                if (r4 != 0) {
                                    throw r0;
                                }
                                r1 = this.responseInterceptor;
                                if (r1 != 0) {
                                    r1.interceptResponse(r4);
                                }
                                if (this.throwExceptionOnExecuteError || r4.isSuccessStatusCode()) {
                                    return r4;
                                }
                                try {
                                    throw new HttpResponseException((HttpResponse) r4);
                                } catch (Throwable th2) {
                                    r4.disconnect();
                                    throw th2;
                                }
                            }
                            r2 = r4;
                            spanStartSpan = span2;
                        } else {
                            sb = null;
                        }
                        HttpResponse httpResponse2 = new HttpResponse(this, lowLevelHttpResponseExecute);
                        scopeWithSpan.close();
                        r4 = httpResponse2;
                        r0 = num;
                        if (r4 == 0) {
                            if (r4 == 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z5 = z4 & z6;
                        } else if (r4.isSuccessStatusCode()) {
                            r5 = this.unsuccessfulResponseHandler;
                            if (r5 != 0) {
                                zHandleResponse = r5.handleResponse(this, r4, z4);
                            } else {
                                zHandleResponse = false;
                            }
                            if (!zHandleResponse) {
                                if (!handleRedirect(r4.getStatusCode(), r4.getHeaders())) {
                                    zHandleResponse = true;
                                } else if (z4) {
                                    nextBackOffMillis = this.backOffPolicy.getNextBackOffMillis();
                                    if (nextBackOffMillis != j) {
                                        this.sleeper.sleep(nextBackOffMillis);
                                        zHandleResponse = true;
                                    }
                                }
                            }
                            z5 = z4 & zHandleResponse;
                            if (z5) {
                                r4.ignore();
                            }
                        } else {
                            if (r4 == 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z5 = z4 & z6;
                        }
                        i2--;
                        if (!z5) {
                            if (r4 == 0) {
                                numValueOf = num;
                            } else {
                                numValueOf = Integer.valueOf(r4.getStatusCode());
                            }
                            span2.end(OpenCensusUtils.getEndSpanOptions(numValueOf));
                            if (r4 != 0) {
                                throw r0;
                            }
                            r1 = this.responseInterceptor;
                            if (r1 != 0) {
                                r1.interceptResponse(r4);
                            }
                            if (this.throwExceptionOnExecuteError) {
                            }
                            return r4;
                        }
                        r2 = r4;
                        spanStartSpan = span2;
                    } catch (Throwable th3) {
                        InputStream content = lowLevelHttpResponseExecute.getContent();
                        if (content != null) {
                            content.close();
                        }
                        throw th3;
                    }
                    lowLevelHttpResponseExecute = BuildRequest.execute();
                    if (lowLevelHttpResponseExecute != null) {
                        OpenCensusUtils.recordReceivedMessageEvent(span2, lowLevelHttpResponseExecute.getContentLength());
                    }
                } catch (IOException e) {
                    if (!this.retryOnExecuteIOException && ((httpIOExceptionHandler = this.ioExceptionHandler) == null || !httpIOExceptionHandler.handleIOException(this, z4))) {
                        span2.end(OpenCensusUtils.getEndSpanOptions(num));
                        throw e;
                    }
                    if (z2) {
                        logger.log(Level.WARNING, "exception thrown while executing request", (Throwable) e);
                    }
                    scopeWithSpan.close();
                    r4 = num;
                    r0 = e;
                }
            } catch (Throwable th4) {
                scopeWithSpan.close();
                throw th4;
            }
            sb2 = null;
            userAgent = this.headers.getUserAgent();
            if (!this.suppressUserAgentSuffix) {
                if (userAgent == null) {
                    HttpHeaders httpHeaders2 = this.headers;
                    String str5 = USER_AGENT_SUFFIX;
                    httpHeaders2.setUserAgent(str5);
                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str5);
                } else {
                    String str6 = userAgent + " " + USER_AGENT_SUFFIX;
                    this.headers.setUserAgent(str6);
                    addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str6);
                }
            }
            OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
            HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, BuildRequest);
            if (!this.suppressUserAgentSuffix) {
                this.headers.setUserAgent(userAgent);
            }
            httpContent = this.content;
            if (httpContent != null) {
                z = true;
            } else {
                z = true;
            }
            if (httpContent != null) {
                type = this.content.getType();
                if (z7) {
                    num = null;
                    j = -1;
                    loggingStreamingContent = new LoggingStreamingContent(httpContent, HttpTransport.LOGGER, Level.CONFIG, this.contentLoggingLimit);
                } else {
                    num = null;
                    j = -1;
                    loggingStreamingContent = httpContent;
                }
                httpEncoding = this.encoding;
                if (httpEncoding == null) {
                    length = this.content.getLength();
                    r6 = num;
                } else {
                    name = httpEncoding.getName();
                    httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                    length = j;
                }
                if (z7) {
                    r6 = name;
                    if (type != null) {
                        z2 = z7;
                        z3 = z;
                        str2 = "Content-Type: " + type;
                        span = spanStartSpan;
                        sb.append(str2).append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            httpEncodingStreamingContent = loggingStreamingContent;
                            sb2.append(" -H '" + str2 + "'");
                        }
                    } else {
                        httpEncodingStreamingContent = loggingStreamingContent;
                        span = spanStartSpan;
                        z2 = z7;
                        z3 = z;
                    }
                    if (r6 != 0) {
                        str = "Content-Encoding: " + r6;
                        sb.append(str).append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            sb2.append(" -H '" + str + "'");
                        }
                    }
                    if (length >= 0) {
                        sb.append("Content-Length: " + length).append(StringUtils.LINE_SEPARATOR);
                    }
                } else {
                    r6 = name;
                    span = spanStartSpan;
                    z2 = z7;
                    z3 = z;
                }
                if (sb2 != null) {
                    httpEncodingStreamingContent = loggingStreamingContent;
                    sb2.append(" -d '@-'");
                }
                httpEncodingStreamingContent = loggingStreamingContent;
                BuildRequest.setContentType(type);
                BuildRequest.setContentEncoding(r6);
                BuildRequest.setContentLength(length);
                BuildRequest.setStreamingContent(httpEncodingStreamingContent);
                streamingContent = httpEncodingStreamingContent;
            } else {
                span = spanStartSpan;
                i2 = i2;
                z2 = z7;
                z3 = z;
                num = null;
                j = -1;
            }
            if (z2) {
                streamingContent = httpContent;
                logger.config(sb.toString());
                if (sb2 != null) {
                    sb2.append(" -- '");
                    sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                    sb2.append("'");
                    if (streamingContent != null) {
                        sb2.append(" << $$$");
                    }
                    logger.config(sb2.toString());
                }
            }
            if (z3) {
                z4 = false;
            } else {
                z4 = false;
            }
            BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
            BuildRequest.setWriteTimeout(this.writeTimeout);
            span2 = span;
            scopeWithSpan = this.tracer.withSpan(span2);
            OpenCensusUtils.recordSentMessageEvent(span2, BuildRequest.getContentLength());
        }
    }

    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().setDaemon(true).build()));
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location), this.useRawRedirectUrls));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    private static void addSpanAttribute(Span span, String str, String str2) {
        if (str2 != null) {
            span.putAttribute(str, AttributeValue.stringAttributeValue(str2));
        }
    }

    private static String getVersion() {
        String property = Constants.VERSION_UNKNOWN;
        try {
            InputStream resourceAsStream = HttpRequest.class.getResourceAsStream("/google-http-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-http-client.version");
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }
}
