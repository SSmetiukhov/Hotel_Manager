import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class EstateFrame extends JFrame {
    private Estate estate;
    private ArrayList<Person> people;

    public EstateFrame(Estate estate, ArrayList<Person> people) throws HeadlessException {
        this.estate = estate;
        Vector<JButton> rentableButtons = new Vector<>();
        JPanel rentablePanel = new JPanel();
        rentablePanel.setLayout(new BoxLayout(rentablePanel, BoxLayout.PAGE_AXIS));
        JPanel peoplePanel = new JPanel();
        peoplePanel.setLayout(new BoxLayout(peoplePanel, BoxLayout.PAGE_AXIS));
        setLayout(new BorderLayout());

        for (Rentable r : estate.getRentablevector()){
            JButton button = new JButton(String.valueOf(r.getId()));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(() -> new rentableFrame(r));
                }
            });
            rentableButtons.add(button);
            rentablePanel.add(button);
        }

        for (Person p: people){
            JButton button = new JButton(p.getName() + " "+ p.getSurname());

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(() -> new PersonFrame(p));
                }
            });
            peoplePanel.add(button);
        }
        JButton report = new JButton("report");
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estate.createReport();
            }
        });

        add(rentablePanel, BorderLayout.LINE_START);
        add(peoplePanel, BorderLayout.LINE_END);
        add(report, BorderLayout.PAGE_END);


        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
