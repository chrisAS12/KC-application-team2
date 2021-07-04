package com.example.KCbootcampapplication.dto;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import lombok.Data;

@Data
public class ResultDto {
    private String userAnswer;
    private String correctAnswer;
    private KnowledgeCheck kc;

    private Double calculateResult(){
        double correctAnswerCounter = 0d;
        int questions = kc.getQuestion().size();
        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            correctAnswerCounter++;
        }
        return correctAnswerCounter/questions;
    }

    private void showEndMessage(){
        int correctAnswerCounter = kc.getQuestion().size();
        if (!userAnswer.equalsIgnoreCase(correctAnswer)){
            correctAnswerCounter--;
        }
        System.out.println("You answered correct to " + correctAnswerCounter
        + " questions out of "+ kc.getQuestion().size());
    }
}
