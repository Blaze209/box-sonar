package io.split.android.client.network;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class CertificatePin {

    @SerializedName("algo")
    private final String mAlgorithm;

    @SerializedName("pin")
    private final byte[] mPin;

    CertificatePin(byte[] pin, String algorithm) {
        this.mPin = pin;
        this.mAlgorithm = algorithm;
    }

    public byte[] getPin() {
        return this.mPin;
    }

    public String getAlgorithm() {
        return this.mAlgorithm;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            CertificatePin certificatePin = (CertificatePin) o;
            if (Arrays.equals(this.mPin, certificatePin.mPin) && Objects.equals(this.mAlgorithm, certificatePin.mAlgorithm)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hash(this.mAlgorithm) * 31) + Arrays.hashCode(this.mPin);
    }
}
