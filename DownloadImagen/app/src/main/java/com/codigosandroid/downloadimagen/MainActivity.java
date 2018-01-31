package com.codigosandroid.downloadimagen;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://receitaparaganhar.com/wp-content/uploads/2015/03/android-logo.png";
    private ImageView imagem;
    private Handler handler = new Handler();
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        progress = ProgressDialog.show(this, "Download Imagem",
                "Buscando imagem, por favor agurade...", false, true);
        downloadImagem(URL);
    }

    private void inicializar() {
        imagem = (ImageView) findViewById(R.id.imagem);
    }

    // Faz o download a imagem em uma nova Thread
    private void downloadImagem(final String urlImagem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Faz o download da imagem
                    java.net.URL url = new URL(urlImagem);
                    InputStream in = url.openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(in);
                    in.close();
                    // Atualiza a tela
                    atualizarTela(bitmap);
                } catch (MalformedURLException e) {
                    // Numa aplicação real esta exceção deve ser tratada.
                    e.printStackTrace();
                } catch (IOException e) {
                    // Numa aplicação real esta exceção deve ser tratada.
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void atualizarTela(final Bitmap bitmap) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();
                imagem.setImageBitmap(bitmap);
            }
        });
    }

}
