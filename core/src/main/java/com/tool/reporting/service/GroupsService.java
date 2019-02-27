package com.tool.reporting.service;

import com.tool.reporting.entity.Groups;
import com.tool.reporting.repository.GroupsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupsService {
    private GroupsRepository groupRepository;

    @Autowired
    public GroupsService(GroupsRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Groups> getAllGroups() {
        log.info("GroupsService: getAllGroups(): method called");
        return groupRepository.findAll();
    }
}
