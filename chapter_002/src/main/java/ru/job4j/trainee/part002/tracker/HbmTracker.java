package ru.job4j.trainee.part002.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

        int result = session.createQuery("update Item SET name = :name, description = :description "
                + "where id = :id")
                .setParameter("name", item.getName())
                .setParameter("description", item.getDescription())
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
        return result > 0;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.delete(session.get(Item.class, id));

        session.getTransaction().commit();
        session.close();
        return findById(id) == null;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();

        List result = session.createQuery("from Item").list();

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        Session session = sf.openSession();
        session.beginTransaction();

        List list = session.createQuery("from Item where name = :name")
                .setParameter("name", name).list();

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