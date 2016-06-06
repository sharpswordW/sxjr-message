package com.sxjr.app.demo.entity;

import javax.persistence.*;

@Table(name = "tb_demo")
public class TbDemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TbDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}