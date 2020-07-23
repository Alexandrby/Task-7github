package com.senla.repository;
import java.io.IOException;
import java.util.ArrayList;

public interface RepositoryBasis<T,P>  {

    T create (T t) throws IOException;

    T read (P p) throws IOException, ClassNotFoundException;

    T update (T t);

    void delete(P nameGuest );

    ArrayList<T> createAll(P p) ;

    ArrayList<T> readAll () throws IOException;

    void addTestList() ;
}
