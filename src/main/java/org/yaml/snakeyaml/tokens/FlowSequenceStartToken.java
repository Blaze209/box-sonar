package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowSequenceStartToken extends Token {
    public FlowSequenceStartToken(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.FlowSequenceStart;
    }
}
