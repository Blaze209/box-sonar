package com.splunk.rum;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class CurrentNetwork {
    private final Carrier carrier;
    private final NetworkState state;
    private final String subType;

    private CurrentNetwork(Builder builder) {
        this.carrier = builder.carrier;
        this.state = builder.state;
        this.subType = builder.subType;
    }

    boolean isOnline() {
        return getState() != NetworkState.NO_NETWORK_AVAILABLE;
    }

    NetworkState getState() {
        return this.state;
    }

    String getSubType() {
        return this.subType;
    }

    public String toString() {
        return "CurrentNetwork{carrier=" + this.carrier + ", state=" + this.state + ", subType='" + this.subType + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CurrentNetwork currentNetwork = (CurrentNetwork) obj;
            if (Objects.equals(this.carrier, currentNetwork.carrier) && this.state == currentNetwork.state && Objects.equals(this.subType, currentNetwork.subType)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.carrier, this.state, this.subType);
    }

    public String getCarrierCountryCode() {
        if (haveCarrier()) {
            return this.carrier.getMobileCountryCode();
        }
        return null;
    }

    public String getCarrierIsoCountryCode() {
        if (haveCarrier()) {
            return this.carrier.getIsoCountryCode();
        }
        return null;
    }

    public String getCarrierNetworkCode() {
        if (haveCarrier()) {
            return this.carrier.getMobileNetworkCode();
        }
        return null;
    }

    public String getCarrierName() {
        if (haveCarrier()) {
            return this.carrier.getName();
        }
        return null;
    }

    private boolean haveCarrier() {
        return this.carrier != null;
    }

    static Builder builder(NetworkState networkState) {
        return new Builder(networkState);
    }

    static class Builder {
        private Carrier carrier;
        private final NetworkState state;
        private String subType;

        public Builder(NetworkState networkState) {
            this.state = networkState;
        }

        CurrentNetwork build() {
            return new CurrentNetwork(this);
        }

        public Builder carrier(Carrier carrier) {
            this.carrier = carrier;
            return this;
        }

        public Builder subType(String str) {
            this.subType = str;
            return this;
        }
    }
}
