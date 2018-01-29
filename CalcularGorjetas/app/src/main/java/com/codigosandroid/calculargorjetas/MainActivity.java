package com.codigosandroid.calculargorjetas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.codigosandroid.utils.utils.AlertUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText edtTotalConta;
    private RadioGroup radioGroup;

    private double total=0.0;

    private DecimalFormat format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

    }

    // Inicializa os componentes
    private void inicializar() {

        // Formato monetário
        format = new DecimalFormat("#,###.##", new DecimalFormatSymbols(new Locale("pt", "BR")));
        format.setMinimumFractionDigits(2);
        format.setParseBigDecimal(true);
        // EditText
        edtTotalConta = (EditText) findViewById(R.id.edtTotalConta);
        // RadioGroup
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        // Calcula a gorjeta
        /* Se não houver nenhum atributo de Button a ser alterado/utilizado
         * pode-se referenciá-lo diretamente pela id */
        findViewById(R.id.btnCalcular).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rbDez:
                        AlertUtil.alert(MainActivity.this,"Total com acréscimo de 10%", "Total: " + format.format(mostrarTotal()) + "\n" +
                                "10%: " + format.format(calculaPercentual(.1)) + "\n" +
                                "Total + 10%: " + format.format(calculaTotal(10)),
                                0, android.R.drawable.ic_menu_info_details);
                        break;
                    case R.id.rbQuinze:
                        AlertUtil.alert(MainActivity.this,"Total com acréscimo de 15%", "Total: " + format.format(mostrarTotal()) + "\n" +
                                "15%: " + format.format(calculaPercentual(.15)) + "\n" +
                                "Total + 15%: " + format.format(calculaTotal(15)),
                                0, android.R.drawable.ic_menu_info_details);
                        break;
                    case R.id.rbVinte:
                        AlertUtil.alert(MainActivity.this,"Total com acréscimo de 20%", "Total: " + format.format(mostrarTotal()) + "\n" +
                                "20%: " + format.format(calculaPercentual(.20)) + "\n" +
                                "Total + 20%: " + format.format(calculaTotal(20)),
                                0,
                                android.R.drawable.ic_menu_info_details);
                        break;
                    default: total = 0;
                }

            }

        });
    }

    private double calculaTotal(int percentual) {

        double totalGeral = 0;

        switch (percentual) {
            case 10: totalGeral = total + calculaPercentual(.1); break;
            case 15: totalGeral = total + calculaPercentual(.15); break;
            case 20: totalGeral = total + calculaPercentual(.20); break;
        }

        return totalGeral;

    }

    private double calculaPercentual(double percentual) {

        // Calcula o total da conta com a gorjeta
        return (total * percentual);

    }

    private double mostrarTotal() {

        try {

            total = Double.parseDouble(edtTotalConta.getText().toString().replace(",", "."));

        } catch (NumberFormatException e) {

            System.out.println("Erro: " + e.getMessage());
            total = 0.0;

        }

        return total;

    }

}
