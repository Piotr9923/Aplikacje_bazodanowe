package Controlers;

import AddDataForm.AddBookForm;
import View.BooksTableMenuPanel;
import View.BooksTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MBooks;

public class BooksTableControler {

    private BooksTableMenuPanel panel;
    private BooksTable table;
    private MBooks mBooks;
    private AddBookForm form;

    public BooksTableControler(MainControler controler) {

        mBooks = new MBooks();

        table = controler.getView().getBooks();
        table.setData(mBooks);

        table.updateTable();

        form = new AddBookForm(mBooks);

        controler.getView().getBooksMenu().getDodaj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.show();

            }
        });

        controler.getView().getBooksMenu().getUsun().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                

            }
        });

        form.getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.addBook();
                form.hide();
                mBooks.updateBooksList();
                mBooks.updateAvailableBooksList();
                mBooks.updateAuthorsList();
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

    public MBooks getmBooks() {
        return mBooks;
    }
    
    public void updateTable(){
        mBooks.updateBooksList();
        table.updateTable();
    }
    
    

}
