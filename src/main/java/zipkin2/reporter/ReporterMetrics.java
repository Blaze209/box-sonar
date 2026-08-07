package zipkin2.reporter;

/* JADX INFO: loaded from: classes6.dex */
public interface ReporterMetrics {
    public static final ReporterMetrics NOOP_METRICS = new ReporterMetrics() { // from class: zipkin2.reporter.ReporterMetrics.1
        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementMessageBytes(int i) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementMessages() {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementMessagesDropped(Throwable th) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementSpanBytes(int i) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementSpans(int i) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void incrementSpansDropped(int i) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void updateQueuedBytes(int i) {
        }

        @Override // zipkin2.reporter.ReporterMetrics
        public void updateQueuedSpans(int i) {
        }

        public String toString() {
            return "NoOpReporterMetrics";
        }
    };

    void incrementMessageBytes(int i);

    void incrementMessages();

    void incrementMessagesDropped(Throwable th);

    void incrementSpanBytes(int i);

    void incrementSpans(int i);

    void incrementSpansDropped(int i);

    void updateQueuedBytes(int i);

    void updateQueuedSpans(int i);
}
