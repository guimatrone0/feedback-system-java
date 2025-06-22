package com.feedbacksystem.analysis;

import com.feedbacksystem.model.Feedback;

public class SentimentAnalyzer {
    public static final String POSITIVO = "POSITIVO";
    public static final String NEGATIVO = "NEGATIVO";
    public static final String NEUTRO = "NEUTRO";
    
    public String analyzeSentiment(Feedback feedback) {
        if (feedback == null || feedback.getTexto() == null) {
            return NEUTRO;
        }
        
        String texto = feedback.getTexto().toLowerCase();
        boolean positivo = containsPositiveWords(texto);
        boolean negativo = containsNegativeWords(texto);
        
        if (positivo && !negativo) {
            return POSITIVO;
        } else if (negativo && !positivo) {
            return NEGATIVO;
        } else if (positivo && negativo) {
            // Se contém ambos, considera a pontuação
            return feedback.getPontuacao() >= 3 ? POSITIVO : NEGATIVO;
        } else {
            return NEUTRO;
        }
    }
    
    private boolean containsPositiveWords(String texto) {
        String[] positiveWords = {"bom", "ótimo", "excelente", "maravilhoso", 
                                 "gostei", "recomendo", "incrível", "perfeito"};
        return containsAnyWord(texto, positiveWords);
    }
    
    private boolean containsNegativeWords(String texto) {
        String[] negativeWords = {"ruim", "péssimo", "horrível", "odiei", 
                                 "não recomendo", "decepcionante", "terrível"};
        return containsAnyWord(texto, negativeWords);
    }
    
    private boolean containsAnyWord(String texto, String[] words) {
        for (String word : words) {
            if (texto.contains(word)) {
                return true;
            }
        }
        return false;
    }
}