package com.example.BookStroreManagement.service;

import com.example.BookStroreManagement.exception.BsmException;
import com.example.BookStroreManagement.model.*;
import com.example.BookStroreManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

//import static java.lang.System.LoggerFinder.service;

@Service
@Transactional
public class BsmServiceImpl implements BsmService {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private WalletRepo walletRepo;
    @Autowired
    private BookInventoryRepository inventoryRepo;
    @Autowired
    private TransactionRepository transactionRepo;


//    public BsmServiceImpl(BookRepository bookRepo){
//        super();
//        this.bookRepo=bookRepo;
//    }
//    public BsmServiceImpl(UserRepository userRepo){
//        super();
//        this.userRepo=userRepo;
//    }

    @Override
    public Book saveBookEntry(Book book) {
        Book newBook =  bookRepo.save(book);
        List<BookInventory> newInventory = new ArrayList<>();
        for(int i=0;i<newBook.getBookQuantity();i++){
            BookInventory newItem= new BookInventory(newBook.getBookId(),newBook.getBookName());
            inventoryRepo.save(newItem);
        }
        return newBook;
    }

    @Override
    public User saveUserEntry(User user) {
        User newUser=userRepo.save(user);
        Wallet wallet = new Wallet(user.getUserId(),0,0);
        walletRepo.save(wallet);
        return newUser;
    }

    @Override
    public User updateUserEntry(User user) {
        Optional<User> usero= this.userRepo.findById(user.getUserId());
        if(usero.isPresent()){
            User userUpdate = usero.get();
            userUpdate.setUsername(user.getUsername());
            userUpdate.setAddress(user.getAddress());
            userUpdate.setEmail(user.getEmail());
            return this.userRepo.save(userUpdate);
        }
        else{
            throw new BsmException("Product didn't found with ID: "+ user.getUsername());
        }
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public void suspendUserByStatus(long userId) {
        Optional<User> usero= this.userRepo.findById(userId);
        if(usero.isPresent()){
            User userUpdate = usero.get();
            userUpdate.setSuspendedStatus(usero.get().isSuspendedStatus());
            this.userRepo.save(userUpdate);
        }
        else{
            throw new BsmException("Product didn't found with ID: "+ userId);
        }
    }

    @Override
    public Book getBookById(long bookId) {
        Optional<Book> book=this.bookRepo.findById(bookId);
        if(book.isPresent()){
            return book.get();
        }
        else{
            throw new BsmException("Book didn't found with ID: "+ bookId);
        }
    }

    @Override
    public void addMoneyToWallet(long userId, long amount) {
        Optional<User> usero= userRepo.findById(userId);
        Optional<Wallet> walletUser = walletRepo.findById(userId);
        if(walletUser.isPresent()) {
            if(amount%500==0) {

                Wallet userWallet= walletUser.get();

                    if(walletUser.isPresent()) {
                        userWallet.setBalance(userWallet.getBalance()+amount);
                        Transaction newTransaction = new Transaction(userId,amount, Timestamp.from(Instant.now()) );
                        transactionRepo.save(newTransaction);

                    }
                    else{
                        throw new BsmException("User didn't found with ID: "+ userId);
                    }

            }
            else{
                throw new BsmException("Amount enter should be in multiple of 500");
            }
        }
        else{
            throw new BsmException("Wallet didn't found with ID: "+ userId);
        }
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        List<Book> list = new ArrayList<>();
        List<Book> allBooks = bookRepo.findAll();
        for(int i=0;i<allBooks.size();i++){
            if(allBooks.get(i).getBookQuantity()!=0){
                list.add(allBooks.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Book> sortedBooksByDate() {
        List<Book> bookItems= bookRepo.findAll();
        bookItems.sort(Comparator.comparing(Book::getCreated_at));
        return bookItems;
    }

    @Override
    public List<Book> sortedBooksByLikes() {
        List<Book> bookItems= bookRepo.findAll();
        bookItems.sort(Comparator.comparing(Book::getBookLikes));
        return bookItems;
    }

    @Override
    public void borrowedBook(long userId, long bookId) {
        Optional<Book> getBook = bookRepo.findById(bookId);
        if (getBook.isPresent()) {
            Optional<User> getUser = userRepo.findById(userId);
            if (getUser.isPresent()) {
                Optional<Wallet> getWallet = walletRepo.findById(userId);
                if (getWallet.isPresent()) {
                    List<Book> list = new ArrayList<>();
                    List<BookInventory> allBooks = inventoryRepo.findAll();
//                    if (allBooks.isPresent()) {
                    BookInventory inventoryBook = new BookInventory();
                    for (int i = 0; i < allBooks.size(); i++) {
                        if (allBooks.get(i).isStatus() && allBooks.get(i).getBookId() == bookId) {
                            inventoryBook = allBooks.get(i);
                            break;
                        }

                    }
//                        Optional<BookInventory> getBookInventory = inventoryRepo.findById(bookId);

//                        if (getBookInventory.isPresent()) {
//                            if (getUser.isPresent()) {
                    User newUser = getUser.get();
                    Wallet newWallet = getWallet.get();

                    Book newItem = getBook.get();
                    BookInventory newBook = inventoryBook;
                    long price = (long) (0.2 * newItem.getBookPrice());
                    if (newWallet.getBooksRented() < 3 && newWallet.getBalance() >= price) {
                        Transaction newTransaction = new Transaction(userId, false, newItem.getBookId(), inventoryBook.getInventoryId());
                        transactionRepo.save(newTransaction);
                        newItem.setBookQuantity(newItem.getBookQuantity() - 1);
                        newWallet.setBooksRented(newWallet.getBooksRented() + 1);
                    } else {
                        throw new BsmException("Book Inventory List is Empty with book id " + bookId);
                    }


//                            } else {
//                                throw new BsmException("User didn't found with ID: " + userId);
//                            }
//                        } else {
//                            throw new BsmException("Book Inventory didn't found with book with ID: " + userId);
//                        }
//                    }
//                    else {
//                        throw new BsmException("BookInventory didn't found with book with ID: " + bookId);
//                    }
//                }
                }
                else {
                    throw new BsmException("Wallet didn't found with ID: " + userId);
                }
            }
            else {
                throw new BsmException("User didn't found with ID: " + userId);
            }
        }
        else {
            throw new BsmException("book didn't found with ID: " + bookId);
        }
    }


//    public List<Book> sortedBooks() {
//        private List<Book> bookItems = null;
//        final int first = 0;
//        if (bookItems == null) {
//            getPagingInfo();
//            bookItems = jpaController.findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
//            Collections.sort(bookItems, new Comparator<Movie>() {
//                public int compare(Movie m1, Movie m2) {
//                    return m1.getDate().compareTo(m2.getDate());
//                }
//            });
//        }
//        return bookItems;
//    }


}
