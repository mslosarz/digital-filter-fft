package pl.edu.pk.aipsc.digitalfilter.window;

import pl.edu.pk.aipsc.digitalfilter.math.Function;
import pl.edu.pk.aipsc.digitalfilter.math.SumFunction;
import pl.edu.pk.aipsc.digitalfilter.window.event.SignalChangeBus;
import pl.edu.pk.aipsc.digitalfilter.window.event.SignalParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignalOperationPanel extends JPanel {

    private Function f;
    private JTextField textT0;
    private JTextField textT1;
    private JTextField textdt;

    private enum Visible {
        ALL {
            @Override
            public JPanel createSubPanel(JPanel panel) {
                return null;
            }
        },
        FUNCTION_CHOOSER {
            @Override
            public JPanel createSubPanel(JPanel panel) {
                return null;
            }
        };

        public abstract JPanel createSubPanel(JPanel panel);
    }

    /**
     * @wbp.parser.constructor
     */
    public SignalOperationPanel(SignalGraph inputSignalPanel,
                                Function[] functions) {
        this(inputSignalPanel, functions, Visible.ALL);
    }

    /**
     * Create the panel.
     */
    public SignalOperationPanel(SignalGraph inputSignalPanel,
                                Function[] functions, Visible visible) {
        setLayout(new GridLayout(0, 1, 0, 0));

        final JTextPane buildFunction = new JTextPane();
        add(buildFunction);

        JPanel functionBuilderPanel = new JPanel();
        add(functionBuilderPanel);
        functionBuilderPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel functionChooser = new JPanel();
        functionBuilderPanel.add(functionChooser);
        functionChooser.setLayout(new GridLayout(0, 2, 0, 0));

        final JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(functions));
        functionChooser.add(comboBox);

        JButton btnDodajFunkcj = new JButton("Dodaj funkcję");
        btnDodajFunkcj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Function selectedItem = (Function) comboBox.getSelectedItem();
                if (f == null) {
                    f = selectedItem;
                } else {
                    f = SumFunction.sum(f, selectedItem);
                }
                buildFunction.setText(f.toString());
                SignalChangeBus.getInstance().post(f);
            }
        });
        functionChooser.add(btnDodajFunkcj);

        JLabel label_2 = new JLabel("");
        functionChooser.add(label_2);

        JButton btnClearFunction = new JButton("Wyczyść funkcję");
        btnClearFunction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                f = null;
                buildFunction.setText(""); // StringUtils.EMPTY
            }
        });
        functionChooser.add(btnClearFunction);
        JPanel rangeChooser = new JPanel();
//		rangeChooser = visible.createSubPanel(rangeChooser);
        functionBuilderPanel.add(rangeChooser);
        rangeChooser.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel labelT0 = new JLabel("T0");
        rangeChooser.add(labelT0);

        textT0 = new JTextField();
        textT0.setText("0");
        textT0.setColumns(10);
        rangeChooser.add(textT0);

        JLabel labelT1 = new JLabel("T1");
        rangeChooser.add(labelT1);

        textT1 = new JTextField();
        textT1.setText("1.573");
        textT1.setColumns(10);
        rangeChooser.add(textT1);

        JLabel labeldt = new JLabel("dt");
        rangeChooser.add(labeldt);

        textdt = new JTextField();
        textdt.setText("0.01");
        textdt.setColumns(10);
        rangeChooser.add(textdt);

        JLabel label = new JLabel("");
        rangeChooser.add(label);

        JButton buttonChange = new JButton("Wyświetl funkcję");
        buttonChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                SignalChangeBus.getInstance().post(
                        SignalParameters.create(textT0.getText(),
                                textT1.getText(), textdt.getText()));
            }
        });
        rangeChooser.add(buttonChange);

    }

}
