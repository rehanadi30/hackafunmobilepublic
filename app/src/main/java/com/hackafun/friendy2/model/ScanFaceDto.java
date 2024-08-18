package com.hackafun.friendy2.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScanFaceDto {
    private String imageBase64;

    // Constructor
    public ScanFaceDto(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    // Getter and Setter
    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    // Method to decode the base64 string and save the image
    public void saveImage(Context context) {
        if (imageBase64 == null || imageBase64.isEmpty()) {
            return;
        }

        // Decode the base64 string to a byte array
        byte[] imageBytes = Base64.decode(imageBase64, Base64.DEFAULT);

        // Convert byte array to Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        if (bitmap == null) {
            return;
        }

        // Save Bitmap to file
        File imageFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "saved_image.jpg");

        try (FileOutputStream out = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
