package com.feedbacksystem.repository;

import com.feedbacksystem.model.Feedback;
import java.util.List;

public interface FeedbackRepository {
    void salvar(Feedback feedback);
    List<Feedback> listarTodos();
    List<Feedback> buscarPorSentimento(String sentimento);
}