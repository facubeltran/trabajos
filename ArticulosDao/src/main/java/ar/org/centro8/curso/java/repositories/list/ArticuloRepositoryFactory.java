package ar.org.centro8.curso.java.repositories.list;

public class ArticuloRepositoryFactory {
    private static ArticuloRepository ar= new ArticuloRepository();

    public static ArticuloRepository getArticuloRepository() {
        return ar;
    }

}
