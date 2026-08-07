package com.amplitude.api;

import android.content.Context;
import com.amplitude.util.DoubleCheck;
import com.amplitude.util.Provider;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes9.dex */
public class PinnedAmplitudeClient extends AmplitudeClient {
    private static final String CERTIFICATE_EU = "MIIDQTCCAimgAwIBAgITBmyfz5m/jAo54vB4ikPmljZbyjANBgkqhkiG9w0BAQsF\nADA5MQswCQYDVQQGEwJVUzEPMA0GA1UEChMGQW1hem9uMRkwFwYDVQQDExBBbWF6\nb24gUm9vdCBDQSAxMB4XDTE1MDUyNjAwMDAwMFoXDTM4MDExNzAwMDAwMFowOTEL\nMAkGA1UEBhMCVVMxDzANBgNVBAoTBkFtYXpvbjEZMBcGA1UEAxMQQW1hem9uIFJv\nb3QgQ0EgMTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALJ4gHHKeNXj\nca9HgFB0fW7Y14h29Jlo91ghYPl0hAEvrAIthtOgQ3pOsqTQNroBvo3bSMgHFzZM\n9O6II8c+6zf1tRn4SWiw3te5djgdYZ6k/oI2peVKVuRF4fn9tBb6dNqcmzU5L/qw\nIFAGbHrQgLKm+a/sRxmPUDgH3KKHOVj4utWp+UhnMJbulHheb4mjUcAwhmahRWa6\nVOujw5H5SNz/0egwLX0tdHA114gk957EWW67c4cX8jJGKLhD+rcdqsq08p8kDi1L\n93FcXmn/6pUCyziKrlA4b9v7LWIbxcceVOF34GfID5yHI9Y/QCB/IIDEgEw+OyQm\njgSubJrIqg0CAwEAAaNCMEAwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMC\nAYYwHQYDVR0OBBYEFIQYzIU07LwMlJQuCFmcx7IQTgoIMA0GCSqGSIb3DQEBCwUA\nA4IBAQCY8jdaQZChGsV2USggNiMOruYou6r4lK5IpDB/G/wkjUu0yKGX9rbxenDI\nU5PMCCjjmCXPI6T53iHTfIUJrU6adTrCC2qJeHZERxhlbI1Bjjt/msv0tadQ1wUs\nN+gDS63pYaACbvXy8MWy7Vu33PqUXHeeE6V/Uq2V8viTO96LXFvKWlJbYK8U90vv\no/ufQJVtMVT8QtPHRh8jrdkPSHCa2XV4cdFyQzR1bldZwgJcJmApzyMZFo6IQ6XU\n5MsI+yMRQ+hDKXJioaldXgjUkK642M4UwtBV8ob2xJNDd2ZhwLnoQdeXeGADbkpy\nrqXRfboQnoZsG4q5WTP468SQvvG5";
    private static final String CERTIFICATE_US = "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";
    private static final String TAG = "com.amplitude.api.PinnedAmplitudeClient";
    protected boolean initializedSSLSocketFactory;
    protected SSLSocketFactory sslSocketFactory;
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    static Map<String, PinnedAmplitudeClient> instances = new HashMap();

    protected static String getCertificate(AmplitudeServerZone amplitudeServerZone) {
        return amplitudeServerZone == AmplitudeServerZone.EU ? CERTIFICATE_EU : CERTIFICATE_US;
    }

    protected static SSLContextBuilder getPinnedCertificateChain(AmplitudeServerZone amplitudeServerZone) {
        return new SSLContextBuilder(amplitudeServerZone).addCertificate(getCertificate(amplitudeServerZone));
    }

    protected static class SSLContextBuilder {
        private final List<String> certificateBase64s;
        protected AmplitudeServerZone serverZone;

        public SSLContextBuilder() {
            this.certificateBase64s = new ArrayList();
            this.serverZone = AmplitudeServerZone.US;
        }

        public SSLContextBuilder(AmplitudeServerZone amplitudeServerZone) {
            this.certificateBase64s = new ArrayList();
            this.serverZone = amplitudeServerZone;
        }

        public SSLContextBuilder addCertificate(String str) {
            this.certificateBase64s.add(str);
            return this;
        }

