package com.portfolio.back.service;


import com.portfolio.back.dto.SkillResponseDTO;
import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Skill;
import com.portfolio.back.repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository  repository;
    
    @Override
    public List<SkillResponseDTO> list() {
        List<Skill> skills = repository.findAll();
        return this.convertToListResponseDTO(skills);
    }

    @Override
    public SkillResponseDTO create(Skill skill) {
        Skill savedSkill = repository.save(skill);
        return this.convertToResponseDTO(savedSkill);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public SkillResponseDTO getById(UUID id) {
        Skill skill =  repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
        return this.convertToResponseDTO(skill);
    }
        
    
    @Override
    public SkillResponseDTO update(Skill skill) {
	Skill savedSkill = repository.save(skill);
        return this.convertToResponseDTO(savedSkill);
    }
    
    @Override
    public List<SkillResponseDTO> list(UUID personId) {
        List<Skill> skills = repository.findAllByPersonIdOrderByNameAscIdAsc(personId);
        return this.convertToListResponseDTO(skills);
    }
    
    private SkillResponseDTO convertToResponseDTO(Skill skill){
        SkillResponseDTO skillResponseDTO = new
            SkillResponseDTO(
                skill.getId(), 
                skill.getName(),
                skill.getGrade(),
                skill.getPerson().getId(),
                skill.getSkillType().getId(),
                skill.getSkillType()
            );
        return skillResponseDTO;
    }
    
    private List<SkillResponseDTO> convertToListResponseDTO(List<Skill> skills){
        
        List<SkillResponseDTO> skillsResponse = new ArrayList<>(); 
        for(Skill skill: skills){
            SkillResponseDTO skillResponseDTO = this.convertToResponseDTO(skill);
            skillsResponse.add(skillResponseDTO);
        }
        return skillsResponse;
    }
}
