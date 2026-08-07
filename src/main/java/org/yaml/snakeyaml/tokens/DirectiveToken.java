package org.yaml.snakeyaml.tokens;

import java.util.List;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

/* JADX INFO: loaded from: classes5.dex */
public final class DirectiveToken<T> extends Token {
    private final String name;
    private final List<T> value;

    public DirectiveToken(String str, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.name = str;
        if (list != null && list.size() != 2) {
            throw new YAMLException("Two strings must be provided instead of " + list.size());
        }
        this.value = list;
    }

    public String getName() {
        return this.name;
    }

    public List<T> getValue() {
        return this.value;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Directive;
    }
}
