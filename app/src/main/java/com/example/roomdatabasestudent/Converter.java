package com.example.roomdatabasestudent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class Converter {

    //date
    @TypeConverter
    public long toLong(Date date) {
        return date.getTime();
    }

    @TypeConverter
    public Date toDate(long date) {
        return new Date(date);
    }

    //bitmap
    @TypeConverter
    public static byte[] getBitmapTypeArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();
    }

    @TypeConverter
    public static Bitmap getByteAsBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