        public SSLContext build() {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                Iterator<String> it = this.certificateBase64s.iterator();
                int i = 1;
                while (it.hasNext()) {
                    keyStore.setCertificateEntry(Integer.toString(i), (X509Certificate) certificateFactory.generateCertificate(new Buffer().write(ByteString.decodeBase64(it.next())).inputStream()));
                    i++;
                }
                trustManagerFactory.init(keyStore);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
                return sSLContext;
            } catch (IOException e) {
                PinnedAmplitudeClient.logger.e(PinnedAmplitudeClient.TAG, e.getMessage(), e);
                return null;
            } catch (GeneralSecurityException e2) {
                PinnedAmplitudeClient.logger.e(PinnedAmplitudeClient.TAG, e2.getMessage(), e2);
                return null;
            }
        }
    }

    public static PinnedAmplitudeClient getInstance() {
        return getInstance(null);
    }

    public static synchronized PinnedAmplitudeClient getInstance(String str) {
        PinnedAmplitudeClient pinnedAmplitudeClient;
        String strNormalizeInstanceName = Utils.normalizeInstanceName(str);
        pinnedAmplitudeClient = instances.get(strNormalizeInstanceName);
        if (pinnedAmplitudeClient == null) {
            pinnedAmplitudeClient = new PinnedAmplitudeClient(strNormalizeInstanceName);
            instances.put(strNormalizeInstanceName, pinnedAmplitudeClient);
        }
        return pinnedAmplitudeClient;
    }

    public PinnedAmplitudeClient(String str) {
        super(str);
        this.initializedSSLSocketFactory = false;
    }

    public synchronized AmplitudeClient initializeInternal(Context context, String str, String str2, Provider<OkHttpClient> provider) {
        super.initialize(context, str, str2);
        runOnLogThread(new AnonymousClass1(this, provider));
        return this;
    }

    /* JADX INFO: renamed from: com.amplitude.api.PinnedAmplitudeClient$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ PinnedAmplitudeClient val$client;
        final /* synthetic */ Provider val$clientProvider;

        AnonymousClass1(PinnedAmplitudeClient pinnedAmplitudeClient, Provider provider) {
            this.val$client = pinnedAmplitudeClient;
            this.val$clientProvider = provider;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$client.initializedSSLSocketFactory) {
                return;
            }
            final SSLSocketFactory pinnedCertSslSocketFactory = PinnedAmplitudeClient.this.getPinnedCertSslSocketFactory(this.val$client.getServerZone());
            if (pinnedCertSslSocketFactory == null) {
                PinnedAmplitudeClient.logger.e(PinnedAmplitudeClient.TAG, "Unable to pin SSL as requested. Will send data without SSL pinning.");
            } else {
                try {
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null, null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(PinnedAmplitudeClient.getCertificate(this.val$client.getServerZone()));
                    Iterator it = arrayList.iterator();
                    int i = 1;
                    while (it.hasNext()) {
                        keyStore.setCertificateEntry(Integer.toString(i), (X509Certificate) certificateFactory.generateCertificate(new Buffer().write(ByteString.decodeBase64((String) it.next())).inputStream()));
                        i++;
                    }
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    if (trustManagers.length == 1) {
                        TrustManager trustManager = trustManagers[0];
                        if (trustManager instanceof X509TrustManager) {
                            final X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                            final Provider provider = this.val$clientProvider;
                            final Provider provider2 = DoubleCheck.provider(new Provider() { // from class: com.amplitude.api.PinnedAmplitudeClient$1$$ExternalSyntheticLambda0
                                @Override // com.amplitude.util.Provider
                                public final Object get() {
                                    return PinnedAmplitudeClient.AnonymousClass1.lambda$run$0(provider, pinnedCertSslSocketFactory, x509TrustManager);
                                }
                            });
                            this.val$client.callFactory = new Call.Factory() { // from class: com.amplitude.api.PinnedAmplitudeClient$1$$ExternalSyntheticLambda1
                                @Override // okhttp3.Call.Factory
                                public final Call newCall(Request request) {
                                    return ((OkHttpClient) provider2.get()).newCall(request);
                                }
                            };
                        }
                    }
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                } catch (IOException e) {
                    PinnedAmplitudeClient.logger.e(PinnedAmplitudeClient.TAG, e.getMessage(), e);
                } catch (GeneralSecurityException e2) {
                    PinnedAmplitudeClient.logger.e(PinnedAmplitudeClient.TAG, e2.getMessage(), e2);
                }
            }
            this.val$client.initializedSSLSocketFactory = true;
        }

        static /* synthetic */ OkHttpClient lambda$run$0(Provider provider, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            OkHttpClient.Builder builder;
            if (provider != null) {
                builder = ((OkHttpClient) provider.get()).newBuilder();
            } else {
                builder = new OkHttpClient.Builder();
            }
            return builder.sslSocketFactory(sSLSocketFactory, x509TrustManager).build();
        }
    }

    @Override // com.amplitude.api.AmplitudeClient
    public synchronized AmplitudeClient initialize(Context context, String str, String str2) {
        return initializeInternal(context, str, str2, null);
    }

    public synchronized AmplitudeClient initialize(Context context, String str, String str2, Provider<OkHttpClient> provider) {
        return initializeInternal(context, str, str2, provider);
    }

    protected SSLSocketFactory getPinnedCertSslSocketFactory(AmplitudeServerZone amplitudeServerZone) {
        return getPinnedCertSslSocketFactory(getPinnedCertificateChain(amplitudeServerZone));
    }

    protected SSLSocketFactory getPinnedCertSslSocketFactory(SSLContextBuilder sSLContextBuilder) {
        if (sSLContextBuilder == null) {
            return null;
        }
        if (this.sslSocketFactory == null) {
            try {
                this.sslSocketFactory = sSLContextBuilder.build().getSocketFactory();
                if (sSLContextBuilder.serverZone == AmplitudeServerZone.EU) {
                    logger.i(TAG, "Pinning SSL session using AWS Root CA Cert");
                } else {
                    logger.i(TAG, "Pinning SSL session using Comodo CA Cert");
                }
            } catch (Exception e) {
                logger.e(TAG, e.getMessage(), e);
            }
        }
        return this.sslSocketFactory;
    }

    @Override // com.amplitude.api.AmplitudeClient
    public AmplitudeClient setServerZone(AmplitudeServerZone amplitudeServerZone) {
        super.setServerZone(amplitudeServerZone);
        this.initializedSSLSocketFactory = false;
        this.sslSocketFactory = null;
        initialize(this.context, this.apiKey, this.userId);
        return this;
    }
}
