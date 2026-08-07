package com.google.android.datatransport.cct.internal;

/* JADX INFO: loaded from: classes13.dex */
final class AutoValue_ExternalPRequestContext extends ExternalPRequestContext {
    private final Integer originAssociatedProductId;

    private AutoValue_ExternalPRequestContext(Integer num) {
        this.originAssociatedProductId = num;
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext
    public Integer getOriginAssociatedProductId() {
        return this.originAssociatedProductId;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.originAssociatedProductId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPRequestContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = (ExternalPRequestContext) obj;
        Integer num = this.originAssociatedProductId;
        if (num == null) {
            return externalPRequestContext.getOriginAssociatedProductId() == null;
        }
        return num.equals(externalPRequestContext.getOriginAssociatedProductId());
    }

    public int hashCode() {
        Integer num = this.originAssociatedProductId;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    static final class Builder extends ExternalPRequestContext.Builder {
        private Integer originAssociatedProductId;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public ExternalPRequestContext.Builder setOriginAssociatedProductId(Integer num) {
            this.originAssociatedProductId = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public ExternalPRequestContext build() {
            return new AutoValue_ExternalPRequestContext(this.originAssociatedProductId);
        }
    }
}
