package com.codigosandroid.exemplointent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.codigosandroid.utils.activity.BaseActivity;
import com.codigosandroid.utils.utils.AlertUtil;
import com.codigosandroid.utils.utils.PermissionUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String ABRIR_TELA = "com.codigosandroid.exemplointent.ABRIR_TELA";
    private String[] permissions = new String[]{
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Bundle params = data != null ? data.getExtras() : null;
            String msg = params.getString("msg");
            if (resultCode == 1) {
                toast(msg);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        Uri uri = null;
        switch (v.getId()) {
            case R.id.btn_abrir_tela:
                intent = new Intent(this, TelaExemplo.class);
                startActivity(intent);
                break;
            case R.id.btn_abrir_tela_2:
                intent = new Intent(ABRIR_TELA);
                startActivity(intent);
                break;
            case R.id.btn_abrir_tela_3:
                intent = new Intent(ABRIR_TELA);
                startActivityForResult(intent, 1);
                break;
            case R.id.btn_abrir_browser:
                uri = Uri.parse("http://www.google.com.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btn_ver_contato_agenda:
                uri = Uri.parse("content://com.android.contacts/contacts/1");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btn_ver_agenda:
                uri = Uri.parse("content://com.android.contacts/contacts");
                intent = new Intent(Intent.ACTION_PICK, uri);
                startActivity(intent);
                break;
            case R.id.btn_fazer_chamada:
                if (PermissionUtil.validade(this, 1, permissions)) {
                    uri = Uri.parse("tel:66778899");
                    intent = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                /* Negou a permissão. Mostra alerta e fecha */
                AlertUtil.alert(this, getString(R.string.app_name), getString(R.string.msg_alerta_permissao));
            } else if (PermissionUtil.checkPermission(this, Manifest.permission.CALL_PHONE)) {
                Uri uri = Uri.parse("tel:66778899");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        }
    }

    // Inicializa componentes
    private void inicializar() {
        findViewById(R.id.btn_abrir_tela).setOnClickListener(this);
        findViewById(R.id.btn_abrir_tela_2).setOnClickListener(this);
        findViewById(R.id.btn_abrir_tela_3).setOnClickListener(this);
        findViewById(R.id.btn_abrir_browser).setOnClickListener(this);
        findViewById(R.id.btn_ver_contato_agenda).setOnClickListener(this);
        findViewById(R.id.btn_ver_agenda).setOnClickListener(this);
        findViewById(R.id.btn_fazer_chamada).setOnClickListener(this);
    }

}
