package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;

public interface PlayerDao {

    public void updatePlayerData(String username, PlayerData playerData);

    public User getById(Integer id);

}
