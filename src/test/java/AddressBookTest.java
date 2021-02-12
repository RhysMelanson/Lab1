import PackAWay.AddressBook;
import PackAWay.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AddressBookTest {

    public BuddyInfo bud;
    public BuddyInfo bud2;

    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("John", "12 lane", "6131234567");
        bud2 = new BuddyInfo("John2", "78 lane", "1112224444");
    }

    @Test
    public void addBuddy() {
        AddressBook book = new AddressBook();
        book.addBuddy("John", "12 lane", "6131234567");


    }

    @Test
    public void removeBuddy() {
        AddressBook book = new AddressBook();
        book.addBuddy("John", "12 lane", "6131234567");
        BuddyInfo bud2 = book.removeBuddy(0);
        assertEquals(bud2.getName(),bud.getName());
        assertEquals(bud2.getAddress(),bud.getAddress());
        assertEquals(bud2.getPhone(),bud.getPhone());
    }

    @Test
    public void testToString() {
        AddressBook book = new AddressBook();
        book.addBuddy("John", "12 lane", "6131234567");
        assertEquals(book.toString(), " Contact: John 12 lane 6131234567");
    }

    @Test
    public void EntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyBook");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(bud);
        em.persist(bud2);

        AddressBook book = new AddressBook("Jims");
        book.addBuddy2(bud);
        book.addBuddy2(bud2);

        em.persist(book);

        em.getTransaction().commit();

        AddressBook p = em.find(AddressBook.class, "Jims");



        em.close();
        emf.close();
    }
}