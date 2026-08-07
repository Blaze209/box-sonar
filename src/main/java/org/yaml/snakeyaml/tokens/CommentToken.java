package org.yaml.snakeyaml.tokens;

import java.util.Objects;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public final class CommentToken extends Token {
    private final CommentType type;
    private final String value;

    public CommentToken(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        Objects.requireNonNull(commentType);
        this.type = commentType;
        Objects.requireNonNull(str);
        this.value = str;
    }

    public CommentType getCommentType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Comment;
    }
}
