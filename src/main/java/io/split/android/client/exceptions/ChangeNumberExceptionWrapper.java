package io.split.android.client.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class ChangeNumberExceptionWrapper extends Exception {
    private final long _changeNumber;
    private final Exception _delegate;

    public ChangeNumberExceptionWrapper(Exception delegate, long changeNumber) {
        this._delegate = delegate;
        this._changeNumber = changeNumber;
    }

    public Exception wrappedException() {
        return this._delegate;
    }

    public long changeNumber() {
        return this._changeNumber;
    }
}
