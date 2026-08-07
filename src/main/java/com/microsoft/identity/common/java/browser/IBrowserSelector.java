package com.microsoft.identity.common.java.browser;

import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrowserSelector {
    Browser selectBrowser(List<BrowserDescriptor> list, BrowserDescriptor browserDescriptor);
}
