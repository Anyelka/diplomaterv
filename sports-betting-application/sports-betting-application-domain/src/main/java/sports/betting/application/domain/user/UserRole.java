package sports.betting.application.domain.user;

public class UserRole {
    private Long id;
    private String name;

    public UserRole(String name) {
        super();
        this.name = name;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
