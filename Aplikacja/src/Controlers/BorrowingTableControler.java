package Controlers;

import AddDataForm.AddBorrowingForm;
import View.BorrowingsTable;
import View.BorrowingsTableMenuPanel;
import View.BorrowingsView;
import filters.BorrowingFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mdata.MBooks;
import mdata.MBorrowing;
import mdata.MReaders;

public class BorrowingTableControler {

    private BorrowingsTableMenuPanel panel;
    private BorrowingsTable table;
    private MBorrowing mBorrowing;
    private MBooks books;
    private MReaders readers;
    private AddBorrowingForm form;
    private BorrowingFilter filter;
    private BorrowingsView view;

    public BorrowingTableControler(MainControler controler) {
        
        view = controler.getView().getBorrowingsView();

        books = controler.getBooksControler().getmBooks();
        readers = controler.getReadersControler().getmReaders();
        mBorrowing = new MBorrowing();

        table = view.getTable();
        table.setData(mBorrowing);

        table.updateTable();

        form = new AddBorrowingForm(mBorrowing, books, readers);
        
        filter = view.getFilter();
        
        filter.setData(mBorrowing);
        
        view.getFilter().getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                filter.filterBorrowingBook();
                table.updateTable();
            }
        });

        view.getMenuPanel().getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.show();

            }
        });

        view.getMenuPanel().getReturnButton().addActionListener(new ActionListener() {
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
