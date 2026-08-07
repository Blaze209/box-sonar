package com.nimbusds.jose;

import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class PlainObject extends JOSEObject {
    private static final long serialVersionUID = 1;
    private final PlainHeader header;

    public PlainObject(Payload payload) {
        setPayload((Payload) Objects.requireNonNull(payload));
        this.header = new PlainHeader();
    }

    public PlainObject(PlainHeader plainHeader, Payload payload) {
        this.header = (PlainHeader) Objects.requireNonNull(plainHeader);
        setPayload((Payload) Objects.requireNonNull(payload));
    }

    public PlainObject(Base64URL base64URL, Base64URL base64URL2) throws ParseException {
        try {
            this.header = PlainHeader.parse((Base64URL) Objects.requireNonNull(base64URL));
            setPayload(new Payload((Base64URL) Objects.requireNonNull(base64URL2)));
            setParsedParts(base64URL, base64URL2, null);
        } catch (ParseException e) {
            throw new ParseException("Invalid unsecured header: " + e.getMessage(), 0);
        }
    }

    @Override // com.nimbusds.jose.JOSEObject
    public PlainHeader getHeader() {
        return this.header;
    }

    @Override // com.nimbusds.jose.JOSEObject
    public String serialize() {
        return this.header.toBase64URL().toString() + '.' + getPayload().toBase64URL().toString() + '.';
    }

    public static PlainObject parse(String str) throws ParseException {
        Base64URL[] base64URLArrSplit = JOSEObject.split(str);
        if (!base64URLArrSplit[2].toString().isEmpty()) {
            throw new ParseException("Unexpected third Base64URL part", 0);
        }
        return new PlainObject(base64URLArrSplit[0], base64URLArrSplit[1]);
    }
}
