package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Registry;
import androidx.constraintlayout.core.state.RegistryCallback;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.observability.DiagnosisParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0011\b!\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0004J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nH\u0004J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\nH\u0004J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0016\u0010)\u001a\u00020\u001b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0016J\b\u0010+\u001a\u00020\u001bH\u0004R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "content", "", "(Ljava/lang/String;)V", "currentContent", "debugName", "forcedDrawDebug", "Landroidx/constraintlayout/compose/MotionLayoutDebugFlags;", "forcedHeight", "", "forcedWidth", "last", "", "layoutInformation", "layoutInformationMode", "Landroidx/constraintlayout/compose/LayoutInfoFlags;", "updateFlag", "Landroidx/compose/runtime/MutableState;", "getCurrentContent", "getDebugName", "getForcedDrawDebug", "getForcedHeight", "getForcedWidth", "getLayoutInformation", "getLayoutInformationMode", "initialization", "", "onDrawDebug", "debugMode", "onLayoutInformation", DiagnosisParams.DIAGNOSIS_MODE, "onNewContent", "onNewDimensions", "width", "height", "setCurrentContent", "setDebugName", "name", "setLayoutInformation", TtmlNode.TAG_INFORMATION, "setUpdateFlag", "needsUpdate", "signalUpdate", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EditableJSONLayout implements LayoutInformationReceiver {
    public static final int $stable = 8;
    private String currentContent;
    private String debugName;
    private MutableState<Long> updateFlag;
    private int forcedWidth = Integer.MIN_VALUE;
    private int forcedHeight = Integer.MIN_VALUE;
    private MotionLayoutDebugFlags forcedDrawDebug = MotionLayoutDebugFlags.UNKNOWN;
    private LayoutInfoFlags layoutInformationMode = LayoutInfoFlags.NONE;
    private String layoutInformation = "";
    private long last = System.nanoTime();

    public EditableJSONLayout(String str) {
        this.currentContent = str;
    }

    protected final void initialization() {
        try {
            onNewContent(this.currentContent);
            if (this.debugName != null) {
                Registry.getInstance().register(this.debugName, new RegistryCallback() { // from class: androidx.constraintlayout.compose.EditableJSONLayout$initialization$callback$1
                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public void onNewMotionScene(String content) {
                        if (content == null) {
                            return;
                        }
                        this.this$0.onNewContent(content);
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public void onProgress(float progress) {
                        this.this$0.onNewProgress(progress);
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public void onDimensions(int width, int height) {
                        this.this$0.onNewDimensions(width, height);
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public String currentMotionScene() {
                        return this.this$0.currentContent;
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public String currentLayoutInformation() {
                        return this.this$0.layoutInformation;
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public void setLayoutInformationMode(int mode) {
                        this.this$0.onLayoutInformation(mode);
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public long getLastModified() {
                        return this.this$0.last;
                    }

                    @Override // androidx.constraintlayout.core.state.RegistryCallback
                    public void setDrawDebug(int debugMode) {
                        this.this$0.onDrawDebug(debugMode);
                    }
                });
            }
        } catch (CLParsingException unused) {
        }
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void setUpdateFlag(MutableState<Long> needsUpdate) {
        this.updateFlag = needsUpdate;
    }

    protected final void signalUpdate() {
        MutableState<Long> mutableState = this.updateFlag;
        if (mutableState != null) {
            Intrinsics.checkNotNull(mutableState);
            MutableState<Long> mutableState2 = this.updateFlag;
            Intrinsics.checkNotNull(mutableState2);
            mutableState.setValue(Long.valueOf(mutableState2.getValue().longValue() + 1));
        }
    }

    public final void setCurrentContent(String content) {
        onNewContent(content);
    }

    public final String getCurrentContent() {
        return this.currentContent;
    }

    public final void setDebugName(String name) {
        this.debugName = name;
    }

    public final String getDebugName() {
        return this.debugName;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public MotionLayoutDebugFlags getForcedDrawDebug() {
        return this.forcedDrawDebug;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public int getForcedWidth() {
        return this.forcedWidth;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public int getForcedHeight() {
        return this.forcedHeight;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void setLayoutInformation(String information) {
        this.last = System.nanoTime();
        this.layoutInformation = information;
    }

    public final String getLayoutInformation() {
        return this.layoutInformation;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public LayoutInfoFlags getLayoutInformationMode() {
        return this.layoutInformationMode;
    }

    protected void onNewContent(String content) {
        CLObject objectOrNull;
        this.currentContent = content;
        try {
            CLObject cLObject = CLParser.parse(content);
            if (cLObject != null) {
                boolean z = this.debugName == null;
                if (z && (objectOrNull = cLObject.getObjectOrNull("Header")) != null) {
                    this.debugName = objectOrNull.getStringOrNull("exportAs");
                    this.layoutInformationMode = LayoutInfoFlags.BOUNDS;
                }
                if (z) {
                    return;
                }
                signalUpdate();
            }
        } catch (CLParsingException | Exception unused) {
        }
    }

    public final void onNewDimensions(int width, int height) {
        this.forcedWidth = width;
        this.forcedHeight = height;
        signalUpdate();
    }

    protected final void onLayoutInformation(int mode) {
        if (mode == LayoutInfoFlags.NONE.ordinal()) {
            this.layoutInformationMode = LayoutInfoFlags.NONE;
        } else if (mode == LayoutInfoFlags.BOUNDS.ordinal()) {
            this.layoutInformationMode = LayoutInfoFlags.BOUNDS;
        }
        signalUpdate();
    }

    protected final void onDrawDebug(int debugMode) {
        MotionLayoutDebugFlags motionLayoutDebugFlags;
        if (debugMode == MotionLayoutDebugFlags.UNKNOWN.ordinal()) {
            motionLayoutDebugFlags = MotionLayoutDebugFlags.UNKNOWN;
        } else if (debugMode == MotionLayoutDebugFlags.NONE.ordinal()) {
            motionLayoutDebugFlags = MotionLayoutDebugFlags.NONE;
        } else if (debugMode == MotionLayoutDebugFlags.SHOW_ALL.ordinal()) {
            motionLayoutDebugFlags = MotionLayoutDebugFlags.SHOW_ALL;
        } else if (debugMode == -1) {
            motionLayoutDebugFlags = MotionLayoutDebugFlags.UNKNOWN;
        } else {
            motionLayoutDebugFlags = MotionLayoutDebugFlags.UNKNOWN;
        }
        this.forcedDrawDebug = motionLayoutDebugFlags;
        signalUpdate();
    }
}
