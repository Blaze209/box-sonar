package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeJSEvent {

    public static final class CppProxy extends NativeJSEvent {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeJSEvent create(NativeJSEventType nativeJSEventType, NativeJSEventName nativeJSEventName);

        private native void nativeDestroy(long j);

        private native String native_getChange(long j);

        private native String native_getChangeEx(long j);

        private native int native_getCommitKey(long j);

        private native boolean native_getFieldFull(long j);

        private native boolean native_getKeyDown(long j);

        private native boolean native_getModifier(long j);

        private native NativeJSEventName native_getName(long j);

        private native boolean native_getRc(long j);

        private native ArrayList<NativeJSSpan> native_getRichChange(long j);

        private native ArrayList<NativeJSSpan> native_getRichChangeEx(long j);

        private native ArrayList<NativeJSSpan> native_getRichValue(long j);

        private native int native_getSelEnd(long j);

        private native int native_getSelStart(long j);

        private native boolean native_getShift(long j);

        private native NativeJSEventSourceTargetInfo native_getSource(long j);

        private native NativeJSEventSourceTargetInfo native_getTarget(long j);

        private native String native_getTargetName(long j);

        private native NativeJSEventType native_getType(long j);

        private native NativeJSEventValue native_getValue(long j);

        private native boolean native_getWillCommit(long j);

        private native void native_setChange(long j, String str);

        private native void native_setChangeEx(long j, String str);

        private native void native_setCommitKey(long j, int i);

        private native void native_setFieldFull(long j, boolean z);

        private native void native_setKeyDown(long j, boolean z);

        private native void native_setModifier(long j, boolean z);

        private native void native_setName(long j, NativeJSEventName nativeJSEventName);

        private native void native_setRc(long j, boolean z);

        private native void native_setRichChange(long j, ArrayList<NativeJSSpan> arrayList);

        private native void native_setRichChangeEx(long j, ArrayList<NativeJSSpan> arrayList);

        private native void native_setRichValue(long j, ArrayList<NativeJSSpan> arrayList);

        private native void native_setSelEnd(long j, int i);

        private native void native_setSelStart(long j, int i);

        private native void native_setShift(long j, boolean z);

        private native void native_setSource(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native void native_setTarget(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native void native_setTargetName(long j, String str);

        private native void native_setType(long j, NativeJSEventType nativeJSEventType);

        private native void native_setValue(long j, NativeJSEventValue nativeJSEventValue);

        private native void native_setWillCommit(long j, boolean z);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public String getChange() {
            return native_getChange(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public String getChangeEx() {
            return native_getChangeEx(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public int getCommitKey() {
            return native_getCommitKey(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getFieldFull() {
            return native_getFieldFull(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getKeyDown() {
            return native_getKeyDown(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getModifier() {
            return native_getModifier(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public NativeJSEventName getName() {
            return native_getName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getRc() {
            return native_getRc(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public ArrayList<NativeJSSpan> getRichChange() {
            return native_getRichChange(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public ArrayList<NativeJSSpan> getRichChangeEx() {
            return native_getRichChangeEx(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public ArrayList<NativeJSSpan> getRichValue() {
            return native_getRichValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public int getSelEnd() {
            return native_getSelEnd(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public int getSelStart() {
            return native_getSelStart(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getShift() {
            return native_getShift(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public NativeJSEventSourceTargetInfo getSource() {
            return native_getSource(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public NativeJSEventSourceTargetInfo getTarget() {
            return native_getTarget(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public String getTargetName() {
            return native_getTargetName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public NativeJSEventType getType() {
            return native_getType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public NativeJSEventValue getValue() {
            return native_getValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public boolean getWillCommit() {
            return native_getWillCommit(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setChange(String str) {
            native_setChange(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setChangeEx(String str) {
            native_setChangeEx(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setCommitKey(int i) {
            native_setCommitKey(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setFieldFull(boolean z) {
            native_setFieldFull(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setKeyDown(boolean z) {
            native_setKeyDown(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setModifier(boolean z) {
            native_setModifier(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setName(NativeJSEventName nativeJSEventName) {
            native_setName(this.nativeRef, nativeJSEventName);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setRc(boolean z) {
            native_setRc(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setRichChange(ArrayList<NativeJSSpan> arrayList) {
            native_setRichChange(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setRichChangeEx(ArrayList<NativeJSSpan> arrayList) {
            native_setRichChangeEx(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setRichValue(ArrayList<NativeJSSpan> arrayList) {
            native_setRichValue(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setSelEnd(int i) {
            native_setSelEnd(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setSelStart(int i) {
            native_setSelStart(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setShift(boolean z) {
            native_setShift(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setSource(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            native_setSource(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setTarget(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            native_setTarget(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setTargetName(String str) {
            native_setTargetName(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setType(NativeJSEventType nativeJSEventType) {
            native_setType(this.nativeRef, nativeJSEventType);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setValue(NativeJSEventValue nativeJSEventValue) {
            native_setValue(this.nativeRef, nativeJSEventValue);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSEvent
        public void setWillCommit(boolean z) {
            native_setWillCommit(this.nativeRef, z);
        }
    }

    public static NativeJSEvent create(NativeJSEventType nativeJSEventType, NativeJSEventName nativeJSEventName) {
        return CppProxy.create(nativeJSEventType, nativeJSEventName);
    }

    public abstract String getChange();

    public abstract String getChangeEx();

    public abstract int getCommitKey();

    public abstract boolean getFieldFull();

    public abstract boolean getKeyDown();

    public abstract boolean getModifier();

    public abstract NativeJSEventName getName();

    public abstract boolean getRc();

    public abstract ArrayList<NativeJSSpan> getRichChange();

    public abstract ArrayList<NativeJSSpan> getRichChangeEx();

    public abstract ArrayList<NativeJSSpan> getRichValue();

    public abstract int getSelEnd();

    public abstract int getSelStart();

    public abstract boolean getShift();

    public abstract NativeJSEventSourceTargetInfo getSource();

    public abstract NativeJSEventSourceTargetInfo getTarget();

    public abstract String getTargetName();

    public abstract NativeJSEventType getType();

    public abstract NativeJSEventValue getValue();

    public abstract boolean getWillCommit();

    public abstract void setChange(String str);

    public abstract void setChangeEx(String str);

    public abstract void setCommitKey(int i);

    public abstract void setFieldFull(boolean z);

    public abstract void setKeyDown(boolean z);

    public abstract void setModifier(boolean z);

    public abstract void setName(NativeJSEventName nativeJSEventName);

    public abstract void setRc(boolean z);

    public abstract void setRichChange(ArrayList<NativeJSSpan> arrayList);

    public abstract void setRichChangeEx(ArrayList<NativeJSSpan> arrayList);

    public abstract void setRichValue(ArrayList<NativeJSSpan> arrayList);

    public abstract void setSelEnd(int i);

    public abstract void setSelStart(int i);

    public abstract void setShift(boolean z);

    public abstract void setSource(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract void setTarget(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract void setTargetName(String str);

    public abstract void setType(NativeJSEventType nativeJSEventType);

    public abstract void setValue(NativeJSEventValue nativeJSEventValue);

    public abstract void setWillCommit(boolean z);
}
