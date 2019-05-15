package sports.betting.application.domain.user;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private Set<UserRole> roles;
    private Optional<PlayerData> playerData;
    private Integer version;

    public User() {
        this.roles = new HashSet<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
    public Optional<PlayerData> getPlayerData() {
        return playerData;
    }
    public void setPlayerData(Optional<PlayerData> playerData) {
        this.playerData = playerData;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

}
