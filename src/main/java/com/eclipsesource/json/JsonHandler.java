package com.eclipsesource.json;

/* JADX INFO: loaded from: classes13.dex */
public abstract class JsonHandler<A, O> {
    JsonParser parser;

    public void endArray(A a) {
    }

    public void endArrayValue(A a) {
    }

    public void endBoolean(boolean z) {
    }

    public void endNull() {
    }

    public void endNumber(String str) {
    }

    public void endObject(O o) {
    }

    public void endObjectName(O o, String str) {
    }

    public void endObjectValue(O o, String str) {
    }

    public void endString(String str) {
    }

    public A startArray() {
        return null;
    }

    public void startArrayValue(A a) {
    }

    public void startBoolean() {
    }

    public void startNull() {
    }

    public void startNumber() {
    }

    public O startObject() {
        return null;
    }

    public void startObjectName(O o) {
    }

    public void startObjectValue(O o, String str) {
    }

    public void startString() {
    }

    protected Location getLocation() {
        return this.parser.getLocation();
    }
}
