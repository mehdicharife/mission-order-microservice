package io.github.mehdicharife.missionorderservice.domain;
import java.util.Objects;


public class Professor {

    private Long id;

    private String firstName;

    private String lastName;


    public Professor() {
    }

    public Professor(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Professor id(Long id) {
        setId(id);
        return this;
    }

    public Professor firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Professor lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Professor)) {
            return false;
        }
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(firstName, professor.firstName) && Objects.equals(lastName, professor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
    
    
}
