package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Interpreter extends InterpreterImpl implements InterpreterApi {
    private final NativeInterpreterWrapperExperimental wrapperExperimental;

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void allocateTensors() {
        super.allocateTensors();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ int getInputIndex(String opName) {
        return super.getInputIndex(opName);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ Tensor getInputTensor(int inputIndex) {
        return super.getInputTensor(inputIndex);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ int getInputTensorCount() {
        return super.getInputTensorCount();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ Tensor getInputTensorFromSignature(String inputName, String signatureKey) {
        return super.getInputTensorFromSignature(inputName, signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ Long getLastNativeInferenceDurationNanoseconds() {
        return super.getLastNativeInferenceDurationNanoseconds();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ int getOutputIndex(String opName) {
        return super.getOutputIndex(opName);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ Tensor getOutputTensor(int outputIndex) {
        return super.getOutputTensor(outputIndex);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ int getOutputTensorCount() {
        return super.getOutputTensorCount();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ Tensor getOutputTensorFromSignature(String outputName, String signatureKey) {
        return super.getOutputTensorFromSignature(outputName, signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ String[] getSignatureInputs(String signatureKey) {
        return super.getSignatureInputs(signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ String[] getSignatureKeys() {
        return super.getSignatureKeys();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ String[] getSignatureOutputs(String signatureKey) {
        return super.getSignatureOutputs(signatureKey);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void resizeInput(int idx, int[] dims) {
        super.resizeInput(idx, dims);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void resizeInput(int idx, int[] dims, boolean strict) {
        super.resizeInput(idx, dims, strict);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void run(Object input, Object output) {
        super.run(input, output);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void runForMultipleInputsOutputs(Object[] inputs, Map outputs) {
        super.runForMultipleInputsOutputs(inputs, outputs);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void runSignature(Map inputs, Map outputs) {
        super.runSignature(inputs, outputs);
    }

    @Override // org.tensorflow.lite.InterpreterImpl, org.tensorflow.lite.InterpreterApi
    public /* bridge */ /* synthetic */ void runSignature(Map inputs, Map outputs, String signatureKey) {
        super.runSignature(inputs, outputs, signatureKey);
    }

    public static class Options extends InterpreterImpl.Options {
        public Options() {
        }

        public Options(InterpreterApi.Options options) {
            super(options);
        }

        Options(InterpreterImpl.Options options) {
            super(options);
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options setUseXNNPACK(boolean useXNNPACK) {
            super.setUseXNNPACK(useXNNPACK);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options setNumThreads(int numThreads) {
            super.setNumThreads(numThreads);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options setUseNNAPI(boolean useNNAPI) {
            super.setUseNNAPI(useNNAPI);
            return this;
        }

        @Deprecated
        public Options setAllowFp16PrecisionForFp32(boolean allow) {
            this.allowFp16PrecisionForFp32 = Boolean.valueOf(allow);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options addDelegate(Delegate delegate) {
            super.addDelegate(delegate);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options addDelegateFactory(DelegateFactory delegateFactory) {
            super.addDelegateFactory(delegateFactory);
            return this;
        }

        public Options setAllowBufferHandleOutput(boolean allow) {
            this.allowBufferHandleOutput = Boolean.valueOf(allow);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options setCancellable(boolean allow) {
            super.setCancellable(allow);
            return this;
        }

        @Override // org.tensorflow.lite.InterpreterApi.Options
        public Options setRuntime(InterpreterApi.Options.TfLiteRuntime runtime) {
            super.setRuntime(runtime);
            return this;
        }
    }

    public Interpreter(File modelFile) {
        this(modelFile, (Options) null);
    }

    public Interpreter(File modelFile, Options options) {
        this(new NativeInterpreterWrapperExperimental(modelFile.getAbsolutePath(), options));
    }

    public Interpreter(ByteBuffer byteBuffer) {
        this(byteBuffer, (Options) null);
    }

    public Interpreter(ByteBuffer byteBuffer, Options options) {
        this(new NativeInterpreterWrapperExperimental(byteBuffer, options));
    }

    private Interpreter(NativeInterpreterWrapperExperimental wrapper) {
        super(wrapper);
        this.wrapperExperimental = wrapper;
    }

    public void resetVariableTensors() {
        checkNotClosed();
        this.wrapperExperimental.resetVariableTensors();
    }

    public void setCancelled(boolean cancelled) {
        this.wrapper.setCancelled(cancelled);
    }
}
