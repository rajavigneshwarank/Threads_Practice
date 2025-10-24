package DeadLock;
import java.util.*;

 class Book{
    private String book_name;

    public Book(String name){
        this.book_name = name;
    }
    public String getBookName(){
        return this.book_name;
    }
}
public class DeadLockBook {

     public static void main(String[] args){

         final Book book1 = new Book("book1");
         final Book book2 = new Book("book2");

         Thread person1 = new Thread(()->{

             synchronized(book1){
                 System.out.println("person1 locked book1 ");

                 try{
                     Thread.sleep(2000);
                 }catch(InterruptedException e){}

                 System.out.println("person1 tries to access book2");
                 synchronized(book2){
                     System.out.println("person2 locked book2");
                 }
             }
         });

         Thread person2 = new Thread(()->{

             synchronized(book2){
                 System.out.println("person2 locked book2 ");

                 try{
                     Thread.sleep(2000);
                 }catch(InterruptedException e){}

                 System.out.println("person2 tries to access book1");
                 synchronized(book1){
                     System.out.println("person2 locked book1");
                 }
             }
         });

         person1.start(); person2.start();
     }
}
