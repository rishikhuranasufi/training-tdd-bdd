package com.infy.cucumber.fixture.continent;

public class TeamContinent extends MappableContinent<TeamContinent.TeamId> {

    public static class TeamId {
        String teamName;
        String teamPassword;

        public String getTeamName() {
            return teamName;
        }

        public String getTeamPassword() {
            return teamPassword;
        }

    }

    public TeamId generate(String qualifier, String... extraParam) {

        String generatedId = "Team_" + qualifier.toUpperCase() + "_" + System.currentTimeMillis();
        TeamId teamId = new TeamId();
        teamId.teamName = generatedId;
        teamId.teamPassword = extraParam.length > 0 ? extraParam[0] : null;
        return teamId;
    }
}
