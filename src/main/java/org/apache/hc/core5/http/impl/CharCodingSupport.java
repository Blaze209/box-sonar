package org.apache.hc.core5.http.impl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import org.apache.hc.core5.http.config.CharCodingConfig;

/* JADX INFO: loaded from: classes5.dex */
public final class CharCodingSupport {
    private CharCodingSupport() {
    }

    public static CharsetDecoder createDecoder(CharCodingConfig charCodingConfig) {
        if (charCodingConfig == null) {
            return null;
        }
        Charset charset = charCodingConfig.getCharset();
        CodingErrorAction malformedInputAction = charCodingConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = charCodingConfig.getUnmappableInputAction();
        if (charset == null) {
            return null;
        }
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetDecoder charsetDecoderOnMalformedInput = charsetDecoderNewDecoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return charsetDecoderOnMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }

    public static CharsetEncoder createEncoder(CharCodingConfig charCodingConfig) {
        Charset charset;
        if (charCodingConfig == null || (charset = charCodingConfig.getCharset()) == null) {
            return null;
        }
        CodingErrorAction malformedInputAction = charCodingConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = charCodingConfig.getUnmappableInputAction();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetEncoder charsetEncoderOnMalformedInput = charsetEncoderNewEncoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return charsetEncoderOnMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }
}
