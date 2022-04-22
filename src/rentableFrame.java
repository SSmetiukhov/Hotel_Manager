import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class rentableFrame extends JFrame {
    private Rentable rentable;


    public rentableFrame(Rentable rentable) {
        this.rentable = rentable;
        JPanel jInfoPanel = new JPanel();
        jInfoPanel.setLayout(new BoxLayout(jInfoPanel,BoxLayout.PAGE_AXIS));

        JPanel jActionPanel = new JPanel();
        jActionPanel.setLayout(new FlowLayout());

        JPanel jPeoplePanel = new JPanel();
        jPeoplePanel.setLayout(new BoxLayout(jPeoplePanel,BoxLayout.PAGE_AXIS));

        setLayout(new BorderLayout());


        JLabel jLabelTenant = null;
        JLabel jLabelDateFrom = null;
        JLabel jLabelDateTo = null;
        JLabel jLabelVolume = null;
        try {
            jLabelTenant = new JLabel("Tenant: " + rentable.getTenant().toString());
            jLabelDateFrom = new JLabel("date from: " + rentable.getDateStart());
            jLabelDateTo = new JLabel("date to: " + rentable.getDateTo());
            jLabelVolume = new JLabel("volume: " + rentable.getVolume() + " currently used: " + rentable.getCurrentVolume());
        } catch (NullPointerException e) {
            jLabelTenant = new JLabel("Tenant: Not set");
            jLabelDateFrom = new JLabel("date from: Not set");
            jLabelDateTo = new JLabel("date to: Not set");
            jLabelVolume = new JLabel("volume: " + rentable.getVolume() + " currently used: " + rentable.getCurrentVolume());
        }


        for (Person p: rentable.getPeople()){
            JButton personButton = new JButton(p.getName() +" "+p.getSurname());
            personButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rentable.checkOut(p);
                }
            });
            jPeoplePanel.add(personButton);
        }

        JButton addPersonButton = new JButton("add person button");
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesonInput = JOptionPane.showInputDialog(null,
                        "name_surname_pesel_address",
                        "add person",
                        JOptionPane.PLAIN_MESSAGE);
                String[] personInputSplited = pesonInput.split("_");
                rentable.checkIn(new Person(personInputSplited[0], personInputSplited[1], Integer.parseInt(personInputSplited[2]),
                        personInputSplited[3]));
            }
        });


        jInfoPanel.add(jLabelTenant);
        jInfoPanel.add(jLabelDateFrom);
        jInfoPanel.add(jLabelDateTo);
        jInfoPanel.add(jLabelVolume);


        JLabel jLabelStorage = new JLabel("storing: " + rentable.getDateTo());
        jInfoPanel.add(jLabelStorage);
        Vector<JButton> jItems = new Vector<>();
        for(Item i: rentable.getStorage()){
            JButton itemButton = new JButton(i.getName());
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        rentable.takeOutItem(i); //TODO do not allow to click on button multiple times
                        System.out.println("removed successfully");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });
            jInfoPanel.add(itemButton);
        }

        JButton addNewItemButton = new JButton("Add new Item");
        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new AddNewButtonFrame(rentable);
                    } catch (TooManyThingsException tooManyThingsException) {
                        tooManyThingsException.printStackTrace();
                    }
                });
            }
        });

        JButton renewRentButton = new JButton("renew rent");
        renewRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentable.renewRent();
            }
        });

        JButton cancelRentButton = new JButton("cancel rent");
        cancelRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentable.cancelRent();
            }
        });

        JButton showPeopleButton = new JButton("show people");
        showPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jActionPanel.add(addNewItemButton);
        jActionPanel.add(renewRentButton);
        jActionPanel.add(cancelRentButton);
        jActionPanel.add(addPersonButton);

        add(jInfoPanel, BorderLayout.LINE_START);
        add(jActionPanel, BorderLayout.PAGE_END);
        add(jPeoplePanel, BorderLayout.LINE_END);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }





}
