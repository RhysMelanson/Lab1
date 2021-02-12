import PackAWay.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    public BuddyInfo bud;

    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("John", "12 lane", "6131234567");
    }



    @Test
    public void getName() {
        String name = bud.getName();
        assertEquals(name, "John");
    }

    @Test
    public void getAddress() {
        String add = bud.getAddress();
        assertEquals(add, "12 lane");
    }

    @Test
    public void getPhone() {
        String phone = bud.getPhone();
        assertEquals(phone, "6131234567");
    }
    @Test
    public void EntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyBook");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bud);
        em.getTransaction().commit();

        BuddyInfo p = em.find(BuddyInfo.class, "John");

        assertEquals(bud.getPhone(), p.getPhone());
        assertEquals(bud.getAddress(), p.getAddress());
        assertEquals(bud.getName(), p.getName());

        em.close();
        emf.close();
    }

}