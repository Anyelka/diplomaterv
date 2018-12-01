package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.PlayerData;

public interface PlayerDao {

    public void updatePlayerData(String username, PlayerData playerData);
}
