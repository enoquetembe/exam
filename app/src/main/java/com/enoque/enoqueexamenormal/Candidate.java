package com.enoque.enoqueexamenormal;

public class Candidate {
    private String bi, name, adress, examTypeCategory, examType;
    private  int age, contact;

    private  double id;


    public Candidate(String bi, String name, String adress, String examTypeCategory, String examType, int age, int contact) {
        this.bi = bi;
        this.id =  Math.random() * 100;
        this.name = name;
        this.adress = adress;
        this.examTypeCategory = examTypeCategory;
        this.examType = examType;
        this.age = age;
        this.contact = contact;
    }

    public Candidate() {
    }


    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public Double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getExamTypeCategory() {
        return examTypeCategory;
    }

    public void setExamTypeCategory(String examTypeCategory) {
        this.examTypeCategory = examTypeCategory;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }



    @Override
    public String toString() {
        return "Candidate{" +
                "bi='" + bi + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", examTypeCategory='" + examTypeCategory + '\'' +
                ", examType='" + examType + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }
}



