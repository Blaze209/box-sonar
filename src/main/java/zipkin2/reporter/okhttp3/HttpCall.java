package zipkin2.reporter.okhttp3;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import zipkin2.Call;
import zipkin2.Callback;

/* JADX INFO: loaded from: classes6.dex */
final class HttpCall extends Call<Void> {
    final okhttp3.Call call;

    HttpCall(okhttp3.Call call) {
        this.call = call;
    }

    @Override // zipkin2.Call
    public Void execute() throws IOException {
        parseResponse(this.call.execute());
        return null;
    }

    @Override // zipkin2.Call
    public void enqueue(Callback<Void> callback) {
        this.call.enqueue(new V2CallbackAdapter(callback));
    }

    @Override // zipkin2.Call
    public void cancel() {
        this.call.cancel();
    }

    @Override // zipkin2.Call
    public boolean isCanceled() {
        return this.call.getCanceled();
    }

    @Override // zipkin2.Call
    public HttpCall clone() {
        return new HttpCall(this.call.clone());
    }

    static class V2CallbackAdapter<V> implements okhttp3.Callback {
        final Callback<V> delegate;

        V2CallbackAdapter(Callback<V> callback) {
            this.delegate = callback;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, IOException iOException) {
            this.delegate.onError(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, Response response) {
            try {
                HttpCall.parseResponse(response);
                this.delegate.onSuccess(null);
            } catch (Throwable th) {
                Call.propagateIfFatal(th);
                this.delegate.onError(th);
            }
        }
    }

    static void parseResponse(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("response failed: " + response);
            }
            return;
        }
        try {
            BufferedSource source = responseBodyBody.getSource();
            if ("gzip".equalsIgnoreCase(response.header("Content-Encoding"))) {
                source = Okio.buffer(new GzipSource(responseBodyBody.getSource()));
            }
            if (!response.isSuccessful()) {
                throw new RuntimeException("response for " + response.request().tag() + " failed: " + source.readUtf8());
            }
            responseBodyBody.close();
        } catch (Throwable th) {
            responseBodyBody.close();
            throw th;
        }
    }
}
