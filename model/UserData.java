package model;

import java.time.LocalDate;

public class UserData {
    /* Struct de dados. Não define comportamento, então todos os campos são públicos */
    private String name, address, contact, email, document;
    private LocalDate birthdate;
    private int matricula = -1; // sinaliza que o programa ainda não atribuiu matrícula a esse objeto

    public UserData(String name, String address, String contact, String email, String document, LocalDate birthdate) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.document = document;
        this.birthdate = birthdate;
    }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public LocalDate getBirthdate() { return birthdate; }
    public String getContact() { return contact; }
    public String getDocument() { return document; }
    public String getEmail() { return email; }
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    
}