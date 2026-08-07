package com.splunk.rum;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class Carrier {
    private final int id;
    private final String isoCountryCode;
    private final String mobileCountryCode;
    private final String mobileNetworkCode;
    private final String name;

    static Builder builder() {
        return new Builder();
    }

    Carrier(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.mobileCountryCode = builder.mobileCountryCode;
        this.mobileNetworkCode = builder.mobileNetworkCode;
        this.isoCountryCode = builder.isoCountryCode;
    }

    int getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    String getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    String getMobileNetworkCode() {
        return this.mobileNetworkCode;
    }

    String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Carrier carrier = (Carrier) obj;
            if (this.id == carrier.id && Objects.equals(this.name, carrier.name) && Objects.equals(this.mobileCountryCode, carrier.mobileCountryCode) && Objects.equals(this.mobileNetworkCode, carrier.mobileNetworkCode) && Objects.equals(this.isoCountryCode, carrier.isoCountryCode)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), this.name, this.mobileCountryCode, this.mobileNetworkCode, this.isoCountryCode);
    }

    public String toString() {
        return "Carrier{id=" + this.id + ", name='" + this.name + "', mobileCountryCode='" + this.mobileCountryCode + "', mobileNetworkCode='" + this.mobileNetworkCode + "', isoCountryCode='" + this.isoCountryCode + "'}";
    }

    static class Builder {
        private int id = -1;
        private String name = null;
        private String mobileCountryCode = null;
        private String mobileNetworkCode = null;
        private String isoCountryCode = null;

        Builder() {
        }

        Carrier build() {
            return new Carrier(this);
        }

        Builder id(int i) {
            this.id = i;
            return this;
        }

        Builder name(String str) {
            this.name = str;
            return this;
        }

        Builder mobileCountryCode(String str) {
            this.mobileCountryCode = str;
            return this;
        }

        Builder mobileNetworkCode(String str) {
            this.mobileNetworkCode = str;
            return this;
        }

        Builder isoCountryCode(String str) {
            this.isoCountryCode = str;
            return this;
        }
    }
}
