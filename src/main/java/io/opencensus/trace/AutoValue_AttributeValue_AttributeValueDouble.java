package io.opencensus.trace;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_AttributeValue_AttributeValueDouble extends AttributeValue.AttributeValueDouble {
    private final Double doubleValue;

    AutoValue_AttributeValue_AttributeValueDouble(Double d) {
        if (d == null) {
            throw new NullPointerException("Null doubleValue");
        }
        this.doubleValue = d;
    }

    @Override // io.opencensus.trace.AttributeValue.AttributeValueDouble
    Double getDoubleValue() {
        return this.doubleValue;
    }

    public String toString() {
        return "AttributeValueDouble{doubleValue=" + this.doubleValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueDouble) {
            return this.doubleValue.equals(((AttributeValue.AttributeValueDouble) obj).getDoubleValue());
        }
        return false;
    }

    public int hashCode() {
        return this.doubleValue.hashCode() ^ 1000003;
    }
}
