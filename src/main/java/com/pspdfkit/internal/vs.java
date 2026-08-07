package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class vs {
    public final Toolbar a;

    public interface a {
        void a();

        void a(js.a aVar);
    }

    public vs(Toolbar toolbar, final ws wsVar) {
        toolbar.getClass();
        this.a = toolbar;
        toolbar.inflateMenu(R.menu.pspdf__menu_note_annotation_editor_toolbar);
        Drawable navigationIcon = toolbar.getNavigationIcon();
        navigationIcon = navigationIcon == null ? ContextCompat.getDrawable(toolbar.getContext(), R.drawable.pspdf__ic_arrow_back) : navigationIcon;
        navigationIcon.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(navigationIcon);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, -1);
        toolbar.setNavigationIcon(drawableWrap);
        toolbar.setElevation(toolbar.getResources().getDimension(R.dimen.pspdf__toolbar_elevation));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.vs$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                vs.a(wsVar, view);
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.pspdfkit.internal.vs$$ExternalSyntheticLambda1
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return vs.a(wsVar, menuItem);
            }
        });
        Context context = toolbar.getContext();
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__NoteEditorToolbarIcons, R.attr.pspdf__noteEditorToolbarIconsStyle, R.style.PSPDFKit_NoteEditorToolbarIcons);
        typedArrayObtainStyledAttributes.getClass();
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__NoteEditorToolbarIcons_pspdf__undoIcon, R.drawable.pspdf__ic_undo);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__NoteEditorToolbarIcons_pspdf__redoIcon, R.drawable.pspdf__ic_redo);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__NoteEditorToolbarIcons_pspdf__deleteIcon, R.drawable.pspdf__ic_delete);
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawableA = a80.a(context, resourceId, -1);
        Drawable drawableA2 = a80.a(context, resourceId2, -1);
        Drawable drawableA3 = a80.a(context, resourceId3, -1);
        MenuItem menuItemA = a(js.a.UNDO);
        if (menuItemA != null) {
            menuItemA.setIcon(drawableA);
        }
        MenuItem menuItemA2 = a(js.a.REDO);
        if (menuItemA2 != null) {
            menuItemA2.setIcon(drawableA2);
        }
        MenuItem menuItemA3 = a(js.a.DELETE);
        if (menuItemA3 != null) {
            menuItemA3.setIcon(drawableA3);
        }
    }

    public static final void a(a aVar, View view) {
        aVar.a();
    }

    public static final boolean a(a aVar, MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        int itemId = menuItem.getItemId();
        if (itemId == R.id.pspdf__note_editor_toolbar_item_undo) {
            aVar.a(js.a.UNDO);
            return true;
        }
        if (itemId == R.id.pspdf__note_editor_toolbar_item_redo) {
            aVar.a(js.a.REDO);
            return true;
        }
        if (itemId != R.id.pspdf__note_editor_toolbar_item_delete) {
            return true;
        }
        aVar.a(js.a.DELETE);
        return true;
    }

    public final MenuItem a(js.a aVar) {
        Menu menu = this.a.getMenu();
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return menu.findItem(R.id.pspdf__note_editor_toolbar_item_undo);
        }
        if (iOrdinal == 1) {
            return menu.findItem(R.id.pspdf__note_editor_toolbar_item_redo);
        }
        if (iOrdinal == 2) {
            return menu.findItem(R.id.pspdf__note_editor_toolbar_item_delete);
        }
        throw new NoWhenBranchMatchedException();
    }
}
