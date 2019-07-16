package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library implements Cloneable{
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book cloningBooks : books) {
            clonedLibrary.books.add(cloningBooks);
        }
        return clonedLibrary;
    }

    /*public Library deepCopy() throws CloneNotSupportedException {
        Set<Book> clonedSet = new HashSet<>() {
        }
    }*/
}
