package org.tinylog.configuration;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;

/* JADX INFO: loaded from: classes5.dex */
public final class JndiValueResolver implements Resolver {
    private static final String DEFAULT_PREFIX = "java:comp/env/";
    public static final JndiValueResolver INSTANCE = new JndiValueResolver();

    @Override // org.tinylog.configuration.Resolver
    public char getPrefix() {
        return CommentBarInputBoxKt.MENTION_SYMBOL;
    }

    private JndiValueResolver() {
    }

    @Override // org.tinylog.configuration.Resolver
    public String getName() {
        return "JNDI values";
    }

    @Override // org.tinylog.configuration.Resolver
    public String resolve(String str) {
        if (!str.contains(":")) {
            str = DEFAULT_PREFIX + str;
        }
        return InitialContextWrapper.resolve(str);
    }
}
