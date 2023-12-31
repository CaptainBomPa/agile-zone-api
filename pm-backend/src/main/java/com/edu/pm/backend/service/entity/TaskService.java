package com.edu.pm.backend.service.entity;

import com.edu.pm.backend.commons.dto.TaskAddDTO;
import com.edu.pm.backend.commons.dto.TaskDTO;
import com.edu.pm.backend.commons.mappers.TaskMapper;
import com.edu.pm.backend.model.Task;
import com.edu.pm.backend.model.UserStory;
import com.edu.pm.backend.repository.TaskRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.edu.pm.backend.commons.mappers.TaskMapper.modelToDTO;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDTO add(TaskAddDTO dto) {
        Task task = Task.builder()
                .taskName(dto.getTaskName())
                .description(dto.getDescription())
                .userStory(UserStory.builder().id(dto.getUserStoryId()).build())
                .build();
        task = taskRepository.save(task);
        return modelToDTO(task);
    }

    public TaskDTO update(TaskAddDTO dto) {
        Task taskFromDB = findById(dto.getId());
        taskFromDB.setTaskName(dto.getTaskName());
        taskFromDB.setDescription(dto.getDescription());
        taskFromDB.setUserStory(UserStory.builder().id(dto.getUserStoryId()).build());
        return modelToDTO(taskRepository.save(taskFromDB));
    }

    public TaskDTO remove(Integer id) {
        Task task = findById(id);
        if (task == null) {
            throw new IllegalArgumentException("Entity not found");
        }
        taskRepository.delete(task);
        return modelToDTO(task);
    }

    @Nullable
    public Task findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Nullable
    public TaskDTO findByIdDTO(Integer id) {
        Task task = findById(id);
        if (task != null) {
            return modelToDTO(task);
        }
        return null;
    }

    public Collection<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(TaskMapper::modelToDTO).toList();
    }
}
