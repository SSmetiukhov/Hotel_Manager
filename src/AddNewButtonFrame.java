import javax.swing.*;
import java.util.Vector;

public  class AddNewButtonFrame {
    private Rentable rentable;


    public AddNewButtonFrame(Rentable rentable) throws TooManyThingsException {

        String[] tab = {"Item","Amphibious", "Boat", "CityCar", "Motorcycle", "OffRoadCar"};
        String s = (String) JOptionPane.showInputDialog(null,
                "Add new Item",
                "Select a type of item",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tab,
                tab[0]);

        switch (s) {
            case "Item" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "VOLUME_NAME or LENGTH_WIDTH_HEIGHT_NAME",
                        "Add new Item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 2)
                    rentable.addItem( new Item(Double.parseDouble(userInputSplited[0]), userInputSplited[1]));
                else
                    rentable.addItem( new Item(Double.parseDouble(userInputSplited[0]),
                            Double.parseDouble(userInputSplited[1]), Double.parseDouble(userInputSplited[2]), userInputSplited[3]));
            }
            case "Amphibious" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "volume_name_enginePower_onGroundSpeed_onWaterSpeed or length_width_height_name_enginePower_onGroundSpeed_onWaterSpeed",
                        "Add new Item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 5)
                    rentable.addItem( new Amphibious(Double.parseDouble(userInputSplited[0]),userInputSplited[1],
                            Double.parseDouble(userInputSplited[2]), Double.parseDouble(userInputSplited[3]),
                            Double.parseDouble(userInputSplited[4])));
                else
                    rentable.addItem( new Amphibious(Double.parseDouble(userInputSplited[0]),Double.parseDouble(userInputSplited[1]),
                            Double.parseDouble(userInputSplited[2]),userInputSplited[3],
                            Double.parseDouble(userInputSplited[4]), Double.parseDouble(userInputSplited[5]),
                            Double.parseDouble(userInputSplited[6])));
            }
            case "Boat" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "volume_name_enginePower_displacement or length_width_height_name_enginePower_displacement",
                        "Add new Item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 4)
                    rentable.addItem(new Boat(Double.parseDouble(userInputSplited[0]),userInputSplited[1],
                            Double.parseDouble(userInputSplited[2]), Double.parseDouble(userInputSplited[3])));
                else
                    rentable.addItem(new Boat(Double.parseDouble(userInputSplited[0]),Double.parseDouble(userInputSplited[1]),
                            Double.parseDouble(userInputSplited[2]),userInputSplited[3],
                            Double.parseDouble(userInputSplited[4]), Double.parseDouble(userInputSplited[5])));
            }
            case "CityCar" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "volume_name_enginePower_emissionStandart or length_width_height_name_enginePower_emissionStandart",
                        "Add new Item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 4)
                    rentable.addItem(new CityCar(Double.parseDouble(userInputSplited[0]),userInputSplited[1],
                            Double.parseDouble(userInputSplited[2]), CityCar.EmissionStandart.valueOf(userInputSplited[3])));
                else
                    rentable.addItem( new CityCar(Double.parseDouble(userInputSplited[0]),Double.parseDouble(userInputSplited[1]),
                            Double.parseDouble(userInputSplited[2]),userInputSplited[3],
                            Double.parseDouble(userInputSplited[4]), CityCar.EmissionStandart.valueOf(userInputSplited[3])));
            }
            case "Motorcycle" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "volume_name_enginePower_transmission or length_width_height_name_enginePower_transmission",
                        "add new item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 4)
                    rentable.addItem(new Motorcylce(Double.parseDouble(userInputSplited[0]),userInputSplited[1],
                            Double.parseDouble(userInputSplited[2]), Motorcylce.Transmission.valueOf(userInputSplited[3])));
                else
                    rentable.addItem( new Motorcylce(Double.parseDouble(userInputSplited[0]),Double.parseDouble(userInputSplited[1]),
                            Double.parseDouble(userInputSplited[2]),userInputSplited[3],
                            Double.parseDouble(userInputSplited[4]), Motorcylce.Transmission.valueOf(userInputSplited[3])));
            }
            case "OffRoadCar" -> {
                String userInput = JOptionPane.showInputDialog(null,
                        "volume_name_enginePower_amountOfWheels or length_width_height_name_enginePower_amountOfWheels",
                        "add new item",
                        JOptionPane.PLAIN_MESSAGE);
                String[] userInputSplited = userInput.split("_");
                if(userInputSplited.length == 4)
                    rentable.addItem( new offRoadCar(Double.parseDouble(userInputSplited[0]),userInputSplited[1],
                            Double.parseDouble(userInputSplited[2]), Integer.parseInt(userInputSplited[3])));
                else
                    rentable.addItem( new offRoadCar(Double.parseDouble(userInputSplited[0]),Double.parseDouble(userInputSplited[1]),
                            Double.parseDouble(userInputSplited[2]),userInputSplited[3],
                            Double.parseDouble(userInputSplited[4]), Integer.parseInt(userInputSplited[3])));
            }
        }
    }
}
