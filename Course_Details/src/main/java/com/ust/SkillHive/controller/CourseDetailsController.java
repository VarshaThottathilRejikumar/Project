package com.ust.SkillHive.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.SkillHive.model.CourseDetails;
import com.ust.SkillHive.service.CourseDetailsService;

@RestController
@RequestMapping("/coursedetails/Instructor")
public class CourseDetailsController {

	@Autowired
	private CourseDetailsService cds;
	
	@PostMapping
	public ResponseEntity<CourseDetails> createCourseDetails(@RequestBody CourseDetails courseDetails){
		CourseDetails createdcourse = cds.createCourseDetails(courseDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdcourse);
	}
	
	@GetMapping("/{topicId}/{topicName}")
	public ResponseEntity<String> getCourseTopic(@PathVariable("topicId") Long topicId, @PathVariable("topicName") String topicName){
		CourseDetails topics=cds.getCourseTopic(topicId);
		if(topics.getTopicName()==null)
		{
			return ResponseEntity.ok("Topic not found with Id " + topicId);
//			throw new CourseNotFoundException("Topic not found with Id " + topicId);
			
		}
		return ResponseEntity.ok(topics.getTopicName());
	}
	
	@GetMapping("/{topicId}")
	public ResponseEntity<CourseDetails> getCourseTopicId(@PathVariable Long topicId){
		CourseDetails topic=cds.getCourseTopicId(topicId);
		return ResponseEntity.ok(topic);
	}
	
	@GetMapping()
	public List<CourseDetails> getAllId(){
		return cds.getAll();
	}
	
	@PutMapping("/{topicId}")
	public ResponseEntity<CourseDetails> update(@RequestBody CourseDetails courseDetails, @PathVariable("topicId") Long id){
		CourseDetails updatedTopic=cds.update(courseDetails, id);
		return ResponseEntity.ok(updatedTopic);
		
	}
	
	@DeleteMapping("/{topicId}")
	public ResponseEntity<CourseDetails> deleteTopic(@PathVariable("topicId") Long id){
		CourseDetails del=cds.deleteCourseDetails(id);
		return ResponseEntity.ok(del);
		
	}
}