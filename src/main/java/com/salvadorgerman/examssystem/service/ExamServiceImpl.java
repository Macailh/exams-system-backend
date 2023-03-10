package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService{

    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Set<Exam> getAllExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Exam getExam(Long id) {
        return examRepository.findById(id).get();
    }

    @Override
    public void deleteExam(Long id) {
        Exam exam = new Exam();
        exam.setId(id);
        examRepository.delete(exam);

    }

    @Override
    public List<Exam> getExamnsFromCategory(Category category) {
        return examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> getActiveExams() {
        return examRepository.findByActve(true);
    }

    @Override
    public List<Exam> getActiveExamsFromCategory(Category category) {
        return examRepository.findByCategoryAndActve(category, true);
    }
}
