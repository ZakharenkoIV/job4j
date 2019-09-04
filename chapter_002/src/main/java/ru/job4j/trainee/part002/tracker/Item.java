package ru.job4j.trainee.part002.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private Long created;
    private String[] comments;
    //Агрегация классов обёрток
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, Long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getCreated() {
        return this.created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "\n" + "Имя заявки: " + getName() + "\n" + "Описание: " + getDesc() + "\n" + "Коментарии: " + getComments() + "\n";
    }
}