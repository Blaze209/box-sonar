package com.pspdfkit.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.R;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.internal.annotations.note.ui.NoteReplyStatusDialogView;
import com.pspdfkit.ui.AnnotationCreatorInputDialogFragment;
import com.pspdfkit.ui.toolbar.ToolbarExtKt;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ws extends LinearLayout implements js, vs.a {
    public final qs a;
    public final Toolbar b;
    public final RecyclerView c;
    public final vs d;
    public FragmentManager e;
    public is f;
    public b g;
    public a h;
    public Parcelable i;

    public interface a {
        void dismiss();
    }

    public interface b {
        void setStatusBarColor(int i);
    }

    public static final class c extends View.BaseSavedState implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public final Parcelable a;
        public final Parcelable b;

        public static final class a implements Parcelable.Creator<c> {
            @Override // android.os.Parcelable.Creator
            public final c createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new c(parcel.readParcelable(c.class.getClassLoader()), parcel.readParcelable(c.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            public final c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcelable parcelable, Parcelable parcelable2) {
            super(parcelable);
            this.a = parcelable;
            this.b = parcelable2;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.getClass();
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
        }
    }

    public static final class d implements AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener {
        public final /* synthetic */ Runnable a;

        public d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAbort() {
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAnnotationCreatorSet(String str) {
            str.getClass();
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws(Context context) {
        super(context, null, 0, 0);
        context.getClass();
        qs qsVar = new qs(context);
        this.a = qsVar;
        setFocusable(true);
        setFocusableInTouchMode(true);
        View.inflate(context, R.layout.pspdf__note_editor_layout, this);
        setOrientation(1);
        View viewFindViewById = findViewById(R.id.pspdf__note_editor_toolbar);
        viewFindViewById.getClass();
        Toolbar toolbar = (Toolbar) viewFindViewById;
        this.b = toolbar;
        ToolbarExtKt.applyWindowInsets$default(toolbar, false, true, false, false, 13, null);
        this.d = new vs(toolbar, this);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__NoteEditorView, R.attr.pspdf__noteEditorStyle, R.style.PSPDFKit_NoteEditorView);
        typedArrayObtainStyledAttributes.getClass();
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__noteBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__notePrimaryTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__noteSecondaryTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NoteEditorView_pspdf__commentColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        typedArrayObtainStyledAttributes.recycle();
        View viewFindViewById2 = findViewById(R.id.pspdf__note_editor_recycler_view);
        viewFindViewById2.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        this.c = recyclerView;
        recyclerView.setBackgroundColor(color);
        recyclerView.setVisibility(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new ss());
        recyclerView.setAdapter(qsVar);
    }

    @Override // com.pspdfkit.internal.js
    public final void a(int i, boolean z) {
        Toolbar toolbar = this.d.a;
        if (z) {
            a80.a(toolbar, new ColorDrawable(i));
        } else {
            toolbar.setBackgroundColor(i);
        }
    }

    @Override // com.pspdfkit.internal.fs
    public final void b(ds dsVar) {
        dsVar.getClass();
        this.a.b(dsVar);
    }

    @Override // com.pspdfkit.internal.fs
    public final void c(ds dsVar) {
        qs qsVar = this.a;
        qsVar.c.add(dsVar);
        qsVar.g = dsVar;
        qsVar.notifyItemInserted(qsVar.c.size() + (qsVar.e ? 1 : 0));
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView.ViewHolder childViewHolder = this.c.getChildViewHolder(this.c.getChildAt(i));
            if (childViewHolder instanceof ea) {
                ea eaVar = (ea) childViewHolder;
                eaVar.d.clearFocus();
                hn.c(eaVar.d);
            }
        }
        this.c.smoothScrollToPosition(this.a.getItemCount() - 1);
    }

    @Override // com.pspdfkit.internal.fs
    public final void d() {
        this.a.d();
    }

    @Override // com.pspdfkit.internal.js
    public final void e() {
        MAMAlertDialogBuilder mAMAlertDialogBuilder = new MAMAlertDialogBuilder(getContext());
        mAMAlertDialogBuilder.setTitle(no.a(getContext(), R.string.pspdf__delete, null));
        mAMAlertDialogBuilder.setMessage(no.a(getContext(), R.string.pspdf__prompt_delete_annotation, null));
        mAMAlertDialogBuilder.setPositiveButton(no.a(getContext(), R.string.pspdf__ok, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.ws$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ws.a(this.f$0, dialogInterface, i);
            }
        });
        mAMAlertDialogBuilder.setNegativeButton(no.a(getContext(), R.string.pspdf__cancel, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.ws$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ws.a(dialogInterface, i);
            }
        });
        mAMAlertDialogBuilder.show();
    }

    @Override // com.pspdfkit.internal.js
    public final void f() {
        hn.c(this);
        a aVar = this.h;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    @Override // com.pspdfkit.internal.js
    public final void finishEditing() {
        hn.c(this);
    }

    @Override // com.pspdfkit.internal.fs
    public final boolean g() {
        return this.a.b.c;
    }

    @Override // com.pspdfkit.internal.fs
    public List<ds> getNoteEditorContentCards() {
        return this.a.c;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.a);
        this.i = cVar.b;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        RecyclerView.LayoutManager layoutManager = this.c.getLayoutManager();
        return new c(parcelableOnSaveInstanceState, layoutManager != null ? layoutManager.onSaveInstanceState() : null);
    }

    @Override // com.pspdfkit.internal.fs
    public void setAddNewReplyBoxDisplayed(boolean z) {
        this.a.setAddNewReplyBoxDisplayed(z);
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        fragmentManager.getClass();
        this.e = fragmentManager;
    }

    public final void setOnDismissViewListener(a aVar) {
        this.h = aVar;
    }

    @Override // com.pspdfkit.internal.js
    public void setPresenter(is isVar) {
        if (isVar == null) {
            requestFocus();
        }
        this.f = isVar;
        this.a.h = isVar;
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    @Override // com.pspdfkit.internal.js
    public void setStatusBarColor(int i) {
        b bVar = this.g;
        if (bVar != null) {
            bVar.setStatusBarColor(i);
        }
    }

    public final void setStatusBarColorCallback(b bVar) {
        this.g = bVar;
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxDisplayed(boolean z) {
        this.a.e = z;
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxExpanded(boolean z) {
        qs qsVar = this.a;
        qsVar.b.c = z;
        qsVar.a();
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxPickerColors(List<Integer> list) {
        list.getClass();
        this.a.setStyleBoxPickerColors(list);
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxPickerIcons(List<String> list) {
        list.getClass();
        this.a.setStyleBoxPickerIcons(list);
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxSelectedColor(int i) {
        qs qsVar = this.a;
        qsVar.b.f = Integer.valueOf(i);
        qsVar.a();
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxSelectedIcon(String str) {
        this.a.setStyleBoxSelectedIcon(str);
    }

    public void setStyleBoxText(String str) {
        str.getClass();
        qs qsVar = this.a;
        qsVar.getClass();
        us usVar = qsVar.b;
        usVar.getClass();
        usVar.e = str;
        qsVar.a();
    }

    @Override // com.pspdfkit.internal.js
    public void setToolbarForegroundColor(int i) {
        vs vsVar = this.d;
        Drawable navigationIcon = vsVar.a.getNavigationIcon();
        if (navigationIcon != null) {
            Drawable drawableWrap = DrawableCompat.wrap(navigationIcon);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, i);
            vsVar.a.setNavigationIcon(navigationIcon);
        }
        MenuItem menuItemA = vsVar.a(js.a.UNDO);
        if (menuItemA != null) {
            Drawable icon = menuItemA.getIcon();
            icon.getClass();
            Drawable drawableWrap2 = DrawableCompat.wrap(icon);
            drawableWrap2.getClass();
            DrawableCompat.setTint(drawableWrap2, i);
            menuItemA.setIcon(drawableWrap2);
        }
        MenuItem menuItemA2 = vsVar.a(js.a.REDO);
        if (menuItemA2 != null) {
            Drawable icon2 = menuItemA2.getIcon();
            icon2.getClass();
            Drawable drawableWrap3 = DrawableCompat.wrap(icon2);
            drawableWrap3.getClass();
            DrawableCompat.setTint(drawableWrap3, i);
            menuItemA2.setIcon(drawableWrap3);
        }
        MenuItem menuItemA3 = vsVar.a(js.a.DELETE);
        if (menuItemA3 != null) {
            Drawable icon3 = menuItemA3.getIcon();
            icon3.getClass();
            Drawable drawableWrap4 = DrawableCompat.wrap(icon3);
            drawableWrap4.getClass();
            DrawableCompat.setTint(drawableWrap4, i);
            menuItemA3.setIcon(drawableWrap4);
        }
        vsVar.a.setTitleTextColor(i);
    }

    @Override // com.pspdfkit.internal.js
    public void setToolbarTitle(String str) {
        this.d.a.setTitle(str);
    }

    public static final void b(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    @Override // com.pspdfkit.internal.fs
    public final void d(ds dsVar) {
        dsVar.getClass();
        this.a.d(dsVar);
    }

    @Override // com.pspdfkit.internal.js
    public final void b() {
        hn.c(this);
    }

    @Override // com.pspdfkit.internal.js
    public final void b(int i, boolean z) {
        if (z) {
            a80.a(this, new ColorDrawable(i));
        } else {
            setBackgroundColor(i);
        }
    }

    public void setToolbarTitle(int i) {
        this.d.a.setTitle(i);
    }

    @Override // com.pspdfkit.internal.fs
    public void setStyleBoxText(int i) {
        this.a.setStyleBoxText(i);
    }

    @Override // com.pspdfkit.internal.js
    public final void c() {
        if (this.c.findFocus() instanceof EditText) {
            requestFocus();
        }
    }

    @Override // com.pspdfkit.internal.js
    public final void a(boolean z) {
        Drawable icon;
        js.a aVar = js.a.DELETE;
        vs vsVar = this.d;
        vsVar.getClass();
        MenuItem menuItemA = vsVar.a(aVar);
        if (menuItemA == null || (icon = menuItemA.getIcon()) == null) {
            return;
        }
        icon.setAlpha(z ? 255 : 100);
        menuItemA.setEnabled(z);
        menuItemA.setIcon(icon);
    }

    @Override // com.pspdfkit.internal.fs
    public final void a(List<? extends ds> list, boolean z) {
        list.getClass();
        this.a.a(list, z);
    }

    @Override // com.pspdfkit.internal.vs.a
    public final void a() {
        is isVar = this.f;
        if (isVar != null) {
            isVar.a();
        }
    }

    @Override // com.pspdfkit.internal.vs.a
    public final void a(js.a aVar) {
        is isVar = this.f;
        if (isVar != null) {
            isVar.a(aVar);
        }
    }

    @Override // com.pspdfkit.internal.js
    public final void a(String str) {
        DocumentSharingManager.shareText(getContext(), str);
    }

    @Override // com.pspdfkit.internal.js
    public final void a(final ds dsVar) {
        dsVar.getClass();
        MAMAlertDialogBuilder mAMAlertDialogBuilder = new MAMAlertDialogBuilder(getContext());
        mAMAlertDialogBuilder.setTitle(no.a(getContext(), R.string.pspdf__set_reply_status, null));
        mAMAlertDialogBuilder.setNegativeButton(no.a(getContext(), R.string.pspdf__cancel, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.ws$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ws.b(dialogInterface, i);
            }
        });
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__note_editor_set_status_dialog_layout, (ViewGroup) null);
        NoteReplyStatusDialogView noteReplyStatusDialogView = (NoteReplyStatusDialogView) viewInflate.findViewById(R.id.pspdf__note_reply_status_dialog_list_view);
        noteReplyStatusDialogView.setItems(fs.b.d);
        mAMAlertDialogBuilder.setView(viewInflate);
        final AlertDialog alertDialogShow = mAMAlertDialogBuilder.show();
        noteReplyStatusDialogView.setOnReviewStateSelectedListener(new NoteReplyStatusDialogView.b() { // from class: com.pspdfkit.internal.ws$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.internal.annotations.note.ui.NoteReplyStatusDialogView.b
            public final void a(fs.b bVar) {
                ws.a(this.f$0, dsVar, alertDialogShow, bVar);
            }
        });
    }

    public static final void a(ws wsVar, ds dsVar, AlertDialog alertDialog, fs.b bVar) {
        bVar.getClass();
        is isVar = wsVar.f;
        if (isVar != null) {
            isVar.a(dsVar, bVar);
        }
        alertDialog.dismiss();
    }

    public static final void a(ws wsVar, DialogInterface dialogInterface, int i) {
        is isVar = wsVar.f;
        if (isVar != null) {
            isVar.f();
        }
    }

    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    @Override // com.pspdfkit.internal.js
    public final void a(Runnable runnable) {
        FragmentManager fragmentManager = this.e;
        if (fragmentManager != null) {
            AnnotationCreatorInputDialogFragment.show(fragmentManager, null, new d(runnable));
        }
    }
}
