package com.example.neo_layout;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ho_Ten_MSV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ho_ten_msv);
        Button btndk = findViewById(R.id.btnDangky);
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText nguoidung = findViewById(R.id.username);
                EditText matkhau = findViewById(R.id.password);
                String username = nguoidung.getText().toString();
                String password = matkhau.getText().toString();


                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Ho_Ten_MSV.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Hiển thị thông tin bằng AlertDialog
                    new AlertDialog.Builder(Ho_Ten_MSV.this)
                            .setTitle("Bạn đã đăng ký thành công")
                            .setMessage("Tên đăng nhập: " + username + "\nMật khẩu: " + password)
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                }
            }
        });




        // Tìm button Đăng nhập từ layout
        Button btnThoat = findViewById(R.id.btnThoat);

        // Xử lý sự kiện khi bấm nút
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang SecondActivity
                Intent intent = new Intent(Ho_Ten_MSV.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}