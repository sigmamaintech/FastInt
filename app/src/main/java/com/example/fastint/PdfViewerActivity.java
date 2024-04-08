package com.example.fastint;

import android.app.Activity;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.core.content.FileProvider;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.storage.FileDownloadTask;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

import java.io.File;

public class PdfViewerActivity extends Activity {

    //    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Установите макет для вашей активности, если это необходимо
//
//        // Инициализируйте Firebase Storage
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageRef = storage.getReference();
//        StorageReference pdfRef = storageRef.child("Library/Algorithms/AlgSort/" + AlgorithmAdapter.FileName);
//
//        // Создайте локальный файл для сохранения PDF
//        final File localFile = new File(getExternalFilesDir(null), "downloaded_pdf.pdf");
//
//        pdfRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                // Файл успешно загружен и сохранен локально
//                openPdf(localFile);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Обработка ошибок
//                Toast.makeText(PdfViewerActivity.this, "Ошибка загрузки файла: " + exception.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    private void openPdf(File file) {
//        // Получите URI для файла с использованием FileProvider
//        Uri uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
//        // Создайте намерение для открытия PDF-файла
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(uri, "application/pdf");
//        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        startActivity(intent);
//    }
}