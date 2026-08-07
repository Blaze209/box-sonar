package com.nimbusds.jose.util;

import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public interface ResourceRetriever {
    Resource retrieveResource(URL url) throws IOException;
}
