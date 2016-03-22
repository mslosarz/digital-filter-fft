package pl.edu.pk.aipsc.digitalfilter;

import pl.edu.pk.aipsc.digitalfilter.math.Functions;
import pl.edu.pk.aipsc.digitalfilter.math.Noises;
import pl.edu.pk.aipsc.digitalfilter.window.SignalGraph;
import pl.edu.pk.aipsc.digitalfilter.window.SignalOperationPanel;
import pl.edu.pk.aipsc.digitalfilter.window.event.SignalChangeBus;

import javax.swing.*;
import java.awt.*;

public class Main {

    private JFrame digitalFilter;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.digitalFilter.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        digitalFilter = new JFrame();
        digitalFilter.setTitle("Filtr Cyfrowy");
        digitalFilter.setBounds(100, 100, 800, 600);
        digitalFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        digitalFilter.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        digitalFilter.getContentPane().add(tabbedPane);

        JPanel inputSignal = new JPanel();
        tabbedPane.addTab("Sygał wejściowy", null, inputSignal, null);
        inputSignal.setLayout(new GridLayout(0, 3, 0, 0));

        SignalGraph signalGraph = new SignalGraph();
        inputSignal.add(signalGraph);

        SignalGraph noiseGraph = new SignalGraph();
        inputSignal.add(noiseGraph);

        SignalGraph resultGraph = new SignalGraph();
        inputSignal.add(resultGraph);

        SignalOperationPanel inputSignalOperation = new SignalOperationPanel(signalGraph, Functions.values());
        inputSignal.add(inputSignalOperation);
        tabbedPane.setEnabledAt(0, true);

        SignalChangeBus.getInstance().setInputSignalGraph(signalGraph);
        SignalChangeBus.getInstance().setNoiseSignalPanel(noiseGraph);

        SignalOperationPanel noiseSignalOperation = new SignalOperationPanel(noiseGraph, Noises.values());
        inputSignal.add(noiseSignalOperation);

        JPanel characteristics = new JPanel();
        tabbedPane.addTab("Charakterystyki", null, characteristics, null);

    }
}
