package com.pspdfkit.document.processor;

import android.net.Uri;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;

/* JADX INFO: loaded from: classes3.dex */
public final class PagePattern {
    public static final PagePattern BLANK = new PagePattern();
    public static final PagePattern DOTS_5MM = new PagePattern("PatternDot5mm.pdf");
    public static final PagePattern GRID_5MM = new PagePattern("PatternGrid5mm.pdf");
    public static final PagePattern LINES_5MM = new PagePattern("PatternLines5mm.pdf");
    public static final PagePattern LINES_7MM = new PagePattern("PatternLines7mm.pdf");
    private final String assetFileName;
    private final DataProvider dataProvider;

    private PagePattern() {
        this.dataProvider = null;
        this.assetFileName = null;
    }

    public String getAssetFileName() {
        return this.assetFileName;
    }

    public DataProvider getDataProvider() {
        return this.dataProvider;
    }

    private PagePattern(String str) {
        this.assetFileName = str;
        this.dataProvider = new AssetDataProvider(wg.b(str));
    }

    public PagePattern(DataProvider dataProvider) {
        uw.a(dataProvider, "dataProvider", null);
        this.dataProvider = dataProvider;
        this.assetFileName = null;
    }

    public PagePattern(Uri uri) {
        this(new ContentResolverDataProvider(uri));
    }
}
