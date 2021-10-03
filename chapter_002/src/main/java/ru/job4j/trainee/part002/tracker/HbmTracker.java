package ru.job4j.trainee.part002.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(item);

        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();

        item.setId(id);
        session.update(item);

        session.getTransaction().commit();
        session.close();
        return findById(id).getName().equals(item.getName());
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();

        Item item = new Item();
        item.setId(id);
        session.delete(item);

        session.getTransaction().commit();
        session.close();
        return findById(id) != null;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();

        List result = session.createQuery("from ru.job4j.trainee.part002.tracker.Item").list();

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();

        String queryString = "from Item where name = :value";
        Query query = session.createQuery(queryString);
        query.setParameter("value", key);
        List<Item> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();

        Item item = session.get(Item.class, id);

        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}