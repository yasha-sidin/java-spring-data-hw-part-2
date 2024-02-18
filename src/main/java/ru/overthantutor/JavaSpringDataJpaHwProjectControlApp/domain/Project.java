package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity(name = "projects")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;
    @JsonIgnore
    @ManyToMany(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_user",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<User> projectUsers;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = LocalDate.now();
    }
}
