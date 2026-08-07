package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class AnchorToken extends Token {
    private final String value;

    public AnchorToken(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Anchor;
    }
}
