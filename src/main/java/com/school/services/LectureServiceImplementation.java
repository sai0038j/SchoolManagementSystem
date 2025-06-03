package com.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entities.Lectures;
import com.school.exceptions.ResourceNotFoundException;
import com.school.repository.LectureRepository;

@Service
public class LectureServiceImplementation implements LectureService {

    @Autowired
    LectureRepository lectureRepository;

    @Override
    public Lectures createPost(Lectures lectures) {
        if (lectures.getTitle() == null || lectures.getTitle().isEmpty()) {
            throw new ResourceNotFoundException(false, "Video title cannot be empty or null");
        }

        return lectureRepository.save(lectures);
    }

    @Override
    public Lectures getById(Integer id) {
        Lectures lecture=lectureRepository.findById(id).get();
        return lecture;
    }

    @Override
    public Lectures updatePost(Lectures lectures, Integer id) {
        Lectures lecture=lectureRepository.findById(id).get();
        lecture.setDescription(lectures.getDescription());
        lecture.setTitle(lectures.getTitle());
        Lectures l=lectureRepository.save(lecture);
        return l;
    }

    @Override
    public void deleteVideo(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Lectures> getallPost() {
        // TODO Auto-generated method stub
        return lectureRepository.findAll();
    }

}