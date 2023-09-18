package com.example.jokenpo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private ImageView jogador1EscolhaImagem;
    private ImageView jogador2EscolhaImagem;
    private TextView resultadoTextView;
    private boolean jogoJogado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        jogador1EscolhaImagem = findViewById(R.id.jogador1EscolhaImagem);
        jogador2EscolhaImagem = findViewById(R.id.jogador2EscolhaImagem);
        resultadoTextView = findViewById(R.id.resultadoTextView);
    }

    public void pedra(View view) {

        if (!jogoJogado) {
            jogador1EscolhaImagem.setImageResource(R.drawable.pedra);
            jogador1EscolhaImagem.setVisibility(View.VISIBLE);

            View linhaPartida = findViewById(R.id.linhaPartida);
            linhaPartida.setVisibility(View.VISIBLE);

            ImageView ximagem = findViewById(R.id.ximagem);
            ximagem.setVisibility(View.VISIBLE);

            int escolhaJogador2 = gerarEscolhaComputador();
            jogador2EscolhaImagem.setImageResource(escolhaParaImagem(escolhaJogador2));
            jogador2EscolhaImagem.setVisibility(View.VISIBLE);

            int resultado = calcularResultado(0, escolhaJogador2);
            exibirResultado(resultado);
            resultadoTextView.setVisibility(View.VISIBLE);

            Button novoJogo = findViewById(R.id.novoJogo);
            novoJogo.setVisibility(View.VISIBLE);
            jogoJogado = true;
        }

    }


    public void papel(View view) {

        if (!jogoJogado) {
            jogador1EscolhaImagem.setImageResource(R.drawable.papel);
            jogador1EscolhaImagem.setVisibility(View.VISIBLE);

            ImageView ximagem = findViewById(R.id.ximagem);
            ximagem.setVisibility(View.VISIBLE);

            View linhaPartida = findViewById(R.id.linhaPartida);
            linhaPartida.setVisibility(View.VISIBLE);

            int escolhaJogador2 = gerarEscolhaComputador();
            jogador2EscolhaImagem.setImageResource(escolhaParaImagem(escolhaJogador2));
            jogador2EscolhaImagem.setVisibility(View.VISIBLE);

            int resultado = calcularResultado(1, escolhaJogador2);
            exibirResultado(resultado);
            resultadoTextView.setVisibility(View.VISIBLE);

            Button novoJogo = findViewById(R.id.novoJogo);
            novoJogo.setVisibility(View.VISIBLE);
            jogoJogado = true;
        }
    }

    public void tesoura(View view) {
        if (!jogoJogado) {
            jogador1EscolhaImagem.setImageResource(R.drawable.tesoura);
            jogador1EscolhaImagem.setVisibility(View.VISIBLE);

            ImageView ximagem = findViewById(R.id.ximagem);
            ximagem.setVisibility(View.VISIBLE);

            View linhaPartida = findViewById(R.id.linhaPartida);
            linhaPartida.setVisibility(View.VISIBLE);

            int escolhaJogador2 = gerarEscolhaComputador();
            jogador2EscolhaImagem.setImageResource(escolhaParaImagem(escolhaJogador2));
            jogador2EscolhaImagem.setVisibility(View.VISIBLE);

            int resultado = calcularResultado(2, escolhaJogador2);
            exibirResultado(resultado);
            resultadoTextView.setVisibility(View.VISIBLE);

            Button novoJogo = findViewById(R.id.novoJogo);
            novoJogo.setVisibility(View.VISIBLE);
            jogoJogado = true;
        }
    }

    public void novoJogo(View view) {
        jogoJogado = false;
        jogador1EscolhaImagem.setVisibility(View.GONE);

        ImageView ximagem = findViewById(R.id.ximagem);
        ximagem.setVisibility(View.GONE);

        View linhaPartida = findViewById(R.id.linhaPartida);
        linhaPartida.setVisibility(View.GONE);

        jogador2EscolhaImagem.setVisibility(View.GONE);

        Button novoJogo = findViewById(R.id.novoJogo);
        novoJogo.setVisibility(View.GONE);

        resultadoTextView.setVisibility(View.GONE);
    }

    private int gerarEscolhaComputador() {
        return (new Random()).nextInt(3);
    }

    private int calcularResultado(int escolhaJogador1, int escolhaJogador2) {
        if (escolhaJogador1 == escolhaJogador2) {
            return 0;
        } else if ((escolhaJogador1 == 0 && escolhaJogador2 == 2) ||
                (escolhaJogador1 == 1 && escolhaJogador2 == 0) ||
                (escolhaJogador1 == 2 && escolhaJogador2 == 1)) {
            return 1;
        } else {
            return -1;
        }
    }


    private int escolhaParaImagem(int escolha) {
        switch (escolha) {
            case 0:
                return R.drawable.pedra;
            case 1:
                return R.drawable.papel;
            case 2:
                return R.drawable.tesoura;
            default:
                return 0;
        }
    }

    private void exibirResultado(int resultado) {
        if (resultado == 0) {
            resultadoTextView.setText("Empate!");
        } else if (resultado == 1) {
            resultadoTextView.setText("Você venceu!");
        } else {
            resultadoTextView.setText("Máquina venceu!");
        }
    }
}
