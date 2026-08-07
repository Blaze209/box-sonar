package com.tokenautocomplete;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CharacterTokenizer implements Tokenizer {
    public static final Parcelable.Creator<CharacterTokenizer> CREATOR = new Parcelable.Creator<CharacterTokenizer>() { // from class: com.tokenautocomplete.CharacterTokenizer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterTokenizer createFromParcel(Parcel parcel) {
            return new CharacterTokenizer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterTokenizer[] newArray(int i) {
            return new CharacterTokenizer[i];
        }
    };
    private ArrayList<Character> splitChar;
    private String tokenTerminator;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharacterTokenizer(List<Character> list, String str) {
        this.splitChar = new ArrayList<>(list);
        this.tokenTerminator = str;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public boolean containsTokenTerminator(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (this.splitChar.contains(Character.valueOf(charSequence.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public List<Range> findTokenRanges(CharSequence charSequence, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i != i2) {
            int i3 = i;
            while (i < i2) {
                char cCharAt = charSequence.charAt(i);
                if (i3 == i && Character.isWhitespace(cCharAt)) {
                    i3 = i + 1;
                }
                if (this.splitChar.contains(Character.valueOf(cCharAt)) || i == i2 - 1) {
                    if (i > i3 || (i == i3 && !this.splitChar.contains(Character.valueOf(cCharAt)))) {
                        arrayList.add(new Range(i3, i + 1));
                    }
                    i3 = i + 1;
                }
                i++;
            }
        }
        return arrayList;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public CharSequence wrapTokenValue(CharSequence charSequence) {
        String str = ((Object) charSequence) + this.tokenTerminator;
        if (!(charSequence instanceof Spanned)) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
        return spannableString;
    }

    CharacterTokenizer(Parcel parcel) {
        this(parcel.readArrayList(Character.class.getClassLoader()), parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.splitChar);
        parcel.writeString(this.tokenTerminator);
    }
}
