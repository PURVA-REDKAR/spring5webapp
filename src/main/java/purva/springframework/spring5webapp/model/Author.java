package purva.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    public Author() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId().equals(author.getId()) &&
                Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName()) &&
                Objects.equals(getBook(), author.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @ManyToMany(mappedBy = "authors")
    private Set<Book> book = new HashSet<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", book=" + book +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }


    public Set<Book> getBooks() {
        return book;
    }

    public void setBooks(Set<Book> books) {
        this.book = books;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = books;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
