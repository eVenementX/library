package utils;
import data.*;


public class LibraryUtils {


    public static void printBooks(Library lib)
    {
        printPublications(lib,Book.class);

    }

    public static void printMagazines(Library lib) {

        printPublications(lib,Magazine.class);
    }

    private static void printPublications(Library lib, Class cl)
    {
       long countPublications = lib.getPublications().values().stream()
               .filter(cl::isInstance)
               .sorted(new Library.AlphabeticComparator())
               .peek(System.out::println)
               .count();
       if (countPublications ==0)
       {
           System.out.println("Brak elementów typu " +cl.getSimpleName());

       }

    }
    public static void printUsers(Library lib)
    {
       lib.getUsers().values().stream()
               .sorted((a,b)->a.getLastName().compareTo(b.getLastName()))
               .forEach(System.out::println);

    }
}
