package com.pspdfkit.ui.audio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.e9;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.fk;
import com.pspdfkit.internal.gk;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.ui.audio.AudioVisualizerView;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.yz;
import com.pspdfkit.ui.LocalizedTextView;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class AudioView extends FrameLayout implements View.OnClickListener {
    private static final int MODE_CHANGE_DELAY_MS = 100;
    private static final long POSITION_UPDATE_INTERVAL_MS = 300;
    private static final int RECORD_CIRCLE_BORDER_RADIUS_DP = 9;
    private static final int RECORD_CIRCLE_BORDER_WIDTH_DP = 2;
    private static final int RECORD_CIRCLE_RADIUS_DP = 6;
    private static final int SHOW_HIDE_ANIMATION_DURATION_MS = 250;
    private LinearLayout audioControlsLayout;
    private LocalizedTextView audioErrorView;
    private ProgressBar audioLoadingBar;
    private AudioVisualizerView audioVisualizer;
    private Drawable closeIcon;
    private TextView currentTime;
    private boolean isDisplayed;
    private boolean isInProgress;
    private boolean isUserSeeking;
    private final go<AudioInspectorLifecycleListener> lifecycleListeners;
    private LoadingState loadingState;
    private Drawable pauseIcon;
    private ImageButton playButton;
    private Drawable playIcon;
    private AudioPlaybackController playbackController;
    private final PlaybackListeners playbackListeners;
    private Drawable recordIcon;
    private Drawable recordIconPaused;
    private AudioRecordingController recordingController;
    private final RecordingListeners recordingListeners;
    private SeekBar seekBar;
    private ImageButton stopButton;
    private Drawable stopIcon;
    private fk.a systemUiVisibleLock;
    private TextView totalTime;
    private final Runnable updateProgressRunnable;
    private Disposable visualizerDisposable;

    public interface AudioInspectorLifecycleListener {
        void onDisplayAudioInspector(AudioView audioView);

        void onPrepareAudioInspector(AudioView audioView);

        void onRemoveAudioInspector(AudioView audioView);
    }

    public enum LoadingState {
        LOADING,
        ERROR,
        READY
    }

    public class PlaybackListeners implements AudioPlaybackController.AudioPlaybackListener, AudioModeListeners.AudioPlaybackModeChangeListener {
        private Runnable updatePlaybackRunnable;

        private PlaybackListeners() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChangeAudioPlaybackMode$0(AudioPlaybackController audioPlaybackController) {
            AudioView audioView = AudioView.this;
            if (audioView.playbackController == audioPlaybackController) {
                audioView.refresh();
            } else {
                audioView.bindController(audioPlaybackController);
            }
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
        public void onChangeAudioPlaybackMode(final AudioPlaybackController audioPlaybackController) {
            Runnable runnable = this.updatePlaybackRunnable;
            if (runnable != null) {
                AudioView.this.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$PlaybackListeners$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onChangeAudioPlaybackMode$0(audioPlaybackController);
                }
            };
            this.updatePlaybackRunnable = runnable2;
            AudioView.this.postDelayed(runnable2, 100L);
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
        public void onEnterAudioPlaybackMode(AudioPlaybackController audioPlaybackController) {
        }

        @Override // com.pspdfkit.ui.audio.AudioPlaybackController.AudioPlaybackListener
        public void onError(AudioPlaybackController audioPlaybackController, Throwable th) {
            AudioView audioView = AudioView.this;
            audioView.showError("⚠︎ " + no.a(audioView.getContext(), R.string.pspdf__audio_error_start_playback, null));
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
        public void onExitAudioPlaybackMode(AudioPlaybackController audioPlaybackController) {
        }

        @Override // com.pspdfkit.ui.audio.AudioPlaybackController.AudioPlaybackListener
        public void onPause(AudioPlaybackController audioPlaybackController) {
            AudioView.this.setInProgress(false);
        }

        @Override // com.pspdfkit.ui.audio.AudioPlaybackController.AudioPlaybackListener
        public void onPlay(AudioPlaybackController audioPlaybackController) {
            AudioView.this.setInProgress(true);
        }

        @Override // com.pspdfkit.ui.audio.AudioPlaybackController.AudioPlaybackListener
        public void onReady(AudioPlaybackController audioPlaybackController) {
            AudioView.this.refresh();
        }

        @Override // com.pspdfkit.ui.audio.AudioPlaybackController.AudioPlaybackListener
        public void onStop(AudioPlaybackController audioPlaybackController) {
            AudioView.this.setInProgress(false);
        }
    }

    public class RecordingListeners implements AudioRecordingController.AudioRecordingListener, AudioModeListeners.AudioRecordingModeChangeListener {
        private Runnable updateRecordingRunnable;

        private RecordingListeners() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChangeAudioRecordingMode$0(AudioRecordingController audioRecordingController) {
            AudioView audioView = AudioView.this;
            if (audioView.recordingController == audioRecordingController) {
                audioView.refresh();
            } else {
                audioView.bindController(audioRecordingController);
            }
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
        public void onChangeAudioRecordingMode(final AudioRecordingController audioRecordingController) {
            Runnable runnable = this.updateRecordingRunnable;
            if (runnable != null) {
                AudioView.this.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$RecordingListeners$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onChangeAudioRecordingMode$0(audioRecordingController);
                }
            };
            this.updateRecordingRunnable = runnable2;
            AudioView.this.postDelayed(runnable2, 100L);
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
        public void onEnterAudioRecordingMode(AudioRecordingController audioRecordingController) {
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onError(AudioRecordingController audioRecordingController, Throwable th) {
            AudioView audioView = AudioView.this;
            audioView.showError("⚠︎ " + no.a(audioView.getContext(), R.string.pspdf__audio_error_start_recording, null));
        }

        @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
        public void onExitAudioRecordingMode(AudioRecordingController audioRecordingController) {
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onPause(AudioRecordingController audioRecordingController) {
            AudioView.this.setInProgress(false);
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onReady(AudioRecordingController audioRecordingController) {
            AudioView.this.refresh();
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onRecord(AudioRecordingController audioRecordingController) {
            AudioView.this.setInProgress(true);
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onSave(AudioRecordingController audioRecordingController) {
        }

        @Override // com.pspdfkit.ui.audio.AudioRecordingController.AudioRecordingListener
        public void onStop(AudioRecordingController audioRecordingController) {
            AudioView.this.setInProgress(false);
        }
    }

    public AudioView(Context context) {
        super(context);
        this.lifecycleListeners = new go<>();
        this.playbackListeners = new PlaybackListeners();
        this.recordingListeners = new RecordingListeners();
        this.isDisplayed = false;
        this.loadingState = LoadingState.READY;
        this.isInProgress = false;
        this.isUserSeeking = false;
        this.updateProgressRunnable = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        init();
    }

    private String formatTime(int i) {
        int i2 = i / 1000;
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
    }

    private void init() {
        setVisibility(8);
    }

    private void initSeekBarListener() {
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.pspdfkit.ui.audio.AudioView.1
            private int seekTime = 0;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    AudioView audioView = AudioView.this;
                    if (audioView.isUserSeeking) {
                        this.seekTime = i;
                        audioView.setCurrentTime(i, true);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                AudioView audioView = AudioView.this;
                if (audioView.playbackController != null) {
                    audioView.isUserSeeking = true;
                    this.seekTime = seekBar.getProgress();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                AudioView audioView = AudioView.this;
                if (audioView.playbackController != null) {
                    audioView.isUserSeeking = false;
                    audioView.setCurrentTime(this.seekTime, true);
                    AudioView.this.playbackController.seekTo(this.seekTime);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hide$2() {
        Iterator<AudioInspectorLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onRemoveAudioInspector(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$hide$3() {
        setVisibility(8);
        if (this.systemUiVisibleLock != null) {
            Context context = getContext();
            fk.a aVar = this.systemUiVisibleLock;
            fk fkVarA = gk.a(context);
            if (fkVarA != null) {
                fkVarA.d.remove(aVar);
                fkVarA.b();
            }
            this.systemUiVisibleLock = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0() {
        this.systemUiVisibleLock = gk.a(getContext(), this.systemUiVisibleLock);
        Iterator<AudioInspectorLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPrepareAudioInspector(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1() {
        Iterator<AudioInspectorLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDisplayAudioInspector(this);
        }
    }

    private void prepareViews() {
        if (this.audioControlsLayout != null) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__audio_inspector_bar, (ViewGroup) this, true);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, R.styleable.pspdf__AudioInspector, R.attr.pspdf__audioInspectorStyle, R.style.PSPDFKit_AudioInspector);
        int iA = f60.a(getContext(), androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AudioInspector_pspdf__backgroundColor, f60.a(getContext(), android.R.attr.colorBackground, R.color.pspdf__surfaceDimLight));
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AudioInspector_pspdf__iconsColor, iA);
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AudioInspector_pspdf__recordingIconColor, ContextCompat.getColor(getContext(), R.color.pspdf__errorContainerLight));
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.pspdf__audio_view_background);
        if (drawable != null) {
            DrawableCompat.setTint(drawable, color);
            setBackground(drawable);
        } else {
            setBackgroundColor(color);
        }
        this.audioLoadingBar = (ProgressBar) viewInflate.findViewById(R.id.pspdf__audio_loading_bar);
        this.audioControlsLayout = (LinearLayout) viewInflate.findViewById(R.id.pspdf__audio_controls_layout);
        this.audioErrorView = (LocalizedTextView) viewInflate.findViewById(R.id.pspdf__audio_error);
        AudioVisualizerView audioVisualizerView = (AudioVisualizerView) viewInflate.findViewById(R.id.pspdf__audio_visualizer);
        this.audioVisualizer = audioVisualizerView;
        audioVisualizerView.setWaveformColor(color2);
        this.closeIcon = a80.a(getContext(), R.drawable.pspdf__ic_close, color2);
        this.stopIcon = a80.a(getContext(), R.drawable.pspdf__ic_stop, color2);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.pspdf__audio_stop);
        this.stopButton = imageButton;
        imageButton.setImageDrawable(this.closeIcon);
        this.stopButton.setOnClickListener(this);
        this.playIcon = a80.a(getContext(), R.drawable.pspdf__ic_play, color2);
        this.pauseIcon = a80.a(getContext(), R.drawable.pspdf__ic_pause, color2);
        this.recordIconPaused = new e9(getContext(), color3, 0, 0.0f, 9.0f, 2.0f);
        this.recordIcon = new e9(getContext(), color3, color3, 6.0f, 9.0f, 2.0f);
        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R.id.pspdf__audio_play);
        this.playButton = imageButton2;
        imageButton2.setImageDrawable(this.playIcon);
        this.playButton.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(R.id.pspdf__audio_seek_bar);
        this.seekBar = seekBar;
        seekBar.setThumbTintList(ColorStateList.valueOf(color2));
        initSeekBarListener();
        this.currentTime = (TextView) viewInflate.findViewById(R.id.pspdf__audio_current_time);
        this.totalTime = (TextView) viewInflate.findViewById(R.id.pspdf__audio_total_time);
        setLoadingState(LoadingState.LOADING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        refreshViews();
        AudioPlaybackController audioPlaybackController = this.playbackController;
        if (audioPlaybackController != null) {
            boolean zIsReady = audioPlaybackController.isReady();
            setLoadingState(zIsReady ? LoadingState.READY : LoadingState.LOADING);
            if (zIsReady) {
                setTotalTime(this.playbackController.getDuration());
                setCurrentTime(this.playbackController.getCurrentPosition(), false);
                setInProgress(this.playbackController.isResumed());
                return;
            }
            return;
        }
        AudioRecordingController audioRecordingController = this.recordingController;
        if (audioRecordingController != null) {
            boolean zIsReady2 = audioRecordingController.isReady();
            setLoadingState(zIsReady2 ? LoadingState.READY : LoadingState.LOADING);
            if (zIsReady2) {
                setCurrentTime(this.recordingController.getCurrentPosition(), false);
                setInProgress(this.recordingController.isResumed());
            }
        }
    }

    private void refreshViews() {
        if (this.playbackController != null) {
            this.seekBar.setVisibility(0);
            this.totalTime.setVisibility(0);
            this.audioVisualizer.setVisibility(8);
            this.stopButton.setImageDrawable(this.closeIcon);
            boolean z = this.isInProgress;
            ImageButton imageButton = this.playButton;
            if (z) {
                imageButton.setImageDrawable(this.pauseIcon);
                this.playButton.setContentDescription(no.a(getContext(), R.string.pspdf__audio_pause, null));
            } else {
                imageButton.setImageDrawable(this.playIcon);
                this.playButton.setContentDescription(no.a(getContext(), R.string.pspdf__audio_resume, null));
            }
            updateProgress();
            return;
        }
        if (this.recordingController != null) {
            this.seekBar.setVisibility(8);
            this.totalTime.setVisibility(8);
            this.audioVisualizer.setVisibility(0);
            this.stopButton.setImageDrawable(this.stopIcon);
            boolean z2 = this.isInProgress;
            ImageButton imageButton2 = this.playButton;
            if (z2) {
                imageButton2.setImageDrawable(this.recordIcon);
                this.playButton.setContentDescription(no.a(getContext(), R.string.pspdf__audio_pause, null));
            } else {
                imageButton2.setImageDrawable(this.recordIconPaused);
                this.playButton.setContentDescription(no.a(getContext(), R.string.pspdf__audio_record, null));
            }
            updateProgress();
            updateAudioVisualizer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentTime(int i, boolean z) {
        if (z || !this.isUserSeeking) {
            this.seekBar.setProgress(i);
            this.currentTime.setText(formatTime(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInProgress(boolean z) {
        if (this.isInProgress == z) {
            return;
        }
        this.isInProgress = z;
        refreshViews();
    }

    private void setLoadingState(LoadingState loadingState) {
        if (this.loadingState == loadingState) {
            return;
        }
        this.loadingState = loadingState;
        int iOrdinal = loadingState.ordinal();
        if (iOrdinal == 0) {
            this.audioLoadingBar.setVisibility(0);
            this.audioControlsLayout.setVisibility(8);
            this.audioErrorView.setVisibility(8);
        } else if (iOrdinal == 1) {
            this.audioLoadingBar.setVisibility(8);
            this.audioControlsLayout.setVisibility(8);
            this.audioErrorView.setVisibility(0);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.audioLoadingBar.setVisibility(8);
            this.audioControlsLayout.setVisibility(0);
            this.audioErrorView.setVisibility(8);
        }
    }

    private void setMediaVolumeControlEnabled(boolean z) {
        a80.a((View) this).setVolumeControlStream(z ? 3 : Integer.MIN_VALUE);
    }

    private void setTotalTime(int i) {
        this.seekBar.setMax(i);
        this.totalTime.setText(formatTime(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(String str) {
        this.audioErrorView.setText(str);
        setLoadingState(LoadingState.ERROR);
    }

    private void updateAudioVisualizer() {
        yz.a(this.visualizerDisposable);
        AudioRecordingController audioRecordingController = this.recordingController;
        if (audioRecordingController != null) {
            if (!this.isInProgress) {
                this.audioVisualizer.setSamples(null);
                return;
            }
            Flowable<ByteBuffer> visualizerFlowable = audioRecordingController.getVisualizerFlowable();
            final AudioVisualizerView audioVisualizerView = this.audioVisualizer;
            Objects.requireNonNull(audioVisualizerView);
            this.visualizerDisposable = visualizerFlowable.subscribe(new Consumer() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda5
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    audioVisualizerView.setSamples((ByteBuffer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        AudioPlaybackController audioPlaybackController = this.playbackController;
        boolean zIsResumed = false;
        if (audioPlaybackController != null) {
            setCurrentTime(audioPlaybackController.getCurrentPosition(), false);
            zIsResumed = this.playbackController.isResumed();
        } else {
            AudioRecordingController audioRecordingController = this.recordingController;
            if (audioRecordingController != null) {
                setCurrentTime(audioRecordingController.getCurrentPosition(), false);
                zIsResumed = this.recordingController.isResumed();
            }
        }
        if (zIsResumed) {
            removeCallbacks(this.updateProgressRunnable);
            postDelayed(this.updateProgressRunnable, 300L);
        }
    }

    public void addOnAudioInspectorLifecycleListener(AudioInspectorLifecycleListener audioInspectorLifecycleListener) {
        uw.a(audioInspectorLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.lifecycleListeners.a(audioInspectorLifecycleListener);
    }

    public void bindController(AudioPlaybackController audioPlaybackController) {
        prepareViews();
        AudioPlaybackController audioPlaybackController2 = this.playbackController;
        if (audioPlaybackController2 == audioPlaybackController) {
            return;
        }
        if (audioPlaybackController2 != null || this.recordingController != null) {
            unbindController(false);
        }
        this.playbackController = audioPlaybackController;
        audioPlaybackController.addAudioPlaybackListener(this.playbackListeners);
        audioPlaybackController.getAudioModeManager().addAudioPlaybackModeChangeListener(this.playbackListeners);
        refresh();
        setMediaVolumeControlEnabled(true);
        show(true);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, 0, rect.right, rect.bottom);
        return false;
    }

    public int getAudioInspectorHeight() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    public void hide(boolean z) {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(z ? 250L : 0L).setStartDelay(z ? 100L : 0L).withStartAction(new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$2();
                }
            }).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$3();
                }
            });
        }
    }

    public boolean isVisible() {
        return this.isDisplayed;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.stopButton) {
            AudioPlaybackController audioPlaybackController = this.playbackController;
            if (audioPlaybackController != null) {
                audioPlaybackController.exitAudioPlaybackMode();
            }
            AudioRecordingController audioRecordingController = this.recordingController;
            if (audioRecordingController != null) {
                audioRecordingController.exitAudioRecordingMode(true);
                return;
            }
            return;
        }
        if (view == this.playButton) {
            AudioPlaybackController audioPlaybackController2 = this.playbackController;
            if (audioPlaybackController2 != null) {
                audioPlaybackController2.toggle();
            }
            AudioRecordingController audioRecordingController2 = this.recordingController;
            if (audioRecordingController2 != null) {
                audioRecordingController2.toggle();
            }
        }
    }

    public void removeOnAudioInspectorLifecycleListener(AudioInspectorLifecycleListener audioInspectorLifecycleListener) {
        uw.a(audioInspectorLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.lifecycleListeners.b(audioInspectorLifecycleListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            prepareViews();
        }
    }

    public void show(boolean z) {
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        prepareViews();
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(z ? 250L : 0L).setStartDelay(z ? 100L : 0L).withStartAction(new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$0();
            }
        }).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$1();
            }
        });
    }

    public void unbindController() {
        unbindController(true);
    }

    private void unbindController(boolean z) {
        if (z) {
            hide(true);
        }
        AudioPlaybackController audioPlaybackController = this.playbackController;
        if (audioPlaybackController != null) {
            audioPlaybackController.removeAudioPlaybackListener(this.playbackListeners);
            this.playbackController.getAudioModeManager().removeAudioPlaybackModeChangeListener(this.playbackListeners);
            this.playbackController = null;
            setMediaVolumeControlEnabled(false);
        }
        AudioRecordingController audioRecordingController = this.recordingController;
        if (audioRecordingController != null) {
            audioRecordingController.removeAudioRecordingListener(this.recordingListeners);
            this.recordingController.getAudioModeManager().removeAudioRecordingModeChangeListener(this.recordingListeners);
            this.recordingController = null;
        }
    }

    public void bindController(AudioRecordingController audioRecordingController) {
        prepareViews();
        AudioRecordingController audioRecordingController2 = this.recordingController;
        if (audioRecordingController2 == audioRecordingController) {
            return;
        }
        if (this.playbackController != null || audioRecordingController2 != null) {
            unbindController(false);
        }
        this.recordingController = audioRecordingController;
        audioRecordingController.addAudioRecordingListener(this.recordingListeners);
        audioRecordingController.getAudioModeManager().addAudioRecordingModeChangeListener(this.recordingListeners);
        refresh();
        show(true);
    }

    public AudioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lifecycleListeners = new go<>();
        this.playbackListeners = new PlaybackListeners();
        this.recordingListeners = new RecordingListeners();
        this.isDisplayed = false;
        this.loadingState = LoadingState.READY;
        this.isInProgress = false;
        this.isUserSeeking = false;
        this.updateProgressRunnable = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        init();
    }

    public AudioView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lifecycleListeners = new go<>();
        this.playbackListeners = new PlaybackListeners();
        this.recordingListeners = new RecordingListeners();
        this.isDisplayed = false;
        this.loadingState = LoadingState.READY;
        this.isInProgress = false;
        this.isUserSeeking = false;
        this.updateProgressRunnable = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        init();
    }

    public AudioView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lifecycleListeners = new go<>();
        this.playbackListeners = new PlaybackListeners();
        this.recordingListeners = new RecordingListeners();
        this.isDisplayed = false;
        this.loadingState = LoadingState.READY;
        this.isInProgress = false;
        this.isUserSeeking = false;
        this.updateProgressRunnable = new Runnable() { // from class: com.pspdfkit.ui.audio.AudioView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        init();
    }
}
