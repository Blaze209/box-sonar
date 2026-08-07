package com.eclipsesource.json;

/* JADX INFO: loaded from: classes13.dex */
public class Location {
    public final int column;
    public final int line;
    public final int offset;

    Location(int i, int i2, int i3) {
        this.offset = i;
        this.column = i3;
        this.line = i2;
    }

    public String toString() {
        return this.line + ":" + this.column;
    }

    public int hashCode() {
        return this.offset;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Location location = (Location) obj;
        return this.offset == location.offset && this.column == location.column && this.line == location.line;
    }
}
