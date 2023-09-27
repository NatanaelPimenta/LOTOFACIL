import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LotofacilGUI extends JFrame {
    private JButton buttonApostaNumero;
    private JButton buttonApostaLetra;
    private JButton buttonApostaParImpar;

    public LotofacilGUI() {
        // Configurar a janela principal
        setTitle("LOTOFÁCIL");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botões para fazer as apostas
        buttonApostaNumero = new JButton("Apostar de 0 a 100");
        buttonApostaLetra = new JButton("Apostar de A à Z");
        buttonApostaParImpar = new JButton("Apostar em par ou ímpar");

        // Adicionar os botões à janela
        add(buttonApostaNumero);
        add(buttonApostaLetra);
        add(buttonApostaParImpar);

        // Adicionar ação de clique para os botões
        buttonApostaNumero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroAposta = lerNumeroAposta();
                int numeroSorteado = gerarNumeroSorteado(101); // Gere um número entre 0 e 100
                verificarResultadoNumero(numeroAposta, numeroSorteado);
            }
        });

        buttonApostaLetra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char letraAposta = lerLetraAposta();
                char letraPremiada = gerarLetraSorteada();
                verificarResultadoLetra(letraAposta, letraPremiada);
            }
        });

        buttonApostaParImpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroParImpar = lerNumeroAposta();
                verificarResultadoParImpar(numeroParImpar);
            }
        });
    }

    private int lerNumeroAposta() {
        String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
        return Integer.parseInt(input);
    }

    private char lerLetraAposta() {
        String input = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z:");
        return input.toUpperCase().charAt(0);
    }

    private int gerarNumeroSorteado(int maximo) {
        Random random = new Random();
        return random.nextInt(maximo);
    }

    private char gerarLetraSorteada() {
        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        return letra;
    }

    private void verificarResultadoNumero(int numeroAposta, int numeroSorteado) {
        if (numeroAposta == numeroSorteado) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
        }
    }

    private void verificarResultadoLetra(char letraAposta, char letraPremiada) {
        if (letraAposta == letraPremiada) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada + ".");
        }
    }

    private void verificarResultadoParImpar(int numeroParImpar) {
        if (numeroParImpar % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! Você digitou um número ímpar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LotofacilGUI lotofacil = new LotofacilGUI();
                lotofacil.setVisible(true);
            }
        });
    }
}
