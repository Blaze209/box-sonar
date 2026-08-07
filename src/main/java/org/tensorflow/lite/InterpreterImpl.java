package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class InterpreterImpl implements InterpreterApi {
    private final String[] signatureKeyList = getSignatureKeys();
    NativeInterpreterWrapper wrapper;

    static class Options extends InterpreterApi.Options {
        Boolean allowBufferHandleOutput;
        Boolean allowFp16PrecisionForFp32;

        public Options() {
        }

        public Options(InterpreterApi.Options options) {
            super(options);
        }

        public Options(Options other) {
            super(other);
            this.allowFp16PrecisionForFp32 = other.allowFp16PrecisionForFp32;
            this.allowBufferHandleOutput = other.allowBufferHandleOutput;
        }
    }

    InterpreterImpl(File modelFile, Options options) {
        this.wrapper = new NativeInterpreterWrapper(modelFile.getAbsolutePath(), options);
    }

    InterpreterImpl(ByteBuffer byteBuffer, Options options) {
        this.wrapper = new NativeInterpreterWrapper(byteBuffer, options);
    }

    InterpreterImpl(NativeInterpreterWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void run(Object input, Object output) {
        HashMap map = new HashMap();
        map.put(0, output);
        runForMultipleInputsOutputs(new Object[]{input}, map);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void runForMultipleInputsOutputs(Object[] inputs, Map<Integer, Object> outputs) {
        checkNotClosed();
        this.wrapper.run(inputs, outputs);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void allocateTensors() {
        checkNotClosed();
        this.wrapper.allocateTensors();
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void resizeInput(int idx, int[] dims) {
        checkNotClosed();
        this.wrapper.resizeInput(idx, dims, false);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void resizeInput(int idx, int[] dims, boolean strict) {
        checkNotClosed();
        this.wrapper.resizeInput(idx, dims, strict);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public int getInputTensorCount() {
        checkNotClosed();
        return this.wrapper.getInputTensorCount();
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public int getInputIndex(String opName) {
        checkNotClosed();
        return this.wrapper.getInputIndex(opName);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public Tensor getInputTensor(int inputIndex) {
        checkNotClosed();
        return this.wrapper.getInputTensor(inputIndex);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public int getOutputTensorCount() {
        checkNotClosed();
        return this.wrapper.getOutputTensorCount();
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public int getOutputIndex(String opName) {
        checkNotClosed();
        return this.wrapper.getOutputIndex(opName);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public Tensor getOutputTensor(int outputIndex) {
        checkNotClosed();
        return this.wrapper.getOutputTensor(outputIndex);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void runSignature(Map<String, Object> inputs, Map<String, Object> outputs, String signatureKey) {
        checkNotClosed();
        if (signatureKey == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                signatureKey = strArr[0];
            }
        }
        if (signatureKey == null) {
            throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
        }
        this.wrapper.runSignature(inputs, outputs, signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public void runSignature(Map<String, Object> inputs, Map<String, Object> outputs) {
        checkNotClosed();
        runSignature(inputs, outputs, null);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public Tensor getInputTensorFromSignature(String inputName, String signatureKey) {
        checkNotClosed();
        if (signatureKey == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                signatureKey = strArr[0];
            }
        }
        if (signatureKey == null) {
            throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
        }
        return this.wrapper.getInputTensor(inputName, signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public String[] getSignatureKeys() {
        checkNotClosed();
        return this.wrapper.getSignatureKeys();
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public String[] getSignatureInputs(String signatureKey) {
        checkNotClosed();
        return this.wrapper.getSignatureInputs(signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public String[] getSignatureOutputs(String signatureKey) {
        checkNotClosed();
        return this.wrapper.getSignatureOutputs(signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public Tensor getOutputTensorFromSignature(String outputName, String signatureKey) {
        checkNotClosed();
        if (signatureKey == null) {
            String[] strArr = this.signatureKeyList;
            if (strArr.length == 1) {
                signatureKey = strArr[0];
            }
        }
        if (signatureKey == null) {
            throw new IllegalArgumentException("Input error: SignatureDef signatureKey should not be null. null is only allowed if the model has a single Signature. Available Signatures: " + Arrays.toString(this.signatureKeyList));
        }
        return this.wrapper.getOutputTensor(outputName, signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterApi
    public Long getLastNativeInferenceDurationNanoseconds() {
        checkNotClosed();
        return this.wrapper.getLastNativeInferenceDurationNanoseconds();
    }

    int getExecutionPlanLength() {
        checkNotClosed();
        return this.wrapper.getExecutionPlanLength();
    }

    @Override // org.tensorflow.lite.InterpreterApi, java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.wrapper;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.wrapper = null;
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    void checkNotClosed() {
        if (this.wrapper == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }
}
