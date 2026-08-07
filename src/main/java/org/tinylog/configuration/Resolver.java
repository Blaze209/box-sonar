package org.tinylog.configuration;

/* JADX INFO: loaded from: classes5.dex */
interface Resolver {
    String getName();

    char getPrefix();

    String resolve(String str);
}
