package org.example;

//package com.example;

import org.example.entity.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        // Insert student
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student s1 = new Student("Niharika");
        session.persist(s1);
        session.getTransaction().commit();
        session.close();
        System.out.println("Student saved successfully!");

        // Fetch student
        Session readSession = HibernateUtil.getSessionFactory().openSession();
        Student retrieved = readSession.get(Student.class, s1.getId());
        System.out.println("Fetched Student: " + retrieved.getId() + " - " + retrieved.getName());
        readSession.close();
    }
}