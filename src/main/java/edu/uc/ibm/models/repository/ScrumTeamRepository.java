package edu.uc.ibm.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.uc.ibm.models.ScrumTeam;

@Repository
public interface ScrumTeamRepository extends MongoRepository<ScrumTeam,String>{

	public ScrumTeam findByScrumTeamId(String scrumTeamId);
	public Long deleteByScrumTeamId(String scrumTeamId);
}
