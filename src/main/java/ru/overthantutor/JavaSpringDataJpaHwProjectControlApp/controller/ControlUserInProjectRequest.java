package ru.overthantutor.JavaSpringDataJpaHwProjectControlApp.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Setter
public class ControlUserInProjectRequest {
        private UUID userId;
        private UUID projectId;
}
