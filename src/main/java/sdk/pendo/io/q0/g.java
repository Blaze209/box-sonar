package sdk.pendo.io.q0;

import java.security.Key;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private final Signature a;
    private final Cipher b;
    private final Mac c;
    private final Key d;
    private final KeyAgreement e;

    public g(Key key) {
        this(null, null, null, key, null);
    }

    public Cipher a() {
        return this.b;
    }

    public Key b() {
        return this.d;
    }

    public KeyAgreement c() {
        return this.e;
    }

    public Signature d() {
        return this.a;
    }

    public g(Signature signature) {
        this(signature, null, null, null, null);
    }

    private g(Signature signature, Cipher cipher, Mac mac, Key key, KeyAgreement keyAgreement) {
        this.a = signature;
        this.b = cipher;
        this.c = mac;
        this.d = key;
        this.e = keyAgreement;
    }

    public g(Cipher cipher) {
        this(null, cipher, null, null, null);
    }

    public g(KeyAgreement keyAgreement) {
        this(null, null, null, null, keyAgreement);
    }
}
