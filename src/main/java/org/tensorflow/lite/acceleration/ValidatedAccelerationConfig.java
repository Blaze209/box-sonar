package org.tensorflow.lite.acceleration;

import org.tensorflow.lite.InterpreterApi;

/* JADX INFO: loaded from: classes5.dex */
public interface ValidatedAccelerationConfig {
    void apply(InterpreterApi.Options options);

    byte[] serialize();
}
