package io.opencensus.trace;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_EndSpanOptions extends EndSpanOptions {
    private final boolean sampleToLocalSpanStore;
    private final Status status;

    private AutoValue_EndSpanOptions(boolean z, @Nullable Status status) {
        this.sampleToLocalSpanStore = z;
        this.status = status;
    }

    @Override // io.opencensus.trace.EndSpanOptions
    public boolean getSampleToLocalSpanStore() {
        return this.sampleToLocalSpanStore;
    }

    @Override // io.opencensus.trace.EndSpanOptions
    @Nullable
    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "EndSpanOptions{sampleToLocalSpanStore=" + this.sampleToLocalSpanStore + ", status=" + this.status + "}";
    }

    public boolean equals(Object obj) {
        Status status;
        if (obj == this) {
            return true;
        }
        if (obj instanceof EndSpanOptions) {
            EndSpanOptions endSpanOptions = (EndSpanOptions) obj;
            if (this.sampleToLocalSpanStore == endSpanOptions.getSampleToLocalSpanStore() && ((status = this.status) != null ? status.equals(endSpanOptions.getStatus()) : endSpanOptions.getStatus() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.sampleToLocalSpanStore ? 1231 : 1237) ^ 1000003) * 1000003;
        Status status = this.status;
        return (status == null ? 0 : status.hashCode()) ^ i;
    }

    static final class Builder extends EndSpanOptions.Builder {
        private Boolean sampleToLocalSpanStore;
        private Status status;

        Builder() {
        }

        @Override // io.opencensus.trace.EndSpanOptions.Builder
        public EndSpanOptions.Builder setSampleToLocalSpanStore(boolean z) {
            this.sampleToLocalSpanStore = Boolean.valueOf(z);
            return this;
        }

        @Override // io.opencensus.trace.EndSpanOptions.Builder
        public EndSpanOptions.Builder setStatus(@Nullable Status status) {
            this.status = status;
            return this;
        }

        @Override // io.opencensus.trace.EndSpanOptions.Builder
        public EndSpanOptions build() {
            String str;
            if (this.sampleToLocalSpanStore != null) {
                str = "";
            } else {
                str = " sampleToLocalSpanStore";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_EndSpanOptions(this.sampleToLocalSpanStore.booleanValue(), this.status);
        }
    }
}
