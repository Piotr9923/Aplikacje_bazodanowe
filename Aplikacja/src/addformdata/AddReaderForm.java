package addformdata;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mdata.MReaders;

public class AddReaderForm {

    private JFrame frame;

    private JLabel firstname, lastname, phoneNumber, bornIn, code, town, street, houseNumber;

    private JTextField firstnameTF, lastnameTF, phoneNumerTF, bornInTF, codeTF, townTF, streetTF, houseNumberTF;

    private JButton save, cancel;

    private MReaders data;

    public AddReaderForm(MReaders data) {

        frame = new JFrame();

        frame.setTitle("Dodaj czytelnika");
        frame.setSize(220, 500);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(null);

        this.data = data;

        createLabels();

        createTextFields();

        createButtons();

    }

    private void createButtons() {

        save = new JButton("Dodaj");
        save.setBounds(125, 425, 85, 30);
        frame.add(save);

        cancel = new JButton("Anuluj");
        cancel.setBounds(10, 425, 85, 30);
        frame.add(cancel);

    }

    public JButton getSave() {
        return save;
    }

    public JButton getCancel() {
        return cancel;
    }

    private void createLabels() {

        firstname = new JLabel("Imię:");
        firstname.setBounds(10, 10, 100, 20);
        frame.add(firstname);

        lastname = new JLabel("Nazwisko:");
        lastname.setBounds(10, 60, 100, 20);
        frame.add(lastname);

        phoneNumber = new JLabel("Numer telefonu:");
        phoneNumber.setBounds(10, 110, 200, 20);
        frame.add(phoneNumber);

        bornIn = new JLabel("Rok urodzenia:");
        bornIn.setBounds(10, 160, 200, 20);
        frame.add(bornIn);

        code = new JLabel("Kod:");
        code.setBounds(10, 210, 70, 20);
        frame.add(code);

        town = new JLabel("Miejscowość:");
        town.setBounds(70, 210, 120, 20);
        frame.add(town);

        street = new JLabel("Ulica:");
        street.setBounds(10, 260, 100, 20);
        frame.add(street);

        houseNumber = new JLabel("Numer domu:");
        houseNumber.setBounds(10, 310, 200, 20);
        frame.add(houseNumber);

    }

    private void createTextFields() {

        firstnameTF = new JTextField();
        firstnameTF.setBounds(10, 30, 200, 20);
        frame.add(firstnameTF);

        lastnameTF = new JTextField();
        lastnameTF.setBounds(10, 80, 200, 20);
        frame.add(lastnameTF);

        phoneNumerTF = new JTextField();
        phoneNumerTF.setBounds(10, 130, 200, 20);
        frame.add(phoneNumerTF);

        bornInTF = new JTextField();
        bornInTF.setBounds(10, 180, 200, 20);
        frame.add(bornInTF);

        codeTF = new JTextField();
        codeTF.setBounds(10, 230, 50, 20);
        frame.add(codeTF);

        townTF = new JTextField();
        townTF.setBounds(70, 230, 140, 20);
        frame.add(townTF);

        streetTF = new JTextField();
        streetTF.setBounds(10, 280, 200, 20);
        frame.add(streetTF);

        houseNumberTF = new JTextField();
        houseNumberTF.setBounds(10, 330, 200, 20);
        frame.add(houseNumberTF);
    }

    public void show() {

        frame.show();

    }

    public void hide() {

        frame.hide();
        clearFields();
    }

    private void clearFields() {

        firstnameTF.setText("");
        lastnameTF.setText("");
        phoneNumerTF.setText("");
        bornInTF.setText("");
        codeTF.setText("");
        townTF.setText("");
        streetTF.setText("");
        houseNumberTF.setText("");

    }

    public void addReader(){
        
       String[]readerData={firstnameTF.getText(), lastnameTF.getText(), phoneNumerTF.getText(), bornInTF.getText(), codeTF.getText(), townTF.getText(), streetTF.getText(), houseNumberTF.getText()};

       data.addNewReader(readerData);
        
    }
}
