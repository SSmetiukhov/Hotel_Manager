import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonFrame extends JFrame {
    private Person person;

    public PersonFrame(Person person) throws HeadlessException {
        this.person = person;
        JPanel rentsPanel = new JPanel();
        rentsPanel.setLayout(new BoxLayout(rentsPanel,BoxLayout.PAGE_AXIS));

        JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new BoxLayout(lettersPanel, BoxLayout.PAGE_AXIS));

        setLayout(new BorderLayout());

        for (Rentable rent : person.getRents()){
            JLabel rentLabel = new JLabel(String.valueOf(rent.getId()));
            rentsPanel.add(rentLabel);
        }

        for (TenantLetter letter : person.getTenantLetters()){
            /*JButton letterButton = new JButton(String.valueOf(letter.getIndx()));
            if (letter.isExpired())
                letterButton.setBackground(Color.RED);
            letterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!letter.isExpired()){
                        int i = 0;
                        while(!(person.getRents().elementAt(i).getId() == letter.getIndx())) {
                            System.out.println("rentId: "  + person.getRents().elementAt(i).getId());
                            System.out.println("letterId: " + letter.getIndx());
                            i++;
                        }
                        person.getRents().elementAt(i).renewRent();
                        person.getTenantLetters().remove(letter);
                    }
                }
            });
            lettersPanel.add(letterButton);*/
            JLabel tenantLetter = new JLabel(String.valueOf(letter.getIndx()));
            if (letter.isExpired())
                tenantLetter.setBackground(Color.RED);
            lettersPanel.add(tenantLetter);
        }
        JButton rentNew = new JButton("rent new");
        rentNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rentsPanel.add(rentNew);

        add(rentsPanel, BorderLayout.LINE_START);
        add(lettersPanel, BorderLayout.LINE_END);

        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
