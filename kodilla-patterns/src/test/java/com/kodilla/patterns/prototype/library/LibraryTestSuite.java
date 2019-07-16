package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("author" + n, "title" + n, LocalDate.of(n, n, n))));

        Library shallowCopyLibrary = null;
        try {
            shallowCopyLibrary = library.shallowCopy();
            shallowCopyLibrary.setName("shallow library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCopyLibrary = null;
        try {
            deepCopyLibrary = library.deepCopy();
            deepCopyLibrary.setName("deep library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        System.out.println(library.getBooks().size());
        //glupia sytuacja, ale jakbym chcial remove to jak powinienem to zapisac?
        library.getBooks().add(new Book("authorxx", "titlexxx", LocalDate.now()));
        System.out.println(library.getBooks().size());
        //Then
        System.out.println(library);
        System.out.println(shallowCopyLibrary);
        System.out.println(deepCopyLibrary);
        Assert.assertEquals(11, library.getBooks().size());
        Assert.assertEquals(11, shallowCopyLibrary.getBooks().size());
        Assert.assertEquals(10, deepCopyLibrary.getBooks().size());
    }
}
