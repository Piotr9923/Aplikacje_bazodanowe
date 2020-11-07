package Controlers;

import AddDataForm.AddBorrowingForm;
import View.BorrowingsTable;
import View.BorrowingsTableMenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MBooks;
import models.MBorrowing;
import models.MReaders;

public class BorrowingsTableControler {

    private BorrowingsTableMenuPanel panel;
    private BorrowingsTable table;
    private MBorrowing mBorrowing;
    private MBooks books;
    private MReaders readers;
    private AddBorrowingForm form;

    public BorrowingsTableControler(MainControler controler) {

        books = controler.getBooksControler().getmBooks();
        readers = controler.getReadersControler().getmReaders();
        mBorrowing = new MBorrowing();

        table = controler.getView().getBorrowings();
        table.setData(mBorrowing);

        table.updateTable();

        form = new AddBorrowingForm(mBorrowing, books, readers);

        controler.getView().getBorrowingsMenu().getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.show();

            }
        });

        controler.getView().getBorrowingsMenu().getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                table.returnBook();
                mBorrowing.updateBorrowingList();
                table.updateTable();
            }
        });

        form.getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.addBorrowing();
                form.hide();
                mBorrowing.updateBorrowingList();
                books.updateAvailableBooksList();
                table.updateTable();

            }
        });

        form.getCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.hide();

            }
        });

    }

    public void updateTable() {
        mBorrowing.updateBorrowingList();
        table.updateTable();
    }

}
