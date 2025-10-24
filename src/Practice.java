
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
public class Practice{

    public static void main(String[] args){

        final Book book1 = new Book("book1");
        final Book book2 = new Book("book2");

        Thread person1 = new Thread(()->{


            System.out.println("person1 enters ");

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}

            System.out.println("person1 tries to access book1");

            synchronized(book1){
                System.out.println("person1 locked book1");
                book2.getBookName();

                System.out.println("person 1 tries to get book2 name");
                try{
                Thread.sleep(5000);}catch(InterruptedException e){}
//                System.out.println("person1 tries to access book2");
            }


        });

        Thread person2 = new Thread(()->{


            System.out.println("person2 enters ");

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}

            System.out.println("person2 tries to access book2");

            synchronized(book2){
                System.out.println("person2 locked book2");
                book1.getBookName();

                System.out.println("person 2 tries to get book 1 name");
                try {
                    Thread.sleep(5000);
                }catch(InterruptedException e){}

            }


        });


        person1.start(); person2.start();
    }
}