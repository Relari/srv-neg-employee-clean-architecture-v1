package com.pe.relari.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum JobTitleCategory {

    SCRUM_MASTER,
    TEAM_LEAD,
    DEVELOPER,
    MANAGER,
    ARCHITECT;

    public static List<String> getJobTitles() {
        return Stream.of(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
