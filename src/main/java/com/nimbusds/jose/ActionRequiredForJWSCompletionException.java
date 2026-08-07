package com.nimbusds.jose;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ActionRequiredForJWSCompletionException extends JOSEException {
    private final CompletableJWSObjectSigning completableSigning;
    private final JWSSignerOption option;

    public ActionRequiredForJWSCompletionException(String str, JWSSignerOption jWSSignerOption, CompletableJWSObjectSigning completableJWSObjectSigning) {
        super(str);
        this.option = (JWSSignerOption) Objects.requireNonNull(jWSSignerOption);
        this.completableSigning = (CompletableJWSObjectSigning) Objects.requireNonNull(completableJWSObjectSigning);
    }

    public JWSSignerOption getTriggeringOption() {
        return this.option;
    }

    public CompletableJWSObjectSigning getCompletableJWSObjectSigning() {
        return this.completableSigning;
    }
}
