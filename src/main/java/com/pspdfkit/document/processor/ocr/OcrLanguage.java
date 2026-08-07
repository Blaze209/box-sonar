package com.pspdfkit.document.processor.ocr;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public enum OcrLanguage {
    CROATIAN("hrv"),
    CZECH("ces"),
    DANISH("dan"),
    DUTCH("nld"),
    ENGLISH("eng"),
    FINNISH("fin"),
    FRENCH("fra"),
    GERMAN("deu"),
    INDONESIAN("ind"),
    ITALIAN("ita"),
    MALAY("msa"),
    NORWEGIAN(CmcdConfiguration.KEY_NEXT_OBJECT_REQUEST),
    POLISH("pol"),
    PORTUGUESE("por"),
    SERBIAN("srp"),
    SLOVAK("slk"),
    SLOVENIAN("slv"),
    SPANISH("spa"),
    SWEDISH("swe"),
    TURKISH("tur"),
    WELSH("cym");

    private final String trainedDataFilename;

    OcrLanguage(String str) {
        this.trainedDataFilename = str;
    }

    public String getTrainedDataFilename() {
        return this.trainedDataFilename;
    }
}
