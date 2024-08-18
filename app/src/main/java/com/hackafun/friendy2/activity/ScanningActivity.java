package com.hackafun.friendy2.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.google.common.util.concurrent.ListenableFuture;
import com.hackafun.friendy2.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ScanningActivity extends AppCompatActivity {

    private PreviewView previewView;
    private Button captureButton;
    private Button retakeButton;
    private ImageCapture imageCapture;
    private File imageFile;

    private static final int REQUEST_CAMERA_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);

        previewView = findViewById(R.id.preview_view);
        captureButton = findViewById(R.id.capture_button);
        retakeButton = findViewById(R.id.retake_button);

        startCamera();

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
            }
        });

        retakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCamera();
                retakeButton.setVisibility(View.GONE);
                captureButton.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, start camera
                startCamera();
            } else {
                // Permission denied
                Toast.makeText(this, "Camera permission is required to use this feature", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void startCamera() {
        final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                Preview preview = new Preview.Builder().build();
                imageCapture = new ImageCapture.Builder().build();

                preview.setSurfaceProvider(previewView.getSurfaceProvider());

                cameraProvider.unbindAll();
                cameraProvider.bindToLifecycle(ScanningActivity.this, CameraSelector.DEFAULT_BACK_CAMERA, preview, imageCapture);

                Log.d("ScanningActivity", "Camera started successfully");

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void captureImage() {
        if (imageCapture != null) {
            File photoFile = new File(getExternalFilesDir(null), "photo.jpg");
            Log.d("ScanningActivity", "Photo file path: " + photoFile.getAbsolutePath());

            ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(photoFile).build();

            Log.d("ScanningActivity", "masuk sini");
            imageCapture.takePicture(outputFileOptions, ContextCompat.getMainExecutor(this), new ImageCapture.OnImageSavedCallback() {
                @Override
                public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                    Log.d("ScanningActivity", "Image saved successfully");
                    imageFile = photoFile;
                    captureButton.setVisibility(View.GONE);
                    retakeButton.setVisibility(View.VISIBLE);
                    Toast.makeText(ScanningActivity.this, "Image captured", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ScanningActivity.this, ResultActivity.class);
                    intent.putExtra("imageUri", Uri.fromFile(imageFile).toString());
                    startActivity(intent);
                }

                @Override
                public void onError(@NonNull ImageCaptureException exception) {
                    Log.e("ScanningActivity", "Failed to capture image", exception);
                    Toast.makeText(ScanningActivity.this, "Failed to capture image", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
