package com.microsoft.identity.common.java.browser;

import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class NoopBrowserSelector implements IBrowserSelector {
    @Override // com.microsoft.identity.common.java.browser.IBrowserSelector
    public Browser selectBrowser(List<BrowserDescriptor> list, BrowserDescriptor browserDescriptor) {
        return null;
    }
}
