package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class TagToken extends Token {
    private final TagTuple value;

    public TagToken(TagTuple tagTuple, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.value = tagTuple;
    }

    public TagTuple getValue() {
        return this.value;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Tag;
    }
}
