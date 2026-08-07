package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public interface ExceptionListener {
    public static final ExceptionListener NO_OP = new ExceptionListener() { // from class: org.apache.hc.core5.http.ExceptionListener.1
        @Override // org.apache.hc.core5.http.ExceptionListener
        public void onError(Exception exc) {
        }

        @Override // org.apache.hc.core5.http.ExceptionListener
        public void onError(HttpConnection httpConnection, Exception exc) {
        }
    };
    public static final ExceptionListener STD_ERR = new ExceptionListener() { // from class: org.apache.hc.core5.http.ExceptionListener.2
        @Override // org.apache.hc.core5.http.ExceptionListener
        public void onError(Exception exc) {
            exc.printStackTrace();
        }

        @Override // org.apache.hc.core5.http.ExceptionListener
        public void onError(HttpConnection httpConnection, Exception exc) {
            exc.printStackTrace();
        }
    };

    void onError(Exception exc);

    void onError(HttpConnection httpConnection, Exception exc);
}
