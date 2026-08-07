package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpRecorder<T> {
    void execute(T data) throws HttpRecorderException;
}
