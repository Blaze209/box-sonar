package com.geniusscansdk.pdf;

import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
final class JNIPDFDocument {
    final Date creationDate;
    final String keywords;
    final Date lastUpdateDate;
    final ArrayList<JNIPDFPage> pages;
    final String password;
    final String title;

    public JNIPDFDocument(String str, String str2, String str3, Date date, Date date2, ArrayList<JNIPDFPage> arrayList) {
        this.title = str;
        this.password = str2;
        this.keywords = str3;
        this.creationDate = date;
        this.lastUpdateDate = date2;
        this.pages = arrayList;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPassword() {
        return this.password;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public ArrayList<JNIPDFPage> getPages() {
        return this.pages;
    }

    public String toString() {
        return "JNIPDFDocument{title=" + this.title + ",password=" + this.password + ",keywords=" + this.keywords + ",creationDate=" + this.creationDate + ",lastUpdateDate=" + this.lastUpdateDate + ",pages=" + this.pages + "}";
    }
}
