package com.example.juego_gato_2024;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView[] cuadros;
    private boolean turnoJugador1 = true;
    private int[] tablero = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuadros = new TextView[9];
        cuadros[0] = findViewById(R.id.cu1);
        cuadros[1] = findViewById(R.id.cu2);
        cuadros[2] = findViewById(R.id.cu3);
        cuadros[3] = findViewById(R.id.cu4);
        cuadros[4] = findViewById(R.id.cu5);
        cuadros[5] = findViewById(R.id.cu6);
        cuadros[6] = findViewById(R.id.cu7);
        cuadros[7] = findViewById(R.id.cu8);
        cuadros[8] = findViewById(R.id.cu9);

        for (int i = 0; i < cuadros.length; i++) {
            final int finalI = i;
            cuadros[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hacerMovimiento(finalI);
                }
            });
        }
    }

    private void hacerMovimiento(int posicion) {
        if (tablero[posicion] == -1) {

            if (turnoJugador1) {
                cuadros[posicion].setText("X");
                tablero[posicion] = 0;
            } else {
                cuadros[posicion].setText("O");
                tablero[posicion] = 1;
            }

            if (verificarGanador() == 0) {

            } else if (verificarGanador() == 1) {

            } else if (verificarEmpate()) {

            } else {

                turnoJugador1 = !turnoJugador1;
                actualizarTurno();
            }
        }
    }

    private int verificarGanador() {

        for (int i = 0; i < 3; i++) {
            if (tablero[i] != -1 && tablero[i] == tablero[i + 3] && tablero[i] == tablero[i + 6]) {
                return tablero[i];
            }

            int fila = i * 3;
            if (tablero[fila] != -1 && tablero[fila] == tablero[fila + 1] && tablero[fila] == tablero[fila + 2]) {
                return tablero[fila];
            }
        }

        if (tablero[0] != -1 && tablero[0] == tablero[4] && tablero[0] == tablero[8]) {
            return tablero[0];
        }

        if (tablero[2] != -1 && tablero[2] == tablero[4] && tablero[2] == tablero[6]) {
            return tablero[2];
        }

        return -1;
    }

    private boolean verificarEmpate() {

        for (int i : tablero) {
            if (i == -1) {

                return false;
            }
        }
        return true;
    }

    private void actualizarTurno() {
        TextView jugadorEnTurno = findViewById(R.id.jugInTurn);
        jugadorEnTurno.setText(turnoJugador1 ? "Jugador(a) 1" : "Jugador(a) 2");
    }
}
