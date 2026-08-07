package org.jose4j.http;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.jose4j.lang.UncheckedJoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Get implements SimpleGet {
    private static final long MAX_RETRY_WAIT = 8000;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Get.class);
    private HostnameVerifier hostnameVerifier;
    private Proxy proxy;
    private SSLSocketFactory sslSocketFactory;
    private int connectTimeout = 20000;
    private int readTimeout = 20000;
    private int retries = 3;
    private long initialRetryWaitTime = 180;
    private boolean progressiveRetryWait = true;
    private int responseBodySizeLimit = 524288;

    @Override // org.jose4j.http.SimpleGet
    public SimpleResponse get(String str) throws IOException {
        log.debug("HTTP GET of {}", str);
        URL url = new URL(str);
        int i = 0;
        while (true) {
            try {
                Proxy proxy = this.proxy;
                URLConnection uRLConnectionOpenConnection = proxy == null ? url.openConnection() : url.openConnection(proxy);
                uRLConnectionOpenConnection.setConnectTimeout(this.connectTimeout);
                uRLConnectionOpenConnection.setReadTimeout(this.readTimeout);
                setUpTls(uRLConnectionOpenConnection);
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                if (responseCode != 200) {
                    throw new IOException("Non 200 status code (" + responseCode + " " + responseMessage + ") returned from " + url);
                }
                Response response = new Response(responseCode, responseMessage, httpURLConnection.getHeaderFields(), getBody(uRLConnectionOpenConnection, getCharset(uRLConnectionOpenConnection)));
                log.debug("HTTP GET of {} returned {}", url, response);
                return response;
            } catch (FileNotFoundException | SSLHandshakeException | SSLPeerUnverifiedException | ResponseBodyTooLargeException e) {
                throw e;
            } catch (IOException e2) {
                i++;
                if (i > this.retries) {
                    throw e2;
                }
                long retryWaitTime = getRetryWaitTime(i);
                log.debug("Waiting {}ms before retrying ({} of {}) HTTP GET of {} after failed attempt: {}", Long.valueOf(retryWaitTime), Integer.valueOf(i), Integer.valueOf(this.retries), url, e2);
                try {
                    Thread.sleep(retryWaitTime);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private String getBody(URLConnection uRLConnection, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            try {
                char[] cArr = new char[1024];
                int i = 0;
                while (true) {
                    int i2 = inputStreamReader.read(cArr);
                    if (-1 != i2) {
                        stringWriter.write(cArr, 0, i2);
                        i += i2;
                        int i3 = this.responseBodySizeLimit;
                        if (i3 > 0 && i > i3) {
                            throw new ResponseBodyTooLargeException("More than " + this.responseBodySizeLimit + " characters have been read from the response body.");
                        }
                    } else {
                        log.debug("read {} characters", Integer.valueOf(i));
                        inputStreamReader.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return stringWriter.toString();
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    private void setUpTls(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            HostnameVerifier hostnameVerifier = this.hostnameVerifier;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
        }
    }

    private String getCharset(URLConnection uRLConnection) {
        String strSubstring;
        String headerField = uRLConnection.getHeaderField("Content-Type");
        if (headerField != null) {
            try {
                for (String str : headerField.replace(" ", "").split(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER)) {
                    if (str.startsWith("charset=")) {
                        strSubstring = str.substring("charset=".length());
                        Charset.forName(strSubstring);
                        return strSubstring;
                    }
                }
                strSubstring = "UTF-8";
                Charset.forName(strSubstring);
                return strSubstring;
            } catch (Exception e) {
                log.debug("Unexpected problem attempted to determine the charset from the Content-Type ({}) so will default to using UTF8: {}", headerField, e);
            }
        }
        return "UTF-8";
    }

    private long getRetryWaitTime(int i) {
        if (this.progressiveRetryWait) {
            return Math.min((long) (Math.pow(2.0d, i - 1) * this.initialRetryWaitTime), MAX_RETRY_WAIT);
        }
        return this.initialRetryWaitTime;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setTrustedCertificates(X509Certificate... x509CertificateArr) {
        setTrustedCertificates(Arrays.asList(x509CertificateArr));
    }

    public void setRetries(int i) {
        this.retries = i;
    }

    public void setProgressiveRetryWait(boolean z) {
        this.progressiveRetryWait = z;
    }

    public void setInitialRetryWaitTime(long j) {
        this.initialRetryWaitTime = j;
    }

    public void setResponseBodySizeLimit(int i) {
        this.responseBodySizeLimit = i;
    }

    public void setTrustedCertificates(Collection<X509Certificate> collection) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX");
            KeyStore keyStore = KeyStore.getInstance("jks");
            keyStore.load(null, null);
            Iterator<X509Certificate> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                keyStore.setCertificateEntry("alias" + i, it.next());
                i++;
            }
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagers, null);
            this.sslSocketFactory = sSLContext.getSocketFactory();
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new UncheckedJoseException("Unable to initialize socket factory with custom trusted  certificates.", e);
        }
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setHttpProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    private static class ResponseBodyTooLargeException extends IOException {
        public ResponseBodyTooLargeException(String str) {
            super(str);
        }
    }
}
