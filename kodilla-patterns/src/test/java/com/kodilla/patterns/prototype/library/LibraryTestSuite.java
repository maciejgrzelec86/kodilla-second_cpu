package com.kodilla.patterns.prototype.library;

import org.junit.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        Library library = new Library("library");
        IntStream.iterate(1, n -> n +1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("author" + n, "title" + n, LocalDate.of(n,n,n))));
    }
}
