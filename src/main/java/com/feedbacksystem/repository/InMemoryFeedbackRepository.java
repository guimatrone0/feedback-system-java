package com.feedbacksystem.repository;

import com.feedbacksystem.model.Feedback;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryFeedbackRepository implements FeedbackRepository {
    private List<Feedback> feedbacks = new ArrayList<>();
    private long nextId = 1;
    
    @Override
    public void salvar(Feedback feedback) {
        feedback.setId(nextId++);
        feedbacks.add(feedback);
    }
    
    @Override
    public List<Feedback> listarTodos() {
        return new ArrayList<>(feedbacks);
    }
    
    @Override
    public List<Feedback> buscarPorSentimento(String sentimento) {
        return feedbacks.stream()
                .filter(f -> f.getSentimento().equalsIgnoreCase(sentimento))
                .collect(Collectors.toList());
    }
}