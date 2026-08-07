package org.apache.hc.core5.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class CharCodingConfig {
    public static final CharCodingConfig DEFAULT = new Builder().build();
    private static final Charset DEFAULT_CHARSET = StandardCharsets.US_ASCII;
    private final Charset charset;
    private final CodingErrorAction malformedInputAction;
    private final CodingErrorAction unmappableInputAction;

    CharCodingConfig(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        this.charset = charset;
        this.malformedInputAction = codingErrorAction;
        this.unmappableInputAction = codingErrorAction2;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[charset=");
        sb.append(this.charset).append(", malformedInputAction=").append(this.malformedInputAction).append(", unmappableInputAction=").append(this.unmappableInputAction).append("]");
        return sb.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(CharCodingConfig charCodingConfig) {
        Args.notNull(charCodingConfig, "Config");
        return new Builder().setCharset(charCodingConfig.getCharset()).setMalformedInputAction(charCodingConfig.getMalformedInputAction()).setUnmappableInputAction(charCodingConfig.getUnmappableInputAction());
    }

    public static class Builder {
        private Charset charset;
        private CodingErrorAction malformedInputAction;
        private CodingErrorAction unmappableInputAction;

        Builder() {
        }

        public Builder setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction codingErrorAction) {
            this.malformedInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = CharCodingConfig.DEFAULT_CHARSET;
            }
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction codingErrorAction) {
            this.unmappableInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = CharCodingConfig.DEFAULT_CHARSET;
            }
            return this;
        }

        public CharCodingConfig build() {
            Charset charset = this.charset;
            if (charset == null && (this.malformedInputAction != null || this.unmappableInputAction != null)) {
                charset = CharCodingConfig.DEFAULT_CHARSET;
            }
            return new CharCodingConfig(charset, this.malformedInputAction, this.unmappableInputAction);
        }
    }
}
