package Controlers;

import AddDataForm.AddBookForm;
import View.BooksTableMenuPanel;
import View.BooksTable;
import filters.BookFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mdata.MBooks;

public class BooksTableControler {

    private BooksTableMenuPanel panel;
    private BooksTable table;
    private MBooks mBooks;
    private AddBookForm form;
    
    private BookFilter filter;

    public BooksTableControler(MainControler controler) {

        mBooks = new MBooks();

        table = controler.getView().getBooks();
        table.setData(mBooks);

        table.updateTable();

        form = new AddBookForm(mBooks);
        
        filter = controler.getView().getBookFilter();
        
        filter.setData(mBooks);
        
        controler.getView().getBookFilter().getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                filter.filterBookList();
                table.updateTable();
            }
        });

        controler.getView().getBooksMenu().getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.show();

            }
        });

        controler.getView().getBooksMenu().getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                table.removeBook();
                mBooks.updateBooksList();
                mBooks.updateAvailableBooksList();
                mBooks.updateAuthorsList();
                mBooks.updateBookTypesList();
                table.updateTable();

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
                mBooks.updateBookTypesList();
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
