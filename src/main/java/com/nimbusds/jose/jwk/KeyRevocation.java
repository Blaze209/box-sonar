package com.nimbusds.jose.jwk;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jwt.util.DateUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class KeyRevocation implements Serializable {
    private final Reason reason;
    private final Date revokedAt;

    public static class Reason {
        private final String value;
        public static final Reason UNSPECIFIED = new Reason("unspecified");
        public static final Reason COMPROMISED = new Reason("compromised");
        public static final Reason SUPERSEDED = new Reason("superseded");

        public Reason(String str) {
            this.value = (String) Objects.requireNonNull(str);
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return getValue();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Reason) {
                return Objects.equals(getValue(), ((Reason) obj).getValue());
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(getValue());
        }

        public static Reason parse(String str) {
            Reason reason = UNSPECIFIED;
            if (reason.getValue().equals(str)) {
                return reason;
            }
            Reason reason2 = COMPROMISED;
            if (reason2.getValue().equals(str)) {
                return reason2;
            }
            Reason reason3 = SUPERSEDED;
            return reason3.getValue().equals(str) ? reason3 : new Reason(str);
        }
    }

    public KeyRevocation(Date date, Reason reason) {
        this.revokedAt = (Date) Objects.requireNonNull(date);
        this.reason = reason;
    }

    public Date getRevocationTime() {
        return this.revokedAt;
    }

    public Reason getReason() {
        return this.reason;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyRevocation)) {
            return false;
        }
        KeyRevocation keyRevocation = (KeyRevocation) obj;
        return Objects.equals(this.revokedAt, keyRevocation.revokedAt) && Objects.equals(getReason(), keyRevocation.getReason());
    }

    public int hashCode() {
        return Objects.hash(this.revokedAt, getReason());
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
        mapNewJSONObject.put("revoked_at", Long.valueOf(DateUtils.toSecondsSinceEpoch(getRevocationTime())));
        if (getReason() != null) {
            mapNewJSONObject.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, getReason().getValue());
        }
        return mapNewJSONObject;
    }

    public static KeyRevocation parse(Map<String, Object> map) throws ParseException {
        return new KeyRevocation(DateUtils.fromSecondsSinceEpoch(JSONObjectUtils.getLong(map, "revoked_at")), map.get(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON) != null ? Reason.parse(JSONObjectUtils.getString(map, BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON)) : null);
    }
}
