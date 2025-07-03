package com.urnaEletronica.main;

import com.urnaEletronica.view.urna;//importa a interface grafica da urna
import javax.swing.SwingUtilities;//importa o utilitario pra rodar a interface

public class Main {
    public static void main(String[] args) {
        //chamar o swing
        SwingUtilities.invokeLater(() -> {
            new urna().setVisible(true);//abre a tela da urna q é um Jframe, aí mostra na tela e deixa visivel
        });
    }
}
