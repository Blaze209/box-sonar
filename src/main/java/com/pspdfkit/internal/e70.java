package com.pspdfkit.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.box.android.base.presentation.components.commentbar.TimestampUtil;
import com.box.android.domain.configuration.UserSessionInfo;
import com.pspdfkit.R;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class e70 extends FrameLayout {
    public final StringBuilder a;
    public final Formatter b;
    public final String c;
    public boolean d;
    public g e;
    public final Context f;
    public final ProgressBar g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final AppCompatImageButton n;
    public final AppCompatImageButton o;
    public final View p;
    public final ViewGroup q;
    public final ViewGroup r;
    public final View s;
    public final View t;
    public final View u;
    public final a v;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            g gVar;
            switch (message.what) {
                case 1:
                    e70.this.a();
                    break;
                case 2:
                    int iB = e70.this.b();
                    e70 e70Var = e70.this;
                    if (!e70Var.l && e70Var.k && (gVar = e70Var.e) != null && ((f70) gVar).b()) {
                        sendMessageDelayed(obtainMessage(2), 1000 - (iB % 1000));
                        break;
                    }
                    break;
                case 3:
                    e70.this.a(3000);
                    e70.this.b(R.id.pspdf__loading_layout);
                    break;
                case 4:
                case 6:
                case 8:
                    e70.this.a();
                    e70 e70Var2 = e70.this;
                    if (e70Var2.u.getVisibility() == 0) {
                        e70Var2.u.setVisibility(8);
                    }
                    if (e70Var2.r.getVisibility() == 0) {
                        e70Var2.r.setVisibility(8);
                    }
                    if (e70Var2.q.getVisibility() == 0) {
                        e70Var2.q.setVisibility(8);
                    }
                    break;
                case 5:
                    e70.this.a(3000);
                    e70.this.b(R.id.pspdf__error_layout);
                    break;
                case 7:
                    e70.this.b(R.id.pspdf__center_play_btn);
                    break;
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e70 e70Var = e70.this;
            g gVar = e70Var.e;
            if (gVar != null) {
                boolean zB = ((f70) gVar).b();
                g gVar2 = e70Var.e;
                if (zB) {
                    ((f70) gVar2).d();
                } else {
                    ((f70) gVar2).e();
                }
                e70Var.c();
                e70.this.a(3000);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e70 e70Var = e70.this;
            boolean z = e70Var.m;
            e70Var.m = !z;
            AppCompatImageButton appCompatImageButton = e70Var.o;
            if (z) {
                appCompatImageButton.setImageResource(R.drawable.pspdf__uvv_player_scale_btn);
            } else {
                appCompatImageButton.setImageResource(R.drawable.pspdf__uvv_player_scale_out_btn);
            }
            e70 e70Var2 = e70.this;
            e70Var2.p.setVisibility(e70Var2.m ? 0 : 4);
            e70 e70Var3 = e70.this;
            ((f70) e70Var3.e).setFullscreen(e70Var3.m);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e70 e70Var = e70.this;
            if (e70Var.m) {
                e70Var.m = false;
                e70Var.o.setImageResource(R.drawable.pspdf__uvv_player_scale_btn);
                e70 e70Var2 = e70.this;
                e70Var2.p.setVisibility(e70Var2.m ? 0 : 4);
                ((f70) e70.this.e).setFullscreen(false);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e70 e70Var = e70.this;
            if (e70Var.u.getVisibility() == 0) {
                e70Var.u.setVisibility(8);
            }
            if (e70Var.r.getVisibility() == 0) {
                e70Var.r.setVisibility(8);
            }
            if (e70Var.q.getVisibility() == 0) {
                e70Var.q.setVisibility(8);
            }
            ((f70) e70.this.e).e();
        }
    }

    public class f implements SeekBar.OnSeekBarChangeListener {
        public int a = 0;
        public boolean b = false;

        public f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            g gVar = e70.this.e;
            if (gVar == null || !z) {
                return;
            }
            this.a = (int) ((((long) ((f70) gVar).getDuration()) * ((long) i)) / 1000);
            this.b = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            e70 e70Var = e70.this;
            if (e70Var.e == null) {
                return;
            }
            e70Var.a(UserSessionInfo.ONE_HOUR_MS);
            e70 e70Var2 = e70.this;
            e70Var2.l = true;
            e70Var2.v.removeMessages(2);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            g gVar = e70.this.e;
            if (gVar == null) {
                return;
            }
            if (this.b) {
                ((f70) gVar).b(this.a);
                e70 e70Var = e70.this;
                TextView textView = e70Var.i;
                if (textView != null) {
                    textView.setText(e70Var.c(this.a));
                }
            }
            e70 e70Var2 = e70.this;
            e70Var2.l = false;
            e70Var2.b();
            e70.this.c();
            e70.this.a(3000);
            e70 e70Var3 = e70.this;
            e70Var3.k = true;
            e70Var3.v.sendEmptyMessage(2);
        }
    }

    public interface g {
    }

    public e70(Context context) {
        super(context);
        this.d = false;
        this.k = true;
        this.m = false;
        this.v = new a();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.pspdfkit.internal.e70$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.a(view, motionEvent);
            }
        };
        b bVar = new b();
        new c();
        d dVar = new d();
        e eVar = new e();
        f fVar = new f();
        this.f = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pspdf__uvv_player_controller, this);
        viewInflate.setOnTouchListener(onTouchListener);
        this.s = viewInflate.findViewById(R.id.pspdf__title_part);
        this.t = viewInflate.findViewById(R.id.pspdf__control_layout);
        this.q = (ViewGroup) viewInflate.findViewById(R.id.pspdf__loading_layout);
        this.r = (ViewGroup) viewInflate.findViewById(R.id.pspdf__error_layout);
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) viewInflate.findViewById(R.id.pspdf__turn_button);
        this.n = appCompatImageButton;
        AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) viewInflate.findViewById(R.id.pspdf__scale_button);
        this.o = appCompatImageButton2;
        View viewFindViewById = viewInflate.findViewById(R.id.pspdf__center_play_btn);
        this.u = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.pspdf__back_btn);
        this.p = viewFindViewById2;
        if (appCompatImageButton != null) {
            appCompatImageButton.requestFocus();
            appCompatImageButton.setOnClickListener(bVar);
        }
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setVisibility(8);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(eVar);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(dVar);
        }
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.pspdf__seekbar);
        this.g = progressBar;
        if (progressBar != null) {
            if (progressBar instanceof SeekBar) {
                ((SeekBar) progressBar).setOnSeekBarChangeListener(fVar);
            }
            progressBar.setMax(1000);
        }
        StringBuilder sb = new StringBuilder();
        this.a = sb;
        this.b = new Formatter(sb, Locale.getDefault());
        String strC = c(0);
        this.c = strC;
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__duration);
        this.h = textView;
        textView.setText(strC);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.pspdf__has_played);
        this.i = textView2;
        textView2.setText(strC);
        this.j = (TextView) viewInflate.findViewById(R.id.pspdf__title);
    }

    public final /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !this.k) {
            return false;
        }
        a();
        this.d = true;
        return true;
    }

    public final void b(int i) {
        if (i == R.id.pspdf__loading_layout) {
            if (this.q.getVisibility() != 0) {
                this.q.setVisibility(0);
            }
            if (this.u.getVisibility() == 0) {
                this.u.setVisibility(8);
            }
            if (this.r.getVisibility() == 0) {
                this.r.setVisibility(8);
                return;
            }
            return;
        }
        if (i == R.id.pspdf__center_play_btn) {
            if (this.u.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            if (this.q.getVisibility() == 0) {
                this.q.setVisibility(8);
            }
            if (this.r.getVisibility() == 0) {
                this.r.setVisibility(8);
                return;
            }
            return;
        }
        if (i == R.id.pspdf__error_layout) {
            if (this.r.getVisibility() != 0) {
                this.r.setVisibility(0);
            }
            if (this.u.getVisibility() == 0) {
                this.u.setVisibility(8);
            }
            if (this.q.getVisibility() == 0) {
                this.q.setVisibility(8);
            }
        }
    }

    public final String c(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.a.setLength(0);
        Formatter formatter = this.b;
        return i5 > 0 ? formatter.format(TimestampUtil.DISPLAY_FORMAT_WITH_HOURS, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                boolean zB = ((f70) this.e).b();
                g gVar = this.e;
                if (zB) {
                    ((f70) gVar).d();
                } else {
                    ((f70) gVar).e();
                }
                c();
                a(3000);
                AppCompatImageButton appCompatImageButton = this.n;
                if (appCompatImageButton != null) {
                    appCompatImageButton.requestFocus();
                }
            }
            return true;
        }
        if (keyCode == 126) {
            if (z && !((f70) this.e).b()) {
                ((f70) this.e).e();
                c();
                a(3000);
            }
            return true;
        }
        if (keyCode == 86 || keyCode == 127) {
            if (z && ((f70) this.e).b()) {
                ((f70) this.e).d();
                c();
                a(3000);
            }
            return true;
        }
        if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode != 4 && keyCode != 82) {
            a(3000);
            return super.dispatchKeyEvent(keyEvent);
        }
        if (z) {
            a();
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.s == null || this.t == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int measuredHeight2 = this.s.getMeasuredHeight();
        int measuredHeight3 = this.t.getMeasuredHeight();
        if (measuredHeight <= 0 || measuredHeight >= measuredHeight2 + measuredHeight3) {
            return;
        }
        int i3 = measuredHeight / 2;
        this.s.getLayoutParams().height = i3;
        this.t.getLayoutParams().height = i3;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a(0);
            this.d = false;
        } else if (action != 1) {
            if (action == 3) {
                a();
            }
        } else if (!this.d) {
            super.performClick();
            a(3000);
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        a(3000);
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        a(3000);
        return true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        AppCompatImageButton appCompatImageButton = this.n;
        if (appCompatImageButton != null) {
            appCompatImageButton.setEnabled(z);
        }
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.setEnabled(z);
        }
        this.p.setEnabled(true);
    }

    public void setMediaPlayer(g gVar) {
        this.e = gVar;
        c();
    }

    public void setOnErrorView(int i) {
        this.r.removeAllViews();
        LayoutInflater.from(this.f).inflate(i, this.r, true);
    }

    public void setOnErrorViewClick(View.OnClickListener onClickListener) {
        this.r.setOnClickListener(onClickListener);
    }

    public void setOnLoadingView(int i) {
        this.q.removeAllViews();
        LayoutInflater.from(this.f).inflate(i, this.q, true);
    }

    public void setTitle(String str) {
        this.j.setText(str);
    }

    public void setOnErrorView(View view) {
        this.r.removeAllViews();
        this.r.addView(view);
    }

    public void setOnLoadingView(View view) {
        this.q.removeAllViews();
        this.q.addView(view);
    }

    public final void a(int i) {
        g gVar;
        if (!this.k) {
            b();
            AppCompatImageButton appCompatImageButton = this.n;
            if (appCompatImageButton != null) {
                appCompatImageButton.requestFocus();
            }
            try {
                AppCompatImageButton appCompatImageButton2 = this.n;
                if (appCompatImageButton2 != null && (gVar = this.e) != null && !((f70) gVar).x) {
                    appCompatImageButton2.setEnabled(false);
                }
            } catch (IncompatibleClassChangeError unused) {
            }
            this.k = true;
        }
        c();
        this.p.setVisibility(this.m ? 0 : 4);
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.s.getVisibility() != 0) {
            this.s.setVisibility(0);
        }
        if (this.t.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        this.v.sendEmptyMessage(2);
        Message messageObtainMessage = this.v.obtainMessage(1);
        if (i != 0) {
            this.v.removeMessages(1);
            this.v.sendMessageDelayed(messageObtainMessage, i);
        }
    }

    public final void c() {
        g gVar = this.e;
        if (gVar != null && ((f70) gVar).b()) {
            this.n.setImageResource(R.drawable.pspdf__uvv_stop_btn);
        } else {
            this.n.setImageResource(R.drawable.pspdf__uvv_player_player_btn);
        }
    }

    public final int b() {
        g gVar = this.e;
        if (gVar == null || this.l) {
            return 0;
        }
        int currentPosition = ((f70) gVar).getCurrentPosition();
        int duration = ((f70) this.e).getDuration();
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            if (duration > 0) {
                progressBar.setProgress((int) ((((long) currentPosition) * 1000) / ((long) duration)));
            }
            this.g.setSecondaryProgress(((f70) this.e).getBufferPercentage() * 10);
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(c(duration));
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setText(c(currentPosition));
        }
        return currentPosition;
    }

    public final void a() {
        if (this.k) {
            this.v.removeMessages(2);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.k = false;
        }
    }
}
