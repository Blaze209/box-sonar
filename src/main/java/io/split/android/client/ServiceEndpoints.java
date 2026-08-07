package io.split.android.client;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class ServiceEndpoints {
    private static final String AUTH_SERVICE_ENDPOINT = "https://auth.split.io/api/v2";
    private static final String EVENTS_ENDPOINT = "https://events.split.io/api";
    private static final String SDK_ENDPOINT = "https://sdk.split.io/api";
    private static final String STREAMING_SERVICE_ENDPOINT = "https://streaming.split.io/sse";
    private static final String TELEMETRY_SERVICE_ENDPOINT = "https://telemetry.split.io/api/v1";
    private String mAuthServiceEndpoint;
    private String mEventsEndpoint;
    private String mSdkEndpoint;
    private String mStreamingServiceEndpoint;
    private String mTelemetryServiceEndpoint;

    private ServiceEndpoints() {
        this.mSdkEndpoint = SDK_ENDPOINT;
        this.mEventsEndpoint = EVENTS_ENDPOINT;
        this.mAuthServiceEndpoint = AUTH_SERVICE_ENDPOINT;
        this.mStreamingServiceEndpoint = STREAMING_SERVICE_ENDPOINT;
        this.mTelemetryServiceEndpoint = TELEMETRY_SERVICE_ENDPOINT;
    }

    public String getSdkEndpoint() {
        return this.mSdkEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkEndpoint(String endpoint) {
        this.mSdkEndpoint = endpoint;
    }

    public String getEventsEndpoint() {
        return this.mEventsEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventsEndpoint(String endpoint) {
        this.mEventsEndpoint = endpoint;
    }

    public String getAuthServiceEndpoint() {
        return this.mAuthServiceEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthServiceEndpoint(String endpoint) {
        this.mAuthServiceEndpoint = endpoint;
    }

    public String getStreamingServiceEndpoint() {
        return this.mStreamingServiceEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamingServiceEndpoint(String endpoint) {
        this.mStreamingServiceEndpoint = endpoint;
    }

    public void setTelemetryServiceEndpoint(String endpoint) {
        this.mTelemetryServiceEndpoint = endpoint;
    }

    public String getTelemetryEndpoint() {
        return this.mTelemetryServiceEndpoint;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        ServiceEndpoints mServiceEndpoints = new ServiceEndpoints();

        protected Builder() {
        }

        public Builder apiEndpoint(String url) {
            this.mServiceEndpoints.setSdkEndpoint((String) Utils.checkNotNull(url));
            return this;
        }

        public Builder eventsEndpoint(String url) {
            this.mServiceEndpoints.setEventsEndpoint((String) Utils.checkNotNull(url));
            return this;
        }

        public Builder sseAuthServiceEndpoint(String url) {
            this.mServiceEndpoints.setAuthServiceEndpoint((String) Utils.checkNotNull(url));
            return this;
        }

        public Builder streamingServiceEndpoint(String url) {
            this.mServiceEndpoints.setStreamingServiceEndpoint((String) Utils.checkNotNull(url));
            return this;
        }

        public Builder telemetryServiceEndpoint(String url) {
            this.mServiceEndpoints.setTelemetryServiceEndpoint((String) Utils.checkNotNull(url));
            return this;
        }

        public ServiceEndpoints build() {
            return this.mServiceEndpoints;
        }
    }

    public static class EndpointValidator {
        public static boolean sdkEndpointIsOverridden(String endpoint) {
            return !ServiceEndpoints.SDK_ENDPOINT.equals(endpoint);
        }

        public static boolean eventsEndpointIsOverridden(String endpoint) {
            return !ServiceEndpoints.EVENTS_ENDPOINT.equals(endpoint);
        }

        public static boolean streamingEndpointIsOverridden(String endpoint) {
            return !ServiceEndpoints.STREAMING_SERVICE_ENDPOINT.equals(endpoint);
        }

        public static boolean authEndpointIsOverridden(String endpoint) {
            return !ServiceEndpoints.AUTH_SERVICE_ENDPOINT.equals(endpoint);
        }

        public static boolean telemetryEndpointIsOverridden(String endpoint) {
            return !ServiceEndpoints.TELEMETRY_SERVICE_ENDPOINT.equals(endpoint);
        }
    }
}
