package Controlers;

import AddDataForm.AddBookForm;
import View.BooksTableMenuPanel;
import View.BooksTable;
import View.BooksView;
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
    
        private BooksView view;


    public BooksTableControler(MainControler controler) {

        mBooks = new MBooks();

        view = controler.getView().getBooksView();
        
        table = view.getTable();
        table.setData(mBooks);

        table.updateTable();

        form = new AddBookForm(mBooks);
        
        filter = view.getFilter();
        
        filter.setData(mBooks);
        
        view.getFilter().getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                filter.filterBookList();
                table.updateTable();
            }
        });

        view.getMenuPanel().getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form.show();

            }
        });

        view.getMenuPanel().getRemoveButton().addActionListener(new ActionListener() {
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
