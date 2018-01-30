package com.blogspot.codigosandroid.calculadora.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blogspot.codigosandroid.calculadora.R;
import com.codigosandroid.utils.utils.AlertUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    /* duas variávies do tipo double pra efetuar as operações */
    private double operador1;
    private double operador2;

    /* variável do tipo String que armazena as operações */
    private String operadores;

    /* componente de texto para o visor da calculadora */
    private EditText txt_visor;
    /* String auxiliar para preencher o visor */
    private String aux = null;

    /** É reconmentado utilizar array de objetos ao se trabalhar
     * com muitos componentes(neste caso ao invés de várias instancias
     * da classe Button temos dois arrays, um para o teclado numério e
     * o outro para as operações aritiméticas e demais ações) */
    /* componentes button que para o teclado numérico da calculadora */
    private Button[] btn_numericos = new Button[10];
    /* componentes button para realizar as as quatro operações matemáticas, ponto decimal
     * limpar, igualdade e sair */
    private Button[] btn_operacoes = new Button[8];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        inicializar(view);
        return view;

    }

    /* Inicializa os componentes da tela */

    private void inicializar(View view) {

        txt_visor = (EditText) view.findViewById(R.id.txt_visor);

        btn_numericos[0] = (Button) view.findViewById(R.id.bt_0);
        btn_numericos[1] = (Button) view.findViewById(R.id.bt_1);
        btn_numericos[2] = (Button) view.findViewById(R.id.bt_2);
        btn_numericos[3] = (Button) view.findViewById(R.id.bt_3);
        btn_numericos[4] = (Button) view.findViewById(R.id.bt_4);
        btn_numericos[5] = (Button) view.findViewById(R.id.bt_5);
        btn_numericos[6] = (Button) view.findViewById(R.id.bt_6);
        btn_numericos[7] = (Button) view.findViewById(R.id.bt_7);
        btn_numericos[8] = (Button) view.findViewById(R.id.bt_8);
        btn_numericos[9] = (Button) view.findViewById(R.id.bt_9);

        btn_operacoes[0] = (Button) view.findViewById(R.id.bt_soma);
        btn_operacoes[1] = (Button) view.findViewById(R.id.bt_subt);
        btn_operacoes[2] = (Button) view.findViewById(R.id.bt_multi);
        btn_operacoes[3] = (Button) view.findViewById(R.id.bt_divi);
        btn_operacoes[4] = (Button) view.findViewById(R.id.bt_ponto);
        btn_operacoes[5] = (Button) view.findViewById(R.id.bt_igual);
        btn_operacoes[6] = (Button) view.findViewById(R.id.bt_limpar);
        btn_operacoes[7] = (Button) view.findViewById(R.id.bt_sair);

        listeners();

    }

	/* Trata os eventos dos componentes da tela */
    private void listeners() {

        for (int i = 0; i < 10; i++) {
            btn_numericos[i].setOnClickListener(this);
        }

        for (int i = 0; i < 8; i++) {
            btn_operacoes[i].setOnClickListener(this);
        }

    }

    /* Função para o teclado numérico */
    private void tecladoNumerico(int leNumero) {

        if (txt_visor.getText().toString().trim().equals("0.0")) {

            limparVisor();
            String textvisor = txt_visor.getText().toString();
            String numero = String.valueOf(leNumero);
            aux = textvisor + numero;
            txt_visor.setText(aux);

        } else {

            String textvisor = txt_visor.getText().toString();
            String numero = String.valueOf(leNumero);
            aux = textvisor + numero;
            txt_visor.setText(aux);

        }

    }

    /* Função para inserção do ponto */
    private void ponto(String ponto){

        String textvisor = txt_visor.getText().toString();
        txt_visor.setText(textvisor + ponto);

    }

    /* Função para limpar o visor */
    private void limparVisor() {

        txt_visor.setText("");

    }

    private void operacoes(String operadores) {

        this.operadores = operadores;

        if (operadores == "+") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "-") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "*") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "/") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        }

    }

    private void igual() {

        if(!txt_visor.getText().toString().trim().equals("")){

            if (operadores == "+") {

                operador2 = operador1 + Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "-") {

                operador2 = operador1 - Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "*") {

                operador2 = operador1 * Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "/") {

                if(operador1 == 0){

                    operador2 = 0;

                } else {

                    operador2 = operador1 / Double.parseDouble(txt_visor.getText().toString().trim());

                }

            }

        }else{

            operador2 = 0;

        }

        txt_visor.setText(String.valueOf(operador2));

    }

    /** Haviam alguns erros no método onclick onde as chamadas 'id.bt_x' não estavam
     * sendo reconhecias. Isso acontece, pois o id reference do componente fica armazenado
     * na classe R do projeto e o caminho o pacote dessa classe não estava
     * declarado no topo da classe (import com.blogspot.codigosandroid.calculadora.R),
     * mas também pode ser feito como está abaixo "classe.atributo_identificaror.id_componente" */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_0:

                tecladoNumerico(0);
                break;

            case R.id.bt_1:

                tecladoNumerico(1);
                break;

            case R.id.bt_2:

                tecladoNumerico(2);
                break;

            case R.id.bt_3:

                tecladoNumerico(3);
                break;

            case R.id.bt_4:

                tecladoNumerico(4);
                break;

            case R.id.bt_5:

                tecladoNumerico(5);
                break;

            case R.id.bt_6:

                tecladoNumerico(6);
                break;

            case R.id.bt_7:

                tecladoNumerico(7);
                break;

            case R.id.bt_8:

                tecladoNumerico(8);
                break;

            case R.id.bt_9:

                tecladoNumerico(9);
                break;

            case R.id.bt_limpar:

                limparVisor();
                break;

            case R.id.bt_igual:

                igual();
                break;

            case R.id.bt_ponto:

                ponto(".");
                break;

            case R.id.bt_sair:

                AlertUtil.alert(getActivity(), "Fechar",
                        "Deseja realmente fechar a aplicação:", R.string.sim, new Runnable() {

                            @Override
                            public void run() {

                                getActivity().finish();

                            }

                        });
                break;

            case R.id.bt_soma:

                operacoes("+");
                break;

            case R.id.bt_subt:

                operacoes("-");
                break;

            case R.id.bt_multi:

                operacoes("*");
                break;

            case R.id.bt_divi:

                operacoes("/");
                break;

        }

    }

}
