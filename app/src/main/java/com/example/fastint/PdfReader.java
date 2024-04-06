package com.example.fastint;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;

import java.io.File;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PdfReader {
//    FirebaseStorage storage = FirebaseStorage.getInstance();
//    StorageReference storageRef = storage.getReference();
//    StorageReference pdfRef = storageRef.child("path_to_your_pdf_file.pdf");
//
//    pdfRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                // Полученный URI можно использовать для чтения файла
//                openPdf(uri);
//            }
//    }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Обработка ошибок, например, файл не найден
//            }
//    });
//    private void openPdfInternal(Uri pdfUri) {
//        PDFView pdfView = findViewById(R.id.pdfView); // Убедитесь, что у вас есть PDFView в вашем макете
//        FileLoader.with(this)
//                .load(pdfUri)
//                .asFile(new FileRequestListener<File>() {
//                    @Override
//                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
//                        File pdfFile = response.getBody();
//                        pdfView.fromFile(pdfFile).load();
//                    }
//
//                    @Override
//                    public void onError(FileLoadRequest request, Throwable t) {
//                        // Обработка ошибок
//                    }
//                });
//    }


}
