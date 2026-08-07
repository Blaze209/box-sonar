package org.apache.hc.core5.http.support;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ExpectSupport {
    public static Expectation parse(HttpRequest httpRequest, EntityDetails entityDetails) throws ProtocolException {
        if (httpRequest.getVersion() != null && httpRequest.getVersion().lessEquals(HttpVersion.HTTP_1_0)) {
            return null;
        }
        final AtomicReference atomicReference = new AtomicReference();
        MessageSupport.parseTokens(httpRequest, "Expect", (Consumer<String>) new Consumer() { // from class: org.apache.hc.core5.http.support.ExpectSupport$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ExpectSupport.lambda$parse$0(atomicReference, (String) obj);
            }
        });
        Expectation expectation = (Expectation) atomicReference.get();
        if (expectation == Expectation.CONTINUE && entityDetails == null) {
            throw new ProtocolException("Expect-Continue request without an enclosed entity");
        }
        return expectation;
    }

    static /* synthetic */ void lambda$parse$0(AtomicReference atomicReference, String str) {
        if (str.equalsIgnoreCase("100-continue")) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Expectation.CONTINUE);
        } else {
            if (TextUtils.isBlank(str)) {
                return;
            }
            atomicReference.set(Expectation.UNKNOWN);
        }
    }
}
