package com.feedbacksystem.service;

import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.analysis.SentimentAnalyzer;
import com.feedbacksystem.repository.FeedbackRepository;

import java.util.List;

public class FeedbackService {
    private FeedbackRepository repository;
    private SentimentAnalyzer analyzer;
    
    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
        this.analyzer = new SentimentAnalyzer();
    }
    
    public void processarFeedback(Feedback feedback) {
        // Análise de sentimento
        String sentimento = analyzer.analyzeSentiment(feedback);
        feedback.setSentimento(sentimento);
        
        // Salvar no repositório
        repository.salvar(feedback);
    }
    
    public List<Feedback> listarFeedbacks() {
        return repository.listarTodos();
    }
    
    public List<Feedback> buscarPorSentimento(String sentimento) {
        return repository.buscarPorSentimento(sentimento);
    }
}